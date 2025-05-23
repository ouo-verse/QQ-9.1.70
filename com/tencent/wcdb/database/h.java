package com.tencent.wcdb.database;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.regex.Pattern;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes27.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f384414a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22082);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            f384414a = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
        }
    }

    private static void a(StringBuilder sb5, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            sb5.append(str);
            sb5.append(str2);
        }
    }

    public static void b(StringBuilder sb5, String[] strArr) {
        int length = strArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            String str = strArr[i3];
            if (str != null) {
                if (i3 > 0) {
                    sb5.append(", ");
                }
                sb5.append(str);
            }
        }
        sb5.append(TokenParser.SP);
    }

    public static String c(boolean z16, String str, String[] strArr, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
        }
        if (!TextUtils.isEmpty(str6) && !f384414a.matcher(str6).matches()) {
            throw new IllegalArgumentException("invalid LIMIT clauses:" + str6);
        }
        StringBuilder sb5 = new StringBuilder(120);
        sb5.append("SELECT ");
        if (z16) {
            sb5.append("DISTINCT ");
        }
        if (strArr != null && strArr.length != 0) {
            b(sb5, strArr);
        } else {
            sb5.append("* ");
        }
        sb5.append("FROM ");
        sb5.append(str);
        a(sb5, " WHERE ", str2);
        a(sb5, " GROUP BY ", str3);
        a(sb5, " HAVING ", str4);
        a(sb5, " ORDER BY ", str5);
        a(sb5, " LIMIT ", str6);
        return sb5.toString();
    }
}
