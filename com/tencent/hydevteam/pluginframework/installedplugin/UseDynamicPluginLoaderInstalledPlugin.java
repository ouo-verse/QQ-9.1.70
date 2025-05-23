package com.tencent.hydevteam.pluginframework.installedplugin;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.util.Arrays;

/* loaded from: classes7.dex */
public class UseDynamicPluginLoaderInstalledPlugin extends InstalledPlugin {
    static IPatchRedirector $redirector_ = null;
    public static final String DYNAMIC_PLUGIN_CONTAINER_PATH = "DYNAMIC_PLUGIN_CONTAINER_PATH";
    public static final String DYNAMIC_PLUGIN_CONTAINER_VERSION = "DYNAMIC_PLUGIN_CONTAINER_VERSION";
    public static final String DYNAMIC_PLUGIN_LOADER_CLASSNAME = "DYNAMIC_PLUGIN_LOADER_CLASSNAME";
    public static final String DYNAMIC_PLUGIN_LOADER_INTERFACE_PACKAGE_NAMES = "DYNAMIC_PLUGIN_LOADER_INTERFACE_PACKAGE_NAMES";
    public static final String DYNAMIC_PLUGIN_LOADER_PATH = "DYNAMIC_PLUGIN_LOADER_PATH";
    public static final String DYNAMIC_PLUGIN_LOADER_VERSION = "DYNAMIC_PLUGIN_LOADER_VERSION";
    public static final String DYNAMIC_PLUGIN_PLUGIN_FILE_TYPE = "DYNAMIC_PLUGIN_PLUGIN_FILE_TYPE";
    private static final long serialVersionUID = 8964590057389188960L;
    public final File dynamicPluginContainerFile;
    public final String dynamicPluginContainerVersion;
    public final String dynamicPluginLoaderClassname;
    public final File dynamicPluginLoaderFile;
    public final String[] dynamicPluginLoaderInterfacePackageNames;
    public final String dynamicPluginLoaderVersion;
    public final File pluginUnpackDir;

    public UseDynamicPluginLoaderInstalledPlugin(String str, String str2, File file, String str3, String str4, File file2, File file3, String str5, String[] strArr, File file4) {
        super(str, str2, file);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, file, str3, str4, file2, file3, str5, strArr, file4);
            return;
        }
        this.dynamicPluginLoaderVersion = str3;
        this.dynamicPluginContainerVersion = str4;
        this.dynamicPluginLoaderFile = file2;
        this.dynamicPluginContainerFile = file3;
        this.dynamicPluginLoaderClassname = str5;
        this.dynamicPluginLoaderInterfacePackageNames = strArr;
        this.pluginUnpackDir = file4;
    }

    @Override // com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin
    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        UseDynamicPluginLoaderInstalledPlugin useDynamicPluginLoaderInstalledPlugin = (UseDynamicPluginLoaderInstalledPlugin) obj;
        if (!this.dynamicPluginLoaderVersion.equals(useDynamicPluginLoaderInstalledPlugin.dynamicPluginLoaderVersion) || !this.dynamicPluginContainerVersion.equals(useDynamicPluginLoaderInstalledPlugin.dynamicPluginContainerVersion) || !this.dynamicPluginLoaderFile.equals(useDynamicPluginLoaderInstalledPlugin.dynamicPluginLoaderFile) || !this.dynamicPluginContainerFile.equals(useDynamicPluginLoaderInstalledPlugin.dynamicPluginContainerFile) || !this.dynamicPluginLoaderClassname.equals(useDynamicPluginLoaderInstalledPlugin.dynamicPluginLoaderClassname) || !Arrays.equals(this.dynamicPluginLoaderInterfacePackageNames, useDynamicPluginLoaderInstalledPlugin.dynamicPluginLoaderInterfacePackageNames)) {
            return false;
        }
        return this.pluginUnpackDir.equals(useDynamicPluginLoaderInstalledPlugin.pluginUnpackDir);
    }

    @Override // com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return (((((((((((((super.hashCode() * 31) + this.dynamicPluginLoaderVersion.hashCode()) * 31) + this.dynamicPluginContainerVersion.hashCode()) * 31) + this.dynamicPluginLoaderFile.hashCode()) * 31) + this.dynamicPluginContainerFile.hashCode()) * 31) + this.dynamicPluginLoaderClassname.hashCode()) * 31) + Arrays.hashCode(this.dynamicPluginLoaderInterfacePackageNames)) * 31) + this.pluginUnpackDir.hashCode();
    }

    @Override // com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "UseDynamicPluginLoaderInstalledPlugin{dynamicPluginLoaderVersion='" + this.dynamicPluginLoaderVersion + "', dynamicPluginContainerVersion='" + this.dynamicPluginContainerVersion + "', dynamicPluginLoaderFile=" + this.dynamicPluginLoaderFile + ", dynamicPluginContainerFile=" + this.dynamicPluginContainerFile + ", dynamicPluginLoaderClassname='" + this.dynamicPluginLoaderClassname + "', dynamicPluginLoaderInterfacePackageNames=" + Arrays.toString(this.dynamicPluginLoaderInterfacePackageNames) + ", pluginUnpackDir=" + this.pluginUnpackDir + '}';
    }

    public UseDynamicPluginLoaderInstalledPlugin(String str, String str2, File file, String str3, String str4, File file2, File file3, String str5, String[] strArr, File file4, int i3) {
        super(str, str2, file, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, file, str3, str4, file2, file3, str5, strArr, file4, Integer.valueOf(i3));
            return;
        }
        this.dynamicPluginLoaderVersion = str3;
        this.dynamicPluginContainerVersion = str4;
        this.dynamicPluginLoaderFile = file2;
        this.dynamicPluginContainerFile = file3;
        this.dynamicPluginLoaderClassname = str5;
        this.dynamicPluginLoaderInterfacePackageNames = strArr;
        this.pluginUnpackDir = file4;
    }
}
