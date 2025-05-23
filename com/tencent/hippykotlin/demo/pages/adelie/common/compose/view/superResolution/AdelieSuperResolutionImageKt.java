package com.tencent.hippykotlin.demo.pages.adelie.common.compose.view.superResolution;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.AdelieSuperResolutionImageView;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.views.LoadSuccessParams;
import com.tencent.ntcompose.core.ComposeNodeKt;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.core.k;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdelieSuperResolutionImageKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AdelieSuperResolutionImage(i iVar, Function2<? super AdelieSuperResolutionImageView, ? super aa<AdelieSuperResolutionImageView>, Unit> function2, String str, Function1<? super LoadSuccessParams, Unit> function1, Function1<? super LoadSuccessParams, Unit> function12, Function1<? super LoadFailParams, Unit> function13, Composer composer, final int i3, final int i16) {
        Function2<? super AdelieSuperResolutionImageView, ? super aa<AdelieSuperResolutionImageView>, Unit> function22;
        int i17;
        String str2;
        int i18;
        Function1<? super LoadSuccessParams, Unit> function14;
        int i19;
        Function1<? super LoadSuccessParams, Unit> function15;
        int i26;
        Function1<? super LoadFailParams, Unit> function16;
        i iVar2;
        Function1<? super LoadSuccessParams, Unit> function17;
        Function1<? super LoadSuccessParams, Unit> function18;
        Function1<? super LoadFailParams, Unit> function19;
        final String str3;
        final Function1<? super LoadSuccessParams, Unit> function110;
        final Function1<? super LoadFailParams, Unit> function111;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1700536478);
        int i27 = i16 & 1;
        int i28 = i27 != 0 ? i3 | 2 : i3;
        int i29 = i16 & 2;
        if (i29 != 0) {
            i28 |= 48;
        } else if ((i3 & 112) == 0) {
            function22 = function2;
            i28 |= startRestartGroup.changed(function22) ? 32 : 16;
            i17 = i16 & 4;
            if (i17 == 0) {
                i28 |= MsgConstant.KRMFILETHUMBSIZE384;
            } else if ((i3 & 896) == 0) {
                str2 = str;
                i28 |= startRestartGroup.changed(str2) ? 256 : 128;
                i18 = i16 & 8;
                if (i18 != 0) {
                    i28 |= 3072;
                } else if ((i3 & 7168) == 0) {
                    function14 = function1;
                    i28 |= startRestartGroup.changed(function14) ? 2048 : 1024;
                    i19 = i16 & 16;
                    if (i19 == 0) {
                        i28 |= 24576;
                    } else if ((57344 & i3) == 0) {
                        function15 = function12;
                        i28 |= startRestartGroup.changed(function15) ? 16384 : 8192;
                        i26 = i16 & 32;
                        if (i26 != 0) {
                            i28 |= 196608;
                        } else if ((458752 & i3) == 0) {
                            function16 = function13;
                            i28 |= startRestartGroup.changed(function16) ? 131072 : 65536;
                            if (i27 != 1 && (i28 & 374491) == 74898 && startRestartGroup.getSkipping()) {
                                startRestartGroup.skipToGroupEnd();
                                iVar2 = iVar;
                                str3 = str2;
                                function110 = function14;
                                function18 = function15;
                                function111 = function16;
                            } else {
                                iVar2 = i27 == 0 ? i.INSTANCE : iVar;
                                if (i29 != 0) {
                                    function22 = null;
                                }
                                String str4 = i17 == 0 ? null : str2;
                                function17 = i18 == 0 ? null : function14;
                                function18 = i19 == 0 ? null : function15;
                                function19 = i26 == 0 ? null : function16;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1700536478, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.common.compose.view.superResolution.AdelieSuperResolutionImage (AdelieSuperResolutionImage.kt:26)");
                                }
                                ArrayList arrayList = new ArrayList();
                                AdelieSuperResolutionPropUpdater adelieSuperResolutionPropUpdater = AdelieSuperResolutionPropUpdater.INSTANCE;
                                arrayList.add(new k("src", str4, null, null, null, null, adelieSuperResolutionPropUpdater, 60, null));
                                if (function17 != null) {
                                    arrayList.add(new k("loadSuccess", function17, null, null, null, null, adelieSuperResolutionPropUpdater, 60, null));
                                }
                                if (function18 != null) {
                                    arrayList.add(new k("loadSuperResolutionSuccess", function18, null, null, null, null, adelieSuperResolutionPropUpdater, 60, null));
                                }
                                if (function19 != null) {
                                    arrayList.add(new k("loadFail", function19, null, null, null, null, adelieSuperResolutionPropUpdater, 60, null));
                                }
                                ComposeNodeKt.a("SuperResolutionImage", AdelieSuperResolutionImageViewCreator.INSTANCE, function22 != null ? null : function22, iVar2, arrayList, null, startRestartGroup, 36918, 32);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                str3 = str4;
                                function110 = function17;
                                function111 = function19;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup != null) {
                                return;
                            }
                            final i iVar3 = iVar2;
                            final Function2<? super AdelieSuperResolutionImageView, ? super aa<AdelieSuperResolutionImageView>, Unit> function23 = function22;
                            final Function1<? super LoadSuccessParams, Unit> function112 = function18;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.compose.view.superResolution.AdelieSuperResolutionImageKt$AdelieSuperResolutionImage$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Unit invoke(Composer composer2, Integer num) {
                                    num.intValue();
                                    AdelieSuperResolutionImageKt.AdelieSuperResolutionImage(i.this, function23, str3, function110, function112, function111, composer2, i3 | 1, i16);
                                    return Unit.INSTANCE;
                                }
                            });
                            return;
                        }
                        function16 = function13;
                        if (i27 != 1) {
                        }
                        if (i27 == 0) {
                        }
                        if (i29 != 0) {
                        }
                        if (i17 == 0) {
                        }
                        if (i18 == 0) {
                        }
                        if (i19 == 0) {
                        }
                        if (i26 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ArrayList arrayList2 = new ArrayList();
                        AdelieSuperResolutionPropUpdater adelieSuperResolutionPropUpdater2 = AdelieSuperResolutionPropUpdater.INSTANCE;
                        arrayList2.add(new k("src", str4, null, null, null, null, adelieSuperResolutionPropUpdater2, 60, null));
                        if (function17 != null) {
                        }
                        if (function18 != null) {
                        }
                        if (function19 != null) {
                        }
                        ComposeNodeKt.a("SuperResolutionImage", AdelieSuperResolutionImageViewCreator.INSTANCE, function22 != null ? null : function22, iVar2, arrayList2, null, startRestartGroup, 36918, 32);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        str3 = str4;
                        function110 = function17;
                        function111 = function19;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    function15 = function12;
                    i26 = i16 & 32;
                    if (i26 != 0) {
                    }
                    function16 = function13;
                    if (i27 != 1) {
                    }
                    if (i27 == 0) {
                    }
                    if (i29 != 0) {
                    }
                    if (i17 == 0) {
                    }
                    if (i18 == 0) {
                    }
                    if (i19 == 0) {
                    }
                    if (i26 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ArrayList arrayList22 = new ArrayList();
                    AdelieSuperResolutionPropUpdater adelieSuperResolutionPropUpdater22 = AdelieSuperResolutionPropUpdater.INSTANCE;
                    arrayList22.add(new k("src", str4, null, null, null, null, adelieSuperResolutionPropUpdater22, 60, null));
                    if (function17 != null) {
                    }
                    if (function18 != null) {
                    }
                    if (function19 != null) {
                    }
                    ComposeNodeKt.a("SuperResolutionImage", AdelieSuperResolutionImageViewCreator.INSTANCE, function22 != null ? null : function22, iVar2, arrayList22, null, startRestartGroup, 36918, 32);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    str3 = str4;
                    function110 = function17;
                    function111 = function19;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function14 = function1;
                i19 = i16 & 16;
                if (i19 == 0) {
                }
                function15 = function12;
                i26 = i16 & 32;
                if (i26 != 0) {
                }
                function16 = function13;
                if (i27 != 1) {
                }
                if (i27 == 0) {
                }
                if (i29 != 0) {
                }
                if (i17 == 0) {
                }
                if (i18 == 0) {
                }
                if (i19 == 0) {
                }
                if (i26 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                ArrayList arrayList222 = new ArrayList();
                AdelieSuperResolutionPropUpdater adelieSuperResolutionPropUpdater222 = AdelieSuperResolutionPropUpdater.INSTANCE;
                arrayList222.add(new k("src", str4, null, null, null, null, adelieSuperResolutionPropUpdater222, 60, null));
                if (function17 != null) {
                }
                if (function18 != null) {
                }
                if (function19 != null) {
                }
                ComposeNodeKt.a("SuperResolutionImage", AdelieSuperResolutionImageViewCreator.INSTANCE, function22 != null ? null : function22, iVar2, arrayList222, null, startRestartGroup, 36918, 32);
                if (ComposerKt.isTraceInProgress()) {
                }
                str3 = str4;
                function110 = function17;
                function111 = function19;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            str2 = str;
            i18 = i16 & 8;
            if (i18 != 0) {
            }
            function14 = function1;
            i19 = i16 & 16;
            if (i19 == 0) {
            }
            function15 = function12;
            i26 = i16 & 32;
            if (i26 != 0) {
            }
            function16 = function13;
            if (i27 != 1) {
            }
            if (i27 == 0) {
            }
            if (i29 != 0) {
            }
            if (i17 == 0) {
            }
            if (i18 == 0) {
            }
            if (i19 == 0) {
            }
            if (i26 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            ArrayList arrayList2222 = new ArrayList();
            AdelieSuperResolutionPropUpdater adelieSuperResolutionPropUpdater2222 = AdelieSuperResolutionPropUpdater.INSTANCE;
            arrayList2222.add(new k("src", str4, null, null, null, null, adelieSuperResolutionPropUpdater2222, 60, null));
            if (function17 != null) {
            }
            if (function18 != null) {
            }
            if (function19 != null) {
            }
            ComposeNodeKt.a("SuperResolutionImage", AdelieSuperResolutionImageViewCreator.INSTANCE, function22 != null ? null : function22, iVar2, arrayList2222, null, startRestartGroup, 36918, 32);
            if (ComposerKt.isTraceInProgress()) {
            }
            str3 = str4;
            function110 = function17;
            function111 = function19;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        function22 = function2;
        i17 = i16 & 4;
        if (i17 == 0) {
        }
        str2 = str;
        i18 = i16 & 8;
        if (i18 != 0) {
        }
        function14 = function1;
        i19 = i16 & 16;
        if (i19 == 0) {
        }
        function15 = function12;
        i26 = i16 & 32;
        if (i26 != 0) {
        }
        function16 = function13;
        if (i27 != 1) {
        }
        if (i27 == 0) {
        }
        if (i29 != 0) {
        }
        if (i17 == 0) {
        }
        if (i18 == 0) {
        }
        if (i19 == 0) {
        }
        if (i26 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        ArrayList arrayList22222 = new ArrayList();
        AdelieSuperResolutionPropUpdater adelieSuperResolutionPropUpdater22222 = AdelieSuperResolutionPropUpdater.INSTANCE;
        arrayList22222.add(new k("src", str4, null, null, null, null, adelieSuperResolutionPropUpdater22222, 60, null));
        if (function17 != null) {
        }
        if (function18 != null) {
        }
        if (function19 != null) {
        }
        ComposeNodeKt.a("SuperResolutionImage", AdelieSuperResolutionImageViewCreator.INSTANCE, function22 != null ? null : function22, iVar2, arrayList22222, null, startRestartGroup, 36918, 32);
        if (ComposerKt.isTraceInProgress()) {
        }
        str3 = str4;
        function110 = function17;
        function111 = function19;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
