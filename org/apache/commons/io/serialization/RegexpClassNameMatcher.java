package org.apache.commons.io.serialization;

import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes29.dex */
final class RegexpClassNameMatcher implements ClassNameMatcher {
    private final Pattern pattern;

    public RegexpClassNameMatcher(String str) {
        this(Pattern.compile(str));
    }

    @Override // org.apache.commons.io.serialization.ClassNameMatcher
    public boolean matches(String str) {
        return this.pattern.matcher(str).matches();
    }

    public RegexpClassNameMatcher(Pattern pattern) {
        if (pattern != null) {
            this.pattern = pattern;
            return;
        }
        throw new IllegalArgumentException("Null pattern");
    }
}
