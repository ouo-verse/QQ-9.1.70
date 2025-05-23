package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.io.ByteArrayInputStream;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes28.dex */
public final class DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1 extends Lambda implements Function0<Object> {
    final /* synthetic */ ByteArrayInputStream $inputStream;
    final /* synthetic */ Parser<Object> $parser;
    final /* synthetic */ DeserializedMemberScope this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1(Parser<Object> parser, ByteArrayInputStream byteArrayInputStream, DeserializedMemberScope deserializedMemberScope) {
        super(0);
        this.$parser = parser;
        this.$inputStream = byteArrayInputStream;
        this.this$0 = deserializedMemberScope;
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final Object invoke() {
        return (MessageLite) this.$parser.parseDelimitedFrom(this.$inputStream, this.this$0.getC().getComponents().getExtensionRegistryLite());
    }
}
