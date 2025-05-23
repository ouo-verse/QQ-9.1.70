package com.tencent.mobileqq.troop.navigatebar.network.handler;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.navigatebar.f;
import com.tencent.mobileqq.troop.navigatebar.network.TroopAioMessageNavigateBusinessHandler;
import com.tencent.protofile.navigatebar.TroopMsgBox$ReportRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes19.dex */
public class d extends a<TroopMsgBox$ReportRsp> {
    static IPatchRedirector $redirector_;

    public d(TroopAioMessageNavigateBusinessHandler troopAioMessageNavigateBusinessHandler) {
        super(troopAioMessageNavigateBusinessHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopAioMessageNavigateBusinessHandler);
        }
    }

    @Override // com.tencent.mobileqq.troop.navigatebar.network.TroopAioMessageNavigateBusinessHandler.a
    @NonNull
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "OidbSvcTrpcTcp.0x1094_0";
    }

    @Override // com.tencent.mobileqq.troop.navigatebar.network.handler.a
    protected int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return f.f297999d;
    }

    @Override // com.tencent.mobileqq.troop.navigatebar.network.handler.a
    protected void f(long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w("TroopAioNav", 2, getClass().getSimpleName() + " notifyUIFail: code = " + j3 + "\uff0c msg = " + str);
        }
    }

    @Override // com.tencent.mobileqq.troop.navigatebar.network.handler.a
    protected void g(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, obj);
        } else if (QLog.isColorLevel()) {
            QLog.w("TroopAioNav", 2, getClass().getSimpleName() + " notifyUISuccess");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.tencent.protofile.navigatebar.TroopMsgBox$ReportRsp] */
    @Override // com.tencent.mobileqq.troop.navigatebar.network.handler.a
    @NonNull
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public TroopMsgBox$ReportRsp c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TroopMsgBox$ReportRsp) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new MessageMicro<TroopMsgBox$ReportRsp>() { // from class: com.tencent.protofile.navigatebar.TroopMsgBox$ReportRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"groups"}, new Object[]{null}, TroopMsgBox$ReportRsp.class);
            public final PBRepeatMessageField<TroopMsgBox$GroupReport> groups = PBField.initRepeatMessage(TroopMsgBox$GroupReport.class);
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.troop.navigatebar.network.handler.a
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void e(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, TroopMsgBox$ReportRsp troopMsgBox$ReportRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, troopMsgBox$ReportRsp);
        } else {
            g(null);
        }
    }
}
