package com.tencent.mobileqq.troop.appscenter.managers;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.AddRobotToGroupReq;
import com.tencent.qqnt.kernel.nativeinterface.AppDetail;
import com.tencent.qqnt.kernel.nativeinterface.AppId;
import com.tencent.qqnt.kernel.nativeinterface.ClientInfo;
import com.tencent.qqnt.kernel.nativeinterface.GetAppCenterReq;
import com.tencent.qqnt.kernel.nativeinterface.GetAppCenterRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGetAppCenterCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.ISetAddRobotToGroupCallback;
import com.tencent.qqnt.kernel.nativeinterface.SetCapsuleSwitchReq;
import com.tencent.qqnt.kernel.nativeinterface.SetGroupAppListReq;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J8\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022(\u0010\u0016\u001a$\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u00150\u0011J8\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182 \u0010\u0016\u001a\u001c\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00150\u001aJF\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2 \u0010\u0016\u001a\u001c\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00150\u001aJ8\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00182 \u0010\u0016\u001a\u001c\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00150\u001a\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/troop/appscenter/managers/NetworkManager;", "", "", "troopUin", "Lcom/tencent/qqnt/kernel/nativeinterface/GetAppCenterReq;", "g", "Lcom/tencent/mobileqq/troop/appscenter/managers/NetworkManager$GroupAppListRequestType;", "requestType", "", "Lcom/tencent/qqnt/kernel/nativeinterface/AppDetail;", "appDetails", "Lcom/tencent/qqnt/kernel/nativeinterface/SetGroupAppListReq;", h.F, "Lcom/tencent/qqnt/kernel/api/s;", "l", "Lcom/tencent/qqnt/kernel/nativeinterface/ClientInfo;", "k", "Lkotlin/Function4;", "", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GetAppCenterRsp;", "", "callback", "i", "", "switchValue", "Lkotlin/Function3;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "associatedId", "e", "<init>", "()V", "a", "GroupAppListRequestType", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class NetworkManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/troop/appscenter/managers/NetworkManager$GroupAppListRequestType;", "", "(Ljava/lang/String;I)V", "ADD_APP", "REMOVE_APP", "UPDATE_APP_LIST", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class GroupAppListRequestType {
        private static final /* synthetic */ GroupAppListRequestType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final GroupAppListRequestType ADD_APP;
        public static final GroupAppListRequestType REMOVE_APP;
        public static final GroupAppListRequestType UPDATE_APP_LIST;

        private static final /* synthetic */ GroupAppListRequestType[] $values() {
            return new GroupAppListRequestType[]{ADD_APP, REMOVE_APP, UPDATE_APP_LIST};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25708);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            ADD_APP = new GroupAppListRequestType("ADD_APP", 0);
            REMOVE_APP = new GroupAppListRequestType("REMOVE_APP", 1);
            UPDATE_APP_LIST = new GroupAppListRequestType("UPDATE_APP_LIST", 2);
            $VALUES = $values();
        }

        GroupAppListRequestType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static GroupAppListRequestType valueOf(String str) {
            return (GroupAppListRequestType) Enum.valueOf(GroupAppListRequestType.class, str);
        }

        public static GroupAppListRequestType[] values() {
            return (GroupAppListRequestType[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/appscenter/managers/NetworkManager$a;", "", "", "LIMIT_CODE", "I", "ROBOT_EXISTING_CODE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.appscenter.managers.NetworkManager$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f294415a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25728);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[GroupAppListRequestType.values().length];
            try {
                iArr[GroupAppListRequestType.ADD_APP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GroupAppListRequestType.REMOVE_APP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GroupAppListRequestType.UPDATE_APP_LIST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f294415a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25736);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NetworkManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(String troopUin, long j3, Function3 callback, int i3, String str) {
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (i3 != 0 && i3 != 10025) {
            QLog.e("TroopAppsCenter.NetworkManager", 1, "Failed to add robot to group for troopUin: " + troopUin + ", Error: " + i3 + ", " + str);
            callback.invoke(Boolean.FALSE, Integer.valueOf(i3), str);
            return;
        }
        QLog.i("TroopAppsCenter.NetworkManager", 1, "Successfully added robot to group for troopUin: " + troopUin + ", robotId: " + j3);
        callback.invoke(Boolean.TRUE, Integer.valueOf(i3), null);
    }

    private final GetAppCenterReq g(String troopUin) {
        int i3;
        TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(troopUin);
        GetAppCenterReq getAppCenterReq = new GetAppCenterReq();
        getAppCenterReq.groupId = Long.parseLong(troopUin);
        getAppCenterReq.clientInfo = k();
        getAppCenterReq.mode = ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch() ? 1 : 0;
        getAppCenterReq.needRobot = 1;
        if (troopInfoFromCache != null) {
            i3 = (int) troopInfoFromCache.dwGroupClassExt;
        } else {
            i3 = 0;
        }
        getAppCenterReq.groupType = i3;
        return getAppCenterReq;
    }

    private final SetGroupAppListReq h(String troopUin, GroupAppListRequestType requestType, List<AppDetail> appDetails) {
        int i3;
        SetGroupAppListReq setGroupAppListReq = new SetGroupAppListReq();
        setGroupAppListReq.groupId = Long.parseLong(troopUin);
        setGroupAppListReq.clientInfo = k();
        if (requestType == GroupAppListRequestType.ADD_APP) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        setGroupAppListReq.addType = i3;
        for (AppDetail appDetail : appDetails) {
            int i16 = b.f294415a[requestType.ordinal()];
            if (i16 != 1 && i16 != 2) {
                if (i16 == 3) {
                    ArrayList<AppId> arrayList = setGroupAppListReq.appids;
                    AppId appId = new AppId();
                    String str = appDetail.appId;
                    Intrinsics.checkNotNullExpressionValue(str, "detail.appId");
                    appId.appid = Long.parseLong(str);
                    appId.source = appDetail.type;
                    arrayList.add(appId);
                }
            } else {
                String str2 = appDetail.appId;
                Intrinsics.checkNotNullExpressionValue(str2, "detail.appId");
                setGroupAppListReq.appendAppid = Long.parseLong(str2);
                setGroupAppListReq.appendSource = appDetail.type;
            }
        }
        return setGroupAppListReq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(String troopUin, Function4 callback, int i3, String str, GetAppCenterRsp getAppCenterRsp) {
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        boolean z16 = true;
        if (i3 == 0) {
            QLog.i("TroopAppsCenter.NetworkManager", 1, "Successfully fetched app center data for troopUin: " + troopUin);
        } else {
            QLog.e("TroopAppsCenter.NetworkManager", 1, "Failed to fetch app center data for troopUin: " + troopUin + ", Error: " + i3 + ", " + str);
        }
        if (i3 != 0) {
            z16 = false;
        }
        callback.invoke(Boolean.valueOf(z16), Integer.valueOf(i3), str, getAppCenterRsp);
    }

    private final ClientInfo k() {
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.platform = 2;
        clientInfo.version = AppSetting.f99551k + "." + AppSetting.f99542b;
        return clientInfo;
    }

    private final s l() {
        IKernelService iKernelService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "all")) != null) {
            return iKernelService.getGroupService();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(long j3, Function3 callback, int i3, String str) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        boolean z16 = true;
        if (i3 == 0) {
            QLog.i("TroopAppsCenter.NetworkManager", 1, "Successfully set capsule switch for troopUin: " + j3);
        } else {
            QLog.e("TroopAppsCenter.NetworkManager", 1, "Failed to set capsule switch for troopUin: " + j3 + ", Error: " + i3 + ", " + str);
        }
        if (i3 != 0) {
            z16 = false;
        }
        callback.invoke(Boolean.valueOf(z16), Integer.valueOf(i3), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(String troopUin, Function3 callback, int i3, String str) {
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (i3 != 0) {
            if (i3 != 41005) {
                QLog.e("TroopAppsCenter.NetworkManager", 1, "Failed to set group app list for troopUin: " + troopUin + ", Error: " + i3 + ", " + str);
                callback.invoke(Boolean.FALSE, Integer.valueOf(i3), str);
                return;
            }
            QLog.w("TroopAppsCenter.NetworkManager", 1, "Limit reached for troopUin: " + troopUin + ", Error: " + i3 + ", \u6dfb\u52a0\u5e94\u7528\u8d85\u8fc7\u4e0a\u9650");
            callback.invoke(Boolean.FALSE, Integer.valueOf(i3), "\u6dfb\u52a0\u5e94\u7528\u8d85\u8fc7\u4e0a\u9650");
            return;
        }
        QLog.i("TroopAppsCenter.NetworkManager", 1, "Successfully set group app list for troopUin: " + troopUin);
        callback.invoke(Boolean.TRUE, Integer.valueOf(i3), null);
    }

    public final void e(@NotNull final String troopUin, final long associatedId, @NotNull final Function3<? super Boolean, ? super Integer, ? super String, Unit> callback) {
        IKernelService iKernelService;
        ac robotService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, troopUin, Long.valueOf(associatedId), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AddRobotToGroupReq addRobotToGroupReq = new AddRobotToGroupReq(Long.parseLong(troopUin), associatedId);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) != null && (robotService = iKernelService.getRobotService()) != null) {
            robotService.setAddRobotToGroup(addRobotToGroupReq, new ISetAddRobotToGroupCallback() { // from class: com.tencent.mobileqq.troop.appscenter.managers.e
                @Override // com.tencent.qqnt.kernel.nativeinterface.ISetAddRobotToGroupCallback
                public final void onResult(int i3, String str) {
                    NetworkManager.f(troopUin, associatedId, callback, i3, str);
                }
            });
        }
    }

    public final void i(@NotNull final String troopUin, @NotNull final Function4<? super Boolean, ? super Integer, ? super String, ? super GetAppCenterRsp, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopUin, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        GetAppCenterReq g16 = g(troopUin);
        s l3 = l();
        if (l3 != null) {
            l3.getAppCenter(g16, new IGetAppCenterCallback() { // from class: com.tencent.mobileqq.troop.appscenter.managers.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetAppCenterCallback
                public final void onResult(int i3, String str, GetAppCenterRsp getAppCenterRsp) {
                    NetworkManager.j(troopUin, callback, i3, str, getAppCenterRsp);
                }
            });
        }
    }

    public final void m(final long troopUin, long switchValue, @NotNull final Function3<? super Boolean, ? super Integer, ? super String, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(troopUin), Long.valueOf(switchValue), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        SetCapsuleSwitchReq setCapsuleSwitchReq = new SetCapsuleSwitchReq();
        setCapsuleSwitchReq.groupId = troopUin;
        setCapsuleSwitchReq.switchValue = switchValue;
        s l3 = l();
        if (l3 != null) {
            l3.C(setCapsuleSwitchReq, new IOperateCallback() { // from class: com.tencent.mobileqq.troop.appscenter.managers.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    NetworkManager.n(troopUin, callback, i3, str);
                }
            });
        }
    }

    public final void o(@NotNull final String troopUin, @NotNull GroupAppListRequestType requestType, @NotNull List<AppDetail> appDetails, @NotNull final Function3<? super Boolean, ? super Integer, ? super String, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, troopUin, requestType, appDetails, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(requestType, "requestType");
        Intrinsics.checkNotNullParameter(appDetails, "appDetails");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SetGroupAppListReq h16 = h(troopUin, requestType, appDetails);
        s l3 = l();
        if (l3 != null) {
            l3.setGroupAppList(h16, new IOperateCallback() { // from class: com.tencent.mobileqq.troop.appscenter.managers.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    NetworkManager.p(troopUin, callback, i3, str);
                }
            });
        }
    }
}
