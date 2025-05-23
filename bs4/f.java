package bs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public long f29057a;

    /* renamed from: b, reason: collision with root package name */
    public g[] f29058b;

    /* renamed from: c, reason: collision with root package name */
    public j[] f29059c;

    /* renamed from: d, reason: collision with root package name */
    public i[] f29060d;

    public f() {
        a();
    }

    public static f c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (f) MessageNano.mergeFrom(new f(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f29057a = codedInputByteBufferNano.readInt64();
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                g[] gVarArr = this.f29058b;
                int length = gVarArr == null ? 0 : gVarArr.length;
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
                this.f29058b = gVarArr2;
            } else if (readTag == 26) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                j[] jVarArr = this.f29059c;
                int length2 = jVarArr == null ? 0 : jVarArr.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                j[] jVarArr2 = new j[i16];
                if (length2 != 0) {
                    System.arraycopy(jVarArr, 0, jVarArr2, 0, length2);
                }
                while (length2 < i16 - 1) {
                    j jVar = new j();
                    jVarArr2[length2] = jVar;
                    codedInputByteBufferNano.readMessage(jVar);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                j jVar2 = new j();
                jVarArr2[length2] = jVar2;
                codedInputByteBufferNano.readMessage(jVar2);
                this.f29059c = jVarArr2;
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                i[] iVarArr = this.f29060d;
                int length3 = iVarArr == null ? 0 : iVarArr.length;
                int i17 = repeatedFieldArrayLength3 + length3;
                i[] iVarArr2 = new i[i17];
                if (length3 != 0) {
                    System.arraycopy(iVarArr, 0, iVarArr2, 0, length3);
                }
                while (length3 < i17 - 1) {
                    i iVar = new i();
                    iVarArr2[length3] = iVar;
                    codedInputByteBufferNano.readMessage(iVar);
                    codedInputByteBufferNano.readTag();
                    length3++;
                }
                i iVar2 = new i();
                iVarArr2[length3] = iVar2;
                codedInputByteBufferNano.readMessage(iVar2);
                this.f29060d = iVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f29057a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j3);
        }
        g[] gVarArr = this.f29058b;
        int i3 = 0;
        if (gVarArr != null && gVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                g[] gVarArr2 = this.f29058b;
                if (i16 >= gVarArr2.length) {
                    break;
                }
                g gVar = gVarArr2[i16];
                if (gVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, gVar);
                }
                i16++;
            }
        }
        j[] jVarArr = this.f29059c;
        if (jVarArr != null && jVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                j[] jVarArr2 = this.f29059c;
                if (i17 >= jVarArr2.length) {
                    break;
                }
                j jVar = jVarArr2[i17];
                if (jVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, jVar);
                }
                i17++;
            }
        }
        i[] iVarArr = this.f29060d;
        if (iVarArr != null && iVarArr.length > 0) {
            while (true) {
                i[] iVarArr2 = this.f29060d;
                if (i3 >= iVarArr2.length) {
                    break;
                }
                i iVar = iVarArr2[i3];
                if (iVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, iVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f29057a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(1, j3);
        }
        g[] gVarArr = this.f29058b;
        int i3 = 0;
        if (gVarArr != null && gVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                g[] gVarArr2 = this.f29058b;
                if (i16 >= gVarArr2.length) {
                    break;
                }
                g gVar = gVarArr2[i16];
                if (gVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, gVar);
                }
                i16++;
            }
        }
        j[] jVarArr = this.f29059c;
        if (jVarArr != null && jVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                j[] jVarArr2 = this.f29059c;
                if (i17 >= jVarArr2.length) {
                    break;
                }
                j jVar = jVarArr2[i17];
                if (jVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, jVar);
                }
                i17++;
            }
        }
        i[] iVarArr = this.f29060d;
        if (iVarArr != null && iVarArr.length > 0) {
            while (true) {
                i[] iVarArr2 = this.f29060d;
                if (i3 >= iVarArr2.length) {
                    break;
                }
                i iVar = iVarArr2[i3];
                if (iVar != null) {
                    codedOutputByteBufferNano.writeMessage(4, iVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public f a() {
        this.f29057a = 0L;
        this.f29058b = g.b();
        this.f29059c = j.b();
        this.f29060d = i.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
