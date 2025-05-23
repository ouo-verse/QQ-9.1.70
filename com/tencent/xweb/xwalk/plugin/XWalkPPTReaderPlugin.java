package com.tencent.xweb.xwalk.plugin;

/* loaded from: classes27.dex */
public class XWalkPPTReaderPlugin extends XWalkReaderBasePlugin {
    @Override // com.tencent.xweb.xwalk.plugin.XWalkReaderBasePlugin
    public String getAPKPath(int i3) {
        return getExtractFile(i3, "pptreader.apk");
    }

    @Override // com.tencent.xweb.xwalk.plugin.XWalkReaderBasePlugin
    public String getEnvClassPath() {
        return "com.tencent.xweb.xfiles.ppt.PPTReaderEnvironment";
    }

    @Override // com.tencent.xweb.xwalk.plugin.XWalkReaderBasePlugin
    public int getMinSupportRuntimeVersion(int i3) {
        if (i3 == 1) {
            return 322;
        }
        if (i3 == 2) {
            return 362;
        }
        return 203;
    }

    @Override // com.tencent.xweb.xwalk.plugin.XWalkPlugin
    public String getPluginName() {
        return XWalkPluginManager.XWALK_PLUGIN_NAME_PPT;
    }

    @Override // com.tencent.xweb.xwalk.plugin.XWalkReaderBasePlugin
    public String getReaderClassPath() {
        return "com.tencent.xweb.xfiles.ppt.PPTReader";
    }

    @Override // com.tencent.xweb.xwalk.plugin.XWalkPlugin
    public boolean isDownloadImmediately() {
        return true;
    }
}
