package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.smtt.utils.Md5Utils;

/* loaded from: classes28.dex */
public class PublishEventTag implements Parcelable {
    public static final Parcelable.Creator<PublishEventTag> CREATOR = new Parcelable.Creator<PublishEventTag>() { // from class: cooperation.qzone.model.PublishEventTag.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PublishEventTag createFromParcel(Parcel parcel) {
            return new PublishEventTag(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PublishEventTag[] newArray(int i3) {
            return new PublishEventTag[i3];
        }
    };
    public String desc;

    /* renamed from: id, reason: collision with root package name */
    public String f390868id;
    public String picUrl;

    /* renamed from: protocol, reason: collision with root package name */
    public String f390869protocol;
    public boolean publishSyncToQcircle;
    public String publishTemplateTopic;
    public String time;
    public String title;
    public String truncateNum;
    public String uin;

    public PublishEventTag() {
    }

    public static PublishEventTag assembleFakeTag(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            PublishEventTag publishEventTag = new PublishEventTag();
            publishEventTag.title = str;
            publishEventTag.uin = str2;
            publishEventTag.f390869protocol = str2 + "_102_" + str;
            publishEventTag.f390868id = Md5Utils.getMD5(str);
            return publishEventTag;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.title);
        parcel.writeString(this.picUrl);
        parcel.writeString(this.f390868id);
        parcel.writeString(this.f390869protocol);
        parcel.writeString(this.desc);
        parcel.writeString(this.truncateNum);
        parcel.writeString(this.uin);
    }

    protected PublishEventTag(Parcel parcel) {
        this.title = parcel.readString();
        this.picUrl = parcel.readString();
        this.f390868id = parcel.readString();
        this.f390869protocol = parcel.readString();
        this.desc = parcel.readString();
        this.truncateNum = parcel.readString();
        this.uin = parcel.readString();
    }
}
