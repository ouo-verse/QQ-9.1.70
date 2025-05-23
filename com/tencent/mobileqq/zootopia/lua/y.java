package com.tencent.mobileqq.zootopia.lua;

import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.common.utils.GsonUtil;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/y;", "Lcom/tencent/mobileqq/z1/lua/b;", "Lcom/tencent/mobileqq/zootopia/lua/c;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "handleSameStyleMixProcess", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class y extends com.tencent.mobileqq.z1.lua.b<c> {

    /* renamed from: e, reason: collision with root package name */
    public static final y f328583e = new y();

    y() {
    }

    @LuaEvent("L2N_SameStyleMixProgress")
    public final String handleSameStyleMixProcess(LuaArgument argument) {
        String f440574c = argument != null ? argument.getF440574c() : null;
        boolean z16 = true;
        QLog.i("ZPlanSameStyleProgressLuaPlugin_", 1, "handleSameStyleMixProcess arg:" + f440574c);
        if (f440574c != null && f440574c.length() != 0) {
            z16 = false;
        }
        if (z16) {
            return "";
        }
        ZPlanSameStyleProgress progress = (ZPlanSameStyleProgress) GsonUtil.f385283b.a().fromJson(f440574c, ZPlanSameStyleProgress.class);
        for (c cVar : a()) {
            Intrinsics.checkNotNullExpressionValue(progress, "progress");
            cVar.a(progress);
        }
        return "";
    }
}
