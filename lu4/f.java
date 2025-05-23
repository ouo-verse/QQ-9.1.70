package lu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public long f415600a;

    /* renamed from: b, reason: collision with root package name */
    public String f415601b;

    /* renamed from: c, reason: collision with root package name */
    public int f415602c;

    /* renamed from: d, reason: collision with root package name */
    public int f415603d;

    /* renamed from: e, reason: collision with root package name */
    public int f415604e;

    public f() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f415600a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.f415601b = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                    this.f415602c = readInt32;
                }
            } else if (readTag == 32) {
                this.f415603d = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f415604e = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f415600a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f415601b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f415601b);
        }
        int i3 = this.f415602c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        int i16 = this.f415603d;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        int i17 = this.f415604e;
        return i17 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(5, i17) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f415600a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f415601b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f415601b);
        }
        int i3 = this.f415602c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        int i16 = this.f415603d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        int i17 = this.f415604e;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public f a() {
        this.f415600a = 0L;
        this.f415601b = "";
        this.f415602c = 0;
        this.f415603d = 0;
        this.f415604e = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
