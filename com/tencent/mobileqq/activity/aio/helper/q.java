package com.tencent.mobileqq.activity.aio.helper;

import android.os.Bundle;
import android.text.Spanned;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: P */
/* loaded from: classes10.dex */
public class q implements com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.b {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.c2cshortcutbar.a f178861a;

    @Override // com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.b
    public void b(com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.d dVar) {
        this.f178861a = new com.tencent.mobileqq.c2cshortcutbar.a(dVar);
    }

    @Override // com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.b
    public void c(int i3, Bundle bundle) {
        this.f178861a.D(i3, bundle);
    }

    @Override // com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.b
    public ViewGroup.LayoutParams getParams() {
        return this.f178861a.i();
    }

    @Override // com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.b
    public int getPriority() {
        return 1;
    }

    @Override // com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.b
    public View getView() {
        return this.f178861a.q();
    }

    @Override // com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.b
    public void a(Spanned spanned) {
    }
}
