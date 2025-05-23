package com.tencent.ntcompose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippy.qq.view.viola.list.TkdListView;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.ScrollerAttr;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.co;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.ntcompose.core.ComposeNodeKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u00e3\u0004\u00106\u001a\u00020\b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002Z\b\u0002\u0010\u000b\u001aT\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012!\u0012\u001f\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00030\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0002j\u0012\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0018\u0001`\t\u00a2\u0006\u0002\b\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00122+\b\u0002\u0010&\u001a%\u0012\u0013\u0012\u00110#\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\b\u0018\u00010\"j\u0004\u0018\u0001`%2+\b\u0002\u0010'\u001a%\u0012\u0013\u0012\u00110#\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\b\u0018\u00010\"j\u0004\u0018\u0001`%2+\b\u0002\u0010(\u001a%\u0012\u0013\u0012\u00110#\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\b\u0018\u00010\"j\u0004\u0018\u0001`%2+\b\u0002\u0010)\u001a%\u0012\u0013\u0012\u00110#\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\b\u0018\u00010\"j\u0004\u0018\u0001`%2@\b\u0002\u0010-\u001a:\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\b\u0018\u00010\u0002j\u0004\u0018\u0001`,2\u0016\b\u0002\u0010/\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\b\u0018\u00010\"2\u0010\b\u0002\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001002\u001c\u00105\u001a\u0018\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\b0\"\u00a2\u0006\u0002\b4\u00a2\u0006\u0002\b\nH\u0001\u00a2\u0006\u0004\b6\u00107\"*\u0010=\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\b\u0018\u000109\u00a2\u0006\u0002\b4088\u0006\u00a2\u0006\f\n\u0004\b6\u0010:\u001a\u0004\b;\u0010<*j\u0010>\"2\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\b0\u000222\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\b0\u0002*@\u0010?\"\u001d\u0012\u0013\u0012\u00110#\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\b0\"2\u001d\u0012\u0013\u0012\u00110#\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\b0\"\u00a8\u0006@"}, d2 = {"Lcom/tencent/ntcompose/core/i;", "modifier", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/views/aq;", "Lcom/tencent/kuikly/core/base/aa;", "Lkotlin/ParameterName;", "name", "viewRef", "", "Lcom/tencent/ntcompose/core/RefFunc;", "Lkotlin/ExtensionFunctionType;", "ref", "Lcom/tencent/ntcompose/foundation/lazy/d;", "state", "Lcom/tencent/ntcompose/material/ListItemsLayoutType;", "itemsLayoutType", "Lcom/tencent/ntcompose/foundation/layout/l;", "contentPadding", "", "userScrollEnabled", "Lto3/a;", "flingBehavior", ScrollerAttr.BOUNCES_ENABLE, ScrollerAttr.SHOW_SCROLLER_INDICATOR, "pagingEnable", "", "visibleAreaIgnoreTopMargin", "visibleAreaIgnoreBottomMargin", "", "firstLoadMaxIndex", "preloadViewDistance", "syncScroll", ScrollerAttr.SYNC_SCROLL_IN_MAX_OFFSET, ScrollerAttr.SCROLL_WITH_PARENT, "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/views/bn;", "e", "Lcom/tencent/ntcompose/material/ListEventCallback;", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, TkdListView.EVENT_TYPE_SCROLL_END, "onBeginDrag", "onEndDrag", "width", "height", "Lcom/tencent/ntcompose/material/ContentSizeChangedEventCallback;", "onContentSizeChanged", "Lcom/tencent/kuikly/core/views/co;", "onWillDragEndBySync", "", "Lcom/tencent/ntcompose/core/k;", "otherProps", "Lcom/tencent/ntcompose/foundation/lazy/layout/a;", "Landroidx/compose/runtime/Composable;", "content", "a", "(Lcom/tencent/ntcompose/core/i;Lkotlin/jvm/functions/Function2;Lcom/tencent/ntcompose/foundation/lazy/d;Lcom/tencent/ntcompose/material/ListItemsLayoutType;Lcom/tencent/ntcompose/foundation/layout/l;Ljava/lang/Boolean;Lto3/a;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Float;ILjava/lang/Float;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Ljava/util/List;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;IIII)V", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Lkotlin/Function0;", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "b", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalLazyListHeaderBuilder", "ContentSizeChangedEventCallback", "ListEventCallback", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class LazyListKt {

    /* renamed from: a, reason: collision with root package name */
    private static final ProvidableCompositionLocal<Function2<Composer, Integer, Unit>> f339343a = CompositionLocalKt.compositionLocalOf$default(null, new Function0<Function2<? super Composer, ? super Integer, ? extends Unit>>() { // from class: com.tencent.ntcompose.material.LazyListKt$LocalLazyListHeaderBuilder$1
        @Override // kotlin.jvm.functions.Function0
        public final Function2<? super Composer, ? super Integer, ? extends Unit> invoke() {
            return null;
        }
    }, 1, null);

    /* JADX WARN: Removed duplicated region for block: B:100:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x03f0  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x041d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0490  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x04bd  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x04f2  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0527  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0554  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0589  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x05be  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x05f3  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0628  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x065d  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0692  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x06c7  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x06f4  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0721  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x074e  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x077b  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x07a8  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0800  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0808  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0849  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0853  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0867  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x087e  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0894  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x08ce  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0897  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0817  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0805  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:392:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x08fe  */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(com.tencent.ntcompose.core.i iVar, Function2<? super aq<?, ?>, ? super com.tencent.kuikly.core.base.aa<aq<?, ?>>, Unit> function2, com.tencent.ntcompose.foundation.lazy.d dVar, ListItemsLayoutType listItemsLayoutType, com.tencent.ntcompose.foundation.layout.l lVar, Boolean bool, to3.a aVar, Boolean bool2, Boolean bool3, Boolean bool4, Float f16, Float f17, int i3, Float f18, Boolean bool5, Float f19, Boolean bool6, Function1<? super ScrollParams, Unit> function1, Function1<? super ScrollParams, Unit> function12, Function1<? super ScrollParams, Unit> function13, Function1<? super ScrollParams, Unit> function14, Function2<? super Float, ? super Float, Unit> function22, Function1<? super co, Unit> function15, List<com.tencent.ntcompose.core.k> list, final Function3<? super com.tencent.ntcompose.foundation.lazy.layout.a, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i16, final int i17, final int i18, final int i19) {
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
        com.tencent.ntcompose.foundation.lazy.d dVar2;
        com.tencent.ntcompose.foundation.layout.l lVar2;
        Boolean bool7;
        to3.a aVar2;
        Boolean bool8;
        Boolean bool9;
        Boolean bool10;
        Float f26;
        Float f27;
        Float f28;
        Boolean bool11;
        Float f29;
        Function1<? super ScrollParams, Unit> function16;
        Function1<? super ScrollParams, Unit> function17;
        Function1<? super ScrollParams, Unit> function18;
        Function1<? super ScrollParams, Unit> function19;
        Function2<? super Float, ? super Float, Unit> function23;
        Function1<? super co, Unit> function110;
        List<com.tencent.ntcompose.core.k> list2;
        com.tencent.ntcompose.core.i iVar2;
        int i87;
        int i88;
        Object rememberedValue;
        final Boolean bool12;
        final Function2<? super aq<?, ?>, ? super com.tencent.kuikly.core.base.aa<aq<?, ?>>, Unit> function24;
        final com.tencent.ntcompose.foundation.lazy.d dVar3;
        final int i89;
        final ListItemsLayoutType listItemsLayoutType2;
        final com.tencent.ntcompose.foundation.layout.l lVar3;
        final Boolean bool13;
        final Float f36;
        final Boolean bool14;
        final Function1<? super ScrollParams, Unit> function111;
        final com.tencent.ntcompose.core.i iVar3;
        final Boolean bool15;
        final Float f37;
        final Float f38;
        final to3.a aVar3;
        final Function1<? super co, Unit> function112;
        final Function1<? super ScrollParams, Unit> function113;
        final Function1<? super ScrollParams, Unit> function114;
        final Boolean bool16;
        final List<com.tencent.ntcompose.core.k> list3;
        final Float f39;
        final Function2<? super Float, ? super Float, Unit> function25;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(224416711);
        int i95 = i19 & 1;
        if (i95 != 0) {
            i26 = i16 | 6;
        } else if ((i16 & 14) == 0) {
            i26 = (startRestartGroup.changed(iVar) ? 4 : 2) | i16;
        } else {
            i26 = i16;
        }
        int i96 = i19 & 2;
        if (i96 != 0) {
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
                    i26 |= startRestartGroup.changed(listItemsLayoutType) ? 2048 : 1024;
                    i29 = i19 & 16;
                    if (i29 == 0) {
                        i26 |= 24576;
                    } else if ((i16 & 57344) == 0) {
                        i26 |= startRestartGroup.changed(lVar) ? 16384 : 8192;
                    }
                    i36 = i19 & 32;
                    if (i36 == 0) {
                        i26 |= 196608;
                    } else if ((i16 & 458752) == 0) {
                        i26 |= startRestartGroup.changed(bool) ? 131072 : 65536;
                    }
                    i37 = i19 & 64;
                    if (i37 == 0) {
                        i26 |= 1572864;
                    } else if ((i16 & 3670016) == 0) {
                        i26 |= startRestartGroup.changed(aVar) ? 1048576 : 524288;
                    }
                    i38 = i19 & 128;
                    if (i38 == 0) {
                        i26 |= 12582912;
                    } else if ((i16 & 29360128) == 0) {
                        i26 |= startRestartGroup.changed(bool2) ? 8388608 : 4194304;
                    }
                    i39 = i19 & 256;
                    if (i39 == 0) {
                        i26 |= 100663296;
                    } else if ((i16 & 234881024) == 0) {
                        i26 |= startRestartGroup.changed(bool3) ? 67108864 : 33554432;
                    }
                    i46 = i19 & 512;
                    if (i46 == 0) {
                        i26 |= 805306368;
                    } else if ((i16 & 1879048192) == 0) {
                        i26 |= startRestartGroup.changed(bool4) ? 536870912 : 268435456;
                    }
                    i47 = i19 & 1024;
                    if (i47 == 0) {
                        i48 = i17 | 6;
                    } else if ((i17 & 14) == 0) {
                        i48 = i17 | (startRestartGroup.changed(f16) ? 4 : 2);
                    } else {
                        i48 = i17;
                    }
                    i49 = i19 & 2048;
                    if (i49 == 0) {
                        i48 |= 48;
                    } else if ((i17 & 112) == 0) {
                        i48 |= startRestartGroup.changed(f17) ? 32 : 16;
                    }
                    int i97 = i48;
                    i56 = i19 & 4096;
                    if (i56 == 0) {
                        i97 |= MsgConstant.KRMFILETHUMBSIZE384;
                        i57 = i56;
                    } else {
                        i57 = i56;
                        if ((i17 & 896) == 0) {
                            i97 |= startRestartGroup.changed(i3) ? 256 : 128;
                            i58 = i19 & 8192;
                            if (i58 != 0) {
                                i97 |= 3072;
                                i59 = i58;
                            } else {
                                i59 = i58;
                                if ((i17 & 7168) == 0) {
                                    i97 |= startRestartGroup.changed(f18) ? 2048 : 1024;
                                    i65 = i19 & 16384;
                                    if (i65 == 0) {
                                        i97 |= 24576;
                                    } else if ((i17 & 57344) == 0) {
                                        i66 = i65;
                                        i97 |= startRestartGroup.changed(bool5) ? 16384 : 8192;
                                        i67 = i19 & 32768;
                                        if (i67 != 0) {
                                            i97 |= 196608;
                                        } else if ((i17 & 458752) == 0) {
                                            i97 |= startRestartGroup.changed(f19) ? 131072 : 65536;
                                        }
                                        i68 = i19 & 65536;
                                        if (i68 != 0) {
                                            i97 |= 1572864;
                                        } else if ((i17 & 3670016) == 0) {
                                            i97 |= startRestartGroup.changed(bool6) ? 1048576 : 524288;
                                        }
                                        i69 = i19 & 131072;
                                        if (i69 != 0) {
                                            i97 |= 12582912;
                                        } else if ((i17 & 29360128) == 0) {
                                            i97 |= startRestartGroup.changed(function1) ? 8388608 : 4194304;
                                        }
                                        i75 = i19 & 262144;
                                        if (i75 != 0) {
                                            i97 |= 100663296;
                                        } else if ((i17 & 234881024) == 0) {
                                            i97 |= startRestartGroup.changed(function12) ? 67108864 : 33554432;
                                        }
                                        i76 = i19 & 524288;
                                        if (i76 != 0) {
                                            i97 |= 805306368;
                                        } else if ((i17 & 1879048192) == 0) {
                                            i97 |= startRestartGroup.changed(function13) ? 536870912 : 268435456;
                                        }
                                        i77 = i19 & 1048576;
                                        if (i77 != 0) {
                                            i78 = i18 | 6;
                                        } else if ((i18 & 14) == 0) {
                                            i78 = i18 | (startRestartGroup.changed(function14) ? 4 : 2);
                                        } else {
                                            i78 = i18;
                                        }
                                        i79 = i19 & 2097152;
                                        if (i79 != 0) {
                                            i78 |= 48;
                                        } else if ((i18 & 112) == 0) {
                                            i78 |= startRestartGroup.changed(function22) ? 32 : 16;
                                        }
                                        int i98 = i78;
                                        i85 = i19 & 4194304;
                                        if (i85 != 0) {
                                            i98 |= MsgConstant.KRMFILETHUMBSIZE384;
                                        } else if ((i18 & 896) == 0) {
                                            i98 |= startRestartGroup.changed(function15) ? 256 : 128;
                                        }
                                        i86 = i19 & 8388608;
                                        if (i86 != 0) {
                                            i98 |= 1024;
                                        }
                                        if ((i19 & 16777216) != 0) {
                                            i98 |= 24576;
                                        } else if ((i18 & 57344) == 0) {
                                            i98 |= startRestartGroup.changed(content) ? 16384 : 8192;
                                        }
                                        if (i86 != 8388608 && (1533916891 & i26) == 306783378 && (1533916891 & i97) == 306783378 && (46811 & i98) == 9362 && startRestartGroup.getSkipping()) {
                                            startRestartGroup.skipToGroupEnd();
                                            iVar3 = iVar;
                                            function24 = function2;
                                            dVar3 = dVar;
                                            listItemsLayoutType2 = listItemsLayoutType;
                                            lVar3 = lVar;
                                            bool13 = bool;
                                            aVar3 = aVar;
                                            bool16 = bool2;
                                            bool12 = bool3;
                                            bool15 = bool4;
                                            f37 = f16;
                                            f38 = f17;
                                            i89 = i3;
                                            f39 = f18;
                                            bool11 = bool5;
                                            f36 = f19;
                                            bool14 = bool6;
                                            function113 = function1;
                                            function17 = function12;
                                            function111 = function13;
                                            function114 = function14;
                                            function25 = function22;
                                            function112 = function15;
                                            list3 = list;
                                        } else {
                                            com.tencent.ntcompose.core.i iVar4 = i95 != 0 ? com.tencent.ntcompose.core.i.INSTANCE : iVar;
                                            Function2<? super aq<?, ?>, ? super com.tencent.kuikly.core.base.aa<aq<?, ?>>, Unit> function26 = i96 != 0 ? null : function2;
                                            dVar2 = i27 != 0 ? null : dVar;
                                            ListItemsLayoutType listItemsLayoutType3 = i28 != 0 ? ListItemsLayoutType.ColumnLinear : listItemsLayoutType;
                                            lVar2 = i29 != 0 ? null : lVar;
                                            bool7 = i36 != 0 ? null : bool;
                                            aVar2 = i37 != 0 ? null : aVar;
                                            bool8 = i38 != 0 ? null : bool2;
                                            bool9 = i39 != 0 ? null : bool3;
                                            bool10 = i46 != 0 ? null : bool4;
                                            f26 = i47 != 0 ? null : f16;
                                            f27 = i49 != 0 ? null : f17;
                                            int i99 = i57 != 0 ? 6 : i3;
                                            f28 = i59 != 0 ? null : f18;
                                            bool11 = i66 != 0 ? null : bool5;
                                            f29 = i67 != 0 ? null : f19;
                                            Boolean bool17 = i68 != 0 ? null : bool6;
                                            function16 = i69 != 0 ? null : function1;
                                            function17 = i75 != 0 ? null : function12;
                                            function18 = i76 != 0 ? null : function13;
                                            function19 = i77 != 0 ? null : function14;
                                            function23 = i79 != 0 ? null : function22;
                                            function110 = i85 != 0 ? null : function15;
                                            list2 = i86 != 0 ? null : list;
                                            if (ComposerKt.isTraceInProgress()) {
                                                iVar2 = iVar4;
                                                i87 = i98;
                                                ComposerKt.traceEventStart(224416711, i26, i97, "com.tencent.ntcompose.material.LazyList (LazyList.kt:104)");
                                            } else {
                                                iVar2 = iVar4;
                                                i87 = i98;
                                            }
                                            ArrayList arrayList = new ArrayList();
                                            LazyListViewUpdateImp lazyListViewUpdateImp = LazyListViewUpdateImp.f339344a;
                                            arrayList.add(new com.tencent.ntcompose.core.k("itemsLayoutType", listItemsLayoutType3, null, null, null, null, lazyListViewUpdateImp, 60, null));
                                            if (lVar2 != null) {
                                                arrayList.add(new com.tencent.ntcompose.core.k("contentPadding", lVar2, null, null, null, null, lazyListViewUpdateImp, 60, null));
                                            }
                                            if (dVar2 != null) {
                                                arrayList.add(new com.tencent.ntcompose.core.k("listState", dVar2, null, null, null, null, lazyListViewUpdateImp, 60, null));
                                            }
                                            if (f28 != null) {
                                                arrayList.add(new com.tencent.ntcompose.core.k("preloadViewDistance", Float.valueOf(f28.floatValue()), null, null, null, null, lazyListViewUpdateImp, 60, null));
                                            }
                                            if (bool7 != null) {
                                                arrayList.add(new com.tencent.ntcompose.core.k("userScrollEnabled", Boolean.valueOf(bool7.booleanValue()), null, null, null, null, lazyListViewUpdateImp, 60, null));
                                            }
                                            if (aVar2 != null) {
                                                arrayList.add(new com.tencent.ntcompose.core.k("flingBehavior", aVar2, null, null, null, null, lazyListViewUpdateImp, 60, null));
                                            }
                                            if (bool10 != null) {
                                                arrayList.add(new com.tencent.ntcompose.core.k("paddingEnable", Boolean.valueOf(bool10.booleanValue()), null, null, null, null, lazyListViewUpdateImp, 60, null));
                                            }
                                            if (bool8 != null) {
                                                arrayList.add(new com.tencent.ntcompose.core.k(ScrollerAttr.BOUNCES_ENABLE, Boolean.valueOf(bool8.booleanValue()), null, null, null, null, lazyListViewUpdateImp, 60, null));
                                            }
                                            if (bool9 != null) {
                                                arrayList.add(new com.tencent.ntcompose.core.k(ScrollerAttr.SHOW_SCROLLER_INDICATOR, Boolean.valueOf(bool9.booleanValue()), null, null, null, null, lazyListViewUpdateImp, 60, null));
                                            }
                                            if (bool11 != null) {
                                                arrayList.add(new com.tencent.ntcompose.core.k("syncScroll", Boolean.valueOf(bool11.booleanValue()), null, null, null, null, lazyListViewUpdateImp, 60, null));
                                            }
                                            if (f29 != null) {
                                                arrayList.add(new com.tencent.ntcompose.core.k(ScrollerAttr.SYNC_SCROLL_IN_MAX_OFFSET, Float.valueOf(f29.floatValue()), null, null, null, null, lazyListViewUpdateImp, 60, null));
                                            }
                                            if (f27 != null) {
                                                arrayList.add(new com.tencent.ntcompose.core.k("visibleAreaIgnoreBottomMargin", Float.valueOf(f27.floatValue()), null, null, null, null, lazyListViewUpdateImp, 60, null));
                                            }
                                            if (f26 != null) {
                                                arrayList.add(new com.tencent.ntcompose.core.k("visibleAreaIgnoreTopMargin", Float.valueOf(f26.floatValue()), null, null, null, null, lazyListViewUpdateImp, 60, null));
                                            }
                                            if (function16 != null) {
                                                arrayList.add(new com.tencent.ntcompose.core.k(HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, function16, null, null, null, null, lazyListViewUpdateImp, 60, null));
                                            }
                                            if (function17 != null) {
                                                arrayList.add(new com.tencent.ntcompose.core.k(TkdListView.EVENT_TYPE_SCROLL_END, function17, null, null, null, null, lazyListViewUpdateImp, 60, null));
                                            }
                                            if (function18 != null) {
                                                arrayList.add(new com.tencent.ntcompose.core.k("onBeginDrag", function18, null, null, null, null, lazyListViewUpdateImp, 60, null));
                                            }
                                            if (function19 != null) {
                                                arrayList.add(new com.tencent.ntcompose.core.k("onEndDrag", function19, null, null, null, null, lazyListViewUpdateImp, 60, null));
                                            }
                                            if (function23 != null) {
                                                arrayList.add(new com.tencent.ntcompose.core.k("onContentSizeChanged", function23, null, null, null, null, lazyListViewUpdateImp, 60, null));
                                            }
                                            if (function110 != null) {
                                                arrayList.add(new com.tencent.ntcompose.core.k("onWillDragEndBySync", function110, null, null, null, null, lazyListViewUpdateImp, 60, null));
                                            }
                                            arrayList.add(new com.tencent.ntcompose.core.k(ScrollerAttr.SCROLL_WITH_PARENT, bool17, null, null, null, null, lazyListViewUpdateImp, 60, null));
                                            if ((dVar2 != null ? dVar2.getInitialFirstVisibleItemIndex() : 0) > 0) {
                                                i88 = Math.max(i99, (dVar2 != null ? dVar2.getInitialFirstVisibleItemIndex() : 0) + 8);
                                            } else {
                                                i88 = i99;
                                            }
                                            arrayList.add(new com.tencent.ntcompose.core.k("firstMaxIndexLoad", Integer.valueOf(i88), null, null, null, null, lazyListViewUpdateImp, 60, null));
                                            if (list2 != null) {
                                                arrayList.addAll(list2);
                                            }
                                            String str = (listItemsLayoutType3 != ListItemsLayoutType.VerticalGrid || listItemsLayoutType3 == ListItemsLayoutType.HorizontalGrid) ? "waterfall_list" : "list";
                                            if (Intrinsics.areEqual(bool10, Boolean.TRUE)) {
                                                str = "page_list";
                                            }
                                            startRestartGroup.startReplaceableGroup(-492369756);
                                            rememberedValue = startRestartGroup.rememberedValue();
                                            Boolean bool18 = bool8;
                                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue = new w();
                                                startRestartGroup.updateRememberedValue(rememberedValue);
                                            }
                                            startRestartGroup.endReplaceableGroup();
                                            final w wVar = (w) rememberedValue;
                                            wVar.b(i99);
                                            Boolean bool19 = bool9;
                                            Boolean bool20 = bool10;
                                            final int i100 = i87;
                                            ComposeNodeKt.a(str, com.tencent.ntcompose.material.base.a.f339408a, function26 == null ? null : function26, iVar2, arrayList, ComposableLambdaKt.composableLambda(startRestartGroup, -891066595, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.LazyListKt$LazyList$1
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

                                                public final void invoke(Composer composer2, int i101) {
                                                    if ((i101 & 11) == 2 && composer2.getSkipping()) {
                                                        composer2.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-891066595, i101, -1, "com.tencent.ntcompose.material.LazyList.<anonymous> (LazyList.kt:262)");
                                                    }
                                                    Function2 function27 = (Function2) composer2.consume(LazyListKt.b());
                                                    composer2.startReplaceableGroup(-1833361285);
                                                    if (function27 != null) {
                                                        function27.invoke(composer2, 0);
                                                        Unit unit = Unit.INSTANCE;
                                                    }
                                                    composer2.endReplaceableGroup();
                                                    content.invoke(wVar, composer2, Integer.valueOf(((i100 >> 9) & 112) | 8));
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }), startRestartGroup, ((i26 << 9) & 7168) | 229424, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            bool12 = bool19;
                                            function24 = function26;
                                            dVar3 = dVar2;
                                            i89 = i99;
                                            listItemsLayoutType2 = listItemsLayoutType3;
                                            lVar3 = lVar2;
                                            bool13 = bool7;
                                            f36 = f29;
                                            bool14 = bool17;
                                            function111 = function18;
                                            iVar3 = iVar2;
                                            bool15 = bool20;
                                            f37 = f26;
                                            f38 = f27;
                                            aVar3 = aVar2;
                                            function112 = function110;
                                            function113 = function16;
                                            function114 = function19;
                                            bool16 = bool18;
                                            list3 = list2;
                                            f39 = f28;
                                            function25 = function23;
                                        }
                                        endRestartGroup = startRestartGroup.endRestartGroup();
                                        if (endRestartGroup == null) {
                                            return;
                                        }
                                        final Boolean bool21 = bool11;
                                        final Function1<? super ScrollParams, Unit> function115 = function17;
                                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.LazyListKt$LazyList$2
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

                                            public final void invoke(Composer composer2, int i101) {
                                                LazyListKt.a(com.tencent.ntcompose.core.i.this, function24, dVar3, listItemsLayoutType2, lVar3, bool13, aVar3, bool16, bool12, bool15, f37, f38, i89, f39, bool21, f36, bool14, function113, function115, function111, function114, function25, function112, list3, content, composer2, i16 | 1, i17, i18, i19);
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
                                    int i982 = i78;
                                    i85 = i19 & 4194304;
                                    if (i85 != 0) {
                                    }
                                    i86 = i19 & 8388608;
                                    if (i86 != 0) {
                                    }
                                    if ((i19 & 16777216) != 0) {
                                    }
                                    if (i86 != 8388608) {
                                    }
                                    if (i95 != 0) {
                                    }
                                    if (i96 != 0) {
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
                                    if (i85 != 0) {
                                    }
                                    if (i86 != 0) {
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    ArrayList arrayList2 = new ArrayList();
                                    LazyListViewUpdateImp lazyListViewUpdateImp2 = LazyListViewUpdateImp.f339344a;
                                    arrayList2.add(new com.tencent.ntcompose.core.k("itemsLayoutType", listItemsLayoutType3, null, null, null, null, lazyListViewUpdateImp2, 60, null));
                                    if (lVar2 != null) {
                                    }
                                    if (dVar2 != null) {
                                    }
                                    if (f28 != null) {
                                    }
                                    if (bool7 != null) {
                                    }
                                    if (aVar2 != null) {
                                    }
                                    if (bool10 != null) {
                                    }
                                    if (bool8 != null) {
                                    }
                                    if (bool9 != null) {
                                    }
                                    if (bool11 != null) {
                                    }
                                    if (f29 != null) {
                                    }
                                    if (f27 != null) {
                                    }
                                    if (f26 != null) {
                                    }
                                    if (function16 != null) {
                                    }
                                    if (function17 != null) {
                                    }
                                    if (function18 != null) {
                                    }
                                    if (function19 != null) {
                                    }
                                    if (function23 != null) {
                                    }
                                    if (function110 != null) {
                                    }
                                    arrayList2.add(new com.tencent.ntcompose.core.k(ScrollerAttr.SCROLL_WITH_PARENT, bool17, null, null, null, null, lazyListViewUpdateImp2, 60, null));
                                    if ((dVar2 != null ? dVar2.getInitialFirstVisibleItemIndex() : 0) > 0) {
                                    }
                                    arrayList2.add(new com.tencent.ntcompose.core.k("firstMaxIndexLoad", Integer.valueOf(i88), null, null, null, null, lazyListViewUpdateImp2, 60, null));
                                    if (list2 != null) {
                                    }
                                    if (listItemsLayoutType3 != ListItemsLayoutType.VerticalGrid) {
                                    }
                                    if (Intrinsics.areEqual(bool10, Boolean.TRUE)) {
                                    }
                                    startRestartGroup.startReplaceableGroup(-492369756);
                                    rememberedValue = startRestartGroup.rememberedValue();
                                    Boolean bool182 = bool8;
                                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    final w wVar2 = (w) rememberedValue;
                                    wVar2.b(i99);
                                    Boolean bool192 = bool9;
                                    Boolean bool202 = bool10;
                                    final int i1002 = i87;
                                    ComposeNodeKt.a(str, com.tencent.ntcompose.material.base.a.f339408a, function26 == null ? null : function26, iVar2, arrayList2, ComposableLambdaKt.composableLambda(startRestartGroup, -891066595, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.LazyListKt$LazyList$1
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

                                        public final void invoke(Composer composer2, int i101) {
                                            if ((i101 & 11) == 2 && composer2.getSkipping()) {
                                                composer2.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-891066595, i101, -1, "com.tencent.ntcompose.material.LazyList.<anonymous> (LazyList.kt:262)");
                                            }
                                            Function2 function27 = (Function2) composer2.consume(LazyListKt.b());
                                            composer2.startReplaceableGroup(-1833361285);
                                            if (function27 != null) {
                                                function27.invoke(composer2, 0);
                                                Unit unit = Unit.INSTANCE;
                                            }
                                            composer2.endReplaceableGroup();
                                            content.invoke(wVar2, composer2, Integer.valueOf(((i1002 >> 9) & 112) | 8));
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), startRestartGroup, ((i26 << 9) & 7168) | 229424, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    bool12 = bool192;
                                    function24 = function26;
                                    dVar3 = dVar2;
                                    i89 = i99;
                                    listItemsLayoutType2 = listItemsLayoutType3;
                                    lVar3 = lVar2;
                                    bool13 = bool7;
                                    f36 = f29;
                                    bool14 = bool17;
                                    function111 = function18;
                                    iVar3 = iVar2;
                                    bool15 = bool202;
                                    f37 = f26;
                                    f38 = f27;
                                    aVar3 = aVar2;
                                    function112 = function110;
                                    function113 = function16;
                                    function114 = function19;
                                    bool16 = bool182;
                                    list3 = list2;
                                    f39 = f28;
                                    function25 = function23;
                                    endRestartGroup = startRestartGroup.endRestartGroup();
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
                            int i9822 = i78;
                            i85 = i19 & 4194304;
                            if (i85 != 0) {
                            }
                            i86 = i19 & 8388608;
                            if (i86 != 0) {
                            }
                            if ((i19 & 16777216) != 0) {
                            }
                            if (i86 != 8388608) {
                            }
                            if (i95 != 0) {
                            }
                            if (i96 != 0) {
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
                            if (i85 != 0) {
                            }
                            if (i86 != 0) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            ArrayList arrayList22 = new ArrayList();
                            LazyListViewUpdateImp lazyListViewUpdateImp22 = LazyListViewUpdateImp.f339344a;
                            arrayList22.add(new com.tencent.ntcompose.core.k("itemsLayoutType", listItemsLayoutType3, null, null, null, null, lazyListViewUpdateImp22, 60, null));
                            if (lVar2 != null) {
                            }
                            if (dVar2 != null) {
                            }
                            if (f28 != null) {
                            }
                            if (bool7 != null) {
                            }
                            if (aVar2 != null) {
                            }
                            if (bool10 != null) {
                            }
                            if (bool8 != null) {
                            }
                            if (bool9 != null) {
                            }
                            if (bool11 != null) {
                            }
                            if (f29 != null) {
                            }
                            if (f27 != null) {
                            }
                            if (f26 != null) {
                            }
                            if (function16 != null) {
                            }
                            if (function17 != null) {
                            }
                            if (function18 != null) {
                            }
                            if (function19 != null) {
                            }
                            if (function23 != null) {
                            }
                            if (function110 != null) {
                            }
                            arrayList22.add(new com.tencent.ntcompose.core.k(ScrollerAttr.SCROLL_WITH_PARENT, bool17, null, null, null, null, lazyListViewUpdateImp22, 60, null));
                            if ((dVar2 != null ? dVar2.getInitialFirstVisibleItemIndex() : 0) > 0) {
                            }
                            arrayList22.add(new com.tencent.ntcompose.core.k("firstMaxIndexLoad", Integer.valueOf(i88), null, null, null, null, lazyListViewUpdateImp22, 60, null));
                            if (list2 != null) {
                            }
                            if (listItemsLayoutType3 != ListItemsLayoutType.VerticalGrid) {
                            }
                            if (Intrinsics.areEqual(bool10, Boolean.TRUE)) {
                            }
                            startRestartGroup.startReplaceableGroup(-492369756);
                            rememberedValue = startRestartGroup.rememberedValue();
                            Boolean bool1822 = bool8;
                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                            }
                            startRestartGroup.endReplaceableGroup();
                            final w wVar22 = (w) rememberedValue;
                            wVar22.b(i99);
                            Boolean bool1922 = bool9;
                            Boolean bool2022 = bool10;
                            final int i10022 = i87;
                            ComposeNodeKt.a(str, com.tencent.ntcompose.material.base.a.f339408a, function26 == null ? null : function26, iVar2, arrayList22, ComposableLambdaKt.composableLambda(startRestartGroup, -891066595, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.LazyListKt$LazyList$1
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

                                public final void invoke(Composer composer2, int i101) {
                                    if ((i101 & 11) == 2 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-891066595, i101, -1, "com.tencent.ntcompose.material.LazyList.<anonymous> (LazyList.kt:262)");
                                    }
                                    Function2 function27 = (Function2) composer2.consume(LazyListKt.b());
                                    composer2.startReplaceableGroup(-1833361285);
                                    if (function27 != null) {
                                        function27.invoke(composer2, 0);
                                        Unit unit = Unit.INSTANCE;
                                    }
                                    composer2.endReplaceableGroup();
                                    content.invoke(wVar22, composer2, Integer.valueOf(((i10022 >> 9) & 112) | 8));
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), startRestartGroup, ((i26 << 9) & 7168) | 229424, 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            bool12 = bool1922;
                            function24 = function26;
                            dVar3 = dVar2;
                            i89 = i99;
                            listItemsLayoutType2 = listItemsLayoutType3;
                            lVar3 = lVar2;
                            bool13 = bool7;
                            f36 = f29;
                            bool14 = bool17;
                            function111 = function18;
                            iVar3 = iVar2;
                            bool15 = bool2022;
                            f37 = f26;
                            f38 = f27;
                            aVar3 = aVar2;
                            function112 = function110;
                            function113 = function16;
                            function114 = function19;
                            bool16 = bool1822;
                            list3 = list2;
                            f39 = f28;
                            function25 = function23;
                            endRestartGroup = startRestartGroup.endRestartGroup();
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
                    int i98222 = i78;
                    i85 = i19 & 4194304;
                    if (i85 != 0) {
                    }
                    i86 = i19 & 8388608;
                    if (i86 != 0) {
                    }
                    if ((i19 & 16777216) != 0) {
                    }
                    if (i86 != 8388608) {
                    }
                    if (i95 != 0) {
                    }
                    if (i96 != 0) {
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
                    if (i85 != 0) {
                    }
                    if (i86 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ArrayList arrayList222 = new ArrayList();
                    LazyListViewUpdateImp lazyListViewUpdateImp222 = LazyListViewUpdateImp.f339344a;
                    arrayList222.add(new com.tencent.ntcompose.core.k("itemsLayoutType", listItemsLayoutType3, null, null, null, null, lazyListViewUpdateImp222, 60, null));
                    if (lVar2 != null) {
                    }
                    if (dVar2 != null) {
                    }
                    if (f28 != null) {
                    }
                    if (bool7 != null) {
                    }
                    if (aVar2 != null) {
                    }
                    if (bool10 != null) {
                    }
                    if (bool8 != null) {
                    }
                    if (bool9 != null) {
                    }
                    if (bool11 != null) {
                    }
                    if (f29 != null) {
                    }
                    if (f27 != null) {
                    }
                    if (f26 != null) {
                    }
                    if (function16 != null) {
                    }
                    if (function17 != null) {
                    }
                    if (function18 != null) {
                    }
                    if (function19 != null) {
                    }
                    if (function23 != null) {
                    }
                    if (function110 != null) {
                    }
                    arrayList222.add(new com.tencent.ntcompose.core.k(ScrollerAttr.SCROLL_WITH_PARENT, bool17, null, null, null, null, lazyListViewUpdateImp222, 60, null));
                    if ((dVar2 != null ? dVar2.getInitialFirstVisibleItemIndex() : 0) > 0) {
                    }
                    arrayList222.add(new com.tencent.ntcompose.core.k("firstMaxIndexLoad", Integer.valueOf(i88), null, null, null, null, lazyListViewUpdateImp222, 60, null));
                    if (list2 != null) {
                    }
                    if (listItemsLayoutType3 != ListItemsLayoutType.VerticalGrid) {
                    }
                    if (Intrinsics.areEqual(bool10, Boolean.TRUE)) {
                    }
                    startRestartGroup.startReplaceableGroup(-492369756);
                    rememberedValue = startRestartGroup.rememberedValue();
                    Boolean bool18222 = bool8;
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    final w wVar222 = (w) rememberedValue;
                    wVar222.b(i99);
                    Boolean bool19222 = bool9;
                    Boolean bool20222 = bool10;
                    final int i100222 = i87;
                    ComposeNodeKt.a(str, com.tencent.ntcompose.material.base.a.f339408a, function26 == null ? null : function26, iVar2, arrayList222, ComposableLambdaKt.composableLambda(startRestartGroup, -891066595, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.LazyListKt$LazyList$1
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

                        public final void invoke(Composer composer2, int i101) {
                            if ((i101 & 11) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-891066595, i101, -1, "com.tencent.ntcompose.material.LazyList.<anonymous> (LazyList.kt:262)");
                            }
                            Function2 function27 = (Function2) composer2.consume(LazyListKt.b());
                            composer2.startReplaceableGroup(-1833361285);
                            if (function27 != null) {
                                function27.invoke(composer2, 0);
                                Unit unit = Unit.INSTANCE;
                            }
                            composer2.endReplaceableGroup();
                            content.invoke(wVar222, composer2, Integer.valueOf(((i100222 >> 9) & 112) | 8));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), startRestartGroup, ((i26 << 9) & 7168) | 229424, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    bool12 = bool19222;
                    function24 = function26;
                    dVar3 = dVar2;
                    i89 = i99;
                    listItemsLayoutType2 = listItemsLayoutType3;
                    lVar3 = lVar2;
                    bool13 = bool7;
                    f36 = f29;
                    bool14 = bool17;
                    function111 = function18;
                    iVar3 = iVar2;
                    bool15 = bool20222;
                    f37 = f26;
                    f38 = f27;
                    aVar3 = aVar2;
                    function112 = function110;
                    function113 = function16;
                    function114 = function19;
                    bool16 = bool18222;
                    list3 = list2;
                    f39 = f28;
                    function25 = function23;
                    endRestartGroup = startRestartGroup.endRestartGroup();
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
                int i972 = i48;
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
                int i982222 = i78;
                i85 = i19 & 4194304;
                if (i85 != 0) {
                }
                i86 = i19 & 8388608;
                if (i86 != 0) {
                }
                if ((i19 & 16777216) != 0) {
                }
                if (i86 != 8388608) {
                }
                if (i95 != 0) {
                }
                if (i96 != 0) {
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
                if (i85 != 0) {
                }
                if (i86 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                ArrayList arrayList2222 = new ArrayList();
                LazyListViewUpdateImp lazyListViewUpdateImp2222 = LazyListViewUpdateImp.f339344a;
                arrayList2222.add(new com.tencent.ntcompose.core.k("itemsLayoutType", listItemsLayoutType3, null, null, null, null, lazyListViewUpdateImp2222, 60, null));
                if (lVar2 != null) {
                }
                if (dVar2 != null) {
                }
                if (f28 != null) {
                }
                if (bool7 != null) {
                }
                if (aVar2 != null) {
                }
                if (bool10 != null) {
                }
                if (bool8 != null) {
                }
                if (bool9 != null) {
                }
                if (bool11 != null) {
                }
                if (f29 != null) {
                }
                if (f27 != null) {
                }
                if (f26 != null) {
                }
                if (function16 != null) {
                }
                if (function17 != null) {
                }
                if (function18 != null) {
                }
                if (function19 != null) {
                }
                if (function23 != null) {
                }
                if (function110 != null) {
                }
                arrayList2222.add(new com.tencent.ntcompose.core.k(ScrollerAttr.SCROLL_WITH_PARENT, bool17, null, null, null, null, lazyListViewUpdateImp2222, 60, null));
                if ((dVar2 != null ? dVar2.getInitialFirstVisibleItemIndex() : 0) > 0) {
                }
                arrayList2222.add(new com.tencent.ntcompose.core.k("firstMaxIndexLoad", Integer.valueOf(i88), null, null, null, null, lazyListViewUpdateImp2222, 60, null));
                if (list2 != null) {
                }
                if (listItemsLayoutType3 != ListItemsLayoutType.VerticalGrid) {
                }
                if (Intrinsics.areEqual(bool10, Boolean.TRUE)) {
                }
                startRestartGroup.startReplaceableGroup(-492369756);
                rememberedValue = startRestartGroup.rememberedValue();
                Boolean bool182222 = bool8;
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                final w wVar2222 = (w) rememberedValue;
                wVar2222.b(i99);
                Boolean bool192222 = bool9;
                Boolean bool202222 = bool10;
                final int i1002222 = i87;
                ComposeNodeKt.a(str, com.tencent.ntcompose.material.base.a.f339408a, function26 == null ? null : function26, iVar2, arrayList2222, ComposableLambdaKt.composableLambda(startRestartGroup, -891066595, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.LazyListKt$LazyList$1
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

                    public final void invoke(Composer composer2, int i101) {
                        if ((i101 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-891066595, i101, -1, "com.tencent.ntcompose.material.LazyList.<anonymous> (LazyList.kt:262)");
                        }
                        Function2 function27 = (Function2) composer2.consume(LazyListKt.b());
                        composer2.startReplaceableGroup(-1833361285);
                        if (function27 != null) {
                            function27.invoke(composer2, 0);
                            Unit unit = Unit.INSTANCE;
                        }
                        composer2.endReplaceableGroup();
                        content.invoke(wVar2222, composer2, Integer.valueOf(((i1002222 >> 9) & 112) | 8));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), startRestartGroup, ((i26 << 9) & 7168) | 229424, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                bool12 = bool192222;
                function24 = function26;
                dVar3 = dVar2;
                i89 = i99;
                listItemsLayoutType2 = listItemsLayoutType3;
                lVar3 = lVar2;
                bool13 = bool7;
                f36 = f29;
                bool14 = bool17;
                function111 = function18;
                iVar3 = iVar2;
                bool15 = bool202222;
                f37 = f26;
                f38 = f27;
                aVar3 = aVar2;
                function112 = function110;
                function113 = function16;
                function114 = function19;
                bool16 = bool182222;
                list3 = list2;
                f39 = f28;
                function25 = function23;
                endRestartGroup = startRestartGroup.endRestartGroup();
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
            int i9722 = i48;
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
            int i9822222 = i78;
            i85 = i19 & 4194304;
            if (i85 != 0) {
            }
            i86 = i19 & 8388608;
            if (i86 != 0) {
            }
            if ((i19 & 16777216) != 0) {
            }
            if (i86 != 8388608) {
            }
            if (i95 != 0) {
            }
            if (i96 != 0) {
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
            if (i85 != 0) {
            }
            if (i86 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            ArrayList arrayList22222 = new ArrayList();
            LazyListViewUpdateImp lazyListViewUpdateImp22222 = LazyListViewUpdateImp.f339344a;
            arrayList22222.add(new com.tencent.ntcompose.core.k("itemsLayoutType", listItemsLayoutType3, null, null, null, null, lazyListViewUpdateImp22222, 60, null));
            if (lVar2 != null) {
            }
            if (dVar2 != null) {
            }
            if (f28 != null) {
            }
            if (bool7 != null) {
            }
            if (aVar2 != null) {
            }
            if (bool10 != null) {
            }
            if (bool8 != null) {
            }
            if (bool9 != null) {
            }
            if (bool11 != null) {
            }
            if (f29 != null) {
            }
            if (f27 != null) {
            }
            if (f26 != null) {
            }
            if (function16 != null) {
            }
            if (function17 != null) {
            }
            if (function18 != null) {
            }
            if (function19 != null) {
            }
            if (function23 != null) {
            }
            if (function110 != null) {
            }
            arrayList22222.add(new com.tencent.ntcompose.core.k(ScrollerAttr.SCROLL_WITH_PARENT, bool17, null, null, null, null, lazyListViewUpdateImp22222, 60, null));
            if ((dVar2 != null ? dVar2.getInitialFirstVisibleItemIndex() : 0) > 0) {
            }
            arrayList22222.add(new com.tencent.ntcompose.core.k("firstMaxIndexLoad", Integer.valueOf(i88), null, null, null, null, lazyListViewUpdateImp22222, 60, null));
            if (list2 != null) {
            }
            if (listItemsLayoutType3 != ListItemsLayoutType.VerticalGrid) {
            }
            if (Intrinsics.areEqual(bool10, Boolean.TRUE)) {
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            rememberedValue = startRestartGroup.rememberedValue();
            Boolean bool1822222 = bool8;
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final w wVar22222 = (w) rememberedValue;
            wVar22222.b(i99);
            Boolean bool1922222 = bool9;
            Boolean bool2022222 = bool10;
            final int i10022222 = i87;
            ComposeNodeKt.a(str, com.tencent.ntcompose.material.base.a.f339408a, function26 == null ? null : function26, iVar2, arrayList22222, ComposableLambdaKt.composableLambda(startRestartGroup, -891066595, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.LazyListKt$LazyList$1
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

                public final void invoke(Composer composer2, int i101) {
                    if ((i101 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-891066595, i101, -1, "com.tencent.ntcompose.material.LazyList.<anonymous> (LazyList.kt:262)");
                    }
                    Function2 function27 = (Function2) composer2.consume(LazyListKt.b());
                    composer2.startReplaceableGroup(-1833361285);
                    if (function27 != null) {
                        function27.invoke(composer2, 0);
                        Unit unit = Unit.INSTANCE;
                    }
                    composer2.endReplaceableGroup();
                    content.invoke(wVar22222, composer2, Integer.valueOf(((i10022222 >> 9) & 112) | 8));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), startRestartGroup, ((i26 << 9) & 7168) | 229424, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            bool12 = bool1922222;
            function24 = function26;
            dVar3 = dVar2;
            i89 = i99;
            listItemsLayoutType2 = listItemsLayoutType3;
            lVar3 = lVar2;
            bool13 = bool7;
            f36 = f29;
            bool14 = bool17;
            function111 = function18;
            iVar3 = iVar2;
            bool15 = bool2022222;
            f37 = f26;
            f38 = f27;
            aVar3 = aVar2;
            function112 = function110;
            function113 = function16;
            function114 = function19;
            bool16 = bool1822222;
            list3 = list2;
            f39 = f28;
            function25 = function23;
            endRestartGroup = startRestartGroup.endRestartGroup();
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
        int i97222 = i48;
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
        int i98222222 = i78;
        i85 = i19 & 4194304;
        if (i85 != 0) {
        }
        i86 = i19 & 8388608;
        if (i86 != 0) {
        }
        if ((i19 & 16777216) != 0) {
        }
        if (i86 != 8388608) {
        }
        if (i95 != 0) {
        }
        if (i96 != 0) {
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
        if (i85 != 0) {
        }
        if (i86 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        ArrayList arrayList222222 = new ArrayList();
        LazyListViewUpdateImp lazyListViewUpdateImp222222 = LazyListViewUpdateImp.f339344a;
        arrayList222222.add(new com.tencent.ntcompose.core.k("itemsLayoutType", listItemsLayoutType3, null, null, null, null, lazyListViewUpdateImp222222, 60, null));
        if (lVar2 != null) {
        }
        if (dVar2 != null) {
        }
        if (f28 != null) {
        }
        if (bool7 != null) {
        }
        if (aVar2 != null) {
        }
        if (bool10 != null) {
        }
        if (bool8 != null) {
        }
        if (bool9 != null) {
        }
        if (bool11 != null) {
        }
        if (f29 != null) {
        }
        if (f27 != null) {
        }
        if (f26 != null) {
        }
        if (function16 != null) {
        }
        if (function17 != null) {
        }
        if (function18 != null) {
        }
        if (function19 != null) {
        }
        if (function23 != null) {
        }
        if (function110 != null) {
        }
        arrayList222222.add(new com.tencent.ntcompose.core.k(ScrollerAttr.SCROLL_WITH_PARENT, bool17, null, null, null, null, lazyListViewUpdateImp222222, 60, null));
        if ((dVar2 != null ? dVar2.getInitialFirstVisibleItemIndex() : 0) > 0) {
        }
        arrayList222222.add(new com.tencent.ntcompose.core.k("firstMaxIndexLoad", Integer.valueOf(i88), null, null, null, null, lazyListViewUpdateImp222222, 60, null));
        if (list2 != null) {
        }
        if (listItemsLayoutType3 != ListItemsLayoutType.VerticalGrid) {
        }
        if (Intrinsics.areEqual(bool10, Boolean.TRUE)) {
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue = startRestartGroup.rememberedValue();
        Boolean bool18222222 = bool8;
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final w wVar222222 = (w) rememberedValue;
        wVar222222.b(i99);
        Boolean bool19222222 = bool9;
        Boolean bool20222222 = bool10;
        final int i100222222 = i87;
        ComposeNodeKt.a(str, com.tencent.ntcompose.material.base.a.f339408a, function26 == null ? null : function26, iVar2, arrayList222222, ComposableLambdaKt.composableLambda(startRestartGroup, -891066595, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.LazyListKt$LazyList$1
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

            public final void invoke(Composer composer2, int i101) {
                if ((i101 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-891066595, i101, -1, "com.tencent.ntcompose.material.LazyList.<anonymous> (LazyList.kt:262)");
                }
                Function2 function27 = (Function2) composer2.consume(LazyListKt.b());
                composer2.startReplaceableGroup(-1833361285);
                if (function27 != null) {
                    function27.invoke(composer2, 0);
                    Unit unit = Unit.INSTANCE;
                }
                composer2.endReplaceableGroup();
                content.invoke(wVar222222, composer2, Integer.valueOf(((i100222222 >> 9) & 112) | 8));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), startRestartGroup, ((i26 << 9) & 7168) | 229424, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        bool12 = bool19222222;
        function24 = function26;
        dVar3 = dVar2;
        i89 = i99;
        listItemsLayoutType2 = listItemsLayoutType3;
        lVar3 = lVar2;
        bool13 = bool7;
        f36 = f29;
        bool14 = bool17;
        function111 = function18;
        iVar3 = iVar2;
        bool15 = bool20222222;
        f37 = f26;
        f38 = f27;
        aVar3 = aVar2;
        function112 = function110;
        function113 = function16;
        function114 = function19;
        bool16 = bool18222222;
        list3 = list2;
        f39 = f28;
        function25 = function23;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    public static final ProvidableCompositionLocal<Function2<Composer, Integer, Unit>> b() {
        return f339343a;
    }
}
