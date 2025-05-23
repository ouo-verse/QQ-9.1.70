package com.tencent.mobileqq.app.friendlist.receiver;

import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.da;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x7df.oidb_0x7df$FriendScore;
import tencent.im.oidb.cmd0x7df.oidb_0x7df$RspBody;
import tencent.im.oidb.oidb_0xc26$EntryDelay;
import tencent.im.oidb.oidb_0xc26$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class h extends a {
    static IPatchRedirector $redirector_;

    public h(QQAppInterface qQAppInterface, FriendListHandler friendListHandler) {
        super(qQAppInterface, friendListHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) friendListHandler);
        }
    }

    private void e(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        int i3;
        Bundle bundle;
        Bundle bundle2;
        boolean z17 = false;
        if (fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            z16 = true;
        } else {
            z16 = false;
        }
        oidb_0xc26$RspBody oidb_0xc26_rspbody = new oidb_0xc26$RspBody();
        if (z16) {
            i3 = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xc26_rspbody);
            if (i3 != 0) {
                z16 = false;
            }
        } else {
            i3 = -1;
        }
        MayknowRecommendManager mayknowRecommendManager = (MayknowRecommendManager) this.f195646a.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
        if (toServiceMsg != null && (bundle2 = toServiceMsg.extraData) != null) {
            bundle = bundle2.getBundle("EXTRA:OidbSvc.0xc26_0");
        } else {
            bundle = null;
        }
        if (bundle != null) {
            bundle.getString(FriendListHandler.PARAM_RECOMMEND_TRACE_ID, "");
        }
        if (z16) {
            oidb_0xc26_rspbody.rpt_msg_persons.get();
            List<Integer> list = oidb_0xc26_rspbody.rpt_entry_inuse.get();
            List<oidb_0xc26$EntryDelay> list2 = oidb_0xc26_rspbody.rpt_entry_delays.get();
            int i16 = oidb_0xc26_rspbody.uint32_timestamp.get();
            oidb_0xc26_rspbody.uint32_next_gap.get();
            mayknowRecommendManager.q(list);
            mayknowRecommendManager.r(list2);
            da.a(this.f195646a, oidb_0xc26_rspbody.rpt_msg_undecides.get(), i16);
            z17 = z16;
        }
        if (QLog.isColorLevel()) {
            QLog.i("FriendListHandler.BaseHandlerReceiver", 1, "handleGetMayKnowRecommend, isSuc=" + z17 + ",oidbesult=" + i3);
        }
        b(88, z17, bundle);
        b(108, z17, bundle);
    }

    private void f(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        int i3;
        int i16;
        int i17;
        if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "FriendListHandler.handleSpecialCareRecommend resp: " + fromServiceMsg + ", data: " + obj);
        }
        if (toServiceMsg != null && fromServiceMsg != null && fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            FriendListHandler.getSpecialRecommendStat = 0;
            oidb_0x7df$RspBody oidb_0x7df_rspbody = new oidb_0x7df$RspBody();
            boolean h16 = h(toServiceMsg, fromServiceMsg, obj, z16, oidb_0x7df_rspbody);
            if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "FriendListHandler.handleSpecialCareRecommend isSuccess: " + h16);
            }
            if (h16) {
                b(91, true, oidb_0x7df_rspbody);
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("FriendListHandler.handleSpecialCareRecommend isOver: ");
                    int i18 = -1;
                    if (oidb_0x7df_rspbody.uint32_over.has()) {
                        i3 = oidb_0x7df_rspbody.uint32_over.get();
                    } else {
                        i3 = -1;
                    }
                    sb5.append(i3);
                    sb5.append(", next: ");
                    if (oidb_0x7df_rspbody.uint32_next_start.has()) {
                        i16 = oidb_0x7df_rspbody.uint32_next_start.get();
                    } else {
                        i16 = -1;
                    }
                    sb5.append(i16);
                    sb5.append(", total: ");
                    if (oidb_0x7df_rspbody.uint32_total.has()) {
                        i17 = oidb_0x7df_rspbody.uint32_total.get();
                    } else {
                        i17 = -1;
                    }
                    sb5.append(i17);
                    sb5.append(", lowest: ");
                    if (oidb_0x7df_rspbody.uint32_low_score.has()) {
                        i18 = oidb_0x7df_rspbody.uint32_low_score.get();
                    }
                    sb5.append(i18);
                    QLog.d("FriendListHandler.BaseHandlerReceiver", 2, sb5.toString());
                }
                if (!oidb_0x7df_rspbody.rpt_msg_friend_score.has()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "FriendListHandler.handleSpecialCareRecommend rpt_msg_friend_score has no data.");
                        return;
                    }
                    return;
                }
                List<oidb_0x7df$FriendScore> list = oidb_0x7df_rspbody.rpt_msg_friend_score.get();
                if (list != null && list.size() > 0) {
                    g(list);
                    this.f195647b.onGetSpecialCareRecommend(list);
                    return;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "FriendListHandler.handleSpecialCareRecommend friendList is null or has no data.");
                        return;
                    }
                    return;
                }
            }
        }
        FriendListHandler.getSpecialRecommendStat = 1;
        b(91, false, null);
    }

    private void g(List<oidb_0x7df$FriendScore> list) {
        String str;
        int i3;
        String str2;
        if (QLog.isColorLevel()) {
            for (oidb_0x7df$FriendScore oidb_0x7df_friendscore : list) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("FriendListHandler.handleSpecialCareRecommend uin: ");
                String str3 = "";
                if (!oidb_0x7df_friendscore.uint64_friend_uin.has()) {
                    str = "";
                } else {
                    str = String.valueOf(oidb_0x7df_friendscore.uint64_friend_uin.get());
                }
                sb5.append(str);
                sb5.append(", score: ");
                int i16 = -1;
                if (oidb_0x7df_friendscore.uint32_friend_score.has()) {
                    i3 = oidb_0x7df_friendscore.uint32_friend_score.get();
                } else {
                    i3 = -1;
                }
                sb5.append(i3);
                sb5.append(", relation: ");
                if (!oidb_0x7df_friendscore.bytes_relation_name.has()) {
                    str2 = "";
                } else {
                    str2 = oidb_0x7df_friendscore.bytes_relation_name.get().toStringUtf8();
                }
                sb5.append(str2);
                sb5.append(", rank: ");
                if (oidb_0x7df_friendscore.uint32_rank.has()) {
                    i16 = oidb_0x7df_friendscore.uint32_rank.get();
                }
                sb5.append(i16);
                sb5.append(", nick: ");
                if (oidb_0x7df_friendscore.bytes_nick.has()) {
                    str3 = oidb_0x7df_friendscore.bytes_nick.get().toStringUtf8();
                }
                sb5.append(str3);
                QLog.d("FriendListHandler.BaseHandlerReceiver", 2, sb5.toString());
            }
        }
    }

    private boolean h(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj, boolean z16, oidb_0x7df$RspBody oidb_0x7df_rspbody) {
        oidb_sso$OIDBSSOPkg parseSSOPkg = FriendListHandler.parseSSOPkg(toServiceMsg, fromServiceMsg, obj);
        if (parseSSOPkg != null) {
            try {
                oidb_0x7df_rspbody.mergeFrom(parseSSOPkg.bytes_bodybuffer.get().toByteArray());
                return z16;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "FriendListHandler.handleSpecialCareRecommend RspBody mergeFrom failed.");
                }
                e16.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.friendlist.receiver.a
    public boolean a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        if (!"OidbSvc.0xc26_0".equals(str) && !"OidbSvc.0xc36_0".equals(str) && !"OidbSvc.0x7df_3".equals(str)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.friendlist.receiver.a
    public void c(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if ("OidbSvc.0xc26_0".equals(serviceCmd)) {
            e(toServiceMsg, fromServiceMsg, obj);
        } else if ("OidbSvc.0x7df_3".equals(serviceCmd)) {
            f(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
