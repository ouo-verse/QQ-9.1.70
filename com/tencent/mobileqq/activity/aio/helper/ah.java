package com.tencent.mobileqq.activity.aio.helper;

import android.os.Bundle;
import android.text.Spanned;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ah implements com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.b {

    /* renamed from: a, reason: collision with root package name */
    private TroopAppShortcutBarHelper f178779a;

    @Override // com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.b
    public void b(com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.d dVar) {
        this.f178779a = new TroopAppShortcutBarHelper(dVar);
    }

    @Override // com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.b
    public void c(int i3, Bundle bundle) {
        TroopAppShortcutBarHelper troopAppShortcutBarHelper = this.f178779a;
        if (troopAppShortcutBarHelper != null) {
            troopAppShortcutBarHelper.D(i3, bundle);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.b
    public ViewGroup.LayoutParams getParams() {
        return this.f178779a.i();
    }

    @Override // com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.b
    public int getPriority() {
        return 2;
    }

    @Override // com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.b
    public View getView() {
        TroopAppShortcutBarHelper troopAppShortcutBarHelper = this.f178779a;
        if (troopAppShortcutBarHelper == null) {
            return null;
        }
        return troopAppShortcutBarHelper.q();
    }

    @Override // com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.b
    public void a(Spanned spanned) {
    }
}
