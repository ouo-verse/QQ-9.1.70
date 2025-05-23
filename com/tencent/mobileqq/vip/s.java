package com.tencent.mobileqq.vip;

import QQService.EVIPSPEC;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.ar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00152\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\r\u001a\u0004\u0018\u00010\fR\u001a\u0010\u0012\u001a\u00020\b8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/vip/s;", "Lcom/tencent/mobileqq/vip/IVipStatusManager;", "", "isSuperQQ", "isVip", "isSVip", "isBigClub", "isStar", "", "uin", "", "getPrivilegeFlags", "Lmqq/app/AppRuntime;", "a", "d", "Ljava/lang/String;", "getManagerName", "()Ljava/lang/String;", "managerName", "<init>", "()V", "e", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class s implements IVipStatusManager {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name */
    private static final boolean f313044f;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String managerName;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vip/s$a;", "", "", "TAG", "Ljava/lang/String;", "", "bugfix", "Z", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vip.s$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49661);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
            f313044f = ar.INSTANCE.b("kenaiyu", "2024-12-19", "vas_bug_135599929").isEnable(true);
        }
    }

    public s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.managerName = "VipStatusManagerImpl";
        }
    }

    @Nullable
    public final AppRuntime a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    @Override // com.tencent.mobileqq.vas.api.IVasManager
    @NotNull
    public String getManagerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.managerName;
    }

    @Override // com.tencent.mobileqq.vip.IVipStatusManager
    public int getPrivilegeFlags(@Nullable String uin) {
        NTVasSimpleInfo findFriendEntityByUin;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 8;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) uin)).intValue();
        }
        AppRuntime a16 = a();
        int i17 = 0;
        if (a16 == null) {
            return 0;
        }
        if (uin == null && f313044f) {
            IVasInfoService iVasInfoService = (IVasInfoService) QRoute.api(IVasInfoService.class);
            String currentUid = a16.getCurrentUid();
            Intrinsics.checkNotNullExpressionValue(currentUid, "app.currentUid");
            findFriendEntityByUin = iVasInfoService.getVasSimpleInfoWithUid(currentUid, "VipStatusManagerImpl");
        } else {
            IVasDepTemp iVasDepTemp = (IVasDepTemp) QRoute.api(IVasDepTemp.class);
            if (uin == null) {
                uin = a16.getAccount();
            }
            findFriendEntityByUin = iVasDepTemp.findFriendEntityByUin(a16, uin);
        }
        int i18 = 2;
        if (findFriendEntityByUin != null) {
            int i19 = (r.c(findFriendEntityByUin, EVIPSPEC.E_SP_SUPERQQ) ? 1 : 0) | 0;
            if (!r.c(findFriendEntityByUin, EVIPSPEC.E_SP_QQVIP)) {
                i18 = 0;
            }
            int i26 = i18 | i19;
            if (r.c(findFriendEntityByUin, EVIPSPEC.E_SP_SUPERVIP)) {
                i3 = 4;
            } else {
                i3 = 0;
            }
            int i27 = i26 | i3;
            if (!r.c(findFriendEntityByUin, EVIPSPEC.E_SP_BIGCLUB)) {
                i16 = 0;
            }
            int i28 = i27 | i16;
            if (findFriendEntityByUin.vipStartFlag == 1) {
                i17 = 16;
            }
            return i28 | i17;
        }
        QLog.e("VipStatusManagerImpl", 2, "getPrivilegeFlags Friends is null");
        return 0;
    }

    @Override // com.tencent.mobileqq.vip.IVipStatusManager
    public boolean isBigClub() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if ((getPrivilegeFlags(null) & 8) != 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vip.IVipStatusManager
    public boolean isSVip() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if ((getPrivilegeFlags(null) & 4) != 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vip.IVipStatusManager
    public boolean isStar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if ((getPrivilegeFlags(null) & 16) != 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vip.IVipStatusManager
    public boolean isSuperQQ() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if ((getPrivilegeFlags(null) & 1) != 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vip.IVipStatusManager
    public boolean isVip() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if ((getPrivilegeFlags(null) & 2) != 0) {
            return true;
        }
        return false;
    }
}
