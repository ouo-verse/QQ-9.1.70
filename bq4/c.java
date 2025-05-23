package bq4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public long f29000a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f29001b;

    /* renamed from: c, reason: collision with root package name */
    public String f29002c;

    /* renamed from: d, reason: collision with root package name */
    public Map<String, String> f29003d;

    /* renamed from: e, reason: collision with root package name */
    public int f29004e;

    /* renamed from: f, reason: collision with root package name */
    public int f29005f;

    public c() {
        a();
    }

    public c a() {
        this.f29000a = 0L;
        this.f29001b = WireFormatNano.EMPTY_BYTES;
        this.f29002c = "";
        this.f29003d = null;
        this.f29004e = 0;
        this.f29005f = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 40) {
                                    if (readTag != 48) {
                                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                            return this;
                                        }
                                    } else {
                                        int readInt32 = codedInputByteBufferNano.readInt32();
                                        if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                                            this.f29005f = readInt32;
                                        }
                                    }
                                } else {
                                    int readInt322 = codedInputByteBufferNano.readInt32();
                                    if (readInt322 == 0 || readInt322 == 1 || readInt322 == 2) {
                                        this.f29004e = readInt322;
                                    }
                                }
                            } else {
                                this.f29003d = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.f29003d, mapFactory, 9, 9, null, 10, 18);
                            }
                        } else {
                            this.f29002c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f29001b = codedInputByteBufferNano.readBytes();
                    }
                } else {
                    this.f29000a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f29000a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!Arrays.equals(this.f29001b, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.f29001b);
        }
        if (!this.f29002c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f29002c);
        }
        Map<String, String> map = this.f29003d;
        if (map != null) {
            computeSerializedSize += InternalNano.computeMapFieldSize(map, 4, 9, 9);
        }
        int i3 = this.f29004e;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i3);
        }
        int i16 = this.f29005f;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(6, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f29000a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!Arrays.equals(this.f29001b, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(2, this.f29001b);
        }
        if (!this.f29002c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f29002c);
        }
        Map<String, String> map = this.f29003d;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 4, 9, 9);
        }
        int i3 = this.f29004e;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i3);
        }
        int i16 = this.f29005f;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
