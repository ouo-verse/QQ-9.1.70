package com.tencent.hydevteam.pluginframework.pluginloader;

import android.content.Context;
import com.tencent.hydevteam.common.annotation.API;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.hydevteam.pluginframework.installedplugin.UseDynamicPluginLoaderInstalledPlugin;
import com.tencent.hydevteam.pluginframework.plugincontainer.DelegateProvider;
import com.tencent.hydevteam.pluginframework.plugincontainer.DelegateProviderHolder;
import com.tencent.hydevteam.pluginframework.pluginloader.exceptions.DynamicPluginLoaderLoadException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

@API
/* loaded from: classes7.dex */
public class DynamicPluginLoader implements PluginLoader {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static PluginLoader f114741a;

    public DynamicPluginLoader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void a(Object obj) throws AssertionError {
        if (obj != null) {
        } else {
            throw new AssertionError();
        }
    }

    @API
    private void initPluginLoaderIfNeeded(InstalledPlugin installedPlugin) throws LoadPluginException {
        if (f114741a == null) {
            UseDynamicPluginLoaderInstalledPlugin useDynamicPluginLoaderInstalledPlugin = (UseDynamicPluginLoaderInstalledPlugin) installedPlugin;
            try {
                DelegateProvider a16 = new DynamicPluginLoaderLoader(useDynamicPluginLoaderInstalledPlugin.dynamicPluginLoaderVersion, useDynamicPluginLoaderInstalledPlugin.dynamicPluginLoaderFile, useDynamicPluginLoaderInstalledPlugin.dynamicPluginLoaderClassname, useDynamicPluginLoaderInstalledPlugin.dynamicPluginLoaderInterfacePackageNames).a();
                f114741a = a16;
                DelegateProviderHolder.setDelegateProvider(a16);
            } catch (DynamicPluginLoaderLoadException e16) {
                throw new LoadPluginException(e16);
            }
        }
    }

    @Override // com.tencent.hydevteam.pluginframework.pluginloader.PluginLoader
    @API
    public ProgressFuture<RunningPlugin> loadPlugin(Context context, InstalledPlugin installedPlugin) throws LoadPluginException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ProgressFuture) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) installedPlugin);
        }
        if (installedPlugin instanceof UseDynamicPluginLoaderInstalledPlugin) {
            try {
                UseDynamicPluginLoaderInstalledPlugin useDynamicPluginLoaderInstalledPlugin = (UseDynamicPluginLoaderInstalledPlugin) installedPlugin;
                a(useDynamicPluginLoaderInstalledPlugin.dynamicPluginLoaderVersion);
                a(useDynamicPluginLoaderInstalledPlugin.dynamicPluginLoaderFile);
                a(useDynamicPluginLoaderInstalledPlugin.pluginPackageName);
                a(useDynamicPluginLoaderInstalledPlugin.pluginVersionForConfigPluginLoader);
                a(useDynamicPluginLoaderInstalledPlugin.pluginVersionForPluginLoaderManage);
                a(useDynamicPluginLoaderInstalledPlugin.pluginFile);
                initPluginLoaderIfNeeded(installedPlugin);
                PluginLoader pluginLoader = f114741a;
                if (pluginLoader != null) {
                    return pluginLoader.loadPlugin(context, installedPlugin);
                }
                throw new LoadPluginException("sActualPluginLoader \u4e3a null");
            } catch (AssertionError e16) {
                throw new LoadPluginException("\u68c0\u67e5\u542f\u52a8\u63d2\u4ef6\u53c2\u6570\u65f6\u53d1\u751f\u9519\u8bef", e16);
            }
        }
        throw new LoadPluginException(installedPlugin + "\u4e0d\u662f\u4e00\u4e2a" + UseDynamicPluginLoaderInstalledPlugin.class);
    }

    @Override // com.tencent.hydevteam.pluginframework.pluginloader.PluginLoader
    @API
    public boolean setPluginDisabled(InstalledPlugin installedPlugin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) installedPlugin)).booleanValue();
        }
        PluginLoader pluginLoader = f114741a;
        if (pluginLoader == null) {
            return false;
        }
        return pluginLoader.setPluginDisabled(installedPlugin);
    }
}
