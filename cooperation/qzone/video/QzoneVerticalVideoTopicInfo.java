package cooperation.qzone.video;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.webkit.URLUtil;
import cooperation.qzone.util.QZLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QzoneVerticalVideoTopicInfo implements Parcelable {
    public static final Parcelable.Creator<QzoneVerticalVideoTopicInfo> CREATOR = new Parcelable.Creator<QzoneVerticalVideoTopicInfo>() { // from class: cooperation.qzone.video.QzoneVerticalVideoTopicInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QzoneVerticalVideoTopicInfo createFromParcel(Parcel parcel) {
            QzoneVerticalVideoTopicInfo qzoneVerticalVideoTopicInfo = new QzoneVerticalVideoTopicInfo();
            qzoneVerticalVideoTopicInfo.feedId = parcel.readString();
            qzoneVerticalVideoTopicInfo.fileId = parcel.readString();
            qzoneVerticalVideoTopicInfo.musicId = parcel.readString();
            qzoneVerticalVideoTopicInfo.musicName = parcel.readString();
            qzoneVerticalVideoTopicInfo.musicUrl = parcel.readString();
            qzoneVerticalVideoTopicInfo.thumbUrl = parcel.readString();
            qzoneVerticalVideoTopicInfo.topicId = parcel.readString();
            qzoneVerticalVideoTopicInfo.topicName = parcel.readString();
            return qzoneVerticalVideoTopicInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QzoneVerticalVideoTopicInfo[] newArray(int i3) {
            return new QzoneVerticalVideoTopicInfo[i3];
        }
    };
    private String TAG = QzoneVerticalVideoTopicInfo.class.getSimpleName();
    private String feedId;
    private String fileId;
    private String musicId;
    private String musicName;
    private String musicUrl;
    private String thumbUrl;
    private String topicId;
    private String topicName;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class MyJSONObject extends JSONObject {
        MyJSONObject() {
        }

        public MyJSONObject putData(String str, String str2) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    put(str, str2);
                } catch (JSONException e16) {
                    QZLog.d(QzoneVerticalVideoTopicInfo.this.TAG, 2, "put JSON error", e16);
                }
            }
            return this;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDescName() {
        if (!TextUtils.isEmpty(this.topicName)) {
            return this.topicName;
        }
        return this.musicName;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public String getFileId() {
        return this.fileId;
    }

    public String getMusicId() {
        return this.musicId;
    }

    public String getMusicName() {
        return this.musicName;
    }

    public String getMusicUrl() {
        return this.musicUrl;
    }

    public String getThumbImgUrl() {
        if (!TextUtils.isEmpty(this.thumbUrl) && !URLUtil.isHttpUrl(this.thumbUrl) && !URLUtil.isHttpsUrl(this.thumbUrl)) {
            Matcher matcher = Pattern.compile("img:(.*?),").matcher(this.thumbUrl);
            if (matcher.find()) {
                String replace = matcher.group().replace("img:", "").replace(",", "");
                if (URLUtil.isHttpUrl(replace) || URLUtil.isHttpsUrl(replace)) {
                    return replace;
                }
                return null;
            }
            return null;
        }
        return this.thumbUrl;
    }

    public String getThumbUrl() {
        return this.thumbUrl;
    }

    public String getTopicId() {
        return this.topicId;
    }

    public String getTopicName() {
        return this.topicName;
    }

    public boolean hasMusic() {
        if (!TextUtils.isEmpty(this.musicUrl) && !TextUtils.isEmpty(this.musicName)) {
            return true;
        }
        return false;
    }

    public QzoneVerticalVideoTopicInfo setFeedId(String str) {
        this.feedId = str;
        return this;
    }

    public QzoneVerticalVideoTopicInfo setFileId(String str) {
        this.fileId = str;
        return this;
    }

    public QzoneVerticalVideoTopicInfo setMusicId(String str) {
        this.musicId = str;
        return this;
    }

    public QzoneVerticalVideoTopicInfo setMusicName(String str) {
        this.musicName = str;
        return this;
    }

    public QzoneVerticalVideoTopicInfo setMusicUrl(String str) {
        this.musicUrl = str;
        return this;
    }

    public QzoneVerticalVideoTopicInfo setThumbUrl(String str) {
        this.thumbUrl = str;
        return this;
    }

    public QzoneVerticalVideoTopicInfo setTopicId(String str) {
        this.topicId = str;
        return this;
    }

    public QzoneVerticalVideoTopicInfo setTopicName(String str) {
        this.topicName = str;
        return this;
    }

    public String toJSONString() {
        MyJSONObject myJSONObject = new MyJSONObject();
        myJSONObject.putData("weishi_feedId", this.feedId).putData("weishi_fileId", this.fileId).putData("weishi_musicId", this.musicId).putData("weishi_musicName", this.musicName).putData("weishi_thumbUrl", this.thumbUrl).putData("weishi_topicID", this.topicId).putData("weishi_topicName", this.topicName);
        return myJSONObject.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.feedId);
        parcel.writeString(this.fileId);
        parcel.writeString(this.musicId);
        parcel.writeString(this.musicName);
        parcel.writeString(this.musicUrl);
        parcel.writeString(this.thumbUrl);
        parcel.writeString(this.topicId);
        parcel.writeString(this.topicName);
    }
}
