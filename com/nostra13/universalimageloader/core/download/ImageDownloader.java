package com.nostra13.universalimageloader.core.download;

import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface ImageDownloader {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum Scheme {
        HTTP("http"),
        HTTPS("https"),
        FILE("file"),
        CONTENT("content"),
        ASSETS("assets"),
        DRAWABLE("drawable"),
        UNKNOWN("");

        private String scheme;
        private String uriPrefix;

        Scheme(String str) {
            this.scheme = str;
            this.uriPrefix = str + QzoneWebViewOfflinePlugin.STR_DEVIDER;
        }

        private boolean belongsTo(String str) {
            return str.toLowerCase(Locale.US).startsWith(this.uriPrefix);
        }

        public static Scheme ofUri(String str) {
            if (str != null) {
                for (Scheme scheme : values()) {
                    if (scheme.belongsTo(str)) {
                        return scheme;
                    }
                }
            }
            return UNKNOWN;
        }

        public String crop(String str) {
            if (belongsTo(str)) {
                return str.substring(this.uriPrefix.length());
            }
            throw new IllegalArgumentException(String.format("URI [%1$s] doesn't have expected scheme [%2$s]", str, this.scheme));
        }

        public String wrap(String str) {
            return this.uriPrefix + str;
        }
    }

    InputStream getStream(String str, Object obj) throws IOException;
}
