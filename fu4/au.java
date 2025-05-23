package fu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class au extends ExtendableMessageNano<au> {

    /* renamed from: a, reason: collision with root package name */
    public String f400743a;

    /* renamed from: b, reason: collision with root package name */
    public long f400744b;

    /* renamed from: c, reason: collision with root package name */
    public eu4.a[] f400745c;

    /* renamed from: d, reason: collision with root package name */
    public eu4.b[] f400746d;

    /* renamed from: e, reason: collision with root package name */
    public long f400747e;

    /* renamed from: f, reason: collision with root package name */
    public w f400748f;

    /* renamed from: g, reason: collision with root package name */
    public aj[] f400749g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f400750h;

    /* renamed from: i, reason: collision with root package name */
    public an[] f400751i;

    public au() {
        a();
    }

    public au a() {
        this.f400743a = "";
        this.f400744b = 0L;
        this.f400745c = eu4.a.b();
        this.f400746d = eu4.b.b();
        this.f400747e = 0L;
        this.f400748f = null;
        this.f400749g = aj.b();
        this.f400750h = WireFormatNano.EMPTY_BYTES;
        this.f400751i = an.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public au mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        int length3;
        int length4;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 40) {
                                    if (readTag != 50) {
                                        if (readTag != 58) {
                                            if (readTag != 66) {
                                                if (readTag != 82) {
                                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                        return this;
                                                    }
                                                } else {
                                                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                                                    an[] anVarArr = this.f400751i;
                                                    if (anVarArr == null) {
                                                        length = 0;
                                                    } else {
                                                        length = anVarArr.length;
                                                    }
                                                    int i3 = repeatedFieldArrayLength + length;
                                                    an[] anVarArr2 = new an[i3];
                                                    if (length != 0) {
                                                        System.arraycopy(anVarArr, 0, anVarArr2, 0, length);
                                                    }
                                                    while (length < i3 - 1) {
                                                        an anVar = new an();
                                                        anVarArr2[length] = anVar;
                                                        codedInputByteBufferNano.readMessage(anVar);
                                                        codedInputByteBufferNano.readTag();
                                                        length++;
                                                    }
                                                    an anVar2 = new an();
                                                    anVarArr2[length] = anVar2;
                                                    codedInputByteBufferNano.readMessage(anVar2);
                                                    this.f400751i = anVarArr2;
                                                }
                                            } else {
                                                this.f400750h = codedInputByteBufferNano.readBytes();
                                            }
                                        } else {
                                            int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                                            aj[] ajVarArr = this.f400749g;
                                            if (ajVarArr == null) {
                                                length2 = 0;
                                            } else {
                                                length2 = ajVarArr.length;
                                            }
                                            int i16 = repeatedFieldArrayLength2 + length2;
                                            aj[] ajVarArr2 = new aj[i16];
                                            if (length2 != 0) {
                                                System.arraycopy(ajVarArr, 0, ajVarArr2, 0, length2);
                                            }
                                            while (length2 < i16 - 1) {
                                                aj ajVar = new aj();
                                                ajVarArr2[length2] = ajVar;
                                                codedInputByteBufferNano.readMessage(ajVar);
                                                codedInputByteBufferNano.readTag();
                                                length2++;
                                            }
                                            aj ajVar2 = new aj();
                                            ajVarArr2[length2] = ajVar2;
                                            codedInputByteBufferNano.readMessage(ajVar2);
                                            this.f400749g = ajVarArr2;
                                        }
                                    } else {
                                        if (this.f400748f == null) {
                                            this.f400748f = new w();
                                        }
                                        codedInputByteBufferNano.readMessage(this.f400748f);
                                    }
                                } else {
                                    this.f400747e = codedInputByteBufferNano.readUInt64();
                                }
                            } else {
                                int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                                eu4.b[] bVarArr = this.f400746d;
                                if (bVarArr == null) {
                                    length3 = 0;
                                } else {
                                    length3 = bVarArr.length;
                                }
                                int i17 = repeatedFieldArrayLength3 + length3;
                                eu4.b[] bVarArr2 = new eu4.b[i17];
                                if (length3 != 0) {
                                    System.arraycopy(bVarArr, 0, bVarArr2, 0, length3);
                                }
                                while (length3 < i17 - 1) {
                                    eu4.b bVar = new eu4.b();
                                    bVarArr2[length3] = bVar;
                                    codedInputByteBufferNano.readMessage(bVar);
                                    codedInputByteBufferNano.readTag();
                                    length3++;
                                }
                                eu4.b bVar2 = new eu4.b();
                                bVarArr2[length3] = bVar2;
                                codedInputByteBufferNano.readMessage(bVar2);
                                this.f400746d = bVarArr2;
                            }
                        } else {
                            int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                            eu4.a[] aVarArr = this.f400745c;
                            if (aVarArr == null) {
                                length4 = 0;
                            } else {
                                length4 = aVarArr.length;
                            }
                            int i18 = repeatedFieldArrayLength4 + length4;
                            eu4.a[] aVarArr2 = new eu4.a[i18];
                            if (length4 != 0) {
                                System.arraycopy(aVarArr, 0, aVarArr2, 0, length4);
                            }
                            while (length4 < i18 - 1) {
                                eu4.a aVar = new eu4.a();
                                aVarArr2[length4] = aVar;
                                codedInputByteBufferNano.readMessage(aVar);
                                codedInputByteBufferNano.readTag();
                                length4++;
                            }
                            eu4.a aVar2 = new eu4.a();
                            aVarArr2[length4] = aVar2;
                            codedInputByteBufferNano.readMessage(aVar2);
                            this.f400745c = aVarArr2;
                        }
                    } else {
                        this.f400744b = codedInputByteBufferNano.readInt64();
                    }
                } else {
                    this.f400743a = codedInputByteBufferNano.readString();
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
        if (!this.f400743a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f400743a);
        }
        long j3 = this.f400744b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j3);
        }
        eu4.a[] aVarArr = this.f400745c;
        int i3 = 0;
        if (aVarArr != null && aVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                eu4.a[] aVarArr2 = this.f400745c;
                if (i16 >= aVarArr2.length) {
                    break;
                }
                eu4.a aVar = aVarArr2[i16];
                if (aVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, aVar);
                }
                i16++;
            }
        }
        eu4.b[] bVarArr = this.f400746d;
        if (bVarArr != null && bVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                eu4.b[] bVarArr2 = this.f400746d;
                if (i17 >= bVarArr2.length) {
                    break;
                }
                eu4.b bVar = bVarArr2[i17];
                if (bVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, bVar);
                }
                i17++;
            }
        }
        long j16 = this.f400747e;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j16);
        }
        w wVar = this.f400748f;
        if (wVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, wVar);
        }
        aj[] ajVarArr = this.f400749g;
        if (ajVarArr != null && ajVarArr.length > 0) {
            int i18 = 0;
            while (true) {
                aj[] ajVarArr2 = this.f400749g;
                if (i18 >= ajVarArr2.length) {
                    break;
                }
                aj ajVar = ajVarArr2[i18];
                if (ajVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, ajVar);
                }
                i18++;
            }
        }
        if (!Arrays.equals(this.f400750h, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(8, this.f400750h);
        }
        an[] anVarArr = this.f400751i;
        if (anVarArr != null && anVarArr.length > 0) {
            while (true) {
                an[] anVarArr2 = this.f400751i;
                if (i3 >= anVarArr2.length) {
                    break;
                }
                an anVar = anVarArr2[i3];
                if (anVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, anVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f400743a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f400743a);
        }
        long j3 = this.f400744b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j3);
        }
        eu4.a[] aVarArr = this.f400745c;
        int i3 = 0;
        if (aVarArr != null && aVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                eu4.a[] aVarArr2 = this.f400745c;
                if (i16 >= aVarArr2.length) {
                    break;
                }
                eu4.a aVar = aVarArr2[i16];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, aVar);
                }
                i16++;
            }
        }
        eu4.b[] bVarArr = this.f400746d;
        if (bVarArr != null && bVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                eu4.b[] bVarArr2 = this.f400746d;
                if (i17 >= bVarArr2.length) {
                    break;
                }
                eu4.b bVar = bVarArr2[i17];
                if (bVar != null) {
                    codedOutputByteBufferNano.writeMessage(4, bVar);
                }
                i17++;
            }
        }
        long j16 = this.f400747e;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j16);
        }
        w wVar = this.f400748f;
        if (wVar != null) {
            codedOutputByteBufferNano.writeMessage(6, wVar);
        }
        aj[] ajVarArr = this.f400749g;
        if (ajVarArr != null && ajVarArr.length > 0) {
            int i18 = 0;
            while (true) {
                aj[] ajVarArr2 = this.f400749g;
                if (i18 >= ajVarArr2.length) {
                    break;
                }
                aj ajVar = ajVarArr2[i18];
                if (ajVar != null) {
                    codedOutputByteBufferNano.writeMessage(7, ajVar);
                }
                i18++;
            }
        }
        if (!Arrays.equals(this.f400750h, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(8, this.f400750h);
        }
        an[] anVarArr = this.f400751i;
        if (anVarArr != null && anVarArr.length > 0) {
            while (true) {
                an[] anVarArr2 = this.f400751i;
                if (i3 >= anVarArr2.length) {
                    break;
                }
                an anVar = anVarArr2[i3];
                if (anVar != null) {
                    codedOutputByteBufferNano.writeMessage(10, anVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
