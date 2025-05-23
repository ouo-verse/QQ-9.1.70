package com.tencent.mobileqq.search.util;

import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    public static int a() {
        int color = MobileQQ.sMobileQQ.getResources().getColor(R.color.ac5);
        if (ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), false, "")) {
            color = MobileQQ.sMobileQQ.getResources().getColor(R.color.ac6);
        }
        if (SimpleUIUtil.isNowElderMode() && !QQTheme.isNowThemeIsNight()) {
            color = MobileQQ.sMobileQQ.getResources().getColor(R.color.cpj);
        }
        if (aq.a()) {
            return MobileQQ.sMobileQQ.getResources().getColor(R.color.qui_common_brand_standard);
        }
        return color;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
    
        if ((r1 + r2) > 10) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0058, code lost:
    
        r4 = r1 - r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005b, code lost:
    
        if (r4 <= 4) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005d, code lost:
    
        r4 = r8.substring(r4);
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006c, code lost:
    
        if ((r7.measureText(r4) + 70.0f) <= r10) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006e, code lost:
    
        r0 = "\u2026" + r4;
        r8 = "\u2026" + r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0090, code lost:
    
        r1 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static CharSequence b(TextView textView, String str, String str2, boolean z16) {
        int i3;
        int i16;
        String lowerCase = str.toLowerCase();
        int indexOf = lowerCase.indexOf(str2);
        int length = str2.length();
        int i17 = 0;
        if (indexOf < 0 && (indexOf = lowerCase.indexOf((str2 = str2.toLowerCase()))) < 0) {
            if (z16) {
                int[] d16 = d(lowerCase, str2, 1);
                int i18 = d16[0];
                if (i18 >= 0) {
                    i16 = d16[1];
                } else {
                    int[] d17 = d(lowerCase, str2, 2);
                    i18 = d17[0];
                    if (i18 >= 0) {
                        i16 = d17[1];
                    } else {
                        return new SpannableStringBuilder(str);
                    }
                }
                indexOf = i18;
                length = i16;
            } else {
                return new SpannableStringBuilder(str);
            }
        }
        int width = textView.getWidth();
        TextPaint paint = textView.getPaint();
        float f16 = width;
        if (paint.measureText(str) > f16) {
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        while (indexOf >= 0) {
            int i19 = length + indexOf;
            if (i19 > str.length()) {
                i3 = str.length();
            } else {
                i3 = i19;
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(a()), indexOf, i3, 17);
            indexOf = lowerCase.indexOf(str2, i19);
            length = str2.length();
        }
        return spannableStringBuilder;
    }

    public static int[] c(ChnToSpell.b bVar, String str) {
        int[] iArr = {-1, 0};
        int indexOf = bVar.f306907b.indexOf(str);
        if (indexOf < 0) {
            return iArr;
        }
        int i3 = 0;
        while (i3 < bVar.f306908c.size()) {
            if (indexOf == bVar.f306908c.get(i3).intValue()) {
                iArr[0] = i3;
                int i16 = i3 + 1;
                while (i16 < bVar.f306908c.size() && str.length() + indexOf > bVar.f306908c.get(i16).intValue()) {
                    i16++;
                }
                iArr[1] = i16 - i3;
                return iArr;
            }
            if (indexOf < bVar.f306908c.get(i3).intValue()) {
                indexOf = bVar.f306907b.indexOf(str, bVar.f306908c.get(i3).intValue());
                if (indexOf < 0) {
                    return iArr;
                }
                i3--;
            }
            i3++;
        }
        return iArr;
    }

    public static int[] d(String str, String str2, int i3) {
        return c(ChnToSpell.e(str, i3), str2);
    }
}
