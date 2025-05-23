package com.tencent.mobileqq.nearbypro.utils;

import com.tencent.mobileqq.nearbypro.land.AreaParam;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import e33.RspErrorData;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0003\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0005\u001a\n\u0010\b\u001a\u00020\u0001*\u00020\u0007\u001a\n\u0010\n\u001a\u00020\u0001*\u00020\t\u001a\n\u0010\f\u001a\u00020\u0001*\u00020\u000b\u001a\n\u0010\u000e\u001a\u00020\u0001*\u00020\r\u001a\n\u0010\u0010\u001a\u00020\u0001*\u00020\u000f\u001a\n\u0010\u0012\u001a\u00020\u0001*\u00020\u0011\u001a\n\u0010\u0014\u001a\u00020\u0001*\u00020\u0013\u001a\n\u0010\u0016\u001a\u00020\u0001*\u00020\u0015\u001a\u0016\u0010\u0019\u001a\u00020\u0018*\u0004\u0018\u00010\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b\u001a\n\u0010\u001b\u001a\u00020\u0001*\u00020\u001a\u001a\n\u0010\u001d\u001a\u00020\u0001*\u00020\u001c\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/land/h;", "", "b", "Lqp4/a;", tl.h.F, "Lqp4/d;", "k", "Lqp4/c;", "j", "Lqp4/b;", "i", "Lcq4/e;", "e", "Lcq4/d;", "d", "Lcq4/b;", "c", "Leq4/b;", "g", "Lxp4/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lxp4/h;", DomainData.DOMAIN_NAME, "data", "", "a", "Le33/c;", "f", "Lrp4/g;", "l", "qq_nearby_pro_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class ToStringExKt {
    public static final boolean a(@Nullable cq4.e eVar, @Nullable cq4.e eVar2) {
        if (eVar2 == null || eVar == null || !Intrinsics.areEqual(eVar.f391680b, eVar2.f391680b) || eVar.f391681c != eVar2.f391681c) {
            return false;
        }
        return true;
    }

    @NotNull
    public static final String b(@NotNull AreaParam areaParam) {
        String str;
        Intrinsics.checkNotNullParameter(areaParam, "<this>");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("{mode=" + areaParam.getMode() + " ");
        qp4.a areaInfo = areaParam.getAreaInfo();
        if (areaInfo != null) {
            str = h(areaInfo);
        } else {
            str = null;
        }
        sb5.append("areaInfo=" + str);
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "str.toString()");
        return sb6;
    }

    @NotNull
    public static final String c(@NotNull cq4.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{AreaId=" + bVar.f391668a + " ");
        stringBuffer.append("roomId=" + bVar.f391669b + " ");
        stringBuffer.append("onlineNum=" + bVar.f391672e + "} ");
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "str.toString()");
        return stringBuffer2;
    }

    @NotNull
    public static final String d(@NotNull cq4.d dVar) {
        String str;
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        StringBuffer stringBuffer = new StringBuffer();
        cq4.e eVar = dVar.f391677a;
        if (eVar != null) {
            str = e(eVar);
        } else {
            str = null;
        }
        stringBuffer.append("{profile=" + str + " ");
        stringBuffer.append("tableId=" + dVar.f391678b + "} ");
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "str.toString()");
        return stringBuffer2;
    }

    @NotNull
    public static final String e(@NotNull cq4.e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        StringBuffer stringBuffer = new StringBuffer();
        byte[] nick = eVar.f391679a;
        Intrinsics.checkNotNullExpressionValue(nick, "nick");
        stringBuffer.append("{nick=" + new String(nick, Charsets.UTF_8) + " ");
        stringBuffer.append("head=" + eVar.f391680b + " ");
        stringBuffer.append("gender=" + eVar.f391681c + "}");
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "str.toString()");
        return stringBuffer2;
    }

    @NotNull
    public static final String f(@NotNull RspErrorData rspErrorData) {
        Intrinsics.checkNotNullParameter(rspErrorData, "<this>");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("RspErrorData {errCode=" + rspErrorData.getErrCode() + " ");
        stringBuffer.append("errMsg=" + rspErrorData.getErrMsg() + " ");
        stringBuffer.append("prompt=" + rspErrorData.getPrompt() + "} ");
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "str.toString()");
        return stringBuffer2;
    }

    @NotNull
    public static final String g(@NotNull eq4.b bVar) {
        String str;
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        StringBuffer stringBuffer = new StringBuffer();
        cq4.b[] bVarArr = bVar.f397039a;
        if (bVarArr != null) {
            str = ArraysKt___ArraysKt.joinToString$default(bVarArr, (CharSequence) null, "[", "]", 0, (CharSequence) null, new Function1<cq4.b, CharSequence>() { // from class: com.tencent.mobileqq.nearbypro.utils.ToStringExKt$toStringEx$bgInfoStr$2
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CharSequence invoke(cq4.b it) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    return String.valueOf(ToStringExKt.c(it));
                }
            }, 25, (Object) null);
        } else {
            str = null;
        }
        stringBuffer.append("areaInfo=" + str + " ");
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "str.toString()");
        return stringBuffer2;
    }

    @NotNull
    public static final String h(@NotNull qp4.a aVar) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("AreaID=" + aVar.f429197a + " ");
        qp4.e eVar = aVar.f429198b;
        sb5.append("coord=" + eVar.f429215a + ", " + eVar.f429216b + " ");
        qp4.c[] cVarArr = aVar.f429199c;
        String str3 = null;
        if (cVarArr != null) {
            str = ArraysKt___ArraysKt.joinToString$default(cVarArr, (CharSequence) null, "[", "]", 0, (CharSequence) null, new Function1<qp4.c, CharSequence>() { // from class: com.tencent.mobileqq.nearbypro.utils.ToStringExKt$toStringEx$bgInfoStr$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CharSequence invoke(qp4.c it) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    return String.valueOf(ToStringExKt.j(it));
                }
            }, 25, (Object) null);
        } else {
            str = null;
        }
        sb5.append("bg=" + str + " ");
        qp4.b[] bVarArr = aVar.f429200d;
        if (bVarArr != null) {
            str2 = ArraysKt___ArraysKt.joinToString$default(bVarArr, (CharSequence) null, "[", "]", 0, (CharSequence) null, new Function1<qp4.b, CharSequence>() { // from class: com.tencent.mobileqq.nearbypro.utils.ToStringExKt$toStringEx$attachStr$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CharSequence invoke(qp4.b it) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    return String.valueOf(ToStringExKt.i(it));
                }
            }, 25, (Object) null);
        } else {
            str2 = null;
        }
        sb5.append("attachment=" + str2 + " ");
        qp4.d dVar = aVar.f429201e;
        if (dVar != null) {
            str3 = k(dVar);
        }
        sb5.append("summaryInfo=" + str3 + " ");
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "str.toString()");
        return sb6;
    }

    @NotNull
    public static final String i(@NotNull qp4.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("url=" + bVar.f429203a + " ");
        stringBuffer.append("jumpUrl=" + bVar.f429205c + " ");
        stringBuffer.append("x=" + bVar.f429204b.f429217a + " ");
        stringBuffer.append("y=" + bVar.f429204b.f429218b);
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "str.toString()");
        return stringBuffer2;
    }

    @NotNull
    public static final String j(@NotNull qp4.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("url=" + cVar.f429207a + " ");
        stringBuffer.append("width=" + cVar.f429208b + " ");
        stringBuffer.append("height=" + cVar.f429209c);
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "str.toString()");
        return stringBuffer2;
    }

    @NotNull
    public static final String k(@NotNull qp4.d dVar) {
        String str;
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("areaName=" + dVar.f429210a + " ");
        String[] strArr = dVar.f429211b;
        if (strArr != null) {
            str = ArraysKt___ArraysKt.joinToString$default(strArr, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null);
        } else {
            str = null;
        }
        sb5.append("areaColors=[" + str + "] ");
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "str.toString()");
        return sb6;
    }

    @NotNull
    public static final String l(@NotNull rp4.g gVar) {
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("StatusInfo={status=" + gVar.f431878a + " ");
        stringBuffer.append("richStatus=" + gVar.f431879b + " ");
        stringBuffer.append("icon=" + gVar.f431881d + " ");
        stringBuffer.append("bigIcon=" + gVar.f431882e + " ");
        stringBuffer.append("extData=" + gVar.f431883f + " ");
        stringBuffer.append("motionIcon=" + gVar.f431886i + " ");
        stringBuffer.append("backgroundImg=" + gVar.f431887j + " ");
        stringBuffer.append("title=" + gVar.f431880c + "} ");
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "str.toString()");
        return stringBuffer2;
    }

    @NotNull
    public static final String m(@NotNull xp4.a aVar) {
        String str;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{fid=" + aVar.f448296a + " ");
        stringBuffer.append("tid=" + aVar.f448297b + " ");
        stringBuffer.append("online=" + aVar.f448302g + " ");
        rp4.g gVar = aVar.f448300e;
        if (gVar != null) {
            str = l(gVar);
        } else {
            str = null;
        }
        stringBuffer.append(str + " ");
        stringBuffer.append("image=" + aVar.f448301f + " ");
        stringBuffer.append("online=" + aVar.f448302g + " ");
        stringBuffer.append("text=" + aVar.f448299d + "} ");
        stringBuffer.append("dis=" + aVar.f448303h);
        stringBuffer.append("post_ts=" + aVar.f448304i);
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "str.toString()");
        return stringBuffer2;
    }

    @NotNull
    public static final String n(@NotNull xp4.h hVar) {
        Float f16;
        Intrinsics.checkNotNullParameter(hVar, "<this>");
        long j3 = hVar.f448325a;
        qp4.e eVar = hVar.f448326b;
        Float f17 = null;
        if (eVar != null) {
            f16 = Float.valueOf(eVar.f429215a);
        } else {
            f16 = null;
        }
        qp4.e eVar2 = hVar.f448326b;
        if (eVar2 != null) {
            f17 = Float.valueOf(eVar2.f429216b);
        }
        return "tid:" + j3 + " lat:[" + f16 + "," + f17 + "] dis:" + hVar.f448330f + " reportTs:" + hVar.f448331g + " ";
    }
}
