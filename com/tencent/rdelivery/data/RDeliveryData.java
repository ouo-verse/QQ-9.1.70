package com.tencent.rdelivery.data;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.rdelivery.net.BaseProto$ValueType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringNumberConversionsJVMKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 92\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010B\u001a\u00020\u0003\u00a2\u0006\u0004\bC\u0010%J5\u0010\u0007\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0005H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003J\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dJ\b\u0010\u001f\u001a\u00020\u0003H\u0016R$\u0010&\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010+\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010'\u001a\u0004\b(\u0010\u000b\"\u0004\b)\u0010*R$\u0010.\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010!\u001a\u0004\b,\u0010#\"\u0004\b-\u0010%R$\u00105\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00108\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010!\u001a\u0004\b6\u0010#\"\u0004\b7\u0010%R\"\u0010;\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010!\u001a\u0004\b9\u0010#\"\u0004\b:\u0010%R$\u0010@\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010<\u001a\u0004\b \u0010=\"\u0004\b>\u0010?R\u0017\u0010B\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010!\u001a\u0004\bA\u0010#\u00a8\u0006D"}, d2 = {"Lcom/tencent/rdelivery/data/RDeliveryData;", "", "T", "", "value", "Lkotlin/Function1;", "action", "e", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "", "b", "()Ljava/lang/Boolean;", "", "j", "()Ljava/lang/Integer;", "", DomainData.DOMAIN_NAME, "()Ljava/lang/Long;", "", "g", "()Ljava/lang/Double;", "", h.F, "()Ljava/lang/Float;", "p", "", "c", "Lorg/json/JSONObject;", "l", "Lorg/json/JSONArray;", "k", "toString", "a", "Ljava/lang/String;", "o", "()Ljava/lang/String;", "w", "(Ljava/lang/String;)V", "responseJsonString", "Ljava/lang/Boolean;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, HippyTKDListViewAdapter.X, "(Ljava/lang/Boolean;)V", "switchValue", "d", ReportConstant.COSTREPORT_PREFIX, "configValue", "Lcom/tencent/rdelivery/net/BaseProto$ValueType;", "Lcom/tencent/rdelivery/net/BaseProto$ValueType;", "getConfigValueType", "()Lcom/tencent/rdelivery/net/BaseProto$ValueType;", "t", "(Lcom/tencent/rdelivery/net/BaseProto$ValueType;)V", "configValueType", "f", "u", "debugInfo", "i", "v", "hitSubTaskID", "Lorg/json/JSONObject;", "()Lorg/json/JSONObject;", "r", "(Lorg/json/JSONObject;)V", "bizContent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "key", "<init>", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class RDeliveryData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String responseJsonString;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private Boolean switchValue;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String configValue;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private BaseProto$ValueType configValueType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String debugInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String hitSubTaskID;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private JSONObject bizContent;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String key;

    public RDeliveryData(@NotNull String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        this.key = key;
        this.debugInfo = "";
        this.hitSubTaskID = "0";
    }

    private final <T> T e(String value, Function1<? super String, ? extends T> action) {
        boolean isBlank;
        String str;
        Object m476constructorimpl;
        if (value != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(value);
            if (!isBlank) {
                str = value;
            } else {
                str = null;
            }
            if (str == null) {
                return null;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(action.invoke(value));
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            if (Result.m482isFailureimpl(m476constructorimpl)) {
                return null;
            }
            return (T) m476constructorimpl;
        }
        return null;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final JSONObject getBizContent() {
        return this.bizContent;
    }

    @Nullable
    public final Boolean b() {
        return (Boolean) e(this.configValue, new Function1<String, Boolean>() { // from class: com.tencent.rdelivery.data.RDeliveryData$getBoolConfigValue$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(String str) {
                return Boolean.valueOf(invoke2(str));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(@NotNull String it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return Boolean.parseBoolean(it);
            }
        });
    }

    @Nullable
    public final byte[] c() {
        return (byte[]) e(this.configValue, new Function1<String, byte[]>() { // from class: com.tencent.rdelivery.data.RDeliveryData$getBytesConfigValue$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final byte[] invoke(@NotNull String it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                byte[] bytes = it.getBytes(Charsets.UTF_8);
                Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                return bytes;
            }
        });
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final String getConfigValue() {
        return this.configValue;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getDebugInfo() {
        return this.debugInfo;
    }

    @Nullable
    public final Double g() {
        return (Double) e(this.configValue, new Function1<String, Double>() { // from class: com.tencent.rdelivery.data.RDeliveryData$getDoubleConfigValue$1
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Double invoke(@NotNull String it) {
                Double doubleOrNull;
                Intrinsics.checkParameterIsNotNull(it, "it");
                doubleOrNull = StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull(it);
                return doubleOrNull;
            }
        });
    }

    @Nullable
    public final Float h() {
        return (Float) e(this.configValue, new Function1<String, Float>() { // from class: com.tencent.rdelivery.data.RDeliveryData$getFloatConfigValue$1
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Float invoke(@NotNull String it) {
                Float floatOrNull;
                Intrinsics.checkParameterIsNotNull(it, "it");
                floatOrNull = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(it);
                return floatOrNull;
            }
        });
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getHitSubTaskID() {
        return this.hitSubTaskID;
    }

    @Nullable
    public final Integer j() {
        return (Integer) e(this.configValue, new Function1<String, Integer>() { // from class: com.tencent.rdelivery.data.RDeliveryData$getIntConfigValue$1
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Integer invoke(@NotNull String it) {
                Integer intOrNull;
                Intrinsics.checkParameterIsNotNull(it, "it");
                intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(it);
                return intOrNull;
            }
        });
    }

    @Nullable
    public final JSONArray k() {
        return (JSONArray) e(this.configValue, new Function1<String, JSONArray>() { // from class: com.tencent.rdelivery.data.RDeliveryData$getJSONArrayConfigValue$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final JSONArray invoke(@NotNull String it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return new JSONArray(it);
            }
        });
    }

    @Nullable
    public final JSONObject l() {
        return (JSONObject) e(this.configValue, new Function1<String, JSONObject>() { // from class: com.tencent.rdelivery.data.RDeliveryData$getJSONObjectConfigValue$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final JSONObject invoke(@NotNull String it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return new JSONObject(it);
            }
        });
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    @Nullable
    public final Long n() {
        return (Long) e(this.configValue, new Function1<String, Long>() { // from class: com.tencent.rdelivery.data.RDeliveryData$getLongConfigValue$1
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Long invoke(@NotNull String it) {
                Long longOrNull;
                Intrinsics.checkParameterIsNotNull(it, "it");
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(it);
                return longOrNull;
            }
        });
    }

    @Nullable
    /* renamed from: o, reason: from getter */
    public final String getResponseJsonString() {
        return this.responseJsonString;
    }

    @Nullable
    public final String p() {
        return this.configValue;
    }

    @Nullable
    /* renamed from: q, reason: from getter */
    public final Boolean getSwitchValue() {
        return this.switchValue;
    }

    public final void r(@Nullable JSONObject jSONObject) {
        this.bizContent = jSONObject;
    }

    public final void s(@Nullable String str) {
        this.configValue = str;
    }

    public final void t(@Nullable BaseProto$ValueType baseProto$ValueType) {
        this.configValueType = baseProto$ValueType;
    }

    @NotNull
    public String toString() {
        return "RDeliveryData(key='" + this.key + "', responseJsonString=" + this.responseJsonString + ", switchValue=" + this.switchValue + ", configValue=" + this.configValue + ", configValueType=" + this.configValueType + ", debugInfo='" + this.debugInfo + "', hitSubTaskID='" + this.hitSubTaskID + "', bizContent='" + this.bizContent + "')";
    }

    public final void u(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.debugInfo = str;
    }

    public final void v(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.hitSubTaskID = str;
    }

    public final void w(@Nullable String str) {
        this.responseJsonString = str;
    }

    public final void x(@Nullable Boolean bool) {
        this.switchValue = bool;
    }
}
