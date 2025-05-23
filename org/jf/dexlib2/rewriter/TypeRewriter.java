package org.jf.dexlib2.rewriter;

import javax.annotation.Nonnull;

/* compiled from: P */
/* loaded from: classes29.dex */
public class TypeRewriter implements Rewriter<String> {
    @Override // org.jf.dexlib2.rewriter.Rewriter
    @Nonnull
    public String rewrite(@Nonnull String str) {
        if (str.length() > 0 && str.charAt(0) == '[') {
            int i3 = 0;
            while (str.charAt(i3) == '[') {
                i3++;
            }
            String substring = str.substring(i3);
            String rewriteUnwrappedType = rewriteUnwrappedType(substring);
            if (substring == rewriteUnwrappedType) {
                return str;
            }
            StringBuilder sb5 = new StringBuilder(rewriteUnwrappedType.length() + i3);
            sb5.append((CharSequence) str, 0, i3);
            sb5.append(rewriteUnwrappedType);
            return sb5.toString();
        }
        return rewriteUnwrappedType(str);
    }

    @Nonnull
    protected String rewriteUnwrappedType(@Nonnull String str) {
        return str;
    }
}
