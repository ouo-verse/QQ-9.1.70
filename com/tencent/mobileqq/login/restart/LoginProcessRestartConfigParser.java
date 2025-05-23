package com.tencent.mobileqq.login.restart;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/login/restart/LoginProcessRestartConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/login/restart/b;", "b", "", "content", "c", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LoginProcessRestartConfigParser extends BaseConfigParser<b> {
    static IPatchRedirector $redirector_;

    public LoginProcessRestartConfigParser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b defaultConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new b(null, null, 0, 0, 0, 0, false, false, 0, 0, 0, 0, 4095, null);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b parse(@NotNull byte[] content) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) content);
        }
        Intrinsics.checkNotNullParameter(content, "content");
        b bVar = new b(null, null, 0, 0, 0, 0, false, false, 0, 0, 0, 0, 4095, null);
        try {
            JSONObject jSONObject = new JSONObject(new String(content, Charsets.UTF_8));
            JSONArray optJSONArray = jSONObject.optJSONArray("scenes");
            if (optJSONArray != null) {
                bVar.g().clear();
                int length = optJSONArray.length();
                int i3 = 0;
                while (i3 < length) {
                    List<String> g16 = bVar.g();
                    int i16 = length;
                    String string = optJSONArray.getString(i3);
                    Intrinsics.checkNotNullExpressionValue(string, "sceneArray.getString(i)");
                    g16.add(string);
                    i3++;
                    length = i16;
                    optJSONArray = optJSONArray;
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("deviceLevels");
            if (optJSONArray2 != null) {
                bVar.b().clear();
                int length2 = optJSONArray2.length();
                int i17 = 0;
                while (i17 < length2) {
                    bVar.b().add(Integer.valueOf(optJSONArray2.optInt(i17)));
                    i17++;
                    optJSONArray2 = optJSONArray2;
                }
            }
            if (jSONObject.has("androidVersion")) {
                bVar.m(jSONObject.getInt("androidVersion"));
            }
            if (jSONObject.has("killProcessDoubleCheck")) {
                bVar.q(jSONObject.optBoolean("killProcessDoubleCheck", true));
            }
            if (jSONObject.has("waitingProcessPreload")) {
                bVar.v(jSONObject.optBoolean("waitingProcessPreload"));
            }
            if (jSONObject.has("slowLaunchThreshold")) {
                bVar.s(jSONObject.optInt("slowLaunchThreshold"));
            }
            if (jSONObject.has("slowColdStartThreshold")) {
                bVar.r(jSONObject.optInt("slowColdStartThreshold"));
            }
            if (jSONObject.has("slowWarmStartThreshold")) {
                bVar.t(jSONObject.optInt("slowWarmStartThreshold"));
            }
            if (jSONObject.has("downgradeTimeThreshold")) {
                bVar.o(jSONObject.optInt("downgradeTimeThreshold"));
            }
            if (jSONObject.has("downgradeSlowNum")) {
                bVar.n(jSONObject.optInt("downgradeSlowNum"));
            }
            if (jSONObject.has("totalPssThreshold")) {
                bVar.u(jSONObject.optInt("totalPssThreshold"));
            }
            if (jSONObject.has("javaUsedRatioThreshold")) {
                bVar.p(jSONObject.optInt("javaUsedRatioThreshold"));
            }
        } catch (Exception e16) {
            QLog.e("LoginProcessRestartConfig", 1, "parse error:", e16);
        }
        return bVar;
    }
}
