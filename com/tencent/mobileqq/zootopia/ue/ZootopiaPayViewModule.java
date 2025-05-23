package com.tencent.mobileqq.zootopia.ue;

import com.tencent.mobileqq.zootopia.lua.ar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0018B\u0011\u0012\b\b\u0003\u0010\u0011\u001a\u00020\f\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0015\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ue/ZootopiaPayViewModule;", "Lcom/tencent/mobileqq/zootopia/ue/a;", "", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "e", "", "resume", "pause", "destroy", "", "success", "engineInitFinish", "", "f", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "pluginScene", tl.h.F, "Lkotlin/Lazy;", "()Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "payViewLuaPlugin", "<init>", "(Ljava/lang/String;)V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaPayViewModule extends a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final String pluginScene;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy payViewLuaPlugin;

    public ZootopiaPayViewModule(@PayPluginScene String pluginScene) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(pluginScene, "pluginScene");
        this.pluginScene = pluginScene;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LuaBasePlugin>() { // from class: com.tencent.mobileqq.zootopia.ue.ZootopiaPayViewModule$payViewLuaPlugin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LuaBasePlugin invoke() {
                if (Intrinsics.areEqual(ZootopiaPayViewModule.this.getPluginScene(), "PORTAL")) {
                    return new com.tencent.mobileqq.zootopia.lua.h(ZootopiaPayViewModule.this.c());
                }
                return new com.tencent.mobileqq.zootopia.lua.g(ZootopiaPayViewModule.this.c());
            }
        });
        this.payViewLuaPlugin = lazy;
    }

    private final LuaBasePlugin h() {
        return (LuaBasePlugin) this.payViewLuaPlugin.getValue();
    }

    @Override // com.tencent.mobileqq.zootopia.ue.a
    protected List<LuaBasePlugin> e() {
        List<LuaBasePlugin> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(h());
        return listOf;
    }

    @Override // com.tencent.mobileqq.zootopia.ue.a, com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineInitFinish(boolean success) {
        String str = this.pluginScene;
        if (Intrinsics.areEqual(str, "PORTAL") ? true : Intrinsics.areEqual(str, "SUB_AVATAR")) {
            boolean c16 = xk3.b.f448110a.c(c());
            QLog.i("ZootopiaPayViewModule_", 1, "engineInitFinish-" + success + ", isTopEngineAc" + c16);
            if (c16) {
                ar.f328509a.b(h());
                return;
            }
            return;
        }
        ar.f328509a.b(h());
    }

    /* renamed from: i, reason: from getter */
    public final String getPluginScene() {
        return this.pluginScene;
    }

    @Override // com.tencent.mobileqq.zootopia.ue.a, com.tencent.mobileqq.zootopia.ue.c
    public void pause() {
        ar.f328509a.c(h());
    }

    @Override // com.tencent.mobileqq.zootopia.ue.a, com.tencent.mobileqq.zootopia.ue.c
    public void resume() {
        ar.f328509a.b(h());
    }

    @Override // com.tencent.mobileqq.zootopia.ue.c
    public void destroy() {
    }
}
