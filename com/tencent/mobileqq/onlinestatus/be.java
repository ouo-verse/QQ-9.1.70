package com.tencent.mobileqq.onlinestatus;

import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusAvatarSwitchService;
import com.tencent.mobileqq.onlinestatus.model.AvatarStatusViewScene;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\b\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\b\u0010\f\u001a\u00020\u0002H\u0007J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\b\u0010\u000f\u001a\u00020\u0002H\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0007J\b\u0010\u0011\u001a\u00020\u0002H\u0007J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\bH\u0007J\b\u0010\u0015\u001a\u00020\u0002H\u0007J\b\u0010\u0016\u001a\u00020\u0002H\u0007J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00188BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/be;", "", "", "b", tl.h.F, "", "uin", "d", "", "c", "a", DomainData.DOMAIN_NAME, "p", "j", "g", "f", "k", "o", "from", "Lcom/tencent/mobileqq/onlinestatus/model/AvatarStatusViewScene;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "e", "l", "i", "Lcom/tencent/mobileqq/onlinestatus/api/IOnlineStatusAvatarSwitchService;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/onlinestatus/api/IOnlineStatusAvatarSwitchService;", "switchService", "<init>", "()V", "qqonlinestatus-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class be {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final be f255580a = new be();

    be() {
    }

    @JvmStatic
    public static final boolean a(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (b() && ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).isAvatarAccountAutoWhite(uin)) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final boolean b() {
        return !AppSetting.o(BaseApplication.getContext());
    }

    @JvmStatic
    public static final int c() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return 12;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026ava, ProcessConstant.ALL)");
        return ((IFeatureRuntimeService) runtimeService).getInt("online_status_avatar_gray_switch", 12);
    }

    @JvmStatic
    public static final boolean d(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (!b()) {
            return false;
        }
        return i(uin);
    }

    @JvmStatic
    public static final boolean e() {
        return b();
    }

    @JvmStatic
    public static final boolean f() {
        return p();
    }

    @JvmStatic
    public static final boolean g(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        int j3 = j(uin);
        if (j3 != 0) {
            if (j3 == 3) {
                return true;
            }
            return false;
        }
        return n(uin);
    }

    @JvmStatic
    public static final boolean h() {
        if (!b()) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final boolean i(@NotNull String uin) {
        com.tencent.mobileqq.onlinestatus.model.f switchStatus;
        Intrinsics.checkNotNullParameter(uin, "uin");
        IOnlineStatusAvatarSwitchService m3 = f255580a.m();
        if (m3 != null && (switchStatus = m3.getSwitchStatus(uin)) != null) {
            return switchStatus.getGrayWhiteSwitch();
        }
        return false;
    }

    @JvmStatic
    public static final int j(@NotNull String uin) {
        IOnlineStatusAvatarSwitchService m3;
        com.tencent.mobileqq.onlinestatus.model.f switchStatus;
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (TextUtils.isEmpty(uin) || !b() || (m3 = f255580a.m()) == null || (switchStatus = m3.getSwitchStatus(uin)) == null) {
            return 0;
        }
        return switchStatus.getPanelSwitch();
    }

    @JvmStatic
    public static final boolean k() {
        return p();
    }

    @JvmStatic
    public static final boolean l() {
        return b();
    }

    private final IOnlineStatusAvatarSwitchService m() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return (IOnlineStatusAvatarSwitchService) peekAppRuntime.getRuntimeService(IOnlineStatusAvatarSwitchService.class, "all");
        }
        return null;
    }

    @JvmStatic
    public static final boolean n(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (!a(uin) && !d(uin)) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final boolean o() {
        return p();
    }

    @JvmStatic
    public static final boolean p() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || TextUtils.isEmpty(peekAppRuntime.getCurrentAccountUin())) {
            return false;
        }
        String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "appRuntime.currentAccountUin");
        if (!a(currentAccountUin) && !h()) {
            return false;
        }
        return true;
    }

    @JvmStatic
    @NotNull
    public static final AvatarStatusViewScene q(int from) {
        if (from != 1 && from != 3) {
            if (from != 4) {
                if (from != 5 && from != 6) {
                    return AvatarStatusViewScene.UNKNOWN;
                }
            } else {
                return AvatarStatusViewScene.ONLINE_STATUS_AGGREGATION_PANEL;
            }
        }
        return AvatarStatusViewScene.POPUP_WINDOW;
    }
}
