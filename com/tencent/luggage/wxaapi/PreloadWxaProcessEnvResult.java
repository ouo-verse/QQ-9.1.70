package com.tencent.luggage.wxaapi;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes9.dex */
public enum PreloadWxaProcessEnvResult implements Parcelable {
    Preload_OK,
    Preload_AlreadyPreloaded,
    Preload_Fail,
    Preload_HitFrequencyLimit,
    Preload_NotLoadDynamicPkg,
    Preload_FailMiniGameNotSupported;

    public static final Parcelable.Creator<PreloadWxaProcessEnvResult> CREATOR = new Parcelable.Creator<PreloadWxaProcessEnvResult>() { // from class: com.tencent.luggage.wxaapi.PreloadWxaProcessEnvResult.a
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PreloadWxaProcessEnvResult createFromParcel(Parcel parcel) {
            int readInt = parcel.readInt();
            for (PreloadWxaProcessEnvResult preloadWxaProcessEnvResult : PreloadWxaProcessEnvResult.values()) {
                if (preloadWxaProcessEnvResult.ordinal() == readInt) {
                    return preloadWxaProcessEnvResult;
                }
            }
            return PreloadWxaProcessEnvResult.Preload_Fail;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PreloadWxaProcessEnvResult[] newArray(int i3) {
            return new PreloadWxaProcessEnvResult[i3];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(ordinal());
    }
}
