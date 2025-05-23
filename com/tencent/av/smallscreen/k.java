package com.tencent.av.smallscreen;

import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;
import com.tencent.av.ui.z;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public class k extends e {
    public k(Context context) {
        this.f74601a = "SmallScreenVideo";
        this.f74604d = R.layout.di6;
        this.f74605e = context.getResources().getDimensionPixelSize(R.dimen.a9h);
        this.f74606f = context.getResources().getDimensionPixelSize(R.dimen.a9_);
    }

    private void g(int i3) {
        i iVar = this.f74603c;
        WindowManager windowManager = iVar.f74619a;
        WindowManager.LayoutParams c16 = iVar.c();
        if (windowManager.getDefaultDisplay().getRotation() % 2 == 0) {
            c16.width = this.f74605e;
            c16.height = this.f74606f;
        } else {
            c16.width = this.f74606f;
            c16.height = this.f74605e;
        }
        Point d16 = this.f74602b.d(i3);
        c16.x = d16.x;
        c16.y = d16.y;
    }

    @Override // com.tencent.av.smallscreen.e
    public void f(BaseSmallScreenService baseSmallScreenService) {
        boolean z16;
        boolean z17;
        SmallScreenVideoController smallScreenVideoController;
        SmallScreenVideoLayerUI smallScreenVideoLayerUI;
        if (!(baseSmallScreenService instanceof SmallScreenService) || (smallScreenVideoController = ((SmallScreenService) baseSmallScreenService).T) == null || (smallScreenVideoLayerUI = smallScreenVideoController.f74556u) == null) {
            z16 = false;
            z17 = false;
        } else {
            z16 = smallScreenVideoLayerUI.N0();
            z17 = smallScreenVideoController.f74556u.P0();
        }
        if (z16 && !z17) {
            this.f74602b.setSize(this.f74605e, z.n(this.f74605e));
        } else {
            this.f74602b.setSize(this.f74605e, this.f74606f);
        }
        this.f74602b.o();
    }

    @Override // com.tencent.av.smallscreen.e
    public void e(boolean z16, int i3) {
        if (z16 && !this.f74603c.b()) {
            g(i3);
        }
        super.e(z16, i3);
    }
}
