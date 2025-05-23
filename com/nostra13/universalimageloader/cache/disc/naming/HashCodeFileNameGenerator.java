package com.nostra13.universalimageloader.cache.disc.naming;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HashCodeFileNameGenerator implements FileNameGenerator {
    @Override // com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator
    public String generate(String str) {
        return String.valueOf(str.hashCode());
    }
}
