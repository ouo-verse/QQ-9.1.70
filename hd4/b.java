package hd4;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import hd4.c;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class b extends c {

    /* renamed from: h, reason: collision with root package name */
    protected static final String f404766h = null;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    protected final String f404767e;

    /* renamed from: f, reason: collision with root package name */
    protected final boolean f404768f;

    /* renamed from: g, reason: collision with root package name */
    protected final boolean f404769g;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    protected static abstract class a<ReportInfoBuilder extends a<ReportInfoBuilder, ReportInfo>, ReportInfo extends b> extends c.a<ReportInfoBuilder, ReportInfo> {

        /* renamed from: c, reason: collision with root package name */
        @NonNull
        private String f404770c = b.f404766h;

        /* renamed from: d, reason: collision with root package name */
        private boolean f404771d = false;

        /* renamed from: e, reason: collision with root package name */
        private boolean f404772e = false;

        public ReportInfoBuilder i(@NonNull String str) {
            this.f404770c = str;
            return (ReportInfoBuilder) e();
        }

        public ReportInfoBuilder j(boolean z16) {
            this.f404771d = z16;
            return (ReportInfoBuilder) e();
        }

        public ReportInfoBuilder k(boolean z16) {
            this.f404772e = z16;
            return (ReportInfoBuilder) e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(@NonNull a aVar) {
        super(aVar);
        this.f404767e = aVar.f404770c;
        this.f404768f = aVar.f404771d;
        this.f404769g = aVar.f404772e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void f(@NonNull Map<String, String> map, @NonNull String str, @Nullable String str2) {
        if (str2 != null) {
            map.put(str, str2);
        }
    }

    @NonNull
    public String c() {
        return this.f404767e;
    }

    public boolean d() {
        return this.f404768f;
    }

    public boolean e() {
        return this.f404769g;
    }
}
