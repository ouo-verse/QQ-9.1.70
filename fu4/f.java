package fu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public long f400770a;

    /* renamed from: b, reason: collision with root package name */
    public int f400771b;

    public f() {
        a();
    }

    public f a() {
        this.f400770a = 0L;
        this.f400771b = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 != 0 && readInt32 != 500 && readInt32 != 400 && readInt32 != 401) {
                            switch (readInt32) {
                                case 100:
                                case 101:
                                case 102:
                                    break;
                                default:
                                    switch (readInt32) {
                                    }
                            }
                        }
                        this.f400771b = readInt32;
                    }
                } else {
                    this.f400770a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f400770a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.f400771b;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f400770a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.f400771b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
