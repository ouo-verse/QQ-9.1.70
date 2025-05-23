package com.tencent.luggage.game.widget.input;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.annotation.IntRange;
import com.tencent.luggage.wxa.ol.k0;
import com.tencent.mobileqq.R;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes2.dex */
public class WAGamePanelInputEditText extends EditText {

    /* renamed from: a, reason: collision with root package name */
    public final k0 f119962a;

    /* renamed from: b, reason: collision with root package name */
    public final InputFilter f119963b;

    /* renamed from: c, reason: collision with root package name */
    public int f119964c;

    /* renamed from: d, reason: collision with root package name */
    public final Spannable.Factory f119965d;

    /* loaded from: classes2.dex */
    public class a extends Editable.Factory {
        public a() {
        }

        @Override // android.text.Editable.Factory
        public Editable newEditable(CharSequence charSequence) {
            return WAGamePanelInputEditText.this.f119962a.a((Editable) WAGamePanelInputEditText.this.a(super.newEditable(charSequence)));
        }
    }

    /* loaded from: classes2.dex */
    public class b implements InputFilter {
        public b() {
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
            Spannable spannableStringBuilder;
            if (TextUtils.isEmpty(charSequence)) {
                return null;
            }
            if (charSequence instanceof Spannable) {
                spannableStringBuilder = (Spannable) charSequence;
            } else {
                spannableStringBuilder = new SpannableStringBuilder(charSequence.subSequence(i3, i16));
            }
            return WAGamePanelInputEditText.this.a(spannableStringBuilder);
        }
    }

    /* loaded from: classes2.dex */
    public class c extends Spannable.Factory {
        public c() {
        }

        @Override // android.text.Spannable.Factory
        public Spannable newSpannable(CharSequence charSequence) {
            return new SpannableStringBuilder(charSequence);
        }
    }

    public WAGamePanelInputEditText(Context context) {
        this(context, null);
    }

    public int getMaxLength() {
        return this.f119964c;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        editorInfo.imeOptions |= 268435456;
        return onCreateInputConnection;
    }

    public void setComposingDismissedListener(com.tencent.luggage.wxa.sl.b bVar) {
        this.f119962a.a(bVar);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        if (this.f119963b != null) {
            int i3 = 0;
            if (inputFilterArr == null) {
                inputFilterArr = new InputFilter[0];
            }
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length + 1];
            while (i3 < inputFilterArr.length) {
                inputFilterArr2[i3] = inputFilterArr[i3];
                i3++;
            }
            inputFilterArr2[i3] = this.f119963b;
            inputFilterArr = inputFilterArr2;
        }
        super.setFilters(inputFilterArr);
    }

    public void setMaxLength(@IntRange(from = 1, to = 2147483647L) int i3) {
        this.f119964c = i3;
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z16) {
        int maxHeight = getMaxHeight();
        super.setSingleLine(z16);
        if (maxHeight > 0) {
            setMaxHeight(maxHeight);
        }
    }

    public WAGamePanelInputEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.ada);
    }

    public WAGamePanelInputEditText(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        b bVar = new b();
        this.f119963b = bVar;
        this.f119964c = Integer.MAX_VALUE;
        this.f119965d = new c();
        this.f119962a = new k0(this);
        super.setEditableFactory(new a());
        super.setFilters(new InputFilter[]{bVar});
    }

    public final Spannable a(Spannable spannable) {
        com.tencent.luggage.wxa.dn.c cVar = new com.tencent.luggage.wxa.dn.c();
        cVar.f124397a = this.f119964c;
        return com.tencent.luggage.wxa.ql.a.a().a(getContext(), spannable, Math.round(getTextSize()), cVar, this.f119965d);
    }
}
