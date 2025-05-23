package com.xingin.xhssharesdk.model.sharedata;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Keep
/* loaded from: classes28.dex */
public class XhsVideoInfo implements Parcelable {
    public static final Parcelable.Creator<XhsVideoInfo> CREATOR = new a();

    @Nullable
    private final XhsImageResourceBean cover;

    @NonNull
    private final XhsVideoResourceBean video;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a implements Parcelable.Creator<XhsVideoInfo> {
        @Override // android.os.Parcelable.Creator
        public final XhsVideoInfo createFromParcel(Parcel parcel) {
            return new XhsVideoInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final XhsVideoInfo[] newArray(int i3) {
            return new XhsVideoInfo[i3];
        }
    }

    public XhsVideoInfo(Parcel parcel) {
        this.video = (XhsVideoResourceBean) parcel.readParcelable(XhsVideoResourceBean.class.getClassLoader());
        this.cover = (XhsImageResourceBean) parcel.readParcelable(XhsImageResourceBean.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public XhsImageResourceBean getCover() {
        return this.cover;
    }

    @NonNull
    public XhsVideoResourceBean getVideo() {
        return this.video;
    }

    public JSONObject toJsonForDeeplink() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("video", this.video.toJsonForDeeplink());
        XhsImageResourceBean xhsImageResourceBean = this.cover;
        if (xhsImageResourceBean != null) {
            jSONObject.putOpt("cover", xhsImageResourceBean.toJsonForDeeplink());
        }
        return jSONObject;
    }

    public String toString() {
        return "XhsVideoInfo{video=" + this.video + ", cover=" + this.cover + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i3) {
        parcel.writeParcelable(this.video, i3);
        parcel.writeParcelable(this.cover, i3);
    }

    public XhsVideoInfo(@NonNull XhsVideoResourceBean xhsVideoResourceBean) {
        this(xhsVideoResourceBean, null);
    }

    public XhsVideoInfo(@NonNull XhsVideoResourceBean xhsVideoResourceBean, @Nullable XhsImageResourceBean xhsImageResourceBean) {
        this.video = xhsVideoResourceBean;
        this.cover = xhsImageResourceBean;
    }
}
