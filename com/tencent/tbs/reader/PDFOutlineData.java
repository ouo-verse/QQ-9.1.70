package com.tencent.tbs.reader;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes26.dex */
public class PDFOutlineData implements Parcelable {
    public static final Parcelable.Creator<PDFOutlineData> CREATOR = new Parcelable.Creator<PDFOutlineData>() { // from class: com.tencent.tbs.reader.PDFOutlineData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PDFOutlineData createFromParcel(Parcel parcel) {
            PDFOutlineData pDFOutlineData = new PDFOutlineData();
            pDFOutlineData.mTitle = parcel.readString();
            pDFOutlineData.mPageNum = parcel.readInt();
            pDFOutlineData.mLevel = parcel.readInt();
            pDFOutlineData.mIsCurOutline = parcel.readInt();
            return pDFOutlineData;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PDFOutlineData[] newArray(int i3) {
            return new PDFOutlineData[i3];
        }
    };
    private int mIsCurOutline;
    private int mLevel;
    private int mPageNum;
    private String mTitle;

    public PDFOutlineData(String str, int i3, int i16) {
        this.mTitle = str;
        this.mPageNum = i3;
        this.mLevel = i16;
        this.mIsCurOutline = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getOutlineLevel() {
        return this.mLevel;
    }

    public int getPage() {
        return this.mPageNum;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public boolean isCurrOutline() {
        if (this.mIsCurOutline == 1) {
            return true;
        }
        return false;
    }

    public void setCurrOutline(boolean z16) {
        this.mIsCurOutline = z16 ? 1 : 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.mTitle);
        parcel.writeInt(this.mPageNum);
        parcel.writeInt(this.mLevel);
        parcel.writeInt(this.mIsCurOutline);
    }

    public PDFOutlineData() {
    }
}
