package com.tencent.mobileqq.data;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.troop.data.k;
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
public class MessageForTroopReward extends ChatMessage {
    public static final int RewardImageType = 1;
    public static final int RewardVideoType = 2;
    public static final int STATUS_UNUPLOAD = 10000;
    public static final int STATUS_UPLOADFAILED = 10003;
    public static final int STATUS_UPLOADFINISH = 10002;
    public static final int STATUS_UPLOADING = 10001;
    public static final String TAG = "MessageForTroopReward";
    public String md5;
    public k resq;
    public int rewardCreateTime;
    public int rewardMoney;
    public int rewardStatus;
    public int rewardType;
    public String sha;
    public String title;
    public int videoDuration;
    public String rewardId = "";
    public String rewardUrl = "";
    public String rewardContent = "";
    public long videoSize = 0;
    public String mediaPath = "";
    public int rewardNum = 0;
    public long rewardSeq = 0;
    public String blurUrl = "";
    public int uploadProgress = 0;
    public int updateTime = 0;
    public String vid = "";
    public int expiredTimeStamp = 0;

    private void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        this.rewardId = objectInput.readUTF();
        this.rewardType = objectInput.readInt();
        this.rewardUrl = objectInput.readUTF();
        this.rewardCreateTime = objectInput.readInt();
        this.rewardStatus = objectInput.readInt();
        this.rewardContent = objectInput.readUTF();
        this.rewardMoney = objectInput.readInt();
        this.videoSize = objectInput.readLong();
        this.videoDuration = objectInput.readInt();
        this.rewardNum = objectInput.readInt();
        this.rewardSeq = objectInput.readLong();
        this.mediaPath = objectInput.readUTF();
        this.blurUrl = objectInput.readUTF();
        this.updateTime = objectInput.readInt();
        this.vid = objectInput.readUTF();
        this.expiredTimeStamp = objectInput.readInt();
    }

    private void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeUTF(this.rewardId);
        objectOutput.writeInt(this.rewardType);
        objectOutput.writeUTF(this.rewardUrl);
        objectOutput.writeInt(this.rewardCreateTime);
        objectOutput.writeInt(this.rewardStatus);
        objectOutput.writeUTF(this.rewardContent);
        objectOutput.writeInt(this.rewardMoney);
        objectOutput.writeLong(this.videoSize);
        objectOutput.writeInt(this.videoDuration);
        objectOutput.writeInt(this.rewardNum);
        objectOutput.writeLong(this.rewardSeq);
        objectOutput.writeUTF(this.mediaPath);
        objectOutput.writeUTF(this.blurUrl);
        objectOutput.writeInt(this.updateTime);
        objectOutput.writeUTF(this.vid);
        objectOutput.writeInt(this.expiredTimeStamp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.mobileqq.data.ChatMessage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doParse() {
        Throwable th5;
        ObjectInputStream objectInputStream;
        Exception e16;
        ObjectInputStream objectInputStream2 = null;
        try {
            try {
                try {
                    objectInputStream = new ObjectInputStream(new ByteArrayInputStream(this.msgData));
                } catch (Exception e17) {
                    objectInputStream = null;
                    e16 = e17;
                } catch (Throwable th6) {
                    th5 = th6;
                    if (0 != 0) {
                    }
                    throw th5;
                }
                try {
                    readExternal(objectInputStream);
                    this.f203106msg = getSummaryMsg();
                    objectInputStream.close();
                } catch (Exception e18) {
                    e16 = e18;
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.TAG_TROOP_SEND_GIFT, 2, "convert byte array to MessageForTroopReward failed", e16);
                    }
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                }
            } catch (Throwable th7) {
                th5 = th7;
                if (0 != 0) {
                    try {
                        objectInputStream2.close();
                    } catch (Exception e19) {
                        e19.printStackTrace();
                    }
                }
                throw th5;
            }
        } catch (Exception e26) {
            e26.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public String getSummaryMsg() {
        return HardCodeUtil.qqStr(R.string.o1h) + this.rewardContent;
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public boolean isSupportReply() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        parse();
        if (this.rewardStatus == 10001) {
            this.rewardStatus = 10003;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void prewrite() {
        ObjectOutputStream objectOutputStream;
        Throwable th5;
        Exception e16;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        } catch (Exception e17) {
            objectOutputStream = null;
            e16 = e17;
        } catch (Throwable th6) {
            objectOutputStream = null;
            th5 = th6;
            if (objectOutputStream != null) {
            }
            try {
                byteArrayOutputStream.close();
            } catch (Exception e18) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_TROOP_REWARD, 2, "convert MessageForTroopReward to byte array failed", e18);
                }
            }
            throw th5;
        }
        try {
            try {
                writeExternal(objectOutputStream);
                objectOutputStream.close();
                this.msgData = byteArrayOutputStream.toByteArray();
                try {
                    objectOutputStream.close();
                } catch (Exception e19) {
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.TAG_TROOP_REWARD, 2, "convert MessageForTroopReward to byte array failed", e19);
                    }
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e26) {
                    e = e26;
                    if (!QLog.isColorLevel()) {
                        return;
                    }
                    QLog.d(LogTag.TAG_TROOP_REWARD, 2, "convert MessageForTroopReward to byte array failed", e);
                }
            } catch (Throwable th7) {
                th5 = th7;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (Exception e27) {
                        if (QLog.isColorLevel()) {
                            QLog.d(LogTag.TAG_TROOP_REWARD, 2, "convert MessageForTroopReward to byte array failed", e27);
                        }
                    }
                }
                byteArrayOutputStream.close();
                throw th5;
            }
        } catch (Exception e28) {
            e16 = e28;
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_TROOP_REWARD, 2, "convert MessageForTroopReward to byte array failed", e16);
            }
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (Exception e29) {
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.TAG_TROOP_REWARD, 2, "convert MessageForTroopReward to byte array failed", e29);
                    }
                }
            }
            try {
                byteArrayOutputStream.close();
            } catch (Exception e36) {
                e = e36;
                if (!QLog.isColorLevel()) {
                    return;
                }
                QLog.d(LogTag.TAG_TROOP_REWARD, 2, "convert MessageForTroopReward to byte array failed", e);
            }
        }
    }
}
