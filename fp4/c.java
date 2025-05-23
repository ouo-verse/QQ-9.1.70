package fp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: h, reason: collision with root package name */
    private static volatile c[] f400282h;

    /* renamed from: a, reason: collision with root package name */
    public long f400283a;

    /* renamed from: b, reason: collision with root package name */
    public int f400284b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f400285c;

    /* renamed from: d, reason: collision with root package name */
    public d f400286d;

    /* renamed from: e, reason: collision with root package name */
    public int f400287e;

    /* renamed from: f, reason: collision with root package name */
    public long f400288f;

    /* renamed from: g, reason: collision with root package name */
    public String f400289g;

    public c() {
        a();
    }

    public static c[] b() {
        if (f400282h == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f400282h == null) {
                    f400282h = new c[0];
                }
            }
        }
        return f400282h;
    }

    public c a() {
        this.f400283a = 0L;
        this.f400284b = 0;
        this.f400285c = WireFormatNano.EMPTY_BYTES;
        this.f400286d = null;
        this.f400287e = 0;
        this.f400288f = 0L;
        this.f400289g = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 40) {
                                    if (readTag != 48) {
                                        if (readTag != 58) {
                                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                return this;
                                            }
                                        } else {
                                            this.f400289g = codedInputByteBufferNano.readString();
                                        }
                                    } else {
                                        this.f400288f = codedInputByteBufferNano.readUInt64();
                                    }
                                } else {
                                    this.f400287e = codedInputByteBufferNano.readUInt32();
                                }
                            } else {
                                if (this.f400286d == null) {
                                    this.f400286d = new d();
                                }
                                codedInputByteBufferNano.readMessage(this.f400286d);
                            }
                        } else {
                            this.f400285c = codedInputByteBufferNano.readBytes();
                        }
                    } else {
                        this.f400284b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    this.f400283a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f400283a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.f400284b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        if (!Arrays.equals(this.f400285c, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.f400285c);
        }
        d dVar = this.f400286d;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, dVar);
        }
        int i16 = this.f400287e;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i16);
        }
        long j16 = this.f400288f;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j16);
        }
        if (!this.f400289g.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.f400289g);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f400283a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.f400284b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        if (!Arrays.equals(this.f400285c, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(3, this.f400285c);
        }
        d dVar = this.f400286d;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(4, dVar);
        }
        int i16 = this.f400287e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i16);
        }
        long j16 = this.f400288f;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j16);
        }
        if (!this.f400289g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f400289g);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
