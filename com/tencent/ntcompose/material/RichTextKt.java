package com.tencent.ntcompose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import bp3.a;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.bg;
import com.tencent.kuikly.core.views.ch;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.ntcompose.core.ComposeNodeKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import zo3.Shadow;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c8\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0089\u0004\u0010@\u001a\u00020\n2\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022B\b\u0002\u0010\r\u001a<\u0012\u0004\u0012\u00020\u0005\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u000b\u00a2\u0006\u0002\b\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(2\u0016\b\u0002\u0010,\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\n\u0018\u00010*2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u00101\u001a\u0004\u0018\u0001002\n\b\u0002\u00103\u001a\u0004\u0018\u0001022-\b\u0002\u00107\u001a'\u0012\u0015\u0012\u0013\u0018\u000104\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\n\u0018\u00010*j\u0004\u0018\u0001`62%\b\u0002\u0010:\u001a\u001f\u0012\u0013\u0012\u001108\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\n\u0018\u00010*2:\u0010?\u001a6\u0012\u0013\u0012\u00110(\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110<\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020\n0\u0004j\u0002`>H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b@\u0010A\u001a\u00a7\u0004\u0010E\u001a\u00020\n2\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022B\b\u0002\u0010\r\u001a<\u0012\u0004\u0012\u00020\u0005\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u000b\u00a2\u0006\u0002\b\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(2\u0016\b\u0002\u0010D\u001a\u0010\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020C\u0018\u00010B2\u0016\b\u0002\u0010,\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\n\u0018\u00010*2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u00101\u001a\u0004\u0018\u0001002\n\b\u0002\u00103\u001a\u0004\u0018\u0001022-\b\u0002\u00107\u001a'\u0012\u0015\u0012\u0013\u0018\u000104\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\n\u0018\u00010*j\u0004\u0018\u0001`62%\b\u0002\u0010:\u001a\u001f\u0012\u0013\u0012\u001108\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\n\u0018\u00010*2@\b\u0002\u0010?\u001a:\u0012\u0013\u0012\u00110(\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110<\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020\n\u0018\u00010\u0004j\u0004\u0018\u0001`>H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bE\u0010F\u001a(\u0010G\u001a\u0002022\u0014\u0010D\u001a\u0010\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020C\u0018\u00010B2\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0000\u001a,\u0010I\u001a\u000202*\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020C0B2\u0014\u0010H\u001a\u0010\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020C\u0018\u00010B*j\u0010J\"2\u0012\u0013\u0012\u00110(\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110<\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020\n0\u000422\u0012\u0013\u0012\u00110(\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110<\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020\n0\u0004\u0082\u0002\u000b\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b\u0019\u00a8\u0006K"}, d2 = {"Lbp3/a;", "text", "Lcom/tencent/ntcompose/core/i;", "modifier", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/views/TextView;", "Lcom/tencent/kuikly/core/base/aa;", "Lkotlin/ParameterName;", "name", "viewRef", "", "Lcom/tencent/ntcompose/core/RefFunc;", "Lkotlin/ExtensionFunctionType;", "ref", "Lcom/tencent/kuikly/core/base/h;", "color", "", "fontSize", "Lcom/tencent/ntcompose/material/o;", "fontStyle", "Lbp3/c;", "fontWeight", "Lcom/tencent/ntcompose/material/n;", "fontFamily", NodeProps.LETTER_SPACING, "Lcom/tencent/ntcompose/material/aj;", TtmlNode.ATTR_TTS_TEXT_DECORATION, "Lcom/tencent/ntcompose/material/ai;", "textAlign", NodeProps.LINE_HEIGHT, "Lcom/tencent/ntcompose/material/al;", "textIndent", "lineSpacing", "paragraphSpacing", "Lzo3/f;", "shadow", "Lcom/tencent/ntcompose/material/an;", "overflow", "Lcom/tencent/ntcompose/material/ao;", "stroke", "", "maxLines", "Lkotlin/Function1;", "Lcom/tencent/ntcompose/material/am;", "onTextLayout", "Lbp3/k;", "style", "lineBreakMargin", "", "textPostProcessor", "", "includePadding", "", "parma", "Lcom/tencent/kuikly/core/base/event/EventHandlerFn;", "onLineBreakMargin", "Lcom/tencent/kuikly/core/views/ch;", "params", "onTextWithLineBreak", "spanIndex", "Lcom/tencent/kuikly/core/base/event/c;", "e", "Lcom/tencent/ntcompose/material/RichTextClickCallback;", NodeProps.ON_CLICK, "a", "(Lbp3/a;Lcom/tencent/ntcompose/core/i;Lkotlin/jvm/functions/Function2;Lcom/tencent/kuikly/core/base/h;Ljava/lang/Float;Lcom/tencent/ntcompose/material/o;Lbp3/c;Lcom/tencent/ntcompose/material/n;Ljava/lang/Float;Lcom/tencent/ntcompose/material/aj;Lcom/tencent/ntcompose/material/ai;Ljava/lang/Float;Lcom/tencent/ntcompose/material/al;Ljava/lang/Float;Ljava/lang/Float;Lzo3/f;Lcom/tencent/ntcompose/material/an;Lcom/tencent/ntcompose/material/ao;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Lbp3/k;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;IIII)V", "", "Lbp3/d;", "inlineContent", "b", "(Lbp3/a;Lcom/tencent/ntcompose/core/i;Lkotlin/jvm/functions/Function2;Lcom/tencent/kuikly/core/base/h;Ljava/lang/Float;Lcom/tencent/ntcompose/material/o;Lbp3/c;Lcom/tencent/ntcompose/material/n;Ljava/lang/Float;Lcom/tencent/ntcompose/material/aj;Lcom/tencent/ntcompose/material/ai;Ljava/lang/Float;Lcom/tencent/ntcompose/material/al;Ljava/lang/Float;Ljava/lang/Float;Lzo3/f;Lcom/tencent/ntcompose/material/an;Lcom/tencent/ntcompose/material/ao;Ljava/lang/Integer;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lbp3/k;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;IIII)V", "d", "other", "c", "RichTextClickCallback", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class RichTextKt {
    /* JADX WARN: Removed duplicated region for block: B:102:0x053b  */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0416  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x041d  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0432  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x044e  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0459  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x04fd  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0443  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0427  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0404  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x033d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(bp3.a aVar, com.tencent.ntcompose.core.i iVar, Function2<? super TextView, ? super com.tencent.kuikly.core.base.aa<TextView>, Unit> function2, com.tencent.kuikly.core.base.h hVar, Float f16, o oVar, bp3.c cVar, n nVar, Float f17, aj ajVar, ai aiVar, Float f18, al alVar, Float f19, Float f26, Shadow shadow, an anVar, ao aoVar, Integer num, Function1<? super am, Unit> function1, bp3.k kVar, Float f27, String str, Boolean bool, Function1<Object, Unit> function12, Function1<? super ch, Unit> function13, final Function2<? super Integer, ? super ClickParams, Unit> onClick, Composer composer, final int i3, final int i16, final int i17, final int i18) {
        int i19;
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
        Function1<? super ch, Unit> function14;
        Composer composer2;
        final al alVar2;
        final bp3.a aVar2;
        Float f28;
        final Shadow shadow2;
        final an anVar2;
        final ao aoVar2;
        final Integer num2;
        final Function1<? super am, Unit> function15;
        final bp3.k kVar2;
        final com.tencent.ntcompose.core.i iVar2;
        final Float f29;
        final Function2<? super TextView, ? super com.tencent.kuikly.core.base.aa<TextView>, Unit> function22;
        final com.tencent.kuikly.core.base.h hVar2;
        final Float f36;
        final o oVar2;
        final bp3.c cVar2;
        final n nVar2;
        final Float f37;
        final aj ajVar2;
        final ai aiVar2;
        final Float f38;
        final Float f39;
        final String str2;
        final Boolean bool2;
        final Function1<Object, Unit> function16;
        final Function1<? super ch, Unit> function17;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(-551723173);
        int i87 = i18 & 1;
        if (i87 != 0) {
            i19 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i19 = (startRestartGroup.changed(aVar) ? 4 : 2) | i3;
        } else {
            i19 = i3;
        }
        int i88 = i18 & 2;
        if (i88 != 0) {
            i19 |= 48;
        } else if ((i3 & 112) == 0) {
            i19 |= startRestartGroup.changed(iVar) ? 32 : 16;
            i26 = i18 & 4;
            if (i26 == 0) {
                i19 |= MsgConstant.KRMFILETHUMBSIZE384;
            } else if ((i3 & 896) == 0) {
                i19 |= startRestartGroup.changed(function2) ? 256 : 128;
                i27 = i18 & 8;
                if (i27 != 0) {
                    i19 |= 1024;
                }
                i28 = i18 & 16;
                if (i28 != 0) {
                    i19 |= 24576;
                } else if ((i3 & 57344) == 0) {
                    i19 |= startRestartGroup.changed(f16) ? 16384 : 8192;
                }
                i29 = i18 & 32;
                if (i29 != 0) {
                    i19 |= 196608;
                } else if ((i3 & 458752) == 0) {
                    i19 |= startRestartGroup.changed(oVar) ? 131072 : 65536;
                }
                i36 = i18 & 64;
                if (i36 != 0) {
                    i19 |= 1572864;
                } else if ((i3 & 3670016) == 0) {
                    i19 |= startRestartGroup.changed(cVar) ? 1048576 : 524288;
                }
                i37 = i18 & 128;
                if (i37 != 0) {
                    i19 |= 12582912;
                } else if ((i3 & 29360128) == 0) {
                    i19 |= startRestartGroup.changed(nVar) ? 8388608 : 4194304;
                }
                i38 = i18 & 256;
                if (i38 != 0) {
                    i19 |= 100663296;
                } else if ((i3 & 234881024) == 0) {
                    i19 |= startRestartGroup.changed(f17) ? 67108864 : 33554432;
                }
                i39 = i18 & 512;
                if (i39 != 0) {
                    i19 |= 805306368;
                } else if ((i3 & 1879048192) == 0) {
                    i19 |= startRestartGroup.changed(ajVar) ? 536870912 : 268435456;
                }
                i46 = i18 & 1024;
                if (i46 != 0) {
                    i47 = i16 | 6;
                } else if ((i16 & 14) == 0) {
                    i47 = i16 | (startRestartGroup.changed(aiVar) ? 4 : 2);
                } else {
                    i47 = i16;
                }
                i48 = i18 & 2048;
                if (i48 != 0) {
                    i47 |= 48;
                } else if ((i16 & 112) == 0) {
                    i47 |= startRestartGroup.changed(f18) ? 32 : 16;
                }
                int i89 = i47;
                i49 = i18 & 4096;
                if (i49 != 0) {
                    i89 |= MsgConstant.KRMFILETHUMBSIZE384;
                    i56 = i49;
                } else {
                    i56 = i49;
                    if ((i16 & 896) == 0) {
                        i89 |= startRestartGroup.changed(alVar) ? 256 : 128;
                        i57 = i18 & 8192;
                        if (i57 == 0) {
                            i89 |= 3072;
                            i58 = i57;
                        } else {
                            i58 = i57;
                            if ((i16 & 7168) == 0) {
                                i89 |= startRestartGroup.changed(f19) ? 2048 : 1024;
                                i59 = i18 & 16384;
                                if (i59 != 0) {
                                    i89 |= 24576;
                                } else if ((i16 & 57344) == 0) {
                                    i65 = i59;
                                    i89 |= startRestartGroup.changed(f26) ? 16384 : 8192;
                                    i66 = i18 & 32768;
                                    if (i66 == 0) {
                                        i89 |= 196608;
                                    } else if ((i16 & 458752) == 0) {
                                        i89 |= startRestartGroup.changed(shadow) ? 131072 : 65536;
                                    }
                                    i67 = i18 & 65536;
                                    if (i67 == 0) {
                                        i89 |= 1572864;
                                    } else if ((i16 & 3670016) == 0) {
                                        i89 |= startRestartGroup.changed(anVar) ? 1048576 : 524288;
                                    }
                                    i68 = i18 & 131072;
                                    if (i68 == 0) {
                                        i89 |= 12582912;
                                    } else if ((i16 & 29360128) == 0) {
                                        i89 |= startRestartGroup.changed(aoVar) ? 8388608 : 4194304;
                                    }
                                    i69 = i18 & 262144;
                                    if (i69 == 0) {
                                        i89 |= 100663296;
                                    } else if ((i16 & 234881024) == 0) {
                                        i89 |= startRestartGroup.changed(num) ? 67108864 : 33554432;
                                    }
                                    i75 = i18 & 524288;
                                    if (i75 == 0) {
                                        i89 |= 805306368;
                                    } else if ((i16 & 1879048192) == 0) {
                                        i89 |= startRestartGroup.changed(function1) ? 536870912 : 268435456;
                                    }
                                    i76 = i18 & 1048576;
                                    int i95 = i76 == 0 ? i17 | 2 : i17;
                                    i77 = i18 & 2097152;
                                    if (i77 == 0) {
                                        i95 |= 48;
                                    } else if ((i17 & 112) == 0) {
                                        i95 |= startRestartGroup.changed(f27) ? 32 : 16;
                                    }
                                    int i96 = i95;
                                    i78 = i18 & 4194304;
                                    if (i78 == 0) {
                                        i96 |= MsgConstant.KRMFILETHUMBSIZE384;
                                    } else if ((i17 & 896) == 0) {
                                        i96 |= startRestartGroup.changed(str) ? 256 : 128;
                                        i79 = i18 & 8388608;
                                        if (i79 != 0) {
                                            i96 |= 3072;
                                        } else if ((i17 & 7168) == 0) {
                                            i96 |= startRestartGroup.changed(bool) ? 2048 : 1024;
                                            i85 = i18 & 16777216;
                                            if (i85 == 0) {
                                                i96 |= 24576;
                                            } else if ((i17 & 57344) == 0) {
                                                i96 |= startRestartGroup.changed(function12) ? 16384 : 8192;
                                            }
                                            i86 = i18 & 33554432;
                                            if (i86 == 0) {
                                                i96 |= 196608;
                                                function14 = function13;
                                            } else {
                                                function14 = function13;
                                                if ((i17 & 458752) == 0) {
                                                    i96 |= startRestartGroup.changed(function14) ? 131072 : 65536;
                                                }
                                            }
                                            if ((i18 & 67108864) == 0) {
                                                i96 |= 1572864;
                                            } else if ((i17 & 3670016) == 0) {
                                                i96 |= startRestartGroup.changed(onClick) ? 1048576 : 524288;
                                            }
                                            if ((i18 & 1048584) != 1048584 && (1533916891 & i19) == 306783378 && (1533916891 & i89) == 306783378 && (2995931 & i96) == 599186 && startRestartGroup.getSkipping()) {
                                                startRestartGroup.skipToGroupEnd();
                                                aVar2 = aVar;
                                                iVar2 = iVar;
                                                function22 = function2;
                                                hVar2 = hVar;
                                                f36 = f16;
                                                oVar2 = oVar;
                                                cVar2 = cVar;
                                                nVar2 = nVar;
                                                f37 = f17;
                                                aiVar2 = aiVar;
                                                f38 = f18;
                                                alVar2 = alVar;
                                                f28 = f26;
                                                shadow2 = shadow;
                                                anVar2 = anVar;
                                                aoVar2 = aoVar;
                                                num2 = num;
                                                function15 = function1;
                                                kVar2 = kVar;
                                                f29 = f27;
                                                str2 = str;
                                                bool2 = bool;
                                                function16 = function12;
                                                composer2 = startRestartGroup;
                                                function17 = function14;
                                                ajVar2 = ajVar;
                                                f39 = f19;
                                            } else {
                                                bp3.a aVar3 = i87 == 0 ? null : aVar;
                                                com.tencent.ntcompose.core.i iVar3 = i88 == 0 ? com.tencent.ntcompose.core.i.INSTANCE : iVar;
                                                Function2<? super TextView, ? super com.tencent.kuikly.core.base.aa<TextView>, Unit> function23 = i26 == 0 ? null : function2;
                                                com.tencent.kuikly.core.base.h hVar3 = i27 == 0 ? null : hVar;
                                                Float f46 = i28 == 0 ? null : f16;
                                                o oVar3 = i29 == 0 ? null : oVar;
                                                bp3.c cVar3 = i36 == 0 ? null : cVar;
                                                n nVar3 = i37 == 0 ? null : nVar;
                                                Float f47 = i38 == 0 ? null : f17;
                                                aj ajVar3 = i39 == 0 ? null : ajVar;
                                                ai aiVar3 = i46 == 0 ? null : aiVar;
                                                Float f48 = i48 == 0 ? null : f18;
                                                al alVar3 = i56 == 0 ? null : alVar;
                                                Float f49 = i58 == 0 ? null : f19;
                                                Float f56 = i65 == 0 ? null : f26;
                                                Shadow shadow3 = i66 == 0 ? null : shadow;
                                                an anVar3 = i67 == 0 ? null : anVar;
                                                ao aoVar3 = i68 == 0 ? null : aoVar;
                                                Integer num3 = i69 == 0 ? null : num;
                                                Function1<? super am, Unit> function18 = i75 == 0 ? null : function1;
                                                bp3.k kVar3 = i76 == 0 ? null : kVar;
                                                Float f57 = i77 == 0 ? null : f27;
                                                String str3 = i78 == 0 ? null : str;
                                                Boolean bool3 = i79 == 0 ? null : bool;
                                                Function1<Object, Unit> function19 = i85 == 0 ? null : function12;
                                                Function1<? super ch, Unit> function110 = i86 == 0 ? null : function14;
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-551723173, i19, i89, "com.tencent.ntcompose.material.ClickableText (RichText.kt:31)");
                                                }
                                                int i97 = i96 << 3;
                                                composer2 = startRestartGroup;
                                                b(aVar3, iVar3, function23, hVar3, f46, oVar3, cVar3, nVar3, f47, ajVar3, aiVar3, f48, alVar3, f49, f56, shadow3, anVar3, aoVar3, num3, null, function18, kVar3, f57, str3, bool3, function19, function110, onClick, composer2, (i19 & 14) | 4096 | (i19 & 112) | (i19 & 896) | (i19 & 57344) | (i19 & 458752) | (i19 & 3670016) | (i19 & 29360128) | (i19 & 234881024) | (1879048192 & i19), (i89 & 14) | (i89 & 112) | (i89 & 896) | (i89 & 7168) | (i89 & 57344) | (i89 & 458752) | (i89 & 3670016) | (i89 & 29360128) | (i89 & 234881024), ((i89 >> 27) & 14) | 64 | (i97 & 896) | (i97 & 7168) | (i97 & 57344) | (i97 & 458752) | (i97 & 3670016) | (i97 & 29360128), 524288);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                                alVar2 = alVar3;
                                                aVar2 = aVar3;
                                                f28 = f56;
                                                shadow2 = shadow3;
                                                anVar2 = anVar3;
                                                aoVar2 = aoVar3;
                                                num2 = num3;
                                                function15 = function18;
                                                kVar2 = kVar3;
                                                iVar2 = iVar3;
                                                f29 = f57;
                                                function22 = function23;
                                                hVar2 = hVar3;
                                                f36 = f46;
                                                oVar2 = oVar3;
                                                cVar2 = cVar3;
                                                nVar2 = nVar3;
                                                f37 = f47;
                                                ajVar2 = ajVar3;
                                                aiVar2 = aiVar3;
                                                f38 = f48;
                                                f39 = f49;
                                                str2 = str3;
                                                bool2 = bool3;
                                                function16 = function19;
                                                function17 = function110;
                                            }
                                            endRestartGroup = composer2.endRestartGroup();
                                            if (endRestartGroup != null) {
                                                return;
                                            }
                                            final Float f58 = f28;
                                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>(iVar2, function22, hVar2, f36, oVar2, cVar2, nVar2, f37, ajVar2, aiVar2, f38, alVar2, f39, f58, shadow2, anVar2, aoVar2, num2, function15, kVar2, f29, str2, bool2, function16, function17, onClick, i3, i16, i17, i18) { // from class: com.tencent.ntcompose.material.RichTextKt$ClickableText$1
                                                final /* synthetic */ int $$changed;
                                                final /* synthetic */ int $$changed1;
                                                final /* synthetic */ int $$changed2;
                                                final /* synthetic */ int $$default;
                                                final /* synthetic */ com.tencent.kuikly.core.base.h $color;
                                                final /* synthetic */ n $fontFamily;
                                                final /* synthetic */ Float $fontSize;
                                                final /* synthetic */ o $fontStyle;
                                                final /* synthetic */ bp3.c $fontWeight;
                                                final /* synthetic */ Boolean $includePadding;
                                                final /* synthetic */ Float $letterSpacing;
                                                final /* synthetic */ Float $lineBreakMargin;
                                                final /* synthetic */ Float $lineHeight;
                                                final /* synthetic */ Float $lineSpacing;
                                                final /* synthetic */ Integer $maxLines;
                                                final /* synthetic */ com.tencent.ntcompose.core.i $modifier;
                                                final /* synthetic */ Function2<Integer, ClickParams, Unit> $onClick;
                                                final /* synthetic */ Function1<Object, Unit> $onLineBreakMargin;
                                                final /* synthetic */ Function1<am, Unit> $onTextLayout;
                                                final /* synthetic */ Function1<ch, Unit> $onTextWithLineBreak;
                                                final /* synthetic */ an $overflow;
                                                final /* synthetic */ Float $paragraphSpacing;
                                                final /* synthetic */ Function2<TextView, com.tencent.kuikly.core.base.aa<TextView>, Unit> $ref;
                                                final /* synthetic */ Shadow $shadow;
                                                final /* synthetic */ ao $stroke;
                                                final /* synthetic */ bp3.k $style;
                                                final /* synthetic */ ai $textAlign;
                                                final /* synthetic */ aj $textDecoration;
                                                final /* synthetic */ al $textIndent;
                                                final /* synthetic */ String $textPostProcessor;

                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                    this.$lineSpacing = f39;
                                                    this.$paragraphSpacing = f58;
                                                    this.$shadow = shadow2;
                                                    this.$overflow = anVar2;
                                                    this.$stroke = aoVar2;
                                                    this.$maxLines = num2;
                                                    this.$onTextLayout = function15;
                                                    this.$style = kVar2;
                                                    this.$lineBreakMargin = f29;
                                                    this.$textPostProcessor = str2;
                                                    this.$includePadding = bool2;
                                                    this.$onLineBreakMargin = function16;
                                                    this.$onTextWithLineBreak = function17;
                                                    this.$onClick = onClick;
                                                    this.$$changed = i3;
                                                    this.$$changed1 = i16;
                                                    this.$$changed2 = i17;
                                                    this.$$default = i18;
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num4) {
                                                    invoke(composer3, num4.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer3, int i98) {
                                                    RichTextKt.a(bp3.a.this, this.$modifier, this.$ref, this.$color, this.$fontSize, this.$fontStyle, this.$fontWeight, this.$fontFamily, this.$letterSpacing, this.$textDecoration, this.$textAlign, this.$lineHeight, null, this.$lineSpacing, this.$paragraphSpacing, this.$shadow, this.$overflow, this.$stroke, this.$maxLines, this.$onTextLayout, this.$style, this.$lineBreakMargin, this.$textPostProcessor, this.$includePadding, this.$onLineBreakMargin, this.$onTextWithLineBreak, this.$onClick, composer3, this.$$changed | 1, this.$$changed1, this.$$changed2, this.$$default);
                                                }
                                            });
                                            return;
                                        }
                                        i85 = i18 & 16777216;
                                        if (i85 == 0) {
                                        }
                                        i86 = i18 & 33554432;
                                        if (i86 == 0) {
                                        }
                                        if ((i18 & 67108864) == 0) {
                                        }
                                        if ((i18 & 1048584) != 1048584) {
                                        }
                                        if (i87 == 0) {
                                        }
                                        if (i88 == 0) {
                                        }
                                        if (i26 == 0) {
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
                                        if (i56 == 0) {
                                        }
                                        if (i58 == 0) {
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
                                        if (i76 == 0) {
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
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        int i972 = i96 << 3;
                                        composer2 = startRestartGroup;
                                        b(aVar3, iVar3, function23, hVar3, f46, oVar3, cVar3, nVar3, f47, ajVar3, aiVar3, f48, alVar3, f49, f56, shadow3, anVar3, aoVar3, num3, null, function18, kVar3, f57, str3, bool3, function19, function110, onClick, composer2, (i19 & 14) | 4096 | (i19 & 112) | (i19 & 896) | (i19 & 57344) | (i19 & 458752) | (i19 & 3670016) | (i19 & 29360128) | (i19 & 234881024) | (1879048192 & i19), (i89 & 14) | (i89 & 112) | (i89 & 896) | (i89 & 7168) | (i89 & 57344) | (i89 & 458752) | (i89 & 3670016) | (i89 & 29360128) | (i89 & 234881024), ((i89 >> 27) & 14) | 64 | (i972 & 896) | (i972 & 7168) | (i972 & 57344) | (i972 & 458752) | (i972 & 3670016) | (i972 & 29360128), 524288);
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        alVar2 = alVar3;
                                        aVar2 = aVar3;
                                        f28 = f56;
                                        shadow2 = shadow3;
                                        anVar2 = anVar3;
                                        aoVar2 = aoVar3;
                                        num2 = num3;
                                        function15 = function18;
                                        kVar2 = kVar3;
                                        iVar2 = iVar3;
                                        f29 = f57;
                                        function22 = function23;
                                        hVar2 = hVar3;
                                        f36 = f46;
                                        oVar2 = oVar3;
                                        cVar2 = cVar3;
                                        nVar2 = nVar3;
                                        f37 = f47;
                                        ajVar2 = ajVar3;
                                        aiVar2 = aiVar3;
                                        f38 = f48;
                                        f39 = f49;
                                        str2 = str3;
                                        bool2 = bool3;
                                        function16 = function19;
                                        function17 = function110;
                                        endRestartGroup = composer2.endRestartGroup();
                                        if (endRestartGroup != null) {
                                        }
                                    }
                                    i79 = i18 & 8388608;
                                    if (i79 != 0) {
                                    }
                                    i85 = i18 & 16777216;
                                    if (i85 == 0) {
                                    }
                                    i86 = i18 & 33554432;
                                    if (i86 == 0) {
                                    }
                                    if ((i18 & 67108864) == 0) {
                                    }
                                    if ((i18 & 1048584) != 1048584) {
                                    }
                                    if (i87 == 0) {
                                    }
                                    if (i88 == 0) {
                                    }
                                    if (i26 == 0) {
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
                                    if (i56 == 0) {
                                    }
                                    if (i58 == 0) {
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
                                    if (i76 == 0) {
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
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    int i9722 = i96 << 3;
                                    composer2 = startRestartGroup;
                                    b(aVar3, iVar3, function23, hVar3, f46, oVar3, cVar3, nVar3, f47, ajVar3, aiVar3, f48, alVar3, f49, f56, shadow3, anVar3, aoVar3, num3, null, function18, kVar3, f57, str3, bool3, function19, function110, onClick, composer2, (i19 & 14) | 4096 | (i19 & 112) | (i19 & 896) | (i19 & 57344) | (i19 & 458752) | (i19 & 3670016) | (i19 & 29360128) | (i19 & 234881024) | (1879048192 & i19), (i89 & 14) | (i89 & 112) | (i89 & 896) | (i89 & 7168) | (i89 & 57344) | (i89 & 458752) | (i89 & 3670016) | (i89 & 29360128) | (i89 & 234881024), ((i89 >> 27) & 14) | 64 | (i9722 & 896) | (i9722 & 7168) | (i9722 & 57344) | (i9722 & 458752) | (i9722 & 3670016) | (i9722 & 29360128), 524288);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    alVar2 = alVar3;
                                    aVar2 = aVar3;
                                    f28 = f56;
                                    shadow2 = shadow3;
                                    anVar2 = anVar3;
                                    aoVar2 = aoVar3;
                                    num2 = num3;
                                    function15 = function18;
                                    kVar2 = kVar3;
                                    iVar2 = iVar3;
                                    f29 = f57;
                                    function22 = function23;
                                    hVar2 = hVar3;
                                    f36 = f46;
                                    oVar2 = oVar3;
                                    cVar2 = cVar3;
                                    nVar2 = nVar3;
                                    f37 = f47;
                                    ajVar2 = ajVar3;
                                    aiVar2 = aiVar3;
                                    f38 = f48;
                                    f39 = f49;
                                    str2 = str3;
                                    bool2 = bool3;
                                    function16 = function19;
                                    function17 = function110;
                                    endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup != null) {
                                    }
                                }
                                i65 = i59;
                                i66 = i18 & 32768;
                                if (i66 == 0) {
                                }
                                i67 = i18 & 65536;
                                if (i67 == 0) {
                                }
                                i68 = i18 & 131072;
                                if (i68 == 0) {
                                }
                                i69 = i18 & 262144;
                                if (i69 == 0) {
                                }
                                i75 = i18 & 524288;
                                if (i75 == 0) {
                                }
                                i76 = i18 & 1048576;
                                if (i76 == 0) {
                                }
                                i77 = i18 & 2097152;
                                if (i77 == 0) {
                                }
                                int i962 = i95;
                                i78 = i18 & 4194304;
                                if (i78 == 0) {
                                }
                                i79 = i18 & 8388608;
                                if (i79 != 0) {
                                }
                                i85 = i18 & 16777216;
                                if (i85 == 0) {
                                }
                                i86 = i18 & 33554432;
                                if (i86 == 0) {
                                }
                                if ((i18 & 67108864) == 0) {
                                }
                                if ((i18 & 1048584) != 1048584) {
                                }
                                if (i87 == 0) {
                                }
                                if (i88 == 0) {
                                }
                                if (i26 == 0) {
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
                                if (i56 == 0) {
                                }
                                if (i58 == 0) {
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
                                if (i76 == 0) {
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
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                int i97222 = i962 << 3;
                                composer2 = startRestartGroup;
                                b(aVar3, iVar3, function23, hVar3, f46, oVar3, cVar3, nVar3, f47, ajVar3, aiVar3, f48, alVar3, f49, f56, shadow3, anVar3, aoVar3, num3, null, function18, kVar3, f57, str3, bool3, function19, function110, onClick, composer2, (i19 & 14) | 4096 | (i19 & 112) | (i19 & 896) | (i19 & 57344) | (i19 & 458752) | (i19 & 3670016) | (i19 & 29360128) | (i19 & 234881024) | (1879048192 & i19), (i89 & 14) | (i89 & 112) | (i89 & 896) | (i89 & 7168) | (i89 & 57344) | (i89 & 458752) | (i89 & 3670016) | (i89 & 29360128) | (i89 & 234881024), ((i89 >> 27) & 14) | 64 | (i97222 & 896) | (i97222 & 7168) | (i97222 & 57344) | (i97222 & 458752) | (i97222 & 3670016) | (i97222 & 29360128), 524288);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                alVar2 = alVar3;
                                aVar2 = aVar3;
                                f28 = f56;
                                shadow2 = shadow3;
                                anVar2 = anVar3;
                                aoVar2 = aoVar3;
                                num2 = num3;
                                function15 = function18;
                                kVar2 = kVar3;
                                iVar2 = iVar3;
                                f29 = f57;
                                function22 = function23;
                                hVar2 = hVar3;
                                f36 = f46;
                                oVar2 = oVar3;
                                cVar2 = cVar3;
                                nVar2 = nVar3;
                                f37 = f47;
                                ajVar2 = ajVar3;
                                aiVar2 = aiVar3;
                                f38 = f48;
                                f39 = f49;
                                str2 = str3;
                                bool2 = bool3;
                                function16 = function19;
                                function17 = function110;
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup != null) {
                                }
                            }
                        }
                        i59 = i18 & 16384;
                        if (i59 != 0) {
                        }
                        i65 = i59;
                        i66 = i18 & 32768;
                        if (i66 == 0) {
                        }
                        i67 = i18 & 65536;
                        if (i67 == 0) {
                        }
                        i68 = i18 & 131072;
                        if (i68 == 0) {
                        }
                        i69 = i18 & 262144;
                        if (i69 == 0) {
                        }
                        i75 = i18 & 524288;
                        if (i75 == 0) {
                        }
                        i76 = i18 & 1048576;
                        if (i76 == 0) {
                        }
                        i77 = i18 & 2097152;
                        if (i77 == 0) {
                        }
                        int i9622 = i95;
                        i78 = i18 & 4194304;
                        if (i78 == 0) {
                        }
                        i79 = i18 & 8388608;
                        if (i79 != 0) {
                        }
                        i85 = i18 & 16777216;
                        if (i85 == 0) {
                        }
                        i86 = i18 & 33554432;
                        if (i86 == 0) {
                        }
                        if ((i18 & 67108864) == 0) {
                        }
                        if ((i18 & 1048584) != 1048584) {
                        }
                        if (i87 == 0) {
                        }
                        if (i88 == 0) {
                        }
                        if (i26 == 0) {
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
                        if (i56 == 0) {
                        }
                        if (i58 == 0) {
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
                        if (i76 == 0) {
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
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i972222 = i9622 << 3;
                        composer2 = startRestartGroup;
                        b(aVar3, iVar3, function23, hVar3, f46, oVar3, cVar3, nVar3, f47, ajVar3, aiVar3, f48, alVar3, f49, f56, shadow3, anVar3, aoVar3, num3, null, function18, kVar3, f57, str3, bool3, function19, function110, onClick, composer2, (i19 & 14) | 4096 | (i19 & 112) | (i19 & 896) | (i19 & 57344) | (i19 & 458752) | (i19 & 3670016) | (i19 & 29360128) | (i19 & 234881024) | (1879048192 & i19), (i89 & 14) | (i89 & 112) | (i89 & 896) | (i89 & 7168) | (i89 & 57344) | (i89 & 458752) | (i89 & 3670016) | (i89 & 29360128) | (i89 & 234881024), ((i89 >> 27) & 14) | 64 | (i972222 & 896) | (i972222 & 7168) | (i972222 & 57344) | (i972222 & 458752) | (i972222 & 3670016) | (i972222 & 29360128), 524288);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        alVar2 = alVar3;
                        aVar2 = aVar3;
                        f28 = f56;
                        shadow2 = shadow3;
                        anVar2 = anVar3;
                        aoVar2 = aoVar3;
                        num2 = num3;
                        function15 = function18;
                        kVar2 = kVar3;
                        iVar2 = iVar3;
                        f29 = f57;
                        function22 = function23;
                        hVar2 = hVar3;
                        f36 = f46;
                        oVar2 = oVar3;
                        cVar2 = cVar3;
                        nVar2 = nVar3;
                        f37 = f47;
                        ajVar2 = ajVar3;
                        aiVar2 = aiVar3;
                        f38 = f48;
                        f39 = f49;
                        str2 = str3;
                        bool2 = bool3;
                        function16 = function19;
                        function17 = function110;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                }
                i57 = i18 & 8192;
                if (i57 == 0) {
                }
                i59 = i18 & 16384;
                if (i59 != 0) {
                }
                i65 = i59;
                i66 = i18 & 32768;
                if (i66 == 0) {
                }
                i67 = i18 & 65536;
                if (i67 == 0) {
                }
                i68 = i18 & 131072;
                if (i68 == 0) {
                }
                i69 = i18 & 262144;
                if (i69 == 0) {
                }
                i75 = i18 & 524288;
                if (i75 == 0) {
                }
                i76 = i18 & 1048576;
                if (i76 == 0) {
                }
                i77 = i18 & 2097152;
                if (i77 == 0) {
                }
                int i96222 = i95;
                i78 = i18 & 4194304;
                if (i78 == 0) {
                }
                i79 = i18 & 8388608;
                if (i79 != 0) {
                }
                i85 = i18 & 16777216;
                if (i85 == 0) {
                }
                i86 = i18 & 33554432;
                if (i86 == 0) {
                }
                if ((i18 & 67108864) == 0) {
                }
                if ((i18 & 1048584) != 1048584) {
                }
                if (i87 == 0) {
                }
                if (i88 == 0) {
                }
                if (i26 == 0) {
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
                if (i56 == 0) {
                }
                if (i58 == 0) {
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
                if (i76 == 0) {
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
                if (ComposerKt.isTraceInProgress()) {
                }
                int i9722222 = i96222 << 3;
                composer2 = startRestartGroup;
                b(aVar3, iVar3, function23, hVar3, f46, oVar3, cVar3, nVar3, f47, ajVar3, aiVar3, f48, alVar3, f49, f56, shadow3, anVar3, aoVar3, num3, null, function18, kVar3, f57, str3, bool3, function19, function110, onClick, composer2, (i19 & 14) | 4096 | (i19 & 112) | (i19 & 896) | (i19 & 57344) | (i19 & 458752) | (i19 & 3670016) | (i19 & 29360128) | (i19 & 234881024) | (1879048192 & i19), (i89 & 14) | (i89 & 112) | (i89 & 896) | (i89 & 7168) | (i89 & 57344) | (i89 & 458752) | (i89 & 3670016) | (i89 & 29360128) | (i89 & 234881024), ((i89 >> 27) & 14) | 64 | (i9722222 & 896) | (i9722222 & 7168) | (i9722222 & 57344) | (i9722222 & 458752) | (i9722222 & 3670016) | (i9722222 & 29360128), 524288);
                if (ComposerKt.isTraceInProgress()) {
                }
                alVar2 = alVar3;
                aVar2 = aVar3;
                f28 = f56;
                shadow2 = shadow3;
                anVar2 = anVar3;
                aoVar2 = aoVar3;
                num2 = num3;
                function15 = function18;
                kVar2 = kVar3;
                iVar2 = iVar3;
                f29 = f57;
                function22 = function23;
                hVar2 = hVar3;
                f36 = f46;
                oVar2 = oVar3;
                cVar2 = cVar3;
                nVar2 = nVar3;
                f37 = f47;
                ajVar2 = ajVar3;
                aiVar2 = aiVar3;
                f38 = f48;
                f39 = f49;
                str2 = str3;
                bool2 = bool3;
                function16 = function19;
                function17 = function110;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i27 = i18 & 8;
            if (i27 != 0) {
            }
            i28 = i18 & 16;
            if (i28 != 0) {
            }
            i29 = i18 & 32;
            if (i29 != 0) {
            }
            i36 = i18 & 64;
            if (i36 != 0) {
            }
            i37 = i18 & 128;
            if (i37 != 0) {
            }
            i38 = i18 & 256;
            if (i38 != 0) {
            }
            i39 = i18 & 512;
            if (i39 != 0) {
            }
            i46 = i18 & 1024;
            if (i46 != 0) {
            }
            i48 = i18 & 2048;
            if (i48 != 0) {
            }
            int i892 = i47;
            i49 = i18 & 4096;
            if (i49 != 0) {
            }
            i57 = i18 & 8192;
            if (i57 == 0) {
            }
            i59 = i18 & 16384;
            if (i59 != 0) {
            }
            i65 = i59;
            i66 = i18 & 32768;
            if (i66 == 0) {
            }
            i67 = i18 & 65536;
            if (i67 == 0) {
            }
            i68 = i18 & 131072;
            if (i68 == 0) {
            }
            i69 = i18 & 262144;
            if (i69 == 0) {
            }
            i75 = i18 & 524288;
            if (i75 == 0) {
            }
            i76 = i18 & 1048576;
            if (i76 == 0) {
            }
            i77 = i18 & 2097152;
            if (i77 == 0) {
            }
            int i962222 = i95;
            i78 = i18 & 4194304;
            if (i78 == 0) {
            }
            i79 = i18 & 8388608;
            if (i79 != 0) {
            }
            i85 = i18 & 16777216;
            if (i85 == 0) {
            }
            i86 = i18 & 33554432;
            if (i86 == 0) {
            }
            if ((i18 & 67108864) == 0) {
            }
            if ((i18 & 1048584) != 1048584) {
            }
            if (i87 == 0) {
            }
            if (i88 == 0) {
            }
            if (i26 == 0) {
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
            if (i56 == 0) {
            }
            if (i58 == 0) {
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
            if (i76 == 0) {
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
            if (ComposerKt.isTraceInProgress()) {
            }
            int i97222222 = i962222 << 3;
            composer2 = startRestartGroup;
            b(aVar3, iVar3, function23, hVar3, f46, oVar3, cVar3, nVar3, f47, ajVar3, aiVar3, f48, alVar3, f49, f56, shadow3, anVar3, aoVar3, num3, null, function18, kVar3, f57, str3, bool3, function19, function110, onClick, composer2, (i19 & 14) | 4096 | (i19 & 112) | (i19 & 896) | (i19 & 57344) | (i19 & 458752) | (i19 & 3670016) | (i19 & 29360128) | (i19 & 234881024) | (1879048192 & i19), (i892 & 14) | (i892 & 112) | (i892 & 896) | (i892 & 7168) | (i892 & 57344) | (i892 & 458752) | (i892 & 3670016) | (i892 & 29360128) | (i892 & 234881024), ((i892 >> 27) & 14) | 64 | (i97222222 & 896) | (i97222222 & 7168) | (i97222222 & 57344) | (i97222222 & 458752) | (i97222222 & 3670016) | (i97222222 & 29360128), 524288);
            if (ComposerKt.isTraceInProgress()) {
            }
            alVar2 = alVar3;
            aVar2 = aVar3;
            f28 = f56;
            shadow2 = shadow3;
            anVar2 = anVar3;
            aoVar2 = aoVar3;
            num2 = num3;
            function15 = function18;
            kVar2 = kVar3;
            iVar2 = iVar3;
            f29 = f57;
            function22 = function23;
            hVar2 = hVar3;
            f36 = f46;
            oVar2 = oVar3;
            cVar2 = cVar3;
            nVar2 = nVar3;
            f37 = f47;
            ajVar2 = ajVar3;
            aiVar2 = aiVar3;
            f38 = f48;
            f39 = f49;
            str2 = str3;
            bool2 = bool3;
            function16 = function19;
            function17 = function110;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i26 = i18 & 4;
        if (i26 == 0) {
        }
        i27 = i18 & 8;
        if (i27 != 0) {
        }
        i28 = i18 & 16;
        if (i28 != 0) {
        }
        i29 = i18 & 32;
        if (i29 != 0) {
        }
        i36 = i18 & 64;
        if (i36 != 0) {
        }
        i37 = i18 & 128;
        if (i37 != 0) {
        }
        i38 = i18 & 256;
        if (i38 != 0) {
        }
        i39 = i18 & 512;
        if (i39 != 0) {
        }
        i46 = i18 & 1024;
        if (i46 != 0) {
        }
        i48 = i18 & 2048;
        if (i48 != 0) {
        }
        int i8922 = i47;
        i49 = i18 & 4096;
        if (i49 != 0) {
        }
        i57 = i18 & 8192;
        if (i57 == 0) {
        }
        i59 = i18 & 16384;
        if (i59 != 0) {
        }
        i65 = i59;
        i66 = i18 & 32768;
        if (i66 == 0) {
        }
        i67 = i18 & 65536;
        if (i67 == 0) {
        }
        i68 = i18 & 131072;
        if (i68 == 0) {
        }
        i69 = i18 & 262144;
        if (i69 == 0) {
        }
        i75 = i18 & 524288;
        if (i75 == 0) {
        }
        i76 = i18 & 1048576;
        if (i76 == 0) {
        }
        i77 = i18 & 2097152;
        if (i77 == 0) {
        }
        int i9622222 = i95;
        i78 = i18 & 4194304;
        if (i78 == 0) {
        }
        i79 = i18 & 8388608;
        if (i79 != 0) {
        }
        i85 = i18 & 16777216;
        if (i85 == 0) {
        }
        i86 = i18 & 33554432;
        if (i86 == 0) {
        }
        if ((i18 & 67108864) == 0) {
        }
        if ((i18 & 1048584) != 1048584) {
        }
        if (i87 == 0) {
        }
        if (i88 == 0) {
        }
        if (i26 == 0) {
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
        if (i56 == 0) {
        }
        if (i58 == 0) {
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
        if (i76 == 0) {
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
        if (ComposerKt.isTraceInProgress()) {
        }
        int i972222222 = i9622222 << 3;
        composer2 = startRestartGroup;
        b(aVar3, iVar3, function23, hVar3, f46, oVar3, cVar3, nVar3, f47, ajVar3, aiVar3, f48, alVar3, f49, f56, shadow3, anVar3, aoVar3, num3, null, function18, kVar3, f57, str3, bool3, function19, function110, onClick, composer2, (i19 & 14) | 4096 | (i19 & 112) | (i19 & 896) | (i19 & 57344) | (i19 & 458752) | (i19 & 3670016) | (i19 & 29360128) | (i19 & 234881024) | (1879048192 & i19), (i8922 & 14) | (i8922 & 112) | (i8922 & 896) | (i8922 & 7168) | (i8922 & 57344) | (i8922 & 458752) | (i8922 & 3670016) | (i8922 & 29360128) | (i8922 & 234881024), ((i8922 >> 27) & 14) | 64 | (i972222222 & 896) | (i972222222 & 7168) | (i972222222 & 57344) | (i972222222 & 458752) | (i972222222 & 3670016) | (i972222222 & 29360128), 524288);
        if (ComposerKt.isTraceInProgress()) {
        }
        alVar2 = alVar3;
        aVar2 = aVar3;
        f28 = f56;
        shadow2 = shadow3;
        anVar2 = anVar3;
        aoVar2 = aoVar3;
        num2 = num3;
        function15 = function18;
        kVar2 = kVar3;
        iVar2 = iVar3;
        f29 = f57;
        function22 = function23;
        hVar2 = hVar3;
        f36 = f46;
        oVar2 = oVar3;
        cVar2 = cVar3;
        nVar2 = nVar3;
        f37 = f47;
        ajVar2 = ajVar3;
        aiVar2 = aiVar3;
        f38 = f48;
        f39 = f49;
        str2 = str3;
        bool2 = bool3;
        function16 = function19;
        function17 = function110;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x094b  */
    /* JADX WARN: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0404  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0427  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0443  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x045b  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0490  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x04b1  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x04e0  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x04e9  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0503  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x050d  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0517  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0521  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x052b  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0535  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x053f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0549  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0553  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0558  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0562  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x056c  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x05a2  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x05d1  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0600  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x063c  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0676  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x06a5  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x06dc  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x070a  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0738  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0792  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x07bd  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x07f6  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x081c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x090f  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x07f8  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0638  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x04f6  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x04fb  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x04d8  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x04a2  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0474  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x045e  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0454  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0446  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x043f  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0438  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x03ed  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x03e7  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:419:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:426:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:433:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:440:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:448:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:455:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:462:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:469:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:476:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:483:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:490:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x034b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void b(bp3.a aVar, com.tencent.ntcompose.core.i iVar, Function2<? super TextView, ? super com.tencent.kuikly.core.base.aa<TextView>, Unit> function2, com.tencent.kuikly.core.base.h hVar, Float f16, o oVar, bp3.c cVar, n nVar, Float f17, aj ajVar, ai aiVar, Float f18, al alVar, Float f19, Float f26, Shadow shadow, an anVar, ao aoVar, Integer num, Map<String, bp3.d> map, Function1<? super am, Unit> function1, bp3.k kVar, Float f27, String str, Boolean bool, Function1<Object, Unit> function12, Function1<? super ch, Unit> function13, Function2<? super Integer, ? super ClickParams, Unit> function22, Composer composer, final int i3, final int i16, final int i17, final int i18) {
        int i19;
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
        int i87;
        Function1<? super ch, Unit> function14;
        int i88;
        final bp3.a aVar2;
        com.tencent.kuikly.core.base.h hVar2;
        o oVar2;
        bp3.c cVar2;
        Float f28;
        Float f29;
        Shadow shadow2;
        an anVar2;
        ao aoVar2;
        Integer num2;
        Map<String, bp3.d> map2;
        bp3.k kVar2;
        Float f36;
        String str2;
        Boolean bool2;
        Function1<Object, Unit> function15;
        Function2<? super Integer, ? super ClickParams, Unit> function23;
        n nVar2;
        aj ajVar2;
        boolean d16;
        Object rememberedValue;
        Composer.Companion companion;
        Float f37;
        Object obj;
        al alVar2;
        Function1 function16;
        final com.tencent.ntcompose.core.i iVar2;
        final Function2<? super TextView, ? super com.tencent.kuikly.core.base.aa<TextView>, Unit> function24;
        final com.tencent.kuikly.core.base.h hVar3;
        final Float f38;
        final o oVar3;
        final bp3.c cVar3;
        final n nVar3;
        final Float f39;
        final an anVar3;
        final ao aoVar3;
        final Float f46;
        final Float f47;
        final aj ajVar3;
        final ai aiVar2;
        final Function1<? super am, Unit> function17;
        final al alVar3;
        final Function1<? super ch, Unit> function18;
        final Function1<Object, Unit> function19;
        Float f48;
        final Integer num3;
        final String str3;
        final Function2<? super Integer, ? super ClickParams, Unit> function25;
        final Shadow shadow3;
        final Map<String, bp3.d> map3;
        final Boolean bool3;
        final bp3.k kVar3;
        final Float f49;
        bp3.d placeholder;
        Float fontSize;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1460396667);
        int i89 = i18 & 1;
        if (i89 != 0) {
            i19 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i19 = (startRestartGroup.changed(aVar) ? 4 : 2) | i3;
        } else {
            i19 = i3;
        }
        int i95 = i18 & 2;
        if (i95 != 0) {
            i19 |= 48;
        } else if ((i3 & 112) == 0) {
            i19 |= startRestartGroup.changed(iVar) ? 32 : 16;
            i26 = i18 & 4;
            if (i26 == 0) {
                i19 |= MsgConstant.KRMFILETHUMBSIZE384;
            } else if ((i3 & 896) == 0) {
                i19 |= startRestartGroup.changed(function2) ? 256 : 128;
                i27 = i18 & 8;
                if (i27 != 0) {
                    i19 |= 1024;
                }
                i28 = i18 & 16;
                if (i28 != 0) {
                    i19 |= 24576;
                } else if ((i3 & 57344) == 0) {
                    i19 |= startRestartGroup.changed(f16) ? 16384 : 8192;
                }
                i29 = i18 & 32;
                if (i29 != 0) {
                    i19 |= 196608;
                } else if ((i3 & 458752) == 0) {
                    i19 |= startRestartGroup.changed(oVar) ? 131072 : 65536;
                }
                i36 = i18 & 64;
                if (i36 != 0) {
                    i19 |= 1572864;
                } else if ((i3 & 3670016) == 0) {
                    i19 |= startRestartGroup.changed(cVar) ? 1048576 : 524288;
                }
                i37 = i18 & 128;
                if (i37 != 0) {
                    i19 |= 12582912;
                } else if ((i3 & 29360128) == 0) {
                    i19 |= startRestartGroup.changed(nVar) ? 8388608 : 4194304;
                }
                i38 = i18 & 256;
                if (i38 != 0) {
                    i19 |= 100663296;
                } else if ((i3 & 234881024) == 0) {
                    i19 |= startRestartGroup.changed(f17) ? 67108864 : 33554432;
                }
                i39 = i18 & 512;
                if (i39 != 0) {
                    i19 |= 805306368;
                } else if ((i3 & 1879048192) == 0) {
                    i19 |= startRestartGroup.changed(ajVar) ? 536870912 : 268435456;
                }
                i46 = i18 & 1024;
                if (i46 != 0) {
                    i47 = i16 | 6;
                } else if ((i16 & 14) == 0) {
                    i47 = i16 | (startRestartGroup.changed(aiVar) ? 4 : 2);
                } else {
                    i47 = i16;
                }
                i48 = i18 & 2048;
                if (i48 != 0) {
                    i47 |= 48;
                } else if ((i16 & 112) == 0) {
                    i47 |= startRestartGroup.changed(f18) ? 32 : 16;
                }
                int i96 = i47;
                i49 = i18 & 4096;
                if (i49 != 0) {
                    i96 |= MsgConstant.KRMFILETHUMBSIZE384;
                } else if ((i16 & 896) == 0) {
                    i96 |= startRestartGroup.changed(alVar) ? 256 : 128;
                    i56 = i18 & 8192;
                    if (i56 == 0) {
                        i96 |= 3072;
                        i57 = i56;
                    } else {
                        i57 = i56;
                        if ((i16 & 7168) == 0) {
                            i96 |= startRestartGroup.changed(f19) ? 2048 : 1024;
                            i58 = i18 & 16384;
                            if (i58 != 0) {
                                i96 |= 24576;
                            } else if ((i16 & 57344) == 0) {
                                i59 = i58;
                                i96 |= startRestartGroup.changed(f26) ? 16384 : 8192;
                                i65 = i18 & 32768;
                                if (i65 == 0) {
                                    i96 |= 196608;
                                } else if ((i16 & 458752) == 0) {
                                    i96 |= startRestartGroup.changed(shadow) ? 131072 : 65536;
                                }
                                i66 = i18 & 65536;
                                if (i66 == 0) {
                                    i96 |= 1572864;
                                } else if ((i16 & 3670016) == 0) {
                                    i96 |= startRestartGroup.changed(anVar) ? 1048576 : 524288;
                                }
                                i67 = i18 & 131072;
                                if (i67 == 0) {
                                    i96 |= 12582912;
                                } else if ((i16 & 29360128) == 0) {
                                    i96 |= startRestartGroup.changed(aoVar) ? 8388608 : 4194304;
                                }
                                i68 = i18 & 262144;
                                if (i68 == 0) {
                                    i96 |= 100663296;
                                } else if ((i16 & 234881024) == 0) {
                                    i96 |= startRestartGroup.changed(num) ? 67108864 : 33554432;
                                }
                                i69 = i18 & 524288;
                                if (i69 != 0) {
                                    i96 |= 268435456;
                                }
                                i75 = i18 & 1048576;
                                if (i75 == 0) {
                                    i76 = i17 | 6;
                                } else if ((i17 & 14) == 0) {
                                    i76 = i17 | (startRestartGroup.changed(function1) ? 4 : 2);
                                } else {
                                    i76 = i17;
                                }
                                i77 = i18 & 2097152;
                                if (i77 != 0) {
                                    i76 |= 16;
                                }
                                int i97 = i76;
                                i78 = i18 & 4194304;
                                if (i78 == 0) {
                                    i97 |= MsgConstant.KRMFILETHUMBSIZE384;
                                } else if ((i17 & 896) == 0) {
                                    i97 |= startRestartGroup.changed(f27) ? 256 : 128;
                                    i79 = i18 & 8388608;
                                    if (i79 != 0) {
                                        i97 |= 3072;
                                    } else if ((i17 & 7168) == 0) {
                                        i97 |= startRestartGroup.changed(str) ? 2048 : 1024;
                                        i85 = i18 & 16777216;
                                        if (i85 == 0) {
                                            i97 |= 24576;
                                        } else if ((i17 & 57344) == 0) {
                                            i97 |= startRestartGroup.changed(bool) ? 16384 : 8192;
                                        }
                                        i86 = i18 & 33554432;
                                        if (i86 == 0) {
                                            i97 |= 196608;
                                        } else if ((i17 & 458752) == 0) {
                                            i97 |= startRestartGroup.changed(function12) ? 131072 : 65536;
                                        }
                                        i87 = i18 & 67108864;
                                        if (i87 == 0) {
                                            i97 |= 1572864;
                                            function14 = function13;
                                        } else {
                                            function14 = function13;
                                            if ((i17 & 3670016) == 0) {
                                                i97 |= startRestartGroup.changed(function14) ? 1048576 : 524288;
                                            }
                                        }
                                        i88 = i18 & 134217728;
                                        if (i88 == 0) {
                                            i97 |= 12582912;
                                        } else if ((i17 & 29360128) == 0) {
                                            i97 |= startRestartGroup.changed(function22) ? 8388608 : 4194304;
                                        }
                                        if ((i18 & 2621448) != 2621448 && (1533916891 & i19) == 306783378 && (1533916891 & i96) == 306783378 && (23967451 & i97) == 4793490 && startRestartGroup.getSkipping()) {
                                            startRestartGroup.skipToGroupEnd();
                                            aVar2 = aVar;
                                            iVar2 = iVar;
                                            function24 = function2;
                                            hVar3 = hVar;
                                            f38 = f16;
                                            oVar3 = oVar;
                                            cVar3 = cVar;
                                            nVar3 = nVar;
                                            f46 = f17;
                                            ajVar3 = ajVar;
                                            aiVar2 = aiVar;
                                            f49 = f18;
                                            alVar3 = alVar;
                                            f39 = f19;
                                            shadow3 = shadow;
                                            anVar3 = anVar;
                                            aoVar3 = aoVar;
                                            num3 = num;
                                            map3 = map;
                                            function17 = function1;
                                            kVar3 = kVar;
                                            f47 = f27;
                                            str3 = str;
                                            bool3 = bool;
                                            function19 = function12;
                                            function25 = function22;
                                            function18 = function14;
                                            f48 = f26;
                                        } else {
                                            aVar2 = i89 == 0 ? null : aVar;
                                            com.tencent.ntcompose.core.i iVar3 = i95 == 0 ? com.tencent.ntcompose.core.i.INSTANCE : iVar;
                                            Function2<? super TextView, ? super com.tencent.kuikly.core.base.aa<TextView>, Unit> function26 = i26 == 0 ? null : function2;
                                            hVar2 = i27 == 0 ? null : hVar;
                                            Float f56 = i28 == 0 ? null : f16;
                                            oVar2 = i29 == 0 ? null : oVar;
                                            cVar2 = i36 == 0 ? null : cVar;
                                            n nVar4 = i37 == 0 ? null : nVar;
                                            Float f57 = i38 == 0 ? null : f17;
                                            aj ajVar4 = i39 == 0 ? null : ajVar;
                                            ai aiVar3 = i46 == 0 ? null : aiVar;
                                            Float f58 = i48 == 0 ? null : f18;
                                            al alVar4 = i49 == 0 ? null : alVar;
                                            f28 = i57 == 0 ? null : f19;
                                            f29 = i59 == 0 ? null : f26;
                                            shadow2 = i65 == 0 ? null : shadow;
                                            anVar2 = i66 == 0 ? null : anVar;
                                            aoVar2 = i67 == 0 ? null : aoVar;
                                            num2 = i68 == 0 ? null : num;
                                            map2 = i69 == 0 ? null : map;
                                            Float f59 = f57;
                                            final Function1<? super am, Unit> function110 = i75 == 0 ? null : function1;
                                            kVar2 = i77 == 0 ? null : kVar;
                                            f36 = i78 == 0 ? null : f27;
                                            str2 = i79 == 0 ? null : str;
                                            bool2 = i85 == 0 ? null : bool;
                                            function15 = i86 == 0 ? null : function12;
                                            if (i87 != 0) {
                                                function14 = null;
                                            }
                                            function23 = i88 == 0 ? null : function22;
                                            if (ComposerKt.isTraceInProgress()) {
                                                nVar2 = nVar4;
                                                ajVar2 = ajVar4;
                                            } else {
                                                nVar2 = nVar4;
                                                ajVar2 = ajVar4;
                                                ComposerKt.traceEventStart(-1460396667, i19, i96, "com.tencent.ntcompose.material.Text (RichText.kt:141)");
                                            }
                                            d16 = d(map2, aVar2);
                                            startRestartGroup.startReplaceableGroup(-492369756);
                                            rememberedValue = startRestartGroup.rememberedValue();
                                            companion = Composer.INSTANCE;
                                            ai aiVar4 = aiVar3;
                                            if (rememberedValue != companion.getEmpty()) {
                                                f37 = f58;
                                                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(com.tencent.kuikly.core.layout.d.INSTANCE.a(), null, 2, null);
                                                startRestartGroup.updateRememberedValue(rememberedValue);
                                            } else {
                                                f37 = f58;
                                            }
                                            startRestartGroup.endReplaceableGroup();
                                            final MutableState mutableState = (MutableState) rememberedValue;
                                            startRestartGroup.startReplaceableGroup(-1669861999);
                                            if (d16) {
                                                obj = function110;
                                            } else {
                                                startRestartGroup.startReplaceableGroup(511388516);
                                                boolean changed = startRestartGroup.changed(mutableState) | startRestartGroup.changed(function110);
                                                obj = startRestartGroup.rememberedValue();
                                                if (changed || obj == companion.getEmpty()) {
                                                    obj = new Function1<am, Unit>() { // from class: com.tencent.ntcompose.material.RichTextKt$Text$1$1
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Unit invoke(am amVar) {
                                                            invoke2(amVar);
                                                            return Unit.INSTANCE;
                                                        }

                                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                        public final void invoke2(am it) {
                                                            Intrinsics.checkNotNullParameter(it, "it");
                                                            mutableState.setValue(it.getFrame());
                                                            Function1<am, Unit> function111 = function110;
                                                            if (function111 != null) {
                                                                function111.invoke(it);
                                                            }
                                                        }
                                                    };
                                                    startRestartGroup.updateRememberedValue(obj);
                                                }
                                                startRestartGroup.endReplaceableGroup();
                                            }
                                            startRestartGroup.endReplaceableGroup();
                                            if (kVar2 != null || (r9 = kVar2.getColor()) == null) {
                                                com.tencent.kuikly.core.base.h hVar4 = hVar2;
                                            }
                                            Float valueOf = Float.valueOf((kVar2 != null || (fontSize = kVar2.getFontSize()) == null) ? f56 == null ? f56.floatValue() : 16.0f : fontSize.floatValue());
                                            if (kVar2 != null || (r37 = kVar2.getFontWeight()) == null) {
                                                bp3.c cVar4 = cVar2;
                                            }
                                            if (kVar2 != null || (r38 = kVar2.getFontStyle()) == null) {
                                                o oVar4 = oVar2;
                                            }
                                            if (kVar2 != null || (r39 = kVar2.getFontFamily()) == null) {
                                                n nVar5 = nVar2;
                                            }
                                            if (kVar2 != null || (r40 = kVar2.getCom.tencent.mtt.hippy.dom.node.NodeProps.LETTER_SPACING java.lang.String()) == null) {
                                                Float f65 = f59;
                                            }
                                            if (kVar2 != null || (r41 = kVar2.getCom.google.android.exoplayer2.text.ttml.TtmlNode.ATTR_TTS_TEXT_DECORATION java.lang.String()) == null) {
                                                aj ajVar5 = ajVar2;
                                            }
                                            if (kVar2 != null || (r42 = kVar2.getShadow()) == null) {
                                                Shadow shadow4 = shadow2;
                                            }
                                            if (kVar2 != null || (r43 = kVar2.getTextAlign()) == null) {
                                                ai aiVar5 = aiVar4;
                                            }
                                            if (kVar2 != null || (r44 = kVar2.getCom.tencent.mtt.hippy.dom.node.NodeProps.LINE_HEIGHT java.lang.String()) == null) {
                                                Float f66 = f37;
                                            }
                                            if (kVar2 != null) {
                                                kVar2.n();
                                            }
                                            if (kVar2 != null || (r45 = kVar2.getLineSpacing()) == null) {
                                                Float f67 = f28;
                                            }
                                            if (kVar2 != null || (r46 = kVar2.getStroke()) == null) {
                                                ao aoVar4 = aoVar2;
                                            }
                                            if (kVar2 != null || (r47 = kVar2.getParagraphSpacing()) == null) {
                                                Float f68 = f29;
                                            }
                                            bp3.k kVar4 = new bp3.k(hVar4, valueOf, cVar4, oVar4, nVar5, f65, ajVar5, shadow4, aiVar5, f66, alVar4, f67, aoVar4, f68, null);
                                            ArrayList arrayList = new ArrayList();
                                            Function1<? super am, Unit> function111 = function110;
                                            if (map2 != null) {
                                                arrayList.add(new com.tencent.ntcompose.core.k("inlineContent", map2, null, null, null, null, RichTextViewPropUpdater.f339353a, 60, null));
                                            }
                                            if (aVar2 != null) {
                                                arrayList.add(new com.tencent.ntcompose.core.k("text", aVar2, null, null, null, null, RichTextViewPropUpdater.f339353a, 60, null));
                                            }
                                            if (anVar2 == null) {
                                                alVar2 = alVar4;
                                                arrayList.add(new com.tencent.ntcompose.core.k("textOverflow", an.d(anVar2.getValue()), null, null, null, null, RichTextViewPropUpdater.f339353a, 60, null));
                                            } else {
                                                alVar2 = alVar4;
                                            }
                                            if (num2 != null) {
                                                arrayList.add(new com.tencent.ntcompose.core.k("maxLines", Integer.valueOf(num2.intValue()), null, null, null, null, RichTextViewPropUpdater.f339353a, 60, null));
                                            }
                                            function16 = (Function1) obj;
                                            if (function16 != null) {
                                                arrayList.add(new com.tencent.ntcompose.core.k("onTextLayout", function16, null, null, null, null, RichTextViewPropUpdater.f339353a, 60, null));
                                            }
                                            if (f36 != null) {
                                                arrayList.add(new com.tencent.ntcompose.core.k("lineBreakMargin", Float.valueOf(f36.floatValue()), null, null, null, null, RichTextViewPropUpdater.f339353a, 60, null));
                                            }
                                            if (function15 != null) {
                                                arrayList.add(new com.tencent.ntcompose.core.k("onLineBreakMargin", function15, null, null, null, null, RichTextViewPropUpdater.f339353a, 60, null));
                                            }
                                            if (function14 != null) {
                                                arrayList.add(new com.tencent.ntcompose.core.k("onTextWithLineBreak", function14, null, null, null, null, RichTextViewPropUpdater.f339353a, 60, null));
                                            }
                                            if (function23 != null) {
                                                arrayList.add(new com.tencent.ntcompose.core.k("onClickCallback", function23, null, null, null, null, RichTextViewPropUpdater.f339353a, 60, null));
                                            }
                                            RichTextViewPropUpdater richTextViewPropUpdater = RichTextViewPropUpdater.f339353a;
                                            arrayList.add(new com.tencent.ntcompose.core.k("textStyle", kVar4, null, null, null, null, richTextViewPropUpdater, 60, null));
                                            if (str2 != null) {
                                                arrayList.add(new com.tencent.ntcompose.core.k("textPostProcessor", str2, null, null, null, null, richTextViewPropUpdater, 60, null));
                                            }
                                            if (bool2 != null) {
                                                arrayList.add(new com.tencent.ntcompose.core.k("includePadding", Boolean.valueOf(bool2.booleanValue()), null, null, null, null, richTextViewPropUpdater, 60, null));
                                            }
                                            ComposeNodeKt.a("rich_text", com.tencent.ntcompose.material.base.a.f339408a, function26 != null ? null : function26, iVar3, arrayList, null, startRestartGroup, ((i19 << 6) & 7168) | 32822, 32);
                                            if (d16) {
                                                com.tencent.kuikly.core.layout.d dVar = (com.tencent.kuikly.core.layout.d) mutableState.getValue();
                                                startRestartGroup.startReplaceableGroup(-1931894862);
                                                List<a.Range<bp3.j>> c16 = aVar2 != null ? aVar2.c() : null;
                                                if (c16 != null) {
                                                    Iterator<T> it = c16.iterator();
                                                    while (it.hasNext()) {
                                                        a.Range range = (a.Range) it.next();
                                                        if ((range.b() instanceof bp3.i) && ((bp3.i) range.b()).getPlaceholder() != null && (placeholder = ((bp3.i) range.b()).getPlaceholder()) != null) {
                                                            startRestartGroup.startMovableGroup(1894776706, ((bp3.i) range.b()).getPlaceholderId());
                                                            startRestartGroup.startReplaceableGroup(-492369756);
                                                            Object rememberedValue2 = startRestartGroup.rememberedValue();
                                                            Composer.Companion companion2 = Composer.INSTANCE;
                                                            if (rememberedValue2 == companion2.getEmpty()) {
                                                                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(com.tencent.kuikly.core.layout.d.INSTANCE.a(), null, 2, null);
                                                                startRestartGroup.updateRememberedValue(rememberedValue2);
                                                            }
                                                            startRestartGroup.endReplaceableGroup();
                                                            final MutableState mutableState2 = (MutableState) rememberedValue2;
                                                            bg placeholderSpan = ((bp3.i) range.b()).getPlaceholderSpan();
                                                            if (placeholderSpan != null) {
                                                                startRestartGroup.startReplaceableGroup(1157296644);
                                                                boolean changed2 = startRestartGroup.changed(mutableState2);
                                                                Object rememberedValue3 = startRestartGroup.rememberedValue();
                                                                if (changed2 || rememberedValue3 == companion2.getEmpty()) {
                                                                    rememberedValue3 = new Function1<com.tencent.kuikly.core.layout.d, Unit>() { // from class: com.tencent.ntcompose.material.RichTextKt$InsertPlaceholderSpan$1$1$1$1$1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.layout.d dVar2) {
                                                                            invoke2(dVar2);
                                                                            return Unit.INSTANCE;
                                                                        }

                                                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                        public final void invoke2(com.tencent.kuikly.core.layout.d it5) {
                                                                            Intrinsics.checkNotNullParameter(it5, "it");
                                                                            mutableState2.setValue(it5);
                                                                        }
                                                                    };
                                                                    startRestartGroup.updateRememberedValue(rememberedValue3);
                                                                }
                                                                startRestartGroup.endReplaceableGroup();
                                                                placeholderSpan.k((Function1) rememberedValue3);
                                                            }
                                                            ModifiersKt.Q(com.tencent.ntcompose.core.i.INSTANCE, new com.tencent.kuikly.core.base.y(0.0f, 0.0f, ((com.tencent.kuikly.core.layout.d) mutableState2.getValue()).getX() + dVar.getX(), ((com.tencent.kuikly.core.layout.d) mutableState2.getValue()).getY() + dVar.getY()), null, 2, null);
                                                            placeholder.a();
                                                            throw null;
                                                        }
                                                    }
                                                    Unit unit = Unit.INSTANCE;
                                                }
                                                startRestartGroup.endReplaceableGroup();
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            iVar2 = iVar3;
                                            function24 = function26;
                                            hVar3 = hVar2;
                                            f38 = f56;
                                            oVar3 = oVar2;
                                            cVar3 = cVar2;
                                            nVar3 = nVar2;
                                            f39 = f28;
                                            anVar3 = anVar2;
                                            aoVar3 = aoVar2;
                                            f46 = f59;
                                            f47 = f36;
                                            ajVar3 = ajVar2;
                                            aiVar2 = aiVar4;
                                            function17 = function111;
                                            alVar3 = alVar2;
                                            function18 = function14;
                                            function19 = function15;
                                            f48 = f29;
                                            num3 = num2;
                                            str3 = str2;
                                            function25 = function23;
                                            shadow3 = shadow2;
                                            map3 = map2;
                                            bool3 = bool2;
                                            kVar3 = kVar2;
                                            f49 = f37;
                                        }
                                        endRestartGroup = startRestartGroup.endRestartGroup();
                                        if (endRestartGroup != null) {
                                            return;
                                        }
                                        final Float f69 = f48;
                                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>(iVar2, function24, hVar3, f38, oVar3, cVar3, nVar3, f46, ajVar3, aiVar2, f49, alVar3, f39, f69, shadow3, anVar3, aoVar3, num3, map3, function17, kVar3, f47, str3, bool3, function19, function18, function25, i3, i16, i17, i18) { // from class: com.tencent.ntcompose.material.RichTextKt$Text$2
                                            final /* synthetic */ int $$changed;
                                            final /* synthetic */ int $$changed1;
                                            final /* synthetic */ int $$changed2;
                                            final /* synthetic */ int $$default;
                                            final /* synthetic */ com.tencent.kuikly.core.base.h $color;
                                            final /* synthetic */ n $fontFamily;
                                            final /* synthetic */ Float $fontSize;
                                            final /* synthetic */ o $fontStyle;
                                            final /* synthetic */ bp3.c $fontWeight;
                                            final /* synthetic */ Boolean $includePadding;
                                            final /* synthetic */ Map<String, bp3.d> $inlineContent;
                                            final /* synthetic */ Float $letterSpacing;
                                            final /* synthetic */ Float $lineBreakMargin;
                                            final /* synthetic */ Float $lineHeight;
                                            final /* synthetic */ Float $lineSpacing;
                                            final /* synthetic */ Integer $maxLines;
                                            final /* synthetic */ com.tencent.ntcompose.core.i $modifier;
                                            final /* synthetic */ Function2<Integer, ClickParams, Unit> $onClick;
                                            final /* synthetic */ Function1<Object, Unit> $onLineBreakMargin;
                                            final /* synthetic */ Function1<am, Unit> $onTextLayout;
                                            final /* synthetic */ Function1<ch, Unit> $onTextWithLineBreak;
                                            final /* synthetic */ an $overflow;
                                            final /* synthetic */ Float $paragraphSpacing;
                                            final /* synthetic */ Function2<TextView, com.tencent.kuikly.core.base.aa<TextView>, Unit> $ref;
                                            final /* synthetic */ Shadow $shadow;
                                            final /* synthetic */ ao $stroke;
                                            final /* synthetic */ bp3.k $style;
                                            final /* synthetic */ ai $textAlign;
                                            final /* synthetic */ aj $textDecoration;
                                            final /* synthetic */ al $textIndent;
                                            final /* synthetic */ String $textPostProcessor;

                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                                this.$lineSpacing = f39;
                                                this.$paragraphSpacing = f69;
                                                this.$shadow = shadow3;
                                                this.$overflow = anVar3;
                                                this.$stroke = aoVar3;
                                                this.$maxLines = num3;
                                                this.$inlineContent = map3;
                                                this.$onTextLayout = function17;
                                                this.$style = kVar3;
                                                this.$lineBreakMargin = f47;
                                                this.$textPostProcessor = str3;
                                                this.$includePadding = bool3;
                                                this.$onLineBreakMargin = function19;
                                                this.$onTextWithLineBreak = function18;
                                                this.$onClick = function25;
                                                this.$$changed = i3;
                                                this.$$changed1 = i16;
                                                this.$$changed2 = i17;
                                                this.$$default = i18;
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num4) {
                                                invoke(composer2, num4.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer2, int i98) {
                                                RichTextKt.b(bp3.a.this, this.$modifier, this.$ref, this.$color, this.$fontSize, this.$fontStyle, this.$fontWeight, this.$fontFamily, this.$letterSpacing, this.$textDecoration, this.$textAlign, this.$lineHeight, null, this.$lineSpacing, this.$paragraphSpacing, this.$shadow, this.$overflow, this.$stroke, this.$maxLines, this.$inlineContent, this.$onTextLayout, this.$style, this.$lineBreakMargin, this.$textPostProcessor, this.$includePadding, this.$onLineBreakMargin, this.$onTextWithLineBreak, this.$onClick, composer2, this.$$changed | 1, this.$$changed1, this.$$changed2, this.$$default);
                                            }
                                        });
                                        return;
                                    }
                                    i85 = i18 & 16777216;
                                    if (i85 == 0) {
                                    }
                                    i86 = i18 & 33554432;
                                    if (i86 == 0) {
                                    }
                                    i87 = i18 & 67108864;
                                    if (i87 == 0) {
                                    }
                                    i88 = i18 & 134217728;
                                    if (i88 == 0) {
                                    }
                                    if ((i18 & 2621448) != 2621448) {
                                    }
                                    if (i89 == 0) {
                                    }
                                    if (i95 == 0) {
                                    }
                                    if (i26 == 0) {
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
                                    Float f592 = f57;
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
                                    if (i87 != 0) {
                                    }
                                    if (i88 == 0) {
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    d16 = d(map2, aVar2);
                                    startRestartGroup.startReplaceableGroup(-492369756);
                                    rememberedValue = startRestartGroup.rememberedValue();
                                    companion = Composer.INSTANCE;
                                    ai aiVar42 = aiVar3;
                                    if (rememberedValue != companion.getEmpty()) {
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    final MutableState<com.tencent.kuikly.core.layout.d> mutableState3 = (MutableState) rememberedValue;
                                    startRestartGroup.startReplaceableGroup(-1669861999);
                                    if (d16) {
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    if (kVar2 != null) {
                                    }
                                    com.tencent.kuikly.core.base.h hVar42 = hVar2;
                                    Float valueOf2 = Float.valueOf((kVar2 != null || (fontSize = kVar2.getFontSize()) == null) ? f56 == null ? f56.floatValue() : 16.0f : fontSize.floatValue());
                                    if (kVar2 != null) {
                                    }
                                    bp3.c cVar42 = cVar2;
                                    if (kVar2 != null) {
                                    }
                                    o oVar42 = oVar2;
                                    if (kVar2 != null) {
                                    }
                                    n nVar52 = nVar2;
                                    if (kVar2 != null) {
                                    }
                                    Float f652 = f592;
                                    if (kVar2 != null) {
                                    }
                                    aj ajVar52 = ajVar2;
                                    if (kVar2 != null) {
                                    }
                                    Shadow shadow42 = shadow2;
                                    if (kVar2 != null) {
                                    }
                                    ai aiVar52 = aiVar42;
                                    if (kVar2 != null) {
                                    }
                                    Float f662 = f37;
                                    if (kVar2 != null) {
                                    }
                                    if (kVar2 != null) {
                                    }
                                    Float f672 = f28;
                                    if (kVar2 != null) {
                                    }
                                    ao aoVar42 = aoVar2;
                                    if (kVar2 != null) {
                                    }
                                    Float f682 = f29;
                                    bp3.k kVar42 = new bp3.k(hVar42, valueOf2, cVar42, oVar42, nVar52, f652, ajVar52, shadow42, aiVar52, f662, alVar4, f672, aoVar42, f682, null);
                                    ArrayList arrayList2 = new ArrayList();
                                    Function1<? super am, Unit> function1112 = function110;
                                    if (map2 != null) {
                                    }
                                    if (aVar2 != null) {
                                    }
                                    if (anVar2 == null) {
                                    }
                                    if (num2 != null) {
                                    }
                                    function16 = (Function1) obj;
                                    if (function16 != null) {
                                    }
                                    if (f36 != null) {
                                    }
                                    if (function15 != null) {
                                    }
                                    if (function14 != null) {
                                    }
                                    if (function23 != null) {
                                    }
                                    RichTextViewPropUpdater richTextViewPropUpdater2 = RichTextViewPropUpdater.f339353a;
                                    arrayList2.add(new com.tencent.ntcompose.core.k("textStyle", kVar42, null, null, null, null, richTextViewPropUpdater2, 60, null));
                                    if (str2 != null) {
                                    }
                                    if (bool2 != null) {
                                    }
                                    ComposeNodeKt.a("rich_text", com.tencent.ntcompose.material.base.a.f339408a, function26 != null ? null : function26, iVar3, arrayList2, null, startRestartGroup, ((i19 << 6) & 7168) | 32822, 32);
                                    if (d16) {
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    iVar2 = iVar3;
                                    function24 = function26;
                                    hVar3 = hVar2;
                                    f38 = f56;
                                    oVar3 = oVar2;
                                    cVar3 = cVar2;
                                    nVar3 = nVar2;
                                    f39 = f28;
                                    anVar3 = anVar2;
                                    aoVar3 = aoVar2;
                                    f46 = f592;
                                    f47 = f36;
                                    ajVar3 = ajVar2;
                                    aiVar2 = aiVar42;
                                    function17 = function1112;
                                    alVar3 = alVar2;
                                    function18 = function14;
                                    function19 = function15;
                                    f48 = f29;
                                    num3 = num2;
                                    str3 = str2;
                                    function25 = function23;
                                    shadow3 = shadow2;
                                    map3 = map2;
                                    bool3 = bool2;
                                    kVar3 = kVar2;
                                    f49 = f37;
                                    endRestartGroup = startRestartGroup.endRestartGroup();
                                    if (endRestartGroup != null) {
                                    }
                                }
                                i79 = i18 & 8388608;
                                if (i79 != 0) {
                                }
                                i85 = i18 & 16777216;
                                if (i85 == 0) {
                                }
                                i86 = i18 & 33554432;
                                if (i86 == 0) {
                                }
                                i87 = i18 & 67108864;
                                if (i87 == 0) {
                                }
                                i88 = i18 & 134217728;
                                if (i88 == 0) {
                                }
                                if ((i18 & 2621448) != 2621448) {
                                }
                                if (i89 == 0) {
                                }
                                if (i95 == 0) {
                                }
                                if (i26 == 0) {
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
                                Float f5922 = f57;
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
                                if (i87 != 0) {
                                }
                                if (i88 == 0) {
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                d16 = d(map2, aVar2);
                                startRestartGroup.startReplaceableGroup(-492369756);
                                rememberedValue = startRestartGroup.rememberedValue();
                                companion = Composer.INSTANCE;
                                ai aiVar422 = aiVar3;
                                if (rememberedValue != companion.getEmpty()) {
                                }
                                startRestartGroup.endReplaceableGroup();
                                final MutableState<com.tencent.kuikly.core.layout.d> mutableState32 = (MutableState) rememberedValue;
                                startRestartGroup.startReplaceableGroup(-1669861999);
                                if (d16) {
                                }
                                startRestartGroup.endReplaceableGroup();
                                if (kVar2 != null) {
                                }
                                com.tencent.kuikly.core.base.h hVar422 = hVar2;
                                Float valueOf22 = Float.valueOf((kVar2 != null || (fontSize = kVar2.getFontSize()) == null) ? f56 == null ? f56.floatValue() : 16.0f : fontSize.floatValue());
                                if (kVar2 != null) {
                                }
                                bp3.c cVar422 = cVar2;
                                if (kVar2 != null) {
                                }
                                o oVar422 = oVar2;
                                if (kVar2 != null) {
                                }
                                n nVar522 = nVar2;
                                if (kVar2 != null) {
                                }
                                Float f6522 = f5922;
                                if (kVar2 != null) {
                                }
                                aj ajVar522 = ajVar2;
                                if (kVar2 != null) {
                                }
                                Shadow shadow422 = shadow2;
                                if (kVar2 != null) {
                                }
                                ai aiVar522 = aiVar422;
                                if (kVar2 != null) {
                                }
                                Float f6622 = f37;
                                if (kVar2 != null) {
                                }
                                if (kVar2 != null) {
                                }
                                Float f6722 = f28;
                                if (kVar2 != null) {
                                }
                                ao aoVar422 = aoVar2;
                                if (kVar2 != null) {
                                }
                                Float f6822 = f29;
                                bp3.k kVar422 = new bp3.k(hVar422, valueOf22, cVar422, oVar422, nVar522, f6522, ajVar522, shadow422, aiVar522, f6622, alVar4, f6722, aoVar422, f6822, null);
                                ArrayList arrayList22 = new ArrayList();
                                Function1<? super am, Unit> function11122 = function110;
                                if (map2 != null) {
                                }
                                if (aVar2 != null) {
                                }
                                if (anVar2 == null) {
                                }
                                if (num2 != null) {
                                }
                                function16 = (Function1) obj;
                                if (function16 != null) {
                                }
                                if (f36 != null) {
                                }
                                if (function15 != null) {
                                }
                                if (function14 != null) {
                                }
                                if (function23 != null) {
                                }
                                RichTextViewPropUpdater richTextViewPropUpdater22 = RichTextViewPropUpdater.f339353a;
                                arrayList22.add(new com.tencent.ntcompose.core.k("textStyle", kVar422, null, null, null, null, richTextViewPropUpdater22, 60, null));
                                if (str2 != null) {
                                }
                                if (bool2 != null) {
                                }
                                ComposeNodeKt.a("rich_text", com.tencent.ntcompose.material.base.a.f339408a, function26 != null ? null : function26, iVar3, arrayList22, null, startRestartGroup, ((i19 << 6) & 7168) | 32822, 32);
                                if (d16) {
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                iVar2 = iVar3;
                                function24 = function26;
                                hVar3 = hVar2;
                                f38 = f56;
                                oVar3 = oVar2;
                                cVar3 = cVar2;
                                nVar3 = nVar2;
                                f39 = f28;
                                anVar3 = anVar2;
                                aoVar3 = aoVar2;
                                f46 = f5922;
                                f47 = f36;
                                ajVar3 = ajVar2;
                                aiVar2 = aiVar422;
                                function17 = function11122;
                                alVar3 = alVar2;
                                function18 = function14;
                                function19 = function15;
                                f48 = f29;
                                num3 = num2;
                                str3 = str2;
                                function25 = function23;
                                shadow3 = shadow2;
                                map3 = map2;
                                bool3 = bool2;
                                kVar3 = kVar2;
                                f49 = f37;
                                endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup != null) {
                                }
                            }
                            i59 = i58;
                            i65 = i18 & 32768;
                            if (i65 == 0) {
                            }
                            i66 = i18 & 65536;
                            if (i66 == 0) {
                            }
                            i67 = i18 & 131072;
                            if (i67 == 0) {
                            }
                            i68 = i18 & 262144;
                            if (i68 == 0) {
                            }
                            i69 = i18 & 524288;
                            if (i69 != 0) {
                            }
                            i75 = i18 & 1048576;
                            if (i75 == 0) {
                            }
                            i77 = i18 & 2097152;
                            if (i77 != 0) {
                            }
                            int i972 = i76;
                            i78 = i18 & 4194304;
                            if (i78 == 0) {
                            }
                            i79 = i18 & 8388608;
                            if (i79 != 0) {
                            }
                            i85 = i18 & 16777216;
                            if (i85 == 0) {
                            }
                            i86 = i18 & 33554432;
                            if (i86 == 0) {
                            }
                            i87 = i18 & 67108864;
                            if (i87 == 0) {
                            }
                            i88 = i18 & 134217728;
                            if (i88 == 0) {
                            }
                            if ((i18 & 2621448) != 2621448) {
                            }
                            if (i89 == 0) {
                            }
                            if (i95 == 0) {
                            }
                            if (i26 == 0) {
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
                            Float f59222 = f57;
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
                            if (i87 != 0) {
                            }
                            if (i88 == 0) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            d16 = d(map2, aVar2);
                            startRestartGroup.startReplaceableGroup(-492369756);
                            rememberedValue = startRestartGroup.rememberedValue();
                            companion = Composer.INSTANCE;
                            ai aiVar4222 = aiVar3;
                            if (rememberedValue != companion.getEmpty()) {
                            }
                            startRestartGroup.endReplaceableGroup();
                            final MutableState<com.tencent.kuikly.core.layout.d> mutableState322 = (MutableState) rememberedValue;
                            startRestartGroup.startReplaceableGroup(-1669861999);
                            if (d16) {
                            }
                            startRestartGroup.endReplaceableGroup();
                            if (kVar2 != null) {
                            }
                            com.tencent.kuikly.core.base.h hVar4222 = hVar2;
                            Float valueOf222 = Float.valueOf((kVar2 != null || (fontSize = kVar2.getFontSize()) == null) ? f56 == null ? f56.floatValue() : 16.0f : fontSize.floatValue());
                            if (kVar2 != null) {
                            }
                            bp3.c cVar4222 = cVar2;
                            if (kVar2 != null) {
                            }
                            o oVar4222 = oVar2;
                            if (kVar2 != null) {
                            }
                            n nVar5222 = nVar2;
                            if (kVar2 != null) {
                            }
                            Float f65222 = f59222;
                            if (kVar2 != null) {
                            }
                            aj ajVar5222 = ajVar2;
                            if (kVar2 != null) {
                            }
                            Shadow shadow4222 = shadow2;
                            if (kVar2 != null) {
                            }
                            ai aiVar5222 = aiVar4222;
                            if (kVar2 != null) {
                            }
                            Float f66222 = f37;
                            if (kVar2 != null) {
                            }
                            if (kVar2 != null) {
                            }
                            Float f67222 = f28;
                            if (kVar2 != null) {
                            }
                            ao aoVar4222 = aoVar2;
                            if (kVar2 != null) {
                            }
                            Float f68222 = f29;
                            bp3.k kVar4222 = new bp3.k(hVar4222, valueOf222, cVar4222, oVar4222, nVar5222, f65222, ajVar5222, shadow4222, aiVar5222, f66222, alVar4, f67222, aoVar4222, f68222, null);
                            ArrayList arrayList222 = new ArrayList();
                            Function1<? super am, Unit> function111222 = function110;
                            if (map2 != null) {
                            }
                            if (aVar2 != null) {
                            }
                            if (anVar2 == null) {
                            }
                            if (num2 != null) {
                            }
                            function16 = (Function1) obj;
                            if (function16 != null) {
                            }
                            if (f36 != null) {
                            }
                            if (function15 != null) {
                            }
                            if (function14 != null) {
                            }
                            if (function23 != null) {
                            }
                            RichTextViewPropUpdater richTextViewPropUpdater222 = RichTextViewPropUpdater.f339353a;
                            arrayList222.add(new com.tencent.ntcompose.core.k("textStyle", kVar4222, null, null, null, null, richTextViewPropUpdater222, 60, null));
                            if (str2 != null) {
                            }
                            if (bool2 != null) {
                            }
                            ComposeNodeKt.a("rich_text", com.tencent.ntcompose.material.base.a.f339408a, function26 != null ? null : function26, iVar3, arrayList222, null, startRestartGroup, ((i19 << 6) & 7168) | 32822, 32);
                            if (d16) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            iVar2 = iVar3;
                            function24 = function26;
                            hVar3 = hVar2;
                            f38 = f56;
                            oVar3 = oVar2;
                            cVar3 = cVar2;
                            nVar3 = nVar2;
                            f39 = f28;
                            anVar3 = anVar2;
                            aoVar3 = aoVar2;
                            f46 = f59222;
                            f47 = f36;
                            ajVar3 = ajVar2;
                            aiVar2 = aiVar4222;
                            function17 = function111222;
                            alVar3 = alVar2;
                            function18 = function14;
                            function19 = function15;
                            f48 = f29;
                            num3 = num2;
                            str3 = str2;
                            function25 = function23;
                            shadow3 = shadow2;
                            map3 = map2;
                            bool3 = bool2;
                            kVar3 = kVar2;
                            f49 = f37;
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                    }
                    i58 = i18 & 16384;
                    if (i58 != 0) {
                    }
                    i59 = i58;
                    i65 = i18 & 32768;
                    if (i65 == 0) {
                    }
                    i66 = i18 & 65536;
                    if (i66 == 0) {
                    }
                    i67 = i18 & 131072;
                    if (i67 == 0) {
                    }
                    i68 = i18 & 262144;
                    if (i68 == 0) {
                    }
                    i69 = i18 & 524288;
                    if (i69 != 0) {
                    }
                    i75 = i18 & 1048576;
                    if (i75 == 0) {
                    }
                    i77 = i18 & 2097152;
                    if (i77 != 0) {
                    }
                    int i9722 = i76;
                    i78 = i18 & 4194304;
                    if (i78 == 0) {
                    }
                    i79 = i18 & 8388608;
                    if (i79 != 0) {
                    }
                    i85 = i18 & 16777216;
                    if (i85 == 0) {
                    }
                    i86 = i18 & 33554432;
                    if (i86 == 0) {
                    }
                    i87 = i18 & 67108864;
                    if (i87 == 0) {
                    }
                    i88 = i18 & 134217728;
                    if (i88 == 0) {
                    }
                    if ((i18 & 2621448) != 2621448) {
                    }
                    if (i89 == 0) {
                    }
                    if (i95 == 0) {
                    }
                    if (i26 == 0) {
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
                    Float f592222 = f57;
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
                    if (i87 != 0) {
                    }
                    if (i88 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    d16 = d(map2, aVar2);
                    startRestartGroup.startReplaceableGroup(-492369756);
                    rememberedValue = startRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    ai aiVar42222 = aiVar3;
                    if (rememberedValue != companion.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    final MutableState<com.tencent.kuikly.core.layout.d> mutableState3222 = (MutableState) rememberedValue;
                    startRestartGroup.startReplaceableGroup(-1669861999);
                    if (d16) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    if (kVar2 != null) {
                    }
                    com.tencent.kuikly.core.base.h hVar42222 = hVar2;
                    Float valueOf2222 = Float.valueOf((kVar2 != null || (fontSize = kVar2.getFontSize()) == null) ? f56 == null ? f56.floatValue() : 16.0f : fontSize.floatValue());
                    if (kVar2 != null) {
                    }
                    bp3.c cVar42222 = cVar2;
                    if (kVar2 != null) {
                    }
                    o oVar42222 = oVar2;
                    if (kVar2 != null) {
                    }
                    n nVar52222 = nVar2;
                    if (kVar2 != null) {
                    }
                    Float f652222 = f592222;
                    if (kVar2 != null) {
                    }
                    aj ajVar52222 = ajVar2;
                    if (kVar2 != null) {
                    }
                    Shadow shadow42222 = shadow2;
                    if (kVar2 != null) {
                    }
                    ai aiVar52222 = aiVar42222;
                    if (kVar2 != null) {
                    }
                    Float f662222 = f37;
                    if (kVar2 != null) {
                    }
                    if (kVar2 != null) {
                    }
                    Float f672222 = f28;
                    if (kVar2 != null) {
                    }
                    ao aoVar42222 = aoVar2;
                    if (kVar2 != null) {
                    }
                    Float f682222 = f29;
                    bp3.k kVar42222 = new bp3.k(hVar42222, valueOf2222, cVar42222, oVar42222, nVar52222, f652222, ajVar52222, shadow42222, aiVar52222, f662222, alVar4, f672222, aoVar42222, f682222, null);
                    ArrayList arrayList2222 = new ArrayList();
                    Function1<? super am, Unit> function1112222 = function110;
                    if (map2 != null) {
                    }
                    if (aVar2 != null) {
                    }
                    if (anVar2 == null) {
                    }
                    if (num2 != null) {
                    }
                    function16 = (Function1) obj;
                    if (function16 != null) {
                    }
                    if (f36 != null) {
                    }
                    if (function15 != null) {
                    }
                    if (function14 != null) {
                    }
                    if (function23 != null) {
                    }
                    RichTextViewPropUpdater richTextViewPropUpdater2222 = RichTextViewPropUpdater.f339353a;
                    arrayList2222.add(new com.tencent.ntcompose.core.k("textStyle", kVar42222, null, null, null, null, richTextViewPropUpdater2222, 60, null));
                    if (str2 != null) {
                    }
                    if (bool2 != null) {
                    }
                    ComposeNodeKt.a("rich_text", com.tencent.ntcompose.material.base.a.f339408a, function26 != null ? null : function26, iVar3, arrayList2222, null, startRestartGroup, ((i19 << 6) & 7168) | 32822, 32);
                    if (d16) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    iVar2 = iVar3;
                    function24 = function26;
                    hVar3 = hVar2;
                    f38 = f56;
                    oVar3 = oVar2;
                    cVar3 = cVar2;
                    nVar3 = nVar2;
                    f39 = f28;
                    anVar3 = anVar2;
                    aoVar3 = aoVar2;
                    f46 = f592222;
                    f47 = f36;
                    ajVar3 = ajVar2;
                    aiVar2 = aiVar42222;
                    function17 = function1112222;
                    alVar3 = alVar2;
                    function18 = function14;
                    function19 = function15;
                    f48 = f29;
                    num3 = num2;
                    str3 = str2;
                    function25 = function23;
                    shadow3 = shadow2;
                    map3 = map2;
                    bool3 = bool2;
                    kVar3 = kVar2;
                    f49 = f37;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i56 = i18 & 8192;
                if (i56 == 0) {
                }
                i58 = i18 & 16384;
                if (i58 != 0) {
                }
                i59 = i58;
                i65 = i18 & 32768;
                if (i65 == 0) {
                }
                i66 = i18 & 65536;
                if (i66 == 0) {
                }
                i67 = i18 & 131072;
                if (i67 == 0) {
                }
                i68 = i18 & 262144;
                if (i68 == 0) {
                }
                i69 = i18 & 524288;
                if (i69 != 0) {
                }
                i75 = i18 & 1048576;
                if (i75 == 0) {
                }
                i77 = i18 & 2097152;
                if (i77 != 0) {
                }
                int i97222 = i76;
                i78 = i18 & 4194304;
                if (i78 == 0) {
                }
                i79 = i18 & 8388608;
                if (i79 != 0) {
                }
                i85 = i18 & 16777216;
                if (i85 == 0) {
                }
                i86 = i18 & 33554432;
                if (i86 == 0) {
                }
                i87 = i18 & 67108864;
                if (i87 == 0) {
                }
                i88 = i18 & 134217728;
                if (i88 == 0) {
                }
                if ((i18 & 2621448) != 2621448) {
                }
                if (i89 == 0) {
                }
                if (i95 == 0) {
                }
                if (i26 == 0) {
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
                Float f5922222 = f57;
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
                if (i87 != 0) {
                }
                if (i88 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                d16 = d(map2, aVar2);
                startRestartGroup.startReplaceableGroup(-492369756);
                rememberedValue = startRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                ai aiVar422222 = aiVar3;
                if (rememberedValue != companion.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                final MutableState<com.tencent.kuikly.core.layout.d> mutableState32222 = (MutableState) rememberedValue;
                startRestartGroup.startReplaceableGroup(-1669861999);
                if (d16) {
                }
                startRestartGroup.endReplaceableGroup();
                if (kVar2 != null) {
                }
                com.tencent.kuikly.core.base.h hVar422222 = hVar2;
                Float valueOf22222 = Float.valueOf((kVar2 != null || (fontSize = kVar2.getFontSize()) == null) ? f56 == null ? f56.floatValue() : 16.0f : fontSize.floatValue());
                if (kVar2 != null) {
                }
                bp3.c cVar422222 = cVar2;
                if (kVar2 != null) {
                }
                o oVar422222 = oVar2;
                if (kVar2 != null) {
                }
                n nVar522222 = nVar2;
                if (kVar2 != null) {
                }
                Float f6522222 = f5922222;
                if (kVar2 != null) {
                }
                aj ajVar522222 = ajVar2;
                if (kVar2 != null) {
                }
                Shadow shadow422222 = shadow2;
                if (kVar2 != null) {
                }
                ai aiVar522222 = aiVar422222;
                if (kVar2 != null) {
                }
                Float f6622222 = f37;
                if (kVar2 != null) {
                }
                if (kVar2 != null) {
                }
                Float f6722222 = f28;
                if (kVar2 != null) {
                }
                ao aoVar422222 = aoVar2;
                if (kVar2 != null) {
                }
                Float f6822222 = f29;
                bp3.k kVar422222 = new bp3.k(hVar422222, valueOf22222, cVar422222, oVar422222, nVar522222, f6522222, ajVar522222, shadow422222, aiVar522222, f6622222, alVar4, f6722222, aoVar422222, f6822222, null);
                ArrayList arrayList22222 = new ArrayList();
                Function1<? super am, Unit> function11122222 = function110;
                if (map2 != null) {
                }
                if (aVar2 != null) {
                }
                if (anVar2 == null) {
                }
                if (num2 != null) {
                }
                function16 = (Function1) obj;
                if (function16 != null) {
                }
                if (f36 != null) {
                }
                if (function15 != null) {
                }
                if (function14 != null) {
                }
                if (function23 != null) {
                }
                RichTextViewPropUpdater richTextViewPropUpdater22222 = RichTextViewPropUpdater.f339353a;
                arrayList22222.add(new com.tencent.ntcompose.core.k("textStyle", kVar422222, null, null, null, null, richTextViewPropUpdater22222, 60, null));
                if (str2 != null) {
                }
                if (bool2 != null) {
                }
                ComposeNodeKt.a("rich_text", com.tencent.ntcompose.material.base.a.f339408a, function26 != null ? null : function26, iVar3, arrayList22222, null, startRestartGroup, ((i19 << 6) & 7168) | 32822, 32);
                if (d16) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                iVar2 = iVar3;
                function24 = function26;
                hVar3 = hVar2;
                f38 = f56;
                oVar3 = oVar2;
                cVar3 = cVar2;
                nVar3 = nVar2;
                f39 = f28;
                anVar3 = anVar2;
                aoVar3 = aoVar2;
                f46 = f5922222;
                f47 = f36;
                ajVar3 = ajVar2;
                aiVar2 = aiVar422222;
                function17 = function11122222;
                alVar3 = alVar2;
                function18 = function14;
                function19 = function15;
                f48 = f29;
                num3 = num2;
                str3 = str2;
                function25 = function23;
                shadow3 = shadow2;
                map3 = map2;
                bool3 = bool2;
                kVar3 = kVar2;
                f49 = f37;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i27 = i18 & 8;
            if (i27 != 0) {
            }
            i28 = i18 & 16;
            if (i28 != 0) {
            }
            i29 = i18 & 32;
            if (i29 != 0) {
            }
            i36 = i18 & 64;
            if (i36 != 0) {
            }
            i37 = i18 & 128;
            if (i37 != 0) {
            }
            i38 = i18 & 256;
            if (i38 != 0) {
            }
            i39 = i18 & 512;
            if (i39 != 0) {
            }
            i46 = i18 & 1024;
            if (i46 != 0) {
            }
            i48 = i18 & 2048;
            if (i48 != 0) {
            }
            int i962 = i47;
            i49 = i18 & 4096;
            if (i49 != 0) {
            }
            i56 = i18 & 8192;
            if (i56 == 0) {
            }
            i58 = i18 & 16384;
            if (i58 != 0) {
            }
            i59 = i58;
            i65 = i18 & 32768;
            if (i65 == 0) {
            }
            i66 = i18 & 65536;
            if (i66 == 0) {
            }
            i67 = i18 & 131072;
            if (i67 == 0) {
            }
            i68 = i18 & 262144;
            if (i68 == 0) {
            }
            i69 = i18 & 524288;
            if (i69 != 0) {
            }
            i75 = i18 & 1048576;
            if (i75 == 0) {
            }
            i77 = i18 & 2097152;
            if (i77 != 0) {
            }
            int i972222 = i76;
            i78 = i18 & 4194304;
            if (i78 == 0) {
            }
            i79 = i18 & 8388608;
            if (i79 != 0) {
            }
            i85 = i18 & 16777216;
            if (i85 == 0) {
            }
            i86 = i18 & 33554432;
            if (i86 == 0) {
            }
            i87 = i18 & 67108864;
            if (i87 == 0) {
            }
            i88 = i18 & 134217728;
            if (i88 == 0) {
            }
            if ((i18 & 2621448) != 2621448) {
            }
            if (i89 == 0) {
            }
            if (i95 == 0) {
            }
            if (i26 == 0) {
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
            Float f59222222 = f57;
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
            if (i87 != 0) {
            }
            if (i88 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            d16 = d(map2, aVar2);
            startRestartGroup.startReplaceableGroup(-492369756);
            rememberedValue = startRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            ai aiVar4222222 = aiVar3;
            if (rememberedValue != companion.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState<com.tencent.kuikly.core.layout.d> mutableState322222 = (MutableState) rememberedValue;
            startRestartGroup.startReplaceableGroup(-1669861999);
            if (d16) {
            }
            startRestartGroup.endReplaceableGroup();
            if (kVar2 != null) {
            }
            com.tencent.kuikly.core.base.h hVar4222222 = hVar2;
            Float valueOf222222 = Float.valueOf((kVar2 != null || (fontSize = kVar2.getFontSize()) == null) ? f56 == null ? f56.floatValue() : 16.0f : fontSize.floatValue());
            if (kVar2 != null) {
            }
            bp3.c cVar4222222 = cVar2;
            if (kVar2 != null) {
            }
            o oVar4222222 = oVar2;
            if (kVar2 != null) {
            }
            n nVar5222222 = nVar2;
            if (kVar2 != null) {
            }
            Float f65222222 = f59222222;
            if (kVar2 != null) {
            }
            aj ajVar5222222 = ajVar2;
            if (kVar2 != null) {
            }
            Shadow shadow4222222 = shadow2;
            if (kVar2 != null) {
            }
            ai aiVar5222222 = aiVar4222222;
            if (kVar2 != null) {
            }
            Float f66222222 = f37;
            if (kVar2 != null) {
            }
            if (kVar2 != null) {
            }
            Float f67222222 = f28;
            if (kVar2 != null) {
            }
            ao aoVar4222222 = aoVar2;
            if (kVar2 != null) {
            }
            Float f68222222 = f29;
            bp3.k kVar4222222 = new bp3.k(hVar4222222, valueOf222222, cVar4222222, oVar4222222, nVar5222222, f65222222, ajVar5222222, shadow4222222, aiVar5222222, f66222222, alVar4, f67222222, aoVar4222222, f68222222, null);
            ArrayList arrayList222222 = new ArrayList();
            Function1<? super am, Unit> function111222222 = function110;
            if (map2 != null) {
            }
            if (aVar2 != null) {
            }
            if (anVar2 == null) {
            }
            if (num2 != null) {
            }
            function16 = (Function1) obj;
            if (function16 != null) {
            }
            if (f36 != null) {
            }
            if (function15 != null) {
            }
            if (function14 != null) {
            }
            if (function23 != null) {
            }
            RichTextViewPropUpdater richTextViewPropUpdater222222 = RichTextViewPropUpdater.f339353a;
            arrayList222222.add(new com.tencent.ntcompose.core.k("textStyle", kVar4222222, null, null, null, null, richTextViewPropUpdater222222, 60, null));
            if (str2 != null) {
            }
            if (bool2 != null) {
            }
            ComposeNodeKt.a("rich_text", com.tencent.ntcompose.material.base.a.f339408a, function26 != null ? null : function26, iVar3, arrayList222222, null, startRestartGroup, ((i19 << 6) & 7168) | 32822, 32);
            if (d16) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            iVar2 = iVar3;
            function24 = function26;
            hVar3 = hVar2;
            f38 = f56;
            oVar3 = oVar2;
            cVar3 = cVar2;
            nVar3 = nVar2;
            f39 = f28;
            anVar3 = anVar2;
            aoVar3 = aoVar2;
            f46 = f59222222;
            f47 = f36;
            ajVar3 = ajVar2;
            aiVar2 = aiVar4222222;
            function17 = function111222222;
            alVar3 = alVar2;
            function18 = function14;
            function19 = function15;
            f48 = f29;
            num3 = num2;
            str3 = str2;
            function25 = function23;
            shadow3 = shadow2;
            map3 = map2;
            bool3 = bool2;
            kVar3 = kVar2;
            f49 = f37;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i26 = i18 & 4;
        if (i26 == 0) {
        }
        i27 = i18 & 8;
        if (i27 != 0) {
        }
        i28 = i18 & 16;
        if (i28 != 0) {
        }
        i29 = i18 & 32;
        if (i29 != 0) {
        }
        i36 = i18 & 64;
        if (i36 != 0) {
        }
        i37 = i18 & 128;
        if (i37 != 0) {
        }
        i38 = i18 & 256;
        if (i38 != 0) {
        }
        i39 = i18 & 512;
        if (i39 != 0) {
        }
        i46 = i18 & 1024;
        if (i46 != 0) {
        }
        i48 = i18 & 2048;
        if (i48 != 0) {
        }
        int i9622 = i47;
        i49 = i18 & 4096;
        if (i49 != 0) {
        }
        i56 = i18 & 8192;
        if (i56 == 0) {
        }
        i58 = i18 & 16384;
        if (i58 != 0) {
        }
        i59 = i58;
        i65 = i18 & 32768;
        if (i65 == 0) {
        }
        i66 = i18 & 65536;
        if (i66 == 0) {
        }
        i67 = i18 & 131072;
        if (i67 == 0) {
        }
        i68 = i18 & 262144;
        if (i68 == 0) {
        }
        i69 = i18 & 524288;
        if (i69 != 0) {
        }
        i75 = i18 & 1048576;
        if (i75 == 0) {
        }
        i77 = i18 & 2097152;
        if (i77 != 0) {
        }
        int i9722222 = i76;
        i78 = i18 & 4194304;
        if (i78 == 0) {
        }
        i79 = i18 & 8388608;
        if (i79 != 0) {
        }
        i85 = i18 & 16777216;
        if (i85 == 0) {
        }
        i86 = i18 & 33554432;
        if (i86 == 0) {
        }
        i87 = i18 & 67108864;
        if (i87 == 0) {
        }
        i88 = i18 & 134217728;
        if (i88 == 0) {
        }
        if ((i18 & 2621448) != 2621448) {
        }
        if (i89 == 0) {
        }
        if (i95 == 0) {
        }
        if (i26 == 0) {
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
        Float f592222222 = f57;
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
        if (i87 != 0) {
        }
        if (i88 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        d16 = d(map2, aVar2);
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        ai aiVar42222222 = aiVar3;
        if (rememberedValue != companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState<com.tencent.kuikly.core.layout.d> mutableState3222222 = (MutableState) rememberedValue;
        startRestartGroup.startReplaceableGroup(-1669861999);
        if (d16) {
        }
        startRestartGroup.endReplaceableGroup();
        if (kVar2 != null) {
        }
        com.tencent.kuikly.core.base.h hVar42222222 = hVar2;
        Float valueOf2222222 = Float.valueOf((kVar2 != null || (fontSize = kVar2.getFontSize()) == null) ? f56 == null ? f56.floatValue() : 16.0f : fontSize.floatValue());
        if (kVar2 != null) {
        }
        bp3.c cVar42222222 = cVar2;
        if (kVar2 != null) {
        }
        o oVar42222222 = oVar2;
        if (kVar2 != null) {
        }
        n nVar52222222 = nVar2;
        if (kVar2 != null) {
        }
        Float f652222222 = f592222222;
        if (kVar2 != null) {
        }
        aj ajVar52222222 = ajVar2;
        if (kVar2 != null) {
        }
        Shadow shadow42222222 = shadow2;
        if (kVar2 != null) {
        }
        ai aiVar52222222 = aiVar42222222;
        if (kVar2 != null) {
        }
        Float f662222222 = f37;
        if (kVar2 != null) {
        }
        if (kVar2 != null) {
        }
        Float f672222222 = f28;
        if (kVar2 != null) {
        }
        ao aoVar42222222 = aoVar2;
        if (kVar2 != null) {
        }
        Float f682222222 = f29;
        bp3.k kVar42222222 = new bp3.k(hVar42222222, valueOf2222222, cVar42222222, oVar42222222, nVar52222222, f652222222, ajVar52222222, shadow42222222, aiVar52222222, f662222222, alVar4, f672222222, aoVar42222222, f682222222, null);
        ArrayList arrayList2222222 = new ArrayList();
        Function1<? super am, Unit> function1112222222 = function110;
        if (map2 != null) {
        }
        if (aVar2 != null) {
        }
        if (anVar2 == null) {
        }
        if (num2 != null) {
        }
        function16 = (Function1) obj;
        if (function16 != null) {
        }
        if (f36 != null) {
        }
        if (function15 != null) {
        }
        if (function14 != null) {
        }
        if (function23 != null) {
        }
        RichTextViewPropUpdater richTextViewPropUpdater2222222 = RichTextViewPropUpdater.f339353a;
        arrayList2222222.add(new com.tencent.ntcompose.core.k("textStyle", kVar42222222, null, null, null, null, richTextViewPropUpdater2222222, 60, null));
        if (str2 != null) {
        }
        if (bool2 != null) {
        }
        ComposeNodeKt.a("rich_text", com.tencent.ntcompose.material.base.a.f339408a, function26 != null ? null : function26, iVar3, arrayList2222222, null, startRestartGroup, ((i19 << 6) & 7168) | 32822, 32);
        if (d16) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        iVar2 = iVar3;
        function24 = function26;
        hVar3 = hVar2;
        f38 = f56;
        oVar3 = oVar2;
        cVar3 = cVar2;
        nVar3 = nVar2;
        f39 = f28;
        anVar3 = anVar2;
        aoVar3 = aoVar2;
        f46 = f592222222;
        f47 = f36;
        ajVar3 = ajVar2;
        aiVar2 = aiVar42222222;
        function17 = function1112222222;
        alVar3 = alVar2;
        function18 = function14;
        function19 = function15;
        f48 = f29;
        num3 = num2;
        str3 = str2;
        function25 = function23;
        shadow3 = shadow2;
        map3 = map2;
        bool3 = bool2;
        kVar3 = kVar2;
        f49 = f37;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static final boolean c(Map<String, bp3.d> map, Map<String, bp3.d> map2) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        if (map == map2) {
            return true;
        }
        if (map2 == null || map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry<String, bp3.d> entry : map.entrySet()) {
            if (!map2.containsKey(entry.getKey()) || !Intrinsics.areEqual(map2.get(entry.getKey()), entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    public static final boolean d(Map<String, bp3.d> map, bp3.a aVar) {
        if (map == null || aVar == null) {
            return true;
        }
        Iterator<T> it = aVar.c().iterator();
        while (it.hasNext()) {
            a.Range range = (a.Range) it.next();
            if (range.b() instanceof bp3.i) {
                bp3.i iVar = (bp3.i) ((bp3.j) range.b());
                bp3.d dVar = map.get(iVar.getPlaceholderId());
                if (dVar != null) {
                    iVar.s(dVar);
                }
            }
        }
        return true;
    }
}
