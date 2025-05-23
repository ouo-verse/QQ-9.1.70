package com.tencent.luggage.wxa.r0;

import android.view.View;
import com.tencent.mm.ui.widget.pulldown.IOverScroll;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a implements IOverScroll {
    @Override // com.tencent.mm.ui.widget.pulldown.IOverScroll
    public int getMaxOffset(View view) {
        if (view != null) {
            return view.getWidth();
        }
        return 0;
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IOverScroll
    public int getMinOffset(View view) {
        int i3;
        if (view != null) {
            i3 = view.getWidth();
        } else {
            i3 = 0;
        }
        return -i3;
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IOverScroll
    public int getOffset(View view) {
        if (view != null) {
            return (int) view.getTranslationX();
        }
        return 0;
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IOverScroll
    public void setOffset(View view, int i3) {
        if (view != null) {
            view.setTranslationX(i3);
        }
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IOverScroll
    public void springBack(View view) {
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IOverScroll
    public void stopSpringBack(View view) {
    }
}
