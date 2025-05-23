package com.tencent.ditto.area;

import android.graphics.Canvas;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.ditto.utils.DittoLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DittoAreaGroup extends DittoArea {
    private final List<DittoArea> mChildren;
    private DittoArea touchedArea;

    public DittoAreaGroup(DittoHost dittoHost) {
        super(dittoHost);
        this.touchedArea = null;
        this.mChildren = new ArrayList();
    }

    public static int getChildMeasureSpec(int i3, int i16, int i17) {
        return getChildMeasureSpec(i3, i16, i17, null);
    }

    private boolean inRange(float f16, float f17, float f18) {
        if (f16 >= f17 && f16 <= f18) {
            return true;
        }
        return false;
    }

    public void addChild(DittoArea dittoArea) {
        addChild(dittoArea, null);
    }

    @Override // com.tencent.ditto.area.DittoArea, com.tencent.ditto.area.DittoElement
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        DittoArea dittoArea;
        if (motionEvent.getAction() == 3 && (dittoArea = this.touchedArea) != null) {
            dittoArea.dispatchTouchEvent(motionEvent);
            this.touchedArea = null;
        }
        for (int size = this.mChildren.size() - 1; size >= 0; size--) {
            DittoArea dittoArea2 = this.mChildren.get(size);
            if (dittoArea2.getVisibility() != 8) {
                float x16 = motionEvent.getX() - getPaddingLeft();
                float y16 = motionEvent.getY() - getPaddingTop();
                if (inRange(x16, dittoArea2.mLeft, dittoArea2.mRight) && inRange(y16, dittoArea2.mTop, dittoArea2.mBottom)) {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.offsetLocation((-dittoArea2.mLeft) - getPaddingLeft(), (-dittoArea2.mTop) - getPaddingTop());
                    if (dittoArea2.dispatchTouchEvent(obtain)) {
                        obtain.recycle();
                        if (motionEvent.getAction() == 0) {
                            this.touchedArea = dittoArea2;
                        }
                        return true;
                    }
                    obtain.recycle();
                } else if (dittoArea2 == this.touchedArea && motionEvent.getAction() == 1) {
                    this.touchedArea.dispatchTouchEventOutside();
                    this.touchedArea = null;
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ditto.area.DittoArea
    public void dispatchTouchEventOutside() {
        for (int size = this.mChildren.size() - 1; size >= 0; size--) {
            DittoArea dittoArea = this.mChildren.get(size);
            if (dittoArea != null && dittoArea.getVisibility() != 8) {
                dittoArea.dispatchTouchEventOutside();
            }
        }
    }

    public DittoArea findChildById(String str) {
        DittoArea findChildById;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (DittoArea dittoArea : this.mChildren) {
            if (str.equals(dittoArea.f100544id)) {
                return dittoArea;
            }
            if ((dittoArea instanceof DittoAreaGroup) && (findChildById = ((DittoAreaGroup) dittoArea).findChildById(str)) != null) {
                return findChildById;
            }
        }
        return null;
    }

    @Override // com.tencent.ditto.area.DittoArea
    public DittoArea findTarget(float f16, float f17) {
        boolean z16;
        DittoArea dittoArea;
        if (super.findTarget(f16, f17) != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            float left = (f16 - getLeft()) - getPaddingLeft();
            float top = (f17 - getTop()) - getPaddingTop();
            for (DittoArea dittoArea2 : this.mChildren) {
                if (dittoArea2.getVisibility() == 0) {
                    dittoArea = dittoArea2.findTarget(left, top);
                } else {
                    dittoArea = null;
                }
                if (dittoArea != null) {
                    return dittoArea;
                }
            }
        }
        return null;
    }

    public DittoArea getChildAt(int i3) {
        return this.mChildren.get(i3);
    }

    public int getChildCount() {
        return this.mChildren.size();
    }

    public List<DittoArea> getChildren() {
        return new ArrayList(this.mChildren);
    }

    public boolean isEmpty() {
        Iterator<DittoArea> it = this.mChildren.iterator();
        while (it.hasNext()) {
            if (it.next().getVisibility() == 0) {
                return false;
            }
        }
        return true;
    }

    public void measureChild(DittoArea dittoArea, int i3, int i16) {
        LayoutAttrSet layoutAttr = dittoArea.getLayoutAttr();
        dittoArea.measure(getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight(), layoutAttr.width), getChildMeasureSpec(i16, getPaddingTop() + getPaddingBottom(), layoutAttr.height));
    }

    public void measureChildWithMargins(DittoArea dittoArea, int i3, int i16, int i17, int i18) {
        LayoutAttrSet layoutAttr = dittoArea.getLayoutAttr();
        dittoArea.measure(getChildMeasureSpec(i3, layoutAttr.leftMargin + layoutAttr.rightMargin + i16, layoutAttr.width), getChildMeasureSpec(i17, layoutAttr.topMargin + layoutAttr.bottomMargin + i18, layoutAttr.height));
    }

    public void measureChildren(int i3, int i16) {
        int size = this.mChildren.size();
        for (int i17 = 0; i17 < size; i17++) {
            DittoArea dittoArea = this.mChildren.get(i17);
            if (dittoArea.getVisibility() != 8) {
                measureChild(dittoArea, i3, i16);
            }
        }
    }

    @Override // com.tencent.ditto.area.DittoArea
    public void onDraw(Canvas canvas) {
        int saveCount = canvas.getSaveCount();
        canvas.save();
        try {
            for (DittoArea dittoArea : this.mChildren) {
                if (dittoArea.getVisibility() == 0) {
                    canvas.translate(dittoArea.getLeft(), dittoArea.getTop());
                    dittoArea.draw(canvas);
                    canvas.translate(-dittoArea.getLeft(), -dittoArea.getTop());
                }
            }
        } catch (Exception e16) {
            DittoLog.e(DittoLog.defaultTag, "", e16);
        }
        canvas.restoreToCount(saveCount);
    }

    public void removeAllChildren() {
        this.mChildren.clear();
        this.mHost.removeAccessibilityArea(this.mChildren);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0047, code lost:
    
        if (r7 == (-2)) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getChildMeasureSpec(int i3, int i16, int i17, DittoArea dittoArea) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3) - i16;
        int i18 = 0;
        int max = Math.max(0, size);
        if (mode == Integer.MIN_VALUE) {
            if (i17 < 0) {
                if (i17 != -1) {
                }
                i17 = max;
                i18 = Integer.MIN_VALUE;
            }
            i18 = 1073741824;
        } else if (mode != 0) {
            if (mode == 1073741824) {
                if (i17 < 0) {
                    if (i17 == -1) {
                        i17 = max;
                    } else if (i17 == -2) {
                        if (dittoArea != null && "yellowdiamond_container".equals(dittoArea.getId())) {
                            i17 = max;
                        }
                        i17 = max;
                        i18 = Integer.MIN_VALUE;
                    }
                }
                i18 = 1073741824;
            }
            i17 = 0;
            i18 = 1073741824;
        } else {
            if (i17 < 0) {
                if (i17 == -1 || i17 == -2) {
                    i17 = 0;
                }
                i17 = 0;
            }
            i18 = 1073741824;
        }
        return View.MeasureSpec.makeMeasureSpec(i17, i18);
    }

    public void addChild(DittoArea dittoArea, LayoutAttrSet layoutAttrSet) {
        if (layoutAttrSet != null) {
            dittoArea.setLayoutAttr(layoutAttrSet);
        }
        this.mChildren.add(dittoArea);
        dittoArea.mParent = new WeakReference<>(this);
    }

    public DittoAreaGroup(DittoHost dittoHost, LayoutAttrSet layoutAttrSet) {
        super(dittoHost, layoutAttrSet);
        this.touchedArea = null;
        this.mChildren = new ArrayList();
    }
}
