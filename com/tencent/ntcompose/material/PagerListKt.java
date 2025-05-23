package com.tencent.ntcompose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.hippy.qq.view.viola.list.TkdListView;
import com.tencent.kuikly.core.views.PageListView;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.ScrollerAttr;
import com.tencent.kuikly.core.views.co;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u00e8\u0004\u00102\u001a\u00020\b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002Z\b\u0002\u0010\u000b\u001aT\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012!\u0012\u001f\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00030\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0002j\u0012\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0018\u0001`\t\u00a2\u0006\u0002\b\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u00102\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u000e2%\b\u0002\u0010!\u001a\u001f\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\b\u0018\u00010\u001f2+\b\u0002\u0010%\u001a%\u0012\u0013\u0012\u00110\"\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\b\u0018\u00010\u001fj\u0004\u0018\u0001`$2+\b\u0002\u0010&\u001a%\u0012\u0013\u0012\u00110\"\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\b\u0018\u00010\u001fj\u0004\u0018\u0001`$2+\b\u0002\u0010'\u001a%\u0012\u0013\u0012\u00110\"\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\b\u0018\u00010\u001fj\u0004\u0018\u0001`$2+\b\u0002\u0010(\u001a%\u0012\u0013\u0012\u00110\"\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\b\u0018\u00010\u001fj\u0004\u0018\u0001`$2@\b\u0002\u0010,\u001a:\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\b\u0018\u00010\u0002j\u0004\u0018\u0001`+2\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\b\u0018\u00010\u001f2\u001c\u00101\u001a\u0018\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\b0\u001f\u00a2\u0006\u0002\b0\u00a2\u0006\u0002\b\nH\u0007\u00a2\u0006\u0004\b2\u00103\u00a8\u00064"}, d2 = {"Lcom/tencent/ntcompose/core/i;", "modifier", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/views/PageListView;", "Lcom/tencent/kuikly/core/base/aa;", "Lkotlin/ParameterName;", "name", "viewRef", "", "Lcom/tencent/ntcompose/core/RefFunc;", "Lkotlin/ExtensionFunctionType;", "ref", "Lcom/tencent/ntcompose/foundation/lazy/d;", "state", "", "pageItemWidth", "", "defaultPageIndex", "", "userScrollEnabled", "Lto3/a;", "flingBehavior", ScrollerAttr.BOUNCES_ENABLE, ScrollerAttr.SHOW_SCROLLER_INDICATOR, "visibleAreaIgnoreTopMargin", "visibleAreaIgnoreBottomMargin", "firstLoadMaxIndex", "preloadViewDistance", "syncScroll", ScrollerAttr.SCROLL_WITH_PARENT, "pageIndexRatio", "Lkotlin/Function1;", "index", "onPageIndexDidChanged", "Lcom/tencent/kuikly/core/views/bn;", "e", "Lcom/tencent/ntcompose/material/ListEventCallback;", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, TkdListView.EVENT_TYPE_SCROLL_END, "onBeginDrag", "onEndDrag", "width", "height", "Lcom/tencent/ntcompose/material/ContentSizeChangedEventCallback;", "onContentSizeChanged", "Lcom/tencent/kuikly/core/views/co;", "onWillDragEndBySync", "Lcom/tencent/ntcompose/foundation/lazy/layout/a;", "Landroidx/compose/runtime/Composable;", "content", "a", "(Lcom/tencent/ntcompose/core/i;Lkotlin/jvm/functions/Function2;Lcom/tencent/ntcompose/foundation/lazy/d;Ljava/lang/Float;ILjava/lang/Boolean;Lto3/a;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Float;ILjava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Boolean;FLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;IIII)V", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PagerListKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x03f0  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0475  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x049d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0528  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x049f  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x055e  */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0367  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(com.tencent.ntcompose.core.i iVar, Function2<? super PageListView<?, ?>, ? super com.tencent.kuikly.core.base.aa<PageListView<?, ?>>, Unit> function2, com.tencent.ntcompose.foundation.lazy.d dVar, final Float f16, int i3, Boolean bool, to3.a aVar, Boolean bool2, Boolean bool3, Float f17, Float f18, int i16, Float f19, Boolean bool4, Boolean bool5, float f26, Function1<? super Integer, Unit> function1, Function1<? super ScrollParams, Unit> function12, Function1<? super ScrollParams, Unit> function13, Function1<? super ScrollParams, Unit> function14, Function1<? super ScrollParams, Unit> function15, Function2<? super Float, ? super Float, Unit> function22, Function1<? super co, Unit> function16, final Function3<? super com.tencent.ntcompose.foundation.lazy.layout.a, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i17, final int i18, final int i19, final int i26) {
        int i27;
        int i28;
        int i29;
        int i36;
        int i37;
        int i38;
        int i39;
        int i46;
        int i47;
        int i48;
        int i49;
        int i56;
        int i57;
        int i58;
        int i59;
        int i65;
        int i66;
        int i67;
        int i68;
        int i69;
        int i75;
        int i76;
        int i77;
        int i78;
        int i79;
        int i85;
        Function1<? super co, Unit> function17;
        Function1<? super Integer, Unit> function18;
        Composer composer2;
        final Float f27;
        final Boolean bool6;
        final Boolean bool7;
        final float f28;
        final Function1<? super Integer, Unit> function19;
        final Function1<? super ScrollParams, Unit> function110;
        final Function1<? super ScrollParams, Unit> function111;
        final Function1<? super ScrollParams, Unit> function112;
        final Function1<? super ScrollParams, Unit> function113;
        final Function2<? super Float, ? super Float, Unit> function23;
        final com.tencent.ntcompose.core.i iVar2;
        final Function2<? super PageListView<?, ?>, ? super com.tencent.kuikly.core.base.aa<PageListView<?, ?>>, Unit> function24;
        final com.tencent.ntcompose.foundation.lazy.d dVar2;
        final int i86;
        final Boolean bool8;
        final to3.a aVar2;
        final Boolean bool9;
        final Boolean bool10;
        final Float f29;
        final Float f36;
        final int i87;
        final Function1<? super co, Unit> function114;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(-507731528);
        int i88 = i26 & 1;
        if (i88 != 0) {
            i27 = i17 | 6;
        } else if ((i17 & 14) == 0) {
            i27 = (startRestartGroup.changed(iVar) ? 4 : 2) | i17;
        } else {
            i27 = i17;
        }
        int i89 = i26 & 2;
        if (i89 != 0) {
            i27 |= 48;
        } else if ((i17 & 112) == 0) {
            i27 |= startRestartGroup.changed(function2) ? 32 : 16;
            i28 = i26 & 4;
            if (i28 == 0) {
                i27 |= MsgConstant.KRMFILETHUMBSIZE384;
            } else if ((i17 & 896) == 0) {
                i27 |= startRestartGroup.changed(dVar) ? 256 : 128;
                if ((i26 & 8) != 0) {
                    i27 |= 3072;
                } else if ((i17 & 7168) == 0) {
                    i27 |= startRestartGroup.changed(f16) ? 2048 : 1024;
                    i29 = i26 & 16;
                    if (i29 == 0) {
                        i27 |= 24576;
                    } else if ((i17 & 57344) == 0) {
                        i27 |= startRestartGroup.changed(i3) ? 16384 : 8192;
                    }
                    i36 = i26 & 32;
                    if (i36 == 0) {
                        i27 |= 196608;
                    } else if ((i17 & 458752) == 0) {
                        i27 |= startRestartGroup.changed(bool) ? 131072 : 65536;
                    }
                    i37 = i26 & 64;
                    if (i37 == 0) {
                        i27 |= 1572864;
                    } else if ((i17 & 3670016) == 0) {
                        i27 |= startRestartGroup.changed(aVar) ? 1048576 : 524288;
                    }
                    i38 = i26 & 128;
                    if (i38 == 0) {
                        i27 |= 12582912;
                    } else if ((i17 & 29360128) == 0) {
                        i27 |= startRestartGroup.changed(bool2) ? 8388608 : 4194304;
                    }
                    i39 = i26 & 256;
                    if (i39 == 0) {
                        i27 |= 100663296;
                    } else if ((i17 & 234881024) == 0) {
                        i27 |= startRestartGroup.changed(bool3) ? 67108864 : 33554432;
                    }
                    i46 = i26 & 512;
                    if (i46 == 0) {
                        i27 |= 805306368;
                    } else if ((i17 & 1879048192) == 0) {
                        i27 |= startRestartGroup.changed(f17) ? 536870912 : 268435456;
                    }
                    i47 = i26 & 1024;
                    if (i47 == 0) {
                        i48 = i18 | 6;
                    } else if ((i18 & 14) == 0) {
                        i48 = i18 | (startRestartGroup.changed(f18) ? 4 : 2);
                    } else {
                        i48 = i18;
                    }
                    i49 = i26 & 2048;
                    if (i49 == 0) {
                        i48 |= 48;
                    } else if ((i18 & 112) == 0) {
                        i48 |= startRestartGroup.changed(i16) ? 32 : 16;
                    }
                    int i95 = i48;
                    i56 = i26 & 4096;
                    if (i56 == 0) {
                        i95 |= MsgConstant.KRMFILETHUMBSIZE384;
                        i57 = i56;
                    } else {
                        i57 = i56;
                        if ((i18 & 896) == 0) {
                            i95 |= startRestartGroup.changed(f19) ? 256 : 128;
                            i58 = i26 & 8192;
                            if (i58 != 0) {
                                i95 |= 3072;
                                i59 = i58;
                            } else {
                                i59 = i58;
                                if ((i18 & 7168) == 0) {
                                    i95 |= startRestartGroup.changed(bool4) ? 2048 : 1024;
                                    i65 = i26 & 16384;
                                    if (i65 == 0) {
                                        i95 |= 24576;
                                    } else if ((i18 & 57344) == 0) {
                                        i66 = i65;
                                        i95 |= startRestartGroup.changed(bool5) ? 16384 : 8192;
                                        i67 = i26 & 32768;
                                        if (i67 != 0) {
                                            i95 |= 196608;
                                        } else if ((i18 & 458752) == 0) {
                                            i95 |= startRestartGroup.changed(f26) ? 131072 : 65536;
                                        }
                                        i68 = i26 & 65536;
                                        if (i68 != 0) {
                                            i95 |= 1572864;
                                        } else if ((i18 & 3670016) == 0) {
                                            i95 |= startRestartGroup.changed(function1) ? 1048576 : 524288;
                                        }
                                        i69 = i26 & 131072;
                                        if (i69 != 0) {
                                            i95 |= 12582912;
                                        } else if ((i18 & 29360128) == 0) {
                                            i95 |= startRestartGroup.changed(function12) ? 8388608 : 4194304;
                                        }
                                        i75 = i26 & 262144;
                                        if (i75 != 0) {
                                            i95 |= 100663296;
                                        } else if ((i18 & 234881024) == 0) {
                                            i95 |= startRestartGroup.changed(function13) ? 67108864 : 33554432;
                                        }
                                        i76 = i26 & 524288;
                                        if (i76 != 0) {
                                            i95 |= 805306368;
                                        } else if ((i18 & 1879048192) == 0) {
                                            i95 |= startRestartGroup.changed(function14) ? 536870912 : 268435456;
                                        }
                                        i77 = i26 & 1048576;
                                        if (i77 != 0) {
                                            i78 = i19 | 6;
                                        } else if ((i19 & 14) == 0) {
                                            i78 = i19 | (startRestartGroup.changed(function15) ? 4 : 2);
                                        } else {
                                            i78 = i19;
                                        }
                                        i79 = i26 & 2097152;
                                        if (i79 != 0) {
                                            i78 |= 48;
                                        } else if ((i19 & 112) == 0) {
                                            i78 |= startRestartGroup.changed(function22) ? 32 : 16;
                                        }
                                        int i96 = i78;
                                        i85 = i26 & 4194304;
                                        if (i85 != 0) {
                                            i96 |= MsgConstant.KRMFILETHUMBSIZE384;
                                        } else if ((i19 & 896) == 0) {
                                            function17 = function16;
                                            i96 |= startRestartGroup.changed(function17) ? 256 : 128;
                                            if ((i26 & 8388608) == 0) {
                                                i96 |= 3072;
                                            } else if ((i19 & 7168) == 0) {
                                                i96 |= startRestartGroup.changed(content) ? 2048 : 1024;
                                            }
                                            if ((1533916891 & i27) != 306783378 && (1533916891 & i95) == 306783378 && (i96 & 5851) == 1170 && startRestartGroup.getSkipping()) {
                                                startRestartGroup.skipToGroupEnd();
                                                iVar2 = iVar;
                                                function24 = function2;
                                                dVar2 = dVar;
                                                i86 = i3;
                                                bool8 = bool;
                                                bool9 = bool2;
                                                bool10 = bool3;
                                                f29 = f17;
                                                f36 = f18;
                                                i87 = i16;
                                                bool6 = bool4;
                                                bool7 = bool5;
                                                f28 = f26;
                                                function19 = function1;
                                                function110 = function12;
                                                function111 = function13;
                                                function112 = function14;
                                                function113 = function15;
                                                function23 = function22;
                                                composer2 = startRestartGroup;
                                                function114 = function17;
                                                aVar2 = aVar;
                                                f27 = f19;
                                            } else {
                                                com.tencent.ntcompose.core.i iVar3 = i88 == 0 ? com.tencent.ntcompose.core.i.INSTANCE : iVar;
                                                Function2<? super PageListView<?, ?>, ? super com.tencent.kuikly.core.base.aa<PageListView<?, ?>>, Unit> function25 = i89 == 0 ? null : function2;
                                                com.tencent.ntcompose.foundation.lazy.d dVar3 = i28 == 0 ? null : dVar;
                                                int i97 = i29 == 0 ? 0 : i3;
                                                Boolean bool11 = i36 == 0 ? null : bool;
                                                to3.a aVar3 = i37 == 0 ? null : aVar;
                                                Boolean bool12 = i38 == 0 ? null : bool2;
                                                Boolean bool13 = i39 == 0 ? null : bool3;
                                                Float f37 = i46 == 0 ? null : f17;
                                                Float f38 = i47 == 0 ? null : f18;
                                                int i98 = i49 == 0 ? 1 : i16;
                                                Float f39 = i57 == 0 ? null : f19;
                                                Boolean bool14 = i59 == 0 ? null : bool4;
                                                Boolean bool15 = i66 == 0 ? null : bool5;
                                                float f46 = i67 == 0 ? 0.5f : f26;
                                                function18 = i68 == 0 ? null : function1;
                                                Function1<? super ScrollParams, Unit> function115 = i69 == 0 ? null : function12;
                                                Function1<? super ScrollParams, Unit> function116 = i75 == 0 ? null : function13;
                                                Function1<? super ScrollParams, Unit> function117 = i76 == 0 ? null : function14;
                                                Function1<? super ScrollParams, Unit> function118 = i77 == 0 ? null : function15;
                                                Function2<? super Float, ? super Float, Unit> function26 = i79 == 0 ? null : function22;
                                                Function1<? super co, Unit> function119 = i85 == 0 ? null : function17;
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-507731528, i27, i95, "com.tencent.ntcompose.material.HorizontalPagerList (PagerList.kt:71)");
                                                }
                                                ArrayList arrayList = new ArrayList();
                                                PageListViewPropUpdater pageListViewPropUpdater = PageListViewPropUpdater.f339345a;
                                                arrayList.add(new com.tencent.ntcompose.core.k("pageItemWidth", f16, null, null, null, null, pageListViewPropUpdater, 60, null));
                                                arrayList.add(new com.tencent.ntcompose.core.k("defaultPageIndex", Integer.valueOf(i97), null, null, null, null, pageListViewPropUpdater, 60, null));
                                                arrayList.add(new com.tencent.ntcompose.core.k("pageIndexRatio", Float.valueOf(f46), null, null, null, null, pageListViewPropUpdater, 60, null));
                                                if (function18 != null) {
                                                    arrayList.add(new com.tencent.ntcompose.core.k("onPageIndexDidChanged", function18, null, null, null, null, pageListViewPropUpdater, 60, null));
                                                }
                                                int i99 = i95;
                                                int i100 = i27;
                                                int i101 = (i100 & 14) | 805309440 | (i100 & 896) | (i100 & 458752) | (i100 & 3670016) | (i100 & 29360128) | (i100 & 234881024);
                                                int i102 = (i100 >> 27) & 14;
                                                int i103 = i99 << 3;
                                                composer2 = startRestartGroup;
                                                LazyListKt.a(iVar3, function25 != null ? null : function25, dVar3, ListItemsLayoutType.RowLinear, null, bool11, aVar3, bool12, bool13, Boolean.TRUE, f37, f38, i98 + i97, f39, bool14, null, bool15, function115, function116, function117, function118, function26, function119, arrayList, content, composer2, i101, i102 | (i103 & 112) | (i103 & 7168) | (i103 & 57344) | ((i99 << 6) & 3670016) | (i99 & 29360128) | (i99 & 234881024) | (i99 & 1879048192), (i96 & 14) | 4096 | (i96 & 112) | (i96 & 896) | ((i96 << 3) & 57344), 32784);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                                f27 = f39;
                                                bool6 = bool14;
                                                bool7 = bool15;
                                                f28 = f46;
                                                function19 = function18;
                                                function110 = function115;
                                                function111 = function116;
                                                function112 = function117;
                                                function113 = function118;
                                                function23 = function26;
                                                iVar2 = iVar3;
                                                function24 = function25;
                                                dVar2 = dVar3;
                                                i86 = i97;
                                                bool8 = bool11;
                                                aVar2 = aVar3;
                                                bool9 = bool12;
                                                bool10 = bool13;
                                                f29 = f37;
                                                f36 = f38;
                                                i87 = i98;
                                                function114 = function119;
                                            }
                                            endRestartGroup = composer2.endRestartGroup();
                                            if (endRestartGroup != null) {
                                                return;
                                            }
                                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.PagerListKt$HorizontalPagerList$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                    invoke(composer3, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer3, int i104) {
                                                    PagerListKt.a(com.tencent.ntcompose.core.i.this, function24, dVar2, f16, i86, bool8, aVar2, bool9, bool10, f29, f36, i87, f27, bool6, bool7, f28, function19, function110, function111, function112, function113, function23, function114, content, composer3, i17 | 1, i18, i19, i26);
                                                }
                                            });
                                            return;
                                        }
                                        function17 = function16;
                                        if ((i26 & 8388608) == 0) {
                                        }
                                        if ((1533916891 & i27) != 306783378) {
                                        }
                                        if (i88 == 0) {
                                        }
                                        if (i89 == 0) {
                                        }
                                        if (i28 == 0) {
                                        }
                                        if (i29 == 0) {
                                        }
                                        if (i36 == 0) {
                                        }
                                        if (i37 == 0) {
                                        }
                                        if (i38 == 0) {
                                        }
                                        if (i39 == 0) {
                                        }
                                        if (i46 == 0) {
                                        }
                                        if (i47 == 0) {
                                        }
                                        if (i49 == 0) {
                                        }
                                        if (i57 == 0) {
                                        }
                                        if (i59 == 0) {
                                        }
                                        if (i66 == 0) {
                                        }
                                        if (i67 == 0) {
                                        }
                                        if (i68 == 0) {
                                        }
                                        if (i69 == 0) {
                                        }
                                        if (i75 == 0) {
                                        }
                                        if (i76 == 0) {
                                        }
                                        if (i77 == 0) {
                                        }
                                        if (i79 == 0) {
                                        }
                                        if (i85 == 0) {
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        ArrayList arrayList2 = new ArrayList();
                                        PageListViewPropUpdater pageListViewPropUpdater2 = PageListViewPropUpdater.f339345a;
                                        arrayList2.add(new com.tencent.ntcompose.core.k("pageItemWidth", f16, null, null, null, null, pageListViewPropUpdater2, 60, null));
                                        arrayList2.add(new com.tencent.ntcompose.core.k("defaultPageIndex", Integer.valueOf(i97), null, null, null, null, pageListViewPropUpdater2, 60, null));
                                        arrayList2.add(new com.tencent.ntcompose.core.k("pageIndexRatio", Float.valueOf(f46), null, null, null, null, pageListViewPropUpdater2, 60, null));
                                        if (function18 != null) {
                                        }
                                        int i992 = i95;
                                        int i1002 = i27;
                                        int i1012 = (i1002 & 14) | 805309440 | (i1002 & 896) | (i1002 & 458752) | (i1002 & 3670016) | (i1002 & 29360128) | (i1002 & 234881024);
                                        int i1022 = (i1002 >> 27) & 14;
                                        int i1032 = i992 << 3;
                                        composer2 = startRestartGroup;
                                        LazyListKt.a(iVar3, function25 != null ? null : function25, dVar3, ListItemsLayoutType.RowLinear, null, bool11, aVar3, bool12, bool13, Boolean.TRUE, f37, f38, i98 + i97, f39, bool14, null, bool15, function115, function116, function117, function118, function26, function119, arrayList2, content, composer2, i1012, i1022 | (i1032 & 112) | (i1032 & 7168) | (i1032 & 57344) | ((i992 << 6) & 3670016) | (i992 & 29360128) | (i992 & 234881024) | (i992 & 1879048192), (i96 & 14) | 4096 | (i96 & 112) | (i96 & 896) | ((i96 << 3) & 57344), 32784);
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        f27 = f39;
                                        bool6 = bool14;
                                        bool7 = bool15;
                                        f28 = f46;
                                        function19 = function18;
                                        function110 = function115;
                                        function111 = function116;
                                        function112 = function117;
                                        function113 = function118;
                                        function23 = function26;
                                        iVar2 = iVar3;
                                        function24 = function25;
                                        dVar2 = dVar3;
                                        i86 = i97;
                                        bool8 = bool11;
                                        aVar2 = aVar3;
                                        bool9 = bool12;
                                        bool10 = bool13;
                                        f29 = f37;
                                        f36 = f38;
                                        i87 = i98;
                                        function114 = function119;
                                        endRestartGroup = composer2.endRestartGroup();
                                        if (endRestartGroup != null) {
                                        }
                                    }
                                    i66 = i65;
                                    i67 = i26 & 32768;
                                    if (i67 != 0) {
                                    }
                                    i68 = i26 & 65536;
                                    if (i68 != 0) {
                                    }
                                    i69 = i26 & 131072;
                                    if (i69 != 0) {
                                    }
                                    i75 = i26 & 262144;
                                    if (i75 != 0) {
                                    }
                                    i76 = i26 & 524288;
                                    if (i76 != 0) {
                                    }
                                    i77 = i26 & 1048576;
                                    if (i77 != 0) {
                                    }
                                    i79 = i26 & 2097152;
                                    if (i79 != 0) {
                                    }
                                    int i962 = i78;
                                    i85 = i26 & 4194304;
                                    if (i85 != 0) {
                                    }
                                    function17 = function16;
                                    if ((i26 & 8388608) == 0) {
                                    }
                                    if ((1533916891 & i27) != 306783378) {
                                    }
                                    if (i88 == 0) {
                                    }
                                    if (i89 == 0) {
                                    }
                                    if (i28 == 0) {
                                    }
                                    if (i29 == 0) {
                                    }
                                    if (i36 == 0) {
                                    }
                                    if (i37 == 0) {
                                    }
                                    if (i38 == 0) {
                                    }
                                    if (i39 == 0) {
                                    }
                                    if (i46 == 0) {
                                    }
                                    if (i47 == 0) {
                                    }
                                    if (i49 == 0) {
                                    }
                                    if (i57 == 0) {
                                    }
                                    if (i59 == 0) {
                                    }
                                    if (i66 == 0) {
                                    }
                                    if (i67 == 0) {
                                    }
                                    if (i68 == 0) {
                                    }
                                    if (i69 == 0) {
                                    }
                                    if (i75 == 0) {
                                    }
                                    if (i76 == 0) {
                                    }
                                    if (i77 == 0) {
                                    }
                                    if (i79 == 0) {
                                    }
                                    if (i85 == 0) {
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    ArrayList arrayList22 = new ArrayList();
                                    PageListViewPropUpdater pageListViewPropUpdater22 = PageListViewPropUpdater.f339345a;
                                    arrayList22.add(new com.tencent.ntcompose.core.k("pageItemWidth", f16, null, null, null, null, pageListViewPropUpdater22, 60, null));
                                    arrayList22.add(new com.tencent.ntcompose.core.k("defaultPageIndex", Integer.valueOf(i97), null, null, null, null, pageListViewPropUpdater22, 60, null));
                                    arrayList22.add(new com.tencent.ntcompose.core.k("pageIndexRatio", Float.valueOf(f46), null, null, null, null, pageListViewPropUpdater22, 60, null));
                                    if (function18 != null) {
                                    }
                                    int i9922 = i95;
                                    int i10022 = i27;
                                    int i10122 = (i10022 & 14) | 805309440 | (i10022 & 896) | (i10022 & 458752) | (i10022 & 3670016) | (i10022 & 29360128) | (i10022 & 234881024);
                                    int i10222 = (i10022 >> 27) & 14;
                                    int i10322 = i9922 << 3;
                                    composer2 = startRestartGroup;
                                    LazyListKt.a(iVar3, function25 != null ? null : function25, dVar3, ListItemsLayoutType.RowLinear, null, bool11, aVar3, bool12, bool13, Boolean.TRUE, f37, f38, i98 + i97, f39, bool14, null, bool15, function115, function116, function117, function118, function26, function119, arrayList22, content, composer2, i10122, i10222 | (i10322 & 112) | (i10322 & 7168) | (i10322 & 57344) | ((i9922 << 6) & 3670016) | (i9922 & 29360128) | (i9922 & 234881024) | (i9922 & 1879048192), (i962 & 14) | 4096 | (i962 & 112) | (i962 & 896) | ((i962 << 3) & 57344), 32784);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    f27 = f39;
                                    bool6 = bool14;
                                    bool7 = bool15;
                                    f28 = f46;
                                    function19 = function18;
                                    function110 = function115;
                                    function111 = function116;
                                    function112 = function117;
                                    function113 = function118;
                                    function23 = function26;
                                    iVar2 = iVar3;
                                    function24 = function25;
                                    dVar2 = dVar3;
                                    i86 = i97;
                                    bool8 = bool11;
                                    aVar2 = aVar3;
                                    bool9 = bool12;
                                    bool10 = bool13;
                                    f29 = f37;
                                    f36 = f38;
                                    i87 = i98;
                                    function114 = function119;
                                    endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup != null) {
                                    }
                                }
                            }
                            i65 = i26 & 16384;
                            if (i65 == 0) {
                            }
                            i66 = i65;
                            i67 = i26 & 32768;
                            if (i67 != 0) {
                            }
                            i68 = i26 & 65536;
                            if (i68 != 0) {
                            }
                            i69 = i26 & 131072;
                            if (i69 != 0) {
                            }
                            i75 = i26 & 262144;
                            if (i75 != 0) {
                            }
                            i76 = i26 & 524288;
                            if (i76 != 0) {
                            }
                            i77 = i26 & 1048576;
                            if (i77 != 0) {
                            }
                            i79 = i26 & 2097152;
                            if (i79 != 0) {
                            }
                            int i9622 = i78;
                            i85 = i26 & 4194304;
                            if (i85 != 0) {
                            }
                            function17 = function16;
                            if ((i26 & 8388608) == 0) {
                            }
                            if ((1533916891 & i27) != 306783378) {
                            }
                            if (i88 == 0) {
                            }
                            if (i89 == 0) {
                            }
                            if (i28 == 0) {
                            }
                            if (i29 == 0) {
                            }
                            if (i36 == 0) {
                            }
                            if (i37 == 0) {
                            }
                            if (i38 == 0) {
                            }
                            if (i39 == 0) {
                            }
                            if (i46 == 0) {
                            }
                            if (i47 == 0) {
                            }
                            if (i49 == 0) {
                            }
                            if (i57 == 0) {
                            }
                            if (i59 == 0) {
                            }
                            if (i66 == 0) {
                            }
                            if (i67 == 0) {
                            }
                            if (i68 == 0) {
                            }
                            if (i69 == 0) {
                            }
                            if (i75 == 0) {
                            }
                            if (i76 == 0) {
                            }
                            if (i77 == 0) {
                            }
                            if (i79 == 0) {
                            }
                            if (i85 == 0) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            ArrayList arrayList222 = new ArrayList();
                            PageListViewPropUpdater pageListViewPropUpdater222 = PageListViewPropUpdater.f339345a;
                            arrayList222.add(new com.tencent.ntcompose.core.k("pageItemWidth", f16, null, null, null, null, pageListViewPropUpdater222, 60, null));
                            arrayList222.add(new com.tencent.ntcompose.core.k("defaultPageIndex", Integer.valueOf(i97), null, null, null, null, pageListViewPropUpdater222, 60, null));
                            arrayList222.add(new com.tencent.ntcompose.core.k("pageIndexRatio", Float.valueOf(f46), null, null, null, null, pageListViewPropUpdater222, 60, null));
                            if (function18 != null) {
                            }
                            int i99222 = i95;
                            int i100222 = i27;
                            int i101222 = (i100222 & 14) | 805309440 | (i100222 & 896) | (i100222 & 458752) | (i100222 & 3670016) | (i100222 & 29360128) | (i100222 & 234881024);
                            int i102222 = (i100222 >> 27) & 14;
                            int i103222 = i99222 << 3;
                            composer2 = startRestartGroup;
                            LazyListKt.a(iVar3, function25 != null ? null : function25, dVar3, ListItemsLayoutType.RowLinear, null, bool11, aVar3, bool12, bool13, Boolean.TRUE, f37, f38, i98 + i97, f39, bool14, null, bool15, function115, function116, function117, function118, function26, function119, arrayList222, content, composer2, i101222, i102222 | (i103222 & 112) | (i103222 & 7168) | (i103222 & 57344) | ((i99222 << 6) & 3670016) | (i99222 & 29360128) | (i99222 & 234881024) | (i99222 & 1879048192), (i9622 & 14) | 4096 | (i9622 & 112) | (i9622 & 896) | ((i9622 << 3) & 57344), 32784);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            f27 = f39;
                            bool6 = bool14;
                            bool7 = bool15;
                            f28 = f46;
                            function19 = function18;
                            function110 = function115;
                            function111 = function116;
                            function112 = function117;
                            function113 = function118;
                            function23 = function26;
                            iVar2 = iVar3;
                            function24 = function25;
                            dVar2 = dVar3;
                            i86 = i97;
                            bool8 = bool11;
                            aVar2 = aVar3;
                            bool9 = bool12;
                            bool10 = bool13;
                            f29 = f37;
                            f36 = f38;
                            i87 = i98;
                            function114 = function119;
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                    }
                    i58 = i26 & 8192;
                    if (i58 != 0) {
                    }
                    i65 = i26 & 16384;
                    if (i65 == 0) {
                    }
                    i66 = i65;
                    i67 = i26 & 32768;
                    if (i67 != 0) {
                    }
                    i68 = i26 & 65536;
                    if (i68 != 0) {
                    }
                    i69 = i26 & 131072;
                    if (i69 != 0) {
                    }
                    i75 = i26 & 262144;
                    if (i75 != 0) {
                    }
                    i76 = i26 & 524288;
                    if (i76 != 0) {
                    }
                    i77 = i26 & 1048576;
                    if (i77 != 0) {
                    }
                    i79 = i26 & 2097152;
                    if (i79 != 0) {
                    }
                    int i96222 = i78;
                    i85 = i26 & 4194304;
                    if (i85 != 0) {
                    }
                    function17 = function16;
                    if ((i26 & 8388608) == 0) {
                    }
                    if ((1533916891 & i27) != 306783378) {
                    }
                    if (i88 == 0) {
                    }
                    if (i89 == 0) {
                    }
                    if (i28 == 0) {
                    }
                    if (i29 == 0) {
                    }
                    if (i36 == 0) {
                    }
                    if (i37 == 0) {
                    }
                    if (i38 == 0) {
                    }
                    if (i39 == 0) {
                    }
                    if (i46 == 0) {
                    }
                    if (i47 == 0) {
                    }
                    if (i49 == 0) {
                    }
                    if (i57 == 0) {
                    }
                    if (i59 == 0) {
                    }
                    if (i66 == 0) {
                    }
                    if (i67 == 0) {
                    }
                    if (i68 == 0) {
                    }
                    if (i69 == 0) {
                    }
                    if (i75 == 0) {
                    }
                    if (i76 == 0) {
                    }
                    if (i77 == 0) {
                    }
                    if (i79 == 0) {
                    }
                    if (i85 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ArrayList arrayList2222 = new ArrayList();
                    PageListViewPropUpdater pageListViewPropUpdater2222 = PageListViewPropUpdater.f339345a;
                    arrayList2222.add(new com.tencent.ntcompose.core.k("pageItemWidth", f16, null, null, null, null, pageListViewPropUpdater2222, 60, null));
                    arrayList2222.add(new com.tencent.ntcompose.core.k("defaultPageIndex", Integer.valueOf(i97), null, null, null, null, pageListViewPropUpdater2222, 60, null));
                    arrayList2222.add(new com.tencent.ntcompose.core.k("pageIndexRatio", Float.valueOf(f46), null, null, null, null, pageListViewPropUpdater2222, 60, null));
                    if (function18 != null) {
                    }
                    int i992222 = i95;
                    int i1002222 = i27;
                    int i1012222 = (i1002222 & 14) | 805309440 | (i1002222 & 896) | (i1002222 & 458752) | (i1002222 & 3670016) | (i1002222 & 29360128) | (i1002222 & 234881024);
                    int i1022222 = (i1002222 >> 27) & 14;
                    int i1032222 = i992222 << 3;
                    composer2 = startRestartGroup;
                    LazyListKt.a(iVar3, function25 != null ? null : function25, dVar3, ListItemsLayoutType.RowLinear, null, bool11, aVar3, bool12, bool13, Boolean.TRUE, f37, f38, i98 + i97, f39, bool14, null, bool15, function115, function116, function117, function118, function26, function119, arrayList2222, content, composer2, i1012222, i1022222 | (i1032222 & 112) | (i1032222 & 7168) | (i1032222 & 57344) | ((i992222 << 6) & 3670016) | (i992222 & 29360128) | (i992222 & 234881024) | (i992222 & 1879048192), (i96222 & 14) | 4096 | (i96222 & 112) | (i96222 & 896) | ((i96222 << 3) & 57344), 32784);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    f27 = f39;
                    bool6 = bool14;
                    bool7 = bool15;
                    f28 = f46;
                    function19 = function18;
                    function110 = function115;
                    function111 = function116;
                    function112 = function117;
                    function113 = function118;
                    function23 = function26;
                    iVar2 = iVar3;
                    function24 = function25;
                    dVar2 = dVar3;
                    i86 = i97;
                    bool8 = bool11;
                    aVar2 = aVar3;
                    bool9 = bool12;
                    bool10 = bool13;
                    f29 = f37;
                    f36 = f38;
                    i87 = i98;
                    function114 = function119;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i29 = i26 & 16;
                if (i29 == 0) {
                }
                i36 = i26 & 32;
                if (i36 == 0) {
                }
                i37 = i26 & 64;
                if (i37 == 0) {
                }
                i38 = i26 & 128;
                if (i38 == 0) {
                }
                i39 = i26 & 256;
                if (i39 == 0) {
                }
                i46 = i26 & 512;
                if (i46 == 0) {
                }
                i47 = i26 & 1024;
                if (i47 == 0) {
                }
                i49 = i26 & 2048;
                if (i49 == 0) {
                }
                int i952 = i48;
                i56 = i26 & 4096;
                if (i56 == 0) {
                }
                i58 = i26 & 8192;
                if (i58 != 0) {
                }
                i65 = i26 & 16384;
                if (i65 == 0) {
                }
                i66 = i65;
                i67 = i26 & 32768;
                if (i67 != 0) {
                }
                i68 = i26 & 65536;
                if (i68 != 0) {
                }
                i69 = i26 & 131072;
                if (i69 != 0) {
                }
                i75 = i26 & 262144;
                if (i75 != 0) {
                }
                i76 = i26 & 524288;
                if (i76 != 0) {
                }
                i77 = i26 & 1048576;
                if (i77 != 0) {
                }
                i79 = i26 & 2097152;
                if (i79 != 0) {
                }
                int i962222 = i78;
                i85 = i26 & 4194304;
                if (i85 != 0) {
                }
                function17 = function16;
                if ((i26 & 8388608) == 0) {
                }
                if ((1533916891 & i27) != 306783378) {
                }
                if (i88 == 0) {
                }
                if (i89 == 0) {
                }
                if (i28 == 0) {
                }
                if (i29 == 0) {
                }
                if (i36 == 0) {
                }
                if (i37 == 0) {
                }
                if (i38 == 0) {
                }
                if (i39 == 0) {
                }
                if (i46 == 0) {
                }
                if (i47 == 0) {
                }
                if (i49 == 0) {
                }
                if (i57 == 0) {
                }
                if (i59 == 0) {
                }
                if (i66 == 0) {
                }
                if (i67 == 0) {
                }
                if (i68 == 0) {
                }
                if (i69 == 0) {
                }
                if (i75 == 0) {
                }
                if (i76 == 0) {
                }
                if (i77 == 0) {
                }
                if (i79 == 0) {
                }
                if (i85 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                ArrayList arrayList22222 = new ArrayList();
                PageListViewPropUpdater pageListViewPropUpdater22222 = PageListViewPropUpdater.f339345a;
                arrayList22222.add(new com.tencent.ntcompose.core.k("pageItemWidth", f16, null, null, null, null, pageListViewPropUpdater22222, 60, null));
                arrayList22222.add(new com.tencent.ntcompose.core.k("defaultPageIndex", Integer.valueOf(i97), null, null, null, null, pageListViewPropUpdater22222, 60, null));
                arrayList22222.add(new com.tencent.ntcompose.core.k("pageIndexRatio", Float.valueOf(f46), null, null, null, null, pageListViewPropUpdater22222, 60, null));
                if (function18 != null) {
                }
                int i9922222 = i952;
                int i10022222 = i27;
                int i10122222 = (i10022222 & 14) | 805309440 | (i10022222 & 896) | (i10022222 & 458752) | (i10022222 & 3670016) | (i10022222 & 29360128) | (i10022222 & 234881024);
                int i10222222 = (i10022222 >> 27) & 14;
                int i10322222 = i9922222 << 3;
                composer2 = startRestartGroup;
                LazyListKt.a(iVar3, function25 != null ? null : function25, dVar3, ListItemsLayoutType.RowLinear, null, bool11, aVar3, bool12, bool13, Boolean.TRUE, f37, f38, i98 + i97, f39, bool14, null, bool15, function115, function116, function117, function118, function26, function119, arrayList22222, content, composer2, i10122222, i10222222 | (i10322222 & 112) | (i10322222 & 7168) | (i10322222 & 57344) | ((i9922222 << 6) & 3670016) | (i9922222 & 29360128) | (i9922222 & 234881024) | (i9922222 & 1879048192), (i962222 & 14) | 4096 | (i962222 & 112) | (i962222 & 896) | ((i962222 << 3) & 57344), 32784);
                if (ComposerKt.isTraceInProgress()) {
                }
                f27 = f39;
                bool6 = bool14;
                bool7 = bool15;
                f28 = f46;
                function19 = function18;
                function110 = function115;
                function111 = function116;
                function112 = function117;
                function113 = function118;
                function23 = function26;
                iVar2 = iVar3;
                function24 = function25;
                dVar2 = dVar3;
                i86 = i97;
                bool8 = bool11;
                aVar2 = aVar3;
                bool9 = bool12;
                bool10 = bool13;
                f29 = f37;
                f36 = f38;
                i87 = i98;
                function114 = function119;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            if ((i26 & 8) != 0) {
            }
            i29 = i26 & 16;
            if (i29 == 0) {
            }
            i36 = i26 & 32;
            if (i36 == 0) {
            }
            i37 = i26 & 64;
            if (i37 == 0) {
            }
            i38 = i26 & 128;
            if (i38 == 0) {
            }
            i39 = i26 & 256;
            if (i39 == 0) {
            }
            i46 = i26 & 512;
            if (i46 == 0) {
            }
            i47 = i26 & 1024;
            if (i47 == 0) {
            }
            i49 = i26 & 2048;
            if (i49 == 0) {
            }
            int i9522 = i48;
            i56 = i26 & 4096;
            if (i56 == 0) {
            }
            i58 = i26 & 8192;
            if (i58 != 0) {
            }
            i65 = i26 & 16384;
            if (i65 == 0) {
            }
            i66 = i65;
            i67 = i26 & 32768;
            if (i67 != 0) {
            }
            i68 = i26 & 65536;
            if (i68 != 0) {
            }
            i69 = i26 & 131072;
            if (i69 != 0) {
            }
            i75 = i26 & 262144;
            if (i75 != 0) {
            }
            i76 = i26 & 524288;
            if (i76 != 0) {
            }
            i77 = i26 & 1048576;
            if (i77 != 0) {
            }
            i79 = i26 & 2097152;
            if (i79 != 0) {
            }
            int i9622222 = i78;
            i85 = i26 & 4194304;
            if (i85 != 0) {
            }
            function17 = function16;
            if ((i26 & 8388608) == 0) {
            }
            if ((1533916891 & i27) != 306783378) {
            }
            if (i88 == 0) {
            }
            if (i89 == 0) {
            }
            if (i28 == 0) {
            }
            if (i29 == 0) {
            }
            if (i36 == 0) {
            }
            if (i37 == 0) {
            }
            if (i38 == 0) {
            }
            if (i39 == 0) {
            }
            if (i46 == 0) {
            }
            if (i47 == 0) {
            }
            if (i49 == 0) {
            }
            if (i57 == 0) {
            }
            if (i59 == 0) {
            }
            if (i66 == 0) {
            }
            if (i67 == 0) {
            }
            if (i68 == 0) {
            }
            if (i69 == 0) {
            }
            if (i75 == 0) {
            }
            if (i76 == 0) {
            }
            if (i77 == 0) {
            }
            if (i79 == 0) {
            }
            if (i85 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            ArrayList arrayList222222 = new ArrayList();
            PageListViewPropUpdater pageListViewPropUpdater222222 = PageListViewPropUpdater.f339345a;
            arrayList222222.add(new com.tencent.ntcompose.core.k("pageItemWidth", f16, null, null, null, null, pageListViewPropUpdater222222, 60, null));
            arrayList222222.add(new com.tencent.ntcompose.core.k("defaultPageIndex", Integer.valueOf(i97), null, null, null, null, pageListViewPropUpdater222222, 60, null));
            arrayList222222.add(new com.tencent.ntcompose.core.k("pageIndexRatio", Float.valueOf(f46), null, null, null, null, pageListViewPropUpdater222222, 60, null));
            if (function18 != null) {
            }
            int i99222222 = i9522;
            int i100222222 = i27;
            int i101222222 = (i100222222 & 14) | 805309440 | (i100222222 & 896) | (i100222222 & 458752) | (i100222222 & 3670016) | (i100222222 & 29360128) | (i100222222 & 234881024);
            int i102222222 = (i100222222 >> 27) & 14;
            int i103222222 = i99222222 << 3;
            composer2 = startRestartGroup;
            LazyListKt.a(iVar3, function25 != null ? null : function25, dVar3, ListItemsLayoutType.RowLinear, null, bool11, aVar3, bool12, bool13, Boolean.TRUE, f37, f38, i98 + i97, f39, bool14, null, bool15, function115, function116, function117, function118, function26, function119, arrayList222222, content, composer2, i101222222, i102222222 | (i103222222 & 112) | (i103222222 & 7168) | (i103222222 & 57344) | ((i99222222 << 6) & 3670016) | (i99222222 & 29360128) | (i99222222 & 234881024) | (i99222222 & 1879048192), (i9622222 & 14) | 4096 | (i9622222 & 112) | (i9622222 & 896) | ((i9622222 << 3) & 57344), 32784);
            if (ComposerKt.isTraceInProgress()) {
            }
            f27 = f39;
            bool6 = bool14;
            bool7 = bool15;
            f28 = f46;
            function19 = function18;
            function110 = function115;
            function111 = function116;
            function112 = function117;
            function113 = function118;
            function23 = function26;
            iVar2 = iVar3;
            function24 = function25;
            dVar2 = dVar3;
            i86 = i97;
            bool8 = bool11;
            aVar2 = aVar3;
            bool9 = bool12;
            bool10 = bool13;
            f29 = f37;
            f36 = f38;
            i87 = i98;
            function114 = function119;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i28 = i26 & 4;
        if (i28 == 0) {
        }
        if ((i26 & 8) != 0) {
        }
        i29 = i26 & 16;
        if (i29 == 0) {
        }
        i36 = i26 & 32;
        if (i36 == 0) {
        }
        i37 = i26 & 64;
        if (i37 == 0) {
        }
        i38 = i26 & 128;
        if (i38 == 0) {
        }
        i39 = i26 & 256;
        if (i39 == 0) {
        }
        i46 = i26 & 512;
        if (i46 == 0) {
        }
        i47 = i26 & 1024;
        if (i47 == 0) {
        }
        i49 = i26 & 2048;
        if (i49 == 0) {
        }
        int i95222 = i48;
        i56 = i26 & 4096;
        if (i56 == 0) {
        }
        i58 = i26 & 8192;
        if (i58 != 0) {
        }
        i65 = i26 & 16384;
        if (i65 == 0) {
        }
        i66 = i65;
        i67 = i26 & 32768;
        if (i67 != 0) {
        }
        i68 = i26 & 65536;
        if (i68 != 0) {
        }
        i69 = i26 & 131072;
        if (i69 != 0) {
        }
        i75 = i26 & 262144;
        if (i75 != 0) {
        }
        i76 = i26 & 524288;
        if (i76 != 0) {
        }
        i77 = i26 & 1048576;
        if (i77 != 0) {
        }
        i79 = i26 & 2097152;
        if (i79 != 0) {
        }
        int i96222222 = i78;
        i85 = i26 & 4194304;
        if (i85 != 0) {
        }
        function17 = function16;
        if ((i26 & 8388608) == 0) {
        }
        if ((1533916891 & i27) != 306783378) {
        }
        if (i88 == 0) {
        }
        if (i89 == 0) {
        }
        if (i28 == 0) {
        }
        if (i29 == 0) {
        }
        if (i36 == 0) {
        }
        if (i37 == 0) {
        }
        if (i38 == 0) {
        }
        if (i39 == 0) {
        }
        if (i46 == 0) {
        }
        if (i47 == 0) {
        }
        if (i49 == 0) {
        }
        if (i57 == 0) {
        }
        if (i59 == 0) {
        }
        if (i66 == 0) {
        }
        if (i67 == 0) {
        }
        if (i68 == 0) {
        }
        if (i69 == 0) {
        }
        if (i75 == 0) {
        }
        if (i76 == 0) {
        }
        if (i77 == 0) {
        }
        if (i79 == 0) {
        }
        if (i85 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        ArrayList arrayList2222222 = new ArrayList();
        PageListViewPropUpdater pageListViewPropUpdater2222222 = PageListViewPropUpdater.f339345a;
        arrayList2222222.add(new com.tencent.ntcompose.core.k("pageItemWidth", f16, null, null, null, null, pageListViewPropUpdater2222222, 60, null));
        arrayList2222222.add(new com.tencent.ntcompose.core.k("defaultPageIndex", Integer.valueOf(i97), null, null, null, null, pageListViewPropUpdater2222222, 60, null));
        arrayList2222222.add(new com.tencent.ntcompose.core.k("pageIndexRatio", Float.valueOf(f46), null, null, null, null, pageListViewPropUpdater2222222, 60, null));
        if (function18 != null) {
        }
        int i992222222 = i95222;
        int i1002222222 = i27;
        int i1012222222 = (i1002222222 & 14) | 805309440 | (i1002222222 & 896) | (i1002222222 & 458752) | (i1002222222 & 3670016) | (i1002222222 & 29360128) | (i1002222222 & 234881024);
        int i1022222222 = (i1002222222 >> 27) & 14;
        int i1032222222 = i992222222 << 3;
        composer2 = startRestartGroup;
        LazyListKt.a(iVar3, function25 != null ? null : function25, dVar3, ListItemsLayoutType.RowLinear, null, bool11, aVar3, bool12, bool13, Boolean.TRUE, f37, f38, i98 + i97, f39, bool14, null, bool15, function115, function116, function117, function118, function26, function119, arrayList2222222, content, composer2, i1012222222, i1022222222 | (i1032222222 & 112) | (i1032222222 & 7168) | (i1032222222 & 57344) | ((i992222222 << 6) & 3670016) | (i992222222 & 29360128) | (i992222222 & 234881024) | (i992222222 & 1879048192), (i96222222 & 14) | 4096 | (i96222222 & 112) | (i96222222 & 896) | ((i96222222 << 3) & 57344), 32784);
        if (ComposerKt.isTraceInProgress()) {
        }
        f27 = f39;
        bool6 = bool14;
        bool7 = bool15;
        f28 = f46;
        function19 = function18;
        function110 = function115;
        function111 = function116;
        function112 = function117;
        function113 = function118;
        function23 = function26;
        iVar2 = iVar3;
        function24 = function25;
        dVar2 = dVar3;
        i86 = i97;
        bool8 = bool11;
        aVar2 = aVar3;
        bool9 = bool12;
        bool10 = bool13;
        f29 = f37;
        f36 = f38;
        i87 = i98;
        function114 = function119;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
