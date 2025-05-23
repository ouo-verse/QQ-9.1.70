package com.qzone.preview.service;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.preview.service.base.AbstractBaseService;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.remote.Callback;
import cooperation.qzone.remote.IActionListener;
import cooperation.qzone.remote.RecvMsg;
import cooperation.qzone.remote.SendMsg;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes39.dex */
public class PictureService extends AbstractBaseService {
    private static final String TEMP_FILE_FOLDERNAME = "gallerytmp";
    public static final String TEMP_FILE_PATH = CacheManager.getCacheDir(TEMP_FILE_FOLDERNAME);
    private static final Object sSparseArraySync = new Object();
    private ServiceCmdDispatcher mCmdDispatcher;
    private SparseArray<Handler> mRequestHandlerMap = new SparseArray<>();
    private volatile boolean mHasInitCmdDispatcher = false;
    private o8.a mRemoteCallImpl = new o8.b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements Callback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Handler f49990d;

        a(Handler handler) {
            this.f49990d = handler;
        }

        @Override // cooperation.qzone.remote.Callback
        public void onResult(Object obj) {
            Handler handler = this.f49990d;
            if (handler == null) {
                return;
            }
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.obj = obj;
            this.f49990d.sendMessage(obtainMessage);
        }
    }

    @Override // com.qzone.preview.service.base.AbstractBaseService
    public void handleRequest(SendMsg sendMsg) {
        String serviceCmd = sendMsg.getServiceCmd();
        b bVar = new b(this, sendMsg);
        synchronized (sSparseArraySync) {
            this.mRequestHandlerMap.put(sendMsg.getRequestId(), bVar);
            if (!this.mHasInitCmdDispatcher) {
                ServiceCmdDispatcher serviceCmdDispatcher = new ServiceCmdDispatcher();
                this.mCmdDispatcher = serviceCmdDispatcher;
                serviceCmdDispatcher.loadMethods(new ServiceHandler(), ServiceHandler.class);
                this.mHasInitCmdDispatcher = true;
            }
        }
        if (serviceCmd != null && !PictureConst.CMD_NULL.equals(serviceCmd)) {
            ServiceCmdDispatcher serviceCmdDispatcher2 = this.mCmdDispatcher;
            if (serviceCmdDispatcher2 != null) {
                serviceCmdDispatcher2.dispatchCmd(serviceCmd, sendMsg, bVar);
                return;
            }
            return;
        }
        handleRpcRequest(sendMsg.extraData, bVar);
    }

    @Override // android.app.Service
    public void onDestroy() {
        SparseArray<Handler> sparseArray = this.mRequestHandlerMap;
        if (sparseArray != null) {
            sparseArray.clear();
            this.mRequestHandlerMap = null;
        }
        ServiceCmdDispatcher serviceCmdDispatcher = this.mCmdDispatcher;
        if (serviceCmdDispatcher != null) {
            serviceCmdDispatcher.destroy();
            this.mCmdDispatcher = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0104 A[Catch: Exception -> 0x0100, TryCatch #0 {Exception -> 0x0100, blocks: (B:48:0x00fc, B:39:0x0104, B:41:0x0109), top: B:47:0x00fc }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0109 A[Catch: Exception -> 0x0100, TRY_LEAVE, TryCatch #0 {Exception -> 0x0100, blocks: (B:48:0x00fc, B:39:0x0104, B:41:0x0109), top: B:47:0x00fc }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x011c A[Catch: Exception -> 0x0118, TryCatch #5 {Exception -> 0x0118, blocks: (B:66:0x0114, B:56:0x011c, B:58:0x0121), top: B:65:0x0114 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0121 A[Catch: Exception -> 0x0118, TRY_LEAVE, TryCatch #5 {Exception -> 0x0118, blocks: (B:66:0x0114, B:56:0x011c, B:58:0x0121), top: B:65:0x0114 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0114 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12, types: [java.io.OutputStream, java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.io.ByteArrayOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RecvMsg saveLargeResultToDisk(RecvMsg recvMsg, Object obj) {
        ObjectOutputStream objectOutputStream;
        ?? r85;
        ObjectOutputStream objectOutputStream2;
        ObjectOutputStream objectOutputStream3;
        ?? r86;
        if (obj != null && (obj instanceof QZoneResult)) {
            ?? r46 = TEMP_FILE_PATH;
            if (!TextUtils.isEmpty(r46)) {
                try {
                    try {
                        QZoneResult qZoneResult = (QZoneResult) obj;
                        Serializable serializable = qZoneResult.getBundle().getSerializable("response");
                        qZoneResult.getBundle().putSerializable("response", null);
                        if (serializable != null && (serializable instanceof Serializable)) {
                            Serializable serializable2 = serializable;
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(qZoneResult.getWhat() + "_");
                            sb5.append(System.currentTimeMillis() + ".dat");
                            String sb6 = sb5.toString();
                            File file = new File((String) r46, sb6);
                            if (file.exists()) {
                                file.delete();
                            }
                            file.createNewFile();
                            r46 = new FileOutputStream(file);
                            try {
                                r85 = new ByteArrayOutputStream();
                                try {
                                    objectOutputStream3 = new ObjectOutputStream(r85);
                                } catch (Exception e16) {
                                    e = e16;
                                    objectOutputStream3 = null;
                                } catch (Throwable th5) {
                                    th = th5;
                                    objectOutputStream2 = null;
                                    r86 = r85;
                                    if (r46 != 0) {
                                    }
                                    if (objectOutputStream2 != null) {
                                    }
                                    if (r86 != 0) {
                                    }
                                    throw th;
                                }
                            } catch (Exception e17) {
                                e = e17;
                                r85 = 0;
                                r46 = r46;
                                objectOutputStream3 = r85;
                                QLog.e("AbstractBaseService", 2, "Error happens when create tmp file for larget QZoneResult!", e);
                                if (r46 != 0) {
                                }
                                if (objectOutputStream3 != null) {
                                }
                                if (r85 != 0) {
                                }
                                return null;
                            } catch (Throwable th6) {
                                th = th6;
                                objectOutputStream = null;
                                r46 = r46;
                                objectOutputStream2 = objectOutputStream;
                                r86 = objectOutputStream;
                                if (r46 != 0) {
                                    try {
                                        r46.close();
                                    } catch (Exception e18) {
                                        QLog.e("AbstractBaseService", 2, "Error happens when close output stream for larget QZoneResult!", e18);
                                        return null;
                                    }
                                }
                                if (objectOutputStream2 != null) {
                                    objectOutputStream2.close();
                                }
                                if (r86 != 0) {
                                    r86.close();
                                }
                                throw th;
                            }
                            try {
                                objectOutputStream3.writeObject(serializable2);
                                r85.writeTo(r46);
                                RecvMsg recvMsg2 = new RecvMsg();
                                recvMsg2.serviceCmd = recvMsg.serviceCmd;
                                recvMsg2.resultCode = recvMsg.resultCode;
                                recvMsg2.reqSeq = recvMsg.reqSeq;
                                recvMsg2.tmpFileName = sb6;
                                recvMsg2.extraData.putParcelable("data", ParcelableWrapper.obtain(qZoneResult));
                                QLog.i("AbstractBaseService", 2, "qzone result tmp file name : " + file.getAbsolutePath());
                                try {
                                    r46.close();
                                    objectOutputStream3.close();
                                    r85.close();
                                    return recvMsg2;
                                } catch (Exception e19) {
                                    QLog.e("AbstractBaseService", 2, "Error happens when close output stream for larget QZoneResult!", e19);
                                    return null;
                                }
                            } catch (Exception e26) {
                                e = e26;
                                QLog.e("AbstractBaseService", 2, "Error happens when create tmp file for larget QZoneResult!", e);
                                if (r46 != 0) {
                                    try {
                                        r46.close();
                                    } catch (Exception e27) {
                                        QLog.e("AbstractBaseService", 2, "Error happens when close output stream for larget QZoneResult!", e27);
                                        return null;
                                    }
                                }
                                if (objectOutputStream3 != null) {
                                    objectOutputStream3.close();
                                }
                                if (r85 != 0) {
                                    r85.close();
                                }
                                return null;
                            }
                        }
                        return null;
                    } catch (Exception e28) {
                        e = e28;
                        r46 = 0;
                        r85 = 0;
                    } catch (Throwable th7) {
                        th = th7;
                        r46 = 0;
                        objectOutputStream = null;
                    }
                } catch (Throwable th8) {
                    th = th8;
                }
            }
        }
        return null;
    }

    /* loaded from: classes39.dex */
    class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private int f49992a;

        /* renamed from: b, reason: collision with root package name */
        private String f49993b;

        /* renamed from: c, reason: collision with root package name */
        private IActionListener f49994c;

        b() {
            super(QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).getLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            RecvMsg saveLargeResultToDisk;
            if (PictureService.this.mRequestHandlerMap == null) {
                QLog.e("AbstractBaseService", 2, "ActionHandler handleMessage mRequestHandlerMap == null.");
                return;
            }
            synchronized (PictureService.sSparseArraySync) {
                PictureService.this.mRequestHandlerMap.remove(this.f49992a);
            }
            RecvMsg recvMsg = new RecvMsg(this.f49992a, this.f49993b);
            Object obj = message.obj;
            if (obj instanceof QZoneResult) {
                recvMsg.extraData.putParcelable("data", ParcelableWrapper.obtain((SmartParcelable) obj));
            } else if (obj instanceof Parcelable) {
                recvMsg.extraData.putParcelable("data", (Parcelable) obj);
            } else if (obj instanceof Serializable) {
                recvMsg.extraData.putSerializable("data", (Serializable) obj);
            } else if (obj instanceof SmartParcelable) {
                recvMsg.extraData.putParcelable("data", ParcelableWrapper.obtain((SmartParcelable) obj));
            }
            IActionListener iActionListener = this.f49994c;
            if (iActionListener != null) {
                try {
                    iActionListener.onRecvFromMsg(recvMsg);
                } catch (RemoteException e16) {
                    e16.printStackTrace();
                    QZLog.w(e16);
                    if (!(e16 instanceof TransactionTooLargeException) || (saveLargeResultToDisk = PictureService.this.saveLargeResultToDisk(recvMsg, obj)) == null) {
                        return;
                    }
                    try {
                        this.f49994c.onRecvFromMsg(saveLargeResultToDisk);
                    } catch (RemoteException unused) {
                        QZLog.w(e16);
                    }
                } catch (Exception e17) {
                    e17.printStackTrace();
                    QZLog.w(e17);
                }
            }
        }

        b(PictureService pictureService, SendMsg sendMsg) {
            this();
            this.f49992a = sendMsg.getRequestId();
            this.f49993b = sendMsg.getServiceCmd();
            this.f49994c = sendMsg.actionListener;
        }
    }

    private void handleRpcRequest(Bundle bundle, Handler handler) {
        Class<?>[] clsArr;
        if (bundle == null) {
            return;
        }
        String string = bundle.getString("methodName");
        int i3 = bundle.getInt("methodParamSize");
        Object[] objArr = (Object[]) bundle.getSerializable("methodParamTypes");
        if (objArr instanceof Class[]) {
            clsArr = (Class[]) objArr;
        } else {
            Class<?>[] clsArr2 = new Class[objArr.length];
            for (int i16 = 0; i16 < objArr.length; i16++) {
                clsArr2[i16] = (Class) objArr[i16];
            }
            clsArr = clsArr2;
        }
        int i17 = bundle.getInt("callbackIndex", -1);
        try {
            Object[] objArr2 = new Object[i3];
            for (int i18 = 0; i18 < i3; i18++) {
                String str = "paramKey" + String.valueOf(i18);
                Object obj = bundle.get(str);
                objArr2[i18] = obj;
                if (obj instanceof ParcelableWrapper) {
                    objArr2[i18] = ParcelableWrapper.getDataFromBudle(bundle, str);
                }
            }
            if (i17 >= 0 && i17 < i3) {
                objArr2[i17] = new a(handler);
            }
            this.mRemoteCallImpl.getClass().getDeclaredMethod(string, clsArr).invoke(this.mRemoteCallImpl, objArr2);
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
        } catch (NoSuchMethodException e17) {
            e17.printStackTrace();
        } catch (InvocationTargetException e18) {
            e18.printStackTrace();
        }
    }
}
