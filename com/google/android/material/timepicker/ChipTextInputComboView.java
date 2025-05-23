package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.n;
import com.google.android.material.textfield.TextInputLayout;
import com.tencent.mobileqq.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* renamed from: d, reason: collision with root package name */
    private final Chip f34454d;

    /* renamed from: e, reason: collision with root package name */
    private final TextInputLayout f34455e;

    /* renamed from: f, reason: collision with root package name */
    private final EditText f34456f;

    /* renamed from: h, reason: collision with root package name */
    private TextWatcher f34457h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f34458i;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private class b extends n {
        b() {
        }

        @Override // com.google.android.material.internal.n, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView.this.f34454d.setText(ChipTextInputComboView.this.c("00"));
            } else {
                ChipTextInputComboView.this.f34454d.setText(ChipTextInputComboView.this.c(editable));
            }
        }
    }

    public ChipTextInputComboView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(CharSequence charSequence) {
        return TimeModel.a(getResources(), charSequence);
    }

    private void d() {
        LocaleList locales;
        if (Build.VERSION.SDK_INT >= 24) {
            locales = getContext().getResources().getConfiguration().getLocales();
            this.f34456f.setImeHintLocales(locales);
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f34454d.isChecked();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        d();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z16) {
        int i3;
        this.f34454d.setChecked(z16);
        EditText editText = this.f34456f;
        int i16 = 0;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        editText.setVisibility(i3);
        Chip chip = this.f34454d;
        if (z16) {
            i16 = 8;
        }
        chip.setVisibility(i16);
        if (isChecked()) {
            ViewUtils.l(this.f34456f);
            if (!TextUtils.isEmpty(this.f34456f.getText())) {
                EditText editText2 = this.f34456f;
                editText2.setSelection(editText2.getText().length());
            }
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.f34454d.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setTag(int i3, Object obj) {
        this.f34454d.setTag(i3, obj);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.f34454d.toggle();
    }

    public ChipTextInputComboView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        LayoutInflater from = LayoutInflater.from(context);
        Chip chip = (Chip) from.inflate(R.layout.f168262fh3, (ViewGroup) this, false);
        this.f34454d = chip;
        chip.setAccessibilityClassName("android.view.View");
        TextInputLayout textInputLayout = (TextInputLayout) from.inflate(R.layout.f168263fh4, (ViewGroup) this, false);
        this.f34455e = textInputLayout;
        EditText L = textInputLayout.L();
        this.f34456f = L;
        L.setVisibility(4);
        b bVar = new b();
        this.f34457h = bVar;
        L.addTextChangedListener(bVar);
        d();
        addView(chip);
        addView(textInputLayout);
        this.f34458i = (TextView) findViewById(R.id.yyi);
        L.setSaveEnabled(false);
        L.setLongClickable(false);
    }
}
