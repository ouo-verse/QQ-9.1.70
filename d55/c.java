package d55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public int f393061a;

    /* renamed from: b, reason: collision with root package name */
    public long f393062b;

    /* renamed from: c, reason: collision with root package name */
    public String f393063c;

    /* renamed from: d, reason: collision with root package name */
    public l[] f393064d;

    public c() {
        a();
    }

    public static c c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (c) MessageNano.mergeFrom(new c(), bArr);
    }

    public c a() {
        this.f393061a = 0;
        this.f393062b = 0L;
        this.f393063c = "";
        this.f393064d = l.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                                l[] lVarArr = this.f393064d;
                                if (lVarArr == null) {
                                    length = 0;
                                } else {
                                    length = lVarArr.length;
                                }
                                int i3 = repeatedFieldArrayLength + length;
                                l[] lVarArr2 = new l[i3];
                                if (length != 0) {
                                    System.arraycopy(lVarArr, 0, lVarArr2, 0, length);
                                }
                                while (length < i3 - 1) {
                                    l lVar = new l();
                                    lVarArr2[length] = lVar;
                                    codedInputByteBufferNano.readMessage(lVar);
                                    codedInputByteBufferNano.readTag();
                                    length++;
                                }
                                l lVar2 = new l();
                                lVarArr2[length] = lVar2;
                                codedInputByteBufferNano.readMessage(lVar2);
                                this.f393064d = lVarArr2;
                            }
                        } else {
                            this.f393063c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f393062b = codedInputByteBufferNano.readUInt64();
                    }
                } else {
                    this.f393061a = codedInputByteBufferNano.readUInt32();
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
        int i3 = this.f393061a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        long j3 = this.f393062b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        if (!this.f393063c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f393063c);
        }
        l[] lVarArr = this.f393064d;
        if (lVarArr != null && lVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                l[] lVarArr2 = this.f393064d;
                if (i16 >= lVarArr2.length) {
                    break;
                }
                l lVar = lVarArr2[i16];
                if (lVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, lVar);
                }
                i16++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f393061a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        long j3 = this.f393062b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        if (!this.f393063c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f393063c);
        }
        l[] lVarArr = this.f393064d;
        if (lVarArr != null && lVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                l[] lVarArr2 = this.f393064d;
                if (i16 >= lVarArr2.length) {
                    break;
                }
                l lVar = lVarArr2[i16];
                if (lVar != null) {
                    codedOutputByteBufferNano.writeMessage(4, lVar);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
