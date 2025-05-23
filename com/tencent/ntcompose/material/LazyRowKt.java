package com.tencent.ntcompose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.hippy.qq.view.viola.list.TkdListView;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.ScrollerAttr;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.co;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u00c7\u0004\u00101\u001a\u00020\b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002Z\b\u0002\u0010\u000b\u001aT\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012!\u0012\u001f\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00030\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0002j\u0012\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0018\u0001`\t\u00a2\u0006\u0002\b\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00102+\b\u0002\u0010$\u001a%\u0012\u0013\u0012\u00110!\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\b\u0018\u00010 j\u0004\u0018\u0001`#2+\b\u0002\u0010%\u001a%\u0012\u0013\u0012\u00110!\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\b\u0018\u00010 j\u0004\u0018\u0001`#2+\b\u0002\u0010&\u001a%\u0012\u0013\u0012\u00110!\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\b\u0018\u00010 j\u0004\u0018\u0001`#2+\b\u0002\u0010'\u001a%\u0012\u0013\u0012\u00110!\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\b\u0018\u00010 j\u0004\u0018\u0001`#2@\b\u0002\u0010+\u001a:\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\b\u0018\u00010\u0002j\u0004\u0018\u0001`*2\u0016\b\u0002\u0010-\u001a\u0010\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\b\u0018\u00010 2\u001c\u00100\u001a\u0018\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\b0 \u00a2\u0006\u0002\b/\u00a2\u0006\u0002\b\nH\u0007\u00a2\u0006\u0004\b1\u00102\u00a8\u00063"}, d2 = {"Lcom/tencent/ntcompose/core/i;", "modifier", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/views/aq;", "Lcom/tencent/kuikly/core/base/aa;", "Lkotlin/ParameterName;", "name", "viewRef", "", "Lcom/tencent/ntcompose/core/RefFunc;", "Lkotlin/ExtensionFunctionType;", "ref", "Lcom/tencent/ntcompose/foundation/lazy/d;", "state", "Lcom/tencent/ntcompose/foundation/layout/l;", "contentPadding", "", "userScrollEnabled", "Lto3/a;", "flingBehavior", ScrollerAttr.BOUNCES_ENABLE, ScrollerAttr.SHOW_SCROLLER_INDICATOR, "pagingEnable", "", "visibleAreaIgnoreTopMargin", "visibleAreaIgnoreBottomMargin", "", "firstLoadMaxIndex", "preloadViewDistance", "syncScroll", ScrollerAttr.SYNC_SCROLL_IN_MAX_OFFSET, ScrollerAttr.SCROLL_WITH_PARENT, "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/views/bn;", "e", "Lcom/tencent/ntcompose/material/ListEventCallback;", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, TkdListView.EVENT_TYPE_SCROLL_END, "onBeginDrag", "onEndDrag", "width", "height", "Lcom/tencent/ntcompose/material/ContentSizeChangedEventCallback;", "onContentSizeChanged", "Lcom/tencent/kuikly/core/views/co;", "onWillDragEndBySync", "Lcom/tencent/ntcompose/foundation/lazy/layout/a;", "Landroidx/compose/runtime/Composable;", "content", "a", "(Lcom/tencent/ntcompose/core/i;Lkotlin/jvm/functions/Function2;Lcom/tencent/ntcompose/foundation/lazy/d;Lcom/tencent/ntcompose/foundation/layout/l;Ljava/lang/Boolean;Lto3/a;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Float;ILjava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;IIII)V", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class LazyRowKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0352  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(com.tencent.ntcompose.core.i iVar, Function2<? super aq<?, ?>, ? super com.tencent.kuikly.core.base.aa<aq<?, ?>>, Unit> function2, com.tencent.ntcompose.foundation.lazy.d dVar, com.tencent.ntcompose.foundation.layout.l lVar, Boolean bool, to3.a aVar, Boolean bool2, Boolean bool3, Boolean bool4, Float f16, Float f17, int i3, Float f18, Boolean bool5, Float f19, Boolean bool6, Function1<? super ScrollParams, Unit> function1, Function1<? super ScrollParams, Unit> function12, Function1<? super ScrollParams, Unit> function13, Function1<? super ScrollParams, Unit> function14, Function2<? super Float, ? super Float, Unit> function22, Function1<? super co, Unit> function15, final Function3<? super com.tencent.ntcompose.foundation.lazy.layout.a, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i16, final int i17, final int i18, final int i19) {
        int i26;
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
        Function1<? super ScrollParams, Unit> function16;
        int i76;
        int i77;
        int i78;
        int i79;
        int i85;
        Composer composer2;
        final Float f26;
        final Boolean bool7;
        Float f27;
        final Boolean bool8;
        final Function1<? super ScrollParams, Unit> function17;
        final Function1<? super ScrollParams, Unit> function18;
        final Function1<? super ScrollParams, Unit> function19;
        final Function1<? super ScrollParams, Unit> function110;
        final Function2<? super Float, ? super Float, Unit> function23;
        final Function1<? super co, Unit> function111;
        final com.tencent.ntcompose.core.i iVar2;
        final Function2<? super aq<?, ?>, ? super com.tencent.kuikly.core.base.aa<aq<?, ?>>, Unit> function24;
        final com.tencent.ntcompose.foundation.lazy.d dVar2;
        final com.tencent.ntcompose.foundation.layout.l lVar2;
        final Boolean bool9;
        final to3.a aVar2;
        final Boolean bool10;
        final Boolean bool11;
        final Boolean bool12;
        final Float f28;
        final Float f29;
        final int i86;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(1635551757);
        int i87 = i19 & 1;
        if (i87 != 0) {
            i26 = i16 | 6;
        } else if ((i16 & 14) == 0) {
            i26 = (startRestartGroup.changed(iVar) ? 4 : 2) | i16;
        } else {
            i26 = i16;
        }
        int i88 = i19 & 2;
        if (i88 != 0) {
            i26 |= 48;
        } else if ((i16 & 112) == 0) {
            i26 |= startRestartGroup.changed(function2) ? 32 : 16;
            i27 = i19 & 4;
            if (i27 == 0) {
                i26 |= MsgConstant.KRMFILETHUMBSIZE384;
            } else if ((i16 & 896) == 0) {
                i26 |= startRestartGroup.changed(dVar) ? 256 : 128;
                i28 = i19 & 8;
                if (i28 != 0) {
                    i26 |= 3072;
                } else if ((i16 & 7168) == 0) {
                    i26 |= startRestartGroup.changed(lVar) ? 2048 : 1024;
                    i29 = i19 & 16;
                    if (i29 == 0) {
                        i26 |= 24576;
                    } else if ((i16 & 57344) == 0) {
                        i26 |= startRestartGroup.changed(bool) ? 16384 : 8192;
                    }
                    i36 = i19 & 32;
                    if (i36 == 0) {
                        i26 |= 196608;
                    } else if ((i16 & 458752) == 0) {
                        i26 |= startRestartGroup.changed(aVar) ? 131072 : 65536;
                    }
                    i37 = i19 & 64;
                    if (i37 == 0) {
                        i26 |= 1572864;
                    } else if ((i16 & 3670016) == 0) {
                        i26 |= startRestartGroup.changed(bool2) ? 1048576 : 524288;
                    }
                    i38 = i19 & 128;
                    if (i38 == 0) {
                        i26 |= 12582912;
                    } else if ((i16 & 29360128) == 0) {
                        i26 |= startRestartGroup.changed(bool3) ? 8388608 : 4194304;
                    }
                    i39 = i19 & 256;
                    if (i39 == 0) {
                        i26 |= 100663296;
                    } else if ((i16 & 234881024) == 0) {
                        i26 |= startRestartGroup.changed(bool4) ? 67108864 : 33554432;
                    }
                    i46 = i19 & 512;
                    if (i46 == 0) {
                        i26 |= 805306368;
                    } else if ((i16 & 1879048192) == 0) {
                        i26 |= startRestartGroup.changed(f16) ? 536870912 : 268435456;
                    }
                    i47 = i19 & 1024;
                    if (i47 == 0) {
                        i48 = i17 | 6;
                    } else if ((i17 & 14) == 0) {
                        i48 = i17 | (startRestartGroup.changed(f17) ? 4 : 2);
                    } else {
                        i48 = i17;
                    }
                    i49 = i19 & 2048;
                    if (i49 == 0) {
                        i48 |= 48;
                    } else if ((i17 & 112) == 0) {
                        i48 |= startRestartGroup.changed(i3) ? 32 : 16;
                    }
                    int i89 = i48;
                    i56 = i19 & 4096;
                    if (i56 == 0) {
                        i89 |= MsgConstant.KRMFILETHUMBSIZE384;
                        i57 = i56;
                    } else {
                        i57 = i56;
                        if ((i17 & 896) == 0) {
                            i89 |= startRestartGroup.changed(f18) ? 256 : 128;
                            i58 = i19 & 8192;
                            if (i58 != 0) {
                                i89 |= 3072;
                                i59 = i58;
                            } else {
                                i59 = i58;
                                if ((i17 & 7168) == 0) {
                                    i89 |= startRestartGroup.changed(bool5) ? 2048 : 1024;
                                    i65 = i19 & 16384;
                                    if (i65 == 0) {
                                        i89 |= 24576;
                                    } else if ((i17 & 57344) == 0) {
                                        i66 = i65;
                                        i89 |= startRestartGroup.changed(f19) ? 16384 : 8192;
                                        i67 = i19 & 32768;
                                        if (i67 != 0) {
                                            i89 |= 196608;
                                        } else if ((i17 & 458752) == 0) {
                                            i89 |= startRestartGroup.changed(bool6) ? 131072 : 65536;
                                        }
                                        i68 = i19 & 65536;
                                        if (i68 != 0) {
                                            i89 |= 1572864;
                                        } else if ((i17 & 3670016) == 0) {
                                            i89 |= startRestartGroup.changed(function1) ? 1048576 : 524288;
                                        }
                                        i69 = i19 & 131072;
                                        if (i69 != 0) {
                                            i89 |= 12582912;
                                        } else if ((i17 & 29360128) == 0) {
                                            i89 |= startRestartGroup.changed(function12) ? 8388608 : 4194304;
                                        }
                                        i75 = i19 & 262144;
                                        if (i75 != 0) {
                                            i89 |= 100663296;
                                            function16 = function13;
                                        } else {
                                            function16 = function13;
                                            if ((i17 & 234881024) == 0) {
                                                i89 |= startRestartGroup.changed(function16) ? 67108864 : 33554432;
                                            }
                                        }
                                        i76 = i19 & 524288;
                                        if (i76 != 0) {
                                            i89 |= 805306368;
                                        } else if ((i17 & 1879048192) == 0) {
                                            i89 |= startRestartGroup.changed(function14) ? 536870912 : 268435456;
                                        }
                                        i77 = i19 & 1048576;
                                        if (i77 != 0) {
                                            i78 = i18 | 6;
                                        } else if ((i18 & 14) == 0) {
                                            i78 = i18 | (startRestartGroup.changed(function22) ? 4 : 2);
                                        } else {
                                            i78 = i18;
                                        }
                                        i79 = i19 & 2097152;
                                        if (i79 != 0) {
                                            i78 |= 48;
                                        } else if ((i18 & 112) == 0) {
                                            i78 |= startRestartGroup.changed(function15) ? 32 : 16;
                                        }
                                        i85 = i78;
                                        if ((i19 & 4194304) != 0) {
                                            i85 |= MsgConstant.KRMFILETHUMBSIZE384;
                                        } else if ((i18 & 896) == 0) {
                                            i85 |= startRestartGroup.changed(content) ? 256 : 128;
                                        }
                                        if ((1533916891 & i26) != 306783378 && (1533916891 & i89) == 306783378 && (i85 & TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_EMPTY) == 146 && startRestartGroup.getSkipping()) {
                                            startRestartGroup.skipToGroupEnd();
                                            iVar2 = iVar;
                                            function24 = function2;
                                            dVar2 = dVar;
                                            lVar2 = lVar;
                                            bool9 = bool;
                                            aVar2 = aVar;
                                            bool10 = bool2;
                                            bool11 = bool3;
                                            bool12 = bool4;
                                            f29 = f17;
                                            i86 = i3;
                                            f26 = f18;
                                            f27 = f19;
                                            bool8 = bool6;
                                            function17 = function1;
                                            function18 = function12;
                                            function110 = function14;
                                            function23 = function22;
                                            function111 = function15;
                                            composer2 = startRestartGroup;
                                            function19 = function16;
                                            f28 = f16;
                                            bool7 = bool5;
                                        } else {
                                            com.tencent.ntcompose.core.i iVar3 = i87 != 0 ? com.tencent.ntcompose.core.i.INSTANCE : iVar;
                                            Function2<? super aq<?, ?>, ? super com.tencent.kuikly.core.base.aa<aq<?, ?>>, Unit> function25 = i88 != 0 ? null : function2;
                                            com.tencent.ntcompose.foundation.lazy.d dVar3 = i27 != 0 ? null : dVar;
                                            com.tencent.ntcompose.foundation.layout.l lVar3 = i28 != 0 ? null : lVar;
                                            Boolean bool13 = i29 != 0 ? null : bool;
                                            to3.a aVar3 = i36 != 0 ? null : aVar;
                                            Boolean bool14 = i37 != 0 ? null : bool2;
                                            Boolean bool15 = i38 != 0 ? null : bool3;
                                            Boolean bool16 = i39 != 0 ? null : bool4;
                                            Float f36 = i46 != 0 ? null : f16;
                                            Float f37 = i47 != 0 ? null : f17;
                                            int i95 = i49 != 0 ? 3 : i3;
                                            Float f38 = i57 != 0 ? null : f18;
                                            Boolean bool17 = i59 != 0 ? null : bool5;
                                            Float f39 = i66 != 0 ? null : f19;
                                            Boolean bool18 = i67 != 0 ? null : bool6;
                                            Function1<? super ScrollParams, Unit> function112 = i68 != 0 ? null : function1;
                                            Function1<? super ScrollParams, Unit> function113 = i69 != 0 ? null : function12;
                                            Function1<? super ScrollParams, Unit> function114 = i75 != 0 ? null : function16;
                                            Function1<? super ScrollParams, Unit> function115 = i76 != 0 ? null : function14;
                                            Function2<? super Float, ? super Float, Unit> function26 = i77 != 0 ? null : function22;
                                            Function1<? super co, Unit> function116 = i79 != 0 ? null : function15;
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1635551757, i26, i89, "com.tencent.ntcompose.material.LazyRow (LazyRow.kt:57)");
                                            }
                                            int i96 = i26 << 3;
                                            int i97 = (i26 & 14) | 3072 | (i26 & 112) | (i26 & 896) | (i96 & 57344) | (i96 & 458752) | (i96 & 3670016) | (i96 & 29360128) | (i96 & 234881024) | (i96 & 1879048192);
                                            int i98 = i89 << 3;
                                            int i99 = ((i26 >> 27) & 14) | (i98 & 112) | (i98 & 896) | (i98 & 7168) | (i98 & 57344) | (i98 & 458752) | (i98 & 3670016) | (i98 & 29360128) | (i98 & 234881024) | (i98 & 1879048192);
                                            int i100 = i85 << 3;
                                            composer2 = startRestartGroup;
                                            LazyListKt.a(iVar3, function25, dVar3, ListItemsLayoutType.RowLinear, lVar3, bool13, aVar3, bool14, bool15, bool16, f36, f37, i95, f38, bool17, f39, bool18, function112, function113, function114, function115, function26, function116, null, content, composer2, i97, i99, ((i89 >> 27) & 14) | (i100 & 112) | (i100 & 896) | ((i85 << 6) & 57344), 8388608);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            f26 = f38;
                                            bool7 = bool17;
                                            f27 = f39;
                                            bool8 = bool18;
                                            function17 = function112;
                                            function18 = function113;
                                            function19 = function114;
                                            function110 = function115;
                                            function23 = function26;
                                            function111 = function116;
                                            iVar2 = iVar3;
                                            function24 = function25;
                                            dVar2 = dVar3;
                                            lVar2 = lVar3;
                                            bool9 = bool13;
                                            aVar2 = aVar3;
                                            bool10 = bool14;
                                            bool11 = bool15;
                                            bool12 = bool16;
                                            f28 = f36;
                                            f29 = f37;
                                            i86 = i95;
                                        }
                                        endRestartGroup = composer2.endRestartGroup();
                                        if (endRestartGroup == null) {
                                            return;
                                        }
                                        final Float f46 = f27;
                                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.LazyRowKt$LazyRow$1
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

                                            public final void invoke(Composer composer3, int i101) {
                                                LazyRowKt.a(com.tencent.ntcompose.core.i.this, function24, dVar2, lVar2, bool9, aVar2, bool10, bool11, bool12, f28, f29, i86, f26, bool7, f46, bool8, function17, function18, function19, function110, function23, function111, content, composer3, i16 | 1, i17, i18, i19);
                                            }
                                        });
                                        return;
                                    }
                                    i66 = i65;
                                    i67 = i19 & 32768;
                                    if (i67 != 0) {
                                    }
                                    i68 = i19 & 65536;
                                    if (i68 != 0) {
                                    }
                                    i69 = i19 & 131072;
                                    if (i69 != 0) {
                                    }
                                    i75 = i19 & 262144;
                                    if (i75 != 0) {
                                    }
                                    i76 = i19 & 524288;
                                    if (i76 != 0) {
                                    }
                                    i77 = i19 & 1048576;
                                    if (i77 != 0) {
                                    }
                                    i79 = i19 & 2097152;
                                    if (i79 != 0) {
                                    }
                                    i85 = i78;
                                    if ((i19 & 4194304) != 0) {
                                    }
                                    if ((1533916891 & i26) != 306783378) {
                                    }
                                    if (i87 != 0) {
                                    }
                                    if (i88 != 0) {
                                    }
                                    if (i27 != 0) {
                                    }
                                    if (i28 != 0) {
                                    }
                                    if (i29 != 0) {
                                    }
                                    if (i36 != 0) {
                                    }
                                    if (i37 != 0) {
                                    }
                                    if (i38 != 0) {
                                    }
                                    if (i39 != 0) {
                                    }
                                    if (i46 != 0) {
                                    }
                                    if (i47 != 0) {
                                    }
                                    if (i49 != 0) {
                                    }
                                    if (i57 != 0) {
                                    }
                                    if (i59 != 0) {
                                    }
                                    if (i66 != 0) {
                                    }
                                    if (i67 != 0) {
                                    }
                                    if (i68 != 0) {
                                    }
                                    if (i69 != 0) {
                                    }
                                    if (i75 != 0) {
                                    }
                                    if (i76 != 0) {
                                    }
                                    if (i77 != 0) {
                                    }
                                    if (i79 != 0) {
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    int i962 = i26 << 3;
                                    int i972 = (i26 & 14) | 3072 | (i26 & 112) | (i26 & 896) | (i962 & 57344) | (i962 & 458752) | (i962 & 3670016) | (i962 & 29360128) | (i962 & 234881024) | (i962 & 1879048192);
                                    int i982 = i89 << 3;
                                    int i992 = ((i26 >> 27) & 14) | (i982 & 112) | (i982 & 896) | (i982 & 7168) | (i982 & 57344) | (i982 & 458752) | (i982 & 3670016) | (i982 & 29360128) | (i982 & 234881024) | (i982 & 1879048192);
                                    int i1002 = i85 << 3;
                                    composer2 = startRestartGroup;
                                    LazyListKt.a(iVar3, function25, dVar3, ListItemsLayoutType.RowLinear, lVar3, bool13, aVar3, bool14, bool15, bool16, f36, f37, i95, f38, bool17, f39, bool18, function112, function113, function114, function115, function26, function116, null, content, composer2, i972, i992, ((i89 >> 27) & 14) | (i1002 & 112) | (i1002 & 896) | ((i85 << 6) & 57344), 8388608);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    f26 = f38;
                                    bool7 = bool17;
                                    f27 = f39;
                                    bool8 = bool18;
                                    function17 = function112;
                                    function18 = function113;
                                    function19 = function114;
                                    function110 = function115;
                                    function23 = function26;
                                    function111 = function116;
                                    iVar2 = iVar3;
                                    function24 = function25;
                                    dVar2 = dVar3;
                                    lVar2 = lVar3;
                                    bool9 = bool13;
                                    aVar2 = aVar3;
                                    bool10 = bool14;
                                    bool11 = bool15;
                                    bool12 = bool16;
                                    f28 = f36;
                                    f29 = f37;
                                    i86 = i95;
                                    endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup == null) {
                                    }
                                }
                            }
                            i65 = i19 & 16384;
                            if (i65 == 0) {
                            }
                            i66 = i65;
                            i67 = i19 & 32768;
                            if (i67 != 0) {
                            }
                            i68 = i19 & 65536;
                            if (i68 != 0) {
                            }
                            i69 = i19 & 131072;
                            if (i69 != 0) {
                            }
                            i75 = i19 & 262144;
                            if (i75 != 0) {
                            }
                            i76 = i19 & 524288;
                            if (i76 != 0) {
                            }
                            i77 = i19 & 1048576;
                            if (i77 != 0) {
                            }
                            i79 = i19 & 2097152;
                            if (i79 != 0) {
                            }
                            i85 = i78;
                            if ((i19 & 4194304) != 0) {
                            }
                            if ((1533916891 & i26) != 306783378) {
                            }
                            if (i87 != 0) {
                            }
                            if (i88 != 0) {
                            }
                            if (i27 != 0) {
                            }
                            if (i28 != 0) {
                            }
                            if (i29 != 0) {
                            }
                            if (i36 != 0) {
                            }
                            if (i37 != 0) {
                            }
                            if (i38 != 0) {
                            }
                            if (i39 != 0) {
                            }
                            if (i46 != 0) {
                            }
                            if (i47 != 0) {
                            }
                            if (i49 != 0) {
                            }
                            if (i57 != 0) {
                            }
                            if (i59 != 0) {
                            }
                            if (i66 != 0) {
                            }
                            if (i67 != 0) {
                            }
                            if (i68 != 0) {
                            }
                            if (i69 != 0) {
                            }
                            if (i75 != 0) {
                            }
                            if (i76 != 0) {
                            }
                            if (i77 != 0) {
                            }
                            if (i79 != 0) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i9622 = i26 << 3;
                            int i9722 = (i26 & 14) | 3072 | (i26 & 112) | (i26 & 896) | (i9622 & 57344) | (i9622 & 458752) | (i9622 & 3670016) | (i9622 & 29360128) | (i9622 & 234881024) | (i9622 & 1879048192);
                            int i9822 = i89 << 3;
                            int i9922 = ((i26 >> 27) & 14) | (i9822 & 112) | (i9822 & 896) | (i9822 & 7168) | (i9822 & 57344) | (i9822 & 458752) | (i9822 & 3670016) | (i9822 & 29360128) | (i9822 & 234881024) | (i9822 & 1879048192);
                            int i10022 = i85 << 3;
                            composer2 = startRestartGroup;
                            LazyListKt.a(iVar3, function25, dVar3, ListItemsLayoutType.RowLinear, lVar3, bool13, aVar3, bool14, bool15, bool16, f36, f37, i95, f38, bool17, f39, bool18, function112, function113, function114, function115, function26, function116, null, content, composer2, i9722, i9922, ((i89 >> 27) & 14) | (i10022 & 112) | (i10022 & 896) | ((i85 << 6) & 57344), 8388608);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            f26 = f38;
                            bool7 = bool17;
                            f27 = f39;
                            bool8 = bool18;
                            function17 = function112;
                            function18 = function113;
                            function19 = function114;
                            function110 = function115;
                            function23 = function26;
                            function111 = function116;
                            iVar2 = iVar3;
                            function24 = function25;
                            dVar2 = dVar3;
                            lVar2 = lVar3;
                            bool9 = bool13;
                            aVar2 = aVar3;
                            bool10 = bool14;
                            bool11 = bool15;
                            bool12 = bool16;
                            f28 = f36;
                            f29 = f37;
                            i86 = i95;
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                            }
                        }
                    }
                    i58 = i19 & 8192;
                    if (i58 != 0) {
                    }
                    i65 = i19 & 16384;
                    if (i65 == 0) {
                    }
                    i66 = i65;
                    i67 = i19 & 32768;
                    if (i67 != 0) {
                    }
                    i68 = i19 & 65536;
                    if (i68 != 0) {
                    }
                    i69 = i19 & 131072;
                    if (i69 != 0) {
                    }
                    i75 = i19 & 262144;
                    if (i75 != 0) {
                    }
                    i76 = i19 & 524288;
                    if (i76 != 0) {
                    }
                    i77 = i19 & 1048576;
                    if (i77 != 0) {
                    }
                    i79 = i19 & 2097152;
                    if (i79 != 0) {
                    }
                    i85 = i78;
                    if ((i19 & 4194304) != 0) {
                    }
                    if ((1533916891 & i26) != 306783378) {
                    }
                    if (i87 != 0) {
                    }
                    if (i88 != 0) {
                    }
                    if (i27 != 0) {
                    }
                    if (i28 != 0) {
                    }
                    if (i29 != 0) {
                    }
                    if (i36 != 0) {
                    }
                    if (i37 != 0) {
                    }
                    if (i38 != 0) {
                    }
                    if (i39 != 0) {
                    }
                    if (i46 != 0) {
                    }
                    if (i47 != 0) {
                    }
                    if (i49 != 0) {
                    }
                    if (i57 != 0) {
                    }
                    if (i59 != 0) {
                    }
                    if (i66 != 0) {
                    }
                    if (i67 != 0) {
                    }
                    if (i68 != 0) {
                    }
                    if (i69 != 0) {
                    }
                    if (i75 != 0) {
                    }
                    if (i76 != 0) {
                    }
                    if (i77 != 0) {
                    }
                    if (i79 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i96222 = i26 << 3;
                    int i97222 = (i26 & 14) | 3072 | (i26 & 112) | (i26 & 896) | (i96222 & 57344) | (i96222 & 458752) | (i96222 & 3670016) | (i96222 & 29360128) | (i96222 & 234881024) | (i96222 & 1879048192);
                    int i98222 = i89 << 3;
                    int i99222 = ((i26 >> 27) & 14) | (i98222 & 112) | (i98222 & 896) | (i98222 & 7168) | (i98222 & 57344) | (i98222 & 458752) | (i98222 & 3670016) | (i98222 & 29360128) | (i98222 & 234881024) | (i98222 & 1879048192);
                    int i100222 = i85 << 3;
                    composer2 = startRestartGroup;
                    LazyListKt.a(iVar3, function25, dVar3, ListItemsLayoutType.RowLinear, lVar3, bool13, aVar3, bool14, bool15, bool16, f36, f37, i95, f38, bool17, f39, bool18, function112, function113, function114, function115, function26, function116, null, content, composer2, i97222, i99222, ((i89 >> 27) & 14) | (i100222 & 112) | (i100222 & 896) | ((i85 << 6) & 57344), 8388608);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    f26 = f38;
                    bool7 = bool17;
                    f27 = f39;
                    bool8 = bool18;
                    function17 = function112;
                    function18 = function113;
                    function19 = function114;
                    function110 = function115;
                    function23 = function26;
                    function111 = function116;
                    iVar2 = iVar3;
                    function24 = function25;
                    dVar2 = dVar3;
                    lVar2 = lVar3;
                    bool9 = bool13;
                    aVar2 = aVar3;
                    bool10 = bool14;
                    bool11 = bool15;
                    bool12 = bool16;
                    f28 = f36;
                    f29 = f37;
                    i86 = i95;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i29 = i19 & 16;
                if (i29 == 0) {
                }
                i36 = i19 & 32;
                if (i36 == 0) {
                }
                i37 = i19 & 64;
                if (i37 == 0) {
                }
                i38 = i19 & 128;
                if (i38 == 0) {
                }
                i39 = i19 & 256;
                if (i39 == 0) {
                }
                i46 = i19 & 512;
                if (i46 == 0) {
                }
                i47 = i19 & 1024;
                if (i47 == 0) {
                }
                i49 = i19 & 2048;
                if (i49 == 0) {
                }
                int i892 = i48;
                i56 = i19 & 4096;
                if (i56 == 0) {
                }
                i58 = i19 & 8192;
                if (i58 != 0) {
                }
                i65 = i19 & 16384;
                if (i65 == 0) {
                }
                i66 = i65;
                i67 = i19 & 32768;
                if (i67 != 0) {
                }
                i68 = i19 & 65536;
                if (i68 != 0) {
                }
                i69 = i19 & 131072;
                if (i69 != 0) {
                }
                i75 = i19 & 262144;
                if (i75 != 0) {
                }
                i76 = i19 & 524288;
                if (i76 != 0) {
                }
                i77 = i19 & 1048576;
                if (i77 != 0) {
                }
                i79 = i19 & 2097152;
                if (i79 != 0) {
                }
                i85 = i78;
                if ((i19 & 4194304) != 0) {
                }
                if ((1533916891 & i26) != 306783378) {
                }
                if (i87 != 0) {
                }
                if (i88 != 0) {
                }
                if (i27 != 0) {
                }
                if (i28 != 0) {
                }
                if (i29 != 0) {
                }
                if (i36 != 0) {
                }
                if (i37 != 0) {
                }
                if (i38 != 0) {
                }
                if (i39 != 0) {
                }
                if (i46 != 0) {
                }
                if (i47 != 0) {
                }
                if (i49 != 0) {
                }
                if (i57 != 0) {
                }
                if (i59 != 0) {
                }
                if (i66 != 0) {
                }
                if (i67 != 0) {
                }
                if (i68 != 0) {
                }
                if (i69 != 0) {
                }
                if (i75 != 0) {
                }
                if (i76 != 0) {
                }
                if (i77 != 0) {
                }
                if (i79 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                int i962222 = i26 << 3;
                int i972222 = (i26 & 14) | 3072 | (i26 & 112) | (i26 & 896) | (i962222 & 57344) | (i962222 & 458752) | (i962222 & 3670016) | (i962222 & 29360128) | (i962222 & 234881024) | (i962222 & 1879048192);
                int i982222 = i892 << 3;
                int i992222 = ((i26 >> 27) & 14) | (i982222 & 112) | (i982222 & 896) | (i982222 & 7168) | (i982222 & 57344) | (i982222 & 458752) | (i982222 & 3670016) | (i982222 & 29360128) | (i982222 & 234881024) | (i982222 & 1879048192);
                int i1002222 = i85 << 3;
                composer2 = startRestartGroup;
                LazyListKt.a(iVar3, function25, dVar3, ListItemsLayoutType.RowLinear, lVar3, bool13, aVar3, bool14, bool15, bool16, f36, f37, i95, f38, bool17, f39, bool18, function112, function113, function114, function115, function26, function116, null, content, composer2, i972222, i992222, ((i892 >> 27) & 14) | (i1002222 & 112) | (i1002222 & 896) | ((i85 << 6) & 57344), 8388608);
                if (ComposerKt.isTraceInProgress()) {
                }
                f26 = f38;
                bool7 = bool17;
                f27 = f39;
                bool8 = bool18;
                function17 = function112;
                function18 = function113;
                function19 = function114;
                function110 = function115;
                function23 = function26;
                function111 = function116;
                iVar2 = iVar3;
                function24 = function25;
                dVar2 = dVar3;
                lVar2 = lVar3;
                bool9 = bool13;
                aVar2 = aVar3;
                bool10 = bool14;
                bool11 = bool15;
                bool12 = bool16;
                f28 = f36;
                f29 = f37;
                i86 = i95;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i28 = i19 & 8;
            if (i28 != 0) {
            }
            i29 = i19 & 16;
            if (i29 == 0) {
            }
            i36 = i19 & 32;
            if (i36 == 0) {
            }
            i37 = i19 & 64;
            if (i37 == 0) {
            }
            i38 = i19 & 128;
            if (i38 == 0) {
            }
            i39 = i19 & 256;
            if (i39 == 0) {
            }
            i46 = i19 & 512;
            if (i46 == 0) {
            }
            i47 = i19 & 1024;
            if (i47 == 0) {
            }
            i49 = i19 & 2048;
            if (i49 == 0) {
            }
            int i8922 = i48;
            i56 = i19 & 4096;
            if (i56 == 0) {
            }
            i58 = i19 & 8192;
            if (i58 != 0) {
            }
            i65 = i19 & 16384;
            if (i65 == 0) {
            }
            i66 = i65;
            i67 = i19 & 32768;
            if (i67 != 0) {
            }
            i68 = i19 & 65536;
            if (i68 != 0) {
            }
            i69 = i19 & 131072;
            if (i69 != 0) {
            }
            i75 = i19 & 262144;
            if (i75 != 0) {
            }
            i76 = i19 & 524288;
            if (i76 != 0) {
            }
            i77 = i19 & 1048576;
            if (i77 != 0) {
            }
            i79 = i19 & 2097152;
            if (i79 != 0) {
            }
            i85 = i78;
            if ((i19 & 4194304) != 0) {
            }
            if ((1533916891 & i26) != 306783378) {
            }
            if (i87 != 0) {
            }
            if (i88 != 0) {
            }
            if (i27 != 0) {
            }
            if (i28 != 0) {
            }
            if (i29 != 0) {
            }
            if (i36 != 0) {
            }
            if (i37 != 0) {
            }
            if (i38 != 0) {
            }
            if (i39 != 0) {
            }
            if (i46 != 0) {
            }
            if (i47 != 0) {
            }
            if (i49 != 0) {
            }
            if (i57 != 0) {
            }
            if (i59 != 0) {
            }
            if (i66 != 0) {
            }
            if (i67 != 0) {
            }
            if (i68 != 0) {
            }
            if (i69 != 0) {
            }
            if (i75 != 0) {
            }
            if (i76 != 0) {
            }
            if (i77 != 0) {
            }
            if (i79 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            int i9622222 = i26 << 3;
            int i9722222 = (i26 & 14) | 3072 | (i26 & 112) | (i26 & 896) | (i9622222 & 57344) | (i9622222 & 458752) | (i9622222 & 3670016) | (i9622222 & 29360128) | (i9622222 & 234881024) | (i9622222 & 1879048192);
            int i9822222 = i8922 << 3;
            int i9922222 = ((i26 >> 27) & 14) | (i9822222 & 112) | (i9822222 & 896) | (i9822222 & 7168) | (i9822222 & 57344) | (i9822222 & 458752) | (i9822222 & 3670016) | (i9822222 & 29360128) | (i9822222 & 234881024) | (i9822222 & 1879048192);
            int i10022222 = i85 << 3;
            composer2 = startRestartGroup;
            LazyListKt.a(iVar3, function25, dVar3, ListItemsLayoutType.RowLinear, lVar3, bool13, aVar3, bool14, bool15, bool16, f36, f37, i95, f38, bool17, f39, bool18, function112, function113, function114, function115, function26, function116, null, content, composer2, i9722222, i9922222, ((i8922 >> 27) & 14) | (i10022222 & 112) | (i10022222 & 896) | ((i85 << 6) & 57344), 8388608);
            if (ComposerKt.isTraceInProgress()) {
            }
            f26 = f38;
            bool7 = bool17;
            f27 = f39;
            bool8 = bool18;
            function17 = function112;
            function18 = function113;
            function19 = function114;
            function110 = function115;
            function23 = function26;
            function111 = function116;
            iVar2 = iVar3;
            function24 = function25;
            dVar2 = dVar3;
            lVar2 = lVar3;
            bool9 = bool13;
            aVar2 = aVar3;
            bool10 = bool14;
            bool11 = bool15;
            bool12 = bool16;
            f28 = f36;
            f29 = f37;
            i86 = i95;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i27 = i19 & 4;
        if (i27 == 0) {
        }
        i28 = i19 & 8;
        if (i28 != 0) {
        }
        i29 = i19 & 16;
        if (i29 == 0) {
        }
        i36 = i19 & 32;
        if (i36 == 0) {
        }
        i37 = i19 & 64;
        if (i37 == 0) {
        }
        i38 = i19 & 128;
        if (i38 == 0) {
        }
        i39 = i19 & 256;
        if (i39 == 0) {
        }
        i46 = i19 & 512;
        if (i46 == 0) {
        }
        i47 = i19 & 1024;
        if (i47 == 0) {
        }
        i49 = i19 & 2048;
        if (i49 == 0) {
        }
        int i89222 = i48;
        i56 = i19 & 4096;
        if (i56 == 0) {
        }
        i58 = i19 & 8192;
        if (i58 != 0) {
        }
        i65 = i19 & 16384;
        if (i65 == 0) {
        }
        i66 = i65;
        i67 = i19 & 32768;
        if (i67 != 0) {
        }
        i68 = i19 & 65536;
        if (i68 != 0) {
        }
        i69 = i19 & 131072;
        if (i69 != 0) {
        }
        i75 = i19 & 262144;
        if (i75 != 0) {
        }
        i76 = i19 & 524288;
        if (i76 != 0) {
        }
        i77 = i19 & 1048576;
        if (i77 != 0) {
        }
        i79 = i19 & 2097152;
        if (i79 != 0) {
        }
        i85 = i78;
        if ((i19 & 4194304) != 0) {
        }
        if ((1533916891 & i26) != 306783378) {
        }
        if (i87 != 0) {
        }
        if (i88 != 0) {
        }
        if (i27 != 0) {
        }
        if (i28 != 0) {
        }
        if (i29 != 0) {
        }
        if (i36 != 0) {
        }
        if (i37 != 0) {
        }
        if (i38 != 0) {
        }
        if (i39 != 0) {
        }
        if (i46 != 0) {
        }
        if (i47 != 0) {
        }
        if (i49 != 0) {
        }
        if (i57 != 0) {
        }
        if (i59 != 0) {
        }
        if (i66 != 0) {
        }
        if (i67 != 0) {
        }
        if (i68 != 0) {
        }
        if (i69 != 0) {
        }
        if (i75 != 0) {
        }
        if (i76 != 0) {
        }
        if (i77 != 0) {
        }
        if (i79 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        int i96222222 = i26 << 3;
        int i97222222 = (i26 & 14) | 3072 | (i26 & 112) | (i26 & 896) | (i96222222 & 57344) | (i96222222 & 458752) | (i96222222 & 3670016) | (i96222222 & 29360128) | (i96222222 & 234881024) | (i96222222 & 1879048192);
        int i98222222 = i89222 << 3;
        int i99222222 = ((i26 >> 27) & 14) | (i98222222 & 112) | (i98222222 & 896) | (i98222222 & 7168) | (i98222222 & 57344) | (i98222222 & 458752) | (i98222222 & 3670016) | (i98222222 & 29360128) | (i98222222 & 234881024) | (i98222222 & 1879048192);
        int i100222222 = i85 << 3;
        composer2 = startRestartGroup;
        LazyListKt.a(iVar3, function25, dVar3, ListItemsLayoutType.RowLinear, lVar3, bool13, aVar3, bool14, bool15, bool16, f36, f37, i95, f38, bool17, f39, bool18, function112, function113, function114, function115, function26, function116, null, content, composer2, i97222222, i99222222, ((i89222 >> 27) & 14) | (i100222222 & 112) | (i100222222 & 896) | ((i85 << 6) & 57344), 8388608);
        if (ComposerKt.isTraceInProgress()) {
        }
        f26 = f38;
        bool7 = bool17;
        f27 = f39;
        bool8 = bool18;
        function17 = function112;
        function18 = function113;
        function19 = function114;
        function110 = function115;
        function23 = function26;
        function111 = function116;
        iVar2 = iVar3;
        function24 = function25;
        dVar2 = dVar3;
        lVar2 = lVar3;
        bool9 = bool13;
        aVar2 = aVar3;
        bool10 = bool14;
        bool11 = bool15;
        bool12 = bool16;
        f28 = f36;
        f29 = f37;
        i86 = i95;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
