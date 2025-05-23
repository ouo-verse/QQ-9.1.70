package am0;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private Object[] f26288a;

    /* renamed from: b, reason: collision with root package name */
    private int f26289b;

    /* renamed from: c, reason: collision with root package name */
    private BusinessFeedData f26290c;

    /* compiled from: P */
    /* renamed from: am0.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public static class C0048a {

        /* renamed from: a, reason: collision with root package name */
        private Object[] f26291a;

        /* renamed from: b, reason: collision with root package name */
        private int f26292b;

        /* renamed from: c, reason: collision with root package name */
        private BusinessFeedData f26293c;

        public a a() {
            a aVar = new a();
            aVar.f26288a = this.f26291a;
            aVar.f26289b = this.f26292b;
            aVar.f26290c = this.f26293c;
            return aVar;
        }

        public C0048a b(Object[] objArr) {
            this.f26291a = objArr;
            return this;
        }

        public C0048a c(BusinessFeedData businessFeedData) {
            this.f26293c = businessFeedData;
            return this;
        }

        public C0048a d(int i3) {
            this.f26292b = i3;
            return this;
        }
    }

    public Object[] d() {
        return this.f26288a;
    }

    public BusinessFeedData e() {
        return this.f26290c;
    }

    public int f() {
        return this.f26289b;
    }

    public boolean g() {
        BusinessFeedData businessFeedData = this.f26290c;
        return businessFeedData != null && businessFeedData.isGDTAdvFeed();
    }
}
