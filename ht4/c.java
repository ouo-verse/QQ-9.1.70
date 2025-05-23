package ht4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import hs4.r;
import hs4.s;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: j, reason: collision with root package name */
    private static volatile c[] f406260j;

    /* renamed from: a, reason: collision with root package name */
    public long f406261a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f406262b;

    /* renamed from: c, reason: collision with root package name */
    public String f406263c;

    /* renamed from: d, reason: collision with root package name */
    public r f406264d;

    /* renamed from: e, reason: collision with root package name */
    public String f406265e;

    /* renamed from: f, reason: collision with root package name */
    public String f406266f;

    /* renamed from: g, reason: collision with root package name */
    public hs4.b f406267g;

    /* renamed from: h, reason: collision with root package name */
    public long f406268h;

    /* renamed from: i, reason: collision with root package name */
    public s f406269i;

    public c() {
        a();
    }

    public static c[] b() {
        if (f406260j == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f406260j == null) {
                    f406260j = new c[0];
                }
            }
        }
        return f406260j;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f406261a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.f406262b = codedInputByteBufferNano.readBytes();
            } else if (readTag == 26) {
                this.f406263c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                if (this.f406264d == null) {
                    this.f406264d = new r();
                }
                codedInputByteBufferNano.readMessage(this.f406264d);
            } else if (readTag == 42) {
                this.f406265e = codedInputByteBufferNano.readString();
            } else if (readTag == 50) {
                this.f406266f = codedInputByteBufferNano.readString();
            } else if (readTag == 58) {
                if (this.f406267g == null) {
                    this.f406267g = new hs4.b();
                }
                codedInputByteBufferNano.readMessage(this.f406267g);
            } else if (readTag == 64) {
                this.f406268h = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 74) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f406269i == null) {
                    this.f406269i = new s();
                }
                codedInputByteBufferNano.readMessage(this.f406269i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f406261a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!Arrays.equals(this.f406262b, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.f406262b);
        }
        if (!this.f406263c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f406263c);
        }
        r rVar = this.f406264d;
        if (rVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, rVar);
        }
        if (!this.f406265e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f406265e);
        }
        if (!this.f406266f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f406266f);
        }
        hs4.b bVar = this.f406267g;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, bVar);
        }
        long j16 = this.f406268h;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j16);
        }
        s sVar = this.f406269i;
        return sVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(9, sVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f406261a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!Arrays.equals(this.f406262b, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(2, this.f406262b);
        }
        if (!this.f406263c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f406263c);
        }
        r rVar = this.f406264d;
        if (rVar != null) {
            codedOutputByteBufferNano.writeMessage(4, rVar);
        }
        if (!this.f406265e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f406265e);
        }
        if (!this.f406266f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f406266f);
        }
        hs4.b bVar = this.f406267g;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(7, bVar);
        }
        long j16 = this.f406268h;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j16);
        }
        s sVar = this.f406269i;
        if (sVar != null) {
            codedOutputByteBufferNano.writeMessage(9, sVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public c a() {
        this.f406261a = 0L;
        this.f406262b = WireFormatNano.EMPTY_BYTES;
        this.f406263c = "";
        this.f406264d = null;
        this.f406265e = "";
        this.f406266f = "";
        this.f406267g = null;
        this.f406268h = 0L;
        this.f406269i = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
