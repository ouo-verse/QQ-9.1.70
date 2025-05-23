package p55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: g, reason: collision with root package name */
    private static volatile e[] f425378g;

    /* renamed from: a, reason: collision with root package name */
    public d f425379a;

    /* renamed from: b, reason: collision with root package name */
    public int f425380b;

    /* renamed from: c, reason: collision with root package name */
    public String f425381c;

    /* renamed from: d, reason: collision with root package name */
    public String f425382d;

    /* renamed from: e, reason: collision with root package name */
    public String f425383e;

    /* renamed from: f, reason: collision with root package name */
    public h[] f425384f;

    public e() {
        a();
    }

    public static e[] b() {
        if (f425378g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f425378g == null) {
                    f425378g = new e[0];
                }
            }
        }
        return f425378g;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f425379a == null) {
                    this.f425379a = new d();
                }
                codedInputByteBufferNano.readMessage(this.f425379a);
            } else if (readTag == 16) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3 || readInt32 == 100) {
                    this.f425380b = readInt32;
                }
            } else if (readTag == 26) {
                this.f425381c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f425382d = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.f425383e = codedInputByteBufferNano.readString();
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                h[] hVarArr = this.f425384f;
                int length = hVarArr == null ? 0 : hVarArr.length;
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
                this.f425384f = hVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        d dVar = this.f425379a;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, dVar);
        }
        int i3 = this.f425380b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        if (!this.f425381c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f425381c);
        }
        if (!this.f425382d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f425382d);
        }
        if (!this.f425383e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f425383e);
        }
        h[] hVarArr = this.f425384f;
        if (hVarArr != null && hVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                h[] hVarArr2 = this.f425384f;
                if (i16 >= hVarArr2.length) {
                    break;
                }
                h hVar = hVarArr2[i16];
                if (hVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, hVar);
                }
                i16++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        d dVar = this.f425379a;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(1, dVar);
        }
        int i3 = this.f425380b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        if (!this.f425381c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f425381c);
        }
        if (!this.f425382d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f425382d);
        }
        if (!this.f425383e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f425383e);
        }
        h[] hVarArr = this.f425384f;
        if (hVarArr != null && hVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                h[] hVarArr2 = this.f425384f;
                if (i16 >= hVarArr2.length) {
                    break;
                }
                h hVar = hVarArr2[i16];
                if (hVar != null) {
                    codedOutputByteBufferNano.writeMessage(6, hVar);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public e a() {
        this.f425379a = null;
        this.f425380b = 0;
        this.f425381c = "";
        this.f425382d = "";
        this.f425383e = "";
        this.f425384f = h.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
