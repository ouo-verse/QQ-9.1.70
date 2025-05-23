package com.tencent.ntcompose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.hippy.qq.view.viola.list.TkdListView;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.ScrollerAttr;
import com.tencent.kuikly.core.views.cm;
import com.tencent.kuikly.core.views.co;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.ntcompose.material.r;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u00d5\u0004\u00107\u001a\u00020\f2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042B\b\u0002\u0010\u000f\u001a<\u0012\u0004\u0012\u00020\u0007\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\r\u00a2\u0006\u0002\b\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00042+\b\u0002\u0010*\u001a%\u0012\u0013\u0012\u00110'\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\f\u0018\u00010&j\u0004\u0018\u0001`)2+\b\u0002\u0010+\u001a%\u0012\u0013\u0012\u00110'\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\f\u0018\u00010&j\u0004\u0018\u0001`)2+\b\u0002\u0010,\u001a%\u0012\u0013\u0012\u00110'\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\f\u0018\u00010&j\u0004\u0018\u0001`)2+\b\u0002\u0010-\u001a%\u0012\u0013\u0012\u00110'\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\f\u0018\u00010&j\u0004\u0018\u0001`)2@\b\u0002\u00101\u001a:\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(.\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006j\u0004\u0018\u0001`02\u0016\b\u0002\u00103\u001a\u0010\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\f\u0018\u00010&2\u001c\u00106\u001a\u0018\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\f0&\u00a2\u0006\u0002\b5\u00a2\u0006\u0002\b\u000eH\u0007\u00a2\u0006\u0004\b7\u00108\u00a8\u00069"}, d2 = {"Lcom/tencent/ntcompose/material/r;", "columns", "Lcom/tencent/ntcompose/core/i;", "modifier", "", "listWidth", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/views/cm;", "Lcom/tencent/kuikly/core/base/aa;", "Lkotlin/ParameterName;", "name", "viewRef", "", "Lcom/tencent/ntcompose/core/RefFunc;", "Lkotlin/ExtensionFunctionType;", "ref", "Lcom/tencent/ntcompose/foundation/lazy/a;", "state", "Lcom/tencent/ntcompose/foundation/layout/l;", "contentPadding", "columnsSpacing", "rowsSpacing", "", "userScrollEnabled", "Lto3/a;", "flingBehavior", ScrollerAttr.BOUNCES_ENABLE, ScrollerAttr.SHOW_SCROLLER_INDICATOR, "pagingEnable", "Lcom/tencent/ntcompose/material/GridLayoutMode;", "gridLayoutMode", "visibleAreaIgnoreTopMargin", "visibleAreaIgnoreBottomMargin", "", "firstLoadMaxIndex", "preloadViewDistance", "syncScroll", ScrollerAttr.SYNC_SCROLL_IN_MAX_OFFSET, "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/views/bn;", "e", "Lcom/tencent/ntcompose/material/ListEventCallback;", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, TkdListView.EVENT_TYPE_SCROLL_END, "onBeginDrag", "onEndDrag", "width", "height", "Lcom/tencent/ntcompose/material/ContentSizeChangedEventCallback;", "onContentSizeChanged", "Lcom/tencent/kuikly/core/views/co;", "onWillDragEndBySync", "Lcom/tencent/ntcompose/foundation/lazy/layout/a;", "Landroidx/compose/runtime/Composable;", "content", "a", "(Lcom/tencent/ntcompose/material/r;Lcom/tencent/ntcompose/core/i;FLkotlin/jvm/functions/Function2;Lcom/tencent/ntcompose/foundation/lazy/a;Lcom/tencent/ntcompose/foundation/layout/l;FFLjava/lang/Boolean;Lto3/a;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/tencent/ntcompose/material/GridLayoutMode;Ljava/lang/Float;Ljava/lang/Float;ILjava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Float;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;IIII)V", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class LazyVerticalGridKt {
    /* JADX WARN: Removed duplicated region for block: B:107:0x06a5  */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x051b  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x05a4  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x05cd  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0669  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x05cf  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x042d  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0459  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x046d  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0474  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x047b  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0482  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0489  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0490  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0497  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x049e  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x04a5  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x04ac  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x04df  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x04a8  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x04a1  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x049a  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0493  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x048c  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0485  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x047e  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0477  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0470  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0469  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0462  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x045b  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0443  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x043d  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0430  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0422  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:374:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x036a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(r rVar, com.tencent.ntcompose.core.i iVar, final float f16, Function2<? super cm, ? super com.tencent.kuikly.core.base.aa<cm>, Unit> function2, com.tencent.ntcompose.foundation.lazy.a aVar, com.tencent.ntcompose.foundation.layout.l lVar, float f17, float f18, Boolean bool, to3.a aVar2, Boolean bool2, Boolean bool3, Boolean bool4, GridLayoutMode gridLayoutMode, Float f19, Float f26, int i3, Float f27, Boolean bool5, Float f28, Function1<? super ScrollParams, Unit> function1, Function1<? super ScrollParams, Unit> function12, Function1<? super ScrollParams, Unit> function13, Function1<? super ScrollParams, Unit> function14, Function2<? super Float, ? super Float, Unit> function22, Function1<? super co, Unit> function15, final Function3<? super com.tencent.ntcompose.foundation.lazy.layout.a, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i16, final int i17, final int i18, final int i19) {
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
        int i76;
        int i77;
        int i78;
        int i79;
        int i85;
        int i86;
        r rVar2;
        Function1<? super co, Unit> function16;
        Boolean bool6;
        to3.a aVar3;
        Boolean bool7;
        int i87;
        Boolean bool8;
        Boolean bool9;
        float f29;
        Function1<? super ScrollParams, Unit> function17;
        Function2<? super Float, ? super Float, Unit> function23;
        com.tencent.ntcompose.foundation.layout.l lVar2;
        float f36;
        GridLayoutMode gridLayoutMode2;
        Function1<? super ScrollParams, Unit> function18;
        Float f37;
        Float f38;
        int i88;
        Float f39;
        Boolean bool10;
        Float f46;
        Function1<? super ScrollParams, Unit> function19;
        Function1<? super ScrollParams, Unit> function110;
        com.tencent.ntcompose.core.i iVar2;
        r rVar3;
        Function2<? super cm, ? super com.tencent.kuikly.core.base.aa<cm>, Unit> function24;
        com.tencent.ntcompose.foundation.lazy.a aVar4;
        Composer composer2;
        final r rVar4;
        final com.tencent.ntcompose.core.i iVar3;
        final Function2<? super cm, ? super com.tencent.kuikly.core.base.aa<cm>, Unit> function25;
        final com.tencent.ntcompose.foundation.lazy.a aVar5;
        final com.tencent.ntcompose.foundation.layout.l lVar3;
        final float f47;
        final float f48;
        final Boolean bool11;
        final to3.a aVar6;
        final Boolean bool12;
        final Boolean bool13;
        final Boolean bool14;
        final GridLayoutMode gridLayoutMode3;
        final Float f49;
        final Float f56;
        final int i89;
        final Float f57;
        final Boolean bool15;
        final Float f58;
        final Function1<? super ScrollParams, Unit> function111;
        final Function1<? super ScrollParams, Unit> function112;
        final Function1<? super ScrollParams, Unit> function113;
        final Function1<? super ScrollParams, Unit> function114;
        final Function2<? super Float, ? super Float, Unit> function26;
        final Function1<? super co, Unit> function115;
        ScopeUpdateScope endRestartGroup;
        int i95;
        int i96;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(1154616877);
        if ((i16 & 14) == 0) {
            if ((i19 & 1) == 0 && startRestartGroup.changed(rVar)) {
                i96 = 4;
                i26 = i96 | i16;
            }
            i96 = 2;
            i26 = i96 | i16;
        } else {
            i26 = i16;
        }
        int i97 = i19 & 2;
        if (i97 != 0) {
            i26 |= 48;
        } else if ((i16 & 112) == 0) {
            i26 |= startRestartGroup.changed(iVar) ? 32 : 16;
            if ((i19 & 4) == 0) {
                i26 |= MsgConstant.KRMFILETHUMBSIZE384;
            } else if ((i16 & 896) == 0) {
                i26 |= startRestartGroup.changed(f16) ? 256 : 128;
                i27 = i19 & 8;
                if (i27 != 0) {
                    i26 |= 3072;
                } else if ((i16 & 7168) == 0) {
                    i26 |= startRestartGroup.changed(function2) ? 2048 : 1024;
                    i28 = i19 & 16;
                    if (i28 == 0) {
                        i26 |= 24576;
                    } else if ((i16 & 57344) == 0) {
                        i26 |= startRestartGroup.changed(aVar) ? 16384 : 8192;
                    }
                    i29 = i19 & 32;
                    if (i29 == 0) {
                        i26 |= 196608;
                    } else if ((i16 & 458752) == 0) {
                        i26 |= startRestartGroup.changed(lVar) ? 131072 : 65536;
                    }
                    i36 = i19 & 64;
                    if (i36 == 0) {
                        i26 |= 1572864;
                    } else if ((i16 & 3670016) == 0) {
                        i26 |= startRestartGroup.changed(f17) ? 1048576 : 524288;
                    }
                    i37 = i19 & 128;
                    if (i37 == 0) {
                        i26 |= 12582912;
                    } else if ((i16 & 29360128) == 0) {
                        i26 |= startRestartGroup.changed(f18) ? 8388608 : 4194304;
                    }
                    i38 = i19 & 256;
                    if (i38 == 0) {
                        i26 |= 100663296;
                    } else if ((i16 & 234881024) == 0) {
                        i26 |= startRestartGroup.changed(bool) ? 67108864 : 33554432;
                    }
                    i39 = i19 & 512;
                    if (i39 == 0) {
                        i26 |= 805306368;
                    } else if ((i16 & 1879048192) == 0) {
                        i26 |= startRestartGroup.changed(aVar2) ? 536870912 : 268435456;
                    }
                    i46 = i19 & 1024;
                    if (i46 == 0) {
                        i47 = i17 | 6;
                    } else if ((i17 & 14) == 0) {
                        i47 = i17 | (startRestartGroup.changed(bool2) ? 4 : 2);
                    } else {
                        i47 = i17;
                    }
                    i48 = i19 & 2048;
                    if (i48 == 0) {
                        i47 |= 48;
                    } else if ((i17 & 112) == 0) {
                        i47 |= startRestartGroup.changed(bool3) ? 32 : 16;
                    }
                    int i98 = i47;
                    i49 = i19 & 4096;
                    if (i49 == 0) {
                        i98 |= MsgConstant.KRMFILETHUMBSIZE384;
                    } else if ((i17 & 896) == 0) {
                        i98 |= startRestartGroup.changed(bool4) ? 256 : 128;
                        i56 = i19 & 8192;
                        if (i56 != 0) {
                            i98 |= 3072;
                            i57 = i56;
                        } else {
                            i57 = i56;
                            if ((i17 & 7168) == 0) {
                                i98 |= startRestartGroup.changed(gridLayoutMode) ? 2048 : 1024;
                                i58 = i19 & 16384;
                                if (i58 == 0) {
                                    i98 |= 24576;
                                } else if ((i17 & 57344) == 0) {
                                    i59 = i58;
                                    i98 |= startRestartGroup.changed(f19) ? 16384 : 8192;
                                    i65 = i19 & 32768;
                                    if (i65 != 0) {
                                        i98 |= 196608;
                                    } else if ((i17 & 458752) == 0) {
                                        i98 |= startRestartGroup.changed(f26) ? 131072 : 65536;
                                    }
                                    i66 = i19 & 65536;
                                    if (i66 != 0) {
                                        i98 |= 1572864;
                                    } else if ((i17 & 3670016) == 0) {
                                        i98 |= startRestartGroup.changed(i3) ? 1048576 : 524288;
                                    }
                                    i67 = i19 & 131072;
                                    if (i67 != 0) {
                                        i98 |= 12582912;
                                    } else if ((i17 & 29360128) == 0) {
                                        i98 |= startRestartGroup.changed(f27) ? 8388608 : 4194304;
                                    }
                                    i68 = i19 & 262144;
                                    if (i68 != 0) {
                                        i98 |= 100663296;
                                    } else if ((i17 & 234881024) == 0) {
                                        i98 |= startRestartGroup.changed(bool5) ? 67108864 : 33554432;
                                    }
                                    i69 = i19 & 524288;
                                    if (i69 != 0) {
                                        i98 |= 805306368;
                                    } else if ((i17 & 1879048192) == 0) {
                                        i98 |= startRestartGroup.changed(f28) ? 536870912 : 268435456;
                                    }
                                    i75 = i19 & 1048576;
                                    if (i75 != 0) {
                                        i76 = i18 | 6;
                                    } else if ((i18 & 14) == 0) {
                                        i76 = i18 | (startRestartGroup.changed(function1) ? 4 : 2);
                                    } else {
                                        i76 = i18;
                                    }
                                    i77 = i19 & 2097152;
                                    if (i77 != 0) {
                                        i76 |= 48;
                                    } else if ((i18 & 112) == 0) {
                                        i76 |= startRestartGroup.changed(function12) ? 32 : 16;
                                    }
                                    int i99 = i76;
                                    i78 = i19 & 4194304;
                                    if (i78 != 0) {
                                        i99 |= MsgConstant.KRMFILETHUMBSIZE384;
                                    } else if ((i18 & 896) == 0) {
                                        i99 |= startRestartGroup.changed(function13) ? 256 : 128;
                                        i79 = i19 & 8388608;
                                        if (i79 == 0) {
                                            i99 |= 3072;
                                        } else if ((i18 & 7168) == 0) {
                                            i99 |= startRestartGroup.changed(function14) ? 2048 : 1024;
                                            i85 = i19 & 16777216;
                                            if (i85 != 0) {
                                                i99 |= 24576;
                                            } else if ((i18 & 57344) == 0) {
                                                i99 |= startRestartGroup.changed(function22) ? 16384 : 8192;
                                            }
                                            i86 = i19 & 33554432;
                                            if (i86 != 0) {
                                                i99 |= 196608;
                                            } else if ((i18 & 458752) == 0) {
                                                i99 |= startRestartGroup.changed(function15) ? 131072 : 65536;
                                            }
                                            if ((i19 & 67108864) == 0) {
                                                i95 = (i18 & 3670016) == 0 ? startRestartGroup.changed(content) ? 1048576 : 524288 : 1572864;
                                                if ((i26 & 1533916891) != 306783378 && (1533916891 & i98) == 306783378 && (2995931 & i99) == 599186 && startRestartGroup.getSkipping()) {
                                                    startRestartGroup.skipToGroupEnd();
                                                    rVar4 = rVar;
                                                    iVar3 = iVar;
                                                    function25 = function2;
                                                    aVar5 = aVar;
                                                    lVar3 = lVar;
                                                    f47 = f17;
                                                    f48 = f18;
                                                    bool11 = bool;
                                                    bool12 = bool2;
                                                    bool13 = bool3;
                                                    bool14 = bool4;
                                                    gridLayoutMode3 = gridLayoutMode;
                                                    f49 = f19;
                                                    f56 = f26;
                                                    i89 = i3;
                                                    f57 = f27;
                                                    bool15 = bool5;
                                                    f58 = f28;
                                                    function111 = function1;
                                                    function112 = function12;
                                                    function113 = function13;
                                                    function114 = function14;
                                                    function26 = function22;
                                                    function115 = function15;
                                                    composer2 = startRestartGroup;
                                                    aVar6 = aVar2;
                                                } else {
                                                    startRestartGroup.startDefaults();
                                                    if ((i16 & 1) == 0 && !startRestartGroup.getDefaultsInvalid()) {
                                                        startRestartGroup.skipToGroupEnd();
                                                        if ((i19 & 1) != 0) {
                                                            i26 &= -15;
                                                        }
                                                        rVar3 = rVar;
                                                        iVar2 = iVar;
                                                        function24 = function2;
                                                        aVar4 = aVar;
                                                        lVar2 = lVar;
                                                        f36 = f17;
                                                        f29 = f18;
                                                        bool6 = bool;
                                                        aVar3 = aVar2;
                                                        bool7 = bool2;
                                                        bool8 = bool3;
                                                        bool9 = bool4;
                                                        gridLayoutMode2 = gridLayoutMode;
                                                        f37 = f19;
                                                        f38 = f26;
                                                        i88 = i3;
                                                        f39 = f27;
                                                        bool10 = bool5;
                                                        f46 = f28;
                                                        function19 = function1;
                                                        function110 = function12;
                                                        function18 = function13;
                                                        function17 = function14;
                                                        function23 = function22;
                                                        function16 = function15;
                                                        i87 = i26;
                                                    } else {
                                                        if ((i19 & 1) == 0) {
                                                            rVar2 = new r.a(1);
                                                            i26 &= -15;
                                                        } else {
                                                            rVar2 = rVar;
                                                        }
                                                        com.tencent.ntcompose.core.i iVar4 = i97 == 0 ? com.tencent.ntcompose.core.i.INSTANCE : iVar;
                                                        Function2<? super cm, ? super com.tencent.kuikly.core.base.aa<cm>, Unit> function27 = i27 == 0 ? null : function2;
                                                        com.tencent.ntcompose.foundation.lazy.a aVar7 = i28 == 0 ? null : aVar;
                                                        com.tencent.ntcompose.foundation.layout.l lVar4 = i29 == 0 ? null : lVar;
                                                        float f59 = i36 == 0 ? 0.0f : f17;
                                                        float f65 = i37 == 0 ? 0.0f : f18;
                                                        Boolean bool16 = i38 == 0 ? null : bool;
                                                        to3.a aVar8 = i39 == 0 ? null : aVar2;
                                                        Boolean bool17 = i46 == 0 ? null : bool2;
                                                        Boolean bool18 = i48 == 0 ? null : bool3;
                                                        Boolean bool19 = i49 == 0 ? null : bool4;
                                                        GridLayoutMode gridLayoutMode4 = i57 == 0 ? null : gridLayoutMode;
                                                        Float f66 = i59 == 0 ? null : f19;
                                                        Float f67 = i65 == 0 ? null : f26;
                                                        int i100 = i66 == 0 ? 8 : i3;
                                                        Float f68 = i67 == 0 ? null : f27;
                                                        Boolean bool20 = i68 == 0 ? null : bool5;
                                                        Float f69 = i69 == 0 ? null : f28;
                                                        Function1<? super ScrollParams, Unit> function116 = i75 == 0 ? null : function1;
                                                        Function1<? super ScrollParams, Unit> function117 = i77 == 0 ? null : function12;
                                                        Function1<? super ScrollParams, Unit> function118 = i78 == 0 ? null : function13;
                                                        Function1<? super ScrollParams, Unit> function119 = i79 == 0 ? null : function14;
                                                        Function2<? super Float, ? super Float, Unit> function28 = i85 == 0 ? null : function22;
                                                        if (i86 == 0) {
                                                            bool6 = bool16;
                                                            aVar3 = aVar8;
                                                            bool7 = bool17;
                                                            i87 = i26;
                                                            bool8 = bool18;
                                                            bool9 = bool19;
                                                            f29 = f65;
                                                            function17 = function119;
                                                            function23 = function28;
                                                            lVar2 = lVar4;
                                                            f36 = f59;
                                                            gridLayoutMode2 = gridLayoutMode4;
                                                            function18 = function118;
                                                            f37 = f66;
                                                            f38 = f67;
                                                            i88 = i100;
                                                            f39 = f68;
                                                            bool10 = bool20;
                                                            f46 = f69;
                                                            function19 = function116;
                                                            function110 = function117;
                                                            function16 = null;
                                                        } else {
                                                            function16 = function15;
                                                            bool6 = bool16;
                                                            aVar3 = aVar8;
                                                            bool7 = bool17;
                                                            i87 = i26;
                                                            bool8 = bool18;
                                                            bool9 = bool19;
                                                            f29 = f65;
                                                            function17 = function119;
                                                            function23 = function28;
                                                            lVar2 = lVar4;
                                                            f36 = f59;
                                                            gridLayoutMode2 = gridLayoutMode4;
                                                            function18 = function118;
                                                            f37 = f66;
                                                            f38 = f67;
                                                            i88 = i100;
                                                            f39 = f68;
                                                            bool10 = bool20;
                                                            f46 = f69;
                                                            function19 = function116;
                                                            function110 = function117;
                                                        }
                                                        iVar2 = iVar4;
                                                        rVar3 = rVar2;
                                                        function24 = function27;
                                                        aVar4 = aVar7;
                                                    }
                                                    startRestartGroup.endDefaults();
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1154616877, i87, i98, "com.tencent.ntcompose.material.LazyVerticalGrid (LazyVerticalGrid.kt:82)");
                                                    }
                                                    ArrayList arrayList = new ArrayList();
                                                    v vVar = v.f339448a;
                                                    arrayList.add(new com.tencent.ntcompose.core.k("columns", rVar3, null, null, null, null, vVar, 60, null));
                                                    arrayList.add(new com.tencent.ntcompose.core.k("columnsSpacing", Float.valueOf(f36), null, null, null, null, vVar, 60, null));
                                                    arrayList.add(new com.tencent.ntcompose.core.k("rowsSpacing", Float.valueOf(f29), null, null, null, null, vVar, 60, null));
                                                    arrayList.add(new com.tencent.ntcompose.core.k("listWidth", Float.valueOf(f16), null, null, null, null, vVar, 60, null));
                                                    if (gridLayoutMode2 != null) {
                                                        arrayList.add(new com.tencent.ntcompose.core.k("gridLayoutMode", gridLayoutMode2, null, null, null, null, vVar, 60, null));
                                                    }
                                                    int i101 = i87 >> 3;
                                                    int i102 = (i101 & 14) | 3072 | ((i87 >> 6) & 896);
                                                    int i103 = i87 >> 9;
                                                    int i104 = (i103 & 3670016) | (i101 & 57344) | i102 | (i103 & 458752);
                                                    int i105 = i98 << 21;
                                                    int i106 = i104 | (29360128 & i105) | (234881024 & i105) | (i105 & 1879048192);
                                                    int i107 = i98 >> 12;
                                                    int i108 = i99 << 21;
                                                    int i109 = (i107 & 458752) | (i107 & 14) | (i107 & 112) | (i107 & 896) | (i107 & 7168) | (i107 & 57344) | (29360128 & i108) | (234881024 & i108) | (i108 & 1879048192);
                                                    int i110 = i99 >> 9;
                                                    composer2 = startRestartGroup;
                                                    LazyListKt.a(iVar2, function24 != null ? null : function24, aVar4, ListItemsLayoutType.VerticalGrid, lVar2, bool6, aVar3, bool7, bool8, bool9, f37, f38, i88, f39, bool10, f46, null, function19, function110, function18, function17, function23, function16, arrayList, content, composer2, i106, i109, (i110 & 896) | (i110 & 14) | 4096 | (i110 & 112) | ((i99 >> 6) & 57344), 65536);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                    rVar4 = rVar3;
                                                    iVar3 = iVar2;
                                                    function25 = function24;
                                                    aVar5 = aVar4;
                                                    lVar3 = lVar2;
                                                    f47 = f36;
                                                    f48 = f29;
                                                    bool11 = bool6;
                                                    aVar6 = aVar3;
                                                    bool12 = bool7;
                                                    bool13 = bool8;
                                                    bool14 = bool9;
                                                    gridLayoutMode3 = gridLayoutMode2;
                                                    f49 = f37;
                                                    f56 = f38;
                                                    i89 = i88;
                                                    f57 = f39;
                                                    bool15 = bool10;
                                                    f58 = f46;
                                                    function111 = function19;
                                                    function112 = function110;
                                                    function113 = function18;
                                                    function114 = function17;
                                                    function26 = function23;
                                                    function115 = function16;
                                                }
                                                endRestartGroup = composer2.endRestartGroup();
                                                if (endRestartGroup != null) {
                                                    return;
                                                }
                                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.LazyVerticalGridKt$LazyVerticalGrid$1
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

                                                    public final void invoke(Composer composer3, int i111) {
                                                        LazyVerticalGridKt.a(r.this, iVar3, f16, function25, aVar5, lVar3, f47, f48, bool11, aVar6, bool12, bool13, bool14, gridLayoutMode3, f49, f56, i89, f57, bool15, f58, function111, function112, function113, function114, function26, function115, content, composer3, i16 | 1, i17, i18, i19);
                                                    }
                                                });
                                                return;
                                            }
                                            i99 |= i95;
                                            if ((i26 & 1533916891) != 306783378) {
                                            }
                                            startRestartGroup.startDefaults();
                                            if ((i16 & 1) == 0) {
                                            }
                                            if ((i19 & 1) == 0) {
                                            }
                                            if (i97 == 0) {
                                            }
                                            if (i27 == 0) {
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
                                            if (i48 == 0) {
                                            }
                                            if (i49 == 0) {
                                            }
                                            if (i57 == 0) {
                                            }
                                            if (i59 == 0) {
                                            }
                                            if (i65 == 0) {
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
                                            if (i77 == 0) {
                                            }
                                            if (i78 == 0) {
                                            }
                                            if (i79 == 0) {
                                            }
                                            if (i85 == 0) {
                                            }
                                            if (i86 == 0) {
                                            }
                                            iVar2 = iVar4;
                                            rVar3 = rVar2;
                                            function24 = function27;
                                            aVar4 = aVar7;
                                            startRestartGroup.endDefaults();
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                            ArrayList arrayList2 = new ArrayList();
                                            v vVar2 = v.f339448a;
                                            arrayList2.add(new com.tencent.ntcompose.core.k("columns", rVar3, null, null, null, null, vVar2, 60, null));
                                            arrayList2.add(new com.tencent.ntcompose.core.k("columnsSpacing", Float.valueOf(f36), null, null, null, null, vVar2, 60, null));
                                            arrayList2.add(new com.tencent.ntcompose.core.k("rowsSpacing", Float.valueOf(f29), null, null, null, null, vVar2, 60, null));
                                            arrayList2.add(new com.tencent.ntcompose.core.k("listWidth", Float.valueOf(f16), null, null, null, null, vVar2, 60, null));
                                            if (gridLayoutMode2 != null) {
                                            }
                                            int i1012 = i87 >> 3;
                                            int i1022 = (i1012 & 14) | 3072 | ((i87 >> 6) & 896);
                                            int i1032 = i87 >> 9;
                                            int i1042 = (i1032 & 3670016) | (i1012 & 57344) | i1022 | (i1032 & 458752);
                                            int i1052 = i98 << 21;
                                            int i1062 = i1042 | (29360128 & i1052) | (234881024 & i1052) | (i1052 & 1879048192);
                                            int i1072 = i98 >> 12;
                                            int i1082 = i99 << 21;
                                            int i1092 = (i1072 & 458752) | (i1072 & 14) | (i1072 & 112) | (i1072 & 896) | (i1072 & 7168) | (i1072 & 57344) | (29360128 & i1082) | (234881024 & i1082) | (i1082 & 1879048192);
                                            int i1102 = i99 >> 9;
                                            composer2 = startRestartGroup;
                                            LazyListKt.a(iVar2, function24 != null ? null : function24, aVar4, ListItemsLayoutType.VerticalGrid, lVar2, bool6, aVar3, bool7, bool8, bool9, f37, f38, i88, f39, bool10, f46, null, function19, function110, function18, function17, function23, function16, arrayList2, content, composer2, i1062, i1092, (i1102 & 896) | (i1102 & 14) | 4096 | (i1102 & 112) | ((i99 >> 6) & 57344), 65536);
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                            rVar4 = rVar3;
                                            iVar3 = iVar2;
                                            function25 = function24;
                                            aVar5 = aVar4;
                                            lVar3 = lVar2;
                                            f47 = f36;
                                            f48 = f29;
                                            bool11 = bool6;
                                            aVar6 = aVar3;
                                            bool12 = bool7;
                                            bool13 = bool8;
                                            bool14 = bool9;
                                            gridLayoutMode3 = gridLayoutMode2;
                                            f49 = f37;
                                            f56 = f38;
                                            i89 = i88;
                                            f57 = f39;
                                            bool15 = bool10;
                                            f58 = f46;
                                            function111 = function19;
                                            function112 = function110;
                                            function113 = function18;
                                            function114 = function17;
                                            function26 = function23;
                                            function115 = function16;
                                            endRestartGroup = composer2.endRestartGroup();
                                            if (endRestartGroup != null) {
                                            }
                                        }
                                        i85 = i19 & 16777216;
                                        if (i85 != 0) {
                                        }
                                        i86 = i19 & 33554432;
                                        if (i86 != 0) {
                                        }
                                        if ((i19 & 67108864) == 0) {
                                        }
                                        i99 |= i95;
                                        if ((i26 & 1533916891) != 306783378) {
                                        }
                                        startRestartGroup.startDefaults();
                                        if ((i16 & 1) == 0) {
                                        }
                                        if ((i19 & 1) == 0) {
                                        }
                                        if (i97 == 0) {
                                        }
                                        if (i27 == 0) {
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
                                        if (i48 == 0) {
                                        }
                                        if (i49 == 0) {
                                        }
                                        if (i57 == 0) {
                                        }
                                        if (i59 == 0) {
                                        }
                                        if (i65 == 0) {
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
                                        if (i77 == 0) {
                                        }
                                        if (i78 == 0) {
                                        }
                                        if (i79 == 0) {
                                        }
                                        if (i85 == 0) {
                                        }
                                        if (i86 == 0) {
                                        }
                                        iVar2 = iVar4;
                                        rVar3 = rVar2;
                                        function24 = function27;
                                        aVar4 = aVar7;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        ArrayList arrayList22 = new ArrayList();
                                        v vVar22 = v.f339448a;
                                        arrayList22.add(new com.tencent.ntcompose.core.k("columns", rVar3, null, null, null, null, vVar22, 60, null));
                                        arrayList22.add(new com.tencent.ntcompose.core.k("columnsSpacing", Float.valueOf(f36), null, null, null, null, vVar22, 60, null));
                                        arrayList22.add(new com.tencent.ntcompose.core.k("rowsSpacing", Float.valueOf(f29), null, null, null, null, vVar22, 60, null));
                                        arrayList22.add(new com.tencent.ntcompose.core.k("listWidth", Float.valueOf(f16), null, null, null, null, vVar22, 60, null));
                                        if (gridLayoutMode2 != null) {
                                        }
                                        int i10122 = i87 >> 3;
                                        int i10222 = (i10122 & 14) | 3072 | ((i87 >> 6) & 896);
                                        int i10322 = i87 >> 9;
                                        int i10422 = (i10322 & 3670016) | (i10122 & 57344) | i10222 | (i10322 & 458752);
                                        int i10522 = i98 << 21;
                                        int i10622 = i10422 | (29360128 & i10522) | (234881024 & i10522) | (i10522 & 1879048192);
                                        int i10722 = i98 >> 12;
                                        int i10822 = i99 << 21;
                                        int i10922 = (i10722 & 458752) | (i10722 & 14) | (i10722 & 112) | (i10722 & 896) | (i10722 & 7168) | (i10722 & 57344) | (29360128 & i10822) | (234881024 & i10822) | (i10822 & 1879048192);
                                        int i11022 = i99 >> 9;
                                        composer2 = startRestartGroup;
                                        LazyListKt.a(iVar2, function24 != null ? null : function24, aVar4, ListItemsLayoutType.VerticalGrid, lVar2, bool6, aVar3, bool7, bool8, bool9, f37, f38, i88, f39, bool10, f46, null, function19, function110, function18, function17, function23, function16, arrayList22, content, composer2, i10622, i10922, (i11022 & 896) | (i11022 & 14) | 4096 | (i11022 & 112) | ((i99 >> 6) & 57344), 65536);
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        rVar4 = rVar3;
                                        iVar3 = iVar2;
                                        function25 = function24;
                                        aVar5 = aVar4;
                                        lVar3 = lVar2;
                                        f47 = f36;
                                        f48 = f29;
                                        bool11 = bool6;
                                        aVar6 = aVar3;
                                        bool12 = bool7;
                                        bool13 = bool8;
                                        bool14 = bool9;
                                        gridLayoutMode3 = gridLayoutMode2;
                                        f49 = f37;
                                        f56 = f38;
                                        i89 = i88;
                                        f57 = f39;
                                        bool15 = bool10;
                                        f58 = f46;
                                        function111 = function19;
                                        function112 = function110;
                                        function113 = function18;
                                        function114 = function17;
                                        function26 = function23;
                                        function115 = function16;
                                        endRestartGroup = composer2.endRestartGroup();
                                        if (endRestartGroup != null) {
                                        }
                                    }
                                    i79 = i19 & 8388608;
                                    if (i79 == 0) {
                                    }
                                    i85 = i19 & 16777216;
                                    if (i85 != 0) {
                                    }
                                    i86 = i19 & 33554432;
                                    if (i86 != 0) {
                                    }
                                    if ((i19 & 67108864) == 0) {
                                    }
                                    i99 |= i95;
                                    if ((i26 & 1533916891) != 306783378) {
                                    }
                                    startRestartGroup.startDefaults();
                                    if ((i16 & 1) == 0) {
                                    }
                                    if ((i19 & 1) == 0) {
                                    }
                                    if (i97 == 0) {
                                    }
                                    if (i27 == 0) {
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
                                    if (i48 == 0) {
                                    }
                                    if (i49 == 0) {
                                    }
                                    if (i57 == 0) {
                                    }
                                    if (i59 == 0) {
                                    }
                                    if (i65 == 0) {
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
                                    if (i77 == 0) {
                                    }
                                    if (i78 == 0) {
                                    }
                                    if (i79 == 0) {
                                    }
                                    if (i85 == 0) {
                                    }
                                    if (i86 == 0) {
                                    }
                                    iVar2 = iVar4;
                                    rVar3 = rVar2;
                                    function24 = function27;
                                    aVar4 = aVar7;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    ArrayList arrayList222 = new ArrayList();
                                    v vVar222 = v.f339448a;
                                    arrayList222.add(new com.tencent.ntcompose.core.k("columns", rVar3, null, null, null, null, vVar222, 60, null));
                                    arrayList222.add(new com.tencent.ntcompose.core.k("columnsSpacing", Float.valueOf(f36), null, null, null, null, vVar222, 60, null));
                                    arrayList222.add(new com.tencent.ntcompose.core.k("rowsSpacing", Float.valueOf(f29), null, null, null, null, vVar222, 60, null));
                                    arrayList222.add(new com.tencent.ntcompose.core.k("listWidth", Float.valueOf(f16), null, null, null, null, vVar222, 60, null));
                                    if (gridLayoutMode2 != null) {
                                    }
                                    int i101222 = i87 >> 3;
                                    int i102222 = (i101222 & 14) | 3072 | ((i87 >> 6) & 896);
                                    int i103222 = i87 >> 9;
                                    int i104222 = (i103222 & 3670016) | (i101222 & 57344) | i102222 | (i103222 & 458752);
                                    int i105222 = i98 << 21;
                                    int i106222 = i104222 | (29360128 & i105222) | (234881024 & i105222) | (i105222 & 1879048192);
                                    int i107222 = i98 >> 12;
                                    int i108222 = i99 << 21;
                                    int i109222 = (i107222 & 458752) | (i107222 & 14) | (i107222 & 112) | (i107222 & 896) | (i107222 & 7168) | (i107222 & 57344) | (29360128 & i108222) | (234881024 & i108222) | (i108222 & 1879048192);
                                    int i110222 = i99 >> 9;
                                    composer2 = startRestartGroup;
                                    LazyListKt.a(iVar2, function24 != null ? null : function24, aVar4, ListItemsLayoutType.VerticalGrid, lVar2, bool6, aVar3, bool7, bool8, bool9, f37, f38, i88, f39, bool10, f46, null, function19, function110, function18, function17, function23, function16, arrayList222, content, composer2, i106222, i109222, (i110222 & 896) | (i110222 & 14) | 4096 | (i110222 & 112) | ((i99 >> 6) & 57344), 65536);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    rVar4 = rVar3;
                                    iVar3 = iVar2;
                                    function25 = function24;
                                    aVar5 = aVar4;
                                    lVar3 = lVar2;
                                    f47 = f36;
                                    f48 = f29;
                                    bool11 = bool6;
                                    aVar6 = aVar3;
                                    bool12 = bool7;
                                    bool13 = bool8;
                                    bool14 = bool9;
                                    gridLayoutMode3 = gridLayoutMode2;
                                    f49 = f37;
                                    f56 = f38;
                                    i89 = i88;
                                    f57 = f39;
                                    bool15 = bool10;
                                    f58 = f46;
                                    function111 = function19;
                                    function112 = function110;
                                    function113 = function18;
                                    function114 = function17;
                                    function26 = function23;
                                    function115 = function16;
                                    endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup != null) {
                                    }
                                }
                                i59 = i58;
                                i65 = i19 & 32768;
                                if (i65 != 0) {
                                }
                                i66 = i19 & 65536;
                                if (i66 != 0) {
                                }
                                i67 = i19 & 131072;
                                if (i67 != 0) {
                                }
                                i68 = i19 & 262144;
                                if (i68 != 0) {
                                }
                                i69 = i19 & 524288;
                                if (i69 != 0) {
                                }
                                i75 = i19 & 1048576;
                                if (i75 != 0) {
                                }
                                i77 = i19 & 2097152;
                                if (i77 != 0) {
                                }
                                int i992 = i76;
                                i78 = i19 & 4194304;
                                if (i78 != 0) {
                                }
                                i79 = i19 & 8388608;
                                if (i79 == 0) {
                                }
                                i85 = i19 & 16777216;
                                if (i85 != 0) {
                                }
                                i86 = i19 & 33554432;
                                if (i86 != 0) {
                                }
                                if ((i19 & 67108864) == 0) {
                                }
                                i992 |= i95;
                                if ((i26 & 1533916891) != 306783378) {
                                }
                                startRestartGroup.startDefaults();
                                if ((i16 & 1) == 0) {
                                }
                                if ((i19 & 1) == 0) {
                                }
                                if (i97 == 0) {
                                }
                                if (i27 == 0) {
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
                                if (i48 == 0) {
                                }
                                if (i49 == 0) {
                                }
                                if (i57 == 0) {
                                }
                                if (i59 == 0) {
                                }
                                if (i65 == 0) {
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
                                if (i77 == 0) {
                                }
                                if (i78 == 0) {
                                }
                                if (i79 == 0) {
                                }
                                if (i85 == 0) {
                                }
                                if (i86 == 0) {
                                }
                                iVar2 = iVar4;
                                rVar3 = rVar2;
                                function24 = function27;
                                aVar4 = aVar7;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                ArrayList arrayList2222 = new ArrayList();
                                v vVar2222 = v.f339448a;
                                arrayList2222.add(new com.tencent.ntcompose.core.k("columns", rVar3, null, null, null, null, vVar2222, 60, null));
                                arrayList2222.add(new com.tencent.ntcompose.core.k("columnsSpacing", Float.valueOf(f36), null, null, null, null, vVar2222, 60, null));
                                arrayList2222.add(new com.tencent.ntcompose.core.k("rowsSpacing", Float.valueOf(f29), null, null, null, null, vVar2222, 60, null));
                                arrayList2222.add(new com.tencent.ntcompose.core.k("listWidth", Float.valueOf(f16), null, null, null, null, vVar2222, 60, null));
                                if (gridLayoutMode2 != null) {
                                }
                                int i1012222 = i87 >> 3;
                                int i1022222 = (i1012222 & 14) | 3072 | ((i87 >> 6) & 896);
                                int i1032222 = i87 >> 9;
                                int i1042222 = (i1032222 & 3670016) | (i1012222 & 57344) | i1022222 | (i1032222 & 458752);
                                int i1052222 = i98 << 21;
                                int i1062222 = i1042222 | (29360128 & i1052222) | (234881024 & i1052222) | (i1052222 & 1879048192);
                                int i1072222 = i98 >> 12;
                                int i1082222 = i992 << 21;
                                int i1092222 = (i1072222 & 458752) | (i1072222 & 14) | (i1072222 & 112) | (i1072222 & 896) | (i1072222 & 7168) | (i1072222 & 57344) | (29360128 & i1082222) | (234881024 & i1082222) | (i1082222 & 1879048192);
                                int i1102222 = i992 >> 9;
                                composer2 = startRestartGroup;
                                LazyListKt.a(iVar2, function24 != null ? null : function24, aVar4, ListItemsLayoutType.VerticalGrid, lVar2, bool6, aVar3, bool7, bool8, bool9, f37, f38, i88, f39, bool10, f46, null, function19, function110, function18, function17, function23, function16, arrayList2222, content, composer2, i1062222, i1092222, (i1102222 & 896) | (i1102222 & 14) | 4096 | (i1102222 & 112) | ((i992 >> 6) & 57344), 65536);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                rVar4 = rVar3;
                                iVar3 = iVar2;
                                function25 = function24;
                                aVar5 = aVar4;
                                lVar3 = lVar2;
                                f47 = f36;
                                f48 = f29;
                                bool11 = bool6;
                                aVar6 = aVar3;
                                bool12 = bool7;
                                bool13 = bool8;
                                bool14 = bool9;
                                gridLayoutMode3 = gridLayoutMode2;
                                f49 = f37;
                                f56 = f38;
                                i89 = i88;
                                f57 = f39;
                                bool15 = bool10;
                                f58 = f46;
                                function111 = function19;
                                function112 = function110;
                                function113 = function18;
                                function114 = function17;
                                function26 = function23;
                                function115 = function16;
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup != null) {
                                }
                            }
                        }
                        i58 = i19 & 16384;
                        if (i58 == 0) {
                        }
                        i59 = i58;
                        i65 = i19 & 32768;
                        if (i65 != 0) {
                        }
                        i66 = i19 & 65536;
                        if (i66 != 0) {
                        }
                        i67 = i19 & 131072;
                        if (i67 != 0) {
                        }
                        i68 = i19 & 262144;
                        if (i68 != 0) {
                        }
                        i69 = i19 & 524288;
                        if (i69 != 0) {
                        }
                        i75 = i19 & 1048576;
                        if (i75 != 0) {
                        }
                        i77 = i19 & 2097152;
                        if (i77 != 0) {
                        }
                        int i9922 = i76;
                        i78 = i19 & 4194304;
                        if (i78 != 0) {
                        }
                        i79 = i19 & 8388608;
                        if (i79 == 0) {
                        }
                        i85 = i19 & 16777216;
                        if (i85 != 0) {
                        }
                        i86 = i19 & 33554432;
                        if (i86 != 0) {
                        }
                        if ((i19 & 67108864) == 0) {
                        }
                        i9922 |= i95;
                        if ((i26 & 1533916891) != 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i16 & 1) == 0) {
                        }
                        if ((i19 & 1) == 0) {
                        }
                        if (i97 == 0) {
                        }
                        if (i27 == 0) {
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
                        if (i48 == 0) {
                        }
                        if (i49 == 0) {
                        }
                        if (i57 == 0) {
                        }
                        if (i59 == 0) {
                        }
                        if (i65 == 0) {
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
                        if (i77 == 0) {
                        }
                        if (i78 == 0) {
                        }
                        if (i79 == 0) {
                        }
                        if (i85 == 0) {
                        }
                        if (i86 == 0) {
                        }
                        iVar2 = iVar4;
                        rVar3 = rVar2;
                        function24 = function27;
                        aVar4 = aVar7;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ArrayList arrayList22222 = new ArrayList();
                        v vVar22222 = v.f339448a;
                        arrayList22222.add(new com.tencent.ntcompose.core.k("columns", rVar3, null, null, null, null, vVar22222, 60, null));
                        arrayList22222.add(new com.tencent.ntcompose.core.k("columnsSpacing", Float.valueOf(f36), null, null, null, null, vVar22222, 60, null));
                        arrayList22222.add(new com.tencent.ntcompose.core.k("rowsSpacing", Float.valueOf(f29), null, null, null, null, vVar22222, 60, null));
                        arrayList22222.add(new com.tencent.ntcompose.core.k("listWidth", Float.valueOf(f16), null, null, null, null, vVar22222, 60, null));
                        if (gridLayoutMode2 != null) {
                        }
                        int i10122222 = i87 >> 3;
                        int i10222222 = (i10122222 & 14) | 3072 | ((i87 >> 6) & 896);
                        int i10322222 = i87 >> 9;
                        int i10422222 = (i10322222 & 3670016) | (i10122222 & 57344) | i10222222 | (i10322222 & 458752);
                        int i10522222 = i98 << 21;
                        int i10622222 = i10422222 | (29360128 & i10522222) | (234881024 & i10522222) | (i10522222 & 1879048192);
                        int i10722222 = i98 >> 12;
                        int i10822222 = i9922 << 21;
                        int i10922222 = (i10722222 & 458752) | (i10722222 & 14) | (i10722222 & 112) | (i10722222 & 896) | (i10722222 & 7168) | (i10722222 & 57344) | (29360128 & i10822222) | (234881024 & i10822222) | (i10822222 & 1879048192);
                        int i11022222 = i9922 >> 9;
                        composer2 = startRestartGroup;
                        LazyListKt.a(iVar2, function24 != null ? null : function24, aVar4, ListItemsLayoutType.VerticalGrid, lVar2, bool6, aVar3, bool7, bool8, bool9, f37, f38, i88, f39, bool10, f46, null, function19, function110, function18, function17, function23, function16, arrayList22222, content, composer2, i10622222, i10922222, (i11022222 & 896) | (i11022222 & 14) | 4096 | (i11022222 & 112) | ((i9922 >> 6) & 57344), 65536);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        rVar4 = rVar3;
                        iVar3 = iVar2;
                        function25 = function24;
                        aVar5 = aVar4;
                        lVar3 = lVar2;
                        f47 = f36;
                        f48 = f29;
                        bool11 = bool6;
                        aVar6 = aVar3;
                        bool12 = bool7;
                        bool13 = bool8;
                        bool14 = bool9;
                        gridLayoutMode3 = gridLayoutMode2;
                        f49 = f37;
                        f56 = f38;
                        i89 = i88;
                        f57 = f39;
                        bool15 = bool10;
                        f58 = f46;
                        function111 = function19;
                        function112 = function110;
                        function113 = function18;
                        function114 = function17;
                        function26 = function23;
                        function115 = function16;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    i56 = i19 & 8192;
                    if (i56 != 0) {
                    }
                    i58 = i19 & 16384;
                    if (i58 == 0) {
                    }
                    i59 = i58;
                    i65 = i19 & 32768;
                    if (i65 != 0) {
                    }
                    i66 = i19 & 65536;
                    if (i66 != 0) {
                    }
                    i67 = i19 & 131072;
                    if (i67 != 0) {
                    }
                    i68 = i19 & 262144;
                    if (i68 != 0) {
                    }
                    i69 = i19 & 524288;
                    if (i69 != 0) {
                    }
                    i75 = i19 & 1048576;
                    if (i75 != 0) {
                    }
                    i77 = i19 & 2097152;
                    if (i77 != 0) {
                    }
                    int i99222 = i76;
                    i78 = i19 & 4194304;
                    if (i78 != 0) {
                    }
                    i79 = i19 & 8388608;
                    if (i79 == 0) {
                    }
                    i85 = i19 & 16777216;
                    if (i85 != 0) {
                    }
                    i86 = i19 & 33554432;
                    if (i86 != 0) {
                    }
                    if ((i19 & 67108864) == 0) {
                    }
                    i99222 |= i95;
                    if ((i26 & 1533916891) != 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i16 & 1) == 0) {
                    }
                    if ((i19 & 1) == 0) {
                    }
                    if (i97 == 0) {
                    }
                    if (i27 == 0) {
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
                    if (i48 == 0) {
                    }
                    if (i49 == 0) {
                    }
                    if (i57 == 0) {
                    }
                    if (i59 == 0) {
                    }
                    if (i65 == 0) {
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
                    if (i77 == 0) {
                    }
                    if (i78 == 0) {
                    }
                    if (i79 == 0) {
                    }
                    if (i85 == 0) {
                    }
                    if (i86 == 0) {
                    }
                    iVar2 = iVar4;
                    rVar3 = rVar2;
                    function24 = function27;
                    aVar4 = aVar7;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ArrayList arrayList222222 = new ArrayList();
                    v vVar222222 = v.f339448a;
                    arrayList222222.add(new com.tencent.ntcompose.core.k("columns", rVar3, null, null, null, null, vVar222222, 60, null));
                    arrayList222222.add(new com.tencent.ntcompose.core.k("columnsSpacing", Float.valueOf(f36), null, null, null, null, vVar222222, 60, null));
                    arrayList222222.add(new com.tencent.ntcompose.core.k("rowsSpacing", Float.valueOf(f29), null, null, null, null, vVar222222, 60, null));
                    arrayList222222.add(new com.tencent.ntcompose.core.k("listWidth", Float.valueOf(f16), null, null, null, null, vVar222222, 60, null));
                    if (gridLayoutMode2 != null) {
                    }
                    int i101222222 = i87 >> 3;
                    int i102222222 = (i101222222 & 14) | 3072 | ((i87 >> 6) & 896);
                    int i103222222 = i87 >> 9;
                    int i104222222 = (i103222222 & 3670016) | (i101222222 & 57344) | i102222222 | (i103222222 & 458752);
                    int i105222222 = i98 << 21;
                    int i106222222 = i104222222 | (29360128 & i105222222) | (234881024 & i105222222) | (i105222222 & 1879048192);
                    int i107222222 = i98 >> 12;
                    int i108222222 = i99222 << 21;
                    int i109222222 = (i107222222 & 458752) | (i107222222 & 14) | (i107222222 & 112) | (i107222222 & 896) | (i107222222 & 7168) | (i107222222 & 57344) | (29360128 & i108222222) | (234881024 & i108222222) | (i108222222 & 1879048192);
                    int i110222222 = i99222 >> 9;
                    composer2 = startRestartGroup;
                    LazyListKt.a(iVar2, function24 != null ? null : function24, aVar4, ListItemsLayoutType.VerticalGrid, lVar2, bool6, aVar3, bool7, bool8, bool9, f37, f38, i88, f39, bool10, f46, null, function19, function110, function18, function17, function23, function16, arrayList222222, content, composer2, i106222222, i109222222, (i110222222 & 896) | (i110222222 & 14) | 4096 | (i110222222 & 112) | ((i99222 >> 6) & 57344), 65536);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    rVar4 = rVar3;
                    iVar3 = iVar2;
                    function25 = function24;
                    aVar5 = aVar4;
                    lVar3 = lVar2;
                    f47 = f36;
                    f48 = f29;
                    bool11 = bool6;
                    aVar6 = aVar3;
                    bool12 = bool7;
                    bool13 = bool8;
                    bool14 = bool9;
                    gridLayoutMode3 = gridLayoutMode2;
                    f49 = f37;
                    f56 = f38;
                    i89 = i88;
                    f57 = f39;
                    bool15 = bool10;
                    f58 = f46;
                    function111 = function19;
                    function112 = function110;
                    function113 = function18;
                    function114 = function17;
                    function26 = function23;
                    function115 = function16;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i28 = i19 & 16;
                if (i28 == 0) {
                }
                i29 = i19 & 32;
                if (i29 == 0) {
                }
                i36 = i19 & 64;
                if (i36 == 0) {
                }
                i37 = i19 & 128;
                if (i37 == 0) {
                }
                i38 = i19 & 256;
                if (i38 == 0) {
                }
                i39 = i19 & 512;
                if (i39 == 0) {
                }
                i46 = i19 & 1024;
                if (i46 == 0) {
                }
                i48 = i19 & 2048;
                if (i48 == 0) {
                }
                int i982 = i47;
                i49 = i19 & 4096;
                if (i49 == 0) {
                }
                i56 = i19 & 8192;
                if (i56 != 0) {
                }
                i58 = i19 & 16384;
                if (i58 == 0) {
                }
                i59 = i58;
                i65 = i19 & 32768;
                if (i65 != 0) {
                }
                i66 = i19 & 65536;
                if (i66 != 0) {
                }
                i67 = i19 & 131072;
                if (i67 != 0) {
                }
                i68 = i19 & 262144;
                if (i68 != 0) {
                }
                i69 = i19 & 524288;
                if (i69 != 0) {
                }
                i75 = i19 & 1048576;
                if (i75 != 0) {
                }
                i77 = i19 & 2097152;
                if (i77 != 0) {
                }
                int i992222 = i76;
                i78 = i19 & 4194304;
                if (i78 != 0) {
                }
                i79 = i19 & 8388608;
                if (i79 == 0) {
                }
                i85 = i19 & 16777216;
                if (i85 != 0) {
                }
                i86 = i19 & 33554432;
                if (i86 != 0) {
                }
                if ((i19 & 67108864) == 0) {
                }
                i992222 |= i95;
                if ((i26 & 1533916891) != 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i16 & 1) == 0) {
                }
                if ((i19 & 1) == 0) {
                }
                if (i97 == 0) {
                }
                if (i27 == 0) {
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
                if (i48 == 0) {
                }
                if (i49 == 0) {
                }
                if (i57 == 0) {
                }
                if (i59 == 0) {
                }
                if (i65 == 0) {
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
                if (i77 == 0) {
                }
                if (i78 == 0) {
                }
                if (i79 == 0) {
                }
                if (i85 == 0) {
                }
                if (i86 == 0) {
                }
                iVar2 = iVar4;
                rVar3 = rVar2;
                function24 = function27;
                aVar4 = aVar7;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                ArrayList arrayList2222222 = new ArrayList();
                v vVar2222222 = v.f339448a;
                arrayList2222222.add(new com.tencent.ntcompose.core.k("columns", rVar3, null, null, null, null, vVar2222222, 60, null));
                arrayList2222222.add(new com.tencent.ntcompose.core.k("columnsSpacing", Float.valueOf(f36), null, null, null, null, vVar2222222, 60, null));
                arrayList2222222.add(new com.tencent.ntcompose.core.k("rowsSpacing", Float.valueOf(f29), null, null, null, null, vVar2222222, 60, null));
                arrayList2222222.add(new com.tencent.ntcompose.core.k("listWidth", Float.valueOf(f16), null, null, null, null, vVar2222222, 60, null));
                if (gridLayoutMode2 != null) {
                }
                int i1012222222 = i87 >> 3;
                int i1022222222 = (i1012222222 & 14) | 3072 | ((i87 >> 6) & 896);
                int i1032222222 = i87 >> 9;
                int i1042222222 = (i1032222222 & 3670016) | (i1012222222 & 57344) | i1022222222 | (i1032222222 & 458752);
                int i1052222222 = i982 << 21;
                int i1062222222 = i1042222222 | (29360128 & i1052222222) | (234881024 & i1052222222) | (i1052222222 & 1879048192);
                int i1072222222 = i982 >> 12;
                int i1082222222 = i992222 << 21;
                int i1092222222 = (i1072222222 & 458752) | (i1072222222 & 14) | (i1072222222 & 112) | (i1072222222 & 896) | (i1072222222 & 7168) | (i1072222222 & 57344) | (29360128 & i1082222222) | (234881024 & i1082222222) | (i1082222222 & 1879048192);
                int i1102222222 = i992222 >> 9;
                composer2 = startRestartGroup;
                LazyListKt.a(iVar2, function24 != null ? null : function24, aVar4, ListItemsLayoutType.VerticalGrid, lVar2, bool6, aVar3, bool7, bool8, bool9, f37, f38, i88, f39, bool10, f46, null, function19, function110, function18, function17, function23, function16, arrayList2222222, content, composer2, i1062222222, i1092222222, (i1102222222 & 896) | (i1102222222 & 14) | 4096 | (i1102222222 & 112) | ((i992222 >> 6) & 57344), 65536);
                if (ComposerKt.isTraceInProgress()) {
                }
                rVar4 = rVar3;
                iVar3 = iVar2;
                function25 = function24;
                aVar5 = aVar4;
                lVar3 = lVar2;
                f47 = f36;
                f48 = f29;
                bool11 = bool6;
                aVar6 = aVar3;
                bool12 = bool7;
                bool13 = bool8;
                bool14 = bool9;
                gridLayoutMode3 = gridLayoutMode2;
                f49 = f37;
                f56 = f38;
                i89 = i88;
                f57 = f39;
                bool15 = bool10;
                f58 = f46;
                function111 = function19;
                function112 = function110;
                function113 = function18;
                function114 = function17;
                function26 = function23;
                function115 = function16;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i27 = i19 & 8;
            if (i27 != 0) {
            }
            i28 = i19 & 16;
            if (i28 == 0) {
            }
            i29 = i19 & 32;
            if (i29 == 0) {
            }
            i36 = i19 & 64;
            if (i36 == 0) {
            }
            i37 = i19 & 128;
            if (i37 == 0) {
            }
            i38 = i19 & 256;
            if (i38 == 0) {
            }
            i39 = i19 & 512;
            if (i39 == 0) {
            }
            i46 = i19 & 1024;
            if (i46 == 0) {
            }
            i48 = i19 & 2048;
            if (i48 == 0) {
            }
            int i9822 = i47;
            i49 = i19 & 4096;
            if (i49 == 0) {
            }
            i56 = i19 & 8192;
            if (i56 != 0) {
            }
            i58 = i19 & 16384;
            if (i58 == 0) {
            }
            i59 = i58;
            i65 = i19 & 32768;
            if (i65 != 0) {
            }
            i66 = i19 & 65536;
            if (i66 != 0) {
            }
            i67 = i19 & 131072;
            if (i67 != 0) {
            }
            i68 = i19 & 262144;
            if (i68 != 0) {
            }
            i69 = i19 & 524288;
            if (i69 != 0) {
            }
            i75 = i19 & 1048576;
            if (i75 != 0) {
            }
            i77 = i19 & 2097152;
            if (i77 != 0) {
            }
            int i9922222 = i76;
            i78 = i19 & 4194304;
            if (i78 != 0) {
            }
            i79 = i19 & 8388608;
            if (i79 == 0) {
            }
            i85 = i19 & 16777216;
            if (i85 != 0) {
            }
            i86 = i19 & 33554432;
            if (i86 != 0) {
            }
            if ((i19 & 67108864) == 0) {
            }
            i9922222 |= i95;
            if ((i26 & 1533916891) != 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i16 & 1) == 0) {
            }
            if ((i19 & 1) == 0) {
            }
            if (i97 == 0) {
            }
            if (i27 == 0) {
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
            if (i48 == 0) {
            }
            if (i49 == 0) {
            }
            if (i57 == 0) {
            }
            if (i59 == 0) {
            }
            if (i65 == 0) {
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
            if (i77 == 0) {
            }
            if (i78 == 0) {
            }
            if (i79 == 0) {
            }
            if (i85 == 0) {
            }
            if (i86 == 0) {
            }
            iVar2 = iVar4;
            rVar3 = rVar2;
            function24 = function27;
            aVar4 = aVar7;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            ArrayList arrayList22222222 = new ArrayList();
            v vVar22222222 = v.f339448a;
            arrayList22222222.add(new com.tencent.ntcompose.core.k("columns", rVar3, null, null, null, null, vVar22222222, 60, null));
            arrayList22222222.add(new com.tencent.ntcompose.core.k("columnsSpacing", Float.valueOf(f36), null, null, null, null, vVar22222222, 60, null));
            arrayList22222222.add(new com.tencent.ntcompose.core.k("rowsSpacing", Float.valueOf(f29), null, null, null, null, vVar22222222, 60, null));
            arrayList22222222.add(new com.tencent.ntcompose.core.k("listWidth", Float.valueOf(f16), null, null, null, null, vVar22222222, 60, null));
            if (gridLayoutMode2 != null) {
            }
            int i10122222222 = i87 >> 3;
            int i10222222222 = (i10122222222 & 14) | 3072 | ((i87 >> 6) & 896);
            int i10322222222 = i87 >> 9;
            int i10422222222 = (i10322222222 & 3670016) | (i10122222222 & 57344) | i10222222222 | (i10322222222 & 458752);
            int i10522222222 = i9822 << 21;
            int i10622222222 = i10422222222 | (29360128 & i10522222222) | (234881024 & i10522222222) | (i10522222222 & 1879048192);
            int i10722222222 = i9822 >> 12;
            int i10822222222 = i9922222 << 21;
            int i10922222222 = (i10722222222 & 458752) | (i10722222222 & 14) | (i10722222222 & 112) | (i10722222222 & 896) | (i10722222222 & 7168) | (i10722222222 & 57344) | (29360128 & i10822222222) | (234881024 & i10822222222) | (i10822222222 & 1879048192);
            int i11022222222 = i9922222 >> 9;
            composer2 = startRestartGroup;
            LazyListKt.a(iVar2, function24 != null ? null : function24, aVar4, ListItemsLayoutType.VerticalGrid, lVar2, bool6, aVar3, bool7, bool8, bool9, f37, f38, i88, f39, bool10, f46, null, function19, function110, function18, function17, function23, function16, arrayList22222222, content, composer2, i10622222222, i10922222222, (i11022222222 & 896) | (i11022222222 & 14) | 4096 | (i11022222222 & 112) | ((i9922222 >> 6) & 57344), 65536);
            if (ComposerKt.isTraceInProgress()) {
            }
            rVar4 = rVar3;
            iVar3 = iVar2;
            function25 = function24;
            aVar5 = aVar4;
            lVar3 = lVar2;
            f47 = f36;
            f48 = f29;
            bool11 = bool6;
            aVar6 = aVar3;
            bool12 = bool7;
            bool13 = bool8;
            bool14 = bool9;
            gridLayoutMode3 = gridLayoutMode2;
            f49 = f37;
            f56 = f38;
            i89 = i88;
            f57 = f39;
            bool15 = bool10;
            f58 = f46;
            function111 = function19;
            function112 = function110;
            function113 = function18;
            function114 = function17;
            function26 = function23;
            function115 = function16;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        if ((i19 & 4) == 0) {
        }
        i27 = i19 & 8;
        if (i27 != 0) {
        }
        i28 = i19 & 16;
        if (i28 == 0) {
        }
        i29 = i19 & 32;
        if (i29 == 0) {
        }
        i36 = i19 & 64;
        if (i36 == 0) {
        }
        i37 = i19 & 128;
        if (i37 == 0) {
        }
        i38 = i19 & 256;
        if (i38 == 0) {
        }
        i39 = i19 & 512;
        if (i39 == 0) {
        }
        i46 = i19 & 1024;
        if (i46 == 0) {
        }
        i48 = i19 & 2048;
        if (i48 == 0) {
        }
        int i98222 = i47;
        i49 = i19 & 4096;
        if (i49 == 0) {
        }
        i56 = i19 & 8192;
        if (i56 != 0) {
        }
        i58 = i19 & 16384;
        if (i58 == 0) {
        }
        i59 = i58;
        i65 = i19 & 32768;
        if (i65 != 0) {
        }
        i66 = i19 & 65536;
        if (i66 != 0) {
        }
        i67 = i19 & 131072;
        if (i67 != 0) {
        }
        i68 = i19 & 262144;
        if (i68 != 0) {
        }
        i69 = i19 & 524288;
        if (i69 != 0) {
        }
        i75 = i19 & 1048576;
        if (i75 != 0) {
        }
        i77 = i19 & 2097152;
        if (i77 != 0) {
        }
        int i99222222 = i76;
        i78 = i19 & 4194304;
        if (i78 != 0) {
        }
        i79 = i19 & 8388608;
        if (i79 == 0) {
        }
        i85 = i19 & 16777216;
        if (i85 != 0) {
        }
        i86 = i19 & 33554432;
        if (i86 != 0) {
        }
        if ((i19 & 67108864) == 0) {
        }
        i99222222 |= i95;
        if ((i26 & 1533916891) != 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i16 & 1) == 0) {
        }
        if ((i19 & 1) == 0) {
        }
        if (i97 == 0) {
        }
        if (i27 == 0) {
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
        if (i48 == 0) {
        }
        if (i49 == 0) {
        }
        if (i57 == 0) {
        }
        if (i59 == 0) {
        }
        if (i65 == 0) {
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
        if (i77 == 0) {
        }
        if (i78 == 0) {
        }
        if (i79 == 0) {
        }
        if (i85 == 0) {
        }
        if (i86 == 0) {
        }
        iVar2 = iVar4;
        rVar3 = rVar2;
        function24 = function27;
        aVar4 = aVar7;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        ArrayList arrayList222222222 = new ArrayList();
        v vVar222222222 = v.f339448a;
        arrayList222222222.add(new com.tencent.ntcompose.core.k("columns", rVar3, null, null, null, null, vVar222222222, 60, null));
        arrayList222222222.add(new com.tencent.ntcompose.core.k("columnsSpacing", Float.valueOf(f36), null, null, null, null, vVar222222222, 60, null));
        arrayList222222222.add(new com.tencent.ntcompose.core.k("rowsSpacing", Float.valueOf(f29), null, null, null, null, vVar222222222, 60, null));
        arrayList222222222.add(new com.tencent.ntcompose.core.k("listWidth", Float.valueOf(f16), null, null, null, null, vVar222222222, 60, null));
        if (gridLayoutMode2 != null) {
        }
        int i101222222222 = i87 >> 3;
        int i102222222222 = (i101222222222 & 14) | 3072 | ((i87 >> 6) & 896);
        int i103222222222 = i87 >> 9;
        int i104222222222 = (i103222222222 & 3670016) | (i101222222222 & 57344) | i102222222222 | (i103222222222 & 458752);
        int i105222222222 = i98222 << 21;
        int i106222222222 = i104222222222 | (29360128 & i105222222222) | (234881024 & i105222222222) | (i105222222222 & 1879048192);
        int i107222222222 = i98222 >> 12;
        int i108222222222 = i99222222 << 21;
        int i109222222222 = (i107222222222 & 458752) | (i107222222222 & 14) | (i107222222222 & 112) | (i107222222222 & 896) | (i107222222222 & 7168) | (i107222222222 & 57344) | (29360128 & i108222222222) | (234881024 & i108222222222) | (i108222222222 & 1879048192);
        int i110222222222 = i99222222 >> 9;
        composer2 = startRestartGroup;
        LazyListKt.a(iVar2, function24 != null ? null : function24, aVar4, ListItemsLayoutType.VerticalGrid, lVar2, bool6, aVar3, bool7, bool8, bool9, f37, f38, i88, f39, bool10, f46, null, function19, function110, function18, function17, function23, function16, arrayList222222222, content, composer2, i106222222222, i109222222222, (i110222222222 & 896) | (i110222222222 & 14) | 4096 | (i110222222222 & 112) | ((i99222222 >> 6) & 57344), 65536);
        if (ComposerKt.isTraceInProgress()) {
        }
        rVar4 = rVar3;
        iVar3 = iVar2;
        function25 = function24;
        aVar5 = aVar4;
        lVar3 = lVar2;
        f47 = f36;
        f48 = f29;
        bool11 = bool6;
        aVar6 = aVar3;
        bool12 = bool7;
        bool13 = bool8;
        bool14 = bool9;
        gridLayoutMode3 = gridLayoutMode2;
        f49 = f37;
        f56 = f38;
        i89 = i88;
        f57 = f39;
        bool15 = bool10;
        f58 = f46;
        function111 = function19;
        function112 = function110;
        function113 = function18;
        function114 = function17;
        function26 = function23;
        function115 = function16;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
