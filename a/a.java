package a;

/* compiled from: P */
/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    public final Runnable f25158d;

    public a(Runnable runnable) {
        this.f25158d = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Runnable runnable = this.f25158d;
            if (runnable != null) {
                runnable.run();
            }
        } catch (Throwable th5) {
            com.tencent.mobileqq.qqbattery.utils.a.d("QQBattery_RunnableWrapper", th5, "", new Object[0]);
        }
    }
}
