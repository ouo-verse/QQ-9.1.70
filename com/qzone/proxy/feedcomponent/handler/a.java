package com.qzone.proxy.feedcomponent.handler;

import cooperation.qzone.mobilereport.MobileReportManager;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {
    public void a(String str, String str2, String str3, int i3) {
        MobileReportManager.getInstance().reportAction("QzonePersonalized", "space_home", "space_feed", str, str2, str3, i3, 1);
    }
}
