package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000\"(\u0010\b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/a;", "startPoint", "endPoint", "", "c", "Lkotlin/Pair;", "a", "Lkotlin/Pair;", "attractPointPair", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class g {

    /* renamed from: a */
    @Nullable
    private static Pair<AttractPoint, AttractPoint> f319363a;

    public static final /* synthetic */ Pair a() {
        return f319363a;
    }

    public static final /* synthetic */ void b(Pair pair) {
        f319363a = pair;
    }

    public static final void c(@Nullable AttractPoint attractPoint, @Nullable AttractPoint attractPoint2) {
        Pair<AttractPoint, AttractPoint> pair;
        Pair<AttractPoint, AttractPoint> pair2 = f319363a;
        if (pair2 == null) {
            f319363a = new Pair<>(attractPoint, attractPoint2);
            return;
        }
        Pair<AttractPoint, AttractPoint> pair3 = null;
        if (attractPoint != null) {
            if (pair2 != null) {
                pair = Pair.copy$default(pair2, attractPoint, null, 2, null);
            } else {
                pair = null;
            }
            f319363a = pair;
        }
        if (attractPoint2 != null) {
            Pair<AttractPoint, AttractPoint> pair4 = f319363a;
            if (pair4 != null) {
                pair3 = Pair.copy$default(pair4, null, attractPoint2, 1, null);
            }
            f319363a = pair3;
        }
    }
}
