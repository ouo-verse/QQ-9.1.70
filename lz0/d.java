package lz0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public b[] f415808a;

    /* renamed from: b, reason: collision with root package name */
    public int f415809b;

    /* renamed from: c, reason: collision with root package name */
    public e[] f415810c;

    /* renamed from: d, reason: collision with root package name */
    public int f415811d;

    /* renamed from: e, reason: collision with root package name */
    public a[] f415812e;

    public d() {
        a();
    }

    public d a() {
        this.f415808a = b.b();
        this.f415809b = 0;
        this.f415810c = e.b();
        this.f415811d = 0;
        this.f415812e = a.b();
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
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (readTag != 42) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                                    a[] aVarArr = this.f415812e;
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
                                    this.f415812e = aVarArr2;
                                }
                            } else {
                                this.f415811d = codedInputByteBufferNano.readInt32();
                            }
                        } else {
                            int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                            e[] eVarArr = this.f415810c;
                            if (eVarArr == null) {
                                length2 = 0;
                            } else {
                                length2 = eVarArr.length;
                            }
                            int i16 = repeatedFieldArrayLength2 + length2;
                            e[] eVarArr2 = new e[i16];
                            if (length2 != 0) {
                                System.arraycopy(eVarArr, 0, eVarArr2, 0, length2);
                            }
                            while (length2 < i16 - 1) {
                                e eVar = new e();
                                eVarArr2[length2] = eVar;
                                codedInputByteBufferNano.readMessage(eVar);
                                codedInputByteBufferNano.readTag();
                                length2++;
                            }
                            e eVar2 = new e();
                            eVarArr2[length2] = eVar2;
                            codedInputByteBufferNano.readMessage(eVar2);
                            this.f415810c = eVarArr2;
                        }
                    } else {
                        this.f415809b = codedInputByteBufferNano.readInt32();
                    }
                } else {
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    b[] bVarArr = this.f415808a;
                    if (bVarArr == null) {
                        length3 = 0;
                    } else {
                        length3 = bVarArr.length;
                    }
                    int i17 = repeatedFieldArrayLength3 + length3;
                    b[] bVarArr2 = new b[i17];
                    if (length3 != 0) {
                        System.arraycopy(bVarArr, 0, bVarArr2, 0, length3);
                    }
                    while (length3 < i17 - 1) {
                        b bVar = new b();
                        bVarArr2[length3] = bVar;
                        codedInputByteBufferNano.readMessage(bVar);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    b bVar2 = new b();
                    bVarArr2[length3] = bVar2;
                    codedInputByteBufferNano.readMessage(bVar2);
                    this.f415808a = bVarArr2;
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
        b[] bVarArr = this.f415808a;
        int i3 = 0;
        if (bVarArr != null && bVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                b[] bVarArr2 = this.f415808a;
                if (i16 >= bVarArr2.length) {
                    break;
                }
                b bVar = bVarArr2[i16];
                if (bVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, bVar);
                }
                i16++;
            }
        }
        int i17 = this.f415809b;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i17);
        }
        e[] eVarArr = this.f415810c;
        if (eVarArr != null && eVarArr.length > 0) {
            int i18 = 0;
            while (true) {
                e[] eVarArr2 = this.f415810c;
                if (i18 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i18];
                if (eVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, eVar);
                }
                i18++;
            }
        }
        int i19 = this.f415811d;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i19);
        }
        a[] aVarArr = this.f415812e;
        if (aVarArr != null && aVarArr.length > 0) {
            while (true) {
                a[] aVarArr2 = this.f415812e;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i3];
                if (aVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, aVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        b[] bVarArr = this.f415808a;
        int i3 = 0;
        if (bVarArr != null && bVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                b[] bVarArr2 = this.f415808a;
                if (i16 >= bVarArr2.length) {
                    break;
                }
                b bVar = bVarArr2[i16];
                if (bVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, bVar);
                }
                i16++;
            }
        }
        int i17 = this.f415809b;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i17);
        }
        e[] eVarArr = this.f415810c;
        if (eVarArr != null && eVarArr.length > 0) {
            int i18 = 0;
            while (true) {
                e[] eVarArr2 = this.f415810c;
                if (i18 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i18];
                if (eVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, eVar);
                }
                i18++;
            }
        }
        int i19 = this.f415811d;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i19);
        }
        a[] aVarArr = this.f415812e;
        if (aVarArr != null && aVarArr.length > 0) {
            while (true) {
                a[] aVarArr2 = this.f415812e;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i3];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(5, aVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
