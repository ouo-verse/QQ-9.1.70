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
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQUIAppSetting;
import java.lang.reflect.Field;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ConfigClearableEditText extends EditText {
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private d M;
    private int N;
    public boolean P;

    /* renamed from: d, reason: collision with root package name */
    Drawable f315559d;

    /* renamed from: e, reason: collision with root package name */
    private int f315560e;

    /* renamed from: f, reason: collision with root package name */
    private int f315561f;

    /* renamed from: h, reason: collision with root package name */
    private float f315562h;

    /* renamed from: i, reason: collision with root package name */
    e f315563i;

    /* renamed from: m, reason: collision with root package name */
    c f315564m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            boolean z16;
            ConfigClearableEditText configClearableEditText = ConfigClearableEditText.this;
            if (motionEvent.getX() > ConfigClearableEditText.this.e()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (ConfigClearableEditText.this.M != null) {
                if (z16 && motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                    ConfigClearableEditText.this.M.Mg(true);
                } else {
                    ConfigClearableEditText.this.M.Mg(false);
                }
            }
            if ((configClearableEditText.getCompoundDrawables()[2] != null || (ConfigClearableEditText.this.C && ConfigClearableEditText.this.M != null)) && motionEvent.getAction() == 1 && z16) {
                ConfigClearableEditText.this.setText("");
                ConfigClearableEditText.this.setClearButtonVisible(false);
                e eVar = ConfigClearableEditText.this.f315563i;
                if (eVar != null) {
                    eVar.E0();
                }
                if (ConfigClearableEditText.this.M != null) {
                    ConfigClearableEditText.this.M.v2();
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
            if (ConfigClearableEditText.this.C && f16 > ConfigClearableEditText.this.e()) {
                return 0;
            }
            return -1;
        }

        @Override // android.support.v4.widget.ExploreByTouchHelper
        protected void getVisibleVirtualViews(List<Integer> list) {
            if (ConfigClearableEditText.this.C) {
                list.add(0);
            }
        }

        @Override // android.support.v4.widget.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int i3, int i16, Bundle bundle) {
            if (QLog.isColorLevel()) {
                QLog.d("ConfigClearableEditTextHelper", 2, "onPerformActionForVirtualView virtualViewId:" + i3);
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
                accessibilityNodeInfoCompat.setContentDescription(az.g(R.string.kmp));
                accessibilityNodeInfoCompat.setClassName(Button.class.getName());
                accessibilityNodeInfoCompat.addAction(16);
                int e16 = ConfigClearableEditText.this.e();
                accessibilityNodeInfoCompat.setBoundsInParent(new Rect(e16, ConfigClearableEditText.this.getPaddingTop(), ConfigClearableEditText.this.f315559d.getIntrinsicWidth() + e16, ConfigClearableEditText.this.getHeight() - ConfigClearableEditText.this.getPaddingBottom()));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface d {
        void Af(boolean z16);

        void Mg(boolean z16);

        void v2();

        int w9();
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface e {
        void E0();
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface f {
    }

    public ConfigClearableEditText(Context context) {
        this(context, null, android.R.attr.editTextStyle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e() {
        int width;
        int intrinsicWidth;
        if (this.M != null) {
            width = getWidth();
            intrinsicWidth = this.M.w9();
        } else {
            width = getWidth() - getPaddingRight();
            intrinsicWidth = this.f315559d.getIntrinsicWidth();
        }
        return width - intrinsicWidth;
    }

    private void f(Context context, AttributeSet attributeSet) {
        this.f315562h = context.getResources().getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.M9);
        try {
            this.f315559d = obtainStyledAttributes.getDrawable(jj2.b.N9);
            this.f315560e = obtainStyledAttributes.getDimensionPixelSize(jj2.b.P9, -1);
            this.f315561f = obtainStyledAttributes.getDimensionPixelSize(jj2.b.O9, -1);
            this.E = obtainStyledAttributes.getBoolean(jj2.b.S9, false);
            this.F = obtainStyledAttributes.getBoolean(jj2.b.T9, false);
            this.G = obtainStyledAttributes.getBoolean(jj2.b.U9, false);
            this.H = obtainStyledAttributes.getBoolean(jj2.b.Q9, false);
            this.I = obtainStyledAttributes.getBoolean(jj2.b.V9, false);
            this.J = obtainStyledAttributes.getBoolean(jj2.b.W9, false);
            this.K = obtainStyledAttributes.getBoolean(jj2.b.R9, false);
            obtainStyledAttributes.recycle();
            if (this.f315559d == null) {
                this.f315559d = getResources().getDrawable(R.drawable.cross);
            }
            Drawable drawable = this.f315559d;
            if (drawable != null) {
                if (this.f315560e == -1 || this.f315561f == -1) {
                    float f16 = this.f315562h;
                    this.f315560e = (int) (f16 * 19.0f);
                    this.f315561f = (int) (f16 * 19.0f);
                }
                drawable.setBounds(0, 0, this.f315560e, this.f315561f);
                setClearButtonVisible(false);
            }
            setOnTouchListener(new a());
            addTextChangedListener(new b());
        } catch (Throwable th5) {
            obtainStyledAttributes.recycle();
            throw th5;
        }
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        c cVar;
        if (this.C && motionEvent.getX() > e() && (cVar = this.f315564m) != null) {
            return cVar.dispatchHoverEvent(motionEvent);
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    protected boolean g() {
        return this.L;
    }

    public void h() {
        d dVar = this.M;
        if (dVar != null) {
            dVar.Mg(true);
        }
        if (getCompoundDrawables()[2] == null && (!this.C || this.M == null)) {
            return;
        }
        setText("");
        setClearButtonVisible(false);
        e eVar = this.f315563i;
        if (eVar != null) {
            eVar.E0();
        }
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
        if (QLog.isColorLevel() && QQUIAppSetting.isEnableAutoDumpLeak()) {
            StringBuilder sb5 = new StringBuilder(100);
            sb5.append("onDetachedFromWindow ");
            sb5.append(getContext().getClass().getSimpleName());
            sb5.append("@0x");
            sb5.append(Integer.toHexString(getContext().hashCode()));
            sb5.append(" ConfigClearableEditText@0x");
            sb5.append(Integer.toHexString(hashCode()));
            QLog.d("ConfigClearableEditText", 2, sb5.toString());
        }
        this.P = true;
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

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i3) {
        if (g()) {
            return super.onTextContextMenuItem(i3);
        }
        return !this.K;
    }

    public void setCanMultiLine(boolean z16) {
        this.D = z16;
    }

    public void setClearButtonStyle(int i3) {
        this.N = i3;
        if (i3 == 1) {
            setClearButtonVisible(false);
        } else if (i3 == 2) {
            setClearButtonVisible(true);
        }
    }

    public void setClearButtonVisible(boolean z16) {
        Drawable drawable;
        if (!z16 || this.N != 1) {
            if (!z16 && this.N == 2) {
                return;
            }
            if (z16) {
                drawable = this.f315559d;
            } else {
                drawable = null;
            }
            d dVar = this.M;
            if (dVar != null) {
                dVar.Af(z16);
                setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
            } else {
                setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], drawable, getCompoundDrawables()[3]);
            }
            if (this.C != z16 && QQUIAppSetting.enableTalkBack()) {
                AccessibilityUtil.m(this);
            }
            this.C = z16;
        }
    }

    @Override // android.widget.TextView
    public void setCursorVisible(boolean z16) {
        if (QLog.isColorLevel() && QQUIAppSetting.isEnableAutoDumpLeak() && this.P) {
            StringBuilder sb5 = new StringBuilder(100);
            sb5.append("setCursorVisible=");
            sb5.append(z16);
            sb5.append(" ");
            sb5.append(getContext().getClass().getSimpleName());
            sb5.append("@0x");
            sb5.append(Integer.toHexString(getContext().hashCode()));
            sb5.append(" ConfigClearableEditText@0x");
            sb5.append(Integer.toHexString(hashCode()));
            QLog.d("ConfigClearableEditText", 2, sb5.toString(), new Exception());
        }
        super.setCursorVisible(z16);
    }

    public void setCustomClearButtonCallback(d dVar) {
        this.M = dVar;
    }

    public void setNeedContextMenu(boolean z16) {
        this.L = z16;
    }

    public void setTextClearedListener(e eVar) {
        this.f315563i = eVar;
    }

    public ConfigClearableEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.R.attr.editTextStyle);
    }

    public ConfigClearableEditText(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = false;
        this.M = null;
        this.N = 0;
        this.P = false;
        try {
            f(context, attributeSet);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        if (QQUIAppSetting.enableTalkBack()) {
            c cVar = new c(this);
            this.f315564m = cVar;
            ViewCompat.setAccessibilityDelegate(this, cVar);
            ViewCompat.setImportantForAccessibility(this, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            String obj = ConfigClearableEditText.this.getText().toString();
            if (ConfigClearableEditText.this.isFocused()) {
                if (obj != null && obj.length() != 0) {
                    if (!ConfigClearableEditText.this.isSingleLine() && !ConfigClearableEditText.this.D) {
                        ConfigClearableEditText.this.setClearButtonVisible(false);
                        return;
                    } else {
                        ConfigClearableEditText.this.setClearButtonVisible(true);
                        return;
                    }
                }
                ConfigClearableEditText.this.setClearButtonVisible(false);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }

    public void setOnTextContextSelectListener(f fVar) {
    }
}
