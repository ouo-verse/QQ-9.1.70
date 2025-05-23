package com.tencent.mobileqq.zplan.lua.plugins;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.zootopia.utils.DataConvertUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zplan/lua/plugins/a;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "arg", "", "getQQVersion", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name */
    public static final a f333829d = new a();

    a() {
    }

    @LuaEvent("L2N_GetQQVersion")
    public final String getQQVersion(LuaArgument arg) {
        Intrinsics.checkNotNullParameter(arg, "arg");
        QLog.d("ZPlanAppInfoLuaPlugin", 1, "getQQVersion called.");
        String valueOf = String.valueOf(AppSetting.f99551k);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Version", valueOf);
        DataConvertUtil dataConvertUtil = DataConvertUtil.f329546a;
        arg.callback(dataConvertUtil.a().toJson(jSONObject));
        QLog.i("ZPlanAppInfoLuaPlugin", 1, "getQQVersion callback : " + dataConvertUtil.a().toJson(jSONObject));
        return null;
    }
}
