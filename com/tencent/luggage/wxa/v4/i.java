package com.tencent.luggage.wxa.v4;

import android.os.Parcel;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum i {
    LEGACY(0),
    PRE_RENDER(1),
    HEADLESS(2);


    /* renamed from: a, reason: collision with root package name */
    public final int f143254a;

    i(int i3) {
        this.f143254a = i3;
    }

    public boolean b() {
        if (this != PRE_RENDER && this != HEADLESS) {
            return false;
        }
        return true;
    }

    public static void a(i iVar, Parcel parcel) {
        parcel.writeInt(iVar.ordinal());
    }

    public static i a(Parcel parcel) {
        int readInt = parcel.readInt();
        for (i iVar : values()) {
            if (readInt == iVar.ordinal()) {
                return iVar;
            }
        }
        w.b("Luggage.WxaColdStartMode", "readFromParcel get unrecognized ordinal %d", Integer.valueOf(readInt));
        return LEGACY;
    }
}
