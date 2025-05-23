package com.qzone.widget;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.regex.Matcher;

/* compiled from: P */
/* loaded from: classes37.dex */
public class UrlExtendEditText extends ExtendEditText {
    protected boolean Q;
    protected boolean R;
    b S;
    protected a T;
    private int U;
    private int V;
    private int W;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f60689a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f60690b0;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface a {
        void a(String str, int i3, int i16);
    }

    public UrlExtendEditText(Context context) {
        this(context, null);
    }

    public void setInputUrlListener(a aVar) {
        this.T = aVar;
    }

    public void setUrlEnabled(boolean z16) {
        this.Q = z16;
    }

    public void setUrlState(int i3) {
        this.W = i3;
        if (i3 == 0) {
            this.f60690b0 = false;
            this.R = false;
        }
    }

    public String w(CharSequence charSequence) {
        String[] strArr = {"http://", "https://", "rtsp://"};
        ArrayList arrayList = new ArrayList();
        Matcher matcher = x8.l.f447417j.matcher(charSequence);
        String str = "";
        while (matcher.find()) {
            this.U = matcher.start();
            int end = matcher.end();
            this.V = end;
            Linkify.MatchFilter matchFilter = Linkify.sUrlMatchFilter;
            if (matchFilter == null || matchFilter.acceptMatch(charSequence, this.U, end)) {
                str = matcher.group();
                arrayList.add(str);
            }
        }
        int size = arrayList.size();
        boolean z16 = true;
        if (size != 1) {
            return "";
        }
        int i3 = 0;
        while (true) {
            if (i3 >= 3) {
                z16 = false;
                break;
            }
            String str2 = strArr[i3];
            if (str.regionMatches(true, 0, str2, 0, str2.length())) {
                String str3 = strArr[i3];
                if (!str.regionMatches(false, 0, str3, 0, str3.length())) {
                    str = strArr[i3] + str.substring(strArr[i3].length());
                }
            } else {
                i3++;
            }
        }
        if (z16) {
            return str;
        }
        return strArr[0] + str;
    }

    public boolean x(String str, String str2) {
        if (this.f60689a0) {
            this.f60689a0 = false;
            return false;
        }
        try {
            String substring = getText().toString().substring(0, this.U);
            SpannableString spannableString = new SpannableString(substring + str + " " + str2 + "" + getText().toString().substring(this.V));
            URLSpan uRLSpan = new URLSpan(substring);
            int i3 = this.U;
            spannableString.setSpan(uRLSpan, i3, str.length() + i3, 33);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(-16776961);
            int i16 = this.U;
            spannableString.setSpan(foregroundColorSpan, i16, str.length() + i16, 33);
            setText(spannableString);
            setSelection(spannableString.length());
            this.W = 2;
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public UrlExtendEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Q = true;
        this.R = false;
        b bVar = new b();
        this.S = bVar;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.f60689a0 = false;
        this.f60690b0 = false;
        addTextChangedListener(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String str, String str2) {
        this.f60690b0 = false;
        this.R = false;
        this.W = 1;
        this.T.a(str2, this.U, this.V);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean performLongClick() {
        this.R = true;
        return super.performLongClick();
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            if (charSequence == null) {
                return;
            }
            int i18 = UrlExtendEditText.this.W;
            if (i18 != 0) {
                if (i18 != 1) {
                    return;
                }
                if (i3 + i16 > UrlExtendEditText.this.U) {
                    if (i3 < UrlExtendEditText.this.V) {
                        UrlExtendEditText.this.f60689a0 = true;
                        return;
                    }
                    return;
                } else {
                    int i19 = i17 - i16;
                    UrlExtendEditText.this.U += i19;
                    UrlExtendEditText.this.V += i19;
                    return;
                }
            }
            UrlExtendEditText urlExtendEditText = UrlExtendEditText.this;
            if (urlExtendEditText.T == null || !urlExtendEditText.Q) {
                return;
            }
            String w3 = urlExtendEditText.w(charSequence);
            if (!TextUtils.isEmpty(w3)) {
                if (UrlExtendEditText.this.f60690b0) {
                    UrlExtendEditText.this.v(charSequence.toString(), w3);
                    return;
                }
                UrlExtendEditText urlExtendEditText2 = UrlExtendEditText.this;
                if (urlExtendEditText2.R) {
                    if (i17 >= 1) {
                        urlExtendEditText2.v(charSequence.toString(), w3);
                        return;
                    } else {
                        urlExtendEditText2.R = false;
                        return;
                    }
                }
                if (i17 == 1 && i16 == 0) {
                    String substring = charSequence.toString().substring(i3, i3 + 1);
                    if (substring.equals(" ") || substring.equals("\n")) {
                        UrlExtendEditText.this.v(charSequence.toString(), w3);
                        return;
                    }
                    return;
                }
                return;
            }
            UrlExtendEditText.this.f60690b0 = false;
            UrlExtendEditText.this.R = false;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i3) {
        if (i3 == 16908322) {
            this.f60690b0 = true;
        }
        return super.onTextContextMenuItem(i3);
    }
}
