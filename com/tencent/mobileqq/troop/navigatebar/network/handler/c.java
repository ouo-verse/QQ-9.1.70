package com.tencent.mobileqq.troop.navigatebar.network.handler;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.navigatebar.ITroopAioMsgNavigateService;
import com.tencent.mobileqq.troop.navigatebar.bean.TroopAioNavMsg;
import com.tencent.mobileqq.troop.navigatebar.bean.TroopAioNavMsgCollection;
import com.tencent.mobileqq.troop.navigatebar.f;
import com.tencent.mobileqq.troop.navigatebar.network.TroopAioMessageNavigateBusinessHandler;
import com.tencent.protofile.navigatebar.TroopMsgBox$Event;
import com.tencent.protofile.navigatebar.TroopMsgBox$GetRsp;
import com.tencent.protofile.navigatebar.TroopMsgBox$GroupEvent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c extends a<TroopMsgBox$GetRsp> {
    static IPatchRedirector $redirector_;

    public c(TroopAioMessageNavigateBusinessHandler troopAioMessageNavigateBusinessHandler) {
        super(troopAioMessageNavigateBusinessHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopAioMessageNavigateBusinessHandler);
        }
    }

    private void i(TroopMsgBox$GetRsp troopMsgBox$GetRsp, List<TroopAioNavMsgCollection> list) {
        if (troopMsgBox$GetRsp.group_events.isEmpty()) {
            return;
        }
        for (TroopMsgBox$GroupEvent troopMsgBox$GroupEvent : troopMsgBox$GetRsp.group_events.get()) {
            if (!troopMsgBox$GroupEvent.events.isEmpty()) {
                TroopAioNavMsgCollection troopAioNavMsgCollection = new TroopAioNavMsgCollection();
                troopAioNavMsgCollection.troopId = String.valueOf(troopMsgBox$GroupEvent.group_id.get());
                list.add(troopAioNavMsgCollection);
                for (TroopMsgBox$Event troopMsgBox$Event : troopMsgBox$GroupEvent.events.get()) {
                    TroopAioNavMsg troopAioNavMsg = new TroopAioNavMsg();
                    troopAioNavMsg.troopId = troopAioNavMsgCollection.troopId;
                    troopAioNavMsg.eventRandom = troopMsgBox$Event.event_random.get();
                    troopAioNavMsg.eventType = (int) troopMsgBox$Event.event_type.get();
                    troopAioNavMsg.msgSeq = troopMsgBox$Event.msg_seq.get();
                    troopAioNavMsg.tinyId = troopMsgBox$Event.from_tinyid.get();
                    troopAioNavMsgCollection.msgList.add(troopAioNavMsg);
                }
            }
        }
    }

    private void k(PBBytesField pBBytesField) {
        String a16 = com.tencent.mobileqq.troop.navigatebar.expriment.a.a(pBBytesField.get().toByteArray());
        if (QLog.isColorLevel()) {
            QLog.d("GetAtMeMsgReceiveHandler", 2, "saveLastCookie cookie : " + pBBytesField);
        }
        if (TextUtils.isEmpty(a16)) {
            return;
        }
        ((ITroopAioMsgNavigateService) this.f298008a.getApp().getRuntimeService(ITroopAioMsgNavigateService.class, "")).saveLastCookie(a16);
    }

    @Override // com.tencent.mobileqq.troop.navigatebar.network.TroopAioMessageNavigateBusinessHandler.a
    @NonNull
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "OidbSvcTrpcTcp.0x1092_0";
    }

    @Override // com.tencent.mobileqq.troop.navigatebar.network.handler.a
    protected int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return f.f297997b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.troop.navigatebar.network.handler.a
    @NonNull
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public TroopMsgBox$GetRsp c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TroopMsgBox$GetRsp) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new TroopMsgBox$GetRsp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.troop.navigatebar.network.handler.a
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void e(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, TroopMsgBox$GetRsp troopMsgBox$GetRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, troopMsgBox$GetRsp);
            return;
        }
        if (troopMsgBox$GetRsp.has() && troopMsgBox$GetRsp.err_code.get() == 0) {
            ArrayList arrayList = new ArrayList();
            i(troopMsgBox$GetRsp, arrayList);
            k(troopMsgBox$GetRsp.cookie);
            g(arrayList);
            return;
        }
        f(troopMsgBox$GetRsp.err_code.get(), troopMsgBox$GetRsp.err_msg.get().toStringUtf8());
    }
}
