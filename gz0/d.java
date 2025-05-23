package gz0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MapFactories;
import java.io.IOException;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public long f403907a;

    /* renamed from: b, reason: collision with root package name */
    public long f403908b;

    /* renamed from: c, reason: collision with root package name */
    public String f403909c;

    /* renamed from: d, reason: collision with root package name */
    public Map<Integer, String> f403910d;

    public d() {
        a();
    }

    public d a() {
        this.f403907a = 0L;
        this.f403908b = 0L;
        this.f403909c = "";
        this.f403910d = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f403910d = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.f403910d, mapFactory, 5, 9, null, 8, 18);
                            }
                        } else {
                            this.f403909c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f403908b = codedInputByteBufferNano.readUInt64();
                    }
                } else {
                    this.f403907a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f403907a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f403908b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        if (!this.f403909c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f403909c);
        }
        Map<Integer, String> map = this.f403910d;
        if (map != null) {
            return computeSerializedSize + InternalNano.computeMapFieldSize(map, 4, 5, 9);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f403907a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f403908b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        if (!this.f403909c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f403909c);
        }
        Map<Integer, String> map = this.f403910d;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 4, 5, 9);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
