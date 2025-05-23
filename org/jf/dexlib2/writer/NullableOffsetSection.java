package org.jf.dexlib2.writer;

import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface NullableOffsetSection<Key> extends OffsetSection<Key> {
    int getNullableItemOffset(@Nullable Key key);
}
