package com.tencent.hydevteam.pluginframework.pluginloader;

import com.tencent.hydevteam.common.annotation.API;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.hydevteam.pluginframework.installedplugin.UseDynamicPluginLoaderInstalledPlugin;
import com.tencent.hydevteam.pluginframework.pluginloader.exceptions.PluginContainerLoadException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Field;

@API
/* loaded from: classes7.dex */
public class DynamicPluginContainerLoader {
    static IPatchRedirector $redirector_;

    public DynamicPluginContainerLoader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void a(Object obj) throws AssertionError {
        if (obj == null) {
            throw new AssertionError();
        }
    }

    @API
    public void load(InstalledPlugin installedPlugin) throws PluginContainerLoadException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) installedPlugin);
            return;
        }
        if (installedPlugin instanceof UseDynamicPluginLoaderInstalledPlugin) {
            try {
                a(((UseDynamicPluginLoaderInstalledPlugin) installedPlugin).dynamicPluginLoaderVersion);
                a(((UseDynamicPluginLoaderInstalledPlugin) installedPlugin).dynamicPluginContainerFile);
                UseDynamicPluginLoaderInstalledPlugin useDynamicPluginLoaderInstalledPlugin = (UseDynamicPluginLoaderInstalledPlugin) installedPlugin;
                ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                try {
                    try {
                        contextClassLoader.loadClass("com.tencent.hydevteam.pluginframework.plugincontainer.version." + useDynamicPluginLoaderInstalledPlugin.dynamicPluginContainerVersion);
                    } catch (ClassNotFoundException unused) {
                    }
                } catch (ClassNotFoundException unused2) {
                    try {
                        a(contextClassLoader, contextClassLoader.loadClass("com.tencent.hydevteam.pluginframework.plugincontainer.DelegateProviderHolder").getClassLoader().getParent());
                        File file = useDynamicPluginLoaderInstalledPlugin.dynamicPluginContainerFile;
                        String str = useDynamicPluginLoaderInstalledPlugin.dynamicPluginLoaderVersion;
                        File file2 = new File(file.getParentFile(), "plugin_container_odex_" + str);
                        file2.mkdirs();
                        try {
                            a(contextClassLoader, new DexClassLoader(file.getAbsolutePath(), file2.getAbsolutePath(), null, contextClassLoader.getParent()));
                        } catch (Exception e16) {
                            throw new PluginContainerLoadException(e16);
                        }
                    } catch (Exception e17) {
                        throw new PluginContainerLoadException(e17);
                    }
                }
            } catch (AssertionError e18) {
                throw new PluginContainerLoadException("\u68c0\u67e5\u542f\u52a8\u63d2\u4ef6\u53c2\u6570\u65f6\u53d1\u751f\u9519\u8bef", e18);
            }
        } else {
            throw new PluginContainerLoadException(installedPlugin + "\u4e0d\u662f\u4e00\u4e2a" + UseDynamicPluginLoaderInstalledPlugin.class);
        }
    }

    private static void a(ClassLoader classLoader, ClassLoader classLoader2) throws Exception {
        Field a16 = a();
        if (a16 != null) {
            a16.setAccessible(true);
            a16.set(classLoader, classLoader2);
            return;
        }
        throw new Exception("\u5728ClassLoader.class\u4e2d\u6ca1\u627e\u5230\u7c7b\u578b\u4e3aClassLoader\u7684parent\u57df");
    }

    private static Field a() {
        Object obj;
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        ClassLoader parent = contextClassLoader.getParent();
        for (Field field : ClassLoader.class.getDeclaredFields()) {
            try {
                boolean isAccessible = field.isAccessible();
                field.setAccessible(true);
                obj = field.get(contextClassLoader);
                field.setAccessible(isAccessible);
            } catch (IllegalAccessException unused) {
            }
            if (obj == parent) {
                return field;
            }
        }
        return null;
    }
}
