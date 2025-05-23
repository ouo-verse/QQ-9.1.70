package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import localpb.dataline.DatalineMsgData$MsgData;

/* compiled from: P */
@KeepClassConstructor
@uniqueConstraints(clause = ConflictClause.IGNORE, columnNames = "time,msgid")
/* loaded from: classes10.dex */
public class DataLineMsgRecord extends MessageRecord implements Cloneable {
    public static final int APP_STATUS_INSTALLED = 1;
    public static final int APP_STATUS_NONE = 0;
    public static final int DATALINE_MSG_VERSION_CODE = 104;
    public static final int FILE_MSG_STATUS_COMING = 1;
    public static final int FILE_MSG_STATUS_INVALID = 3;
    public static final int FILE_MSG_STATUS_NONE = 0;
    public static final int FILE_MSG_STATUS_PAUSED = 2;
    public static final int IPAD_DEV_TYPE = 1;
    public static final int MSG_TYPE_DATALINE_APP = -2335;
    public static final int MSG_TYPE_DATALINE_FILE = -2005;
    public static final int MSG_TYPE_DATALINE_GRAY = -5000;
    public static final int MSG_TYPE_DATALINE_MSG_VIDEO = -2009;
    public static final int MSG_TYPE_DATALINE_PIC = -2000;
    public static final int MSG_TYPE_DATALINE_PROMPT = -2334;
    public static final int MSG_TYPE_DATALINE_TEXT = -1000;
    public static final int MSG_TYPE_DATALINE_VIDEO = -2009;
    public static final int PAD_DEV_TYPE = 3;
    public static final int PC_DEV_TYPE = 0;
    public static final int PHONE_DEV_TYPE = 2;
    public static final int SESSION_STATE_DONE = 1;
    public static final int SESSION_STATE_INIT = 0;
    public static final int SESSION_STATE_REVING = 2;

    @notColumn
    public boolean bIsApkFile;

    @notColumn
    public boolean bIsMoloImage;

    @notColumn
    public boolean bIsResendOrRecvFile;

    @notColumn
    public boolean bIsSended;

    @notColumn
    public boolean bIsTransfering;

    @notColumn
    public boolean bNoInsertFm;
    public int busId;

    @notColumn
    public int dataline_type;

    @notColumn
    public long entityID;

    @notColumn
    public int fileFrom;

    @notColumn
    public long fileMsgStatus;

    @notColumn
    public String fileUuid;
    public String filename;
    public long filesize;
    public int forwardTroopFileEntrance;
    public int groupId;
    public int groupIndex;
    public int groupSize;

    @notColumn
    public boolean isReportPause;
    public boolean issuc;
    public byte[] md5;

    @notColumn
    public int nAppStatus;

    @notColumn
    public int nOpType;

    @notColumn
    public long nServerIp;

    @notColumn
    public long nServerPort;

    @notColumn
    public int nSessionState;

    @notColumn
    public long nWeiyunSessionId;

    @notColumn
    public int nWeiyunSrcType;
    public String path;
    public float progress;
    public String serverPath;
    public long sessionid;

    @notColumn
    public String strMoloIconUrl;

    @notColumn
    public String strMoloKey;

    @notColumn
    public String strMoloSource;

    @notColumn
    public String strMoloSrcIconUrl;

    @notColumn
    public String strWeiyunDir;

    @notColumn
    public String strWeiyunId;

    @notColumn
    public String strWeiyunMd5;

    @notColumn
    public String strWeiyunSha;
    public String thumbPath;

    @notColumn
    public long uOwnerUin;

    @notColumn
    public byte[] vTokenKey;

    @notColumn
    public byte[] vUrlNotify;

    public DataLineMsgRecord() {
        this(0);
    }

    public static int getDevTypeBySeId(long j3) {
        if (isPadDevice()) {
            if (0 != (j3 & LockFreeTaskQueueCore.CLOSED_MASK)) {
                return 2;
            }
            return 0;
        }
        if (0 != (j3 & 1152921504606846976L)) {
            return 1;
        }
        return 0;
    }

