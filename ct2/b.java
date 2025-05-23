package ct2;

import bt2.c;
import bt2.d;
import com.tencent.mobileqq.app.BusinessObserver;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b implements BusinessObserver {
    public static final int C;

    /* renamed from: d, reason: collision with root package name */
    private static int f391828d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f391829e;

    /* renamed from: f, reason: collision with root package name */
    public static final int f391830f;

    /* renamed from: h, reason: collision with root package name */
    public static final int f391831h;

    /* renamed from: i, reason: collision with root package name */
    public static final int f391832i;

    /* renamed from: m, reason: collision with root package name */
    public static final int f391833m;

    static {
        int i3 = 0 + 1;
        int i16 = i3 + 1;
        f391829e = i3;
        int i17 = i16 + 1;
        f391830f = i16;
        int i18 = i17 + 1;
        f391831h = i17;
        int i19 = i18 + 1;
        f391832i = i18;
        int i26 = i19 + 1;
        f391833m = i19;
        f391828d = i26 + 1;
        C = i26;
    }

    private void g(int i3, boolean z16, Object obj) {
        if (i3 == f391830f && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 3) {
                c(z16, ((Integer) objArr[0]).intValue(), ((Long) objArr[1]).longValue(), (ArrayList) objArr[2]);
            }
        }
    }

    private void h(int i3, boolean z16, Object obj) {
        if (i3 == f391829e && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 3) {
                d(z16, ((Integer) objArr[0]).intValue(), ((Long) objArr[1]).longValue(), (c) objArr[2]);
            }
        }
    }

    private void i(int i3, boolean z16, Object obj) {
        Object[] objArr;
        if (i3 != C) {
            return;
        }
        if (obj instanceof Object[]) {
            objArr = (Object[]) obj;
        } else {
            objArr = null;
        }
        if (objArr != null && objArr.length > 2) {
            f(z16, ((Long) objArr[0]).longValue(), ((Integer) objArr[1]).intValue(), (String) objArr[2]);
        } else {
            f(false, 0L, 0, "");
        }
    }

    private void j(int i3, boolean z16, Object obj) {
        if (i3 == f391831h && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 4) {
                Boolean bool = (Boolean) objArr[0];
                String str = (String) objArr[1];
                String str2 = (String) objArr[2];
                String str3 = (String) objArr[3];
                if (bool.booleanValue()) {
                    a(str, str2, str3);
                } else {
                    b(str, str2, str3);
                }
            }
        }
    }

    private void k(int i3, boolean z16, Object obj) {
        if (i3 != f391832i) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 2) {
                e(z16, ((Long) objArr[0]).longValue(), (ArrayList) objArr[1]);
                return;
            } else {
                e(false, 0L, null);
                return;
            }
        }
        e(false, 0L, null);
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        h(i3, z16, obj);
        g(i3, z16, obj);
        j(i3, z16, obj);
        k(i3, z16, obj);
        i(i3, z16, obj);
    }

    protected void a(String str, String str2, String str3) {
    }

    protected void b(String str, String str2, String str3) {
    }

    protected void e(boolean z16, long j3, ArrayList<String> arrayList) {
    }

    protected void c(boolean z16, int i3, long j3, ArrayList<d> arrayList) {
    }

    @Deprecated
    protected void d(boolean z16, int i3, long j3, c cVar) {
    }

    protected void f(boolean z16, long j3, int i3, String str) {
    }
}
