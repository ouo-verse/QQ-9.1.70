package com.tencent.luggage.wxa.tg;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f {

    /* renamed from: h, reason: collision with root package name */
    public static final Pattern f141301h = Pattern.compile("[R,r]ange:\\s*bytes=(\\d*)\\s*-\\s*(\\d*)");

    /* renamed from: i, reason: collision with root package name */
    public static HashMap f141302i = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public BufferedReader f141303a;

    /* renamed from: b, reason: collision with root package name */
    public LinkedHashMap f141304b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    public LinkedHashMap f141305c = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name */
    public int[] f141306d = new int[2];

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f141307e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public String f141308f;

    /* renamed from: g, reason: collision with root package name */
    public String f141309g;

    public f(InputStream inputStream, String str) {
        this.f141303a = new BufferedReader(new InputStreamReader(inputStream));
        this.f141309g = str + "HttpParser";
        try {
            e();
        } catch (IOException e16) {
            h.a(6, this.f141309g, "error parsing request " + h.a((Throwable) e16));
        }
    }

    public static String a(Map map) {
        return b(c(map));
    }

    public static String b(Map map) {
        String str = "";
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() != null) {
                str = (str + ((String) entry.getKey())) + MsgSummary.STR_COLON;
            }
            str = (str + ((String) entry.getValue())) + "\r\n";
        }
        return str;
    }

    public static Map c(Map map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (str != null) {
                    linkedHashMap.put(str.toLowerCase().trim(), (String) list.get(i3));
                } else {
                    linkedHashMap.put(str, (String) list.get(i3));
                }
            }
        }
        return linkedHashMap;
    }

    public final void d() {
        StringBuilder sb5 = new StringBuilder();
        String readLine = this.f141303a.readLine();
        sb5.append(readLine);
        sb5.append("|");
        while (true) {
            if (readLine.equals("")) {
                break;
            }
            int indexOf = readLine.indexOf(58);
            if (indexOf < 0) {
                this.f141304b = null;
                break;
            }
            this.f141304b.put(readLine.substring(0, indexOf).toLowerCase().trim(), readLine.substring(indexOf + 1).trim());
            this.f141307e.add(readLine);
            readLine = this.f141303a.readLine();
            sb5.append(readLine);
            sb5.append("|");
        }
        h.a(4, this.f141309g, "parseHeaders:" + sb5.toString());
    }

    public void e() {
        String str;
        String readLine = this.f141303a.readLine();
        h.a(4, this.f141309g, "parseRequest:" + readLine);
        if (readLine != null && readLine.length() != 0) {
            if (Character.isWhitespace(readLine.charAt(0))) {
                h.a(6, this.f141309g, "character first char is whitespace");
                return;
            }
            String[] split = readLine.split("\\s");
            if (split.length != 3) {
                h.a(6, this.f141309g, "cmd.length is not 3");
                return;
            }
            this.f141307e.add(readLine);
            this.f141308f = split[0];
            if (split[2].indexOf("HTTP/") == 0 && split[2].indexOf(46) > 5) {
                str = split[2];
            } else if (split[0].indexOf("HTTP/") == 0 && split[0].indexOf(46) > 5) {
                str = split[0];
            } else {
                str = null;
            }
            if (str != null) {
                String[] split2 = str.substring(5).split("\\.");
                try {
                    this.f141306d[0] = Integer.parseInt(split2[0]);
                    this.f141306d[1] = Integer.parseInt(split2[1]);
                } catch (NumberFormatException e16) {
                    h.a(6, this.f141309g, "error parsing request NumberFormatException:" + h.a((Throwable) e16));
                    return;
                }
            }
            if (!split[0].equals("GET") && !split[0].equals("HEAD")) {
                if (!split[0].equals("POST") && !split[0].equals(HttpOptions.METHOD_NAME) && !split[0].equals(HttpPut.METHOD_NAME) && !split[0].equals("DELETE") && !split[0].equals("TRACE")) {
                    split[0].equals("CONNECT");
                }
            } else {
                int indexOf = split[1].indexOf(63);
                if (indexOf >= 0) {
                    String[] split3 = split[1].substring(indexOf + 1).split(ContainerUtils.FIELD_DELIMITER);
                    this.f141305c = new LinkedHashMap();
                    for (int i3 = 0; i3 < split3.length; i3++) {
                        String[] split4 = split3[i3].split(ContainerUtils.KEY_VALUE_DELIMITER);
                        if (split4.length == 2) {
                            this.f141305c.put(URLDecoder.decode(split4[0], "UTF-8"), URLDecoder.decode(split4[1], "UTF-8"));
                        } else if (split4.length == 1 && split3[i3].indexOf(61) == split3[i3].length() - 1) {
                            this.f141305c.put(URLDecoder.decode(split4[0], "UTF-8"), "");
                        }
                    }
                }
            }
            d();
            return;
        }
        h.a(6, this.f141309g, "initial is not valid");
    }

    public String a(String str) {
        return (String) this.f141305c.get(str);
    }

    public static String a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return "Date: " + simpleDateFormat.format(new Date()) + " GMT";
    }

    public static String a(int i3) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return "Expires: " + simpleDateFormat.format(new Date(System.currentTimeMillis() + (i3 * 3600000))) + " GMT";
    }

    public String b() {
        StringBuilder sb5 = new StringBuilder();
        Iterator it = this.f141307e.iterator();
        while (it.hasNext()) {
            sb5.append((String) it.next());
            sb5.append("\n");
        }
        return sb5.toString();
    }

    public String c() {
        return this.f141308f;
    }

    public static String a(long j3, long j16, long j17, String str, boolean z16) {
        long j18;
        String str2;
        long j19 = j16;
        boolean z17 = j3 != -1;
        boolean z18 = !TextUtils.isEmpty(str);
        boolean z19 = j17 >= 0;
        if (!z17) {
            j18 = j17;
        } else if (j19 == -2) {
            j18 = j17 - j3;
        } else {
            long j26 = j17 - 1;
            if (j19 > j26) {
                h.a(5, "HttpParser", "fix rangeEnd. max=" + j26 + " current=" + j19);
            }
            j19 = Math.min(j19, j26);
            j18 = (j19 - j3) + 1;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("");
        sb5.append(z17 ? "HTTP/1.1 206 PARTIAL CONTENT\r\n" : "HTTP/1.1 200 OK\r\n");
        String str3 = sb5.toString() + "Connection: close\r\n";
        if (z19 && z17) {
            if (j19 == -2) {
                str3 = str3 + String.format(Locale.US, "Content-Range: bytes %d-%d/%d\r\n", Long.valueOf(j3), Long.valueOf(j17 - 1), Long.valueOf(j17));
            } else {
                str3 = str3 + String.format(Locale.US, "Content-Range: bytes %d-%d/%d\r\n", Long.valueOf(j3), Long.valueOf(j19), Long.valueOf(j17));
            }
        }
        if (z16) {
            str2 = str3 + String.format(Locale.US, "Cache-Control: max-age=%d\r\n", Integer.valueOf(TVKEventId.PLAYER_STATE_SWITCHDEF_START));
        } else {
            str2 = str3 + "Cache-Control: no-cache\r\n";
        }
        String str4 = str2 + a() + "\r\n";
        if (z16) {
            str4 = str4 + a(3) + "\r\n";
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append(str4);
        sb6.append(z19 ? String.format(Locale.US, "Content-Length: %d\r\n", Long.valueOf(j18)) : "");
        String str5 = sb6.toString() + "Accept-Ranges: bytes\r\n";
        StringBuilder sb7 = new StringBuilder();
        sb7.append(str5);
        sb7.append(z18 ? String.format("Content-Type: %s\r\n", str) : "");
        String str6 = (sb7.toString() + String.format("X-Server: %s\r\n", "VideoProxy 1.4.1")) + "\r\n";
        if (!z17 && z18 && str.equalsIgnoreCase("video/mp4")) {
            com.tencent.luggage.wxa.og.a.a().m().a(j17);
        }
        return str6;
    }

    public static long[] b(String str) {
        long j3;
        if (!TextUtils.isEmpty(str)) {
            Matcher matcher = f141301h.matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                String group2 = matcher.group(2);
                try {
                    j3 = Long.parseLong(group);
                } catch (NumberFormatException unused) {
                    j3 = 0;
                }
                try {
                    return new long[]{j3, Long.parseLong(group2)};
                } catch (NumberFormatException unused2) {
                    return new long[]{j3, -2};
                }
            }
        }
        return new long[]{-1, -1};
    }
}