    public static int getDevTypeBySet(DataLineMsgSet dataLineMsgSet) {
        long j3;
        if (dataLineMsgSet != null) {
            Iterator<DataLineMsgRecord> it = dataLineMsgSet.values().iterator();
            if (it.hasNext()) {
                j3 = it.next().sessionid;
                return getDevTypeBySeId(j3);
            }
        }
        j3 = 0;
        return getDevTypeBySeId(j3);
    }

    public static String getSqlStatment(String str, int i3) {
        String tableName = tableName();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("select * from " + tableName);
        sb5.append(" order by _id desc limit 60");
        String sb6 = sb5.toString();
        sb5.delete(0, sb5.length());
        sb5.append("select * from (" + sb6 + ") order by _id asc");
        return sb5.toString();
    }

    public static boolean isPadDevice() {
        if (PadUtil.a(BaseApplicationImpl.getApplication().getBaseContext()) == DeviceType.TABLET) {
            return true;
        }
        return false;
    }

    public static byte[] longToByte(long j3) {
        return new byte[]{(byte) j3, (byte) (j3 >> 8), (byte) (j3 >> 16), (byte) (j3 >> 24), (byte) (j3 >> 32), (byte) (j3 >> 40), (byte) (j3 >> 48), (byte) (j3 >> 56)};
    }

