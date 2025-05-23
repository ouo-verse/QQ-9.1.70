package com.tencent.mobileqq.data;

import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForFuDai extends ChatMessage implements CustomFrameAnimationDrawable.b {
    private static final String TAG = "MessageForFuDai";
    public int busiId;
    public int currentFrame;
    public int expireTime;
    public int shareType;
    private int state;
    public int themeId;
    public boolean useDefaultImag;
    public String hostUin = "";
    public String fdId = "";
    public String targetId = "";
    public String fdTxt = "";
    public String aioTails = "";
    private String highlightMsg = "";

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class Decoder {
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00aa -> B:12:0x00ad). Please report as a decompilation issue!!! */
        public static void decode(byte[] bArr, MessageForFuDai messageForFuDai) {
            ByteArrayInputStream byteArrayInputStream;
            ObjectInputStream objectInputStream = null;
            try {
                try {
                    byteArrayInputStream = new ByteArrayInputStream(bArr);
                    try {
                        try {
                            ObjectInputStream objectInputStream2 = new ObjectInputStream(byteArrayInputStream);
                            try {
                                messageForFuDai.state = objectInputStream2.readInt();
                                messageForFuDai.hostUin = objectInputStream2.readLong() + "";
                                messageForFuDai.fdId = objectInputStream2.readUTF();
                                messageForFuDai.shareType = objectInputStream2.readInt();
                                messageForFuDai.targetId = objectInputStream2.readLong() + "";
                                messageForFuDai.fdTxt = objectInputStream2.readUTF();
                                messageForFuDai.aioTails = objectInputStream2.readUTF();
                                messageForFuDai.busiId = objectInputStream2.readInt();
                                messageForFuDai.highlightMsg = objectInputStream2.readUTF();
                                messageForFuDai.expireTime = objectInputStream2.readInt();
                                messageForFuDai.themeId = objectInputStream2.readInt();
                                messageForFuDai.f203106msg = messageForFuDai.fdTxt;
                                try {
                                    objectInputStream2.close();
                                } catch (IOException e16) {
                                    QLog.e(MessageForFuDai.TAG, 1, "decode: ", e16);
                                }
                                byteArrayInputStream.close();
                            } catch (Exception e17) {
                                e = e17;
                                objectInputStream = objectInputStream2;
                                QLog.d(MessageForFuDai.TAG, 1, "decode: ", e);
                                if (objectInputStream != null) {
                                    try {
                                        objectInputStream.close();
                                    } catch (IOException e18) {
                                        QLog.e(MessageForFuDai.TAG, 1, "decode: ", e18);
                                    }
                                }
                                if (byteArrayInputStream != null) {
                                    byteArrayInputStream.close();
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                objectInputStream = objectInputStream2;
                                if (objectInputStream != null) {
                                    try {
                                        objectInputStream.close();
                                    } catch (IOException e19) {
                                        QLog.e(MessageForFuDai.TAG, 1, "decode: ", e19);
                                    }
                                }
                                if (byteArrayInputStream != null) {
                                    try {
                                        byteArrayInputStream.close();
                                        throw th;
                                    } catch (IOException e26) {
                                        QLog.e(MessageForFuDai.TAG, 1, "decode: ", e26);
                                        throw th;
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                        }
                    } catch (Exception e27) {
                        e = e27;
                    }
                } catch (Exception e28) {
                    e = e28;
                    byteArrayInputStream = null;
                } catch (Throwable th7) {
                    th = th7;
                    byteArrayInputStream = null;
                }
            } catch (IOException e29) {
                QLog.e(MessageForFuDai.TAG, 1, "decode: ", e29);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class Encoder {
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v16 */
        /* JADX WARN: Type inference failed for: r3v17 */
        /* JADX WARN: Type inference failed for: r3v7, types: [byte[]] */
        public static byte[] encode(MessageForFuDai messageForFuDai) {
            ByteArrayOutputStream byteArrayOutputStream;
            byte[] bArr;
            ObjectOutputStream objectOutputStream = 0;
            byte[] bArr2 = null;
            r3 = null;
            ObjectOutputStream objectOutputStream2 = null;
            objectOutputStream = 0;
            try {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        ObjectOutputStream objectOutputStream3 = new ObjectOutputStream(byteArrayOutputStream);
                        try {
                            try {
                                objectOutputStream3.writeInt(messageForFuDai.state);
                                Long l3 = 0L;
                                try {
                                    l3 = Long.valueOf(messageForFuDai.hostUin);
                                } catch (Exception e16) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e(MessageForFuDai.TAG, 2, "encode() error hostUin", e16);
                                    }
                                }
                                objectOutputStream3.writeLong(l3.longValue());
                                objectOutputStream3.writeUTF(messageForFuDai.fdId);
                                objectOutputStream3.writeInt(messageForFuDai.shareType);
                                Long l16 = 0L;
                                try {
                                    l16 = Long.valueOf(messageForFuDai.targetId);
                                } catch (Exception e17) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e(MessageForFuDai.TAG, 2, "encode() error targetId", e17);
                                    }
                                }
                                objectOutputStream3.writeLong(l16.longValue());
                                objectOutputStream3.writeUTF(messageForFuDai.fdTxt);
                                objectOutputStream3.writeUTF(messageForFuDai.aioTails);
                                objectOutputStream3.writeInt(messageForFuDai.busiId);
                                objectOutputStream3.writeUTF(messageForFuDai.highlightMsg);
                                objectOutputStream3.writeInt(messageForFuDai.expireTime);
                                objectOutputStream3.writeInt(messageForFuDai.themeId);
                                objectOutputStream3.flush();
                                bArr2 = byteArrayOutputStream.toByteArray();
                                if (QLog.isColorLevel()) {
                                    QLog.d(MessageForFuDai.TAG, 2, "encode() called msgData.size=[" + bArr2.length + "]");
                                }
                                try {
                                    objectOutputStream3.close();
                                } catch (IOException e18) {
                                    QLog.e(MessageForFuDai.TAG, 1, "encode: ", e18);
                                }
                                try {
                                    byteArrayOutputStream.close();
                                    objectOutputStream = bArr2;
                                } catch (IOException e19) {
                                    QLog.e(MessageForFuDai.TAG, 1, "encode: ", e19);
                                    objectOutputStream = bArr2;
                                }
                            } catch (Exception e26) {
                                e = e26;
                                bArr = bArr2;
                                objectOutputStream2 = objectOutputStream3;
                                QLog.e(MessageForFuDai.TAG, 1, "encode: ", e);
                                if (objectOutputStream2 != null) {
                                    try {
                                        objectOutputStream2.close();
                                    } catch (IOException e27) {
                                        QLog.e(MessageForFuDai.TAG, 1, "encode: ", e27);
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (IOException e28) {
                                        QLog.e(MessageForFuDai.TAG, 1, "encode: ", e28);
                                    }
                                }
                                objectOutputStream = bArr;
                                return objectOutputStream;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            objectOutputStream = objectOutputStream3;
                            if (objectOutputStream != 0) {
                                try {
                                    objectOutputStream.close();
                                } catch (IOException e29) {
                                    QLog.e(MessageForFuDai.TAG, 1, "encode: ", e29);
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                    throw th;
                                } catch (IOException e36) {
                                    QLog.e(MessageForFuDai.TAG, 1, "encode: ", e36);
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e37) {
                        e = e37;
                        bArr = null;
                    }
                } catch (Exception e38) {
                    e = e38;
                    byteArrayOutputStream = null;
                    bArr = null;
                } catch (Throwable th6) {
                    th = th6;
                    byteArrayOutputStream = null;
                }
                return objectOutputStream;
            } catch (Throwable th7) {
                th = th7;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        Decoder.decode(this.msgData, this);
    }

    public int getState() {
        return this.state;
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public String getSummaryMsg() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getSummaryMsg() called fdTxt=" + this.fdTxt);
        }
        return this.fdTxt;
    }

    public String highlightMsg() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "highlightMsg Txt=" + this.highlightMsg);
        }
        return this.highlightMsg;
    }

    public boolean isEmpty() {
        if (this.state == 4) {
            return true;
        }
        return false;
    }

    public boolean isExpired() {
        return true;
    }

    public boolean isGrabByMe() {
        int i3 = this.state;
        if (i3 != 3 && i3 != 7) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public boolean isSupportReply() {
        return true;
    }

    @Override // com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable.b
    public void onUpdate(int i3) {
        this.currentFrame = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        this.msgData = Encoder.encode(this);
    }

    @Override // com.tencent.mobileqq.data.MessageRecord
    public String toString() {
        return "MessageForFuDai{hostUin='" + MsfSdkUtils.getShortUin(this.hostUin) + "', fdId='" + this.fdId + "', shareType=" + this.shareType + ", targetId='" + this.targetId + "', fdTxt='" + this.fdTxt + "', aioTails='" + this.aioTails + "', state=" + this.state + ", busiId=" + this.busiId + ", highlightMsg='" + this.highlightMsg + "', themeId=" + this.themeId + ", expireTime=" + this.expireTime + ", currentFrame=" + this.currentFrame + ", useDefaultImag=" + this.useDefaultImag + '}';
    }
}
