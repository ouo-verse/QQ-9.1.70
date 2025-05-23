package com.tencent.xweb.xwalk.plugin;

/* loaded from: classes27.dex */
public class XWalkWordReaderPlugin extends XWalkReaderBasePlugin {
    @Override // com.tencent.xweb.xwalk.plugin.XWalkReaderBasePlugin
    public String getAPKPath(int i3) {
        return getExtractFile(i3, "wordreader.apk");
    }

    @Override // com.tencent.xweb.xwalk.plugin.XWalkReaderBasePlugin
    public String getEnvClassPath() {
        return "com.tencent.xweb.xfiles.word.WordReaderEnvironment";
    }

    @Override // com.tencent.xweb.xwalk.plugin.XWalkReaderBasePlugin
    public int getMinSupportRuntimeVersion(int i3) {
        if (i3 == 1) {
            return 524;
        }
        if (i3 == 2) {
            return 744;
        }
        return 100;
    }

    @Override // com.tencent.xweb.xwalk.plugin.XWalkPlugin
    public String getPluginName() {
        return XWalkPluginManager.XWALK_PLUGIN_NAME_WORD;
    }

    @Override // com.tencent.xweb.xwalk.plugin.XWalkReaderBasePlugin
    public String getReaderClassPath() {
        return "com.tencent.xweb.xfiles.word.WordReader";
    }

    @Override // com.tencent.xweb.xwalk.plugin.XWalkPlugin
    public boolean isDownloadImmediately() {
        return true;
    }
}
