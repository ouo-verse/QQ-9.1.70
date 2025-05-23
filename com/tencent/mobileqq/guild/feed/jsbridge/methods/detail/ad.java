package com.tencent.mobileqq.guild.feed.jsbridge.methods.detail;

/* compiled from: P */
/* loaded from: classes13.dex */
public class ad extends c {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    public String k() {
        return "showHideInput";
    }

    @Override // ok1.a
    protected boolean o(String str, String str2, String str3) {
        lj1.a l3 = l();
        if (l3 == null) {
            return false;
        }
        l3.updateBottomBarVisible(b("show"));
        return true;
    }
}
