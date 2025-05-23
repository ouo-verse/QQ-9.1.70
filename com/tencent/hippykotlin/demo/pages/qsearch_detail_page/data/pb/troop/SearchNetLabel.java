package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop;

import com.tencent.kuikly.core.base.h;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class SearchNetLabel {
    public h bgColor;
    public int gender;
    public String icon;
    public String text = "";
    public h textColor;
    public int type;

    public SearchNetLabel() {
        h.Companion companion = h.INSTANCE;
        this.textColor = companion.m();
        this.bgColor = companion.c();
        this.type = 3;
        this.gender = 1;
        this.icon = "";
    }
}
