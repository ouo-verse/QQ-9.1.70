package com.tencent.mobileqq.location.net;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import tencent.im.oidb.cmd0x857.TroopTips0x857$LbsShareChangePushInfo;
import tencent.im.oidb.cmd0x857.TroopTips0x857$NotifyMsgBody;

/* compiled from: P */
/* loaded from: classes15.dex */
public class g {
    static IPatchRedirector $redirector_;

    public static void a(AppInterface appInterface, TroopTips0x857$NotifyMsgBody troopTips0x857$NotifyMsgBody) {
        TroopTips0x857$LbsShareChangePushInfo troopTips0x857$LbsShareChangePushInfo = troopTips0x857$NotifyMsgBody.opt_lbs_share_change_plus_info.get();
        com.tencent.mobileqq.location.e.b(appInterface).processTroopPush(new com.tencent.mobileqq.location.data.b(troopTips0x857$LbsShareChangePushInfo.uint32_msg_type.get(), troopTips0x857$LbsShareChangePushInfo.uint64_group_id.get(), troopTips0x857$LbsShareChangePushInfo.uint64_oper_uin.get(), troopTips0x857$LbsShareChangePushInfo.bytes_ext_info.get().toByteArray()));
    }
}
