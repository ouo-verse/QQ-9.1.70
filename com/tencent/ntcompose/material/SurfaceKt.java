package com.tencent.ntcompose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aN\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\b\tH\u0007\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ntcompose/core/i;", "modifier", "Lzo3/g;", "shape", "Lcom/tencent/kuikly/core/base/h;", "color", "contentColor", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "content", "a", "(Lcom/tencent/ntcompose/core/i;Lzo3/g;Lcom/tencent/kuikly/core/base/h;Lcom/tencent/kuikly/core/base/h;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class SurfaceKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(com.tencent.ntcompose.core.i iVar, zo3.g gVar, com.tencent.kuikly.core.base.h hVar, com.tencent.kuikly.core.base.h hVar2, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i3, final int i16) {
        com.tencent.ntcompose.core.i iVar2;
        int i17;
        zo3.g gVar2;
        int i18;
        int i19;
        com.tencent.kuikly.core.base.h hVar3;
        com.tencent.kuikly.core.base.h hVar4;
        com.tencent.ntcompose.core.i iVar3;
        com.tencent.kuikly.core.base.h hVar5;
        final Ref.BooleanRef booleanRef;
        final Ref.BooleanRef booleanRef2;
        final com.tencent.ntcompose.core.i iVar4;
        final zo3.g gVar3;
        final com.tencent.kuikly.core.base.h hVar6;
        final com.tencent.kuikly.core.base.h hVar7;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(-1964383267);
        int i26 = i16 & 1;
        if (i26 != 0) {
            i17 = i3 | 6;
            iVar2 = iVar;
        } else if ((i3 & 14) == 0) {
            iVar2 = iVar;
            i17 = i3 | (startRestartGroup.changed(iVar) ? 4 : 2);
        } else {
            iVar2 = iVar;
            i17 = i3;
        }
        int i27 = i16 & 2;
        if (i27 != 0) {
            i17 |= 48;
        } else if ((i3 & 112) == 0) {
            gVar2 = gVar;
            i17 |= startRestartGroup.changed(gVar) ? 32 : 16;
            i18 = i16 & 4;
            if (i18 != 0) {
                i17 |= 128;
            }
            i19 = i16 & 8;
            if (i19 != 0) {
                i17 |= 1024;
            }
            if ((i16 & 16) == 0) {
                i17 |= 24576;
            } else if ((i3 & 57344) == 0) {
                i17 |= startRestartGroup.changed(content) ? 16384 : 8192;
            }
            if ((i16 & 12) != 12 && (46811 & i17) == 9362 && startRestartGroup.getSkipping()) {
                startRestartGroup.skipToGroupEnd();
                hVar6 = hVar;
                hVar7 = hVar2;
                iVar4 = iVar2;
                gVar3 = gVar2;
            } else {
                startRestartGroup.startDefaults();
                if ((i3 & 1) == 0 && !startRestartGroup.getDefaultsInvalid()) {
                    startRestartGroup.skipToGroupEnd();
                    if (i18 != 0) {
                        i17 &= -897;
                    }
                    hVar5 = hVar;
                    hVar4 = hVar2;
                    iVar3 = iVar2;
                } else {
                    com.tencent.ntcompose.core.i iVar5 = i26 == 0 ? com.tencent.ntcompose.core.i.INSTANCE : iVar2;
                    if (i27 != 0) {
                        gVar2 = null;
                    }
                    if (i18 == 0) {
                        hVar3 = com.tencent.kuikly.core.base.h.INSTANCE.n();
                        i17 &= -897;
                    } else {
                        hVar3 = hVar;
                    }
                    if (i19 == 0) {
                        iVar3 = iVar5;
                        hVar4 = null;
                    } else {
                        hVar4 = hVar2;
                        iVar3 = iVar5;
                    }
                    hVar5 = hVar3;
                }
                zo3.g gVar4 = gVar2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1964383267, i17, -1, "com.tencent.ntcompose.material.Surface (Surface.kt:44)");
                }
                com.tencent.ntcompose.core.i q16 = gVar4 == null ? ModifiersKt.q(iVar3, gVar4) : iVar3;
                booleanRef = new Ref.BooleanRef();
                booleanRef2 = new Ref.BooleanRef();
                q16.a(Unit.INSTANCE, new Function2<i.c, Unit, Unit>() { // from class: com.tencent.ntcompose.material.SurfaceKt$Surface$2
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

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(i.c mod, Unit unit) {
                        Intrinsics.checkNotNullParameter(mod, "mod");
                        Intrinsics.checkNotNullParameter(unit, "<anonymous parameter 1>");
                        boolean z16 = mod instanceof com.tencent.ntcompose.core.k;
                        if (z16) {
                            com.tencent.ntcompose.core.k kVar = (com.tencent.ntcompose.core.k) mod;
                            if (Intrinsics.areEqual(kVar.getPropKey(), "height") || Intrinsics.areEqual(kVar.getPropKey(), "size") || Intrinsics.areEqual(kVar.getPropKey(), "heightIn") || Intrinsics.areEqual(kVar.getPropKey(), "fill_max_size") || Intrinsics.areEqual(kVar.getPropKey(), "fill_max_height") || Intrinsics.areEqual(kVar.getPropKey(), "sizeIn") || Intrinsics.areEqual(kVar.getPropKey(), "wrap_content_height") || Intrinsics.areEqual(kVar.getPropKey(), "wrap_content_size")) {
                                Ref.BooleanRef.this.element = true;
                                return;
                            }
                        }
                        if (z16 && Intrinsics.areEqual(((com.tencent.ntcompose.core.k) mod).getPropKey(), "background")) {
                            booleanRef2.element = true;
                        }
                    }
                });
                if (!booleanRef.element) {
                    q16 = com.tencent.ntcompose.foundation.layout.o.f339291a.a(q16, 1.0f);
                }
                if (!booleanRef2.element) {
                    q16 = ModifiersKt.c(q16, hVar4 == null ? hVar5 : hVar4);
                }
                ViewKt.a(null, q16, content, startRestartGroup, (i17 >> 6) & 896, 1);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                iVar4 = iVar3;
                gVar3 = gVar4;
                hVar6 = hVar5;
                hVar7 = hVar4;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                return;
            }
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.SurfaceKt$Surface$3
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

                public final void invoke(Composer composer2, int i28) {
                    SurfaceKt.a(com.tencent.ntcompose.core.i.this, gVar3, hVar6, hVar7, content, composer2, i3 | 1, i16);
                }
            });
            return;
        }
        gVar2 = gVar;
        i18 = i16 & 4;
        if (i18 != 0) {
        }
        i19 = i16 & 8;
        if (i19 != 0) {
        }
        if ((i16 & 16) == 0) {
        }
        if ((i16 & 12) != 12) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) == 0) {
        }
        if (i26 == 0) {
        }
        if (i27 != 0) {
        }
        if (i18 == 0) {
        }
        if (i19 == 0) {
        }
        hVar5 = hVar3;
        zo3.g gVar42 = gVar2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        if (gVar42 == null) {
        }
        booleanRef = new Ref.BooleanRef();
        booleanRef2 = new Ref.BooleanRef();
        q16.a(Unit.INSTANCE, new Function2<i.c, Unit, Unit>() { // from class: com.tencent.ntcompose.material.SurfaceKt$Surface$2
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

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(i.c mod, Unit unit) {
                Intrinsics.checkNotNullParameter(mod, "mod");
                Intrinsics.checkNotNullParameter(unit, "<anonymous parameter 1>");
                boolean z16 = mod instanceof com.tencent.ntcompose.core.k;
                if (z16) {
                    com.tencent.ntcompose.core.k kVar = (com.tencent.ntcompose.core.k) mod;
                    if (Intrinsics.areEqual(kVar.getPropKey(), "height") || Intrinsics.areEqual(kVar.getPropKey(), "size") || Intrinsics.areEqual(kVar.getPropKey(), "heightIn") || Intrinsics.areEqual(kVar.getPropKey(), "fill_max_size") || Intrinsics.areEqual(kVar.getPropKey(), "fill_max_height") || Intrinsics.areEqual(kVar.getPropKey(), "sizeIn") || Intrinsics.areEqual(kVar.getPropKey(), "wrap_content_height") || Intrinsics.areEqual(kVar.getPropKey(), "wrap_content_size")) {
                        Ref.BooleanRef.this.element = true;
                        return;
                    }
                }
                if (z16 && Intrinsics.areEqual(((com.tencent.ntcompose.core.k) mod).getPropKey(), "background")) {
                    booleanRef2.element = true;
                }
            }
        });
        if (!booleanRef.element) {
        }
        if (!booleanRef2.element) {
        }
        ViewKt.a(null, q16, content, startRestartGroup, (i17 >> 6) & 896, 1);
        if (ComposerKt.isTraceInProgress()) {
        }
        iVar4 = iVar3;
        gVar3 = gVar42;
        hVar6 = hVar5;
        hVar7 = hVar4;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
