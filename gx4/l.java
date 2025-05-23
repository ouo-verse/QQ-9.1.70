package gx4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class l extends ExtendableMessageNano<l> {

    /* renamed from: f, reason: collision with root package name */
    private static volatile l[] f403788f;

    /* renamed from: a, reason: collision with root package name */
    public int f403789a;

    /* renamed from: b, reason: collision with root package name */
    public int f403790b;

    /* renamed from: c, reason: collision with root package name */
    public long f403791c;

    /* renamed from: d, reason: collision with root package name */
    public e f403792d;

    /* renamed from: e, reason: collision with root package name */
    public m f403793e;

    public l() {
        a();
    }

    public static l[] b() {
        if (f403788f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f403788f == null) {
                    f403788f = new l[0];
                }
            }
        }
        return f403788f;
    }

    public l a() {
        this.f403789a = 0;
        this.f403790b = 0;
        this.f403791c = 0L;
        this.f403792d = null;
        this.f403793e = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public l mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 24) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    if (this.f403793e == null) {
                                        this.f403793e = new m();
                                    }
                                    codedInputByteBufferNano.readMessage(this.f403793e);
                                }
                            } else {
                                if (this.f403792d == null) {
                                    this.f403792d = new e();
                                }
                                codedInputByteBufferNano.readMessage(this.f403792d);
                            }
                        } else {
                            this.f403791c = codedInputByteBufferNano.readUInt64();
                        }
                    } else {
                        this.f403790b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    this.f403789a = codedInputByteBufferNano.readUInt32();
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
        int i3 = this.f403789a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f403790b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        long j3 = this.f403791c;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        e eVar = this.f403792d;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, eVar);
        }
        m mVar = this.f403793e;
        if (mVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(5, mVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f403789a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f403790b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        long j3 = this.f403791c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        e eVar = this.f403792d;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(4, eVar);
        }
        m mVar = this.f403793e;
        if (mVar != null) {
            codedOutputByteBufferNano.writeMessage(5, mVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
