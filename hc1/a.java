package hc1;

import android.text.TextUtils;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.DataMigrationResourceInfo;
import com.tencent.qqnt.msg.f;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class a {

    /* renamed from: b, reason: collision with root package name */
    public static final String f404727b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f404728c;

    /* renamed from: a, reason: collision with root package name */
    protected BaseQQAppInterface f404729a;

    static {
        StringBuilder sb5 = new StringBuilder();
        String str = com.tencent.mobileqq.msgbackup.util.a.f251368a;
        sb5.append(str);
        sb5.append("fileThumb/");
        f404727b = sb5.toString();
        f404728c = str + ProtocolDownloaderConstants.FILE_PREFIX;
    }

    public a(BaseQQAppInterface baseQQAppInterface) {
        this.f404729a = baseQQAppInterface;
    }

    private void j(String str) {
        if (QLog.isDebugVersion()) {
            QLog.i("FileMsgBackupHandler<QFile>", 1, str);
        }
    }

    public abstract boolean a(MessageRecord messageRecord, MsgBackupResEntity msgBackupResEntity);

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(MessageRecord messageRecord) {
        if (messageRecord == null) {
            return;
        }
        messageRecord.removeExtInfoToExtStr("_backup_ForwardFileType");
        messageRecord.removeExtInfoToExtStr("_backup_ForwardSenderUin");
        messageRecord.removeExtInfoToExtStr("_backup_ForwardReceiverUin");
        messageRecord.removeExtInfoToExtStr("_backup_ForwardUuid");
        messageRecord.removeExtInfoToExtStr("_backup_ForwardFileName");
        messageRecord.removeExtInfoToExtStr("_backup_ForwardSize");
        messageRecord.removeExtInfoToExtStr("_backup_ForwardSha");
        messageRecord.removeExtInfoToExtStr("_backup_ForwardMd5");
        messageRecord.removeExtInfoToExtStr("_backup_ForwardDeadTime");
        messageRecord.removeExtInfoToExtStr("_backup_ForwardImgWidth");
        messageRecord.removeExtInfoToExtStr("_backup_ForwardImgHeight");
        messageRecord.removeExtInfoToExtStr("_backup_ForwardDuration");
        messageRecord.removeExtInfoToExtStr("_backup_ForwardBusType");
        messageRecord.removeExtInfoToExtStr("_backup_ForwardFilePath");
        messageRecord.removeExtInfoToExtStr("_backup_ForwardFileStatus");
        messageRecord.removeExtInfoToExtStr("_backup_ForwardFaildReason");
        messageRecord.removeExtInfoToExtStr("_backup_ForwardLasSuccess");
        messageRecord.removeExtInfoToExtStr("_backup_ForwardStatusPaused");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HashMap<String, String> c(String str) {
        String str2;
        String str3;
        int i3;
        int i16;
        HashMap<String, String> hashMap = new HashMap<>();
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("uint64_sender_uin")) {
                str2 = "uint32_img_width";
                str3 = "sha3";
            } else {
                String string = jSONObject.getString("uint64_sender_uin");
                str2 = "uint32_img_width";
                StringBuilder sb5 = new StringBuilder();
                str3 = "sha3";
                sb5.append("decodeResExtInfo senderUin[");
                sb5.append(string);
                sb5.append("]");
                j(sb5.toString());
                hashMap.put("uint64_sender_uin", string);
            }
            if (jSONObject.has("uint64_receiver_uin")) {
                String string2 = jSONObject.getString("uint64_receiver_uin");
                j("decodeResExtInfo recvUin[" + string2 + "]");
                hashMap.put("uint64_receiver_uin", string2);
            }
            if (jSONObject.has("uint32_file_type")) {
                int i17 = jSONObject.getInt("uint32_file_type");
                j("decodeResExtInfo peerType[" + i17 + "]");
                hashMap.put("uint32_file_type", String.valueOf(i17));
            }
            if (jSONObject.has("bytes_file_uuid")) {
                String string3 = jSONObject.getString("bytes_file_uuid");
                j("decodeResExtInfo fileUuid[" + string3 + "]");
                hashMap.put("bytes_file_uuid", string3);
            }
            if (jSONObject.has("str_file_name")) {
                String string4 = jSONObject.getString("str_file_name");
                j("decodeResExtInfo fileName[" + string4 + "]");
                hashMap.put("str_file_name", string4);
            }
            if (jSONObject.has("uint64_file_size")) {
                long j3 = jSONObject.getLong("uint64_file_size");
                j("decodeResExtInfo fileSize[" + j3 + "]");
                hashMap.put("uint64_file_size", String.valueOf(j3));
            }
            if (jSONObject.has("md5")) {
                String string5 = jSONObject.getString("md5");
                if (!TextUtils.isEmpty(string5)) {
                    j("decodeResExtInfo fileMd5[" + string5 + "]");
                    hashMap.put("md5", string5);
                }
            }
            if (jSONObject.has("md510")) {
                String string6 = jSONObject.getString("md510");
                if (!TextUtils.isEmpty(string6)) {
                    j("decodeResExtInfo file10Md5[" + string6 + "]");
                    hashMap.put("md510", string6);
                }
            }
            if (jSONObject.has(WidgetCacheLunarData.SHA)) {
                String string7 = jSONObject.getString(WidgetCacheLunarData.SHA);
                if (!TextUtils.isEmpty(string7)) {
                    j("decodeResExtInfo sha[" + string7 + "]");
                    hashMap.put(WidgetCacheLunarData.SHA, string7);
                }
            }
            String str4 = str3;
            if (jSONObject.has(str4)) {
                String string8 = jSONObject.getString(str4);
                if (!TextUtils.isEmpty(string8)) {
                    j("decodeResExtInfo sha3[" + string8 + "]");
                    hashMap.put(str4, string8);
                }
            }
            String str5 = str2;
            if (jSONObject.has(str5) && (i16 = jSONObject.getInt(str5)) != 0) {
                j("decodeResExtInfo imgWidth[" + i16 + "]");
                hashMap.put(str5, String.valueOf(i16));
            }
            if (jSONObject.has("uint32_img_height") && (i3 = jSONObject.getInt("uint32_img_height")) != 0) {
                j("decodeResExtInfo imgHeight[" + i3 + "]");
                hashMap.put("uint32_img_height", String.valueOf(i3));
            }
        } catch (Exception unused) {
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String d(MsgBackupResEntity msgBackupResEntity) {
        w e16 = f.e();
        if (e16 == null) {
            return "";
        }
        String dataMigrationGetResourceLocalDestinyPath = e16.dataMigrationGetResourceLocalDestinyPath(new DataMigrationResourceInfo(msgBackupResEntity.msgSeq, msgBackupResEntity.msgRandom, msgBackupResEntity.msgType, msgBackupResEntity.msgSubType, msgBackupResEntity.filePath, msgBackupResEntity.fileSize, msgBackupResEntity.extraDataStr));
        if (dataMigrationGetResourceLocalDestinyPath != null && !TextUtils.isEmpty(dataMigrationGetResourceLocalDestinyPath)) {
            return dataMigrationGetResourceLocalDestinyPath;
        }
        QLog.d("FileMsgBackupHandler<QFile>", 1, "RawFileSave rawFilePath is null or empty");
        return "";
    }

    public abstract String e(MsgBackupResEntity msgBackupResEntity);

    public abstract void f(MessageRecord messageRecord, List<MsgBackupResEntity> list);

    public abstract void g(MsgBackupResEntity msgBackupResEntity);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean h(MsgBackupResEntity msgBackupResEntity) {
        int i3;
        if (msgBackupResEntity == null || msgBackupResEntity.msgType != 5 || ((i3 = msgBackupResEntity.msgSubType) != 12 && i3 != 11)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean i(MessageRecord messageRecord, MsgBackupResEntity msgBackupResEntity) {
        if (!messageRecord.isMultiMsg) {
            return true;
        }
        String str = c(msgBackupResEntity.extraDataStr).get("bytes_file_uuid");
        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("_m_ForwardUuid");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(extInfoFromExtStr) && str.equals(extInfoFromExtStr)) {
            if (QLog.isDebugVersion()) {
                QLog.i("FileMsgBackupHandler<QFile>", 1, "isResourceRelateToMsg: multi msg match res. fileId[" + extInfoFromExtStr + "] ");
            }
            return true;
        }
        return false;
    }

    protected boolean k(String str, String str2) {
        if (!FileUtils.fileExistsAndNotEmpty(str)) {
            QLog.i("FileMsgBackupHandler<QFile>", 1, "moveFileSavePath. tempPath is null");
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            QLog.i("FileMsgBackupHandler<QFile>", 1, "moveFileSavePath. targetPath is null");
            return false;
        }
        return FileUtils.moveFile(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(String str, String str2, String str3) {
        if (k(str, str2)) {
            QLog.d("FileMsgBackupHandler<QFile>", 1, "moveFileToRealPath. SavePath[" + str2 + "], TempPath[" + str + "],[ " + str3 + " ]");
            return;
        }
        QLog.d("FileMsgBackupHandler<QFile>", 1, "moveFileToRealPath. move file failed.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(String str, String str2, String str3, String str4) {
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str2 + MsgSummary.STR_COLON);
            if (!TextUtils.isEmpty(str3)) {
                sb5.append("msg[");
                sb5.append(str3);
                sb5.append("] ");
            }
            sb5.append(str4);
            QLog.i(str, 4, sb5.toString());
        }
    }
}
