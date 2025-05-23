package dw4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;
import pu4.x;
import qu4.h;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public int f395107a;

    /* renamed from: b, reason: collision with root package name */
    public int f395108b;

    /* renamed from: c, reason: collision with root package name */
    public h f395109c;

    /* renamed from: d, reason: collision with root package name */
    public h f395110d;

    /* renamed from: e, reason: collision with root package name */
    public h f395111e;

    /* renamed from: f, reason: collision with root package name */
    public x f395112f;

    public a() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f395107a = codedInputByteBufferNano.readInt32();
            } else if (readTag == 16) {
                this.f395108b = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 26) {
                if (this.f395109c == null) {
                    this.f395109c = new h();
                }
                codedInputByteBufferNano.readMessage(this.f395109c);
            } else if (readTag == 34) {
                if (this.f395110d == null) {
                    this.f395110d = new h();
                }
                codedInputByteBufferNano.readMessage(this.f395110d);
            } else if (readTag == 42) {
                if (this.f395111e == null) {
                    this.f395111e = new h();
                }
                codedInputByteBufferNano.readMessage(this.f395111e);
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f395112f == null) {
                    this.f395112f = new x();
                }
                codedInputByteBufferNano.readMessage(this.f395112f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f395107a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.f395108b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        h hVar = this.f395109c;
        if (hVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, hVar);
        }
        h hVar2 = this.f395110d;
        if (hVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, hVar2);
        }
        h hVar3 = this.f395111e;
        if (hVar3 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, hVar3);
        }
        x xVar = this.f395112f;
        return xVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(6, xVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f395107a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.f395108b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        h hVar = this.f395109c;
        if (hVar != null) {
            codedOutputByteBufferNano.writeMessage(3, hVar);
        }
        h hVar2 = this.f395110d;
        if (hVar2 != null) {
            codedOutputByteBufferNano.writeMessage(4, hVar2);
        }
        h hVar3 = this.f395111e;
        if (hVar3 != null) {
            codedOutputByteBufferNano.writeMessage(5, hVar3);
        }
        x xVar = this.f395112f;
        if (xVar != null) {
            codedOutputByteBufferNano.writeMessage(6, xVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public a a() {
        this.f395107a = 0;
        this.f395108b = 0;
        this.f395109c = null;
        this.f395110d = null;
        this.f395111e = null;
        this.f395112f = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
