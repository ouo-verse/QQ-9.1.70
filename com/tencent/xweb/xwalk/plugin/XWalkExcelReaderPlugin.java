package com.tencent.xweb.xwalk.plugin;

import com.tencent.view.FilterEnum;

/* loaded from: classes27.dex */
public class XWalkExcelReaderPlugin extends XWalkReaderBasePlugin {
    @Override // com.tencent.xweb.xwalk.plugin.XWalkReaderBasePlugin
    public String getAPKPath(int i3) {
        return getExtractFile(i3, "excelreader.apk");
    }

    @Override // com.tencent.xweb.xwalk.plugin.XWalkReaderBasePlugin
    public String getEnvClassPath() {
        return "com.tencent.xweb.xfiles.excel.ExcelReaderEnvironment";
    }

    @Override // com.tencent.xweb.xwalk.plugin.XWalkReaderBasePlugin
    public int getMinSupportRuntimeVersion(int i3) {
        if (i3 == 1) {
            return 238;
        }
        if (i3 == 2) {
            return FilterEnum.MIC_PTU_TRANS_XINXIAN;
        }
        return 100;
    }

    @Override // com.tencent.xweb.xwalk.plugin.XWalkPlugin
    public String getPluginName() {
        return XWalkPluginManager.XWALK_PLUGIN_NAME_EXCEL;
    }

    @Override // com.tencent.xweb.xwalk.plugin.XWalkReaderBasePlugin
    public String getReaderClassPath() {
        return "com.tencent.xweb.xfiles.excel.ExcelReader";
    }

    @Override // com.tencent.xweb.xwalk.plugin.XWalkPlugin
    public boolean isDownloadImmediately() {
        return true;
    }
}
