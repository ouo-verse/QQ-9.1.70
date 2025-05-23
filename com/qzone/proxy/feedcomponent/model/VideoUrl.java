package com.qzone.proxy.feedcomponent.model;

import android.os.Parcel;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class VideoUrl implements SmartParcelable {

    @NeedParcel
    public int decoderType;

    @NeedParcel
    public String url;

    @NeedParcel
    public int videoRate;

    public VideoUrl() {
    }

    public void readFrom(Parcel parcel) {
        this.url = parcel.readString();
        this.decoderType = parcel.readInt();
        this.videoRate = parcel.readInt();
    }

    public String toString() {
        return "VideoUrl [url=" + this.url + ", decoderType=" + this.decoderType + ", videoRate=" + this.videoRate + "]";
    }

    public void writeTo(Parcel parcel) {
        parcel.writeString(this.url);
        parcel.writeInt(this.decoderType);
        parcel.writeInt(this.videoRate);
    }

    public VideoUrl(String str) {
        this.url = str;
        this.decoderType = 1;
    }

    public VideoUrl(String str, int i3) {
        this.url = str;
        this.decoderType = i3;
    }

    public VideoUrl(String str, int i3, int i16) {
        this.url = str;
        this.decoderType = i3;
        this.videoRate = i16;
    }
}
