package com.tencent.mm.plugin.appbrand.widget.sms;

import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.AppCompatEditText;
import com.tencent.luggage.wxa.tl.b;

/* compiled from: P */
/* loaded from: classes9.dex */
public class VerifyCodeEditText extends AppCompatEditText implements b {
    public VerifyCodeEditText(Context context) {
        super(context);
    }

    @Override // com.tencent.luggage.wxa.tl.b
    public InputConnection a() {
        return super.onCreateInputConnection(new EditorInfo());
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return null;
    }

    public VerifyCodeEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VerifyCodeEditText(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
