package com.tencent.xweb;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes27.dex */
public final class ProxyConfig {
    public static final String MATCH_ALL_SCHEMES = "*";
    public static final String MATCH_HTTP = "http";
    public static final String MATCH_HTTPS = "https";

    /* renamed from: a, reason: collision with root package name */
    public List f384959a;

    /* renamed from: b, reason: collision with root package name */
    public List f384960b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f384961c;

    /* loaded from: classes27.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public List f384962a;

        /* renamed from: b, reason: collision with root package name */
        public List f384963b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f384964c;

        public Builder() {
            this.f384964c = false;
            this.f384962a = new ArrayList();
            this.f384963b = new ArrayList();
        }

        public final List a() {
            return this.f384963b;
        }

        @NonNull
        public Builder addBypassRule(@NonNull String str) {
            this.f384963b.add(str);
            return this;
        }

        @NonNull
        public Builder addDirect(@NonNull String str) {
            this.f384962a.add(new ProxyRule(str, "direct://"));
            return this;
        }

        @NonNull
        public Builder addProxyRule(@NonNull String str) {
            this.f384962a.add(new ProxyRule(str));
            return this;
        }

        public final List b() {
            return this.f384962a;
        }

        @NonNull
        public ProxyConfig build() {
            return new ProxyConfig(b(), a(), c());
        }

        @NonNull
        public Builder bypassSimpleHostnames() {
            return addBypassRule("<local>");
        }

        public final boolean c() {
            return this.f384964c;
        }

        @NonNull
        public Builder removeImplicitRules() {
            return addBypassRule("<-loopback>");
        }

        @NonNull
        public Builder setReverseBypassEnabled(boolean z16) {
            this.f384964c = z16;
            return this;
        }

        @NonNull
        public Builder addDirect() {
            return addDirect("*");
        }

        @NonNull
        public Builder addProxyRule(@NonNull String str, @NonNull String str2) {
            this.f384962a.add(new ProxyRule(str2, str));
            return this;
        }

        public Builder(@NonNull ProxyConfig proxyConfig) {
            this.f384964c = false;
            this.f384962a = proxyConfig.getProxyRules();
            this.f384963b = proxyConfig.getBypassRules();
            this.f384964c = proxyConfig.isReverseBypassEnabled();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes27.dex */
    public @interface ProxyScheme {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public ProxyConfig(@NonNull List<ProxyRule> list, @NonNull List<String> list2, boolean z16) {
        this.f384959a = list;
        this.f384960b = list2;
        this.f384961c = z16;
    }

    @NonNull
    public List<String> getBypassRules() {
        return Collections.unmodifiableList(this.f384960b);
    }

    @NonNull
    public List<ProxyRule> getProxyRules() {
        return Collections.unmodifiableList(this.f384959a);
    }

    public boolean isReverseBypassEnabled() {
        return this.f384961c;
    }

    /* loaded from: classes27.dex */
    public static final class ProxyRule {

        /* renamed from: a, reason: collision with root package name */
        public String f384965a;

        /* renamed from: b, reason: collision with root package name */
        public String f384966b;

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public ProxyRule(@NonNull String str, @NonNull String str2) {
            this.f384965a = str;
            this.f384966b = str2;
        }

        @NonNull
        public String getSchemeFilter() {
            return this.f384965a;
        }

        @NonNull
        public String getUrl() {
            return this.f384966b;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public ProxyRule(@NonNull String str) {
            this("*", str);
        }
    }
}
