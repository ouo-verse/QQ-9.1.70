package com.tencent.xweb;

import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.java_websocket.WebSocketImpl;

/* compiled from: P */
/* loaded from: classes27.dex */
public class WebAddress {

    /* renamed from: f, reason: collision with root package name */
    public static Pattern f384974f = Pattern.compile("(?:(http|https|file)\\:\\/\\/)?(?:([-A-Za-z0-9$_.+!*'(),;?&=]+(?:\\:[-A-Za-z0-9$_.+!*'(),;?&=]+)?)@)?([a-zA-Z0-9\u00a0-\ud7ff\uf900-\ufdcf\ufdf0-\uffef%_-][a-zA-Z0-9\u00a0-\ud7ff\uf900-\ufdcf\ufdf0-\uffef%_\\.-]*|\\[[0-9a-fA-F:\\.]+\\])?(?:\\:([0-9]*))?(\\/?[^#]*)?.*", 2);

    /* renamed from: a, reason: collision with root package name */
    public String f384975a;

    /* renamed from: b, reason: collision with root package name */
    public String f384976b;

    /* renamed from: c, reason: collision with root package name */
    public int f384977c;

    /* renamed from: d, reason: collision with root package name */
    public String f384978d;

    /* renamed from: e, reason: collision with root package name */
    public String f384979e;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class ParseException extends RuntimeException {
        public String response;

        public ParseException(String str) {
            this.response = str;
        }
    }

    public WebAddress(String str) throws ParseException {
        str.getClass();
        this.f384975a = "";
        this.f384976b = "";
        this.f384977c = -1;
        this.f384978d = "/";
        this.f384979e = "";
        Matcher matcher = f384974f.matcher(str);
        if (matcher.matches()) {
            String group = matcher.group(1);
            if (group != null) {
                this.f384975a = group.toLowerCase(Locale.ROOT);
            }
            String group2 = matcher.group(2);
            if (group2 != null) {
                this.f384979e = group2;
            }
            String group3 = matcher.group(3);
            if (group3 != null) {
                this.f384976b = group3;
            }
            String group4 = matcher.group(4);
            if (group4 != null && group4.length() > 0) {
                try {
                    this.f384977c = Integer.parseInt(group4);
                } catch (NumberFormatException unused) {
                    throw new ParseException("Bad port");
                }
            }
            String group5 = matcher.group(5);
            if (group5 != null && group5.length() > 0) {
                if (group5.charAt(0) == '/') {
                    this.f384978d = group5;
                } else {
                    this.f384978d = "/" + group5;
                }
            }
            if (this.f384977c == 443 && this.f384975a.equals("")) {
                this.f384975a = "https";
            } else if (this.f384977c == -1) {
                if (this.f384975a.equals("https")) {
                    this.f384977c = WebSocketImpl.DEFAULT_WSS_PORT;
                } else {
                    this.f384977c = 80;
                }
            }
            if (this.f384975a.equals("")) {
                this.f384975a = "http";
                return;
            }
            return;
        }
        throw new ParseException("Bad address");
    }

    public String getAuthInfo() {
        return this.f384979e;
    }

    public String getHost() {
        return this.f384976b;
    }

    public String getPath() {
        return this.f384978d;
    }

    public int getPort() {
        return this.f384977c;
    }

    public String getScheme() {
        return this.f384975a;
    }

    public void setAuthInfo(String str) {
        this.f384979e = str;
    }

    public void setHost(String str) {
        this.f384976b = str;
    }

    public void setPath(String str) {
        this.f384978d = str;
    }

    public void setPort(int i3) {
        this.f384977c = i3;
    }

    public void setScheme(String str) {
        this.f384975a = str;
    }

    public String toString() {
        String str;
        String str2 = "";
        if ((this.f384977c == 443 || !this.f384975a.equals("https")) && (this.f384977c == 80 || !this.f384975a.equals("http"))) {
            str = "";
        } else {
            str = ":" + this.f384977c;
        }
        if (this.f384979e.length() > 0) {
            str2 = this.f384979e + "@";
        }
        return this.f384975a + QzoneWebViewOfflinePlugin.STR_DEVIDER + str2 + this.f384976b + str + this.f384978d;
    }
}
