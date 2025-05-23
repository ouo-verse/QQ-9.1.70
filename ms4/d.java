package ms4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MapFactories;
import java.io.IOException;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public int f417516a;

    /* renamed from: b, reason: collision with root package name */
    public long f417517b;

    /* renamed from: c, reason: collision with root package name */
    public long f417518c;

    /* renamed from: d, reason: collision with root package name */
    public Map<Long, Boolean> f417519d;

    /* renamed from: e, reason: collision with root package name */
    public long f417520e;

    /* renamed from: f, reason: collision with root package name */
    public int f417521f;

    public d() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1) {
                    this.f417516a = readInt32;
                }
            } else if (readTag == 16) {
                this.f417517b = codedInputByteBufferNano.readInt64();
            } else if (readTag == 24) {
                this.f417518c = codedInputByteBufferNano.readInt64();
            } else if (readTag == 34) {
                this.f417519d = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.f417519d, mapFactory, 3, 8, null, 8, 16);
            } else if (readTag == 40) {
                this.f417520e = codedInputByteBufferNano.readInt64();
            } else if (readTag != 48) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int readInt322 = codedInputByteBufferNano.readInt32();
                if (readInt322 == 0 || readInt322 == 1 || readInt322 == 2) {
                    this.f417521f = readInt322;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f417516a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        long j3 = this.f417517b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j3);
        }
        long j16 = this.f417518c;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j16);
        }
        Map<Long, Boolean> map = this.f417519d;
        if (map != null) {
            computeSerializedSize += InternalNano.computeMapFieldSize(map, 4, 3, 8);
        }
        long j17 = this.f417520e;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(5, j17);
        }
        int i16 = this.f417521f;
        return i16 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(6, i16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f417516a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        long j3 = this.f417517b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j3);
        }
        long j16 = this.f417518c;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(3, j16);
        }
        Map<Long, Boolean> map = this.f417519d;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 4, 3, 8);
        }
        long j17 = this.f417520e;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeInt64(5, j17);
        }
        int i16 = this.f417521f;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public d a() {
        this.f417516a = 0;
        this.f417517b = 0L;
        this.f417518c = 0L;
        this.f417519d = null;
        this.f417520e = 0L;
        this.f417521f = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
