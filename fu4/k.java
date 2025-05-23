package fu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class k extends ExtendableMessageNano<k> {

    /* renamed from: a, reason: collision with root package name */
    public String f400781a;

    /* renamed from: b, reason: collision with root package name */
    public String f400782b;

    /* renamed from: c, reason: collision with root package name */
    public int f400783c;

    /* renamed from: d, reason: collision with root package name */
    public eu4.a[] f400784d;

    /* renamed from: e, reason: collision with root package name */
    public eu4.b[] f400785e;

    /* renamed from: f, reason: collision with root package name */
    public ac f400786f;

    /* renamed from: g, reason: collision with root package name */
    public ax f400787g;

    public k() {
        a();
    }

    public k a() {
        this.f400781a = "";
        this.f400782b = "";
        this.f400783c = 0;
        this.f400784d = eu4.a.b();
        this.f400785e = eu4.b.b();
        this.f400786f = null;
        this.f400787g = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public k mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (readTag != 50) {
                                        if (readTag != 58) {
                                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                return this;
                                            }
                                        } else {
                                            if (this.f400787g == null) {
                                                this.f400787g = new ax();
                                            }
                                            codedInputByteBufferNano.readMessage(this.f400787g);
                                        }
                                    } else {
                                        if (this.f400786f == null) {
                                            this.f400786f = new ac();
                                        }
                                        codedInputByteBufferNano.readMessage(this.f400786f);
                                    }
                                } else {
                                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                                    eu4.b[] bVarArr = this.f400785e;
                                    if (bVarArr == null) {
                                        length = 0;
                                    } else {
                                        length = bVarArr.length;
                                    }
                                    int i3 = repeatedFieldArrayLength + length;
                                    eu4.b[] bVarArr2 = new eu4.b[i3];
                                    if (length != 0) {
                                        System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                                    }
                                    while (length < i3 - 1) {
                                        eu4.b bVar = new eu4.b();
                                        bVarArr2[length] = bVar;
                                        codedInputByteBufferNano.readMessage(bVar);
                                        codedInputByteBufferNano.readTag();
                                        length++;
                                    }
                                    eu4.b bVar2 = new eu4.b();
                                    bVarArr2[length] = bVar2;
                                    codedInputByteBufferNano.readMessage(bVar2);
                                    this.f400785e = bVarArr2;
                                }
                            } else {
                                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                                eu4.a[] aVarArr = this.f400784d;
                                if (aVarArr == null) {
                                    length2 = 0;
                                } else {
                                    length2 = aVarArr.length;
                                }
                                int i16 = repeatedFieldArrayLength2 + length2;
                                eu4.a[] aVarArr2 = new eu4.a[i16];
                                if (length2 != 0) {
                                    System.arraycopy(aVarArr, 0, aVarArr2, 0, length2);
                                }
                                while (length2 < i16 - 1) {
                                    eu4.a aVar = new eu4.a();
                                    aVarArr2[length2] = aVar;
                                    codedInputByteBufferNano.readMessage(aVar);
                                    codedInputByteBufferNano.readTag();
                                    length2++;
                                }
                                eu4.a aVar2 = new eu4.a();
                                aVarArr2[length2] = aVar2;
                                codedInputByteBufferNano.readMessage(aVar2);
                                this.f400784d = aVarArr2;
                            }
                        } else {
                            this.f400783c = codedInputByteBufferNano.readUInt32();
                        }
                    } else {
                        this.f400782b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f400781a = codedInputByteBufferNano.readString();
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
        if (!this.f400781a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f400781a);
        }
        if (!this.f400782b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f400782b);
        }
        int i3 = this.f400783c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        eu4.a[] aVarArr = this.f400784d;
        int i16 = 0;
        if (aVarArr != null && aVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                eu4.a[] aVarArr2 = this.f400784d;
                if (i17 >= aVarArr2.length) {
                    break;
                }
                eu4.a aVar = aVarArr2[i17];
                if (aVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, aVar);
                }
                i17++;
            }
        }
        eu4.b[] bVarArr = this.f400785e;
        if (bVarArr != null && bVarArr.length > 0) {
            while (true) {
                eu4.b[] bVarArr2 = this.f400785e;
                if (i16 >= bVarArr2.length) {
                    break;
                }
                eu4.b bVar = bVarArr2[i16];
                if (bVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, bVar);
                }
                i16++;
            }
        }
        ac acVar = this.f400786f;
        if (acVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, acVar);
        }
        ax axVar = this.f400787g;
        if (axVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(7, axVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f400781a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f400781a);
        }
        if (!this.f400782b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f400782b);
        }
        int i3 = this.f400783c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        eu4.a[] aVarArr = this.f400784d;
        int i16 = 0;
        if (aVarArr != null && aVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                eu4.a[] aVarArr2 = this.f400784d;
                if (i17 >= aVarArr2.length) {
                    break;
                }
                eu4.a aVar = aVarArr2[i17];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(4, aVar);
                }
                i17++;
            }
        }
        eu4.b[] bVarArr = this.f400785e;
        if (bVarArr != null && bVarArr.length > 0) {
            while (true) {
                eu4.b[] bVarArr2 = this.f400785e;
                if (i16 >= bVarArr2.length) {
                    break;
                }
                eu4.b bVar = bVarArr2[i16];
                if (bVar != null) {
                    codedOutputByteBufferNano.writeMessage(5, bVar);
                }
                i16++;
            }
        }
        ac acVar = this.f400786f;
        if (acVar != null) {
            codedOutputByteBufferNano.writeMessage(6, acVar);
        }
        ax axVar = this.f400787g;
        if (axVar != null) {
            codedOutputByteBufferNano.writeMessage(7, axVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
