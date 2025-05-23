package ft4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public int f400606a;

    /* renamed from: b, reason: collision with root package name */
    public long f400607b;

    /* renamed from: c, reason: collision with root package name */
    public long f400608c;

    /* renamed from: d, reason: collision with root package name */
    public long f400609d;

    /* renamed from: e, reason: collision with root package name */
    public long f400610e;

    /* renamed from: f, reason: collision with root package name */
    public int f400611f;

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
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3 && readInt32 != 4 && readInt32 != 999) {
                    switch (readInt32) {
                    }
                }
                this.f400606a = readInt32;
            } else if (readTag == 16) {
                this.f400607b = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.f400608c = codedInputByteBufferNano.readInt64();
            } else if (readTag == 32) {
                this.f400609d = codedInputByteBufferNano.readInt64();
            } else if (readTag == 40) {
                this.f400610e = codedInputByteBufferNano.readInt64();
            } else if (readTag != 48) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f400611f = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f400606a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        long j3 = this.f400607b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        long j16 = this.f400608c;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j16);
        }
        long j17 = this.f400609d;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(4, j17);
        }
        long j18 = this.f400610e;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(5, j18);
        }
        int i16 = this.f400611f;
        return i16 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(6, i16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f400606a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        long j3 = this.f400607b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        long j16 = this.f400608c;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(3, j16);
        }
        long j17 = this.f400609d;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeInt64(4, j17);
        }
        long j18 = this.f400610e;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeInt64(5, j18);
        }
        int i16 = this.f400611f;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public a a() {
        this.f400606a = 0;
        this.f400607b = 0L;
        this.f400608c = 0L;
        this.f400609d = 0L;
        this.f400610e = 0L;
        this.f400611f = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
