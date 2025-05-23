package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.qqcircle.utils.bj;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSLifecycleCollectionEvent {

    /* renamed from: a, reason: collision with root package name */
    private QFSCollectionType f84998a;

    /* renamed from: b, reason: collision with root package name */
    private c f84999b;

    /* renamed from: c, reason: collision with root package name */
    private d f85000c;

    /* renamed from: d, reason: collision with root package name */
    private b f85001d;

    /* renamed from: e, reason: collision with root package name */
    private a f85002e;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public enum QFSApplicationLifecycleEnum {
        FOREGROUND,
        BACKGROUND
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public enum QFSBusinessLifecycleEnum {
        RELEASE
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public enum QFSCollectionType {
        LIST_LIFECYCLE,
        PAGE_LIFECYCLE,
        BUSINESS_LIFECYCLE,
        APPLICATION_LIFECYCLE
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public enum QFSListLifecycleEnum {
        SELECTED
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public enum QFSPageLifecycleEnum {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private QFSApplicationLifecycleEnum f85003a;

        public a(QFSApplicationLifecycleEnum qFSApplicationLifecycleEnum) {
            this.f85003a = qFSApplicationLifecycleEnum;
        }

        public QFSApplicationLifecycleEnum a() {
            return this.f85003a;
        }

        public String toString() {
            return "QFSApplicationLifecycleInfo{mLifecycle=" + this.f85003a + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private QFSBusinessLifecycleEnum f85004a;

        public b(QFSBusinessLifecycleEnum qFSBusinessLifecycleEnum) {
            this.f85004a = qFSBusinessLifecycleEnum;
        }

        public QFSBusinessLifecycleEnum a() {
            return this.f85004a;
        }

        public String toString() {
            return "QFSBusinessLifecycleInfo{mLifecycle=" + this.f85004a + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private String f85005a;

        /* renamed from: b, reason: collision with root package name */
        private e30.b f85006b;

        /* renamed from: c, reason: collision with root package name */
        private int f85007c;

        /* renamed from: d, reason: collision with root package name */
        private QFSListLifecycleEnum f85008d;

        public c(String str, e30.b bVar, int i3, QFSListLifecycleEnum qFSListLifecycleEnum) {
            this.f85005a = str;
            this.f85006b = bVar;
            this.f85007c = i3;
            this.f85008d = qFSListLifecycleEnum;
        }

        public String a() {
            return this.f85005a;
        }

        public QFSListLifecycleEnum b() {
            return this.f85008d;
        }

        public int c() {
            return this.f85007c;
        }

        public String toString() {
            return "QFSListLifecycleInfo{mDtPageId='" + this.f85005a + "', mFeedId=" + bj.g(this.f85006b) + ", mPosition=" + this.f85007c + ", mLifecycle=" + this.f85008d + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private int f85009a;

        /* renamed from: b, reason: collision with root package name */
        private String f85010b;

        /* renamed from: c, reason: collision with root package name */
        private int f85011c;

        /* renamed from: d, reason: collision with root package name */
        private QFSPageLifecycleEnum f85012d;

        public d(int i3, String str, int i16, QFSPageLifecycleEnum qFSPageLifecycleEnum) {
            this.f85009a = i3;
            this.f85010b = str;
            this.f85011c = i16;
            this.f85012d = qFSPageLifecycleEnum;
        }

        public int a() {
            return this.f85011c;
        }

        public String b() {
            return this.f85010b;
        }

        public QFSPageLifecycleEnum c() {
            return this.f85012d;
        }

        public String toString() {
            return "QFSPageLifecycleInfo{mHashCode=" + this.f85009a + ", mDtPageId='" + this.f85010b + "', mDcPageId='" + this.f85011c + "', mLifecycle=" + this.f85012d + '}';
        }
    }

    public QFSLifecycleCollectionEvent(QFSCollectionType qFSCollectionType, c cVar) {
        this.f84998a = qFSCollectionType;
        this.f84999b = cVar;
    }

    public a a() {
        return this.f85002e;
    }

    public b b() {
        return this.f85001d;
    }

    public QFSCollectionType c() {
        return this.f84998a;
    }

    public c d() {
        return this.f84999b;
    }

    public d e() {
        return this.f85000c;
    }

    public QFSLifecycleCollectionEvent(QFSCollectionType qFSCollectionType, d dVar) {
        this.f84998a = qFSCollectionType;
        this.f85000c = dVar;
    }

    public QFSLifecycleCollectionEvent(QFSCollectionType qFSCollectionType, b bVar) {
        this.f84998a = qFSCollectionType;
        this.f85001d = bVar;
    }

    public QFSLifecycleCollectionEvent(QFSCollectionType qFSCollectionType, a aVar) {
        this.f84998a = qFSCollectionType;
        this.f85002e = aVar;
    }
}
