package m64;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u0000 \n2\u00020\u0001:\u0001\bB!\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\u0006\u0010\u001b\u001a\u00020\u0006\u0012\u0006\u0010\u001c\u001a\u00020\u0012\u00a2\u0006\u0004\b\u001d\u0010\u001eB\u0011\b\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001d\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006R\"\u0010\u000e\u001a\u00020\u00068\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR+\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00128F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006 "}, d2 = {"Lm64/a;", "", "Lorg/json/JSONObject;", "jsonObject", "", "e", "", "i", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", h.F, "(Ljava/lang/String;)V", "mRobotId", "b", "f", "mFunctionName", "", "<set-?>", "c", "Lkotlin/properties/ReadWriteProperty;", "()I", "g", "(I)V", "mFunctionType", "robotId", "functionName", "functionType", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "jsonString", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public String mRobotId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public String mFunctionName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ReadWriteProperty mFunctionType;

    /* renamed from: e, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f416314e = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "mFunctionType", "getMFunctionType()I", 0))};

    public a(@NotNull String robotId, @NotNull String functionName, int i3) {
        Intrinsics.checkNotNullParameter(robotId, "robotId");
        Intrinsics.checkNotNullParameter(functionName, "functionName");
        this.mFunctionType = Delegates.INSTANCE.notNull();
        h(robotId);
        f(functionName);
        g(i3);
    }

    private final void e(JSONObject jsonObject) {
        String optString = jsonObject.optString("ROBOT_ID", "");
        Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(ROBOT_ID, \"\")");
        h(optString);
        String optString2 = jsonObject.optString("FUNCTION_NAME", "");
        Intrinsics.checkNotNullExpressionValue(optString2, "jsonObject.optString(FUNCTION_NAME, \"\")");
        f(optString2);
        g(jsonObject.optInt("FUNCTION_TYPE", 1));
    }

    @NotNull
    public final String a() {
        return d() + "_" + b() + "_" + c();
    }

    @NotNull
    public final String b() {
        String str = this.mFunctionName;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mFunctionName");
        return null;
    }

    public final int c() {
        return ((Number) this.mFunctionType.getValue(this, f416314e[0])).intValue();
    }

    @NotNull
    public final String d() {
        String str = this.mRobotId;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRobotId");
        return null;
    }

    public final void f(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mFunctionName = str;
    }

    public final void g(int i3) {
        this.mFunctionType.setValue(this, f416314e[0], Integer.valueOf(i3));
    }

    public final void h(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mRobotId = str;
    }

    @NotNull
    public final String i() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ROBOT_ID", d());
        jSONObject.put("FUNCTION_NAME", b());
        jSONObject.put("FUNCTION_TYPE", c());
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026ype)\n        }.toString()");
        return jSONObject2;
    }

    public a(@NotNull String jsonString) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        this.mFunctionType = Delegates.INSTANCE.notNull();
        e(new JSONObject(jsonString));
    }
}
