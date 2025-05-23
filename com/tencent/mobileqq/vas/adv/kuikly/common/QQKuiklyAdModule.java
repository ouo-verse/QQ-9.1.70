package com.tencent.mobileqq.vas.adv.kuikly.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment;
import com.tencent.ad.tangram.views.feedback.AdFeedbackParams;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import i01.e;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J?\u0010\u0010\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2+\u0010\u000f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nj\u0004\u0018\u0001`\u000eH\u0002J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0002J?\u0010\u0013\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2+\u0010\u000f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nj\u0004\u0018\u0001`\u000eH\u0002JI\u0010\u0016\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2+\u0010\u000f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nj\u0004\u0018\u0001`\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0002J?\u0010\u0017\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2+\u0010\u000f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nj\u0004\u0018\u0001`\u000eH\u0002J=\u0010\u001a\u001a\u00020\u00022+\u0010\u000f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nj\u0004\u0018\u0001`\u000e2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002JI\u0010\u001c\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001b\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042+\u0010\u000f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nj\u0004\u0018\u0001`\u000eH\u0016JI\u0010\u001c\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001b\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2+\u0010\u000f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nj\u0004\u0018\u0001`\u000eH\u0016R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/kuikly/common/QQKuiklyAdModule;", "Li01/e;", "", "l", "", "paramsObject", "", "g", "", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "d", "clickStr", "j", "p", "", "isNeedToJumpApp", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i", "", "retCode", "c", "method", "call", "Lcom/tencent/ad/tangram/views/feedback/AdFeedbackDialogFragment$Listener;", "Lcom/tencent/ad/tangram/views/feedback/AdFeedbackDialogFragment$Listener;", "mAdFeedbackDialogListener", "<init>", "()V", "e", "a", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class QQKuiklyAdModule extends e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AdFeedbackDialogFragment.Listener mAdFeedbackDialogListener;

    private final void c(Function1<Object, Unit> callback, int retCode) {
        QLog.e("QQKuiklyAdModule", 1, "callbackRetCode:", Integer.valueOf(retCode));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ret_code", retCode);
        if (callback != null) {
            callback.invoke(jSONObject);
        }
    }

    private final void d(String params, Function1<Object, Unit> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new QQKuiklyAdModule$getDeviceInfo$1(params, callback, this, null), 3, null);
    }

    private final byte[] g(Object paramsObject) {
        JSONObject jSONObject;
        boolean z16 = false;
        if (paramsObject != null && (paramsObject instanceof Object[])) {
            Object[] objArr = (Object[]) paramsObject;
            if (objArr.length > 0) {
                String str = (String) objArr[0];
                if (!TextUtils.isEmpty(str)) {
                    if (str != null) {
                        jSONObject = new JSONObject(str);
                    } else {
                        jSONObject = null;
                    }
                    if (jSONObject != null) {
                        z16 = jSONObject.optBoolean("is_first_screen");
                    }
                }
            }
        }
        return pz2.b.f428093a.e(z16);
    }

    private final void i(String params, Function1<Object, Unit> callback) {
        Integer valueOf;
        if (TextUtils.isEmpty(params)) {
            c(callback, -1);
            QLog.e("QQKuiklyAdModule", 1, "getViewPosInfo tag parse null");
            return;
        }
        View view = null;
        if (params != null) {
            try {
                valueOf = Integer.valueOf(Integer.parseInt(params));
            } catch (Exception e16) {
                QLog.e("QQKuiklyAdModule", 1, "getViewPosInfo error:", e16);
                c(callback, -2);
                return;
            }
        } else {
            valueOf = null;
        }
        if (valueOf != null) {
            view = viewWithTag(valueOf.intValue());
        }
        if (view == null) {
            QLog.e("QQKuiklyAdModule", 1, "getViewPosInfo error: targetView is null");
            c(callback, -2);
            return;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i3 = iArr[0];
        int i16 = iArr[1];
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ad_left", i3);
        jSONObject.put("ad_top", i16);
        if (callback != null) {
            callback.invoke(jSONObject);
        }
        QLog.d("QQKuiklyAdModule", 1, "getViewPosInfo left:" + i3 + ", top:" + i16);
    }

    private final void j(String clickStr) {
        boolean z16;
        QLog.i("QQKuiklyAdModule", 1, "handleClick");
        if (clickStr != null && clickStr.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("QQKuiklyAdModule", 1, "handleClick clickStr invalid");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(clickStr);
            JSONObject optJSONObject = jSONObject.optJSONObject(QAdVrReport.ElementID.AD_INFO);
            String optString = jSONObject.optString("anti_spam_str");
            if (JSONObject.NULL.equals(optJSONObject)) {
                QLog.e("QQKuiklyAdModule", 1, "adInfoJson paramJSON invalid");
                return;
            }
            qq_ad_get.QQAdGetRsp.AdInfo adInfo = (qq_ad_get.QQAdGetRsp.AdInfo) GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), optJSONObject);
            if (adInfo == null) {
                return;
            }
            boolean optBoolean = jSONObject.optBoolean(AppConstants.Key.NEED_REPORT, true);
            GdtHandler.Params params = new GdtHandler.Params();
            params.f108486ad = new GdtAd(adInfo);
            params.processId = MobileQQ.sProcessId;
            params.activity = new WeakReference<>(getActivity());
            Bundle bundle = new Bundle();
            bundle.putString(LaunchParam.KEY_REF_ID, AdDownloadConstants.DOWNLOAD_SOURCE_AD);
            params.extra = bundle;
            params.directPlay = true;
            params.videoCeilingSupportedIfNotInstalled = true;
            params.reportForClick = optBoolean;
            params.antiSpamParams = optString;
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(params);
        } catch (Throwable th5) {
            QLog.e("QQKuiklyAdModule", 1, "handleClick error, msg: ", th5);
        }
    }

    private final void l() {
        pz2.b.f428093a.b();
    }

    private final void m(String params, Function1<Object, Unit> callback, boolean isNeedToJumpApp) {
        PackageManager packageManager;
        int i3;
        QLog.d("QQKuiklyAdModule", 1, "isSupportJumpScheme, jumpAppSchema:", Boolean.valueOf(isNeedToJumpApp));
        if (TextUtils.isEmpty(params)) {
            c(callback, -1);
            QLog.e("QQKuiklyAdModule", 1, "isSupportJumpScheme url parse null");
            return;
        }
        try {
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
            intent.setData(Uri.parse(params));
            Bundle bundle = new Bundle();
            bundle.putString("big_brother_source_key", AdDownloadConstants.DOWNLOAD_SOURCE_AD);
            intent.putExtras(bundle);
            intent.setFlags(268435456);
            Activity activity = getActivity();
            if (activity != null) {
                packageManager = activity.getPackageManager();
            } else {
                packageManager = null;
            }
            if (packageManager != null) {
                if (packageManager.resolveActivity(intent, 65536) == null) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                if (isNeedToJumpApp && i3 == 1) {
                    if (getActivity() != null) {
                        QLog.d("QQKuiklyAdModule", 1, "jumpAppSchema");
                        Activity activity2 = getActivity();
                        if (activity2 != null) {
                            activity2.startActivity(intent);
                        }
                    } else {
                        i3 = -2;
                    }
                }
                c(callback, i3);
                QLog.d("QQKuiklyAdModule", 1, "isSupportJumpScheme:", Integer.valueOf(i3));
                return;
            }
            c(callback, 0);
            QLog.d("QQKuiklyAdModule", 1, "isSupportJumpScheme:0, pkm is null");
        } catch (Exception e16) {
            QLog.e("QQKuiklyAdModule", 1, "isSupportJumpScheme error:", e16);
            c(callback, -2);
        }
    }

    static /* synthetic */ void o(QQKuiklyAdModule qQKuiklyAdModule, String str, Function1 function1, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        qQKuiklyAdModule.m(str, function1, z16);
    }

    private final void p(String params, final Function1<Object, Unit> callback) {
        QLog.d("QQKuiklyAdModule", 1, "openAdFeedBackDialog");
        if (TextUtils.isEmpty(params)) {
            c(callback, -1);
            return;
        }
        qq_ad_get.QQAdGetRsp.AdInfo adInfo = (qq_ad_get.QQAdGetRsp.AdInfo) GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(params));
        if (adInfo == null) {
            c(callback, -1);
            return;
        }
        this.mAdFeedbackDialogListener = new AdFeedbackDialogFragment.Listener() { // from class: com.tencent.mobileqq.vas.adv.kuikly.common.a
            @Override // com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment.Listener
            public final void onResult(AdFeedbackDialogFragment.Result result) {
                QQKuiklyAdModule.q(QQKuiklyAdModule.this, callback, result);
            }
        };
        AdFeedbackParams adFeedbackParams = new AdFeedbackParams();
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        adFeedbackParams.activity = new WeakReference<>((Activity) context);
        adFeedbackParams.listener = new WeakReference<>(this.mAdFeedbackDialogListener);
        adFeedbackParams.f61346ad = new GdtAd(adInfo);
        adFeedbackParams.isDarkMode = QQTheme.isNowThemeIsNight();
        try {
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).showFeedbackDialogFragment(adFeedbackParams);
        } catch (Throwable th5) {
            QLog.e("QQKuiklyAdModule", 1, "openAdFeedBackDialog error:", th5);
            c(callback, -2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(QQKuiklyAdModule this$0, Function1 function1, AdFeedbackDialogFragment.Result result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (result != null && result.action == 3) {
            this$0.c(function1, 0);
        }
    }

    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable Object params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (Intrinsics.areEqual(method, "getQZoneAdReqParam")) {
            return g(params);
        }
        return super.call(method, params, callback);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -1424175976:
                if (method.equals("isSupportJumpScheme")) {
                    o(this, params, callback, false, 4, null);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1042312825:
                if (method.equals("getViewPosInfo")) {
                    i(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -101765446:
                if (method.equals("openAdFeedBackDialog")) {
                    p(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 483103770:
                if (method.equals("getDeviceInfo")) {
                    d(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1467416640:
                if (method.equals("handleClick")) {
                    j(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1540800148:
                if (method.equals("jumpAppSchema")) {
                    m(params, callback, true);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1941510066:
                if (method.equals("initQZoneAdReqDeviceInfo")) {
                    l();
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            default:
                return super.call(method, params, callback);
        }
    }
}
