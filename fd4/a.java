package fd4;

import android.support.annotation.NonNull;
import com.tencent.tab.exp.sdk.export.injector.network.TabNetworkMethod;
import com.tencent.tab.exp.sdk.impl.x;
import fd4.a;
import fd4.a.AbstractC10306a;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class a<Data, RequestBuilder extends AbstractC10306a<Data, RequestBuilder, Request>, Request extends a<Data, RequestBuilder, Request>> {

    /* renamed from: g, reason: collision with root package name */
    private static final TabNetworkMethod f398337g = TabNetworkMethod.POST;

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final TabNetworkMethod f398338a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final String f398339b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private final Data f398340c;

    /* renamed from: d, reason: collision with root package name */
    private final int f398341d;

    /* renamed from: e, reason: collision with root package name */
    private final int f398342e;

    /* renamed from: f, reason: collision with root package name */
    private final int f398343f;

    /* compiled from: P */
    /* renamed from: fd4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    protected static abstract class AbstractC10306a<Data, RequestBuilder extends AbstractC10306a<Data, RequestBuilder, Request>, Request extends a<Data, RequestBuilder, Request>> {

        /* renamed from: a, reason: collision with root package name */
        protected TabNetworkMethod f398344a = a.f398337g;

        /* renamed from: b, reason: collision with root package name */
        protected String f398345b = "";

        /* renamed from: c, reason: collision with root package name */
        protected Data f398346c = null;

        /* renamed from: d, reason: collision with root package name */
        protected int f398347d;

        /* renamed from: e, reason: collision with root package name */
        protected int f398348e;

        /* renamed from: f, reason: collision with root package name */
        protected int f398349f;

        public RequestBuilder a(int i3) {
            this.f398347d = i3;
            return c();
        }

        public RequestBuilder b(@NonNull Data data) {
            this.f398346c = data;
            return c();
        }

        @NonNull
        protected abstract RequestBuilder c();

        public RequestBuilder d(@NonNull TabNetworkMethod tabNetworkMethod) {
            this.f398344a = tabNetworkMethod;
            return c();
        }

        public RequestBuilder e(int i3) {
            this.f398348e = i3;
            return c();
        }

        public RequestBuilder f(@NonNull String str) {
            this.f398345b = str;
            return c();
        }

        public RequestBuilder g(int i3) {
            this.f398349f = i3;
            return c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(@NonNull AbstractC10306a<Data, RequestBuilder, Request> abstractC10306a) {
        this.f398338a = (TabNetworkMethod) x.e(abstractC10306a.f398344a, f398337g);
        this.f398339b = x.d(abstractC10306a.f398345b, "");
        this.f398340c = abstractC10306a.f398346c;
        this.f398341d = abstractC10306a.f398347d;
        this.f398342e = abstractC10306a.f398348e;
        this.f398343f = abstractC10306a.f398349f;
    }

    public int b() {
        return this.f398341d;
    }

    @NonNull
    public Data c() {
        return this.f398340c;
    }

    public int d() {
        return this.f398342e;
    }

    @NonNull
    public String e() {
        return this.f398339b;
    }

    public int f() {
        return this.f398343f;
    }
}
