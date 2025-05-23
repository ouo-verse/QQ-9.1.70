package com.tencent.mobileqq.qqexpand.utils;

import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes16.dex */
public class r {
    public static boolean a(String str, String str2, boolean z16) {
        return QzoneConfig.getInstance().getConfig(str, str2, z16);
    }

    public static boolean b() {
        return a("RelationChain", "GameBoxReceiveSyncPush", true);
    }
}
