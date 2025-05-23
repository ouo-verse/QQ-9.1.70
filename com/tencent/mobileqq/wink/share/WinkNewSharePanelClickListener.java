package com.tencent.mobileqq.wink.share;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.util.Consumer;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.richframework.util.RFWSaveUtil;
import com.tencent.biz.richframework.util.bean.RFWSaveMediaResultBean;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqfavor.api.IQQFavHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001\u0010B+\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000eH\u0016R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0017R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/wink/share/WinkNewSharePanelClickListener;", "Lcom/tencent/mobileqq/sharepanel/j;", "", "g", "l", "i", DomainData.DOMAIN_NAME, "j", "p", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "", "channelId", "a", "actionId", "b", "Landroid/app/Activity;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/wink/api/d;", "Lcom/tencent/mobileqq/wink/api/d;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/wink/share/WinkShareCommonModel;", "c", "Lcom/tencent/mobileqq/wink/share/WinkShareCommonModel;", "shareModel", "d", "Lcom/tencent/mobileqq/sharepanel/j;", "onPanelClickListener", "Lcom/tencent/mobileqq/wink/share/WinkShareUtils;", "e", "Lcom/tencent/mobileqq/wink/share/WinkShareUtils;", "winkShareUtils", "<init>", "(Landroid/app/Activity;Lcom/tencent/mobileqq/wink/api/d;Lcom/tencent/mobileqq/wink/share/WinkShareCommonModel;Lcom/tencent/mobileqq/sharepanel/j;)V", "f", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkNewSharePanelClickListener implements com.tencent.mobileqq.sharepanel.j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.wink.api.d config;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final WinkShareCommonModel shareModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.mobileqq.sharepanel.j onPanelClickListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WinkShareUtils winkShareUtils;

    public WinkNewSharePanelClickListener(@NotNull Activity activity, @NotNull com.tencent.mobileqq.wink.api.d config, @Nullable WinkShareCommonModel winkShareCommonModel, @Nullable com.tencent.mobileqq.sharepanel.j jVar) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(config, "config");
        this.activity = activity;
        this.config = config;
        this.shareModel = winkShareCommonModel;
        this.onPanelClickListener = jVar;
        this.winkShareUtils = new WinkShareUtils();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(final WinkNewSharePanelClickListener this$0, final RFWSaveMediaResultBean rFWSaveMediaResultBean) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.share.g
            @Override // java.lang.Runnable
            public final void run() {
                WinkNewSharePanelClickListener.f(WinkNewSharePanelClickListener.this, rFWSaveMediaResultBean);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(WinkNewSharePanelClickListener this$0, RFWSaveMediaResultBean rFWSaveMediaResultBean) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function2<String, Boolean, Unit> a16 = this$0.config.a();
        if (a16 != null) {
            boolean z16 = false;
            if (rFWSaveMediaResultBean != null && rFWSaveMediaResultBean.isSuccess) {
                z16 = true;
            }
            a16.invoke("save_to_phone", Boolean.valueOf(z16));
        }
    }

    private final void g() {
        String l3;
        String str;
        Intent f16;
        String string;
        String str2;
        String string2;
        boolean z16;
        WinkShareCommonModel winkShareCommonModel = this.shareModel;
        if (winkShareCommonModel == null) {
            w53.b.c("WinkNewSharePanelClickListener", "shareArkToQQ fail: shareModel is null");
            Function2<String, Boolean, Unit> a16 = this.config.a();
            if (a16 != null) {
                a16.invoke("qqfriend", Boolean.FALSE);
                return;
            }
            return;
        }
        if (winkShareCommonModel.getIsNewArkRequest()) {
            String requestArkBusId = this.shareModel.getRequestArkBusId();
            if (requestArkBusId != null && requestArkBusId.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                w53.b.c("WinkNewSharePanelClickListener", "shareArkToQQ fail: new ark requestArkBusId is null");
                Function2<String, Boolean, Unit> a17 = this.config.a();
                if (a17 != null) {
                    a17.invoke("qqfriend", Boolean.FALSE);
                    return;
                }
                return;
            }
        }
        if (this.shareModel.getIsNewArkRequest()) {
            WinkShareUtils winkShareUtils = this.winkShareUtils;
            String requestArkBusId2 = this.shareModel.getRequestArkBusId();
            Intrinsics.checkNotNull(requestArkBusId2);
            String shareUrl = this.shareModel.getShareUrl();
            String title = this.shareModel.getTitle();
            String descForQq = this.shareModel.getDescForQq();
            if (descForQq == null) {
                descForQq = this.shareModel.getDesc();
            }
            String str3 = descForQq;
            String preview = this.shareModel.getPreview();
            int serviceId = this.shareModel.getServiceId();
            Bundle extraParams = this.shareModel.getExtraParams();
            if (extraParams == null || (string2 = extraParams.getString("material_id")) == null) {
                str2 = "";
            } else {
                str2 = string2;
            }
            f16 = WinkShareUtils.F(winkShareUtils, requestArkBusId2, 0, "", shareUrl, title, str3, preview, serviceId, str2, null, 512, null);
        } else {
            WinkShareUtils winkShareUtils2 = this.winkShareUtils;
            String shareUrl2 = this.shareModel.getShareUrl();
            String title2 = this.shareModel.getTitle();
            String desc = this.shareModel.getDesc();
            String preview2 = this.shareModel.getPreview();
            int serviceId2 = this.shareModel.getServiceId();
            Bundle extraParams2 = this.shareModel.getExtraParams();
            if (extraParams2 == null || (l3 = extraParams2.getString(HiAnalyticsConstant.BI_KEY_SDK_VER)) == null) {
                l3 = this.winkShareUtils.l();
            }
            Intrinsics.checkNotNullExpressionValue(l3, "shareModel.extraParams?.\u2026hareUtils.getSdkVersion()");
            Bundle extraParams3 = this.shareModel.getExtraParams();
            if (extraParams3 == null || (string = extraParams3.getString("material_id")) == null) {
                str = "";
            } else {
                str = string;
            }
            f16 = WinkShareUtils.f(winkShareUtils2, -1, null, shareUrl2, title2, desc, preview2, "2", serviceId2, l3, str, null, 1024, null);
        }
        this.winkShareUtils.r(this.activity, false, f16, this.shareModel.getRequestQQId(), true);
    }

    private final void h() {
        boolean z16;
        String shareQZoneUrl;
        WinkShareCommonModel winkShareCommonModel = this.shareModel;
        if (winkShareCommonModel == null) {
            w53.b.c("WinkNewSharePanelClickListener", "shareArkToQQGuild fail: shareModel is null");
            Function2<String, Boolean, Unit> a16 = this.config.a();
            if (a16 != null) {
                a16.invoke("qqchannel", Boolean.FALSE);
                return;
            }
            return;
        }
        String shareQZoneUrl2 = winkShareCommonModel.getShareQZoneUrl();
        if (shareQZoneUrl2 != null && shareQZoneUrl2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            shareQZoneUrl = this.shareModel.getShareUrl();
        } else {
            shareQZoneUrl = this.shareModel.getShareQZoneUrl();
            Intrinsics.checkNotNull(shareQZoneUrl);
        }
        this.winkShareUtils.u(this.activity, shareQZoneUrl, this.shareModel.getTitle(), this.shareModel.getDesc(), this.shareModel.getPreview(), this.shareModel.getRequestGuildId(), this.shareModel.getServiceId());
    }

    private final void i() {
        boolean z16;
        String shareQZoneUrl;
        WinkShareCommonModel winkShareCommonModel = this.shareModel;
        if (winkShareCommonModel == null) {
            w53.b.c("WinkNewSharePanelClickListener", "shareArkToQZone fail: shareModel is null");
            Function2<String, Boolean, Unit> a16 = this.config.a();
            if (a16 != null) {
                a16.invoke("qzoneshuoshuo", Boolean.FALSE);
                return;
            }
            return;
        }
        String shareQZoneUrl2 = winkShareCommonModel.getShareQZoneUrl();
        if (shareQZoneUrl2 != null && shareQZoneUrl2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            shareQZoneUrl = this.shareModel.getShareUrl();
        } else {
            shareQZoneUrl = this.shareModel.getShareQZoneUrl();
            Intrinsics.checkNotNull(shareQZoneUrl);
        }
        String str = shareQZoneUrl;
        WinkShareUtils winkShareUtils = this.winkShareUtils;
        Activity activity = this.activity;
        String title = this.shareModel.getTitle();
        String descForQq = this.shareModel.getDescForQq();
        if (descForQq == null) {
            descForQq = this.shareModel.getDesc();
        }
        winkShareUtils.C(activity, str, title, descForQq, this.shareModel.getPreview(), this.shareModel.getRequestQZoneId());
    }

    private final void j() {
        boolean z16;
        String shareExternalUrl;
        WinkShareCommonModel winkShareCommonModel = this.shareModel;
        if (winkShareCommonModel == null) {
            w53.b.c("WinkNewSharePanelClickListener", "shareArkToWechat fail: shareModel is null");
            Function2<String, Boolean, Unit> a16 = this.config.a();
            if (a16 != null) {
                a16.invoke("weixin", Boolean.FALSE);
                return;
            }
            return;
        }
        String shareExternalUrl2 = winkShareCommonModel.getShareExternalUrl();
        if (shareExternalUrl2 != null && shareExternalUrl2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            shareExternalUrl = this.shareModel.getShareUrl();
        } else {
            shareExternalUrl = this.shareModel.getShareExternalUrl();
            Intrinsics.checkNotNull(shareExternalUrl);
        }
        this.winkShareUtils.n(new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.share.WinkNewSharePanelClickListener$shareArkToWechat$1$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z17) {
                w53.b.f("WinkNewSharePanelClickListener", "wxChatShareCallback isSuccess: " + z17);
            }
        });
        boolean w3 = WinkShareUtils.w(this.winkShareUtils, this.activity, shareExternalUrl, this.shareModel.getTitle(), this.shareModel.getDesc(), this.shareModel.getPreview(), false, 32, null);
        Function2<String, Boolean, Unit> a17 = this.config.a();
        if (a17 != null) {
            a17.invoke("weixin", Boolean.valueOf(w3));
        }
    }

    private final void k() {
        boolean z16;
        String shareExternalUrl;
        WinkShareCommonModel winkShareCommonModel = this.shareModel;
        if (winkShareCommonModel == null) {
            w53.b.c("WinkNewSharePanelClickListener", "shareArkToWechatCircle fail: shareModel is null");
            Function2<String, Boolean, Unit> a16 = this.config.a();
            if (a16 != null) {
                a16.invoke("weixincircle", Boolean.FALSE);
                return;
            }
            return;
        }
        String shareExternalUrl2 = winkShareCommonModel.getShareExternalUrl();
        if (shareExternalUrl2 != null && shareExternalUrl2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            shareExternalUrl = this.shareModel.getShareUrl();
        } else {
            shareExternalUrl = this.shareModel.getShareExternalUrl();
            Intrinsics.checkNotNull(shareExternalUrl);
        }
        boolean v3 = this.winkShareUtils.v(this.activity, shareExternalUrl, this.shareModel.getTitle(), this.shareModel.getDesc(), this.shareModel.getPreview(), true);
        Function2<String, Boolean, Unit> a17 = this.config.a();
        if (a17 != null) {
            a17.invoke("weixincircle", Boolean.valueOf(v3));
        }
    }

    private final void l() {
        int i3;
        WinkShareUtils winkShareUtils = this.winkShareUtils;
        Activity activity = this.activity;
        String shareUrl = this.config.getShareUrl();
        WinkShareCommonModel winkShareCommonModel = this.shareModel;
        if (winkShareCommonModel != null) {
            i3 = winkShareCommonModel.getRequestQQId();
        } else {
            i3 = 0;
        }
        winkShareUtils.x(activity, shareUrl, null, i3, true);
    }

    private final void m() {
        int i3;
        WinkShareUtils winkShareUtils = this.winkShareUtils;
        Activity activity = this.activity;
        String shareUrl = this.config.getShareUrl();
        WinkShareCommonModel winkShareCommonModel = this.shareModel;
        if (winkShareCommonModel != null) {
            i3 = winkShareCommonModel.getRequestQQId();
        } else {
            i3 = 0;
        }
        winkShareUtils.z(activity, shareUrl, i3);
    }

    private final void n() {
        int i3;
        Bundle bundle;
        WinkShareUtils winkShareUtils = this.winkShareUtils;
        Activity activity = this.activity;
        String shareUrl = this.config.getShareUrl();
        WinkShareCommonModel winkShareCommonModel = this.shareModel;
        if (winkShareCommonModel != null) {
            i3 = winkShareCommonModel.getRequestQZoneId();
        } else {
            i3 = 0;
        }
        WinkShareCommonModel winkShareCommonModel2 = this.shareModel;
        if (winkShareCommonModel2 == null || (bundle = winkShareCommonModel2.getQzonePublishParams()) == null) {
            bundle = new Bundle();
        }
        winkShareUtils.A(activity, shareUrl, i3, bundle);
    }

    private final void o() {
        HashMap<String, Serializable> hashMapOf;
        int i3;
        Bundle extraParams;
        ArrayList<LocalMediaInfo> arrayList = new ArrayList<>();
        LocalMediaInfo c16 = ba3.a.c(this.config.getShareUrl());
        int i16 = 0;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(AECameraConstants.MEDIA_FROM, AECameraConstants.MEDIA_FROM_EDIT));
        c16.extData = hashMapOf;
        arrayList.add(c16);
        WinkShareCommonModel winkShareCommonModel = this.shareModel;
        if (winkShareCommonModel != null && (extraParams = winkShareCommonModel.getExtraParams()) != null) {
            i3 = extraParams.getInt(WinkShareCommonModel.EXTRA_PARAMS_QZONE_ALBUM_COME_FROM);
        } else {
            i3 = 0;
        }
        IQZoneApiProxy iQZoneApiProxy = (IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class);
        Activity activity = this.activity;
        Bundle bundle = new Bundle();
        WinkShareCommonModel winkShareCommonModel2 = this.shareModel;
        if (winkShareCommonModel2 != null) {
            i16 = winkShareCommonModel2.getRequestQZoneAlbumId();
        }
        iQZoneApiProxy.launchQZoneUploadPhotoPage(activity, arrayList, "", i3, bundle, i16);
    }

    private final void p() {
        String shareUrl;
        WinkShareUtils winkShareUtils = this.winkShareUtils;
        Activity activity = this.activity;
        WinkShareCommonModel winkShareCommonModel = this.shareModel;
        if (winkShareCommonModel == null || (shareUrl = winkShareCommonModel.getSharePathForOutChannel()) == null) {
            shareUrl = this.config.getShareUrl();
        }
        boolean B = winkShareUtils.B(activity, shareUrl, false);
        Function2<String, Boolean, Unit> a16 = this.config.a();
        if (a16 != null) {
            a16.invoke("weixin", Boolean.valueOf(B));
        }
    }

    private final void q() {
        String shareUrl;
        WinkShareUtils winkShareUtils = this.winkShareUtils;
        Activity activity = this.activity;
        WinkShareCommonModel winkShareCommonModel = this.shareModel;
        if (winkShareCommonModel == null || (shareUrl = winkShareCommonModel.getSharePathForOutChannel()) == null) {
            shareUrl = this.config.getShareUrl();
        }
        boolean B = winkShareUtils.B(activity, shareUrl, true);
        Function2<String, Boolean, Unit> a16 = this.config.a();
        if (a16 != null) {
            a16.invoke("weixincircle", Boolean.valueOf(B));
        }
    }

    @Override // com.tencent.mobileqq.sharepanel.j
    public void a(@NotNull String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        int f326335a = this.config.getF326335a();
        if (f326335a != 1) {
            if (f326335a == 2) {
                switch (channelId.hashCode()) {
                    case -791575966:
                        if (channelId.equals("weixin")) {
                            j();
                            break;
                        }
                        break;
                    case -393543490:
                        if (channelId.equals("qqfriend")) {
                            g();
                            break;
                        }
                        break;
                    case -304161157:
                        if (channelId.equals("qzoneshuoshuo")) {
                            i();
                            break;
                        }
                        break;
                    case 154627506:
                        if (channelId.equals("weixincircle")) {
                            k();
                            break;
                        }
                        break;
                    case 2024098531:
                        if (channelId.equals("qqchannel")) {
                            h();
                            break;
                        }
                        break;
                }
            }
        } else {
            w53.b.f("WinkNewSharePanelClickListener", "onShareChannelClick shareType: " + this.config.getF326335a());
            switch (channelId.hashCode()) {
                case -791575966:
                    if (channelId.equals("weixin")) {
                        p();
                        break;
                    }
                    break;
                case -393543490:
                    if (channelId.equals("qqfriend")) {
                        l();
                        break;
                    }
                    break;
                case -304161157:
                    if (channelId.equals("qzoneshuoshuo")) {
                        n();
                        break;
                    }
                    break;
                case -193284878:
                    if (channelId.equals(QCircleScheme.AttrQQPublish.PICKER_QZONE_ALBUM)) {
                        o();
                        break;
                    }
                    break;
                case 154627506:
                    if (channelId.equals("weixincircle")) {
                        q();
                        break;
                    }
                    break;
                case 2024098531:
                    if (channelId.equals("qqchannel")) {
                        m();
                        break;
                    }
                    break;
            }
        }
        com.tencent.mobileqq.sharepanel.j jVar = this.onPanelClickListener;
        if (jVar != null) {
            jVar.a(channelId);
        }
    }

    @Override // com.tencent.mobileqq.sharepanel.j
    public void b(@NotNull String actionId) {
        AppRuntime peekAppRuntime;
        Intrinsics.checkNotNullParameter(actionId, "actionId");
        w53.b.f("WinkNewSharePanelClickListener", "onAppendActionClick shareType: " + actionId);
        int hashCode = actionId.hashCode();
        if (hashCode != -2010036582) {
            if (hashCode != -1052216532) {
                if (hashCode == 1050790300 && actionId.equals("favorite") && (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) != null) {
                    ((IQQFavHelper) peekAppRuntime.getRuntimeService(IQQFavHelper.class, "all")).addPictureToFavorite(peekAppRuntime, this.activity, this.config.getShareUrl());
                }
            } else if (actionId.equals("save_to_phone")) {
                w53.b.f("WinkNewSharePanelClickListener", "onItemClick to SAVE");
                RFWSaveUtil.insertMedia(BaseApplication.context, this.config.getShareUrl(), new Consumer() { // from class: com.tencent.mobileqq.wink.share.f
                    @Override // androidx.core.util.Consumer
                    public final void accept(Object obj) {
                        WinkNewSharePanelClickListener.e(WinkNewSharePanelClickListener.this, (RFWSaveMediaResultBean) obj);
                    }
                });
            }
        } else if (actionId.equals("recognize_qr_code")) {
            Intent intent = new Intent();
            intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", this.config.getShareUrl());
            intent.putExtra("detectType", 1);
            intent.putExtra("fromPicQRDecode", true);
            String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
            try {
                String buildQRScanReportParams = ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).buildQRScanReportParams(null, null, null, account, account, 10);
                Intrinsics.checkNotNullExpressionValue(buildQRScanReportParams, "api<IScanUtilApi>(IScanU\u2026ll, null, uin, uin, type)");
                intent.putExtra("report_params", buildQRScanReportParams);
            } catch (Throwable th5) {
                QLog.e("WinkNewSharePanelClickListener", 1, "onQRDecodeSucceed error:" + th5.getMessage());
            }
            RouteUtils.startActivity(this.activity, intent, "/qrscan/scanner");
        }
        com.tencent.mobileqq.sharepanel.j jVar = this.onPanelClickListener;
        if (jVar != null) {
            jVar.b(actionId);
        }
    }
}
