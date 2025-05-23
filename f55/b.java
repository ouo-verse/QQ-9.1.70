package f55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public e[] f397863a;

    /* renamed from: b, reason: collision with root package name */
    public int f397864b;

    /* renamed from: c, reason: collision with root package name */
    public h[] f397865c;

    public b() {
        a();
    }

    public static b c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (b) MessageNano.mergeFrom(new b(), bArr);
    }

    public b a() {
        this.f397863a = e.b();
        this.f397864b = 0;
        this.f397865c = h.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                            h[] hVarArr = this.f397865c;
                            if (hVarArr == null) {
                                length = 0;
                            } else {
                                length = hVarArr.length;
                            }
                            int i3 = repeatedFieldArrayLength + length;
                            h[] hVarArr2 = new h[i3];
                            if (length != 0) {
                                System.arraycopy(hVarArr, 0, hVarArr2, 0, length);
                            }
                            while (length < i3 - 1) {
                                h hVar = new h();
                                hVarArr2[length] = hVar;
                                codedInputByteBufferNano.readMessage(hVar);
                                codedInputByteBufferNano.readTag();
                                length++;
                            }
                            h hVar2 = new h();
                            hVarArr2[length] = hVar2;
                            codedInputByteBufferNano.readMessage(hVar2);
                            this.f397865c = hVarArr2;
                        }
                    } else {
                        this.f397864b = codedInputByteBufferNano.readInt32();
                    }
                } else {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    e[] eVarArr = this.f397863a;
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
                    this.f397863a = eVarArr2;
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
        e[] eVarArr = this.f397863a;
        int i3 = 0;
        if (eVarArr != null && eVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                e[] eVarArr2 = this.f397863a;
                if (i16 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i16];
                if (eVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, eVar);
                }
                i16++;
            }
        }
        int i17 = this.f397864b;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i17);
        }
        h[] hVarArr = this.f397865c;
        if (hVarArr != null && hVarArr.length > 0) {
            while (true) {
                h[] hVarArr2 = this.f397865c;
                if (i3 >= hVarArr2.length) {
                    break;
                }
                h hVar = hVarArr2[i3];
                if (hVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, hVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        e[] eVarArr = this.f397863a;
        int i3 = 0;
        if (eVarArr != null && eVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                e[] eVarArr2 = this.f397863a;
                if (i16 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i16];
                if (eVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, eVar);
                }
                i16++;
            }
        }
        int i17 = this.f397864b;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i17);
        }
        h[] hVarArr = this.f397865c;
        if (hVarArr != null && hVarArr.length > 0) {
            while (true) {
                h[] hVarArr2 = this.f397865c;
                if (i3 >= hVarArr2.length) {
                    break;
                }
                h hVar = hVarArr2[i3];
                if (hVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, hVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
