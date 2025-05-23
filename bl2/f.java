package bl2;

import android.widget.EditText;

/* compiled from: P */
/* loaded from: classes16.dex */
public class f extends a {
    public f(EditText editText) {
        super(editText);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        String charSequence2 = charSequence.toString();
        if (charSequence2.startsWith("0") && charSequence2.trim().length() > 1) {
            String substring = charSequence2.substring(1);
            this.f28605d.setText(substring);
            this.f28605d.setSelection(substring.length());
        }
    }
}
