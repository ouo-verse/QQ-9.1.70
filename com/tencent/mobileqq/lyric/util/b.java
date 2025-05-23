package com.tencent.mobileqq.lyric.util;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static com.tencent.mobileqq.lyric.data.b a(String str, boolean z16) {
        com.tencent.mobileqq.lyric.data.b a16;
        if (str != null && str.length() >= 0) {
            try {
                if (z16) {
                    a16 = new d(str).b();
                } else {
                    a16 = new c(str).a();
                }
                if (a16 != null) {
                    if (a16.f243142b.size() > 0) {
                        return a16;
                    }
                    return null;
                }
                return null;
            } catch (Exception e16) {
                Log.e("LyricParseHelper", "parse exception:", e16);
                return null;
            }
        }
        return null;
    }
}
