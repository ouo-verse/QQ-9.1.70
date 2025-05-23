package com.tencent.qcircle.shadow.core.runtime;

import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;

/* loaded from: classes22.dex */
public class ShadowPackageItemInfo {
    public static XmlResourceParser loadXmlMetaData(ClassLoader classLoader, PackageItemInfo packageItemInfo, PackageManager packageManager, String str) {
        int i3;
        Resources resources = PluginPartInfoManager.getPluginInfo(classLoader).application.getResources();
        Bundle bundle = packageItemInfo.metaData;
        if (bundle != null && (i3 = bundle.getInt(str)) != 0) {
            return resources.getXml(i3);
        }
        return null;
    }
}
