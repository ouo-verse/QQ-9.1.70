package cooperation.qzone.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ExtendButton extends CompoundButton {
    private boolean mAncestorHaveOneSelected;

    public ExtendButton(Context context) {
        super(context);
        this.mAncestorHaveOneSelected = true;
    }

    @Override // android.view.View
    protected void dispatchSetSelected(boolean z16) {
        ViewParent parent;
        if (z16 && this.mAncestorHaveOneSelected && (parent = getParent()) != null && (parent instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) parent;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt != null && childAt != this) {
                    childAt.setSelected(false);
                }
            }
        }
    }

    @Override // android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCheckable(true);
        accessibilityNodeInfo.setChecked(isChecked());
    }

    public void setAncestorHaveOneSelected(boolean z16) {
        this.mAncestorHaveOneSelected = z16;
    }

    public ExtendButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAncestorHaveOneSelected = true;
    }

    public ExtendButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mAncestorHaveOneSelected = true;
    }
}
