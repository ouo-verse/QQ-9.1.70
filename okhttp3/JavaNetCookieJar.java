package okhttp3;

import java.io.IOException;
import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.Cookie;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import org.apache.http.cookie.SM;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class JavaNetCookieJar implements CookieJar {
    private final CookieHandler cookieHandler;

    public JavaNetCookieJar(CookieHandler cookieHandler) {
        this.cookieHandler = cookieHandler;
    }

    private List<Cookie> decodeHeaderAsJavaNetCookies(HttpUrl httpUrl, String str) {
        String str2;
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            int delimiterOffset = Util.delimiterOffset(str, i3, length, ";,");
            int delimiterOffset2 = Util.delimiterOffset(str, i3, delimiterOffset, '=');
            String trimSubstring = Util.trimSubstring(str, i3, delimiterOffset2);
            if (!trimSubstring.startsWith("$")) {
                if (delimiterOffset2 < delimiterOffset) {
                    str2 = Util.trimSubstring(str, delimiterOffset2 + 1, delimiterOffset);
                } else {
                    str2 = "";
                }
                if (str2.startsWith("\"") && str2.endsWith("\"")) {
                    str2 = str2.substring(1, str2.length() - 1);
                }
                arrayList.add(new Cookie.Builder().name(trimSubstring).value(str2).domain(httpUrl.host()).build());
            }
            i3 = delimiterOffset + 1;
        }
        return arrayList;
    }

    @Override // okhttp3.CookieJar
    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
        try {
            ArrayList arrayList = null;
            for (Map.Entry<String, List<String>> entry : this.cookieHandler.get(httpUrl.uri(), Collections.emptyMap()).entrySet()) {
                String key = entry.getKey();
                if ("Cookie".equalsIgnoreCase(key) || SM.COOKIE2.equalsIgnoreCase(key)) {
                    if (!entry.getValue().isEmpty()) {
                        for (String str : entry.getValue()) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.addAll(decodeHeaderAsJavaNetCookies(httpUrl, str));
                        }
                    }
                }
            }
            if (arrayList != null) {
                return Collections.unmodifiableList(arrayList);
            }
            return Collections.emptyList();
        } catch (IOException e16) {
            Platform.get().log(5, "Loading cookies failed for " + httpUrl.resolve("/..."), e16);
            return Collections.emptyList();
        }
    }

    @Override // okhttp3.CookieJar
    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        if (this.cookieHandler != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<Cookie> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toString(true));
            }
            try {
                this.cookieHandler.put(httpUrl.uri(), Collections.singletonMap("Set-Cookie", arrayList));
            } catch (IOException e16) {
                Platform.get().log(5, "Saving cookies failed for " + httpUrl.resolve("/..."), e16);
            }
        }
    }
}
