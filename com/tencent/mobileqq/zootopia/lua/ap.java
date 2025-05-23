package com.tencent.mobileqq.zootopia.lua;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import com.tencent.zplan.luabridge.ZPlanLuaBridge;
import com.tencent.zplan.luabridge.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ap;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "showNewFriendDialog", "getNewFriendInvitation", "copyToPasteBoard", "Landroid/app/Activity;", "d", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Landroid/app/Activity;)V", "e", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ap extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Activity activity;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zootopia/lua/ap$b", "Lcom/tencent/mobileqq/zootopia/ipc/w;", "Lorg/json/JSONObject;", "value", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.ipc.w {
        b() {
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.w
        public void a(JSONObject value) {
            Intrinsics.checkNotNullParameter(value, "value");
            QLog.i("ZootopiaFriendInviteLugPlugin", 1, "getNewFriendInvitation result=" + value);
            ZPlanLuaBridge zPlanLuaBridge = ZPlanLuaBridge.INSTANCE;
            String jSONObject = value.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "value.toString()");
            a.C10063a.b(zPlanLuaBridge, "N2L_OnNewFriendInvitation", jSONObject, null, 4, null);
        }
    }

    public ap(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
    }

    @LuaEvent("L2N_CopyToPasteBoard")
    public final String copyToPasteBoard(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        String optString = new JSONObject(argument.getParams()).optString(HippyControllerProps.STRING);
        boolean z16 = true;
        try {
            Object systemService = BaseApplication.getContext().getSystemService("clipboard");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
            ClipboardMonitor.setPrimaryClip((ClipboardManager) systemService, ClipData.newPlainText("", optString));
        } catch (Exception e16) {
            QLog.e("ZootopiaFriendInviteLugPlugin", 1, "copyToClipboard, exception=", e16);
            z16 = false;
        }
        if (z16) {
            return argument.ok();
        }
        return argument.fail();
    }

    @LuaEvent("L2N_GetNewFriendInvitation")
    public final String getNewFriendInvitation(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZootopiaFriendInviteLugPlugin", 1, "getNewFriendInvitation");
        ((com.tencent.mobileqq.zootopia.ipc.v) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.v.class)).getNewFriendInvitation(new b());
        return argument.ok();
    }

    @LuaEvent("L2N_ShowNewFriendDialog")
    public final String showNewFriendDialog(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZootopiaFriendInviteLugPlugin", 1, "showNewFriendDialog");
        ((com.tencent.mobileqq.zootopia.ipc.v) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.v.class)).showNewFriendDialog(new c(argument));
        return "";
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zootopia/lua/ap$c", "Lcom/tencent/mobileqq/zootopia/ipc/aj;", "", "result", "", "onResult", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.ipc.aj {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LuaArgument f328507a;

        c(LuaArgument luaArgument) {
            this.f328507a = luaArgument;
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.aj
        public void onResult(boolean result) {
            if (result) {
                this.f328507a.ok();
            } else {
                this.f328507a.fail();
            }
        }
    }
}
