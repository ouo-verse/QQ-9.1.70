package k05;

import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.tools.util;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static final char[] f411377c = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, TokenParser.SP, 0, 0, '#', 0, 0, 0, 0, 0, 0, 0, 0, 0, '-', '.', '/', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 0, 0, 0, 0, 0, '?', 0, 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 0, 0, 0, 0, util.base64_pad_url, 0, 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '{', 0, '}', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, String> f411378a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f411379b;

    public a() {
        this.f411379b = false;
        if ("com.tencent.mobileqq:qzone".equals(b())) {
            this.f411378a = new ConcurrentHashMap<>(1024);
            this.f411379b = true;
        }
    }

    private String b() {
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null) {
            return mobileQQ.getQQProcessName();
        }
        return null;
    }

    private String d(String str) {
        if (str == null) {
            return null;
        }
        try {
            char[] charArray = str.toCharArray();
            boolean z16 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= charArray.length) {
                    break;
                }
                char c16 = f411377c[charArray[i3]];
                charArray[i3] = c16;
                if (c16 == 0) {
                    z16 = true;
                    break;
                }
                i3++;
            }
            if (z16) {
                return str.toLowerCase();
            }
            return new String(charArray);
        } catch (Exception unused) {
            return str.toLowerCase();
        }
    }

    public boolean a() {
        return this.f411379b;
    }

    public String c(String str) {
        String str2 = null;
        if (str == null) {
            return null;
        }
        ConcurrentHashMap<String, String> concurrentHashMap = this.f411378a;
        if (concurrentHashMap != null && concurrentHashMap.containsKey(str)) {
            str2 = this.f411378a.get(str);
        }
        if (str2 == null) {
            str2 = d(str);
            ConcurrentHashMap<String, String> concurrentHashMap2 = this.f411378a;
            if (concurrentHashMap2 != null) {
                concurrentHashMap2.put(str, str2);
            }
        }
        return str2;
    }
}
