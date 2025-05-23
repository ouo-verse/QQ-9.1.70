package com.tencent.rmonitor.fd.cluser;

/* compiled from: P */
/* loaded from: classes25.dex */
class d extends a {

    /* renamed from: b, reason: collision with root package name */
    private final String[] f365572b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(int i3, String... strArr) {
        super(i3);
        this.f365572b = strArr;
    }

    @Override // com.tencent.rmonitor.fd.cluser.c
    public boolean match(String str) {
        for (String str2 : this.f365572b) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }
}
