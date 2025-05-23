package com.tencent.mobileqq.data;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForTroopStory extends MessageForRichText {
    public static final int CTR_VERSION = 1;
    public static final String KEY_COMPATIBLE_TEXT = "key_compatible_text";
    public static final String KEY_CTR_VERSION = "key_ctr_version";
    public static final String KEY_DOODLE_URL = "key_doodle_url";
    public static final String KEY_MD5 = "key_md5";
    public static final String KEY_SOURCE_ACTION_DATA = "key_source_action_data";
    public static final String KEY_SOURCE_ACTION_TYPE = "key_source_action_type";
    public static final String KEY_SOURCE_NAME = "key_source_name";
    public static final String KEY_STORY_ID = "key_story_id";
    public static final String KEY_THUMB_URL = "key_thumb_url";
    public static final String KEY_UID = "key_uid";
    public static final String KEY_UNION_ID = "key_union_id";
    public static final String KEY_VIDEO_HEIGHT = "key_video_height";
    public static final String KEY_VIDEO_WIDTH = "key_video_width";
    public static final String MSG_CONTENT = HardCodeUtil.qqStr(R.string.o1_);
    public static final String TAG = "MessageForTroopStory";
    public String compatibleText;
    public int ctrVersion;
    public String doodleUrl;
    public String md5;
    public String sourceActionData;
    public String sourceActionType;
    public String sourceName;
    public String storyId;
    public String thumbUrl;
    public long uid;
    public String unionId;
    public int videoHeight;
    public int videoWidth;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0085 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.mobileqq.data.ChatMessage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doParse() {
        Throwable th5;
        ObjectInputStream objectInputStream;
        Exception e16;
        this.f203106msg = MSG_CONTENT;
        ObjectInputStream objectInputStream2 = null;
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
                this.uid = objectInputStream.readLong();
                this.unionId = objectInputStream.readUTF();
                this.storyId = objectInputStream.readUTF();
                this.md5 = objectInputStream.readUTF();
                this.thumbUrl = objectInputStream.readUTF();
                this.doodleUrl = objectInputStream.readUTF();
                this.videoWidth = objectInputStream.readInt();
                this.videoHeight = objectInputStream.readInt();
                this.sourceName = objectInputStream.readUTF();
                this.sourceActionType = objectInputStream.readUTF();
                this.sourceActionData = objectInputStream.readUTF();
                this.compatibleText = objectInputStream.readUTF();
                this.ctrVersion = objectInputStream.read();
            } catch (Exception e18) {
                e16 = e18;
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "parse MessageForTroopStory failed", e16);
                }
                if (objectInputStream == null) {
                    return;
                }
                objectInputStream.close();
            }
            try {
                objectInputStream.close();
            } catch (IOException unused) {
            }
        } catch (Throwable th7) {
            th5 = th7;
            if (0 != 0) {
                try {
                    objectInputStream2.close();
                } catch (IOException unused2) {
                }
            }
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        parse();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        serial();
    }

    public void serial() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                try {
                    ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                    try {
                        objectOutputStream2.writeLong(this.uid);
                        String str = this.unionId;
                        String str2 = "";
                        if (str == null) {
                            str = "";
                        }
                        objectOutputStream2.writeUTF(str);
                        String str3 = this.storyId;
                        if (str3 == null) {
                            str3 = "";
                        }
                        objectOutputStream2.writeUTF(str3);
                        String str4 = this.md5;
                        if (str4 == null) {
                            str4 = "";
                        }
                        objectOutputStream2.writeUTF(str4);
                        String str5 = this.thumbUrl;
                        if (str5 == null) {
                            str5 = "";
                        }
                        objectOutputStream2.writeUTF(str5);
                        String str6 = this.doodleUrl;
                        if (str6 == null) {
                            str6 = "";
                        }
                        objectOutputStream2.writeUTF(str6);
                        objectOutputStream2.writeInt(this.videoWidth);
                        objectOutputStream2.writeInt(this.videoHeight);
                        String str7 = this.sourceName;
                        if (str7 == null) {
                            str7 = "";
                        }
                        objectOutputStream2.writeUTF(str7);
                        String str8 = this.sourceActionType;
                        if (str8 == null) {
                            str8 = "";
                        }
                        objectOutputStream2.writeUTF(str8);
                        String str9 = this.sourceActionData;
                        if (str9 == null) {
                            str9 = "";
                        }
                        objectOutputStream2.writeUTF(str9);
                        String str10 = this.compatibleText;
                        if (str10 != null) {
                            str2 = str10;
                        }
                        objectOutputStream2.writeUTF(str2);
                        objectOutputStream2.write(this.ctrVersion);
                        objectOutputStream2.flush();
                        this.msgData = byteArrayOutputStream.toByteArray();
                        objectOutputStream2.close();
                    } catch (Exception e16) {
                        e = e16;
                        objectOutputStream = objectOutputStream2;
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "serial MessageForTroopStory failed", e);
                        }
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        objectOutputStream = objectOutputStream2;
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception e17) {
                e = e17;
            }
        } catch (IOException unused2) {
        }
    }

    public String toDebugString() {
        return "MessageForTroopStory{doodleUrl='" + this.doodleUrl + "', uid=" + this.uid + ", unionId='" + this.unionId + "', storyId='" + this.storyId + "', md5='" + this.md5 + "', thumbUrl='" + this.thumbUrl + "', videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight + ", sourceName='" + this.sourceName + "', sourceActionType='" + this.sourceActionType + "', sourceActionData='" + this.sourceActionData + "'}";
    }
}
