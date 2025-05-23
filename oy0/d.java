package oy0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public int f424476a;

    /* renamed from: b, reason: collision with root package name */
    public String f424477b;

    /* renamed from: c, reason: collision with root package name */
    public h[] f424478c;

    /* renamed from: d, reason: collision with root package name */
    public int f424479d;

    /* renamed from: e, reason: collision with root package name */
    public int f424480e;

    public d() {
        a();
    }

    public static d c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (d) MessageNano.mergeFrom(new d(), bArr);
    }

    public d a() {
        this.f424476a = 0;
        this.f424477b = "";
        this.f424478c = h.b();
        this.f424479d = 0;
        this.f424480e = 0;
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
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    this.f424480e = codedInputByteBufferNano.readUInt32();
                                }
                            } else {
                                this.f424479d = codedInputByteBufferNano.readUInt32();
                            }
                        } else {
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                            h[] hVarArr = this.f424478c;
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
                            this.f424478c = hVarArr2;
                        }
                    } else {
                        this.f424477b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f424476a = codedInputByteBufferNano.readInt32();
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
        int i3 = this.f424476a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.f424477b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f424477b);
        }
        h[] hVarArr = this.f424478c;
        if (hVarArr != null && hVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                h[] hVarArr2 = this.f424478c;
                if (i16 >= hVarArr2.length) {
                    break;
                }
                h hVar = hVarArr2[i16];
                if (hVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, hVar);
                }
                i16++;
            }
        }
        int i17 = this.f424479d;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        int i18 = this.f424480e;
        if (i18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(5, i18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f424476a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f424477b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f424477b);
        }
        h[] hVarArr = this.f424478c;
        if (hVarArr != null && hVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                h[] hVarArr2 = this.f424478c;
                if (i16 >= hVarArr2.length) {
                    break;
                }
                h hVar = hVarArr2[i16];
                if (hVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, hVar);
                }
                i16++;
            }
        }
        int i17 = this.f424479d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        int i18 = this.f424480e;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
