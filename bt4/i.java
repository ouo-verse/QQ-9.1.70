package bt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class i extends ExtendableMessageNano<i> {

    /* renamed from: a, reason: collision with root package name */
    public int f29125a;

    /* renamed from: b, reason: collision with root package name */
    public String f29126b;

    /* renamed from: c, reason: collision with root package name */
    public int f29127c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f29128d;

    public i() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public i mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f29125a = codedInputByteBufferNano.readInt32();
            } else if (readTag == 18) {
                this.f29126b = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                    this.f29127c = readInt32;
                }
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f29128d = codedInputByteBufferNano.readBool();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f29125a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.f29126b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f29126b);
        }
        int i16 = this.f29127c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i16);
        }
        boolean z16 = this.f29128d;
        return z16 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(4, z16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f29125a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f29126b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f29126b);
        }
        int i16 = this.f29127c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i16);
        }
        boolean z16 = this.f29128d;
        if (z16) {
            codedOutputByteBufferNano.writeBool(4, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public i a() {
        this.f29125a = 0;
        this.f29126b = "";
        this.f29127c = 0;
        this.f29128d = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
