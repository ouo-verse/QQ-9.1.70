package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface LazyStringList extends ProtocolStringList {
    void add(ByteString byteString);

    ByteString getByteString(int i3);

    List<?> getUnderlyingElements();

    LazyStringList getUnmodifiableView();
}
