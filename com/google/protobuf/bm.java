package com.google.protobuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class bm implements as {

    /* renamed from: a, reason: collision with root package name */
    private final au f35723a;

    /* renamed from: b, reason: collision with root package name */
    private final String f35724b;

    /* renamed from: c, reason: collision with root package name */
    private final Object[] f35725c;

    /* renamed from: d, reason: collision with root package name */
    private final int f35726d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(au auVar, String str, Object[] objArr) {
        this.f35723a = auVar;
        this.f35724b = str;
        this.f35725c = objArr;
        char charAt = str.charAt(0);
        if (charAt < '\ud800') {
            this.f35726d = charAt;
            return;
        }
        int i3 = charAt & '\u1fff';
        int i16 = 13;
        int i17 = 1;
        while (true) {
            int i18 = i17 + 1;
            char charAt2 = str.charAt(i17);
            if (charAt2 >= '\ud800') {
                i3 |= (charAt2 & '\u1fff') << i16;
                i16 += 13;
                i17 = i18;
            } else {
                this.f35726d = i3 | (charAt2 << i16);
                return;
            }
        }
    }

    @Override // com.google.protobuf.as
    public boolean a() {
        if ((this.f35726d & 2) == 2) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.as
    public au b() {
        return this.f35723a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object[] c() {
        return this.f35725c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() {
        return this.f35724b;
    }

    @Override // com.google.protobuf.as
    public ProtoSyntax getSyntax() {
        if ((this.f35726d & 1) == 1) {
            return ProtoSyntax.PROTO2;
        }
        return ProtoSyntax.PROTO3;
    }
}
