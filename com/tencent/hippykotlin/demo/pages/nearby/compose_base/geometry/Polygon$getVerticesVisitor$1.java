package com.tencent.hippykotlin.demo.pages.nearby.compose_base.geometry;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* loaded from: classes31.dex */
public final class Polygon$getVerticesVisitor$1 extends Lambda implements Function0<Point> {
    public final /* synthetic */ Ref.IntRef $index;
    public final /* synthetic */ int $size;
    public final /* synthetic */ Polygon this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Polygon$getVerticesVisitor$1(Ref.IntRef intRef, int i3, Polygon polygon) {
        super(0);
        this.$index = intRef;
        this.$size = i3;
        this.this$0 = polygon;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Point invoke() {
        Ref.IntRef intRef = this.$index;
        if (intRef.element >= this.$size) {
            intRef.element = 0;
        }
        Point point = this.this$0.vertices.get(intRef.element);
        this.$index.element++;
        return point;
    }
}
