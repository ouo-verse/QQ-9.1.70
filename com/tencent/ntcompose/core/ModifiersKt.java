package com.tencent.ntcompose.core;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.ntcompose.core.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aT\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\t\u001aN\u0010\u0016\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012:\u0010\u0015\u001a6\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\fj\u0002`\u0014\u001a9\u0010\u001b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012%\u0010\u0015\u001a!\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00130\u0017j\u0002`\u001a\u001a\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001c*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001*@\u0010\u001e\"\u001d\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00130\u00172\u001d\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00130\u0017*j\u0010\u001f\"2\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\f22\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\f\u00a8\u0006 "}, d2 = {"Lcom/tencent/ntcompose/core/i;", "", "propKey", "", "propArg0", "propArg1", "propArg2", "propArg3", "propArg4", "Lcom/tencent/ntcompose/core/f;", "viewPropUpdater", "b", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/base/Attr;", "Lkotlin/ParameterName;", "name", "attr", "Lcom/tencent/kuikly/core/base/event/Event;", "event", "", "Lcom/tencent/ntcompose/core/ViewCallback;", "viewCallback", "d", "Lkotlin/Function1;", "Lcom/tencent/ntcompose/core/ComposeRenderView;", "view", "Lcom/tencent/ntcompose/core/ComposeRenderViewCallback;", "e", "Lcom/tencent/ntcompose/core/k;", "a", "ComposeRenderViewCallback", "ViewCallback", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ModifiersKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final k a(i iVar, final String propKey) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        iVar.a(Unit.INSTANCE, new Function2<i.c, Unit, Unit>() { // from class: com.tencent.ntcompose.core.ModifiersKt$getProp$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(i.c cVar, Unit unit) {
                invoke2(cVar, unit);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(i.c mod, Unit unit) {
                Intrinsics.checkNotNullParameter(mod, "mod");
                Intrinsics.checkNotNullParameter(unit, "<anonymous parameter 1>");
                if ((mod instanceof k) && Intrinsics.areEqual(((k) mod).getPropKey(), propKey)) {
                    objectRef.element = mod;
                }
            }
        });
        return (k) objectRef.element;
    }

    public static final i d(i iVar, String propKey, Function2<? super Attr, ? super Event, Unit> viewCallback) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(viewCallback, "viewCallback");
        return c(iVar, propKey, viewCallback, null, null, null, null, m.f339225a, 60, null);
    }

    public static final i e(i iVar, String propKey, Function1<? super ComposeRenderView, Unit> viewCallback) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(viewCallback, "viewCallback");
        return c(iVar, propKey, viewCallback, null, null, null, null, b.f339208a, 60, null);
    }

    public static final i b(i iVar, String propKey, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, f viewPropUpdater) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(viewPropUpdater, "viewPropUpdater");
        return iVar.b(new k(propKey, obj, obj2, obj3, obj4, obj5, viewPropUpdater));
    }

    public static /* synthetic */ i c(i iVar, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, f fVar, int i3, Object obj6) {
        return b(iVar, str, obj, (i3 & 4) != 0 ? null : obj2, (i3 & 8) != 0 ? null : obj3, (i3 & 16) != 0 ? null : obj4, (i3 & 32) != 0 ? null : obj5, fVar);
    }
}
