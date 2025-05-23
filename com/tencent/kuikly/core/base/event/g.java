package com.tencent.kuikly.core.base.event;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000\u001a\u0018\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0000\u001a\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0000\u001a\u0018\u0010\u000e\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0000\u00a8\u0006\u000f"}, d2 = {"", "radians", "d", "Lcom/tencent/kuikly/core/base/event/j;", "touch1", "touch2", "b", "", "touches", "Lkotlin/Pair;", "c", "Lcom/tencent/kuikly/core/base/event/i;", "segment1", "segment2", "a", "core_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class g {
    public static final float a(Segment segment1, Segment segment2) {
        Intrinsics.checkNotNullParameter(segment1, "segment1");
        Intrinsics.checkNotNullParameter(segment2, "segment2");
        Pair pair = new Pair(Float.valueOf(segment1.a().getFirst().floatValue() - segment1.b().getFirst().floatValue()), Float.valueOf(segment1.a().getSecond().floatValue() - segment1.b().getSecond().floatValue()));
        Pair pair2 = new Pair(Float.valueOf(segment2.a().getFirst().floatValue() - segment2.b().getFirst().floatValue()), Float.valueOf(segment2.a().getSecond().floatValue() - segment2.b().getSecond().floatValue()));
        return -d((float) Math.atan2((((Number) pair.getFirst()).floatValue() * ((Number) pair2.getSecond()).floatValue()) - (((Number) pair.getSecond()).floatValue() * ((Number) pair2.getFirst()).floatValue()), (((Number) pair.getFirst()).floatValue() * ((Number) pair2.getFirst()).floatValue()) + (((Number) pair.getSecond()).floatValue() * ((Number) pair2.getSecond()).floatValue())));
    }

    public static final float b(j touch1, j touch2) {
        Intrinsics.checkNotNullParameter(touch1, "touch1");
        Intrinsics.checkNotNullParameter(touch2, "touch2");
        float pageX = touch2.getPageX() - touch1.getPageX();
        float pageY = touch2.getPageY() - touch1.getPageY();
        return (float) Math.sqrt((pageX * pageX) + (pageY * pageY));
    }

    public static final Pair<Float, Float> c(List<j> touches) {
        j jVar;
        Intrinsics.checkNotNullParameter(touches, "touches");
        j jVar2 = touches.get(0);
        if (touches.size() > 1) {
            jVar = touches.get(1);
        } else {
            jVar = touches.get(0);
        }
        j jVar3 = jVar;
        return new Pair<>(Float.valueOf((jVar3.getPageX() + jVar2.getPageX()) / 2.0f), Float.valueOf((jVar3.getPageY() + jVar2.getPageY()) / 2.0f));
    }

    public static final float d(float f16) {
        return (f16 * 180.0f) / 3.1415927f;
    }
}
