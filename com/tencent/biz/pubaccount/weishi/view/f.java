package com.tencent.biz.pubaccount.weishi.view;

import android.content.Context;
import android.view.View;

/* compiled from: P */
/* loaded from: classes32.dex */
public class f {

    /* renamed from: d, reason: collision with root package name */
    protected final View f82463d;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(View view) {
        this.f82463d = view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T extends View> T a(int i3) {
        return (T) this.f82463d.findViewById(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context b() {
        return this.f82463d.getContext();
    }
}
