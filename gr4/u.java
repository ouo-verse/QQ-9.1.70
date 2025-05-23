package gr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.tencent.component.media.MtpConstants;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class u extends ExtendableMessageNano<u> {

    /* renamed from: a, reason: collision with root package name */
    public long f403214a;

    /* renamed from: b, reason: collision with root package name */
    public y[] f403215b;

    /* renamed from: c, reason: collision with root package name */
    public t f403216c;

    /* renamed from: d, reason: collision with root package name */
    public String f403217d;

    /* renamed from: e, reason: collision with root package name */
    public String f403218e;

    /* renamed from: f, reason: collision with root package name */
    public String f403219f;

    /* renamed from: g, reason: collision with root package name */
    public int f403220g;

    /* renamed from: h, reason: collision with root package name */
    public int f403221h;

    /* renamed from: i, reason: collision with root package name */
    public int f403222i;

    /* renamed from: j, reason: collision with root package name */
    public byte[] f403223j;

    /* renamed from: k, reason: collision with root package name */
    public long f403224k;

    /* renamed from: l, reason: collision with root package name */
    public int f403225l;

    /* renamed from: m, reason: collision with root package name */
    public rq4.a f403226m;

    /* renamed from: n, reason: collision with root package name */
    public rq4.b f403227n;

    public u() {
        a();
    }

    public u a() {
        this.f403214a = 0L;
        this.f403215b = y.b();
        this.f403216c = null;
        this.f403217d = "";
        this.f403218e = "";
        this.f403219f = "";
        this.f403220g = 0;
        this.f403221h = 0;
        this.f403222i = 0;
        this.f403223j = WireFormatNano.EMPTY_BYTES;
        this.f403224k = 0L;
        this.f403225l = 0;
        this.f403226m = null;
        this.f403227n = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public u mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f403214a = codedInputByteBufferNano.readUInt64();
                    break;
                case 18:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    y[] yVarArr = this.f403215b;
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
                    this.f403215b = yVarArr2;
                    break;
                case 26:
                    if (this.f403216c == null) {
                        this.f403216c = new t();
                    }
                    codedInputByteBufferNano.readMessage(this.f403216c);
                    break;
                case 34:
                    this.f403217d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f403218e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f403219f = codedInputByteBufferNano.readString();
                    break;
                case 56:
                    this.f403220g = codedInputByteBufferNano.readInt32();
                    break;
                case 64:
                    this.f403221h = codedInputByteBufferNano.readInt32();
                    break;
                case 72:
                    this.f403222i = codedInputByteBufferNano.readInt32();
                    break;
                case 82:
                    this.f403223j = codedInputByteBufferNano.readBytes();
                    break;
                case 88:
                    this.f403224k = codedInputByteBufferNano.readUInt64();
                    break;
                case 8192:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1) {
                        break;
                    } else {
                        this.f403225l = readInt32;
                        break;
                    }
                case MtpConstants.RESPONSE_DEVICE_PROP_NOT_SUPPORTED /* 8202 */:
                    if (this.f403226m == null) {
                        this.f403226m = new rq4.a();
                    }
                    codedInputByteBufferNano.readMessage(this.f403226m);
                    break;
                case 8210:
                    if (this.f403227n == null) {
                        this.f403227n = new rq4.b();
                    }
                    codedInputByteBufferNano.readMessage(this.f403227n);
                    break;
                default:
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f403214a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        y[] yVarArr = this.f403215b;
        if (yVarArr != null && yVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                y[] yVarArr2 = this.f403215b;
                if (i3 >= yVarArr2.length) {
                    break;
                }
                y yVar = yVarArr2[i3];
                if (yVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, yVar);
                }
                i3++;
            }
        }
        t tVar = this.f403216c;
        if (tVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, tVar);
        }
        if (!this.f403217d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f403217d);
        }
        if (!this.f403218e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f403218e);
        }
        if (!this.f403219f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f403219f);
        }
        int i16 = this.f403220g;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i16);
        }
        int i17 = this.f403221h;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i17);
        }
        int i18 = this.f403222i;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, i18);
        }
        if (!Arrays.equals(this.f403223j, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(10, this.f403223j);
        }
        long j16 = this.f403224k;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(11, j16);
        }
        int i19 = this.f403225l;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1024, i19);
        }
        rq4.a aVar = this.f403226m;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1025, aVar);
        }
        rq4.b bVar = this.f403227n;
        if (bVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1026, bVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f403214a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        y[] yVarArr = this.f403215b;
        if (yVarArr != null && yVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                y[] yVarArr2 = this.f403215b;
                if (i3 >= yVarArr2.length) {
                    break;
                }
                y yVar = yVarArr2[i3];
                if (yVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, yVar);
                }
                i3++;
            }
        }
        t tVar = this.f403216c;
        if (tVar != null) {
            codedOutputByteBufferNano.writeMessage(3, tVar);
        }
        if (!this.f403217d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f403217d);
        }
        if (!this.f403218e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f403218e);
        }
        if (!this.f403219f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f403219f);
        }
        int i16 = this.f403220g;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i16);
        }
        int i17 = this.f403221h;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i17);
        }
        int i18 = this.f403222i;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(9, i18);
        }
        if (!Arrays.equals(this.f403223j, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(10, this.f403223j);
        }
        long j16 = this.f403224k;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(11, j16);
        }
        int i19 = this.f403225l;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(1024, i19);
        }
        rq4.a aVar = this.f403226m;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(1025, aVar);
        }
        rq4.b bVar = this.f403227n;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(1026, bVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
