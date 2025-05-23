package ez0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MapFactories;
import java.io.IOException;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public Map<String, byte[]> f397449a;

    /* renamed from: b, reason: collision with root package name */
    public int f397450b;

    public a() {
        a();
    }

    public a a() {
        this.f397449a = null;
        this.f397450b = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.f397450b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    this.f397449a = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.f397449a, mapFactory, 9, 12, null, 10, 18);
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        Map<String, byte[]> map = this.f397449a;
        if (map != null) {
            computeSerializedSize += InternalNano.computeMapFieldSize(map, 1, 9, 12);
        }
        int i3 = this.f397450b;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Map<String, byte[]> map = this.f397449a;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 1, 9, 12);
        }
        int i3 = this.f397450b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
