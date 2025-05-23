package com.tencent.mobileqq.zootopia.lua;

import android.app.Activity;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/bb;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "openQzonePicList", "getValidUrlByInvalidUrl", "Landroid/app/Activity;", "d", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "e", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class bb extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Activity activity;

    public bb(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
    }

    @LuaEvent("L2N_GetValidUrlByInvalidUrl")
    public final String getValidUrlByInvalidUrl(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZootopiaQzoneLuaPlugin", 4, "getValidUrlByInvalidUrl");
        ((com.tencent.mobileqq.zootopia.ipc.ag) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.ag.class)).getValidUrlByInvalidUrl(new JSONObject(argument.getParams()));
        return argument.ok();
    }

    @LuaEvent("L2N_OpenQzonePicList")
    public final String openQzonePicList(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZootopiaQzoneLuaPlugin", 4, "openQzonePicList");
        ((com.tencent.mobileqq.zootopia.ipc.ag) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.ag.class)).openQzonePicList(new JSONObject(argument.getParams()));
        return argument.ok();
    }
}
