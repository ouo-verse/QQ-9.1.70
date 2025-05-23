package com.tencent.zplan.luabridge.plugins;

import android.text.TextUtils;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import com.tencent.zplan.utils.ZLog;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ2\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\bH\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/zplan/luabridge/plugins/e;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lorg/json/JSONObject;", "jsonObject", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "a", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "handleDTDataReport", "<init>", "()V", "d", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class e extends LuaBasePlugin {
    private final HashMap<String, String> a(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        Iterator keys = jsonObject.keys();
        HashMap<String, String> hashMap = new HashMap<>();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            String value = jsonObject.optString(key);
            Intrinsics.checkNotNullExpressionValue(key, "key");
            Intrinsics.checkNotNullExpressionValue(value, "value");
            hashMap.put(key, value);
        }
        return hashMap;
    }

    @LuaEvent("L2N_LightDTDataReport")
    @Nullable
    public final String handleDTDataReport(@NotNull LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        if (TextUtils.isEmpty(argument.getParams())) {
            ZLog.f386189b.d("DengTaReportPlugin", 1, "L2N_DTDataReport params empty");
            return argument.fail();
        }
        JSONObject jSONObject = new JSONObject(argument.getParams());
        String pageCode = jSONObject.optString("pageCode", "");
        String modeCode = jSONObject.optString("modeCode", "");
        String eventCode = jSONObject.optString("eventCode", "");
        HashMap<String, String> a16 = a(jSONObject.optJSONObject("params"));
        lx4.b bVar = (lx4.b) mx4.a.f417748a.a(lx4.b.class);
        if (bVar != null) {
            Intrinsics.checkNotNullExpressionValue(pageCode, "pageCode");
            Intrinsics.checkNotNullExpressionValue(modeCode, "modeCode");
            Intrinsics.checkNotNullExpressionValue(eventCode, "eventCode");
            bVar.b(pageCode, modeCode, eventCode, a16);
        }
        return argument.ok();
    }
}
