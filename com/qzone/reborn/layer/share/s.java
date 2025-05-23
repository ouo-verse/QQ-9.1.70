package com.qzone.reborn.layer.share;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.business.share.ShareUtils;
import com.qzone.util.ToastUtil;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.libra.util.ImageContentType;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI;
import com.tencent.mobileqq.wink.api.IWinkMediaHelper;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.util.QQToastUtil;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.VideoInfo;
import cooperation.qzone.model.VideoUrl;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: P */
/* loaded from: classes37.dex */
public class s extends QZoneBaseShareAction {

    /* renamed from: j, reason: collision with root package name */
    private static final String f58209j = ((IWinkEditorResourceAPI) QRoute.api(IWinkEditorResourceAPI.class)).getDownloadBasePath() + ImageContentType.IMAGE_PREFIX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f58212d;

        b(f fVar) {
            this.f58212d = fVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            s.this.I(this.f58212d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QZLog.i(QZLog.TO_DEVICE_TAG, 1, "\u53d6\u6d88\u5206\u4eab");
        }
    }

    public s(Activity activity) {
        super(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(f fVar) {
        VideoInfo videoInfo;
        VideoUrl videoUrl;
        PhotoInfo photoInfo = fVar.f58179c;
        if (photoInfo == null) {
            return;
        }
        String str = photoInfo.downloadUrl;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(photoInfo.albumId);
        sb5.append("_");
        sb5.append(photoInfo.lloc);
        if (TextUtils.isEmpty(str) && (videoInfo = photoInfo.videodata) != null && (videoUrl = videoInfo.downloadVideoUrl) != null && !TextUtils.isEmpty(videoUrl.url)) {
            str = photoInfo.videodata.downloadVideoUrl.url;
            VideoInfo videoInfo2 = photoInfo.videodata;
            String str2 = videoInfo2.albumid;
            String str3 = videoInfo2.lloc;
        }
        B(n().getResources().getString(R.string.f2199767v));
        if (fVar.f58177a == 1) {
            ToastUtil.n(R.string.f21969674);
            i();
        } else {
            RFWDownloaderFactory.getDownloader(new u6.c()).download(str, new a(fVar));
        }
    }

    private void J(f fVar) {
        PhotoInfo photoInfo = fVar.f58179c;
        if (photoInfo == null) {
            return;
        }
        int x16 = tk.h.x(photoInfo, fVar.f58180d);
        if (x16 == 0) {
            I(fVar);
        } else {
            if (x16 != 4) {
                return;
            }
            N(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String K(f fVar) {
        if (fVar.f58179c.isVideo()) {
            if (com.qzone.preview.d.f(fVar.f58180d)) {
                return WinkDaTongReportConstant.ElementParamValue.QZONE_ALBUM_VIDEO_LAYER_PAGE;
            }
            return WinkDaTongReportConstant.ElementParamValue.QZONE_SHUOSHUO_VIDEO_LAYER_PAGE;
        }
        if (com.qzone.preview.d.f(fVar.f58180d)) {
            return WinkDaTongReportConstant.ElementParamValue.QZONE_ALBUM_PIC_LAYER_PAGE;
        }
        return WinkDaTongReportConstant.ElementParamValue.QZONE_SHUOSHUO_PIC_LAYER_PAGE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean L(String str) {
        VideoInfo videoInfo;
        IWinkMediaHelper iWinkMediaHelper = (IWinkMediaHelper) QRoute.api(IWinkMediaHelper.class);
        if (this.f58109d.isVideo()) {
            PhotoInfo photoInfo = this.f58109d;
            if (photoInfo == null || (videoInfo = photoInfo.videodata) == null) {
                return false;
            }
            return iWinkMediaHelper.isSupportVideoFormat(videoInfo.width, videoInfo.height, (int) videoInfo.validVideoTime);
        }
        return iWinkMediaHelper.isSupportImageFormat(new File(str));
    }

    private void N(f fVar) {
        ShareUtils.s(n(), new b(fVar), new c());
    }

    public void H(f fVar, Map<String, Object> map) {
        map.put("xsj_target_qq", Long.valueOf(this.f58110e.ownerUin));
        map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_SHAREPANE_SOURCE, K(fVar));
        map.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_QQ_SHARE_PANEL);
        VideoReport.reportEvent("ev_xsj_sharepanel_action", null, map);
    }

    public void M(String str) {
        yo.g gVar = new yo.g(str);
        i();
        yo.d.b(n(), gVar);
    }

    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    void j(f fVar, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.put("xsj_action_type", "share");
        buildElementParams.put("xsj_share_target", WinkDaTongReportConstant.ElementParamValue.LITTLE_WORLD);
        H(fVar, buildElementParams);
        if (fVar.f58179c.isVideo()) {
            J(fVar);
        } else {
            I(fVar);
        }
    }

    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    public int[] s() {
        return new int[]{203};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements RFWDownloader.RFWDownloadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f58210d;

        a(f fVar) {
            this.f58210d = fVar;
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void callEnd(Call call) {
            com.tencent.biz.richframework.download.v.a(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void callFailed(Call call, IOException iOException) {
            com.tencent.biz.richframework.download.v.b(this, call, iOException);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void callStart(Call call) {
            com.tencent.biz.richframework.download.v.c(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol2) {
            com.tencent.biz.richframework.download.v.d(this, call, inetSocketAddress, proxy, protocol2);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol2, IOException iOException) {
            com.tencent.biz.richframework.download.v.e(this, call, inetSocketAddress, proxy, protocol2, iOException);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
            com.tencent.biz.richframework.download.v.f(this, call, inetSocketAddress, proxy);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectionAcquired(Call call, Connection connection) {
            com.tencent.biz.richframework.download.v.g(this, call, connection);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectionReleased(Call call, Connection connection) {
            com.tencent.biz.richframework.download.v.h(this, call, connection);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void dnsEnd(Call call, String str, List list) {
            com.tencent.biz.richframework.download.v.i(this, call, str, list);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void dnsStart(Call call, String str) {
            com.tencent.biz.richframework.download.v.j(this, call, str);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void requestBodyEnd(Call call, long j3) {
            com.tencent.biz.richframework.download.v.k(this, call, j3);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void requestBodyStart(Call call) {
            com.tencent.biz.richframework.download.v.l(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void requestHeadersEnd(Call call, Request request) {
            com.tencent.biz.richframework.download.v.m(this, call, request);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void requestHeadersStart(Call call) {
            com.tencent.biz.richframework.download.v.n(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void responseBodyEnd(Call call, long j3) {
            com.tencent.biz.richframework.download.v.o(this, call, j3);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void responseBodyStart(Call call) {
            com.tencent.biz.richframework.download.v.p(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void responseHeadersEnd(Call call, Response response) {
            com.tencent.biz.richframework.download.v.q(this, call, response);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void responseHeadersStart(Call call) {
            com.tencent.biz.richframework.download.v.r(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void secureConnectEnd(Call call, Handshake handshake) {
            com.tencent.biz.richframework.download.v.s(this, call, handshake);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void secureConnectStart(Call call) {
            com.tencent.biz.richframework.download.v.t(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
        public void onRspCallback(boolean z16, String str) {
            if (!z16) {
                QQToastUtil.showQQToastInUiThread(0, "\u89c6\u9891\u4fdd\u5b58\u5931\u8d25");
                return;
            }
            QLog.i("QZoneShareQCircleAction", 2, "file path is " + str);
            if (TextUtils.isEmpty(str) || !s.this.L(str)) {
                if (!s.this.L(str)) {
                    QQToastUtil.showQQToastInUiThread(0, "\u89c6\u9891\u683c\u5f0f\u4e0d\u652f\u6301\u5206\u4eab");
                    s.this.i();
                    return;
                } else {
                    s.this.i();
                    return;
                }
            }
            s.this.M("mqqapi://qcircle/openqqpublish?target=3&exit_dialog=1&mediaPath=" + str + ContainerUtils.FIELD_DELIMITER + WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID + ContainerUtils.KEY_VALUE_DELIMITER + s.this.K(this.f58210d));
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
        public void onDownloadProgress(float f16, long j3, long j16) {
        }
    }
}
