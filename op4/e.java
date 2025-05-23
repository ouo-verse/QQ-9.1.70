package op4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public String f423314a;

    /* renamed from: b, reason: collision with root package name */
    public String f423315b;

    /* renamed from: c, reason: collision with root package name */
    public int f423316c;

    /* renamed from: d, reason: collision with root package name */
    public sp4.c f423317d;

    /* renamed from: e, reason: collision with root package name */
    public sp4.c f423318e;

    /* renamed from: f, reason: collision with root package name */
    public String f423319f;

    /* renamed from: g, reason: collision with root package name */
    public String f423320g;

    /* renamed from: h, reason: collision with root package name */
    public c f423321h;

    /* renamed from: i, reason: collision with root package name */
    public int f423322i;

    /* renamed from: j, reason: collision with root package name */
    public i f423323j;

    public e() {
        a();
    }

    public e a() {
        this.f423314a = "";
        this.f423315b = "";
        this.f423316c = 0;
        this.f423317d = null;
        this.f423318e = null;
        this.f423319f = "";
        this.f423320g = "";
        this.f423321h = null;
        this.f423322i = 0;
        this.f423323j = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f423314a = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.f423315b = codedInputByteBufferNano.readString();
                    break;
                case 24:
                    this.f423316c = codedInputByteBufferNano.readUInt32();
                    break;
                case 34:
                    if (this.f423317d == null) {
                        this.f423317d = new sp4.c();
                    }
                    codedInputByteBufferNano.readMessage(this.f423317d);
                    break;
                case 42:
                    if (this.f423318e == null) {
                        this.f423318e = new sp4.c();
                    }
                    codedInputByteBufferNano.readMessage(this.f423318e);
                    break;
                case 50:
                    this.f423319f = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.f423320g = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    if (this.f423321h == null) {
                        this.f423321h = new c();
                    }
                    codedInputByteBufferNano.readMessage(this.f423321h);
                    break;
                case 72:
                    this.f423322i = codedInputByteBufferNano.readUInt32();
                    break;
                case 82:
                    if (this.f423323j == null) {
                        this.f423323j = new i();
                    }
                    codedInputByteBufferNano.readMessage(this.f423323j);
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
        if (!this.f423314a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f423314a);
        }
        if (!this.f423315b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f423315b);
        }
        int i3 = this.f423316c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        sp4.c cVar = this.f423317d;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, cVar);
        }
        sp4.c cVar2 = this.f423318e;
        if (cVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, cVar2);
        }
        if (!this.f423319f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f423319f);
        }
        if (!this.f423320g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f423320g);
        }
        c cVar3 = this.f423321h;
        if (cVar3 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, cVar3);
        }
        int i16 = this.f423322i;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i16);
        }
        i iVar = this.f423323j;
        if (iVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(10, iVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f423314a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f423314a);
        }
        if (!this.f423315b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f423315b);
        }
        int i3 = this.f423316c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        sp4.c cVar = this.f423317d;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(4, cVar);
        }
        sp4.c cVar2 = this.f423318e;
        if (cVar2 != null) {
            codedOutputByteBufferNano.writeMessage(5, cVar2);
        }
        if (!this.f423319f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f423319f);
        }
        if (!this.f423320g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f423320g);
        }
        c cVar3 = this.f423321h;
        if (cVar3 != null) {
            codedOutputByteBufferNano.writeMessage(8, cVar3);
        }
        int i16 = this.f423322i;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i16);
        }
        i iVar = this.f423323j;
        if (iVar != null) {
            codedOutputByteBufferNano.writeMessage(10, iVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
