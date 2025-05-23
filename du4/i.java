package du4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class i extends ExtendableMessageNano<i> {

    /* renamed from: a, reason: collision with root package name */
    public Map<Integer, k> f394989a;

    /* renamed from: b, reason: collision with root package name */
    public Map<Integer, d> f394990b;

    public i() {
        a();
    }

    public static i c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (i) MessageNano.mergeFrom(new i(), bArr);
    }

    public i a() {
        this.f394989a = null;
        this.f394990b = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public i mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.f394990b = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.f394990b, mapFactory, 5, 11, new d(), 8, 18);
                    }
                } else {
                    this.f394989a = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.f394989a, mapFactory, 5, 11, new k(), 8, 18);
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
        Map<Integer, k> map = this.f394989a;
        if (map != null) {
            computeSerializedSize += InternalNano.computeMapFieldSize(map, 1, 5, 11);
        }
        Map<Integer, d> map2 = this.f394990b;
        if (map2 != null) {
            return computeSerializedSize + InternalNano.computeMapFieldSize(map2, 2, 5, 11);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Map<Integer, k> map = this.f394989a;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 1, 5, 11);
        }
        Map<Integer, d> map2 = this.f394990b;
        if (map2 != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map2, 2, 5, 11);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
