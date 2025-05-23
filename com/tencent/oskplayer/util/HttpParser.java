package com.tencent.oskplayer.util;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.oskplayer.PlayerConfig;
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

/* loaded from: classes22.dex */
public class HttpParser {
    public static final int NOT_RANGE_REQUEST = -1;
    public static final int RANGE_NOT_SPECIFIED = -2;
    private static final String TAG = "HttpParser";
    private String mLogTag;
    private BufferedReader reader;
    private String requestMethod;
    public static HashMap<String, Map<String, String>> sParseParamsCacheMap = new HashMap<>();
    private static final Pattern RANGE_HEADER_PATTERN = Pattern.compile("[R,r]ange:\\s*bytes=(\\d*)\\s*-\\s*(\\d*)");
    private LinkedHashMap<String, String> headers = new LinkedHashMap<>();
    private LinkedHashMap<String, String> params = new LinkedHashMap<>();
    private int[] ver = new int[2];
    private ArrayList<String> rawHeaders = new ArrayList<>();

    public HttpParser(InputStream inputStream, String str) {
        this.reader = new BufferedReader(new InputStreamReader(inputStream));
        this.mLogTag = str + TAG;
        try {
            parseRequest();
        } catch (IOException e16) {
            PlayerUtils.log(6, this.mLogTag, "error parsing request " + PlayerUtils.getPrintableStackTrace(e16));
        }
    }

