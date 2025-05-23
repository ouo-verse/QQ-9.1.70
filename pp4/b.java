package pp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: g, reason: collision with root package name */
    private static volatile b[] f426964g;

    /* renamed from: a, reason: collision with root package name */
    public long f426965a;

    /* renamed from: b, reason: collision with root package name */
    public int f426966b;

    /* renamed from: c, reason: collision with root package name */
    public d f426967c;

    /* renamed from: d, reason: collision with root package name */
    public long f426968d;

    /* renamed from: e, reason: collision with root package name */
    public long f426969e;

    /* renamed from: f, reason: collision with root package name */
    public long f426970f;

    public b() {
        a();
    }

    public static b[] b() {
        if (f426964g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f426964g == null) {
                    f426964g = new b[0];
                }
            }
        }
        return f426964g;
    }

    public b a() {
        this.f426965a = 0L;
        this.f426966b = 0;
        this.f426967c = null;
        this.f426968d = 0L;
        this.f426969e = 0L;
        this.f426970f = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (readTag != 48) {
                                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                            return this;
                                        }
                                    } else {
                                        this.f426970f = codedInputByteBufferNano.readUInt64();
                                    }
                                } else {
                                    this.f426969e = codedInputByteBufferNano.readUInt64();
                                }
                            } else {
                                this.f426968d = codedInputByteBufferNano.readInt64();
                            }
                        } else {
                            if (this.f426967c == null) {
                                this.f426967c = new d();
                            }
                            codedInputByteBufferNano.readMessage(this.f426967c);
                        }
                    } else {
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                            this.f426966b = readInt32;
                        }
                    }
                } else {
                    this.f426965a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f426965a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.f426966b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        d dVar = this.f426967c;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, dVar);
        }
        long j16 = this.f426968d;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(4, j16);
        }
        long j17 = this.f426969e;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j17);
        }
        long j18 = this.f426970f;
        if (j18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(6, j18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f426965a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.f426966b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        d dVar = this.f426967c;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(3, dVar);
        }
        long j16 = this.f426968d;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(4, j16);
        }
        long j17 = this.f426969e;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j17);
        }
        long j18 = this.f426970f;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
