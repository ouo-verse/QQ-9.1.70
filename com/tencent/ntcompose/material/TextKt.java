package com.tencent.ntcompose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.ch;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.ntcompose.core.ComposeNodeKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.aj;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import zo3.Shadow;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b0\u0001\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u00d7\u0003\u0010;\u001a\u00020\n2\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022B\b\u0002\u0010\r\u001a<\u0012\u0004\u0012\u00020\u0005\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u000b\u00a2\u0006\u0002\b\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(2\u0016\b\u0002\u0010,\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\n\u0018\u00010*2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u00102\u001a\u0004\u0018\u0001012-\b\u0002\u00106\u001a'\u0012\u0015\u0012\u0013\u0018\u000103\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\n\u0018\u00010*j\u0004\u0018\u0001`52%\b\u0002\u00109\u001a\u001f\u0012\u0013\u0012\u001107\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020\n\u0018\u00010*2\b\b\u0002\u0010:\u001a\u000201H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b;\u0010<\u001a\u0014\u0010>\u001a\u00020\n*\u00020=2\u0006\u0010.\u001a\u00020-H\u0000\u0082\u0002\u000b\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b\u0019\u00a8\u0006?"}, d2 = {"", "text", "Lcom/tencent/ntcompose/core/i;", "modifier", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/views/TextView;", "Lcom/tencent/kuikly/core/base/aa;", "Lkotlin/ParameterName;", "name", "viewRef", "", "Lcom/tencent/ntcompose/core/RefFunc;", "Lkotlin/ExtensionFunctionType;", "ref", "Lcom/tencent/kuikly/core/base/h;", "color", "", "fontSize", "Lcom/tencent/ntcompose/material/o;", "fontStyle", "Lbp3/c;", "fontWeight", "Lcom/tencent/ntcompose/material/n;", "fontFamily", NodeProps.LETTER_SPACING, "Lcom/tencent/ntcompose/material/aj;", TtmlNode.ATTR_TTS_TEXT_DECORATION, "Lcom/tencent/ntcompose/material/ai;", "textAlign", NodeProps.LINE_HEIGHT, "Lcom/tencent/ntcompose/material/al;", "textIndent", "lineSpacing", "paragraphSpacing", "Lzo3/f;", "shadow", "Lcom/tencent/ntcompose/material/an;", "overflow", "Lcom/tencent/ntcompose/material/ao;", "stroke", "", "maxLines", "Lkotlin/Function1;", "Lcom/tencent/ntcompose/material/am;", "onTextLayout", "Lbp3/k;", "style", "lineBreakMargin", "textPostProcessor", "", "includePadding", "", "parma", "Lcom/tencent/kuikly/core/base/event/EventHandlerFn;", "onLineBreakMargin", "Lcom/tencent/kuikly/core/views/ch;", "params", "onTextWithLineBreak", "onlyUseDefaultTextView", "a", "(Ljava/lang/String;Lcom/tencent/ntcompose/core/i;Lkotlin/jvm/functions/Function2;Lcom/tencent/kuikly/core/base/h;Ljava/lang/Float;Lcom/tencent/ntcompose/material/o;Lbp3/c;Lcom/tencent/ntcompose/material/n;Ljava/lang/Float;Lcom/tencent/ntcompose/material/aj;Lcom/tencent/ntcompose/material/ai;Ljava/lang/Float;Lcom/tencent/ntcompose/material/al;Ljava/lang/Float;Ljava/lang/Float;Lzo3/f;Lcom/tencent/ntcompose/material/an;Lcom/tencent/ntcompose/material/ao;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Lbp3/k;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;IIII)V", "Lcom/tencent/kuikly/core/views/ce;", "b", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class TextKt {
    /* JADX WARN: Removed duplicated region for block: B:102:0x078c  */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x03e7  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x03ed  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0461  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x046a  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0484  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x048e  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0498  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x04a2  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x04ac  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x04b6  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x04c0  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x04ca  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x04d4  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x04d9  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x04e3  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x04ed  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0521  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0550  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x058c  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x05c3  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x05f2  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0629  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0658  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0687  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x06b6  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x071a  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0725  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0750  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0727  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x071e  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0588  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0477  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x047c  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x045b  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x043d  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0421  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x03f0  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:404:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:411:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:418:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:432:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x033d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(String str, com.tencent.ntcompose.core.i iVar, Function2<? super TextView, ? super com.tencent.kuikly.core.base.aa<TextView>, Unit> function2, com.tencent.kuikly.core.base.h hVar, Float f16, o oVar, bp3.c cVar, n nVar, Float f17, aj ajVar, ai aiVar, Float f18, al alVar, Float f19, Float f26, Shadow shadow, an anVar, ao aoVar, Integer num, Function1<? super am, Unit> function1, bp3.k kVar, Float f27, String str2, Boolean bool, Function1<Object, Unit> function12, Function1<? super ch, Unit> function13, boolean z16, Composer composer, final int i3, final int i16, final int i17, final int i18) {
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
        Function1<? super ch, Unit> function14;
        int i86;
        String str3;
        com.tencent.kuikly.core.base.h hVar2;
        o oVar2;
        bp3.c cVar2;
        n nVar2;
        aj ajVar2;
        ai aiVar2;
        Float f28;
        Float f29;
        Float f36;
        Shadow shadow2;
        an anVar2;
        ao aoVar2;
        Integer num2;
        Function1<? super am, Unit> function15;
        bp3.k kVar2;
        Float f37;
        String str4;
        Boolean bool2;
        Function1<Object, Unit> function16;
        Float f38;
        String str5;
        final com.tencent.ntcompose.core.i iVar2;
        final Float f39;
        final n nVar3;
        final Float f46;
        final o oVar3;
        final bp3.c cVar3;
        final Float f47;
        final an anVar3;
        final ao aoVar3;
        final bp3.k kVar3;
        final String str6;
        final ai aiVar3;
        final com.tencent.kuikly.core.base.h hVar3;
        final Function1<? super ch, Unit> function17;
        final Function1<Object, Unit> function18;
        Float f48;
        final String str7;
        final Float f49;
        final al alVar2;
        final boolean z17;
        final Float f56;
        final Integer num3;
        final Function1<? super am, Unit> function19;
        final aj ajVar3;
        final Function2<? super TextView, ? super com.tencent.kuikly.core.base.aa<TextView>, Unit> function22;
        final Boolean bool3;
        final Shadow shadow3;
        Float fontSize;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1822752923);
        int i87 = i18 & 1;
        if (i87 != 0) {
            i19 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i19 = (startRestartGroup.changed(str) ? 4 : 2) | i3;
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
                } else if ((i16 & 896) == 0) {
                    i89 |= startRestartGroup.changed(alVar) ? 256 : 128;
                    i56 = i18 & 8192;
                    if (i56 == 0) {
                        i89 |= 3072;
                        i57 = i56;
                    } else {
                        i57 = i56;
                        if ((i16 & 7168) == 0) {
                            i89 |= startRestartGroup.changed(f19) ? 2048 : 1024;
                            i58 = i18 & 16384;
                            if (i58 != 0) {
                                i89 |= 24576;
                            } else if ((i16 & 57344) == 0) {
                                i59 = i58;
                                i89 |= startRestartGroup.changed(f26) ? 16384 : 8192;
                                i65 = i18 & 32768;
                                if (i65 == 0) {
                                    i89 |= 196608;
                                } else if ((i16 & 458752) == 0) {
                                    i89 |= startRestartGroup.changed(shadow) ? 131072 : 65536;
                                }
                                i66 = i18 & 65536;
                                if (i66 == 0) {
                                    i89 |= 1572864;
                                } else if ((i16 & 3670016) == 0) {
                                    i89 |= startRestartGroup.changed(anVar) ? 1048576 : 524288;
                                }
                                i67 = i18 & 131072;
                                if (i67 == 0) {
                                    i89 |= 12582912;
                                } else if ((i16 & 29360128) == 0) {
                                    i89 |= startRestartGroup.changed(aoVar) ? 8388608 : 4194304;
                                }
                                i68 = i18 & 262144;
                                if (i68 == 0) {
                                    i89 |= 100663296;
                                } else if ((i16 & 234881024) == 0) {
                                    i89 |= startRestartGroup.changed(num) ? 67108864 : 33554432;
                                }
                                i69 = i18 & 524288;
                                if (i69 == 0) {
                                    i89 |= 805306368;
                                } else if ((i16 & 1879048192) == 0) {
                                    i89 |= startRestartGroup.changed(function1) ? 536870912 : 268435456;
                                }
                                i75 = i18 & 1048576;
                                int i95 = i75 == 0 ? i17 | 2 : i17;
                                i76 = i18 & 2097152;
                                if (i76 == 0) {
                                    i95 |= 48;
                                } else if ((i17 & 112) == 0) {
                                    i95 |= startRestartGroup.changed(f27) ? 32 : 16;
                                }
                                int i96 = i95;
                                i77 = i18 & 4194304;
                                if (i77 == 0) {
                                    i96 |= MsgConstant.KRMFILETHUMBSIZE384;
                                } else if ((i17 & 896) == 0) {
                                    i96 |= startRestartGroup.changed(str2) ? 256 : 128;
                                    i78 = i18 & 8388608;
                                    if (i78 != 0) {
                                        i96 |= 3072;
                                    } else if ((i17 & 7168) == 0) {
                                        i96 |= startRestartGroup.changed(bool) ? 2048 : 1024;
                                        i79 = i18 & 16777216;
                                        if (i79 == 0) {
                                            i96 |= 24576;
                                        } else if ((i17 & 57344) == 0) {
                                            i96 |= startRestartGroup.changed(function12) ? 16384 : 8192;
                                        }
                                        i85 = i18 & 33554432;
                                        if (i85 == 0) {
                                            i96 |= 196608;
                                            function14 = function13;
                                        } else {
                                            function14 = function13;
                                            if ((i17 & 458752) == 0) {
                                                i96 |= startRestartGroup.changed(function14) ? 131072 : 65536;
                                            }
                                        }
                                        i86 = i18 & 67108864;
                                        if (i86 == 0) {
                                            i96 |= 1572864;
                                        } else if ((i17 & 3670016) == 0) {
                                            i96 |= startRestartGroup.changed(z16) ? 1048576 : 524288;
                                        }
                                        if ((i18 & 1048584) != 1048584 && (1533916891 & i19) == 306783378 && (1533916891 & i89) == 306783378 && (2995931 & i96) == 599186 && startRestartGroup.getSkipping()) {
                                            startRestartGroup.skipToGroupEnd();
                                            str6 = str;
                                            iVar2 = iVar;
                                            function22 = function2;
                                            hVar3 = hVar;
                                            f46 = f16;
                                            oVar3 = oVar;
                                            cVar3 = cVar;
                                            nVar3 = nVar;
                                            f56 = f17;
                                            ajVar3 = ajVar;
                                            aiVar3 = aiVar;
                                            f39 = f18;
                                            alVar2 = alVar;
                                            f47 = f19;
                                            shadow3 = shadow;
                                            anVar3 = anVar;
                                            aoVar3 = aoVar;
                                            num3 = num;
                                            function19 = function1;
                                            kVar3 = kVar;
                                            f49 = f27;
                                            str7 = str2;
                                            bool3 = bool;
                                            function18 = function12;
                                            z17 = z16;
                                            function17 = function14;
                                            f48 = f26;
                                        } else {
                                            str3 = i87 == 0 ? null : str;
                                            com.tencent.ntcompose.core.i iVar3 = i88 == 0 ? com.tencent.ntcompose.core.i.INSTANCE : iVar;
                                            Function2<? super TextView, ? super com.tencent.kuikly.core.base.aa<TextView>, Unit> function23 = i26 == 0 ? null : function2;
                                            hVar2 = i27 == 0 ? null : hVar;
                                            Float f57 = i28 == 0 ? null : f16;
                                            oVar2 = i29 == 0 ? null : oVar;
                                            cVar2 = i36 == 0 ? null : cVar;
                                            nVar2 = i37 == 0 ? null : nVar;
                                            Float f58 = i38 == 0 ? null : f17;
                                            ajVar2 = i39 == 0 ? null : ajVar;
                                            aiVar2 = i46 == 0 ? null : aiVar;
                                            f28 = i48 == 0 ? null : f18;
                                            al alVar3 = i49 == 0 ? null : alVar;
                                            f29 = i57 == 0 ? null : f19;
                                            f36 = i59 == 0 ? null : f26;
                                            shadow2 = i65 == 0 ? null : shadow;
                                            anVar2 = i66 == 0 ? null : anVar;
                                            aoVar2 = i67 == 0 ? null : aoVar;
                                            num2 = i68 == 0 ? null : num;
                                            function15 = i69 == 0 ? null : function1;
                                            kVar2 = i75 == 0 ? null : kVar;
                                            f37 = i76 == 0 ? null : f27;
                                            str4 = i77 == 0 ? null : str2;
                                            bool2 = i78 == 0 ? null : bool;
                                            function16 = i79 == 0 ? null : function12;
                                            if (i85 != 0) {
                                                function14 = null;
                                            }
                                            boolean z18 = i86 == 0 ? false : z16;
                                            if (ComposerKt.isTraceInProgress()) {
                                                f38 = f58;
                                            } else {
                                                f38 = f58;
                                                ComposerKt.traceEventStart(-1822752923, i19, i89, "com.tencent.ntcompose.material.Text (Text.kt:83)");
                                            }
                                            if (kVar2 != null || (r8 = kVar2.getColor()) == null) {
                                                com.tencent.kuikly.core.base.h hVar4 = hVar2;
                                            }
                                            Float valueOf = Float.valueOf((kVar2 != null || (fontSize = kVar2.getFontSize()) == null) ? f57 == null ? f57.floatValue() : 16.0f : fontSize.floatValue());
                                            if (kVar2 != null || (r32 = kVar2.getFontWeight()) == null) {
                                                bp3.c cVar4 = cVar2;
                                            }
                                            if (kVar2 != null || (r33 = kVar2.getFontStyle()) == null) {
                                                o oVar4 = oVar2;
                                            }
                                            if (kVar2 != null || (r34 = kVar2.getFontFamily()) == null) {
                                                n nVar4 = nVar2;
                                            }
                                            if (kVar2 != null || (r35 = kVar2.getCom.tencent.mtt.hippy.dom.node.NodeProps.LETTER_SPACING java.lang.String()) == null) {
                                                Float f59 = f38;
                                            }
                                            if (kVar2 != null || (r36 = kVar2.getCom.google.android.exoplayer2.text.ttml.TtmlNode.ATTR_TTS_TEXT_DECORATION java.lang.String()) == null) {
                                                aj ajVar4 = ajVar2;
                                            }
                                            if (kVar2 != null || (r37 = kVar2.getShadow()) == null) {
                                                Shadow shadow4 = shadow2;
                                            }
                                            if (kVar2 != null || (r38 = kVar2.getTextAlign()) == null) {
                                                ai aiVar4 = aiVar2;
                                            }
                                            if (kVar2 != null || (r39 = kVar2.getCom.tencent.mtt.hippy.dom.node.NodeProps.LINE_HEIGHT java.lang.String()) == null) {
                                                Float f65 = f28;
                                            }
                                            if (kVar2 != null) {
                                                kVar2.n();
                                            }
                                            if (kVar2 != null || (r40 = kVar2.getLineSpacing()) == null) {
                                                Float f66 = f29;
                                            }
                                            if (kVar2 != null || (r41 = kVar2.getStroke()) == null) {
                                                ao aoVar4 = aoVar2;
                                            }
                                            if (kVar2 != null || (r42 = kVar2.getParagraphSpacing()) == null) {
                                                Float f67 = f36;
                                            }
                                            bp3.k kVar4 = new bp3.k(hVar4, valueOf, cVar4, oVar4, nVar4, f59, ajVar4, shadow4, aiVar4, f65, alVar3, f66, aoVar4, f67, null);
                                            ArrayList arrayList = new ArrayList();
                                            if (str3 != null) {
                                                arrayList.add(new com.tencent.ntcompose.core.k("text", str3, null, null, null, null, TextViewPropUpdater.f339357a, 60, null));
                                            }
                                            if (anVar2 == null) {
                                                str5 = str3;
                                                arrayList.add(new com.tencent.ntcompose.core.k("textOverflow", an.d(anVar2.getValue()), null, null, null, null, TextViewPropUpdater.f339357a, 60, null));
                                            } else {
                                                str5 = str3;
                                            }
                                            if (num2 != null) {
                                                arrayList.add(new com.tencent.ntcompose.core.k("maxLines", Integer.valueOf(num2.intValue()), null, null, null, null, TextViewPropUpdater.f339357a, 60, null));
                                            }
                                            if (function15 != null) {
                                                arrayList.add(new com.tencent.ntcompose.core.k("onTextLayout", function15, null, null, null, null, TextViewPropUpdater.f339357a, 60, null));
                                            }
                                            if (f37 != null) {
                                                arrayList.add(new com.tencent.ntcompose.core.k("lineBreakMargin", Float.valueOf(f37.floatValue()), null, null, null, null, TextViewPropUpdater.f339357a, 60, null));
                                            }
                                            if (function16 != null) {
                                                arrayList.add(new com.tencent.ntcompose.core.k("onLineBreakMargin", function16, null, null, null, null, TextViewPropUpdater.f339357a, 60, null));
                                            }
                                            if (function14 != null) {
                                                arrayList.add(new com.tencent.ntcompose.core.k("onTextWithLineBreak", function14, null, null, null, null, TextViewPropUpdater.f339357a, 60, null));
                                            }
                                            if (str4 != null) {
                                                arrayList.add(new com.tencent.ntcompose.core.k("textPostProcessor", str4, null, null, null, null, TextViewPropUpdater.f339357a, 60, null));
                                            }
                                            if (bool2 != null) {
                                                arrayList.add(new com.tencent.ntcompose.core.k("includePadding", Boolean.valueOf(bool2.booleanValue()), null, null, null, null, TextViewPropUpdater.f339357a, 60, null));
                                            }
                                            arrayList.add(new com.tencent.ntcompose.core.k("textStyle", kVar4, null, null, null, null, TextViewPropUpdater.f339357a, 60, null));
                                            ComposeNodeKt.a(!z18 ? AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT : "text", com.tencent.ntcompose.material.base.a.f339408a, function23 != null ? null : function23, iVar3, arrayList, null, startRestartGroup, ((i19 << 6) & 7168) | 32816, 32);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            iVar2 = iVar3;
                                            f39 = f28;
                                            nVar3 = nVar2;
                                            f46 = f57;
                                            oVar3 = oVar2;
                                            cVar3 = cVar2;
                                            f47 = f29;
                                            anVar3 = anVar2;
                                            aoVar3 = aoVar2;
                                            kVar3 = kVar2;
                                            str6 = str5;
                                            aiVar3 = aiVar2;
                                            hVar3 = hVar2;
                                            function17 = function14;
                                            function18 = function16;
                                            f48 = f36;
                                            str7 = str4;
                                            f49 = f37;
                                            alVar2 = alVar3;
                                            z17 = z18;
                                            f56 = f38;
                                            num3 = num2;
                                            function19 = function15;
                                            Function2<? super TextView, ? super com.tencent.kuikly.core.base.aa<TextView>, Unit> function24 = function23;
                                            ajVar3 = ajVar2;
                                            function22 = function24;
                                            Shadow shadow5 = shadow2;
                                            bool3 = bool2;
                                            shadow3 = shadow5;
                                        }
                                        endRestartGroup = startRestartGroup.endRestartGroup();
                                        if (endRestartGroup != null) {
                                            return;
                                        }
                                        final Float f68 = f48;
                                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>(str6, iVar2, function22, hVar3, f46, oVar3, cVar3, nVar3, f56, ajVar3, aiVar3, f39, alVar2, f47, f68, shadow3, anVar3, aoVar3, num3, function19, kVar3, f49, str7, bool3, function18, function17, z17, i3, i16, i17, i18) { // from class: com.tencent.ntcompose.material.TextKt$Text$1
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
                                            final /* synthetic */ Function1<Object, Unit> $onLineBreakMargin;
                                            final /* synthetic */ Function1<am, Unit> $onTextLayout;
                                            final /* synthetic */ Function1<ch, Unit> $onTextWithLineBreak;
                                            final /* synthetic */ boolean $onlyUseDefaultTextView;
                                            final /* synthetic */ an $overflow;
                                            final /* synthetic */ Float $paragraphSpacing;
                                            final /* synthetic */ Function2<TextView, com.tencent.kuikly.core.base.aa<TextView>, Unit> $ref;
                                            final /* synthetic */ Shadow $shadow;
                                            final /* synthetic */ ao $stroke;
                                            final /* synthetic */ bp3.k $style;
                                            final /* synthetic */ String $text;
                                            final /* synthetic */ ai $textAlign;
                                            final /* synthetic */ aj $textDecoration;
                                            final /* synthetic */ al $textIndent;
                                            final /* synthetic */ String $textPostProcessor;

                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                                this.$lineSpacing = f47;
                                                this.$paragraphSpacing = f68;
                                                this.$shadow = shadow3;
                                                this.$overflow = anVar3;
                                                this.$stroke = aoVar3;
                                                this.$maxLines = num3;
                                                this.$onTextLayout = function19;
                                                this.$style = kVar3;
                                                this.$lineBreakMargin = f49;
                                                this.$textPostProcessor = str7;
                                                this.$includePadding = bool3;
                                                this.$onLineBreakMargin = function18;
                                                this.$onTextWithLineBreak = function17;
                                                this.$onlyUseDefaultTextView = z17;
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

                                            public final void invoke(Composer composer2, int i97) {
                                                TextKt.a(this.$text, this.$modifier, this.$ref, this.$color, this.$fontSize, this.$fontStyle, this.$fontWeight, this.$fontFamily, this.$letterSpacing, this.$textDecoration, this.$textAlign, this.$lineHeight, null, this.$lineSpacing, this.$paragraphSpacing, this.$shadow, this.$overflow, this.$stroke, this.$maxLines, this.$onTextLayout, this.$style, this.$lineBreakMargin, this.$textPostProcessor, this.$includePadding, this.$onLineBreakMargin, this.$onTextWithLineBreak, this.$onlyUseDefaultTextView, composer2, this.$$changed | 1, this.$$changed1, this.$$changed2, this.$$default);
                                            }
                                        });
                                        return;
                                    }
                                    i79 = i18 & 16777216;
                                    if (i79 == 0) {
                                    }
                                    i85 = i18 & 33554432;
                                    if (i85 == 0) {
                                    }
                                    i86 = i18 & 67108864;
                                    if (i86 == 0) {
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
                                    if (i76 == 0) {
                                    }
                                    if (i77 == 0) {
                                    }
                                    if (i78 == 0) {
                                    }
                                    if (i79 == 0) {
                                    }
                                    if (i85 != 0) {
                                    }
                                    if (i86 == 0) {
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    if (kVar2 != null) {
                                    }
                                    com.tencent.kuikly.core.base.h hVar42 = hVar2;
                                    Float valueOf2 = Float.valueOf((kVar2 != null || (fontSize = kVar2.getFontSize()) == null) ? f57 == null ? f57.floatValue() : 16.0f : fontSize.floatValue());
                                    if (kVar2 != null) {
                                    }
                                    bp3.c cVar42 = cVar2;
                                    if (kVar2 != null) {
                                    }
                                    o oVar42 = oVar2;
                                    if (kVar2 != null) {
                                    }
                                    n nVar42 = nVar2;
                                    if (kVar2 != null) {
                                    }
                                    Float f592 = f38;
                                    if (kVar2 != null) {
                                    }
                                    aj ajVar42 = ajVar2;
                                    if (kVar2 != null) {
                                    }
                                    Shadow shadow42 = shadow2;
                                    if (kVar2 != null) {
                                    }
                                    ai aiVar42 = aiVar2;
                                    if (kVar2 != null) {
                                    }
                                    Float f652 = f28;
                                    if (kVar2 != null) {
                                    }
                                    if (kVar2 != null) {
                                    }
                                    Float f662 = f29;
                                    if (kVar2 != null) {
                                    }
                                    ao aoVar42 = aoVar2;
                                    if (kVar2 != null) {
                                    }
                                    Float f672 = f36;
                                    bp3.k kVar42 = new bp3.k(hVar42, valueOf2, cVar42, oVar42, nVar42, f592, ajVar42, shadow42, aiVar42, f652, alVar3, f662, aoVar42, f672, null);
                                    ArrayList arrayList2 = new ArrayList();
                                    if (str3 != null) {
                                    }
                                    if (anVar2 == null) {
                                    }
                                    if (num2 != null) {
                                    }
                                    if (function15 != null) {
                                    }
                                    if (f37 != null) {
                                    }
                                    if (function16 != null) {
                                    }
                                    if (function14 != null) {
                                    }
                                    if (str4 != null) {
                                    }
                                    if (bool2 != null) {
                                    }
                                    arrayList2.add(new com.tencent.ntcompose.core.k("textStyle", kVar42, null, null, null, null, TextViewPropUpdater.f339357a, 60, null));
                                    ComposeNodeKt.a(!z18 ? AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT : "text", com.tencent.ntcompose.material.base.a.f339408a, function23 != null ? null : function23, iVar3, arrayList2, null, startRestartGroup, ((i19 << 6) & 7168) | 32816, 32);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    iVar2 = iVar3;
                                    f39 = f28;
                                    nVar3 = nVar2;
                                    f46 = f57;
                                    oVar3 = oVar2;
                                    cVar3 = cVar2;
                                    f47 = f29;
                                    anVar3 = anVar2;
                                    aoVar3 = aoVar2;
                                    kVar3 = kVar2;
                                    str6 = str5;
                                    aiVar3 = aiVar2;
                                    hVar3 = hVar2;
                                    function17 = function14;
                                    function18 = function16;
                                    f48 = f36;
                                    str7 = str4;
                                    f49 = f37;
                                    alVar2 = alVar3;
                                    z17 = z18;
                                    f56 = f38;
                                    num3 = num2;
                                    function19 = function15;
                                    Function2<? super TextView, ? super com.tencent.kuikly.core.base.aa<TextView>, Unit> function242 = function23;
                                    ajVar3 = ajVar2;
                                    function22 = function242;
                                    Shadow shadow52 = shadow2;
                                    bool3 = bool2;
                                    shadow3 = shadow52;
                                    endRestartGroup = startRestartGroup.endRestartGroup();
                                    if (endRestartGroup != null) {
                                    }
                                }
                                i78 = i18 & 8388608;
                                if (i78 != 0) {
                                }
                                i79 = i18 & 16777216;
                                if (i79 == 0) {
                                }
                                i85 = i18 & 33554432;
                                if (i85 == 0) {
                                }
                                i86 = i18 & 67108864;
                                if (i86 == 0) {
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
                                if (i76 == 0) {
                                }
                                if (i77 == 0) {
                                }
                                if (i78 == 0) {
                                }
                                if (i79 == 0) {
                                }
                                if (i85 != 0) {
                                }
                                if (i86 == 0) {
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                if (kVar2 != null) {
                                }
                                com.tencent.kuikly.core.base.h hVar422 = hVar2;
                                Float valueOf22 = Float.valueOf((kVar2 != null || (fontSize = kVar2.getFontSize()) == null) ? f57 == null ? f57.floatValue() : 16.0f : fontSize.floatValue());
                                if (kVar2 != null) {
                                }
                                bp3.c cVar422 = cVar2;
                                if (kVar2 != null) {
                                }
                                o oVar422 = oVar2;
                                if (kVar2 != null) {
                                }
                                n nVar422 = nVar2;
                                if (kVar2 != null) {
                                }
                                Float f5922 = f38;
                                if (kVar2 != null) {
                                }
                                aj ajVar422 = ajVar2;
                                if (kVar2 != null) {
                                }
                                Shadow shadow422 = shadow2;
                                if (kVar2 != null) {
                                }
                                ai aiVar422 = aiVar2;
                                if (kVar2 != null) {
                                }
                                Float f6522 = f28;
                                if (kVar2 != null) {
                                }
                                if (kVar2 != null) {
                                }
                                Float f6622 = f29;
                                if (kVar2 != null) {
                                }
                                ao aoVar422 = aoVar2;
                                if (kVar2 != null) {
                                }
                                Float f6722 = f36;
                                bp3.k kVar422 = new bp3.k(hVar422, valueOf22, cVar422, oVar422, nVar422, f5922, ajVar422, shadow422, aiVar422, f6522, alVar3, f6622, aoVar422, f6722, null);
                                ArrayList arrayList22 = new ArrayList();
                                if (str3 != null) {
                                }
                                if (anVar2 == null) {
                                }
                                if (num2 != null) {
                                }
                                if (function15 != null) {
                                }
                                if (f37 != null) {
                                }
                                if (function16 != null) {
                                }
                                if (function14 != null) {
                                }
                                if (str4 != null) {
                                }
                                if (bool2 != null) {
                                }
                                arrayList22.add(new com.tencent.ntcompose.core.k("textStyle", kVar422, null, null, null, null, TextViewPropUpdater.f339357a, 60, null));
                                ComposeNodeKt.a(!z18 ? AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT : "text", com.tencent.ntcompose.material.base.a.f339408a, function23 != null ? null : function23, iVar3, arrayList22, null, startRestartGroup, ((i19 << 6) & 7168) | 32816, 32);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                iVar2 = iVar3;
                                f39 = f28;
                                nVar3 = nVar2;
                                f46 = f57;
                                oVar3 = oVar2;
                                cVar3 = cVar2;
                                f47 = f29;
                                anVar3 = anVar2;
                                aoVar3 = aoVar2;
                                kVar3 = kVar2;
                                str6 = str5;
                                aiVar3 = aiVar2;
                                hVar3 = hVar2;
                                function17 = function14;
                                function18 = function16;
                                f48 = f36;
                                str7 = str4;
                                f49 = f37;
                                alVar2 = alVar3;
                                z17 = z18;
                                f56 = f38;
                                num3 = num2;
                                function19 = function15;
                                Function2<? super TextView, ? super com.tencent.kuikly.core.base.aa<TextView>, Unit> function2422 = function23;
                                ajVar3 = ajVar2;
                                function22 = function2422;
                                Shadow shadow522 = shadow2;
                                bool3 = bool2;
                                shadow3 = shadow522;
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
                            if (i69 == 0) {
                            }
                            i75 = i18 & 1048576;
                            if (i75 == 0) {
                            }
                            i76 = i18 & 2097152;
                            if (i76 == 0) {
                            }
                            int i962 = i95;
                            i77 = i18 & 4194304;
                            if (i77 == 0) {
                            }
                            i78 = i18 & 8388608;
                            if (i78 != 0) {
                            }
                            i79 = i18 & 16777216;
                            if (i79 == 0) {
                            }
                            i85 = i18 & 33554432;
                            if (i85 == 0) {
                            }
                            i86 = i18 & 67108864;
                            if (i86 == 0) {
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
                            if (i76 == 0) {
                            }
                            if (i77 == 0) {
                            }
                            if (i78 == 0) {
                            }
                            if (i79 == 0) {
                            }
                            if (i85 != 0) {
                            }
                            if (i86 == 0) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            if (kVar2 != null) {
                            }
                            com.tencent.kuikly.core.base.h hVar4222 = hVar2;
                            Float valueOf222 = Float.valueOf((kVar2 != null || (fontSize = kVar2.getFontSize()) == null) ? f57 == null ? f57.floatValue() : 16.0f : fontSize.floatValue());
                            if (kVar2 != null) {
                            }
                            bp3.c cVar4222 = cVar2;
                            if (kVar2 != null) {
                            }
                            o oVar4222 = oVar2;
                            if (kVar2 != null) {
                            }
                            n nVar4222 = nVar2;
                            if (kVar2 != null) {
                            }
                            Float f59222 = f38;
                            if (kVar2 != null) {
                            }
                            aj ajVar4222 = ajVar2;
                            if (kVar2 != null) {
                            }
                            Shadow shadow4222 = shadow2;
                            if (kVar2 != null) {
                            }
                            ai aiVar4222 = aiVar2;
                            if (kVar2 != null) {
                            }
                            Float f65222 = f28;
                            if (kVar2 != null) {
                            }
                            if (kVar2 != null) {
                            }
                            Float f66222 = f29;
                            if (kVar2 != null) {
                            }
                            ao aoVar4222 = aoVar2;
                            if (kVar2 != null) {
                            }
                            Float f67222 = f36;
                            bp3.k kVar4222 = new bp3.k(hVar4222, valueOf222, cVar4222, oVar4222, nVar4222, f59222, ajVar4222, shadow4222, aiVar4222, f65222, alVar3, f66222, aoVar4222, f67222, null);
                            ArrayList arrayList222 = new ArrayList();
                            if (str3 != null) {
                            }
                            if (anVar2 == null) {
                            }
                            if (num2 != null) {
                            }
                            if (function15 != null) {
                            }
                            if (f37 != null) {
                            }
                            if (function16 != null) {
                            }
                            if (function14 != null) {
                            }
                            if (str4 != null) {
                            }
                            if (bool2 != null) {
                            }
                            arrayList222.add(new com.tencent.ntcompose.core.k("textStyle", kVar4222, null, null, null, null, TextViewPropUpdater.f339357a, 60, null));
                            ComposeNodeKt.a(!z18 ? AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT : "text", com.tencent.ntcompose.material.base.a.f339408a, function23 != null ? null : function23, iVar3, arrayList222, null, startRestartGroup, ((i19 << 6) & 7168) | 32816, 32);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            iVar2 = iVar3;
                            f39 = f28;
                            nVar3 = nVar2;
                            f46 = f57;
                            oVar3 = oVar2;
                            cVar3 = cVar2;
                            f47 = f29;
                            anVar3 = anVar2;
                            aoVar3 = aoVar2;
                            kVar3 = kVar2;
                            str6 = str5;
                            aiVar3 = aiVar2;
                            hVar3 = hVar2;
                            function17 = function14;
                            function18 = function16;
                            f48 = f36;
                            str7 = str4;
                            f49 = f37;
                            alVar2 = alVar3;
                            z17 = z18;
                            f56 = f38;
                            num3 = num2;
                            function19 = function15;
                            Function2<? super TextView, ? super com.tencent.kuikly.core.base.aa<TextView>, Unit> function24222 = function23;
                            ajVar3 = ajVar2;
                            function22 = function24222;
                            Shadow shadow5222 = shadow2;
                            bool3 = bool2;
                            shadow3 = shadow5222;
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
                    if (i69 == 0) {
                    }
                    i75 = i18 & 1048576;
                    if (i75 == 0) {
                    }
                    i76 = i18 & 2097152;
                    if (i76 == 0) {
                    }
                    int i9622 = i95;
                    i77 = i18 & 4194304;
                    if (i77 == 0) {
                    }
                    i78 = i18 & 8388608;
                    if (i78 != 0) {
                    }
                    i79 = i18 & 16777216;
                    if (i79 == 0) {
                    }
                    i85 = i18 & 33554432;
                    if (i85 == 0) {
                    }
                    i86 = i18 & 67108864;
                    if (i86 == 0) {
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
                    if (i76 == 0) {
                    }
                    if (i77 == 0) {
                    }
                    if (i78 == 0) {
                    }
                    if (i79 == 0) {
                    }
                    if (i85 != 0) {
                    }
                    if (i86 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (kVar2 != null) {
                    }
                    com.tencent.kuikly.core.base.h hVar42222 = hVar2;
                    Float valueOf2222 = Float.valueOf((kVar2 != null || (fontSize = kVar2.getFontSize()) == null) ? f57 == null ? f57.floatValue() : 16.0f : fontSize.floatValue());
                    if (kVar2 != null) {
                    }
                    bp3.c cVar42222 = cVar2;
                    if (kVar2 != null) {
                    }
                    o oVar42222 = oVar2;
                    if (kVar2 != null) {
                    }
                    n nVar42222 = nVar2;
                    if (kVar2 != null) {
                    }
                    Float f592222 = f38;
                    if (kVar2 != null) {
                    }
                    aj ajVar42222 = ajVar2;
                    if (kVar2 != null) {
                    }
                    Shadow shadow42222 = shadow2;
                    if (kVar2 != null) {
                    }
                    ai aiVar42222 = aiVar2;
                    if (kVar2 != null) {
                    }
                    Float f652222 = f28;
                    if (kVar2 != null) {
                    }
                    if (kVar2 != null) {
                    }
                    Float f662222 = f29;
                    if (kVar2 != null) {
                    }
                    ao aoVar42222 = aoVar2;
                    if (kVar2 != null) {
                    }
                    Float f672222 = f36;
                    bp3.k kVar42222 = new bp3.k(hVar42222, valueOf2222, cVar42222, oVar42222, nVar42222, f592222, ajVar42222, shadow42222, aiVar42222, f652222, alVar3, f662222, aoVar42222, f672222, null);
                    ArrayList arrayList2222 = new ArrayList();
                    if (str3 != null) {
                    }
                    if (anVar2 == null) {
                    }
                    if (num2 != null) {
                    }
                    if (function15 != null) {
                    }
                    if (f37 != null) {
                    }
                    if (function16 != null) {
                    }
                    if (function14 != null) {
                    }
                    if (str4 != null) {
                    }
                    if (bool2 != null) {
                    }
                    arrayList2222.add(new com.tencent.ntcompose.core.k("textStyle", kVar42222, null, null, null, null, TextViewPropUpdater.f339357a, 60, null));
                    ComposeNodeKt.a(!z18 ? AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT : "text", com.tencent.ntcompose.material.base.a.f339408a, function23 != null ? null : function23, iVar3, arrayList2222, null, startRestartGroup, ((i19 << 6) & 7168) | 32816, 32);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    iVar2 = iVar3;
                    f39 = f28;
                    nVar3 = nVar2;
                    f46 = f57;
                    oVar3 = oVar2;
                    cVar3 = cVar2;
                    f47 = f29;
                    anVar3 = anVar2;
                    aoVar3 = aoVar2;
                    kVar3 = kVar2;
                    str6 = str5;
                    aiVar3 = aiVar2;
                    hVar3 = hVar2;
                    function17 = function14;
                    function18 = function16;
                    f48 = f36;
                    str7 = str4;
                    f49 = f37;
                    alVar2 = alVar3;
                    z17 = z18;
                    f56 = f38;
                    num3 = num2;
                    function19 = function15;
                    Function2<? super TextView, ? super com.tencent.kuikly.core.base.aa<TextView>, Unit> function242222 = function23;
                    ajVar3 = ajVar2;
                    function22 = function242222;
                    Shadow shadow52222 = shadow2;
                    bool3 = bool2;
                    shadow3 = shadow52222;
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
                if (i69 == 0) {
                }
                i75 = i18 & 1048576;
                if (i75 == 0) {
                }
                i76 = i18 & 2097152;
                if (i76 == 0) {
                }
                int i96222 = i95;
                i77 = i18 & 4194304;
                if (i77 == 0) {
                }
                i78 = i18 & 8388608;
                if (i78 != 0) {
                }
                i79 = i18 & 16777216;
                if (i79 == 0) {
                }
                i85 = i18 & 33554432;
                if (i85 == 0) {
                }
                i86 = i18 & 67108864;
                if (i86 == 0) {
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
                if (i76 == 0) {
                }
                if (i77 == 0) {
                }
                if (i78 == 0) {
                }
                if (i79 == 0) {
                }
                if (i85 != 0) {
                }
                if (i86 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                if (kVar2 != null) {
                }
                com.tencent.kuikly.core.base.h hVar422222 = hVar2;
                Float valueOf22222 = Float.valueOf((kVar2 != null || (fontSize = kVar2.getFontSize()) == null) ? f57 == null ? f57.floatValue() : 16.0f : fontSize.floatValue());
                if (kVar2 != null) {
                }
                bp3.c cVar422222 = cVar2;
                if (kVar2 != null) {
                }
                o oVar422222 = oVar2;
                if (kVar2 != null) {
                }
                n nVar422222 = nVar2;
                if (kVar2 != null) {
                }
                Float f5922222 = f38;
                if (kVar2 != null) {
                }
                aj ajVar422222 = ajVar2;
                if (kVar2 != null) {
                }
                Shadow shadow422222 = shadow2;
                if (kVar2 != null) {
                }
                ai aiVar422222 = aiVar2;
                if (kVar2 != null) {
                }
                Float f6522222 = f28;
                if (kVar2 != null) {
                }
                if (kVar2 != null) {
                }
                Float f6622222 = f29;
                if (kVar2 != null) {
                }
                ao aoVar422222 = aoVar2;
                if (kVar2 != null) {
                }
                Float f6722222 = f36;
                bp3.k kVar422222 = new bp3.k(hVar422222, valueOf22222, cVar422222, oVar422222, nVar422222, f5922222, ajVar422222, shadow422222, aiVar422222, f6522222, alVar3, f6622222, aoVar422222, f6722222, null);
                ArrayList arrayList22222 = new ArrayList();
                if (str3 != null) {
                }
                if (anVar2 == null) {
                }
                if (num2 != null) {
                }
                if (function15 != null) {
                }
                if (f37 != null) {
                }
                if (function16 != null) {
                }
                if (function14 != null) {
                }
                if (str4 != null) {
                }
                if (bool2 != null) {
                }
                arrayList22222.add(new com.tencent.ntcompose.core.k("textStyle", kVar422222, null, null, null, null, TextViewPropUpdater.f339357a, 60, null));
                ComposeNodeKt.a(!z18 ? AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT : "text", com.tencent.ntcompose.material.base.a.f339408a, function23 != null ? null : function23, iVar3, arrayList22222, null, startRestartGroup, ((i19 << 6) & 7168) | 32816, 32);
                if (ComposerKt.isTraceInProgress()) {
                }
                iVar2 = iVar3;
                f39 = f28;
                nVar3 = nVar2;
                f46 = f57;
                oVar3 = oVar2;
                cVar3 = cVar2;
                f47 = f29;
                anVar3 = anVar2;
                aoVar3 = aoVar2;
                kVar3 = kVar2;
                str6 = str5;
                aiVar3 = aiVar2;
                hVar3 = hVar2;
                function17 = function14;
                function18 = function16;
                f48 = f36;
                str7 = str4;
                f49 = f37;
                alVar2 = alVar3;
                z17 = z18;
                f56 = f38;
                num3 = num2;
                function19 = function15;
                Function2<? super TextView, ? super com.tencent.kuikly.core.base.aa<TextView>, Unit> function2422222 = function23;
                ajVar3 = ajVar2;
                function22 = function2422222;
                Shadow shadow522222 = shadow2;
                bool3 = bool2;
                shadow3 = shadow522222;
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
            int i892 = i47;
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
            if (i69 == 0) {
            }
            i75 = i18 & 1048576;
            if (i75 == 0) {
            }
            i76 = i18 & 2097152;
            if (i76 == 0) {
            }
            int i962222 = i95;
            i77 = i18 & 4194304;
            if (i77 == 0) {
            }
            i78 = i18 & 8388608;
            if (i78 != 0) {
            }
            i79 = i18 & 16777216;
            if (i79 == 0) {
            }
            i85 = i18 & 33554432;
            if (i85 == 0) {
            }
            i86 = i18 & 67108864;
            if (i86 == 0) {
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
            if (i76 == 0) {
            }
            if (i77 == 0) {
            }
            if (i78 == 0) {
            }
            if (i79 == 0) {
            }
            if (i85 != 0) {
            }
            if (i86 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            if (kVar2 != null) {
            }
            com.tencent.kuikly.core.base.h hVar4222222 = hVar2;
            Float valueOf222222 = Float.valueOf((kVar2 != null || (fontSize = kVar2.getFontSize()) == null) ? f57 == null ? f57.floatValue() : 16.0f : fontSize.floatValue());
            if (kVar2 != null) {
            }
            bp3.c cVar4222222 = cVar2;
            if (kVar2 != null) {
            }
            o oVar4222222 = oVar2;
            if (kVar2 != null) {
            }
            n nVar4222222 = nVar2;
            if (kVar2 != null) {
            }
            Float f59222222 = f38;
            if (kVar2 != null) {
            }
            aj ajVar4222222 = ajVar2;
            if (kVar2 != null) {
            }
            Shadow shadow4222222 = shadow2;
            if (kVar2 != null) {
            }
            ai aiVar4222222 = aiVar2;
            if (kVar2 != null) {
            }
            Float f65222222 = f28;
            if (kVar2 != null) {
            }
            if (kVar2 != null) {
            }
            Float f66222222 = f29;
            if (kVar2 != null) {
            }
            ao aoVar4222222 = aoVar2;
            if (kVar2 != null) {
            }
            Float f67222222 = f36;
            bp3.k kVar4222222 = new bp3.k(hVar4222222, valueOf222222, cVar4222222, oVar4222222, nVar4222222, f59222222, ajVar4222222, shadow4222222, aiVar4222222, f65222222, alVar3, f66222222, aoVar4222222, f67222222, null);
            ArrayList arrayList222222 = new ArrayList();
            if (str3 != null) {
            }
            if (anVar2 == null) {
            }
            if (num2 != null) {
            }
            if (function15 != null) {
            }
            if (f37 != null) {
            }
            if (function16 != null) {
            }
            if (function14 != null) {
            }
            if (str4 != null) {
            }
            if (bool2 != null) {
            }
            arrayList222222.add(new com.tencent.ntcompose.core.k("textStyle", kVar4222222, null, null, null, null, TextViewPropUpdater.f339357a, 60, null));
            ComposeNodeKt.a(!z18 ? AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT : "text", com.tencent.ntcompose.material.base.a.f339408a, function23 != null ? null : function23, iVar3, arrayList222222, null, startRestartGroup, ((i19 << 6) & 7168) | 32816, 32);
            if (ComposerKt.isTraceInProgress()) {
            }
            iVar2 = iVar3;
            f39 = f28;
            nVar3 = nVar2;
            f46 = f57;
            oVar3 = oVar2;
            cVar3 = cVar2;
            f47 = f29;
            anVar3 = anVar2;
            aoVar3 = aoVar2;
            kVar3 = kVar2;
            str6 = str5;
            aiVar3 = aiVar2;
            hVar3 = hVar2;
            function17 = function14;
            function18 = function16;
            f48 = f36;
            str7 = str4;
            f49 = f37;
            alVar2 = alVar3;
            z17 = z18;
            f56 = f38;
            num3 = num2;
            function19 = function15;
            Function2<? super TextView, ? super com.tencent.kuikly.core.base.aa<TextView>, Unit> function24222222 = function23;
            ajVar3 = ajVar2;
            function22 = function24222222;
            Shadow shadow5222222 = shadow2;
            bool3 = bool2;
            shadow3 = shadow5222222;
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
        int i8922 = i47;
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
        if (i69 == 0) {
        }
        i75 = i18 & 1048576;
        if (i75 == 0) {
        }
        i76 = i18 & 2097152;
        if (i76 == 0) {
        }
        int i9622222 = i95;
        i77 = i18 & 4194304;
        if (i77 == 0) {
        }
        i78 = i18 & 8388608;
        if (i78 != 0) {
        }
        i79 = i18 & 16777216;
        if (i79 == 0) {
        }
        i85 = i18 & 33554432;
        if (i85 == 0) {
        }
        i86 = i18 & 67108864;
        if (i86 == 0) {
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
        if (i76 == 0) {
        }
        if (i77 == 0) {
        }
        if (i78 == 0) {
        }
        if (i79 == 0) {
        }
        if (i85 != 0) {
        }
        if (i86 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        if (kVar2 != null) {
        }
        com.tencent.kuikly.core.base.h hVar42222222 = hVar2;
        Float valueOf2222222 = Float.valueOf((kVar2 != null || (fontSize = kVar2.getFontSize()) == null) ? f57 == null ? f57.floatValue() : 16.0f : fontSize.floatValue());
        if (kVar2 != null) {
        }
        bp3.c cVar42222222 = cVar2;
        if (kVar2 != null) {
        }
        o oVar42222222 = oVar2;
        if (kVar2 != null) {
        }
        n nVar42222222 = nVar2;
        if (kVar2 != null) {
        }
        Float f592222222 = f38;
        if (kVar2 != null) {
        }
        aj ajVar42222222 = ajVar2;
        if (kVar2 != null) {
        }
        Shadow shadow42222222 = shadow2;
        if (kVar2 != null) {
        }
        ai aiVar42222222 = aiVar2;
        if (kVar2 != null) {
        }
        Float f652222222 = f28;
        if (kVar2 != null) {
        }
        if (kVar2 != null) {
        }
        Float f662222222 = f29;
        if (kVar2 != null) {
        }
        ao aoVar42222222 = aoVar2;
        if (kVar2 != null) {
        }
        Float f672222222 = f36;
        bp3.k kVar42222222 = new bp3.k(hVar42222222, valueOf2222222, cVar42222222, oVar42222222, nVar42222222, f592222222, ajVar42222222, shadow42222222, aiVar42222222, f652222222, alVar3, f662222222, aoVar42222222, f672222222, null);
        ArrayList arrayList2222222 = new ArrayList();
        if (str3 != null) {
        }
        if (anVar2 == null) {
        }
        if (num2 != null) {
        }
        if (function15 != null) {
        }
        if (f37 != null) {
        }
        if (function16 != null) {
        }
        if (function14 != null) {
        }
        if (str4 != null) {
        }
        if (bool2 != null) {
        }
        arrayList2222222.add(new com.tencent.ntcompose.core.k("textStyle", kVar42222222, null, null, null, null, TextViewPropUpdater.f339357a, 60, null));
        ComposeNodeKt.a(!z18 ? AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT : "text", com.tencent.ntcompose.material.base.a.f339408a, function23 != null ? null : function23, iVar3, arrayList2222222, null, startRestartGroup, ((i19 << 6) & 7168) | 32816, 32);
        if (ComposerKt.isTraceInProgress()) {
        }
        iVar2 = iVar3;
        f39 = f28;
        nVar3 = nVar2;
        f46 = f57;
        oVar3 = oVar2;
        cVar3 = cVar2;
        f47 = f29;
        anVar3 = anVar2;
        aoVar3 = aoVar2;
        kVar3 = kVar2;
        str6 = str5;
        aiVar3 = aiVar2;
        hVar3 = hVar2;
        function17 = function14;
        function18 = function16;
        f48 = f36;
        str7 = str4;
        f49 = f37;
        alVar2 = alVar3;
        z17 = z18;
        f56 = f38;
        num3 = num2;
        function19 = function15;
        Function2<? super TextView, ? super com.tencent.kuikly.core.base.aa<TextView>, Unit> function242222222 = function23;
        ajVar3 = ajVar2;
        function22 = function242222222;
        Shadow shadow52222222 = shadow2;
        bool3 = bool2;
        shadow3 = shadow52222222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static final void b(ce ceVar, bp3.k style) {
        Intrinsics.checkNotNullParameter(ceVar, "<this>");
        Intrinsics.checkNotNullParameter(style, "style");
        com.tencent.kuikly.core.base.h color = style.getColor();
        if (color != null) {
            ceVar.color(color);
        }
        Float fontSize = style.getFontSize();
        if (fontSize != null) {
            ce.fontSize$default(ceVar, fontSize.floatValue(), null, 2, null);
        }
        o fontStyle = style.getFontStyle();
        if (fontStyle != null) {
            if (fontStyle.getValue() == o.INSTANCE.a()) {
                ceVar.fontStyleItalic();
            } else {
                ceVar.fontStyleNormal();
            }
        }
        n fontFamily = style.getFontFamily();
        if (fontFamily != null) {
            ceVar.fontFamily(fontFamily.getFontName());
        }
        Float f16 = style.getCom.tencent.mtt.hippy.dom.node.NodeProps.LETTER_SPACING java.lang.String();
        if (f16 != null) {
            ceVar.with(NodeProps.LETTER_SPACING, Float.valueOf(f16.floatValue()));
        }
        aj ajVar = style.getCom.google.android.exoplayer2.text.ttml.TtmlNode.ATTR_TTS_TEXT_DECORATION java.lang.String();
        if (ajVar != null) {
            int mask = ajVar.getMask();
            aj.Companion companion = aj.INSTANCE;
            if (mask == companion.a()) {
                ceVar.textDecorationLineThrough();
            } else if (mask == companion.c()) {
                ceVar.textDecorationUnderLine();
            } else {
                ceVar.with(TtmlNode.ATTR_TTS_TEXT_DECORATION, "");
            }
        }
        Shadow shadow = style.getShadow();
        if (shadow != null) {
            ceVar.textShadow(shadow.getOffset().getX(), shadow.getOffset().getY(), shadow.getBlurRadius(), shadow.getColor());
        }
        ai textAlign = style.getTextAlign();
        if (textAlign != null) {
            int value = textAlign.getValue();
            ai.Companion companion2 = ai.INSTANCE;
            if (value != companion2.d() && value != companion2.b()) {
                if (value != companion2.a() && value != companion2.a()) {
                    ceVar.textAlignLeft();
                } else {
                    ceVar.textAlignCenter();
                }
            } else {
                ceVar.textAlignRight();
            }
        }
        Float f17 = style.getCom.tencent.mtt.hippy.dom.node.NodeProps.LINE_HEIGHT java.lang.String();
        if (f17 != null) {
            ceVar.lineHeight(f17.floatValue());
        }
        Float lineSpacing = style.getLineSpacing();
        if (lineSpacing != null) {
            ceVar.lineSpacing(lineSpacing.floatValue());
        }
        Float paragraphSpacing = style.getParagraphSpacing();
        if (paragraphSpacing != null) {
            ceVar.paragraphSpacing(paragraphSpacing.floatValue());
        }
        style.n();
        bp3.c fontWeight = style.getFontWeight();
        if (fontWeight != null) {
            if (fontWeight.getWeight() <= 300) {
                ceVar.fontWeight300();
            } else if (fontWeight.getWeight() <= 400) {
                ceVar.fontWeight400();
            } else if (fontWeight.getWeight() == 500) {
                ceVar.fontWeight500();
            } else if (fontWeight.getWeight() == 600) {
                ceVar.fontWeight600();
            } else if (fontWeight.getWeight() >= 700) {
                ceVar.fontWeight700();
            } else {
                ceVar.fontWeight400();
            }
        }
        ao stroke = style.getStroke();
        if (stroke != null) {
            ceVar.textStroke(stroke.getColor(), stroke.getWidth());
        }
    }
}
