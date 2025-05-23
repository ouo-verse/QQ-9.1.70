package com.tencent.luggage.wxa.bo;

import android.text.TextUtils;
import android.util.Pair;
import android.webkit.MimeTypeMap;
import com.tencent.ark.ark;
import com.tencent.libra.util.ImageContentType;
import com.tencent.local_edit.andserver.util.MediaType;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final Map f123089a;

    /* renamed from: b, reason: collision with root package name */
    public static final Map f123090b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: c, reason: collision with root package name */
        public static final Pattern f123091c = Pattern.compile("([a-zA-Z*-.0-9]+/[a-zA-Z*-.0-9]+)");

        /* renamed from: a, reason: collision with root package name */
        public final String f123092a;

        /* renamed from: b, reason: collision with root package name */
        public final String f123093b;

        public a(String str, String str2) {
            this.f123092a = str;
            this.f123093b = str2;
        }

        public static a a(String str) {
            String str2 = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Matcher matcher = f123091c.matcher(str);
            if (!matcher.find()) {
                return null;
            }
            String group = matcher.group(0);
            if (str.contains("charset=")) {
                str2 = str.substring(str.indexOf("charset=") + 8).trim();
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "UTF-8";
            }
            return new a(group, str2);
        }

        public String toString() {
            return "ContentType{mimeType='" + this.f123092a + "', charset='" + this.f123093b + "'}";
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("silk", "audio/silk"));
        arrayList.add(new Pair("jpg", "image/jpeg"));
        arrayList.add(new Pair(ark.ARKMETADATA_JSON, "application/json"));
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            hashMap.put((String) pair.first, (String) pair.second);
            hashMap2.put((String) pair.second, (String) pair.first);
        }
        f123089a = Collections.unmodifiableMap(hashMap);
        f123090b = Collections.unmodifiableMap(hashMap2);
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String lowerCase = str.toLowerCase();
        String str2 = (String) f123090b.get(lowerCase);
        if (TextUtils.isEmpty(str2)) {
            str2 = MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        }
        if (TextUtils.isEmpty(str2)) {
            if ("audio/mpeg".equals(lowerCase) || "audio/mp3".equals(lowerCase)) {
                return FileReaderHelper.MP3_EXT;
            }
            if ("audio/mp4".equals(lowerCase)) {
                return "mp4";
            }
            if (MediaType.APPLICATION_PDF_VALUE.equals(lowerCase)) {
                return FileReaderHelper.PDF_EXT;
            }
            if ("image/jpeg".equals(lowerCase) || ImageContentType.MIME_TYPE_JPG.equals(lowerCase)) {
                return "jpg";
            }
        }
        return str2;
    }

    public static String b(String str) {
        int lastIndexOf;
        if (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(46)) < 0 || lastIndexOf >= str.length() - 1) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = (String) f123089a.get(str.toLowerCase());
        if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            str2 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
        }
        if (TextUtils.isEmpty(str2) && FileReaderHelper.MP3_EXT.equals(str)) {
            return "audio/mpeg";
        }
        return str2;
    }

    public static String d(String str) {
        return c(b(str));
    }
}
