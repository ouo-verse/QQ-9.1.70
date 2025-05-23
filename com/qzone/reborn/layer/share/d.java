package com.qzone.reborn.layer.share;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.qzone.business.share.ShareUtils;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.util.ToastUtil;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.vas.theme.ThemeSwitchUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import com.tencent.util.QQToastUtil;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.ShareArkInfo;
import cooperation.qzone.model.VideoInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class d extends c {

    /* renamed from: k, reason: collision with root package name */
    private Handler f58171k;

    /* renamed from: l, reason: collision with root package name */
    private int f58172l;

    /* renamed from: m, reason: collision with root package name */
    private long f58173m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b extends Handler {
        b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == -1) {
                d.this.i();
                QZLog.i(QZLog.TO_DEVICE_TAG, 1, "forwardPictureForChat copyPictures-save error: unknown");
                d.this.f58172l = 0;
                d.this.f58173m = -1L;
                return;
            }
            if (i3 == 1) {
                d.this.i();
                ToastUtil.o(R.string.gk7, 4);
                d.this.f58172l = 0;
                d.this.f58173m = -1L;
                return;
            }
            if (i3 == 2) {
                d.this.i();
                Object obj = message.obj;
                if (obj != null && (obj instanceof String)) {
                    d.this.S((String) obj);
                }
                QZLog.d("QZoneFeedxSharePicToQQChat", 1, "forwardPictureForChat time cost:" + (System.currentTimeMillis() - d.this.f58173m));
                d.this.f58172l = 0;
                d.this.f58173m = -1L;
                return;
            }
            if (i3 == 3) {
                d.this.i();
                ToastUtil.o(R.string.gk6, 4);
                d.this.f58172l = 0;
                d.this.f58173m = -1L;
                return;
            }
            if (i3 != 4) {
                return;
            }
            Dialog dialog = d.this.f58106a;
            if (dialog == null || !dialog.isShowing()) {
                d.this.B(com.qzone.util.l.a(R.string.jzl));
            }
        }
    }

    public d(Activity activity) {
        super(activity);
        this.f58173m = -1L;
    }

    public static void V(Activity activity, PhotoInfo photoInfo, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, boolean z16) {
        VideoInfo videoInfo = photoInfo.videodata;
        if (videoInfo == null || videoInfo.videoUrl == null) {
            return;
        }
        ShareUtils.e eVar = new ShareUtils.e();
        eVar.f44741b = photoInfo.shareTitle;
        eVar.f44742c = photoInfo.shareSummary;
        eVar.f44743d = photoInfo.sharePhotoUrl;
        eVar.f44740a = photoInfo.shareQqUrl;
        eVar.f44716m = z16;
        ShareArkInfo shareArkInfo = photoInfo.shareArkInfo;
        if (shareArkInfo != null) {
            String str = shareArkInfo.mArkContent;
            eVar.f44722s = str;
            eVar.f44721r = shareArkInfo.mViewId;
            eVar.f44720q = shareArkInfo.mArkId;
            if (!TextUtils.isEmpty(str)) {
                eVar.b(eVar.f44722s, eVar.f44720q, eVar.f44721r);
            }
        }
        if (z16 && !TextUtils.isEmpty(actionSheetItem.uin)) {
            eVar.f44717n = X(photoInfo, actionSheetItem);
            eVar.f44718o = actionSheetItem.uinType;
        }
        ShareUtils.n(activity, eVar, 0);
    }

    private void W(f fVar) {
        if (J()) {
            M();
            return;
        }
        int x16 = tk.h.x(fVar.f58179c, fVar.f58180d);
        if (x16 == 0) {
            V(n(), this.f58109d, this.f58114i, Y());
        } else {
            if (x16 != 4) {
                return;
            }
            N(fVar);
        }
    }

    @Override // com.qzone.reborn.layer.share.c
    protected void G(f fVar) {
        V(n(), this.f58109d, this.f58114i, Y());
    }

    @Override // com.qzone.reborn.layer.share.c
    protected void L(Bundle bundle) {
        PhotoInfo photoInfo = this.f58109d;
        if (photoInfo == null || photoInfo.videodata == null) {
            return;
        }
        V(n(), this.f58109d, this.f58114i, Y());
    }

    protected boolean R() {
        if (!tk.k.f436438a.a(this.f58109d)) {
            QLog.i("QZoneFeedxSharePicToQQChat", 1, "not allow to use new download policy");
            return false;
        }
        if (AppSetting.isDebugVersion()) {
            return gd.a.f401926a.c("KEY_ENABLE_NEW_LAYER_SHARE_PIC", true);
        }
        boolean V = com.qzone.reborn.configx.g.f53821a.b().V();
        QLog.i("QZoneFeedxSharePicToQQChat", 1, "cang lan switch is " + V);
        return V;
    }

    protected abstract void S(String str);

    public void T(f fVar) {
        if (R()) {
            U();
            return;
        }
        if (this.f58173m == -1) {
            this.f58173m = System.currentTimeMillis();
        }
        LpReportInfo_pf00064.report(301, 8, 2);
        if (this.f58171k == null) {
            this.f58171k = new b();
        }
        f(4, VFSAssistantUtils.getSDKPrivatePath("photo/"), this.f58171k);
    }

    public void U() {
        String str;
        PhotoInfo photoInfo = this.f58109d;
        if (photoInfo == null) {
            return;
        }
        if (!TextUtils.isEmpty(photoInfo.downloadUrl)) {
            str = this.f58109d.downloadUrl;
        } else {
            str = this.f58109d.bigUrl;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        B(com.qzone.util.l.a(R.string.jzl));
        RFWDownloaderFactory.getDownloader(new u6.c()).download(str, new a());
    }

    protected boolean Y() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.share.c, com.qzone.reborn.layer.share.QZoneBaseShareAction
    public void x(Message message) {
        super.x(message);
        QZoneResult unpack = QZoneResult.unpack(message);
        if (unpack != null && unpack.what == 1000067) {
            T(this.f58107b);
        }
    }

    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    void j(f fVar, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        String str;
        String str2;
        String str3;
        PhotoInfo photoInfo;
        if (fVar != null && (photoInfo = fVar.f58179c) != null) {
            if (photoInfo.isVideo()) {
                W(fVar);
            } else {
                T(fVar);
            }
            ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", "29", true);
            return;
        }
        int i3 = RFWLog.USR;
        Object[] objArr = new Object[1];
        StringBuilder sb5 = new StringBuilder();
        sb5.append("invalid share context, ");
        if (fVar != null && fVar.f58180d != null) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(" curKey is ");
            String str4 = "";
            if (TextUtils.isEmpty(fVar.f58180d.curKey)) {
                str2 = "";
            } else {
                str2 = fVar.f58180d.curKey;
            }
            sb6.append(str2);
            sb6.append(" ugcKey is ");
            if (TextUtils.isEmpty(fVar.f58180d.ugcKey)) {
                str3 = "";
            } else {
                str3 = fVar.f58180d.ugcKey;
            }
            sb6.append(str3);
            sb6.append(" cellId is ");
            if (!TextUtils.isEmpty(fVar.f58180d.cell_id)) {
                str4 = fVar.f58180d.cell_id;
            }
            sb6.append(str4);
            str = sb6.toString();
        } else {
            str = "all info is null";
        }
        sb5.append(str);
        objArr[0] = sb5.toString();
        RFWLog.e("QZoneFeedxSharePicToQQChat", i3, objArr);
    }

    private static long X(PhotoInfo photoInfo, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        long parseLong;
        long j3 = 0;
        if (actionSheetItem != null) {
            try {
                if (!TextUtils.isEmpty(actionSheetItem.uin)) {
                    parseLong = Long.parseLong(actionSheetItem.uin);
                    j3 = parseLong;
                    return j3;
                }
            } catch (Exception e16) {
                RFWLog.e("QZoneFeedxSharePicToQQChat", RFWLog.USR, "exception is " + e16);
                return j3;
            }
        }
        if (photoInfo == null || photoInfo.videodata == null) {
            return 0L;
        }
        parseLong = photoInfo.uploaduin;
        j3 = parseLong;
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements RFWDownloader.RFWDownloadListener {
        a() {
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

        @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
        public void onRspCallback(boolean z16, String str) {
            d.this.i();
            if (!z16) {
                QQToastUtil.showQQToastInUiThread(4, "\u590d\u5236\u56fe\u7247\u5931\u8d25\uff0c\u6682\u65f6\u4e0d\u80fd\u8f6c\u53d1\u7ed9\u597d\u53cb");
            } else {
                d.this.S(str);
            }
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
        public void onDownloadProgress(float f16, long j3, long j16) {
        }
    }
}