    public static String getDateHeader() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return "Date: " + simpleDateFormat.format(new Date()) + " GMT";
    }

    public static String getExpiresHeader(int i3) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return "Expires: " + simpleDateFormat.format(new Date(System.currentTimeMillis() + (i3 * 3600000))) + " GMT";
    }

    public static String getHeaders(Map<String, List<String>> map) {
        return map2String(parseHeaders(map));
    }

    public static long[] getRangeOffset(String str) {
        long j3;
        if (!TextUtils.isEmpty(str)) {
            Matcher matcher = RANGE_HEADER_PATTERN.matcher(str);
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

    public static String map2String(Map<String, String> map) {
        String str = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                str = (str + entry.getKey()) + MsgSummary.STR_COLON;
            }
            str = (str + entry.getValue()) + "\r\n";
        }
        return str;
    }

    public static String newResponseHeader(long j3, long j16, long j17, String str, boolean z16) {
        boolean z17;
        boolean z18;
        long j18;
        String str2;
        String str3;
        String str4;
        long j19 = j16;
        if (j3 != -1) {
            z17 = true;
        } else {
            z17 = false;
        }
        boolean z19 = !TextUtils.isEmpty(str);
        if (j17 >= 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z17) {
            if (j19 == -2) {
                j18 = j17 - j3;
            } else {
                long j26 = j17 - 1;
                if (j19 > j26) {
                    PlayerUtils.log(5, TAG, "fix rangeEnd. max=" + j26 + " current=" + j19);
                }
                j19 = Math.min(j19, j26);
                j18 = (j19 - j3) + 1;
            }
        } else {
            j18 = j17;
        }
        StringBuilder sb5 = new StringBuilder();
        String str5 = "";
        sb5.append("");
        if (z17) {
            str2 = "HTTP/1.1 206 PARTIAL CONTENT\r\n";
        } else {
            str2 = "HTTP/1.1 200 OK\r\n";
        }
        sb5.append(str2);
        String str6 = sb5.toString() + "Connection: close\r\n";
        if (z18 && z17) {
            if (j19 == -2) {
                str6 = str6 + String.format("Content-Range: bytes %d-%d/%d\r\n", Long.valueOf(j3), Long.valueOf(j17 - 1), Long.valueOf(j17));
            } else {
                str6 = str6 + String.format("Content-Range: bytes %d-%d/%d\r\n", Long.valueOf(j3), Long.valueOf(j19), Long.valueOf(j17));
            }
        }
        if (z16) {
            str3 = str6 + String.format("Cache-Control: max-age=%d\r\n", Integer.valueOf(TVKEventId.PLAYER_STATE_SWITCHDEF_START));
        } else {
            str3 = str6 + "Cache-Control: no-cache\r\n";
        }
        String str7 = str3 + getDateHeader() + "\r\n";
        if (z16) {
            str7 = str7 + getExpiresHeader(3) + "\r\n";
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append(str7);
        if (!z18) {
            str4 = "";
        } else {
            str4 = String.format("Content-Length: %d\r\n", Long.valueOf(j18));
        }
        sb6.append(str4);
        String str8 = sb6.toString() + "Accept-Ranges: bytes\r\n";
        StringBuilder sb7 = new StringBuilder();
        sb7.append(str8);
        if (z19) {
            str5 = String.format("Content-Type: %s\r\n", str);
        }
        sb7.append(str5);
        return (sb7.toString() + String.format("X-Server: %s\r\n", PlayerConfig.SERVER)) + "\r\n";
    }

    public static Map<String, String> parseHeaders(Map<String, List<String>> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            for (int i3 = 0; i3 < value.size(); i3++) {
                if (key != null) {
                    linkedHashMap.put(key.toLowerCase().trim(), value.get(i3));
                } else {
                    linkedHashMap.put(key, value.get(i3));
                }
            }
        }
        return linkedHashMap;
    }

    public static Map<String, String> parseParams(String str) {
        int indexOf;
        if (!TextUtils.isEmpty(str) && sParseParamsCacheMap.containsKey(str)) {
            return sParseParamsCacheMap.get(str);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (str != null && (indexOf = str.indexOf(63)) > 0) {
            String[] split = str.substring(indexOf + 1).split(ContainerUtils.FIELD_DELIMITER);
            for (int i3 = 0; i3 < split.length; i3++) {
                try {
                    String[] split2 = split[i3].split(ContainerUtils.KEY_VALUE_DELIMITER);
                    if (split2.length == 2) {
                        linkedHashMap.put(URLDecoder.decode(split2[0], "UTF-8"), URLDecoder.decode(split2[1], "UTF-8"));
                    } else if (split2.length == 1 && split[i3].indexOf(61) == split[i3].length() - 1) {
                        linkedHashMap.put(URLDecoder.decode(split2[0], "UTF-8"), "");
                    }
                } catch (IOException e16) {
                    PlayerUtils.log(5, TAG, PlayerUtils.getPrintableStackTrace(e16));
                }
            }
            sParseParamsCacheMap.put(str, linkedHashMap);
        }
        return linkedHashMap;
    }

    public static String replaceParam(String str, String str2, String str3) {
        String str4 = str2 + ContainerUtils.KEY_VALUE_DELIMITER;
        if (str != null && str.contains(str4)) {
            return str.replaceAll(str2 + "=[^&]+", str2 + ContainerUtils.KEY_VALUE_DELIMITER + str3);
        }
        return str;
    }

    public String getParam(String str) {
        return this.params.get(str);
    }

    public String getRawHeaders() {
        StringBuilder sb5 = new StringBuilder();
        Iterator<String> it = this.rawHeaders.iterator();
        while (it.hasNext()) {
            sb5.append(it.next());
            sb5.append("\n");
        }
        return sb5.toString();
    }

    public String getRequestMethod() {
        return this.requestMethod;
    }

    public String getVersion() {
        return this.ver[0] + "." + this.ver[1];
    }

    public void parseRequest() throws IOException {
        String str;
        String readLine = this.reader.readLine();
        PlayerUtils.log(4, this.mLogTag, "initial=" + readLine);
        if (readLine != null && readLine.length() != 0) {
            if (Character.isWhitespace(readLine.charAt(0))) {
                PlayerUtils.log(6, this.mLogTag, "character first char is whitespace");
                return;
            }
            String[] split = readLine.split("\\s");
            if (split.length != 3) {
                PlayerUtils.log(6, this.mLogTag, "cmd.length is not 3");
                return;
            }
            this.requestMethod = split[0];
            if (split[2].indexOf("HTTP/") == 0 && split[2].indexOf(46) > 5) {
                str = split[2];
            } else if (split[0].indexOf("HTTP/") == 0 && split[0].indexOf(46) > 5) {
                str = split[0];
            } else {
                str = null;
            }
            this.rawHeaders.add(readLine);
            if (str != null) {
                String[] split2 = str.substring(5).split("\\.");
                try {
                    this.ver[0] = Integer.parseInt(split2[0]);
                    this.ver[1] = Integer.parseInt(split2[1]);
                } catch (NumberFormatException e16) {
                    PlayerUtils.log(6, this.mLogTag, "error parsing request NumberFormatException" + PlayerUtils.getPrintableStackTrace(e16));
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
                    this.params = new LinkedHashMap<>();
                    for (int i3 = 0; i3 < split3.length; i3++) {
                        String[] split4 = split3[i3].split(ContainerUtils.KEY_VALUE_DELIMITER);
                        if (split4.length == 2) {
                            this.params.put(URLDecoder.decode(split4[0], "UTF-8"), URLDecoder.decode(split4[1], "UTF-8"));
                        } else if (split4.length == 1 && split3[i3].indexOf(61) == split3[i3].length() - 1) {
                            this.params.put(URLDecoder.decode(split4[0], "UTF-8"), "");
                        }
                    }
                }
            }
            parseHeaders();
            return;
        }
        PlayerUtils.log(6, this.mLogTag, "initial is not valid");
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public static Map<String, String> parseHeaders(String str) {
        String[] split = str.split("\r\n");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str2 : split) {
            if (!str2.equals("")) {
                int indexOf = str2.indexOf(58);
                if (indexOf < 0) {
                    linkedHashMap.put("null", str2);
                } else {
                    linkedHashMap.put(str2.substring(0, indexOf).toLowerCase().trim(), str2.substring(indexOf + 1).trim());
                }
            }
        }
        return linkedHashMap;
    }

    private void parseHeaders() throws IOException {
        StringBuilder sb5 = new StringBuilder();
        String readLine = this.reader.readLine();
        sb5.append(readLine);
        sb5.append("|");
        while (true) {
            if (readLine.equals("")) {
                break;
            }
            int indexOf = readLine.indexOf(58);
            if (indexOf < 0) {
                this.headers = null;
                break;
            }
            this.headers.put(readLine.substring(0, indexOf).toLowerCase().trim(), readLine.substring(indexOf + 1).trim());
            this.rawHeaders.add(readLine);
            readLine = this.reader.readLine();
            sb5.append(readLine);
            sb5.append("|");
        }
        PlayerUtils.log(4, this.mLogTag, sb5.toString());
    }
}
