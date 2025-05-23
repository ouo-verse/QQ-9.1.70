package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForTroopGift extends MessageForDeliverGiftTips {
    public int giftPicId;
    public String title = "";
    public String message = "";
    public String comefrom = "";
    public boolean isReported = false;
    public boolean isLoading = false;
    public String giftUrl = "";

    private String getNotNullString(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    private void readExternal(ObjectInput objectInput) throws IOException {
        this.animationPackageId = objectInput.readInt();
        this.remindBrief = objectInput.readUTF();
        this.animationBrief = objectInput.readUTF();
        this.giftCount = objectInput.readInt();
        this.senderUin = objectInput.readLong();
        this.receiverUin = objectInput.readLong();
        this.title = objectInput.readUTF();
        this.subtitle = objectInput.readUTF();
        this.message = objectInput.readUTF();
        this.giftPicId = objectInput.readInt();
        this.comefrom = objectInput.readUTF();
        this.exflag = objectInput.readInt();
        this.isReported = objectInput.readBoolean();
        this.summary = objectInput.readUTF();
        this.jumpUrl = objectInput.readUTF();
        this.isFromNearby = objectInput.readBoolean();
        this.sendScore = objectInput.readInt();
        this.recvScore = objectInput.readInt();
        this.charmHeroism = objectInput.readUTF();
        this.btFlag = objectInput.readInt();
        this.objColor = objectInput.readInt();
        this.senderName = objectInput.readUTF();
        try {
            int readInt = objectInput.readInt();
            this.version = readInt;
            if (readInt >= 1) {
                this.bagId = objectInput.readUTF();
                if (this.version >= 2) {
                    this.animationType = objectInput.readInt();
                    this.interactId = objectInput.readUTF();
                    this.interactState = objectInput.readInt();
                    this.alreadyPlayMicroseconds = objectInput.readLong();
                    this.playTotalMicroseconds = objectInput.readLong();
                    this.interactText = objectInput.readUTF();
                    this.participateNum = objectInput.readInt();
                    this.interactFirstUin = objectInput.readLong();
                    this.interactFirstNickname = objectInput.readUTF();
                    this.interacEndtUrl = objectInput.readUTF();
                    this.receiverHead = objectInput.readUTF();
                    this.receiverName = objectInput.readUTF();
                    this.is_activity_gift = objectInput.readInt();
                    this.activity_text = objectInput.readUTF();
                    this.activity_text_color = objectInput.readUTF();
                    this.activity_url = objectInput.readUTF();
                    this.animationPackageUrl = objectInput.readUTF();
                }
            }
        } catch (IOException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_TROOP_SEND_GIFT, 2, "readExternal error.", e16);
            }
        }
    }

    private void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeInt(this.animationPackageId);
        objectOutput.writeUTF(getNotNullString(this.remindBrief));
        objectOutput.writeUTF(getNotNullString(this.animationBrief));
        objectOutput.writeInt(this.giftCount);
        objectOutput.writeLong(this.senderUin);
        objectOutput.writeLong(this.receiverUin);
        objectOutput.writeUTF(getNotNullString(this.title));
        objectOutput.writeUTF(getNotNullString(this.subtitle));
        objectOutput.writeUTF(getNotNullString(this.message));
        objectOutput.writeInt(this.giftPicId);
        objectOutput.writeUTF(getNotNullString(this.comefrom));
        objectOutput.writeInt(this.exflag);
        objectOutput.writeBoolean(this.isReported);
        objectOutput.writeUTF(getNotNullString(this.summary));
        objectOutput.writeUTF(getNotNullString(this.jumpUrl));
        objectOutput.writeBoolean(this.isFromNearby);
        objectOutput.writeInt(this.sendScore);
        objectOutput.writeInt(this.recvScore);
        objectOutput.writeUTF(getNotNullString(this.charmHeroism));
        objectOutput.writeInt(this.btFlag);
        objectOutput.writeInt(this.objColor);
        objectOutput.writeUTF(getNotNullString(this.senderName));
        objectOutput.writeInt(2);
        objectOutput.writeUTF(getNotNullString(this.bagId));
        objectOutput.writeInt(this.animationType);
        objectOutput.writeUTF(getNotNullString(this.interactId));
        objectOutput.writeInt(this.interactState);
        objectOutput.writeLong(this.alreadyPlayMicroseconds);
        objectOutput.writeLong(this.playTotalMicroseconds);
        objectOutput.writeUTF(getNotNullString(this.interactText));
        objectOutput.writeInt(this.participateNum);
        objectOutput.writeLong(this.interactFirstUin);
        objectOutput.writeUTF(getNotNullString(this.interactFirstNickname));
        objectOutput.writeUTF(getNotNullString(this.interacEndtUrl));
        objectOutput.writeUTF(getNotNullString(this.receiverHead));
        objectOutput.writeUTF(getNotNullString(this.receiverName));
        objectOutput.writeInt(this.is_activity_gift);
        objectOutput.writeUTF(getNotNullString(this.activity_text));
        objectOutput.writeUTF(getNotNullString(this.activity_text_color));
        objectOutput.writeUTF(getNotNullString(this.activity_url));
        objectOutput.writeUTF(getNotNullString(this.animationPackageUrl));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.mobileqq.data.MessageForGrayTips, com.tencent.mobileqq.data.ChatMessage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doParse() {
        ObjectInputStream objectInputStream;
        Throwable th5;
        IOException e16;
        if (!TextUtils.isEmpty(this.f203106msg)) {
            this.mIsParsed = true;
            return;
        }
        try {
            try {
                objectInputStream = new ObjectInputStream(new ByteArrayInputStream(this.msgData));
            } catch (IOException e17) {
                objectInputStream = null;
                e16 = e17;
            } catch (Throwable th6) {
                objectInputStream = null;
                th5 = th6;
                if (objectInputStream != null) {
                }
                throw th5;
            }
            try {
                try {
                    readExternal(objectInputStream);
                    this.f203106msg = this.summary;
                    objectInputStream.close();
                } catch (Throwable th7) {
                    th5 = th7;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (Exception e18) {
                            e18.printStackTrace();
                        }
                    }
                    throw th5;
                }
            } catch (IOException e19) {
                e16 = e19;
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_TROOP_SEND_GIFT, 2, "convert byte array to MessageForTroopGift failed", e16);
                }
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            }
        } catch (Exception e26) {
            e26.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public String getSummaryMsg() {
        return this.summary;
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public boolean isSupportReply() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        parse();
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void prewrite() {
        Throwable th5;
        ObjectOutputStream objectOutputStream;
        IOException e16;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            } catch (IOException e17) {
                objectOutputStream = null;
                e16 = e17;
            } catch (Throwable th6) {
                th5 = th6;
                if (0 != 0) {
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e18) {
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.TAG_TROOP_SEND_GIFT, 2, "convert MessageForTroopGift to byte array failed", e18);
                    }
                }
                throw th5;
            }
            try {
                writeExternal(objectOutputStream);
                objectOutputStream.close();
                this.msgData = byteArrayOutputStream.toByteArray();
                try {
                    objectOutputStream.close();
                } catch (Exception e19) {
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.TAG_TROOP_SEND_GIFT, 2, "convert MessageForTroopGift to byte array failed", e19);
                    }
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e26) {
                    e = e26;
                    if (!QLog.isColorLevel()) {
                        return;
                    }
                    QLog.d(LogTag.TAG_TROOP_SEND_GIFT, 2, "convert MessageForTroopGift to byte array failed", e);
                }
            } catch (IOException e27) {
                e16 = e27;
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_TROOP_SEND_GIFT, 2, "convert MessageForTroopGift to byte array failed", e16);
                }
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (Exception e28) {
                        if (QLog.isColorLevel()) {
                            QLog.d(LogTag.TAG_TROOP_SEND_GIFT, 2, "convert MessageForTroopGift to byte array failed", e28);
                        }
                    }
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e29) {
                    e = e29;
                    if (!QLog.isColorLevel()) {
                        return;
                    }
                    QLog.d(LogTag.TAG_TROOP_SEND_GIFT, 2, "convert MessageForTroopGift to byte array failed", e);
                }
            }
        } catch (Throwable th7) {
            th5 = th7;
            if (0 != 0) {
                try {
                    objectOutputStream2.close();
                } catch (Exception e36) {
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.TAG_TROOP_SEND_GIFT, 2, "convert MessageForTroopGift to byte array failed", e36);
                    }
                }
            }
            byteArrayOutputStream.close();
            throw th5;
        }
    }
}
