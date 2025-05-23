package ev4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public e f397207a;

    /* renamed from: b, reason: collision with root package name */
    public e[] f397208b;

    /* renamed from: c, reason: collision with root package name */
    public h f397209c;

    /* renamed from: d, reason: collision with root package name */
    public h[] f397210d;

    /* renamed from: e, reason: collision with root package name */
    public int f397211e;

    /* renamed from: f, reason: collision with root package name */
    public String f397212f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f397213g;

    public b() {
        a();
    }

    public static b c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (b) MessageNano.mergeFrom(new b(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f397207a == null) {
                    this.f397207a = new e();
                }
                codedInputByteBufferNano.readMessage(this.f397207a);
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                e[] eVarArr = this.f397208b;
                int length = eVarArr == null ? 0 : eVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                e[] eVarArr2 = new e[i3];
                if (length != 0) {
                    System.arraycopy(eVarArr, 0, eVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    e eVar = new e();
                    eVarArr2[length] = eVar;
                    codedInputByteBufferNano.readMessage(eVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                e eVar2 = new e();
                eVarArr2[length] = eVar2;
                codedInputByteBufferNano.readMessage(eVar2);
                this.f397208b = eVarArr2;
            } else if (readTag == 26) {
                if (this.f397209c == null) {
                    this.f397209c = new h();
                }
                codedInputByteBufferNano.readMessage(this.f397209c);
            } else if (readTag == 34) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                h[] hVarArr = this.f397210d;
                int length2 = hVarArr == null ? 0 : hVarArr.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                h[] hVarArr2 = new h[i16];
                if (length2 != 0) {
                    System.arraycopy(hVarArr, 0, hVarArr2, 0, length2);
                }
                while (length2 < i16 - 1) {
                    h hVar = new h();
                    hVarArr2[length2] = hVar;
                    codedInputByteBufferNano.readMessage(hVar);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                h hVar2 = new h();
                hVarArr2[length2] = hVar2;
                codedInputByteBufferNano.readMessage(hVar2);
                this.f397210d = hVarArr2;
            } else if (readTag == 40) {
                this.f397211e = codedInputByteBufferNano.readInt32();
            } else if (readTag == 50) {
                this.f397212f = codedInputByteBufferNano.readString();
            } else if (readTag != 56) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f397213g = codedInputByteBufferNano.readBool();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        e eVar = this.f397207a;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, eVar);
        }
        e[] eVarArr = this.f397208b;
        int i3 = 0;
        if (eVarArr != null && eVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                e[] eVarArr2 = this.f397208b;
                if (i16 >= eVarArr2.length) {
                    break;
                }
                e eVar2 = eVarArr2[i16];
                if (eVar2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, eVar2);
                }
                i16++;
            }
        }
        h hVar = this.f397209c;
        if (hVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, hVar);
        }
        h[] hVarArr = this.f397210d;
        if (hVarArr != null && hVarArr.length > 0) {
            while (true) {
                h[] hVarArr2 = this.f397210d;
                if (i3 >= hVarArr2.length) {
                    break;
                }
                h hVar2 = hVarArr2[i3];
                if (hVar2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, hVar2);
                }
                i3++;
            }
        }
        int i17 = this.f397211e;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i17);
        }
        if (!this.f397212f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f397212f);
        }
        boolean z16 = this.f397213g;
        return z16 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(7, z16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        e eVar = this.f397207a;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(1, eVar);
        }
        e[] eVarArr = this.f397208b;
        int i3 = 0;
        if (eVarArr != null && eVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                e[] eVarArr2 = this.f397208b;
                if (i16 >= eVarArr2.length) {
                    break;
                }
                e eVar2 = eVarArr2[i16];
                if (eVar2 != null) {
                    codedOutputByteBufferNano.writeMessage(2, eVar2);
                }
                i16++;
            }
        }
        h hVar = this.f397209c;
        if (hVar != null) {
            codedOutputByteBufferNano.writeMessage(3, hVar);
        }
        h[] hVarArr = this.f397210d;
        if (hVarArr != null && hVarArr.length > 0) {
            while (true) {
                h[] hVarArr2 = this.f397210d;
                if (i3 >= hVarArr2.length) {
                    break;
                }
                h hVar2 = hVarArr2[i3];
                if (hVar2 != null) {
                    codedOutputByteBufferNano.writeMessage(4, hVar2);
                }
                i3++;
            }
        }
        int i17 = this.f397211e;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i17);
        }
        if (!this.f397212f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f397212f);
        }
        boolean z16 = this.f397213g;
        if (z16) {
            codedOutputByteBufferNano.writeBool(7, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public b a() {
        this.f397207a = null;
        this.f397208b = e.b();
        this.f397209c = null;
        this.f397210d = h.b();
        this.f397211e = 0;
        this.f397212f = "";
        this.f397213g = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
