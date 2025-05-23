package fu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class ah extends ExtendableMessageNano<ah> {

    /* renamed from: a, reason: collision with root package name */
    public ai f400678a;

    /* renamed from: b, reason: collision with root package name */
    public at f400679b;

    /* renamed from: c, reason: collision with root package name */
    public n f400680c;

    /* renamed from: d, reason: collision with root package name */
    public l f400681d;

    /* renamed from: e, reason: collision with root package name */
    public g f400682e;

    /* renamed from: f, reason: collision with root package name */
    public ao f400683f;

    /* renamed from: g, reason: collision with root package name */
    public x f400684g;

    /* renamed from: h, reason: collision with root package name */
    public ar f400685h;

    /* renamed from: i, reason: collision with root package name */
    public p f400686i;

    /* renamed from: j, reason: collision with root package name */
    public byte[] f400687j;

    public ah() {
        a();
    }

    public ah a() {
        this.f400678a = null;
        this.f400679b = null;
        this.f400680c = null;
        this.f400681d = null;
        this.f400682e = null;
        this.f400683f = null;
        this.f400684g = null;
        this.f400685h = null;
        this.f400686i = null;
        this.f400687j = WireFormatNano.EMPTY_BYTES;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ah mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    if (this.f400678a == null) {
                        this.f400678a = new ai();
                    }
                    codedInputByteBufferNano.readMessage(this.f400678a);
                    break;
                case 18:
                    if (this.f400679b == null) {
                        this.f400679b = new at();
                    }
                    codedInputByteBufferNano.readMessage(this.f400679b);
                    break;
                case 26:
                    if (this.f400680c == null) {
                        this.f400680c = new n();
                    }
                    codedInputByteBufferNano.readMessage(this.f400680c);
                    break;
                case 34:
                    if (this.f400681d == null) {
                        this.f400681d = new l();
                    }
                    codedInputByteBufferNano.readMessage(this.f400681d);
                    break;
                case 42:
                    if (this.f400682e == null) {
                        this.f400682e = new g();
                    }
                    codedInputByteBufferNano.readMessage(this.f400682e);
                    break;
                case 50:
                    if (this.f400683f == null) {
                        this.f400683f = new ao();
                    }
                    codedInputByteBufferNano.readMessage(this.f400683f);
                    break;
                case 58:
                    if (this.f400684g == null) {
                        this.f400684g = new x();
                    }
                    codedInputByteBufferNano.readMessage(this.f400684g);
                    break;
                case 66:
                    if (this.f400685h == null) {
                        this.f400685h = new ar();
                    }
                    codedInputByteBufferNano.readMessage(this.f400685h);
                    break;
                case 74:
                    if (this.f400686i == null) {
                        this.f400686i = new p();
                    }
                    codedInputByteBufferNano.readMessage(this.f400686i);
                    break;
                case com.tencent.luggage.wxa.uf.n.CTRL_INDEX /* 794 */:
                    this.f400687j = codedInputByteBufferNano.readBytes();
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
        ai aiVar = this.f400678a;
        if (aiVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, aiVar);
        }
        at atVar = this.f400679b;
        if (atVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, atVar);
        }
        n nVar = this.f400680c;
        if (nVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, nVar);
        }
        l lVar = this.f400681d;
        if (lVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, lVar);
        }
        g gVar = this.f400682e;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, gVar);
        }
        ao aoVar = this.f400683f;
        if (aoVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, aoVar);
        }
        x xVar = this.f400684g;
        if (xVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, xVar);
        }
        ar arVar = this.f400685h;
        if (arVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, arVar);
        }
        p pVar = this.f400686i;
        if (pVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, pVar);
        }
        if (!Arrays.equals(this.f400687j, WireFormatNano.EMPTY_BYTES)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(99, this.f400687j);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        ai aiVar = this.f400678a;
        if (aiVar != null) {
            codedOutputByteBufferNano.writeMessage(1, aiVar);
        }
        at atVar = this.f400679b;
        if (atVar != null) {
            codedOutputByteBufferNano.writeMessage(2, atVar);
        }
        n nVar = this.f400680c;
        if (nVar != null) {
            codedOutputByteBufferNano.writeMessage(3, nVar);
        }
        l lVar = this.f400681d;
        if (lVar != null) {
            codedOutputByteBufferNano.writeMessage(4, lVar);
        }
        g gVar = this.f400682e;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(5, gVar);
        }
        ao aoVar = this.f400683f;
        if (aoVar != null) {
            codedOutputByteBufferNano.writeMessage(6, aoVar);
        }
        x xVar = this.f400684g;
        if (xVar != null) {
            codedOutputByteBufferNano.writeMessage(7, xVar);
        }
        ar arVar = this.f400685h;
        if (arVar != null) {
            codedOutputByteBufferNano.writeMessage(8, arVar);
        }
        p pVar = this.f400686i;
        if (pVar != null) {
            codedOutputByteBufferNano.writeMessage(9, pVar);
        }
        if (!Arrays.equals(this.f400687j, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(99, this.f400687j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
