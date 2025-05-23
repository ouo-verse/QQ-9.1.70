package com.tencent.mobileqq.zootopia.lua;

import com.tencent.mobileqq.z1.base.openId.ZootopiaOpenIdResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/au;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "requestAuthInfo", "reAuthorization", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class au extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name */
    public static final au f328516d = new au();

    au() {
    }

    @LuaEvent("L2N_NotifyQQTokenInvalid")
    public final String reAuthorization(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZootopiaOpenIdSilentLuaPlugin", 1, "start handle silent reAuthorization");
        ((com.tencent.mobileqq.zootopia.ipc.ac) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.ac.class)).reAuthOpenIdSilent(new a(argument));
        return null;
    }

    @LuaEvent("L2N_RequestAuthInfo")
    public final String requestAuthInfo(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZootopiaOpenIdSilentLuaPlugin", 1, "start handle silent requestAuthInfo");
        ((com.tencent.mobileqq.zootopia.ipc.ac) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.ac.class)).getOpenIdInfoSilent(new a(argument));
        return null;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016R\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/au$a;", "Lcom/tencent/mobileqq/zootopia/ipc/ab;", "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "result", "Lorg/json/JSONObject;", "e", "", "errCode", "", "msg", "d", "", "a", "errMsg", "b", "c", "Lcom/tencent/zplan/luabridge/LuaArgument;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "getArgument", "()Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "<init>", "(Lcom/tencent/zplan/luabridge/LuaArgument;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements com.tencent.mobileqq.zootopia.ipc.ab {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final LuaArgument argument;

        public a(LuaArgument argument) {
            Intrinsics.checkNotNullParameter(argument, "argument");
            this.argument = argument;
        }

        private final JSONObject d(int errCode, String msg2) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("Error", "errCode:" + errCode + ",msg:" + msg2);
            } catch (Throwable th5) {
                QLog.e("ZootopiaOpenIdSilentLuaPlugin", 1, "getFailedLuaResult, error,", th5);
            }
            return jSONObject;
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ab
        public void a(ZootopiaOpenIdResult result) {
            String ok5 = this.argument.ok(e(result));
            if (QLog.isColorLevel()) {
                QLog.d("ZootopiaOpenIdSilentLuaPlugin", 2, "send result, " + ok5);
            } else {
                QLog.i("ZootopiaOpenIdSilentLuaPlugin", 1, "send result");
            }
            this.argument.callback(ok5);
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ab
        public void b(int errCode, String errMsg) {
            String ok5 = this.argument.ok(d(errCode, errMsg == null ? "unknown" : errMsg));
            if (QLog.isColorLevel()) {
                QLog.d("ZootopiaOpenIdSilentLuaPlugin", 1, "send error:" + ok5);
            } else {
                QLog.i("ZootopiaOpenIdSilentLuaPlugin", 1, "send error:" + errCode + ", " + errMsg);
            }
            this.argument.callback(ok5);
        }

        private final JSONObject e(ZootopiaOpenIdResult result) {
            if (result == null) {
                return d(-1, "result is null");
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("OpenId", result.getOpenId());
                jSONObject.put("AccessToken", result.getAccessToken());
                jSONObject.put("PayToken", result.getPayToken());
            } catch (Throwable th5) {
                QLog.e("ZootopiaOpenIdSilentLuaPlugin", 1, "getSuccessLuaResult, error,", th5);
            }
            return jSONObject;
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ab
        public void c() {
        }
    }
}
