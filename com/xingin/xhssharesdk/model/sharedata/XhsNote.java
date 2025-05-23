package com.xingin.xhssharesdk.model.sharedata;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* compiled from: P */
@Keep
/* loaded from: classes28.dex */
public class XhsNote implements Parcelable {
    public static final Parcelable.Creator<XhsNote> CREATOR = new a();
    private String content;
    private XhsImageInfo imageInfo;
    private String title;
    private XhsVideoInfo videoInfo;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a implements Parcelable.Creator<XhsNote> {
        @Override // android.os.Parcelable.Creator
        public final XhsNote createFromParcel(Parcel parcel) {
            return new XhsNote(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final XhsNote[] newArray(int i3) {
            return new XhsNote[i3];
        }
    }

    public XhsNote() {
    }

    public XhsNote(Parcel parcel) {
        this.title = parcel.readString();
        this.content = parcel.readString();
        this.imageInfo = (XhsImageInfo) parcel.readParcelable(XhsImageInfo.class.getClassLoader());
        this.videoInfo = (XhsVideoInfo) parcel.readParcelable(XhsVideoInfo.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getContent() {
        return this.content;
    }

    public XhsImageInfo getImageInfo() {
        return this.imageInfo;
    }

    public String getNoteType() {
        if (getImageInfo() != null && getImageInfo().isValid()) {
            return "IMAGE";
        }
        if (getVideoInfo() != null) {
            return "VIDEO";
        }
        return "";
    }

    public String getTitle() {
        return this.title;
    }

    public XhsVideoInfo getVideoInfo() {
        return this.videoInfo;
    }

    public XhsNote setContent(String str) {
        this.content = str;
        return this;
    }

    public XhsNote setImageInfo(XhsImageInfo xhsImageInfo) {
        this.imageInfo = xhsImageInfo;
        return this;
    }

    public XhsNote setTitle(String str) {
        this.title = str;
        return this;
    }

    public XhsNote setVideoInfo(XhsVideoInfo xhsVideoInfo) {
        this.videoInfo = xhsVideoInfo;
        return this;
    }

    public JSONObject toJsonForDeeplink() {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.title)) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("value", this.title);
            jSONObject.putOpt("title", jSONObject2);
        }
        if (!TextUtils.isEmpty(this.content)) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("value", this.content);
            jSONObject.putOpt("content", jSONObject3);
        }
        XhsImageInfo xhsImageInfo = this.imageInfo;
        if (xhsImageInfo != null && xhsImageInfo.isValid()) {
            jSONObject.putOpt("image_info", this.imageInfo.toJsonForDeeplink());
        }
        XhsVideoInfo xhsVideoInfo = this.videoInfo;
        if (xhsVideoInfo != null) {
            jSONObject.putOpt("video_info", xhsVideoInfo.toJsonForDeeplink());
        }
        return jSONObject;
    }

    @NonNull
    public String toString() {
        return "XhsNote{title='" + this.title + "', content='" + this.content + "', imageInfo=" + this.imageInfo + ", videoInfo=" + this.videoInfo + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i3) {
        parcel.writeString(this.title);
        parcel.writeString(this.content);
        parcel.writeParcelable(this.imageInfo, i3);
        parcel.writeParcelable(this.videoInfo, i3);
    }
}
