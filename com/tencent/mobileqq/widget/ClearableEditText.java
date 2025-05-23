package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ClearableEditText extends EditText {
    private boolean C;
    private boolean D;
    private int E;
    public boolean F;

    /* renamed from: d, reason: collision with root package name */
    Drawable f315523d;

    /* renamed from: e, reason: collision with root package name */
    private int f315524e;

    /* renamed from: f, reason: collision with root package name */
    private int f315525f;

    /* renamed from: h, reason: collision with root package name */
    private float f315526h;

    /* renamed from: i, reason: collision with root package name */
    d f315527i;

    /* renamed from: m, reason: collision with root package name */
    c f315528m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (ClearableEditText.this.getCompoundDrawables()[2] == null) {
                return false;
            }
            boolean z16 = true;
            if (motionEvent.getAction() != 1) {
                return false;
            }
            if (motionEvent.getX() <= (ClearableEditText.this.getWidth() - ClearableEditText.this.getPaddingRight()) - ClearableEditText.this.f315523d.getIntrinsicWidth()) {
                z16 = false;
            }
            if (z16) {
                ClearableEditText.this.setText("");
                ClearableEditText.this.setClearButtonVisible(false);
                d dVar = ClearableEditText.this.f315527i;
                if (dVar != null) {
                    dVar.E0();
                }
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private class c extends ExploreByTouchHelper {
        public c(View view) {
            super(view);
        }

        @Override // android.support.v4.widget.ExploreByTouchHelper
        protected int getVirtualViewAt(float f16, float f17) {
            if (ClearableEditText.this.C && f16 > (ClearableEditText.this.getWidth() - ClearableEditText.this.getPaddingRight()) - ClearableEditText.this.f315523d.getIntrinsicWidth()) {
                return 0;
            }
            return -1;
        }

        @Override // android.support.v4.widget.ExploreByTouchHelper
        protected void getVisibleVirtualViews(List<Integer> list) {
            if (ClearableEditText.this.C) {
                list.add(0);
            }
        }

        @Override // android.support.v4.widget.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int i3, int i16, Bundle bundle) {
            if (QLog.isColorLevel()) {
                QLog.d("ClearableEditTextHelper", 2, "onPerformActionForVirtualView virtualViewId:" + i3);
                return false;
            }
            return false;
        }

        @Override // android.support.v4.widget.ExploreByTouchHelper
        protected void onPopulateEventForVirtualView(int i3, AccessibilityEvent accessibilityEvent) {
            if (i3 == 0) {
                accessibilityEvent.setContentDescription(az.g(R.string.kmp));
                accessibilityEvent.setClassName(Button.class.getName());
            }
        }

        @Override // android.support.v4.widget.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int i3, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (i3 == 0) {
                accessibilityNodeInfoCompat.setContentDescription(HardCodeUtil.qqStr(R.string.kmp));
                accessibilityNodeInfoCompat.setClassName(Button.class.getName());
                accessibilityNodeInfoCompat.addAction(16);
                accessibilityNodeInfoCompat.setBoundsInParent(new Rect((ClearableEditText.this.getWidth() - ClearableEditText.this.getPaddingRight()) - ClearableEditText.this.f315523d.getIntrinsicWidth(), ClearableEditText.this.getPaddingTop(), ClearableEditText.this.getWidth() - ClearableEditText.this.getPaddingRight(), ClearableEditText.this.getHeight() - ClearableEditText.this.getPaddingBottom()));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface d {
        void E0();
    }

    public ClearableEditText(Context context) {
        this(context, null, android.R.attr.editTextStyle);
    }

    private void d(Context context, AttributeSet attributeSet) {
        this.f315526h = context.getResources().getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, u51.a.L1);
        try {
            this.f315523d = obtainStyledAttributes.getDrawable(u51.a.M1);
            this.f315524e = obtainStyledAttributes.getDimensionPixelSize(u51.a.O1, -1);
            this.f315525f = obtainStyledAttributes.getDimensionPixelSize(u51.a.N1, -1);
            obtainStyledAttributes.recycle();
            if (this.f315523d == null) {
                this.f315523d = getResources().getDrawable(R.drawable.cross);
            }
            Drawable drawable = this.f315523d;
            if (drawable != null) {
                if (this.f315524e == -1 || this.f315525f == -1) {
                    float f16 = this.f315526h;
                    this.f315524e = (int) (f16 * 19.0f);
                    this.f315525f = (int) (f16 * 19.0f);
                }
                drawable.setBounds(0, 0, this.f315524e, this.f315525f);
                setClearButtonVisible(false);
            }
            setOnTouchListener(new a());
            addTextChangedListener(new b());
        } catch (Throwable th5) {
            obtainStyledAttributes.recycle();
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable c() {
        return this.f315523d;
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (this.C && motionEvent.getX() > (getWidth() - getPaddingRight()) - this.f315523d.getIntrinsicWidth()) {
            return this.f315528m.dispatchHoverEvent(motionEvent);
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    public ClearableEditText e(Drawable drawable) {
        this.f315523d = drawable;
        if (drawable != null) {
            if (this.f315524e == -1 || this.f315525f == -1) {
                float f16 = this.f315526h;
                this.f315524e = (int) (f16 * 19.0f);
                this.f315525f = (int) (f16 * 19.0f);
            }
            drawable.setBounds(0, 0, this.f315524e, this.f315525f);
            setClearButtonVisible(false);
        }
        return this;
    }

    @Override // android.widget.TextView
    public boolean isSingleLine() {
        try {
            Field declaredField = TextView.class.getDeclaredField("mSingleLine");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            if (!(obj instanceof Boolean)) {
                return false;
            }
            return ((Boolean) obj).booleanValue();
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
            return false;
        } catch (IllegalArgumentException e17) {
            e17.printStackTrace();
            return false;
        } catch (NoSuchFieldException e18) {
            e18.printStackTrace();
            return false;
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        if (QLog.isColorLevel() && az.f316689c) {
            StringBuilder sb5 = new StringBuilder(100);
            sb5.append("onDetachedFromWindow ");
            sb5.append(getContext().getClass().getSimpleName());
            sb5.append("@0x");
            sb5.append(Integer.toHexString(getContext().hashCode()));
            sb5.append(" ClearableEditText@0x");
            sb5.append(Integer.toHexString(hashCode()));
            QLog.d("ClearableEditText", 2, sb5.toString());
        }
        this.F = true;
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z16, int i3, Rect rect) {
        super.onFocusChanged(z16, i3, rect);
        if (!z16) {
            setCursorVisible(false);
            setClearButtonVisible(false);
        } else {
            setCursorVisible(true);
            if (getText().toString().length() != 0) {
                setClearButtonVisible(true);
            }
        }
    }

    public void setCanMultiLine(boolean z16) {
        this.D = z16;
    }

    public void setClearButtonStyle(int i3) {
        this.E = i3;
        if (i3 == 1) {
            setClearButtonVisible(false);
        } else if (i3 == 2) {
            setClearButtonVisible(true);
        }
    }

    public void setClearButtonVisible(boolean z16) {
        Drawable drawable;
        if (!z16 || this.E != 1) {
            if (!z16 && this.E == 2) {
                return;
            }
            if (z16) {
                drawable = this.f315523d;
            } else {
                drawable = null;
            }
            setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], drawable, getCompoundDrawables()[3]);
            if (this.C != z16) {
                AccessibilityUtil.m(this);
            }
            this.C = z16;
        }
    }

    @Override // android.widget.TextView
    public void setCursorVisible(boolean z16) {
        if (QLog.isColorLevel() && az.f316689c && this.F) {
            StringBuilder sb5 = new StringBuilder(100);
            sb5.append("setCursorVisible=");
            sb5.append(z16);
            sb5.append(" ");
            sb5.append(getContext().getClass().getSimpleName());
            sb5.append("@0x");
            sb5.append(Integer.toHexString(getContext().hashCode()));
            sb5.append(" ClearableEditText@0x");
            sb5.append(Integer.toHexString(hashCode()));
            QLog.d("ClearableEditText", 2, sb5.toString(), new Exception());
        }
        super.setCursorVisible(z16);
    }

    public void setTextClearedListener(d dVar) {
        this.f315527i = dVar;
    }

    public ClearableEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.R.attr.editTextStyle);
    }

    public ClearableEditText(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.C = false;
        this.D = false;
        this.E = 0;
        this.F = false;
        try {
            d(context, attributeSet);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        c cVar = new c(this);
        this.f315528m = cVar;
        ViewCompat.setAccessibilityDelegate(this, cVar);
        ViewCompat.setImportantForAccessibility(this, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            String obj = ClearableEditText.this.getText().toString();
            if (ClearableEditText.this.isFocused()) {
                if (obj != null && obj.length() != 0) {
                    if (!ClearableEditText.this.isSingleLine() && !ClearableEditText.this.D) {
                        ClearableEditText.this.setClearButtonVisible(false);
                        return;
                    } else {
                        ClearableEditText.this.setClearButtonVisible(true);
                        return;
                    }
                }
                ClearableEditText.this.setClearButtonVisible(false);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
