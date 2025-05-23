package hq4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public np4.c f405961a;

    /* renamed from: b, reason: collision with root package name */
    public String f405962b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f405963c;

    /* renamed from: d, reason: collision with root package name */
    public int f405964d;

    public d() {
        a();
    }

    public d a() {
        this.f405961a = null;
        this.f405962b = "";
        this.f405963c = WireFormatNano.EMPTY_INT_ARRAY;
        this.f405964d = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (readTag != 26) {
                                if (readTag != 32) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    this.f405964d = codedInputByteBufferNano.readUInt32();
                                }
                            } else {
                                int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                                int position = codedInputByteBufferNano.getPosition();
                                int i3 = 0;
                                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                                    codedInputByteBufferNano.readUInt32();
                                    i3++;
                                }
                                codedInputByteBufferNano.rewindToPosition(position);
                                int[] iArr = this.f405963c;
                                if (iArr == null) {
                                    length = 0;
                                } else {
                                    length = iArr.length;
                                }
                                int i16 = i3 + length;
                                int[] iArr2 = new int[i16];
                                if (length != 0) {
                                    System.arraycopy(iArr, 0, iArr2, 0, length);
                                }
                                while (length < i16) {
                                    iArr2[length] = codedInputByteBufferNano.readUInt32();
                                    length++;
                                }
                                this.f405963c = iArr2;
                                codedInputByteBufferNano.popLimit(pushLimit);
                            }
                        } else {
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 24);
                            int[] iArr3 = this.f405963c;
                            if (iArr3 == null) {
                                length2 = 0;
                            } else {
                                length2 = iArr3.length;
                            }
                            int i17 = repeatedFieldArrayLength + length2;
                            int[] iArr4 = new int[i17];
                            if (length2 != 0) {
                                System.arraycopy(iArr3, 0, iArr4, 0, length2);
                            }
                            while (length2 < i17 - 1) {
                                iArr4[length2] = codedInputByteBufferNano.readUInt32();
                                codedInputByteBufferNano.readTag();
                                length2++;
                            }
                            iArr4[length2] = codedInputByteBufferNano.readUInt32();
                            this.f405963c = iArr4;
                        }
                    } else {
                        this.f405962b = codedInputByteBufferNano.readString();
                    }
                } else {
                    if (this.f405961a == null) {
                        this.f405961a = new np4.c();
                    }
                    codedInputByteBufferNano.readMessage(this.f405961a);
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
        np4.c cVar = this.f405961a;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, cVar);
        }
        if (!this.f405962b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f405962b);
        }
        int[] iArr2 = this.f405963c;
        if (iArr2 != null && iArr2.length > 0) {
            int i3 = 0;
            int i16 = 0;
            while (true) {
                iArr = this.f405963c;
                if (i3 >= iArr.length) {
                    break;
                }
                i16 += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr[i3]);
                i3++;
            }
            computeSerializedSize = computeSerializedSize + i16 + (iArr.length * 1);
        }
        int i17 = this.f405964d;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        np4.c cVar = this.f405961a;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(1, cVar);
        }
        if (!this.f405962b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f405962b);
        }
        int[] iArr = this.f405963c;
        if (iArr != null && iArr.length > 0) {
            int i3 = 0;
            while (true) {
                int[] iArr2 = this.f405963c;
                if (i3 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(3, iArr2[i3]);
                i3++;
            }
        }
        int i16 = this.f405964d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
