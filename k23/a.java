package k23;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f411433a;

    /* renamed from: b, reason: collision with root package name */
    public int f411434b;

    /* renamed from: c, reason: collision with root package name */
    public int f411435c;

    /* renamed from: d, reason: collision with root package name */
    public int f411436d;

    public a() {
        a();
    }

    public a a() {
        this.f411433a = false;
        this.f411434b = 0;
        this.f411435c = 0;
        this.f411436d = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 24) {
                            if (readTag != 32) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                int readInt32 = codedInputByteBufferNano.readInt32();
                                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                                    this.f411436d = readInt32;
                                }
                            }
                        } else {
                            int readInt322 = codedInputByteBufferNano.readInt32();
                            if (readInt322 == 0 || readInt322 == 1 || readInt322 == 2) {
                                this.f411435c = readInt322;
                            }
                        }
                    } else {
                        this.f411434b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    this.f411433a = codedInputByteBufferNano.readBool();
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
        boolean z16 = this.f411433a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        int i3 = this.f411434b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        int i16 = this.f411435c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i16);
        }
        int i17 = this.f411436d;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(4, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f411433a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        int i3 = this.f411434b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        int i16 = this.f411435c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i16);
        }
        int i17 = this.f411436d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
