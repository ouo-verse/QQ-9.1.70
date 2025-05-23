package dh1;

import com.tencent.mobileqq.utils.x;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u00072\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\b\u00a8\u0006\f"}, d2 = {"Ldh1/b;", "", "", "c", "recycleViewWidth", "a", "screenHeight", "b", "I", "mostCardCnt", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int mostCardCnt = 2;

    public final int a(int recycleViewWidth) {
        int max = Math.max(2, (int) ((recycleViewWidth / x.a(162.0f)) + 0.5d));
        this.mostCardCnt = max;
        int min = Math.min(5, max);
        this.mostCardCnt = min;
        return min;
    }

    public final int b(int screenHeight) {
        return Math.max(4, (int) ((screenHeight / x.a(232.0f)) + 0.5d));
    }

    /* renamed from: c, reason: from getter */
    public final int getMostCardCnt() {
        return this.mostCardCnt;
    }
}
