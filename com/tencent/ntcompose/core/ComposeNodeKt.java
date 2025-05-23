package com.tencent.ntcompose.core;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import com.tencent.kuikly.core.base.aa;
import com.tencent.ntcompose.animation.ComposeAnimationManager;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u009c\u0001\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022<\b\u0002\u0010\f\u001a6\u0012\u0002\b\u0003\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\b\u0012\u0002\b\u0003\u0018\u0001`\n\u00a2\u0006\u0002\b\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u001c\b\u0002\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u00112\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0013\u00a2\u0006\u0002\b\u0014H\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017*h\u0010\u0019\u001a\u0004\b\u0000\u0010\u0018\".\u0012\u0004\u0012\u00028\u0000\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004\u00a2\u0006\u0002\b\u000b2.\u0012\u0004\u0012\u00028\u0000\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004\u00a2\u0006\u0002\b\u000b\u00a8\u0006\u001a"}, d2 = {"", "viewType", "Lcom/tencent/ntcompose/core/e;", "creator", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/base/aa;", "Lkotlin/ParameterName;", "name", "viewRef", "", "Lcom/tencent/ntcompose/core/RefFunc;", "Lkotlin/ExtensionFunctionType;", "ref", "Lcom/tencent/ntcompose/core/i;", "modifier", "Ljava/util/ArrayList;", "Lcom/tencent/ntcompose/core/k;", "Lkotlin/collections/ArrayList;", "otherProps", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "content", "a", "(Ljava/lang/String;Lcom/tencent/ntcompose/core/e;Lkotlin/jvm/functions/Function2;Lcom/tencent/ntcompose/core/i;Ljava/util/ArrayList;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "V", "RefFunc", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ComposeNodeKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x006c  */
    /* JADX WARN: Type inference failed for: r6v18, types: [com.tencent.ntcompose.core.i, T] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(final String viewType, final e creator, Function2<?, ? super aa<?>, Unit> function2, i iVar, ArrayList<k> arrayList, Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i3, final int i16) {
        int i17;
        final Function2<?, ? super aa<?>, Unit> function23;
        int i18;
        T t16;
        int i19;
        int i26;
        Function2<? super Composer, ? super Integer, Unit> function24;
        final ArrayList<k> arrayList2;
        d dVar;
        i iVar2;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        Intrinsics.checkNotNullParameter(creator, "creator");
        Composer startRestartGroup = composer.startRestartGroup(1907819256);
        if ((i16 & 1) != 0) {
            i17 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i17 = (startRestartGroup.changed(viewType) ? 4 : 2) | i3;
        } else {
            i17 = i3;
        }
        if ((i16 & 2) != 0) {
            i17 |= 48;
        } else if ((i3 & 112) == 0) {
            i17 |= startRestartGroup.changed(creator) ? 32 : 16;
        }
        int i27 = i16 & 4;
        if (i27 != 0) {
            i17 |= MsgConstant.KRMFILETHUMBSIZE384;
        } else if ((i3 & 896) == 0) {
            function23 = function2;
            i17 |= startRestartGroup.changed(function23) ? 256 : 128;
            i18 = i16 & 8;
            if (i18 == 0) {
                i17 |= 3072;
            } else if ((i3 & 7168) == 0) {
                Object obj = iVar;
                i17 |= startRestartGroup.changed(obj) ? 2048 : 1024;
                t16 = obj;
                i19 = i16 & 16;
                if (i19 != 0) {
                    i17 |= 8192;
                }
                i26 = i16 & 32;
                if (i26 != 0) {
                    i17 |= 196608;
                } else if ((458752 & i3) == 0) {
                    function24 = function22;
                    i17 |= startRestartGroup.changed(function24) ? 131072 : 65536;
                    if (i19 != 16 && (374491 & i17) == 74898 && startRestartGroup.getSkipping()) {
                        startRestartGroup.skipToGroupEnd();
                        arrayList2 = arrayList;
                        iVar2 = t16;
                    } else {
                        if (i27 != 0) {
                            function23 = null;
                        }
                        if (i18 != 0) {
                            t16 = i.INSTANCE;
                        }
                        arrayList2 = i19 == 0 ? null : arrayList;
                        if (i26 != 0) {
                            function24 = null;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1907819256, i17, -1, "com.tencent.ntcompose.core.MakeComposeNode (ComposeNode.kt:24)");
                        }
                        dVar = d.f339209a;
                        if (!dVar.b(viewType)) {
                            dVar.c(viewType, creator);
                        }
                        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                        objectRef.element = t16;
                        if (ComposeAnimationManager.f339152a.d()) {
                            objectRef.element = com.tencent.ntcompose.material.base.ModifiersKt.s((i) objectRef.element);
                        }
                        if (function24 == null) {
                            startRestartGroup.startReplaceableGroup(-1056534604);
                            Function0<ComposeRenderView> function0 = new Function0<ComposeRenderView>() { // from class: com.tencent.ntcompose.core.ComposeNodeKt$MakeComposeNode$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final ComposeRenderView invoke() {
                                    ComposeRenderView a16 = d.f339209a.a(viewType);
                                    Function2<?, aa<?>, Unit> function25 = function23;
                                    Ref.ObjectRef<i> objectRef2 = objectRef;
                                    ArrayList<k> arrayList3 = arrayList2;
                                    a16.j(function25);
                                    a16.h(objectRef2.element);
                                    a16.i(arrayList3);
                                    return a16;
                                }
                            };
                            int i28 = (i17 >> 9) & 896;
                            startRestartGroup.startReplaceableGroup(-548224868);
                            if (!(startRestartGroup.getApplier() instanceof l)) {
                                ComposablesKt.invalidApplier();
                            }
                            startRestartGroup.startNode();
                            if (startRestartGroup.getInserting()) {
                                startRestartGroup.createNode(function0);
                            } else {
                                startRestartGroup.useNode();
                            }
                            Composer m20constructorimpl = Updater.m20constructorimpl(startRestartGroup);
                            Updater.m27setimpl(m20constructorimpl, function23, new Function2<ComposeRenderView, Function2<?, ? super aa<?>, ? extends Unit>, Unit>() { // from class: com.tencent.ntcompose.core.ComposeNodeKt$MakeComposeNode$2$1
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(ComposeRenderView composeRenderView, Function2<?, ? super aa<?>, ? extends Unit> function25) {
                                    invoke2(composeRenderView, (Function2<?, ? super aa<?>, Unit>) function25);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(ComposeRenderView set, Function2<?, ? super aa<?>, Unit> function25) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.m(function25);
                                }
                            });
                            Updater.m27setimpl(m20constructorimpl, objectRef.element, new Function2<ComposeRenderView, i, Unit>() { // from class: com.tencent.ntcompose.core.ComposeNodeKt$MakeComposeNode$2$2
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(ComposeRenderView composeRenderView, i iVar3) {
                                    invoke2(composeRenderView, iVar3);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(ComposeRenderView set, i it) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    set.k(it);
                                }
                            });
                            Updater.m27setimpl(m20constructorimpl, arrayList2, new Function2<ComposeRenderView, ArrayList<k>, Unit>() { // from class: com.tencent.ntcompose.core.ComposeNodeKt$MakeComposeNode$2$3
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(ComposeRenderView composeRenderView, ArrayList<k> arrayList3) {
                                    invoke2(composeRenderView, arrayList3);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(ComposeRenderView set, ArrayList<k> arrayList3) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.l(arrayList3);
                                }
                            });
                            function24.invoke(startRestartGroup, Integer.valueOf((i28 >> 6) & 14));
                            startRestartGroup.endNode();
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.endReplaceableGroup();
                        } else {
                            startRestartGroup.startReplaceableGroup(-1056533911);
                            final Function0<ComposeRenderView> function02 = new Function0<ComposeRenderView>() { // from class: com.tencent.ntcompose.core.ComposeNodeKt$MakeComposeNode$3
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final ComposeRenderView invoke() {
                                    ComposeRenderView a16 = d.f339209a.a(viewType);
                                    Function2<?, aa<?>, Unit> function25 = function23;
                                    Ref.ObjectRef<i> objectRef2 = objectRef;
                                    ArrayList<k> arrayList3 = arrayList2;
                                    a16.j(function25);
                                    a16.h(objectRef2.element);
                                    a16.i(arrayList3);
                                    return a16;
                                }
                            };
                            startRestartGroup.startReplaceableGroup(1886828752);
                            if (!(startRestartGroup.getApplier() instanceof l)) {
                                ComposablesKt.invalidApplier();
                            }
                            startRestartGroup.startNode();
                            if (startRestartGroup.getInserting()) {
                                startRestartGroup.createNode(new Function0<ComposeRenderView>() { // from class: com.tencent.ntcompose.core.ComposeNodeKt$MakeComposeNode$$inlined$ComposeNode$1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Type inference failed for: r0v1, types: [com.tencent.ntcompose.core.ComposeRenderView, java.lang.Object] */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final ComposeRenderView invoke() {
                                        return Function0.this.invoke();
                                    }
                                });
                            } else {
                                startRestartGroup.useNode();
                            }
                            Composer m20constructorimpl2 = Updater.m20constructorimpl(startRestartGroup);
                            Updater.m27setimpl(m20constructorimpl2, function23, new Function2<ComposeRenderView, Function2<?, ? super aa<?>, ? extends Unit>, Unit>() { // from class: com.tencent.ntcompose.core.ComposeNodeKt$MakeComposeNode$4$1
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(ComposeRenderView composeRenderView, Function2<?, ? super aa<?>, ? extends Unit> function25) {
                                    invoke2(composeRenderView, (Function2<?, ? super aa<?>, Unit>) function25);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(ComposeRenderView set, Function2<?, ? super aa<?>, Unit> function25) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.m(function25);
                                }
                            });
                            Updater.m27setimpl(m20constructorimpl2, objectRef.element, new Function2<ComposeRenderView, i, Unit>() { // from class: com.tencent.ntcompose.core.ComposeNodeKt$MakeComposeNode$4$2
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(ComposeRenderView composeRenderView, i iVar3) {
                                    invoke2(composeRenderView, iVar3);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(ComposeRenderView set, i it) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    set.k(it);
                                }
                            });
                            Updater.m27setimpl(m20constructorimpl2, arrayList2, new Function2<ComposeRenderView, ArrayList<k>, Unit>() { // from class: com.tencent.ntcompose.core.ComposeNodeKt$MakeComposeNode$4$3
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(ComposeRenderView composeRenderView, ArrayList<k> arrayList3) {
                                    invoke2(composeRenderView, arrayList3);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(ComposeRenderView set, ArrayList<k> arrayList3) {
                                    Intrinsics.checkNotNullParameter(set, "$this$set");
                                    set.l(arrayList3);
                                }
                            });
                            startRestartGroup.endNode();
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.endReplaceableGroup();
                        }
                        iVar2 = t16;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            iVar2 = t16;
                        }
                    }
                    final i iVar3 = iVar2;
                    final Function2<? super Composer, ? super Integer, Unit> function25 = function24;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        return;
                    }
                    final Function2<?, ? super aa<?>, Unit> function26 = function23;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.core.ComposeNodeKt$MakeComposeNode$5
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i29) {
                            ComposeNodeKt.a(viewType, creator, function26, iVar3, arrayList2, function25, composer2, i3 | 1, i16);
                        }
                    });
                    return;
                }
                function24 = function22;
                if (i19 != 16) {
                }
                if (i27 != 0) {
                }
                if (i18 != 0) {
                }
                if (i19 == 0) {
                }
                if (i26 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                dVar = d.f339209a;
                if (!dVar.b(viewType)) {
                }
                final Ref.ObjectRef<i> objectRef2 = new Ref.ObjectRef();
                objectRef2.element = t16;
                if (ComposeAnimationManager.f339152a.d()) {
                }
                if (function24 == null) {
                }
                iVar2 = t16;
                if (ComposerKt.isTraceInProgress()) {
                }
                final i iVar32 = iVar2;
                final Function2<? super Composer, ? super Integer, Unit> function252 = function24;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            t16 = iVar;
            i19 = i16 & 16;
            if (i19 != 0) {
            }
            i26 = i16 & 32;
            if (i26 != 0) {
            }
            function24 = function22;
            if (i19 != 16) {
            }
            if (i27 != 0) {
            }
            if (i18 != 0) {
            }
            if (i19 == 0) {
            }
            if (i26 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            dVar = d.f339209a;
            if (!dVar.b(viewType)) {
            }
            final Ref.ObjectRef<i> objectRef22 = new Ref.ObjectRef();
            objectRef22.element = t16;
            if (ComposeAnimationManager.f339152a.d()) {
            }
            if (function24 == null) {
            }
            iVar2 = t16;
            if (ComposerKt.isTraceInProgress()) {
            }
            final i iVar322 = iVar2;
            final Function2<? super Composer, ? super Integer, Unit> function2522 = function24;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        function23 = function2;
        i18 = i16 & 8;
        if (i18 == 0) {
        }
        t16 = iVar;
        i19 = i16 & 16;
        if (i19 != 0) {
        }
        i26 = i16 & 32;
        if (i26 != 0) {
        }
        function24 = function22;
        if (i19 != 16) {
        }
        if (i27 != 0) {
        }
        if (i18 != 0) {
        }
        if (i19 == 0) {
        }
        if (i26 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        dVar = d.f339209a;
        if (!dVar.b(viewType)) {
        }
        final Ref.ObjectRef<i> objectRef222 = new Ref.ObjectRef();
        objectRef222.element = t16;
        if (ComposeAnimationManager.f339152a.d()) {
        }
        if (function24 == null) {
        }
        iVar2 = t16;
        if (ComposerKt.isTraceInProgress()) {
        }
        final i iVar3222 = iVar2;
        final Function2<? super Composer, ? super Integer, Unit> function25222 = function24;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
