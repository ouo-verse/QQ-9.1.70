package com.tencent.mobileqq.troop.robot.api.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import bt2.d;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.redpoint.api.IRedPointUtilsApi;
import com.tencent.mobileqq.troop.robot.api.IRobotUtilApi;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.GroupCmd0xce5Req;
import com.tencent.qqnt.kernel.nativeinterface.GroupCmd0xce5Rsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotRedPoint;
import com.tencent.qqnt.kernel.nativeinterface.IGroupRobotInfoCallback;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopRobotHandler extends TroopBaseHandler implements ct2.a {
    public TroopRobotHandler(AppInterface appInterface) {
        super(appInterface);
    }

    @Nullable
    private ac H2() {
        AppInterface appInterface = this.appRuntime;
        if (appInterface == null) {
            return null;
        }
        return ((IKernelService) appInterface.getRuntimeService(IKernelService.class, "")).getRobotService();
    }

    @NonNull
    private IGroupRobotInfoCallback I2(final long j3) {
        return new IGroupRobotInfoCallback() { // from class: com.tencent.mobileqq.troop.robot.api.impl.a
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupRobotInfoCallback
            public final void onResult(int i3, String str, GroupCmd0xce5Rsp groupCmd0xce5Rsp) {
                TroopRobotHandler.this.K2(j3, i3, str, groupCmd0xce5Rsp);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J2(long j3, int i3, String str, GroupCmd0xce5Rsp groupCmd0xce5Rsp) {
        if (i3 == 0 && groupCmd0xce5Rsp != null) {
            notifyUI(ct2.b.f391832i, true, L2(j3, groupCmd0xce5Rsp));
        } else {
            notifyUI(ct2.b.f391832i, false, null);
            ((IRobotUtilApi) QRoute.api(IRobotUtilApi.class)).setRobotRedInfoUpdate(this.appRuntime, 120L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K2(long j3, int i3, String str, GroupCmd0xce5Rsp groupCmd0xce5Rsp) {
        if (i3 == 0 && groupCmd0xce5Rsp != null) {
            ArrayList<GroupRobotInfo> robotInfoList = groupCmd0xce5Rsp.getRobotInfoList();
            ArrayList arrayList = new ArrayList(robotInfoList.size());
            Iterator<GroupRobotInfo> it = robotInfoList.iterator();
            while (it.hasNext()) {
                arrayList.add(new d(it.next()));
            }
            notifyUI(ct2.b.f391830f, true, new Object[]{Integer.valueOf(i3), Long.valueOf(j3), arrayList});
            return;
        }
        notifyUI(ct2.b.f391830f, false, new Object[]{Integer.valueOf(i3), Long.valueOf(j3), null});
    }

    @NonNull
    private Object L2(long j3, GroupCmd0xce5Rsp groupCmd0xce5Rsp) {
        boolean z16;
        long cacheTime = groupCmd0xce5Rsp.getRobotRedpointList().getCacheTime();
        ArrayList<GroupRobotRedPoint> redpointList = groupCmd0xce5Rsp.getRobotRedpointList().getRedpointList();
        ArrayList<String> arrayList = new ArrayList<>(redpointList.size());
        Iterator<GroupRobotRedPoint> it = redpointList.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(it.next().getRobotUin()));
        }
        ((IRobotUtilApi) QRoute.api(IRobotUtilApi.class)).setRobotRedInfoUpdate(this.appRuntime, cacheTime);
        ((ITroopRobotService) this.appRuntime.getRuntimeService(ITroopRobotService.class, "all")).onGetRobotRedInfo(this.appRuntime, cacheTime, arrayList);
        IRobotUtilApi iRobotUtilApi = (IRobotUtilApi) QRoute.api(IRobotUtilApi.class);
        AppInterface appInterface = this.appRuntime;
        if (groupCmd0xce5Rsp.getRobotRedpointList().getRole() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        iRobotUtilApi.setRobotRedForAllMembers(appInterface, z16);
        ((IRedPointUtilsApi) QRoute.api(IRedPointUtilsApi.class)).updateRedPointInfo(this.appRuntime, String.valueOf(j3), "troop", 1, ((IRobotUtilApi) QRoute.api(IRobotUtilApi.class)).getNeedShowRobotRedDotAio(this.appRuntime, String.valueOf(j3)) ? 1 : 0);
        return new Object[]{Long.valueOf(cacheTime), arrayList};
    }

    @Override // ct2.a
    public void N(final long j3) {
        ac H2 = H2();
        if (H2 == null) {
            return;
        }
        GroupCmd0xce5Req groupCmd0xce5Req = new GroupCmd0xce5Req();
        groupCmd0xce5Req.groupId = j3;
        groupCmd0xce5Req.serviceType = 6;
        H2.FetchGroupRobotInfo(groupCmd0xce5Req, new IGroupRobotInfoCallback() { // from class: com.tencent.mobileqq.troop.robot.api.impl.b
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupRobotInfoCallback
            public final void onResult(int i3, String str, GroupCmd0xce5Rsp groupCmd0xce5Rsp) {
                TroopRobotHandler.this.J2(j3, i3, str, groupCmd0xce5Rsp);
            }
        });
    }

    @Override // ct2.a
    public void Z(long j3) {
        ac H2 = H2();
        if (H2 == null) {
            return;
        }
        GroupCmd0xce5Req groupCmd0xce5Req = new GroupCmd0xce5Req();
        groupCmd0xce5Req.groupId = j3;
        groupCmd0xce5Req.serviceType = 3;
        H2.FetchGroupRobotInfo(groupCmd0xce5Req, I2(j3));
    }

    @Override // ct2.a
    public void a0(String str, String str2, String str3, Boolean bool) {
        if (QLog.isColorLevel()) {
            QLog.d("TroopRobotHandlerRobotMemberChange", 2, "handleRobotMemberChangeFromWeb : troopUin:" + str + " robotUin:" + str2 + " robotName:" + str3 + " isAdd:" + bool);
        }
        notifyUI(ct2.b.f391831h, true, new Object[]{bool, str, str2, str3});
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvc.0xce5_0");
            this.allowCmdSet.add("OidbSvc.0xce5_1");
            this.allowCmdSet.add("OidbSvc.0xce5_3");
            this.allowCmdSet.add("OidbSvc.0xce5_6");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.troop.handler.TroopBaseHandler
    protected String getTag() {
        return "TroopRobotHandler";
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return ct2.b.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (fromServiceMsg != null && toServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd)) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopRobotHandler", 2, "cmdfilter error=" + serviceCmd);
                    return;
                }
                return;
            }
            if (!getTag().equals(toServiceMsg.extraData.getString("REQ_TAG")) && QLog.isColorLevel()) {
                QLog.d("TroopRobotHandler", 2, "REQ_TAG doesn't match. cmd:  " + serviceCmd);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopRobotHandler", 2, "onReceive,resp == null or req == null");
        }
    }
}
