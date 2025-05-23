package com.tencent.xweb;

import com.tencent.xweb.LibraryLoader;
import com.tencent.xweb.util.IXWebLogClient;
import com.tencent.xweb.util.WebViewExtensionListener;

/* compiled from: P */
/* loaded from: classes27.dex */
public class XWebEnvironmentConfig {

    /* renamed from: a, reason: collision with root package name */
    public IXWebLogClient f385042a;

    /* renamed from: b, reason: collision with root package name */
    public WebViewReporterInterface f385043b;

    /* renamed from: c, reason: collision with root package name */
    public ISharedPreferenceProvider f385044c;

    /* renamed from: d, reason: collision with root package name */
    public LibraryLoader.ILibraryLoader f385045d;

    /* renamed from: e, reason: collision with root package name */
    public WebViewExtensionListener f385046e;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class XWebEnvironmentConfigBuilder {

        /* renamed from: a, reason: collision with root package name */
        public IXWebLogClient f385047a;

        /* renamed from: b, reason: collision with root package name */
        public WebViewReporterInterface f385048b;

        /* renamed from: c, reason: collision with root package name */
        public ISharedPreferenceProvider f385049c;

        /* renamed from: d, reason: collision with root package name */
        public LibraryLoader.ILibraryLoader f385050d;

        /* renamed from: e, reason: collision with root package name */
        public WebViewExtensionListener f385051e;

        public XWebEnvironmentConfig createXWebEnvironmentConfig() {
            return new XWebEnvironmentConfig(this.f385047a, this.f385048b, this.f385049c, this.f385050d, this.f385051e);
        }

        public XWebEnvironmentConfigBuilder setLibraryLoader(LibraryLoader.ILibraryLoader iLibraryLoader) {
            this.f385050d = iLibraryLoader;
            return this;
        }

        public XWebEnvironmentConfigBuilder setLogInterface(IXWebLogClient iXWebLogClient) {
            this.f385047a = iXWebLogClient;
            return this;
        }

        public XWebEnvironmentConfigBuilder setReporterInterface(WebViewReporterInterface webViewReporterInterface) {
            this.f385048b = webViewReporterInterface;
            return this;
        }

        public XWebEnvironmentConfigBuilder setSharedPreferenceProvider(ISharedPreferenceProvider iSharedPreferenceProvider) {
            this.f385049c = iSharedPreferenceProvider;
            return this;
        }

        public XWebEnvironmentConfigBuilder setWebViewExtensionListener(WebViewExtensionListener webViewExtensionListener) {
            this.f385051e = webViewExtensionListener;
            return this;
        }
    }

    public XWebEnvironmentConfig(IXWebLogClient iXWebLogClient, WebViewReporterInterface webViewReporterInterface, ISharedPreferenceProvider iSharedPreferenceProvider, LibraryLoader.ILibraryLoader iLibraryLoader, WebViewExtensionListener webViewExtensionListener) {
        this.f385042a = iXWebLogClient;
        this.f385043b = webViewReporterInterface;
        this.f385044c = iSharedPreferenceProvider;
        this.f385045d = iLibraryLoader;
        this.f385046e = webViewExtensionListener;
    }

    public LibraryLoader.ILibraryLoader getLibraryLoader() {
        return this.f385045d;
    }

    public IXWebLogClient getLogInterface() {
        return this.f385042a;
    }

    public WebViewReporterInterface getReporterInterface() {
        return this.f385043b;
    }

    public ISharedPreferenceProvider getSharedPreferenceProvider() {
        return this.f385044c;
    }

    public WebViewExtensionListener getWebViewExtensionListener() {
        return this.f385046e;
    }
}
