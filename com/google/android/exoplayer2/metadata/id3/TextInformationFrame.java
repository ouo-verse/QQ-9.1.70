package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.Util;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class TextInformationFrame extends Id3Frame {
    public static final Parcelable.Creator<TextInformationFrame> CREATOR = new Parcelable.Creator<TextInformationFrame>() { // from class: com.google.android.exoplayer2.metadata.id3.TextInformationFrame.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TextInformationFrame createFromParcel(Parcel parcel) {
            return new TextInformationFrame(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TextInformationFrame[] newArray(int i3) {
            return new TextInformationFrame[i3];
        }
    };
    public final String description;
    public final String value;

    public TextInformationFrame(String str, String str2, String str3) {
        super(str);
        this.description = str2;
        this.value = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TextInformationFrame.class != obj.getClass()) {
            return false;
        }
        TextInformationFrame textInformationFrame = (TextInformationFrame) obj;
        if (this.f32945id.equals(textInformationFrame.f32945id) && Util.areEqual(this.description, textInformationFrame.description) && Util.areEqual(this.value, textInformationFrame.value)) {
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
        String str2 = this.value;
        if (str2 != null) {
            i16 = str2.hashCode();
        }
        return i17 + i16;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f32945id);
        parcel.writeString(this.description);
        parcel.writeString(this.value);
    }

    TextInformationFrame(Parcel parcel) {
        super(parcel.readString());
        this.description = parcel.readString();
        this.value = parcel.readString();
    }
}
