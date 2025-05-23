package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.HttpUrl;
import tencent.im.oidb.cmd0xea3.oidb_0xea3$BackMsg;
import tencent.im.oidb.cmd0xea3.oidb_0xea3$ReqBody;
import tencent.im.oidb.cmd0xea3.oidb_0xea3$RspBody;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private AppInterface f298731a;

    /* renamed from: b, reason: collision with root package name */
    private long f298732b;

    /* renamed from: c, reason: collision with root package name */
    private int f298733c;

    /* renamed from: d, reason: collision with root package name */
    private long f298734d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<Long> f298735e;

    /* renamed from: f, reason: collision with root package name */
    private List<oidb_0xea3$BackMsg> f298736f;

    /* renamed from: g, reason: collision with root package name */
    private List<Long> f298737g;

    private void a(oidb_0xea3$RspBody oidb_0xea3_rspbody) {
        QLog.i("Oidb0xea3Sender", 2, "handleTroopImportantMsg_suc troopUin:" + this.f298732b);
        TroopShortcutBarHandler troopShortcutBarHandler = (TroopShortcutBarHandler) this.f298731a.getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE);
        if (troopShortcutBarHandler == null) {
            return;
        }
        if (oidb_0xea3_rspbody.back_group_msg.has()) {
            this.f298736f.addAll(oidb_0xea3_rspbody.back_group_msg.get());
        }
        troopShortcutBarHandler.notifyUI(4, true, new Object[]{Long.valueOf(this.f298732b), this.f298736f, this.f298737g});
        d();
    }

    private void b(oidb_0xea3$RspBody oidb_0xea3_rspbody) {
        QLog.i("Oidb0xea3Sender", 2, "handleTroopImportantMsg_tryNex troopUin:" + this.f298732b + ",retryCount" + this.f298733c);
        if (oidb_0xea3_rspbody.back_group_msg.has()) {
            for (oidb_0xea3$BackMsg oidb_0xea3_backmsg : oidb_0xea3_rspbody.back_group_msg.get()) {
                if (oidb_0xea3_backmsg.f435995msg.has() && oidb_0xea3_backmsg.addition_seq.has()) {
                    this.f298735e.add(Long.valueOf(oidb_0xea3_backmsg.addition_seq.get()));
                    this.f298736f.add(oidb_0xea3_backmsg);
                }
            }
        }
        e();
    }

    private void d() {
        String obj;
        if (QLog.isColorLevel()) {
            ArrayList arrayList = new ArrayList();
            List<oidb_0xea3$BackMsg> list = this.f298736f;
            if (list != null) {
                Iterator<oidb_0xea3$BackMsg> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(Long.valueOf(it.next().addition_seq.get()));
                }
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("msgSeqs:");
            sb5.append(arrayList.toString());
            sb5.append(" mRspUnchangeSeqs:");
            List<Long> list2 = this.f298737g;
            if (list2 == null) {
                obj = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            } else {
                obj = list2.toString();
            }
            sb5.append(obj);
            QLog.i("Oidb0xea3Sender", 2, sb5.toString());
        }
    }

    public boolean c(FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) fromServiceMsg, obj)).booleanValue();
        }
        if (((TroopShortcutBarHandler) this.f298731a.getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE)) == null) {
            return true;
        }
        oidb_0xea3$RspBody oidb_0xea3_rspbody = new oidb_0xea3$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xea3_rspbody);
        if (parseOIDBPkg == 0) {
            if (this.f298737g == null && oidb_0xea3_rspbody.return_unchange_seq.has()) {
                this.f298737g = oidb_0xea3_rspbody.return_unchange_seq.get();
            }
            a(oidb_0xea3_rspbody);
            return true;
        }
        if (parseOIDBPkg >= 1900 && parseOIDBPkg <= 2900) {
            QLog.e("Oidb0xea3Sender", 2, "handleTroopImportantMsg troopUin:" + this.f298732b + ",result: " + parseOIDBPkg);
            if (this.f298737g == null && oidb_0xea3_rspbody.return_unchange_seq.has()) {
                this.f298737g = oidb_0xea3_rspbody.return_unchange_seq.get();
            }
            int i3 = this.f298733c + 1;
            this.f298733c = i3;
            if (i3 >= 3) {
                a(oidb_0xea3_rspbody);
                return true;
            }
            b(oidb_0xea3_rspbody);
            return false;
        }
        QLog.e("Oidb0xea3Sender", 2, "handleTroopImportantMsg troopUin:" + this.f298732b + ",result: " + parseOIDBPkg);
        a(oidb_0xea3_rspbody);
        return true;
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        TroopShortcutBarHandler troopShortcutBarHandler = (TroopShortcutBarHandler) this.f298731a.getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE);
        if (troopShortcutBarHandler == null) {
            return;
        }
        QLog.i("Oidb0xea3Sender", 2, "getTroopImportantMsgInternal troopUin:" + this.f298732b + ",msgSeqs: " + this.f298735e.toString() + ",retryCount" + this.f298733c);
        oidb_0xea3$ReqBody oidb_0xea3_reqbody = new oidb_0xea3$ReqBody();
        oidb_0xea3_reqbody.group_code.set(this.f298732b);
        Iterator<Long> it = this.f298735e.iterator();
        while (it.hasNext()) {
            oidb_0xea3_reqbody.msg_seq.add(it.next());
        }
        ToServiceMsg makeOIDBPkg = troopShortcutBarHandler.makeOIDBPkg("OidbSvcTcp.0xea3", 3747, 1, oidb_0xea3_reqbody.toByteArray(), 30000L);
        makeOIDBPkg.extraData.putLong("sendSeq", this.f298734d);
        troopShortcutBarHandler.sendPbReq(makeOIDBPkg);
    }
}
