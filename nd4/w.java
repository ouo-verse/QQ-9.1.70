package nd4;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private String f420042a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private List<z> f420043b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private List<String> f420044c;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private String f420045a;

        /* renamed from: b, reason: collision with root package name */
        @NonNull
        private List<z> f420046b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        @NonNull
        private List<String> f420047c = new ArrayList();

        @NonNull
        public w d() {
            return new w(this);
        }

        public b e(@NonNull List<String> list) {
            this.f420047c = list;
            return this;
        }

        public b f(@NonNull String str) {
            this.f420045a = str;
            return this;
        }

        public b g(@NonNull List<z> list) {
            this.f420046b = list;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public w h(@NonNull w wVar, @NonNull List<z> list) {
            f(wVar.b()).e(wVar.a()).g(list);
            return new w(this);
        }
    }

    @NonNull
    public List<String> a() {
        return this.f420044c;
    }

    @NonNull
    public String b() {
        return this.f420042a;
    }

    @NonNull
    public List<z> c() {
        return this.f420043b;
    }

    w(b bVar) {
        this.f420042a = bVar.f420045a;
        this.f420043b = bVar.f420046b;
        this.f420044c = bVar.f420047c;
    }
}
