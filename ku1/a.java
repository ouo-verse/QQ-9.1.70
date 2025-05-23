package ku1;

import com.tencent.mobileqq.app.BusinessObserver;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a implements BusinessObserver {

    /* renamed from: d, reason: collision with root package name */
    private static int f413038d = 0 + 1;

    /* renamed from: e, reason: collision with root package name */
    public static final int f413039e = 0;

    private void b(int i3, boolean z16, Object obj) {
        if (i3 != f413039e) {
            return;
        }
        a(z16);
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        b(i3, z16, obj);
    }

    protected void a(boolean z16) {
    }
}
