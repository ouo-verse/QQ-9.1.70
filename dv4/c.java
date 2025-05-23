package dv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f395021a;

    /* renamed from: b, reason: collision with root package name */
    public uu4.h f395022b;

    /* renamed from: c, reason: collision with root package name */
    public uu4.h f395023c;

    /* renamed from: d, reason: collision with root package name */
    public int f395024d;

    public c() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f395021a = codedInputByteBufferNano.readBool();
            } else if (readTag == 18) {
                if (this.f395022b == null) {
                    this.f395022b = new uu4.h();
                }
                codedInputByteBufferNano.readMessage(this.f395022b);
            } else if (readTag == 26) {
                if (this.f395023c == null) {
                    this.f395023c = new uu4.h();
                }
                codedInputByteBufferNano.readMessage(this.f395023c);
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f395024d = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z16 = this.f395021a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        uu4.h hVar = this.f395022b;
        if (hVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, hVar);
        }
        uu4.h hVar2 = this.f395023c;
        if (hVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, hVar2);
        }
        int i3 = this.f395024d;
        return i3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f395021a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        uu4.h hVar = this.f395022b;
        if (hVar != null) {
            codedOutputByteBufferNano.writeMessage(2, hVar);
        }
        uu4.h hVar2 = this.f395023c;
        if (hVar2 != null) {
            codedOutputByteBufferNano.writeMessage(3, hVar2);
        }
        int i3 = this.f395024d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public c a() {
        this.f395021a = false;
        this.f395022b = null;
        this.f395023c = null;
        this.f395024d = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
