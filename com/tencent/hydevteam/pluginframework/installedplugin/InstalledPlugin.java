package com.tencent.hydevteam.pluginframework.installedplugin;

import com.tencent.hydevteam.common.annotation.API;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.io.Serializable;

@API
/* loaded from: classes7.dex */
public class InstalledPlugin implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final String PLUGIN_FILE_PATH = "PLUGIN_FILE_PATH";
    public static final String PLUGIN_LAUNCH_FAILED_TAG = "launch.failed";
    public static final String PLUGIN_PACKAGE_NAME = "PLUGIN_PACKAGE_NAME";
    public static final String PLUGIN_VERSION = "PLUGIN_VERSION";
    private static final long serialVersionUID = -6006001380938520517L;
    public final File pluginFile;
    public int pluginFileType;
    public final String pluginPackageName;
    public final String pluginVersionForConfigPluginLoader;
    public final String pluginVersionForPluginLoaderManage;

    public InstalledPlugin(String str, String str2, File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, file);
            return;
        }
        this.pluginPackageName = str;
        this.pluginVersionForConfigPluginLoader = str2;
        this.pluginVersionForPluginLoaderManage = Long.toString(file.lastModified(), 36);
        this.pluginFile = file;
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        InstalledPlugin installedPlugin = (InstalledPlugin) obj;
        if (!this.pluginPackageName.equals(installedPlugin.pluginPackageName) || !this.pluginVersionForConfigPluginLoader.equals(installedPlugin.pluginVersionForConfigPluginLoader) || !this.pluginVersionForPluginLoaderManage.equals(installedPlugin.pluginVersionForPluginLoaderManage)) {
            return false;
        }
        return this.pluginFile.equals(installedPlugin.pluginFile);
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return (((((this.pluginPackageName.hashCode() * 31) + this.pluginVersionForConfigPluginLoader.hashCode()) * 31) + this.pluginVersionForPluginLoaderManage.hashCode()) * 31) + this.pluginFile.hashCode();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "InstalledPlugin{pluginPackageName='" + this.pluginPackageName + "', pluginVersionForConfigPluginLoader='" + this.pluginVersionForConfigPluginLoader + "', pluginVersionForPluginLoaderManage='" + this.pluginVersionForPluginLoaderManage + "', pluginFile=" + this.pluginFile + '}';
    }

    public InstalledPlugin(String str, String str2, File file, int i3) {
        this(str, str2, file);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.pluginFileType = i3;
        } else {
            iPatchRedirector.redirect((short) 2, this, str, str2, file, Integer.valueOf(i3));
        }
    }
}
