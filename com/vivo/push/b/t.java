package com.vivo.push.b;

import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class t extends s {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<String> f387602a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<String> f387603b;

    public t(int i3) {
        super(i3);
        this.f387602a = null;
        this.f387603b = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("content", this.f387602a);
        dVar.a("error_msg", this.f387603b);
    }

    public final ArrayList<String> d() {
        return this.f387602a;
    }

    public final List<String> e() {
        return this.f387603b;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnSetTagsCommand";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f387602a = dVar.c("content");
        this.f387603b = dVar.c("error_msg");
    }
}
