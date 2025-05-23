package gq4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile a[] f403080d;

    /* renamed from: a, reason: collision with root package name */
    public long f403081a;

    /* renamed from: b, reason: collision with root package name */
    public int f403082b;

    /* renamed from: c, reason: collision with root package name */
    public rp4.b f403083c;

    public a() {
        a();
    }

    public static a[] b() {
        if (f403080d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f403080d == null) {
                    f403080d = new a[0];
                }
            }
        }
        return f403080d;
    }

    public a a() {
        this.f403081a = 0L;
        this.f403082b = 0;
        this.f403083c = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            if (this.f403083c == null) {
                                this.f403083c = new rp4.b();
                            }
                            codedInputByteBufferNano.readMessage(this.f403083c);
                        }
                    } else {
                        this.f403082b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    this.f403081a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f403081a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.f403082b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        rp4.b bVar = this.f403083c;
        if (bVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, bVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f403081a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.f403082b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        rp4.b bVar = this.f403083c;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(3, bVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
