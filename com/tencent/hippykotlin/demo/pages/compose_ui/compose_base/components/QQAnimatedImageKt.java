package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.material.APNGKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.LottieKt;
import com.tencent.ntcompose.material.PAGKt;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.ntcompose.ui.platform.a;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import cooperation.photoplus.sticker.Sticker;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QQAnimatedImageKt {
    /* JADX WARN: Removed duplicated region for block: B:13:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void QQAnimatedImage(final String str, i iVar, boolean z16, Integer num, Composer composer, final int i3, final int i16) {
        int i17;
        boolean z17;
        int i18;
        Integer num2;
        i iVar2;
        boolean z18;
        List split$default;
        Object first;
        final boolean z19;
        final Integer num3;
        boolean endsWith$default;
        boolean endsWith$default2;
        boolean endsWith$default3;
        boolean endsWith$default4;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1712917966);
        if ((i16 & 1) != 0) {
            i17 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i17 = (startRestartGroup.changed(str) ? 4 : 2) | i3;
        } else {
            i17 = i3;
        }
        int i19 = i16 & 2;
        if (i19 != 0) {
            i17 |= 16;
        }
        int i26 = i16 & 4;
        if (i26 != 0) {
            i17 |= MsgConstant.KRMFILETHUMBSIZE384;
        } else if ((i3 & 896) == 0) {
            z17 = z16;
            i17 |= startRestartGroup.changed(z17) ? 256 : 128;
            i18 = i16 & 8;
            if (i18 == 0) {
                i17 |= 3072;
            } else if ((i3 & 7168) == 0) {
                num2 = num;
                i17 |= startRestartGroup.changed(num2) ? 2048 : 1024;
                if (i19 != 2 && (i17 & 5851) == 1170 && startRestartGroup.getSkipping()) {
                    startRestartGroup.skipToGroupEnd();
                    iVar2 = iVar;
                    z19 = z17;
                    num3 = num2;
                } else {
                    iVar2 = i19 != 0 ? i.INSTANCE : iVar;
                    z18 = i26 != 0 ? false : z17;
                    Integer num4 = i18 != 0 ? null : num2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1712917966, i17, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQAnimatedImage (QQAnimatedImage.kt:18)");
                    }
                    split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER}, false, 0, 6, (Object) null);
                    first = CollectionsKt___CollectionsKt.first((List<? extends Object>) split$default);
                    String str2 = (String) first;
                    if (!z18) {
                        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str2, ".apng", false, 2, null);
                        if (!endsWith$default) {
                            endsWith$default2 = StringsKt__StringsJVMKt.endsWith$default(str2, ".webp", false, 2, null);
                            if (!endsWith$default2) {
                                endsWith$default3 = StringsKt__StringsJVMKt.endsWith$default(str2, ".pag", false, 2, null);
                                if (!endsWith$default3) {
                                    endsWith$default4 = StringsKt__StringsJVMKt.endsWith$default(str2, Sticker.JSON_SUFFIX, false, 2, null);
                                    if (endsWith$default4) {
                                        startRestartGroup.startReplaceableGroup(2006489531);
                                        LottieKt.a(iVar2, null, str, false, false, null, null, null, startRestartGroup, ((i17 << 6) & 896) | 8, 250);
                                        startRestartGroup.endReplaceableGroup();
                                    } else {
                                        startRestartGroup.startReplaceableGroup(2006489583);
                                        ImageKt.a(str, null, null, null, null, iVar2, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, startRestartGroup, (i17 & 14) | 262144, 0, 0, 2097118);
                                        startRestartGroup.endReplaceableGroup();
                                    }
                                } else {
                                    startRestartGroup.startReplaceableGroup(2006489431);
                                    PAGKt.a(iVar2, null, str, null, 0, false, null, null, null, startRestartGroup, ((i17 << 6) & 896) | 8, 506);
                                    startRestartGroup.endReplaceableGroup();
                                }
                            } else {
                                startRestartGroup.startReplaceableGroup(2006489141);
                                if (((a) startRestartGroup.consume(CompositionLocalsKt.d())).k()) {
                                    startRestartGroup.startReplaceableGroup(2006489219);
                                    APNGKt.a(iVar2, null, str, null, Boolean.TRUE, null, null, null, startRestartGroup, ((i17 << 6) & 896) | 24584, 234);
                                    startRestartGroup.endReplaceableGroup();
                                } else {
                                    startRestartGroup.startReplaceableGroup(2006489315);
                                    ImageKt.a(str, null, null, null, null, iVar2, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, startRestartGroup, (i17 & 14) | 262144, 0, 0, 2097118);
                                    startRestartGroup.endReplaceableGroup();
                                }
                                startRestartGroup.endReplaceableGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z19 = z18;
                            num3 = num4;
                        }
                    }
                    startRestartGroup.startReplaceableGroup(2006488994);
                    APNGKt.a(iVar2, null, str, num4, Boolean.TRUE, null, null, null, startRestartGroup, ((i17 << 6) & 896) | 24584 | (i17 & 7168), 226);
                    startRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z19 = z18;
                    num3 = num4;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                    return;
                }
                final i iVar3 = iVar2;
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQAnimatedImageKt$QQAnimatedImage$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Composer composer2, Integer num5) {
                        num5.intValue();
                        QQAnimatedImageKt.QQAnimatedImage(str, iVar3, z19, num3, composer2, i3 | 1, i16);
                        return Unit.INSTANCE;
                    }
                });
                return;
            }
            num2 = num;
            if (i19 != 2) {
            }
            if (i19 != 0) {
            }
            if (i26 != 0) {
            }
            if (i18 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER}, false, 0, 6, (Object) null);
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) split$default);
            String str22 = (String) first;
            if (!z18) {
            }
            startRestartGroup.startReplaceableGroup(2006488994);
            APNGKt.a(iVar2, null, str, num4, Boolean.TRUE, null, null, null, startRestartGroup, ((i17 << 6) & 896) | 24584 | (i17 & 7168), 226);
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
            z19 = z18;
            num3 = num4;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        z17 = z16;
        i18 = i16 & 8;
        if (i18 == 0) {
        }
        num2 = num;
        if (i19 != 2) {
        }
        if (i19 != 0) {
        }
        if (i26 != 0) {
        }
        if (i18 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER}, false, 0, 6, (Object) null);
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) split$default);
        String str222 = (String) first;
        if (!z18) {
        }
        startRestartGroup.startReplaceableGroup(2006488994);
        APNGKt.a(iVar2, null, str, num4, Boolean.TRUE, null, null, null, startRestartGroup, ((i17 << 6) & 896) | 24584 | (i17 & 7168), 226);
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        z19 = z18;
        num3 = num4;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
