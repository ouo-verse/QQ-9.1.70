package com.qzone.preview.service;

import NS_MOBILE_PHOTO.MarkFaceItemFeed;
import NS_MOBILE_PHOTO.MarkFaceItemMood;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import com.qzone.album.business.search.SearchFilterComposition;
import com.qzone.app.ImageEnvImpl;
import com.qzone.app.ImageLogger;
import com.qzone.app.j;
import com.qzone.common.activities.base.ak;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.preview.business.BasePicureViewController;
import com.qzone.preview.business.d;
import com.qzone.preview.business.e;
import com.qzone.preview.business.f;
import com.qzone.preview.business.g;
import com.qzone.preview.business.h;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.YTFace.model.FaceTarget;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.remote.Callback;
import cooperation.qzone.remote.IActionListener;
import cooperation.qzone.remote.RecvMsg;
import cooperation.qzone.remote.RemoteServiceProxy;
import cooperation.qzone.remote.SendMsg;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import so.b;

/* loaded from: classes39.dex */
public class PictureManager {
    static final String TAG = "[PhotoAlbum]PictureManager";
    public static String downloadReportKey = null;
    public static boolean needDownloadReport = false;
    private static volatile PictureManager sInstance;
    private boolean hasNet;
    private ServiceCmdDispatcher mCmdDispatcher;
    private o8.a mRemoteCall;
    private o8.c mRpcInvocationHandler;
    private RequestSender mSender;
    private RemoteServiceProxy serviceProxy;
    protected static final Object lock = new Object();
    private static Object serviceLock = new Object();
    private AtomicInteger mReqestId = new AtomicInteger(1);
    private HashMap<Integer, SoftReference<Handler>> mRequestHandlerMap = new HashMap<>();
    private IActionListener mActionListener = new a();
    NetworkState.NetworkStateListener netStateListener = new b();

    /* loaded from: classes39.dex */
    class a extends IActionListener.Stub {
        a() {
        }

        @Override // cooperation.qzone.remote.IActionListener
        public void onRecvFromMsg(RecvMsg recvMsg) throws RemoteException {
            if (!TextUtils.isEmpty(recvMsg.tmpFileName)) {
                PictureManager.this.loadLargeResultFromDisk(recvMsg);
            }
            int requestId = recvMsg.getRequestId();
            SoftReference softReference = PictureManager.this.mRequestHandlerMap != null ? (SoftReference) PictureManager.this.mRequestHandlerMap.remove(Integer.valueOf(requestId)) : null;
            String serviceCmd = recvMsg.getServiceCmd();
            if (serviceCmd != null && !PictureConst.CMD_NULL.equals(serviceCmd)) {
                if (softReference == null || softReference.get() == null) {
                    return;
                }
                PictureManager.this.getCmdDippatcher().dispatchCmd(serviceCmd, recvMsg, (Handler) softReference.get());
                return;
            }
            PictureManager.this.mRpcInvocationHandler.d(requestId, recvMsg.extraData);
        }
    }

    /* loaded from: classes39.dex */
    class b implements NetworkState.NetworkStateListener {
        b() {
        }

        @Override // cooperation.qzone.util.NetworkState.NetworkStateListener
        public void onNetworkConnect(boolean z16) {
            PictureManager.this.hasNet = z16;
        }
    }

    /* loaded from: classes39.dex */
    class c extends Handler {
        c() {
        }
    }

