package com.vivo.push.b;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class a extends c {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<String> f387558a;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a(boolean z16, String str, ArrayList<String> arrayList) {
        super(r1, str);
        int i3;
        if (z16) {
            i3 = 2002;
        } else {
            i3 = 2003;
        }
        this.f387558a = arrayList;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a(ComicCancelRedPointPopItemData.JSON_KEY_TAGS, this.f387558a);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.f387558a = dVar.c(ComicCancelRedPointPopItemData.JSON_KEY_TAGS);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final String toString() {
        return "AliasCommand:" + b();
    }
}
