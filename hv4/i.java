package hv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class i extends ExtendableMessageNano<i> {

    /* renamed from: a, reason: collision with root package name */
    public g[] f406431a;

    /* renamed from: b, reason: collision with root package name */
    public String f406432b;

    /* renamed from: c, reason: collision with root package name */
    public String f406433c;

    /* renamed from: d, reason: collision with root package name */
    public String f406434d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f406435e;

    public i() {
        a();
    }

    public i a() {
        this.f406431a = g.b();
        this.f406432b = "";
        this.f406433c = "";
        this.f406434d = "";
        this.f406435e = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public i mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                g[] gVarArr = this.f406431a;
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
                this.f406431a = gVarArr2;
            } else if (readTag == 18) {
                this.f406432b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f406433c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f406434d = codedInputByteBufferNano.readString();
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f406435e = codedInputByteBufferNano.readBool();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        g[] gVarArr = this.f406431a;
        if (gVarArr != null && gVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                g[] gVarArr2 = this.f406431a;
                if (i3 >= gVarArr2.length) {
                    break;
                }
                g gVar = gVarArr2[i3];
                if (gVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, gVar);
                }
                i3++;
            }
        }
        if (!this.f406432b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f406432b);
        }
        if (!this.f406433c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f406433c);
        }
        if (!this.f406434d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f406434d);
        }
        boolean z16 = this.f406435e;
        return z16 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(5, z16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        g[] gVarArr = this.f406431a;
        if (gVarArr != null && gVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                g[] gVarArr2 = this.f406431a;
                if (i3 >= gVarArr2.length) {
                    break;
                }
                g gVar = gVarArr2[i3];
                if (gVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, gVar);
                }
                i3++;
            }
        }
        if (!this.f406432b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f406432b);
        }
        if (!this.f406433c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f406433c);
        }
        if (!this.f406434d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f406434d);
        }
        boolean z16 = this.f406435e;
        if (z16) {
            codedOutputByteBufferNano.writeBool(5, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
