package bl2;

import android.widget.EditText;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class e extends a {

    /* renamed from: e, reason: collision with root package name */
    private int f28623e;

    public e(EditText editText) {
        super(editText);
        this.f28623e = 2;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        if (charSequence.toString().contains(".") && (charSequence.length() - 1) - charSequence.toString().indexOf(".") > this.f28623e) {
            charSequence = charSequence.toString().subSequence(0, charSequence.toString().indexOf(".") + this.f28623e + 1);
            this.f28605d.setText(charSequence);
            try {
                this.f28605d.setSelection(charSequence.length());
            } catch (IndexOutOfBoundsException e16) {
                QLog.e("MoneyWatcher", 1, "set selection error :", e16);
            }
        }
        if (charSequence.toString().trim().equals(".")) {
            charSequence = "0" + ((Object) charSequence);
            this.f28605d.setText(charSequence);
            this.f28605d.setSelection(2);
        }
        if (charSequence.toString().startsWith("0") && charSequence.toString().trim().length() > 1 && charSequence.toString().charAt(1) != '.') {
            CharSequence subSequence = charSequence.subSequence(1, charSequence.length());
            this.f28605d.setText(subSequence);
            try {
                this.f28605d.setSelection(subSequence.length());
            } catch (IndexOutOfBoundsException e17) {
                QLog.e("MoneyWatcher", 1, "set selection error :", e17);
            }
        }
    }
}
