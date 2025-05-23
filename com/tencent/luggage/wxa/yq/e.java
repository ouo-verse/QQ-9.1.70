package com.tencent.luggage.wxa.yq;

import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes9.dex */
public class e extends f {

    /* renamed from: n, reason: collision with root package name */
    public String f146065n;

    public e(String str, String str2) {
        this(null, false, e());
        this.f146065n = str;
        this.f146067b = false;
        this.f146069d = false;
        this.f146074i = "local:" + str2;
    }

    public static int e() {
        int availableVersion = XWalkEnvironment.getAvailableVersion();
        if (availableVersion < 100000000) {
            return 100000000;
        }
        return availableVersion + 1;
    }

    @Override // com.tencent.luggage.wxa.yq.f
    public boolean a() {
        return true;
    }

    public e(String str, boolean z16, int i3) {
        super(str, z16, i3, com.tencent.luggage.wxa.ar.b.b(), 0);
    }
}
