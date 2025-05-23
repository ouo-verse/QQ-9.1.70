package ki3;

import com.tencent.mobileqq.zootopia.lua.ZPlanDownloadUrlLuaPlugin;
import com.tencent.mobileqq.zootopia.lua.ZPlanFileLuaPlugin;
import com.tencent.mobileqq.zootopia.lua.ZPlanGetUeEnvLuaPlugin;
import com.tencent.mobileqq.zootopia.lua.ZPlanHttpToolsPlugin;
import com.tencent.mobileqq.zootopia.lua.ZPlanNotifyEngineVersionLuaPlugin;
import com.tencent.mobileqq.zootopia.lua.ZPlanNotifyRoleCompletedLuaPlugin;
import com.tencent.mobileqq.zootopia.lua.ZPlanPauseDownloadLuaPlugin;
import com.tencent.mobileqq.zootopia.lua.ZPlanSetDownloadMaxLimitLuaPlugin;
import com.tencent.mobileqq.zootopia.lua.ZPlanThirdAuthLuaPlugin;
import com.tencent.mobileqq.zootopia.lua.ZootopiaDressLuaPlugin;
import com.tencent.mobileqq.zootopia.lua.ZootopiaEnterAvatarScenePlugin;
import com.tencent.mobileqq.zootopia.lua.ZootopiaOidbPushPlugin;
import com.tencent.mobileqq.zootopia.lua.ZootopiaOpenSchemeLuaPlugin;
import com.tencent.mobileqq.zootopia.lua.ZootopiaSsoLuaPlugin;
import com.tencent.mobileqq.zootopia.lua.ZplanPreLoadPeakProcessLuaPlugin;
import com.tencent.mobileqq.zootopia.lua.aa;
import com.tencent.mobileqq.zootopia.lua.al;
import com.tencent.mobileqq.zootopia.lua.au;
import com.tencent.mobileqq.zootopia.lua.y;
import com.tencent.mobileqq.zplan.lua.plugins.ZPlanCommonSharePlugin;
import com.tencent.mobileqq.zplan.lua.plugins.ZPlanDialogLuaPlugin;
import com.tencent.mobileqq.zplan.lua.plugins.ZPlanReportMsgPlugin;
import com.tencent.mobileqq.zplan.lua.plugins.ZPlanSmallHomeLuaPlugin;
import com.tencent.mobileqq.zplan.lua.plugins.ZPlanStorageLuaPlugin;
import com.tencent.mobileqq.zplan.lua.plugins.ZplanQQMCPlugin;
import com.tencent.mobileqq.zplan.lua.plugins.d;
import com.tencent.mobileqq.zplan.lua.plugins.e;
import com.tencent.mobileqq.zplan.lua.plugins.g;
import com.tencent.mobileqq.zplan.lua.plugins.i;
import com.tencent.mobileqq.zplan.web.impl.ZPlanCustomWebViewLuaPlugin;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import zx4.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lki3/a;", "Lzx4/h;", "", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "a", "Ljava/util/List;", "mPlugins", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<LuaBasePlugin> mPlugins;

    public a() {
        List<LuaBasePlugin> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new LuaBasePlugin[]{au.f328516d, e.f333842d, ZootopiaDressLuaPlugin.INSTANCE.a(), ZootopiaEnterAvatarScenePlugin.INSTANCE.a(), com.tencent.mobileqq.zplan.lua.plugins.a.f333829d, d.f333840d, ZootopiaSsoLuaPlugin.INSTANCE.a(), ZootopiaOidbPushPlugin.INSTANCE.a(), g.f333847d, ZPlanStorageLuaPlugin.f333825d, ZootopiaOpenSchemeLuaPlugin.INSTANCE.a(), al.f328496d, ZPlanPauseDownloadLuaPlugin.INSTANCE.a(), ZPlanDownloadUrlLuaPlugin.INSTANCE.a(), ZPlanReportMsgPlugin.INSTANCE.a(), ZPlanThirdAuthLuaPlugin.INSTANCE.a(), ZPlanCommonSharePlugin.INSTANCE.a(), ZPlanCustomWebViewLuaPlugin.INSTANCE.a(), ZplanPreLoadPeakProcessLuaPlugin.INSTANCE.a(), y.f328583e, aa.f328467d, ZPlanSetDownloadMaxLimitLuaPlugin.INSTANCE.a(), ZPlanNotifyRoleCompletedLuaPlugin.INSTANCE.a(), ZPlanGetUeEnvLuaPlugin.INSTANCE.a(), ZPlanSmallHomeLuaPlugin.INSTANCE.a(), ZPlanDialogLuaPlugin.INSTANCE.b(), ZPlanNotifyEngineVersionLuaPlugin.INSTANCE.a(), ZPlanFileLuaPlugin.INSTANCE.a(), i.f333849d, ZplanQQMCPlugin.INSTANCE.a(), ZPlanHttpToolsPlugin.INSTANCE.a()});
        this.mPlugins = listOf;
    }

    @Override // zx4.h
    public List<LuaBasePlugin> a() {
        return this.mPlugins;
    }
}
