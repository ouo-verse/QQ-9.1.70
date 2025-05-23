package bl2;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class a implements TextWatcher {

    /* renamed from: d, reason: collision with root package name */
    protected EditText f28605d;

    public a(EditText editText) {
        this.f28605d = editText;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
    }
}
