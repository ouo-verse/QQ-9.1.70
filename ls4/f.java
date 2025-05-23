package ls4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile f[] f415523e;

    /* renamed from: a, reason: collision with root package name */
    public long f415524a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f415525b;

    /* renamed from: c, reason: collision with root package name */
    public long f415526c;

    /* renamed from: d, reason: collision with root package name */
    public String f415527d;

    public f() {
        a();
    }

    public static f[] b() {
        if (f415523e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f415523e == null) {
                    f415523e = new f[0];
                }
            }
        }
        return f415523e;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f415524a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.f415525b = codedInputByteBufferNano.readBytes();
            } else if (readTag == 24) {
                this.f415526c = codedInputByteBufferNano.readInt64();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f415527d = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f415524a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!Arrays.equals(this.f415525b, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.f415525b);
        }
        long j16 = this.f415526c;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j16);
        }
        return !this.f415527d.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f415527d) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f415524a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!Arrays.equals(this.f415525b, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(2, this.f415525b);
        }
        long j16 = this.f415526c;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(3, j16);
        }
        if (!this.f415527d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f415527d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public f a() {
        this.f415524a = 0L;
        this.f415525b = WireFormatNano.EMPTY_BYTES;
        this.f415526c = 0L;
        this.f415527d = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
