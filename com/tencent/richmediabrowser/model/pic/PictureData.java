package com.tencent.richmediabrowser.model.pic;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.richmediabrowser.model.RichMediaBaseData;

/* loaded from: classes25.dex */
public class PictureData extends RichMediaBaseData {
    public static final Parcelable.Creator<RichMediaBaseData> CREATOR = new a();
    public int errorCode;
    public boolean isDownloadSuccess;

    /* loaded from: classes25.dex */
    static class a implements Parcelable.Creator<RichMediaBaseData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RichMediaBaseData createFromParcel(Parcel parcel) {
            PictureData pictureData = new PictureData();
            pictureData.readFromParcel(parcel);
            return pictureData;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RichMediaBaseData[] newArray(int i3) {
            return new RichMediaBaseData[i3];
        }
    }

    @Override // com.tencent.richmediabrowser.model.RichMediaBaseData
    public int getType() {
        return 1;
    }
}
