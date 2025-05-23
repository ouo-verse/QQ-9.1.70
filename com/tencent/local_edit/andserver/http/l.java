package com.tencent.local_edit.andserver.http;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.net.URI;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import org.apache.commons.io.Charsets;

/* compiled from: P */
/* loaded from: classes7.dex */
public class l implements com.tencent.local_edit.andserver.util.g {

    /* renamed from: h, reason: collision with root package name */
    private final String f119817h;

    /* renamed from: i, reason: collision with root package name */
    private final String f119818i;

    /* renamed from: j, reason: collision with root package name */
    private final int f119819j;

    /* renamed from: k, reason: collision with root package name */
    private final String f119820k;

    /* renamed from: l, reason: collision with root package name */
    private final String f119821l;

    /* renamed from: m, reason: collision with root package name */
    private final String f119822m;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private String f119823a;

        /* renamed from: b, reason: collision with root package name */
        private String f119824b;

        /* renamed from: c, reason: collision with root package name */
        private int f119825c;

        /* renamed from: d, reason: collision with root package name */
        private List<String> f119826d;

        /* renamed from: e, reason: collision with root package name */
        private com.tencent.local_edit.andserver.util.f<String, String> f119827e;

        /* renamed from: f, reason: collision with root package name */
        private String f119828f;

        public l g() {
            return new l(this);
        }

        public b h(@NonNull String str) {
            this.f119826d = l.f(str);
            return this;
        }

        b(@NonNull String str) {
            URI create = URI.create(str);
            this.f119823a = create.getScheme();
            this.f119824b = create.getHost();
            this.f119825c = create.getPort();
            this.f119826d = l.f(create.getPath());
            this.f119827e = l.h(create.getRawQuery());
            this.f119828f = create.getFragment();
        }
    }

    public static b d(String str) {
        return new b(str);
    }

    public static String e(com.tencent.local_edit.andserver.util.f<String, String> fVar) {
        StringBuilder sb5 = new StringBuilder();
        Iterator<Map.Entry<String, String>> it = fVar.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            String key = next.getKey();
            List<String> list = (List) next.getValue();
            if (list != null && !list.isEmpty()) {
                for (String str : list) {
                    sb5.append(key);
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(com.tencent.local_edit.andserver.util.h.c(str, "utf-8"));
                }
            } else {
                sb5.append(key);
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            }
        }
        while (it.hasNext()) {
            Map.Entry<String, String> next2 = it.next();
            String key2 = next2.getKey();
            List<String> list2 = (List) next2.getValue();
            if (list2 != null && !list2.isEmpty()) {
                for (String str2 : list2) {
                    sb5.append(ContainerUtils.FIELD_DELIMITER);
                    sb5.append(key2);
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(com.tencent.local_edit.andserver.util.h.c(str2, "utf-8"));
                }
            } else {
                sb5.append(ContainerUtils.FIELD_DELIMITER);
                sb5.append(key2);
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            }
        }
        return sb5.toString();
    }

    public static List<String> f(String str) {
        LinkedList linkedList = new LinkedList();
        if (TextUtils.isEmpty(str)) {
            return linkedList;
        }
        while (str.contains("//")) {
            str = str.replace("//", "/");
        }
        while (str.contains("/")) {
            if (str.startsWith("/")) {
                linkedList.add("");
                str = str.substring(1);
            } else {
                int indexOf = str.indexOf("/");
                linkedList.add(str.substring(0, indexOf));
                str = str.substring(indexOf + 1);
            }
            if (!str.contains("/")) {
                linkedList.add(str);
            }
        }
        return linkedList;
    }

    public static String g(List<String> list) {
        if (list != null && !list.isEmpty()) {
            StringBuilder sb5 = new StringBuilder();
            for (String str : list) {
                sb5.append("/");
                sb5.append(str);
            }
            String sb6 = sb5.toString();
            while (sb6.contains("//")) {
                sb6 = sb6.replace("//", "/");
            }
            return sb6;
        }
        return "";
    }

    public static com.tencent.local_edit.andserver.util.f<String, String> h(String str) {
        com.tencent.local_edit.andserver.util.e eVar = new com.tencent.local_edit.andserver.util.e();
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                str = str.substring(1);
            }
            StringTokenizer stringTokenizer = new StringTokenizer(str, ContainerUtils.FIELD_DELIMITER);
            while (stringTokenizer.hasMoreElements()) {
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf(ContainerUtils.KEY_VALUE_DELIMITER);
                if (indexOf > 0 && indexOf < nextToken.length() - 1) {
                    eVar.a(nextToken.substring(0, indexOf), com.tencent.local_edit.andserver.util.h.b(nextToken.substring(indexOf + 1), Charsets.toCharset("utf-8")));
                }
            }
        }
        return eVar;
    }

    @NonNull
    public b a() {
        return new b(toString());
    }

    @NonNull
    public com.tencent.local_edit.andserver.util.f<String, String> b() {
        return h(this.f119821l);
    }

    @NonNull
    public String c() {
        return this.f119820k;
    }

    @NonNull
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (!TextUtils.isEmpty(this.f119817h)) {
            sb5.append(this.f119817h);
            sb5.append(":");
        }
        if (!TextUtils.isEmpty(this.f119818i) && this.f119819j > 0) {
            sb5.append("//");
            sb5.append(this.f119818i);
            sb5.append(":");
            sb5.append(this.f119819j);
        }
        if (!TextUtils.isEmpty(this.f119820k)) {
            sb5.append(this.f119820k);
        }
        if (!TextUtils.isEmpty(this.f119821l)) {
            sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
            sb5.append(this.f119821l);
        }
        if (!TextUtils.isEmpty(this.f119822m)) {
            sb5.append("#");
            sb5.append(this.f119822m);
        }
        return sb5.toString();
    }

    l(b bVar) {
        this.f119817h = bVar.f119823a;
        this.f119818i = bVar.f119824b;
        this.f119819j = bVar.f119825c;
        this.f119820k = g(bVar.f119826d);
        this.f119821l = e(bVar.f119827e);
        this.f119822m = bVar.f119828f;
    }
}
