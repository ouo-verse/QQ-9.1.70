package com.tencent.mobileqq.troop.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0006\u00a2\u0006\u0004\b\u0011\u0010\u0012J,\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006H\u0016J,\u0010\f\u001a\u00020\u000b2\"\u0010\u0007\u001a\u001e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n\u0018\u00010\u0004j\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n\u0018\u0001`\u0006H\u0016R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR(\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/troop/api/impl/m;", "Lcom/tencent/mobileqq/troop/api/c;", "", "uin", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "Lkotlin/collections/ArrayList;", "robotList", "", "b", "", "", "a", "Ljava/lang/String;", "troopUin", "Ljava/util/ArrayList;", "selectedUins", "<init>", "(Ljava/lang/String;Ljava/util/ArrayList;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
final class m implements com.tencent.mobileqq.troop.api.c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String troopUin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ArrayList<String> selectedUins;

    public m(@Nullable String str, @Nullable ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) arrayList);
        } else {
            this.troopUin = str;
            this.selectedUins = arrayList;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0061 A[LOOP:0: B:18:0x0036->B:25:0x0061, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0063 A[SYNTHETIC] */
    @Override // com.tencent.mobileqq.troop.api.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(@Nullable ArrayList<? extends Object> robotList) {
        ArrayList<RobotCoreInfo> arrayList;
        String valueOf;
        ac robotService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) robotList);
            return;
        }
        if (robotList != null && !robotList.isEmpty()) {
            IKernelService iKernelService = (IKernelService) bg.l(IKernelService.class);
            if (iKernelService != null && (robotService = iKernelService.getRobotService()) != null) {
                arrayList = robotService.getAllRobotFriendsFromCache();
            } else {
                arrayList = null;
            }
            int size = robotList.size() - 1;
            if (size < 0) {
                return;
            }
            while (true) {
                int i3 = size - 1;
                Object obj = robotList.get(size);
                if (obj instanceof com.tencent.qqnt.ntrelation.friendsinfo.bean.d) {
                    valueOf = ((com.tencent.qqnt.ntrelation.friendsinfo.bean.d) obj).x();
                } else {
                    if (obj instanceof RobotCoreInfo) {
                        valueOf = String.valueOf(((RobotCoreInfo) obj).getRobotUin());
                    }
                    if (i3 < 0) {
                        size = i3;
                    } else {
                        return;
                    }
                }
                if (b(valueOf, arrayList)) {
                    robotList.remove(size);
                }
                if (i3 < 0) {
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00c0, code lost:
    
        if (r11 != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d1, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00ce, code lost:
    
        if (r11 != false) goto L66;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(@NotNull String uin, @Nullable ArrayList<RobotCoreInfo> robotList) {
        boolean z16;
        Boolean bool;
        boolean z17;
        boolean f16;
        RobotCoreInfo robotCoreInfo;
        boolean g16;
        boolean z18;
        boolean h16;
        boolean z19;
        boolean e16;
        Object obj;
        boolean f17;
        Boolean bool2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) uin, (Object) robotList)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        ITroopRobotService iTroopRobotService = (ITroopRobotService) bg.l(ITroopRobotService.class);
        boolean z26 = true;
        if (iTroopRobotService != null && iTroopRobotService.isRobotUin(uin)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (QLog.isDebugVersion()) {
                QLog.d("TroopRobotApiImpl", 4, "[needFilter] not robot, uin:" + uin);
            }
            return false;
        }
        ArrayList<String> arrayList = this.selectedUins;
        Boolean bool3 = null;
        if (arrayList != null) {
            bool = Boolean.valueOf(arrayList.contains(uin));
        } else {
            bool = null;
        }
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            z26 = false;
        } else {
            String str = this.troopUin;
            if (str != null && str.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                f16 = l.f(this.troopUin);
                if (f16) {
                    if (robotList != null) {
                        Iterator<T> it = robotList.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                obj = it.next();
                                if (Intrinsics.areEqual(String.valueOf(((RobotCoreInfo) obj).robotUin), uin)) {
                                    break;
                                }
                            } else {
                                obj = null;
                                break;
                            }
                        }
                        robotCoreInfo = (RobotCoreInfo) obj;
                    } else {
                        robotCoreInfo = null;
                    }
                    g16 = l.g(this.troopUin);
                    if (g16) {
                        if (robotCoreInfo != null) {
                            e16 = l.e(robotCoreInfo);
                            if (e16) {
                                z19 = true;
                            }
                        }
                        z19 = false;
                    } else {
                        if (robotCoreInfo != null) {
                            h16 = l.h(robotCoreInfo);
                            if (h16) {
                                z18 = true;
                            }
                        }
                        z18 = false;
                    }
                    if (QLog.isColorLevel()) {
                        String str2 = this.troopUin;
                        f17 = l.f(str2);
                        if (robotCoreInfo != null) {
                            bool2 = Boolean.valueOf(robotCoreInfo.allowAddGroup);
                        } else {
                            bool2 = null;
                        }
                        if (robotCoreInfo != null) {
                            bool3 = Boolean.valueOf(robotCoreInfo.allowInvitedToGroup);
                        }
                        QLog.i("TroopRobotApiImpl", 2, "[needFilter] res:" + z26 + ", uin:" + uin + ", troopUin:" + str2 + ", exist:" + bool + ", canInvite:" + f17 + ", allowAdd:" + bool2 + ", allowInvited:" + bool3);
                    }
                    return z26;
                }
            }
        }
        robotCoreInfo = null;
        if (QLog.isColorLevel()) {
        }
        return z26;
    }
}
