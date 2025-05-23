package com.tencent.mobileqq.rely;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class SingleLineHotwordTextView extends TextView {
    static IPatchRedirector $redirector_;
    public static final HashMap<String, SpannableString> F;
    private int C;
    protected String D;
    protected String E;

    /* renamed from: d, reason: collision with root package name */
    public String f280843d;

    /* renamed from: e, reason: collision with root package name */
    public String f280844e;

    /* renamed from: f, reason: collision with root package name */
    public int f280845f;

    /* renamed from: h, reason: collision with root package name */
    public int f280846h;

    /* renamed from: i, reason: collision with root package name */
    public int f280847i;

    /* renamed from: m, reason: collision with root package name */
    private ArrayList<String> f280848m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24270);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            F = new HashMap<>();
        }
    }

    public SingleLineHotwordTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f280843d = null;
        this.f280844e = null;
        this.f280845f = Integer.MAX_VALUE;
        this.f280846h = 0;
        this.f280847i = -1;
        this.f280848m = null;
        this.C = -97212;
        this.D = "";
        this.E = "";
        setSingleLine();
    }

    protected static String a(String str, ArrayList<String> arrayList) {
        StringBuilder sb5 = new StringBuilder("key=[");
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                String str2 = arrayList.get(i3);
                if (!TextUtils.isEmpty(str2)) {
                    str2 = str2.toLowerCase();
                }
                sb5.append(str2);
                if (i3 != size - 1) {
                    sb5.append("|");
                } else {
                    sb5.append("]");
                }
            }
        }
        sb5.append("&&text=[");
        sb5.append(str);
        sb5.append("]");
        return sb5.toString().toLowerCase();
    }

    public static SpannableString b(String str, ArrayList<String> arrayList, int i3) {
        int indexOf;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        if (h(arrayList)) {
            return spannableString;
        }
        String lowerCase = spannableString.toString().toLowerCase();
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            String str2 = arrayList.get(i16);
            if (!TextUtils.isEmpty(str2) && (indexOf = lowerCase.indexOf(str2.toLowerCase())) > -1) {
                spannableString.setSpan(new ForegroundColorSpan(i3), indexOf, str2.length() + indexOf, 33);
            }
        }
        return spannableString;
    }

    public static String c(int i3, String str, String str2, int i16, TextPaint textPaint, String str3) {
        int i17;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            StringBuilder sb5 = new StringBuilder(str);
            if (!TextUtils.isEmpty(str3)) {
                sb5.append(".");
                sb5.append(str3);
            }
            String sb6 = sb5.toString();
            int indexOf = sb6.toLowerCase().indexOf(str2.toLowerCase());
            if (indexOf == -1) {
                return sb6;
            }
            int length = sb6.length();
            float[] fArr = new float[length];
            int i18 = 0;
            textPaint.getTextWidths(sb6, 0, length, fArr);
            if (i3 == 2) {
                String str4 = "." + str3;
                if (!TextUtils.isEmpty(str3)) {
                    sb6 = sb6.substring(0, sb6.lastIndexOf(str4));
                    i17 = (int) (0 + textPaint.measureText(str4));
                } else {
                    i17 = 0;
                }
                int measureText = (int) (i17 + textPaint.measureText("\u2026"));
                int i19 = 0;
                while (true) {
                    if (i19 >= length) {
                        break;
                    }
                    measureText = (int) (measureText + fArr[i19]);
                    if (measureText > i16) {
                        length = i19;
                        break;
                    }
                    i19++;
                }
                String str5 = sb6.substring(0, length) + "\u2026";
                if (!TextUtils.isEmpty(str3)) {
                    return str5 + str4;
                }
                return str5;
            }
            boolean z16 = true;
            if (i3 == 1) {
                int measureText2 = (int) (0 + textPaint.measureText("\u2026"));
                int i26 = length - 1;
                while (true) {
                    if (i26 <= 0) {
                        break;
                    }
                    measureText2 = (int) (measureText2 + fArr[i26]);
                    if (measureText2 > i16) {
                        i18 = i26 + 1;
                        break;
                    }
                    i26--;
                }
                return "\u2026" + sb6.substring(i18, length);
            }
            if (i3 == 3) {
                int length2 = str2.length() + indexOf;
                int measureText3 = (int) (0 + (textPaint.measureText("\u2026") * 2.0f) + textPaint.measureText(sb6.substring(indexOf, length2)));
                while (indexOf > 0 && length2 < length) {
                    if (z16) {
                        measureText3 = (int) (measureText3 + fArr[indexOf - 1]);
                        if (measureText3 >= i16) {
                            break;
                        }
                        indexOf--;
                        z16 = !z16;
                    } else {
                        measureText3 = (int) (measureText3 + fArr[length2]);
                        if (measureText3 >= i16) {
                            break;
                        }
                        length2++;
                        z16 = !z16;
                    }
                }
                return "\u2026" + sb6.substring(indexOf, length2) + "\u2026";
            }
            return sb6;
        }
        return str;
    }

    public static int d(String str, String str2, int i3, TextPaint textPaint, String str3) {
        int i16 = 0;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0;
        }
        StringBuilder sb5 = new StringBuilder(str);
        if (!TextUtils.isEmpty(str3)) {
            sb5.append(".");
            sb5.append(str3);
        }
        String sb6 = sb5.toString();
        int indexOf = sb6.toLowerCase().indexOf(str2.toLowerCase());
        if (indexOf == -1) {
            return 0;
        }
        int length = sb6.length();
        float f16 = i3;
        if (textPaint.measureText(sb6, 0, length) <= f16) {
            return 0;
        }
        if (indexOf != 0) {
            float[] fArr = new float[length];
            textPaint.getTextWidths(sb6, 0, length, fArr);
            int measureText = (int) (f16 - textPaint.measureText("\u2026"));
            if (!TextUtils.isEmpty(str3)) {
                measureText = (int) (measureText - textPaint.measureText(str3));
            }
            int length2 = str2.length() + indexOf;
            int i17 = 0;
            for (int i18 = 0; i18 < length2; i18++) {
                i17 = (int) (i17 + fArr[i18]);
            }
            if (i17 >= measureText) {
                while (indexOf < length) {
                    i16 = (int) (i16 + fArr[indexOf]);
                    indexOf++;
                }
                if (i16 < measureText) {
                    return 1;
                }
                return 3;
            }
        }
        return 2;
    }

    public static String e(String str) {
        if (str == null) {
            return "";
        }
        if (str.endsWith(".rename")) {
            String replace = str.replace(".rename", "");
            int lastIndexOf = replace.lastIndexOf(".");
            if (lastIndexOf == -1) {
                return "";
            }
            if (replace.substring(lastIndexOf).replaceAll("[0-9]*", "").replace("(", "").replace(")", "").equalsIgnoreCase(".apk")) {
                return ".apk.rename";
            }
        }
        int lastIndexOf2 = str.lastIndexOf(".");
        if (lastIndexOf2 < 0) {
            return "";
        }
        return str.substring(lastIndexOf2);
    }

    public static boolean h(List<?> list) {
        if (list == null || list.size() < 1) {
            return true;
        }
        return false;
    }

    public static void i() {
        HashMap<String, SpannableString> hashMap = F;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public String f(String str, String str2, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (str == null) {
            return null;
        }
        if (str2 == null) {
            return str;
        }
        if (str.length() <= i3) {
            return str;
        }
        int indexOf = str.toLowerCase().indexOf(str2.toLowerCase());
        if (indexOf == -1) {
            return str.substring(0, i3) + "\u2026";
        }
        if (str2.length() < str.length()) {
            if (str2.length() + indexOf == str.length()) {
                return "\u2026" + str.substring(str.length() - i3, str.length());
            }
            if (indexOf == 0) {
                return str.substring(0, indexOf + i3) + "\u2026";
            }
            if (str.length() - indexOf > i3 - 1) {
                return "\u2026" + str.substring(indexOf, i3 + indexOf) + "\u2026";
            }
            return "\u2026." + str.substring(str.length() - i3, str.length());
        }
        return str;
    }

    protected int g(String str, String str2, String str3, String str4, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 3;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, this, str, str2, str3, str4, Integer.valueOf(i3))).intValue();
        }
        int i17 = -1;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String lowerCase = str.toLowerCase();
            if (i3 == 1) {
                if (!str2.toLowerCase().contains(lowerCase)) {
                    i16 = -1;
                } else if (str3 == null || !str3.toLowerCase().contains(lowerCase)) {
                    if (str4 != null && str4.toLowerCase().contains(lowerCase)) {
                        i16 = 2;
                    }
                }
                i17 = i16;
            }
            i16 = 1;
            i17 = i16;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SingleLineHotwordTextView", 2, "getTargetType targetType = " + i17 + ", hotword = " + str + ", text = " + str2 + ", fileName = " + str3 + ", extension = " + str4 + ", contentType = " + i3);
        }
        return i17;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        String str;
        SpannableString spannableString;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        if (TextUtils.isEmpty(this.D)) {
            return;
        }
        ArrayList<String> arrayList = this.f280848m;
        if (arrayList != null && arrayList.size() > 0) {
            str = this.f280848m.get(0);
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f280843d == null) {
            this.f280843d = this.D;
            this.f280844e = null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        HashMap<String, SpannableString> hashMap = F;
        if (hashMap.containsKey(this.E)) {
            spannableString = hashMap.get(this.E);
        } else {
            int width = getWidth();
            TextPaint paint = getPaint();
            int d16 = d(this.f280843d, str, width, paint, this.f280844e);
            String c16 = c(d16, this.f280843d, str, width, paint, this.f280844e);
            SpannableString b16 = b(c16, this.f280848m, this.C);
            hashMap.put(this.E, b16);
            if (QLog.isColorLevel()) {
                QLog.d("SingleLineHotwordTextView", 2, "type = " + d16 + ", displayText = " + c16 + ", text = " + this.D + ", viewWidth = " + width + ", new = " + paint.measureText(c16) + ", old = " + paint.measureText(this.D) + ", onLayout t = " + (System.currentTimeMillis() - currentTimeMillis));
            }
            spannableString = b16;
        }
        super.setText(spannableString, TextView.BufferType.SPANNABLE);
    }

    public void setContentType(int i3, int i16) {
        String str;
        ArrayList<String> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f280845f = i16;
        this.f280846h = i3;
        if (QLog.isColorLevel()) {
            QLog.d("SingleLineHotwordTextView", 2, "setContentType text = " + this.D);
        }
        String str2 = this.D;
        this.f280843d = str2;
        this.f280844e = null;
        if (i3 == 1) {
            String e16 = e(str2);
            if (!TextUtils.isEmpty(e16)) {
                int lastIndexOf = str2.toLowerCase().lastIndexOf(e16.toLowerCase());
                if (lastIndexOf > -1) {
                    this.f280843d = str2.substring(0, lastIndexOf);
                    this.f280844e = e16;
                    if (e16.length() > 1) {
                        this.f280844e = e16.substring(1);
                    }
                }
                ArrayList<String> arrayList2 = this.f280848m;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    str = this.f280848m.get(0);
                } else {
                    str = null;
                }
                int g16 = g(str, str2, this.f280843d, this.f280844e, this.f280846h);
                this.f280847i = g16;
                if (g16 == 3) {
                    StringBuffer stringBuffer = new StringBuffer(this.f280843d);
                    stringBuffer.append(".");
                    stringBuffer.append(this.f280844e);
                    this.f280843d = stringBuffer.toString();
                    this.f280844e = null;
                } else {
                    this.f280844e = f(this.f280844e, str, this.f280845f, g16);
                    if (this.f280847i == 2 && (arrayList = this.f280848m) != null && arrayList.size() > 0 && str != null && str.length() > this.f280845f) {
                        this.f280848m.remove(0);
                        this.f280848m.add(0, this.f280844e);
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("SingleLineHotwordTextView", 2, "setContentType name = " + this.f280843d + ", extension = " + this.f280844e);
        }
    }

    public void setHotword(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            ArrayList<String> arrayList = this.f280848m;
            if (arrayList != null) {
                arrayList.clear();
                this.f280848m = null;
                return;
            }
            return;
        }
        ArrayList<String> arrayList2 = new ArrayList<>();
        this.f280848m = arrayList2;
        arrayList2.add(str);
    }

    public void setHotwords(ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) arrayList);
        } else {
            this.f280848m = arrayList;
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) charSequence, (Object) bufferType);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SingleLineHotwordTextView", 2, "setText text = " + ((Object) charSequence));
        }
        String charSequence2 = charSequence.toString();
        this.D = charSequence2;
        this.f280843d = null;
        this.f280844e = null;
        this.f280845f = Integer.MAX_VALUE;
        this.f280846h = 0;
        this.f280847i = -1;
        String a16 = a(charSequence2, this.f280848m);
        this.E = a16;
        HashMap<String, SpannableString> hashMap = F;
        if (hashMap.containsKey(a16)) {
            super.setText(hashMap.get(this.E), bufferType);
        } else {
            super.setText(charSequence, bufferType);
        }
    }

    public void setHotword(ArrayList<String> arrayList, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) arrayList, i3);
        } else {
            this.f280848m = arrayList;
            this.C = i3;
        }
    }
}
