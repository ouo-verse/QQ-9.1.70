package com.tencent.av.ManageConfig;

import com.tencent.mobileqq.jsonconverter.Alias;
import com.tencent.weiyun.transmission.db.JobDbManager;
import java.util.List;
import tl.h;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    @Alias("testInfos")
    public List<C0728a> f72817a;

    /* compiled from: P */
    /* renamed from: com.tencent.av.ManageConfig.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0728a {

        /* renamed from: a, reason: collision with root package name */
        @Alias("min_version")
        public String f72818a;

        /* renamed from: b, reason: collision with root package name */
        @Alias("codec")
        public int f72819b;

        /* renamed from: c, reason: collision with root package name */
        @Alias("min_sdk")
        public int f72820c;

        /* renamed from: d, reason: collision with root package name */
        @Alias("async_min_sdk")
        public int f72821d;

        /* renamed from: e, reason: collision with root package name */
        @Alias(JobDbManager.TBL_UPLOAD)
        public boolean f72822e;

        /* renamed from: f, reason: collision with root package name */
        @Alias("disable_sdks")
        public List<Integer> f72823f;

        /* renamed from: g, reason: collision with root package name */
        @Alias("test_ver")
        public int f72824g;

        /* renamed from: h, reason: collision with root package name */
        @Alias("samples")
        public List<C0729a> f72825h;

        /* renamed from: i, reason: collision with root package name */
        @Alias("expdate")
        public String f72826i;

        /* compiled from: P */
        /* renamed from: com.tencent.av.ManageConfig.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0729a {

            /* renamed from: a, reason: collision with root package name */
            @Alias("w")
            public int f72827a;

            /* renamed from: b, reason: collision with root package name */
            @Alias(h.F)
            public int f72828b;

            /* renamed from: c, reason: collision with root package name */
            @Alias("exp")
            public String f72829c;

            /* renamed from: d, reason: collision with root package name */
            @Alias("url")
            public String f72830d;

            /* renamed from: e, reason: collision with root package name */
            @Alias("md5")
            public String f72831e;
        }
    }

    public static a a(String str) {
        return (a) com.tencent.mobileqq.jsonconverter.a.e(str, a.class);
    }
}