    public PictureManager() {
        ImageManagerEnv.init(BaseApplication.getContext(), new ImageEnvImpl(), new ImageLogger());
        com.qzone.misc.network.downloader.b.f48396g = false;
        setNetStateCallback();
        if (!km.a.f412646a.a()) {
            registerExitProcessListener();
        }
        initProxy();
        getRemoteServiceProxy();
        if (j.b()) {
            return;
        }
        j.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ServiceCmdDispatcher getCmdDippatcher() {
        if (this.mCmdDispatcher == null) {
            ServiceCmdDispatcher serviceCmdDispatcher = new ServiceCmdDispatcher();
            this.mCmdDispatcher = serviceCmdDispatcher;
            serviceCmdDispatcher.loadMethods(new RequestReceiver(), RequestReceiver.class);
        }
        return this.mCmdDispatcher;
    }

    public static PictureManager getInstance() {
        if (sInstance == null) {
            synchronized (lock) {
                if (sInstance == null) {
                    sInstance = new PictureManager();
                }
            }
        }
        return sInstance;
    }

    private RemoteServiceProxy getRemoteServiceProxy() {
        RemoteServiceProxy remoteServiceProxy = this.serviceProxy;
        if (remoteServiceProxy != null) {
            return remoteServiceProxy;
        }
        synchronized (serviceLock) {
            if (this.serviceProxy == null) {
                this.serviceProxy = new RemoteServiceProxy("com.qzone.preview.service.PictureService");
            }
        }
        return this.serviceProxy;
    }

    private void registerExitProcessListener() {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.preview.service.PictureManager.1
            @Override // java.lang.Runnable
            public void run() {
                so.b.d().h(BaseApplication.getContext().getPackageName() + ":picture", new b.InterfaceC11240b() { // from class: com.qzone.preview.service.PictureManager.1.1
                    @Override // so.b.InterfaceC11240b
                    public void onExit() {
                        PictureManager.this.destroy();
                        BaseApplication.getContext().stopService(ak.z(BaseApplication.getContext()));
                        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).postDelayed(new Runnable() { // from class: com.qzone.preview.service.PictureManager.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                km.a aVar = km.a.f412646a;
                                if (aVar.a()) {
                                    return;
                                }
                                aVar.d();
                            }
                        }, 900L);
                    }
                });
            }
        });
    }

    public static void removeSelectPic(String str) {
        getInstance().getSender().delLocalPhoto(new c(), str);
    }

    public boolean checkNetworkConnect() {
        return this.hasNet;
    }

    public void cloudBatchFaceRecognize(Handler handler, ArrayList<float[]> arrayList, FaceTarget faceTarget, String str) {
        getSender().cloudBatchFaceRecognize(handler, arrayList, faceTarget, str);
    }

    public void destroy() {
        ServiceCmdDispatcher serviceCmdDispatcher = this.mCmdDispatcher;
        if (serviceCmdDispatcher != null) {
            serviceCmdDispatcher.destroy();
            this.mCmdDispatcher = null;
        }
        HashMap<Integer, SoftReference<Handler>> hashMap = this.mRequestHandlerMap;
        if (hashMap != null) {
            hashMap.clear();
            this.mRequestHandlerMap = null;
        }
        o8.c cVar = this.mRpcInvocationHandler;
        if (cVar != null) {
            cVar.c();
        }
        RemoteServiceProxy remoteServiceProxy = this.serviceProxy;
        if (remoteServiceProxy != null) {
            remoteServiceProxy.unbindBaseService();
        }
    }

    public void downloadVideo(String str, Handler handler) {
        getSender().downloadVideo(str, handler);
    }

    public void faceOperation(Handler handler, MarkFaceItemMood markFaceItemMood, MarkFaceItemFeed markFaceItemFeed, long j3, int i3) {
        getSender().faceOperation(handler, markFaceItemMood, markFaceItemFeed, j3, i3);
    }

    public void getCacheCategoryPhotoList(long j3, int i3, String str, int i16, int i17, Callback callback) {
        this.mRemoteCall.i(Long.valueOf(j3), Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17), callback);
    }

    public void getCachePhotoSearchResult(long j3, String str, int i3, int i16, Callback callback) {
        this.mRemoteCall.g(Long.valueOf(j3), str, Integer.valueOf(i3), Integer.valueOf(i16), callback);
    }

    public void getCacheRecentPhotoList(long j3, int i3, int i16, int i17, Callback callback) {
        this.mRemoteCall.e(Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), callback);
    }

    public void getMoreCategoryPhotoList(long j3, int i3, String str, String str2, Callback callback) {
        this.mRemoteCall.c(Long.valueOf(j3), Integer.valueOf(i3), str, str2, callback);
    }

    public void getMorePhotoSearchResult(long j3, String str, SearchFilterComposition searchFilterComposition, String str2, Callback callback) {
        this.mRemoteCall.d(Long.valueOf(j3), str, searchFilterComposition, str2, callback);
    }

    public void getMoreRecentPhotoList(long j3, int i3, Callback callback) {
        this.mRemoteCall.j(Long.valueOf(j3), Integer.valueOf(i3), callback);
    }

    public void getPullDownRecentPhotoList(long j3, Callback callback) {
        this.mRemoteCall.a(Long.valueOf(j3), callback);
    }

    public void getPullUpRecentPhotoList(long j3, Callback callback) {
        this.mRemoteCall.f(Long.valueOf(j3), callback);
    }

    public void getQzoneQunPhotoListEx(int i3, Long l3, String str, String str2, String str3, Integer num, String str4, HashMap<Integer, String> hashMap, Callback callback) {
        PictureManager pictureManager;
        String str5;
        boolean isEmpty = TextUtils.isEmpty(str2);
        String str6 = str == null ? "" : str;
        if (str3 == null) {
            str5 = "";
            pictureManager = this;
        } else {
            pictureManager = this;
            str5 = str3;
        }
        pictureManager.mRemoteCall.h(Integer.valueOf(i3), l3, str6, str2, str5, num, 0, Integer.valueOf(isEmpty ? 1 : 0), str4, hashMap, callback);
    }

    public RequestSender getSender() {
        if (this.mSender == null) {
            this.mSender = new RequestSender(getHostManager());
        }
        return this.mSender;
    }

    public void getVideoId(Handler handler, String str) {
        getSender().getVideoId(handler, str);
    }

    protected void initProxy() {
        this.mRpcInvocationHandler = new o8.c();
        this.mRemoteCall = (o8.a) Proxy.newProxyInstance(o8.a.class.getClassLoader(), new Class[]{o8.a.class}, this.mRpcInvocationHandler);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0107 A[Catch: Exception -> 0x010b, TRY_ENTER, TryCatch #2 {Exception -> 0x010b, blocks: (B:36:0x00d8, B:38:0x00dd, B:40:0x00e2, B:41:0x00e5, B:43:0x00eb, B:53:0x0107, B:55:0x010f, B:57:0x0114, B:59:0x0119, B:61:0x011f), top: B:6:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x010f A[Catch: Exception -> 0x010b, TryCatch #2 {Exception -> 0x010b, blocks: (B:36:0x00d8, B:38:0x00dd, B:40:0x00e2, B:41:0x00e5, B:43:0x00eb, B:53:0x0107, B:55:0x010f, B:57:0x0114, B:59:0x0119, B:61:0x011f), top: B:6:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0114 A[Catch: Exception -> 0x010b, TryCatch #2 {Exception -> 0x010b, blocks: (B:36:0x00d8, B:38:0x00dd, B:40:0x00e2, B:41:0x00e5, B:43:0x00eb, B:53:0x0107, B:55:0x010f, B:57:0x0114, B:59:0x0119, B:61:0x011f), top: B:6:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0132 A[Catch: Exception -> 0x012e, TryCatch #0 {Exception -> 0x012e, blocks: (B:82:0x012a, B:69:0x0132, B:71:0x0137, B:73:0x013c, B:75:0x0142), top: B:81:0x012a }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0137 A[Catch: Exception -> 0x012e, TryCatch #0 {Exception -> 0x012e, blocks: (B:82:0x012a, B:69:0x0132, B:71:0x0137, B:73:0x013c, B:75:0x0142), top: B:81:0x012a }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x013c A[Catch: Exception -> 0x012e, TryCatch #0 {Exception -> 0x012e, blocks: (B:82:0x012a, B:69:0x0132, B:71:0x0137, B:73:0x013c, B:75:0x0142), top: B:81:0x012a }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x012a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loadLargeResultFromDisk(RecvMsg recvMsg) {
        File file;
        BufferedInputStream bufferedInputStream;
        ?? r75;
        ObjectInputStream objectInputStream;
        if (TextUtils.isEmpty(recvMsg.tmpFileName)) {
            return;
        }
        String str = PictureService.TEMP_FILE_PATH;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                file = new File(str, recvMsg.tmpFileName);
            } catch (Exception e16) {
                e = e16;
                file = null;
                bufferedInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                file = null;
                bufferedInputStream = null;
            }
            try {
                if (file.exists()) {
                    QLog.i(TAG, 2, "start to load tmp file for QZoneResult : " + file.getAbsolutePath());
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        bufferedInputStream = new BufferedInputStream(fileInputStream2);
                        try {
                            r75 = new ObjectInputStream(bufferedInputStream);
                            try {
                                Object readObject = r75.readObject();
                                if (readObject != null && (readObject instanceof Serializable)) {
                                    Serializable serializable = (Serializable) readObject;
                                    Parcelable parcelable = recvMsg.extraData.getParcelable("data");
                                    if (parcelable != null && (parcelable instanceof ParcelableWrapper)) {
                                        ParcelableWrapper parcelableWrapper = (ParcelableWrapper) parcelable;
                                        if (parcelableWrapper.getData() != null && (parcelableWrapper.getData() instanceof QZoneResult)) {
                                            QZoneResult qZoneResult = (QZoneResult) parcelableWrapper.getData();
                                            qZoneResult.getBundle().putSerializable("response", serializable);
                                            recvMsg.extraData.putParcelable("data", ParcelableWrapper.obtain(qZoneResult));
                                        }
                                    }
                                    if (QZLog.isColorLevel()) {
                                        QZLog.i(TAG, "Read tmp file to Obj Succ");
                                    }
                                } else {
                                    QZLog.e(TAG, "failed to read tmp file to QZoneResult !");
                                }
                                fileInputStream = fileInputStream2;
                                objectInputStream = r75;
                            } catch (Exception e17) {
                                e = e17;
                                fileInputStream = fileInputStream2;
                                r75 = r75;
                                try {
                                    QZLog.e(TAG, "Error happens when load tmp file for QZoneResult!", e);
                                    if (fileInputStream != null) {
                                        fileInputStream.close();
                                    }
                                    if (r75 != 0) {
                                        r75.close();
                                    }
                                    if (bufferedInputStream != null) {
                                        bufferedInputStream.close();
                                    }
                                    if (file == null && file.exists()) {
                                        file.delete();
                                        return;
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (Exception e18) {
                                            QZLog.e(TAG, "Error happens when close input stream for larget QZoneResult!", e18);
                                            throw th;
                                        }
                                    }
                                    if (r75 != 0) {
                                        r75.close();
                                    }
                                    if (bufferedInputStream != null) {
                                        bufferedInputStream.close();
                                    }
                                    if (file != null && file.exists()) {
                                        file.delete();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th7) {
                                th = th7;
                                fileInputStream = fileInputStream2;
                                if (fileInputStream != null) {
                                }
                                if (r75 != 0) {
                                }
                                if (bufferedInputStream != null) {
                                }
                                if (file != null) {
                                    file.delete();
                                }
                                throw th;
                            }
                        } catch (Exception e19) {
                            e = e19;
                            r75 = 0;
                        } catch (Throwable th8) {
                            th = th8;
                            r75 = 0;
                        }
                    } catch (Exception e26) {
                        e = e26;
                        bufferedInputStream = null;
                        r75 = 0;
                    } catch (Throwable th9) {
                        th = th9;
                        bufferedInputStream = null;
                        r75 = 0;
                    }
                } else {
                    QZLog.e(TAG, "failed to find tmp file for QZoneResult, which supposed to exist : " + file.getAbsolutePath());
                    bufferedInputStream = null;
                    objectInputStream = null;
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception e27) {
                e = e27;
                bufferedInputStream = null;
                r75 = bufferedInputStream;
                QZLog.e(TAG, "Error happens when load tmp file for QZoneResult!", e);
                if (fileInputStream != null) {
                }
                if (r75 != 0) {
                }
                if (bufferedInputStream != null) {
                }
                if (file == null) {
                }
            } catch (Throwable th10) {
                th = th10;
                bufferedInputStream = null;
                r75 = bufferedInputStream;
                if (fileInputStream != null) {
                }
                if (r75 != 0) {
                }
                if (bufferedInputStream != null) {
                }
                if (file != null) {
                }
                throw th;
            }
        } catch (Exception e28) {
            QZLog.e(TAG, "Error happens when close input stream for larget QZoneResult!", e28);
        }
    }

    protected int sendData(String str, Bundle bundle, Handler handler, long j3, boolean z16) {
        HashMap<Integer, SoftReference<Handler>> hashMap;
        SendMsg sendMsg = new SendMsg(str);
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (bundle.size() > 0) {
            sendMsg.extraData.putAll(bundle);
        }
        int incrementAndGet = this.mReqestId.incrementAndGet();
        sendMsg.setRequestId(incrementAndGet);
        if (j3 > 0) {
            sendMsg.setTimeout(j3);
        }
        sendMsg.setNeedCallback(z16);
        if (handler != null && (hashMap = this.mRequestHandlerMap) != null) {
            hashMap.put(Integer.valueOf(incrementAndGet), new SoftReference<>(handler));
        }
        sendMsg.actionListener = this.mActionListener;
        try {
            if (getRemoteServiceProxy() != null) {
                getRemoteServiceProxy().sendMsg(sendMsg);
            } else {
                HashMap<Integer, SoftReference<Handler>> hashMap2 = this.mRequestHandlerMap;
                if (hashMap2 != null) {
                    hashMap2.remove(Integer.valueOf(incrementAndGet));
                }
                QZLog.e(TAG, 1, "sendData getRemoteServiceProxy null cmd= " + str);
            }
            return incrementAndGet;
        } catch (Exception e16) {
            HashMap<Integer, SoftReference<Handler>> hashMap3 = this.mRequestHandlerMap;
            if (hashMap3 != null) {
                hashMap3.remove(Integer.valueOf(incrementAndGet));
            }
            e16.printStackTrace();
            throw new RuntimeException("sendMsg is fail", e16);
        }
    }

    public void setNetStateCallback() {
        NetworkState.addListener(this.netStateListener);
        this.hasNet = NetworkState.isNetSupport();
    }

    public void faceOperation(Handler handler, MarkFaceItemMood markFaceItemMood, MarkFaceItemFeed markFaceItemFeed, long j3, int i3, String str, int i16) {
        getSender().faceOperation(handler, markFaceItemMood, markFaceItemFeed, j3, i3, str, i16);
    }

    public BasePicureViewController getPicureViewController(int i3, com.qzone.preview.b bVar) {
        BasePicureViewController gVar;
        QZLog.d(TAG, 1, "getPicureViewController... mode:", Integer.valueOf(i3));
        if (i3 == 1) {
            gVar = new g();
        } else if (i3 == 2) {
            gVar = new com.qzone.preview.business.b();
        } else if (i3 == 3) {
            gVar = new d();
        } else if (i3 == 8) {
            gVar = new com.qzone.preview.business.c();
        } else if (i3 != 9) {
            switch (i3) {
                case 11:
                    gVar = new com.qzone.preview.business.a();
                    break;
                case 12:
                    gVar = new h();
                    break;
                case 13:
                    gVar = new e();
                    break;
                default:
                    gVar = new BasePicureViewController();
                    break;
            }
        } else {
            gVar = new f();
        }
        gVar.Q0(bVar);
        return gVar;
    }

    public void getOutShareUrl(Handler handler, int i3, int i16, String str, String str2, String str3, String str4, int i17, long j3, int i18, Map<Integer, String> map) {
        QZLog.d("[PhotoAlbum]shareOutSide", 1, "getOutShareUrl appid:", Integer.valueOf(i3), " ugcType:", Integer.valueOf(i16), " cellid:", str, " albumid:", str2, " lloc:", str3, " batchid:", str4, " iIsShareTo:", Integer.valueOf(i17), " hostUin:", Long.valueOf(j3), " shareScene:", Integer.valueOf(i18), " busi_param:", map);
        getSender().getOutShareUrl(handler, i3, i16, str, str2, str3, str4, i17, j3, i18, map);
    }

    public void getQzonePhotoComment(String str, String str2, String str3, PhotoParam photoParam, Handler handler) {
        if (photoParam == null) {
            return;
        }
        int i3 = photoParam.appid;
        if (i3 != 4) {
            if (i3 != 311) {
                return;
            }
            getSender().getQzonePhotoCommentEx(handler, photoParam.feedUin, photoParam.cell_id, "", "", 5);
        } else if (TextUtils.isEmpty(str3)) {
            getSender().getQzonePhotoCommentEx(handler, photoParam.feedUin, "", str, str2, 0);
        } else {
            getSender().getQzonePhotoCommentEx(handler, photoParam.feedUin, str3, str, str2, 4);
        }
    }

    public void getQzonePhotoListEx(String str, int i3, int i16, String str2, PhotoParam photoParam, long j3, int i17, long j16, Callback callback) {
        int i18;
        PictureManager pictureManager;
        if (photoParam == null) {
            return;
        }
        boolean isEmpty = TextUtils.isEmpty(str);
        String str3 = isEmpty ? "" : str;
        if (photoParam.albumid == null) {
            photoParam.albumid = "";
        }
        if (photoParam.albumanswer == null) {
            photoParam.albumanswer = "";
        }
        if (i3 != 1 || i16 != 1) {
            if (i3 != 1) {
                i18 = i16 == 1 ? 2 : 1;
            }
            pictureManager = this;
            pictureManager.mRemoteCall.b(Long.valueOf(photoParam.ownerUin), photoParam.albumid, str3, photoParam.albumanswer, Integer.valueOf(photoParam.sortType), 0, 0, 0, Integer.valueOf(isEmpty ? 1 : 0), str2, (HashMap) photoParam.busi_param, Integer.valueOf(photoParam.appid), photoParam.cell_id, Integer.valueOf(i18), Long.valueOf(j3), Integer.valueOf(i17), Long.valueOf(j16), callback);
        }
        pictureManager = this;
        i18 = 0;
        pictureManager.mRemoteCall.b(Long.valueOf(photoParam.ownerUin), photoParam.albumid, str3, photoParam.albumanswer, Integer.valueOf(photoParam.sortType), 0, 0, 0, Integer.valueOf(isEmpty ? 1 : 0), str2, (HashMap) photoParam.busi_param, Integer.valueOf(photoParam.appid), photoParam.cell_id, Integer.valueOf(i18), Long.valueOf(j3), Integer.valueOf(i17), Long.valueOf(j16), callback);
    }

    protected PictureManager getHostManager() {
        return this;
    }

    public int sendData(String str, Bundle bundle, Handler handler) {
        try {
            return sendData(str, bundle, handler, 0L, true);
        } catch (Exception e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    public int sendData(Bundle bundle) {
        try {
            return sendData(PictureConst.CMD_NULL, bundle, null, 0L, true);
        } catch (Exception e16) {
            e16.printStackTrace();
            return -1;
        }
    }
}
