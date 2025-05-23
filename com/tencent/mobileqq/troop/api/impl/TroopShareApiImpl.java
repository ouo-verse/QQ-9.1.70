package com.tencent.mobileqq.troop.api.impl;

import android.content.Intent;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.sharepanel.api.ISharePanelApi;
import com.tencent.mobileqq.troop.api.ITroopShareApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/troop/api/impl/TroopShareApiImpl;", "Lcom/tencent/mobileqq/troop/api/ITroopShareApi;", "", "rspArkMessage", "", "isSwitchOn", "getAppName", "getAppVersion", "getAppView", "getBizSrc", WadlProxyConsts.SCENE_ID, "useNewSharePanel", "isNewShareLinkSwitchOn", "Landroid/content/Intent;", "parseArkJson", "<init>", "()V", "Companion", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopShareApiImpl implements ITroopShareApi {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    private static final String ARK_APP_NAME_TROOP_SHARE = "com.tencent.troopsharecard";

    @NotNull
    private static final String ARK_APP_VER = "1.0.0.30";

    @NotNull
    private static final String ARK_APP_VIEW = "contact";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "TroopShareApiImpl";

    @NotNull
    private static final String TROOP_CONFIG_ID = "106116";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/api/impl/TroopShareApiImpl$a;", "", "", "ARK_APP_NAME_TROOP_SHARE", "Ljava/lang/String;", "ARK_APP_VER", "ARK_APP_VIEW", "TAG", "TROOP_CONFIG_ID", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.api.impl.TroopShareApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24089);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopShareApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String getAppName(String rspArkMessage, boolean isSwitchOn) {
        if (isSwitchOn) {
            return com.tencent.relation.common.utils.c.d(rspArkMessage, null);
        }
        return ARK_APP_NAME_TROOP_SHARE;
    }

    private final String getAppVersion(String rspArkMessage, boolean isSwitchOn) {
        if (isSwitchOn) {
            return com.tencent.relation.common.utils.c.f(rspArkMessage, null);
        }
        return ARK_APP_VER;
    }

    private final String getAppView(String rspArkMessage, boolean isSwitchOn) {
        if (isSwitchOn) {
            return com.tencent.relation.common.utils.c.g(rspArkMessage, null);
        }
        return "contact";
    }

    private final String getBizSrc(String rspArkMessage, boolean isSwitchOn) {
        if (!isSwitchOn) {
            return null;
        }
        return com.tencent.relation.common.utils.c.a(rspArkMessage, null);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopShareApi
    public boolean isNewShareLinkSwitchOn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106109", true);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopShareApi
    @NotNull
    public Intent parseArkJson(@Nullable String rspArkMessage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Intent) iPatchRedirector.redirect((short) 4, (Object) this, (Object) rspArkMessage);
        }
        Intent intent = new Intent();
        if (rspArkMessage == null) {
            return intent;
        }
        try {
            intent.putExtra("forward_type", 53);
            intent.putExtra("is_ark_display_share", true);
            intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 1);
            boolean isNewShareLinkSwitchOn = ((ITroopShareApi) QRoute.api(ITroopShareApi.class)).isNewShareLinkSwitchOn();
            String appName = getAppName(rspArkMessage, isNewShareLinkSwitchOn);
            if (appName != null) {
                intent.putExtra("forward_ark_app_name", appName);
            } else {
                appName = null;
            }
            String appVersion = getAppVersion(rspArkMessage, isNewShareLinkSwitchOn);
            if (appVersion != null) {
                intent.putExtra("forward_ark_app_ver", appVersion);
            } else {
                appVersion = null;
            }
            String appView = getAppView(rspArkMessage, isNewShareLinkSwitchOn);
            if (appView != null) {
                intent.putExtra("forward_ark_app_view", appView);
            } else {
                appView = null;
            }
            String bizSrc = getBizSrc(rspArkMessage, isNewShareLinkSwitchOn);
            if (bizSrc != null) {
                intent.putExtra("forward_ark_biz_src", bizSrc);
            }
            String e16 = com.tencent.relation.common.utils.c.e(rspArkMessage, null);
            if (e16 != null) {
                intent.putExtra("forward_ark_app_prompt", e16);
            }
            String b16 = com.tencent.relation.common.utils.c.b(rspArkMessage);
            if (b16 != null) {
                intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_CONFIG, b16);
            }
            intent.putExtra("k_dataline", false);
            String c16 = com.tencent.relation.common.utils.c.c(rspArkMessage);
            intent.putExtra("forward_ark_app_meta", c16);
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 1, "getTroopCardShareArkIntent: rspArkMessage\uff1a" + rspArkMessage);
            }
            intent.putExtras(QQCustomArkDialogUtil.zipArgs(appName, appView, appVersion, c16, MobileQQ.sMobileQQ.getApplicationContext().getResources().getDisplayMetrics().density, null, null));
        } catch (Exception e17) {
            QLog.e(TAG, 1, "parseArkJson exception:" + e17, e17);
        }
        return intent;
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopShareApi
    public boolean useNewSharePanel(@NotNull String sceneId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) sceneId)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(sceneId, "sceneId");
        if (!((ISharePanelApi) QRoute.api(ISharePanelApi.class)).useNewSharePanel(sceneId)) {
            return false;
        }
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(TROOP_CONFIG_ID, true);
    }
}
