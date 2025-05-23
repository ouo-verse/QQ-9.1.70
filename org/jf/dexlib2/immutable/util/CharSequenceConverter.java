package org.jf.dexlib2.immutable.util;

import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.util.ImmutableConverter;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class CharSequenceConverter {
    private static final ImmutableConverter<String, CharSequence> CONVERTER = new ImmutableConverter<String, CharSequence>() { // from class: org.jf.dexlib2.immutable.util.CharSequenceConverter.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jf.util.ImmutableConverter
        public boolean isImmutable(@Nonnull CharSequence charSequence) {
            return charSequence instanceof String;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jf.util.ImmutableConverter
        @Nonnull
        public String makeImmutable(@Nonnull CharSequence charSequence) {
            return charSequence.toString();
        }
    };

    CharSequenceConverter() {
    }

    @Nonnull
    public static ImmutableList<String> immutableStringList(@Nullable Iterable<? extends CharSequence> iterable) {
        return CONVERTER.toList(iterable);
    }
}
