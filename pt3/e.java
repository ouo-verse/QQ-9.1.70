package pt3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public int f427136a;

    /* renamed from: b, reason: collision with root package name */
    public String f427137b;

    /* renamed from: c, reason: collision with root package name */
    public String f427138c;

    /* renamed from: d, reason: collision with root package name */
    public String f427139d;

    /* renamed from: e, reason: collision with root package name */
    public int f427140e;

    public e() {
        a();
    }

    public static e c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (e) MessageNano.mergeFrom(new e(), bArr);
    }

    public e a() {
        this.f427136a = 0;
        this.f427137b = "";
        this.f427138c = "";
        this.f427139d = "";
        this.f427140e = 0;
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
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 40) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    this.f427140e = codedInputByteBufferNano.readUInt32();
                                }
                            } else {
                                this.f427139d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f427138c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f427137b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f427136a = codedInputByteBufferNano.readInt32();
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeInt32Size(1, this.f427136a);
        if (!this.f427137b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f427137b);
        }
        if (!this.f427138c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f427138c);
        }
        if (!this.f427139d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f427139d);
        }
        int i3 = this.f427140e;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(5, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeInt32(1, this.f427136a);
        if (!this.f427137b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f427137b);
        }
        if (!this.f427138c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f427138c);
        }
        if (!this.f427139d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f427139d);
        }
        int i3 = this.f427140e;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
