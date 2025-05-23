package com.tencent.mobileqq.zplan.lua.plugins;

import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import com.tencent.zplan.luabridge.plugins.data.CommonLoadingData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/lua/plugins/d;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Ltx4/a;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "arg", "", "notifyHotPatchVersionInfo", "notifyHotPatchResult", "notifyNotifyLoadingError", "Lcom/tencent/zplan/luabridge/plugins/data/CommonLoadingData;", "loadingData", "", "Q0", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class d extends LuaBasePlugin implements tx4.a {

    /* renamed from: d, reason: collision with root package name */
    public static final d f333840d;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/zplan/lua/plugins/d$a", "Lai3/b;", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements ai3.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LuaArgument f333841a;

        a(LuaArgument luaArgument) {
            this.f333841a = luaArgument;
        }
    }

    static {
        d dVar = new d();
        f333840d = dVar;
        ZPlanServiceHelper.I.D0(dVar);
    }

    d() {
    }

    @Override // tx4.a
    public void Q0(CommonLoadingData loadingData) {
        Intrinsics.checkNotNullParameter(loadingData, "loadingData");
        QLog.d("ZPlanHotPatchLuaPlugin", 1, "loading progress event with loadingData: " + loadingData);
        ((yh3.a) k74.i.INSTANCE.a(yh3.a.class)).dispatchProgressEvent(loadingData);
    }

    @LuaEvent("L2N_NotifyHotPatchResult")
    public final String notifyHotPatchResult(LuaArgument arg) {
        Intrinsics.checkNotNullParameter(arg, "arg");
        ((yh3.a) k74.i.INSTANCE.a(yh3.a.class)).dispatchHotPatchResult(arg.getF440574c());
        return null;
    }

    @LuaEvent("L2N_NotifyHotPatchVersionInfo")
    public final String notifyHotPatchVersionInfo(LuaArgument arg) {
        Intrinsics.checkNotNullParameter(arg, "arg");
        QLog.i("ZPlanHotPatchLuaPlugin", 1, "notifyHotPatchVersionInfo arg.params:" + arg.getF440574c());
        ((yh3.a) k74.i.INSTANCE.a(yh3.a.class)).dispatchStatusChangeEvent(arg.getF440574c());
        return null;
    }

    @LuaEvent("L2N_NotifyLoadingError")
    public final String notifyNotifyLoadingError(LuaArgument arg) {
        Intrinsics.checkNotNullParameter(arg, "arg");
        QLog.i("ZPlanHotPatchLuaPlugin", 1, "notifyNotifyLoadingError param:" + arg.getF440574c());
        ((yh3.a) k74.i.INSTANCE.a(yh3.a.class)).dispatchLoadingError(arg.getF440574c(), new a(arg));
        return null;
    }
}
