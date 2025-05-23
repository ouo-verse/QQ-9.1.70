package com.tencent.biz.qqcircle.debug.controller;

/* compiled from: P */
/* loaded from: classes4.dex */
public class br extends bs {
    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String c() {
        return null;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String d() {
        return "QCircleShareAvatarRandomController";
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String e() {
        return "SHARE_AVATAR_RANDOM";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.debug.controller.bs, com.tencent.qcircle.cooperation.config.debug.d
    public void g(int i3) {
        super.g(i3);
        boolean z16 = true;
        if (i3 != 1) {
            z16 = false;
        }
        uq3.k.b().j("share_avatar_random", z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qcircle.cooperation.config.debug.d
    public int h() {
        return 1;
    }
}
