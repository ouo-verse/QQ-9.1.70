package com.tencent.adelie.av.ui;

import android.content.Context;
import android.view.WindowManager;
import android.widget.TextView;
import com.tencent.av.smallscreen.i;

/* compiled from: P */
/* loaded from: classes37.dex */
public class d extends com.tencent.av.smallscreen.d {
    public d(Context context) {
        super(context);
    }

    public WindowManager.LayoutParams h() {
        i iVar = this.f74603c;
        if (iVar == null) {
            return null;
        }
        return iVar.c();
    }

    public TextView i() {
        return this.f74599i;
    }

    public void j(int i3) {
        this.f74602b.setCurPosition(i3);
    }

    public void k(int i3) {
        this.f74599i.setText(i3);
    }

    public void l() {
        i iVar = this.f74603c;
        if (iVar != null) {
            iVar.f();
        }
    }
}
