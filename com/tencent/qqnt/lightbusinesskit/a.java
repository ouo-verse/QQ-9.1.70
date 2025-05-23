package com.tencent.qqnt.lightbusinesskit;

import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import com.tencent.qqnt.kernel.nativeinterface.UIConfig;
import com.tencent.qqnt.msg.f;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0014\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0007J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0007J\u0006\u0010\f\u001a\u00020\u0002R\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/lightbusinesskit/a;", "", "", "defaultVal", "c", "jsonString", "a", "Lorg/json/JSONObject;", "jsonObject", "", "b", "f", "e", "Ljava/lang/String;", "sForceShowOnMsgListIdsStr", "<init>", "()V", "qq-light-business-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f359319a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String sForceShowOnMsgListIdsStr;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29674);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f359319a = new a();
            sForceShowOnMsgListIdsStr = "[\"1_1\",\"1_2\",\"2_1\",\"3_1\",\"3_2\",\"3_3\",\"4_1\",\"4_2\",\"4_3\",\"5_1\",\"5_2\",\"11_1\",\"11_2\",\"11_3\",\"12_1\",\"12_2\",\"12_3\",\"13_1\",\"13_2\"]";
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @NotNull
    public static final String a(@NotNull String jsonString) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        try {
            JSONObject jSONObject = new JSONObject(jsonString);
            JSONObject jSONObject2 = new JSONObject();
            f359319a.b(jSONObject2);
            jSONObject.put("feature_param", jSONObject2);
            String jSONObject3 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "jsonObject.toString()");
            QLog.e("LiteActionSwitch", 1, "addFeatureParam success " + jSONObject3);
            return jSONObject3;
        } catch (JSONException e16) {
            QLog.e("LiteActionSwitch", 1, "addFeatureParam fail " + e16 + TokenParser.SP + jsonString);
            return jsonString;
        }
    }

    private final void b(JSONObject jsonObject) {
        boolean z16 = !((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getDisableInteractiveSwitchLocal();
        jsonObject.put("enable_mutual_mark", z16);
        jsonObject.put("enable_new_mark", z16);
    }

    @JvmStatic
    @NotNull
    public static final String c(@Nullable String defaultVal) {
        if (defaultVal == null) {
            defaultVal = "{\"enable\":true}";
        }
        return a(defaultVal);
    }

    public static /* synthetic */ String d(String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        return c(str);
    }

    @JvmStatic
    public static final void f() {
        IQQNTWrapperSession k3;
        boolean z16 = true;
        String d16 = d(null, 1, null);
        QLog.d("LiteActionSwitch", 1, "[updateLIAConfig] is call. config=" + d16);
        if (d16.length() <= 0) {
            z16 = false;
        }
        if (z16 && (k3 = f.k()) != null) {
            k3.onUIConfigUpdate(UIConfig.KLITEACTIONCFG, d16);
        }
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return sForceShowOnMsgListIdsStr;
    }
}
