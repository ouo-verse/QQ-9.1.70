package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class WeishiFeedCommInfo implements Parcelable {
    public static final Parcelable.Creator<WeishiFeedCommInfo> CREATOR = new Parcelable.Creator<WeishiFeedCommInfo>() { // from class: cooperation.qzone.model.WeishiFeedCommInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WeishiFeedCommInfo createFromParcel(Parcel parcel) {
            return new WeishiFeedCommInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WeishiFeedCommInfo[] newArray(int i3) {
            return new WeishiFeedCommInfo[i3];
        }
    };
    public int appid;
    public String cellId;
    public String curlikekey;
    public String feedskey;
    public boolean isLike;
    public int operatemask;
    public int operatemask2;
    public int orgCommentnum;
    public String orglikekey;
    public int orglikenum;
    public int polyPraiseCombo;
    public int polyPraiseItemId;
    public String polyPraisePicUrl;
    public String subId;
    public int ugcRight;
    public String ugckey;

    public WeishiFeedCommInfo(int i3, String str, String str2, String str3, String str4) {
        this.appid = i3;
        this.ugckey = str;
        this.cellId = str2;
        this.subId = str3;
        this.feedskey = str4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.appid);
        parcel.writeString(this.ugckey);
        parcel.writeString(this.cellId);
        parcel.writeString(this.subId);
        parcel.writeString(this.feedskey);
        parcel.writeInt(this.operatemask);
        parcel.writeInt(this.operatemask2);
        parcel.writeString(this.curlikekey);
        parcel.writeString(this.orglikekey);
        parcel.writeInt(this.orglikenum);
        parcel.writeInt(this.orgCommentnum);
        parcel.writeInt(this.ugcRight);
        parcel.writeInt(this.isLike ? 1 : 0);
        parcel.writeInt(this.polyPraiseItemId);
        parcel.writeString(this.polyPraisePicUrl);
        parcel.writeInt(this.polyPraiseCombo);
    }

    protected WeishiFeedCommInfo(Parcel parcel) {
        this.appid = parcel.readInt();
        this.ugckey = parcel.readString();
        this.cellId = parcel.readString();
        this.subId = parcel.readString();
        this.feedskey = parcel.readString();
        this.operatemask = parcel.readInt();
        this.operatemask2 = parcel.readInt();
        this.curlikekey = parcel.readString();
        this.orglikekey = parcel.readString();
        this.orglikenum = parcel.readInt();
        this.orgCommentnum = parcel.readInt();
        this.ugcRight = parcel.readInt();
        this.isLike = parcel.readInt() == 1;
        this.polyPraiseItemId = parcel.readInt();
        this.polyPraisePicUrl = parcel.readString();
        this.polyPraiseCombo = parcel.readInt();
    }
}
