package eu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: f, reason: collision with root package name */
    private static volatile b[] f397174f;

    /* renamed from: a, reason: collision with root package name */
    public byte[] f397175a;

    /* renamed from: b, reason: collision with root package name */
    public int f397176b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f397177c;

    /* renamed from: d, reason: collision with root package name */
    public int f397178d;

    /* renamed from: e, reason: collision with root package name */
    public int f397179e;

    public b() {
        a();
    }

    public static b[] b() {
        if (f397174f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f397174f == null) {
                    f397174f = new b[0];
                }
            }
        }
        return f397174f;
    }

    public b a() {
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f397175a = bArr;
        this.f397176b = 0;
        this.f397177c = bArr;
        this.f397178d = 0;
        this.f397179e = 0;
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
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    this.f397179e = codedInputByteBufferNano.readUInt32();
                                }
                            } else {
                                this.f397178d = codedInputByteBufferNano.readUInt32();
                            }
                        } else {
                            this.f397177c = codedInputByteBufferNano.readBytes();
                        }
                    } else {
                        this.f397176b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    this.f397175a = codedInputByteBufferNano.readBytes();
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
        byte[] bArr = this.f397175a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f397175a);
        }
        int i3 = this.f397176b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        if (!Arrays.equals(this.f397177c, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.f397177c);
        }
        int i16 = this.f397178d;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        int i17 = this.f397179e;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(5, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        byte[] bArr = this.f397175a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(1, this.f397175a);
        }
        int i3 = this.f397176b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        if (!Arrays.equals(this.f397177c, bArr2)) {
            codedOutputByteBufferNano.writeBytes(3, this.f397177c);
        }
        int i16 = this.f397178d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        int i17 = this.f397179e;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
