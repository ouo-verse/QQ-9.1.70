package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface MessageLite extends MessageLiteOrBuilder {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface Builder extends Cloneable, MessageLiteOrBuilder {
        MessageLite build();

        Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException;
    }

    Parser<? extends MessageLite> getParserForType();

    int getSerializedSize();

    Builder newBuilderForType();

    Builder toBuilder();

    void writeTo(CodedOutputStream codedOutputStream) throws IOException;
}
