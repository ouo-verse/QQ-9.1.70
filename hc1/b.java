package hc1;

import android.text.TextUtils;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.an;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b extends a {
    public b(BaseQQAppInterface baseQQAppInterface) {
        super(baseQQAppInterface);
    }

    private void n(MessageRecord messageRecord, List<MsgBackupResEntity> list) {
        FileManagerEntity fileManagerEntity;
        m("OfflineFileMsgBackupHandler<QFile>", "createOfflineFileRecord", String.valueOf(messageRecord.msgseq), "fileInfo[" + messageRecord.getExtInfoString() + "]");
        if (messageRecord.isMultiMsg) {
            QLog.d("OfflineFileMsgBackupHandler<QFile>", 1, "createOfflineFileRecord", String.valueOf(messageRecord.msgseq), "create multi file info.");
            fileManagerEntity = ah.t(this.f404729a, (ChatMessage) messageRecord);
        } else {
            QLog.d("OfflineFileMsgBackupHandler<QFile>", 1, "createOfflineFileRecord", String.valueOf(messageRecord.msgseq), "create normal file info.");
            fileManagerEntity = new FileManagerEntity();
            fileManagerEntity.nSessionId = ah.R().longValue();
            fileManagerEntity.uniseq = messageRecord.uniseq;
            fileManagerEntity.selfUin = messageRecord.selfuin;
            fileManagerEntity.isReaded = false;
            String str = messageRecord.frienduin;
            fileManagerEntity.peerUin = str;
            int i3 = messageRecord.istroop;
            fileManagerEntity.peerType = i3;
            fileManagerEntity.peerNick = ah.z0(this.f404729a, str, null, i3);
            fileManagerEntity.Uuid = messageRecord.getExtInfoFromExtStr("_backup_ForwardUuid");
            fileManagerEntity.fileName = messageRecord.getExtInfoFromExtStr("_backup_ForwardFileName");
            String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("_backup_ForwardSize");
            if (!TextUtils.isEmpty(extInfoFromExtStr)) {
                fileManagerEntity.fileSize = Long.parseLong(extInfoFromExtStr);
            }
            if (messageRecord.isSend()) {
                fileManagerEntity.nOpType = 0;
                fileManagerEntity.bSend = true;
            } else {
                fileManagerEntity.nOpType = 1;
                fileManagerEntity.bSend = false;
            }
            String extInfoFromExtStr2 = messageRecord.getExtInfoFromExtStr("_backup_ForwardFilePath");
            if (FileUtils.fileExistsAndNotEmpty(extInfoFromExtStr2)) {
                fileManagerEntity.setFilePath(extInfoFromExtStr2);
                fileManagerEntity.setCloudType(3);
            } else {
                fileManagerEntity.setCloudType(1);
            }
            fileManagerEntity.strFileMd5 = messageRecord.getExtInfoFromExtStr("_backup_ForwardMd5");
            fileManagerEntity.strFileSHA = messageRecord.getExtInfoFromExtStr("_backup_ForwardSha");
            try {
                fileManagerEntity.imgWidth = Integer.parseInt(messageRecord.getExtInfoFromExtStr("_backup_ForwardImgWidth"));
            } catch (NumberFormatException e16) {
                QLog.e("OfflineFileMsgBackupHandler<QFile>", 1, e16, new Object[0]);
            }
            try {
                fileManagerEntity.imgHeight = Integer.parseInt(messageRecord.getExtInfoFromExtStr("_backup_ForwardImgHeight"));
            } catch (NumberFormatException e17) {
                QLog.e("OfflineFileMsgBackupHandler<QFile>", 1, e17, new Object[0]);
            }
        }
        if (fileManagerEntity != null) {
            fileManagerEntity.status = -1;
            if (TextUtils.isEmpty(fileManagerEntity.Uuid)) {
                fileManagerEntity.status = 16;
            }
            fileManagerEntity.srvTime = messageRecord.time * 1000;
            if (list != null && !list.isEmpty()) {
                for (MsgBackupResEntity msgBackupResEntity : list) {
                    if (h(msgBackupResEntity) && i(messageRecord, msgBackupResEntity)) {
                        String e18 = e(msgBackupResEntity);
                        if (!TextUtils.isEmpty(e18)) {
                            int i16 = msgBackupResEntity.msgSubType;
                            if (i16 == 12) {
                                String d16 = d(msgBackupResEntity);
                                l(e18, d16, "OfflineFileMsgBackupHandler<QFile>");
                                if (FileUtils.fileExistsAndNotEmpty(d16)) {
                                    fileManagerEntity.strLargeThumPath = d16;
                                    QLog.d("OfflineFileMsgBackupHandler<QFile>", 1, "createOfflineFileRecord", String.valueOf(messageRecord.msgseq), "save large thumb path. path[" + d16 + "]");
                                }
                            } else if (i16 == 11) {
                                String d17 = d(msgBackupResEntity);
                                l(e18, d17, "OfflineFileMsgBackupHandler<QFile>");
                                if (FileUtils.fileExistsAndNotEmpty(d17)) {
                                    fileManagerEntity.setFilePath(d17);
                                    fileManagerEntity.status = 1;
                                    p(fileManagerEntity, msgBackupResEntity.extraDataStr);
                                    q(fileManagerEntity, msgBackupResEntity.extraDataStr);
                                    QLog.d("OfflineFileMsgBackupHandler<QFile>", 1, "createOfflineFileRecord", String.valueOf(messageRecord.msgseq), "save origin path. path[" + d17 + "]");
                                }
                            }
                        }
                    }
                }
            }
            IMsgBackupTempApi iMsgBackupTempApi = (IMsgBackupTempApi) QRoute.api(IMsgBackupTempApi.class);
            iMsgBackupTempApi.insertToMemMap(this.f404729a, fileManagerEntity);
            iMsgBackupTempApi.insertToFMList(this.f404729a, fileManagerEntity);
        }
    }

    private String o(String str, String str2, int i3) {
        String defaultThumbPath = lc1.b.a().getDefaultThumbPath();
        String f16 = an.f(i3, com.tencent.securitysdk.utils.c.b(str));
        if (!q.f(defaultThumbPath + f16) && !TextUtils.isEmpty(str2)) {
            return an.f(i3, com.tencent.securitysdk.utils.c.b(str2));
        }
        return f16;
    }

    private void p(FileManagerEntity fileManagerEntity, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("md5")) {
                fileManagerEntity.strFileMd5 = jSONObject.getString("md5");
            } else if (jSONObject.has("md510")) {
                fileManagerEntity.str10Md5 = jSONObject.getString("md510");
            }
        } catch (JSONException unused) {
        }
    }

    private void q(FileManagerEntity fileManagerEntity, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(WidgetCacheLunarData.SHA)) {
                fileManagerEntity.strFileSHA = jSONObject.getString(WidgetCacheLunarData.SHA);
            } else if (jSONObject.has("sha3")) {
                fileManagerEntity.strFileSha3 = jSONObject.getString("sha3");
            }
        } catch (JSONException unused) {
        }
    }

    private boolean r(MessageRecord messageRecord, List<MsgBackupResEntity> list) {
        String str;
        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("_backup_ForwardUuid");
        if (messageRecord.isMultiMsg) {
            extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("_m_ForwardUuid");
        }
        if (TextUtils.isEmpty(extInfoFromExtStr)) {
            QLog.d("OfflineFileMsgBackupHandler<QFile>", 1, "updateOfflineFileRecord", String.valueOf(messageRecord.msgseq), "error. file id is null.");
            return false;
        }
        IMsgBackupTempApi iMsgBackupTempApi = (IMsgBackupTempApi) QRoute.api(IMsgBackupTempApi.class);
        FileManagerEntity queryFileManagerEntityByFileUuidForMemory = iMsgBackupTempApi.queryFileManagerEntityByFileUuidForMemory(this.f404729a, extInfoFromExtStr);
        if (queryFileManagerEntityByFileUuidForMemory == null) {
            queryFileManagerEntityByFileUuidForMemory = iMsgBackupTempApi.queryEntityForDbByFileId(this.f404729a, extInfoFromExtStr);
        }
        FileManagerEntity fileManagerEntity = queryFileManagerEntityByFileUuidForMemory;
        if (fileManagerEntity == null) {
            return false;
        }
        if (!messageRecord.isMultiMsg) {
            str = "]";
            if (iMsgBackupTempApi.getMessageRecord(this.f404729a, messageRecord.frienduin, messageRecord.istroop, messageRecord.shmsgseq, messageRecord.msgtype) == null) {
                m("OfflineFileMsgBackupHandler<QFile>", "updateOfflineFileRecord", String.valueOf(messageRecord.msgseq), "old msg is not exist create bind. uniseq[" + messageRecord.uniseq + str);
                fileManagerEntity.uniseq = messageRecord.uniseq;
            }
        } else {
            QLog.d("OfflineFileMsgBackupHandler<QFile>", 1, "updateOfflineFileRecord", String.valueOf(messageRecord.msgseq), "messageForOfflineFile is isMultiMsg");
            fileManagerEntity.uniseq = messageRecord.uniseq;
            str = "]";
        }
        fileManagerEntity.status = -1;
        if (list != null && !list.isEmpty()) {
            for (MsgBackupResEntity msgBackupResEntity : list) {
                if (h(msgBackupResEntity) && i(messageRecord, msgBackupResEntity)) {
                    String e16 = e(msgBackupResEntity);
                    if (!TextUtils.isEmpty(e16)) {
                        int i3 = msgBackupResEntity.msgSubType;
                        if (i3 == 12) {
                            String d16 = d(msgBackupResEntity);
                            if (FileUtils.fileExistsAndNotEmpty(d16)) {
                                fileManagerEntity.strLargeThumPath = d16;
                                QLog.d("OfflineFileMsgBackupHandler<QFile>", 1, "updateOfflineFileRecord", String.valueOf(messageRecord.msgseq), "update large thumb path. path[" + d16 + str);
                            } else {
                                l(e16, d16, "OfflineFileMsgBackupHandler<QFile>");
                            }
                        } else if (i3 == 11) {
                            String d17 = d(msgBackupResEntity);
                            if (FileUtils.fileExistsAndNotEmpty(d17)) {
                                fileManagerEntity.setFilePath(d17);
                                fileManagerEntity.status = 1;
                                p(fileManagerEntity, msgBackupResEntity.extraDataStr);
                                q(fileManagerEntity, msgBackupResEntity.extraDataStr);
                                QLog.d("OfflineFileMsgBackupHandler<QFile>", 1, "updateOfflineFileRecord", String.valueOf(messageRecord.msgseq), "update origin file path. path[" + d17 + str);
                            } else {
                                l(e16, d17, "OfflineFileMsgBackupHandler<QFile>");
                            }
                        }
                    }
                }
            }
        }
        iMsgBackupTempApi.updateFileEntity(this.f404729a, fileManagerEntity);
        return true;
    }

    @Override // hc1.a
    public boolean a(MessageRecord messageRecord, MsgBackupResEntity msgBackupResEntity) {
        if (msgBackupResEntity == null) {
            return false;
        }
        int i3 = msgBackupResEntity.msgSubType;
        if (i3 == 12) {
            boolean fileExistsAndNotEmpty = FileUtils.fileExistsAndNotEmpty(d(msgBackupResEntity));
            QLog.i("<QFile_Backup>", 1, "checkNeedDownloadRes: offline large thumb exist[" + fileExistsAndNotEmpty + "]");
            return !fileExistsAndNotEmpty;
        }
        if (i3 != 11) {
            return false;
        }
        boolean fileExistsAndNotEmpty2 = FileUtils.fileExistsAndNotEmpty(d(msgBackupResEntity));
        QLog.i("<QFile_Backup>", 1, "checkNeedDownloadRes: offline origin file exist[" + fileExistsAndNotEmpty2 + "]");
        return !fileExistsAndNotEmpty2;
    }

    @Override // hc1.a
    public String e(MsgBackupResEntity msgBackupResEntity) {
        String str;
        String str2;
        HashMap<String, String> c16 = c(msgBackupResEntity.extraDataStr);
        int i3 = msgBackupResEntity.msgSubType;
        if (i3 == 12) {
            String str3 = c16.get("md5");
            if (TextUtils.isEmpty(str3)) {
                str3 = c16.get("md510");
            }
            String str4 = c16.get("bytes_file_uuid");
            if (QLog.isDebugVersion()) {
                QLog.i("<QFile_Backup>", 1, "getTempFilePath: md5[" + str3 + "] fileId[" + str4 + "]");
            }
            str = o(str4, str3, 7);
            str2 = a.f404727b;
        } else if (i3 != 11) {
            str = "";
            str2 = str;
        } else {
            String str5 = c16.get("str_file_name");
            if (QLog.isDebugVersion()) {
                QLog.i("<QFile_Backup>", 1, "getTempFilePath: offline fileName[" + str5 + "]");
            }
            str = MD5.toMD5(str5 + c16.get("bytes_file_uuid"));
            if (QLog.isDebugVersion()) {
                QLog.i("<QFile_Backup>", 1, "getTempFilePath: offline temp msg backup fileName[" + str + "]");
            }
            str2 = a.f404728c;
        }
        m("OfflineFileMsgBackupHandler<QFile>", "getTempFilePath", "", "resType[" + msgBackupResEntity.msgType + "] tempPath[" + str2 + str + "]");
        return str2 + str;
    }

    @Override // hc1.a
    public void f(MessageRecord messageRecord, List<MsgBackupResEntity> list) {
        if (list != null) {
            QLog.d("OfflineFileMsgBackupHandler<QFile>", 1, "Import --step: msgSeq[" + messageRecord.msgseq + "resourceSize[" + list.size() + "]");
            Iterator<MsgBackupResEntity> it = list.iterator();
            while (it.hasNext()) {
                QLog.d("OfflineFileMsgBackupHandler<QFile>", 1, "Import --step: backup entity [" + it.next().toLogString() + "]");
            }
        }
        if (r(messageRecord, list)) {
            QLog.d("OfflineFileMsgBackupHandler<QFile>", 1, "handleImport", String.valueOf(messageRecord.msgseq), "update offline file record.");
        } else {
            n(messageRecord, list);
            QLog.d("OfflineFileMsgBackupHandler<QFile>", 1, "handleImport", String.valueOf(messageRecord.msgseq), "create offline file record.");
        }
        b(messageRecord);
    }

    @Override // hc1.a
    public void g(MsgBackupResEntity msgBackupResEntity) {
        if (!h(msgBackupResEntity)) {
            return;
        }
        String e16 = e(msgBackupResEntity);
        if (TextUtils.isEmpty(e16)) {
            return;
        }
        int i3 = msgBackupResEntity.msgSubType;
        if (i3 == 12) {
            l(e16, d(msgBackupResEntity), "OfflineFileMsgBackupHandler<QFile>");
        } else if (i3 == 11) {
            l(e16, d(msgBackupResEntity), "OfflineFileMsgBackupHandler<QFile>");
        }
    }
}
