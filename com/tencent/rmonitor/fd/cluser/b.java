package com.tencent.rmonitor.fd.cluser;

import com.tencent.rmonitor.common.util.e;

/* compiled from: P */
/* loaded from: classes25.dex */
class b extends a {

    /* renamed from: b, reason: collision with root package name */
    private final String[] f365571b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i3, String... strArr) {
        super(i3);
        this.f365571b = strArr;
    }

    @Override // com.tencent.rmonitor.fd.cluser.c
    public boolean match(String str) {
        for (String str2 : this.f365571b) {
            if (e.a(str2, str)) {
                return true;
            }
        }
        return false;
    }
}
