package com.tencent.mobileqq.guild.nt.misc.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import java.util.Map;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IUploadApi extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f230929a;

        /* renamed from: b, reason: collision with root package name */
        public final String f230930b;

        public a(String str, String str2) {
            this.f230929a = str;
            this.f230930b = str2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface b {
        void a(c cVar, d dVar);
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface c {
        d a();

        void b();
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public int f230931a;

        /* renamed from: b, reason: collision with root package name */
        public int f230932b;

        /* renamed from: c, reason: collision with root package name */
        public int f230933c;

        /* renamed from: d, reason: collision with root package name */
        public String f230934d;

        public String toString() {
            return "TaskState{state=" + this.f230931a + ", code=" + this.f230932b + ", progress=" + this.f230933c + ", content='" + this.f230934d + "'}";
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public String f230935a;

        /* renamed from: b, reason: collision with root package name */
        public String f230936b;

        /* renamed from: c, reason: collision with root package name */
        public String f230937c;

        /* renamed from: d, reason: collision with root package name */
        public Map<String, String> f230938d;

        /* renamed from: e, reason: collision with root package name */
        public List<a> f230939e;

        /* renamed from: f, reason: collision with root package name */
        public b f230940f;

        public String toString() {
            return "UploadParam{host='" + this.f230935a + "', urlEndPoint='" + this.f230936b + "', filePath='" + this.f230937c + "', queryStrings=" + this.f230938d + ", cookies=" + this.f230939e + ", listener=" + this.f230940f + '}';
        }
    }

    c startUploadTask(e eVar);
}
