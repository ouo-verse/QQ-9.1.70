package hq4;

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
    public np4.c f405955a;

    /* renamed from: b, reason: collision with root package name */
    public sp4.c[] f405956b;

    /* renamed from: c, reason: collision with root package name */
    public long[] f405957c;

    public b() {
        a();
    }

    public static b c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (b) MessageNano.mergeFrom(new b(), bArr);
    }

    public b a() {
        this.f405955a = null;
        this.f405956b = sp4.c.b();
        this.f405957c = WireFormatNano.EMPTY_LONG_ARRAY;
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
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (readTag != 26) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                                int position = codedInputByteBufferNano.getPosition();
                                int i3 = 0;
                                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                                    codedInputByteBufferNano.readUInt64();
                                    i3++;
                                }
                                codedInputByteBufferNano.rewindToPosition(position);
                                long[] jArr = this.f405957c;
                                if (jArr == null) {
                                    length = 0;
                                } else {
                                    length = jArr.length;
                                }
                                int i16 = i3 + length;
                                long[] jArr2 = new long[i16];
                                if (length != 0) {
                                    System.arraycopy(jArr, 0, jArr2, 0, length);
                                }
                                while (length < i16) {
                                    jArr2[length] = codedInputByteBufferNano.readUInt64();
                                    length++;
                                }
                                this.f405957c = jArr2;
                                codedInputByteBufferNano.popLimit(pushLimit);
                            }
                        } else {
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 24);
                            long[] jArr3 = this.f405957c;
                            if (jArr3 == null) {
                                length2 = 0;
                            } else {
                                length2 = jArr3.length;
                            }
                            int i17 = repeatedFieldArrayLength + length2;
                            long[] jArr4 = new long[i17];
                            if (length2 != 0) {
                                System.arraycopy(jArr3, 0, jArr4, 0, length2);
                            }
                            while (length2 < i17 - 1) {
                                jArr4[length2] = codedInputByteBufferNano.readUInt64();
                                codedInputByteBufferNano.readTag();
                                length2++;
                            }
                            jArr4[length2] = codedInputByteBufferNano.readUInt64();
                            this.f405957c = jArr4;
                        }
                    } else {
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        sp4.c[] cVarArr = this.f405956b;
                        if (cVarArr == null) {
                            length3 = 0;
                        } else {
                            length3 = cVarArr.length;
                        }
                        int i18 = repeatedFieldArrayLength2 + length3;
                        sp4.c[] cVarArr2 = new sp4.c[i18];
                        if (length3 != 0) {
                            System.arraycopy(cVarArr, 0, cVarArr2, 0, length3);
                        }
                        while (length3 < i18 - 1) {
                            sp4.c cVar = new sp4.c();
                            cVarArr2[length3] = cVar;
                            codedInputByteBufferNano.readMessage(cVar);
                            codedInputByteBufferNano.readTag();
                            length3++;
                        }
                        sp4.c cVar2 = new sp4.c();
                        cVarArr2[length3] = cVar2;
                        codedInputByteBufferNano.readMessage(cVar2);
                        this.f405956b = cVarArr2;
                    }
                } else {
                    if (this.f405955a == null) {
                        this.f405955a = new np4.c();
                    }
                    codedInputByteBufferNano.readMessage(this.f405955a);
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
        np4.c cVar = this.f405955a;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, cVar);
        }
        sp4.c[] cVarArr = this.f405956b;
        int i3 = 0;
        if (cVarArr != null && cVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                sp4.c[] cVarArr2 = this.f405956b;
                if (i16 >= cVarArr2.length) {
                    break;
                }
                sp4.c cVar2 = cVarArr2[i16];
                if (cVar2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, cVar2);
                }
                i16++;
            }
        }
        long[] jArr = this.f405957c;
        if (jArr != null && jArr.length > 0) {
            int i17 = 0;
            while (true) {
                long[] jArr2 = this.f405957c;
                if (i3 < jArr2.length) {
                    i17 += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr2[i3]);
                    i3++;
                } else {
                    return computeSerializedSize + i17 + (jArr2.length * 1);
                }
            }
        } else {
            return computeSerializedSize;
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        np4.c cVar = this.f405955a;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(1, cVar);
        }
        sp4.c[] cVarArr = this.f405956b;
        int i3 = 0;
        if (cVarArr != null && cVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                sp4.c[] cVarArr2 = this.f405956b;
                if (i16 >= cVarArr2.length) {
                    break;
                }
                sp4.c cVar2 = cVarArr2[i16];
                if (cVar2 != null) {
                    codedOutputByteBufferNano.writeMessage(2, cVar2);
                }
                i16++;
            }
        }
        long[] jArr = this.f405957c;
        if (jArr != null && jArr.length > 0) {
            while (true) {
                long[] jArr2 = this.f405957c;
                if (i3 >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(3, jArr2[i3]);
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
