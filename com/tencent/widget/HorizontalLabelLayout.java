package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class HorizontalLabelLayout extends ViewGroup {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private int[] f384596d;

    /* renamed from: e, reason: collision with root package name */
    private int f384597e;

    /* renamed from: f, reason: collision with root package name */
    public int f384598f;

    public HorizontalLabelLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f384597e = 0;
            this.f384598f = 12;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public FrameLayout.LayoutParams generateDefaultLayoutParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (FrameLayout.LayoutParams) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return new FrameLayout.LayoutParams(-2, -2, 16);
    }

    @Override // android.view.ViewGroup
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (FrameLayout.LayoutParams) iPatchRedirector.redirect((short) 5, (Object) this, (Object) attributeSet);
        }
        return new FrameLayout.LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) layoutParams)).booleanValue();
        }
        return layoutParams instanceof FrameLayout.LayoutParams;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x018b  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        int max;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        int childCount = getChildCount();
        int paddingLeft = ((i17 - i3) - getPaddingLeft()) - getPaddingRight();
        int paddingLeft2 = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i37 = paddingLeft / 2;
        int[] iArr = this.f384596d;
        if ((iArr == null && childCount > 0) || (iArr != null && iArr.length < childCount)) {
            this.f384596d = new int[childCount];
        } else if (iArr != null) {
            int i38 = 0;
            while (true) {
                int[] iArr2 = this.f384596d;
                if (i38 >= iArr2.length) {
                    break;
                }
                iArr2[i38] = 0;
                i38++;
            }
        }
        int i39 = 0;
        int i46 = 0;
        int i47 = 0;
        int i48 = 0;
        int i49 = 0;
        while (true) {
            i19 = 8;
            if (i39 >= childCount) {
                break;
            }
            View childAt = getChildAt(i39);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i56 = measuredWidth + marginLayoutParams.leftMargin;
                int i57 = marginLayoutParams.rightMargin;
                int i58 = i56 + i57;
                int i59 = measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                if (this.f384597e == 1) {
                    if (i46 == 0) {
                        max = Math.max(i37, i58);
                    } else {
                        max = Math.max(i37, i58 + this.f384598f);
                    }
                    i49 = max;
                    if (i46 + i49 > paddingLeft) {
                        this.f384596d[i47] = i48;
                        i47++;
                        i46 = 0;
                        i48 = 0;
                    }
                    i46 += i49;
                } else {
                    int i65 = i46 + i58;
                    if (i65 > paddingLeft && i65 - i57 <= paddingLeft) {
                        i58 -= i57;
                    } else if (i65 > paddingLeft) {
                        this.f384596d[i47] = i48;
                        i47++;
                        i46 = 0;
                        i48 = 0;
                    }
                    i46 += i58;
                }
                i48 = Math.max(i48, i59);
            }
            if (i39 == childCount - 1) {
                int[] iArr3 = this.f384596d;
                if (i47 < iArr3.length) {
                    iArr3[i47] = i48;
                }
            }
            i39++;
        }
        int i66 = 0;
        int i67 = 0;
        int i68 = 0;
        int i69 = 0;
        int i75 = 0;
        while (i66 < childCount) {
            View childAt2 = getChildAt(i66);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) childAt2.getLayoutParams();
            if (childAt2.getVisibility() != i19) {
                int measuredWidth2 = childAt2.getMeasuredWidth();
                int measuredHeight2 = childAt2.getMeasuredHeight();
                int i76 = marginLayoutParams2.leftMargin + measuredWidth2;
                i26 = childCount;
                int i77 = marginLayoutParams2.rightMargin;
                int i78 = i76 + i77;
                int i79 = i49;
                i27 = i66;
                int i85 = measuredHeight2 + marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
                if (this.f384597e == 1) {
                    if (i67 == 0) {
                        i36 = Math.max(i37, i78);
                    } else {
                        i36 = Math.max(i37, this.f384598f + i78);
                    }
                    if (i67 + i36 > paddingLeft) {
                        i68 += i75;
                        i69++;
                        i67 = 0;
                        i75 = 0;
                    }
                    int i86 = paddingLeft2 + i67 + marginLayoutParams2.leftMargin;
                    int i87 = i68;
                    int i88 = paddingTop + i68 + marginLayoutParams2.topMargin;
                    if (marginLayoutParams2 instanceof FrameLayout.LayoutParams) {
                        int[] iArr4 = this.f384596d;
                        i28 = paddingLeft;
                        if (i69 < iArr4.length) {
                            int i89 = ((FrameLayout.LayoutParams) marginLayoutParams2).gravity;
                            i29 = paddingLeft2;
                            if (i89 == -1) {
                                i89 = 16;
                            }
                            int i95 = i89 & 112;
                            if (i95 != 16) {
                                if (i95 == 80) {
                                    i88 += iArr4[i69] - i85;
                                }
                                childAt2.layout(i86, i88, measuredWidth2 + i86, i88 + measuredHeight2);
                                if (this.f384597e == 1) {
                                    i67 += i36;
                                } else {
                                    i67 += i78;
                                }
                                i75 = Math.max(i75, i85);
                                i68 = i87;
                                i49 = i36;
                            } else {
                                i88 += (iArr4[i69] - i85) / 2;
                                childAt2.layout(i86, i88, measuredWidth2 + i86, i88 + measuredHeight2);
                                if (this.f384597e == 1) {
                                }
                                i75 = Math.max(i75, i85);
                                i68 = i87;
                                i49 = i36;
                            }
                        }
                    } else {
                        i28 = paddingLeft;
                    }
                    i29 = paddingLeft2;
                    childAt2.layout(i86, i88, measuredWidth2 + i86, i88 + measuredHeight2);
                    if (this.f384597e == 1) {
                    }
                    i75 = Math.max(i75, i85);
                    i68 = i87;
                    i49 = i36;
                } else {
                    int i96 = i67 + i78;
                    if (i96 > paddingLeft && i96 - i77 <= paddingLeft) {
                        i78 -= i77;
                    } else if (i96 > paddingLeft) {
                        i68 += i75;
                        i69++;
                        i36 = i79;
                        i67 = 0;
                        i75 = 0;
                        int i862 = paddingLeft2 + i67 + marginLayoutParams2.leftMargin;
                        int i872 = i68;
                        int i882 = paddingTop + i68 + marginLayoutParams2.topMargin;
                        if (marginLayoutParams2 instanceof FrameLayout.LayoutParams) {
                        }
                        i29 = paddingLeft2;
                        childAt2.layout(i862, i882, measuredWidth2 + i862, i882 + measuredHeight2);
                        if (this.f384597e == 1) {
                        }
                        i75 = Math.max(i75, i85);
                        i68 = i872;
                        i49 = i36;
                    }
                    i36 = i79;
                    int i8622 = paddingLeft2 + i67 + marginLayoutParams2.leftMargin;
                    int i8722 = i68;
                    int i8822 = paddingTop + i68 + marginLayoutParams2.topMargin;
                    if (marginLayoutParams2 instanceof FrameLayout.LayoutParams) {
                    }
                    i29 = paddingLeft2;
                    childAt2.layout(i8622, i8822, measuredWidth2 + i8622, i8822 + measuredHeight2);
                    if (this.f384597e == 1) {
                    }
                    i75 = Math.max(i75, i85);
                    i68 = i8722;
                    i49 = i36;
                }
            } else {
                i26 = childCount;
                i27 = i66;
                i28 = paddingLeft;
                i29 = paddingLeft2;
            }
            i66 = i27 + 1;
            childCount = i26;
            paddingLeft = i28;
            paddingLeft2 = i29;
            i19 = 8;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        int childCount = getChildCount();
        int size = (View.MeasureSpec.getSize(i3) - getPaddingLeft()) - getPaddingRight();
        int i17 = size / 2;
        int i18 = 0;
        int i19 = 0;
        int i26 = 0;
        int i27 = 0;
        for (int i28 = 0; i28 < childCount; i28++) {
            View childAt = getChildAt(i28);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8) {
                measureChildWithMargins(childAt, i3, 0, i16, 0);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i29 = measuredWidth + marginLayoutParams.leftMargin;
                int i36 = marginLayoutParams.rightMargin;
                int i37 = i29 + i36;
                int i38 = measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                if (this.f384597e == 1) {
                    if (i19 == 0) {
                        i37 = Math.max(i17, i37);
                    } else {
                        i37 = Math.max(i17, i37 + this.f384598f);
                    }
                    if (i19 + i37 > size) {
                        i18 = Math.max(i18, i19);
                        i26 += i27;
                        i19 = 0;
                        i27 = 0;
                    }
                    i19 += i37;
                    i27 = Math.max(i27, i38);
                } else {
                    int i39 = i19 + i37;
                    if (i39 > size && i39 - i36 <= size) {
                        i37 -= i36;
                    } else if (i39 > size) {
                        i18 = Math.max(i18, i19);
                        i26 += i27;
                        i19 = 0;
                        i27 = 0;
                    }
                    i19 += i37;
                    i27 = Math.max(i27, i38);
                }
            }
        }
        setMeasuredDimension(View.resolveSize(Math.max(Math.max(i18, i19) + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i3), View.resolveSize(Math.max(i26 + i27 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i16));
    }

    public void setStyle(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else if (i3 == 1) {
            this.f384597e = 1;
            this.f384598f = (int) (getContext().getResources().getDisplayMetrics().density * 6.0f);
        } else {
            this.f384597e = 0;
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? new FrameLayout.LayoutParams(layoutParams) : (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 6, (Object) this, (Object) layoutParams);
    }

    public HorizontalLabelLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public HorizontalLabelLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.f384597e = 0;
            this.f384598f = 12;
        }
    }
}
