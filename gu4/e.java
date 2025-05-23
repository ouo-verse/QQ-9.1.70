package gu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f403385a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f403386b;

    /* renamed from: c, reason: collision with root package name */
    public long f403387c;

    public e() {
        a();
    }

    public e a() {
        this.f403385a = false;
        this.f403386b = false;
        this.f403387c = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 24) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            this.f403387c = codedInputByteBufferNano.readInt64();
                        }
                    } else {
                        this.f403386b = codedInputByteBufferNano.readBool();
                    }
                } else {
                    this.f403385a = codedInputByteBufferNano.readBool();
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
        boolean z16 = this.f403385a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        boolean z17 = this.f403386b;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z17);
        }
        long j3 = this.f403387c;
        if (j3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(3, j3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f403385a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        boolean z17 = this.f403386b;
        if (z17) {
            codedOutputByteBufferNano.writeBool(2, z17);
        }
        long j3 = this.f403387c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(3, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
