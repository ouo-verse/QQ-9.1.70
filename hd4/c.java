package hd4;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class c {

    /* renamed from: c, reason: collision with root package name */
    public static final String f404773c = null;

    /* renamed from: d, reason: collision with root package name */
    public static final Map<String, String> f404774d = null;

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final String f404775a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final Map<String, String> f404776b;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    protected static abstract class a<ReportInfoBuilder extends a<ReportInfoBuilder, ReportInfo>, ReportInfo extends c> {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private String f404777a = c.f404773c;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private Map<String, String> f404778b = c.f404774d;

        public ReportInfoBuilder c(@NonNull String str) {
            this.f404777a = str;
            return e();
        }

        public ReportInfoBuilder d(@Nullable Map<String, String> map) {
            this.f404778b = map;
            return e();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @NonNull
        public abstract ReportInfoBuilder e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(@NonNull a aVar) {
        this.f404775a = aVar.f404777a;
        this.f404776b = aVar.f404778b;
    }

    @NonNull
    public String a() {
        return this.f404775a;
    }

    @Nullable
    public Map<String, String> b() {
        return this.f404776b;
    }
}
