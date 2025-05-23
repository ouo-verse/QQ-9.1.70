package com.tencent.guild.aio.emo;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes6.dex */
public class EmotionPanelData implements Parcelable {
    public static final Parcelable.Creator<EmotionPanelData> CREATOR = new a();

    /* loaded from: classes6.dex */
    class a implements Parcelable.Creator<EmotionPanelData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EmotionPanelData createFromParcel(Parcel parcel) {
            return new EmotionPanelData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EmotionPanelData[] newArray(int i3) {
            return new EmotionPanelData[i3];
        }
    }

    public EmotionPanelData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected EmotionPanelData(Parcel parcel) {
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
    }
}
