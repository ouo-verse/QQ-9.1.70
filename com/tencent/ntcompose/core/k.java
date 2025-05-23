package com.tencent.ntcompose.core;

import com.tencent.ntcompose.core.i;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\"\u001a\u00020\u001e\u00a2\u0006\u0004\b#\u0010$J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0012\u001a\u0004\b\u001c\u0010\u0014R\u0017\u0010\"\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/ntcompose/core/k;", "Lcom/tencent/ntcompose/core/i$c;", "Lcom/tencent/ntcompose/core/ComposeRenderView;", "view", "", "i", tl.h.F, "", "other", "", "equals", "", "b", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "propKey", "c", "Ljava/lang/Object;", "d", "()Ljava/lang/Object;", "propArg0", "e", "propArg1", "getPropArg2", "propArg2", "f", "propArg3", "getPropArg4", "propArg4", "Lcom/tencent/ntcompose/core/f;", "Lcom/tencent/ntcompose/core/f;", "getViewPropUpdater", "()Lcom/tencent/ntcompose/core/f;", "viewPropUpdater", "<init>", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lcom/tencent/ntcompose/core/f;)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class k implements i.c {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String propKey;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Object propArg0;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Object propArg1;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Object propArg2;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Object propArg3;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Object propArg4;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final f viewPropUpdater;

    public k(String propKey, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, f viewPropUpdater) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(viewPropUpdater, "viewPropUpdater");
        this.propKey = propKey;
        this.propArg0 = obj;
        this.propArg1 = obj2;
        this.propArg2 = obj3;
        this.propArg3 = obj4;
        this.propArg4 = obj5;
        this.viewPropUpdater = viewPropUpdater;
    }

    @Override // com.tencent.ntcompose.core.i
    public <R> R a(R r16, Function2<? super i.c, ? super R, ? extends R> function2) {
        return (R) i.c.a.b(this, r16, function2);
    }

    @Override // com.tencent.ntcompose.core.i
    public i b(i iVar) {
        return i.c.a.c(this, iVar);
    }

    @Override // com.tencent.ntcompose.core.i
    public <R> R c(R r16, Function2<? super R, ? super i.c, ? extends R> function2) {
        return (R) i.c.a.a(this, r16, function2);
    }

    /* renamed from: d, reason: from getter */
    public final Object getPropArg0() {
        return this.propArg0;
    }

    /* renamed from: e, reason: from getter */
    public final Object getPropArg1() {
        return this.propArg1;
    }

    /* renamed from: f, reason: from getter */
    public final Object getPropArg3() {
        return this.propArg3;
    }

    /* renamed from: g, reason: from getter */
    public final String getPropKey() {
        return this.propKey;
    }

    public final void h(ComposeRenderView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.viewPropUpdater.resetPropToView(view, this.propKey);
    }

    public final void i(ComposeRenderView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.viewPropUpdater.setPropToView(view, this.propKey, this.propArg0, this.propArg1, this.propArg2, this.propArg3, this.propArg4);
    }

    public /* synthetic */ k(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, f fVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, obj, (i3 & 4) != 0 ? null : obj2, (i3 & 8) != 0 ? null : obj3, (i3 & 16) != 0 ? null : obj4, (i3 & 32) != 0 ? null : obj5, fVar);
    }

    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof k)) {
            return false;
        }
        k kVar = (k) other;
        return Intrinsics.areEqual(this.propKey, kVar.propKey) && Intrinsics.areEqual(this.propArg0, kVar.propArg0) && Intrinsics.areEqual(this.propArg1, kVar.propArg1) && Intrinsics.areEqual(this.propArg2, kVar.propArg2) && Intrinsics.areEqual(this.propArg3, kVar.propArg3) && Intrinsics.areEqual(this.propArg4, kVar.propArg4) && Intrinsics.areEqual(this.viewPropUpdater, kVar.viewPropUpdater);
    }
}
