package com.tencent.luggage.wxa.fd;

import android.os.Parcel;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum j0 {
    UNKNOWN,
    TRANSPARENT,
    OPAQUE;

    public static void a(j0 j0Var, Parcel parcel) {
        if (j0Var == null) {
            j0Var = UNKNOWN;
        }
        parcel.writeInt(j0Var.ordinal());
    }

    public static j0 a(Parcel parcel) {
        j0 j0Var = UNKNOWN;
        int readInt = parcel.readInt();
        for (j0 j0Var2 : values()) {
            if (j0Var2.ordinal() == readInt) {
                return j0Var2;
            }
        }
        return j0Var;
    }
}
