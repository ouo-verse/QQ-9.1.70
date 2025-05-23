package com.tencent.mm.ui.widget.sortlist;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.Checkable;

/* compiled from: P */
/* loaded from: classes9.dex */
public class DragSortItemViewCheckable extends DragSortItemView implements Checkable {
    public DragSortItemViewCheckable(Context context) {
        super(context);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        KeyEvent.Callback childAt = getChildAt(0);
        if (!(childAt instanceof Checkable)) {
            return false;
        }
        return ((Checkable) childAt).isChecked();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z16) {
        KeyEvent.Callback childAt = getChildAt(0);
        if (childAt instanceof Checkable) {
            ((Checkable) childAt).setChecked(z16);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        KeyEvent.Callback childAt = getChildAt(0);
        if (childAt instanceof Checkable) {
            ((Checkable) childAt).toggle();
        }
    }
}
