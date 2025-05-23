package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.Util;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class UrlLinkFrame extends Id3Frame {
    public static final Parcelable.Creator<UrlLinkFrame> CREATOR = new Parcelable.Creator<UrlLinkFrame>() { // from class: com.google.android.exoplayer2.metadata.id3.UrlLinkFrame.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UrlLinkFrame createFromParcel(Parcel parcel) {
            return new UrlLinkFrame(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UrlLinkFrame[] newArray(int i3) {
            return new UrlLinkFrame[i3];
        }
    };
    public final String description;
    public final String url;

    public UrlLinkFrame(String str, String str2, String str3) {
        super(str);
        this.description = str2;
        this.url = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || UrlLinkFrame.class != obj.getClass()) {
            return false;
        }
        UrlLinkFrame urlLinkFrame = (UrlLinkFrame) obj;
        if (this.f32945id.equals(urlLinkFrame.f32945id) && Util.areEqual(this.description, urlLinkFrame.description) && Util.areEqual(this.url, urlLinkFrame.url)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int hashCode = (527 + this.f32945id.hashCode()) * 31;
        String str = this.description;
        int i16 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = (hashCode + i3) * 31;
        String str2 = this.url;
        if (str2 != null) {
            i16 = str2.hashCode();
        }
        return i17 + i16;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f32945id);
        parcel.writeString(this.description);
        parcel.writeString(this.url);
    }

    UrlLinkFrame(Parcel parcel) {
        super(parcel.readString());
        this.description = parcel.readString();
        this.url = parcel.readString();
    }
}
