package fu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class ak extends ExtendableMessageNano<ak> {

    /* renamed from: a, reason: collision with root package name */
    public al f400695a;

    /* renamed from: b, reason: collision with root package name */
    public au f400696b;

    /* renamed from: c, reason: collision with root package name */
    public o f400697c;

    /* renamed from: d, reason: collision with root package name */
    public m f400698d;

    /* renamed from: e, reason: collision with root package name */
    public h f400699e;

    /* renamed from: f, reason: collision with root package name */
    public ap f400700f;

    /* renamed from: g, reason: collision with root package name */
    public y f400701g;

    /* renamed from: h, reason: collision with root package name */
    public as f400702h;

    /* renamed from: i, reason: collision with root package name */
    public q f400703i;

    /* renamed from: j, reason: collision with root package name */
    public byte[] f400704j;

    public ak() {
        a();
    }

    public ak a() {
        this.f400695a = null;
        this.f400696b = null;
        this.f400697c = null;
        this.f400698d = null;
        this.f400699e = null;
        this.f400700f = null;
        this.f400701g = null;
        this.f400702h = null;
        this.f400703i = null;
        this.f400704j = WireFormatNano.EMPTY_BYTES;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ak mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    if (this.f400695a == null) {
                        this.f400695a = new al();
                    }
                    codedInputByteBufferNano.readMessage(this.f400695a);
                    break;
                case 18:
                    if (this.f400696b == null) {
                        this.f400696b = new au();
                    }
                    codedInputByteBufferNano.readMessage(this.f400696b);
                    break;
                case 26:
                    if (this.f400697c == null) {
                        this.f400697c = new o();
                    }
                    codedInputByteBufferNano.readMessage(this.f400697c);
                    break;
                case 34:
                    if (this.f400698d == null) {
                        this.f400698d = new m();
                    }
                    codedInputByteBufferNano.readMessage(this.f400698d);
                    break;
                case 42:
                    if (this.f400699e == null) {
                        this.f400699e = new h();
                    }
                    codedInputByteBufferNano.readMessage(this.f400699e);
                    break;
                case 50:
                    if (this.f400700f == null) {
                        this.f400700f = new ap();
                    }
                    codedInputByteBufferNano.readMessage(this.f400700f);
                    break;
                case 58:
                    if (this.f400701g == null) {
                        this.f400701g = new y();
                    }
                    codedInputByteBufferNano.readMessage(this.f400701g);
                    break;
                case 66:
                    if (this.f400702h == null) {
                        this.f400702h = new as();
                    }
                    codedInputByteBufferNano.readMessage(this.f400702h);
                    break;
                case 74:
                    if (this.f400703i == null) {
                        this.f400703i = new q();
                    }
                    codedInputByteBufferNano.readMessage(this.f400703i);
                    break;
                case com.tencent.luggage.wxa.uf.n.CTRL_INDEX /* 794 */:
                    this.f400704j = codedInputByteBufferNano.readBytes();
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
        al alVar = this.f400695a;
        if (alVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, alVar);
        }
        au auVar = this.f400696b;
        if (auVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, auVar);
        }
        o oVar = this.f400697c;
        if (oVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, oVar);
        }
        m mVar = this.f400698d;
        if (mVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, mVar);
        }
        h hVar = this.f400699e;
        if (hVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, hVar);
        }
        ap apVar = this.f400700f;
        if (apVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, apVar);
        }
        y yVar = this.f400701g;
        if (yVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, yVar);
        }
        as asVar = this.f400702h;
        if (asVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, asVar);
        }
        q qVar = this.f400703i;
        if (qVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, qVar);
        }
        if (!Arrays.equals(this.f400704j, WireFormatNano.EMPTY_BYTES)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(99, this.f400704j);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        al alVar = this.f400695a;
        if (alVar != null) {
            codedOutputByteBufferNano.writeMessage(1, alVar);
        }
        au auVar = this.f400696b;
        if (auVar != null) {
            codedOutputByteBufferNano.writeMessage(2, auVar);
        }
        o oVar = this.f400697c;
        if (oVar != null) {
            codedOutputByteBufferNano.writeMessage(3, oVar);
        }
        m mVar = this.f400698d;
        if (mVar != null) {
            codedOutputByteBufferNano.writeMessage(4, mVar);
        }
        h hVar = this.f400699e;
        if (hVar != null) {
            codedOutputByteBufferNano.writeMessage(5, hVar);
        }
        ap apVar = this.f400700f;
        if (apVar != null) {
            codedOutputByteBufferNano.writeMessage(6, apVar);
        }
        y yVar = this.f400701g;
        if (yVar != null) {
            codedOutputByteBufferNano.writeMessage(7, yVar);
        }
        as asVar = this.f400702h;
        if (asVar != null) {
            codedOutputByteBufferNano.writeMessage(8, asVar);
        }
        q qVar = this.f400703i;
        if (qVar != null) {
            codedOutputByteBufferNano.writeMessage(9, qVar);
        }
        if (!Arrays.equals(this.f400704j, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(99, this.f400704j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
