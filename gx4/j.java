package gx4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class j extends ExtendableMessageNano<j> {

    /* renamed from: a, reason: collision with root package name */
    public int f403784a;

    /* renamed from: b, reason: collision with root package name */
    public l[] f403785b;

    public j() {
        a();
    }

    public j a() {
        this.f403784a = 0;
        this.f403785b = l.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public j mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        l[] lVarArr = this.f403785b;
                        if (lVarArr == null) {
                            length = 0;
                        } else {
                            length = lVarArr.length;
                        }
                        int i3 = repeatedFieldArrayLength + length;
                        l[] lVarArr2 = new l[i3];
                        if (length != 0) {
                            System.arraycopy(lVarArr, 0, lVarArr2, 0, length);
                        }
                        while (length < i3 - 1) {
                            l lVar = new l();
                            lVarArr2[length] = lVar;
                            codedInputByteBufferNano.readMessage(lVar);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        l lVar2 = new l();
                        lVarArr2[length] = lVar2;
                        codedInputByteBufferNano.readMessage(lVar2);
                        this.f403785b = lVarArr2;
                    }
                } else {
                    this.f403784a = codedInputByteBufferNano.readUInt32();
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
        int i3 = this.f403784a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        l[] lVarArr = this.f403785b;
        if (lVarArr != null && lVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                l[] lVarArr2 = this.f403785b;
                if (i16 >= lVarArr2.length) {
                    break;
                }
                l lVar = lVarArr2[i16];
                if (lVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, lVar);
                }
                i16++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f403784a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        l[] lVarArr = this.f403785b;
        if (lVarArr != null && lVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                l[] lVarArr2 = this.f403785b;
                if (i16 >= lVarArr2.length) {
                    break;
                }
                l lVar = lVarArr2[i16];
                if (lVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, lVar);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
