package com.tencent.luggage.wxa.r0;

import android.view.View;
import com.tencent.mm.ui.widget.pulldown.IOverScroll;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c implements IOverScroll {
    @Override // com.tencent.mm.ui.widget.pulldown.IOverScroll
    public int getMaxOffset(View view) {
        if (view != null) {
            return view.getHeight();
        }
        return 0;
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IOverScroll
    public int getMinOffset(View view) {
        int i3;
        if (view != null) {
            i3 = view.getHeight();
        } else {
            i3 = 0;
        }
        return -i3;
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IOverScroll
    public int getOffset(View view) {
        if (view == null) {
            return 0;
        }
        float scaleY = (view.getScaleY() - 1) * view.getHeight();
        if (view.getPivotY() > 0.0f) {
            return -((int) scaleY);
        }
        return (int) scaleY;
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IOverScroll
    public void setOffset(View view, int i3) {
        if (view == null) {
            return;
        }
        float abs = Math.abs(i3) / view.getHeight();
        if (i3 > 0) {
            view.setPivotY(0.0f);
        } else {
            view.setPivotY(view.getHeight());
        }
        view.setScaleY(1 + abs);
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IOverScroll
    public void springBack(View view) {
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IOverScroll
    public void stopSpringBack(View view) {
    }
}
