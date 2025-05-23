package com.tencent.luggage.wxa.qj;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static long f138902a;

    /* renamed from: b, reason: collision with root package name */
    public static final List f138903b = Collections.synchronizedList(new LinkedList());

    /* renamed from: c, reason: collision with root package name */
    public static volatile Boolean f138904c = Boolean.FALSE;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f138905a;

        /* renamed from: b, reason: collision with root package name */
        public String f138906b;

        /* renamed from: c, reason: collision with root package name */
        public String f138907c;

        /* renamed from: d, reason: collision with root package name */
        public String f138908d;

        /* renamed from: e, reason: collision with root package name */
        public long f138909e;

        /* renamed from: f, reason: collision with root package name */
        public long f138910f;

        /* renamed from: g, reason: collision with root package name */
        public String f138911g;

        public String toString() {
            return this.f138908d + "," + this.f138906b + "," + this.f138907c + "," + (this.f138909e - c.f138902a) + "," + (this.f138910f - c.f138902a) + "," + this.f138911g;
        }
    }

    public static synchronized Boolean b() {
        Boolean bool;
        synchronized (c.class) {
            bool = f138904c;
        }
        return bool;
    }

    public static void a(String str, String str2, String str3, double d16) {
        long currentTimeMillis = System.currentTimeMillis();
        a(str, str2, str3, BdhLogUtil.LogTag.Tag_Conn, currentTimeMillis, currentTimeMillis, String.format("{\"%s\":%f}", str3, Double.valueOf(d16)));
    }

    public static void a(String str, String str2, String str3, String str4, long j3, long j16, String str5) {
        if (b().booleanValue()) {
            a aVar = new a();
            aVar.f138905a = str;
            aVar.f138908d = str3;
            aVar.f138906b = str2;
            aVar.f138907c = str4;
            aVar.f138909e = j3;
            aVar.f138910f = j16;
            aVar.f138911g = str5 != null ? URLEncoder.encode(str5) : "";
            List list = f138903b;
            if (list.size() < 10000) {
                list.add(aVar);
            }
        }
    }
}
