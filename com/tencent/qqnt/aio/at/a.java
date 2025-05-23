package com.tencent.qqnt.aio.at;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqnt.aio.at.c;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public class a extends c {
    static IPatchRedirector $redirector_;

    public a(Context context, String str, String str2, String str3, int i3, Paint paint, String str4, int i16) {
        super(context, str, str2, str3, i3, paint, str4, i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, str2, str3, Integer.valueOf(i3), paint, str4, Integer.valueOf(i16));
        }
    }

    public static SpannableString q(Context context, String str, String str2, String str3, String str4, EditText editText, int i3, boolean z16) {
        return r(context, str, str2, str3, str4, editText, i3, z16, true);
    }

    public static SpannableString r(Context context, String str, String str2, String str3, String str4, EditText editText, int i3, boolean z16, boolean z17) {
        int i16;
        a aVar;
        String str5;
        if (context == null || TextUtils.isEmpty(str) || editText == null) {
            return null;
        }
        if (editText.getPaint() != null) {
            editText.getPaint().setColor(context.getResources().getColor(s()));
        }
        int width = (editText.getWidth() - editText.getPaddingLeft()) - editText.getPaddingRight();
        if (z16) {
            i16 = 0;
        } else {
            i16 = i3;
        }
        try {
            aVar = new a(context, str, str2, str3, width, editText.getPaint(), str4, i16);
        } catch (OutOfMemoryError unused) {
            aVar = null;
        }
        if (aVar == null) {
            return null;
        }
        String replaceAll = c.o(aVar.f349475f).replaceAll("[\r\n]", " ");
        if (z17) {
            str5 = replaceAll + " ";
        } else {
            str5 = replaceAll;
        }
        SpannableString spannableString = new SpannableString(str5);
        spannableString.setSpan(aVar, 0, replaceAll.length(), 33);
        aVar.F = spannableString.length();
        return spannableString;
    }

    private static int s() {
        if (QQTheme.isVasTheme()) {
            return R.color.skin_input_theme_version2;
        }
        return R.color.qui_common_text_primary;
    }

    @Override // com.tencent.qqnt.aio.at.c
    protected List<c.b> b(Paint paint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) paint);
        }
        List<c.b> c16 = c.c(this.f349478m, this.f349475f, paint, this.L);
        this.f349477i = c.n(c16, paint, new Rect());
        return c16;
    }
}
