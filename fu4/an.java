package fu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class an extends ExtendableMessageNano<an> {

    /* renamed from: f, reason: collision with root package name */
    private static volatile an[] f400717f;

    /* renamed from: a, reason: collision with root package name */
    public int f400718a;

    /* renamed from: b, reason: collision with root package name */
    public String f400719b;

    /* renamed from: c, reason: collision with root package name */
    public long f400720c;

    /* renamed from: d, reason: collision with root package name */
    public eu4.a[] f400721d;

    /* renamed from: e, reason: collision with root package name */
    public eu4.b[] f400722e;

    public an() {
        a();
    }

    public static an[] b() {
        if (f400717f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f400717f == null) {
                    f400717f = new an[0];
                }
            }
        }
        return f400717f;
    }

    public an a() {
        this.f400718a = 0;
        this.f400719b = "";
        this.f400720c = 0L;
        this.f400721d = eu4.a.b();
        this.f400722e = eu4.b.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public an mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                                    eu4.b[] bVarArr = this.f400722e;
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
                                    this.f400722e = bVarArr2;
                                }
                            } else {
                                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                                eu4.a[] aVarArr = this.f400721d;
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
                                this.f400721d = aVarArr2;
                            }
                        } else {
                            this.f400720c = codedInputByteBufferNano.readInt64();
                        }
                    } else {
                        this.f400719b = codedInputByteBufferNano.readString();
                    }
                } else {
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 == 0 || readInt32 == 100 || readInt32 == 200) {
                        this.f400718a = readInt32;
                    }
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
        int i3 = this.f400718a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.f400719b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f400719b);
        }
        long j3 = this.f400720c;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j3);
        }
        eu4.a[] aVarArr = this.f400721d;
        int i16 = 0;
        if (aVarArr != null && aVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                eu4.a[] aVarArr2 = this.f400721d;
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
        eu4.b[] bVarArr = this.f400722e;
        if (bVarArr != null && bVarArr.length > 0) {
            while (true) {
                eu4.b[] bVarArr2 = this.f400722e;
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
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f400718a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f400719b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f400719b);
        }
        long j3 = this.f400720c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(3, j3);
        }
        eu4.a[] aVarArr = this.f400721d;
        int i16 = 0;
        if (aVarArr != null && aVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                eu4.a[] aVarArr2 = this.f400721d;
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
        eu4.b[] bVarArr = this.f400722e;
        if (bVarArr != null && bVarArr.length > 0) {
            while (true) {
                eu4.b[] bVarArr2 = this.f400722e;
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
        super.writeTo(codedOutputByteBufferNano);
    }
}
