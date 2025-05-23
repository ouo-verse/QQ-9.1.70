package com.tencent.mobileqq.troop.utils;

import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupSimpleInfo;
import com.tencent.qqnt.kernel.nativeinterface.MemberInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b-\u0010.J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J+\u0010\n\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0007*\u0004\u0018\u00010\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ3\u0010\u000e\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0007*\u0004\u0018\u00010\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\r\u001a\u00020\fH\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\r\u001a\u00020\fH\u0007J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0007J\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J&\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u001bj\b\u0012\u0004\u0012\u00028\u0000`\u001c\"\u0004\b\u0000\u0010\u0019*\b\u0012\u0004\u0012\u00028\u00000\u001aJ\u0016\u0010#\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 J\u0016\u0010&\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020$J\u0016\u0010*\u001a\u00020\"2\u0006\u0010'\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020(J\u000e\u0010,\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\f\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/troop/utils/bg;", "", "Lcom/tencent/common/app/AppInterface;", "e", "Lmqq/app/AppRuntime;", "f", "Lmqq/app/api/IRuntimeService;", "T", "Ljava/lang/Class;", "clazz", "l", "(Ljava/lang/Class;)Lmqq/app/api/IRuntimeService;", "", "callerRunningProcess", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;", "Lcom/tencent/qqnt/kernel/api/s;", tl.h.F, "Ljava/lang/Runnable;", "runnable", "", "k", "j", "Lcom/tencent/qqnt/kernel/api/r;", "g", "E", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", DomainData.DOMAIN_NAME, "", "troopUin", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupDetailInfo;", "detailInfo", "", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSimpleInfo;", "simpleInfo", "c", "memberUin", "Lcom/tencent/qqnt/kernel/nativeinterface/MemberInfo;", "memberInfo", "d", "msg", "a", "<init>", "()V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class bg {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final bg f302144a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25341);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f302144a = new bg();
        }
    }

    bg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @Nullable
    public static final AppInterface e() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            return (AppInterface) peekAppRuntime;
        }
        return null;
    }

    @JvmStatic
    @Nullable
    public static final AppRuntime f() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        return peekAppRuntime;
    }

    @JvmStatic
    @Nullable
    public static final com.tencent.qqnt.kernel.api.s h(@NotNull String callerRunningProcess) {
        String str;
        boolean z16;
        IKernelService iKernelService;
        AppRuntime peekAppRuntime;
        Intrinsics.checkNotNullParameter(callerRunningProcess, "callerRunningProcess");
        try {
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            if (mobileQQ != null && (peekAppRuntime = mobileQQ.peekAppRuntime()) != null) {
                str = peekAppRuntime.getAccount();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z16 = false;
                if (!z16 || (iKernelService = (IKernelService) m(IKernelService.class, callerRunningProcess)) == null) {
                    return null;
                }
                return iKernelService.getGroupService();
            }
            z16 = true;
            if (!z16) {
                return null;
            }
            return iKernelService.getGroupService();
        } catch (Exception e16) {
            QLog.e("TroopUtil", 1, "getGroupService: ", e16);
            return null;
        }
    }

    public static /* synthetic */ com.tencent.qqnt.kernel.api.s i(String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "";
        }
        return h(str);
    }

    @JvmStatic
    public static final void k(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            runnable.run();
        } else {
            ThreadManager.getUIHandler().post(runnable);
        }
    }

    @JvmStatic
    @Nullable
    public static final <T extends IRuntimeService> T l(@NotNull Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return (T) m(clazz, "");
    }

    @JvmStatic
    @Nullable
    public static final <T extends IRuntimeService> T m(@NotNull Class<T> clazz, @NotNull String callerRunningProcess) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(callerRunningProcess, "callerRunningProcess");
        AppRuntime f16 = f();
        if (f16 != null) {
            return (T) f16.getRuntimeService(clazz, callerRunningProcess);
        }
        return null;
    }

    public final void a(@NotNull String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) msg2);
        } else {
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }
    }

    public final boolean b(long troopUin, @NotNull GroupDetailInfo detailInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, Long.valueOf(troopUin), detailInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(detailInfo, "detailInfo");
        long j3 = detailInfo.groupCode;
        if (j3 > 0 && j3 == troopUin) {
            return false;
        }
        QLog.e("TroopUtil", 1, "checkGroupInfoError: troopUin=" + troopUin + ", detail.groupCode=" + j3);
        a("\u68c0\u6d4b\u5230\u7fa4\u8d44\u6599\u6709\u5f02\u5e38");
        return true;
    }

    public final boolean c(long troopUin, @NotNull GroupSimpleInfo simpleInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, Long.valueOf(troopUin), simpleInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(simpleInfo, "simpleInfo");
        long j3 = simpleInfo.groupCode;
        if (j3 > 0 && j3 == troopUin) {
            return false;
        }
        QLog.e("TroopUtil", 1, "checkGroupInfoError: troopUin=" + troopUin + ", simple.groupCode=" + j3);
        a("\u68c0\u6d4b\u5230\u7fa4\u6570\u636e\u6709\u5f02\u5e38");
        return true;
    }

    public final boolean d(long memberUin, @NotNull MemberInfo memberInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, Long.valueOf(memberUin), memberInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(memberInfo, "memberInfo");
        long j3 = memberInfo.uin;
        if (j3 > 0 && j3 == memberUin) {
            return false;
        }
        QLog.e("TroopUtil", 1, "checkGroupMemberInfoError: memberUin=" + memberUin + ", ntMember.uin=" + j3);
        return true;
    }

    @Nullable
    public final com.tencent.qqnt.kernel.api.r g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qqnt.kernel.api.r) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        IKernelService iKernelService = (IKernelService) l(IKernelService.class);
        if (iKernelService != null) {
            return iKernelService.getGroupSchoolService();
        }
        return null;
    }

    public final void j(@NotNull Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
        } else {
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            ThreadManagerV2.excute(runnable, 16, null, false);
        }
    }

    @NotNull
    public final <E> ArrayList<E> n(@NotNull List<? extends E> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this, (Object) list);
        }
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list instanceof ArrayList) {
            return (ArrayList) list;
        }
        return new ArrayList<>(list);
    }
}
