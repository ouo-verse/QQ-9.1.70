package com.tencent.mobileqq.qwallet.home;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$AppInfo;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$Declaim;
import com.qwallet.utils.QWalletUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.INewQWalletApi;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.qwallet.home.QWalletHomePreviewController;
import com.tencent.mobileqq.qwallet.home.report.QWalletHomeStep;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tenpay.api.TenpayInterface;
import com.tenpay.idverify.IdVerifyModule;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qwallet.plugin.IActivity;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.PatternLockUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0003J \u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J$\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007JB\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00142\b\b\u0002\u0010\u0019\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u0006H\u0007J\u001e\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J \u0010\u001f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001e\u001a\u00020\fJ\u0018\u0010 \u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/u;", "", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", WadlProxyConsts.CHANNEL, "", tl.h.F, "i", "j", "", DomainData.DOMAIN_NAME, "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$AppInfo;", "appInfo", "f", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$Declaim;", "declaim", "c", "", "actionName", "r2", "r3", "r4", "r5", IProfileCardConst.KEY_FROM_TYPE, "l", "g", "k", "isRealName", "b", "e", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final u f278200a = new u();

    u() {
    }

    @JvmStatic
    public static final void c(@NotNull final Context context, @Nullable final QWalletHomePage$AppInfo appInfo, @Nullable QWalletHomePage$Declaim declaim) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (appInfo == null || f278200a.f(context, appInfo)) {
            return;
        }
        final String str = "home_app_declaim_accept_" + com.tencent.mobileqq.base.a.c() + "_" + c4.a.D(appInfo);
        boolean c16 = com.tencent.mobileqq.qwallet.utils.g.c(str, false);
        final Bundle bundle = new Bundle();
        bundle.putString("key_url_source", INewQWalletApi.QWALLET_SECURITY_WEB_URL_SOURCE);
        String str2 = null;
        Activity activity = null;
        if (appInfo.has_statement.get() && !c16 && declaim != null) {
            if (context instanceof Activity) {
                activity = (Activity) context;
            }
            String str3 = declaim.statement_title.get();
            String str4 = appInfo.company_name.get();
            Intrinsics.checkNotNullExpressionValue(str4, "appInfo.company_name.get()");
            DialogUtil.createDisclaimerDialog(activity, str3, c4.a.f(declaim, str4), declaim.statement_btn_text.get(), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.home.t
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    u.d(str, context, appInfo, bundle, dialogInterface, i3);
                }
            }).show();
            return;
        }
        PBStringField pBStringField = appInfo.url;
        if (pBStringField != null) {
            str2 = pBStringField.get();
        }
        QWalletUtils.l(context, str2, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String key, Context context, QWalletHomePage$AppInfo qWalletHomePage$AppInfo, Bundle bizExtData, DialogInterface dialogInterface, int i3) {
        String str;
        Intrinsics.checkNotNullParameter(key, "$key");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(bizExtData, "$bizExtData");
        com.tencent.mobileqq.qwallet.utils.g.l(key, true);
        PBStringField pBStringField = qWalletHomePage$AppInfo.url;
        if (pBStringField != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        QWalletUtils.l(context, str, bizExtData);
    }

    private final boolean f(Context context, QWalletHomePage$AppInfo appInfo) {
        int i3;
        boolean z16;
        PBInt64Field pBInt64Field;
        if (!((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            return false;
        }
        if (appInfo != null && (pBInt64Field = appInfo.bit_flag) != null) {
            i3 = (int) pBInt64Field.get();
        } else {
            i3 = 0;
        }
        if ((i3 & 1) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        QQToast.makeText(context, "\u672a\u6210\u5e74\u4eba\u6a21\u5f0f\u4e0b\u8be5\u5185\u5bb9\u4e0d\u53ef\u8bbf\u95ee", 0).show();
        return true;
    }

    @Deprecated(message = "\u8001\u7684loading\u6a21\u5f0f\u6253\u5f00\u94b1\u5305\u9996\u9875\uff0c\u540e\u7eed\u53ef\u4ee5\u4e0b\u67b6")
    private final void h(Context context, Intent intent, int channel) {
        if (n(channel)) {
            new b4.a(context, PatternLockUtils.isNeedOpenPatternLock(context, com.tencent.mobileqq.base.a.c())).show();
            intent.putExtra("QWalletHomeFragment.is_loading_dialog_showed", true);
        }
        intent.putExtra(IQWalletHelper.QWALLET_EXTRA_KEY_IS_FLING, false);
        intent.putExtra("KEY_CLICK_ENTRY_BEAN", new QWalletHomeStep.ClickAction(System.currentTimeMillis(), channel, QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:tool")));
        intent.putExtra("QWalletHomeFragment.enum_page_type", QWalletHomePreviewController.EnumEnterMode.NORMAL_WITH_LOADING);
        com.tencent.mobileqq.base.c.f(context, intent, QWalletHomeFragment.class, false, 8, null);
    }

    private final void i(Context context, Intent intent, int channel) {
        intent.putExtra("QWalletHomeFragment.enum_page_type", QWalletHomePreviewController.EnumEnterMode.NORMAL);
        intent.putExtra(IQWalletHelper.QWALLET_EXTRA_KEY_IS_FLING, false);
        intent.putExtra("KEY_CLICK_ENTRY_BEAN", new QWalletHomeStep.ClickAction(System.currentTimeMillis(), channel, QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:tool")));
        com.tencent.mobileqq.base.c.f(context, intent, QWalletHomeFragment.class, false, 8, null);
    }

    private final void j(Context context, Intent intent, int channel) {
        intent.putExtra("QWalletHomeFragment.enum_page_type", QWalletHomePreviewController.EnumEnterMode.PREVIEW);
        intent.putExtra(IQWalletHelper.QWALLET_EXTRA_KEY_IS_FLING, false);
        intent.putExtra("KEY_CLICK_ENTRY_BEAN", new QWalletHomeStep.ClickAction(System.currentTimeMillis(), channel, QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:tool")));
        com.tencent.mobileqq.base.c.e(context, intent, QWalletHomeFragment.class, true);
    }

    @JvmStatic
    public static final void l(@NotNull String actionName, @NotNull String r26, @NotNull String r36, @NotNull String r46, @NotNull String r56, int fromType) {
        Intrinsics.checkNotNullParameter(actionName, "actionName");
        Intrinsics.checkNotNullParameter(r26, "r2");
        Intrinsics.checkNotNullParameter(r36, "r3");
        Intrinsics.checkNotNullParameter(r46, "r4");
        Intrinsics.checkNotNullParameter(r56, "r5");
        com.tencent.mobileqq.qwallet.c.d("", actionName, QCircleDaTongConstant.ElementParamValue.WALLET, fromType, 0, r26, r36, r46, r56);
    }

    public static /* synthetic */ void m(String str, String str2, String str3, String str4, String subVersion, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            str2 = "";
        }
        if ((i16 & 4) != 0) {
            str3 = "";
        }
        if ((i16 & 8) != 0) {
            str4 = "";
        }
        if ((i16 & 16) != 0) {
            subVersion = AppSetting.f99551k;
            Intrinsics.checkNotNullExpressionValue(subVersion, "subVersion");
        }
        if ((i16 & 32) != 0) {
            i3 = 0;
        }
        l(str, str2, str3, str4, subVersion, i3);
    }

    private final boolean n(int channel) {
        if (channel == 3 || channel == 4 || channel == 7 || MobileQQ.sProcessId == 7) {
            return false;
        }
        return true;
    }

    public final void b(@NotNull Context context, @Nullable QWalletHomePage$AppInfo appInfo, boolean isRealName) {
        boolean z16;
        PBStringField pBStringField;
        String str;
        boolean z17;
        Intrinsics.checkNotNullParameter(context, "context");
        if (!isRealName) {
            IdVerifyModule.startFromQWallet(context);
            return;
        }
        if (f(context, appInfo)) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        HomeLegacyBizManager homeLegacyBizManager = HomeLegacyBizManager.f277929d;
        String k3 = homeLegacyBizManager.k();
        String i3 = homeLegacyBizManager.i();
        String str2 = "https://myun.tenpay.com/pages/balance/dist/index.html?_wwv=128&audit=1";
        boolean z18 = false;
        if (appInfo != null && (pBStringField = appInfo.url) != null && (str = pBStringField.get()) != null) {
            if (str.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                str2 = str;
            }
        }
        if (k3 != null && k3.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (i3 == null || i3.length() == 0) {
                z18 = true;
            }
            if (!z18) {
                intent.putExtra("tenpayData", k3);
                intent.putExtra("iapData", i3);
                str2 = Uri.parse(str2).buildUpon().appendQueryParameter("isPreload", "1").build().toString();
                Intrinsics.checkNotNullExpressionValue(str2, "{\n            intent.put\u2026ld().toString()\n        }");
            }
        }
        intent.putExtra("url", str2);
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        intent.putExtra("big_brother_source_key", "biz_src_zf_qianbao");
        context.startActivity(intent);
    }

    public final void e(@NotNull Context context, @Nullable QWalletHomePage$AppInfo appInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (f(context, appInfo)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("entry", "0");
        jSONObject.put(IActivity.PARAM_IS_USE_QWALLET_PATTERN_LOCK, false);
        Bundle bundle = new Bundle();
        bundle.putInt("come_from", 2);
        bundle.putString(com.tencent.mobileqq.msf.core.c0.j.T0, "appid#30000002|bargainor_id#0|channel#POS");
        bundle.putString("extra_data", jSONObject.toString());
        TenpayInterface.gotoView(context, "payCode", com.tencent.mobileqq.base.a.c(), com.tencent.mobileqq.base.a.b(), bundle, null);
    }

    public final void g(@NotNull Context context, @NotNull Intent intent, int channel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (com.tencent.mobileqq.utils.u.a().b()) {
            return;
        }
        QWalletHomeAdvIPCModule.f277953d.j();
        if (!((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).isSwitchOn(IQWalletUnitedConfigApi.QWALLET_HOME_PREVIEW_MODE, false)) {
            h(context, intent, channel);
        } else if (QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:tool")) {
            i(context, intent, channel);
        } else {
            j(context, intent, channel);
        }
    }

    public final void k(@NotNull Context context, @NotNull Intent intent, int channel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        intent.putExtra("QWalletHomeFragment.enum_page_type", QWalletHomePreviewController.EnumEnterMode.TOOL_PAGE);
        intent.putExtra(IQWalletHelper.QWALLET_EXTRA_KEY_IS_FLING, false);
        intent.putExtra("KEY_CLICK_ENTRY_BEAN", new QWalletHomeStep.ClickAction(System.currentTimeMillis(), channel, QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:tool")));
        com.tencent.mobileqq.base.c.f(context, intent, QWalletHomeFragment.class, false, 8, null);
    }
}
