package bz0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public int[] f29447a;

    /* renamed from: b, reason: collision with root package name */
    public a[] f29448b;

    public d() {
        a();
    }

    public d a() {
        this.f29447a = WireFormatNano.EMPTY_INT_ARRAY;
        this.f29448b = a.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        int length3;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 10) {
                        if (readTag != 18) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                            a[] aVarArr = this.f29448b;
                            if (aVarArr == null) {
                                length = 0;
                            } else {
                                length = aVarArr.length;
                            }
                            int i3 = repeatedFieldArrayLength + length;
                            a[] aVarArr2 = new a[i3];
                            if (length != 0) {
                                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                            }
                            while (length < i3 - 1) {
                                a aVar = new a();
                                aVarArr2[length] = aVar;
                                codedInputByteBufferNano.readMessage(aVar);
                                codedInputByteBufferNano.readTag();
                                length++;
                            }
                            a aVar2 = new a();
                            aVarArr2[length] = aVar2;
                            codedInputByteBufferNano.readMessage(aVar2);
                            this.f29448b = aVarArr2;
                        }
                    } else {
                        int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                        int position = codedInputByteBufferNano.getPosition();
                        int i16 = 0;
                        while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                            codedInputByteBufferNano.readUInt32();
                            i16++;
                        }
                        codedInputByteBufferNano.rewindToPosition(position);
                        int[] iArr = this.f29447a;
                        if (iArr == null) {
                            length2 = 0;
                        } else {
                            length2 = iArr.length;
                        }
                        int i17 = i16 + length2;
                        int[] iArr2 = new int[i17];
                        if (length2 != 0) {
                            System.arraycopy(iArr, 0, iArr2, 0, length2);
                        }
                        while (length2 < i17) {
                            iArr2[length2] = codedInputByteBufferNano.readUInt32();
                            length2++;
                        }
                        this.f29447a = iArr2;
                        codedInputByteBufferNano.popLimit(pushLimit);
                    }
                } else {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 8);
                    int[] iArr3 = this.f29447a;
                    if (iArr3 == null) {
                        length3 = 0;
                    } else {
                        length3 = iArr3.length;
                    }
                    int i18 = repeatedFieldArrayLength2 + length3;
                    int[] iArr4 = new int[i18];
                    if (length3 != 0) {
                        System.arraycopy(iArr3, 0, iArr4, 0, length3);
                    }
                    while (length3 < i18 - 1) {
                        iArr4[length3] = codedInputByteBufferNano.readUInt32();
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    iArr4[length3] = codedInputByteBufferNano.readUInt32();
                    this.f29447a = iArr4;
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int[] iArr;
        int computeSerializedSize = super.computeSerializedSize();
        int[] iArr2 = this.f29447a;
        int i3 = 0;
        if (iArr2 != null && iArr2.length > 0) {
            int i16 = 0;
            int i17 = 0;
            while (true) {
                iArr = this.f29447a;
                if (i16 >= iArr.length) {
                    break;
                }
                i17 += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr[i16]);
                i16++;
            }
            computeSerializedSize = computeSerializedSize + i17 + (iArr.length * 1);
        }
        a[] aVarArr = this.f29448b;
        if (aVarArr != null && aVarArr.length > 0) {
            while (true) {
                a[] aVarArr2 = this.f29448b;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i3];
                if (aVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, aVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int[] iArr = this.f29447a;
        int i3 = 0;
        if (iArr != null && iArr.length > 0) {
            int i16 = 0;
            while (true) {
                int[] iArr2 = this.f29447a;
                if (i16 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(1, iArr2[i16]);
                i16++;
            }
        }
        a[] aVarArr = this.f29448b;
        if (aVarArr != null && aVarArr.length > 0) {
            while (true) {
                a[] aVarArr2 = this.f29448b;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i3];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, aVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
