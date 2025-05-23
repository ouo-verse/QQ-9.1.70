package ek0;

import com.qzone.proxy.personalitycomponent.adapter.PersonalityConfig;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mobileqq.vas.theme.ThemeSwitchUtil;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, String> f396527a;

    static {
        HashMap hashMap = new HashMap();
        f396527a = hashMap;
        hashMap.put("100", "Continue");
        f396527a.put("101", "Switching Protocol");
        f396527a.put("200", "OK");
        f396527a.put(ThemeReporter.FROM_DIY, "Created");
        f396527a.put(ThemeReporter.FROM_NIGHT, "Accepted");
        f396527a.put(ThemeReporter.FROM_WEEKLOOP, "Non-Authoritative Information");
        f396527a.put(ThemeReporter.FROM_AUTH, "No Content");
        f396527a.put(ThemeReporter.FROM_ENGINE, "Reset Content");
        f396527a.put(ThemeReporter.FROM_INIT_THEME, "Partial Content");
        f396527a.put(IndividuationPlugin.Business_Font, "Multiple Choice");
        f396527a.put(ThemeSwitchUtil.FROM_LOGIN_RESULT, "Moved Permanently");
        f396527a.put("302", "Found");
        f396527a.put("303", "See Other");
        f396527a.put("304", "Not Modified");
        f396527a.put("305", "Use Proxy");
        f396527a.put("306", "unused");
        f396527a.put("307", "Temporary Redirect");
        f396527a.put("308", "Permanent Redirect");
        f396527a.put(IndividuationPlugin.Business_Pendant, "Bad Request");
        f396527a.put("401", "Unauthorized");
        f396527a.put("402", "Payment Required");
        f396527a.put("403", "Forbidden");
        f396527a.put("404", "Not Found");
        f396527a.put("405", "Method Not Allowed");
        f396527a.put(PersonalityConfig.RESERVES_COVER_CLICK_WIDGET_VISITOR_WITH_NANE_PLATGE, "Not Acceptable");
        f396527a.put("407", "Proxy Authentication Required");
        f396527a.put("408", "Request Timeout");
        f396527a.put("409", "Conflict");
        f396527a.put("410", "Gone");
        f396527a.put("411", "Length Required");
        f396527a.put("412", "Precondition Failed");
        f396527a.put("413", "Payload Too Large");
        f396527a.put("414", "URI Too Long");
        f396527a.put("415", "Unsupported Media Type");
        f396527a.put("416", "Requested Range Not Satisfiable");
        f396527a.put("417", "Expectation Failed");
        f396527a.put("418", "I'm a teapot");
        f396527a.put("421", "Misdirected Request");
        f396527a.put("426", "Upgrade Required");
        f396527a.put("428", "Precondition Required");
        f396527a.put("429", "Too Many Requests");
        f396527a.put("431", "Request Header Fields Too Large");
        f396527a.put("500", "Internal Server Error");
        f396527a.put("501", "Not Implemented");
        f396527a.put("502", "Bad Gateway");
        f396527a.put("503", "Service Unavailable");
        f396527a.put("504", "Gateway Timeout");
        f396527a.put("505", "HTTP Version Not Supported");
        f396527a.put("506", "Variant Also Negotiates");
        f396527a.put("507", "Variant Also Negotiates");
        f396527a.put("511", "Network Authentication Required");
    }

    public static String a(String str) {
        if (!f396527a.containsKey(str)) {
            return "unknown status";
        }
        return f396527a.get(str);
    }
}
