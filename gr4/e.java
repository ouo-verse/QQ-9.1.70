package gr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public int f403111a;

    /* renamed from: b, reason: collision with root package name */
    public String f403112b;

    /* renamed from: c, reason: collision with root package name */
    public s f403113c;

    /* renamed from: d, reason: collision with root package name */
    public aa f403114d;

    /* renamed from: e, reason: collision with root package name */
    public l f403115e;

    /* renamed from: f, reason: collision with root package name */
    public z f403116f;

    /* renamed from: g, reason: collision with root package name */
    public y[] f403117g;

    /* renamed from: h, reason: collision with root package name */
    public a f403118h;

    public e() {
        a();
    }

    public static e c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (e) MessageNano.mergeFrom(new e(), bArr);
    }

    public e a() {
        this.f403111a = 0;
        this.f403112b = "";
        this.f403113c = null;
        this.f403114d = null;
        this.f403115e = null;
        this.f403116f = null;
        this.f403117g = y.b();
        this.f403118h = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (readTag != 50) {
                                        if (readTag != 58) {
                                            if (readTag != 16386) {
                                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                    return this;
                                                }
                                            } else {
                                                if (this.f403118h == null) {
                                                    this.f403118h = new a();
                                                }
                                                codedInputByteBufferNano.readMessage(this.f403118h);
                                            }
                                        } else {
                                            if (this.f403116f == null) {
                                                this.f403116f = new z();
                                            }
                                            codedInputByteBufferNano.readMessage(this.f403116f);
                                        }
                                    } else {
                                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                                        y[] yVarArr = this.f403117g;
                                        if (yVarArr == null) {
                                            length = 0;
                                        } else {
                                            length = yVarArr.length;
                                        }
                                        int i3 = repeatedFieldArrayLength + length;
                                        y[] yVarArr2 = new y[i3];
                                        if (length != 0) {
                                            System.arraycopy(yVarArr, 0, yVarArr2, 0, length);
                                        }
                                        while (length < i3 - 1) {
                                            y yVar = new y();
                                            yVarArr2[length] = yVar;
                                            codedInputByteBufferNano.readMessage(yVar);
                                            codedInputByteBufferNano.readTag();
                                            length++;
                                        }
                                        y yVar2 = new y();
                                        yVarArr2[length] = yVar2;
                                        codedInputByteBufferNano.readMessage(yVar2);
                                        this.f403117g = yVarArr2;
                                    }
                                } else {
                                    if (this.f403115e == null) {
                                        this.f403115e = new l();
                                    }
                                    codedInputByteBufferNano.readMessage(this.f403115e);
                                }
                            } else {
                                if (this.f403114d == null) {
                                    this.f403114d = new aa();
                                }
                                codedInputByteBufferNano.readMessage(this.f403114d);
                            }
                        } else {
                            if (this.f403113c == null) {
                                this.f403113c = new s();
                            }
                            codedInputByteBufferNano.readMessage(this.f403113c);
                        }
                    } else {
                        this.f403112b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f403111a = codedInputByteBufferNano.readInt32();
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
        int i3 = this.f403111a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.f403112b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f403112b);
        }
        s sVar = this.f403113c;
        if (sVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, sVar);
        }
        aa aaVar = this.f403114d;
        if (aaVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, aaVar);
        }
        l lVar = this.f403115e;
        if (lVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, lVar);
        }
        y[] yVarArr = this.f403117g;
        if (yVarArr != null && yVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                y[] yVarArr2 = this.f403117g;
                if (i16 >= yVarArr2.length) {
                    break;
                }
                y yVar = yVarArr2[i16];
                if (yVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, yVar);
                }
                i16++;
            }
        }
        z zVar = this.f403116f;
        if (zVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, zVar);
        }
        a aVar = this.f403118h;
        if (aVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2048, aVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f403111a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f403112b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f403112b);
        }
        s sVar = this.f403113c;
        if (sVar != null) {
            codedOutputByteBufferNano.writeMessage(3, sVar);
        }
        aa aaVar = this.f403114d;
        if (aaVar != null) {
            codedOutputByteBufferNano.writeMessage(4, aaVar);
        }
        l lVar = this.f403115e;
        if (lVar != null) {
            codedOutputByteBufferNano.writeMessage(5, lVar);
        }
        y[] yVarArr = this.f403117g;
        if (yVarArr != null && yVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                y[] yVarArr2 = this.f403117g;
                if (i16 >= yVarArr2.length) {
                    break;
                }
                y yVar = yVarArr2[i16];
                if (yVar != null) {
                    codedOutputByteBufferNano.writeMessage(6, yVar);
                }
                i16++;
            }
        }
        z zVar = this.f403116f;
        if (zVar != null) {
            codedOutputByteBufferNano.writeMessage(7, zVar);
        }
        a aVar = this.f403118h;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(2048, aVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
