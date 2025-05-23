package com.tencent.ntcompose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.KeyboardOptions;
import com.tencent.kuikly.core.views.InputEvent;
import com.tencent.kuikly.core.views.InputParams;
import com.tencent.kuikly.core.views.KeyboardParams;
import com.tencent.kuikly.core.views.TextAreaEvent;
import com.tencent.kuikly.core.views.cc;
import com.tencent.ntcompose.core.ComposeNodeKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import cp3.a;
import cp3.c;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import yo3.Size;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u00fe\u0002\u0010(\u001a\u00020\u00052\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\t2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e\u00a2\u0006\u0002\b\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\t2\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042%\b\u0002\u0010#\u001a\u001f\u0012\u0013\u0012\u00110\u001f\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\b\u0002\u0010$\u001a\u00020\t2%\b\u0002\u0010%\u001a\u001f\u0012\u0013\u0012\u00110\u001f\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\b\u0002\u0010'\u001a\u00020\tH\u0007\u00a2\u0006\u0004\b(\u0010)\u001a\u0014\u0010,\u001a\u00020\u0005*\u00020*2\u0006\u0010+\u001a\u00020\u000bH\u0000\u001a\u0014\u0010.\u001a\u00020\u0005*\u00020*2\u0006\u0010-\u001a\u00020\u0013H\u0000\u001a\"\u00102\u001a\u00020\u0005*\u00020/2\u0006\u00100\u001a\u00020\u00152\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00000\u000eH\u0000\u001a\u0014\u00104\u001a\u00020**\u00020*2\u0006\u00103\u001a\u00020\u0017H\u0002\u001a\u0014\u00106\u001a\u00020\u0005*\u0002052\u0006\u0010+\u001a\u00020\u000bH\u0000\u001a\u0014\u00107\u001a\u00020\u0005*\u0002052\u0006\u0010-\u001a\u00020\u0013H\u0000\u001a\"\u00109\u001a\u00020\u0005*\u0002082\u0006\u00100\u001a\u00020\u00152\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00000\u000eH\u0000\u001a\u0014\u0010:\u001a\u000205*\u0002052\u0006\u00103\u001a\u00020\u0017H\u0002\u00a8\u0006;"}, d2 = {"", "value", "Lcom/tencent/ntcompose/material/ak;", "state", "Lkotlin/Function1;", "", "onValueChange", "Lcom/tencent/ntcompose/core/i;", "modifier", "", "readOnly", "Lbp3/k;", "textStyle", "singleLine", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "Lcom/tencent/kuikly/core/base/h;", "cursorColor", "Lbp3/g;", "keyboardOptions", "Lbp3/e;", "keyboardActions", "", "maxInputLength", "autoFocus", "onReachMaxInputLength", "onReturnAction", "syncKeyboardHeightChangeEvent", "Lcom/tencent/kuikly/core/views/an;", "onKeyboardHeightChange", "Lyo3/d;", "Lkotlin/ParameterName;", "name", "size", "onInputTextSizeChanged", "syncInputTextSizeChanged", "onInputTextSizeChangedV2", "onFocusChanged", "onlyUseDefaultTextView", "a", "(Ljava/lang/String;Lcom/tencent/ntcompose/material/ak;Lkotlin/jvm/functions/Function1;Lcom/tencent/ntcompose/core/i;Ljava/lang/Boolean;Lbp3/k;ZLkotlin/jvm/functions/Function2;Lcom/tencent/kuikly/core/base/h;Lbp3/g;Lbp3/e;Ljava/lang/Integer;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;IIII)V", "Lcom/tencent/kuikly/core/views/cc;", "style", "i", "options", "g", "Lcom/tencent/kuikly/core/views/TextAreaEvent;", "actions", "getReturnKeyType", "e", "weight", "c", "Lcom/tencent/kuikly/core/views/ai;", tl.h.F, "f", "Lcom/tencent/kuikly/core/views/InputEvent;", "d", "b", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class TextFieldKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x048d  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x04bc  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x04e8  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0514  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0540  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x056c  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x05a1  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x05d6  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0602  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x062e  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x065d  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x068c  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x06c9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0739  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x075e  */
    /* JADX WARN: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(String str, ak akVar, Function1<? super String, Unit> function1, com.tencent.ntcompose.core.i iVar, Boolean bool, bp3.k kVar, boolean z16, Function2<? super Composer, ? super Integer, Unit> function2, com.tencent.kuikly.core.base.h hVar, KeyboardOptions keyboardOptions, bp3.e eVar, Integer num, Boolean bool2, Function0<Unit> function0, Function0<Unit> function02, boolean z17, Function1<? super KeyboardParams, Unit> function12, Function1<? super Size, Unit> function13, boolean z18, Function1<? super Size, Unit> function14, Function1<? super Boolean, Unit> function15, boolean z19, Composer composer, final int i3, final int i16, final int i17, final int i18) {
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
        boolean z26;
        int i68;
        int i69;
        int i75;
        int i76;
        String str2;
        final ak akVar2;
        Boolean bool3;
        bp3.k kVar2;
        Function2<? super Composer, ? super Integer, Unit> function22;
        com.tencent.kuikly.core.base.h hVar2;
        KeyboardOptions keyboardOptions2;
        bp3.e eVar2;
        Integer num2;
        Boolean bool4;
        Function0<Unit> function03;
        Function0<Unit> function04;
        Function1<? super KeyboardParams, Unit> function16;
        Function1<? super Size, Unit> function17;
        Function1<? super Size, Unit> function18;
        Function1<? super Boolean, Unit> function19;
        boolean z27;
        com.tencent.ntcompose.core.i iVar2;
        Object rememberedValue;
        Composer.Companion companion;
        int i77;
        boolean changed;
        Object rememberedValue2;
        final boolean z28;
        final ComposableLambda composableLambda;
        final com.tencent.ntcompose.core.i iVar3;
        com.tencent.kuikly.core.base.h hVar3;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        Integer num3;
        final com.tencent.ntcompose.core.i iVar4;
        final bp3.k kVar3;
        final Function1<? super Size, Unit> function110;
        final com.tencent.kuikly.core.base.h hVar4;
        bp3.e eVar3;
        final Boolean bool5;
        final Function1<? super Size, Unit> function111;
        final Function0<Unit> function05;
        final boolean z29;
        final Function1<? super KeyboardParams, Unit> function112;
        final boolean z36;
        final boolean z37;
        Boolean bool6;
        KeyboardOptions keyboardOptions3;
        final Function1<? super String, Unit> function113;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-556281067);
        int i78 = i18 & 1;
        if (i78 != 0) {
            i19 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i19 = (startRestartGroup.changed(str) ? 4 : 2) | i3;
        } else {
            i19 = i3;
        }
        int i79 = i18 & 2;
        if (i79 != 0) {
            i19 |= 16;
        }
        int i85 = i18 & 4;
        if (i85 != 0) {
            i19 |= MsgConstant.KRMFILETHUMBSIZE384;
        } else if ((i3 & 896) == 0) {
            i19 |= startRestartGroup.changed(function1) ? 256 : 128;
            i26 = i18 & 8;
            if (i26 == 0) {
                i19 |= 3072;
            } else if ((i3 & 7168) == 0) {
                i19 |= startRestartGroup.changed(iVar) ? 2048 : 1024;
                i27 = i18 & 16;
                if (i27 != 0) {
                    i19 |= 24576;
                } else if ((i3 & 57344) == 0) {
                    i19 |= startRestartGroup.changed(bool) ? 16384 : 8192;
                }
                i28 = i18 & 32;
                if (i28 != 0) {
                    i19 |= 65536;
                }
                i29 = i18 & 64;
                if (i29 != 0) {
                    i19 |= 1572864;
                } else if ((i3 & 3670016) == 0) {
                    i19 |= startRestartGroup.changed(z16) ? 1048576 : 524288;
                }
                i36 = i18 & 128;
                if (i36 != 0) {
                    i19 |= 12582912;
                } else if ((i3 & 29360128) == 0) {
                    i19 |= startRestartGroup.changed(function2) ? 8388608 : 4194304;
                }
                i37 = i18 & 256;
                if (i37 != 0) {
                    i19 |= 33554432;
                }
                i38 = i18 & 512;
                if (i38 != 0) {
                    i19 |= 805306368;
                } else if ((i3 & 1879048192) == 0) {
                    i19 |= startRestartGroup.changed(keyboardOptions) ? 536870912 : 268435456;
                }
                i39 = i18 & 1024;
                if (i39 != 0) {
                    i46 = i16 | 6;
                } else if ((i16 & 14) == 0) {
                    i46 = i16 | (startRestartGroup.changed(eVar) ? 4 : 2);
                } else {
                    i46 = i16;
                }
                i47 = i18 & 2048;
                if (i47 != 0) {
                    i46 |= 48;
                } else if ((i16 & 112) == 0) {
                    i46 |= startRestartGroup.changed(num) ? 32 : 16;
                }
                int i86 = i46;
                i48 = i18 & 4096;
                if (i48 != 0) {
                    i86 |= MsgConstant.KRMFILETHUMBSIZE384;
                } else if ((i16 & 896) == 0) {
                    i86 |= startRestartGroup.changed(bool2) ? 256 : 128;
                    i49 = i18 & 8192;
                    if (i49 == 0) {
                        i86 |= 3072;
                        i56 = i49;
                    } else {
                        i56 = i49;
                        if ((i16 & 7168) == 0) {
                            i86 |= startRestartGroup.changed(function0) ? 2048 : 1024;
                            i57 = i18 & 16384;
                            if (i57 != 0) {
                                i86 |= 24576;
                            } else if ((i16 & 57344) == 0) {
                                i58 = i57;
                                i86 |= startRestartGroup.changed(function02) ? 16384 : 8192;
                                i59 = i18 & 32768;
                                if (i59 == 0) {
                                    i86 |= 196608;
                                } else if ((i16 & 458752) == 0) {
                                    i86 |= startRestartGroup.changed(z17) ? 131072 : 65536;
                                }
                                i65 = i18 & 65536;
                                if (i65 == 0) {
                                    i86 |= 1572864;
                                } else if ((i16 & 3670016) == 0) {
                                    i86 |= startRestartGroup.changed(function12) ? 1048576 : 524288;
                                }
                                i66 = i18 & 131072;
                                if (i66 == 0) {
                                    i86 |= 12582912;
                                } else if ((i16 & 29360128) == 0) {
                                    i86 |= startRestartGroup.changed(function13) ? 8388608 : 4194304;
                                }
                                i67 = i18 & 262144;
                                if (i67 == 0) {
                                    i86 |= 100663296;
                                    z26 = z18;
                                } else {
                                    z26 = z18;
                                    if ((i16 & 234881024) == 0) {
                                        i86 |= startRestartGroup.changed(z26) ? 67108864 : 33554432;
                                    }
                                }
                                i68 = i18 & 524288;
                                if (i68 == 0) {
                                    i86 |= 805306368;
                                } else if ((i16 & 1879048192) == 0) {
                                    i86 |= startRestartGroup.changed(function14) ? 536870912 : 268435456;
                                }
                                i69 = i18 & 1048576;
                                if (i69 == 0) {
                                    i75 = i17 | 6;
                                } else if ((i17 & 14) == 0) {
                                    i75 = i17 | (startRestartGroup.changed(function15) ? 4 : 2);
                                } else {
                                    i75 = i17;
                                }
                                i76 = i18 & 2097152;
                                if (i76 == 0) {
                                    i75 |= 48;
                                } else if ((i17 & 112) == 0) {
                                    i75 |= startRestartGroup.changed(z19) ? 32 : 16;
                                }
                                if ((i18 & 290) != 290 && (1533916891 & i19) == 306783378 && (1533916891 & i86) == 306783378 && (i75 & 91) == 18 && startRestartGroup.getSkipping()) {
                                    startRestartGroup.skipToGroupEnd();
                                    str2 = str;
                                    akVar2 = akVar;
                                    function113 = function1;
                                    iVar4 = iVar;
                                    bool5 = bool;
                                    kVar3 = kVar;
                                    z28 = z16;
                                    function23 = function2;
                                    hVar4 = hVar;
                                    keyboardOptions3 = keyboardOptions;
                                    eVar3 = eVar;
                                    num3 = num;
                                    bool6 = bool2;
                                    function03 = function0;
                                    z29 = z17;
                                    function112 = function12;
                                    function110 = function13;
                                    function111 = function14;
                                    function19 = function15;
                                    z37 = z19;
                                    z36 = z26;
                                    function05 = function02;
                                } else {
                                    str2 = i78 == 0 ? null : str;
                                    akVar2 = i79 == 0 ? null : akVar;
                                    final Function1<? super String, Unit> function114 = i85 == 0 ? null : function1;
                                    com.tencent.ntcompose.core.i iVar5 = i26 == 0 ? com.tencent.ntcompose.core.i.INSTANCE : iVar;
                                    bool3 = i27 == 0 ? null : bool;
                                    kVar2 = i28 == 0 ? null : kVar;
                                    boolean z38 = i29 == 0 ? false : z16;
                                    function22 = i36 == 0 ? null : function2;
                                    hVar2 = i37 == 0 ? null : hVar;
                                    keyboardOptions2 = i38 == 0 ? null : keyboardOptions;
                                    eVar2 = i39 == 0 ? null : eVar;
                                    num2 = i47 == 0 ? null : num;
                                    bool4 = i48 == 0 ? null : bool2;
                                    function03 = i56 == 0 ? null : function0;
                                    function04 = i58 == 0 ? null : function02;
                                    boolean z39 = i59 == 0 ? false : z17;
                                    function16 = i65 == 0 ? null : function12;
                                    function17 = i66 == 0 ? null : function13;
                                    boolean z46 = i67 == 0 ? z26 : false;
                                    function18 = i68 == 0 ? null : function14;
                                    function19 = i69 == 0 ? null : function15;
                                    z27 = i76 == 0 ? true : z19;
                                    if (ComposerKt.isTraceInProgress()) {
                                        iVar2 = iVar5;
                                    } else {
                                        iVar2 = iVar5;
                                        ComposerKt.traceEventStart(-556281067, i19, i86, "com.tencent.ntcompose.material.TextField (TextField.kt:170)");
                                    }
                                    startRestartGroup.startReplaceableGroup(-492369756);
                                    rememberedValue = startRestartGroup.rememberedValue();
                                    companion = Composer.INSTANCE;
                                    final int i87 = i86;
                                    if (rememberedValue != companion.getEmpty()) {
                                        i77 = i19;
                                        rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str2 == null ? "" : str2, null, 2, null);
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    } else {
                                        i77 = i19;
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    final MutableState mutableState = (MutableState) rememberedValue;
                                    Function1<InputParams, Unit> function115 = new Function1<InputParams, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$TextField$nOnValueChange$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(InputParams inputParams) {
                                            invoke2(inputParams);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(InputParams it) {
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            mutableState.setValue(it.getText());
                                            ak akVar3 = akVar2;
                                            if (akVar3 != null) {
                                                String text = it.getText();
                                                Integer inputLength = it.getInputLength();
                                                akVar3.b(text, inputLength != null ? inputLength.intValue() : it.getText().length());
                                            }
                                            Function1<String, Unit> function116 = function114;
                                            if (function116 != null) {
                                                function116.invoke(it.getText());
                                            }
                                        }
                                    };
                                    startRestartGroup.startReplaceableGroup(1157296644);
                                    changed = startRestartGroup.changed(mutableState);
                                    Function1<? super String, Unit> function116 = function114;
                                    rememberedValue2 = startRestartGroup.rememberedValue();
                                    if (!changed || rememberedValue2 == companion.getEmpty()) {
                                        rememberedValue2 = new Function1<InputParams, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$TextField$onValueWillChange$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(InputParams inputParams) {
                                                invoke2(inputParams);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(InputParams it) {
                                                Intrinsics.checkNotNullParameter(it, "it");
                                                mutableState.setValue(it.getText());
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue2);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    Function1 function117 = (Function1) rememberedValue2;
                                    final ArrayList arrayList = new ArrayList();
                                    if (str2 != null) {
                                        arrayList.add(new com.tencent.ntcompose.core.k("value", str2, null, null, null, null, TextFieldViewPropUpdater.f339356a, 60, null));
                                    }
                                    if (akVar2 != null) {
                                        arrayList.add(new com.tencent.ntcompose.core.k("state", akVar2, null, null, null, null, TextFieldViewPropUpdater.f339356a, 60, null));
                                    }
                                    TextFieldViewPropUpdater textFieldViewPropUpdater = TextFieldViewPropUpdater.f339356a;
                                    arrayList.add(new com.tencent.ntcompose.core.k("onValueChange", function115, null, null, null, null, textFieldViewPropUpdater, 60, null));
                                    arrayList.add(new com.tencent.ntcompose.core.k("textWillChange", function117, null, null, null, null, textFieldViewPropUpdater, 60, null));
                                    if (bool3 != null) {
                                        bool3.booleanValue();
                                        arrayList.add(new com.tencent.ntcompose.core.k("readOnly", bool3, null, null, null, null, textFieldViewPropUpdater, 60, null));
                                    }
                                    if (kVar2 != null) {
                                        arrayList.add(new com.tencent.ntcompose.core.k("textStyle", kVar2, null, null, null, null, textFieldViewPropUpdater, 60, null));
                                    }
                                    if (keyboardOptions2 != null) {
                                        arrayList.add(new com.tencent.ntcompose.core.k("keyboardOptions", keyboardOptions2, null, null, null, null, textFieldViewPropUpdater, 60, null));
                                    }
                                    if (eVar2 != null) {
                                        arrayList.add(new com.tencent.ntcompose.core.k("keyboardActions", eVar2, null, null, null, null, textFieldViewPropUpdater, 60, null));
                                    }
                                    if (hVar2 != null) {
                                        arrayList.add(new com.tencent.ntcompose.core.k("cursorColor", hVar2, null, null, null, null, textFieldViewPropUpdater, 60, null));
                                    }
                                    if (num2 != null) {
                                        arrayList.add(new com.tencent.ntcompose.core.k("maxInputLength", Integer.valueOf(num2.intValue()), null, null, null, null, textFieldViewPropUpdater, 60, null));
                                    }
                                    if (bool4 != null) {
                                        arrayList.add(new com.tencent.ntcompose.core.k("autoFocus", Boolean.valueOf(bool4.booleanValue()), null, null, null, null, textFieldViewPropUpdater, 60, null));
                                    }
                                    if (function03 != null) {
                                        arrayList.add(new com.tencent.ntcompose.core.k("onReachMaxInputLength", function03, null, null, null, null, textFieldViewPropUpdater, 60, null));
                                    }
                                    if (function04 != null) {
                                        arrayList.add(new com.tencent.ntcompose.core.k("onReturnAction", function04, null, null, null, null, textFieldViewPropUpdater, 60, null));
                                    }
                                    if (function16 != null) {
                                        arrayList.add(new com.tencent.ntcompose.core.k("onKeyboardHeightChange", function16, Boolean.valueOf(z39), null, null, null, textFieldViewPropUpdater, 56, null));
                                    }
                                    if (function18 != null) {
                                        arrayList.add(new com.tencent.ntcompose.core.k("textContentSizeChanged", function18, Boolean.valueOf(z46), null, null, null, textFieldViewPropUpdater, 56, null));
                                    }
                                    if (function19 != null) {
                                        arrayList.add(new com.tencent.ntcompose.core.k("onFocusChanged", function19, null, null, null, null, textFieldViewPropUpdater, 60, null));
                                        Unit unit = Unit.INSTANCE;
                                    }
                                    z28 = z38;
                                    composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, -2062754826, true, new Function3<com.tencent.ntcompose.core.i, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$TextField$textFieldBuilder$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.core.i iVar6, Composer composer2, Integer num4) {
                                            invoke(iVar6, composer2, num4.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(com.tencent.ntcompose.core.i it, Composer composer2, int i88) {
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            if ((i88 & 14) == 0) {
                                                i88 |= composer2.changed(it) ? 4 : 2;
                                            }
                                            if ((i88 & 91) == 18 && composer2.getSkipping()) {
                                                composer2.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2062754826, i88, -1, "com.tencent.ntcompose.material.TextField.<anonymous> (TextField.kt:266)");
                                            }
                                            if (z28) {
                                                composer2.startReplaceableGroup(617596452);
                                                ComposeNodeKt.a("input", com.tencent.ntcompose.material.base.a.f339408a, null, it, arrayList, null, composer2, ((i88 << 9) & 7168) | 33206, 32);
                                                composer2.endReplaceableGroup();
                                            } else {
                                                composer2.startReplaceableGroup(617596687);
                                                ComposeNodeKt.a("text_area", com.tencent.ntcompose.material.base.a.f339408a, null, it, arrayList, null, composer2, ((i88 << 9) & 7168) | 33206, 32);
                                                composer2.endReplaceableGroup();
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    });
                                    if (function22 != null && function17 == null) {
                                        startRestartGroup.startReplaceableGroup(-1779946418);
                                        iVar3 = iVar2;
                                        composableLambda.invoke(iVar3, startRestartGroup, Integer.valueOf(((i77 >> 9) & 14) | 48));
                                        startRestartGroup.endReplaceableGroup();
                                        hVar3 = hVar2;
                                    } else {
                                        iVar3 = iVar2;
                                        startRestartGroup.startReplaceableGroup(-1779947234);
                                        hVar3 = hVar2;
                                        final Function1<? super Size, Unit> function118 = function17;
                                        final Function2<? super Composer, ? super Integer, Unit> function24 = function22;
                                        final int i88 = i77;
                                        final bp3.k kVar4 = kVar2;
                                        final boolean z47 = z27;
                                        final int i89 = i75;
                                        BoxKt.a(ModifiersKt.s(iVar3), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1958109908, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$TextField$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer2, Integer num4) {
                                                invoke(bVar, composer2, num4.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(com.tencent.ntcompose.foundation.layout.b Box, Composer composer2, int i95) {
                                                Function2<Composer, Integer, Unit> function25;
                                                Intrinsics.checkNotNullParameter(Box, "$this$Box");
                                                if ((i95 & 81) == 16 && composer2.getSkipping()) {
                                                    composer2.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1958109908, i95, -1, "com.tencent.ntcompose.material.TextField.<anonymous> (TextField.kt:287)");
                                                }
                                                Function1<Size, Unit> function119 = function118;
                                                composer2.startReplaceableGroup(617597081);
                                                if (function119 != null) {
                                                    final MutableState<String> mutableState2 = mutableState;
                                                    final bp3.k kVar5 = kVar4;
                                                    final Function1<Size, Unit> function120 = function118;
                                                    final int i96 = i87;
                                                    final boolean z48 = z47;
                                                    final int i97 = i89;
                                                    BoxKt.a(ModifiersKt.R(ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), false), null, null, ComposableLambdaKt.composableLambda(composer2, 1272142184, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$TextField$1$1$1
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer3, Integer num4) {
                                                            invoke(bVar, composer3, num4.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(com.tencent.ntcompose.foundation.layout.b Box2, Composer composer3, int i98) {
                                                            bp3.c b16;
                                                            Float fontSize;
                                                            Float fontSize2;
                                                            Intrinsics.checkNotNullParameter(Box2, "$this$Box");
                                                            if ((i98 & 81) == 16 && composer3.getSkipping()) {
                                                                composer3.skipToGroupEnd();
                                                                return;
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(1272142184, i98, -1, "com.tencent.ntcompose.material.TextField.<anonymous>.<anonymous>.<anonymous> (TextField.kt:289)");
                                                            }
                                                            String value = mutableState2.getValue();
                                                            bp3.k kVar6 = kVar5;
                                                            float f16 = 15.0f;
                                                            float floatValue = (kVar6 == null || (fontSize2 = kVar6.getFontSize()) == null) ? 15.0f : fontSize2.floatValue();
                                                            bp3.k kVar7 = kVar5;
                                                            if (kVar7 != null && (fontSize = kVar7.getFontSize()) != null) {
                                                                f16 = fontSize.floatValue();
                                                            }
                                                            float f17 = f16 * 1.2f;
                                                            bp3.k kVar8 = kVar5;
                                                            if (kVar8 == null || (b16 = kVar8.getFontWeight()) == null) {
                                                                b16 = bp3.c.INSTANCE.b();
                                                            }
                                                            bp3.c cVar = b16;
                                                            Float valueOf = Float.valueOf(floatValue);
                                                            Float valueOf2 = Float.valueOf(f17);
                                                            final Function1<Size, Unit> function121 = function120;
                                                            composer3.startReplaceableGroup(1157296644);
                                                            boolean changed2 = composer3.changed(function121);
                                                            Object rememberedValue3 = composer3.rememberedValue();
                                                            if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                                rememberedValue3 = new Function1<am, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$TextField$1$1$1$1$1
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
                                                                        Function1<Size, Unit> function122 = function121;
                                                                        if (function122 != null) {
                                                                            function122.invoke(new Size(it.getFrame().getWidth(), it.getFrame().getHeight()));
                                                                        }
                                                                    }
                                                                };
                                                                composer3.updateRememberedValue(rememberedValue3);
                                                            }
                                                            composer3.endReplaceableGroup();
                                                            TextKt.a(value, null, null, null, valueOf, null, cVar, null, null, null, null, valueOf2, null, null, null, null, null, null, null, (Function1) rememberedValue3, null, null, null, null, null, null, z48, composer3, 0, 0, (i97 << 15) & 3670016, 66582446);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                    }), composer2, 3072, 6);
                                                }
                                                composer2.endReplaceableGroup();
                                                composer2.startReplaceableGroup(617597587);
                                                if ((mutableState.getValue().length() == 0) && (function25 = function24) != null) {
                                                    function25.invoke(composer2, Integer.valueOf((i88 >> 21) & 14));
                                                }
                                                composer2.endReplaceableGroup();
                                                Function3<com.tencent.ntcompose.core.i, Composer, Integer, Unit> function3 = composableLambda;
                                                com.tencent.ntcompose.core.i iVar6 = com.tencent.ntcompose.core.i.INSTANCE;
                                                com.tencent.ntcompose.core.i h16 = ComposeLayoutPropUpdaterKt.h(iVar6, 0.0f, 1, null);
                                                com.tencent.ntcompose.core.i a16 = com.tencent.ntcompose.core.ModifiersKt.a(iVar3, "onFocusChanged");
                                                if (a16 != null) {
                                                    iVar6 = a16;
                                                }
                                                function3.invoke(h16.b(iVar6), composer2, 48);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }), startRestartGroup, 3072, 6);
                                        startRestartGroup.endReplaceableGroup();
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    function23 = function22;
                                    num3 = num2;
                                    iVar4 = iVar3;
                                    kVar3 = kVar2;
                                    function110 = function17;
                                    hVar4 = hVar3;
                                    eVar3 = eVar2;
                                    bool5 = bool3;
                                    function111 = function18;
                                    function05 = function04;
                                    z29 = z39;
                                    function112 = function16;
                                    z36 = z46;
                                    z37 = z27;
                                    bool6 = bool4;
                                    keyboardOptions3 = keyboardOptions2;
                                    function113 = function116;
                                }
                                endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup != null) {
                                    return;
                                }
                                final String str3 = str2;
                                final ak akVar3 = akVar2;
                                final boolean z48 = z28;
                                final KeyboardOptions keyboardOptions4 = keyboardOptions3;
                                final bp3.e eVar4 = eVar3;
                                final Integer num4 = num3;
                                final Boolean bool7 = bool6;
                                final Function0<Unit> function06 = function03;
                                final Function1<? super Boolean, Unit> function119 = function19;
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$TextField$2
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num5) {
                                        invoke(composer2, num5.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer2, int i95) {
                                        TextFieldKt.a(str3, akVar3, function113, iVar4, bool5, kVar3, z48, function23, hVar4, keyboardOptions4, eVar4, num4, bool7, function06, function05, z29, function112, function110, z36, function111, function119, z37, composer2, i3 | 1, i16, i17, i18);
                                    }
                                });
                                return;
                            }
                            i58 = i57;
                            i59 = i18 & 32768;
                            if (i59 == 0) {
                            }
                            i65 = i18 & 65536;
                            if (i65 == 0) {
                            }
                            i66 = i18 & 131072;
                            if (i66 == 0) {
                            }
                            i67 = i18 & 262144;
                            if (i67 == 0) {
                            }
                            i68 = i18 & 524288;
                            if (i68 == 0) {
                            }
                            i69 = i18 & 1048576;
                            if (i69 == 0) {
                            }
                            i76 = i18 & 2097152;
                            if (i76 == 0) {
                            }
                            if ((i18 & 290) != 290) {
                            }
                            if (i78 == 0) {
                            }
                            if (i79 == 0) {
                            }
                            if (i85 == 0) {
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
                            if (i47 == 0) {
                            }
                            if (i48 == 0) {
                            }
                            if (i56 == 0) {
                            }
                            if (i58 == 0) {
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
                            if (i76 == 0) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            startRestartGroup.startReplaceableGroup(-492369756);
                            rememberedValue = startRestartGroup.rememberedValue();
                            companion = Composer.INSTANCE;
                            final int i872 = i86;
                            if (rememberedValue != companion.getEmpty()) {
                            }
                            startRestartGroup.endReplaceableGroup();
                            final MutableState<String> mutableState2 = (MutableState) rememberedValue;
                            Function1<InputParams, Unit> function1152 = new Function1<InputParams, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$TextField$nOnValueChange$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(InputParams inputParams) {
                                    invoke2(inputParams);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(InputParams it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    mutableState2.setValue(it.getText());
                                    ak akVar32 = akVar2;
                                    if (akVar32 != null) {
                                        String text = it.getText();
                                        Integer inputLength = it.getInputLength();
                                        akVar32.b(text, inputLength != null ? inputLength.intValue() : it.getText().length());
                                    }
                                    Function1<String, Unit> function1162 = function114;
                                    if (function1162 != null) {
                                        function1162.invoke(it.getText());
                                    }
                                }
                            };
                            startRestartGroup.startReplaceableGroup(1157296644);
                            changed = startRestartGroup.changed(mutableState2);
                            Function1<? super String, Unit> function1162 = function114;
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (!changed) {
                            }
                            rememberedValue2 = new Function1<InputParams, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$TextField$onValueWillChange$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(InputParams inputParams) {
                                    invoke2(inputParams);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(InputParams it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    mutableState2.setValue(it.getText());
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                            startRestartGroup.endReplaceableGroup();
                            Function1 function1172 = (Function1) rememberedValue2;
                            final ArrayList<com.tencent.ntcompose.core.k> arrayList2 = new ArrayList();
                            if (str2 != null) {
                            }
                            if (akVar2 != null) {
                            }
                            TextFieldViewPropUpdater textFieldViewPropUpdater2 = TextFieldViewPropUpdater.f339356a;
                            arrayList2.add(new com.tencent.ntcompose.core.k("onValueChange", function1152, null, null, null, null, textFieldViewPropUpdater2, 60, null));
                            arrayList2.add(new com.tencent.ntcompose.core.k("textWillChange", function1172, null, null, null, null, textFieldViewPropUpdater2, 60, null));
                            if (bool3 != null) {
                            }
                            if (kVar2 != null) {
                            }
                            if (keyboardOptions2 != null) {
                            }
                            if (eVar2 != null) {
                            }
                            if (hVar2 != null) {
                            }
                            if (num2 != null) {
                            }
                            if (bool4 != null) {
                            }
                            if (function03 != null) {
                            }
                            if (function04 != null) {
                            }
                            if (function16 != null) {
                            }
                            if (function18 != null) {
                            }
                            if (function19 != null) {
                            }
                            z28 = z38;
                            composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, -2062754826, true, new Function3<com.tencent.ntcompose.core.i, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$TextField$textFieldBuilder$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.core.i iVar6, Composer composer2, Integer num42) {
                                    invoke(iVar6, composer2, num42.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(com.tencent.ntcompose.core.i it, Composer composer2, int i882) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    if ((i882 & 14) == 0) {
                                        i882 |= composer2.changed(it) ? 4 : 2;
                                    }
                                    if ((i882 & 91) == 18 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2062754826, i882, -1, "com.tencent.ntcompose.material.TextField.<anonymous> (TextField.kt:266)");
                                    }
                                    if (z28) {
                                        composer2.startReplaceableGroup(617596452);
                                        ComposeNodeKt.a("input", com.tencent.ntcompose.material.base.a.f339408a, null, it, arrayList2, null, composer2, ((i882 << 9) & 7168) | 33206, 32);
                                        composer2.endReplaceableGroup();
                                    } else {
                                        composer2.startReplaceableGroup(617596687);
                                        ComposeNodeKt.a("text_area", com.tencent.ntcompose.material.base.a.f339408a, null, it, arrayList2, null, composer2, ((i882 << 9) & 7168) | 33206, 32);
                                        composer2.endReplaceableGroup();
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            });
                            if (function22 != null) {
                            }
                            iVar3 = iVar2;
                            startRestartGroup.startReplaceableGroup(-1779947234);
                            hVar3 = hVar2;
                            final Function1<? super Size, Unit> function1182 = function17;
                            final Function2<? super Composer, ? super Integer, Unit> function242 = function22;
                            final int i882 = i77;
                            final bp3.k kVar42 = kVar2;
                            final boolean z472 = z27;
                            final int i892 = i75;
                            BoxKt.a(ModifiersKt.s(iVar3), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1958109908, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$TextField$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer2, Integer num42) {
                                    invoke(bVar, composer2, num42.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(com.tencent.ntcompose.foundation.layout.b Box, Composer composer2, int i95) {
                                    Function2<Composer, Integer, Unit> function25;
                                    Intrinsics.checkNotNullParameter(Box, "$this$Box");
                                    if ((i95 & 81) == 16 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1958109908, i95, -1, "com.tencent.ntcompose.material.TextField.<anonymous> (TextField.kt:287)");
                                    }
                                    Function1<Size, Unit> function1192 = function1182;
                                    composer2.startReplaceableGroup(617597081);
                                    if (function1192 != null) {
                                        final MutableState<String> mutableState22 = mutableState2;
                                        final bp3.k kVar5 = kVar42;
                                        final Function1<? super Size, Unit> function120 = function1182;
                                        final int i96 = i872;
                                        final boolean z482 = z472;
                                        final int i97 = i892;
                                        BoxKt.a(ModifiersKt.R(ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), false), null, null, ComposableLambdaKt.composableLambda(composer2, 1272142184, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$TextField$1$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer3, Integer num42) {
                                                invoke(bVar, composer3, num42.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(com.tencent.ntcompose.foundation.layout.b Box2, Composer composer3, int i98) {
                                                bp3.c b16;
                                                Float fontSize;
                                                Float fontSize2;
                                                Intrinsics.checkNotNullParameter(Box2, "$this$Box");
                                                if ((i98 & 81) == 16 && composer3.getSkipping()) {
                                                    composer3.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1272142184, i98, -1, "com.tencent.ntcompose.material.TextField.<anonymous>.<anonymous>.<anonymous> (TextField.kt:289)");
                                                }
                                                String value = mutableState22.getValue();
                                                bp3.k kVar6 = kVar5;
                                                float f16 = 15.0f;
                                                float floatValue = (kVar6 == null || (fontSize2 = kVar6.getFontSize()) == null) ? 15.0f : fontSize2.floatValue();
                                                bp3.k kVar7 = kVar5;
                                                if (kVar7 != null && (fontSize = kVar7.getFontSize()) != null) {
                                                    f16 = fontSize.floatValue();
                                                }
                                                float f17 = f16 * 1.2f;
                                                bp3.k kVar8 = kVar5;
                                                if (kVar8 == null || (b16 = kVar8.getFontWeight()) == null) {
                                                    b16 = bp3.c.INSTANCE.b();
                                                }
                                                bp3.c cVar = b16;
                                                Float valueOf = Float.valueOf(floatValue);
                                                Float valueOf2 = Float.valueOf(f17);
                                                final Function1<? super Size, Unit> function121 = function120;
                                                composer3.startReplaceableGroup(1157296644);
                                                boolean changed2 = composer3.changed(function121);
                                                Object rememberedValue3 = composer3.rememberedValue();
                                                if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue3 = new Function1<am, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$TextField$1$1$1$1$1
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
                                                            Function1<Size, Unit> function122 = function121;
                                                            if (function122 != null) {
                                                                function122.invoke(new Size(it.getFrame().getWidth(), it.getFrame().getHeight()));
                                                            }
                                                        }
                                                    };
                                                    composer3.updateRememberedValue(rememberedValue3);
                                                }
                                                composer3.endReplaceableGroup();
                                                TextKt.a(value, null, null, null, valueOf, null, cVar, null, null, null, null, valueOf2, null, null, null, null, null, null, null, (Function1) rememberedValue3, null, null, null, null, null, null, z482, composer3, 0, 0, (i97 << 15) & 3670016, 66582446);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }), composer2, 3072, 6);
                                    }
                                    composer2.endReplaceableGroup();
                                    composer2.startReplaceableGroup(617597587);
                                    if ((mutableState2.getValue().length() == 0) && (function25 = function242) != null) {
                                        function25.invoke(composer2, Integer.valueOf((i882 >> 21) & 14));
                                    }
                                    composer2.endReplaceableGroup();
                                    Function3<com.tencent.ntcompose.core.i, Composer, Integer, Unit> function3 = composableLambda;
                                    com.tencent.ntcompose.core.i iVar6 = com.tencent.ntcompose.core.i.INSTANCE;
                                    com.tencent.ntcompose.core.i h16 = ComposeLayoutPropUpdaterKt.h(iVar6, 0.0f, 1, null);
                                    com.tencent.ntcompose.core.i a16 = com.tencent.ntcompose.core.ModifiersKt.a(iVar3, "onFocusChanged");
                                    if (a16 != null) {
                                        iVar6 = a16;
                                    }
                                    function3.invoke(h16.b(iVar6), composer2, 48);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), startRestartGroup, 3072, 6);
                            startRestartGroup.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            function23 = function22;
                            num3 = num2;
                            iVar4 = iVar3;
                            kVar3 = kVar2;
                            function110 = function17;
                            hVar4 = hVar3;
                            eVar3 = eVar2;
                            bool5 = bool3;
                            function111 = function18;
                            function05 = function04;
                            z29 = z39;
                            function112 = function16;
                            z36 = z46;
                            z37 = z27;
                            bool6 = bool4;
                            keyboardOptions3 = keyboardOptions2;
                            function113 = function1162;
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                    }
                    i57 = i18 & 16384;
                    if (i57 != 0) {
                    }
                    i58 = i57;
                    i59 = i18 & 32768;
                    if (i59 == 0) {
                    }
                    i65 = i18 & 65536;
                    if (i65 == 0) {
                    }
                    i66 = i18 & 131072;
                    if (i66 == 0) {
                    }
                    i67 = i18 & 262144;
                    if (i67 == 0) {
                    }
                    i68 = i18 & 524288;
                    if (i68 == 0) {
                    }
                    i69 = i18 & 1048576;
                    if (i69 == 0) {
                    }
                    i76 = i18 & 2097152;
                    if (i76 == 0) {
                    }
                    if ((i18 & 290) != 290) {
                    }
                    if (i78 == 0) {
                    }
                    if (i79 == 0) {
                    }
                    if (i85 == 0) {
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
                    if (i47 == 0) {
                    }
                    if (i48 == 0) {
                    }
                    if (i56 == 0) {
                    }
                    if (i58 == 0) {
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
                    if (i76 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.startReplaceableGroup(-492369756);
                    rememberedValue = startRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    final int i8722 = i86;
                    if (rememberedValue != companion.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    final MutableState<String> mutableState22 = (MutableState) rememberedValue;
                    Function1<InputParams, Unit> function11522 = new Function1<InputParams, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$TextField$nOnValueChange$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(InputParams inputParams) {
                            invoke2(inputParams);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(InputParams it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            mutableState22.setValue(it.getText());
                            ak akVar32 = akVar2;
                            if (akVar32 != null) {
                                String text = it.getText();
                                Integer inputLength = it.getInputLength();
                                akVar32.b(text, inputLength != null ? inputLength.intValue() : it.getText().length());
                            }
                            Function1<String, Unit> function11622 = function114;
                            if (function11622 != null) {
                                function11622.invoke(it.getText());
                            }
                        }
                    };
                    startRestartGroup.startReplaceableGroup(1157296644);
                    changed = startRestartGroup.changed(mutableState22);
                    Function1<? super String, Unit> function11622 = function114;
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue2 = new Function1<InputParams, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$TextField$onValueWillChange$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(InputParams inputParams) {
                            invoke2(inputParams);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(InputParams it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            mutableState22.setValue(it.getText());
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                    startRestartGroup.endReplaceableGroup();
                    Function1 function11722 = (Function1) rememberedValue2;
                    final ArrayList<com.tencent.ntcompose.core.k> arrayList22 = new ArrayList();
                    if (str2 != null) {
                    }
                    if (akVar2 != null) {
                    }
                    TextFieldViewPropUpdater textFieldViewPropUpdater22 = TextFieldViewPropUpdater.f339356a;
                    arrayList22.add(new com.tencent.ntcompose.core.k("onValueChange", function11522, null, null, null, null, textFieldViewPropUpdater22, 60, null));
                    arrayList22.add(new com.tencent.ntcompose.core.k("textWillChange", function11722, null, null, null, null, textFieldViewPropUpdater22, 60, null));
                    if (bool3 != null) {
                    }
                    if (kVar2 != null) {
                    }
                    if (keyboardOptions2 != null) {
                    }
                    if (eVar2 != null) {
                    }
                    if (hVar2 != null) {
                    }
                    if (num2 != null) {
                    }
                    if (bool4 != null) {
                    }
                    if (function03 != null) {
                    }
                    if (function04 != null) {
                    }
                    if (function16 != null) {
                    }
                    if (function18 != null) {
                    }
                    if (function19 != null) {
                    }
                    z28 = z38;
                    composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, -2062754826, true, new Function3<com.tencent.ntcompose.core.i, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$TextField$textFieldBuilder$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.core.i iVar6, Composer composer2, Integer num42) {
                            invoke(iVar6, composer2, num42.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(com.tencent.ntcompose.core.i it, Composer composer2, int i8822) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            if ((i8822 & 14) == 0) {
                                i8822 |= composer2.changed(it) ? 4 : 2;
                            }
                            if ((i8822 & 91) == 18 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2062754826, i8822, -1, "com.tencent.ntcompose.material.TextField.<anonymous> (TextField.kt:266)");
                            }
                            if (z28) {
                                composer2.startReplaceableGroup(617596452);
                                ComposeNodeKt.a("input", com.tencent.ntcompose.material.base.a.f339408a, null, it, arrayList22, null, composer2, ((i8822 << 9) & 7168) | 33206, 32);
                                composer2.endReplaceableGroup();
                            } else {
                                composer2.startReplaceableGroup(617596687);
                                ComposeNodeKt.a("text_area", com.tencent.ntcompose.material.base.a.f339408a, null, it, arrayList22, null, composer2, ((i8822 << 9) & 7168) | 33206, 32);
                                composer2.endReplaceableGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    });
                    if (function22 != null) {
                    }
                    iVar3 = iVar2;
                    startRestartGroup.startReplaceableGroup(-1779947234);
                    hVar3 = hVar2;
                    final Function1<? super Size, Unit> function11822 = function17;
                    final Function2<? super Composer, ? super Integer, Unit> function2422 = function22;
                    final int i8822 = i77;
                    final bp3.k kVar422 = kVar2;
                    final boolean z4722 = z27;
                    final int i8922 = i75;
                    BoxKt.a(ModifiersKt.s(iVar3), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1958109908, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$TextField$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer2, Integer num42) {
                            invoke(bVar, composer2, num42.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(com.tencent.ntcompose.foundation.layout.b Box, Composer composer2, int i95) {
                            Function2<Composer, Integer, Unit> function25;
                            Intrinsics.checkNotNullParameter(Box, "$this$Box");
                            if ((i95 & 81) == 16 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1958109908, i95, -1, "com.tencent.ntcompose.material.TextField.<anonymous> (TextField.kt:287)");
                            }
                            Function1<Size, Unit> function1192 = function11822;
                            composer2.startReplaceableGroup(617597081);
                            if (function1192 != null) {
                                final MutableState<String> mutableState222 = mutableState22;
                                final bp3.k kVar5 = kVar422;
                                final Function1<? super Size, Unit> function120 = function11822;
                                final int i96 = i8722;
                                final boolean z482 = z4722;
                                final int i97 = i8922;
                                BoxKt.a(ModifiersKt.R(ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), false), null, null, ComposableLambdaKt.composableLambda(composer2, 1272142184, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$TextField$1$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer3, Integer num42) {
                                        invoke(bVar, composer3, num42.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(com.tencent.ntcompose.foundation.layout.b Box2, Composer composer3, int i98) {
                                        bp3.c b16;
                                        Float fontSize;
                                        Float fontSize2;
                                        Intrinsics.checkNotNullParameter(Box2, "$this$Box");
                                        if ((i98 & 81) == 16 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1272142184, i98, -1, "com.tencent.ntcompose.material.TextField.<anonymous>.<anonymous>.<anonymous> (TextField.kt:289)");
                                        }
                                        String value = mutableState222.getValue();
                                        bp3.k kVar6 = kVar5;
                                        float f16 = 15.0f;
                                        float floatValue = (kVar6 == null || (fontSize2 = kVar6.getFontSize()) == null) ? 15.0f : fontSize2.floatValue();
                                        bp3.k kVar7 = kVar5;
                                        if (kVar7 != null && (fontSize = kVar7.getFontSize()) != null) {
                                            f16 = fontSize.floatValue();
                                        }
                                        float f17 = f16 * 1.2f;
                                        bp3.k kVar8 = kVar5;
                                        if (kVar8 == null || (b16 = kVar8.getFontWeight()) == null) {
                                            b16 = bp3.c.INSTANCE.b();
                                        }
                                        bp3.c cVar = b16;
                                        Float valueOf = Float.valueOf(floatValue);
                                        Float valueOf2 = Float.valueOf(f17);
                                        final Function1<? super Size, Unit> function121 = function120;
                                        composer3.startReplaceableGroup(1157296644);
                                        boolean changed2 = composer3.changed(function121);
                                        Object rememberedValue3 = composer3.rememberedValue();
                                        if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue3 = new Function1<am, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$TextField$1$1$1$1$1
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
                                                    Function1<Size, Unit> function122 = function121;
                                                    if (function122 != null) {
                                                        function122.invoke(new Size(it.getFrame().getWidth(), it.getFrame().getHeight()));
                                                    }
                                                }
                                            };
                                            composer3.updateRememberedValue(rememberedValue3);
                                        }
                                        composer3.endReplaceableGroup();
                                        TextKt.a(value, null, null, null, valueOf, null, cVar, null, null, null, null, valueOf2, null, null, null, null, null, null, null, (Function1) rememberedValue3, null, null, null, null, null, null, z482, composer3, 0, 0, (i97 << 15) & 3670016, 66582446);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer2, 3072, 6);
                            }
                            composer2.endReplaceableGroup();
                            composer2.startReplaceableGroup(617597587);
                            if ((mutableState22.getValue().length() == 0) && (function25 = function2422) != null) {
                                function25.invoke(composer2, Integer.valueOf((i8822 >> 21) & 14));
                            }
                            composer2.endReplaceableGroup();
                            Function3<com.tencent.ntcompose.core.i, Composer, Integer, Unit> function3 = composableLambda;
                            com.tencent.ntcompose.core.i iVar6 = com.tencent.ntcompose.core.i.INSTANCE;
                            com.tencent.ntcompose.core.i h16 = ComposeLayoutPropUpdaterKt.h(iVar6, 0.0f, 1, null);
                            com.tencent.ntcompose.core.i a16 = com.tencent.ntcompose.core.ModifiersKt.a(iVar3, "onFocusChanged");
                            if (a16 != null) {
                                iVar6 = a16;
                            }
                            function3.invoke(h16.b(iVar6), composer2, 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), startRestartGroup, 3072, 6);
                    startRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function23 = function22;
                    num3 = num2;
                    iVar4 = iVar3;
                    kVar3 = kVar2;
                    function110 = function17;
                    hVar4 = hVar3;
                    eVar3 = eVar2;
                    bool5 = bool3;
                    function111 = function18;
                    function05 = function04;
                    z29 = z39;
                    function112 = function16;
                    z36 = z46;
                    z37 = z27;
                    bool6 = bool4;
                    keyboardOptions3 = keyboardOptions2;
                    function113 = function11622;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i49 = i18 & 8192;
                if (i49 == 0) {
                }
                i57 = i18 & 16384;
                if (i57 != 0) {
                }
                i58 = i57;
                i59 = i18 & 32768;
                if (i59 == 0) {
                }
                i65 = i18 & 65536;
                if (i65 == 0) {
                }
                i66 = i18 & 131072;
                if (i66 == 0) {
                }
                i67 = i18 & 262144;
                if (i67 == 0) {
                }
                i68 = i18 & 524288;
                if (i68 == 0) {
                }
                i69 = i18 & 1048576;
                if (i69 == 0) {
                }
                i76 = i18 & 2097152;
                if (i76 == 0) {
                }
                if ((i18 & 290) != 290) {
                }
                if (i78 == 0) {
                }
                if (i79 == 0) {
                }
                if (i85 == 0) {
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
                if (i47 == 0) {
                }
                if (i48 == 0) {
                }
                if (i56 == 0) {
                }
                if (i58 == 0) {
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
                if (i76 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceableGroup(-492369756);
                rememberedValue = startRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                final int i87222 = i86;
                if (rememberedValue != companion.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                final MutableState<String> mutableState222 = (MutableState) rememberedValue;
                Function1<InputParams, Unit> function115222 = new Function1<InputParams, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$TextField$nOnValueChange$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(InputParams inputParams) {
                        invoke2(inputParams);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(InputParams it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        mutableState222.setValue(it.getText());
                        ak akVar32 = akVar2;
                        if (akVar32 != null) {
                            String text = it.getText();
                            Integer inputLength = it.getInputLength();
                            akVar32.b(text, inputLength != null ? inputLength.intValue() : it.getText().length());
                        }
                        Function1<String, Unit> function116222 = function114;
                        if (function116222 != null) {
                            function116222.invoke(it.getText());
                        }
                    }
                };
                startRestartGroup.startReplaceableGroup(1157296644);
                changed = startRestartGroup.changed(mutableState222);
                Function1<? super String, Unit> function116222 = function114;
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue2 = new Function1<InputParams, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$TextField$onValueWillChange$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(InputParams inputParams) {
                        invoke2(inputParams);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(InputParams it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        mutableState222.setValue(it.getText());
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
                startRestartGroup.endReplaceableGroup();
                Function1 function117222 = (Function1) rememberedValue2;
                final ArrayList<com.tencent.ntcompose.core.k> arrayList222 = new ArrayList();
                if (str2 != null) {
                }
                if (akVar2 != null) {
                }
                TextFieldViewPropUpdater textFieldViewPropUpdater222 = TextFieldViewPropUpdater.f339356a;
                arrayList222.add(new com.tencent.ntcompose.core.k("onValueChange", function115222, null, null, null, null, textFieldViewPropUpdater222, 60, null));
                arrayList222.add(new com.tencent.ntcompose.core.k("textWillChange", function117222, null, null, null, null, textFieldViewPropUpdater222, 60, null));
                if (bool3 != null) {
                }
                if (kVar2 != null) {
                }
                if (keyboardOptions2 != null) {
                }
                if (eVar2 != null) {
                }
                if (hVar2 != null) {
                }
                if (num2 != null) {
                }
                if (bool4 != null) {
                }
                if (function03 != null) {
                }
                if (function04 != null) {
                }
                if (function16 != null) {
                }
                if (function18 != null) {
                }
                if (function19 != null) {
                }
                z28 = z38;
                composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, -2062754826, true, new Function3<com.tencent.ntcompose.core.i, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$TextField$textFieldBuilder$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.core.i iVar6, Composer composer2, Integer num42) {
                        invoke(iVar6, composer2, num42.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(com.tencent.ntcompose.core.i it, Composer composer2, int i88222) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        if ((i88222 & 14) == 0) {
                            i88222 |= composer2.changed(it) ? 4 : 2;
                        }
                        if ((i88222 & 91) == 18 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2062754826, i88222, -1, "com.tencent.ntcompose.material.TextField.<anonymous> (TextField.kt:266)");
                        }
                        if (z28) {
                            composer2.startReplaceableGroup(617596452);
                            ComposeNodeKt.a("input", com.tencent.ntcompose.material.base.a.f339408a, null, it, arrayList222, null, composer2, ((i88222 << 9) & 7168) | 33206, 32);
                            composer2.endReplaceableGroup();
                        } else {
                            composer2.startReplaceableGroup(617596687);
                            ComposeNodeKt.a("text_area", com.tencent.ntcompose.material.base.a.f339408a, null, it, arrayList222, null, composer2, ((i88222 << 9) & 7168) | 33206, 32);
                            composer2.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                });
                if (function22 != null) {
                }
                iVar3 = iVar2;
                startRestartGroup.startReplaceableGroup(-1779947234);
                hVar3 = hVar2;
                final Function1<? super Size, Unit> function118222 = function17;
                final Function2<? super Composer, ? super Integer, Unit> function24222 = function22;
                final int i88222 = i77;
                final bp3.k kVar4222 = kVar2;
                final boolean z47222 = z27;
                final int i89222 = i75;
                BoxKt.a(ModifiersKt.s(iVar3), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1958109908, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$TextField$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer2, Integer num42) {
                        invoke(bVar, composer2, num42.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(com.tencent.ntcompose.foundation.layout.b Box, Composer composer2, int i95) {
                        Function2<Composer, Integer, Unit> function25;
                        Intrinsics.checkNotNullParameter(Box, "$this$Box");
                        if ((i95 & 81) == 16 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1958109908, i95, -1, "com.tencent.ntcompose.material.TextField.<anonymous> (TextField.kt:287)");
                        }
                        Function1<Size, Unit> function1192 = function118222;
                        composer2.startReplaceableGroup(617597081);
                        if (function1192 != null) {
                            final MutableState<String> mutableState2222 = mutableState222;
                            final bp3.k kVar5 = kVar4222;
                            final Function1<? super Size, Unit> function120 = function118222;
                            final int i96 = i87222;
                            final boolean z482 = z47222;
                            final int i97 = i89222;
                            BoxKt.a(ModifiersKt.R(ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), false), null, null, ComposableLambdaKt.composableLambda(composer2, 1272142184, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$TextField$1$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer3, Integer num42) {
                                    invoke(bVar, composer3, num42.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(com.tencent.ntcompose.foundation.layout.b Box2, Composer composer3, int i98) {
                                    bp3.c b16;
                                    Float fontSize;
                                    Float fontSize2;
                                    Intrinsics.checkNotNullParameter(Box2, "$this$Box");
                                    if ((i98 & 81) == 16 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1272142184, i98, -1, "com.tencent.ntcompose.material.TextField.<anonymous>.<anonymous>.<anonymous> (TextField.kt:289)");
                                    }
                                    String value = mutableState2222.getValue();
                                    bp3.k kVar6 = kVar5;
                                    float f16 = 15.0f;
                                    float floatValue = (kVar6 == null || (fontSize2 = kVar6.getFontSize()) == null) ? 15.0f : fontSize2.floatValue();
                                    bp3.k kVar7 = kVar5;
                                    if (kVar7 != null && (fontSize = kVar7.getFontSize()) != null) {
                                        f16 = fontSize.floatValue();
                                    }
                                    float f17 = f16 * 1.2f;
                                    bp3.k kVar8 = kVar5;
                                    if (kVar8 == null || (b16 = kVar8.getFontWeight()) == null) {
                                        b16 = bp3.c.INSTANCE.b();
                                    }
                                    bp3.c cVar = b16;
                                    Float valueOf = Float.valueOf(floatValue);
                                    Float valueOf2 = Float.valueOf(f17);
                                    final Function1<? super Size, Unit> function121 = function120;
                                    composer3.startReplaceableGroup(1157296644);
                                    boolean changed2 = composer3.changed(function121);
                                    Object rememberedValue3 = composer3.rememberedValue();
                                    if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue3 = new Function1<am, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$TextField$1$1$1$1$1
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
                                                Function1<Size, Unit> function122 = function121;
                                                if (function122 != null) {
                                                    function122.invoke(new Size(it.getFrame().getWidth(), it.getFrame().getHeight()));
                                                }
                                            }
                                        };
                                        composer3.updateRememberedValue(rememberedValue3);
                                    }
                                    composer3.endReplaceableGroup();
                                    TextKt.a(value, null, null, null, valueOf, null, cVar, null, null, null, null, valueOf2, null, null, null, null, null, null, null, (Function1) rememberedValue3, null, null, null, null, null, null, z482, composer3, 0, 0, (i97 << 15) & 3670016, 66582446);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer2, 3072, 6);
                        }
                        composer2.endReplaceableGroup();
                        composer2.startReplaceableGroup(617597587);
                        if ((mutableState222.getValue().length() == 0) && (function25 = function24222) != null) {
                            function25.invoke(composer2, Integer.valueOf((i88222 >> 21) & 14));
                        }
                        composer2.endReplaceableGroup();
                        Function3<com.tencent.ntcompose.core.i, Composer, Integer, Unit> function3 = composableLambda;
                        com.tencent.ntcompose.core.i iVar6 = com.tencent.ntcompose.core.i.INSTANCE;
                        com.tencent.ntcompose.core.i h16 = ComposeLayoutPropUpdaterKt.h(iVar6, 0.0f, 1, null);
                        com.tencent.ntcompose.core.i a16 = com.tencent.ntcompose.core.ModifiersKt.a(iVar3, "onFocusChanged");
                        if (a16 != null) {
                            iVar6 = a16;
                        }
                        function3.invoke(h16.b(iVar6), composer2, 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), startRestartGroup, 3072, 6);
                startRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                }
                function23 = function22;
                num3 = num2;
                iVar4 = iVar3;
                kVar3 = kVar2;
                function110 = function17;
                hVar4 = hVar3;
                eVar3 = eVar2;
                bool5 = bool3;
                function111 = function18;
                function05 = function04;
                z29 = z39;
                function112 = function16;
                z36 = z46;
                z37 = z27;
                bool6 = bool4;
                keyboardOptions3 = keyboardOptions2;
                function113 = function116222;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i27 = i18 & 16;
            if (i27 != 0) {
            }
            i28 = i18 & 32;
            if (i28 != 0) {
            }
            i29 = i18 & 64;
            if (i29 != 0) {
            }
            i36 = i18 & 128;
            if (i36 != 0) {
            }
            i37 = i18 & 256;
            if (i37 != 0) {
            }
            i38 = i18 & 512;
            if (i38 != 0) {
            }
            i39 = i18 & 1024;
            if (i39 != 0) {
            }
            i47 = i18 & 2048;
            if (i47 != 0) {
            }
            int i862 = i46;
            i48 = i18 & 4096;
            if (i48 != 0) {
            }
            i49 = i18 & 8192;
            if (i49 == 0) {
            }
            i57 = i18 & 16384;
            if (i57 != 0) {
            }
            i58 = i57;
            i59 = i18 & 32768;
            if (i59 == 0) {
            }
            i65 = i18 & 65536;
            if (i65 == 0) {
            }
            i66 = i18 & 131072;
            if (i66 == 0) {
            }
            i67 = i18 & 262144;
            if (i67 == 0) {
            }
            i68 = i18 & 524288;
            if (i68 == 0) {
            }
            i69 = i18 & 1048576;
            if (i69 == 0) {
            }
            i76 = i18 & 2097152;
            if (i76 == 0) {
            }
            if ((i18 & 290) != 290) {
            }
            if (i78 == 0) {
            }
            if (i79 == 0) {
            }
            if (i85 == 0) {
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
            if (i47 == 0) {
            }
            if (i48 == 0) {
            }
            if (i56 == 0) {
            }
            if (i58 == 0) {
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
            if (i76 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            rememberedValue = startRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            final int i872222 = i862;
            if (rememberedValue != companion.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState<String> mutableState2222 = (MutableState) rememberedValue;
            Function1<InputParams, Unit> function1152222 = new Function1<InputParams, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$TextField$nOnValueChange$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(InputParams inputParams) {
                    invoke2(inputParams);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(InputParams it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    mutableState2222.setValue(it.getText());
                    ak akVar32 = akVar2;
                    if (akVar32 != null) {
                        String text = it.getText();
                        Integer inputLength = it.getInputLength();
                        akVar32.b(text, inputLength != null ? inputLength.intValue() : it.getText().length());
                    }
                    Function1<String, Unit> function1162222 = function114;
                    if (function1162222 != null) {
                        function1162222.invoke(it.getText());
                    }
                }
            };
            startRestartGroup.startReplaceableGroup(1157296644);
            changed = startRestartGroup.changed(mutableState2222);
            Function1<? super String, Unit> function1162222 = function114;
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue2 = new Function1<InputParams, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$TextField$onValueWillChange$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(InputParams inputParams) {
                    invoke2(inputParams);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(InputParams it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    mutableState2222.setValue(it.getText());
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
            startRestartGroup.endReplaceableGroup();
            Function1 function1172222 = (Function1) rememberedValue2;
            final ArrayList<com.tencent.ntcompose.core.k> arrayList2222 = new ArrayList();
            if (str2 != null) {
            }
            if (akVar2 != null) {
            }
            TextFieldViewPropUpdater textFieldViewPropUpdater2222 = TextFieldViewPropUpdater.f339356a;
            arrayList2222.add(new com.tencent.ntcompose.core.k("onValueChange", function1152222, null, null, null, null, textFieldViewPropUpdater2222, 60, null));
            arrayList2222.add(new com.tencent.ntcompose.core.k("textWillChange", function1172222, null, null, null, null, textFieldViewPropUpdater2222, 60, null));
            if (bool3 != null) {
            }
            if (kVar2 != null) {
            }
            if (keyboardOptions2 != null) {
            }
            if (eVar2 != null) {
            }
            if (hVar2 != null) {
            }
            if (num2 != null) {
            }
            if (bool4 != null) {
            }
            if (function03 != null) {
            }
            if (function04 != null) {
            }
            if (function16 != null) {
            }
            if (function18 != null) {
            }
            if (function19 != null) {
            }
            z28 = z38;
            composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, -2062754826, true, new Function3<com.tencent.ntcompose.core.i, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$TextField$textFieldBuilder$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.core.i iVar6, Composer composer2, Integer num42) {
                    invoke(iVar6, composer2, num42.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(com.tencent.ntcompose.core.i it, Composer composer2, int i882222) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if ((i882222 & 14) == 0) {
                        i882222 |= composer2.changed(it) ? 4 : 2;
                    }
                    if ((i882222 & 91) == 18 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2062754826, i882222, -1, "com.tencent.ntcompose.material.TextField.<anonymous> (TextField.kt:266)");
                    }
                    if (z28) {
                        composer2.startReplaceableGroup(617596452);
                        ComposeNodeKt.a("input", com.tencent.ntcompose.material.base.a.f339408a, null, it, arrayList2222, null, composer2, ((i882222 << 9) & 7168) | 33206, 32);
                        composer2.endReplaceableGroup();
                    } else {
                        composer2.startReplaceableGroup(617596687);
                        ComposeNodeKt.a("text_area", com.tencent.ntcompose.material.base.a.f339408a, null, it, arrayList2222, null, composer2, ((i882222 << 9) & 7168) | 33206, 32);
                        composer2.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            });
            if (function22 != null) {
            }
            iVar3 = iVar2;
            startRestartGroup.startReplaceableGroup(-1779947234);
            hVar3 = hVar2;
            final Function1<? super Size, Unit> function1182222 = function17;
            final Function2<? super Composer, ? super Integer, Unit> function242222 = function22;
            final int i882222 = i77;
            final bp3.k kVar42222 = kVar2;
            final boolean z472222 = z27;
            final int i892222 = i75;
            BoxKt.a(ModifiersKt.s(iVar3), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1958109908, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$TextField$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer2, Integer num42) {
                    invoke(bVar, composer2, num42.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(com.tencent.ntcompose.foundation.layout.b Box, Composer composer2, int i95) {
                    Function2<Composer, Integer, Unit> function25;
                    Intrinsics.checkNotNullParameter(Box, "$this$Box");
                    if ((i95 & 81) == 16 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1958109908, i95, -1, "com.tencent.ntcompose.material.TextField.<anonymous> (TextField.kt:287)");
                    }
                    Function1<Size, Unit> function1192 = function1182222;
                    composer2.startReplaceableGroup(617597081);
                    if (function1192 != null) {
                        final MutableState<String> mutableState22222 = mutableState2222;
                        final bp3.k kVar5 = kVar42222;
                        final Function1<? super Size, Unit> function120 = function1182222;
                        final int i96 = i872222;
                        final boolean z482 = z472222;
                        final int i97 = i892222;
                        BoxKt.a(ModifiersKt.R(ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), false), null, null, ComposableLambdaKt.composableLambda(composer2, 1272142184, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$TextField$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer3, Integer num42) {
                                invoke(bVar, composer3, num42.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(com.tencent.ntcompose.foundation.layout.b Box2, Composer composer3, int i98) {
                                bp3.c b16;
                                Float fontSize;
                                Float fontSize2;
                                Intrinsics.checkNotNullParameter(Box2, "$this$Box");
                                if ((i98 & 81) == 16 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1272142184, i98, -1, "com.tencent.ntcompose.material.TextField.<anonymous>.<anonymous>.<anonymous> (TextField.kt:289)");
                                }
                                String value = mutableState22222.getValue();
                                bp3.k kVar6 = kVar5;
                                float f16 = 15.0f;
                                float floatValue = (kVar6 == null || (fontSize2 = kVar6.getFontSize()) == null) ? 15.0f : fontSize2.floatValue();
                                bp3.k kVar7 = kVar5;
                                if (kVar7 != null && (fontSize = kVar7.getFontSize()) != null) {
                                    f16 = fontSize.floatValue();
                                }
                                float f17 = f16 * 1.2f;
                                bp3.k kVar8 = kVar5;
                                if (kVar8 == null || (b16 = kVar8.getFontWeight()) == null) {
                                    b16 = bp3.c.INSTANCE.b();
                                }
                                bp3.c cVar = b16;
                                Float valueOf = Float.valueOf(floatValue);
                                Float valueOf2 = Float.valueOf(f17);
                                final Function1<? super Size, Unit> function121 = function120;
                                composer3.startReplaceableGroup(1157296644);
                                boolean changed2 = composer3.changed(function121);
                                Object rememberedValue3 = composer3.rememberedValue();
                                if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue3 = new Function1<am, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$TextField$1$1$1$1$1
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
                                            Function1<Size, Unit> function122 = function121;
                                            if (function122 != null) {
                                                function122.invoke(new Size(it.getFrame().getWidth(), it.getFrame().getHeight()));
                                            }
                                        }
                                    };
                                    composer3.updateRememberedValue(rememberedValue3);
                                }
                                composer3.endReplaceableGroup();
                                TextKt.a(value, null, null, null, valueOf, null, cVar, null, null, null, null, valueOf2, null, null, null, null, null, null, null, (Function1) rememberedValue3, null, null, null, null, null, null, z482, composer3, 0, 0, (i97 << 15) & 3670016, 66582446);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer2, 3072, 6);
                    }
                    composer2.endReplaceableGroup();
                    composer2.startReplaceableGroup(617597587);
                    if ((mutableState2222.getValue().length() == 0) && (function25 = function242222) != null) {
                        function25.invoke(composer2, Integer.valueOf((i882222 >> 21) & 14));
                    }
                    composer2.endReplaceableGroup();
                    Function3<com.tencent.ntcompose.core.i, Composer, Integer, Unit> function3 = composableLambda;
                    com.tencent.ntcompose.core.i iVar6 = com.tencent.ntcompose.core.i.INSTANCE;
                    com.tencent.ntcompose.core.i h16 = ComposeLayoutPropUpdaterKt.h(iVar6, 0.0f, 1, null);
                    com.tencent.ntcompose.core.i a16 = com.tencent.ntcompose.core.ModifiersKt.a(iVar3, "onFocusChanged");
                    if (a16 != null) {
                        iVar6 = a16;
                    }
                    function3.invoke(h16.b(iVar6), composer2, 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), startRestartGroup, 3072, 6);
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
            function23 = function22;
            num3 = num2;
            iVar4 = iVar3;
            kVar3 = kVar2;
            function110 = function17;
            hVar4 = hVar3;
            eVar3 = eVar2;
            bool5 = bool3;
            function111 = function18;
            function05 = function04;
            z29 = z39;
            function112 = function16;
            z36 = z46;
            z37 = z27;
            bool6 = bool4;
            keyboardOptions3 = keyboardOptions2;
            function113 = function1162222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i26 = i18 & 8;
        if (i26 == 0) {
        }
        i27 = i18 & 16;
        if (i27 != 0) {
        }
        i28 = i18 & 32;
        if (i28 != 0) {
        }
        i29 = i18 & 64;
        if (i29 != 0) {
        }
        i36 = i18 & 128;
        if (i36 != 0) {
        }
        i37 = i18 & 256;
        if (i37 != 0) {
        }
        i38 = i18 & 512;
        if (i38 != 0) {
        }
        i39 = i18 & 1024;
        if (i39 != 0) {
        }
        i47 = i18 & 2048;
        if (i47 != 0) {
        }
        int i8622 = i46;
        i48 = i18 & 4096;
        if (i48 != 0) {
        }
        i49 = i18 & 8192;
        if (i49 == 0) {
        }
        i57 = i18 & 16384;
        if (i57 != 0) {
        }
        i58 = i57;
        i59 = i18 & 32768;
        if (i59 == 0) {
        }
        i65 = i18 & 65536;
        if (i65 == 0) {
        }
        i66 = i18 & 131072;
        if (i66 == 0) {
        }
        i67 = i18 & 262144;
        if (i67 == 0) {
        }
        i68 = i18 & 524288;
        if (i68 == 0) {
        }
        i69 = i18 & 1048576;
        if (i69 == 0) {
        }
        i76 = i18 & 2097152;
        if (i76 == 0) {
        }
        if ((i18 & 290) != 290) {
        }
        if (i78 == 0) {
        }
        if (i79 == 0) {
        }
        if (i85 == 0) {
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
        if (i47 == 0) {
        }
        if (i48 == 0) {
        }
        if (i56 == 0) {
        }
        if (i58 == 0) {
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
        if (i76 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        final int i8722222 = i8622;
        if (rememberedValue != companion.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState<String> mutableState22222 = (MutableState) rememberedValue;
        Function1<InputParams, Unit> function11522222 = new Function1<InputParams, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$TextField$nOnValueChange$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InputParams inputParams) {
                invoke2(inputParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InputParams it) {
                Intrinsics.checkNotNullParameter(it, "it");
                mutableState22222.setValue(it.getText());
                ak akVar32 = akVar2;
                if (akVar32 != null) {
                    String text = it.getText();
                    Integer inputLength = it.getInputLength();
                    akVar32.b(text, inputLength != null ? inputLength.intValue() : it.getText().length());
                }
                Function1<String, Unit> function11622222 = function114;
                if (function11622222 != null) {
                    function11622222.invoke(it.getText());
                }
            }
        };
        startRestartGroup.startReplaceableGroup(1157296644);
        changed = startRestartGroup.changed(mutableState22222);
        Function1<? super String, Unit> function11622222 = function114;
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue2 = new Function1<InputParams, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$TextField$onValueWillChange$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InputParams inputParams) {
                invoke2(inputParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InputParams it) {
                Intrinsics.checkNotNullParameter(it, "it");
                mutableState22222.setValue(it.getText());
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceableGroup();
        Function1 function11722222 = (Function1) rememberedValue2;
        final ArrayList<com.tencent.ntcompose.core.k> arrayList22222 = new ArrayList();
        if (str2 != null) {
        }
        if (akVar2 != null) {
        }
        TextFieldViewPropUpdater textFieldViewPropUpdater22222 = TextFieldViewPropUpdater.f339356a;
        arrayList22222.add(new com.tencent.ntcompose.core.k("onValueChange", function11522222, null, null, null, null, textFieldViewPropUpdater22222, 60, null));
        arrayList22222.add(new com.tencent.ntcompose.core.k("textWillChange", function11722222, null, null, null, null, textFieldViewPropUpdater22222, 60, null));
        if (bool3 != null) {
        }
        if (kVar2 != null) {
        }
        if (keyboardOptions2 != null) {
        }
        if (eVar2 != null) {
        }
        if (hVar2 != null) {
        }
        if (num2 != null) {
        }
        if (bool4 != null) {
        }
        if (function03 != null) {
        }
        if (function04 != null) {
        }
        if (function16 != null) {
        }
        if (function18 != null) {
        }
        if (function19 != null) {
        }
        z28 = z38;
        composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, -2062754826, true, new Function3<com.tencent.ntcompose.core.i, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$TextField$textFieldBuilder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.core.i iVar6, Composer composer2, Integer num42) {
                invoke(iVar6, composer2, num42.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(com.tencent.ntcompose.core.i it, Composer composer2, int i8822222) {
                Intrinsics.checkNotNullParameter(it, "it");
                if ((i8822222 & 14) == 0) {
                    i8822222 |= composer2.changed(it) ? 4 : 2;
                }
                if ((i8822222 & 91) == 18 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2062754826, i8822222, -1, "com.tencent.ntcompose.material.TextField.<anonymous> (TextField.kt:266)");
                }
                if (z28) {
                    composer2.startReplaceableGroup(617596452);
                    ComposeNodeKt.a("input", com.tencent.ntcompose.material.base.a.f339408a, null, it, arrayList22222, null, composer2, ((i8822222 << 9) & 7168) | 33206, 32);
                    composer2.endReplaceableGroup();
                } else {
                    composer2.startReplaceableGroup(617596687);
                    ComposeNodeKt.a("text_area", com.tencent.ntcompose.material.base.a.f339408a, null, it, arrayList22222, null, composer2, ((i8822222 << 9) & 7168) | 33206, 32);
                    composer2.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        });
        if (function22 != null) {
        }
        iVar3 = iVar2;
        startRestartGroup.startReplaceableGroup(-1779947234);
        hVar3 = hVar2;
        final Function1<? super Size, Unit> function11822222 = function17;
        final Function2<? super Composer, ? super Integer, Unit> function2422222 = function22;
        final int i8822222 = i77;
        final bp3.k kVar422222 = kVar2;
        final boolean z4722222 = z27;
        final int i8922222 = i75;
        BoxKt.a(ModifiersKt.s(iVar3), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1958109908, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$TextField$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer2, Integer num42) {
                invoke(bVar, composer2, num42.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(com.tencent.ntcompose.foundation.layout.b Box, Composer composer2, int i95) {
                Function2<Composer, Integer, Unit> function25;
                Intrinsics.checkNotNullParameter(Box, "$this$Box");
                if ((i95 & 81) == 16 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1958109908, i95, -1, "com.tencent.ntcompose.material.TextField.<anonymous> (TextField.kt:287)");
                }
                Function1<Size, Unit> function1192 = function11822222;
                composer2.startReplaceableGroup(617597081);
                if (function1192 != null) {
                    final MutableState<String> mutableState222222 = mutableState22222;
                    final bp3.k kVar5 = kVar422222;
                    final Function1<? super Size, Unit> function120 = function11822222;
                    final int i96 = i8722222;
                    final boolean z482 = z4722222;
                    final int i97 = i8922222;
                    BoxKt.a(ModifiersKt.R(ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), false), null, null, ComposableLambdaKt.composableLambda(composer2, 1272142184, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$TextField$1$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer3, Integer num42) {
                            invoke(bVar, composer3, num42.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(com.tencent.ntcompose.foundation.layout.b Box2, Composer composer3, int i98) {
                            bp3.c b16;
                            Float fontSize;
                            Float fontSize2;
                            Intrinsics.checkNotNullParameter(Box2, "$this$Box");
                            if ((i98 & 81) == 16 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1272142184, i98, -1, "com.tencent.ntcompose.material.TextField.<anonymous>.<anonymous>.<anonymous> (TextField.kt:289)");
                            }
                            String value = mutableState222222.getValue();
                            bp3.k kVar6 = kVar5;
                            float f16 = 15.0f;
                            float floatValue = (kVar6 == null || (fontSize2 = kVar6.getFontSize()) == null) ? 15.0f : fontSize2.floatValue();
                            bp3.k kVar7 = kVar5;
                            if (kVar7 != null && (fontSize = kVar7.getFontSize()) != null) {
                                f16 = fontSize.floatValue();
                            }
                            float f17 = f16 * 1.2f;
                            bp3.k kVar8 = kVar5;
                            if (kVar8 == null || (b16 = kVar8.getFontWeight()) == null) {
                                b16 = bp3.c.INSTANCE.b();
                            }
                            bp3.c cVar = b16;
                            Float valueOf = Float.valueOf(floatValue);
                            Float valueOf2 = Float.valueOf(f17);
                            final Function1<? super Size, Unit> function121 = function120;
                            composer3.startReplaceableGroup(1157296644);
                            boolean changed2 = composer3.changed(function121);
                            Object rememberedValue3 = composer3.rememberedValue();
                            if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue3 = new Function1<am, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$TextField$1$1$1$1$1
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
                                        Function1<Size, Unit> function122 = function121;
                                        if (function122 != null) {
                                            function122.invoke(new Size(it.getFrame().getWidth(), it.getFrame().getHeight()));
                                        }
                                    }
                                };
                                composer3.updateRememberedValue(rememberedValue3);
                            }
                            composer3.endReplaceableGroup();
                            TextKt.a(value, null, null, null, valueOf, null, cVar, null, null, null, null, valueOf2, null, null, null, null, null, null, null, (Function1) rememberedValue3, null, null, null, null, null, null, z482, composer3, 0, 0, (i97 << 15) & 3670016, 66582446);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, 3072, 6);
                }
                composer2.endReplaceableGroup();
                composer2.startReplaceableGroup(617597587);
                if ((mutableState22222.getValue().length() == 0) && (function25 = function2422222) != null) {
                    function25.invoke(composer2, Integer.valueOf((i8822222 >> 21) & 14));
                }
                composer2.endReplaceableGroup();
                Function3<com.tencent.ntcompose.core.i, Composer, Integer, Unit> function3 = composableLambda;
                com.tencent.ntcompose.core.i iVar6 = com.tencent.ntcompose.core.i.INSTANCE;
                com.tencent.ntcompose.core.i h16 = ComposeLayoutPropUpdaterKt.h(iVar6, 0.0f, 1, null);
                com.tencent.ntcompose.core.i a16 = com.tencent.ntcompose.core.ModifiersKt.a(iVar3, "onFocusChanged");
                if (a16 != null) {
                    iVar6 = a16;
                }
                function3.invoke(h16.b(iVar6), composer2, 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), startRestartGroup, 3072, 6);
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        function23 = function22;
        num3 = num2;
        iVar4 = iVar3;
        kVar3 = kVar2;
        function110 = function17;
        hVar4 = hVar3;
        eVar3 = eVar2;
        bool5 = bool3;
        function111 = function18;
        function05 = function04;
        z29 = z39;
        function112 = function16;
        z36 = z46;
        z37 = z27;
        bool6 = bool4;
        keyboardOptions3 = keyboardOptions2;
        function113 = function11622222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    private static final com.tencent.kuikly.core.views.ai b(com.tencent.kuikly.core.views.ai aiVar, int i3) {
        aiVar.with("fontWeight", String.valueOf(i3));
        return aiVar;
    }

    private static final cc c(cc ccVar, int i3) {
        ccVar.with("fontWeight", String.valueOf(i3));
        return ccVar;
    }

    public static final void d(InputEvent inputEvent, final bp3.e actions, Function0<String> getReturnKeyType) {
        Intrinsics.checkNotNullParameter(inputEvent, "<this>");
        Intrinsics.checkNotNullParameter(actions, "actions");
        Intrinsics.checkNotNullParameter(getReturnKeyType, "getReturnKeyType");
        inputEvent.m(new Function1<String, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$setKeyboardActions$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String actionType) {
                Intrinsics.checkNotNullParameter(actionType, "actionType");
                bp3.e.this.a();
            }
        });
    }

    public static final void e(TextAreaEvent textAreaEvent, final bp3.e actions, Function0<String> getReturnKeyType) {
        Intrinsics.checkNotNullParameter(textAreaEvent, "<this>");
        Intrinsics.checkNotNullParameter(actions, "actions");
        Intrinsics.checkNotNullParameter(getReturnKeyType, "getReturnKeyType");
        textAreaEvent.l(new Function1<String, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldKt$setKeyboardActions$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                bp3.e.this.a();
            }
        });
    }

    public static final void f(com.tencent.kuikly.core.views.ai aiVar, KeyboardOptions options) {
        Intrinsics.checkNotNullParameter(aiVar, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        int keyboardType = options.getKeyboardType();
        c.Companion companion = cp3.c.INSTANCE;
        if (cp3.c.k(keyboardType, companion.d()) ? true : cp3.c.k(keyboardType, companion.b()) ? true : cp3.c.k(keyboardType, companion.g())) {
            aiVar.r();
        } else if (cp3.c.k(keyboardType, companion.c())) {
            aiVar.q();
        } else {
            if (cp3.c.k(keyboardType, companion.f()) ? true : cp3.c.k(keyboardType, companion.e())) {
                aiVar.s();
            } else {
                if (!(cp3.c.k(keyboardType, companion.h()) ? true : cp3.c.k(keyboardType, companion.a()))) {
                    cp3.c.k(keyboardType, companion.i());
                }
            }
        }
        int imeAction = options.getImeAction();
        a.Companion companion2 = cp3.a.INSTANCE;
        if (cp3.a.j(imeAction, companion2.a()) || cp3.a.j(imeAction, companion2.e())) {
            return;
        }
        if (cp3.a.j(imeAction, companion2.c())) {
            aiVar.x();
            return;
        }
        if (cp3.a.j(imeAction, companion2.g())) {
            aiVar.z();
            return;
        }
        if (cp3.a.j(imeAction, companion2.h())) {
            aiVar.A();
            return;
        }
        if (cp3.a.j(imeAction, companion2.f())) {
            return;
        }
        if (cp3.a.j(imeAction, companion2.d())) {
            aiVar.y();
        } else if (cp3.a.j(imeAction, companion2.b())) {
            aiVar.w();
        }
    }

    public static final void g(cc ccVar, KeyboardOptions options) {
        Intrinsics.checkNotNullParameter(ccVar, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        int keyboardType = options.getKeyboardType();
        c.Companion companion = cp3.c.INSTANCE;
        if (cp3.c.k(keyboardType, companion.d()) ? true : cp3.c.k(keyboardType, companion.b()) ? true : cp3.c.k(keyboardType, companion.g())) {
            ccVar.t();
        } else if (cp3.c.k(keyboardType, companion.c())) {
            ccVar.s();
        } else {
            if (cp3.c.k(keyboardType, companion.f()) ? true : cp3.c.k(keyboardType, companion.e())) {
                ccVar.u();
            } else {
                if (!(cp3.c.k(keyboardType, companion.h()) ? true : cp3.c.k(keyboardType, companion.a()))) {
                    cp3.c.k(keyboardType, companion.i());
                }
            }
        }
        int imeAction = options.getImeAction();
        a.Companion companion2 = cp3.a.INSTANCE;
        if (cp3.a.j(imeAction, companion2.a()) || cp3.a.j(imeAction, companion2.e())) {
            return;
        }
        if (cp3.a.j(imeAction, companion2.c())) {
            ccVar.z();
            return;
        }
        if (cp3.a.j(imeAction, companion2.g())) {
            ccVar.B();
            return;
        }
        if (cp3.a.j(imeAction, companion2.h())) {
            ccVar.C();
            return;
        }
        if (cp3.a.j(imeAction, companion2.f())) {
            return;
        }
        if (cp3.a.j(imeAction, companion2.d())) {
            ccVar.A();
        } else if (cp3.a.j(imeAction, companion2.b())) {
            ccVar.y();
        }
    }

    public static final void h(com.tencent.kuikly.core.views.ai aiVar, bp3.k style) {
        Intrinsics.checkNotNullParameter(aiVar, "<this>");
        Intrinsics.checkNotNullParameter(style, "style");
        com.tencent.kuikly.core.base.h color = style.getColor();
        if (color != null) {
            aiVar.i(color);
        }
        Float fontSize = style.getFontSize();
        if (fontSize != null) {
            com.tencent.kuikly.core.views.ai.m(aiVar, fontSize.floatValue(), null, 2, null);
        }
        ai textAlign = style.getTextAlign();
        if (textAlign != null) {
            int value = textAlign.getValue();
            ai.Companion companion = ai.INSTANCE;
            if (value == companion.c() || value == companion.e()) {
                aiVar.D();
            } else if (value == companion.a()) {
                aiVar.C();
            } else {
                if (value == companion.d() || value == companion.b()) {
                    aiVar.E();
                } else {
                    aiVar.D();
                }
            }
        }
        bp3.c fontWeight = style.getFontWeight();
        if (fontWeight != null) {
            b(aiVar, fontWeight.getWeight());
        }
    }

    public static final void i(cc ccVar, bp3.k style) {
        Intrinsics.checkNotNullParameter(ccVar, "<this>");
        Intrinsics.checkNotNullParameter(style, "style");
        com.tencent.kuikly.core.base.h color = style.getColor();
        if (color != null) {
            ccVar.i(color);
        }
        Float fontSize = style.getFontSize();
        if (fontSize != null) {
            cc.m(ccVar, fontSize.floatValue(), null, 2, null);
        }
        ai textAlign = style.getTextAlign();
        if (textAlign != null) {
            int value = textAlign.getValue();
            ai.Companion companion = ai.INSTANCE;
            if (value == companion.c() || value == companion.e()) {
                ccVar.F();
            } else if (value == companion.a()) {
                ccVar.E();
            } else {
                if (value == companion.d() || value == companion.b()) {
                    ccVar.G();
                } else {
                    ccVar.F();
                }
            }
        }
        bp3.c fontWeight = style.getFontWeight();
        if (fontWeight != null) {
            c(ccVar, fontWeight.getWeight());
        }
    }
}
