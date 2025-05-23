package bs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class j extends ExtendableMessageNano<j> {

    /* renamed from: f, reason: collision with root package name */
    private static volatile j[] f29074f;

    /* renamed from: a, reason: collision with root package name */
    public long f29075a;

    /* renamed from: b, reason: collision with root package name */
    public k f29076b;

    /* renamed from: c, reason: collision with root package name */
    public String f29077c;

    /* renamed from: d, reason: collision with root package name */
    public int f29078d;

    /* renamed from: e, reason: collision with root package name */
    public b f29079e;

    public j() {
        a();
    }

    public static j[] b() {
        if (f29074f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f29074f == null) {
                    f29074f = new j[0];
                }
            }
        }
        return f29074f;
    }

    public static j d(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (j) MessageNano.mergeFrom(new j(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public j mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f29075a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                if (this.f29076b == null) {
                    this.f29076b = new k();
                }
                codedInputByteBufferNano.readMessage(this.f29076b);
            } else if (readTag == 26) {
                this.f29077c = codedInputByteBufferNano.readString();
            } else if (readTag == 32) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1) {
                    this.f29078d = readInt32;
                }
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f29079e == null) {
                    this.f29079e = new b();
                }
                codedInputByteBufferNano.readMessage(this.f29079e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f29075a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        k kVar = this.f29076b;
        if (kVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, kVar);
        }
        if (!this.f29077c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f29077c);
        }
        int i3 = this.f29078d;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i3);
        }
        b bVar = this.f29079e;
        return bVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(5, bVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f29075a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        k kVar = this.f29076b;
        if (kVar != null) {
            codedOutputByteBufferNano.writeMessage(2, kVar);
        }
        if (!this.f29077c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f29077c);
        }
        int i3 = this.f29078d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i3);
        }
        b bVar = this.f29079e;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(5, bVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public j a() {
        this.f29075a = 0L;
        this.f29076b = null;
        this.f29077c = "";
        this.f29078d = 0;
        this.f29079e = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
