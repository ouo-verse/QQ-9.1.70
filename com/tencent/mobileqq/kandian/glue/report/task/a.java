package com.tencent.mobileqq.kandian.glue.report.task;

import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class a {

    /* renamed from: j, reason: collision with root package name */
    public static int f239954j = 0;

    /* renamed from: k, reason: collision with root package name */
    public static int f239955k = 1;

    /* renamed from: l, reason: collision with root package name */
    public static int f239956l = 2;

    /* renamed from: m, reason: collision with root package name */
    public static int f239957m = 3;

    /* renamed from: n, reason: collision with root package name */
    public static int f239958n = 4;

    /* renamed from: o, reason: collision with root package name */
    public static int f239959o = 5;

    /* renamed from: p, reason: collision with root package name */
    public static int f239960p = 1;

    /* renamed from: q, reason: collision with root package name */
    public static int f239961q = 2;

    /* renamed from: r, reason: collision with root package name */
    public static int f239962r = 3;

    /* renamed from: s, reason: collision with root package name */
    public static int f239963s = 4;

    /* renamed from: a, reason: collision with root package name */
    public JSContext f239964a;

    /* renamed from: b, reason: collision with root package name */
    public String f239965b;

    /* renamed from: d, reason: collision with root package name */
    public JSONObject f239967d;

    /* renamed from: c, reason: collision with root package name */
    public int f239966c = f239954j;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<C7960a> f239968e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    public ArrayList<C7960a> f239969f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    public ArrayList<C7960a> f239970g = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    public ArrayList<C7960a> f239971h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    public ArrayList<C7960a> f239972i = new ArrayList<>();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.kandian.glue.report.task.a$a, reason: collision with other inner class name */
    /* loaded from: classes33.dex */
    public static class C7960a {

        /* renamed from: a, reason: collision with root package name */
        public String f239973a;

        /* renamed from: b, reason: collision with root package name */
        public String f239974b;

        /* renamed from: c, reason: collision with root package name */
        public ArrayList<String> f239975c = new ArrayList<>();

        /* renamed from: d, reason: collision with root package name */
        public ArrayList<String> f239976d = new ArrayList<>();

        /* renamed from: e, reason: collision with root package name */
        public ArrayList<String> f239977e = new ArrayList<>();
    }

    public String toString() {
        return "Task{jsContext=" + this.f239964a + ", id='" + this.f239965b + "', status=" + this.f239966c + ", config=" + this.f239967d + ", filter=" + Arrays.toString(this.f239968e.toArray()) + ", extraction=" + Arrays.toString(this.f239969f.toArray()) + ", process=" + Arrays.toString(this.f239970g.toArray()) + ", distribution=" + Arrays.toString(this.f239971h.toArray()) + ", check=" + Arrays.toString(this.f239972i.toArray()) + '}';
    }
}
