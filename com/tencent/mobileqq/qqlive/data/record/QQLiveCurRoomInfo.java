package com.tencent.mobileqq.qqlive.data.record;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveCurRoomInfo implements Parcelable {
    static IPatchRedirector $redirector_ = null;
    public static final Parcelable.Creator<QQLiveCurRoomInfo> CREATOR;
    public static final int ROOM_TYPE_ANCHOR = 1;
    public static final int ROOM_TYPE_AUDIENCE = 2;
    public static final int ROOM_TYPE_UNKNOW = 0;
    public String account;
    public boolean isFloatWindow;
    public boolean playingAudio;
    public boolean playingVideo;
    public int processContextHashCode;
    public int processId;
    public String programId;
    public long roomId;
    public int roomType;
    public long uid;
    public boolean usingAudioRecord;
    public boolean usingCamera;
    public boolean usingScreenCapture;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56703);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            CREATOR = new Parcelable.Creator<QQLiveCurRoomInfo>() { // from class: com.tencent.mobileqq.qqlive.data.record.QQLiveCurRoomInfo.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public QQLiveCurRoomInfo createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new QQLiveCurRoomInfo(parcel) : (QQLiveCurRoomInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public QQLiveCurRoomInfo[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new QQLiveCurRoomInfo[i3] : (QQLiveCurRoomInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            };
        }
    }

    public QQLiveCurRoomInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.roomType = 0;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 0;
    }

    public boolean isConditionEquals(QQLiveCurRoomInfo qQLiveCurRoomInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQLiveCurRoomInfo)).booleanValue();
        }
        if (qQLiveCurRoomInfo == null || qQLiveCurRoomInfo == this) {
            return true;
        }
        if (qQLiveCurRoomInfo.roomId == this.roomId && qQLiveCurRoomInfo.roomType == this.roomType && TextUtils.equals(qQLiveCurRoomInfo.programId, this.programId)) {
            return true;
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "QQLiveCurRoomInfo{roomType=" + this.roomType + ", roomId=" + this.roomId + ", programId=" + this.programId + ", uid=" + this.uid + ", isFloatWindow=" + this.isFloatWindow + ", playingVideo=" + this.playingVideo + ", playingAudio=" + this.playingAudio + ", usingAudioRecord=" + this.usingAudioRecord + ", usingCamera=" + this.usingCamera + ", usingScreenCapture=" + this.usingScreenCapture + ", processId=" + this.processId + ", processContextHashCode=" + this.processContextHashCode + ", account=" + this.account + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeInt(this.roomType);
        parcel.writeLong(this.roomId);
        parcel.writeString(this.programId);
        parcel.writeLong(this.uid);
        parcel.writeByte(this.isFloatWindow ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.playingVideo ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.playingAudio ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.usingAudioRecord ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.usingCamera ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.usingScreenCapture ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.processId);
        parcel.writeInt(this.processContextHashCode);
        parcel.writeString(this.account);
    }

    public QQLiveCurRoomInfo(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.roomType = 0;
        this.roomType = parcel.readInt();
        this.roomId = parcel.readLong();
        this.programId = parcel.readString();
        this.uid = parcel.readLong();
        this.isFloatWindow = parcel.readByte() != 0;
        this.playingVideo = parcel.readByte() != 0;
        this.playingAudio = parcel.readByte() != 0;
        this.usingAudioRecord = parcel.readByte() != 0;
        this.usingCamera = parcel.readByte() != 0;
        this.usingScreenCapture = parcel.readByte() != 0;
        this.processId = parcel.readInt();
        this.processContextHashCode = parcel.readInt();
        this.account = parcel.readString();
    }
}
