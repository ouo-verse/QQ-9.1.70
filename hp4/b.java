package hp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public int f405848a;

    /* renamed from: b, reason: collision with root package name */
    public String f405849b;

    /* renamed from: c, reason: collision with root package name */
    public long[] f405850c;

    /* renamed from: d, reason: collision with root package name */
    public e[] f405851d;

    public b() {
        a();
    }

    public static b c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (b) MessageNano.mergeFrom(new b(), bArr);
    }

    public b a() {
        this.f405848a = 0;
        this.f405849b = "";
        this.f405850c = WireFormatNano.EMPTY_LONG_ARRAY;
        this.f405851d = e.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        int length3;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (readTag != 26) {
                                if (readTag != 34) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                                    e[] eVarArr = this.f405851d;
                                    if (eVarArr == null) {
                                        length = 0;
                                    } else {
                                        length = eVarArr.length;
                                    }
                                    int i3 = repeatedFieldArrayLength + length;
                                    e[] eVarArr2 = new e[i3];
                                    if (length != 0) {
                                        System.arraycopy(eVarArr, 0, eVarArr2, 0, length);
                                    }
                                    while (length < i3 - 1) {
                                        e eVar = new e();
                                        eVarArr2[length] = eVar;
                                        codedInputByteBufferNano.readMessage(eVar);
                                        codedInputByteBufferNano.readTag();
                                        length++;
                                    }
                                    e eVar2 = new e();
                                    eVarArr2[length] = eVar2;
                                    codedInputByteBufferNano.readMessage(eVar2);
                                    this.f405851d = eVarArr2;
                                }
                            } else {
                                int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                                int position = codedInputByteBufferNano.getPosition();
                                int i16 = 0;
                                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                                    codedInputByteBufferNano.readUInt64();
                                    i16++;
                                }
                                codedInputByteBufferNano.rewindToPosition(position);
                                long[] jArr = this.f405850c;
                                if (jArr == null) {
                                    length2 = 0;
                                } else {
                                    length2 = jArr.length;
                                }
                                int i17 = i16 + length2;
                                long[] jArr2 = new long[i17];
                                if (length2 != 0) {
                                    System.arraycopy(jArr, 0, jArr2, 0, length2);
                                }
                                while (length2 < i17) {
                                    jArr2[length2] = codedInputByteBufferNano.readUInt64();
                                    length2++;
                                }
                                this.f405850c = jArr2;
                                codedInputByteBufferNano.popLimit(pushLimit);
                            }
                        } else {
                            int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 24);
                            long[] jArr3 = this.f405850c;
                            if (jArr3 == null) {
                                length3 = 0;
                            } else {
                                length3 = jArr3.length;
                            }
                            int i18 = repeatedFieldArrayLength2 + length3;
                            long[] jArr4 = new long[i18];
                            if (length3 != 0) {
                                System.arraycopy(jArr3, 0, jArr4, 0, length3);
                            }
                            while (length3 < i18 - 1) {
                                jArr4[length3] = codedInputByteBufferNano.readUInt64();
                                codedInputByteBufferNano.readTag();
                                length3++;
                            }
                            jArr4[length3] = codedInputByteBufferNano.readUInt64();
                            this.f405850c = jArr4;
                        }
                    } else {
                        this.f405849b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f405848a = codedInputByteBufferNano.readInt32();
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        long[] jArr;
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f405848a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.f405849b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f405849b);
        }
        long[] jArr2 = this.f405850c;
        int i16 = 0;
        if (jArr2 != null && jArr2.length > 0) {
            int i17 = 0;
            int i18 = 0;
            while (true) {
                jArr = this.f405850c;
                if (i17 >= jArr.length) {
                    break;
                }
                i18 += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr[i17]);
                i17++;
            }
            computeSerializedSize = computeSerializedSize + i18 + (jArr.length * 1);
        }
        e[] eVarArr = this.f405851d;
        if (eVarArr != null && eVarArr.length > 0) {
            while (true) {
                e[] eVarArr2 = this.f405851d;
                if (i16 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i16];
                if (eVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, eVar);
                }
                i16++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f405848a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f405849b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f405849b);
        }
        long[] jArr = this.f405850c;
        int i16 = 0;
        if (jArr != null && jArr.length > 0) {
            int i17 = 0;
            while (true) {
                long[] jArr2 = this.f405850c;
                if (i17 >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(3, jArr2[i17]);
                i17++;
            }
        }
        e[] eVarArr = this.f405851d;
        if (eVarArr != null && eVarArr.length > 0) {
            while (true) {
                e[] eVarArr2 = this.f405851d;
                if (i16 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i16];
                if (eVar != null) {
                    codedOutputByteBufferNano.writeMessage(4, eVar);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
