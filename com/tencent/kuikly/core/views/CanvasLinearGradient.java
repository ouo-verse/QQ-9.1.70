package com.tencent.kuikly.core.views;

import com.heytap.databaseengine.model.UserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\t\u001a\u00020\bH\u0016R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u0012\u0010\fR$\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/kuikly/core/views/CanvasLinearGradient;", "", "", "stopIn01", "Lcom/tencent/kuikly/core/base/h;", "color", "", "a", "", "toString", UserInfo.SEX_FEMALE, "b", "()F", "x0", "d", "y0", "c", "x1", "e", "y1", "Ljava/util/ArrayList;", "Lcom/tencent/kuikly/core/base/j;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "colorStops", "<init>", "(FFFF)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class CanvasLinearGradient {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float x0;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final float y0;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final float x1;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final float y1;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<com.tencent.kuikly.core.base.j> colorStops = new ArrayList<>();

    public CanvasLinearGradient(float f16, float f17, float f18, float f19) {
        this.x0 = f16;
        this.y0 = f17;
        this.x1 = f18;
        this.y1 = f19;
    }

    public final void a(float stopIn01, com.tencent.kuikly.core.base.h color) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.colorStops.add(new com.tencent.kuikly.core.base.j(color, stopIn01));
    }

    /* renamed from: b, reason: from getter */
    public final float getX0() {
        return this.x0;
    }

    /* renamed from: c, reason: from getter */
    public final float getX1() {
        return this.x1;
    }

    /* renamed from: d, reason: from getter */
    public final float getY0() {
        return this.y0;
    }

    /* renamed from: e, reason: from getter */
    public final float getY1() {
        return this.y1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v13, types: [T, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v8, types: [T, java.lang.String] */
    public String toString() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new String();
        Iterator<com.tencent.kuikly.core.base.j> it = this.colorStops.iterator();
        while (it.hasNext()) {
            objectRef.element = ((String) objectRef.element) + it.next() + ',';
        }
        if (((CharSequence) objectRef.element).length() > 0) {
            T t16 = objectRef.element;
            ?? substring = ((String) t16).substring(0, ((String) t16).length() - 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            objectRef.element = substring;
        }
        return "linear-gradient" + new com.tencent.kuikly.core.nvi.serialization.json.e(new Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit>() { // from class: com.tencent.kuikly.core.views.CanvasLinearGradient$toString$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.kuikly.core.nvi.serialization.json.e $receiver) {
                Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                $receiver.z("x0", Float.valueOf(CanvasLinearGradient.this.getX0()));
                $receiver.z("y0", Float.valueOf(CanvasLinearGradient.this.getY0()));
                $receiver.z("x1", Float.valueOf(CanvasLinearGradient.this.getX1()));
                $receiver.z("y1", Float.valueOf(CanvasLinearGradient.this.getY1()));
                $receiver.z("colorStops", objectRef.element);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar) {
                invoke2(eVar);
                return Unit.INSTANCE;
            }
        });
    }
}
