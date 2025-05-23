package com.tencent.mobileqq.search.util;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public List<String> f285039a;

    /* renamed from: b, reason: collision with root package name */
    public int f285040b = 0;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements Comparator<String> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            if (str != null && str2 != null) {
                return str2.length() - str.length();
            }
            return 0;
        }
    }

    public e(List<String> list, String str) {
        list = list == null ? new ArrayList<>() : list;
        if (str != null && !list.contains(str)) {
            list.add(str);
        }
        Collections.sort(list, new a());
        this.f285039a = list;
    }

    public SpannableString a(CharSequence charSequence) {
        return d(charSequence, false, false);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:(1:24)|(3:26|(1:31)(1:(1:29))|30)|32|(1:34)|35|36|(1:38)(1:52)|39|40|(1:44)|45|(1:49)|50|51|30) */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00a0, code lost:
    
        r12 = android.graphics.Color.parseColor("#00a5e0");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SpannableString b(CharSequence charSequence, String str, boolean z16, boolean z17, boolean z18) {
        String str2;
        if (TextUtils.isEmpty(charSequence)) {
            return null;
        }
        SpannableString spannableString = new SpannableString(charSequence);
        List<String> list = this.f285039a;
        if (list != null && list.size() > 0) {
            String charSequence2 = charSequence.toString();
            Object[] array = this.f285039a.toArray();
            this.f285040b = 0;
            boolean z19 = false;
            boolean z26 = false;
            for (Object obj : array) {
                String str3 = (String) obj;
                if (str3.length() <= 1 && z19) {
                    break;
                }
                int i3 = 0;
                while (true) {
                    int f16 = f(charSequence2, str3, i3);
                    if (f16 == -1) {
                        break;
                    }
                    if (z18 && f16 > 10 && !z26 && !z16) {
                        charSequence2 = "\u2026" + charSequence2.substring(f16 - 6);
                        spannableString = new SpannableString(charSequence2);
                        f16 = 7;
                        z26 = true;
                    }
                    if (z17) {
                        int indexOf = charSequence2.indexOf(" ");
                        int indexOf2 = charSequence2.indexOf(" ", indexOf);
                        if (f16 >= indexOf) {
                            if (f16 > indexOf2) {
                            }
                        }
                        i3 = f16 + 1;
                    }
                    if (str3.length() > 1) {
                        z19 = true;
                        z26 = true;
                    }
                    if (TextUtils.isEmpty(str)) {
                        str2 = "#00a5e0";
                    } else {
                        str2 = str;
                    }
                    int parseColor = Color.parseColor(str2);
                    if (ThemeUtil.isInNightMode(MobileQQ.sMobileQQ.peekAppRuntime()) && TextUtils.isEmpty(str)) {
                        parseColor = Color.parseColor("#004080");
                    }
                    if (aq.a() && TextUtils.isEmpty(str)) {
                        parseColor = MobileQQ.sMobileQQ.getResources().getColor(R.color.qui_common_brand_standard);
                    }
                    spannableString.setSpan(new ForegroundColorSpan(parseColor), f16, str3.length() + f16, 34);
                    this.f285040b++;
                    i3 = f16 + 1;
                }
            }
        }
        return spannableString;
    }

    public SpannableString c(CharSequence charSequence, boolean z16) {
        return d(charSequence, z16, false);
    }

    public SpannableString d(CharSequence charSequence, boolean z16, boolean z17) {
        return b(charSequence, null, z16, z17, true);
    }

    public SpannableString e(CharSequence charSequence, boolean z16, boolean z17, boolean z18) {
        return b(charSequence, null, z16, z17, z18);
    }

    public int f(String str, String str2, int i3) {
        if (str != null && str2 != null) {
            return str.toLowerCase().indexOf(str2.toLowerCase(), i3);
        }
        return -1;
    }
}
