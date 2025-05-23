package com.tencent.mapsdk.internal;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class qr {

    /* renamed from: a, reason: collision with root package name */
    public final String f149895a;

    /* renamed from: b, reason: collision with root package name */
    public final String f149896b;

    /* renamed from: c, reason: collision with root package name */
    public final int f149897c;

    /* renamed from: d, reason: collision with root package name */
    public final String[] f149898d;

    public qr(String str, String str2, String[] strArr, int i3) {
        String[] strArr2;
        this.f149895a = str;
        this.f149896b = str2;
        if (strArr == null) {
            strArr2 = null;
        } else {
            int length = strArr.length;
            String[] strArr3 = new String[length];
            System.arraycopy(strArr, 0, strArr3, 0, length);
            strArr2 = strArr3;
        }
        this.f149898d = strArr2;
        this.f149897c = i3;
    }

    private static String[] a(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        int length = strArr.length;
        String[] strArr2 = new String[length];
        System.arraycopy(strArr, 0, strArr2, 0, length);
        return strArr2;
    }
}
