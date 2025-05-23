package fv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: g, reason: collision with root package name */
    private static volatile d[] f400866g;

    /* renamed from: a, reason: collision with root package name */
    public long f400867a;

    /* renamed from: b, reason: collision with root package name */
    public int f400868b;

    /* renamed from: c, reason: collision with root package name */
    public String f400869c;

    /* renamed from: d, reason: collision with root package name */
    public String f400870d;

    /* renamed from: e, reason: collision with root package name */
    public long f400871e;

    /* renamed from: f, reason: collision with root package name */
    public String f400872f;

    public d() {
        a();
    }

    public static d[] b() {
        if (f400866g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f400866g == null) {
                    f400866g = new d[0];
                }
            }
        }
        return f400866g;
    }

    public d a() {
        this.f400867a = 0L;
        this.f400868b = 0;
        this.f400869c = "";
        this.f400870d = "";
        this.f400871e = 0L;
        this.f400872f = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 40) {
                                    if (readTag != 50) {
                                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                            return this;
                                        }
                                    } else {
                                        this.f400872f = codedInputByteBufferNano.readString();
                                    }
                                } else {
                                    this.f400871e = codedInputByteBufferNano.readUInt64();
                                }
                            } else {
                                this.f400870d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f400869c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                            this.f400868b = readInt32;
                        }
                    }
                } else {
                    this.f400867a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f400867a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.f400868b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        if (!this.f400869c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f400869c);
        }
        if (!this.f400870d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f400870d);
        }
        long j16 = this.f400871e;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j16);
        }
        if (!this.f400872f.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.f400872f);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f400867a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.f400868b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        if (!this.f400869c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f400869c);
        }
        if (!this.f400870d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f400870d);
        }
        long j16 = this.f400871e;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j16);
        }
        if (!this.f400872f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f400872f);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
