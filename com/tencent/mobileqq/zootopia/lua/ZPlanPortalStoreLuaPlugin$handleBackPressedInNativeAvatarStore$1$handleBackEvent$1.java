package com.tencent.mobileqq.zootopia.lua;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.zootopia.lua.ZPlanPortalStoreLuaPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.luabridge.LuaArgument;
import k74.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
final class ZPlanPortalStoreLuaPlugin$handleBackPressedInNativeAvatarStore$1$handleBackEvent$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ LuaArgument $argument;
    final /* synthetic */ JSONObject $param;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanPortalStoreLuaPlugin$handleBackPressedInNativeAvatarStore$1$handleBackEvent$1(JSONObject jSONObject, LuaArgument luaArgument) {
        super(0);
        this.$param = jSONObject;
        this.$argument = luaArgument;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
        i.Companion companion = k74.i.INSTANCE;
        ((cj3.a) companion.a(cj3.a.class)).avatarCharacterChanged();
        ((eh3.a) companion.a(eh3.a.class)).refreshDressInfo("mod_save");
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$param.put("shouldExit", true);
        this.$argument.callback(this.$param.toString());
        JSONObject jSONObject = this.$param;
        ZPlanPortalStoreLuaPlugin.Companion companion = ZPlanPortalStoreLuaPlugin.INSTANCE;
        QLog.i("ZPlanPortalStoreLuaPlugin", 1, "handleBackPressedInNativeAvatarStore end, callback=" + jSONObject + ", isSaveDressChanged=" + companion.b());
        if (companion.b()) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.zootopia.lua.v
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanPortalStoreLuaPlugin$handleBackPressedInNativeAvatarStore$1$handleBackEvent$1.c();
                }
            }, 3000L);
            companion.f(false);
        }
    }
}
