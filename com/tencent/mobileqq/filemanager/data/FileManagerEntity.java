package com.tencent.mobileqq.filemanager.data;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.IGNORE, columnNames = "nSessionId")
/* loaded from: classes12.dex */
public class FileManagerEntity extends Entity implements Cloneable {
    public long TroopUin;
    public String Uuid;
    public String WeiYunDirKey;
    public String WeiYunFileId;
    public String apkSafeDetailUrl;
    public int apkSafeLevel;
    public String apkSafeMsg;
    public boolean bCannotPlay;
    public boolean bDelInAio;
    public boolean bDelInFM;
    public boolean bOnceSuccess;
    public boolean bSend;

    @notColumn
    public boolean bUseMediaPlatform;
    public byte[] bombData;
    public int busId;
    public String channelId;
    public String channelName;
    public int cloudType;

    @notColumn
    public long datalineEntitySessionId;
    public long dbVer;
    public int dlGourpIndex;
    public int dlGroupCount;
    public int dlGroupId;
    public long duplicateEntitySessionId;
    public String duplicateFilePath;
    public int errCode;
    public float fOlRecvProgressOnNotify;
    public float fOlRecvSpeed;
    public float fProgress;
    public String fileIdCrc;
    public String fileName;

    @notColumn
    public String fileSetId;
    public long fileSize;
    public int forwardTroopFileEntrance;
    public int fromScene;
    public long fwSrcNtMsgId;
    public int fwSrcPeerType;
    public String fwSrcPeerUid;
    public long fwSrcUniseq;
    public String guildId;
    public String guildName;
    public String httpsDomain;
    public int imgHeight;
    public int imgWidth;
    public boolean isDuplicateFile;

    @notColumn
    public boolean isFromrMolo;
    public boolean isReaded;
    public boolean isZipInnerFile;

    @notColumn
    public long lastSuccessTime;
    public long lastTime;
    public long localModifyTime;

    @notColumn
    public Object mContext;

    @notColumn
    public int mThumbRetryCount;
    public long mTroopFileVideoReqInterval;

    @notColumn
    public String miniAppDownloadId;
    public long msgSeq;
    public long msgTime;
    public long msgUid;
    public int nFileType;
    public long nOLfileSessionId;
    public int nOlSenderProgress;
    public long nRelatedSessionId;
    public int nWeiYunSrcType;

    @notColumn
    public int nfcServerIP;

    @notColumn
    public short nfcServerPort;

    @notColumn
    public byte[] nfcTokenKey;

    @notColumn
    public byte[] nfcUrlNotify;
    public int ntChatType;
    public long ntMsgId;
    public long ntSubMsgID;

    @notColumn
    public long originMsgTime;

    @notColumn
    public long originShmsgseq;

    @notColumn
    public long peerDin;
    public String peerNick;
    public String peerUid;
    public String peerUin;

    @notColumn
    public int qlmsgSrc;

    @notColumn
    public FileManagerEntity relatedEntity;

    @notColumn
    public FileManagerEntitySearchPCPart searchPCPart;
    public String selfUin;
    public int status;
    public String str10Md5;
    public String strApkPackageName;

    @notColumn
    public String strDataLineMPFileID;
    public String strFavFileId;
    public String strFavId;
    public String strFileMd5;
    public String strFilePath;
    public String strFileSHA;
    public String strFileSha3;
    public String strLargeThumPath;
    public String strMiddleThumPath;
    public String strQRUrl;
    public String strServerPath;
    public String strSrcName;
    public String strThumbPath;
    public String strTroopFileID;
    public String strTroopFilePath;
    public String strTroopFileSha1;
    public String strTroopFileUuid;
    public long structMsgSeq;

    @notColumn
    public int svrPathIpType;
    public int thumbInvalidCode;
    public String tmpSessionFromPhone;
    public String tmpSessionRelatedUin;

    @notColumn
    public byte[] tmpSessionSig;
    public String tmpSessionToPhone;
    public long tmpSessionType;

    @notColumn
    public int transSpeed;

    @notColumn
    public boolean videoDownloadForceThroughNT;
    public String yybApkIconUrl;
    public String yybApkName;
    public String yybApkPackageName;
    public String zipFileId;
    public String zipFilePath;
    public String zipInnerPath;
    public int zipType;

    @notColumn
    public boolean bSetVerify = false;

    @notColumn
    public String mExcitingSpeed = null;

    @notColumn
    public boolean isCheckPrivateDir = false;

    @notColumn
    public boolean isStartWlan = false;

    @notColumn
    public boolean fromFile = false;

    @notColumn
    public int entrance = 0;

