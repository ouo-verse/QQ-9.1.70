package oz0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import sr4.g;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public long f424557a;

    /* renamed from: b, reason: collision with root package name */
    public g[] f424558b;

    /* renamed from: c, reason: collision with root package name */
    public int f424559c;

    /* renamed from: d, reason: collision with root package name */
    public int f424560d;

    /* renamed from: e, reason: collision with root package name */
    public int f424561e;

    /* renamed from: f, reason: collision with root package name */
    public int f424562f;

    /* renamed from: g, reason: collision with root package name */
    public int f424563g;

    public a() {
        a();
    }

    public static a c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (a) MessageNano.mergeFrom(new a(), bArr);
    }

    public a a() {
        this.f424557a = 0L;
        this.f424558b = g.b();
        this.f424559c = 0;
        this.f424560d = 0;
        this.f424561e = 0;
        this.f424562f = 0;
        this.f424563g = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (readTag != 48) {
                                        if (readTag != 56) {
                                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                return this;
                                            }
                                        } else {
                                            this.f424563g = codedInputByteBufferNano.readUInt32();
                                        }
                                    } else {
                                        this.f424562f = codedInputByteBufferNano.readUInt32();
                                    }
                                } else {
                                    this.f424561e = codedInputByteBufferNano.readUInt32();
                                }
                            } else {
                                this.f424560d = codedInputByteBufferNano.readUInt32();
                            }
                        } else {
                            this.f424559c = codedInputByteBufferNano.readUInt32();
                        }
                    } else {
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        g[] gVarArr = this.f424558b;
                        if (gVarArr == null) {
                            length = 0;
                        } else {
                            length = gVarArr.length;
                        }
                        int i3 = repeatedFieldArrayLength + length;
                        g[] gVarArr2 = new g[i3];
                        if (length != 0) {
                            System.arraycopy(gVarArr, 0, gVarArr2, 0, length);
                        }
                        while (length < i3 - 1) {
                            g gVar = new g();
                            gVarArr2[length] = gVar;
                            codedInputByteBufferNano.readMessage(gVar);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        g gVar2 = new g();
                        gVarArr2[length] = gVar2;
                        codedInputByteBufferNano.readMessage(gVar2);
                        this.f424558b = gVarArr2;
                    }
                } else {
                    this.f424557a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f424557a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        g[] gVarArr = this.f424558b;
        if (gVarArr != null && gVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                g[] gVarArr2 = this.f424558b;
                if (i3 >= gVarArr2.length) {
                    break;
                }
                g gVar = gVarArr2[i3];
                if (gVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, gVar);
                }
                i3++;
            }
        }
        int i16 = this.f424559c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        int i17 = this.f424560d;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        int i18 = this.f424561e;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i18);
        }
        int i19 = this.f424562f;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i19);
        }
        int i26 = this.f424563g;
        if (i26 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(7, i26);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f424557a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        g[] gVarArr = this.f424558b;
        if (gVarArr != null && gVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                g[] gVarArr2 = this.f424558b;
                if (i3 >= gVarArr2.length) {
                    break;
                }
                g gVar = gVarArr2[i3];
                if (gVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, gVar);
                }
                i3++;
            }
        }
        int i16 = this.f424559c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        int i17 = this.f424560d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        int i18 = this.f424561e;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i18);
        }
        int i19 = this.f424562f;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i19);
        }
        int i26 = this.f424563g;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i26);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
