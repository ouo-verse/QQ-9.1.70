package com.tencent.mobileqq.webview.swift.component;

import android.text.TextUtils;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.config.business.bm;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class s {
    static IPatchRedirector $redirector_;

    public static final ArrayList<String> a() {
        String str;
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            bm bmVar = (bm) am.s().x(361);
            if (bmVar != null && !TextUtils.isEmpty(bmVar.f202632i)) {
                str = bmVar.f202632i;
            } else {
                str = "QQ";
            }
            for (String str2 : str.split(";")) {
                arrayList.add(str2);
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public static final boolean b(int i3, boolean z16) {
        if (((bm) am.s().x(361)) != null) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5 || Math.random() >= Float.valueOf(r0.f202629f).floatValue()) {
                                return z16;
                            }
                        } else if (Math.random() >= Float.valueOf(r0.f202630g).floatValue()) {
                            return z16;
                        }
                    } else if (Math.random() >= Float.valueOf(r0.f202631h).floatValue()) {
                        return z16;
                    }
                } else if (Math.random() >= Float.valueOf(r0.f202628e).floatValue()) {
                    return z16;
                }
            } else if (Math.random() >= Float.valueOf(r0.f202627d).floatValue()) {
                return z16;
            }
            return true;
        }
        return z16;
    }
}
