package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.emoticonview.EmotionPanelData;

/* loaded from: classes10.dex */
public class PromotionEmoticonPkg extends EmotionPanelData {
    public static final Parcelable.Creator<PromotionEmoticonPkg> CREATOR = new a();
    public static int GIF = 3;
    public static int H5MAGIC = 4;
    public static int MAGIC = 1;
    public static int PAY_1_YUAN = 1;
    public static int PAY_6_YUAN = 6;
    public static int PAY_LIMIT_FREE = 0;
    public static int PNG = 2;
    public static int SMALL = 5;
    public String bgColor;
    public String btnDesc;
    public String detailUrl;
    public int exposureNum;
    public int feeType;

    /* renamed from: id, reason: collision with root package name */
    public String f203111id;
    public String imgUrl;
    public boolean isFixedEmoticon;
    public String pkgDesc;
    public int price;
    public int recommendType;
    public int redpointFlag;
    public String titleColor;
    public int type;

    /* loaded from: classes10.dex */
    class a implements Parcelable.Creator<PromotionEmoticonPkg> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PromotionEmoticonPkg createFromParcel(Parcel parcel) {
            return new PromotionEmoticonPkg(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PromotionEmoticonPkg[] newArray(int i3) {
            return new PromotionEmoticonPkg[i3];
        }
    }

    public PromotionEmoticonPkg() {
        this.exposureNum = 0;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmotionPanelData, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmotionPanelData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f203111id);
        parcel.writeInt(this.type);
        parcel.writeInt(this.feeType);
        parcel.writeString(this.imgUrl);
        parcel.writeString(this.pkgDesc);
        parcel.writeString(this.btnDesc);
        parcel.writeString(this.titleColor);
        parcel.writeString(this.bgColor);
        parcel.writeString(this.detailUrl);
        parcel.writeInt(this.price);
        parcel.writeInt(this.recommendType);
        parcel.writeInt(this.redpointFlag);
        parcel.writeInt(this.exposureNum);
        parcel.writeByte(this.isFixedEmoticon ? (byte) 1 : (byte) 0);
    }

    protected PromotionEmoticonPkg(Parcel parcel) {
        this.exposureNum = 0;
        this.f203111id = parcel.readString();
        this.type = parcel.readInt();
        this.feeType = parcel.readInt();
        this.imgUrl = parcel.readString();
        this.pkgDesc = parcel.readString();
        this.btnDesc = parcel.readString();
        this.titleColor = parcel.readString();
        this.bgColor = parcel.readString();
        this.detailUrl = parcel.readString();
        this.price = parcel.readInt();
        this.recommendType = parcel.readInt();
        this.redpointFlag = parcel.readInt();
        this.exposureNum = parcel.readInt();
        this.isFixedEmoticon = parcel.readByte() != 0;
    }
}
