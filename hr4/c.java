package hr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public long f406098a;

    /* renamed from: b, reason: collision with root package name */
    public long f406099b;

    /* renamed from: c, reason: collision with root package name */
    public int f406100c;

    /* renamed from: d, reason: collision with root package name */
    public e f406101d;

    public c() {
        a();
    }

    public c a() {
        this.f406098a = 0L;
        this.f406099b = 0L;
        this.f406100c = 0;
        this.f406101d = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 24) {
                            if (readTag != 34) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                if (this.f406101d == null) {
                                    this.f406101d = new e();
                                }
                                codedInputByteBufferNano.readMessage(this.f406101d);
                            }
                        } else {
                            int readInt32 = codedInputByteBufferNano.readInt32();
                            if (readInt32 == 0 || readInt32 == 1) {
                                this.f406100c = readInt32;
                            }
                        }
                    } else {
                        this.f406099b = codedInputByteBufferNano.readInt64();
                    }
                } else {
                    this.f406098a = codedInputByteBufferNano.readInt64();
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
        long j3 = this.f406098a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j3);
        }
        long j16 = this.f406099b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j16);
        }
        int i3 = this.f406100c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        e eVar = this.f406101d;
        if (eVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, eVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f406098a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(1, j3);
        }
        long j16 = this.f406099b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j16);
        }
        int i3 = this.f406100c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        e eVar = this.f406101d;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(4, eVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
