package com.tencent.mobileqq.zootopia.lua;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.zootopia.service.api.IZootopiaShareArkService;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaEvent;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ZootopiaEnterAvatarScenePlugin;", "Lcom/tencent/mobileqq/z1/lua/b;", "Lcom/tencent/mobileqq/zootopia/lua/i;", "listener", "", "g", tl.h.F, "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "", "handleEnterAvatarResidence", "handleEnterAvatarScene", "<init>", "()V", "e", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaEnterAvatarScenePlugin extends com.tencent.mobileqq.z1.lua.b<i> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    private static final Lazy<ZootopiaEnterAvatarScenePlugin> f328424f;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zootopia/lua/ZootopiaEnterAvatarScenePlugin$a;", "", "Lcom/tencent/mobileqq/zootopia/lua/ZootopiaEnterAvatarScenePlugin;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/zootopia/lua/ZootopiaEnterAvatarScenePlugin;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.lua.ZootopiaEnterAvatarScenePlugin$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZootopiaEnterAvatarScenePlugin a() {
            return (ZootopiaEnterAvatarScenePlugin) ZootopiaEnterAvatarScenePlugin.f328424f.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<ZootopiaEnterAvatarScenePlugin> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaEnterAvatarScenePlugin>() { // from class: com.tencent.mobileqq.zootopia.lua.ZootopiaEnterAvatarScenePlugin$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZootopiaEnterAvatarScenePlugin invoke() {
                return new ZootopiaEnterAvatarScenePlugin();
            }
        });
        f328424f = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(LuaArgument argument, int i3, int i16) {
        Intrinsics.checkNotNullParameter(argument, "$argument");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("retcode", i3);
        jSONObject.put("servercode", i16);
        argument.callback(argument.ok(jSONObject));
    }

    public final void g(i listener) {
        ((com.tencent.mobileqq.zootopia.ipc.r) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.r.class)).registerEnterAvatarSceneListener(listener);
    }

    public final void h(i listener) {
        ((com.tencent.mobileqq.zootopia.ipc.r) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.r.class)).unRegisterEnterAvatarSceneListener(listener);
    }

    @LuaEvent("L2N_EnterAvatarResidence")
    public final String handleEnterAvatarResidence(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        ((com.tencent.mobileqq.zootopia.ipc.r) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.r.class)).enterAvatarResidence();
        return argument.ok();
    }

    @LuaEvent("L2N_EnterAvatarScene")
    public final String handleEnterAvatarScene(final LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        JSONObject jSONObject = new JSONObject(argument.getF440574c());
        int optInt = jSONObject.optInt(IZootopiaShareArkService.ARK_MAP_ID);
        boolean optBoolean = jSONObject.optBoolean(FavEmoConstant.ROAMING_TYPE_PANEL);
        ((com.tencent.mobileqq.zootopia.ipc.r) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.r.class)).enterAvatarScene(optInt, jSONObject.optString("extras"), Boolean.valueOf(optBoolean), new com.tencent.mobileqq.zootopia.ipc.q() { // from class: com.tencent.mobileqq.zootopia.lua.an
            @Override // com.tencent.mobileqq.zootopia.ipc.q
            public final void a(int i3, int i16) {
                ZootopiaEnterAvatarScenePlugin.f(LuaArgument.this, i3, i16);
            }
        });
        return "";
    }
}
