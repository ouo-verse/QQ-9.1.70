package iu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;
import uv4.az;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: m, reason: collision with root package name */
    private static volatile b[] f408761m;

    /* renamed from: a, reason: collision with root package name */
    public long f408762a;

    /* renamed from: b, reason: collision with root package name */
    public az f408763b;

    /* renamed from: c, reason: collision with root package name */
    public int f408764c;

    /* renamed from: d, reason: collision with root package name */
    public String f408765d;

    /* renamed from: e, reason: collision with root package name */
    public String f408766e;

    /* renamed from: f, reason: collision with root package name */
    public int f408767f;

    /* renamed from: g, reason: collision with root package name */
    public String f408768g;

    /* renamed from: h, reason: collision with root package name */
    public long f408769h;

    /* renamed from: i, reason: collision with root package name */
    public i f408770i;

    /* renamed from: j, reason: collision with root package name */
    public long f408771j;

    /* renamed from: k, reason: collision with root package name */
    public String f408772k;

    /* renamed from: l, reason: collision with root package name */
    public String f408773l;

    public b() {
        a();
    }

    public static b[] b() {
        if (f408761m == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f408761m == null) {
                    f408761m = new b[0];
                }
            }
        }
        return f408761m;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f408762a = codedInputByteBufferNano.readUInt64();
                    break;
                case 18:
                    if (this.f408763b == null) {
                        this.f408763b = new az();
                    }
                    codedInputByteBufferNano.readMessage(this.f408763b);
                    break;
                case 24:
                    this.f408764c = codedInputByteBufferNano.readUInt32();
                    break;
                case 34:
                    this.f408765d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f408766e = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    this.f408767f = codedInputByteBufferNano.readUInt32();
                    break;
                case 58:
                    this.f408768g = codedInputByteBufferNano.readString();
                    break;
                case 64:
                    this.f408769h = codedInputByteBufferNano.readUInt64();
                    break;
                case 74:
                    if (this.f408770i == null) {
                        this.f408770i = new i();
                    }
                    codedInputByteBufferNano.readMessage(this.f408770i);
                    break;
                case 80:
                    this.f408771j = codedInputByteBufferNano.readUInt64();
                    break;
                case 90:
                    this.f408772k = codedInputByteBufferNano.readString();
                    break;
                case 98:
                    this.f408773l = codedInputByteBufferNano.readString();
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
        long j3 = this.f408762a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        az azVar = this.f408763b;
        if (azVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, azVar);
        }
        int i3 = this.f408764c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        if (!this.f408765d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f408765d);
        }
        if (!this.f408766e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f408766e);
        }
        int i16 = this.f408767f;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i16);
        }
        if (!this.f408768g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f408768g);
        }
        long j16 = this.f408769h;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j16);
        }
        i iVar = this.f408770i;
        if (iVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, iVar);
        }
        long j17 = this.f408771j;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(10, j17);
        }
        if (!this.f408772k.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.f408772k);
        }
        return !this.f408773l.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(12, this.f408773l) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f408762a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        az azVar = this.f408763b;
        if (azVar != null) {
            codedOutputByteBufferNano.writeMessage(2, azVar);
        }
        int i3 = this.f408764c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        if (!this.f408765d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f408765d);
        }
        if (!this.f408766e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f408766e);
        }
        int i16 = this.f408767f;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i16);
        }
        if (!this.f408768g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f408768g);
        }
        long j16 = this.f408769h;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j16);
        }
        i iVar = this.f408770i;
        if (iVar != null) {
            codedOutputByteBufferNano.writeMessage(9, iVar);
        }
        long j17 = this.f408771j;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(10, j17);
        }
        if (!this.f408772k.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.f408772k);
        }
        if (!this.f408773l.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.f408773l);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public b a() {
        this.f408762a = 0L;
        this.f408763b = null;
        this.f408764c = 0;
        this.f408765d = "";
        this.f408766e = "";
        this.f408767f = 0;
        this.f408768g = "";
        this.f408769h = 0L;
        this.f408770i = null;
        this.f408771j = 0L;
        this.f408772k = "";
        this.f408773l = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
