package com.tencent.lyric.util;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static com.tencent.lyric.data.a a(String str, boolean z16) {
        return b(str, z16, false);
    }

    public static com.tencent.lyric.data.a b(String str, boolean z16, boolean z17) {
        com.tencent.lyric.data.a a16;
        f fVar;
        if (str != null && str.length() >= 0) {
            try {
                if (z16) {
                    if (z17) {
                        fVar = new g(str);
                    } else {
                        fVar = new f(str);
                    }
                    a16 = fVar.b();
                } else {
                    a16 = new e(str).a();
                }
                if (a16 != null) {
                    if (a16.f147056b.size() > 0) {
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
