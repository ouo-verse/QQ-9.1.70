package cooperation.qzone.feed;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class CertifiedFakeFeed implements Parcelable {
    public static final String BUNDLE_KEY = "KEY_CERTIFIED_FAKE_FEED";
    public static final String BUNDLE_KEY_LIST = "KEY_CERTIFIED_FAKE_FEED_LIST";
    public static final Parcelable.Creator<CertifiedFakeFeed> CREATOR = new Parcelable.Creator<CertifiedFakeFeed>() { // from class: cooperation.qzone.feed.CertifiedFakeFeed.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CertifiedFakeFeed createFromParcel(Parcel parcel) {
            return new CertifiedFakeFeed(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CertifiedFakeFeed[] newArray(int i3) {
            return new CertifiedFakeFeed[i3];
        }
    };
    private String clientKey;
    private String content;
    private String coverPath;
    private long createTime;
    private int duration;
    private String feedId;
    private int feedType;
    private int height;
    private String puin;
    private String title;
    private int width;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class Builder {
        private CertifiedFakeFeed feed = new CertifiedFakeFeed();

        public CertifiedFakeFeed build() {
            return this.feed;
        }

        public Builder setClientKey(String str) {
            this.feed.clientKey = str;
            return this;
        }

        public Builder setContent(String str) {
            this.feed.content = str;
            return this;
        }

        public Builder setCoverPath(String str) {
            this.feed.coverPath = str;
            return this;
        }

        public Builder setCreateTime(long j3) {
            this.feed.createTime = j3;
            return this;
        }

        public Builder setDuration(int i3) {
            this.feed.duration = i3;
            return this;
        }

        public Builder setFeedId(String str) {
            this.feed.feedId = str;
            return this;
        }

        public Builder setFeedType(int i3) {
            this.feed.feedType = i3;
            return this;
        }

        public Builder setHeight(int i3) {
            this.feed.height = i3;
            return this;
        }

        public Builder setPuin(String str) {
            this.feed.puin = str;
            return this;
        }

        public Builder setTitle(String str) {
            this.feed.title = str;
            return this;
        }

        public Builder setWidth(int i3) {
            this.feed.width = i3;
            return this;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getClientKey() {
        return this.clientKey;
    }

    public String getContent() {
        return this.content;
    }

    public String getCoverPath() {
        return this.coverPath;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public int getFeedType() {
        return this.feedType;
    }

    public int getHeight() {
        return this.height;
    }

    public String getPuin() {
        return this.puin;
    }

    public String getTitle() {
        return this.title;
    }

    public int getWidth() {
        return this.width;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.feedId);
        parcel.writeString(this.clientKey);
        parcel.writeInt(this.feedType);
        parcel.writeString(this.title);
        parcel.writeString(this.content);
        parcel.writeString(this.coverPath);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeInt(this.duration);
        parcel.writeLong(this.createTime);
        parcel.writeString(this.puin);
    }

    CertifiedFakeFeed() {
    }

    public CertifiedFakeFeed(Parcel parcel) {
        this.feedId = parcel.readString();
        this.clientKey = parcel.readString();
        this.feedType = parcel.readInt();
        this.title = parcel.readString();
        this.content = parcel.readString();
        this.coverPath = parcel.readString();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.duration = parcel.readInt();
        this.createTime = parcel.readLong();
        this.puin = parcel.readString();
    }
}
