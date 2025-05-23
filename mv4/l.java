package mv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class l extends ExtendableMessageNano<l> {

    /* renamed from: a, reason: collision with root package name */
    public j f417685a;

    /* renamed from: b, reason: collision with root package name */
    public h f417686b;

    /* renamed from: c, reason: collision with root package name */
    public i f417687c;

    /* renamed from: d, reason: collision with root package name */
    public o f417688d;

    /* renamed from: e, reason: collision with root package name */
    public a f417689e;

    /* renamed from: f, reason: collision with root package name */
    public n f417690f;

    /* renamed from: g, reason: collision with root package name */
    public f f417691g;

    /* renamed from: h, reason: collision with root package name */
    public d f417692h;

    /* renamed from: i, reason: collision with root package name */
    public b f417693i;

    /* renamed from: j, reason: collision with root package name */
    public k f417694j;

    /* renamed from: k, reason: collision with root package name */
    public g f417695k;

    /* renamed from: l, reason: collision with root package name */
    public c f417696l;

    public l() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public l mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    if (this.f417685a == null) {
                        this.f417685a = new j();
                    }
                    codedInputByteBufferNano.readMessage(this.f417685a);
                    break;
                case 18:
                    if (this.f417686b == null) {
                        this.f417686b = new h();
                    }
                    codedInputByteBufferNano.readMessage(this.f417686b);
                    break;
                case 26:
                    if (this.f417687c == null) {
                        this.f417687c = new i();
                    }
                    codedInputByteBufferNano.readMessage(this.f417687c);
                    break;
                case 34:
                    if (this.f417688d == null) {
                        this.f417688d = new o();
                    }
                    codedInputByteBufferNano.readMessage(this.f417688d);
                    break;
                case 42:
                    if (this.f417689e == null) {
                        this.f417689e = new a();
                    }
                    codedInputByteBufferNano.readMessage(this.f417689e);
                    break;
                case 50:
                    if (this.f417690f == null) {
                        this.f417690f = new n();
                    }
                    codedInputByteBufferNano.readMessage(this.f417690f);
                    break;
                case 58:
                    if (this.f417691g == null) {
                        this.f417691g = new f();
                    }
                    codedInputByteBufferNano.readMessage(this.f417691g);
                    break;
                case 66:
                    if (this.f417692h == null) {
                        this.f417692h = new d();
                    }
                    codedInputByteBufferNano.readMessage(this.f417692h);
                    break;
                case 74:
                    if (this.f417693i == null) {
                        this.f417693i = new b();
                    }
                    codedInputByteBufferNano.readMessage(this.f417693i);
                    break;
                case 82:
                    if (this.f417694j == null) {
                        this.f417694j = new k();
                    }
                    codedInputByteBufferNano.readMessage(this.f417694j);
                    break;
                case 90:
                    if (this.f417695k == null) {
                        this.f417695k = new g();
                    }
                    codedInputByteBufferNano.readMessage(this.f417695k);
                    break;
                case 98:
                    if (this.f417696l == null) {
                        this.f417696l = new c();
                    }
                    codedInputByteBufferNano.readMessage(this.f417696l);
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
        j jVar = this.f417685a;
        if (jVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, jVar);
        }
        h hVar = this.f417686b;
        if (hVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, hVar);
        }
        i iVar = this.f417687c;
        if (iVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, iVar);
        }
        o oVar = this.f417688d;
        if (oVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, oVar);
        }
        a aVar = this.f417689e;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, aVar);
        }
        n nVar = this.f417690f;
        if (nVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, nVar);
        }
        f fVar = this.f417691g;
        if (fVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, fVar);
        }
        d dVar = this.f417692h;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, dVar);
        }
        b bVar = this.f417693i;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, bVar);
        }
        k kVar = this.f417694j;
        if (kVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, kVar);
        }
        g gVar = this.f417695k;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, gVar);
        }
        c cVar = this.f417696l;
        return cVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(12, cVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        j jVar = this.f417685a;
        if (jVar != null) {
            codedOutputByteBufferNano.writeMessage(1, jVar);
        }
        h hVar = this.f417686b;
        if (hVar != null) {
            codedOutputByteBufferNano.writeMessage(2, hVar);
        }
        i iVar = this.f417687c;
        if (iVar != null) {
            codedOutputByteBufferNano.writeMessage(3, iVar);
        }
        o oVar = this.f417688d;
        if (oVar != null) {
            codedOutputByteBufferNano.writeMessage(4, oVar);
        }
        a aVar = this.f417689e;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(5, aVar);
        }
        n nVar = this.f417690f;
        if (nVar != null) {
            codedOutputByteBufferNano.writeMessage(6, nVar);
        }
        f fVar = this.f417691g;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(7, fVar);
        }
        d dVar = this.f417692h;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(8, dVar);
        }
        b bVar = this.f417693i;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(9, bVar);
        }
        k kVar = this.f417694j;
        if (kVar != null) {
            codedOutputByteBufferNano.writeMessage(10, kVar);
        }
        g gVar = this.f417695k;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(11, gVar);
        }
        c cVar = this.f417696l;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(12, cVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public l a() {
        this.f417685a = null;
        this.f417686b = null;
        this.f417687c = null;
        this.f417688d = null;
        this.f417689e = null;
        this.f417690f = null;
        this.f417691g = null;
        this.f417692h = null;
        this.f417693i = null;
        this.f417694j = null;
        this.f417695k = null;
        this.f417696l = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
