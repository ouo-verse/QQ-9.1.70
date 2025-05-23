package bz0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: h, reason: collision with root package name */
    private static volatile c[] f29439h;

    /* renamed from: a, reason: collision with root package name */
    public long f29440a;

    /* renamed from: b, reason: collision with root package name */
    public int f29441b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f29442c;

    /* renamed from: d, reason: collision with root package name */
    public d f29443d;

    /* renamed from: e, reason: collision with root package name */
    public int f29444e;

    /* renamed from: f, reason: collision with root package name */
    public long f29445f;

    /* renamed from: g, reason: collision with root package name */
    public String f29446g;

    public c() {
        a();
    }

    public static c[] b() {
        if (f29439h == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f29439h == null) {
                    f29439h = new c[0];
                }
            }
        }
        return f29439h;
    }

    public c a() {
        this.f29440a = 0L;
        this.f29441b = 0;
        this.f29442c = WireFormatNano.EMPTY_BYTES;
        this.f29443d = null;
        this.f29444e = 0;
        this.f29445f = 0L;
        this.f29446g = "";
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
                                            this.f29446g = codedInputByteBufferNano.readString();
                                        }
                                    } else {
                                        this.f29445f = codedInputByteBufferNano.readUInt64();
                                    }
                                } else {
                                    this.f29444e = codedInputByteBufferNano.readUInt32();
                                }
                            } else {
                                if (this.f29443d == null) {
                                    this.f29443d = new d();
                                }
                                codedInputByteBufferNano.readMessage(this.f29443d);
                            }
                        } else {
                            this.f29442c = codedInputByteBufferNano.readBytes();
                        }
                    } else {
                        this.f29441b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    this.f29440a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f29440a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.f29441b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        if (!Arrays.equals(this.f29442c, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.f29442c);
        }
        d dVar = this.f29443d;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, dVar);
        }
        int i16 = this.f29444e;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i16);
        }
        long j16 = this.f29445f;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j16);
        }
        if (!this.f29446g.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.f29446g);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f29440a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.f29441b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        if (!Arrays.equals(this.f29442c, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(3, this.f29442c);
        }
        d dVar = this.f29443d;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(4, dVar);
        }
        int i16 = this.f29444e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i16);
        }
        long j16 = this.f29445f;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j16);
        }
        if (!this.f29446g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f29446g);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
