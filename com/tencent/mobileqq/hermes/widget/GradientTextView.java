package com.tencent.mobileqq.hermes.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes8.dex */
public class GradientTextView extends AppCompatTextView {
    static IPatchRedirector $redirector_;

    public GradientTextView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        getPaint().setShader(new LinearGradient(0.0f, 0.0f, getWidth(), getHeight(), new int[]{Color.parseColor("#FFE249"), Color.parseColor("#FF826D"), Color.parseColor("#D75AFF"), Color.parseColor("#0070FF"), Color.parseColor("#009CFF"), Color.parseColor("#5BD4FF")}, new float[]{-0.0789f, 0.0124f, 0.1303f, 0.4142f, 0.7136f, 1.1028f}, Shader.TileMode.CLAMP));
    }

    public GradientTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public GradientTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
