package com.tencent.qqperf.reporter.flow;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final int f363359a;

    /* renamed from: b, reason: collision with root package name */
    private final int f363360b;

    /* renamed from: c, reason: collision with root package name */
    private final int f363361c;

    /* renamed from: d, reason: collision with root package name */
    private final String f363362d;

    /* renamed from: e, reason: collision with root package name */
    private final String f363363e;

    /* renamed from: f, reason: collision with root package name */
    private final String f363364f;

    /* renamed from: g, reason: collision with root package name */
    private final String f363365g;

    /* renamed from: h, reason: collision with root package name */
    private final String f363366h;

    /* renamed from: i, reason: collision with root package name */
    private final String f363367i;

    /* renamed from: j, reason: collision with root package name */
    private final String f363368j;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        int f363369a = 0;

        /* renamed from: b, reason: collision with root package name */
        int f363370b = 0;

        /* renamed from: c, reason: collision with root package name */
        int f363371c = 1;

        /* renamed from: d, reason: collision with root package name */
        String f363372d = "";

        /* renamed from: e, reason: collision with root package name */
        String f363373e = "";

        /* renamed from: g, reason: collision with root package name */
        String f363375g = "";

        /* renamed from: f, reason: collision with root package name */
        String f363374f = "";

        /* renamed from: h, reason: collision with root package name */
        String f363376h = "";

        /* renamed from: i, reason: collision with root package name */
        String f363377i = "";

        /* renamed from: j, reason: collision with root package name */
        String f363378j = "";

        public b a() {
            return new b(this);
        }

        public a b(int i3) {
            this.f363369a = i3;
            return this;
        }

        public a c(String str) {
            this.f363372d = str;
            return this;
        }

        public a d(String str) {
            this.f363373e = str;
            return this;
        }

        public a e(String str) {
            this.f363375g = str;
            return this;
        }

        public a f(int i3) {
            this.f363371c = i3;
            return this;
        }

        public a g(int i3) {
            this.f363370b = i3;
            return this;
        }

        public a h(String str) {
            this.f363376h = str;
            return this;
        }

        public a i(String str) {
            this.f363377i = str;
            return this;
        }

        public a j(String str) {
            this.f363378j = str;
            return this;
        }

        public a k(String str) {
            this.f363374f = str;
            return this;
        }
    }

    public b(a aVar) {
        this.f363359a = aVar.f363369a;
        this.f363360b = aVar.f363370b;
        this.f363361c = aVar.f363371c;
        this.f363362d = aVar.f363372d;
        this.f363363e = aVar.f363373e;
        this.f363365g = aVar.f363375g;
        this.f363364f = aVar.f363374f;
        this.f363366h = aVar.f363376h;
        this.f363367i = aVar.f363377i;
        this.f363368j = aVar.f363378j;
    }

    public HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(PreDownloadConstants.RPORT_KEY_BUSINESS_ID, String.valueOf(this.f363359a));
        hashMap.put(DKEngine.GlobalKey.NET_WORK_TYPE, String.valueOf(this.f363360b));
        hashMap.put("isForeground", String.valueOf(this.f363361c));
        hashMap.put("businessScene", this.f363362d);
        hashMap.put("entrancePath", this.f363363e);
        hashMap.put("url", this.f363364f);
        hashMap.put("flowAmount", this.f363365g);
        hashMap.put("reserveField1", this.f363366h);
        hashMap.put("reserveField2", this.f363367i);
        hashMap.put("reserveField3", this.f363368j);
        return hashMap;
    }

    public String b() {
        return "businessID=" + this.f363359a + "," + DKEngine.GlobalKey.NET_WORK_TYPE + ContainerUtils.KEY_VALUE_DELIMITER + this.f363360b + ",isForeground" + ContainerUtils.KEY_VALUE_DELIMITER + this.f363361c + ",businessScene" + ContainerUtils.KEY_VALUE_DELIMITER + this.f363362d + ",entrancePath" + ContainerUtils.KEY_VALUE_DELIMITER + this.f363363e + ",flowAmount" + ContainerUtils.KEY_VALUE_DELIMITER + this.f363365g;
    }
}
