package com.yolo.esports.download.common;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap<String, DownloadInfo> f390029a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public final Object f390030b = new Object();

    public boolean a(String str) {
        boolean containsKey;
        synchronized (this.f390030b) {
            containsKey = this.f390029a.containsKey(str);
        }
        return containsKey;
    }

    public DownloadInfo b(String str) {
        DownloadInfo downloadInfo;
        synchronized (this.f390030b) {
            downloadInfo = this.f390029a.get(str);
        }
        return downloadInfo;
    }

    public DownloadInfo c(String str, DownloadInfo downloadInfo) {
        synchronized (this.f390030b) {
            if (downloadInfo != null) {
                if (!TextUtils.isEmpty(str)) {
                    return this.f390029a.put(str, downloadInfo);
                }
            }
            return null;
        }
    }

    public DownloadInfo d(Object obj) {
        DownloadInfo remove;
        synchronized (this.f390030b) {
            remove = this.f390029a.remove(obj);
        }
        return remove;
    }

    public String toString() {
        String sb5;
        synchronized (this.f390030b) {
            try {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("downloadInfos, size=");
                sb6.append(this.f390029a.keySet().size());
                sb6.append("{\n");
                Iterator<String> it = this.f390029a.keySet().iterator();
                while (it.hasNext()) {
                    sb6.append(this.f390029a.get(it.next()).toString());
                    sb6.append("\n");
                }
                sb6.append("}\n");
                sb5 = sb6.toString();
            } catch (Throwable unused) {
                return "";
            }
        }
        return sb5;
    }
}
