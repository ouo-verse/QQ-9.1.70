package com.tencent.component.network.downloader;

import android.text.TextUtils;
import com.tencent.component.network.utils.NetworkUtils;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class UrlKeyGenerator {
    public static final UrlKeyGenerator GENERATOR_DESPITE_DOMAIN;
    public static final UrlKeyGenerator GENERATOR_DESPITE_HASH;
    private static final String HTTPS_PREFIX = "https://";
    private static final String HTTP_PREFIX = "http://";

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static class GeneratorDespiteDomain extends UrlKeyGenerator {
        GeneratorDespiteDomain() {
        }

        @Override // com.tencent.component.network.downloader.UrlKeyGenerator
        public String generate(String str) {
            int indexOf;
            if (UrlKeyGenerator.startsWithIgnoreCase(str, "http://")) {
                indexOf = str.indexOf("/", 7);
            } else if (UrlKeyGenerator.startsWithIgnoreCase(str, "https://")) {
                indexOf = str.indexOf("/", 8);
            } else {
                indexOf = str.indexOf("/");
            }
            if (indexOf != -1) {
                return str.substring(indexOf);
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static class GeneratorDespiteHash extends GeneratorDespiteDomain {
        GeneratorDespiteHash() {
            super();
        }

        @Override // com.tencent.component.network.downloader.UrlKeyGenerator.GeneratorDespiteDomain, com.tencent.component.network.downloader.UrlKeyGenerator
        public String generate(String str) {
            String generate = super.generate(str);
            if (TextUtils.isEmpty(generate)) {
                return generate;
            }
            int indexOf = generate.indexOf(35);
            if (indexOf > 0) {
                return generate.substring(0, indexOf);
            }
            return generate;
        }
    }

    static {
        GENERATOR_DESPITE_DOMAIN = new GeneratorDespiteDomain();
        GENERATOR_DESPITE_HASH = new GeneratorDespiteHash();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean startsWithIgnoreCase(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str != null && str2 != null) {
            return str.regionMatches(true, 0, str2, 0, str2.length());
        }
        return false;
    }

    public final String doGenerate(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (!NetworkUtils.isNetworkUrl(str)) {
            return str;
        }
        return generate(str);
    }

    public abstract String generate(String str);
}
