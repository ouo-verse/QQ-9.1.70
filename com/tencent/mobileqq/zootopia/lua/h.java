package com.tencent.mobileqq.zootopia.lua;

import android.app.Activity;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\"\u0010\u000b\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/h;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "openRechargePanel", "Lmqq/util/WeakReference;", "Landroid/app/Activity;", "kotlin.jvm.PlatformType", "d", "Lmqq/util/WeakReference;", "activityRef", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Landroid/app/Activity;)V", "e", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class h extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<Activity> activityRef;

    public h(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activityRef = new WeakReference<>(activity);
    }

    @LuaEvent("L2N_OpenRechargePanelForMain")
    public final String openRechargePanel(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("NativePayViewLuaPluginForMain", 1, "openRechargePanel, params:" + argument.getF440574c());
        return g.INSTANCE.a(argument, this.activityRef);
    }
}
