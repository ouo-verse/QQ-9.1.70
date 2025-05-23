package com.qzone.proxy.feedcomponent.model;

import android.os.Parcel;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class WeishiInfo implements SmartParcelable {

    @NeedParcel
    public String cover_url;

    @NeedParcel
    public Map<String, String> dc_report;

    @NeedParcel
    public String nick_name;

    @NeedParcel
    public String pull_weishi_alg_id;

    @NeedParcel
    public int pull_weishi_mask;

    @NeedParcel
    public String weishi_clipbrd;

    @NeedParcel
    public String weishi_download_url;

    @NeedParcel
    public String weishi_feedId;

    @NeedParcel
    public String weishi_fileId;

    @NeedParcel
    public String weishi_musicId;

    @NeedParcel
    public String weishi_musicName;

    @NeedParcel
    public String weishi_musicUrl;

    @NeedParcel
    public String weishi_pull_schema;

    @NeedParcel
    public String weishi_schema;

    @NeedParcel
    public String weishi_topicID;

    @NeedParcel
    public String weishi_topicName;

    @NeedParcel
    public String weishi_topicUrl;

    public void readFrom(Parcel parcel) {
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
        this.pull_weishi_mask = parcel.readInt();
        this.weishi_download_url = parcel.readString();
        this.weishi_pull_schema = parcel.readString();
        this.weishi_clipbrd = parcel.readString();
        this.pull_weishi_alg_id = parcel.readString();
    }

    public String toString() {
        return "WeishiInfo [nick_name=" + this.nick_name + ", weishi_musicName=" + this.weishi_musicName + ", weishi_topicName=" + this.weishi_topicName + "]";
    }

    public void writeTo(Parcel parcel) {
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
        parcel.writeInt(this.pull_weishi_mask);
        parcel.writeString(this.weishi_download_url);
        parcel.writeString(this.weishi_pull_schema);
        parcel.writeString(this.weishi_clipbrd);
        parcel.writeString(this.pull_weishi_alg_id);
    }
}