    @notColumn
    public boolean isPhotoToMyComputer = false;

    @unique
    public long nSessionId = 0;
    public long uniseq = -1;
    public int peerType = 0;
    public long srvTime = com.tencent.mobileqq.service.message.e.K0() * 1000;
    public int nOpType = -1;

    public FileManagerEntity() {
        this.videoDownloadForceThroughNT = false;
        this.searchPCPart = null;
        this.fileSetId = "";
        setCloudType(-1);
        this.fileSize = 0L;
        this.status = -1;
        this.nFileType = -1;
        this.fProgress = 0.0f;
        this.isReaded = false;
        this.nWeiYunSrcType = 0;
        this.lastTime = 0L;
        this.bDelInAio = false;
        this.bDelInFM = false;
        this.bSend = true;
        this.nOlSenderProgress = -1;
        this.fOlRecvSpeed = 0.0f;
        this.fOlRecvProgressOnNotify = 0.0f;
        this.dbVer = 50L;
        this.msgSeq = 0L;
        this.msgUid = 0L;
        this.nRelatedSessionId = 0L;
        this.msgTime = 0L;
        this.nOLfileSessionId = 0L;
        this.busId = 0;
        this.TroopUin = 0L;
        this.errCode = 0;
        this.transSpeed = 0;
        this.qlmsgSrc = 0;
        this.tmpSessionType = 0L;
        this.bCannotPlay = false;
        this.bOnceSuccess = false;
        this.mThumbRetryCount = 0;
        this.bUseMediaPlatform = false;
        this.apkSafeLevel = 0;
        this.svrPathIpType = 0;
        this.fromScene = 0;
        this.ntMsgId = 0L;
        this.fwSrcNtMsgId = 0L;
        this.fwSrcPeerType = 0;
        this.fwSrcUniseq = 0L;
        this.ntSubMsgID = 0L;
        this.ntChatType = 0;
        this.duplicateFilePath = "";
        this.isDuplicateFile = false;
        this.duplicateEntitySessionId = 0L;
        this.videoDownloadForceThroughNT = false;
        this.searchPCPart = new FileManagerEntitySearchPCPart();
        this.fileSetId = "";
    }

    public static String tableName() {
        return "mr_fileManager";
    }

