package com.qq.e.comm.plugin.ipc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.qq.e.comm.managers.GDTADManager;

/* loaded from: classes3.dex */
public class IPCResult implements Parcelable {
    public static final int CODE_CONNECTION_INVALID = -2;
    public static final int CODE_CONNECT_FAILED = -105;
    public static final int CODE_ERR = -102;
    public static final int CODE_HAS_EXCEPTION = -101;
    public static final int CODE_NO_CONNECT = -1;
    public static final int CODE_NO_ERR = 0;
    public static final int CODE_UNKOWN = -100;
    public static final Parcelable.Creator<IPCResult> CREATOR = new Parcelable.Creator<IPCResult>() { // from class: com.qq.e.comm.plugin.ipc.IPCResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IPCResult createFromParcel(Parcel parcel) {
            return new IPCResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IPCResult[] newArray(int i3) {
            return new IPCResult[i3];
        }
    };
    public int code;
    public Bundle data;

    /* renamed from: e, reason: collision with root package name */
    public Throwable f39585e;

    public IPCResult() {
    }

    public static IPCResult createExceptionResult(Throwable th5) {
        IPCResult iPCResult = new IPCResult();
        iPCResult.code = -101;
        iPCResult.f39585e = th5;
        return iPCResult;
    }

    public static IPCResult createResult(int i3, Bundle bundle) {
        IPCResult iPCResult = new IPCResult();
        iPCResult.code = i3;
        iPCResult.data = bundle;
        return iPCResult;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean isValid() {
        if (this.data != null) {
            return true;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.code);
        parcel.writeBundle(this.data);
    }

    protected IPCResult(Parcel parcel) {
        this.code = parcel.readInt();
        Bundle readBundle = parcel.readBundle();
        this.data = readBundle;
        if (readBundle != null) {
            readBundle.setClassLoader(GDTADManager.getInstance().getPM().getPluginClassLoader());
        }
    }
}
