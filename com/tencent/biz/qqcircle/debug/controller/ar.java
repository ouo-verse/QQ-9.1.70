package com.tencent.biz.qqcircle.debug.controller;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ar extends bs {
    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String c() {
        return null;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String d() {
        return "QCircleFaceSettingsClearController";
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String e() {
        return "\u6e05\u9664\u4eba\u8138\u68c0\u6d4b";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.debug.controller.bs, com.tencent.qcircle.cooperation.config.debug.d
    public void g(int i3) {
        super.g(i3);
        uq3.k.b().j("mmkv_key_first_show_guide", true);
        uq3.k.b().j("mmkv_key_first_guide_set", false);
        uq3.k.a().j("mmkv_key_open_face_detect", false);
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
        uq3.k.b().j("mmkv_key_first_show_guide", true);
        uq3.k.b().j("mmkv_key_first_guide_set", false);
        uq3.k.a().j("mmkv_key_open_face_detect", false);
    }
}
