package com.tencent.mobileqq.sharepanel.api.impl;

import androidx.fragment.app.FragmentActivity;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.sharepanel.api.ISharePanelApi;
import com.tencent.mobileqq.sharepanel.config.united.a;
import com.tencent.mobileqq.sharepanel.f;
import com.tencent.mobileqq.sharepanel.launcher.ipc.t;
import com.tencent.mobileqq.sharepanel.q;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0017J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/api/impl/SharePanelApiImpl;", "Lcom/tencent/mobileqq/sharepanel/api/ISharePanelApi;", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", WadlProxyConsts.SCENE_ID, "Lcom/tencent/mobileqq/sharepanel/f;", "createSharePanel", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "getIPCModule", "", "useNewSharePanel", "<init>", "()V", "Companion", "a", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SharePanelApiImpl implements ISharePanelApi {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    private static final String CONFIG_SHARE_PANEL_CONFIG = "qq_share_panel_config";

    @NotNull
    private static final String CONFIG_SHARE_PANEL_SWITCH = "qq_share_panel_switch";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String SHARE_PANEL_DEBUG_SWITCH = "qq_share_panel_debug_switch";

    @NotNull
    public static final String SHARE_PANEL_SCENE_DEBUG_SWITCH = "qq_share_panel_debug_switch_scene_";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/api/impl/SharePanelApiImpl$a;", "", "", "a", "", WadlProxyConsts.SCENE_ID, "b", "CONFIG_SHARE_PANEL_CONFIG", "Ljava/lang/String;", "CONFIG_SHARE_PANEL_SWITCH", "SHARE_PANEL_DEBUG_SWITCH", "SHARE_PANEL_SCENE_DEBUG_SWITCH", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.sharepanel.api.impl.SharePanelApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(SharePanelApiImpl.CONFIG_SHARE_PANEL_SWITCH, false);
        }

        public final boolean b(@NotNull String sceneId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) sceneId)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(sceneId, "sceneId");
            a aVar = (a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(SharePanelApiImpl.CONFIG_SHARE_PANEL_CONFIG);
            if (aVar != null && aVar.a().contains(sceneId)) {
                return false;
            }
            return true;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31779);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SharePanelApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.sharepanel.api.ISharePanelApi
    @NotNull
    public f createSharePanel(@NotNull FragmentActivity activity, @NotNull String sceneId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (f) iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) sceneId);
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(sceneId, "sceneId");
        return new q(activity, sceneId);
    }

    @Override // com.tencent.mobileqq.sharepanel.api.ISharePanelApi
    @NotNull
    public QIPCModule getIPCModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (QIPCModule) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return t.f287412d;
    }

    @Override // com.tencent.mobileqq.sharepanel.api.ISharePanelApi
    @Deprecated(message = "\u8bf7\u76f4\u63a5\u4f7f\u7528\u4e1a\u52a1\u63a5\u5165\u5f00\u5173", replaceWith = @ReplaceWith(expression = "useNewSharePanel(sceneId: String)", imports = {}))
    public boolean useNewSharePanel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? INSTANCE.a() : ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
    }

    @Override // com.tencent.mobileqq.sharepanel.api.ISharePanelApi
    public boolean useNewSharePanel(@NotNull String sceneId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) sceneId)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(sceneId, "sceneId");
        Companion companion = INSTANCE;
        if (companion.a()) {
            return companion.b(sceneId);
        }
        return false;
    }
}
