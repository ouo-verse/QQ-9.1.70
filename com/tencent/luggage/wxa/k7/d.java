package com.tencent.luggage.wxa.k7;

import android.util.Pair;
import com.tencent.luggage.wxa.tn.w0;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d {
    public static final String b(List list) {
        Object obj;
        String str = "";
        if (list == null) {
            return "";
        }
        if (w0.c("") && !w0.a(list)) {
            StringBuilder sb5 = new StringBuilder();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                if (w0.c((String) pair.second)) {
                    obj = pair.first;
                } else {
                    obj = pair.second;
                }
                String str2 = (String) obj;
                if (!w0.c(str2)) {
                    sb5.append("\u3001");
                    sb5.append(str2);
                }
            }
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
            str = !w0.c(sb6) ? new Regex("\u3001").replaceFirst(sb6, "") : sb6;
        }
        String d16 = w0.d(str);
        Intrinsics.checkNotNullExpressionValue(d16, "nullAsNil(ret)");
        return d16;
    }
}
