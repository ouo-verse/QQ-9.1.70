package jy2;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Ljy2/j;", "", "", com.tencent.luggage.wxa.c8.c.G, "", "a", "J", "getDuration", "()J", "duration", "b", "Z", "needShowTipWhenNearlyEnd", "", "c", "I", "doubleCheck", "<init>", "(J)V", "d", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long duration;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean needShowTipWhenNearlyEnd = true;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int doubleCheck;

    public j(long j3) {
        this.duration = j3;
    }

    public final boolean a(long pos) {
        long j3 = this.duration;
        if (j3 > 0 && pos + 5000 > j3 && pos < j3 - 3000) {
            if (this.needShowTipWhenNearlyEnd) {
                this.needShowTipWhenNearlyEnd = false;
                this.doubleCheck = 0;
                return true;
            }
        } else if (pos + 5000 <= j3) {
            int i3 = this.doubleCheck + 1;
            this.doubleCheck = i3;
            if (i3 == 2) {
                this.needShowTipWhenNearlyEnd = true;
                this.doubleCheck = 0;
            }
        }
        return false;
    }
}
