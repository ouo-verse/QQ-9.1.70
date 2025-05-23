package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.msg.im_msg_body$QQWalletAioBody;

/* loaded from: classes10.dex */
public class QQWalletRedPacketMsg implements ISafeStream {
    public String authkey;
    public QQWalletAioBodyReserve body;
    private int channelId;
    public int conftype;
    public vk2.b elem;
    public String envelopeName;
    public int envelopeid;
    public boolean isOpened;
    public int msgFrom;
    public int redChannel;
    public String redPacketId;
    public String redPacketIndex;
    public int redtype;
    private int resend;
    public List<Long> specifyUinList;
    public int templateId;

    public QQWalletRedPacketMsg() {
        this.specifyUinList = new ArrayList();
        this.body = new QQWalletAioBodyReserve();
    }

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
                    QLog.d(LogTag.QQWALLET_MSG, 2, "QQWalletRedPacketMsg write Exception", e);
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
        vk2.b bVar = new vk2.b();
        this.elem = bVar;
        bVar.f441763a = qwSafeInputStream.readInt();
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
        this.redtype = qwSafeInputStream.readInt();
        this.redPacketId = qwSafeInputStream.readUTF();
        this.authkey = qwSafeInputStream.readUTF();
        this.isOpened = qwSafeInputStream.readBoolean();
        this.elem.f441771i = qwSafeInputStream.readInt();
        this.elem.f441772j = qwSafeInputStream.readInt();
        this.elem.f441773k = qwSafeInputStream.readUTF();
        this.elem.f441774l = qwSafeInputStream.readUTF();
        this.elem.f441775m = qwSafeInputStream.readUTF();
        this.elem.f441776n = qwSafeInputStream.readUTF();
        this.elem.f441777o = qwSafeInputStream.readInt(13487565);
        this.elem.f441778p = qwSafeInputStream.readInt(-1);
        this.elem.f441779q = qwSafeInputStream.readUTF();
        this.elem.f441780r = qwSafeInputStream.readUTF();
        this.elem.f441781s = qwSafeInputStream.readUTF();
        this.envelopeid = qwSafeInputStream.readInt(-1);
        this.envelopeName = qwSafeInputStream.readUTF();
        this.conftype = qwSafeInputStream.readInt(-1);
        this.msgFrom = qwSafeInputStream.readInt(-1);
        this.redPacketIndex = qwSafeInputStream.readUTF();
        this.redChannel = qwSafeInputStream.readInt();
        this.specifyUinList = (List) qwSafeInputStream.readObject(new ArrayList());
        this.elem.f441782t = qwSafeInputStream.readInt(12000);
        this.elem.f441783u = qwSafeInputStream.readInt();
        this.elem.f441784v = qwSafeInputStream.readInt();
        this.elem.f441787y = qwSafeInputStream.readInt();
        this.elem.f441788z = qwSafeInputStream.readInt();
        this.elem.B = qwSafeInputStream.readInt();
        this.elem.C = qwSafeInputStream.readInt();
        this.elem.D = qwSafeInputStream.readInt();
        this.elem.E = qwSafeInputStream.readInt();
        this.body.feedId = qwSafeInputStream.readUTF();
        this.elem.F = qwSafeInputStream.readUTF();
        this.body.subChannel = qwSafeInputStream.readInt();
        this.body.poemRule = qwSafeInputStream.readUTF();
        this.body.makeHbExtend = qwSafeInputStream.readUTF();
        this.body.shengpiziMask = qwSafeInputStream.readUTF();
        this.body.shengpiziMD5 = qwSafeInputStream.readUTF();
        this.body.payFlag = qwSafeInputStream.readInt();
        this.body.hbFlag = qwSafeInputStream.readInt();
        this.body.coverId = qwSafeInputStream.readInt();
        this.body.avatarId = qwSafeInputStream.readInt();
        this.body.zplanSenderUin = qwSafeInputStream.readUTF();
        this.elem.f441785w = qwSafeInputStream.readUTF();
        this.elem.f441786x = qwSafeInputStream.readInt();
        if (QLog.isColorLevel()) {
            QLog.d("QQWalletRedPacketMsg", 2, "readExternal redtype=" + this.redtype + ", skinId=" + this.elem.f441784v + ", outerSkinId=" + this.elem.f441785w + ", skinFrom=" + this.elem.f441786x + ", effectsId=" + this.elem.f441787y + ", special_pop_id=" + this.elem.f441788z + ", themeId=" + this.elem.B);
        }
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
        qwSafeOutputStream.writeInt(this.redtype);
        qwSafeOutputStream.writeUTF(this.redPacketId);
        qwSafeOutputStream.writeUTF(this.authkey);
        qwSafeOutputStream.writeBoolean(this.isOpened);
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
        qwSafeOutputStream.writeInt(this.envelopeid);
        qwSafeOutputStream.writeUTF(this.envelopeName);
        qwSafeOutputStream.writeInt(this.conftype);
        qwSafeOutputStream.writeInt(this.msgFrom);
        qwSafeOutputStream.writeUTF(this.redPacketIndex);
        qwSafeOutputStream.writeInt(this.redChannel);
        qwSafeOutputStream.writeObject(this.specifyUinList);
        qwSafeOutputStream.writeInt(this.elem.f441782t);
        qwSafeOutputStream.writeInt(this.elem.f441783u);
        qwSafeOutputStream.writeInt(this.elem.f441784v);
        qwSafeOutputStream.writeInt(this.elem.f441787y);
        qwSafeOutputStream.writeInt(this.elem.f441788z);
        qwSafeOutputStream.writeInt(this.elem.B);
        qwSafeOutputStream.writeInt(this.elem.C);
        qwSafeOutputStream.writeInt(this.elem.D);
        qwSafeOutputStream.writeInt(this.elem.E);
        qwSafeOutputStream.writeUTF(this.body.feedId);
        qwSafeOutputStream.writeUTF(this.elem.F);
        qwSafeOutputStream.writeInt(this.body.subChannel);
        qwSafeOutputStream.writeUTF(this.body.poemRule);
        qwSafeOutputStream.writeUTF(this.body.makeHbExtend);
        qwSafeOutputStream.writeUTF(this.body.shengpiziMask);
        qwSafeOutputStream.writeUTF(this.body.shengpiziMD5);
        qwSafeOutputStream.writeInt(this.body.payFlag);
        qwSafeOutputStream.writeInt(this.body.hbFlag);
        qwSafeOutputStream.writeInt(this.body.coverId);
        qwSafeOutputStream.writeInt(this.body.avatarId);
        qwSafeOutputStream.writeUTF(this.body.zplanSenderUin);
        qwSafeOutputStream.writeUTF(this.elem.f441785w);
        qwSafeOutputStream.writeInt(this.elem.f441786x);
    }

    public void writeHeader(QwSafeOutputStream qwSafeOutputStream, int i3) throws Exception {
        qwSafeOutputStream.writeInt(32);
        qwSafeOutputStream.writeInt(2);
        qwSafeOutputStream.writeInt(2);
        qwSafeOutputStream.writeInt(i3);
    }

    public QQWalletRedPacketMsg(im_msg_body$QQWalletAioBody im_msg_body_qqwalletaiobody, String str) {
        this.specifyUinList = new ArrayList();
        if (im_msg_body_qqwalletaiobody != null && !TextUtils.isEmpty(str)) {
            this.elem = new vk2.b(im_msg_body_qqwalletaiobody.receiver);
            this.body = new QQWalletAioBodyReserve(im_msg_body_qqwalletaiobody);
            this.channelId = im_msg_body_qqwalletaiobody.sint32_channelid.get();
            this.templateId = im_msg_body_qqwalletaiobody.sint32_templateid.get();
            this.resend = im_msg_body_qqwalletaiobody.uint32_resend.get();
            this.redtype = im_msg_body_qqwalletaiobody.sint32_redtype.get();
            this.redPacketId = im_msg_body_qqwalletaiobody.bytes_billno.get().toStringUtf8();
            this.authkey = im_msg_body_qqwalletaiobody.bytes_authkey.get().toStringUtf8();
            this.envelopeid = im_msg_body_qqwalletaiobody.sint32_envelopeid.get();
            this.envelopeName = im_msg_body_qqwalletaiobody.bytes_name.get().toStringUtf8();
            this.conftype = im_msg_body_qqwalletaiobody.sint32_redtype.get();
            this.msgFrom = im_msg_body_qqwalletaiobody.sint32_msg_from.get();
            this.redPacketIndex = im_msg_body_qqwalletaiobody.string_index.get().toStringUtf8();
            List<Long> list = im_msg_body_qqwalletaiobody.uint64_grap_uin.get();
            if (list != null) {
                this.specifyUinList = list;
            }
            this.redChannel = im_msg_body_qqwalletaiobody.uint32_redchannel.get();
            return;
        }
        this.body = new QQWalletAioBodyReserve();
    }
}
