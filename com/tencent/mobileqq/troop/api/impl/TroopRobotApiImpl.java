package com.tencent.mobileqq.troop.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.api.ITroopRobotApi;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.IFetchRobotCoreInfosCallback;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J.\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0005H\u0016J(\u0010\r\u001a\u00020\f2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0004j\b\u0012\u0004\u0012\u00020\u0002`\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001c\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/troop/api/impl/TroopRobotApiImpl;", "Lcom/tencent/mobileqq/troop/api/ITroopRobotApi;", "", "troopUin", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "selectedUins", "Lcom/tencent/mobileqq/troop/api/c;", "initTroopRobotInviteFilter", "robotUidList", "Ljava/lang/Runnable;", "runnable", "", "fetchRobotInfo", "robotUin", "", "canInviteToTroop", "couldInviteTroopRobot", "<init>", "()V", "Companion", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopRobotApiImpl implements ITroopRobotApi {
    static IPatchRedirector $redirector_;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final ConcurrentHashMap<String, RobotCoreInfo> FETCHED_ROBOT_INFO;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/api/impl/TroopRobotApiImpl$a;", "", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "FETCHED_ROBOT_INFO", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.api.impl.TroopRobotApiImpl$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24024);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
            FETCHED_ROBOT_INFO = new ConcurrentHashMap<>();
        }
    }

    public TroopRobotApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchRobotInfo$lambda$3(Runnable runnable, int i3, String str, ArrayList arrayList) {
        Integer num;
        Intrinsics.checkNotNullParameter(runnable, "$runnable");
        if (arrayList != null) {
            num = Integer.valueOf(arrayList.size());
        } else {
            num = null;
        }
        QLog.i("TroopRobotApiImpl", 1, "[fetchRobotInfo] result:" + i3 + ", errMsg:" + str + ", robots.size:" + num);
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                RobotCoreInfo it5 = (RobotCoreInfo) it.next();
                ConcurrentHashMap<String, RobotCoreInfo> concurrentHashMap = FETCHED_ROBOT_INFO;
                String valueOf = String.valueOf(it5.robotUin);
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                concurrentHashMap.put(valueOf, it5);
            }
        }
        com.tencent.qqnt.e.i(runnable);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x007e, code lost:
    
        if (r4 == true) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0089, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0087, code lost:
    
        if (r4 == true) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0093  */
    @Override // com.tencent.mobileqq.troop.api.ITroopRobotApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean canInviteToTroop(@Nullable String troopUin, @Nullable String robotUin) {
        Boolean bool;
        RobotCoreInfo robotCoreInfo;
        boolean f16;
        Boolean bool2;
        boolean f17;
        ArrayList<RobotCoreInfo> arrayList;
        boolean g16;
        boolean h16;
        boolean e16;
        Object obj;
        ac robotService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) troopUin, (Object) robotUin)).booleanValue();
        }
        boolean z16 = false;
        Boolean bool3 = null;
        if (troopUin != null && robotUin != null) {
            f17 = l.f(troopUin);
            if (f17) {
                IKernelService iKernelService = (IKernelService) bg.l(IKernelService.class);
                if (iKernelService != null && (robotService = iKernelService.getRobotService()) != null) {
                    arrayList = robotService.getAllRobotFriendsFromCache();
                } else {
                    arrayList = null;
                }
                if (arrayList != null) {
                    Iterator<T> it = arrayList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj = it.next();
                            if (Intrinsics.areEqual(String.valueOf(((RobotCoreInfo) obj).robotUin), robotUin)) {
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
                if (robotCoreInfo == null) {
                    robotCoreInfo = FETCHED_ROBOT_INFO.get(robotUin);
                    bool = Boolean.FALSE;
                } else {
                    bool = Boolean.TRUE;
                }
                g16 = l.g(troopUin);
                if (g16) {
                    if (robotCoreInfo != null) {
                        e16 = l.e(robotCoreInfo);
                    }
                    if (QLog.isColorLevel()) {
                        f16 = l.f(troopUin);
                        if (robotCoreInfo != null) {
                            bool2 = Boolean.valueOf(robotCoreInfo.allowAddGroup);
                        } else {
                            bool2 = null;
                        }
                        if (robotCoreInfo != null) {
                            bool3 = Boolean.valueOf(robotCoreInfo.allowInvitedToGroup);
                        }
                        QLog.i("TroopRobotApiImpl", 2, "[canInviteToTroop] res:" + z16 + ", troopUin:" + troopUin + ", robotUin:" + robotUin + ", canInvite:" + f16 + ", useFriCache:" + bool + "}, allowAdd:" + bool2 + ", allowInvited:" + bool3);
                    }
                    return z16;
                }
                if (robotCoreInfo != null) {
                    h16 = l.h(robotCoreInfo);
                }
                if (QLog.isColorLevel()) {
                }
                return z16;
            }
        }
        bool = null;
        robotCoreInfo = null;
        if (QLog.isColorLevel()) {
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopRobotApi
    public boolean couldInviteTroopRobot(@Nullable String troopUin) {
        boolean f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            f16 = l.f(troopUin);
            return f16;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) troopUin)).booleanValue();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopRobotApi
    public void fetchRobotInfo(@NotNull ArrayList<String> robotUidList, @NotNull final Runnable runnable) {
        ac acVar;
        RobotCoreInfo robotCoreInfo;
        boolean z16;
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) robotUidList, (Object) runnable);
            return;
        }
        Intrinsics.checkNotNullParameter(robotUidList, "robotUidList");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        IKernelService iKernelService = (IKernelService) bg.l(IKernelService.class);
        if (iKernelService != null) {
            acVar = iKernelService.getRobotService();
        } else {
            acVar = null;
        }
        if (acVar == null) {
            QLog.i("TroopRobotApiImpl", 1, "[fetchRobotInfo] robotService is null");
            runnable.run();
            return;
        }
        ArrayList<RobotCoreInfo> allRobotFriendsFromCache = acVar.getAllRobotFriendsFromCache();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : robotUidList) {
            String str = (String) obj2;
            if (allRobotFriendsFromCache != null) {
                Iterator<T> it = allRobotFriendsFromCache.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (Intrinsics.areEqual(((RobotCoreInfo) obj).getUid(), str)) {
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
            if (robotCoreInfo == null && FETCHED_ROBOT_INFO.get(str) == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj2);
            }
        }
        QLog.i("TroopRobotApiImpl", 1, "[fetchRobotInfo] size:" + arrayList.size() + ", " + arrayList);
        if (arrayList.isEmpty()) {
            runnable.run();
        } else {
            acVar.batchFetchRobotCoreInfos(new ArrayList<>(arrayList), new IFetchRobotCoreInfosCallback() { // from class: com.tencent.mobileqq.troop.api.impl.k
                @Override // com.tencent.qqnt.kernel.nativeinterface.IFetchRobotCoreInfosCallback
                public final void onResult(int i3, String str2, ArrayList arrayList2) {
                    TroopRobotApiImpl.fetchRobotInfo$lambda$3(runnable, i3, str2, arrayList2);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopRobotApi
    @NotNull
    public com.tencent.mobileqq.troop.api.c initTroopRobotInviteFilter(@Nullable String troopUin, @Nullable ArrayList<String> selectedUins) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.troop.api.c) iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopUin, (Object) selectedUins);
        }
        return new m(troopUin, selectedUins);
    }
}
