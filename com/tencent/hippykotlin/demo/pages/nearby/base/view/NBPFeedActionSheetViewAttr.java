package com.tencent.hippykotlin.demo.pages.nearby.base.view;

import com.tencent.kuikly.core.base.k;

/* loaded from: classes31.dex */
public final class NBPFeedActionSheetViewAttr extends k {
    public boolean showUnrelatedTheme;
    public int appId = 2;
    public String feedId = "";
    public String viewerUserId = "";
    public String posterUserId = "";
    public String posterTinyId = "";

    public final void params(int i3, String str, String str2, String str3, String str4, boolean z16) {
        this.appId = i3;
        this.feedId = str;
        this.viewerUserId = str2;
        this.posterUserId = str3;
        this.posterTinyId = str4;
        this.showUnrelatedTheme = z16;
    }
}
