package com.tencent.xweb.xwalk.plugin;

/* loaded from: classes27.dex */
public class XWalkTXTReaderPlugin extends XWalkReaderBasePlugin {
    @Override // com.tencent.xweb.xwalk.plugin.XWalkReaderBasePlugin
    public String getAPKPath(int i3) {
        return getExtractFile(i3, "txtreader.apk");
    }

    @Override // com.tencent.xweb.xwalk.plugin.XWalkReaderBasePlugin
    public String getEnvClassPath() {
        return "com.tencent.xweb.xfiles.txt.TXTReaderEnvironment";
    }

    @Override // com.tencent.xweb.xwalk.plugin.XWalkReaderBasePlugin
    public int getMinSupportRuntimeVersion(int i3) {
        return 100;
    }

    @Override // com.tencent.xweb.xwalk.plugin.XWalkPlugin
    public String getPluginName() {
        return XWalkPluginManager.XWALK_PLUGIN_NAME_TXT;
    }

    @Override // com.tencent.xweb.xwalk.plugin.XWalkReaderBasePlugin
    public String getReaderClassPath() {
        return "com.tencent.xweb.xfiles.txt.TXTReader";
    }

    @Override // com.tencent.xweb.xwalk.plugin.XWalkPlugin
    public boolean isDownloadImmediately() {
        return true;
    }
}
