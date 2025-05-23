package com.tencent.mobileqq.guild.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.guild.util.cb;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
@RequiresApi(api = 21)
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes14.dex */
public class CharacterCountEditText extends EditText {

    /* renamed from: d, reason: collision with root package name */
    private TextWatcher f235781d;

    /* renamed from: e, reason: collision with root package name */
    private int f235782e;

    /* renamed from: f, reason: collision with root package name */
    private c f235783f;

    /* renamed from: h, reason: collision with root package name */
    private int f235784h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a extends Editable.Factory {
        a() {
        }

        @Override // android.text.Editable.Factory
        public Editable newEditable(CharSequence charSequence) {
            if (charSequence instanceof QQTextBuilder) {
                return (Editable) charSequence;
            }
            return new QQTextBuilder(charSequence, 2, 20);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface c {
        void Bf(cb.b bVar);

        void s7(cb.b bVar);
    }

    public CharacterCountEditText(Context context) {
        this(context, null, R.attr.editTextStyle, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(cb.b bVar) {
        if (this.f235784h == 1) {
            return bVar.c();
        }
        return bVar.a();
    }

    private void f() {
        setEditableFactory(new a());
        b bVar = new b();
        this.f235781d = bVar;
        addTextChangedListener(bVar);
    }

    public void setCountChangeListener(c cVar) {
        this.f235783f = cVar;
    }

    public void setLimitCount(int i3) {
        this.f235782e = i3;
    }

    @Override // android.widget.EditText
    public void setSelection(int i3) {
        if (i3 > getText().length()) {
            i3 = getText().length();
        }
        super.setSelection(i3);
    }

    public CharacterCountEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle, 0);
    }

    public CharacterCountEditText(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public CharacterCountEditText(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.f235782e = Integer.MAX_VALUE;
        this.f235784h = 0;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, up1.a.f439415a0);
            this.f235784h = obtainStyledAttributes.getInt(up1.a.f439429b0, 0);
            obtainStyledAttributes.recycle();
        }
        f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b implements TextWatcher {

        /* renamed from: d, reason: collision with root package name */
        private cb.b f235786d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f235787e = false;

        /* renamed from: f, reason: collision with root package name */
        private int f235788f = 0;

        /* renamed from: h, reason: collision with root package name */
        private int f235789h = 0;

        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (QLog.isDevelopLevel()) {
                QLog.d("CharacterCountEditText", 4, "afterTextChanged : " + editable.toString() + ", s hash: " + editable.hashCode(), "shouldLimit: ", Boolean.valueOf(this.f235787e));
                if (this.f235787e) {
                    QLog.d("CharacterCountEditText", 4, "afterText, start: ", Integer.valueOf(this.f235788f), " end: ", Integer.valueOf(this.f235789h));
                    QLog.d("CharacterCountEditText", 4, "afterText, ", editable.subSequence(0, this.f235788f), " + ", editable.subSequence(this.f235789h, editable.length()));
                }
            }
            if (this.f235787e) {
                editable.replace(this.f235788f, this.f235789h, "");
                this.f235787e = false;
                this.f235786d = cb.b(editable);
            }
            if (CharacterCountEditText.this.f235783f != null) {
                CharacterCountEditText.this.f235783f.s7(this.f235786d);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            cb.b b16 = cb.b(charSequence);
            this.f235786d = b16;
            if (CharacterCountEditText.this.e(b16) <= CharacterCountEditText.this.f235782e) {
                this.f235787e = false;
                return;
            }
            int i18 = i17 + i3;
            float e16 = CharacterCountEditText.this.f235782e - (CharacterCountEditText.this.e(this.f235786d) - CharacterCountEditText.this.e(cb.b(charSequence.subSequence(i3, i18))));
            if (e16 >= 0.0f) {
                this.f235788f = cb.a(charSequence, i3, e16, CharacterCountEditText.this.f235784h);
                this.f235789h = i18;
            } else {
                this.f235788f = cb.a(charSequence, 0, CharacterCountEditText.this.f235782e, CharacterCountEditText.this.f235784h);
                this.f235789h = charSequence.length();
            }
            this.f235787e = true;
            if (CharacterCountEditText.this.f235783f != null) {
                CharacterCountEditText.this.f235783f.Bf(this.f235786d);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
