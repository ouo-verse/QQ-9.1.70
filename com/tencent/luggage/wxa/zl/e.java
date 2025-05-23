package com.tencent.luggage.wxa.zl;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.widget.EditText;
import android.widget.NumberPicker;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class e {

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a extends Editable.Factory {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.zl.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C6992a extends SpannableStringBuilder {
            public C6992a(CharSequence charSequence) {
                super(charSequence);
            }

            @Override // android.text.SpannableStringBuilder, android.text.Spannable
            public void setSpan(Object obj, int i3, int i16, int i17) {
                try {
                    super.setSpan(obj, i3, i16, i17);
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.text.Editable.Factory
        public Editable newEditable(CharSequence charSequence) {
            return new C6992a(charSequence);
        }
    }

    public static void a(NumberPicker numberPicker) {
        if (numberPicker == null) {
            return;
        }
        try {
            EditText editText = (EditText) new com.tencent.luggage.wxa.u9.b(numberPicker, "mInputText", null).a();
            if (editText != null) {
                editText.setEditableFactory(new a());
            }
        } catch (Exception unused) {
        }
    }
}
