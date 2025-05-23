package com.tencent.gamematrix.gmcg.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamematrix.gmcg.api.util.CGStringUtil;

/* loaded from: classes6.dex */
public class GmCgPlayQueueInfo implements Parcelable {
    public static final Parcelable.Creator<GmCgPlayQueueInfo> CREATOR = new Parcelable.Creator<GmCgPlayQueueInfo>() { // from class: com.tencent.gamematrix.gmcg.api.model.GmCgPlayQueueInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GmCgPlayQueueInfo createFromParcel(Parcel parcel) {
            return new GmCgPlayQueueInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GmCgPlayQueueInfo[] newArray(int i3) {
            return new GmCgPlayQueueInfo[i3];
        }
    };
    public String pBizInfo;
    public int pCurAllocQueueSize;
    public int pCurAllocQueueWaitSec;
    public String pGameTag;
    public int pIdentityProfType;
    public int pRealWaitPos;
    public boolean pWaitCanceled;
    public String pWaitId;
    public int pWaitNum;
    public int pWaitPos;
    public int pWaitSec;

    public GmCgPlayQueueInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getIdentityProfType() {
        return this.pIdentityProfType;
    }

    public boolean isValid() {
        return CGStringUtil.notEmpty(this.pWaitId);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.pGameTag);
        parcel.writeString(this.pWaitId);
        parcel.writeInt(this.pWaitNum);
        parcel.writeInt(this.pWaitPos);
        parcel.writeInt(this.pWaitSec);
        parcel.writeByte(this.pWaitCanceled ? (byte) 1 : (byte) 0);
        parcel.writeString(this.pBizInfo);
        parcel.writeInt(this.pIdentityProfType);
        parcel.writeInt(this.pRealWaitPos);
        parcel.writeInt(this.pCurAllocQueueSize);
        parcel.writeInt(this.pCurAllocQueueWaitSec);
    }

    protected GmCgPlayQueueInfo(Parcel parcel) {
        this.pGameTag = parcel.readString();
        this.pWaitId = parcel.readString();
        this.pWaitNum = parcel.readInt();
        this.pWaitPos = parcel.readInt();
        this.pWaitSec = parcel.readInt();
        this.pWaitCanceled = parcel.readByte() != 0;
        this.pBizInfo = parcel.readString();
        this.pIdentityProfType = parcel.readInt();
        this.pRealWaitPos = parcel.readInt();
        this.pCurAllocQueueSize = parcel.readInt();
        this.pCurAllocQueueWaitSec = parcel.readInt();
    }
}
