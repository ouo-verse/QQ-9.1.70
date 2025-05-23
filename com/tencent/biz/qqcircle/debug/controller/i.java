package com.tencent.biz.qqcircle.debug.controller;

/* compiled from: P */
/* loaded from: classes4.dex */
public class i extends bs {
    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String c() {
        return null;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String d() {
        return "QCircleDailyClearBubbleController";
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String e() {
        return "\u6e05\u9664\u65e5\u5e38\u6c14\u6ce1";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.debug.controller.bs, com.tencent.qcircle.cooperation.config.debug.d
    public void g(int i3) {
        super.g(i3);
        uq3.k.a().j("mmkv_is_first_time_show_daily_bubble", true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qcircle.cooperation.config.debug.d
    public int h() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.debug.controller.bs, com.tencent.qcircle.cooperation.config.debug.d
    public void k() {
        super.k();
        p(0);
        uq3.k.a().j("mmkv_is_first_time_show_daily_bubble", true);
    }
}
