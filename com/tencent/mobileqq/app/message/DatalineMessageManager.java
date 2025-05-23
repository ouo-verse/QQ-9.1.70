package com.tencent.mobileqq.app.message;

import android.os.Handler;
import android.os.Looper;
import com.dataline.activities.LiteActivity;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class DatalineMessageManager implements IMessageManager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected QQAppInterface f195835d;

    /* renamed from: e, reason: collision with root package name */
    protected QQMessageFacade f195836e;

    /* renamed from: f, reason: collision with root package name */
    protected String f195837f;

    /* renamed from: h, reason: collision with root package name */
    protected int f195838h;

    public DatalineMessageManager(QQAppInterface qQAppInterface, QQMessageFacade qQMessageFacade) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) qQMessageFacade);
            return;
        }
        this.f195837f = AppConstants.DATALINE_PC_UIN;
        this.f195838h = 6000;
        this.f195835d = qQAppInterface;
        this.f195836e = qQMessageFacade;
    }

    public long a(DataLineMsgRecord dataLineMsgRecord, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, this, dataLineMsgRecord, Boolean.valueOf(z16))).longValue();
        }
        if (dataLineMsgRecord == null) {
            if (QLog.isColorLevel()) {
                QLog.w("Q.msg.DatalineMessageManager", 2, "mr is null");
                return -1L;
            }
            return -1L;
        }
        if (!dataLineMsgRecord.isSend()) {
            this.f195835d.getDatalineMsgDBTransformer().a(DataLineMsgRecord.getDevTypeBySeId(dataLineMsgRecord.sessionid));
            com.tencent.mobileqq.filemanager.fileassistant.util.e eVar = new com.tencent.mobileqq.filemanager.fileassistant.util.e(this.f195835d);
            eVar.b(dataLineMsgRecord);
            ChatMessage e16 = eVar.e();
            e16.isread = false;
            new com.tencent.mobileqq.filemanager.fileassistant.util.d(this.f195835d).a(e16);
            ((DataLineHandler) this.f195835d.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).e3();
        }
        p();
        return 0L;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            c().l();
        }
    }

    protected DataLineMsgProxy c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (DataLineMsgProxy) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.f195835d.getDataLineMsgProxy(0);
    }

    public DataLineMsgRecord d(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (DataLineMsgRecord) iPatchRedirector.redirect((short) 5, (Object) this, j3);
        }
        return c().t(j3);
    }

    public void e(int i3, DataLineMsgProxy.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3, (Object) aVar);
        } else {
            c().z(i3, aVar);
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            c().B();
        }
    }

    public int g(DataLineMsgSet dataLineMsgSet) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this, (Object) dataLineMsgSet)).intValue();
        }
        Looper mainLooper = Looper.getMainLooper();
        boolean z16 = false;
        if (Thread.currentThread() == mainLooper.getThread()) {
            int C = c().C(dataLineMsgSet);
            if (C > 0) {
                String f16 = ao.f(String.valueOf(this.f195837f), this.f195838h);
                if (this.f195836e.f116349e.containsKey(f16)) {
                    z16 = this.f195836e.f116349e.get(f16).hasReply;
                    this.f195836e.f116349e.remove(f16);
                }
                long size = c().f().size();
                if (size > 0) {
                    DataLineMsgRecord q16 = c().q();
                    if (q16 != null && (((i3 = q16.msgtype) == -5000 || i3 == -5041 || i3 == -2073) && size > 1)) {
                        q16 = c().f().get((int) (size - 2)).getLastItem();
                    }
                    Message message = new Message();
                    if (q16 != null) {
                        MessageRecord.copyMessageRecordBaseField(message, q16);
                        message.emoRecentMsg = null;
                        message.hasReply = z16;
                        this.f195836e.w(message);
                        this.f195836e.f116349e.put(ao.f(String.valueOf(this.f195837f), this.f195838h), message);
                    }
                }
                DataLineMsgRecord dataLineMsgRecord = new DataLineMsgRecord();
                dataLineMsgRecord.selfuin = this.f195837f;
                this.f195836e.K0(dataLineMsgRecord);
            }
            return C;
        }
        new Handler(mainLooper).post(new Runnable(dataLineMsgSet) { // from class: com.tencent.mobileqq.app.message.DatalineMessageManager.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ DataLineMsgSet f195840d;

            {
                this.f195840d = dataLineMsgSet;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DatalineMessageManager.this, (Object) dataLineMsgSet);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z17;
                int i16;
                int i17;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (DatalineMessageManager.this.c().C(this.f195840d) > 0) {
                    String f17 = ao.f(String.valueOf(DatalineMessageManager.this.f195837f), DatalineMessageManager.this.f195838h);
                    if (DatalineMessageManager.this.f195836e.f116349e.containsKey(f17)) {
                        z17 = DatalineMessageManager.this.f195836e.f116349e.get(f17).hasReply;
                        i16 = DatalineMessageManager.this.f195836e.f116349e.get(f17).counter;
                        DatalineMessageManager.this.f195836e.f116349e.remove(f17);
                    } else {
                        z17 = false;
                        i16 = 0;
                    }
                    long size2 = DatalineMessageManager.this.c().f().size();
                    if (size2 > 0) {
                        DataLineMsgRecord q17 = DatalineMessageManager.this.c().q();
                        if (q17 != null && (((i17 = q17.msgtype) == -5000 || i17 == -5041 || i17 == -2073) && size2 > 1)) {
                            q17 = DatalineMessageManager.this.c().f().get((int) (size2 - 2)).getLastItem();
                        }
                        Message message2 = new Message();
                        if (q17 != null) {
                            MessageRecord.copyMessageRecordBaseField(message2, q17);
                            message2.emoRecentMsg = null;
                            message2.counter = i16;
                            message2.hasReply = z17;
                            DatalineMessageManager.this.f195836e.w(message2);
                            DatalineMessageManager datalineMessageManager = DatalineMessageManager.this;
                            datalineMessageManager.f195836e.f116349e.put(ao.f(String.valueOf(datalineMessageManager.f195837f), DatalineMessageManager.this.f195838h), message2);
                        }
                    }
                    DataLineMsgRecord dataLineMsgRecord2 = new DataLineMsgRecord();
                    DatalineMessageManager datalineMessageManager2 = DatalineMessageManager.this;
                    dataLineMsgRecord2.selfuin = datalineMessageManager2.f195837f;
                    datalineMessageManager2.f195836e.K0(dataLineMsgRecord2);
                }
            }
        });
        return 0;
    }

    public int h(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this, j3)).intValue();
        }
        DataLineMsgSet v3 = c().v(j3);
        if (v3 == null) {
            return -1;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() == mainLooper.getThread()) {
            return g(v3);
        }
        new Handler(mainLooper).post(new Runnable(v3) { // from class: com.tencent.mobileqq.app.message.DatalineMessageManager.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ DataLineMsgSet f195839d;

            {
                this.f195839d = v3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DatalineMessageManager.this, (Object) v3);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    DatalineMessageManager.this.g(this.f195839d);
                }
            }
        });
        return 0;
    }

    public void i(long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Long.valueOf(j3), str);
        } else {
            c().E(j3, str);
        }
    }

    public void j(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, j3);
        } else {
            c().F(j3);
        }
    }

    public void k(long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Long.valueOf(j3), str);
        } else {
            c().H(j3, str);
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        if (!LiteActivity.class.getName().equals(ConfigHandler.O2(BaseApplication.getContext()))) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.DatalineMessageManager", 2, "setDataLineMsgReaded,unread=" + this.f195836e.G().R(this.f195837f, this.f195838h));
        }
        if (this.f195836e.G().R(this.f195837f, this.f195838h) > 0) {
            c().K();
            this.f195836e.G().r(this.f195837f, this.f195838h, true);
            this.f195836e.K0(this.f195836e.getLastMessage(this.f195837f, this.f195838h));
        }
    }

    public void m(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, j3);
        } else {
            c().L(j3);
        }
    }

    public void n(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, j3);
        } else {
            c().M(j3);
        }
    }

    public void o(long j3, String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Long.valueOf(j3), str, bArr);
        } else {
            c().I(j3, str, bArr);
        }
    }

    protected void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            ((DataLineHandler) this.f195835d.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).A4(false);
        }
    }
}
