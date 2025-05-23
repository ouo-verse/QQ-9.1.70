package com.tencent.luggage.wxa.mj;

import android.text.TextUtils;
import com.tencent.luggage.wxa.tn.w;
import org.apache.commons.lang.StringUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface g {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum a {
        LIGHT,
        DARK,
        IGNORE;

        public String b() {
            return name().toLowerCase();
        }

        public static a a(String str, boolean z16) {
            if (TextUtils.isEmpty(str)) {
                return z16 ? LIGHT : DARK;
            }
            for (a aVar : values()) {
                if (StringUtils.equalsIgnoreCase(aVar.b(), str)) {
                    return aVar;
                }
            }
            w.b("Luggage.AppBrandPageViewPullDownExtension.BackgroundTextStyle", "fromString(%s), unrecognized", str);
            return z16 ? LIGHT : DARK;
        }
    }

    void a();

    void a(a aVar, int i3);

    void a(String str);

    void a(String str, String str2);

    void a(boolean z16);

    void b();

    void b(String str);

    void b(boolean z16);
}
