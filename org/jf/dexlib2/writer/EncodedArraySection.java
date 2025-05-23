package org.jf.dexlib2.writer;

import java.util.List;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface EncodedArraySection<EncodedArrayKey, EncodedValue> extends OffsetSection<EncodedArrayKey> {
    List<? extends EncodedValue> getEncodedValueList(EncodedArrayKey encodedarraykey);
}
