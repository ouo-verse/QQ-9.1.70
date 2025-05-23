package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class WeishiBasicInfo implements Parcelable {
    public static final Parcelable.Creator<WeishiBasicInfo> CREATOR = new Parcelable.Creator<WeishiBasicInfo>() { // from class: cooperation.qzone.model.WeishiBasicInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WeishiBasicInfo createFromParcel(Parcel parcel) {
            return new WeishiBasicInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WeishiBasicInfo[] newArray(int i3) {
            return new WeishiBasicInfo[i3];
        }
    };
    public String cover_url;
    public Map<String, String> dc_report;
    public String nick_name;
    public String weishi_feedId;
    public String weishi_fileId;
    public String weishi_musicId;
    public String weishi_musicName;
    public String weishi_musicUrl;
    public String weishi_schema;
    public String weishi_summary;
    public String weishi_topicID;
    public String weishi_topicName;
    public String weishi_topicUrl;

    public WeishiBasicInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Map<String, String> map, String str12) {
        this.weishi_feedId = str;
        this.weishi_fileId = str2;
        this.cover_url = str3;
        this.nick_name = str4;
        this.weishi_musicId = str5;
        this.weishi_musicName = str6;
        this.weishi_musicUrl = str7;
        this.weishi_topicID = str8;
        this.weishi_topicName = str9;
        this.weishi_topicUrl = str10;
        this.weishi_schema = str11;
        this.dc_report = map;
        this.weishi_summary = str12;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.weishi_feedId);
        parcel.writeString(this.weishi_fileId);
        parcel.writeString(this.cover_url);
        parcel.writeString(this.nick_name);
        parcel.writeString(this.weishi_musicId);
        parcel.writeString(this.weishi_musicName);
        parcel.writeString(this.weishi_musicUrl);
        parcel.writeString(this.weishi_topicID);
        parcel.writeString(this.weishi_topicName);
        parcel.writeString(this.weishi_topicUrl);
        parcel.writeString(this.weishi_schema);
        parcel.writeMap(this.dc_report);
        parcel.writeString(this.weishi_summary);
    }

    protected WeishiBasicInfo(Parcel parcel) {
        this.weishi_feedId = parcel.readString();
        this.weishi_fileId = parcel.readString();
        this.cover_url = parcel.readString();
        this.nick_name = parcel.readString();
        this.weishi_musicId = parcel.readString();
        this.weishi_musicName = parcel.readString();
        this.weishi_musicUrl = parcel.readString();
        this.weishi_topicID = parcel.readString();
        this.weishi_topicName = parcel.readString();
        this.weishi_topicUrl = parcel.readString();
        this.weishi_schema = parcel.readString();
        HashMap hashMap = new HashMap();
        this.dc_report = hashMap;
        parcel.readMap(hashMap, hashMap.getClass().getClassLoader());
        this.weishi_summary = parcel.readString();
    }
}
