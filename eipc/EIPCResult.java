package eipc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import mqq.app.MobileQQ;

/* loaded from: classes28.dex */
public class EIPCResult implements Parcelable {
    public static final int CODE_CONNECTION_INVALID = -2;
    public static final int CODE_CONNECT_FAILED = -105;
    public static final int CODE_ERR = -102;
    public static final int CODE_HAS_EXCEPTION = -101;
    public static final int CODE_NO_CONNECT = -1;
    public static final int CODE_NO_ERR = 0;
    public static final int CODE_PASS_CHECK_SENDING = -1000;
    public static final int CODE_PASS_CHECK_SENT = -1001;
    public static final int CODE_UNKOWN = -100;
    public static final Parcelable.Creator<EIPCResult> CREATOR;
    public static final String KEY_CODE = "code";
    public static final String KEY_ERR_MSG = "err_msg";
    public static EIPCResult UNKNOW_RESULT;
    public int code;
    public Bundle data;

    /* renamed from: e, reason: collision with root package name */
    public Throwable f396321e;

    static {
        EIPCResult eIPCResult = new EIPCResult();
        UNKNOW_RESULT = eIPCResult;
        eIPCResult.code = -100;
        CREATOR = new Parcelable.Creator<EIPCResult>() { // from class: eipc.EIPCResult.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public EIPCResult createFromParcel(Parcel parcel) {
                return new EIPCResult(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public EIPCResult[] newArray(int i3) {
                return new EIPCResult[i3];
            }
        };
    }

    public EIPCResult() {
    }

    public static EIPCResult createExceptionResult(Throwable th5) {
        EIPCResult eIPCResult = new EIPCResult();
        eIPCResult.code = -101;
        eIPCResult.f396321e = th5;
        return eIPCResult;
    }

    public static EIPCResult createResult(int i3, Bundle bundle) {
        EIPCResult eIPCResult = new EIPCResult();
        eIPCResult.code = i3;
        eIPCResult.data = bundle;
        return eIPCResult;
    }

    public static EIPCResult createSuccessResult(Bundle bundle) {
        EIPCResult eIPCResult = new EIPCResult();
        eIPCResult.code = 0;
        eIPCResult.data = bundle;
        return eIPCResult;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean isSuccess() {
        if (this.code == 0) {
            return true;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.code);
        parcel.writeBundle(this.data);
    }

    EIPCResult(Parcel parcel) {
        this.code = parcel.readInt();
        Bundle readBundle = parcel.readBundle();
        this.data = readBundle;
        if (readBundle != null) {
            readBundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
        }
    }
}
