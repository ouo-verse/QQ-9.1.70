package com.tencent.mobileqq.search.view;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.SoftKeyboardStateHelper;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes18.dex */
public class AutoHintLayout extends LinearLayout implements SoftKeyboardStateHelper.SoftKeyboardStateListener {
    private int C;
    private List<String> D;
    private List<String> E;
    private int F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;

    /* renamed from: d, reason: collision with root package name */
    private final com.tencent.mobileqq.search.view.b f285100d;

    /* renamed from: e, reason: collision with root package name */
    private AnimRunnable f285101e;

    /* renamed from: f, reason: collision with root package name */
    private final Collection<b> f285102f;

    /* renamed from: h, reason: collision with root package name */
    private EditText f285103h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f285104i;

    /* renamed from: m, reason: collision with root package name */
    private long f285105m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class AnimRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<AutoHintLayout> f285106d;

        public AnimRunnable(AutoHintLayout autoHintLayout) {
            this.f285106d = new WeakReference<>(autoHintLayout);
        }

        @Override // java.lang.Runnable
        public void run() {
            AutoHintLayout autoHintLayout = this.f285106d.get();
            if (autoHintLayout == null) {
                return;
            }
            if (autoHintLayout.h()) {
                autoHintLayout.v(true);
                autoHintLayout.postDelayed(this, autoHintLayout.f285105m + autoHintLayout.C);
            } else {
                autoHintLayout.t();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface b {
        void onHintChange(int i3, String str, String str2);
    }

    public AutoHintLayout(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        if (!this.K && this.J && !this.f285103h.isCursorVisible()) {
            return true;
        }
        return false;
    }

    private boolean j() {
        EditText editText = this.f285103h;
        if (editText != null && TextUtils.isEmpty(editText.getText().toString())) {
            return true;
        }
        return false;
    }

    private boolean k() {
        List<String> list = this.D;
        if (list != null && !list.isEmpty() && this.F < this.D.size()) {
            return true;
        }
        return false;
    }

    private void l() {
        String str;
        for (b bVar : this.f285102f) {
            List<String> list = this.E;
            if (list != null && this.F < list.size()) {
                str = this.E.get(this.F);
            } else {
                str = null;
            }
            int i3 = this.F;
            bVar.onHintChange(i3, this.D.get(i3), str);
        }
    }

    private void o(EditText editText) {
        this.f285103h = editText;
        this.f285100d.q(editText.getHintTextColors());
        this.f285100d.r(this.f285103h.getTextSize());
        this.f285100d.t(this.f285103h.getTypeface());
        this.f285100d.n(this.f285103h.getGravity());
        this.f285100d.j(this.C);
        this.f285103h.addTextChangedListener(new a());
    }

    private void p(String str, boolean z16) {
        this.f285100d.p(str, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (!this.G && !this.I) {
            if (this.f285101e == null) {
                this.f285101e = new AnimRunnable(this);
            }
            this.G = true;
            postDelayed(this.f285101e, this.f285105m);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.G) {
            removeCallbacks(this.f285101e);
            this.G = false;
            this.f285101e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z16) {
        String str = this.D.get(this.F);
        if (QLog.isDebugVersion()) {
            QLog.d("AutoHintLayout", 1, "[updateHint] hintText = " + str + ", anim = " + z16);
        } else {
            QLog.d("AutoHintLayout", 1, "[updateHint] mPos = " + this.F + ", anim = " + z16);
        }
        p(str, z16);
        l();
        int i3 = this.F + 1;
        this.F = i3;
        if (i3 >= this.D.size()) {
            this.F = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        boolean z16;
        if (k() && j()) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.J = z16;
        this.f285100d.s(z16);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i3, layoutParams);
        if (view instanceof EditText) {
            o((EditText) view);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.f285100d.d(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.f285104i) {
            return;
        }
        this.f285104i = true;
        super.drawableStateChanged();
        this.f285100d.l(getDrawableState());
        this.f285104i = false;
    }

    public String i() {
        return this.f285100d.f();
    }

    public void m(b bVar) {
        if (bVar != null && !this.f285102f.contains(bVar)) {
            this.f285102f.add(bVar);
        }
    }

    public void n() {
        if (this.f285103h == null) {
            return;
        }
        setHintList(null);
        this.f285103h.setHint(R.string.h_a);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.I = false;
        if (this.H) {
            r();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.I = true;
        t();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (this.f285103h != null) {
            Rect rect = new Rect();
            int i19 = 0;
            rect.set(0, 0, this.f285103h.getWidth(), this.f285103h.getHeight());
            offsetDescendantRectToMyCoords(this.f285103h, rect);
            int i26 = rect.left;
            if (i26 < 0) {
                i19 = Math.abs(i26);
            }
            this.f285100d.o(rect.left + this.f285103h.getCompoundPaddingLeft() + i19, rect.top + this.f285103h.getCompoundPaddingTop(), (rect.right - this.f285103h.getCompoundPaddingRight()) + i19, rect.bottom - this.f285103h.getCompoundPaddingBottom());
        }
    }

    @Override // com.tencent.mobileqq.widget.SoftKeyboardStateHelper.SoftKeyboardStateListener
    public void onSoftKeyboardClosed() {
        if (this.H) {
            r();
        }
    }

    @Override // com.tencent.mobileqq.widget.SoftKeyboardStateHelper.SoftKeyboardStateListener
    public void onSoftKeyboardOpened(int i3) {
        t();
    }

    public void q() {
        this.H = true;
        r();
    }

    public void s() {
        this.H = false;
        t();
    }

    public void setAnimDuration(int i3) {
        if (i3 > 0) {
            this.C = i3;
            this.f285100d.j(i3);
        }
    }

    public void setAnimInterpolator(TimeInterpolator timeInterpolator) {
        this.f285100d.k(timeInterpolator);
    }

    public void setEnableFrondIconRunInAnim(boolean z16, QUISearchBar qUISearchBar) {
        if (z16) {
            if (qUISearchBar == null) {
                QLog.i("AutoHintLayout", 1, "setEnableFrondIconRunInAnim  searchBar == null  config fail");
                return;
            }
            Drawable searchIcon = qUISearchBar.getCustomResource().getSearchIcon(qUISearchBar);
            int dpToPx = ViewUtils.dpToPx(18.0f);
            searchIcon.setBounds(0, 0, dpToPx, dpToPx);
            this.f285100d.m(searchIcon);
            return;
        }
        this.f285100d.m(null);
    }

    public void setHintHelperGravity(int i3) {
        this.f285100d.n(i3);
    }

    public void setHintList(List<String> list) {
        boolean z16 = true;
        if (list == null) {
            QLog.d("AutoHintLayout", 1, "[setHintList] empty list");
        } else {
            QLog.d("AutoHintLayout", 1, "[setHintList] hintList length = " + list.size());
        }
        this.D = list;
        this.F = 0;
        if (this.f285103h == null) {
            return;
        }
        if (k()) {
            if (this.D.size() != 1) {
                z16 = false;
            }
            this.K = z16;
            this.f285103h.setHint("");
            w();
            v(false);
            q();
            return;
        }
        w();
    }

    public void setInterval(long j3) {
        if (j3 > 0) {
            this.f285105m = j3;
        }
    }

    public void setReportDataList(List<String> list) {
        this.E = list;
    }

    public void u(b bVar) {
        if (bVar != null) {
            this.f285102f.remove(bVar);
        }
    }

    public void x(int i3, int i16, QUISearchBar qUISearchBar) {
        if (this.f285100d.g()) {
            setEnableFrondIconRunInAnim(true, qUISearchBar);
        }
    }

    public AutoHintLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f285102f = new ArraySet();
        this.f285105m = 3000L;
        this.C = 500;
        setWillNotDraw(false);
        this.f285100d = new com.tencent.mobileqq.search.view.b(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AutoHintLayout.this.w();
            AutoHintLayout.this.r();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
