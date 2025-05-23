package op4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public String f423310a;

    /* renamed from: b, reason: collision with root package name */
    public int f423311b;

    /* renamed from: c, reason: collision with root package name */
    public sp4.c[] f423312c;

    /* renamed from: d, reason: collision with root package name */
    public int f423313d;

    public d() {
        a();
    }

    public d a() {
        this.f423310a = "";
        this.f423311b = 0;
        this.f423312c = sp4.c.b();
        this.f423313d = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f423313d = codedInputByteBufferNano.readUInt32();
                            }
                        } else {
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                            sp4.c[] cVarArr = this.f423312c;
                            if (cVarArr == null) {
                                length = 0;
                            } else {
                                length = cVarArr.length;
                            }
                            int i3 = repeatedFieldArrayLength + length;
                            sp4.c[] cVarArr2 = new sp4.c[i3];
                            if (length != 0) {
                                System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                            }
                            while (length < i3 - 1) {
                                sp4.c cVar = new sp4.c();
                                cVarArr2[length] = cVar;
                                codedInputByteBufferNano.readMessage(cVar);
                                codedInputByteBufferNano.readTag();
                                length++;
                            }
                            sp4.c cVar2 = new sp4.c();
                            cVarArr2[length] = cVar2;
                            codedInputByteBufferNano.readMessage(cVar2);
                            this.f423312c = cVarArr2;
                        }
                    } else {
                        this.f423311b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    this.f423310a = codedInputByteBufferNano.readString();
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
        if (!this.f423310a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f423310a);
        }
        int i3 = this.f423311b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        sp4.c[] cVarArr = this.f423312c;
        if (cVarArr != null && cVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                sp4.c[] cVarArr2 = this.f423312c;
                if (i16 >= cVarArr2.length) {
                    break;
                }
                sp4.c cVar = cVarArr2[i16];
                if (cVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, cVar);
                }
                i16++;
            }
        }
        int i17 = this.f423313d;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f423310a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f423310a);
        }
        int i3 = this.f423311b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        sp4.c[] cVarArr = this.f423312c;
        if (cVarArr != null && cVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                sp4.c[] cVarArr2 = this.f423312c;
                if (i16 >= cVarArr2.length) {
                    break;
                }
                sp4.c cVar = cVarArr2[i16];
                if (cVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, cVar);
                }
                i16++;
            }
        }
        int i17 = this.f423313d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
