package com.tencent.qqmini.sdk.launcher.ipc;

import android.os.Binder;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.annotation.NonNull;

/* loaded from: classes23.dex */
public class ProcessDeathNotifier implements Parcelable {
    public static final Parcelable.Creator<ProcessDeathNotifier> CREATOR = new Parcelable.Creator<ProcessDeathNotifier>() { // from class: com.tencent.qqmini.sdk.launcher.ipc.ProcessDeathNotifier.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProcessDeathNotifier[] newArray(int i3) {
            return new ProcessDeathNotifier[0];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProcessDeathNotifier createFromParcel(Parcel parcel) {
            return new ProcessDeathNotifier(parcel);
        }
    };
    private static volatile ProcessDeathNotifier sInstance;
    private final IBinder mBinder;

    public static ProcessDeathNotifier getInstance() {
        if (sInstance == null) {
            synchronized (ProcessDeathNotifier.class) {
                if (sInstance == null) {
                    sInstance = new ProcessDeathNotifier();
                }
            }
        }
        return sInstance;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void observeDeath(@NonNull final Runnable runnable) {
        try {
            this.mBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.tencent.qqmini.sdk.launcher.ipc.ProcessDeathNotifier.1
                @Override // android.os.IBinder.DeathRecipient
                public void binderDied() {
                    runnable.run();
                }
            }, 0);
        } catch (DeadObjectException unused) {
            runnable.run();
        } catch (RemoteException unused2) {
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeStrongBinder(this.mBinder);
    }

    ProcessDeathNotifier() {
        this.mBinder = new Binder();
    }

    ProcessDeathNotifier(Parcel parcel) {
        this.mBinder = parcel.readStrongBinder();
    }
}
