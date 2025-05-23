package com.tencent.ntcompose.ui.focus;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.ntcompose.core.ModifiersKt;
import com.tencent.ntcompose.core.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ntcompose/core/i;", "Lcom/tencent/ntcompose/ui/focus/a;", "focusRequester", "a", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class FocusRequestModifierKt {
    public static final i a(i iVar, final a focusRequester) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(focusRequester, "focusRequester");
        return ModifiersKt.d(iVar, "focusRequester", new Function2<Attr, Event, Unit>() { // from class: com.tencent.ntcompose.ui.focus.FocusRequestModifierKt$focusRequester$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Attr attr, Event event) {
                invoke2(attr, event);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Attr attr, Event event) {
                Intrinsics.checkNotNullParameter(attr, "attr");
                Intrinsics.checkNotNullParameter(event, "event");
                a.this.d(new aa<>(attr.getPagerId(), attr.getNativeRef()));
            }
        });
    }
}
