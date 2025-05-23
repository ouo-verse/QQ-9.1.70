package mp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: k, reason: collision with root package name */
    private static volatile f[] f417152k;

    /* renamed from: a, reason: collision with root package name */
    public int f417153a;

    /* renamed from: b, reason: collision with root package name */
    public String f417154b;

    /* renamed from: c, reason: collision with root package name */
    public int f417155c;

    /* renamed from: d, reason: collision with root package name */
    public String f417156d;

    /* renamed from: e, reason: collision with root package name */
    public float f417157e;

    /* renamed from: f, reason: collision with root package name */
    public b f417158f;

    /* renamed from: g, reason: collision with root package name */
    public b f417159g;

    /* renamed from: h, reason: collision with root package name */
    public c f417160h;

    /* renamed from: i, reason: collision with root package name */
    public int f417161i;

    /* renamed from: j, reason: collision with root package name */
    public int f417162j;

    public f() {
        a();
    }

    public static f[] b() {
        if (f417152k == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f417152k == null) {
                    f417152k = new f[0];
                }
            }
        }
        return f417152k;
    }

    public f a() {
        this.f417153a = 0;
        this.f417154b = "";
        this.f417155c = 0;
        this.f417156d = "";
        this.f417157e = 0.0f;
        this.f417158f = null;
        this.f417159g = null;
        this.f417160h = null;
        this.f417161i = 0;
        this.f417162j = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f417153a = codedInputByteBufferNano.readInt32();
                    break;
                case 18:
                    this.f417154b = codedInputByteBufferNano.readString();
                    break;
                case 24:
                    this.f417155c = codedInputByteBufferNano.readInt32();
                    break;
                case 34:
                    this.f417156d = codedInputByteBufferNano.readString();
                    break;
                case 45:
                    this.f417157e = codedInputByteBufferNano.readFloat();
                    break;
                case 50:
                    if (this.f417158f == null) {
                        this.f417158f = new b();
                    }
                    codedInputByteBufferNano.readMessage(this.f417158f);
                    break;
                case 58:
                    if (this.f417159g == null) {
                        this.f417159g = new b();
                    }
                    codedInputByteBufferNano.readMessage(this.f417159g);
                    break;
                case 66:
                    if (this.f417160h == null) {
                        this.f417160h = new c();
                    }
                    codedInputByteBufferNano.readMessage(this.f417160h);
                    break;
                case 72:
                    this.f417161i = codedInputByteBufferNano.readInt32();
                    break;
                case 80:
                    this.f417162j = codedInputByteBufferNano.readInt32();
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
        int i3 = this.f417153a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.f417154b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f417154b);
        }
        int i16 = this.f417155c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i16);
        }
        if (!this.f417156d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f417156d);
        }
        if (Float.floatToIntBits(this.f417157e) != Float.floatToIntBits(0.0f)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(5, this.f417157e);
        }
        b bVar = this.f417158f;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, bVar);
        }
        b bVar2 = this.f417159g;
        if (bVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, bVar2);
        }
        c cVar = this.f417160h;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, cVar);
        }
        int i17 = this.f417161i;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, i17);
        }
        int i18 = this.f417162j;
        if (i18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(10, i18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f417153a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f417154b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f417154b);
        }
        int i16 = this.f417155c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i16);
        }
        if (!this.f417156d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f417156d);
        }
        if (Float.floatToIntBits(this.f417157e) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(5, this.f417157e);
        }
        b bVar = this.f417158f;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(6, bVar);
        }
        b bVar2 = this.f417159g;
        if (bVar2 != null) {
            codedOutputByteBufferNano.writeMessage(7, bVar2);
        }
        c cVar = this.f417160h;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(8, cVar);
        }
        int i17 = this.f417161i;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(9, i17);
        }
        int i18 = this.f417162j;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(10, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
