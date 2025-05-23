package com.tencent.ntcompose.ui.focus;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.views.InputEvent;
import com.tencent.kuikly.core.views.InputParams;
import com.tencent.kuikly.core.views.TextAreaEvent;
import com.tencent.ntcompose.core.ModifiersKt;
import com.tencent.ntcompose.core.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/ntcompose/core/i;", "Lkotlin/Function1;", "Lcom/tencent/ntcompose/ui/focus/c;", "", "onFocusChanged", "a", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class FocusChangedModiferKt {
    public static final i a(i iVar, final Function1<? super c, Unit> onFocusChanged) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Intrinsics.checkNotNullParameter(onFocusChanged, "onFocusChanged");
        return ModifiersKt.d(iVar, "onFocusChanged", new Function2<Attr, Event, Unit>() { // from class: com.tencent.ntcompose.ui.focus.FocusChangedModiferKt$onFocusChanged$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                boolean z16 = event instanceof InputEvent;
                InputEvent inputEvent = z16 ? (InputEvent) event : null;
                if (inputEvent != null) {
                    final Function1<c, Unit> function1 = onFocusChanged;
                    inputEvent.i(new Function1<InputParams, Unit>() { // from class: com.tencent.ntcompose.ui.focus.FocusChangedModiferKt$onFocusChanged$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(InputParams inputParams) {
                            invoke2(inputParams);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(InputParams it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            function1.invoke(new d(true));
                        }
                    });
                }
                InputEvent inputEvent2 = z16 ? (InputEvent) event : null;
                if (inputEvent2 != null) {
                    final Function1<c, Unit> function12 = onFocusChanged;
                    inputEvent2.h(new Function1<InputParams, Unit>() { // from class: com.tencent.ntcompose.ui.focus.FocusChangedModiferKt$onFocusChanged$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(InputParams inputParams) {
                            invoke2(inputParams);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(InputParams it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            function12.invoke(new d(false));
                        }
                    });
                }
                boolean z17 = event instanceof TextAreaEvent;
                TextAreaEvent textAreaEvent = z17 ? (TextAreaEvent) event : null;
                if (textAreaEvent != null) {
                    final Function1<c, Unit> function13 = onFocusChanged;
                    textAreaEvent.i(new Function1<InputParams, Unit>() { // from class: com.tencent.ntcompose.ui.focus.FocusChangedModiferKt$onFocusChanged$1.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(InputParams inputParams) {
                            invoke2(inputParams);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(InputParams it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            function13.invoke(new d(true));
                        }
                    });
                }
                TextAreaEvent textAreaEvent2 = z17 ? (TextAreaEvent) event : null;
                if (textAreaEvent2 != null) {
                    final Function1<c, Unit> function14 = onFocusChanged;
                    textAreaEvent2.h(new Function1<InputParams, Unit>() { // from class: com.tencent.ntcompose.ui.focus.FocusChangedModiferKt$onFocusChanged$1.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(InputParams inputParams) {
                            invoke2(inputParams);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(InputParams it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            function14.invoke(new d(false));
                        }
                    });
                }
            }
        });
    }
}
