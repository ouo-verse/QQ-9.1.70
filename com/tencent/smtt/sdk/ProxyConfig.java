package com.tencent.smtt.sdk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes23.dex */
public final class ProxyConfig {
    public static final String MATCH_ALL_SCHEMES = "*";

    /* renamed from: a, reason: collision with root package name */
    private List<ProxyRule> f368982a;

    /* renamed from: b, reason: collision with root package name */
    private List<String> f368983b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f368984c;

    /* loaded from: classes23.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private List<ProxyRule> f368985a;

        /* renamed from: b, reason: collision with root package name */
        private List<String> f368986b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f368987c;

        public Builder() {
            this.f368987c = false;
            this.f368985a = new ArrayList();
            this.f368986b = new ArrayList();
        }

        private List<ProxyRule> a() {
            return this.f368985a;
        }

        private List<String> b() {
            return this.f368986b;
        }

        private boolean c() {
            return this.f368987c;
        }

        public Builder addBypassRule(String str) {
            this.f368986b.add(str);
            return this;
        }

        public Builder addDirect(String str) {
            this.f368985a.add(new ProxyRule(str, "direct://"));
            return this;
        }

        public Builder addProxyRule(String str) {
            this.f368985a.add(new ProxyRule(str));
            return this;
        }

        public ProxyConfig build() {
            return new ProxyConfig(a(), b(), c());
        }

        public Builder bypassSimpleHostnames() {
            return addBypassRule("<local>");
        }

        public Builder removeImplicitRules() {
            return addBypassRule("<-loopback>");
        }

        public Builder setReverseBypassEnabled(boolean z16) {
            this.f368987c = z16;
            return this;
        }

        public Builder addDirect() {
            return addDirect("*");
        }

        public Builder addProxyRule(String str, String str2) {
            this.f368985a.add(new ProxyRule(str2, str));
            return this;
        }

        public Builder(ProxyConfig proxyConfig) {
            this.f368987c = false;
            this.f368985a = proxyConfig.getProxyRules();
            this.f368986b = proxyConfig.getBypassRules();
            this.f368987c = proxyConfig.isReverseBypassEnabled();
        }
    }

    public ProxyConfig(List<ProxyRule> list, List<String> list2, boolean z16) {
        this.f368982a = list;
        this.f368983b = list2;
        this.f368984c = z16;
    }

    public List<String> getBypassRules() {
        return Collections.unmodifiableList(this.f368983b);
    }

    public List<ProxyRule> getProxyRules() {
        return Collections.unmodifiableList(this.f368982a);
    }

    public boolean isReverseBypassEnabled() {
        return this.f368984c;
    }

    /* loaded from: classes23.dex */
    public static final class ProxyRule {

        /* renamed from: a, reason: collision with root package name */
        private String f368988a;

        /* renamed from: b, reason: collision with root package name */
        private String f368989b;

        public ProxyRule(String str, String str2) {
            this.f368988a = str;
            this.f368989b = str2;
        }

        public String getSchemeFilter() {
            return this.f368988a;
        }

        public String getUrl() {
            return this.f368989b;
        }

        public ProxyRule(String str) {
            this("*", str);
        }
    }
}
