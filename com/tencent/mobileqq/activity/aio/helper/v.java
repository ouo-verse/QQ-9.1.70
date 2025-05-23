package com.tencent.mobileqq.activity.aio.helper;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes10.dex */
public class v {
    public static void a(FileManagerEntity fileManagerEntity, MessageForTroopFile messageForTroopFile) {
        if (fileManagerEntity != null && messageForTroopFile != null) {
            if (fileManagerEntity.fileSize == 0) {
                long j3 = messageForTroopFile.fileSize;
                if (j3 > 0) {
                    fileManagerEntity.fileSize = j3;
                    if (QLog.isColorLevel()) {
                        QLog.d(ProcessConstant.QQFAV, 2, "checkPatchEntity, patch size:" + fileManagerEntity.fileSize);
                    }
                }
            }
            if (TextUtils.isEmpty(fileManagerEntity.fileName) && !TextUtils.isEmpty(messageForTroopFile.fileName)) {
                fileManagerEntity.fileName = messageForTroopFile.fileName;
                if (QLog.isColorLevel()) {
                    QLog.d(ProcessConstant.QQFAV, 2, "checkPatchEntity, patch name:" + fileManagerEntity.fileName);
                }
            }
        }
    }

    public static FileManagerEntity b(QQAppInterface qQAppInterface, ChatMessage chatMessage) {
        int i3;
        if (chatMessage == null || !chatMessage.isMultiMsg) {
            return null;
        }
        String extInfoFromExtStr = chatMessage.getExtInfoFromExtStr("_m_ForwardFileType");
        if (!TextUtils.isEmpty(extInfoFromExtStr)) {
            i3 = Integer.parseInt(extInfoFromExtStr);
        } else {
            i3 = -1;
        }
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            return null;
        }
        FileManagerEntity fileManagerEntity = new FileManagerEntity();
        fileManagerEntity.nSessionId = FileManagerUtil.genSessionId().longValue();
        fileManagerEntity.uniseq = chatMessage.uniseq;
        fileManagerEntity.selfUin = qQAppInterface.getAccount();
        fileManagerEntity.isReaded = false;
        String extInfoFromExtStr2 = chatMessage.getExtInfoFromExtStr("_m_ForwardBusType");
        if (!TextUtils.isEmpty(extInfoFromExtStr2)) {
            fileManagerEntity.busId = Integer.valueOf(extInfoFromExtStr2).intValue();
        } else {
            fileManagerEntity.busId = -1;
        }
        fileManagerEntity.peerUin = chatMessage.getExtInfoFromExtStr("_m_ForwardReceiverUin");
        if (i3 == 1) {
            fileManagerEntity.peerType = 0;
            fileManagerEntity.peerUin = chatMessage.getExtInfoFromExtStr("_m_ForwardSenderUin");
        } else if (i3 == 2) {
            fileManagerEntity.peerType = 3000;
        } else if (i3 == 3) {
            fileManagerEntity.peerType = 1;
        }
        fileManagerEntity.peerNick = FileManagerUtil.getPeerNick(qQAppInterface, fileManagerEntity.peerUin, null, fileManagerEntity.peerType);
        fileManagerEntity.Uuid = chatMessage.getExtInfoFromExtStr("_m_ForwardUuid");
        fileManagerEntity.fileIdCrc = chatMessage.getExtInfoFromExtStr("_m_ForwardFileIdCrc");
        fileManagerEntity.fileName = chatMessage.getExtInfoFromExtStr("_m_ForwardFileName");
        String extInfoFromExtStr3 = chatMessage.getExtInfoFromExtStr("_m_ForwardSize");
        if (!TextUtils.isEmpty(extInfoFromExtStr3)) {
            fileManagerEntity.fileSize = Long.parseLong(extInfoFromExtStr3);
        }
        String extInfoFromExtStr4 = chatMessage.getExtInfoFromExtStr("_m_ForwardSenderUin");
        if (!TextUtils.isEmpty(fileManagerEntity.selfUin)) {
            if (fileManagerEntity.selfUin.equals(extInfoFromExtStr4)) {
                fileManagerEntity.nOpType = 0;
            } else {
                fileManagerEntity.nOpType = 1;
            }
        }
        fileManagerEntity.status = -1;
        String extInfoFromExtStr5 = chatMessage.getExtInfoFromExtStr("_m_ForwardReceiverUin");
        if (!TextUtils.isEmpty(fileManagerEntity.selfUin)) {
            if (fileManagerEntity.selfUin.equals(extInfoFromExtStr5)) {
                fileManagerEntity.bSend = false;
            } else {
                fileManagerEntity.bSend = true;
            }
        }
        String extInfoFromExtStr6 = chatMessage.getExtInfoFromExtStr("_m_ForwardFilePath");
        if (FileUtils.fileExistsAndNotEmpty(extInfoFromExtStr6)) {
            fileManagerEntity.setFilePath(extInfoFromExtStr6);
            fileManagerEntity.setCloudType(3);
        } else {
            fileManagerEntity.setCloudType(1);
        }
        fileManagerEntity.strFileMd5 = chatMessage.getExtInfoFromExtStr("_m_ForwardMd5");
        fileManagerEntity.strFileSHA = chatMessage.getExtInfoFromExtStr("_m_ForwardSha");
        try {
            fileManagerEntity.imgWidth = Integer.parseInt(chatMessage.getExtInfoFromExtStr("_m_ForwardImgWidth"));
        } catch (NumberFormatException unused) {
        }
        try {
            fileManagerEntity.imgHeight = Integer.parseInt(chatMessage.getExtInfoFromExtStr("_m_ForwardImgHeight"));
        } catch (NumberFormatException unused2) {
        }
        return fileManagerEntity;
    }

    public static String c(QQAppInterface qQAppInterface, ChatMessage chatMessage) {
        String str;
        if (chatMessage != null && qQAppInterface != null) {
            String k3 = com.tencent.imcore.message.ad.k(chatMessage);
            if (chatMessage.isMultiMsg && !com.tencent.biz.anonymous.a.m(chatMessage)) {
                str = chatMessage.getExtInfoFromExtStr("self_nickname");
                if (TextUtils.isEmpty(str)) {
                    str = MultiMsgManager.w().z(chatMessage.senderuin, chatMessage.msgseq, qQAppInterface);
                }
            } else {
                str = "";
            }
            if (str == null || TextUtils.getTrimmedLength(str) == 0) {
                str = com.tencent.mobileqq.multimsg.i.d(chatMessage.senderuin);
            }
            if (!TextUtils.isEmpty(k3)) {
                return str;
            }
            return k3;
        }
        return null;
    }

    public static FileManagerEntity d(com.tencent.mobileqq.troop.data.t tVar) {
        FileManagerEntity fileManagerEntity = new FileManagerEntity();
        fileManagerEntity.nSessionId = FileManagerUtil.genSessionId().longValue();
        fileManagerEntity.setCloudType(4);
        fileManagerEntity.fileName = tVar.f294987u;
        if (com.tencent.mobileqq.filemanager.util.q.p(tVar.f294978l)) {
            fileManagerEntity.setFilePath(tVar.f294978l);
        }
        if (com.tencent.mobileqq.filemanager.util.q.p(tVar.f294980n)) {
            fileManagerEntity.strLargeThumPath = tVar.f294980n;
        }
        if (com.tencent.mobileqq.filemanager.util.q.p(tVar.f294979m)) {
            fileManagerEntity.strThumbPath = tVar.f294979m;
        } else if (com.tencent.mobileqq.filemanager.util.q.p(tVar.f294981o)) {
            fileManagerEntity.strMiddleThumPath = tVar.f294981o;
        }
        long j3 = tVar.f294976j;
        fileManagerEntity.fileSize = j3;
        fileManagerEntity.fProgress = ((float) tVar.f294977k) / ((float) j3);
        fileManagerEntity.nFileType = FileManagerUtil.getFileType(tVar.f294987u);
        int i3 = tVar.f294972f;
        if (6 <= i3 && 13 != i3) {
            if (12 == i3) {
                fileManagerEntity.status = 0;
            } else {
                fileManagerEntity.status = 1;
            }
        } else {
            fileManagerEntity.status = 2;
        }
        UUID uuid = tVar.f294967a;
        if (uuid != null) {
            fileManagerEntity.strTroopFileID = uuid.toString();
        }
        fileManagerEntity.strTroopFilePath = tVar.f294985s;
        fileManagerEntity.strTroopFileSha1 = tVar.f294986t;
        fileManagerEntity.busId = tVar.f294988v;
        long j16 = tVar.f294971e;
        fileManagerEntity.TroopUin = j16;
        fileManagerEntity.peerType = 1;
        fileManagerEntity.peerUin = String.valueOf(j16);
        fileManagerEntity.peerUid = String.valueOf(tVar.f294971e);
        fileManagerEntity.srvTime = com.tencent.mobileqq.service.message.e.K0() * 1000;
        QLog.i("MultiFavoriteHelper", 1, "=_= create new Entity[" + fileManagerEntity.nSessionId + "] fileName[" + tVar.f294987u + "] by troop size(" + fileManagerEntity.imgHeight + ":" + fileManagerEntity.imgWidth + ")");
        return fileManagerEntity;
    }
}