    public static byte[] packMsgData(DataLineMsgRecord dataLineMsgRecord, int i3) {
        int i16;
        String str = dataLineMsgRecord.f203106msg;
        if (str != null) {
            int i17 = 0;
            try {
                if (i3 == 106) {
                    DatalineMsgData$MsgData datalineMsgData$MsgData = new DatalineMsgData$MsgData();
                    datalineMsgData$MsgData.str_msg.set(dataLineMsgRecord.f203106msg);
                    datalineMsgData$MsgData.uint64_filemsgstatus.set(dataLineMsgRecord.fileMsgStatus);
                    datalineMsgData$MsgData.uint64_weiyunsessionid.set(dataLineMsgRecord.nWeiyunSessionId);
                    String str2 = dataLineMsgRecord.strMoloKey;
                    if (str2 != null) {
                        datalineMsgData$MsgData.str_molokey.set(str2);
                    }
                    String str3 = dataLineMsgRecord.strMoloIconUrl;
                    if (str3 != null) {
                        datalineMsgData$MsgData.str_moloiconurl.set(str3);
                    }
                    String str4 = dataLineMsgRecord.strMoloSource;
                    if (str4 != null) {
                        datalineMsgData$MsgData.str_molosource.set(str4);
                    }
                    String str5 = dataLineMsgRecord.strMoloSrcIconUrl;
                    if (str5 != null) {
                        datalineMsgData$MsgData.str_molosrcurl.set(str5);
                    }
                    datalineMsgData$MsgData.fixed32_ip.set((int) dataLineMsgRecord.nServerIp);
                    datalineMsgData$MsgData.uint32_port.set((int) dataLineMsgRecord.nServerPort);
                    byte[] bArr = dataLineMsgRecord.vUrlNotify;
                    if (bArr != null) {
                        datalineMsgData$MsgData.bytes_url_notify.set(ByteStringMicro.copyFrom(bArr));
                    }
                    byte[] bArr2 = dataLineMsgRecord.vTokenKey;
                    if (bArr2 != null) {
                        datalineMsgData$MsgData.bytes_tokenkey.set(ByteStringMicro.copyFrom(bArr2));
                    }
                    PBUInt32Field pBUInt32Field = datalineMsgData$MsgData.uint32_isapkfile;
                    if (dataLineMsgRecord.bIsApkFile) {
                        i16 = 1;
                    } else {
                        i16 = 0;
                    }
                    pBUInt32Field.set(i16);
                    PBUInt32Field pBUInt32Field2 = datalineMsgData$MsgData.uint32_ismoloimage;
                    if (dataLineMsgRecord.bIsMoloImage) {
                        i17 = 1;
                    }
                    pBUInt32Field2.set(i17);
                    datalineMsgData$MsgData.uint32_fileFrom.set(dataLineMsgRecord.fileFrom);
                    String str6 = dataLineMsgRecord.fileUuid;
                    if (str6 != null) {
                        datalineMsgData$MsgData.str_fileUuid.set(str6);
                    }
                    datalineMsgData$MsgData.uint32_nOpType.set(dataLineMsgRecord.nOpType);
                    datalineMsgData$MsgData.uint64_entityID.set(dataLineMsgRecord.entityID);
                    datalineMsgData$MsgData.uint64_OwnerUin.set(dataLineMsgRecord.uOwnerUin);
                    datalineMsgData$MsgData.uint32_busId.set(dataLineMsgRecord.busId);
                    datalineMsgData$MsgData.uint32_forwardTroopFileEntranc.set(dataLineMsgRecord.forwardTroopFileEntrance);
                    datalineMsgData$MsgData.bool_sended.set(dataLineMsgRecord.bIsSended);
                    if (!TextUtils.isEmpty(dataLineMsgRecord.strWeiyunId)) {
                        datalineMsgData$MsgData.str_weiyunid.set(dataLineMsgRecord.strWeiyunId);
                    }
                    if (!TextUtils.isEmpty(dataLineMsgRecord.strWeiyunDir)) {
                        datalineMsgData$MsgData.str_weiyundirkey.set(dataLineMsgRecord.strWeiyunDir);
                    }
                    datalineMsgData$MsgData.uint32_weiyunsrctype.set(dataLineMsgRecord.nWeiyunSrcType);
                    if (!TextUtils.isEmpty(dataLineMsgRecord.strWeiyunMd5)) {
                        datalineMsgData$MsgData.str_weiyunmd5.set(dataLineMsgRecord.strWeiyunMd5);
                    }
                    if (!TextUtils.isEmpty(dataLineMsgRecord.strWeiyunSha)) {
                        datalineMsgData$MsgData.str_weiyunsha.set(dataLineMsgRecord.strWeiyunSha);
                    }
                    return datalineMsgData$MsgData.toByteArray();
                }
                if (i3 == 105) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byteArrayOutputStream.write(longToByte(dataLineMsgRecord.fileMsgStatus));
                        byteArrayOutputStream.write(longToByte(dataLineMsgRecord.nWeiyunSessionId));
                        byteArrayOutputStream.write(dataLineMsgRecord.f203106msg.getBytes("UTF-8"));
                        dataLineMsgRecord.msgData = (byte[]) byteArrayOutputStream.toByteArray().clone();
                        byteArrayOutputStream.close();
                        return null;
                    } catch (IOException unused) {
                        return null;
                    }
                }
                if (i3 == 104) {
                    byte[] longToByte = longToByte(dataLineMsgRecord.fileMsgStatus);
                    byte[] bytes = dataLineMsgRecord.f203106msg.getBytes("UTF-8");
                    byte[] bArr3 = new byte[bytes.length + 8];
                    dataLineMsgRecord.msgData = bArr3;
                    System.arraycopy(longToByte, 0, bArr3, 0, longToByte.length);
                    System.arraycopy(bytes, 0, dataLineMsgRecord.msgData, longToByte.length, bytes.length);
                    return null;
                }
                if (i3 > 0) {
                    dataLineMsgRecord.msgData = str.getBytes("UTF-8");
                    return null;
                }
                return null;
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static String tableName() {
        return "mr_data_line";
    }

    public static void unpackMsgData(DataLineMsgRecord dataLineMsgRecord, byte[] bArr, int i3) {
        String str;
        long j3;
        long j16;
        String str2;
        String str3;
        String str4;
        String str5;
        boolean z16;
        long j17;
        long j18;
        byte[] bArr2;
        byte[] bArr3;
        int i16;
        String str6;
        int i17;
        long j19;
        int i18;
        int i19;
        boolean z17;
        String str7;
        String str8;
        String str9;
        long j26 = 0;
        int i26 = 0;
        try {
            if (i3 == 106) {
                DatalineMsgData$MsgData datalineMsgData$MsgData = new DatalineMsgData$MsgData();
                try {
                    datalineMsgData$MsgData.mergeFrom(bArr);
                    if (datalineMsgData$MsgData.str_msg.has()) {
                        str = datalineMsgData$MsgData.str_msg.get();
                    } else {
                        str = "";
                    }
                    dataLineMsgRecord.f203106msg = str;
                    if (datalineMsgData$MsgData.uint64_filemsgstatus.has()) {
                        j3 = datalineMsgData$MsgData.uint64_filemsgstatus.get();
                    } else {
                        j3 = 0;
                    }
                    dataLineMsgRecord.fileMsgStatus = j3;
                    if (datalineMsgData$MsgData.uint64_weiyunsessionid.has()) {
                        j16 = datalineMsgData$MsgData.uint64_weiyunsessionid.get();
                    } else {
                        j16 = 0;
                    }
                    dataLineMsgRecord.nWeiyunSessionId = j16;
                    String str10 = null;
                    if (datalineMsgData$MsgData.str_molokey.has()) {
                        str2 = datalineMsgData$MsgData.str_molokey.get();
                    } else {
                        str2 = null;
                    }
                    dataLineMsgRecord.strMoloKey = str2;
                    if (datalineMsgData$MsgData.str_moloiconurl.has()) {
                        str3 = datalineMsgData$MsgData.str_moloiconurl.get();
                    } else {
                        str3 = null;
                    }
                    dataLineMsgRecord.strMoloIconUrl = str3;
                    if (datalineMsgData$MsgData.str_molosource.has()) {
                        str4 = datalineMsgData$MsgData.str_molosource.get();
                    } else {
                        str4 = null;
                    }
                    dataLineMsgRecord.strMoloSource = str4;
                    if (datalineMsgData$MsgData.str_molosrcurl.has()) {
                        str5 = datalineMsgData$MsgData.str_molosrcurl.get();
                    } else {
                        str5 = null;
                    }
                    dataLineMsgRecord.strMoloSrcIconUrl = str5;
                    boolean z18 = true;
                    if (datalineMsgData$MsgData.uint32_isapkfile.has() && datalineMsgData$MsgData.uint32_isapkfile.get() == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    dataLineMsgRecord.bIsApkFile = z16;
                    if (datalineMsgData$MsgData.fixed32_ip.has()) {
                        j17 = datalineMsgData$MsgData.fixed32_ip.get();
                    } else {
                        j17 = 0;
                    }
                    dataLineMsgRecord.nServerIp = j17;
                    if (datalineMsgData$MsgData.uint32_port.has()) {
                        j18 = datalineMsgData$MsgData.uint32_port.get();
                    } else {
                        j18 = 0;
                    }
                    dataLineMsgRecord.nServerPort = j18;
                    if (datalineMsgData$MsgData.bytes_url_notify.has()) {
                        bArr2 = datalineMsgData$MsgData.bytes_url_notify.get().toByteArray();
                    } else {
                        bArr2 = null;
                    }
                    dataLineMsgRecord.vUrlNotify = bArr2;
                    if (datalineMsgData$MsgData.bytes_tokenkey.has()) {
                        bArr3 = datalineMsgData$MsgData.bytes_tokenkey.get().toByteArray();
                    } else {
                        bArr3 = null;
                    }
                    dataLineMsgRecord.vTokenKey = bArr3;
                    if (!datalineMsgData$MsgData.uint32_ismoloimage.has() || datalineMsgData$MsgData.uint32_ismoloimage.get() != 1) {
                        z18 = false;
                    }
                    dataLineMsgRecord.bIsMoloImage = z18;
                    if (datalineMsgData$MsgData.uint32_fileFrom.has()) {
                        i16 = datalineMsgData$MsgData.uint32_fileFrom.get();
                    } else {
                        i16 = 0;
                    }
                    dataLineMsgRecord.fileFrom = i16;
                    if (datalineMsgData$MsgData.str_fileUuid.has()) {
                        str6 = datalineMsgData$MsgData.str_fileUuid.get();
                    } else {
                        str6 = null;
                    }
                    dataLineMsgRecord.fileUuid = str6;
                    if (datalineMsgData$MsgData.uint32_nOpType.has()) {
                        i17 = datalineMsgData$MsgData.uint32_nOpType.get();
                    } else {
                        i17 = -1;
                    }
                    dataLineMsgRecord.nOpType = i17;
                    if (datalineMsgData$MsgData.uint64_entityID.has()) {
                        j19 = datalineMsgData$MsgData.uint64_entityID.get();
                    } else {
                        j19 = 0;
                    }
                    dataLineMsgRecord.entityID = j19;
                    if (datalineMsgData$MsgData.uint64_OwnerUin.has()) {
                        j26 = datalineMsgData$MsgData.uint64_OwnerUin.get();
                    }
                    dataLineMsgRecord.uOwnerUin = j26;
                    if (datalineMsgData$MsgData.uint32_busId.has()) {
                        i18 = datalineMsgData$MsgData.uint32_busId.get();
                    } else {
                        i18 = 0;
                    }
                    dataLineMsgRecord.busId = i18;
                    if (datalineMsgData$MsgData.uint32_forwardTroopFileEntranc.has()) {
                        i19 = datalineMsgData$MsgData.uint32_forwardTroopFileEntranc.get();
                    } else {
                        i19 = 0;
                    }
                    dataLineMsgRecord.forwardTroopFileEntrance = i19;
                    if (datalineMsgData$MsgData.bool_sended.has()) {
                        z17 = datalineMsgData$MsgData.bool_sended.get();
                    } else {
                        z17 = false;
                    }
                    dataLineMsgRecord.bIsSended = z17;
                    if (datalineMsgData$MsgData.str_weiyunid.has()) {
                        str7 = datalineMsgData$MsgData.str_weiyunid.get();
                    } else {
                        str7 = null;
                    }
                    dataLineMsgRecord.strWeiyunId = str7;
                    if (datalineMsgData$MsgData.str_weiyundirkey.has()) {
                        str8 = datalineMsgData$MsgData.str_weiyundirkey.get();
                    } else {
                        str8 = null;
                    }
                    dataLineMsgRecord.strWeiyunDir = str8;
                    if (datalineMsgData$MsgData.uint32_weiyunsrctype.has()) {
                        i26 = datalineMsgData$MsgData.uint32_weiyunsrctype.get();
                    }
                    dataLineMsgRecord.nWeiyunSrcType = i26;
                    if (datalineMsgData$MsgData.str_weiyunmd5.has()) {
                        str9 = datalineMsgData$MsgData.str_weiyunmd5.get();
                    } else {
                        str9 = null;
                    }
                    dataLineMsgRecord.strWeiyunMd5 = str9;
                    if (datalineMsgData$MsgData.str_weiyunsha.has()) {
                        str10 = datalineMsgData$MsgData.str_weiyunsha.get();
                    }
                    dataLineMsgRecord.strWeiyunSha = str10;
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                    return;
                }
            }
            if (i3 == 105) {
                byte[] bArr4 = new byte[8];
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    byteArrayInputStream.read(bArr4);
                    dataLineMsgRecord.fileMsgStatus = Utils.b(bArr4);
                    byteArrayInputStream.read(bArr4);
                    dataLineMsgRecord.nWeiyunSessionId = Utils.b(bArr4);
                    byte[] bArr5 = new byte[bArr.length - 16];
                    byteArrayInputStream.read(bArr5);
                    dataLineMsgRecord.f203106msg = new String(bArr5, "UTF-8");
                    byteArrayInputStream.close();
                    return;
                } catch (IOException unused) {
                    return;
                }
            }
            if (i3 == 104) {
                byte[] bArr6 = new byte[8];
                int length = bArr.length - 8;
                byte[] bArr7 = new byte[length];
                System.arraycopy(bArr, 0, bArr6, 0, 8);
                System.arraycopy(bArr, 8, bArr7, 0, length);
                dataLineMsgRecord.fileMsgStatus = Utils.b(bArr6);
                dataLineMsgRecord.f203106msg = new String(bArr7, "UTF-8");
                return;
            }
            if (i3 > 0) {
                dataLineMsgRecord.f203106msg = new String(bArr, "UTF-8");
                dataLineMsgRecord.fileMsgStatus = 0L;
            }
        } catch (UnsupportedEncodingException e17) {
            e17.printStackTrace();
        }
    }

    public boolean canForward() {
        if (FileUtils.fileExistsAndNotEmpty(this.path) && this.strMoloKey == null) {
            return true;
        }
        return false;
    }

    public void doPrewrite() {
        prewrite();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public Class<? extends Entity> getClassForTable() {
        return DataLineMsgRecord.class;
    }

    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public String getTableName() {
        if (isPadDevice()) {
            if (this.dataline_type == 2 || (this.sessionid & LockFreeTaskQueueCore.CLOSED_MASK) != 0) {
                return "mr_data_line_phone";
            }
            return "mr_data_line";
        }
        if (this.dataline_type != 1 && (this.sessionid & 1152921504606846976L) == 0) {
            return "mr_data_line";
        }
        return "mr_data_line_ipad";
    }

    public boolean isForward() {
        int i3 = this.nOpType;
        if (i3 != 31 && i3 != 29) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        unpackMsgData(this, this.msgData, this.versionCode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        this.msgData = packMsgData(this, this.versionCode);
    }

    public FileManagerEntity trans2Entity() {
        FileManagerEntity fileManagerEntity;
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (this.entityID != 0) {
            fileManagerEntity = qQAppInterface.getFileManagerDataCenter().D(this.entityID);
        } else {
            fileManagerEntity = null;
        }
        if (fileManagerEntity == null) {
            fileManagerEntity = new FileManagerEntity();
            long longValue = FileManagerUtil.genSessionId().longValue();
            fileManagerEntity.nSessionId = longValue;
            this.entityID = longValue;
            int i3 = this.nOpType;
            if (i3 != 29) {
                if (i3 == 31) {
                    fileManagerEntity.TroopUin = this.uOwnerUin;
                    fileManagerEntity.strTroopFilePath = this.fileUuid;
                    fileManagerEntity.setCloudType(4);
                }
            } else {
                fileManagerEntity.selfUin = String.valueOf(this.uOwnerUin);
                fileManagerEntity.Uuid = this.fileUuid;
                fileManagerEntity.setCloudType(1);
            }
            fileManagerEntity.peerUin = this.selfuin;
            fileManagerEntity.peerType = this.istroop;
            fileManagerEntity.fileName = this.filename;
            fileManagerEntity.fileSize = this.filesize;
            fileManagerEntity.busId = this.busId;
            fileManagerEntity.forwardTroopFileEntrance = this.forwardTroopFileEntrance;
            fileManagerEntity.nOpType = this.nOpType;
            fileManagerEntity.status = 0;
            long j3 = this.sessionid;
            fileManagerEntity.uniseq = j3;
            fileManagerEntity.datalineEntitySessionId = j3;
            qQAppInterface.getFileManagerDataCenter().v(fileManagerEntity);
        }
        return fileManagerEntity;
    }

    public DataLineMsgRecord(int i3) {
        String valueOf = String.valueOf(AppConstants.DATALINE_PC_UIN);
        this.selfuin = valueOf;
        this.frienduin = valueOf;
        this.senderuin = valueOf;
        this.istroop = 6000;
        this.nWeiyunSessionId = 0L;
        this.versionCode = 106;
        this.bIsResendOrRecvFile = false;
        this.isReportPause = false;
        this.dataline_type = i3;
        this.fileFrom = 0;
        this.nOpType = -1;
        this.bIsSended = false;
        this.bNoInsertFm = false;
        this.nWeiyunSrcType = 0;
        this.nSessionState = 0;
    }

    public static String tableName(int i3) {
        return isPadDevice() ? i3 == 2 ? "mr_data_line_phone" : "mr_data_line" : i3 == 1 ? "mr_data_line_ipad" : "mr_data_line";
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public DataLineMsgRecord m168clone() {
        try {
            return (DataLineMsgRecord) super.clone();
        } catch (CloneNotSupportedException e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
