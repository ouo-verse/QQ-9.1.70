package androidx.core.os;

import android.os.Parcel;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class ParcelCompat {
    ParcelCompat() {
    }

    public static boolean readBoolean(@NonNull Parcel parcel) {
        if (parcel.readInt() != 0) {
            return true;
        }
        return false;
    }

    public static void writeBoolean(@NonNull Parcel parcel, boolean z16) {
        parcel.writeInt(z16 ? 1 : 0);
    }
}
