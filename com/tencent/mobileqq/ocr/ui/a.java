package com.tencent.mobileqq.ocr.ui;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public List<String> f254831a;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ocr.ui.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    class C8174a implements Comparator<String> {
        static IPatchRedirector $redirector_;

        C8174a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2)).intValue();
            }
            if (str != null && str2 != null) {
                return str2.length() - str.length();
            }
            return 0;
        }
    }

    public a(List<String> list, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list, (Object) str);
            return;
        }
        list = list == null ? new ArrayList<>() : list;
        if (str != null && !list.contains(str)) {
            list.add(str);
        }
        Collections.sort(list, new C8174a());
        this.f254831a = list;
    }

    public static String c(String str) {
        return Pattern.compile("[\\s|\\t|\\r|\\n]+").matcher(str).replaceAll("");
    }

    public SpannableString a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SpannableString) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        return b(str, false);
    }

    public SpannableString b(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SpannableString) iPatchRedirector.redirect((short) 4, this, str, Boolean.valueOf(z16));
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        List<String> list = this.f254831a;
        if (list != null && list.size() > 0) {
            boolean z17 = false;
            boolean z18 = false;
            for (Object obj : this.f254831a.toArray()) {
                String str2 = (String) obj;
                if (str2.length() <= 1 && z17) {
                    break;
                }
                int i3 = 0;
                while (true) {
                    int d16 = d(str, str2, i3);
                    if (d16 == -1) {
                        break;
                    }
                    if (d16 > 10 && !z18 && !z16) {
                        str = "\u2026" + str.substring(d16 - 6);
                        spannableString = new SpannableString(str);
                        d16 = 7;
                        z18 = true;
                    }
                    if (str2.length() > 1) {
                        z17 = true;
                        z18 = true;
                    }
                    spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#12b7f5")), d16, str2.length() + d16, 34);
                    i3 = d16 + 1;
                }
            }
        }
        return spannableString;
    }

    public int d(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, str, str2, Integer.valueOf(i3))).intValue();
        }
        if (str != null && str2 != null) {
            return str.toLowerCase().indexOf(str2.toLowerCase(), i3);
        }
        return -1;
    }
}
