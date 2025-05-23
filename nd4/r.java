package nd4;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private t f420018a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private m f420019b;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private v f420021d;

    /* renamed from: e, reason: collision with root package name */
    private AtomicBoolean f420022e = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private x f420020c = new x();

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(@NonNull t tVar, @NonNull m mVar) {
        this.f420018a = tVar;
        this.f420019b = mVar;
        this.f420021d = new v(this.f420018a.b(), this.f420019b);
    }

    public <T extends a> T a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return (T) this.f420020c.a(str);
        }
        throw new IllegalArgumentException(String.format("\u76d1\u63a7\u540d\u4e3a\u7a7a\uff0c\u8bf7\u586b\u5165\u5df2\u6ce8\u518c\u8fc7\u7684\u76d1\u63a7\u540d\u79f0\uff01", new Object[0]));
    }

    public <T extends a> T b(a aVar) {
        aVar.g(this.f420021d, this.f420019b);
        return (T) this.f420020c.b(aVar);
    }

    public void c() {
        if (!this.f420022e.compareAndSet(false, true)) {
            return;
        }
        this.f420021d.h();
    }
}
