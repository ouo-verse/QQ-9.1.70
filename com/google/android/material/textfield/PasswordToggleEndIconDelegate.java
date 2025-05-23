package com.google.android.material.textfield;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import com.google.android.material.internal.n;
import com.google.android.material.textfield.TextInputLayout;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class PasswordToggleEndIconDelegate extends d {

    /* renamed from: e, reason: collision with root package name */
    private final TextWatcher f34362e;

    /* renamed from: f, reason: collision with root package name */
    private final TextInputLayout.d f34363f;

    /* renamed from: g, reason: collision with root package name */
    private final TextInputLayout.e f34364g;

    /* loaded from: classes2.dex */
    class a extends n {
        a() {
        }

        @Override // com.google.android.material.internal.n, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            PasswordToggleEndIconDelegate.this.f34419c.setChecked(!r1.g());
        }
    }

    /* loaded from: classes2.dex */
    class b implements TextInputLayout.d {
        b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.d
        public void a(@NonNull TextInputLayout textInputLayout) {
            EditText L = textInputLayout.L();
            PasswordToggleEndIconDelegate.this.f34419c.setChecked(!r0.g());
            L.removeTextChangedListener(PasswordToggleEndIconDelegate.this.f34362e);
            L.addTextChangedListener(PasswordToggleEndIconDelegate.this.f34362e);
        }
    }

    /* loaded from: classes2.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            EditText L = PasswordToggleEndIconDelegate.this.f34417a.L();
            if (L != null) {
                int selectionEnd = L.getSelectionEnd();
                if (PasswordToggleEndIconDelegate.this.g()) {
                    L.setTransformationMethod(null);
                } else {
                    L.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                if (selectionEnd >= 0) {
                    L.setSelection(selectionEnd);
                }
                PasswordToggleEndIconDelegate.this.f34417a.o0();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PasswordToggleEndIconDelegate(@NonNull TextInputLayout textInputLayout, @DrawableRes int i3) {
        super(textInputLayout, i3);
        this.f34362e = new a();
        this.f34363f = new b();
        this.f34364g = new TextInputLayout.e() { // from class: com.google.android.material.textfield.PasswordToggleEndIconDelegate.3
            @Override // com.google.android.material.textfield.TextInputLayout.e
            public void a(@NonNull TextInputLayout textInputLayout2, int i16) {
                final EditText L = textInputLayout2.L();
                if (L != null && i16 == 1) {
                    L.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    L.post(new Runnable() { // from class: com.google.android.material.textfield.PasswordToggleEndIconDelegate.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            L.removeTextChangedListener(PasswordToggleEndIconDelegate.this.f34362e);
                        }
                    });
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        EditText L = this.f34417a.L();
        if (L != null && (L.getTransformationMethod() instanceof PasswordTransformationMethod)) {
            return true;
        }
        return false;
    }

    private static boolean h(EditText editText) {
        if (editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.d
    public void a() {
        TextInputLayout textInputLayout = this.f34417a;
        int i3 = this.f34420d;
        if (i3 == 0) {
            i3 = R.drawable.jko;
        }
        textInputLayout.setEndIconDrawable(i3);
        TextInputLayout textInputLayout2 = this.f34417a;
        textInputLayout2.setEndIconContentDescription(textInputLayout2.getResources().getText(R.string.f173322su));
        this.f34417a.setEndIconVisible(true);
        this.f34417a.setEndIconCheckable(true);
        this.f34417a.setEndIconOnClickListener(new c());
        this.f34417a.g(this.f34363f);
        this.f34417a.h(this.f34364g);
        EditText L = this.f34417a.L();
        if (h(L)) {
            L.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
