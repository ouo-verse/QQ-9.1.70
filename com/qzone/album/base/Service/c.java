package com.qzone.album.base.Service;

import NS_MOBILE_PHOTO.Album;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.qzone.adapter.feedcomponent.e;
import com.qzone.adapter.feedcomponent.f;
import com.qzone.adapter.feedcomponent.q;
import com.qzone.adapter.feedcomponent.s;
import com.qzone.album.data.AlbumCacheDataManager;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.protocol.AbsCompatRequest;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.common.event.Observable;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.publish.business.publishqueue.h;
import com.qzone.publish.business.task.QZoneQueueTask;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.reborn.albumx.qzone.local.QZoneUploadRecommendDirector;
import com.qzone.util.al;
import com.qzone.util.image.ImageInfo;
import com.tencent.biz.richframework.network.servlet.VSBaseServlet;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c extends Observable implements IQZoneServiceListener, IObserver.background, com.qzone.album.base.Service.b {

    /* renamed from: f, reason: collision with root package name */
    private static final al<c, Void> f42034f = new a();

    /* renamed from: d, reason: collision with root package name */
    private AlbumCacheDataManager f42035d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f42036e;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends al<c, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public c a(Void r16) {
            return new c();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null) {
                return;
            }
            int i3 = message.what;
            if (i3 == 100 || i3 == 101) {
                Object obj = message.obj;
                if (obj instanceof HashMap) {
                    HashMap hashMap = (HashMap) obj;
                    AbsCompatRequest absCompatRequest = (AbsCompatRequest) hashMap.get(VSBaseServlet.KEY_REQUEST);
                    s sVar = (s) hashMap.get("key_result");
                    String cmdString = absCompatRequest.getCmdString();
                    if (absCompatRequest.isCancel() || absCompatRequest.isComplete()) {
                        return;
                    }
                    AbsCompatRequest.a callback = absCompatRequest.getCallback();
                    if (callback != null) {
                        try {
                            callback.a(absCompatRequest, sVar, sVar.getReturnCode(), sVar.getMessage());
                            QZLog.i("[PhotoAlbum]QZoneAlbumService", "CompatCallback [" + cmdString + "] end, type = " + message.what);
                        } catch (Exception e16) {
                            QZLog.e("[PhotoAlbum]QZoneAlbumService", "CompatCallback [" + cmdString + "] fail : ", e16);
                        }
                    }
                    absCompatRequest.setComplete(true);
                }
            }
        }
    }

    c() {
        super("QzoneAlbum");
        this.f42036e = new b(Looper.getMainLooper());
        this.f42035d = AlbumCacheDataManager.J();
        EventCenter.getInstance().addObserver(this, 3, "WriteOperation", 17, 10, 44, 49, 11, 45, 50, 13, 34);
    }

    public static c G() {
        return f42034f.get(null);
    }

    public e.a F() {
        return e.a.a(getEventSource());
    }

    public void H(long j3, Handler handler, int i3, HashMap<String, String> hashMap) {
        g4.a.f401215a.getServiceInterface().b(j3, handler, i3, hashMap);
    }

    public void M(String str, BusinessFeedData businessFeedData) {
        this.f42035d.k0(str);
        this.f42035d.m0(str);
        this.f42035d.n0(str);
        com.qzone.common.business.service.d.e().j("album", ef.b.a(businessFeedData));
    }

    public void R(long j3, Handler handler, int i3, HashMap<String, String> hashMap) {
        g4.a.f401215a.getServiceInterface().a(j3, handler, null, i3, hashMap);
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (QZLog.isColorLevel()) {
            QZLog.d(QZLog.TO_DEVICE_TAG, 2, "[PhotoAlbum]QZoneAlbumService\t onTaskResponse() task.mType:" + qZoneTask.mType);
        }
        QZLog.i("[PhotoAlbum]QZoneAlbumService", "onTaskResponse " + qZoneTask.mType);
        QZoneRequest qZoneRequest = qZoneTask.mRequest;
        if (qZoneRequest instanceof AbsCompatRequest) {
            AbsCompatRequest absCompatRequest = (AbsCompatRequest) qZoneRequest;
            String cmdString = qZoneRequest.getCmdString();
            s c16 = s.c(qZoneTask.getResult(0));
            boolean z16 = true;
            if (qZoneTask.mResultCode != 0) {
                c16.setSucceed(false);
                QZLog.e("[PhotoAlbum]QZoneAlbumService", "[" + cmdString + "] fail with code :" + qZoneTask.mResultCode);
                Object param = absCompatRequest.getParam("album");
                if (param != null && (param instanceof Album)) {
                    Album album = (Album) param;
                    QZLog.e("[PhotoAlbum]QZoneAlbumService", "[" + cmdString + "] fail with album info id=" + album.albumid + ", name=" + album.name);
                }
            } else {
                try {
                    Object onJceRespParse = absCompatRequest.onJceRespParse(qZoneTask.mRequest.rsp);
                    c16.setSucceed(true);
                    c16.setData(onJceRespParse);
                    QZLog.i("[PhotoAlbum]QZoneAlbumService", "[" + cmdString + "] onJceRespParse success");
                } catch (Exception e16) {
                    c16.setSucceed(false);
                    QZLog.e("[PhotoAlbum]QZoneAlbumService", "[" + cmdString + "] onJceRespParse fail : ", e16);
                }
            }
            AbsCompatRequest.b onJceParseListener = absCompatRequest.getOnJceParseListener();
            if (onJceParseListener != null) {
                try {
                    z16 = onJceParseListener.a(absCompatRequest, c16);
                    QZLog.i("[PhotoAlbum]QZoneAlbumService", "OnJceParseListener[" + cmdString + "] success");
                } catch (Exception e17) {
                    c16.setSucceed(false);
                    QZLog.e("[PhotoAlbum]QZoneAlbumService", "OnJceParseListener[" + cmdString + "] fail : ", e17);
                }
            }
            boolean isCancel = absCompatRequest.isCancel();
            if (!z16 || isCancel) {
                return;
            }
            Message obtain = Message.obtain();
            HashMap hashMap = new HashMap();
            hashMap.put(VSBaseServlet.KEY_REQUEST, absCompatRequest);
            hashMap.put("key_result", c16);
            obtain.obj = hashMap;
            obtain.what = 100;
            this.f42036e.sendMessage(obtain);
        }
    }

    private void I() {
        notify(8, new Object[0]);
    }

    private void K() {
        notify(27, new Object[0]);
    }

    private void L(Object... objArr) {
        notify(3, objArr);
    }

    private void Q(Object... objArr) {
        notify(26, objArr);
        I();
    }

    private s4.c E(String str, List<ImageInfo> list, VideoInfo videoInfo, String str2, long j3, BusinessAlbumInfo businessAlbumInfo, Map<String, String> map) {
        BitmapFactory.Options options;
        if ((list == null || list.isEmpty()) && videoInfo == null) {
            return null;
        }
        s4.c cVar = new s4.c();
        cVar.albumid = businessAlbumInfo.mAlbumId;
        cVar.clientKey = str;
        cVar.albumname = businessAlbumInfo.getTitle();
        cVar.clientKey = str;
        cVar.lbs = str2;
        cVar.ownerUin = LoginData.getInstance().getUin();
        cVar.mUploadTime = (int) (System.currentTimeMillis() / 1000);
        cVar.uploadnum = list != null ? list.size() : 0;
        cVar.videoInfo = videoInfo;
        ArrayList<PictureItem> arrayList = new ArrayList<>();
        if (list != null && !list.isEmpty()) {
            for (ImageInfo imageInfo : list) {
                PictureItem pictureItem = new PictureItem();
                PictureUrl pictureUrl = new PictureUrl();
                pictureItem.currentUrl = pictureUrl;
                String str3 = imageInfo.mPath;
                pictureUrl.url = str3;
                if (URLUtil.isNetworkUrl(str3)) {
                    options = null;
                } else {
                    options = com.qzone.util.image.c.G(str3);
                    if (!str3.startsWith("file://")) {
                        str3 = "file://" + str3;
                    }
                }
                if (options != null) {
                    PictureUrl pictureUrl2 = pictureItem.currentUrl;
                    pictureUrl2.width = options.outWidth;
                    pictureUrl2.height = options.outHeight;
                    if ("image/gif".equalsIgnoreCase(options.outMimeType)) {
                        pictureItem.currentUrl.pictureType = 2;
                        pictureItem.type = 2;
                    }
                    if (options.outWidth * 5 <= options.outHeight) {
                        pictureItem.setChangtuFlag(true);
                    }
                }
                PictureUrl pictureUrl3 = pictureItem.currentUrl;
                pictureItem.bigUrl = pictureUrl3;
                pictureItem.originUrl = pictureUrl3;
                pictureItem.localFileUrl = str3;
                arrayList.add(pictureItem);
            }
        }
        if (videoInfo != null) {
            PictureItem pictureItem2 = new PictureItem();
            pictureItem2.currentUrl = videoInfo.currentUrl;
            pictureItem2.bigUrl = videoInfo.bigUrl;
            pictureItem2.originUrl = videoInfo.originUrl;
            arrayList.add(pictureItem2);
        }
        cVar.pics = arrayList;
        return cVar;
    }

    private void J(QZoneQueueTask qZoneQueueTask) {
        if (qZoneQueueTask == null) {
            return;
        }
        if (qZoneQueueTask.getExactType() == 2) {
            long batchId = qZoneQueueTask.getBatchId();
            if (h.c(batchId) && h.e(batchId).f51145d > 0) {
                return;
            }
        }
        this.f42035d.k0(qZoneQueueTask.clientKey);
        this.f42035d.n0(qZoneQueueTask.clientKey);
        QZLog.d("[PhotoAlbum]QZoneAlbumService", 4, "removeFakePhotoCacheData clientKey:" + qZoneQueueTask.clientKey);
        K();
        this.f42035d.m0(qZoneQueueTask.clientKey);
        I();
    }

    public void N(String str, List<ImageInfo> list, String str2, long j3, BusinessAlbumInfo businessAlbumInfo, int i3, Map<String, String> map, Long l3) {
        ArrayList<PhotoCacheData> D;
        ArrayList arrayList = new ArrayList();
        Iterator<ImageInfo> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().mPath);
        }
        if (arrayList.size() > 0) {
            EventCenter.getInstance().post("PHOTOUPLOADACTION", 1, arrayList.toArray());
            QZoneUploadRecommendDirector.INSTANCE.a().E(arrayList);
        }
        String str3 = businessAlbumInfo.mAlbumId;
        if (TextUtils.isEmpty(str3) || (D = D(str, list, null, str2, j3, businessAlbumInfo, map)) == null) {
            return;
        }
        if (QZLog.isDevelopLevel()) {
            QZLog.d("TestFlowId", 4, "onUploadPhoto datas size:" + D.size());
        }
        this.f42035d.c(str3, D);
        if (!bl.b(list)) {
            notify(33, str3, l3, q.b().f(list.get(0)));
            notify(10, str3, list.get(0).mPath, l3);
        }
        L(this.f42035d.B(str3), Boolean.FALSE);
        this.f42035d.d(E(str, list, null, str2, j3, businessAlbumInfo, map));
        I();
    }

    public void P(String str, List<MediaWrapper> list, String str2, long j3, BusinessAlbumInfo businessAlbumInfo, int i3, Map<String, String> map, int i16) {
        ArrayList<PhotoCacheData> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap = new HashMap();
        for (MediaWrapper mediaWrapper : list) {
            if (mediaWrapper.isImage()) {
                notify(10, businessAlbumInfo.getId(), mediaWrapper.getImageInfo().mPath);
                arrayList2.add(mediaWrapper.getImageInfo().mPath);
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(mediaWrapper.getImageInfo());
                hashMap.put(mediaWrapper.getImageInfo().mPath, mediaWrapper.getImageInfo());
                arrayList.addAll(D(str, arrayList3, null, str2, j3, businessAlbumInfo, map));
            } else if (mediaWrapper.isVideo()) {
                arrayList.addAll(C(str, MediaWrapper.toVideoInfo(mediaWrapper.getVideoInfo()), j3, businessAlbumInfo, map));
                arrayList2.add(mediaWrapper.getVideoInfo().mVideoPath);
            }
        }
        if (arrayList2.size() > 0) {
            EventCenter.getInstance().post("PHOTOUPLOADACTION", 1, arrayList2.toArray());
            QZoneUploadRecommendDirector.INSTANCE.a().E(arrayList2);
        }
        String str3 = businessAlbumInfo.mAlbumId;
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        if (i16 == 1) {
            this.f42035d.c(str3, arrayList);
            this.f42035d.e(businessAlbumInfo.mUin, arrayList);
        }
        Object obj = Boolean.FALSE;
        L(this.f42035d.B(str3), obj);
        Q(this.f42035d.V(businessAlbumInfo.mUin, 2), obj);
    }

    @Override // com.qzone.common.event.IObserver.background
    public void onEventBackgroundThread(Event event) {
        if ("WriteOperation".equals(event.source.getName())) {
            Object[] objArr = (Object[]) event.params;
            int i3 = event.what;
            if (i3 != 10) {
                if (i3 != 11) {
                    if (i3 == 13) {
                        J((QZoneQueueTask) objArr[0]);
                        return;
                    }
                    if (i3 == 17) {
                        this.f42035d.q((String) objArr[1], (String) objArr[3]);
                        notify(7, new Object[0]);
                        return;
                    }
                    if (i3 == 34) {
                        String str = (String) objArr[0];
                        this.f42035d.n(str);
                        this.f42035d.o(str);
                        return;
                    } else if (i3 == 44) {
                        O((String) objArr[0], (List) objArr[1], (VideoInfo) objArr[2], (String) objArr[3], ((Long) objArr[4]).longValue(), (BusinessAlbumInfo) objArr[5], 4097, (Map) objArr[6]);
                        return;
                    } else if (i3 != 45) {
                        if (i3 == 49) {
                            P((String) objArr[0], (List) objArr[1], (String) objArr[2], ((Long) objArr[3]).longValue(), (BusinessAlbumInfo) objArr[4], 4097, (Map) objArr[5], ((Integer) objArr[6]).intValue());
                            return;
                        } else if (i3 != 50) {
                            return;
                        }
                    }
                }
                M((String) objArr[0], (BusinessFeedData) objArr[1]);
                return;
            }
            N((String) objArr[0], (List) objArr[1], (String) objArr[2], ((Long) objArr[3]).longValue(), (BusinessAlbumInfo) objArr[4], 4097, (Map) objArr[5], (Long) objArr[7]);
        }
    }

    private ArrayList<PhotoCacheData> C(String str, VideoInfo videoInfo, long j3, BusinessAlbumInfo businessAlbumInfo, Map<String, String> map) {
        if (videoInfo == null) {
            return null;
        }
        PhotoCacheData photoCacheData = new PhotoCacheData();
        photoCacheData.albumid = businessAlbumInfo.mAlbumId;
        photoCacheData.clientKey = str;
        photoCacheData.curkey = str;
        PictureItem pictureItem = new PictureItem();
        photoCacheData.picItem = pictureItem;
        pictureItem.currentUrl = videoInfo.currentUrl;
        pictureItem.bigUrl = videoInfo.bigUrl;
        pictureItem.originUrl = videoInfo.originUrl;
        photoCacheData.videodata = videoInfo;
        photoCacheData.videoflag = 1;
        photoCacheData.uploadtime = System.currentTimeMillis() / 1000;
        photoCacheData.poiAddress = map != null ? map.get("get_idname") : null;
        photoCacheData.ownerUin = LoginData.getInstance().getUin();
        photoCacheData.shoottime = videoInfo.shootTime;
        ArrayList<PhotoCacheData> arrayList = new ArrayList<>();
        arrayList.add(photoCacheData);
        return arrayList;
    }

    @Override // com.qzone.album.base.Service.b
    public void c(AbsCompatRequest absCompatRequest, String str) {
        if (absCompatRequest == null) {
            return;
        }
        if (str != null) {
            absCompatRequest.setRefer(str);
        }
        if (NetworkState.isNetSupport()) {
            QZoneBusinessLooper.getInstance().runTask(new QZoneTask(absCompatRequest, null, this, 0));
        } else {
            QZLog.i("[PhotoAlbum]QZoneAlbumService", 2, "network not connect ");
            AbsCompatRequest.a callback = absCompatRequest.getCallback();
            if (callback != null) {
                QZoneResult qZoneResult = new QZoneResult(0);
                qZoneResult.setMessage(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkNotConnect", "\u7f51\u7edc\u65e0\u8fde\u63a5"));
                qZoneResult.setReturnCode(1000006);
                s c16 = s.c(qZoneResult);
                callback.a(absCompatRequest, c16, c16.getReturnCode(), c16.getMessage());
                return;
            }
        }
        if (absCompatRequest.getTimeout() > 0) {
            QZoneResult qZoneResult2 = new QZoneResult(0);
            qZoneResult2.setMessage(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkTimeOut", "\u7f51\u7edc\u8d85\u65f6"));
            qZoneResult2.setReturnCode(1002);
            s c17 = s.c(qZoneResult2);
            Message obtain = Message.obtain();
            HashMap hashMap = new HashMap();
            hashMap.put(VSBaseServlet.KEY_REQUEST, absCompatRequest);
            hashMap.put("key_result", c17);
            obtain.obj = hashMap;
            obtain.what = 101;
            this.f42036e.sendMessageDelayed(obtain, absCompatRequest.getTimeout());
        }
    }

    public void O(String str, List<ImageInfo> list, VideoInfo videoInfo, String str2, long j3, BusinessAlbumInfo businessAlbumInfo, int i3, Map<String, String> map) {
        ArrayList<PhotoCacheData> C;
        if (videoInfo != null && videoInfo.videoUrl != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoInfo.videoUrl.url);
            EventCenter.getInstance().post("PHOTOUPLOADACTION", 1, arrayList.toArray());
        }
        String str3 = businessAlbumInfo.mAlbumId;
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        if ((videoInfo == null || !videoInfo.isTranscoding) && (C = C(str, videoInfo, j3, businessAlbumInfo, map)) != null) {
            QZLog.d("TestFlowId", 4, "onUploadVideo data size:" + C.size());
            this.f42035d.c(str3, C);
            this.f42035d.e(businessAlbumInfo.mUin, C);
            Boolean bool = Boolean.FALSE;
            L(this.f42035d.B(str3), bool);
            Q(this.f42035d.V(businessAlbumInfo.mUin, 2), bool);
        }
    }

    private ArrayList<PhotoCacheData> D(String str, List<ImageInfo> list, VideoInfo videoInfo, String str2, long j3, BusinessAlbumInfo businessAlbumInfo, Map<String, String> map) {
        BitmapFactory.Options options;
        if ((list == null || list.isEmpty()) && videoInfo == null) {
            return null;
        }
        ArrayList<PhotoCacheData> arrayList = new ArrayList<>();
        if (list != null && !list.isEmpty()) {
            for (ImageInfo imageInfo : list) {
                PhotoCacheData photoCacheData = new PhotoCacheData();
                photoCacheData.albumid = businessAlbumInfo.mAlbumId;
                photoCacheData.clientKey = str;
                photoCacheData.curkey = str;
                photoCacheData.desc = imageInfo.mDescription;
                photoCacheData.shoottime = f.C(map);
                PictureItem pictureItem = new PictureItem();
                PictureUrl pictureUrl = new PictureUrl();
                pictureItem.currentUrl = pictureUrl;
                String str3 = imageInfo.mPath;
                pictureUrl.url = str3;
                if (URLUtil.isNetworkUrl(str3)) {
                    options = null;
                } else {
                    options = com.qzone.util.image.c.G(str3);
                    if (!str3.startsWith("file://")) {
                        str3 = "file://" + str3;
                    }
                }
                if (options != null) {
                    PictureUrl pictureUrl2 = pictureItem.currentUrl;
                    pictureUrl2.width = options.outWidth;
                    pictureUrl2.height = options.outHeight;
                    if ("image/gif".equalsIgnoreCase(options.outMimeType)) {
                        pictureItem.currentUrl.pictureType = 2;
                        pictureItem.type = 2;
                    }
                    if (options.outWidth * 5 <= options.outHeight) {
                        pictureItem.setChangtuFlag(true);
                    }
                }
                PictureUrl pictureUrl3 = pictureItem.currentUrl;
                pictureItem.bigUrl = pictureUrl3;
                pictureItem.originUrl = pictureUrl3;
                pictureItem.localFileUrl = str3;
                photoCacheData.picItem = pictureItem;
                photoCacheData.uploadtime = System.currentTimeMillis() / 1000;
                photoCacheData.poiAddress = map == null ? null : map.get("get_idname");
                photoCacheData.ownerUin = LoginData.getInstance().getUin();
                arrayList.add(photoCacheData);
            }
        }
        if (videoInfo != null) {
            PhotoCacheData photoCacheData2 = new PhotoCacheData();
            photoCacheData2.albumid = businessAlbumInfo.mAlbumId;
            photoCacheData2.clientKey = str;
            photoCacheData2.curkey = str;
            photoCacheData2.shoottime = f.C(map);
            PictureItem pictureItem2 = new PictureItem();
            photoCacheData2.picItem = pictureItem2;
            pictureItem2.currentUrl = videoInfo.currentUrl;
            pictureItem2.bigUrl = videoInfo.bigUrl;
            pictureItem2.originUrl = videoInfo.originUrl;
            photoCacheData2.videodata = videoInfo;
            photoCacheData2.videoflag = 1;
            photoCacheData2.uploadtime = System.currentTimeMillis() / 1000;
            photoCacheData2.poiAddress = map == null ? null : map.get("get_idname");
            photoCacheData2.ownerUin = LoginData.getInstance().getUin();
            arrayList.add(photoCacheData2);
        }
        return arrayList;
    }
}
