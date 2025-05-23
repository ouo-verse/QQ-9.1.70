package com.qzone.proxy.vipcomponent.adapter;

import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes39.dex */
public class VipConfig {
    public static int getConfig(String str, String str2, int i3) {
        return QzoneConfig.getInstance().getConfig(str, str2, i3);
    }

    public static String getConfig(String str, String str2, String str3) {
        return QzoneConfig.getInstance().getConfig(str, str2, str3);
    }
}
