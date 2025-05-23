package com.tencent.ntcompose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippy.qq.view.viola.list.TkdListView;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.RenderView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.VirtualViewKt;
import com.tencent.kuikly.core.timer.Timer;
import com.tencent.kuikly.core.views.PageListView;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.ScrollerContentView;
import com.tencent.kuikly.core.views.ScrollerView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0007\u00a2\u0006\u0004\b\u0001\u0010\u0002\u001a\u00e8\u0003\u0010)\u001a\u00020\t2Z\b\u0002\u0010\f\u001aT\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004\u0012!\u0012\u001f\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00040\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003j\u0012\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004\u0018\u0001`\n\u00a2\u0006\u0002\b\u000b2\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00162%\b\u0002\u0010\u001a\u001a\u001f\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\t\u0018\u00010\u00182+\b\u0002\u0010\u001e\u001a%\u0012\u0013\u0012\u00110\u001b\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\t\u0018\u00010\u0018j\u0004\u0018\u0001`\u001d2+\b\u0002\u0010\u001f\u001a%\u0012\u0013\u0012\u00110\u001b\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\t\u0018\u00010\u0018j\u0004\u0018\u0001`\u001d2+\b\u0002\u0010 \u001a%\u0012\u0013\u0012\u00110\u001b\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\t\u0018\u00010\u0018j\u0004\u0018\u0001`\u001d2+\b\u0002\u0010!\u001a%\u0012\u0013\u0012\u00110\u001b\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\t\u0018\u00010\u0018j\u0004\u0018\u0001`\u001d2@\b\u0002\u0010%\u001a:\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003j\u0004\u0018\u0001`$2\u001c\u0010(\u001a\u0018\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\t0\u0018\u00a2\u0006\u0002\b'\u00a2\u0006\u0002\b\u000bH\u0007\u00a2\u0006\u0004\b)\u0010*\u001a8\u0010/\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u00162\u0016\u0010.\u001a\u0012\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004\u0018\u00010\u0005H\u0002\u001a8\u00100\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u00162\u0016\u0010.\u001a\u0012\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004\u0018\u00010\u0005H\u0002\u001a*\u00102\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u0001012\u0016\u0010\f\u001a\u0012\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004\u0018\u00010\u0005H\u0002\u001a*\u00103\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u0001012\u0016\u0010\f\u001a\u0012\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004\u0018\u00010\u0005H\u0002\u001a \u00104\u001a\u00020\u00122\u0016\u0010\f\u001a\u0012\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004\u0018\u00010\u0005H\u0002\u00a8\u00065"}, d2 = {"Lcom/tencent/ntcompose/material/ac;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Landroidx/compose/runtime/Composer;I)Lcom/tencent/ntcompose/material/ac;", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/views/PageListView;", "Lcom/tencent/kuikly/core/base/aa;", "Lkotlin/ParameterName;", "name", "viewRef", "", "Lcom/tencent/ntcompose/core/RefFunc;", "Lkotlin/ExtensionFunctionType;", "ref", "Lcom/tencent/ntcompose/core/i;", "modifier", "state", "", "pageItemWidth", "", "itemTotalCount", "loopPlayIntervalTimeMs", "defaultPageIndex", "", "scrollEnable", "Lkotlin/Function1;", "index", "onPageIndexDidChanged", "Lcom/tencent/kuikly/core/views/bn;", "e", "Lcom/tencent/ntcompose/material/ListEventCallback;", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, TkdListView.EVENT_TYPE_SCROLL_END, "onBeginDrag", "onEndDrag", "width", "height", "Lcom/tencent/ntcompose/material/ContentSizeChangedEventCallback;", "onContentSizeChanged", "Lcom/tencent/ntcompose/foundation/lazy/layout/a;", "Landroidx/compose/runtime/Composable;", "content", "a", "(Lkotlin/jvm/functions/Function2;Lcom/tencent/ntcompose/core/i;Lcom/tencent/ntcompose/material/ac;FIIIZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "offset", "itemSize", "isHorizontal", "pageListRef", "B", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", HippyTKDListViewAdapter.X, "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class SliderPageKt {
    /* JADX WARN: Type inference failed for: r11v10, types: [com.tencent.kuikly.core.base.Attr] */
    /* JADX WARN: Type inference failed for: r11v3, types: [com.tencent.kuikly.core.base.Attr] */
    /* JADX WARN: Type inference failed for: r11v5, types: [com.tencent.kuikly.core.base.Attr] */
    /* JADX WARN: Type inference failed for: r11v8, types: [com.tencent.kuikly.core.base.Attr] */
    /* JADX WARN: Type inference failed for: r13v10, types: [com.tencent.kuikly.core.base.Attr] */
    /* JADX WARN: Type inference failed for: r13v14, types: [com.tencent.kuikly.core.base.Attr] */
    /* JADX WARN: Type inference failed for: r13v3, types: [com.tencent.kuikly.core.base.Attr] */
    /* JADX WARN: Type inference failed for: r13v7, types: [com.tencent.kuikly.core.base.Attr] */
    private static final void B(float f16, float f17, boolean z16, com.tencent.kuikly.core.base.aa<PageListView<?, ?>> aaVar) {
        ?? viewAttr;
        ?? viewAttr2;
        ?? viewAttr3;
        ?? viewAttr4;
        ?? viewAttr5;
        ?? viewAttr6;
        ?? viewAttr7;
        ?? viewAttr8;
        float x16 = (x(aaVar) + 2) * f17;
        float f18 = x(aaVar) > 2 ? 1.5f * f17 : f17;
        if (z16) {
            if (f16 < f18) {
                DeclarativeBaseView<?, ?> z17 = z(aaVar);
                if (z17 != null && (viewAttr8 = z17.getViewAttr()) != 0) {
                    viewAttr8.transform(new com.tencent.kuikly.core.base.y((-x(aaVar)) * 1.0f, 0.0f, 0.0f, 0.0f, 14, null));
                }
            } else {
                DeclarativeBaseView<?, ?> z18 = z(aaVar);
                if (z18 != null && (viewAttr5 = z18.getViewAttr()) != 0) {
                    viewAttr5.transform(new com.tencent.kuikly.core.base.y(0.0f, 0.0f, 0.0f, 0.0f, 12, null));
                }
            }
            if (f16 > (x16 - f17) - f18) {
                DeclarativeBaseView<?, ?> y16 = y(aaVar);
                if (y16 == null || (viewAttr7 = y16.getViewAttr()) == 0) {
                    return;
                }
                viewAttr7.transform(new com.tencent.kuikly.core.base.y(x(aaVar) * 1.0f, 0.0f, 0.0f, 0.0f, 14, null));
                return;
            }
            DeclarativeBaseView<?, ?> y17 = y(aaVar);
            if (y17 == null || (viewAttr6 = y17.getViewAttr()) == 0) {
                return;
            }
            viewAttr6.transform(new com.tencent.kuikly.core.base.y(0.0f, 0.0f, 0.0f, 0.0f, 14, null));
            return;
        }
        if (f16 < f18) {
            DeclarativeBaseView<?, ?> z19 = z(aaVar);
            if (z19 != null && (viewAttr4 = z19.getViewAttr()) != 0) {
                viewAttr4.transform(new com.tencent.kuikly.core.base.y(0.0f, (-x(aaVar)) * 1.0f, 0.0f, 0.0f, 12, null));
            }
        } else {
            DeclarativeBaseView<?, ?> z26 = z(aaVar);
            if (z26 != null && (viewAttr = z26.getViewAttr()) != 0) {
                viewAttr.transform(new com.tencent.kuikly.core.base.y(0.0f, 0.0f, 0.0f, 0.0f, 12, null));
            }
        }
        if (f16 > (x16 - f17) - f18) {
            DeclarativeBaseView<?, ?> y18 = y(aaVar);
            if (y18 == null || (viewAttr3 = y18.getViewAttr()) == 0) {
                return;
            }
            viewAttr3.transform(new com.tencent.kuikly.core.base.y(0.0f, x(aaVar) * 1.0f, 0.0f, 0.0f, 12, null));
            return;
        }
        DeclarativeBaseView<?, ?> y19 = y(aaVar);
        if (y19 == null || (viewAttr2 = y19.getViewAttr()) == 0) {
            return;
        }
        viewAttr2.transform(new com.tencent.kuikly.core.base.y(0.0f, 0.0f, 0.0f, 0.0f, 12, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(float f16, float f17, boolean z16, com.tencent.kuikly.core.base.aa<PageListView<?, ?>> aaVar) {
        PageListView<?, ?> b16;
        PageListView<?, ?> b17;
        PageListView<?, ?> b18;
        PageListView<?, ?> b19;
        float x16 = (x(aaVar) + 2) * f17;
        if (f16 < 0.1f) {
            f16 = x(aaVar) * 1.0f * f17;
            if (z16) {
                if (aaVar != null && (b19 = aaVar.b()) != null) {
                    ScrollerView.setContentOffset$default(b19, f16, 0.0f, false, null, 8, null);
                }
            } else if (aaVar != null && (b18 = aaVar.b()) != null) {
                ScrollerView.setContentOffset$default(b18, 0.0f, f16, false, null, 8, null);
            }
        } else if (f16 >= (x16 - f17) - 0.1f) {
            if (z16) {
                if (aaVar != null && (b17 = aaVar.b()) != null) {
                    ScrollerView.setContentOffset$default(b17, f17, 0.0f, false, null, 8, null);
                }
            } else if (aaVar != null && (b16 = aaVar.b()) != null) {
                ScrollerView.setContentOffset$default(b16, 0.0f, f17, false, null, 8, null);
            }
            f16 = f17;
        }
        B(f16, f17, z16, aaVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x065d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x05a4  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x067c  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(Function2<? super PageListView<?, ?>, ? super com.tencent.kuikly.core.base.aa<PageListView<?, ?>>, Unit> function2, final com.tencent.ntcompose.core.i modifier, ac acVar, final float f16, final int i3, int i16, int i17, boolean z16, Function1<? super Integer, Unit> function1, Function1<? super ScrollParams, Unit> function12, Function1<? super ScrollParams, Unit> function13, Function1<? super ScrollParams, Unit> function14, Function1<? super ScrollParams, Unit> function15, Function2<? super Float, ? super Float, Unit> function22, final Function3<? super com.tencent.ntcompose.foundation.lazy.layout.a, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i18, final int i19, final int i26) {
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
        Object rememberedValue;
        Composer.Companion companion;
        Function2<? super Float, ? super Float, Unit> function23;
        int i57;
        Function1<? super ScrollParams, Unit> function16;
        Function1<? super ScrollParams, Unit> function17;
        Function2<? super PageListView<?, ?>, ? super com.tencent.kuikly.core.base.aa<PageListView<?, ?>>, Unit> function24;
        Function1<? super ScrollParams, Unit> function18;
        Function1<? super ScrollParams, Unit> function19;
        Composer composer2;
        Function1<? super Integer, Unit> function110;
        final Function1<? super Integer, Unit> function111;
        final Function1<? super ScrollParams, Unit> function112;
        final Function1<? super ScrollParams, Unit> function113;
        final ac acVar2;
        final int i58;
        final boolean z17;
        final Function2<? super PageListView<?, ?>, ? super com.tencent.kuikly.core.base.aa<PageListView<?, ?>>, Unit> function25;
        final Function1<? super ScrollParams, Unit> function114;
        final Function1<? super ScrollParams, Unit> function115;
        final Function2<? super Float, ? super Float, Unit> function26;
        final int i59;
        int i65;
        int i66;
        Composer composer3;
        char c16;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(1183617166);
        int i67 = i26 & 1;
        if (i67 != 0) {
            i27 = i18 | 6;
        } else if ((i18 & 14) == 0) {
            i27 = (startRestartGroup.changed(function2) ? 4 : 2) | i18;
        } else {
            i27 = i18;
        }
        if ((i26 & 2) != 0) {
            i27 |= 48;
        } else if ((i18 & 112) == 0) {
            i27 |= startRestartGroup.changed(modifier) ? 32 : 16;
        }
        int i68 = i26 & 4;
        if (i68 != 0) {
            i27 |= MsgConstant.KRMFILETHUMBSIZE384;
        } else if ((i18 & 896) == 0) {
            i27 |= startRestartGroup.changed(acVar) ? 256 : 128;
            if ((i26 & 8) == 0) {
                i27 |= 3072;
            } else if ((i18 & 7168) == 0) {
                i27 |= startRestartGroup.changed(f16) ? 2048 : 1024;
            }
            if ((i26 & 16) == 0) {
                i27 |= 24576;
            } else if ((57344 & i18) == 0) {
                i27 |= startRestartGroup.changed(i3) ? 16384 : 8192;
            }
            i28 = i26 & 32;
            if (i28 == 0) {
                i27 |= 196608;
            } else if ((i18 & 458752) == 0) {
                i27 |= startRestartGroup.changed(i16) ? 131072 : 65536;
            }
            i29 = i26 & 64;
            if (i29 == 0) {
                i27 |= 1572864;
            } else if ((i18 & 3670016) == 0) {
                i27 |= startRestartGroup.changed(i17) ? 1048576 : 524288;
            }
            i36 = i26 & 128;
            if (i36 == 0) {
                i27 |= 12582912;
            } else if ((i18 & 29360128) == 0) {
                i27 |= startRestartGroup.changed(z16) ? 8388608 : 4194304;
            }
            i37 = i26 & 256;
            if (i37 == 0) {
                i27 |= 100663296;
            } else if ((i18 & 234881024) == 0) {
                i27 |= startRestartGroup.changed(function1) ? 67108864 : 33554432;
            }
            i38 = i26 & 512;
            if (i38 == 0) {
                i27 |= 805306368;
            } else if ((i18 & 1879048192) == 0) {
                i27 |= startRestartGroup.changed(function12) ? 536870912 : 268435456;
            }
            i39 = i26 & 1024;
            if (i39 == 0) {
                i46 = i19 | 6;
            } else if ((i19 & 14) == 0) {
                i46 = i19 | (startRestartGroup.changed(function13) ? 4 : 2);
            } else {
                i46 = i19;
            }
            i47 = i26 & 2048;
            if (i47 == 0) {
                i46 |= 48;
            } else if ((i19 & 112) == 0) {
                i46 |= startRestartGroup.changed(function14) ? 32 : 16;
            }
            final int i69 = i46;
            i48 = i26 & 4096;
            if (i48 == 0) {
                i69 |= MsgConstant.KRMFILETHUMBSIZE384;
            } else if ((i19 & 896) == 0) {
                i69 |= startRestartGroup.changed(function15) ? 256 : 128;
                i49 = i26 & 8192;
                if (i49 != 0) {
                    i69 |= 3072;
                    i56 = i49;
                } else {
                    i56 = i49;
                    if ((i19 & 7168) == 0) {
                        i69 |= startRestartGroup.changed(function22) ? 2048 : 1024;
                        if ((i26 & 16384) == 0) {
                            i69 |= 24576;
                        } else if ((57344 & i19) == 0) {
                            i69 |= startRestartGroup.changed(content) ? 16384 : 8192;
                        }
                        if ((1533916891 & i27) != 306783378 && (46811 & i69) == 9362 && startRestartGroup.getSkipping()) {
                            startRestartGroup.skipToGroupEnd();
                            function25 = function2;
                            acVar2 = acVar;
                            i59 = i16;
                            i58 = i17;
                            function111 = function1;
                            function112 = function12;
                            function113 = function13;
                            function114 = function14;
                            function115 = function15;
                            function26 = function22;
                            composer2 = startRestartGroup;
                            z17 = z16;
                        } else {
                            final Function2<? super PageListView<?, ?>, ? super com.tencent.kuikly.core.base.aa<PageListView<?, ?>>, Unit> function27 = i67 == 0 ? null : function2;
                            ac acVar3 = i68 == 0 ? null : acVar;
                            int i75 = i28 == 0 ? 3000 : i16;
                            int i76 = i29 == 0 ? 0 : i17;
                            boolean z18 = i36 == 0 ? true : z16;
                            final Function1<? super Integer, Unit> function116 = i37 == 0 ? null : function1;
                            final Function1<? super ScrollParams, Unit> function117 = i38 == 0 ? null : function12;
                            final Function1<? super ScrollParams, Unit> function118 = i39 == 0 ? null : function13;
                            final Function1<? super ScrollParams, Unit> function119 = i47 == 0 ? null : function14;
                            final Function1<? super ScrollParams, Unit> function120 = i48 == 0 ? null : function15;
                            final Function2<? super Float, ? super Float, Unit> function28 = i56 == 0 ? null : function22;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1183617166, i27, i69, "com.tencent.ntcompose.material.HorizontalSliderPage (SliderPage.kt:72)");
                            }
                            startRestartGroup.startReplaceableGroup(-492369756);
                            rememberedValue = startRestartGroup.rememberedValue();
                            companion = Composer.INSTANCE;
                            if (rememberedValue == companion.getEmpty()) {
                                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(-1, null, 2, null);
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            startRestartGroup.endReplaceableGroup();
                            final MutableState mutableState = (MutableState) rememberedValue;
                            int max = i75 > 0 ? 0 : Math.max(1000, i75);
                            if (i3 <= 1) {
                                startRestartGroup.startReplaceableGroup(-1608415565);
                                startRestartGroup.startReplaceableGroup(-492369756);
                                Object rememberedValue2 = startRestartGroup.rememberedValue();
                                if (rememberedValue2 == companion.getEmpty()) {
                                    rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                }
                                startRestartGroup.endReplaceableGroup();
                                final MutableState mutableState2 = (MutableState) rememberedValue2;
                                startRestartGroup.startReplaceableGroup(-492369756);
                                Object rememberedValue3 = startRestartGroup.rememberedValue();
                                if (rememberedValue3 == companion.getEmpty()) {
                                    i65 = i75;
                                    rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                                    startRestartGroup.updateRememberedValue(rememberedValue3);
                                } else {
                                    i65 = i75;
                                }
                                startRestartGroup.endReplaceableGroup();
                                final MutableState mutableState3 = (MutableState) rememberedValue3;
                                startRestartGroup.startReplaceableGroup(-492369756);
                                Object rememberedValue4 = startRestartGroup.rememberedValue();
                                if (rememberedValue4 == companion.getEmpty()) {
                                    i66 = i27;
                                    rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                                    startRestartGroup.updateRememberedValue(rememberedValue4);
                                } else {
                                    i66 = i27;
                                }
                                startRestartGroup.endReplaceableGroup();
                                final MutableState mutableState4 = (MutableState) rememberedValue4;
                                int i77 = i76 + 1;
                                startRestartGroup.startReplaceableGroup(511388516);
                                boolean changed = startRestartGroup.changed(mutableState2) | startRestartGroup.changed(function27);
                                Object rememberedValue5 = startRestartGroup.rememberedValue();
                                if (changed || rememberedValue5 == companion.getEmpty()) {
                                    rememberedValue5 = new Function2<PageListView<?, ?>, com.tencent.kuikly.core.base.aa<PageListView<?, ?>>, Unit>() { // from class: com.tencent.ntcompose.material.SliderPageKt$HorizontalSliderPage$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(PageListView<?, ?> pageListView, com.tencent.kuikly.core.base.aa<PageListView<?, ?>> aaVar) {
                                            invoke2(pageListView, aaVar);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(PageListView<?, ?> HorizontalPagerList, com.tencent.kuikly.core.base.aa<PageListView<?, ?>> it) {
                                            Intrinsics.checkNotNullParameter(HorizontalPagerList, "$this$HorizontalPagerList");
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            SliderPageKt.i(mutableState2, it);
                                            Function2<PageListView<?, ?>, com.tencent.kuikly.core.base.aa<PageListView<?, ?>>, Unit> function29 = function27;
                                            if (function29 != null) {
                                                function29.invoke(HorizontalPagerList, it);
                                            }
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue5);
                                }
                                startRestartGroup.endReplaceableGroup();
                                Function2 function29 = (Function2) rememberedValue5;
                                Float valueOf = Float.valueOf(f16);
                                Boolean valueOf2 = Boolean.valueOf(z18);
                                Boolean bool = Boolean.FALSE;
                                Function2<? super PageListView<?, ?>, ? super com.tencent.kuikly.core.base.aa<PageListView<?, ?>>, Unit> function210 = function27;
                                startRestartGroup.startReplaceableGroup(1618982084);
                                boolean changed2 = startRestartGroup.changed(mutableState2) | startRestartGroup.changed(mutableState) | startRestartGroup.changed(function116);
                                Object rememberedValue6 = startRestartGroup.rememberedValue();
                                if (changed2 || rememberedValue6 == companion.getEmpty()) {
                                    rememberedValue6 = new Function1<Integer, Unit>() { // from class: com.tencent.ntcompose.material.SliderPageKt$HorizontalSliderPage$2$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                                            invoke(num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(int i78) {
                                            com.tencent.kuikly.core.base.aa h16;
                                            int x16;
                                            int d16;
                                            h16 = SliderPageKt.h(mutableState2);
                                            x16 = SliderPageKt.x(h16);
                                            int i79 = i78 == 0 ? x16 - 1 : i78 >= x16 + 1 ? 0 : i78 - 1;
                                            d16 = SliderPageKt.d(mutableState);
                                            if (d16 != i79) {
                                                SliderPageKt.g(mutableState, i79);
                                                Function1<Integer, Unit> function121 = function116;
                                                if (function121 != null) {
                                                    function121.invoke(Integer.valueOf(i79));
                                                }
                                            }
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue6);
                                }
                                startRestartGroup.endReplaceableGroup();
                                Function1 function121 = (Function1) rememberedValue6;
                                startRestartGroup.startReplaceableGroup(1618982084);
                                boolean changed3 = startRestartGroup.changed(mutableState3) | startRestartGroup.changed(mutableState2) | startRestartGroup.changed(function117);
                                Object rememberedValue7 = startRestartGroup.rememberedValue();
                                if (changed3 || rememberedValue7 == companion.getEmpty()) {
                                    rememberedValue7 = new Function1<ScrollParams, Unit>() { // from class: com.tencent.ntcompose.material.SliderPageKt$HorizontalSliderPage$3$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(ScrollParams scrollParams) {
                                            invoke2(scrollParams);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(ScrollParams it) {
                                            com.tencent.kuikly.core.base.aa h16;
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            SliderPageKt.k(mutableState3, true);
                                            float offsetX = it.getOffsetX();
                                            float viewWidth = it.getViewWidth();
                                            h16 = SliderPageKt.h(mutableState2);
                                            SliderPageKt.C(offsetX, viewWidth, true, h16);
                                            Function1<ScrollParams, Unit> function122 = function117;
                                            if (function122 != null) {
                                                function122.invoke(it);
                                            }
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue7);
                                }
                                startRestartGroup.endReplaceableGroup();
                                Function1 function122 = (Function1) rememberedValue7;
                                startRestartGroup.startReplaceableGroup(511388516);
                                boolean changed4 = startRestartGroup.changed(mutableState2) | startRestartGroup.changed(function118);
                                Object rememberedValue8 = startRestartGroup.rememberedValue();
                                if (changed4 || rememberedValue8 == companion.getEmpty()) {
                                    rememberedValue8 = new Function1<ScrollParams, Unit>() { // from class: com.tencent.ntcompose.material.SliderPageKt$HorizontalSliderPage$4$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(ScrollParams scrollParams) {
                                            invoke2(scrollParams);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(ScrollParams it) {
                                            com.tencent.kuikly.core.base.aa h16;
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            float offsetX = it.getOffsetX();
                                            float viewWidth = it.getViewWidth();
                                            h16 = SliderPageKt.h(mutableState2);
                                            SliderPageKt.C(offsetX, viewWidth, true, h16);
                                            Function1<ScrollParams, Unit> function123 = function118;
                                            if (function123 != null) {
                                                function123.invoke(it);
                                            }
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue8);
                                }
                                startRestartGroup.endReplaceableGroup();
                                Function1 function123 = (Function1) rememberedValue8;
                                startRestartGroup.startReplaceableGroup(511388516);
                                boolean changed5 = startRestartGroup.changed(mutableState4) | startRestartGroup.changed(function119);
                                Object rememberedValue9 = startRestartGroup.rememberedValue();
                                if (changed5 || rememberedValue9 == companion.getEmpty()) {
                                    rememberedValue9 = new Function1<ScrollParams, Unit>() { // from class: com.tencent.ntcompose.material.SliderPageKt$HorizontalSliderPage$5$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(ScrollParams scrollParams) {
                                            invoke2(scrollParams);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(ScrollParams it) {
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            SliderPageKt.c(mutableState4, true);
                                            Function1<ScrollParams, Unit> function124 = function119;
                                            if (function124 != null) {
                                                function124.invoke(it);
                                            }
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue9);
                                }
                                startRestartGroup.endReplaceableGroup();
                                Function1 function124 = (Function1) rememberedValue9;
                                startRestartGroup.startReplaceableGroup(511388516);
                                boolean changed6 = startRestartGroup.changed(mutableState4) | startRestartGroup.changed(function120);
                                Object rememberedValue10 = startRestartGroup.rememberedValue();
                                if (changed6 || rememberedValue10 == companion.getEmpty()) {
                                    rememberedValue10 = new Function1<ScrollParams, Unit>() { // from class: com.tencent.ntcompose.material.SliderPageKt$HorizontalSliderPage$6$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(ScrollParams scrollParams) {
                                            invoke2(scrollParams);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(ScrollParams it) {
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            SliderPageKt.c(mutableState4, false);
                                            Function1<ScrollParams, Unit> function125 = function120;
                                            if (function125 != null) {
                                                function125.invoke(it);
                                            }
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue10);
                                }
                                startRestartGroup.endReplaceableGroup();
                                Function1 function125 = (Function1) rememberedValue10;
                                Object[] objArr = {mutableState3, mutableState2, Float.valueOf(f16), function28};
                                startRestartGroup.startReplaceableGroup(-568225417);
                                Function1<? super ScrollParams, Unit> function126 = function117;
                                boolean z19 = false;
                                for (int i78 = 0; i78 < 4; i78++) {
                                    z19 |= startRestartGroup.changed(objArr[i78]);
                                }
                                Object rememberedValue11 = startRestartGroup.rememberedValue();
                                if (z19 || rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue11 = new Function2<Float, Float, Unit>() { // from class: com.tencent.ntcompose.material.SliderPageKt$HorizontalSliderPage$7$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Float f17, Float f18) {
                                            invoke(f17.floatValue(), f18.floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(float f17, float f18) {
                                            boolean j3;
                                            com.tencent.kuikly.core.base.aa h16;
                                            com.tencent.kuikly.core.base.aa h17;
                                            PageListView pageListView;
                                            j3 = SliderPageKt.j(mutableState3);
                                            if (j3) {
                                                h16 = SliderPageKt.h(mutableState2);
                                                float curOffsetX = (h16 == null || (pageListView = (PageListView) h16.b()) == null) ? 0.0f : pageListView.getCurOffsetX();
                                                float f19 = f16;
                                                h17 = SliderPageKt.h(mutableState2);
                                                SliderPageKt.C(curOffsetX, f19, true, h17);
                                            }
                                            Function2<Float, Float, Unit> function211 = function28;
                                            if (function211 != null) {
                                                function211.invoke(Float.valueOf(f17), Float.valueOf(f18));
                                            }
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue11);
                                }
                                startRestartGroup.endReplaceableGroup();
                                int i79 = i66;
                                function23 = function28;
                                Function1<? super Integer, Unit> function127 = function116;
                                i57 = i65;
                                function16 = function126;
                                function17 = function118;
                                function24 = function210;
                                function18 = function119;
                                function19 = function120;
                                PagerListKt.a(modifier, function29, acVar3, valueOf, i77, valueOf2, null, bool, bool, null, null, 0, null, null, null, 0.0f, function121, function122, function123, function124, function125, (Function2) rememberedValue11, null, ComposableLambdaKt.composableLambda(startRestartGroup, -559967034, true, new Function3<com.tencent.ntcompose.foundation.lazy.layout.a, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.SliderPageKt$HorizontalSliderPage$8
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.lazy.layout.a aVar, Composer composer4, Integer num) {
                                        invoke(aVar, composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(com.tencent.ntcompose.foundation.lazy.layout.a HorizontalPagerList, Composer composer4, int i85) {
                                        Intrinsics.checkNotNullParameter(HorizontalPagerList, "$this$HorizontalPagerList");
                                        if ((i85 & 14) == 0) {
                                            i85 |= composer4.changed(HorizontalPagerList) ? 4 : 2;
                                        }
                                        if ((i85 & 91) == 18 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-559967034, i85, -1, "com.tencent.ntcompose.material.HorizontalSliderPage.<anonymous> (SliderPage.kt:157)");
                                        }
                                        composer4.startMovableGroup(1377959221, MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST);
                                        i.Companion companion2 = com.tencent.ntcompose.core.i.INSTANCE;
                                        BoxKt.a(ModifiersKt.M(companion2, false), null, null, null, composer4, 0, 14);
                                        composer4.endMovableGroup();
                                        content.invoke(HorizontalPagerList, composer4, Integer.valueOf((i85 & 14) | ((i69 >> 9) & 112)));
                                        composer4.startMovableGroup(1377959355, "last");
                                        BoxKt.a(ModifiersKt.M(companion2, false), null, null, null, composer4, 0, 14);
                                        composer4.endMovableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), startRestartGroup, ((i66 >> 3) & 14) | 113246208 | (i79 & 896) | (i79 & 7168) | ((i79 >> 6) & 458752), 0, 3072, 4259392);
                                if (max > 0) {
                                    composer3 = startRestartGroup;
                                    composer3.startReplaceableGroup(-492369756);
                                    Object rememberedValue12 = composer3.rememberedValue();
                                    if (rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                                        c16 = 2;
                                        rememberedValue12 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                        composer3.updateRememberedValue(rememberedValue12);
                                    } else {
                                        c16 = 2;
                                    }
                                    composer3.endReplaceableGroup();
                                    final MutableState mutableState5 = (MutableState) rememberedValue12;
                                    Integer valueOf3 = Integer.valueOf(max);
                                    Boolean valueOf4 = Boolean.valueOf(b(mutableState4));
                                    Object[] objArr2 = new Object[5];
                                    objArr2[0] = mutableState4;
                                    objArr2[1] = mutableState5;
                                    objArr2[c16] = Integer.valueOf(max);
                                    objArr2[3] = mutableState2;
                                    objArr2[4] = mutableState;
                                    composer3.startReplaceableGroup(-568225417);
                                    boolean z26 = false;
                                    for (int i85 = 0; i85 < 5; i85++) {
                                        z26 |= composer3.changed(objArr2[i85]);
                                    }
                                    Object rememberedValue13 = composer3.rememberedValue();
                                    if (z26 || rememberedValue13 == Composer.INSTANCE.getEmpty()) {
                                        final int i86 = max;
                                        rememberedValue13 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.tencent.ntcompose.material.SliderPageKt$HorizontalSliderPage$9$1

                                            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "", "dispose", "runtime_release"}, k = 1, mv = {1, 7, 1})
                                            /* loaded from: classes34.dex */
                                            public static final class a implements DisposableEffectResult {

                                                /* renamed from: a, reason: collision with root package name */
                                                final /* synthetic */ MutableState f339354a;

                                                public a(MutableState mutableState) {
                                                    this.f339354a = mutableState;
                                                }

                                                @Override // androidx.compose.runtime.DisposableEffectResult
                                                public void dispose() {
                                                    Timer e16;
                                                    e16 = SliderPageKt.e(this.f339354a);
                                                    if (e16 != null) {
                                                        e16.e();
                                                    }
                                                    SliderPageKt.f(this.f339354a, null);
                                                }
                                            }

                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                                                boolean b16;
                                                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                                                b16 = SliderPageKt.b(mutableState4);
                                                if (!b16) {
                                                    MutableState<Timer> mutableState6 = mutableState5;
                                                    Timer timer = new Timer();
                                                    int i87 = i86;
                                                    final MutableState<com.tencent.kuikly.core.base.aa<PageListView<?, ?>>> mutableState7 = mutableState2;
                                                    final MutableState<Integer> mutableState8 = mutableState;
                                                    timer.f(i87, i87, new Function0<Unit>() { // from class: com.tencent.ntcompose.material.SliderPageKt$HorizontalSliderPage$9$1$1$1
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(0);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function0
                                                        public /* bridge */ /* synthetic */ Unit invoke() {
                                                            invoke2();
                                                            return Unit.INSTANCE;
                                                        }

                                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                        public final void invoke2() {
                                                            com.tencent.kuikly.core.base.aa h16;
                                                            PageListView pageListView;
                                                            int d16;
                                                            h16 = SliderPageKt.h(mutableState7);
                                                            if (h16 == null || (pageListView = (PageListView) h16.b()) == null) {
                                                                return;
                                                            }
                                                            d16 = SliderPageKt.d(mutableState8);
                                                            pageListView.scrollToPageIndex(d16 + 2, true);
                                                        }
                                                    });
                                                    SliderPageKt.f(mutableState6, timer);
                                                }
                                                return new a(mutableState5);
                                            }
                                        };
                                        composer3.updateRememberedValue(rememberedValue13);
                                    }
                                    composer3.endReplaceableGroup();
                                    EffectsKt.DisposableEffect(valueOf3, valueOf4, (Function1) rememberedValue13, composer3, 0);
                                } else {
                                    composer3 = startRestartGroup;
                                }
                                composer3.endReplaceableGroup();
                                composer2 = composer3;
                                function110 = function127;
                            } else {
                                function23 = function28;
                                Function1<? super Integer, Unit> function128 = function116;
                                i57 = i75;
                                function16 = function117;
                                function17 = function118;
                                function24 = function27;
                                function18 = function119;
                                function19 = function120;
                                int i87 = i27;
                                startRestartGroup.startReplaceableGroup(-1608412688);
                                int i88 = i69;
                                int i89 = i87 >> 6;
                                int i95 = ((i87 >> 3) & 14) | 100687872 | ((i87 << 3) & 112) | (i87 & 896) | (i87 & 7168) | (i89 & 458752);
                                int i96 = 29360128 & i89;
                                int i97 = i88 << 24;
                                int i98 = i96 | (234881024 & i97) | (i97 & 1879048192);
                                int i99 = i88 >> 6;
                                composer2 = startRestartGroup;
                                PagerListKt.a(modifier, function24, acVar3, Float.valueOf(f16), 0, Boolean.valueOf(z18), null, null, Boolean.FALSE, null, null, 0, null, null, null, 0.0f, null, function16, function17, function18, function19, function23, null, content, composer2, i95, i98, (i99 & 112) | (i99 & 14) | ((i88 >> 3) & 7168), 4325056);
                                if (d(mutableState) != 0) {
                                    g(mutableState, 0);
                                    function110 = function128;
                                    if (function110 != null) {
                                        function110.invoke(Integer.valueOf(d(mutableState)));
                                        Unit unit = Unit.INSTANCE;
                                    }
                                } else {
                                    function110 = function128;
                                }
                                composer2.endReplaceableGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function111 = function110;
                            function112 = function16;
                            function113 = function17;
                            acVar2 = acVar3;
                            i58 = i76;
                            z17 = z18;
                            function25 = function24;
                            function114 = function18;
                            function115 = function19;
                            function26 = function23;
                            i59 = i57;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            return;
                        }
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.SliderPageKt$HorizontalSliderPage$10
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i100) {
                                SliderPageKt.a(function25, modifier, acVar2, f16, i3, i59, i58, z17, function111, function112, function113, function114, function115, function26, content, composer4, i18 | 1, i19, i26);
                            }
                        });
                        return;
                    }
                }
                if ((i26 & 16384) == 0) {
                }
                if ((1533916891 & i27) != 306783378) {
                }
                if (i67 == 0) {
                }
                if (i68 == 0) {
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
                if (i47 == 0) {
                }
                if (i48 == 0) {
                }
                if (i56 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceableGroup(-492369756);
                rememberedValue = startRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (rememberedValue == companion.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                final MutableState<Integer> mutableState6 = (MutableState) rememberedValue;
                if (i75 > 0) {
                }
                if (i3 <= 1) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                function111 = function110;
                function112 = function16;
                function113 = function17;
                acVar2 = acVar3;
                i58 = i76;
                z17 = z18;
                function25 = function24;
                function114 = function18;
                function115 = function19;
                function26 = function23;
                i59 = i57;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i49 = i26 & 8192;
            if (i49 != 0) {
            }
            if ((i26 & 16384) == 0) {
            }
            if ((1533916891 & i27) != 306783378) {
            }
            if (i67 == 0) {
            }
            if (i68 == 0) {
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
            if (i47 == 0) {
            }
            if (i48 == 0) {
            }
            if (i56 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            rememberedValue = startRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState<Integer> mutableState62 = (MutableState) rememberedValue;
            if (i75 > 0) {
            }
            if (i3 <= 1) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            function111 = function110;
            function112 = function16;
            function113 = function17;
            acVar2 = acVar3;
            i58 = i76;
            z17 = z18;
            function25 = function24;
            function114 = function18;
            function115 = function19;
            function26 = function23;
            i59 = i57;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        if ((i26 & 8) == 0) {
        }
        if ((i26 & 16) == 0) {
        }
        i28 = i26 & 32;
        if (i28 == 0) {
        }
        i29 = i26 & 64;
        if (i29 == 0) {
        }
        i36 = i26 & 128;
        if (i36 == 0) {
        }
        i37 = i26 & 256;
        if (i37 == 0) {
        }
        i38 = i26 & 512;
        if (i38 == 0) {
        }
        i39 = i26 & 1024;
        if (i39 == 0) {
        }
        i47 = i26 & 2048;
        if (i47 == 0) {
        }
        final int i692 = i46;
        i48 = i26 & 4096;
        if (i48 == 0) {
        }
        i49 = i26 & 8192;
        if (i49 != 0) {
        }
        if ((i26 & 16384) == 0) {
        }
        if ((1533916891 & i27) != 306783378) {
        }
        if (i67 == 0) {
        }
        if (i68 == 0) {
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
        if (i47 == 0) {
        }
        if (i48 == 0) {
        }
        if (i56 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState<Integer> mutableState622 = (MutableState) rememberedValue;
        if (i75 > 0) {
        }
        if (i3 <= 1) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        function111 = function110;
        function112 = function16;
        function113 = function17;
        acVar2 = acVar3;
        i58 = i76;
        z17 = z18;
        function25 = function24;
        function114 = function18;
        function115 = function19;
        function26 = function23;
        i59 = i57;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(MutableState<Boolean> mutableState, boolean z16) {
        mutableState.setValue(Boolean.valueOf(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int d(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Timer e(MutableState<Timer> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(MutableState<Timer> mutableState, Timer timer) {
        mutableState.setValue(timer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(MutableState<Integer> mutableState, int i3) {
        mutableState.setValue(Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.tencent.kuikly.core.base.aa<PageListView<?, ?>> h(MutableState<com.tencent.kuikly.core.base.aa<PageListView<?, ?>>> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(MutableState<com.tencent.kuikly.core.base.aa<PageListView<?, ?>>> mutableState, com.tencent.kuikly.core.base.aa<PageListView<?, ?>> aaVar) {
        mutableState.setValue(aaVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(MutableState<Boolean> mutableState, boolean z16) {
        mutableState.setValue(Boolean.valueOf(z16));
    }

    public static final ac A(Composer composer, int i3) {
        composer.startReplaceableGroup(703379664);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(703379664, i3, -1, "com.tencent.ntcompose.material.rememberSliderPageState (SliderPage.kt:19)");
        }
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new ac();
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        ac acVar = (ac) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return acVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int x(com.tencent.kuikly.core.base.aa<PageListView<?, ?>> aaVar) {
        if ((aaVar != null ? aaVar.b() : null) == null) {
            return 0;
        }
        PageListView<?, ?> b16 = aaVar.b();
        Intrinsics.checkNotNull(b16 != null ? b16.getContentView() : null);
        return Math.max(0, VirtualViewKt.a(r0).size() - 2);
    }

    private static final DeclarativeBaseView<?, ?> y(com.tencent.kuikly.core.base.aa<PageListView<?, ?>> aaVar) {
        if ((aaVar != null ? aaVar.b() : null) == null) {
            return null;
        }
        PageListView<?, ?> b16 = aaVar.b();
        ScrollerContentView contentView = b16 != null ? b16.getContentView() : null;
        Intrinsics.checkNotNull(contentView);
        List<DeclarativeBaseView<?, ?>> a16 = VirtualViewKt.a(contentView);
        if (a16.size() < 3) {
            return null;
        }
        DeclarativeBaseView<?, ?> declarativeBaseView = a16.get(1);
        ViewContainer<?, ?> domParent = declarativeBaseView.getDomParent();
        if ((domParent != null ? domParent.getRenderView() : null) != null && declarativeBaseView.getRenderView() == null) {
            declarativeBaseView.createRenderView();
            ViewContainer<?, ?> domParent2 = declarativeBaseView.getDomParent();
            RenderView renderView = domParent2 != null ? domParent2.getRenderView() : null;
            Intrinsics.checkNotNull(renderView);
            renderView.e(declarativeBaseView.getNativeRef(), -1);
        }
        return declarativeBaseView;
    }

    private static final DeclarativeBaseView<?, ?> z(com.tencent.kuikly.core.base.aa<PageListView<?, ?>> aaVar) {
        if ((aaVar != null ? aaVar.b() : null) == null) {
            return null;
        }
        PageListView<?, ?> b16 = aaVar.b();
        ScrollerContentView contentView = b16 != null ? b16.getContentView() : null;
        Intrinsics.checkNotNull(contentView);
        List<DeclarativeBaseView<?, ?>> a16 = VirtualViewKt.a(contentView);
        if (a16.size() < 3) {
            return null;
        }
        DeclarativeBaseView<?, ?> declarativeBaseView = a16.get(a16.size() - 2);
        ViewContainer<?, ?> domParent = declarativeBaseView.getDomParent();
        if ((domParent != null ? domParent.getRenderView() : null) != null && declarativeBaseView.getRenderView() == null) {
            declarativeBaseView.createRenderView();
            ViewContainer<?, ?> domParent2 = declarativeBaseView.getDomParent();
            RenderView renderView = domParent2 != null ? domParent2.getRenderView() : null;
            Intrinsics.checkNotNull(renderView);
            renderView.e(declarativeBaseView.getNativeRef(), -1);
        }
        return declarativeBaseView;
    }
}
