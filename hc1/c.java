package hc1;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c extends a {
    public c(BaseQQAppInterface baseQQAppInterface) {
        super(baseQQAppInterface);
    }

    private void n(MessageRecord messageRecord, List<MsgBackupResEntity> list) {
        MessageForTroopFile messageForTroopFile;
        boolean z16;
        char c16;
        Iterator<MsgBackupResEntity> it;
        String str;
        char c17;
        boolean z17 = true;
        if (messageRecord == null) {
            QLog.e("TroopFileMsgBackupHandler<QFile>", 1, "createTroopFileRecord: failed. get troop file msg is null.");
            return;
        }
        IMsgBackupTempApi iMsgBackupTempApi = (IMsgBackupTempApi) QRoute.api(IMsgBackupTempApi.class);
        char c18 = 3;
        if (messageRecord.isMultiMsg) {
            messageForTroopFile = (MessageForTroopFile) iMsgBackupTempApi.changeRealChatMessage((ChatMessage) messageRecord);
            QLog.d("TroopFileMsgBackupHandler<QFile>", 1, "createTroopFileRecord", String.valueOf(messageForTroopFile.msgseq), "MessageForTroopFile is isMultiMsg");
        } else {
            messageForTroopFile = (MessageForTroopFile) messageRecord;
        }
        long parseLong = Long.parseLong(messageForTroopFile.frienduin);
        if (iMsgBackupTempApi.isNeedHandleCreateTroopFileInfo(this.f404729a, parseLong, messageForTroopFile) && list != null && !list.isEmpty()) {
            Iterator<MsgBackupResEntity> it5 = list.iterator();
            String str2 = "";
            String str3 = "";
            while (it5.hasNext()) {
                MsgBackupResEntity next = it5.next();
                if (h(next) && i(messageRecord, next)) {
                    String e16 = e(next);
                    if (!TextUtils.isEmpty(e16)) {
                        int i3 = next.msgSubType;
                        if (i3 == 12) {
                            str3 = d(next);
                            l(e16, str3, "TroopFileMsgBackupHandler<QFile>");
                            it = it5;
                            z16 = true;
                            QLog.d("TroopFileMsgBackupHandler<QFile>", 1, "createTroopFileRecord", String.valueOf(messageForTroopFile.msgseq), "save large thumb path. path[" + str3 + "]");
                            str2 = str2;
                            c16 = 3;
                            c17 = 2;
                        } else {
                            it = it5;
                            str = str2;
                            z16 = true;
                            if (i3 == 11) {
                                String d16 = d(next);
                                l(e16, d16, "TroopFileMsgBackupHandler<QFile>");
                                c16 = 3;
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("save raw File path. path[");
                                str2 = d16;
                                sb5.append(str2);
                                sb5.append("]");
                                String sb6 = sb5.toString();
                                c17 = 2;
                                QLog.d("TroopFileMsgBackupHandler<QFile>", 1, "createTroopFileRecord", String.valueOf(messageForTroopFile.msgseq), sb6);
                            } else {
                                c16 = 3;
                            }
                        }
                        c18 = c16;
                        z17 = z16;
                        it5 = it;
                    } else {
                        z16 = z17;
                        c16 = c18;
                        it = it5;
                        str = str2;
                    }
                    c17 = 2;
                    str2 = str;
                    c18 = c16;
                    z17 = z16;
                    it5 = it;
                }
            }
            iMsgBackupTempApi.saveTroopFileInfo(this.f404729a, parseLong, messageForTroopFile, str2, str3);
        }
    }

    private boolean o(MessageRecord messageRecord, List<MsgBackupResEntity> list) {
        MessageForTroopFile messageForTroopFile;
        if (messageRecord == null) {
            QLog.e("TroopFileMsgBackupHandler<QFile>", 1, "updateTroopFileRecord: get updateTroopFileRecord failed. get troop file msg is null.");
            return false;
        }
        IMsgBackupTempApi iMsgBackupTempApi = (IMsgBackupTempApi) QRoute.api(IMsgBackupTempApi.class);
        if (messageRecord.isMultiMsg) {
            messageForTroopFile = (MessageForTroopFile) iMsgBackupTempApi.changeRealChatMessage((ChatMessage) messageRecord);
            QLog.d("TroopFileMsgBackupHandler<QFile>", 1, "updateTroopFileRecord", String.valueOf(messageForTroopFile.msgseq), "MessageForTroopFile is isMultiMsg");
        } else {
            messageForTroopFile = (MessageForTroopFile) messageRecord;
        }
        if (!iMsgBackupTempApi.isNeedHandleTroopFileRecord(this.f404729a, messageForTroopFile)) {
            return false;
        }
        if (list != null && !list.isEmpty()) {
            String str = "";
            String str2 = "";
            for (MsgBackupResEntity msgBackupResEntity : list) {
                if (h(msgBackupResEntity) && i(messageRecord, msgBackupResEntity)) {
                    String e16 = e(msgBackupResEntity);
                    if (!TextUtils.isEmpty(e16)) {
                        int i3 = msgBackupResEntity.msgSubType;
                        if (i3 == 12) {
                            str2 = d(msgBackupResEntity);
                            if (FileUtils.fileExistsAndNotEmpty(str2)) {
                                QLog.d("TroopFileMsgBackupHandler<QFile>", 1, "updateTroopFileRecord", String.valueOf(messageForTroopFile.msgseq), "getLargeThumbPath2 is exists");
                            } else {
                                l(e16, str2, "TroopFileMsgBackupHandler<QFile>");
                            }
                        } else if (i3 == 11) {
                            str = d(msgBackupResEntity);
                            if (FileUtils.fileExistsAndNotEmpty(str)) {
                                QLog.d("TroopFileMsgBackupHandler<QFile>", 1, "updateTroopFileRecord", String.valueOf(messageForTroopFile.msgseq), "getLocalFilePath2 is exists");
                            } else {
                                l(e16, str, "TroopFileMsgBackupHandler<QFile>");
                            }
                        }
                    }
                }
            }
            if (FileUtils.fileExistsAndNotEmpty(str)) {
                QLog.d("TroopFileMsgBackupHandler<QFile>", 1, "updateTroopFileRecord", String.valueOf(messageForTroopFile.msgseq), "rawFilePath is save");
                iMsgBackupTempApi.saveItemRawPath(this.f404729a, messageForTroopFile, str);
            }
            if (FileUtils.fileExistsAndNotEmpty(str2)) {
                QLog.d("TroopFileMsgBackupHandler<QFile>", 1, "updateTroopFileRecord", String.valueOf(messageForTroopFile.msgseq), "largeThumbPath is save");
                iMsgBackupTempApi.saveItemLargeThrumbPath(this.f404729a, messageForTroopFile, str2);
            }
        }
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
            QLog.i("<QFile_Backup>", 1, "checkNeedDownloadRes: Troop large thumb exist[" + fileExistsAndNotEmpty + "]");
            return !fileExistsAndNotEmpty;
        }
        if (i3 != 11) {
            return false;
        }
        boolean fileExistsAndNotEmpty2 = FileUtils.fileExistsAndNotEmpty(d(msgBackupResEntity));
        QLog.i("<QFile_Backup>", 1, "checkNeedDownloadRes: Troop origin file exist[" + fileExistsAndNotEmpty2 + "]");
        return !fileExistsAndNotEmpty2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.StringBuilder] */
    @Override // hc1.a
    public String e(MsgBackupResEntity msgBackupResEntity) {
        String str;
        String str2;
        ?? c16;
        long j3;
        String str3 = "";
        try {
            c16 = c(msgBackupResEntity.extraDataStr);
            IMsgBackupTempApi iMsgBackupTempApi = (IMsgBackupTempApi) QRoute.api(IMsgBackupTempApi.class);
            int i3 = msgBackupResEntity.msgSubType;
            try {
                if (i3 == 12) {
                    String str4 = (String) c16.get("uint64_receiver_uin");
                    if (!TextUtils.isEmpty(str4)) {
                        j3 = Long.parseLong(str4);
                    } else {
                        QLog.i("<QFile_Backup>", 1, "getTempFilePath: troop file uin is null");
                        j3 = 0;
                    }
                    String str5 = (String) c16.get("bytes_file_uuid");
                    if (QLog.isDebugVersion()) {
                        QLog.i("<QFile_Backup>", 1, "getTempFilePath: troop file uin[" + str4 + "] fileId[" + str5 + "]");
                    }
                    String troopThumbnailFile = iMsgBackupTempApi.getTroopThumbnailFile(j3, str5);
                    str = a.f404727b;
                    c16 = troopThumbnailFile;
                } else if (i3 != 11) {
                    String str6 = "";
                    str = str6;
                    c16 = str6;
                } else {
                    String str7 = (String) c16.get("str_file_name");
                    try {
                        if (QLog.isDebugVersion()) {
                            QLog.i("<QFile_Backup>", 1, "getTempFilePath: troop fileName[" + str7 + "]");
                        }
                        String md5 = MD5.toMD5(str7 + ((String) c16.get("bytes_file_uuid")));
                        if (QLog.isDebugVersion()) {
                            QLog.i("<QFile_Backup>", 1, "getTempFilePath: troop temp msg backup fileName[" + md5 + "]");
                        }
                        str = a.f404728c;
                        c16 = md5;
                    } catch (Exception e16) {
                        e = e16;
                        str = "";
                        str3 = str7;
                        QLog.e("TroopFileMsgBackupHandler<QFile>", 1, "getTroopFileException: " + Arrays.toString(e.getStackTrace()));
                        str2 = str3;
                        return str + str2;
                    }
                }
            } catch (Exception e17) {
                e = e17;
                str = "";
            }
        } catch (Exception e18) {
            e = e18;
            str = "";
        }
        try {
            m("TroopFileMsgBackupHandler<QFile>", "getTempFilePath", "", "resType[" + msgBackupResEntity.msgType + "] tempPath[" + str + c16 + "]");
            str2 = c16;
        } catch (Exception e19) {
            e = e19;
            str3 = c16;
            QLog.e("TroopFileMsgBackupHandler<QFile>", 1, "getTroopFileException: " + Arrays.toString(e.getStackTrace()));
            str2 = str3;
            return str + str2;
        }
        return str + str2;
    }

    @Override // hc1.a
    public void f(MessageRecord messageRecord, List<MsgBackupResEntity> list) {
        if (QLog.isDebugVersion()) {
            QLog.i("<QFile_Backup>", 1, "Import: type[troop] contactUin[" + messageRecord.frienduin + "] senderUin[" + messageRecord.senderuin + "] uniSeq[" + messageRecord.uniseq + "] msgSeq[" + messageRecord.msgseq + "]");
            if (list != null) {
                QLog.i("<QFile_Backup>", 1, "Import --step: msgSeq[" + messageRecord.msgseq + "resourceSize[" + list.size() + "]");
                Iterator<MsgBackupResEntity> it = list.iterator();
                while (it.hasNext()) {
                    QLog.i("<QFile_Backup>", 1, "Import --step: backup entity [" + it.next().toLogString() + "]");
                }
            }
        }
        if (o(messageRecord, list)) {
            m("TroopFileMsgBackupHandler<QFile>", "handleImport", String.valueOf(messageRecord.msgseq), "update troop file record.");
        } else {
            n(messageRecord, list);
            m("TroopFileMsgBackupHandler<QFile>", "handleImport", String.valueOf(messageRecord.msgseq), "create troop file record.");
        }
        b(messageRecord);
    }

    @Override // hc1.a
    public void g(MsgBackupResEntity msgBackupResEntity) {
        if (!h(msgBackupResEntity)) {
            return;
        }
        String e16 = e(msgBackupResEntity);
        if (!TextUtils.isEmpty(e16)) {
            int i3 = msgBackupResEntity.msgSubType;
            if (i3 == 12) {
                l(e16, d(msgBackupResEntity), "TroopFileMsgBackupHandler<QFile>");
            } else if (i3 == 11) {
                l(e16, d(msgBackupResEntity), "TroopFileMsgBackupHandler<QFile>");
            }
        }
    }
}
