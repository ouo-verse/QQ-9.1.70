package com.tencent.map.lib.models;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class MapExploreByTouchHelper extends ExploreByTouchHelper {
    protected static final int MAP_ACTION_CLICKED = 1;
    protected static final int NO_ITEM = -1;
    public List<AccessibleTouchItem> accessibleTouchItems;

    public MapExploreByTouchHelper(@NonNull View view) {
        super(view);
        this.accessibleTouchItems = new ArrayList();
    }

    protected abstract int getTargetPoiItemIdx(float f16, float f17);

    @Override // android.support.v4.widget.ExploreByTouchHelper
    protected int getVirtualViewAt(float f16, float f17) {
        int targetPoiItemIdx = getTargetPoiItemIdx(f16, f17);
        if (targetPoiItemIdx == -1) {
            return Integer.MIN_VALUE;
        }
        return targetPoiItemIdx;
    }

    @Override // android.support.v4.widget.ExploreByTouchHelper
    protected void getVisibleVirtualViews(List<Integer> list) {
        for (int i3 = 0; i3 < this.accessibleTouchItems.size(); i3++) {
            list.add(Integer.valueOf(i3));
        }
    }

    protected abstract boolean onItemClicked(int i3);

    @Override // android.support.v4.widget.ExploreByTouchHelper
    protected boolean onPerformActionForVirtualView(int i3, int i16, Bundle bundle) {
        if (i16 == 16) {
            return onItemClicked(i3);
        }
        return false;
    }

    @Override // android.support.v4.widget.ExploreByTouchHelper
    protected void onPopulateEventForVirtualView(int i3, AccessibilityEvent accessibilityEvent) {
        if (i3 >= this.accessibleTouchItems.size()) {
            accessibilityEvent.getText().add("");
            return;
        }
        AccessibleTouchItem accessibleTouchItem = this.accessibleTouchItems.get(i3);
        if (accessibleTouchItem != null) {
            accessibilityEvent.getText().add(accessibleTouchItem.getContentDescription());
            return;
        }
        throw new IllegalArgumentException("Invalid virtual view id");
    }

    @Override // android.support.v4.widget.ExploreByTouchHelper
    protected void onPopulateNodeForVirtualView(int i3, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (i3 >= this.accessibleTouchItems.size()) {
            accessibilityNodeInfoCompat.setText("");
            accessibilityNodeInfoCompat.setBoundsInParent(new Rect());
            return;
        }
        AccessibleTouchItem accessibleTouchItem = this.accessibleTouchItems.get(i3);
        if (accessibleTouchItem != null) {
            accessibilityNodeInfoCompat.setText(accessibleTouchItem.getContentDescription());
            accessibilityNodeInfoCompat.setBoundsInParent(accessibleTouchItem.getBounds());
            accessibilityNodeInfoCompat.addAction(16);
            return;
        }
        throw new IllegalArgumentException("Invalid virtual view id");
    }

    public void onTalkBackActivate(View view) {
        ViewCompat.setAccessibilityDelegate(view, this);
    }

    public void onTalkBackDeActivate(View view) {
        ViewCompat.setAccessibilityDelegate(view, null);
    }
}
