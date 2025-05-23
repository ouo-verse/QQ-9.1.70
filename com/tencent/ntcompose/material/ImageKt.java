package com.tencent.ntcompose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.LoadFailureParams;
import com.tencent.kuikly.core.views.LoadResolutionParams;
import com.tencent.kuikly.core.views.LoadSuccessParams;
import com.tencent.ntcompose.core.ComposeNodeKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u00fb\u0002\u0010/\u001a\u00020\f2\u0010\b\u0002\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00002B\b\u0002\u0010\u000f\u001a<\u0012\u0004\u0012\u00020\u0007\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\r\u00a2\u0006\u0002\b\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"2\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\f\u0018\u00010$2\u0016\b\u0002\u0010(\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\f\u0018\u00010$2\u0016\b\u0002\u0010*\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\f\u0018\u00010$2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+2\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0000\u0018\u00010-H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b/\u00100\u001a\u0012\u00103\u001a\u00020\f*\u0002012\u0006\u00102\u001a\u00020\u0000*\n\u00104\"\u00020\u00002\u00020\u0000\u0082\u0002\u000b\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b\u0019\u00a8\u00065"}, d2 = {"", "Lcom/tencent/ntcompose/material/Painter;", "painter", "", "drawableRawData", "customCacheKey", "Lkotlin/Function2;", "Lcom/tencent/kuikly/core/views/ImageView;", "Lcom/tencent/kuikly/core/base/aa;", "Lkotlin/ParameterName;", "name", "viewRef", "", "Lcom/tencent/ntcompose/core/RefFunc;", "Lkotlin/ExtensionFunctionType;", "ref", "contentDescription", "Lcom/tencent/ntcompose/core/i;", "modifier", "Lcom/tencent/ntcompose/material/c;", "alignment", "Lcom/tencent/ntcompose/material/h;", "contentScale", "", com.tencent.luggage.wxa.c8.c.f123400v, "Lzo3/b;", CustomAnimation.KeyPath.COLOR_FILTER, "src", "Lcom/tencent/kuikly/core/base/attr/e;", "srcUri", "", "isDotNineImage", "placeholderSrc", "blurRadius", "Lcom/tencent/ntcompose/material/y;", "maskLinearGradient", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/views/au;", "loadSuccess", "Lcom/tencent/kuikly/core/views/as;", "loadFailure", "Lcom/tencent/kuikly/core/views/at;", "loadResolution", "Lcom/tencent/kuikly/core/base/h;", "tintColor", "", "httpHeaders", "a", "(Ljava/lang/String;[BLjava/lang/String;Lkotlin/jvm/functions/Function2;Ljava/lang/String;Lcom/tencent/ntcompose/core/i;Lcom/tencent/ntcompose/material/c;ILjava/lang/Float;Lzo3/b;Ljava/lang/String;Lcom/tencent/kuikly/core/base/attr/e;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Float;Lcom/tencent/ntcompose/material/y;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lcom/tencent/kuikly/core/base/h;Ljava/util/Map;Landroidx/compose/runtime/Composer;IIII)V", "Lcom/tencent/kuikly/core/views/af;", "key", "b", "Painter", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ImageKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0471 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x049c  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x04c9  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x04fe  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x052b  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0558  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x058a  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x05b7  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x058d  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x05d9  */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0286  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(String str, byte[] bArr, String str2, Function2<? super ImageView, ? super com.tencent.kuikly.core.base.aa<ImageView>, Unit> function2, String str3, com.tencent.ntcompose.core.i iVar, c cVar, int i3, Float f16, zo3.b bVar, String str4, com.tencent.kuikly.core.base.attr.e eVar, Boolean bool, String str5, Float f17, y yVar, Function1<? super LoadSuccessParams, Unit> function1, Function1<? super LoadFailureParams, Unit> function12, Function1<? super LoadResolutionParams, Unit> function13, com.tencent.kuikly.core.base.h hVar, Map<String, String> map, Composer composer, final int i16, final int i17, final int i18, final int i19) {
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
        String str6;
        byte[] bArr2;
        String str7;
        c cVar2;
        Float f18;
        String str8;
        com.tencent.kuikly.core.base.attr.e eVar2;
        Boolean bool2;
        String str9;
        Float f19;
        y yVar2;
        Function1<? super LoadSuccessParams, Unit> function14;
        Function1<? super LoadFailureParams, Unit> function15;
        Function1<? super LoadResolutionParams, Unit> function16;
        com.tencent.kuikly.core.base.h hVar2;
        Map<String, String> map2;
        zo3.b bVar2;
        ArrayList arrayList;
        t tVar;
        final Float f26;
        Boolean bool3;
        final Function2<? super ImageView, ? super com.tencent.kuikly.core.base.aa<ImageView>, Unit> function22;
        final com.tencent.ntcompose.core.i iVar2;
        final Function1<? super LoadFailureParams, Unit> function17;
        final Function1<? super LoadResolutionParams, Unit> function18;
        final String str10;
        final com.tencent.kuikly.core.base.attr.e eVar3;
        final String str11;
        final int i69;
        final String str12;
        final Float f27;
        final y yVar3;
        final Function1<? super LoadSuccessParams, Unit> function19;
        final com.tencent.kuikly.core.base.h hVar3;
        final zo3.b bVar3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1640398095);
        int i75 = i19 & 1;
        if (i75 != 0) {
            i26 = i16 | 6;
        } else if ((i16 & 14) == 0) {
            i26 = (startRestartGroup.changed(str) ? 4 : 2) | i16;
        } else {
            i26 = i16;
        }
        int i76 = i19 & 2;
        if (i76 != 0) {
            i26 |= 16;
        }
        int i77 = i19 & 4;
        if (i77 != 0) {
            i26 |= MsgConstant.KRMFILETHUMBSIZE384;
        } else if ((i16 & 896) == 0) {
            i26 |= startRestartGroup.changed(str2) ? 256 : 128;
            i27 = i19 & 8;
            if (i27 == 0) {
                i26 |= 3072;
            } else if ((i16 & 7168) == 0) {
                i26 |= startRestartGroup.changed(function2) ? 2048 : 1024;
                i28 = i19 & 32;
                if (i28 != 0) {
                    i26 |= 196608;
                } else if ((i16 & 458752) == 0) {
                    i26 |= startRestartGroup.changed(iVar) ? 131072 : 65536;
                }
                i29 = i19 & 128;
                if (i29 != 0) {
                    i26 |= 12582912;
                } else if ((i16 & 29360128) == 0) {
                    i26 |= startRestartGroup.changed(i3) ? 8388608 : 4194304;
                }
                i36 = i19 & 256;
                if (i36 != 0) {
                    i26 |= 100663296;
                } else if ((i16 & 234881024) == 0) {
                    i26 |= startRestartGroup.changed(f16) ? 67108864 : 33554432;
                }
                i37 = i19 & 512;
                if (i37 != 0) {
                    i26 |= 805306368;
                } else if ((i16 & 1879048192) == 0) {
                    i26 |= startRestartGroup.changed(bVar) ? 536870912 : 268435456;
                }
                i38 = i19 & 1024;
                if (i38 != 0) {
                    i39 = i17 | 6;
                } else if ((i17 & 14) == 0) {
                    i39 = i17 | (startRestartGroup.changed(str4) ? 4 : 2);
                } else {
                    i39 = i17;
                }
                i46 = i19 & 2048;
                if (i46 != 0) {
                    i39 |= 16;
                }
                int i78 = i39;
                i47 = i19 & 4096;
                if (i47 != 0) {
                    i78 |= MsgConstant.KRMFILETHUMBSIZE384;
                } else if ((i17 & 896) == 0) {
                    i78 |= startRestartGroup.changed(bool) ? 256 : 128;
                    i48 = i19 & 8192;
                    if (i48 == 0) {
                        i78 |= 3072;
                        i49 = i48;
                    } else {
                        i49 = i48;
                        if ((i17 & 7168) == 0) {
                            i78 |= startRestartGroup.changed(str5) ? 2048 : 1024;
                            i56 = i19 & 16384;
                            if (i56 != 0) {
                                i78 |= 24576;
                            } else if ((i17 & 57344) == 0) {
                                i57 = i56;
                                i78 |= startRestartGroup.changed(f17) ? 16384 : 8192;
                                i58 = i19 & 32768;
                                if (i58 != 0) {
                                    i78 |= 65536;
                                }
                                i59 = i19 & 65536;
                                if (i59 == 0) {
                                    i78 |= 1572864;
                                } else if ((i17 & 3670016) == 0) {
                                    i78 |= startRestartGroup.changed(function1) ? 1048576 : 524288;
                                }
                                i65 = i19 & 131072;
                                if (i65 == 0) {
                                    i78 |= 12582912;
                                } else if ((i17 & 29360128) == 0) {
                                    i78 |= startRestartGroup.changed(function12) ? 8388608 : 4194304;
                                }
                                i66 = i19 & 262144;
                                if (i66 == 0) {
                                    i78 |= 100663296;
                                } else if ((i17 & 234881024) == 0) {
                                    i78 |= startRestartGroup.changed(function13) ? 67108864 : 33554432;
                                }
                                i67 = i19 & 524288;
                                if (i67 != 0) {
                                    i78 |= 268435456;
                                }
                                i68 = i19 & 1048576;
                                int i79 = i68 == 0 ? i18 | 2 : i18;
                                if ((i19 & 1607682) != 1607682 && (1531254491 & i26) == 306250898 && (1533916891 & i78) == 306783378 && (i79 & 11) == 2 && startRestartGroup.getSkipping()) {
                                    startRestartGroup.skipToGroupEnd();
                                    str6 = str;
                                    bArr2 = bArr;
                                    str11 = str2;
                                    function22 = function2;
                                    str12 = str3;
                                    iVar2 = iVar;
                                    cVar2 = cVar;
                                    i69 = i3;
                                    f26 = f16;
                                    bVar3 = bVar;
                                    str10 = str4;
                                    eVar3 = eVar;
                                    bool3 = bool;
                                    str9 = str5;
                                    f27 = f17;
                                    yVar3 = yVar;
                                    function19 = function1;
                                    function17 = function12;
                                    function18 = function13;
                                    hVar3 = hVar;
                                    map2 = map;
                                } else {
                                    str6 = i75 == 0 ? null : str;
                                    bArr2 = i76 == 0 ? null : bArr;
                                    str7 = i77 == 0 ? null : str2;
                                    Function2<? super ImageView, ? super com.tencent.kuikly.core.base.aa<ImageView>, Unit> function23 = i27 == 0 ? null : function2;
                                    String str13 = (i19 & 16) == 0 ? null : str3;
                                    com.tencent.ntcompose.core.i iVar3 = i28 == 0 ? com.tencent.ntcompose.core.i.INSTANCE : iVar;
                                    cVar2 = (i19 & 64) == 0 ? null : cVar;
                                    int a16 = i29 == 0 ? h.INSTANCE.a() : i3;
                                    f18 = i36 == 0 ? null : f16;
                                    zo3.b bVar4 = i37 == 0 ? null : bVar;
                                    str8 = i38 == 0 ? null : str4;
                                    eVar2 = i46 == 0 ? null : eVar;
                                    bool2 = i47 == 0 ? null : bool;
                                    str9 = i49 == 0 ? null : str5;
                                    f19 = i57 == 0 ? null : f17;
                                    yVar2 = i58 == 0 ? null : yVar;
                                    function14 = i59 == 0 ? null : function1;
                                    function15 = i65 == 0 ? null : function12;
                                    function16 = i66 == 0 ? null : function13;
                                    hVar2 = i67 == 0 ? null : hVar;
                                    map2 = i68 == 0 ? null : map;
                                    if (ComposerKt.isTraceInProgress()) {
                                        bVar2 = bVar4;
                                    } else {
                                        bVar2 = bVar4;
                                        ComposerKt.traceEventStart(1640398095, i26, i78, "com.tencent.ntcompose.material.Image (Image.kt:67)");
                                    }
                                    arrayList = new ArrayList();
                                    if (str7 != null) {
                                        arrayList.add(new com.tencent.ntcompose.core.k("customCacheKey", str7, null, null, null, null, t.f339446a, 60, null));
                                    }
                                    if (map2 != null) {
                                        arrayList.add(new com.tencent.ntcompose.core.k("httpHeaders", map2, null, null, null, null, t.f339446a, 60, null));
                                    }
                                    if (function15 != null) {
                                        arrayList.add(new com.tencent.ntcompose.core.k("loadFailure", function15, null, null, null, null, t.f339446a, 60, null));
                                    }
                                    if (str6 != null) {
                                        arrayList.add(new com.tencent.ntcompose.core.k("painter", str6, bool2, null, null, null, t.f339446a, 56, null));
                                    }
                                    if (bArr2 != null) {
                                        arrayList.add(new com.tencent.ntcompose.core.k("drawableRawData", bArr2, null, null, null, null, t.f339446a, 60, null));
                                    }
                                    h d16 = h.d(a16);
                                    tVar = t.f339446a;
                                    arrayList.add(new com.tencent.ntcompose.core.k("contentScale", d16, null, null, null, null, tVar, 60, null));
                                    if (f18 != null) {
                                        arrayList.add(new com.tencent.ntcompose.core.k("imageAlpha", Float.valueOf(f18.floatValue()), null, null, null, null, tVar, 60, null));
                                    }
                                    if (hVar2 != null) {
                                        arrayList.add(new com.tencent.ntcompose.core.k("tintColor", hVar2, null, null, null, null, tVar, 60, null));
                                    }
                                    if (str8 == null || eVar2 != null) {
                                        arrayList.add(new com.tencent.ntcompose.core.k("src", str8, eVar2, bool2, null, null, tVar, 48, null));
                                    }
                                    if (str9 != null) {
                                        arrayList.add(new com.tencent.ntcompose.core.k("placeholderSrc", str9, null, null, null, null, tVar, 60, null));
                                    }
                                    if (f19 != null) {
                                        arrayList.add(new com.tencent.ntcompose.core.k("blurRadius", Float.valueOf(f19.floatValue()), null, null, null, null, tVar, 60, null));
                                    }
                                    if (yVar2 != null) {
                                        arrayList.add(new com.tencent.ntcompose.core.k("maskLinearGradient", yVar2, null, null, null, null, tVar, 60, null));
                                    }
                                    if (function14 != null) {
                                        arrayList.add(new com.tencent.ntcompose.core.k("loadSuccess", function14, null, null, null, null, tVar, 60, null));
                                    }
                                    if (function16 != null) {
                                        arrayList.add(new com.tencent.ntcompose.core.k("loadResolution", function16, null, null, null, null, tVar, 60, null));
                                    }
                                    ComposeNodeKt.a("image", com.tencent.ntcompose.material.base.a.f339408a, function23 != null ? null : function23, iVar3, arrayList, null, startRestartGroup, ((i26 >> 6) & 7168) | 32822, 32);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    f26 = f18;
                                    bool3 = bool2;
                                    function22 = function23;
                                    iVar2 = iVar3;
                                    function17 = function15;
                                    function18 = function16;
                                    str10 = str8;
                                    eVar3 = eVar2;
                                    str11 = str7;
                                    i69 = a16;
                                    str12 = str13;
                                    f27 = f19;
                                    yVar3 = yVar2;
                                    function19 = function14;
                                    hVar3 = hVar2;
                                    bVar3 = bVar2;
                                }
                                endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup != null) {
                                    return;
                                }
                                final String str14 = str6;
                                final byte[] bArr3 = bArr2;
                                final c cVar3 = cVar2;
                                final Boolean bool4 = bool3;
                                final String str15 = str9;
                                final Map<String, String> map3 = map2;
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>(str14, bArr3, str11, function22, str12, iVar2, cVar3, i69, f26, bVar3, str10, eVar3, bool4, str15, f27, yVar3, function19, function17, function18, hVar3, map3, i16, i17, i18, i19) { // from class: com.tencent.ntcompose.material.ImageKt$Image$1
                                    final /* synthetic */ int $$changed;
                                    final /* synthetic */ int $$changed1;
                                    final /* synthetic */ int $$changed2;
                                    final /* synthetic */ int $$default;
                                    final /* synthetic */ c $alignment;
                                    final /* synthetic */ Float $alpha;
                                    final /* synthetic */ Float $blurRadius;
                                    final /* synthetic */ zo3.b $colorFilter;
                                    final /* synthetic */ String $contentDescription;
                                    final /* synthetic */ int $contentScale;
                                    final /* synthetic */ String $customCacheKey;
                                    final /* synthetic */ byte[] $drawableRawData;
                                    final /* synthetic */ Map<String, String> $httpHeaders;
                                    final /* synthetic */ Boolean $isDotNineImage;
                                    final /* synthetic */ Function1<LoadFailureParams, Unit> $loadFailure;
                                    final /* synthetic */ Function1<LoadResolutionParams, Unit> $loadResolution;
                                    final /* synthetic */ Function1<LoadSuccessParams, Unit> $loadSuccess;
                                    final /* synthetic */ y $maskLinearGradient;
                                    final /* synthetic */ com.tencent.ntcompose.core.i $modifier;
                                    final /* synthetic */ String $painter;
                                    final /* synthetic */ String $placeholderSrc;
                                    final /* synthetic */ Function2<ImageView, com.tencent.kuikly.core.base.aa<ImageView>, Unit> $ref;
                                    final /* synthetic */ String $src;
                                    final /* synthetic */ com.tencent.kuikly.core.base.attr.e $srcUri;
                                    final /* synthetic */ com.tencent.kuikly.core.base.h $tintColor;

                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                        this.$src = str10;
                                        this.$srcUri = eVar3;
                                        this.$isDotNineImage = bool4;
                                        this.$placeholderSrc = str15;
                                        this.$blurRadius = f27;
                                        this.$maskLinearGradient = yVar3;
                                        this.$loadSuccess = function19;
                                        this.$loadFailure = function17;
                                        this.$loadResolution = function18;
                                        this.$tintColor = hVar3;
                                        this.$httpHeaders = map3;
                                        this.$$changed = i16;
                                        this.$$changed1 = i17;
                                        this.$$changed2 = i18;
                                        this.$$default = i19;
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                        invoke(composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer2, int i85) {
                                        ImageKt.a(this.$painter, this.$drawableRawData, this.$customCacheKey, this.$ref, this.$contentDescription, this.$modifier, this.$alignment, this.$contentScale, this.$alpha, null, this.$src, this.$srcUri, this.$isDotNineImage, this.$placeholderSrc, this.$blurRadius, this.$maskLinearGradient, this.$loadSuccess, this.$loadFailure, this.$loadResolution, this.$tintColor, this.$httpHeaders, composer2, this.$$changed | 1, this.$$changed1, this.$$changed2, this.$$default);
                                    }
                                });
                                return;
                            }
                            i57 = i56;
                            i58 = i19 & 32768;
                            if (i58 != 0) {
                            }
                            i59 = i19 & 65536;
                            if (i59 == 0) {
                            }
                            i65 = i19 & 131072;
                            if (i65 == 0) {
                            }
                            i66 = i19 & 262144;
                            if (i66 == 0) {
                            }
                            i67 = i19 & 524288;
                            if (i67 != 0) {
                            }
                            i68 = i19 & 1048576;
                            if (i68 == 0) {
                            }
                            if ((i19 & 1607682) != 1607682) {
                            }
                            if (i75 == 0) {
                            }
                            if (i76 == 0) {
                            }
                            if (i77 == 0) {
                            }
                            if (i27 == 0) {
                            }
                            if ((i19 & 16) == 0) {
                            }
                            if (i28 == 0) {
                            }
                            if ((i19 & 64) == 0) {
                            }
                            if (i29 == 0) {
                            }
                            if (i36 == 0) {
                            }
                            if (i37 == 0) {
                            }
                            if (i38 == 0) {
                            }
                            if (i46 == 0) {
                            }
                            if (i47 == 0) {
                            }
                            if (i49 == 0) {
                            }
                            if (i57 == 0) {
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
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            arrayList = new ArrayList();
                            if (str7 != null) {
                            }
                            if (map2 != null) {
                            }
                            if (function15 != null) {
                            }
                            if (str6 != null) {
                            }
                            if (bArr2 != null) {
                            }
                            h d162 = h.d(a16);
                            tVar = t.f339446a;
                            arrayList.add(new com.tencent.ntcompose.core.k("contentScale", d162, null, null, null, null, tVar, 60, null));
                            if (f18 != null) {
                            }
                            if (hVar2 != null) {
                            }
                            if (str8 == null) {
                            }
                            arrayList.add(new com.tencent.ntcompose.core.k("src", str8, eVar2, bool2, null, null, tVar, 48, null));
                            if (str9 != null) {
                            }
                            if (f19 != null) {
                            }
                            if (yVar2 != null) {
                            }
                            if (function14 != null) {
                            }
                            if (function16 != null) {
                            }
                            ComposeNodeKt.a("image", com.tencent.ntcompose.material.base.a.f339408a, function23 != null ? null : function23, iVar3, arrayList, null, startRestartGroup, ((i26 >> 6) & 7168) | 32822, 32);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            f26 = f18;
                            bool3 = bool2;
                            function22 = function23;
                            iVar2 = iVar3;
                            function17 = function15;
                            function18 = function16;
                            str10 = str8;
                            eVar3 = eVar2;
                            str11 = str7;
                            i69 = a16;
                            str12 = str13;
                            f27 = f19;
                            yVar3 = yVar2;
                            function19 = function14;
                            hVar3 = hVar2;
                            bVar3 = bVar2;
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                    }
                    i56 = i19 & 16384;
                    if (i56 != 0) {
                    }
                    i57 = i56;
                    i58 = i19 & 32768;
                    if (i58 != 0) {
                    }
                    i59 = i19 & 65536;
                    if (i59 == 0) {
                    }
                    i65 = i19 & 131072;
                    if (i65 == 0) {
                    }
                    i66 = i19 & 262144;
                    if (i66 == 0) {
                    }
                    i67 = i19 & 524288;
                    if (i67 != 0) {
                    }
                    i68 = i19 & 1048576;
                    if (i68 == 0) {
                    }
                    if ((i19 & 1607682) != 1607682) {
                    }
                    if (i75 == 0) {
                    }
                    if (i76 == 0) {
                    }
                    if (i77 == 0) {
                    }
                    if (i27 == 0) {
                    }
                    if ((i19 & 16) == 0) {
                    }
                    if (i28 == 0) {
                    }
                    if ((i19 & 64) == 0) {
                    }
                    if (i29 == 0) {
                    }
                    if (i36 == 0) {
                    }
                    if (i37 == 0) {
                    }
                    if (i38 == 0) {
                    }
                    if (i46 == 0) {
                    }
                    if (i47 == 0) {
                    }
                    if (i49 == 0) {
                    }
                    if (i57 == 0) {
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
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    arrayList = new ArrayList();
                    if (str7 != null) {
                    }
                    if (map2 != null) {
                    }
                    if (function15 != null) {
                    }
                    if (str6 != null) {
                    }
                    if (bArr2 != null) {
                    }
                    h d1622 = h.d(a16);
                    tVar = t.f339446a;
                    arrayList.add(new com.tencent.ntcompose.core.k("contentScale", d1622, null, null, null, null, tVar, 60, null));
                    if (f18 != null) {
                    }
                    if (hVar2 != null) {
                    }
                    if (str8 == null) {
                    }
                    arrayList.add(new com.tencent.ntcompose.core.k("src", str8, eVar2, bool2, null, null, tVar, 48, null));
                    if (str9 != null) {
                    }
                    if (f19 != null) {
                    }
                    if (yVar2 != null) {
                    }
                    if (function14 != null) {
                    }
                    if (function16 != null) {
                    }
                    ComposeNodeKt.a("image", com.tencent.ntcompose.material.base.a.f339408a, function23 != null ? null : function23, iVar3, arrayList, null, startRestartGroup, ((i26 >> 6) & 7168) | 32822, 32);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    f26 = f18;
                    bool3 = bool2;
                    function22 = function23;
                    iVar2 = iVar3;
                    function17 = function15;
                    function18 = function16;
                    str10 = str8;
                    eVar3 = eVar2;
                    str11 = str7;
                    i69 = a16;
                    str12 = str13;
                    f27 = f19;
                    yVar3 = yVar2;
                    function19 = function14;
                    hVar3 = hVar2;
                    bVar3 = bVar2;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i48 = i19 & 8192;
                if (i48 == 0) {
                }
                i56 = i19 & 16384;
                if (i56 != 0) {
                }
                i57 = i56;
                i58 = i19 & 32768;
                if (i58 != 0) {
                }
                i59 = i19 & 65536;
                if (i59 == 0) {
                }
                i65 = i19 & 131072;
                if (i65 == 0) {
                }
                i66 = i19 & 262144;
                if (i66 == 0) {
                }
                i67 = i19 & 524288;
                if (i67 != 0) {
                }
                i68 = i19 & 1048576;
                if (i68 == 0) {
                }
                if ((i19 & 1607682) != 1607682) {
                }
                if (i75 == 0) {
                }
                if (i76 == 0) {
                }
                if (i77 == 0) {
                }
                if (i27 == 0) {
                }
                if ((i19 & 16) == 0) {
                }
                if (i28 == 0) {
                }
                if ((i19 & 64) == 0) {
                }
                if (i29 == 0) {
                }
                if (i36 == 0) {
                }
                if (i37 == 0) {
                }
                if (i38 == 0) {
                }
                if (i46 == 0) {
                }
                if (i47 == 0) {
                }
                if (i49 == 0) {
                }
                if (i57 == 0) {
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
                if (ComposerKt.isTraceInProgress()) {
                }
                arrayList = new ArrayList();
                if (str7 != null) {
                }
                if (map2 != null) {
                }
                if (function15 != null) {
                }
                if (str6 != null) {
                }
                if (bArr2 != null) {
                }
                h d16222 = h.d(a16);
                tVar = t.f339446a;
                arrayList.add(new com.tencent.ntcompose.core.k("contentScale", d16222, null, null, null, null, tVar, 60, null));
                if (f18 != null) {
                }
                if (hVar2 != null) {
                }
                if (str8 == null) {
                }
                arrayList.add(new com.tencent.ntcompose.core.k("src", str8, eVar2, bool2, null, null, tVar, 48, null));
                if (str9 != null) {
                }
                if (f19 != null) {
                }
                if (yVar2 != null) {
                }
                if (function14 != null) {
                }
                if (function16 != null) {
                }
                ComposeNodeKt.a("image", com.tencent.ntcompose.material.base.a.f339408a, function23 != null ? null : function23, iVar3, arrayList, null, startRestartGroup, ((i26 >> 6) & 7168) | 32822, 32);
                if (ComposerKt.isTraceInProgress()) {
                }
                f26 = f18;
                bool3 = bool2;
                function22 = function23;
                iVar2 = iVar3;
                function17 = function15;
                function18 = function16;
                str10 = str8;
                eVar3 = eVar2;
                str11 = str7;
                i69 = a16;
                str12 = str13;
                f27 = f19;
                yVar3 = yVar2;
                function19 = function14;
                hVar3 = hVar2;
                bVar3 = bVar2;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i28 = i19 & 32;
            if (i28 != 0) {
            }
            i29 = i19 & 128;
            if (i29 != 0) {
            }
            i36 = i19 & 256;
            if (i36 != 0) {
            }
            i37 = i19 & 512;
            if (i37 != 0) {
            }
            i38 = i19 & 1024;
            if (i38 != 0) {
            }
            i46 = i19 & 2048;
            if (i46 != 0) {
            }
            int i782 = i39;
            i47 = i19 & 4096;
            if (i47 != 0) {
            }
            i48 = i19 & 8192;
            if (i48 == 0) {
            }
            i56 = i19 & 16384;
            if (i56 != 0) {
            }
            i57 = i56;
            i58 = i19 & 32768;
            if (i58 != 0) {
            }
            i59 = i19 & 65536;
            if (i59 == 0) {
            }
            i65 = i19 & 131072;
            if (i65 == 0) {
            }
            i66 = i19 & 262144;
            if (i66 == 0) {
            }
            i67 = i19 & 524288;
            if (i67 != 0) {
            }
            i68 = i19 & 1048576;
            if (i68 == 0) {
            }
            if ((i19 & 1607682) != 1607682) {
            }
            if (i75 == 0) {
            }
            if (i76 == 0) {
            }
            if (i77 == 0) {
            }
            if (i27 == 0) {
            }
            if ((i19 & 16) == 0) {
            }
            if (i28 == 0) {
            }
            if ((i19 & 64) == 0) {
            }
            if (i29 == 0) {
            }
            if (i36 == 0) {
            }
            if (i37 == 0) {
            }
            if (i38 == 0) {
            }
            if (i46 == 0) {
            }
            if (i47 == 0) {
            }
            if (i49 == 0) {
            }
            if (i57 == 0) {
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
            if (ComposerKt.isTraceInProgress()) {
            }
            arrayList = new ArrayList();
            if (str7 != null) {
            }
            if (map2 != null) {
            }
            if (function15 != null) {
            }
            if (str6 != null) {
            }
            if (bArr2 != null) {
            }
            h d162222 = h.d(a16);
            tVar = t.f339446a;
            arrayList.add(new com.tencent.ntcompose.core.k("contentScale", d162222, null, null, null, null, tVar, 60, null));
            if (f18 != null) {
            }
            if (hVar2 != null) {
            }
            if (str8 == null) {
            }
            arrayList.add(new com.tencent.ntcompose.core.k("src", str8, eVar2, bool2, null, null, tVar, 48, null));
            if (str9 != null) {
            }
            if (f19 != null) {
            }
            if (yVar2 != null) {
            }
            if (function14 != null) {
            }
            if (function16 != null) {
            }
            ComposeNodeKt.a("image", com.tencent.ntcompose.material.base.a.f339408a, function23 != null ? null : function23, iVar3, arrayList, null, startRestartGroup, ((i26 >> 6) & 7168) | 32822, 32);
            if (ComposerKt.isTraceInProgress()) {
            }
            f26 = f18;
            bool3 = bool2;
            function22 = function23;
            iVar2 = iVar3;
            function17 = function15;
            function18 = function16;
            str10 = str8;
            eVar3 = eVar2;
            str11 = str7;
            i69 = a16;
            str12 = str13;
            f27 = f19;
            yVar3 = yVar2;
            function19 = function14;
            hVar3 = hVar2;
            bVar3 = bVar2;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i27 = i19 & 8;
        if (i27 == 0) {
        }
        i28 = i19 & 32;
        if (i28 != 0) {
        }
        i29 = i19 & 128;
        if (i29 != 0) {
        }
        i36 = i19 & 256;
        if (i36 != 0) {
        }
        i37 = i19 & 512;
        if (i37 != 0) {
        }
        i38 = i19 & 1024;
        if (i38 != 0) {
        }
        i46 = i19 & 2048;
        if (i46 != 0) {
        }
        int i7822 = i39;
        i47 = i19 & 4096;
        if (i47 != 0) {
        }
        i48 = i19 & 8192;
        if (i48 == 0) {
        }
        i56 = i19 & 16384;
        if (i56 != 0) {
        }
        i57 = i56;
        i58 = i19 & 32768;
        if (i58 != 0) {
        }
        i59 = i19 & 65536;
        if (i59 == 0) {
        }
        i65 = i19 & 131072;
        if (i65 == 0) {
        }
        i66 = i19 & 262144;
        if (i66 == 0) {
        }
        i67 = i19 & 524288;
        if (i67 != 0) {
        }
        i68 = i19 & 1048576;
        if (i68 == 0) {
        }
        if ((i19 & 1607682) != 1607682) {
        }
        if (i75 == 0) {
        }
        if (i76 == 0) {
        }
        if (i77 == 0) {
        }
        if (i27 == 0) {
        }
        if ((i19 & 16) == 0) {
        }
        if (i28 == 0) {
        }
        if ((i19 & 64) == 0) {
        }
        if (i29 == 0) {
        }
        if (i36 == 0) {
        }
        if (i37 == 0) {
        }
        if (i38 == 0) {
        }
        if (i46 == 0) {
        }
        if (i47 == 0) {
        }
        if (i49 == 0) {
        }
        if (i57 == 0) {
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
        if (ComposerKt.isTraceInProgress()) {
        }
        arrayList = new ArrayList();
        if (str7 != null) {
        }
        if (map2 != null) {
        }
        if (function15 != null) {
        }
        if (str6 != null) {
        }
        if (bArr2 != null) {
        }
        h d1622222 = h.d(a16);
        tVar = t.f339446a;
        arrayList.add(new com.tencent.ntcompose.core.k("contentScale", d1622222, null, null, null, null, tVar, 60, null));
        if (f18 != null) {
        }
        if (hVar2 != null) {
        }
        if (str8 == null) {
        }
        arrayList.add(new com.tencent.ntcompose.core.k("src", str8, eVar2, bool2, null, null, tVar, 48, null));
        if (str9 != null) {
        }
        if (f19 != null) {
        }
        if (yVar2 != null) {
        }
        if (function14 != null) {
        }
        if (function16 != null) {
        }
        ComposeNodeKt.a("image", com.tencent.ntcompose.material.base.a.f339408a, function23 != null ? null : function23, iVar3, arrayList, null, startRestartGroup, ((i26 >> 6) & 7168) | 32822, 32);
        if (ComposerKt.isTraceInProgress()) {
        }
        f26 = f18;
        bool3 = bool2;
        function22 = function23;
        iVar2 = iVar3;
        function17 = function15;
        function18 = function16;
        str10 = str8;
        eVar3 = eVar2;
        str11 = str7;
        i69 = a16;
        str12 = str13;
        f27 = f19;
        yVar3 = yVar2;
        function19 = function14;
        hVar3 = hVar2;
        bVar3 = bVar2;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static final void b(com.tencent.kuikly.core.views.af afVar, String key) {
        Intrinsics.checkNotNullParameter(afVar, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        afVar.with("customCacheKey", key);
    }
}
