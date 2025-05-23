package com.tencent.hippy.qq.update.qarchive.tools.zip;

import java.util.zip.ZipException;

/* compiled from: P */
/* loaded from: classes7.dex */
public class UnsupportedZipFeatureException extends ZipException {
    private static final long serialVersionUID = 4430521921766595597L;
    private final ZipEntry entry;
    private final Feature reason;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class Feature {
        private final String name;
        public static final Feature ENCRYPTION = new Feature("encryption");
        public static final Feature METHOD = new Feature("compression method");
        public static final Feature DATA_DESCRIPTOR = new Feature("data descriptor");

        Feature(String str) {
            this.name = str;
        }

        public String toString() {
            return this.name;
        }
    }

    public UnsupportedZipFeatureException(Feature feature, ZipEntry zipEntry) {
        super("unsupported feature " + feature + " used in entry " + zipEntry.getName());
        this.reason = feature;
        this.entry = zipEntry;
    }

    public ZipEntry getEntry() {
        return this.entry;
    }

    public Feature getFeature() {
        return this.reason;
    }
}
