package ot4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import hs4.k;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public int[] f424053a;

    /* renamed from: b, reason: collision with root package name */
    public k[] f424054b;

    public d() {
        a();
    }

    public d a() {
        this.f424053a = WireFormatNano.EMPTY_INT_ARRAY;
        this.f424054b = k.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 8);
                int[] iArr = this.f424053a;
                int length = iArr == null ? 0 : iArr.length;
                int i3 = repeatedFieldArrayLength + length;
                int[] iArr2 = new int[i3];
                if (length != 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, length);
                }
                while (length < i3 - 1) {
                    iArr2[length] = codedInputByteBufferNano.readUInt32();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                iArr2[length] = codedInputByteBufferNano.readUInt32();
                this.f424053a = iArr2;
            } else if (readTag == 10) {
                int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i16 = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readUInt32();
                    i16++;
                }
                codedInputByteBufferNano.rewindToPosition(position);
                int[] iArr3 = this.f424053a;
                int length2 = iArr3 == null ? 0 : iArr3.length;
                int i17 = i16 + length2;
                int[] iArr4 = new int[i17];
                if (length2 != 0) {
                    System.arraycopy(iArr3, 0, iArr4, 0, length2);
                }
                while (length2 < i17) {
                    iArr4[length2] = codedInputByteBufferNano.readUInt32();
                    length2++;
                }
                this.f424053a = iArr4;
                codedInputByteBufferNano.popLimit(pushLimit);
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                k[] kVarArr = this.f424054b;
                int length3 = kVarArr == null ? 0 : kVarArr.length;
                int i18 = repeatedFieldArrayLength2 + length3;
                k[] kVarArr2 = new k[i18];
                if (length3 != 0) {
                    System.arraycopy(kVarArr, 0, kVarArr2, 0, length3);
                }
                while (length3 < i18 - 1) {
                    k kVar = new k();
                    kVarArr2[length3] = kVar;
                    codedInputByteBufferNano.readMessage(kVar);
                    codedInputByteBufferNano.readTag();
                    length3++;
                }
                k kVar2 = new k();
                kVarArr2[length3] = kVar2;
                codedInputByteBufferNano.readMessage(kVar2);
                this.f424054b = kVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int[] iArr;
        int computeSerializedSize = super.computeSerializedSize();
        int[] iArr2 = this.f424053a;
        int i3 = 0;
        if (iArr2 != null && iArr2.length > 0) {
            int i16 = 0;
            int i17 = 0;
            while (true) {
                iArr = this.f424053a;
                if (i16 >= iArr.length) {
                    break;
                }
                i17 += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr[i16]);
                i16++;
            }
            computeSerializedSize = computeSerializedSize + i17 + (iArr.length * 1);
        }
        k[] kVarArr = this.f424054b;
        if (kVarArr != null && kVarArr.length > 0) {
            while (true) {
                k[] kVarArr2 = this.f424054b;
                if (i3 >= kVarArr2.length) {
                    break;
                }
                k kVar = kVarArr2[i3];
                if (kVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, kVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int[] iArr = this.f424053a;
        int i3 = 0;
        if (iArr != null && iArr.length > 0) {
            int i16 = 0;
            while (true) {
                int[] iArr2 = this.f424053a;
                if (i16 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(1, iArr2[i16]);
                i16++;
            }
        }
        k[] kVarArr = this.f424054b;
        if (kVarArr != null && kVarArr.length > 0) {
            while (true) {
                k[] kVarArr2 = this.f424054b;
                if (i3 >= kVarArr2.length) {
                    break;
                }
                k kVar = kVarArr2[i3];
                if (kVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, kVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
