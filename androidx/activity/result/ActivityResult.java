package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class ActivityResult implements Parcelable {

    @NonNull
    public static final Parcelable.Creator<ActivityResult> CREATOR = new Parcelable.Creator<ActivityResult>() { // from class: androidx.activity.result.ActivityResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityResult createFromParcel(@NonNull Parcel parcel) {
            return new ActivityResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityResult[] newArray(int i3) {
            return new ActivityResult[i3];
        }
    };

    @Nullable
    private final Intent mData;
    private final int mResultCode;

    public ActivityResult(int i3, @Nullable Intent intent) {
        this.mResultCode = i3;
        this.mData = intent;
    }

    @NonNull
    public static String resultCodeToString(int i3) {
        if (i3 != -1) {
            if (i3 != 0) {
                return String.valueOf(i3);
            }
            return "RESULT_CANCELED";
        }
        return "RESULT_OK";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public Intent getData() {
        return this.mData;
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + resultCodeToString(this.mResultCode) + ", data=" + this.mData + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i3) {
        int i16;
        parcel.writeInt(this.mResultCode);
        if (this.mData == null) {
            i16 = 0;
        } else {
            i16 = 1;
        }
        parcel.writeInt(i16);
        Intent intent = this.mData;
        if (intent != null) {
            intent.writeToParcel(parcel, i3);
        }
    }

    ActivityResult(Parcel parcel) {
        this.mResultCode = parcel.readInt();
        this.mData = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
