package com.tencent.mobileqq.wink.api.impl;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.sharepanel.api.ISharePanelApi;
import com.tencent.mobileqq.sharepanel.n;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.wink.api.IWinkNewSharePanelApi;
import com.tencent.mobileqq.wink.share.WinkNewSharePanelClickListener;
import com.tencent.mobileqq.wink.share.WinkShareCommonModel;
import com.tencent.mobileqq.wink.share.WinkShareUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J4\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J<\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J \u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\u0012\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/wink/api/impl/WinkNewSharePanelApiImpl;", "Lcom/tencent/mobileqq/wink/api/IWinkNewSharePanelApi;", "", WadlProxyConsts.SCENE_ID, "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/wink/api/d;", "shareConfig", "Lcom/tencent/mobileqq/wink/share/WinkShareCommonModel;", "shareModel", "Lcom/tencent/mobileqq/sharepanel/j;", "onPanelClickListener", "Lcom/tencent/mobileqq/sharepanel/f;", "createPanel", "", "hideRecentContent", "", "showSharePanel", "Lcom/tencent/mobileqq/sharepanel/m;", "callback", "wrapIntent", "<init>", "()V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkNewSharePanelApiImpl implements IWinkNewSharePanelApi {

    @NotNull
    private static final String TAG = "WinkNewSharePanelApiImpl";

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/api/impl/WinkNewSharePanelApiImpl$b", "Lcom/tencent/mobileqq/sharepanel/n;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "Lkotlin/collections/ArrayList;", "targetList", "Lcom/tencent/mobileqq/sharepanel/m;", "callback", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements n {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.wink.api.d f317986b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ WinkShareCommonModel f317987c;

        b(com.tencent.mobileqq.wink.api.d dVar, WinkShareCommonModel winkShareCommonModel) {
            this.f317986b = dVar;
            this.f317987c = winkShareCommonModel;
        }

        @Override // com.tencent.mobileqq.sharepanel.n
        public void a(@NotNull ArrayList<ResultRecord> targetList, @NotNull com.tencent.mobileqq.sharepanel.m callback) {
            Intrinsics.checkNotNullParameter(targetList, "targetList");
            Intrinsics.checkNotNullParameter(callback, "callback");
            WinkNewSharePanelApiImpl.this.wrapIntent(this.f317986b, this.f317987c, callback);
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/api/impl/WinkNewSharePanelApiImpl$c", "Lcom/tencent/mobileqq/sharepanel/b;", "", "success", "", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "targetList", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements com.tencent.mobileqq.sharepanel.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.wink.api.d f317988a;

        c(com.tencent.mobileqq.wink.api.d dVar) {
            this.f317988a = dVar;
        }

        @Override // com.tencent.mobileqq.sharepanel.b
        public void a(boolean success, @NotNull List<? extends ResultRecord> targetList) {
            Intrinsics.checkNotNullParameter(targetList, "targetList");
            QLog.d(WinkNewSharePanelApiImpl.TAG, 1, "onForwardResult " + success);
            Function2<String, Boolean, Unit> a16 = this.f317988a.a();
            if (a16 != null) {
                a16.invoke("qqfriend", Boolean.valueOf(success));
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/wink/api/impl/WinkNewSharePanelApiImpl$d", "Lcom/tencent/mobileqq/sharepanel/k;", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements com.tencent.mobileqq.sharepanel.k {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.wink.api.d f317989a;

        d(com.tencent.mobileqq.wink.api.d dVar) {
            this.f317989a = dVar;
        }

        @Override // com.tencent.mobileqq.sharepanel.k
        public void a() {
            QLog.d(WinkNewSharePanelApiImpl.TAG, 1, "onSharePanelDismiss");
            Function0<Unit> b16 = this.f317989a.b();
            if (b16 != null) {
                b16.invoke();
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkNewSharePanelApi
    @NotNull
    public com.tencent.mobileqq.sharepanel.f createPanel(@NotNull String sceneId, @NotNull FragmentActivity activity, @NotNull com.tencent.mobileqq.wink.api.d shareConfig, @Nullable WinkShareCommonModel shareModel, @Nullable com.tencent.mobileqq.sharepanel.j onPanelClickListener) {
        Intrinsics.checkNotNullParameter(sceneId, "sceneId");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareConfig, "shareConfig");
        return ((ISharePanelApi) QRoute.api(ISharePanelApi.class)).createSharePanel(activity, sceneId).k0(new b(shareConfig, shareModel)).t0(new WinkNewSharePanelClickListener(activity, shareConfig, shareModel, onPanelClickListener)).f0(new c(shareConfig)).n0(new d(shareConfig));
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkNewSharePanelApi
    public void showSharePanel(@NotNull String sceneId, @NotNull FragmentActivity activity, @NotNull com.tencent.mobileqq.wink.api.d shareConfig, @Nullable WinkShareCommonModel shareModel, @Nullable com.tencent.mobileqq.sharepanel.j onPanelClickListener, boolean hideRecentContent) {
        Intrinsics.checkNotNullParameter(sceneId, "sceneId");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareConfig, "shareConfig");
        com.tencent.mobileqq.sharepanel.f createPanel = createPanel(sceneId, activity, shareConfig, shareModel, onPanelClickListener);
        if (shareConfig.getF326335a() == 1) {
            Bitmap c16 = com.tencent.mobileqq.wink.utils.f.c(shareConfig.getShareUrl());
            Intrinsics.checkNotNullExpressionValue(c16, "decodeFile(shareConfig.getShareUrl())");
            createPanel.q0(c16);
        }
        if (hideRecentContent) {
            createPanel.s0().show();
        } else {
            createPanel.show();
        }
    }

    public final void wrapIntent(@NotNull com.tencent.mobileqq.wink.api.d shareConfig, @Nullable WinkShareCommonModel shareModel, @NotNull com.tencent.mobileqq.sharepanel.m callback) {
        String l3;
        String str;
        String string;
        String str2;
        String string2;
        Intrinsics.checkNotNullParameter(shareConfig, "shareConfig");
        Intrinsics.checkNotNullParameter(callback, "callback");
        WinkShareUtils winkShareUtils = new WinkShareUtils();
        int f326335a = shareConfig.getF326335a();
        boolean z16 = true;
        if (f326335a != 1) {
            if (f326335a != 2) {
                callback.onFail();
                return;
            }
            if (shareModel == null) {
                return;
            }
            if (shareModel.getIsNewArkRequest()) {
                String requestArkBusId = shareModel.getRequestArkBusId();
                Intent intent = null;
                String str3 = null;
                if (requestArkBusId != null) {
                    String shareUrl = shareModel.getShareUrl();
                    String title = shareModel.getTitle();
                    String descForQq = shareModel.getDescForQq();
                    if (descForQq == null) {
                        descForQq = shareModel.getDesc();
                    }
                    String preview = shareModel.getPreview();
                    int serviceId = shareModel.getServiceId();
                    Bundle extraParams = shareModel.getExtraParams();
                    if (extraParams == null || (string2 = extraParams.getString("material_id")) == null) {
                        str2 = "";
                    } else {
                        str2 = string2;
                    }
                    Intrinsics.checkNotNullExpressionValue(str2, "shareModel.extraParams?.\u2026EY_TAG_MATERIAL_ID) ?: \"\"");
                    String shareQZoneUrl = shareModel.getShareQZoneUrl();
                    if (shareQZoneUrl != null && shareQZoneUrl.length() != 0) {
                        z16 = false;
                    }
                    if (!z16) {
                        str3 = shareModel.getShareQZoneUrl();
                    }
                    intent = winkShareUtils.E(requestArkBusId, 0, "", shareUrl, title, descForQq, preview, serviceId, str2, str3);
                }
                callback.a(intent);
                return;
            }
            String shareUrl2 = shareModel.getShareUrl();
            String title2 = shareModel.getTitle();
            String desc = shareModel.getDesc();
            String preview2 = shareModel.getPreview();
            int serviceId2 = shareModel.getServiceId();
            Bundle extraParams2 = shareModel.getExtraParams();
            if (extraParams2 == null || (l3 = extraParams2.getString(HiAnalyticsConstant.BI_KEY_SDK_VER)) == null) {
                l3 = winkShareUtils.l();
            }
            String str4 = l3;
            Intrinsics.checkNotNullExpressionValue(str4, "shareModel.extraParams?.\u2026hareUtils.getSdkVersion()");
            Bundle extraParams3 = shareModel.getExtraParams();
            if (extraParams3 == null || (string = extraParams3.getString("material_id")) == null) {
                str = "";
            } else {
                str = string;
            }
            callback.a(WinkShareUtils.f(winkShareUtils, 0, "", shareUrl2, title2, desc, preview2, "2", serviceId2, str4, str, null, 1024, null));
            return;
        }
        String shareUrl3 = shareConfig.getShareUrl();
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 1);
        bundle.putString(AppConstants.Key.FORWARD_FILEPATH, shareUrl3);
        bundle.putString(AppConstants.Key.FORWARD_THUMB, shareUrl3);
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, shareUrl3);
        bundle.putInt("forward_source_business_type", BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD);
        bundle.putBoolean("key_flag_from_plugin", true);
        bundle.putString(AppConstants.Key.FORWARD_EXTRA, shareUrl3);
        Intent intent2 = new Intent();
        intent2.putExtras(bundle);
        callback.a(intent2);
    }
}
