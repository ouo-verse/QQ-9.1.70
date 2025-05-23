package com.qzone.preview.service;

import NS_MOBILE_OPERATION.PhotoInformation;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.qzone.adapter.feedcomponent.s;
import com.qzone.album.protocol.AbsCompatRequest;
import com.qzone.album.protocol.QZoneGetRecentPhotoListByTimeLineRequest;
import com.qzone.album.protocol.QZoneQunViewPhotoRequest;
import com.qzone.album.protocol.QZoneViewPhotoRequest;
import com.qzone.album.protocol.QzoneGetPhotoCommentRequest;
import com.qzone.business.favorite.service.QzoneFavoriteService;
import com.qzone.business.share.ShareUtils;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.service.OutSiteShareService;
import com.qzone.common.business.service.QZoneAdvService;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.preview.PictureViewerFactory;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.remote.Callback;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneFeedxLayerRequestSender implements PictureConst {
    private static final String KEY_CALLBACK = "callback";
    private static final String KEY_HANDLER = "handler";
    private static final String KEY_RESPONSE = "response";
    private static final String KEY_TYPE = "type";
    private static final String TAG = "QZoneFeedxLayerRequestSender";
    private AbsCompatRequest.a mOnGetPhotoCommentCallback = new c();
    private AbsCompatRequest.a mOnViewPhotoCallback = new a();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements AbsCompatRequest.a {
        a() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            QZoneResult qZoneResult = new QZoneResult();
            qZoneResult.setSucceed(sVar.getSucceed());
            qZoneResult.setReturnCode(sVar.getReturnCode());
            qZoneResult.setMessage(qZoneResult.getMessage());
            Bundle bundle = qZoneResult.getBundle();
            if (absCompatRequest.getParam("type") instanceof Integer) {
                bundle.putInt("type", ((Integer) absCompatRequest.getParam("type")).intValue());
            }
            if (sVar.getData() instanceof QZoneViewPhotoRequest.a) {
                bundle.putSerializable("response", ((QZoneViewPhotoRequest.a) sVar.getData()).f43977a);
            }
            if (sVar.getData() instanceof QZoneQunViewPhotoRequest.a) {
                bundle.putSerializable("response", ((QZoneQunViewPhotoRequest.a) sVar.getData()).f43975a);
            }
            Callback callback = (Callback) absCompatRequest.getParam("callback");
            if (callback != null) {
                callback.onResult(qZoneResult);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements AbsCompatRequest.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Callback f49997a;

        b(Callback callback) {
            this.f49997a = callback;
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            if (this.f49997a == null || sVar == null) {
                return;
            }
            QZoneResult qZoneResult = new QZoneResult();
            qZoneResult.setSucceed(sVar.getSucceed());
            qZoneResult.setReturnCode(sVar.getReturnCode());
            qZoneResult.setMessage(qZoneResult.getMessage());
            Bundle bundle = qZoneResult.getBundle();
            if (!(sVar.getData() instanceof Bundle) || sVar.getBundle() == null) {
                return;
            }
            bundle.putBoolean("hasMore", sVar.getHasMore());
            bundle.putSerializable("response", sVar.getBundle().getSerializable("response"));
            qZoneResult.setData(bundle);
            this.f49997a.onResult(qZoneResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class f implements AbsCompatRequest.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f50006a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Handler f50007b;

        f(String str, Handler handler) {
            this.f50006a = str;
            this.f50007b = handler;
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            t5.a.b(this.f50006a);
            sVar.sendToHandler(this.f50007b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class g implements QzoneFavoriteService.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f50009a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f50010b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f50011c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f50012d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Handler f50013e;

        g(long j3, String str, long j16, long j17, Handler handler) {
            this.f50009a = j3;
            this.f50010b = str;
            this.f50011c = j16;
            this.f50012d = j17;
            this.f50013e = handler;
        }

        @Override // com.qzone.business.favorite.service.QzoneFavoriteService.d
        public void a(String str, boolean z16) {
            QzoneFavoriteService.M().J(this.f50009a, str, this.f50010b, this.f50011c, this.f50012d, true, this.f50013e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class j implements AbsCompatRequest.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Callback f50019a;

        j(Callback callback) {
            this.f50019a = callback;
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            QZoneFeedxLayerRequestSender.this.handleRecentAlbumTimeline(absCompatRequest, sVar, false, this.f50019a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class k implements AbsCompatRequest.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Callback f50021a;

        k(Callback callback) {
            this.f50021a = callback;
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            QZoneFeedxLayerRequestSender.this.handleRecentAlbumTimeline(absCompatRequest, sVar, true, this.f50021a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements AbsCompatRequest.a {
        c() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            if (sVar != null && (sVar.a() instanceof QZoneResult)) {
                if (absCompatRequest != null && (absCompatRequest.getParam(QZoneFeedxLayerRequestSender.KEY_HANDLER) instanceof Handler)) {
                    QZoneResult qZoneResult = (QZoneResult) sVar.a();
                    Handler handler = (Handler) absCompatRequest.getParam(QZoneFeedxLayerRequestSender.KEY_HANDLER);
                    QZLog.d(QZoneFeedxLayerRequestSender.TAG, 4, "mOnGetPhotoCommentCallback - onResponse handler msg is " + handler.obtainMessage(qZoneResult.what) + " message is " + str);
                    qZoneResult.setSucceed(sVar.getSucceed());
                    qZoneResult.setReturnCode(sVar.getReturnCode());
                    qZoneResult.setMessage(qZoneResult.getMessage());
                    Bundle bundle = qZoneResult.getBundle();
                    bundle.putInt("type", ((Integer) absCompatRequest.getParam("type")).intValue());
                    Object data = qZoneResult.getData();
                    if (data instanceof QzoneGetPhotoCommentRequest.RespBean) {
                        bundle.putSerializable("response", ((QzoneGetPhotoCommentRequest.RespBean) data).f43993d);
                    }
                    Message obtain = Message.obtain();
                    obtain.what = 1000199;
                    obtain.obj = qZoneResult;
                    handler.sendMessage(obtain);
                    return;
                }
                RFWLog.e(QZoneFeedxLayerRequestSender.TAG, RFWLog.CLR, "not instance of handler");
                return;
            }
            RFWLog.e(QZoneFeedxLayerRequestSender.TAG, RFWLog.CLR, "not qzone result");
        }
    }

    public void handleGetQZonePhotoComment(QZoneAlbumRequestBuilder qZoneAlbumRequestBuilder, Handler handler) {
        QZLog.d(TAG, 4, "handleGetQzonePhotoComment start");
        long j3 = qZoneAlbumRequestBuilder.uin;
        String str = qZoneAlbumRequestBuilder.cellId;
        AbsCompatRequest v06 = com.qzone.album.base.Service.a.W().v0(j3, qZoneAlbumRequestBuilder.albumId, qZoneAlbumRequestBuilder.photoId, qZoneAlbumRequestBuilder.reqType, str, this.mOnGetPhotoCommentCallback);
        v06.addParam(KEY_HANDLER, handler);
        v06.addParam("type", 6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d implements AbsCompatRequest.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QZoneInteractPhotoRequestBuilder f50000a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Handler f50001b;

        d(QZoneInteractPhotoRequestBuilder qZoneInteractPhotoRequestBuilder, Handler handler) {
            this.f50000a = qZoneInteractPhotoRequestBuilder;
            this.f50001b = handler;
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            if (sVar == null) {
                return;
            }
            if (sVar.getSucceed() && (sVar.a() instanceof QZoneResult)) {
                QZoneResult qZoneResult = (QZoneResult) sVar.a();
                qZoneResult.what = 999909;
                qZoneResult.setData(this.f50000a);
            }
            sVar.sendToHandler(this.f50001b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class e implements AbsCompatRequest.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QZoneInteractPhotoRequestBuilder f50003a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Handler f50004b;

        e(QZoneInteractPhotoRequestBuilder qZoneInteractPhotoRequestBuilder, Handler handler) {
            this.f50003a = qZoneInteractPhotoRequestBuilder;
            this.f50004b = handler;
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            if (sVar == null) {
                return;
            }
            if (sVar.getSucceed() && (sVar.a() instanceof QZoneResult)) {
                QZoneResult qZoneResult = (QZoneResult) sVar.a();
                qZoneResult.what = 999909;
                qZoneResult.setData(this.f50003a);
            }
            sVar.sendToHandler(this.f50004b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class h implements AbsCompatRequest.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Handler f50015a;

        h(Handler handler) {
            this.f50015a = handler;
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            sVar.setWhat(1000118);
            sVar.sendToHandler(this.f50015a);
        }
    }

    public void getMoreRecentAlbumPhoto(QZoneAlbumRequestBuilder qZoneAlbumRequestBuilder, Callback callback) {
        if (qZoneAlbumRequestBuilder == null) {
            return;
        }
        com.qzone.album.base.Service.a.W().T(qZoneAlbumRequestBuilder, new i(callback));
    }

    public void getMoreRecentVideoList(QZoneAlbumRequestBuilder qZoneAlbumRequestBuilder, Callback callback) {
        if (qZoneAlbumRequestBuilder == null) {
            return;
        }
        com.qzone.album.base.Service.a.W().U(qZoneAlbumRequestBuilder, new b(callback));
    }

    public void handleCommentGroupPhoto(QZoneInteractPhotoRequestBuilder qZoneInteractPhotoRequestBuilder, Handler handler) {
        if (qZoneInteractPhotoRequestBuilder == null) {
            return;
        }
        QZoneWriteOperationService.v0().Q(handler, qZoneInteractPhotoRequestBuilder.transformBuilderToGroupCommentParams());
    }

    public void handleCommentPhoto(QZoneInteractPhotoRequestBuilder qZoneInteractPhotoRequestBuilder, Handler handler) {
        if (qZoneInteractPhotoRequestBuilder == null) {
            return;
        }
        QZoneWriteOperationService.v0().Q(handler, qZoneInteractPhotoRequestBuilder.transformBuilderToCommentParams());
    }

    public void handleDeleteFavor(QZoneInteractPhotoRequestBuilder qZoneInteractPhotoRequestBuilder, Handler handler) {
        if (qZoneInteractPhotoRequestBuilder == null) {
            return;
        }
        long j3 = qZoneInteractPhotoRequestBuilder.ownerUin;
        String str = qZoneInteractPhotoRequestBuilder.ugcKey;
        QzoneFavoriteService.M().Q(new g(j3, str, qZoneInteractPhotoRequestBuilder.appId, qZoneInteractPhotoRequestBuilder.subId, handler), str);
    }

    public void handleDeletePhoto(QZoneInteractPhotoRequestBuilder qZoneInteractPhotoRequestBuilder, Handler handler) {
        if (qZoneInteractPhotoRequestBuilder == null) {
            return;
        }
        String str = qZoneInteractPhotoRequestBuilder.albumId;
        ArrayList<String> arrayList = qZoneInteractPhotoRequestBuilder.photoIdList;
        int i3 = qZoneInteractPhotoRequestBuilder.appId;
        ArrayList<String> arrayList2 = qZoneInteractPhotoRequestBuilder.videoIdList;
        boolean z16 = qZoneInteractPhotoRequestBuilder.isFromSearchResult;
        if (i3 == 311) {
            com.qzone.album.base.Service.a.W().E(arrayList2, new d(qZoneInteractPhotoRequestBuilder, handler));
        } else {
            com.qzone.album.base.Service.a.W().B(str, arrayList, arrayList2, new e(qZoneInteractPhotoRequestBuilder, handler), z16);
        }
    }

    public void handleDownloadVideo(QZoneAlbumMediaRequestBuilder qZoneAlbumMediaRequestBuilder, Handler handler) {
        if (qZoneAlbumMediaRequestBuilder == null) {
            return;
        }
        com.qzone.misc.network.downloader.i.u().q(qZoneAlbumMediaRequestBuilder.videoDownloadUrl);
    }

    public void handleEditPhotoInfo(QZoneInteractPhotoRequestBuilder qZoneInteractPhotoRequestBuilder, Handler handler) {
        if (qZoneInteractPhotoRequestBuilder == null) {
            return;
        }
        String str = qZoneInteractPhotoRequestBuilder.albumId;
        String str2 = qZoneInteractPhotoRequestBuilder.cacheKey;
        int i3 = qZoneInteractPhotoRequestBuilder.operateType;
        com.qzone.album.base.Service.a.W().G(str, qZoneInteractPhotoRequestBuilder.photoIdList, qZoneInteractPhotoRequestBuilder.photoInfo, i3, null, str2, new h(handler));
    }

    public void handleGetOutShareUrl(QZoneInteractPhotoRequestBuilder qZoneInteractPhotoRequestBuilder, Handler handler) {
        if (qZoneInteractPhotoRequestBuilder == null) {
            return;
        }
        OutSiteShareService.a().d(handler, qZoneInteractPhotoRequestBuilder.appId, qZoneInteractPhotoRequestBuilder.ugcType, qZoneInteractPhotoRequestBuilder.cellId, qZoneInteractPhotoRequestBuilder.albumId, qZoneInteractPhotoRequestBuilder.lloc, qZoneInteractPhotoRequestBuilder.batchId, qZoneInteractPhotoRequestBuilder.iIsShareTo, qZoneInteractPhotoRequestBuilder.ownerUin, qZoneInteractPhotoRequestBuilder.shareScene, qZoneInteractPhotoRequestBuilder.extraInfoMap);
    }

    public void handleGetVideoId(QZoneAlbumMediaRequestBuilder qZoneAlbumMediaRequestBuilder, Handler handler) {
        if (qZoneAlbumMediaRequestBuilder == null) {
            return;
        }
        ShareUtils.i(handler, qZoneAlbumMediaRequestBuilder.videoShareUrl);
    }

    public void handlePraisePhoto(QZoneInteractPhotoRequestBuilder qZoneInteractPhotoRequestBuilder, Handler handler) {
        if (qZoneInteractPhotoRequestBuilder == null) {
            return;
        }
        QZoneWriteOperationService.v0().u1(handler, qZoneInteractPhotoRequestBuilder.transformBuilderToLikeParams());
    }

    public void handleRequestAdData(QZoneAlbumMediaRequestBuilder qZoneAlbumMediaRequestBuilder, Handler handler) {
        if (qZoneAlbumMediaRequestBuilder == null) {
            return;
        }
        QZoneAdvService.c().g(handler, qZoneAlbumMediaRequestBuilder.localType, qZoneAlbumMediaRequestBuilder.remoteType);
    }

    public void handleSendReportExposeOrClick(QZoneAlbumMediaRequestBuilder qZoneAlbumMediaRequestBuilder, Handler handler) {
        if (qZoneAlbumMediaRequestBuilder == null) {
            return;
        }
        if (qZoneAlbumMediaRequestBuilder.isExpose) {
            ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportExpose(qZoneAlbumMediaRequestBuilder.traceInfo, qZoneAlbumMediaRequestBuilder.uin);
        } else {
            ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClick(qZoneAlbumMediaRequestBuilder.traceInfo, qZoneAlbumMediaRequestBuilder.uin);
        }
    }

    public void loadMoreRecentAlbumTimeline(QZoneAlbumRequestBuilder qZoneAlbumRequestBuilder, Callback callback) {
        if (qZoneAlbumRequestBuilder == null) {
            return;
        }
        com.qzone.album.base.Service.a.W().V(qZoneAlbumRequestBuilder, new j(callback));
    }

    public void loadMoreUpRecentAlbumTimeline(QZoneAlbumRequestBuilder qZoneAlbumRequestBuilder, Callback callback) {
        if (qZoneAlbumRequestBuilder == null) {
            return;
        }
        com.qzone.album.base.Service.a.W().V(qZoneAlbumRequestBuilder, new k(callback));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class i implements AbsCompatRequest.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Callback f50017a;

        i(Callback callback) {
            this.f50017a = callback;
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.a
        public void a(AbsCompatRequest absCompatRequest, s sVar, int i3, String str) {
            if (sVar == null || absCompatRequest == null) {
                return;
            }
            QZoneResult qZoneResult = new QZoneResult();
            qZoneResult.setSucceed(sVar.getSucceed());
            qZoneResult.setReturnCode(sVar.getReturnCode());
            qZoneResult.setMessage(sVar.getMessage());
            if (sVar.getSucceed() && qZoneResult.getBundle() != null) {
                qZoneResult.getBundle().putSerializable("response", sVar.getBundle().getSerializable("response"));
            }
            Callback callback = this.f50017a;
            if (callback != null) {
                callback.onResult(qZoneResult);
            }
        }
    }

    public void handleAddFavor(QZoneInteractPhotoRequestBuilder qZoneInteractPhotoRequestBuilder, Handler handler) {
        if (qZoneInteractPhotoRequestBuilder == null) {
            return;
        }
        long j3 = qZoneInteractPhotoRequestBuilder.ownerUin;
        long j16 = qZoneInteractPhotoRequestBuilder.appId;
        long j17 = qZoneInteractPhotoRequestBuilder.subId;
        String str = qZoneInteractPhotoRequestBuilder.cellId;
        String str2 = qZoneInteractPhotoRequestBuilder.cellSubId;
        String str3 = qZoneInteractPhotoRequestBuilder.ugcKey;
        HashMap<String, String> hashMap = qZoneInteractPhotoRequestBuilder.extendMap;
        ArrayList<String> arrayList = qZoneInteractPhotoRequestBuilder.photoUrlList;
        ArrayList<PhotoInformation> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next)) {
                    PhotoInformation photoInformation = new PhotoInformation();
                    photoInformation.sUrl = next;
                    arrayList2.add(photoInformation);
                }
            }
        }
        QzoneFavoriteService.M().F(j3, j16, j17, str, str2, str3, hashMap, arrayList2, true, handler);
    }

    public void getGroupPhotoList(QZoneAlbumRequestBuilder qZoneAlbumRequestBuilder, Callback callback) {
        if (qZoneAlbumRequestBuilder == null) {
            return;
        }
        if (TextUtils.isEmpty(qZoneAlbumRequestBuilder.lloc)) {
            qZoneAlbumRequestBuilder.reqType = 1;
        }
        AbsCompatRequest u06 = com.qzone.album.base.Service.a.W().u0(qZoneAlbumRequestBuilder.groupId, qZoneAlbumRequestBuilder.uploadUin, qZoneAlbumRequestBuilder.albumId, qZoneAlbumRequestBuilder.lloc, "", qZoneAlbumRequestBuilder.sort, qZoneAlbumRequestBuilder.getComment, qZoneAlbumRequestBuilder.reqType, qZoneAlbumRequestBuilder.bigUrl, qZoneAlbumRequestBuilder.busiParam, this.mOnViewPhotoCallback);
        u06.addParam("callback", callback);
        u06.addParam("type", 4);
    }

    public void handleForwardPhoto(QZoneInteractPhotoRequestBuilder qZoneInteractPhotoRequestBuilder, Handler handler) {
        if (qZoneInteractPhotoRequestBuilder == null) {
            return;
        }
        String str = qZoneInteractPhotoRequestBuilder.contentCacheUniKey;
        com.qzone.album.base.Service.a.W().J(qZoneInteractPhotoRequestBuilder.appId, (int) qZoneInteractPhotoRequestBuilder.subId, qZoneInteractPhotoRequestBuilder.ownerUin, qZoneInteractPhotoRequestBuilder.albumId, qZoneInteractPhotoRequestBuilder.srcSubId, qZoneInteractPhotoRequestBuilder.forwardText, 4, "", 0, null, str, new f(str, handler));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleRecentAlbumTimeline(AbsCompatRequest absCompatRequest, s sVar, boolean z16, Callback callback) {
        if (absCompatRequest == null || sVar == null) {
            return;
        }
        QZoneResult qZoneResult = new QZoneResult();
        qZoneResult.setReturnCode(sVar.getReturnCode());
        qZoneResult.setSucceed(sVar.getSucceed());
        qZoneResult.setMessage(sVar.getMessage());
        if (sVar.getSucceed() && (sVar.getData() instanceof QZoneGetRecentPhotoListByTimeLineRequest.a)) {
            QZoneGetRecentPhotoListByTimeLineRequest.a aVar = (QZoneGetRecentPhotoListByTimeLineRequest.a) sVar.getData();
            ArrayList<PhotoInfo> e06 = PictureViewerFactory.e0(aVar.f43940a);
            qZoneResult.setSucceed(true);
            qZoneResult.getBundle().putBoolean("hasMore", aVar.f43943d == 1);
            qZoneResult.getBundle().putInt("direction", z16 ? 2 : 1);
            qZoneResult.getBundle().putParcelableArrayList("responseList", e06);
            if (sVar.getSucceed() && qZoneResult.getBundle() != null) {
                qZoneResult.getBundle().putSerializable("response", sVar.getBundle().getSerializable("response"));
            }
        }
        if (callback != null) {
            callback.onResult(qZoneResult);
        }
    }
}
