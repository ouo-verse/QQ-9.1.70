package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class WeishiFeedInfo implements Parcelable {
    public static final Parcelable.Creator<WeishiFeedInfo> CREATOR = new Parcelable.Creator<WeishiFeedInfo>() { // from class: cooperation.qzone.model.WeishiFeedInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WeishiFeedInfo createFromParcel(Parcel parcel) {
            return new WeishiFeedInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WeishiFeedInfo[] newArray(int i3) {
            return new WeishiFeedInfo[i3];
        }
    };
    public static final int FROM_TYPE_ALBUM_VIDEO = 1;
    public static final int FROM_TYPE_DEFAULT = 0;
    public static final int FROM_TYPE_WEISHI_VIDEO = 2;
    public WeishiBasicInfo basicInfo;
    public WeishiBottomButton bottomButton;
    public WeishiFeedCommInfo feedCommInfo;
    public int feedFakeType;
    public WeishiInterestInfo interestInfo;
    public KingCardInfo kingCardInfo;
    public boolean mIsFrdLikeMiniAppVideo;
    public int mIsFrom;
    public WeishiOperationInfo operationInfo;
    public WeishiShareDataInfo shareDataInfo;
    public WeishiUserInfo userInfo;
    public VideoInfo videoInfo;

    public WeishiFeedInfo() {
        this.mIsFrom = 0;
        this.feedFakeType = 2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.userInfo, i3);
        parcel.writeParcelable(this.videoInfo, i3);
        parcel.writeParcelable(this.basicInfo, i3);
        parcel.writeParcelable(this.feedCommInfo, i3);
        parcel.writeParcelable(this.operationInfo, i3);
        parcel.writeParcelable(this.bottomButton, i3);
        parcel.writeParcelable(this.shareDataInfo, i3);
        parcel.writeParcelable(this.kingCardInfo, i3);
        parcel.writeParcelable(this.interestInfo, i3);
        parcel.writeInt(this.mIsFrom);
        parcel.writeInt(this.mIsFrdLikeMiniAppVideo ? 1 : 0);
        parcel.writeInt(this.feedFakeType);
    }

    protected WeishiFeedInfo(Parcel parcel) {
        this.mIsFrom = 0;
        this.feedFakeType = 2;
        this.userInfo = (WeishiUserInfo) parcel.readParcelable(WeishiUserInfo.class.getClassLoader());
        this.videoInfo = (VideoInfo) parcel.readParcelable(VideoInfo.class.getClassLoader());
        this.basicInfo = (WeishiBasicInfo) parcel.readParcelable(WeishiBasicInfo.class.getClassLoader());
        this.feedCommInfo = (WeishiFeedCommInfo) parcel.readParcelable(WeishiFeedCommInfo.class.getClassLoader());
        this.operationInfo = (WeishiOperationInfo) parcel.readParcelable(WeishiOperationInfo.class.getClassLoader());
        this.bottomButton = (WeishiBottomButton) parcel.readParcelable(WeishiBottomButton.class.getClassLoader());
        this.shareDataInfo = (WeishiShareDataInfo) parcel.readParcelable(WeishiShareDataInfo.class.getClassLoader());
        this.kingCardInfo = (KingCardInfo) parcel.readParcelable(KingCardInfo.class.getClassLoader());
        this.interestInfo = (WeishiInterestInfo) parcel.readParcelable(WeishiInterestInfo.class.getClassLoader());
        this.mIsFrom = parcel.readInt();
        this.mIsFrdLikeMiniAppVideo = parcel.readInt() != 0;
        this.feedFakeType = parcel.readInt();
    }
}
