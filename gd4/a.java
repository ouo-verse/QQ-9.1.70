package gd4;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import gd4.a;
import gd4.a.AbstractC10370a;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class a<Data, ResponseBuilder extends AbstractC10370a<Data, ResponseBuilder, Response>, Response extends a<Data, ResponseBuilder, Response>> {

    /* renamed from: a, reason: collision with root package name */
    private final long f401978a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final Data f401979b;

    /* compiled from: P */
    /* renamed from: gd4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    protected static abstract class AbstractC10370a<Data, ResponseBuilder extends AbstractC10370a<Data, ResponseBuilder, Response>, Response extends a<Data, ResponseBuilder, Response>> {

        /* renamed from: a, reason: collision with root package name */
        protected long f401980a = -1;

        /* renamed from: b, reason: collision with root package name */
        protected Data f401981b = null;

        public ResponseBuilder a(@Nullable Data data) {
            this.f401981b = data;
            return b();
        }

        @NonNull
        protected abstract ResponseBuilder b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(@NonNull AbstractC10370a<Data, ResponseBuilder, Response> abstractC10370a) {
        this.f401978a = abstractC10370a.f401980a;
        this.f401979b = abstractC10370a.f401981b;
    }

    @Nullable
    public Data a() {
        return this.f401979b;
    }
}
