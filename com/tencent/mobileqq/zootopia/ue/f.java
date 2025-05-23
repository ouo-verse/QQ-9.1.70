package com.tencent.mobileqq.zootopia.ue;

import com.tencent.mobileqq.zootopia.lua.PortalTabBarLuaPlugin;
import com.tencent.mobileqq.zootopia.lua.ZootopiaAvatarImageLuaPlugin;
import com.tencent.mobileqq.zootopia.lua.ZootopiaCleanSceneDataPlugin;
import com.tencent.mobileqq.zootopia.lua.ZootopiaReturnLuaPlugin;
import com.tencent.mobileqq.zplan.lua.plugins.j;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ue/f;", "Lcom/tencent/mobileqq/zootopia/ue/a;", "", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "e", "", "destroy", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class f extends a {
    @Override // com.tencent.mobileqq.zootopia.ue.a
    protected List<LuaBasePlugin> e() {
        List<LuaBasePlugin> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new LuaBasePlugin[]{PortalTabBarLuaPlugin.INSTANCE.a(), ZootopiaAvatarImageLuaPlugin.INSTANCE.a(), ZootopiaReturnLuaPlugin.INSTANCE.a(), ZootopiaCleanSceneDataPlugin.INSTANCE.a(), com.tencent.mobileqq.zplan.lua.plugins.h.f333848d, j.f333850d});
        return listOf;
    }

    @Override // com.tencent.mobileqq.zootopia.ue.c
    public void destroy() {
    }
}