    public synchronized void copyFrom(FileManagerEntity fileManagerEntity) {
        byte[] bArr = fileManagerEntity.bombData;
        if (bArr != null) {
            this.bombData = (byte[]) bArr.clone();
        }
        this.fileName = fileManagerEntity.fileName;
        this.fileSize = fileManagerEntity.fileSize;
        this.fProgress = fileManagerEntity.fProgress;
        this.isReaded = fileManagerEntity.isReaded;
        this.uniseq = fileManagerEntity.uniseq;
        this.nFileType = fileManagerEntity.nFileType;
        this.nOpType = fileManagerEntity.nOpType;
        this.peerNick = fileManagerEntity.peerNick;
        this.peerType = fileManagerEntity.peerType;
        this.peerUin = fileManagerEntity.peerUin;
        this.selfUin = fileManagerEntity.selfUin;
        this.srvTime = fileManagerEntity.srvTime;
        this.status = fileManagerEntity.status;
        setFilePath(fileManagerEntity.getFilePath());
        setCloudType(fileManagerEntity.getCloudType());
        this.strServerPath = fileManagerEntity.strServerPath;
        this.strLargeThumPath = fileManagerEntity.strLargeThumPath;
        this.strMiddleThumPath = fileManagerEntity.strMiddleThumPath;
        this.strThumbPath = fileManagerEntity.strThumbPath;
        this.Uuid = fileManagerEntity.Uuid;
        this.fileIdCrc = fileManagerEntity.fileIdCrc;
        this.bUseMediaPlatform = fileManagerEntity.bUseMediaPlatform;
        this.WeiYunFileId = fileManagerEntity.WeiYunFileId;
        this.WeiYunDirKey = fileManagerEntity.WeiYunDirKey;
        this.nWeiYunSrcType = fileManagerEntity.nWeiYunSrcType;
        this.lastTime = fileManagerEntity.lastTime;
        this.bSend = fileManagerEntity.bSend;
        this.nOlSenderProgress = fileManagerEntity.nOlSenderProgress;
        this.fOlRecvSpeed = fileManagerEntity.fOlRecvSpeed;
        this.fOlRecvProgressOnNotify = fileManagerEntity.fOlRecvProgressOnNotify;
        this.dbVer = fileManagerEntity.dbVer;
        this.strSrcName = fileManagerEntity.strSrcName;
        this.msgSeq = fileManagerEntity.msgSeq;
        this.msgUid = fileManagerEntity.msgUid;
        this.nRelatedSessionId = fileManagerEntity.nRelatedSessionId;
        this.msgTime = fileManagerEntity.msgTime;
        this.nOLfileSessionId = fileManagerEntity.nOLfileSessionId;
        this.strFileMd5 = fileManagerEntity.strFileMd5;
        this.strTroopFileID = fileManagerEntity.strTroopFileID;
        this.strTroopFilePath = fileManagerEntity.strTroopFilePath;
        this.busId = fileManagerEntity.busId;
        this.TroopUin = fileManagerEntity.TroopUin;
        this.structMsgSeq = fileManagerEntity.structMsgSeq;
        this.errCode = fileManagerEntity.errCode;
        this.strFileSHA = fileManagerEntity.strFileSHA;
        this.tmpSessionType = fileManagerEntity.tmpSessionType;
        this.tmpSessionRelatedUin = fileManagerEntity.tmpSessionRelatedUin;
        this.tmpSessionFromPhone = fileManagerEntity.tmpSessionFromPhone;
        this.tmpSessionToPhone = fileManagerEntity.tmpSessionToPhone;
        this.imgWidth = fileManagerEntity.imgWidth;
        this.imgHeight = fileManagerEntity.imgHeight;
        this.bCannotPlay = fileManagerEntity.bCannotPlay;
        this.lastSuccessTime = fileManagerEntity.lastSuccessTime;
        this.zipInnerPath = fileManagerEntity.zipInnerPath;
        this.isZipInnerFile = fileManagerEntity.isZipInnerFile;
        this.httpsDomain = fileManagerEntity.httpsDomain;
        this.strFavFileId = fileManagerEntity.strFavFileId;
        this.strFavId = fileManagerEntity.strFavId;
        this.yybApkPackageName = fileManagerEntity.yybApkPackageName;
        this.yybApkName = fileManagerEntity.yybApkName;
        this.yybApkIconUrl = fileManagerEntity.yybApkIconUrl;
        this.apkSafeLevel = fileManagerEntity.apkSafeLevel;
        this.apkSafeMsg = fileManagerEntity.apkSafeMsg;
        this.apkSafeDetailUrl = fileManagerEntity.apkSafeDetailUrl;
        this.svrPathIpType = fileManagerEntity.svrPathIpType;
        this.guildId = fileManagerEntity.guildId;
        this.channelId = fileManagerEntity.channelId;
        this.guildName = fileManagerEntity.guildName;
        this.channelName = fileManagerEntity.channelName;
        this.fromScene = fileManagerEntity.fromScene;
        this.ntMsgId = fileManagerEntity.ntMsgId;
        this.peerUid = fileManagerEntity.peerUid;
        this.fwSrcNtMsgId = fileManagerEntity.fwSrcNtMsgId;
        this.fwSrcPeerUid = fileManagerEntity.fwSrcPeerUid;
        this.fwSrcPeerType = fileManagerEntity.fwSrcPeerType;
        this.fwSrcUniseq = fileManagerEntity.fwSrcUniseq;
        this.fromFile = fileManagerEntity.fromFile;
        this.entrance = fileManagerEntity.entrance;
        this.ntSubMsgID = fileManagerEntity.ntSubMsgID;
        this.ntChatType = fileManagerEntity.ntChatType;
        this.duplicateFilePath = fileManagerEntity.duplicateFilePath;
        this.duplicateEntitySessionId = fileManagerEntity.duplicateEntitySessionId;
        this.isDuplicateFile = fileManagerEntity.isDuplicateFile;
        this.isPhotoToMyComputer = fileManagerEntity.isPhotoToMyComputer;
        this.videoDownloadForceThroughNT = fileManagerEntity.videoDownloadForceThroughNT;
        this.searchPCPart = fileManagerEntity.searchPCPart;
        this.fileSetId = fileManagerEntity.fileSetId;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FileManagerEntity) || ((FileManagerEntity) obj).nSessionId != this.nSessionId) {
            return false;
        }
        return true;
    }

    public int getCloudType() {
        return this.cloudType;
    }

    public String getFilePath() {
        return this.strFilePath;
    }

    @Override // com.tencent.mobileqq.persistence.Entity
    public String getTableName() {
        return "mr_fileManager";
    }

    public boolean isFromProcessingBuddyForward2DatalineItem() {
        int i3;
        if (this.nOpType == 29 && ((i3 = this.status) == 2 || i3 == 0)) {
            return true;
        }
        return false;
    }

    public boolean isFromProcessingForward2DatalineItem() {
        int i3;
        if (this.nOpType == 31 && ((i3 = this.status) == 2 || i3 == 0)) {
            return true;
        }
        return false;
    }

    public boolean isFromProcessingForward2c2cOrDiscItem() {
        int i3;
        int i16 = this.nOpType;
        if ((i16 != 24 && i16 != 25) || ((i3 = this.status) != 2 && i3 != 0)) {
            return false;
        }
        return true;
    }

    public boolean isSend() {
        int i3 = this.nOpType;
        if (i3 != 0 && i3 != 3 && i3 != 4 && i3 != 6 && i3 != 7 && i3 != 20 && i3 != 21 && i3 != 22 && i3 != 24 && i3 != 25 && i3 != 26 && i3 != 27 && i3 != 28 && i3 != 29 && i3 != 31 && i3 != 51 && i3 != 32 && i3 != 52) {
            return false;
        }
        return true;
    }

    public boolean sendCloudUnsuccessful() {
        int i3 = this.status;
        if (i3 == 16) {
            return true;
        }
        if (i3 != 1 && isSend() && this.status != -1) {
            return true;
        }
        return false;
    }

    public void setCloudType(int i3) {
        this.cloudType = i3;
        if (i3 == 3 && TextUtils.isEmpty(this.strFilePath) && this.bSetVerify) {
            QLog.w("FileManagerEntity<FileAssistant>", 1, "local file set entity filepath is null!");
            this.bSetVerify = false;
        }
        this.bSetVerify = false;
    }

    public void setFilePath(String str) {
        this.strFilePath = str;
        if (TextUtils.isEmpty(str) && this.bSetVerify) {
            QLog.w("FileManagerEntity<FileAssistant>", 1, "set entity strFilePath is null!");
            this.bSetVerify = false;
        }
        if (TextUtils.isEmpty(this.strFilePath) && !this.bSetVerify) {
            this.bSetVerify = true;
        }
    }

    public String toString() {
        return "FileManagerEntity{nSessionId=" + this.nSessionId + ", uniseq=" + this.uniseq + ", ntChatType=" + this.ntChatType + ", peerType=" + this.peerType + ", peerUin='" + this.peerUin + "', selfUin='" + this.selfUin + "', peerNick='" + this.peerNick + "', fileName='" + this.fileName + "', srvTime=" + this.srvTime + ", nOpType=" + this.nOpType + ", cloudType=" + this.cloudType + ", fileSize=" + this.fileSize + ", status=" + this.status + ", strFilePath='" + this.strFilePath + "', strServerPath='" + this.strServerPath + "', nFileType=" + this.nFileType + ", fProgress=" + this.fProgress + ", isReaded=" + this.isReaded + ", Uuid='" + this.Uuid + "', fileIdCrc='" + this.fileIdCrc + "', bUseMediaPlatform=" + this.bUseMediaPlatform + ", WeiYunFileId='" + this.WeiYunFileId + "', nWeiYunSrcType=" + this.nWeiYunSrcType + ", lastTime=" + this.lastTime + ", bDelInAio=" + this.bDelInAio + ", bDelInFM=" + this.bDelInFM + ", strThumbPath='" + this.strThumbPath + "', bSend=" + this.bSend + ", bombData=" + Arrays.toString(this.bombData) + ", nOlSenderProgress=" + this.nOlSenderProgress + ", fOlRecvSpeed=" + this.fOlRecvSpeed + ", fOlRecvProgressOnNotify=" + this.fOlRecvProgressOnNotify + ", dbVer=" + this.dbVer + ", strSrcName='" + this.strSrcName + "', msgSeq=" + this.msgSeq + ", msgUid=" + this.msgUid + ", msgTime=" + this.msgTime + ", nOLfileSessionId=" + this.nOLfileSessionId + ", nRelatedSessionId=" + this.nRelatedSessionId + ", strTroopFileID='" + this.strTroopFileID + "', strTroopFilePath='" + this.strTroopFilePath + "', strTroopFileSha1='" + this.strTroopFileSha1 + "', strTroopFileUuid='" + this.strTroopFileUuid + "', mTroopFileVideoReqInterval=" + this.mTroopFileVideoReqInterval + ", busId=" + this.busId + ", TroopUin=" + this.TroopUin + ", structMsgSeq=" + this.structMsgSeq + ", forwardTroopFileEntrance=" + this.forwardTroopFileEntrance + ", strFileMd5='" + this.strFileMd5 + "', errCode=" + this.errCode + ", strFileSHA='" + this.strFileSHA + "', tmpSessionType=" + this.tmpSessionType + ", tmpSessionRelatedUin='" + this.tmpSessionRelatedUin + "', tmpSessionFromPhone='" + this.tmpSessionFromPhone + "', tmpSessionToPhone='" + this.tmpSessionToPhone + "', strApkPackageName='" + this.strApkPackageName + "', yybApkPackageName='" + this.yybApkPackageName + "', yybApkName='" + this.yybApkName + "', yybApkIconUrl='" + this.yybApkIconUrl + "', strFavFileId='" + this.strFavFileId + "', strFavId='" + this.strFavId + "', thumbInvalidCode=" + this.thumbInvalidCode + ", transSpeed=" + this.transSpeed + ", qlmsgSrc=" + this.qlmsgSrc + ", relatedEntity=" + this.relatedEntity + ", tmpSessionSig=" + Arrays.toString(this.tmpSessionSig) + ", strDataLineMPFileID='" + this.strDataLineMPFileID + "', peerDin=" + this.peerDin + ", mContext=" + this.mContext + ", bSetVerify=" + this.bSetVerify + ", datalineEntitySessionId=" + this.datalineEntitySessionId + ", isFromrMolo=" + this.isFromrMolo + ", imgWidth=" + this.imgWidth + ", imgHeight=" + this.imgHeight + ", isZipInnerFile=" + this.isZipInnerFile + ", zipFilePath='" + this.zipFilePath + "', zipType=" + this.zipType + ", zipInnerPath='" + this.zipInnerPath + "', strLargeThumPath='" + this.strLargeThumPath + "', strMiddleThumPath='" + this.strMiddleThumPath + "', bCannotPlay=" + this.bCannotPlay + ", WeiYunDirKey='" + this.WeiYunDirKey + "', bOnceSuccess=" + this.bOnceSuccess + ", lastSuccessTime=" + this.lastSuccessTime + ", zipFileId='" + this.zipFileId + "', mThumbRetryCount=" + this.mThumbRetryCount + ", httpsDomain='" + this.httpsDomain + "', localModifyTime=" + this.localModifyTime + ", strFileSha3='" + this.strFileSha3 + "', str10Md5='" + this.str10Md5 + "', strQRUrl='" + this.strQRUrl + "', miniAppDownloadId='" + this.miniAppDownloadId + "', mExcitingSpeed='" + this.mExcitingSpeed + "', isCheckPrivateDir=" + this.isCheckPrivateDir + ", apkSafeLevel=" + this.apkSafeLevel + ", apkSafeMsg='" + this.apkSafeMsg + "', apkSafeDetailUrl='" + this.apkSafeDetailUrl + "', svrPathIpType=" + this.svrPathIpType + ", isStartWlan=" + this.isStartWlan + ", dlGroupCount=" + this.dlGroupCount + ", dlGourpIndex=" + this.dlGourpIndex + ", dlGroupId=" + this.dlGroupId + ", nfcTokenKey=" + Arrays.toString(this.nfcTokenKey) + ", nfcUrlNotify=" + Arrays.toString(this.nfcUrlNotify) + ", nfcServerIP=" + this.nfcServerIP + ", nfcServerPort=" + ((int) this.nfcServerPort) + ", originMsgTime=" + this.originMsgTime + ", originShmsgseq=" + this.originShmsgseq + ", guildId='" + this.guildId + "', channelId='" + this.channelId + "', guildName='" + this.guildName + "', channelName='" + this.channelName + "', fromScene=" + this.fromScene + ", ntMsgId=" + this.ntMsgId + ", peerUid='" + this.peerUid + "', fwSrcNtMsgId=" + this.fwSrcNtMsgId + ", fwSrcPeerUid='" + this.fwSrcPeerUid + "', fwSrcPeerType=" + this.fwSrcPeerType + ", fwSrcUniseq=" + this.fwSrcUniseq + ", ntSubMsgID=" + this.ntSubMsgID + ", ntChatType=" + this.ntChatType + ", duplicateFilePath=" + this.duplicateFilePath + ", duplicateEntitySessionId=" + this.duplicateEntitySessionId + ", isDuplicateFile=" + this.isDuplicateFile + ", fromFile=" + this.fromFile + ", isPhotoToMyComputer=" + this.isPhotoToMyComputer + ", videoDownloadForceThroughNT=" + this.videoDownloadForceThroughNT + ", searchPCPart=" + this.searchPCPart + ", fileSetId=" + this.fileSetId + '}';
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public FileManagerEntity m177clone() {
        try {
            return (FileManagerEntity) super.clone();
        } catch (CloneNotSupportedException e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
