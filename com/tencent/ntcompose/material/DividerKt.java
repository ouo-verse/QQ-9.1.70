package com.tencent.ntcompose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u001aA\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/ntcompose/core/i;", "modifier", "Lcom/tencent/kuikly/core/base/h;", "color", "", "thickness", "startIndent", "endIndent", "", "a", "(Lcom/tencent/ntcompose/core/i;Lcom/tencent/kuikly/core/base/h;FFFLandroidx/compose/runtime/Composer;II)V", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class DividerKt {
    /* JADX WARN: Removed duplicated region for block: B:13:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(com.tencent.ntcompose.core.i iVar, com.tencent.kuikly.core.base.h hVar, float f16, float f17, float f18, Composer composer, final int i3, final int i16) {
        com.tencent.ntcompose.core.i iVar2;
        int i17;
        float f19;
        int i18;
        float f26;
        int i19;
        float f27;
        com.tencent.ntcompose.core.i iVar3;
        com.tencent.kuikly.core.base.h a16;
        float f28;
        float f29;
        float f36;
        int i26;
        com.tencent.ntcompose.core.i iVar4;
        final float f37;
        final float f38;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(95147133);
        int i27 = i16 & 1;
        if (i27 != 0) {
            i17 = i3 | 6;
            iVar2 = iVar;
        } else if ((i3 & 14) == 0) {
            iVar2 = iVar;
            i17 = (startRestartGroup.changed(iVar2) ? 4 : 2) | i3;
        } else {
            iVar2 = iVar;
            i17 = i3;
        }
        int i28 = i16 & 2;
        if (i28 != 0) {
            i17 |= 16;
        }
        int i29 = i16 & 4;
        if (i29 != 0) {
            i17 |= MsgConstant.KRMFILETHUMBSIZE384;
        } else if ((i3 & 896) == 0) {
            f19 = f16;
            i17 |= startRestartGroup.changed(f19) ? 256 : 128;
            i18 = i16 & 8;
            if (i18 == 0) {
                i17 |= 3072;
            } else if ((i3 & 7168) == 0) {
                f26 = f17;
                i17 |= startRestartGroup.changed(f26) ? 2048 : 1024;
                i19 = i16 & 16;
                if (i19 != 0) {
                    i17 |= 24576;
                } else if ((57344 & i3) == 0) {
                    f27 = f18;
                    i17 |= startRestartGroup.changed(f27) ? 16384 : 8192;
                    if (i28 != 2 && (46811 & i17) == 9362 && startRestartGroup.getSkipping()) {
                        startRestartGroup.skipToGroupEnd();
                        a16 = hVar;
                        iVar3 = iVar2;
                        f37 = f26;
                        f38 = f27;
                    } else {
                        startRestartGroup.startDefaults();
                        if ((i3 & 1) == 0 && !startRestartGroup.getDefaultsInvalid()) {
                            startRestartGroup.skipToGroupEnd();
                            a16 = hVar;
                            iVar3 = iVar2;
                        } else {
                            iVar3 = i27 == 0 ? com.tencent.ntcompose.core.i.INSTANCE : iVar2;
                            a16 = i28 == 0 ? com.tencent.kuikly.core.base.h.INSTANCE.a(0.12f) : hVar;
                            if (i29 != 0) {
                                f19 = 0.5f;
                            }
                            if (i18 != 0) {
                                f26 = 0.0f;
                            }
                            if (i19 != 0) {
                                f28 = 0.0f;
                                f29 = f19;
                                f36 = f26;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(95147133, i3, -1, "com.tencent.ntcompose.material.Divider (Divider.kt:19)");
                                }
                                if (!(f36 == 0.0f)) {
                                    i26 = 1;
                                    iVar4 = ComposeLayoutPropUpdaterKt.n(com.tencent.ntcompose.core.i.INSTANCE, f36, 0.0f, f28, 0.0f, 10, null);
                                } else {
                                    i26 = 1;
                                    iVar4 = com.tencent.ntcompose.core.i.INSTANCE;
                                }
                                BoxKt.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(iVar3.b(iVar4), 0.0f, i26, null), f29), a16), null, null, null, startRestartGroup, 0, 14);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                f19 = f29;
                                f37 = f36;
                                f38 = f28;
                            }
                        }
                        f29 = f19;
                        f36 = f26;
                        f28 = f27;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        if (!(f36 == 0.0f)) {
                        }
                        BoxKt.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(iVar3.b(iVar4), 0.0f, i26, null), f29), a16), null, null, null, startRestartGroup, 0, 14);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        f19 = f29;
                        f37 = f36;
                        f38 = f28;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        return;
                    }
                    final com.tencent.ntcompose.core.i iVar5 = iVar3;
                    final com.tencent.kuikly.core.base.h hVar2 = a16;
                    final float f39 = f19;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.DividerKt$Divider$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i36) {
                            DividerKt.a(com.tencent.ntcompose.core.i.this, hVar2, f39, f37, f38, composer2, i3 | 1, i16);
                        }
                    });
                    return;
                }
                f27 = f18;
                if (i28 != 2) {
                }
                startRestartGroup.startDefaults();
                if ((i3 & 1) == 0) {
                }
                if (i27 == 0) {
                }
                if (i28 == 0) {
                }
                if (i29 != 0) {
                }
                if (i18 != 0) {
                }
                if (i19 != 0) {
                }
                f29 = f19;
                f36 = f26;
                f28 = f27;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                if (!(f36 == 0.0f)) {
                }
                BoxKt.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(iVar3.b(iVar4), 0.0f, i26, null), f29), a16), null, null, null, startRestartGroup, 0, 14);
                if (ComposerKt.isTraceInProgress()) {
                }
                f19 = f29;
                f37 = f36;
                f38 = f28;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            f26 = f17;
            i19 = i16 & 16;
            if (i19 != 0) {
            }
            f27 = f18;
            if (i28 != 2) {
            }
            startRestartGroup.startDefaults();
            if ((i3 & 1) == 0) {
            }
            if (i27 == 0) {
            }
            if (i28 == 0) {
            }
            if (i29 != 0) {
            }
            if (i18 != 0) {
            }
            if (i19 != 0) {
            }
            f29 = f19;
            f36 = f26;
            f28 = f27;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            if (!(f36 == 0.0f)) {
            }
            BoxKt.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(iVar3.b(iVar4), 0.0f, i26, null), f29), a16), null, null, null, startRestartGroup, 0, 14);
            if (ComposerKt.isTraceInProgress()) {
            }
            f19 = f29;
            f37 = f36;
            f38 = f28;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        f19 = f16;
        i18 = i16 & 8;
        if (i18 == 0) {
        }
        f26 = f17;
        i19 = i16 & 16;
        if (i19 != 0) {
        }
        f27 = f18;
        if (i28 != 2) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) == 0) {
        }
        if (i27 == 0) {
        }
        if (i28 == 0) {
        }
        if (i29 != 0) {
        }
        if (i18 != 0) {
        }
        if (i19 != 0) {
        }
        f29 = f19;
        f36 = f26;
        f28 = f27;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        if (!(f36 == 0.0f)) {
        }
        BoxKt.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(iVar3.b(iVar4), 0.0f, i26, null), f29), a16), null, null, null, startRestartGroup, 0, 14);
        if (ComposerKt.isTraceInProgress()) {
        }
        f19 = f29;
        f37 = f36;
        f38 = f28;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
