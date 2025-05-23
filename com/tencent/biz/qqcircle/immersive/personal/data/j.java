package com.tencent.biz.qqcircle.immersive.personal.data;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public class j extends b {
    @Override // com.tencent.biz.qqcircle.immersive.personal.data.b
    public String a() {
        return "QFSMainBasicBusiProfileBizInfo";
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.b
    public String b() {
        return "update_version_profile_biz";
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.b
    public boolean e(a aVar, a aVar2) {
        try {
            aVar.g().set(aVar2.g());
            return true;
        } catch (Exception e16) {
            QLog.e("QFSMainBasicBusiProfileBizInfo", 1, "[update] ", e16);
            return false;
        }
    }
}
