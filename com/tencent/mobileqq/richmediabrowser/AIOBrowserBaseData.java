package com.tencent.mobileqq.richmediabrowser;

import android.os.Parcel;
import com.tencent.richmediabrowser.model.RichMediaBaseData;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class AIOBrowserBaseData extends RichMediaBaseData {
    public static final String MEDIA_FILE_ERROR = "I:E";
    public static final String MEDIA_FILE_NONE = "I:N";
    public boolean isInMixedMsg;
    public boolean isMsgSeqReady;
    public long msgId;
    public long shmsgseq;
    public long size;
    public long time;
    public int subId = 0;
    public int istroop = 0;
    public boolean isMultiMsg = false;

    @Override // com.tencent.richmediabrowser.model.RichMediaBaseData
    public void readFromParcel(Parcel parcel) {
        boolean z16;
        boolean z17;
        super.readFromParcel(parcel);
        this.msgId = parcel.readLong();
        this.subId = parcel.readInt();
        this.time = parcel.readLong();
        this.size = parcel.readLong();
        this.shmsgseq = parcel.readLong();
        this.istroop = parcel.readInt();
        boolean z18 = false;
        if (parcel.readInt() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isMultiMsg = z16;
        if (parcel.readInt() == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.isInMixedMsg = z17;
        if (parcel.readInt() == 1) {
            z18 = true;
        }
        this.isMsgSeqReady = z18;
    }

    @Override // com.tencent.richmediabrowser.model.RichMediaBaseData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeLong(this.msgId);
        parcel.writeInt(this.subId);
        parcel.writeLong(this.time);
        parcel.writeLong(this.size);
        parcel.writeLong(this.shmsgseq);
        parcel.writeInt(this.istroop);
        parcel.writeInt(this.isMultiMsg ? 1 : 0);
        parcel.writeInt(this.isInMixedMsg ? 1 : 0);
        parcel.writeInt(this.isMsgSeqReady ? 1 : 0);
    }
}
