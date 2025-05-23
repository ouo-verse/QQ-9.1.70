package com.tencent.mobileqq.zplan.lua.plugins;

import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import java.net.URLDecoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zplan/lua/plugins/i;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "arg", "", "showQQToast", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class i extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name */
    public static final i f333849d = new i();

    i() {
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0064  */
    @LuaEvent("L2N_ShowToast")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String showQQToast(LuaArgument arg) {
        String optString;
        int i3;
        MobileQQ mobileQQ;
        Intrinsics.checkNotNullParameter(arg, "arg");
        JSONObject jSONObject = new JSONObject(arg.getParams());
        if (jSONObject.optBoolean("IsEncode", false)) {
            optString = URLDecoder.decode(jSONObject.optString("Message"), "UTF-8");
        } else {
            optString = jSONObject.optString("Message");
        }
        int optInt = jSONObject.optInt("Style", 0);
        if (optInt != 0) {
            i3 = 2;
            if (optInt != 1) {
                if (optInt == 2) {
                    i3 = 1;
                }
            }
            QLog.d("ZootipiaToastLuaPlugin", 1, "show Toast " + jSONObject);
            mobileQQ = MobileQQ.sMobileQQ;
            if ((mobileQQ == null ? QQToast.makeText(mobileQQ, i3, optString, 0).show() : null) != null) {
                return arg.fail("context is null");
            }
            return arg.ok();
        }
        i3 = 0;
        QLog.d("ZootipiaToastLuaPlugin", 1, "show Toast " + jSONObject);
        mobileQQ = MobileQQ.sMobileQQ;
        if ((mobileQQ == null ? QQToast.makeText(mobileQQ, i3, optString, 0).show() : null) != null) {
        }
    }
}
