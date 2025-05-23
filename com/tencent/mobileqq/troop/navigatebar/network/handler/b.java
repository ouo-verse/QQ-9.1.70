package com.tencent.mobileqq.troop.navigatebar.network.handler;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.navigatebar.bean.TroopAioNavMsg;
import com.tencent.mobileqq.troop.navigatebar.bean.TroopAioNavMsgCollection;
import com.tencent.mobileqq.troop.navigatebar.f;
import com.tencent.mobileqq.troop.navigatebar.network.TroopAioMessageNavigateBusinessHandler;
import com.tencent.protofile.navigatebar.TroopMsgBox$Event;
import com.tencent.protofile.navigatebar.TroopMsgBox$GetGroupEventsRsp;
import com.tencent.protofile.navigatebar.TroopMsgBox$Group;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.shadow.dynamic.host.Constant;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b extends a<TroopMsgBox$GetGroupEventsRsp> {
    static IPatchRedirector $redirector_;

    public b(TroopAioMessageNavigateBusinessHandler troopAioMessageNavigateBusinessHandler) {
        super(troopAioMessageNavigateBusinessHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopAioMessageNavigateBusinessHandler);
        }
    }

    private void i(TroopMsgBox$GetGroupEventsRsp troopMsgBox$GetGroupEventsRsp, List<TroopAioNavMsgCollection> list) {
        for (TroopMsgBox$Group troopMsgBox$Group : troopMsgBox$GetGroupEventsRsp.groups.get()) {
            if (!troopMsgBox$Group.events.isEmpty()) {
                TroopAioNavMsgCollection troopAioNavMsgCollection = new TroopAioNavMsgCollection();
                troopAioNavMsgCollection.troopId = String.valueOf(troopMsgBox$Group.group_id.get());
                for (TroopMsgBox$Event troopMsgBox$Event : troopMsgBox$Group.events.get()) {
                    TroopAioNavMsg troopAioNavMsg = new TroopAioNavMsg();
                    troopAioNavMsg.troopId = troopAioNavMsgCollection.troopId;
                    troopAioNavMsg.eventRandom = troopMsgBox$Event.event_random.get();
                    troopAioNavMsg.eventType = (int) troopMsgBox$Event.event_type.get();
                    troopAioNavMsg.msgSeq = troopMsgBox$Event.msg_seq.get();
                    troopAioNavMsg.tinyId = troopMsgBox$Event.from_tinyid.get();
                    troopAioNavMsgCollection.msgList.add(troopAioNavMsg);
                }
                list.add(troopAioNavMsgCollection);
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.navigatebar.network.TroopAioMessageNavigateBusinessHandler.a
    @NonNull
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "OidbSvcTrpcTcp.0x1093_0";
    }

    @Override // com.tencent.mobileqq.troop.navigatebar.network.handler.a
    protected int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return f.f297998c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.troop.navigatebar.network.handler.a
    @NonNull
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public TroopMsgBox$GetGroupEventsRsp c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TroopMsgBox$GetGroupEventsRsp) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new TroopMsgBox$GetGroupEventsRsp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.troop.navigatebar.network.handler.a
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void e(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, TroopMsgBox$GetGroupEventsRsp troopMsgBox$GetGroupEventsRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, troopMsgBox$GetGroupEventsRsp);
            return;
        }
        if (!com.tencent.mobileqq.troop.navigatebar.expriment.a.c()) {
            return;
        }
        if (troopMsgBox$GetGroupEventsRsp.has() && troopMsgBox$GetGroupEventsRsp.err_code.get() == 0) {
            if (troopMsgBox$GetGroupEventsRsp.groups.isEmpty()) {
                f(Constant.FROM_ID_START_ACTIVITY, "");
                return;
            }
            ArrayList arrayList = new ArrayList();
            i(troopMsgBox$GetGroupEventsRsp, arrayList);
            g(arrayList);
            return;
        }
        f(troopMsgBox$GetGroupEventsRsp.err_code.get(), troopMsgBox$GetGroupEventsRsp.err_msg.get().toStringUtf8());
    }
}
