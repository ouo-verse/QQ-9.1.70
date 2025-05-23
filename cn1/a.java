package cn1;

import com.tencent.mobileqq.app.BusinessObserver;

/* compiled from: P */
/* loaded from: classes13.dex */
public class a implements BusinessObserver {

    /* renamed from: d, reason: collision with root package name */
    private static int f31134d = 0 + 1;

    /* renamed from: e, reason: collision with root package name */
    public static final int f31135e = 0;

    private void b(int i3, boolean z16, Object obj) {
        int i16;
        if (i3 != f31135e) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 1) {
                i16 = ((Integer) objArr[0]).intValue();
                a(z16, i16);
            }
        }
        i16 = -1;
        a(z16, i16);
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        b(i3, z16, obj);
    }

    protected void a(boolean z16, int i3) {
    }
}
