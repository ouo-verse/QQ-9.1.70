package com.tencent.mobileqq.nearby.redtouch;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x6cd$PullRedpointReq;
import tencent.im.oidb.cmd0x6cd$RedpointInfo;
import tencent.im.oidb.cmd0x6cd$ReqBody;
import tencent.im.oidb.cmd0x6cd$RspBody;
import tencent.im.oidb.cmd0x6ce$ReadRedpointReq;
import tencent.im.oidb.cmd0x6ce$ReqBody;
import tencent.im.oidb.cmd0x6ce$RspBody;
import tencent.im.oidb.cmd0x6f5$ReqBody;
import tencent.im.oidb.cmd0x6f5$RspBody;

/* compiled from: P */
/* loaded from: classes15.dex */
public class RedtouchHandler extends BusinessHandler {
    public RedtouchHandler(AppInterface appInterface) {
        super(appInterface);
    }

    private void E2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        LocalRedTouchManager localRedTouchManager;
        if (QLog.isColorLevel()) {
            QLog.i("RedtouchHandler", 2, "handleGetRedPointConfigs");
        }
        cmd0x6f5$RspBody cmd0x6f5_rspbody = new cmd0x6f5$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, cmd0x6f5_rspbody);
        if (QLog.isColorLevel()) {
            QLog.i("RedtouchHandler", 2, "handleGetRedPointConfigs, errCode=" + parseOIDBPkg);
        }
        if (parseOIDBPkg == 0 && cmd0x6f5_rspbody.str_config_version.has()) {
            String str = cmd0x6f5_rspbody.str_config_version.get();
            if (QLog.isColorLevel()) {
                QLog.i("RedtouchHandler", 2, "handleGetRedPointConfigs, server configVersion=" + str);
            }
            if (!TextUtils.isEmpty(str) && (localRedTouchManager = (LocalRedTouchManager) this.appRuntime.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER)) != null) {
                localRedTouchManager.D(str);
                localRedTouchManager.A(cmd0x6f5_rspbody);
                localRedTouchManager.k();
            }
        }
    }

    private void F2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        List<cmd0x6cd$RedpointInfo> list;
        ArrayList arrayList;
        if (QLog.isColorLevel()) {
            QLog.i("RedtouchHandler", 2, "handlePullRedTouch");
        }
        if (toServiceMsg != null && fromServiceMsg != null) {
            boolean z16 = false;
            boolean z17 = toServiceMsg.extraData.getBoolean("is_single_task", false);
            if (z17) {
                i3 = toServiceMsg.extraData.getInt("task_id");
            } else {
                i3 = 0;
            }
            cmd0x6cd$RspBody cmd0x6cd_rspbody = new cmd0x6cd$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, cmd0x6cd_rspbody);
            LocalRedTouchManager localRedTouchManager = (LocalRedTouchManager) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
            if (localRedTouchManager == null) {
                return;
            }
            List<cmd0x6cd$PullRedpointReq> list2 = null;
            if (parseOIDBPkg == 0) {
                if (QLog.isColorLevel()) {
                    QLog.i("RedtouchHandler", 2, "handlePullRedTouch success.");
                }
                if (cmd0x6cd_rspbody.rpt_msg_redpoint.has()) {
                    list = cmd0x6cd_rspbody.rpt_msg_redpoint.get();
                } else {
                    list = null;
                }
                if (list != null) {
                    arrayList = new ArrayList(list.size());
                    for (int i16 = 0; i16 < list.size(); i16++) {
                        RedTouchItem redTouchItem = RedTouchItem.getRedTouchItem(list.get(i16));
                        if (!z17 || redTouchItem.taskId == i3) {
                            arrayList.add(redTouchItem);
                        }
                    }
                } else {
                    arrayList = null;
                }
                if (cmd0x6cd_rspbody.rpt_unfinished_redpoint.has()) {
                    list2 = cmd0x6cd_rspbody.rpt_unfinished_redpoint.get();
                }
                if (list2 != null && list2.size() > 0) {
                    H2(list2, z17);
                    z16 = true;
                }
                list2 = arrayList;
            } else if (QLog.isColorLevel()) {
                QLog.i("RedtouchHandler", 2, "handlePullRedTouch failed:" + parseOIDBPkg);
            }
            localRedTouchManager.p(list2, z16);
        }
    }

    private void G2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (QLog.isColorLevel()) {
            QLog.i("RedtouchHandler", 2, "handleReportTouchClick");
        }
        if (toServiceMsg != null && fromServiceMsg != null) {
            int i3 = toServiceMsg.extraData.getInt("redPointId", 0);
            if (OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, new MessageMicro<cmd0x6ce$RspBody>() { // from class: tencent.im.oidb.cmd0x6ce$RspBody
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], cmd0x6ce$RspBody.class);
            }) == 0) {
                if (QLog.isColorLevel()) {
                    QLog.i("RedtouchHandler", 2, "handleReportTouchClick success. taskId:" + i3);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("RedtouchHandler", 2, "handleReportTouchClick faild. taskId:" + i3);
            }
        }
    }

    public void D2() {
        if (QLog.isColorLevel()) {
            QLog.i("RedtouchHandler", 2, "getRedPointConfigs(), client version : " + AppSetting.f99551k);
        }
        cmd0x6f5$ReqBody cmd0x6f5_reqbody = new cmd0x6f5$ReqBody();
        cmd0x6f5_reqbody.uint32_qq_platform.set(1);
        cmd0x6f5_reqbody.str_qq_version.set(AppSetting.f99551k);
        sendPbReq(makeOIDBPkg("OidbSvc.cmd0x6f5", 1781, 0, cmd0x6f5_reqbody.toByteArray()));
    }

    public void H2(List<cmd0x6cd$PullRedpointReq> list, boolean z16) {
        Object valueOf;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("pullRedTouch, list size=");
            if (list == null) {
                valueOf = "";
            } else {
                valueOf = Integer.valueOf(list.size());
            }
            sb5.append(valueOf);
            sb5.append(", isSingleTask=");
            sb5.append(z16);
            QLog.i("RedtouchHandler", 2, sb5.toString());
        }
        if (list != null && list.size() != 0) {
            cmd0x6cd$ReqBody cmd0x6cd_reqbody = new cmd0x6cd$ReqBody();
            if (z16) {
                cmd0x6cd_reqbody.msg_pull_single_task.set(list.get(0));
            } else {
                cmd0x6cd_reqbody.rpt_last_pull_redpoint.set(list);
            }
            cmd0x6cd_reqbody.uint32_ret_msg_rec.set(1);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.cmd0x6cd", 1741, 0, cmd0x6cd_reqbody.toByteArray());
            makeOIDBPkg.extraData.putBoolean("is_single_task", z16);
            if (z16) {
                makeOIDBPkg.extraData.putInt("task_id", list.get(0).uint32_taskid.get());
            }
            super.sendPbReq(makeOIDBPkg);
        }
    }

    public void I2(List<cmd0x6ce$ReadRedpointReq> list) {
        if (QLog.isColorLevel()) {
            QLog.i("RedtouchHandler", 2, "reportRedTouchClick, redPointId=" + list.get(0).uint32_appid.get());
        }
        cmd0x6ce$ReqBody cmd0x6ce_reqbody = new cmd0x6ce$ReqBody();
        cmd0x6ce_reqbody.rpt_msg_read_req.set(list);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.cmd0x6ce", 1742, 0, cmd0x6ce_reqbody.toByteArray());
        makeOIDBPkg.extraData.putInt("redPointId", list.get(0).uint32_appid.get());
        super.sendPbReq(makeOIDBPkg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvc.cmd0x6f5");
            this.allowCmdSet.add("OidbSvc.cmd0x6cd");
            this.allowCmdSet.add("OidbSvc.cmd0x6ce");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if ("OidbSvc.cmd0x6cd".equals(serviceCmd)) {
            F2(toServiceMsg, fromServiceMsg, obj);
        } else if ("OidbSvc.cmd0x6ce".equals(serviceCmd)) {
            G2(toServiceMsg, fromServiceMsg, obj);
        } else if ("OidbSvc.cmd0x6f5".equals(serviceCmd)) {
            E2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
