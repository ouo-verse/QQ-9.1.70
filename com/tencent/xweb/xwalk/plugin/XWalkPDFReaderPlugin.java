package com.tencent.xweb.xwalk.plugin;

import com.tencent.view.FilterEnum;

/* loaded from: classes27.dex */
public class XWalkPDFReaderPlugin extends XWalkReaderBasePlugin {
    @Override // com.tencent.xweb.xwalk.plugin.XWalkReaderBasePlugin
    public String getAPKPath(int i3) {
        return getExtractFile(i3, "pdfreader.apk");
    }

    @Override // com.tencent.xweb.xwalk.plugin.XWalkReaderBasePlugin
    public String getEnvClassPath() {
        return "com.tencent.xweb.xfiles.pdf.PDFReaderEnvironment";
    }

    @Override // com.tencent.xweb.xwalk.plugin.XWalkReaderBasePlugin
    public int getMinSupportRuntimeVersion(int i3) {
        if (i3 == 1) {
            return 250;
        }
        if (i3 == 2) {
            return FilterEnum.MIC_PTU_BAIXI;
        }
        return 100;
    }

    @Override // com.tencent.xweb.xwalk.plugin.XWalkPlugin
    public String getPluginName() {
        return XWalkPluginManager.XWALK_PLUGIN_NAME_PDF;
    }

    @Override // com.tencent.xweb.xwalk.plugin.XWalkReaderBasePlugin
    public String getReaderClassPath() {
        return "com.tencent.xweb.xfiles.pdf.PDFReader";
    }

    @Override // com.tencent.xweb.xwalk.plugin.XWalkPlugin
    public boolean isDownloadImmediately() {
        return true;
    }
}
