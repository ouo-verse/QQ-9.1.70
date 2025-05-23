package a24;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0012\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0014\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u000e\u001a\u0004\b\u0005\u0010\u000f\"\u0004\b\u0013\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"La24/e;", "La24/b;", "", "a", "", "b", "I", "getType", "()I", "f", "(I)V", "type", "", "c", "Z", "()Z", "d", "(Z)V", "isEnd", "e", "needHide", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class e extends b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int type;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isEnd;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean needHide;

    @Override // a24.b
    public long a() {
        return -3L;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getNeedHide() {
        return this.needHide;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsEnd() {
        return this.isEnd;
    }

    public final void d(boolean z16) {
        this.isEnd = z16;
    }

    public final void e(boolean z16) {
        this.needHide = z16;
    }

    public final void f(int i3) {
        this.type = i3;
    }
}
