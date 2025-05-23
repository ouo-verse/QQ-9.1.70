package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes7.dex */
public class SubType0xef implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public SubType0xef() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void b(MsgType0x210 msgType0x210) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0xef, [linkstar push test]");
        }
        byte[] bArr = msgType0x210.vProtobuf;
        int length = bArr.length;
        if (length < 6) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0xef, [linkstar push test]. vProtoBuf.length is " + length);
            return;
        }
        int i3 = (bArr[0] << 4) + bArr[1];
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 2, bArr2, 0, 4);
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0xef, [linkstar push test]. msgType=" + i3);
        }
        ThreadManager.getUIHandler().post(new Runnable(i3) { // from class: com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xef.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f116594d;

            {
                this.f116594d = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, i3);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                QQToast.makeText(BaseApplication.getContext(), "Linkstar Push!ChooserAc!! msgType = " + this.f116594d, 0).show();
            }
        });
        if (length > 6) {
            int i16 = length - 6;
            byte[] bArr3 = new byte[i16];
            System.arraycopy(msgType0x210.vProtobuf, 6, bArr3, 0, i16);
            com.tencent.mobileqq.app.utils.o.a(i3, bArr2, bArr3);
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        b(msgType0x210);
        return null;
    }
}
