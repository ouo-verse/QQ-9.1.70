package org.apache.httpcore.impl;

import java.util.Locale;
import org.apache.httpcore.HttpStatus;
import org.apache.httpcore.ReasonPhraseCatalog;
import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;
import org.apache.httpcore.util.Args;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes29.dex */
public class EnglishReasonPhraseCatalog implements ReasonPhraseCatalog {
    public static final EnglishReasonPhraseCatalog INSTANCE = new EnglishReasonPhraseCatalog();
    private static final String[][] REASON_PHRASES = {null, new String[3], new String[8], new String[8], new String[30], new String[8]};

    static {
        setReason(200, "OK");
        setReason(201, "Created");
        setReason(202, "Accepted");
        setReason(204, "No Content");
        setReason(301, "Moved Permanently");
        setReason(302, "Moved Temporarily");
        setReason(304, "Not Modified");
        setReason(400, "Bad Request");
        setReason(401, "Unauthorized");
        setReason(403, "Forbidden");
        setReason(404, "Not Found");
        setReason(HttpStatus.SC_TOO_MANY_REQUESTS, "Too Many Requests");
        setReason(500, "Internal Server Error");
        setReason(501, "Not Implemented");
        setReason(502, "Bad Gateway");
        setReason(503, "Service Unavailable");
        setReason(100, "Continue");
        setReason(307, "Temporary Redirect");
        setReason(405, "Method Not Allowed");
        setReason(409, "Conflict");
        setReason(412, "Precondition Failed");
        setReason(413, "Request Too Long");
        setReason(414, "Request-URI Too Long");
        setReason(415, "Unsupported Media Type");
        setReason(300, "Multiple Choices");
        setReason(303, "See Other");
        setReason(305, "Use Proxy");
        setReason(402, "Payment Required");
        setReason(406, "Not Acceptable");
        setReason(407, "Proxy Authentication Required");
        setReason(408, "Request Timeout");
        setReason(101, "Switching Protocols");
        setReason(203, "Non Authoritative Information");
        setReason(205, "Reset Content");
        setReason(206, "Partial Content");
        setReason(504, "Gateway Timeout");
        setReason(505, "Http Version Not Supported");
        setReason(410, "Gone");
        setReason(411, "Length Required");
        setReason(416, "Requested Range Not Satisfiable");
        setReason(417, "Expectation Failed");
        setReason(102, "Processing");
        setReason(207, "Multi-Status");
        setReason(422, "Unprocessable Entity");
        setReason(419, "Insufficient Space On Resource");
        setReason(420, "Method Failure");
        setReason(423, "Locked");
        setReason(507, "Insufficient Storage");
        setReason(424, "Failed Dependency");
    }

    protected EnglishReasonPhraseCatalog() {
    }

    private static void setReason(int i3, String str) {
        int i16 = i3 / 100;
        REASON_PHRASES[i16][i3 - (i16 * 100)] = str;
    }

    @Override // org.apache.httpcore.ReasonPhraseCatalog
    public String getReason(int i3, Locale locale) {
        boolean z16;
        if (i3 >= 100 && i3 < 600) {
            z16 = true;
        } else {
            z16 = false;
        }
        Args.check(z16, "Unknown category for status code " + i3);
        int i16 = i3 / 100;
        int i17 = i3 - (i16 * 100);
        String[] strArr = REASON_PHRASES[i16];
        if (strArr.length > i17) {
            return strArr[i17];
        }
        return null;
    }
}
