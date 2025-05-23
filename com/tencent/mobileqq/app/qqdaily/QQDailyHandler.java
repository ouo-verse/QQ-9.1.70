package com.tencent.mobileqq.app.qqdaily;

import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0xe27.oidb_cmd0xe27$RspBody;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QQDailyHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private List<a> f196534d;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface a {
        void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, oidb_cmd0xe27$RspBody oidb_cmd0xe27_rspbody);
    }

    public QQDailyHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f196534d = new ArrayList();
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Class) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [tencent.im.oidb.cmd0xe27.oidb_cmd0xe27$RspBody, com.tencent.mobileqq.pb.MessageMicro] */
    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQDailyHandler", 2, "receive from front back report: " + fromServiceMsg.isSuccess());
        }
        ?? r06 = new MessageMicro<oidb_cmd0xe27$RspBody>() { // from class: tencent.im.oidb.cmd0xe27.oidb_cmd0xe27$RspBody
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_test_keep_silence_sec"}, new Object[]{0}, oidb_cmd0xe27$RspBody.class);
            public final PBUInt32Field uint32_test_keep_silence_sec = PBField.initUInt32(0);
        };
        if (OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, r06) == 0) {
            for (a aVar : this.f196534d) {
                if (aVar != 0) {
                    aVar.a(toServiceMsg, fromServiceMsg, r06);
                }
            }
        }
    }
}
