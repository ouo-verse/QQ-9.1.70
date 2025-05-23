package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.hippykotlin.demo.pages.base.view.QQComposeMarkdownView;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.QQComposeViewExtCreator;
import com.tencent.kuikly.core.base.aa;
import com.tencent.ntcompose.core.ComposeNodeKt;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.core.k;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QQComposeMarkdownKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void QQComposeMarkdown(i iVar, Function2<? super QQComposeMarkdownView, ? super aa<QQComposeMarkdownView>, Unit> function2, String str, int i3, float f16, Composer composer, final int i16, final int i17) {
        Function2<? super QQComposeMarkdownView, ? super aa<QQComposeMarkdownView>, Unit> function22;
        int i18;
        String str2;
        int i19;
        int i26;
        int i27;
        float f17;
        i iVar2;
        final String str3;
        final int i28;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1053629790);
        int i29 = i17 & 1;
        int i36 = i29 != 0 ? i16 | 2 : i16;
        int i37 = i17 & 2;
        if (i37 != 0) {
            i36 |= 48;
        } else if ((i16 & 112) == 0) {
            function22 = function2;
            i36 |= startRestartGroup.changed(function22) ? 32 : 16;
            i18 = i17 & 4;
            if (i18 == 0) {
                i36 |= MsgConstant.KRMFILETHUMBSIZE384;
            } else if ((i16 & 896) == 0) {
                str2 = str;
                i36 |= startRestartGroup.changed(str2) ? 256 : 128;
                i19 = i17 & 8;
                if (i19 != 0) {
                    i36 |= 3072;
                } else if ((i16 & 7168) == 0) {
                    i26 = i3;
                    i36 |= startRestartGroup.changed(i26) ? 2048 : 1024;
                    i27 = i17 & 16;
                    if (i27 == 0) {
                        i36 |= 24576;
                    } else if ((57344 & i16) == 0) {
                        f17 = f16;
                        i36 |= startRestartGroup.changed(f17) ? 16384 : 8192;
                        if (i29 != 1 && (i36 & 46811) == 9362 && startRestartGroup.getSkipping()) {
                            startRestartGroup.skipToGroupEnd();
                            iVar2 = iVar;
                            str3 = str2;
                            i28 = i26;
                        } else {
                            iVar2 = i29 != 0 ? i.INSTANCE : iVar;
                            if (i37 != 0) {
                                function22 = null;
                            }
                            String str4 = i18 != 0 ? "" : str2;
                            int i38 = i19 != 0 ? Integer.MAX_VALUE : i26;
                            float f18 = i27 != 0 ? 4.0f : f17;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1053629790, i16, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQComposeMarkdown (QQComposeMarkdown.kt:33)");
                            }
                            ArrayList arrayList = new ArrayList();
                            QQComposeMarkdownPropUpdater qQComposeMarkdownPropUpdater = QQComposeMarkdownPropUpdater.INSTANCE;
                            arrayList.add(new k("markdown", str4, null, null, null, null, qQComposeMarkdownPropUpdater, 60, null));
                            arrayList.add(new k("maxLines", Integer.valueOf(i38), null, null, null, null, qQComposeMarkdownPropUpdater, 60, null));
                            arrayList.add(new k("paragraphSpacing", Float.valueOf(f18), null, null, null, null, qQComposeMarkdownPropUpdater, 60, null));
                            ComposeNodeKt.a("QQComposeMarkdownView", QQComposeViewExtCreator.INSTANCE, function22 == null ? null : function22, iVar2, arrayList, null, startRestartGroup, 36918, 32);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            str3 = str4;
                            i28 = i38;
                            f17 = f18;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                            return;
                        }
                        final i iVar3 = iVar2;
                        final Function2<? super QQComposeMarkdownView, ? super aa<QQComposeMarkdownView>, Unit> function23 = function22;
                        final float f19 = f17;
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQComposeMarkdownKt$QQComposeMarkdown$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(Composer composer2, Integer num) {
                                num.intValue();
                                QQComposeMarkdownKt.QQComposeMarkdown(i.this, function23, str3, i28, f19, composer2, i16 | 1, i17);
                                return Unit.INSTANCE;
                            }
                        });
                        return;
                    }
                    f17 = f16;
                    if (i29 != 1) {
                    }
                    if (i29 != 0) {
                    }
                    if (i37 != 0) {
                    }
                    if (i18 != 0) {
                    }
                    if (i19 != 0) {
                    }
                    if (i27 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ArrayList arrayList2 = new ArrayList();
                    QQComposeMarkdownPropUpdater qQComposeMarkdownPropUpdater2 = QQComposeMarkdownPropUpdater.INSTANCE;
                    arrayList2.add(new k("markdown", str4, null, null, null, null, qQComposeMarkdownPropUpdater2, 60, null));
                    arrayList2.add(new k("maxLines", Integer.valueOf(i38), null, null, null, null, qQComposeMarkdownPropUpdater2, 60, null));
                    arrayList2.add(new k("paragraphSpacing", Float.valueOf(f18), null, null, null, null, qQComposeMarkdownPropUpdater2, 60, null));
                    ComposeNodeKt.a("QQComposeMarkdownView", QQComposeViewExtCreator.INSTANCE, function22 == null ? null : function22, iVar2, arrayList2, null, startRestartGroup, 36918, 32);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    str3 = str4;
                    i28 = i38;
                    f17 = f18;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i26 = i3;
                i27 = i17 & 16;
                if (i27 == 0) {
                }
                f17 = f16;
                if (i29 != 1) {
                }
                if (i29 != 0) {
                }
                if (i37 != 0) {
                }
                if (i18 != 0) {
                }
                if (i19 != 0) {
                }
                if (i27 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                ArrayList arrayList22 = new ArrayList();
                QQComposeMarkdownPropUpdater qQComposeMarkdownPropUpdater22 = QQComposeMarkdownPropUpdater.INSTANCE;
                arrayList22.add(new k("markdown", str4, null, null, null, null, qQComposeMarkdownPropUpdater22, 60, null));
                arrayList22.add(new k("maxLines", Integer.valueOf(i38), null, null, null, null, qQComposeMarkdownPropUpdater22, 60, null));
                arrayList22.add(new k("paragraphSpacing", Float.valueOf(f18), null, null, null, null, qQComposeMarkdownPropUpdater22, 60, null));
                ComposeNodeKt.a("QQComposeMarkdownView", QQComposeViewExtCreator.INSTANCE, function22 == null ? null : function22, iVar2, arrayList22, null, startRestartGroup, 36918, 32);
                if (ComposerKt.isTraceInProgress()) {
                }
                str3 = str4;
                i28 = i38;
                f17 = f18;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            str2 = str;
            i19 = i17 & 8;
            if (i19 != 0) {
            }
            i26 = i3;
            i27 = i17 & 16;
            if (i27 == 0) {
            }
            f17 = f16;
            if (i29 != 1) {
            }
            if (i29 != 0) {
            }
            if (i37 != 0) {
            }
            if (i18 != 0) {
            }
            if (i19 != 0) {
            }
            if (i27 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            ArrayList arrayList222 = new ArrayList();
            QQComposeMarkdownPropUpdater qQComposeMarkdownPropUpdater222 = QQComposeMarkdownPropUpdater.INSTANCE;
            arrayList222.add(new k("markdown", str4, null, null, null, null, qQComposeMarkdownPropUpdater222, 60, null));
            arrayList222.add(new k("maxLines", Integer.valueOf(i38), null, null, null, null, qQComposeMarkdownPropUpdater222, 60, null));
            arrayList222.add(new k("paragraphSpacing", Float.valueOf(f18), null, null, null, null, qQComposeMarkdownPropUpdater222, 60, null));
            ComposeNodeKt.a("QQComposeMarkdownView", QQComposeViewExtCreator.INSTANCE, function22 == null ? null : function22, iVar2, arrayList222, null, startRestartGroup, 36918, 32);
            if (ComposerKt.isTraceInProgress()) {
            }
            str3 = str4;
            i28 = i38;
            f17 = f18;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        function22 = function2;
        i18 = i17 & 4;
        if (i18 == 0) {
        }
        str2 = str;
        i19 = i17 & 8;
        if (i19 != 0) {
        }
        i26 = i3;
        i27 = i17 & 16;
        if (i27 == 0) {
        }
        f17 = f16;
        if (i29 != 1) {
        }
        if (i29 != 0) {
        }
        if (i37 != 0) {
        }
        if (i18 != 0) {
        }
        if (i19 != 0) {
        }
        if (i27 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        ArrayList arrayList2222 = new ArrayList();
        QQComposeMarkdownPropUpdater qQComposeMarkdownPropUpdater2222 = QQComposeMarkdownPropUpdater.INSTANCE;
        arrayList2222.add(new k("markdown", str4, null, null, null, null, qQComposeMarkdownPropUpdater2222, 60, null));
        arrayList2222.add(new k("maxLines", Integer.valueOf(i38), null, null, null, null, qQComposeMarkdownPropUpdater2222, 60, null));
        arrayList2222.add(new k("paragraphSpacing", Float.valueOf(f18), null, null, null, null, qQComposeMarkdownPropUpdater2222, 60, null));
        ComposeNodeKt.a("QQComposeMarkdownView", QQComposeViewExtCreator.INSTANCE, function22 == null ? null : function22, iVar2, arrayList2222, null, startRestartGroup, 36918, 32);
        if (ComposerKt.isTraceInProgress()) {
        }
        str3 = str4;
        i28 = i38;
        f17 = f18;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
