package bu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public long f29231a;

    /* renamed from: b, reason: collision with root package name */
    public long f29232b;

    /* renamed from: c, reason: collision with root package name */
    public int f29233c;

    /* renamed from: d, reason: collision with root package name */
    public int f29234d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f29235e;

    /* renamed from: f, reason: collision with root package name */
    public int f29236f;

    public a() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f29231a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.f29232b = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.f29233c = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.f29234d = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 42) {
                this.f29235e = codedInputByteBufferNano.readBytes();
            } else if (readTag != 48) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3 && readInt32 != 4 && readInt32 != 999) {
                    switch (readInt32) {
                    }
                }
                this.f29236f = readInt32;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f29231a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f29232b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        int i3 = this.f29233c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        int i16 = this.f29234d;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        if (!Arrays.equals(this.f29235e, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(5, this.f29235e);
        }
        int i17 = this.f29236f;
        return i17 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(6, i17) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f29231a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f29232b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        int i3 = this.f29233c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        int i16 = this.f29234d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        if (!Arrays.equals(this.f29235e, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(5, this.f29235e);
        }
        int i17 = this.f29236f;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public a a() {
        this.f29231a = 0L;
        this.f29232b = 0L;
        this.f29233c = 0;
        this.f29234d = 0;
        this.f29235e = WireFormatNano.EMPTY_BYTES;
        this.f29236f = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
