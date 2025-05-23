package com.tencent.mobileqq.zootopia.lua;

import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/bc;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/mobileqq/zootopia/lua/d;", "loadingCallback", "", "a", "b", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "handleProgressError", "Ljava/util/concurrent/CopyOnWriteArrayList;", "e", "Ljava/util/concurrent/CopyOnWriteArrayList;", "callbackList", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class bc extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name */
    public static final bc f328541d = new bc();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArrayList<d> callbackList = new CopyOnWriteArrayList<>();

    bc() {
    }

    @LuaEvent("L2N_ParadiseLoadingError")
    public final String handleProgressError(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZootopiaSceneLoadingLuaPlugin", 1, hashCode() + ", handleProgressError, params:" + argument.getF440574c());
        JSONObject jSONObject = new JSONObject(argument.getF440574c());
        int optInt = jSONObject.optInt("errorCode", -1);
        String optString = jSONObject.optString("msg", "");
        Iterator<T> it = callbackList.iterator();
        while (it.hasNext()) {
            ((d) it.next()).o(optInt, optString);
        }
        return argument.ok();
    }

    public final void a(d loadingCallback) {
        if (loadingCallback == null) {
            return;
        }
        CopyOnWriteArrayList<d> copyOnWriteArrayList = callbackList;
        if (copyOnWriteArrayList.contains(loadingCallback)) {
            return;
        }
        copyOnWriteArrayList.add(loadingCallback);
    }

    public final void b(d loadingCallback) {
        if (loadingCallback == null) {
            return;
        }
        callbackList.remove(loadingCallback);
    }
}
