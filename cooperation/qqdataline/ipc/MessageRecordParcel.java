package cooperation.qqdataline.ipc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.dataline.mpfile.MpfileTaskRecord;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageRecord;

/* loaded from: classes28.dex */
public class MessageRecordParcel implements Parcelable {
    public static final Parcelable.Creator<MessageRecordParcel> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    private MessageRecord f390545d;

    /* loaded from: classes28.dex */
    class a implements Parcelable.Creator<MessageRecordParcel> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MessageRecordParcel createFromParcel(Parcel parcel) {
            return MessageRecordParcel.c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MessageRecordParcel[] newArray(int i3) {
            return new MessageRecordParcel[i3];
        }
    }

    public MessageRecordParcel(MessageRecord messageRecord) {
        this.f390545d = messageRecord;
    }

    private static void b(Bundle bundle, DataLineMsgRecord dataLineMsgRecord) {
        dataLineMsgRecord.issuc = bundle.getBoolean("DataLineMsgRecord.issuc");
        dataLineMsgRecord.progress = bundle.getFloat("DataLineMsgRecord.progress");
        dataLineMsgRecord.path = bundle.getString("DataLineMsgRecord.path");
        dataLineMsgRecord.thumbPath = bundle.getString("DataLineMsgRecord.thumbPath");
        dataLineMsgRecord.filename = bundle.getString("DataLineMsgRecord.filename");
        dataLineMsgRecord.filesize = bundle.getLong("DataLineMsgRecord.filesize");
        dataLineMsgRecord.serverPath = bundle.getString("DataLineMsgRecord.serverPath");
        dataLineMsgRecord.md5 = bundle.getByteArray("DataLineMsgRecord.md5");
        dataLineMsgRecord.sessionid = bundle.getLong("DataLineMsgRecord.sessionid");
        dataLineMsgRecord.groupId = bundle.getInt("DataLineMsgRecord.groupId");
        dataLineMsgRecord.groupSize = bundle.getInt("DataLineMsgRecord.groupSize");
        dataLineMsgRecord.groupIndex = bundle.getInt("DataLineMsgRecord.groupIndex");
        dataLineMsgRecord.isReportPause = bundle.getBoolean("DataLineMsgRecord.isReportPause");
        dataLineMsgRecord.nServerIp = bundle.getLong("DataLineMsgRecord.nServerIp");
        dataLineMsgRecord.nServerPort = bundle.getLong("DataLineMsgRecord.nServerPort");
        dataLineMsgRecord.vUrlNotify = bundle.getByteArray("DataLineMsgRecord.vUrlNotify");
        dataLineMsgRecord.vTokenKey = bundle.getByteArray("DataLineMsgRecord.vTokenKey");
        dataLineMsgRecord.bIsResendOrRecvFile = bundle.getBoolean("DataLineMsgRecord.bIsResendOrRecvFile");
        dataLineMsgRecord.fileMsgStatus = bundle.getLong("DataLineMsgRecord.fileMsgStatus");
        dataLineMsgRecord.nWeiyunSessionId = bundle.getLong("DataLineMsgRecord.nWeiyunSessionId");
        dataLineMsgRecord.strMoloKey = bundle.getString("DataLineMsgRecord.strMoloKey");
        dataLineMsgRecord.strMoloIconUrl = bundle.getString("DataLineMsgRecord.strMoloIconUrl");
        dataLineMsgRecord.strMoloSource = bundle.getString("DataLineMsgRecord.strMoloSource");
        dataLineMsgRecord.strMoloSrcIconUrl = bundle.getString("DataLineMsgRecord.strMoloSrcIconUrl");
        dataLineMsgRecord.nAppStatus = bundle.getInt("DataLineMsgRecord.nAppStatus");
        dataLineMsgRecord.bIsApkFile = bundle.getBoolean("DataLineMsgRecord.bIsApkFile");
        dataLineMsgRecord.bIsMoloImage = bundle.getBoolean("DataLineMsgRecord.bIsMoloImage");
        dataLineMsgRecord.entityID = bundle.getLong("DataLineMsgRecord.entityID");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static MessageRecordParcel c(Parcel parcel) {
        MpfileTaskRecord mpfileTaskRecord;
        String readString = parcel.readString();
        if (readString.equals("DataLineMsgRecord")) {
            DataLineMsgRecord dataLineMsgRecord = new DataLineMsgRecord();
            Bundle readBundle = parcel.readBundle();
            e(readBundle, dataLineMsgRecord);
            b(readBundle, dataLineMsgRecord);
            mpfileTaskRecord = dataLineMsgRecord;
        } else if (readString.equals("MpfileTaskRecord")) {
            MpfileTaskRecord mpfileTaskRecord2 = new MpfileTaskRecord();
            Bundle readBundle2 = parcel.readBundle();
            e(readBundle2, mpfileTaskRecord2);
            f(readBundle2, mpfileTaskRecord2);
            mpfileTaskRecord = mpfileTaskRecord2;
        } else {
            mpfileTaskRecord = null;
        }
        if (mpfileTaskRecord == null) {
            return null;
        }
        return new MessageRecordParcel(mpfileTaskRecord);
    }

    private static void e(Bundle bundle, MessageRecord messageRecord) {
        messageRecord.setId(bundle.getLong("Entity._id"));
        messageRecord.setStatus(bundle.getInt("Entity._status"));
        messageRecord.selfuin = bundle.getString("MessageRecord.selfuin");
        messageRecord.frienduin = bundle.getString("MessageRecord.frienduin");
        messageRecord.senderuin = bundle.getString("MessageRecord.senderuin");
        messageRecord.time = bundle.getLong("MessageRecord.time");
        messageRecord.f203106msg = bundle.getString("MessageRecord.msg");
        messageRecord.msgtype = bundle.getInt("MessageRecord.msgtype");
        messageRecord.isread = bundle.getBoolean("MessageRecord.isread");
        messageRecord.issend = bundle.getInt("MessageRecord.issend");
        messageRecord.msgseq = bundle.getLong("MessageRecord.msgseq");
        messageRecord.shmsgseq = bundle.getLong("MessageRecord.shmsgseq");
        messageRecord.istroop = bundle.getInt("MessageRecord.istroop");
        messageRecord.extraflag = bundle.getInt("MessageRecord.extraflag");
        messageRecord.sendFailCode = bundle.getInt("MessageRecord.sendFailCode");
        messageRecord.msgId = bundle.getLong("MessageRecord.msgId");
        messageRecord.msgData = bundle.getByteArray("MessageRecord.msgData");
        messageRecord.longMsgIndex = bundle.getInt("MessageRecord.longMsgIndex");
        messageRecord.longMsgCount = bundle.getInt("MessageRecord.longMsgCount");
        messageRecord.longMsgId = bundle.getInt("MessageRecord.longMsgId");
        messageRecord.msgUid = bundle.getLong("MessageRecord.msgUid");
        messageRecord.uniseq = bundle.getLong("MessageRecord.uniseq");
        messageRecord.extStr = bundle.getString("MessageRecord.extStr");
        messageRecord.isMultiMsg = bundle.getBoolean("MessageRecord.isMultiMsg");
        messageRecord.extInt = bundle.getInt("MessageRecord.extInt");
        messageRecord.extLong = bundle.getInt("MessageRecord.extLong");
        messageRecord.isValid = bundle.getBoolean("MessageRecord.isValid");
        messageRecord.versionCode = bundle.getInt("MessageRecord.versionCode");
        messageRecord.vipBubbleID = bundle.getLong("MessageRecord.vipBubbleID");
    }

    private static void f(Bundle bundle, MpfileTaskRecord mpfileTaskRecord) {
        mpfileTaskRecord.sessionId = bundle.getLong("MpfileTaskRecord.sessionId");
        mpfileTaskRecord.fileId = bundle.getString("MpfileTaskRecord.fileId");
        mpfileTaskRecord.fileName = bundle.getString("MpfileTaskRecord.fileName");
        mpfileTaskRecord.currentSize = bundle.getLong("MpfileTaskRecord.currentSize");
        mpfileTaskRecord.totalSize = bundle.getLong("MpfileTaskRecord.totalSize");
        mpfileTaskRecord.fileTime = bundle.getString("MpfileTaskRecord.fileTime");
        mpfileTaskRecord.filePath = bundle.getString("MpfileTaskRecord.filePath");
        mpfileTaskRecord.fileTempPath = bundle.getString("MpfileTaskRecord.fileTempPath");
        mpfileTaskRecord.din = bundle.getLong("MpfileTaskRecord.din");
    }

    private static void g(Bundle bundle, DataLineMsgRecord dataLineMsgRecord) {
        bundle.putBoolean("DataLineMsgRecord.issuc", dataLineMsgRecord.issuc);
        bundle.putFloat("DataLineMsgRecord.progress", dataLineMsgRecord.progress);
        String str = dataLineMsgRecord.path;
        if (str != null) {
            bundle.putString("DataLineMsgRecord.path", str);
        }
        String str2 = dataLineMsgRecord.thumbPath;
        if (str2 != null) {
            bundle.putString("DataLineMsgRecord.thumbPath", str2);
        }
        String str3 = dataLineMsgRecord.filename;
        if (str3 != null) {
            bundle.putString("DataLineMsgRecord.filename", str3);
        }
        bundle.putLong("DataLineMsgRecord.filesize", dataLineMsgRecord.filesize);
        String str4 = dataLineMsgRecord.serverPath;
        if (str4 != null) {
            bundle.putString("DataLineMsgRecord.serverPath", str4);
        }
        byte[] bArr = dataLineMsgRecord.md5;
        if (bArr != null) {
            bundle.putByteArray("DataLineMsgRecord.md5", bArr);
        }
        bundle.putLong("DataLineMsgRecord.sessionid", dataLineMsgRecord.sessionid);
        bundle.putInt("DataLineMsgRecord.groupId", dataLineMsgRecord.groupId);
        bundle.putInt("DataLineMsgRecord.groupSize", dataLineMsgRecord.groupSize);
        bundle.putInt("DataLineMsgRecord.groupIndex", dataLineMsgRecord.groupIndex);
        bundle.putBoolean("DataLineMsgRecord.isReportPause", dataLineMsgRecord.isReportPause);
        bundle.putLong("DataLineMsgRecord.nServerIp", dataLineMsgRecord.nServerIp);
        bundle.putLong("DataLineMsgRecord.nServerPort", dataLineMsgRecord.nServerPort);
        byte[] bArr2 = dataLineMsgRecord.vUrlNotify;
        if (bArr2 != null) {
            bundle.putByteArray("DataLineMsgRecord.vUrlNotify", bArr2);
        }
        byte[] bArr3 = dataLineMsgRecord.vTokenKey;
        if (bArr3 != null) {
            bundle.putByteArray("DataLineMsgRecord.vTokenKey", bArr3);
        }
        bundle.putBoolean("DataLineMsgRecord.bIsResendOrRecvFile", dataLineMsgRecord.bIsResendOrRecvFile);
        bundle.putLong("DataLineMsgRecord.fileMsgStatus", dataLineMsgRecord.fileMsgStatus);
        bundle.putLong("DataLineMsgRecord.nWeiyunSessionId", dataLineMsgRecord.nWeiyunSessionId);
        String str5 = dataLineMsgRecord.strMoloKey;
        if (str5 != null) {
            bundle.putString("DataLineMsgRecord.strMoloKey", str5);
        }
        String str6 = dataLineMsgRecord.strMoloIconUrl;
        if (str6 != null) {
            bundle.putString("DataLineMsgRecord.strMoloIconUrl", str6);
        }
        String str7 = dataLineMsgRecord.strMoloSource;
        if (str7 != null) {
            bundle.putString("DataLineMsgRecord.strMoloSource", str7);
        }
        String str8 = dataLineMsgRecord.strMoloSrcIconUrl;
        if (str8 != null) {
            bundle.putString("DataLineMsgRecord.strMoloSrcIconUrl", str8);
        }
        bundle.putInt("DataLineMsgRecord.nAppStatus", dataLineMsgRecord.nAppStatus);
        bundle.putBoolean("DataLineMsgRecord.bIsApkFile", dataLineMsgRecord.bIsApkFile);
        bundle.putBoolean("DataLineMsgRecord.bIsMoloImage", dataLineMsgRecord.bIsMoloImage);
        bundle.putLong("DataLineMsgRecord.entityID", dataLineMsgRecord.entityID);
    }

    private static void j(Bundle bundle, MessageRecord messageRecord) {
        bundle.putLong("Entity._id", messageRecord.getId());
        bundle.putInt("Entity._status", messageRecord.getStatus());
        String str = messageRecord.selfuin;
        if (str != null) {
            bundle.putString("MessageRecord.selfuin", str);
        }
        String str2 = messageRecord.frienduin;
        if (str2 != null) {
            bundle.putString("MessageRecord.frienduin", str2);
        }
        String str3 = messageRecord.senderuin;
        if (str3 != null) {
            bundle.putString("MessageRecord.senderuin", str3);
        }
        bundle.putLong("MessageRecord.time", messageRecord.time);
        String str4 = messageRecord.f203106msg;
        if (str4 != null) {
            bundle.putString("MessageRecord.msg", str4);
        }
        bundle.putInt("MessageRecord.msgtype", messageRecord.msgtype);
        bundle.putBoolean("MessageRecord.isread", messageRecord.isread);
        bundle.putInt("MessageRecord.issend", messageRecord.issend);
        bundle.putLong("MessageRecord.msgseq", messageRecord.msgseq);
        bundle.putLong("MessageRecord.shmsgseq", messageRecord.shmsgseq);
        bundle.putInt("MessageRecord.istroop", messageRecord.istroop);
        bundle.putInt("MessageRecord.extraflag", messageRecord.extraflag);
        bundle.putInt("MessageRecord.sendFailCode", messageRecord.sendFailCode);
        bundle.putLong("MessageRecord.msgId", messageRecord.msgId);
        byte[] bArr = messageRecord.msgData;
        if (bArr != null) {
            bundle.putByteArray("MessageRecord.msgData", bArr);
        }
        bundle.putInt("MessageRecord.longMsgIndex", messageRecord.longMsgIndex);
        bundle.putInt("MessageRecord.longMsgCount", messageRecord.longMsgCount);
        bundle.putInt("MessageRecord.longMsgId", messageRecord.longMsgId);
        bundle.putLong("MessageRecord.msgUid", messageRecord.msgUid);
        bundle.putLong("MessageRecord.uniseq", messageRecord.uniseq);
        String str5 = messageRecord.extStr;
        if (str5 != null) {
            bundle.putString("MessageRecord.extStr", str5);
        }
        bundle.putBoolean("MessageRecord.isMultiMsg", messageRecord.isMultiMsg);
        bundle.putInt("MessageRecord.extInt", messageRecord.extInt);
        bundle.putInt("MessageRecord.extLong", messageRecord.extLong);
        bundle.putBoolean("MessageRecord.isValid", messageRecord.isValid);
        bundle.putInt("MessageRecord.versionCode", messageRecord.versionCode);
        bundle.putLong("MessageRecord.vipBubbleID", messageRecord.vipBubbleID);
    }

    private static void k(Bundle bundle, MpfileTaskRecord mpfileTaskRecord) {
        bundle.putLong("MpfileTaskRecord.sessionId", mpfileTaskRecord.sessionId);
        String str = mpfileTaskRecord.fileId;
        if (str != null) {
            bundle.putString("MpfileTaskRecord.fileId", str);
        }
        String str2 = mpfileTaskRecord.fileName;
        if (str2 != null) {
            bundle.putString("MpfileTaskRecord.fileName", str2);
        }
        bundle.putLong("MpfileTaskRecord.currentSize", mpfileTaskRecord.currentSize);
        bundle.putLong("MpfileTaskRecord.totalSize", mpfileTaskRecord.totalSize);
        String str3 = mpfileTaskRecord.fileTime;
        if (str3 != null) {
            bundle.putString("MpfileTaskRecord.fileTime", str3);
        }
        String str4 = mpfileTaskRecord.filePath;
        if (str4 != null) {
            bundle.putString("MpfileTaskRecord.filePath", str4);
        }
        String str5 = mpfileTaskRecord.fileTempPath;
        if (str5 != null) {
            bundle.putString("MpfileTaskRecord.fileTempPath", str5);
        }
        bundle.putLong("MpfileTaskRecord.din", mpfileTaskRecord.din);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        MessageRecord messageRecord = this.f390545d;
        if (messageRecord instanceof DataLineMsgRecord) {
            parcel.writeString("DataLineMsgRecord");
            Bundle bundle = new Bundle();
            j(bundle, this.f390545d);
            g(bundle, (DataLineMsgRecord) this.f390545d);
            parcel.writeBundle(bundle);
            return;
        }
        if (messageRecord instanceof MpfileTaskRecord) {
            parcel.writeString("MpfileTaskRecord");
            Bundle bundle2 = new Bundle();
            j(bundle2, this.f390545d);
            k(bundle2, (MpfileTaskRecord) this.f390545d);
            parcel.writeBundle(bundle2);
        }
    }
}
