package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniServiceFetcher implements Parcelable {
    public static final Parcelable.Creator<MiniServiceFetcher> CREATOR = new Parcelable.Creator<MiniServiceFetcher>() { // from class: com.tencent.qqmini.sdk.launcher.model.MiniServiceFetcher.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MiniServiceFetcher createFromParcel(Parcel parcel) {
            parcel.readStrongBinder();
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MiniServiceFetcher[] newArray(int i3) {
            return new MiniServiceFetcher[i3];
        }
    };
    private static final String TAG = "MiniServiceManager";
    private IMiniServiceManager mServiceManager;

    public MiniServiceFetcher(IMiniServiceManager iMiniServiceManager) {
        this.mServiceManager = iMiniServiceManager;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IMiniServiceManager getMiniServiceManager() {
        return this.mServiceManager;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeStrongBinder(this.mServiceManager.asBinder());
    }
}
