package com.tencent.mobileqq.confess;

import com.tencent.imcore.message.ConversationFacade;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xb67.oidb_0xb67$RspBody;
import tencent.im.oidb.cmd0xbc3.oidb_0xbc3$RspBody;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ConfessHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f202083d;

    public ConfessHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f202083d = qQAppInterface;
        }
    }

    private void D2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg != null && fromServiceMsg != null) {
            long j3 = toServiceMsg.extraData.getLong("fromUin", 0L);
            long j16 = toServiceMsg.extraData.getLong("toUin", 0L);
            int i3 = toServiceMsg.extraData.getInt("topicId", 0);
            int i16 = toServiceMsg.extraData.getInt("type", 0);
            boolean z16 = toServiceMsg.extraData.getBoolean("isConfessor", false);
            if (QLog.isColorLevel()) {
                QLog.i("ConfessHandler", 2, "handleGetHolmesProgress fUin:" + j3 + " tUin:" + j16 + " topicid:" + i3 + " type:" + i16 + " isConfessor:" + z16);
            }
            oidb_0xbc3$RspBody oidb_0xbc3_rspbody = new oidb_0xbc3$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xbc3_rspbody);
            if (parseOIDBPkg == 0) {
                if (oidb_0xbc3_rspbody.uint32_cur_count.has() && oidb_0xbc3_rspbody.uint32_total_count.has()) {
                    int i17 = oidb_0xbc3_rspbody.uint32_cur_count.get();
                    int i18 = oidb_0xbc3_rspbody.uint32_total_count.get();
                    if (QLog.isColorLevel()) {
                        QLog.i("ConfessHandler", 2, "handleGetHolmesProgress curCount:" + i17 + " totalCount:" + i18);
                    }
                    notifyUI(8, true, new Object[]{Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z16)});
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("ConfessHandler", 2, "handleGetHolmesProgress failed no msg");
                }
                notifyUI(8, false, new Object[]{Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Integer.valueOf(i16), 0, 0, Boolean.valueOf(z16)});
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("ConfessHandler", 2, "handleGetHolmesProgress failed result:" + parseOIDBPkg);
            }
            notifyUI(8, false, new Object[]{Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Integer.valueOf(i16), 0, 0, Boolean.valueOf(z16)});
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.confess.ConfessHandler] */
    private void E2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        ConfessInfo confessInfo;
        int i3;
        ?? r152;
        int i16;
        String str;
        char c16;
        boolean z16;
        int i17;
        if (toServiceMsg != null && fromServiceMsg != null) {
            String str2 = "";
            String string = toServiceMsg.extraData.getString("frdUin", "");
            int i18 = toServiceMsg.extraData.getInt("shieldHours", 0);
            int i19 = toServiceMsg.extraData.getInt("uinType", 0);
            int i26 = toServiceMsg.extraData.getInt("topicId", 0);
            try {
                confessInfo = (ConfessInfo) toServiceMsg.extraData.getSerializable("confessInfo");
            } catch (Exception unused) {
                confessInfo = null;
            }
            oidb_0xb67$RspBody oidb_0xb67_rspbody = new oidb_0xb67$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xb67_rspbody);
            if (parseOIDBPkg != 0) {
                String str3 = "";
                String stringUtf8 = oidb_0xb67_rspbody.bytes_err_msg.get().toStringUtf8();
                if (QLog.isColorLevel()) {
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(parseOIDBPkg);
                    if (stringUtf8 != null) {
                        str3 = stringUtf8;
                    }
                    objArr[1] = str3;
                    QLog.i("ConfessHandler", 2, String.format("handleSetShieldFlag failed result:%d msg:%s", objArr));
                }
                notifyUI(3, false, new Object[]{string, Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i18), stringUtf8, null});
                return;
            }
            if (oidb_0xb67_rspbody.uint32_result.has()) {
                i3 = oidb_0xb67_rspbody.uint32_result.get();
            } else {
                i3 = 0;
            }
            if (oidb_0xb67_rspbody.bytes_err_msg.has()) {
                str2 = oidb_0xb67_rspbody.bytes_err_msg.get().toStringUtf8();
            }
            if (i3 == 0) {
                if (i18 == -1) {
                    z16 = true;
                    i17 = 6;
                    str = "ConfessHandler";
                    ConfessMsgUtil.a(this.f202083d, string, ConfessConfig.O, i19, i26, confessInfo);
                } else {
                    z16 = true;
                    i17 = 6;
                    str = "ConfessHandler";
                    ConfessMsgUtil.b(this.f202083d, string, i19, i26, confessInfo);
                }
                Object[] objArr2 = new Object[i17];
                objArr2[0] = string;
                objArr2[z16 ? 1 : 0] = Integer.valueOf(i19);
                objArr2[2] = Integer.valueOf(i26);
                c16 = 3;
                objArr2[3] = Integer.valueOf(i18);
                objArr2[4] = null;
                objArr2[5] = confessInfo;
                notifyUI(3, z16, objArr2);
                i16 = 4;
                r152 = z16;
            } else {
                r152 = 1;
                i16 = 4;
                str = "ConfessHandler";
                c16 = 3;
                notifyUI(3, false, new Object[]{string, Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i18), str2, null});
            }
            if (QLog.isColorLevel()) {
                Object[] objArr3 = new Object[i16];
                objArr3[0] = Integer.valueOf(parseOIDBPkg);
                objArr3[r152] = Integer.valueOf(i3);
                objArr3[2] = string;
                objArr3[c16] = Integer.valueOf(i18);
                QLog.i(str, 2, String.format("handleSetShieldFlag result:%d rspResult:%d frdUin:%s hours:%d", objArr3));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void I2(QQAppInterface qQAppInterface, ConfessConfig confessConfig) {
        long K0 = com.tencent.mobileqq.service.message.e.K0();
        long d16 = ConfessConfig.d(qQAppInterface, "redpoint_box_show");
        boolean z16 = false;
        if (QLog.isColorLevel()) {
            QLog.i("ConfessHandler", 2, String.format("onNeedShowBoxRedPoint oldRedPointTs:%d", Long.valueOf(d16)));
        }
        ConfessConfig.l(qQAppInterface, "redpoint_box_show", K0);
        ConfessMsgUtil.t(qQAppInterface, false, true);
        ConversationFacade G = qQAppInterface.getMessageFacade().G();
        String str = AppConstants.CONFESS_UIN;
        G.h(str, 1032);
        RecentUserProxy m3 = qQAppInterface.getProxyManager().m();
        RecentUser findRecentUser = m3.findRecentUser(str, 1032);
        if (findRecentUser == null) {
            findRecentUser = new RecentUser(str, 1032);
            findRecentUser.lastmsgtime = K0;
        } else {
            if (findRecentUser.lastmsgtime < K0) {
                findRecentUser.lastmsgtime = K0;
            }
            if (z16) {
                m3.saveRecentUser(findRecentUser);
                MqqHandler handler = qQAppInterface.getHandler(Conversation.class);
                if (handler != null) {
                    handler.sendEmptyMessage(1009);
                }
            }
            notifyUI(4, true, confessConfig);
        }
        z16 = true;
        if (z16) {
        }
        notifyUI(4, true, confessConfig);
    }

    private void J2(QQAppInterface qQAppInterface, ConfessConfig confessConfig) {
        if (QLog.isColorLevel()) {
            QLog.i("ConfessHandler", 2, "onNeedShowLebaRedPoint");
        }
        ConfessConfig.l(qQAppInterface, "redpoint_leba_show", com.tencent.mobileqq.service.message.e.K0());
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void F2(d dVar) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) dVar);
            return;
        }
        if (this.f202083d == null) {
            return;
        }
        if (dVar != null && dVar.b()) {
            RecentUserProxy m3 = this.f202083d.getProxyManager().m();
            String str = AppConstants.CONFESS_UIN;
            RecentUser findRecentUser = m3.findRecentUser(str, 1032);
            if (findRecentUser == null) {
                findRecentUser = new RecentUser();
                findRecentUser.uin = str;
                findRecentUser.setType(1032);
                findRecentUser.lastmsgtime = dVar.f202179e;
            } else {
                long j3 = findRecentUser.lastmsgtime;
                long j16 = dVar.f202179e;
                if (j3 < j16) {
                    findRecentUser.lastmsgtime = j16;
                } else {
                    z16 = false;
                    if (z16) {
                        m3.saveRecentUser(findRecentUser);
                        MqqHandler handler = this.f202083d.getHandler(Conversation.class);
                        if (handler != null) {
                            handler.sendEmptyMessage(1009);
                        }
                    }
                }
            }
            z16 = true;
            if (z16) {
            }
        }
        notifyUI(1, true, null);
    }

    public void G2(d dVar) {
        MqqHandler handler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) dVar);
            return;
        }
        QQAppInterface qQAppInterface = this.f202083d;
        if (qQAppInterface == null) {
            return;
        }
        if (qQAppInterface.getProxyManager().m().findRecentUser(AppConstants.CONFESS_UIN, 1032) != null && (handler = this.f202083d.getHandler(Conversation.class)) != null) {
            handler.sendEmptyMessage(1009);
        }
        notifyUI(2, true, dVar);
    }

    public void H2(QQAppInterface qQAppInterface, ConfessConfig confessConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) qQAppInterface, (Object) confessConfig);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ConfessHandler", 2, String.format("onGetNewConfig boxEntry:%d contactEntry:%d", Integer.valueOf(confessConfig.f202074r), Integer.valueOf(confessConfig.f202075s)));
        }
        if (confessConfig.f202074r == 2) {
            I2(qQAppInterface, confessConfig);
        }
        if (confessConfig.f202075s == 2) {
            J2(qQAppInterface, confessConfig);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Set) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvc.cmd0xb67");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Class) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return b.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if ("OidbSvc.cmd0xb67".equals(serviceCmd)) {
            E2(toServiceMsg, fromServiceMsg, obj);
        } else if ("OidbSvc.cmd0xbc3".equals(serviceCmd)) {
            D2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
