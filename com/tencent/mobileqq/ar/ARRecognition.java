package com.tencent.mobileqq.ar;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ARRecognition implements Parcelable {
    public static final Parcelable.Creator<ARRecognition> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public long f196956d;

    /* renamed from: e, reason: collision with root package name */
    public int f196957e;

    /* renamed from: f, reason: collision with root package name */
    public int f196958f;

    /* renamed from: h, reason: collision with root package name */
    public int f196959h;

    /* renamed from: i, reason: collision with root package name */
    public long f196960i;

    /* renamed from: m, reason: collision with root package name */
    public int f196961m;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements Parcelable.Creator<ARRecognition> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ARRecognition createFromParcel(Parcel parcel) {
            return new ARRecognition(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ARRecognition[] newArray(int i3) {
            return new ARRecognition[i3];
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class b implements Comparator<c> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            return cVar.f196962a - cVar2.f196962a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f196962a;

        /* renamed from: b, reason: collision with root package name */
        public long f196963b;

        public c(long j3, int i3) {
            this.f196962a = i3;
            this.f196963b = j3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public long f196964a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f196965b;

        public d(long j3, boolean z16) {
            this.f196964a = j3;
            this.f196965b = z16;
        }
    }

    public ARRecognition() {
    }

    public static long a(ArrayList<ARRecognition> arrayList) {
        long j3 = 0;
        if (arrayList != null) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (arrayList.get(i3).f196957e != 0) {
                    j3 |= 1 << ((int) arrayList.get(i3).f196956d);
                }
            }
        }
        return j3;
    }

    public static long b(ArrayList<ARRecognition> arrayList) {
        long j3 = 0;
        if (arrayList != null) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (arrayList.get(i3).f196958f != 0) {
                    j3 |= 1 << ((int) arrayList.get(i3).f196956d);
                }
            }
        }
        return j3;
    }

    public static d c(ArrayList<ARRecognition> arrayList, com.tencent.mobileqq.ar.arengine.m mVar) {
        boolean z16 = false;
        d dVar = new d(0L, false);
        if (arrayList != null && arrayList.size() > 0) {
            boolean b16 = com.tencent.mobileqq.ar.arengine.d.b(mVar.f198206d);
            boolean b17 = com.tencent.mobileqq.ar.arengine.g.b(mVar.f198207e);
            boolean a16 = com.tencent.mobileqq.ar.arengine.o.a(mVar.f198208f);
            boolean c16 = com.tencent.mobileqq.ar.arengine.e.c(mVar.f198212j);
            boolean b18 = com.tencent.mobileqq.ar.arengine.t.b(mVar.f198213k);
            if (!b16 && !b17 && !a16 && !c16 && !b18) {
                return dVar;
            }
            ArrayList arrayList2 = new ArrayList();
            if (b16) {
                arrayList2.add(new c(1L, e(arrayList, 1L)));
            }
            if (a16) {
                arrayList2.add(new c(4L, e(arrayList, 4L)));
            }
            if (b17) {
                arrayList2.add(new c(2L, e(arrayList, 2L)));
            }
            if (c16) {
                arrayList2.add(new c(128L, e(arrayList, 128L)));
            }
            if (b18) {
                arrayList2.add(new c(2048L, e(arrayList, 2048L)));
            }
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                sb5.append("(index:");
                sb5.append(i3);
                sb5.append(",prority=" + ((c) arrayList2.get(i3)).f196963b + ")\n");
            }
            QLog.i("AREngine_CommonConfigInfo", 1, "getCurrentPriorityHighestResult print result " + sb5.toString());
            Collections.sort(arrayList2, new b());
            dVar.f196964a = ((c) arrayList2.get(0)).f196963b;
            if (arrayList2.size() == 1) {
                z16 = true;
            }
            dVar.f196965b = z16;
        }
        return dVar;
    }

    public static int e(ArrayList<ARRecognition> arrayList, long j3) {
        if (arrayList != null) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (j3 == (1 << ((int) arrayList.get(i3).f196956d))) {
                    return arrayList.get(i3).f196959h;
                }
            }
            return 5;
        }
        return 5;
    }

    public static boolean f(long j3, long j16, int i3, int i16) {
        if (i3 != i16) {
            if (i3 >= i16) {
                return false;
            }
            return true;
        }
        if (j3 != 1 && j16 != 1) {
            if (j3 != 2 && j16 != 2) {
                if (j3 != 128 && j16 != 128) {
                    if (j3 != 4 && j16 != 4) {
                        if (j3 != 64 && j16 != 64) {
                            if ((j3 == 2048 || j16 == 2048) && j3 != 2048) {
                                return false;
                            }
                            return true;
                        }
                        if (j3 != 64) {
                            return false;
                        }
                        return true;
                    }
                    if (j3 != 4) {
                        return false;
                    }
                    return true;
                }
                if (j3 != 128) {
                    return false;
                }
                return true;
            }
            if (j3 != 2) {
                return false;
            }
            return true;
        }
        if (j3 != 1) {
            return false;
        }
        return true;
    }

    public static boolean g(ArrayList<ARRecognition> arrayList, long j3, long j16) {
        int i3;
        int i16;
        int i17 = 5;
        if (arrayList != null) {
            int i18 = 5;
            for (int i19 = 0; i19 < arrayList.size(); i19++) {
                long j17 = 1 << ((int) arrayList.get(i19).f196956d);
                if (j3 == j17) {
                    i17 = arrayList.get(i19).f196959h;
                } else if (j16 == j17) {
                    i18 = arrayList.get(i19).f196959h;
                }
            }
            i3 = i17;
            i16 = i18;
        } else {
            i3 = 5;
            i16 = 5;
        }
        return f(j3, j16, i3, i16);
    }

    public static boolean j(ArrayList<ARRecognition> arrayList, long j3) {
        int e16 = e(arrayList, j3);
        if (arrayList != null) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (!f(j3, 1 << ((int) arrayList.get(i3).f196956d), e16, arrayList.get(i3).f196959h)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean k(com.tencent.mobileqq.ar.arengine.m mVar, ArrayList<ARRecognition> arrayList, long j3) {
        if (mVar == null || arrayList == null || !l(mVar, j3)) {
            return false;
        }
        int e16 = e(arrayList, j3);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            long j16 = 1 << ((int) arrayList.get(i3).f196956d);
            int i16 = arrayList.get(i3).f196959h;
            if (j3 != j16 && l(mVar, j16) && !f(j3, j16, e16, i16)) {
                return false;
            }
        }
        return true;
    }

    public static boolean l(com.tencent.mobileqq.ar.arengine.m mVar, long j3) {
        if (mVar == null) {
            return false;
        }
        if (j3 == 1) {
            return com.tencent.mobileqq.ar.arengine.d.b(mVar.f198206d);
        }
        if (j3 == 2) {
            return com.tencent.mobileqq.ar.arengine.g.b(mVar.f198207e);
        }
        if (j3 == 128) {
            return com.tencent.mobileqq.ar.arengine.e.c(mVar.f198212j);
        }
        if (j3 == 4) {
            return com.tencent.mobileqq.ar.arengine.o.a(mVar.f198208f);
        }
        if (j3 == 64) {
            return com.tencent.mobileqq.ar.arengine.h.b(mVar.f198210h);
        }
        if (j3 != 2048) {
            return false;
        }
        return com.tencent.mobileqq.ar.arengine.t.b(mVar.f198213k);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("Recognition{");
        stringBuffer.append("type=");
        stringBuffer.append(this.f196956d);
        stringBuffer.append("CloudRecogOpen =");
        stringBuffer.append(this.f196957e);
        stringBuffer.append("LocalRecogOpen =");
        stringBuffer.append(this.f196958f);
        stringBuffer.append(", priority='");
        stringBuffer.append(this.f196959h);
        stringBuffer.append('\'');
        stringBuffer.append(", wait_ms='");
        stringBuffer.append(this.f196960i);
        stringBuffer.append('\'');
        stringBuffer.append("ImagePreprocess_open =");
        stringBuffer.append(this.f196961m);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f196956d);
        parcel.writeInt(this.f196957e);
        parcel.writeInt(this.f196958f);
        parcel.writeInt(this.f196959h);
        parcel.writeLong(this.f196960i);
        parcel.writeInt(this.f196961m);
    }

    public ARRecognition(Parcel parcel) {
        this.f196956d = parcel.readLong();
        this.f196957e = parcel.readInt();
        this.f196958f = parcel.readInt();
        this.f196959h = parcel.readInt();
        this.f196960i = parcel.readLong();
        this.f196961m = parcel.readInt();
    }
}
