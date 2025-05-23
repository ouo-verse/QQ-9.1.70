package com.tencent.shadow.dynamic.host;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* compiled from: P */
/* loaded from: classes25.dex */
public class FailedException extends Exception implements Parcelable {
    public static final Parcelable.Creator<FailedException> CREATOR = new Parcelable.Creator<FailedException>() { // from class: com.tencent.shadow.dynamic.host.FailedException.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FailedException createFromParcel(Parcel parcel) {
            return new FailedException(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FailedException[] newArray(int i3) {
            return new FailedException[i3];
        }
    };
    public static final int ERROR_CODE_FILE_NOT_FOUND_EXCEPTION = 3;
    public static final int ERROR_CODE_RELOAD_LOADER_EXCEPTION = 8;
    public static final int ERROR_CODE_RELOAD_RUNTIME_EXCEPTION = 7;
    public static final int ERROR_CODE_REMOTE_EXCEPTION = 1;
    public static final int ERROR_CODE_RESET_UUID_EXCEPTION = 6;
    public static final int ERROR_CODE_RUNTIME_EXCEPTION = 2;
    public static final int ERROR_CODE_UUID_MANAGER_DEAD_EXCEPTION = 5;
    public static final int ERROR_CODE_UUID_MANAGER_NULL_EXCEPTION = 4;
    public final int errorCode;
    public final String errorMessage;

    public FailedException(RemoteException remoteException) {
        this.errorCode = 1;
        this.errorMessage = remoteException.getClass().getSimpleName() + ":" + remoteException.getMessage();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.errorCode);
        parcel.writeString(this.errorMessage);
    }

    public FailedException(RuntimeException runtimeException) {
        this.errorCode = 2;
        this.errorMessage = runtimeException.getClass().getSimpleName() + ":" + runtimeException.getMessage();
    }

    public FailedException(int i3, String str) {
        this.errorCode = i3;
        this.errorMessage = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FailedException(Parcel parcel) {
        this.errorCode = parcel.readInt();
        this.errorMessage = parcel.readString();
    }
}
