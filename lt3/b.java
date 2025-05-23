package lt3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public int f415540a;

    /* renamed from: b, reason: collision with root package name */
    public int f415541b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f415542c;

    /* renamed from: d, reason: collision with root package name */
    public int f415543d;

    /* renamed from: e, reason: collision with root package name */
    public int f415544e;

    /* renamed from: f, reason: collision with root package name */
    public long f415545f;

    /* renamed from: g, reason: collision with root package name */
    public long f415546g;

    /* renamed from: h, reason: collision with root package name */
    public int f415547h;

    /* renamed from: i, reason: collision with root package name */
    public a[] f415548i;

    public b() {
        a();
    }

    public b a() {
        this.f415540a = 0;
        this.f415541b = 0;
        this.f415542c = WireFormatNano.EMPTY_BYTES;
        this.f415543d = 0;
        this.f415544e = 0;
        this.f415545f = 0L;
        this.f415546g = 0L;
        this.f415547h = 1;
        this.f415548i = a.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (readTag != 48) {
                                        if (readTag != 56) {
                                            if (readTag != 64) {
                                                if (readTag != 74) {
                                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                        return this;
                                                    }
                                                } else {
                                                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 74);
                                                    a[] aVarArr = this.f415548i;
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
                                                    this.f415548i = aVarArr2;
                                                }
                                            } else {
                                                int readInt32 = codedInputByteBufferNano.readInt32();
                                                if (readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                                                    this.f415547h = readInt32;
                                                }
                                            }
                                        } else {
                                            this.f415546g = codedInputByteBufferNano.readUInt64();
                                        }
                                    } else {
                                        this.f415545f = codedInputByteBufferNano.readUInt64();
                                    }
                                } else {
                                    this.f415544e = codedInputByteBufferNano.readUInt32();
                                }
                            } else {
                                this.f415543d = codedInputByteBufferNano.readUInt32();
                            }
                        } else {
                            this.f415542c = codedInputByteBufferNano.readBytes();
                        }
                    } else {
                        this.f415541b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    this.f415540a = codedInputByteBufferNano.readUInt32();
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
        int i3 = this.f415540a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f415541b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        if (!Arrays.equals(this.f415542c, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.f415542c);
        }
        int i17 = this.f415543d;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        int i18 = this.f415544e;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i18);
        }
        long j3 = this.f415545f;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j3);
        }
        long j16 = this.f415546g;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j16);
        }
        int i19 = this.f415547h;
        if (i19 != 1) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i19);
        }
        a[] aVarArr = this.f415548i;
        if (aVarArr != null && aVarArr.length > 0) {
            int i26 = 0;
            while (true) {
                a[] aVarArr2 = this.f415548i;
                if (i26 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i26];
                if (aVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, aVar);
                }
                i26++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f415540a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f415541b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        if (!Arrays.equals(this.f415542c, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(3, this.f415542c);
        }
        int i17 = this.f415543d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        int i18 = this.f415544e;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i18);
        }
        long j3 = this.f415545f;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j3);
        }
        long j16 = this.f415546g;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j16);
        }
        int i19 = this.f415547h;
        if (i19 != 1) {
            codedOutputByteBufferNano.writeInt32(8, i19);
        }
        a[] aVarArr = this.f415548i;
        if (aVarArr != null && aVarArr.length > 0) {
            int i26 = 0;
            while (true) {
                a[] aVarArr2 = this.f415548i;
                if (i26 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i26];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(9, aVar);
                }
                i26++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
