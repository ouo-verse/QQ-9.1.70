package com.tencent.mobileqq.activity.book;

import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.AttributeSet;
import android.widget.EditText;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.UnsupportedEncodingException;

/* compiled from: P */
/* loaded from: classes10.dex */
public class BookEditText extends EditText {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private int f180608d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f180609e;

    /* renamed from: f, reason: collision with root package name */
    private InputFilter[] f180610f;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements InputFilter {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BookEditText.this);
            }
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CharSequence) iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), spanned, Integer.valueOf(i17), Integer.valueOf(i18));
            }
            BookEditText.this.b(spanned.toString());
            if (BookEditText.this.b(charSequence.toString()) == 0) {
                int unused = BookEditText.this.f180608d;
            } else if (QQEmojiUtil.containsEmoji(charSequence.toString())) {
                return "";
            }
            return charSequence.subSequence(i3, i16 - i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface b {
    }

    public BookEditText(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public int b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).intValue();
        }
        if (str == null) {
            return 0;
        }
        try {
            return str.getBytes("utf8").length;
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            return str.getBytes().length;
        }
    }

    public void setCanInputWhenLenghtLimit(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.f180609e = z16;
        }
    }

    public void setInputListener(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bVar);
        }
    }

    public void setTextLengthLimit(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.f180608d = i3;
        }
    }

    public BookEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f180608d = 80;
        this.f180609e = false;
        this.f180610f = new InputFilter[]{new a()};
        setInputType(131072);
        setSingleLine(false);
        setHorizontallyScrolling(false);
        setFilters(this.f180610f);
    }
}
