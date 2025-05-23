package com.tencent.mobileqq.app.message.cleanup.tool;

import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.message.filescan.d;
import com.tencent.mobileqq.app.message.messageclean.y;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qshadow.core.QShadow;
import com.tencent.mobileqq.qshadow.utils.QShadowRepository;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.xaction.log.b;
import cooperation.plugin.IPluginManager;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/app/message/cleanup/tool/PluginCleanUpThoroughCacheTool;", "Lcom/tencent/mobileqq/app/message/messageclean/y;", "", "getClearSize", "", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getWhiteList", "<init>", "()V", "Companion", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class PluginCleanUpThoroughCacheTool implements y {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final String CONFIG_KEY = "plugin_clean_switch";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/app/message/cleanup/tool/PluginCleanUpThoroughCacheTool$a;", "", "", "CONFIG_KEY", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.app.message.cleanup.tool.PluginCleanUpThoroughCacheTool$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54146);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PluginCleanUpThoroughCacheTool() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.y
    public void clearCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        AppRuntime runtime = BaseApplicationImpl.sApplication.getRuntime();
        if (!(runtime instanceof QQAppInterface)) {
            return;
        }
        Manager manager = runtime.getManager(QQManagerFactory.MGR_PLUGIN);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type cooperation.plugin.IPluginManager");
        ((IPluginManager) manager).I5();
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.y
    public long getClearSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        AppRuntime runtime = BaseApplicationImpl.sApplication.getRuntime();
        if (!(runtime instanceof QQAppInterface)) {
            return 0L;
        }
        Manager manager = runtime.getManager(QQManagerFactory.MGR_PLUGIN);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type cooperation.plugin.IPluginManager");
        return ((IPluginManager) manager).n5();
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.y
    @NotNull
    public ArrayList<String> getWhiteList() {
        ArrayList<String> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        d dVar = d.f195978a;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(dVar.a() + "/app_lib/qqpim_plugin", dVar.a() + "/files/ShadowPlugin_Odlite", dVar.a() + "/odlite", dVar.a() + "/ShadowPlugin_Odlite", dVar.a() + "/app_debug_plugin_info", dVar.a() + "/app_plugin_info", dVar.a() + "/files/PluginManager", dVar.a() + "/files/plugins", dVar.a() + "/files/plugins_64", dVar.a() + "/files/ShadowPlugin_AV", dVar.a() + "/files/ShadowPlugin_Base", dVar.a() + "/files/ShadowPlugin_Channel", dVar.a() + "/files/ShadowPlugin_Core", dVar.a() + "/files/ShadowPlugin_RoomBiz", dVar.a() + "/files/ShadowPlugin_RoomCore", dVar.a() + "/files/ShadowPlugin_RoomImport", dVar.a() + "/pluginAsset", dVar.a() + "/PluginInfo", dVar.a() + "/plugins", dVar.a() + "/ShadowPlugin_AV", dVar.a() + "/ShadowPlugin_Base", dVar.a() + "/ShadowPlugin_Channel", dVar.a() + "/ShadowPlugin_Controller", dVar.a() + "/ShadowPlugin_Core", dVar.a() + "/ShadowPlugin_RoomBiz", dVar.a() + "/ShadowPlugin_RoomCore", dVar.a() + "/ShadowPlugin_RoomImport", dVar.a() + "/ShadowPlugin_RoomOver", dVar.a() + "/ShadowPlugin_RTMP", dVar.a() + "/ShadowPluginManager", dVar.d() + "/files/ShadowPlugin_Base", dVar.d() + "/Tencent/MobileQQ/shadow", dVar.a() + "/app_lib/qqindividuality_plugin", dVar.a() + "/files/buscard", dVar.a() + "/app_lib/BuscardPlugin", dVar.a() + "/files/ShadowPlugin_huaweistep-plugin", dVar.a() + "/ShadowPlugin_huaweistep-plugin", dVar.a() + "/files/feature_apk_so");
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(CONFIG_KEY, true)) {
            b.a("plugin_tag", 1, "isSwitchOn is false");
            for (String str : QShadowRepository.getAllInstallPlugin(BaseApplication.context).keySet()) {
                if (QShadow.getInstance().isPluginRunning(str)) {
                    d dVar2 = d.f195978a;
                    arrayListOf.add(dVar2.a() + "/files/qshadow-plugins/" + str);
                    arrayListOf.add(dVar2.a() + "/files/qshadow-plugins/" + str + "-temp");
                    arrayListOf.add(dVar2.a() + "/files/ShadowPluginManager/UnpackedPlugin/" + str);
                    arrayListOf.add(dVar2.a() + "/files/ShadowPluginManager/UnpackedPlugin/QShadow" + str);
                    Log.i("plugin_tag", "shadow plugin running. do not allow clean");
                }
            }
        }
        return arrayListOf;
    }
}
