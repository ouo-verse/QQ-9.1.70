package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.LogTag;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QQWalletTransferMsg implements ISafeStream {
    private int channelId;
    public String listId;
    private int resend;
    public int templateId;
    public QQWalletAioBodyReserve body = new QQWalletAioBodyReserve();
    public vk2.b elem = new vk2.b();

    /* JADX WARN: Removed duplicated region for block: B:11:0x0028 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.tencent.mobileqq.data.ISafeStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] flushMsgData(int i3) {
        QwSafeOutputStream qwSafeOutputStream;
        try {
            qwSafeOutputStream = new QwSafeOutputStream();
            try {
                writeHeader(qwSafeOutputStream, i3);
                writeExternal(qwSafeOutputStream);
            } catch (Exception e16) {
                e = e16;
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.QQWALLET_MSG, 2, "QQWalletTransferMsg write Exception", e);
                }
                if (qwSafeOutputStream != null) {
                }
            }
        } catch (Exception e17) {
            e = e17;
            qwSafeOutputStream = null;
        }
        if (qwSafeOutputStream != null) {
            return null;
        }
        return qwSafeOutputStream.flushDataAndCloseStream();
    }

    public int getChannelId() {
        return this.channelId;
    }

    public int getResend() {
        return this.resend;
    }

    public void readExternal(QwSafeInputStream qwSafeInputStream) throws Exception {
        this.elem.f441763a = qwSafeInputStream.readInt();
        this.elem.f441764b = qwSafeInputStream.readInt();
        this.elem.f441765c = qwSafeInputStream.readUTF();
        this.elem.f441766d = qwSafeInputStream.readUTF();
        this.elem.f441767e = qwSafeInputStream.readUTF();
        this.elem.f441768f = qwSafeInputStream.readUTF();
        this.elem.f441769g = qwSafeInputStream.readUTF();
        this.elem.f441770h = qwSafeInputStream.readUTF();
        this.channelId = qwSafeInputStream.readInt();
        this.templateId = qwSafeInputStream.readInt();
        this.resend = qwSafeInputStream.readInt();
        this.elem.f441771i = qwSafeInputStream.readInt(-1);
        this.elem.f441772j = qwSafeInputStream.readInt(-1);
        this.elem.f441773k = qwSafeInputStream.readUTF();
        this.elem.f441774l = qwSafeInputStream.readUTF();
        this.elem.f441775m = qwSafeInputStream.readUTF();
        this.elem.f441776n = qwSafeInputStream.readUTF();
        this.elem.f441777o = qwSafeInputStream.readInt(13487565);
        this.elem.f441778p = qwSafeInputStream.readInt(-1);
        this.elem.f441779q = qwSafeInputStream.readUTF();
        this.elem.f441780r = qwSafeInputStream.readUTF();
        this.elem.f441781s = qwSafeInputStream.readUTF();
        this.body.pfaType = qwSafeInputStream.readInt();
        this.elem.c(qwSafeInputStream.readUTF());
        this.listId = qwSafeInputStream.readUTF();
    }

    public void writeExternal(QwSafeOutputStream qwSafeOutputStream) throws Exception {
        qwSafeOutputStream.writeInt(this.elem.f441763a);
        qwSafeOutputStream.writeInt(this.elem.f441764b);
        qwSafeOutputStream.writeUTF(this.elem.f441765c);
        qwSafeOutputStream.writeUTF(this.elem.f441766d);
        qwSafeOutputStream.writeUTF(this.elem.f441767e);
        qwSafeOutputStream.writeUTF(this.elem.f441768f);
        qwSafeOutputStream.writeUTF(this.elem.f441769g);
        qwSafeOutputStream.writeUTF(this.elem.f441770h);
        qwSafeOutputStream.writeInt(this.channelId);
        qwSafeOutputStream.writeInt(this.templateId);
        qwSafeOutputStream.writeInt(this.resend);
        qwSafeOutputStream.writeInt(this.elem.f441771i);
        qwSafeOutputStream.writeInt(this.elem.f441772j);
        qwSafeOutputStream.writeUTF(this.elem.f441773k);
        qwSafeOutputStream.writeUTF(this.elem.f441774l);
        qwSafeOutputStream.writeUTF(this.elem.f441775m);
        qwSafeOutputStream.writeUTF(this.elem.f441776n);
        qwSafeOutputStream.writeInt(this.elem.f441777o);
        qwSafeOutputStream.writeInt(this.elem.f441778p);
        qwSafeOutputStream.writeUTF(this.elem.f441779q);
        qwSafeOutputStream.writeUTF(this.elem.f441780r);
        qwSafeOutputStream.writeUTF(this.elem.f441781s);
        qwSafeOutputStream.writeInt(this.body.pfaType);
        qwSafeOutputStream.writeUTF(this.elem.a());
        qwSafeOutputStream.writeUTF(this.listId);
    }

    public void writeHeader(QwSafeOutputStream qwSafeOutputStream, int i3) throws Exception {
        qwSafeOutputStream.writeInt(32);
        qwSafeOutputStream.writeInt(1);
        qwSafeOutputStream.writeInt(4);
        qwSafeOutputStream.writeInt(i3);
    }
}
