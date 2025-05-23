package com.tencent.mobileqq.mini.apkg;

import NS_MINI_INTERFACE.INTERFACE$TagInfo;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes33.dex */
public class TagInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<TagInfo> CREATOR = new Parcelable.Creator<TagInfo>() { // from class: com.tencent.mobileqq.mini.apkg.TagInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TagInfo createFromParcel(Parcel parcel) {
            TagInfo tagInfo = new TagInfo();
            tagInfo.tagText = parcel.readString();
            tagInfo.tagColor = parcel.readString();
            tagInfo.tagType = parcel.readInt();
            return tagInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TagInfo[] newArray(int i3) {
            return new TagInfo[i3];
        }
    };
    public String tagColor;
    public String tagText;
    public int tagType;

    public static TagInfo copy(TagInfo tagInfo) {
        TagInfo tagInfo2 = new TagInfo();
        if (tagInfo != null) {
            tagInfo2.tagText = tagInfo.tagText;
            tagInfo2.tagColor = tagInfo.tagColor;
            tagInfo2.tagType = tagInfo.tagType;
        }
        return tagInfo2;
    }

    public static TagInfo from(INTERFACE$TagInfo iNTERFACE$TagInfo) {
        TagInfo tagInfo = new TagInfo();
        if (iNTERFACE$TagInfo != null) {
            tagInfo.tagText = iNTERFACE$TagInfo.tagText.get();
            tagInfo.tagColor = iNTERFACE$TagInfo.tagColor.get();
            tagInfo.tagType = iNTERFACE$TagInfo.tagType.get();
        }
        return tagInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.tagText);
        parcel.writeString(this.tagColor);
        parcel.writeInt(this.tagType);
    }
}
