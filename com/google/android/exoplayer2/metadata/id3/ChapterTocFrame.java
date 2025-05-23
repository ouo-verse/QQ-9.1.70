package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class ChapterTocFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterTocFrame> CREATOR = new Parcelable.Creator<ChapterTocFrame>() { // from class: com.google.android.exoplayer2.metadata.id3.ChapterTocFrame.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ChapterTocFrame createFromParcel(Parcel parcel) {
            return new ChapterTocFrame(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ChapterTocFrame[] newArray(int i3) {
            return new ChapterTocFrame[i3];
        }
    };
    public static final String ID = "CTOC";
    public final String[] children;
    public final String elementId;
    public final boolean isOrdered;
    public final boolean isRoot;
    private final Id3Frame[] subFrames;

    public ChapterTocFrame(String str, boolean z16, boolean z17, String[] strArr, Id3Frame[] id3FrameArr) {
        super(ID);
        this.elementId = str;
        this.isRoot = z16;
        this.isOrdered = z17;
        this.children = strArr;
        this.subFrames = id3FrameArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ChapterTocFrame.class != obj.getClass()) {
            return false;
        }
        ChapterTocFrame chapterTocFrame = (ChapterTocFrame) obj;
        if (this.isRoot == chapterTocFrame.isRoot && this.isOrdered == chapterTocFrame.isOrdered && Util.areEqual(this.elementId, chapterTocFrame.elementId) && Arrays.equals(this.children, chapterTocFrame.children) && Arrays.equals(this.subFrames, chapterTocFrame.subFrames)) {
            return true;
        }
        return false;
    }

    public Id3Frame getSubFrame(int i3) {
        return this.subFrames[i3];
    }

    public int getSubFrameCount() {
        return this.subFrames.length;
    }

    public int hashCode() {
        int i3;
        int i16 = (((527 + (this.isRoot ? 1 : 0)) * 31) + (this.isOrdered ? 1 : 0)) * 31;
        String str = this.elementId;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        return i16 + i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.elementId);
        parcel.writeByte(this.isRoot ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isOrdered ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.children);
        parcel.writeInt(this.subFrames.length);
        for (Id3Frame id3Frame : this.subFrames) {
            parcel.writeParcelable(id3Frame, 0);
        }
    }

    ChapterTocFrame(Parcel parcel) {
        super(ID);
        this.elementId = parcel.readString();
        this.isRoot = parcel.readByte() != 0;
        this.isOrdered = parcel.readByte() != 0;
        this.children = parcel.createStringArray();
        int readInt = parcel.readInt();
        this.subFrames = new Id3Frame[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            this.subFrames[i3] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }
}
