package com.tencent.mobileqq.crossend.communication.base;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class e extends LuaBasePlugin {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(LuaArgument luaArgument, JSONObject jSONObject) {
        try {
            if (jSONObject.getInt("code") == 0) {
                luaArgument.ok(jSONObject);
            } else {
                luaArgument.fail("ErrorCode:" + jSONObject.getInt("code"));
            }
        } catch (JSONException e16) {
            QLog.e("QQCrossEndLuaPlugin", 1, e16, new Object[0]);
        }
    }

    @LuaEvent("QQWebApi")
    private void callNative(final LuaArgument luaArgument) {
        JSONObject jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject(luaArgument.getParams());
            String string = jSONObject2.getString("business");
            String string2 = jSONObject2.getString("method");
            if (jSONObject2.has("data")) {
                jSONObject = jSONObject2.getJSONObject("data");
            } else {
                jSONObject = new JSONObject();
            }
            com.tencent.mobileqq.crossend.communication.core.a.d(string, string2, jSONObject, new ab1.a() { // from class: com.tencent.mobileqq.crossend.communication.base.d
                @Override // ab1.a
                public final void f(JSONObject jSONObject3) {
                    e.b(LuaArgument.this, jSONObject3);
                }
            });
        } catch (JSONException e16) {
            QLog.e("QQCrossEndLuaPlugin", 1, e16, new Object[0]);
        }
    }
}
