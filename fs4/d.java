package fs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public long f400505a;

    /* renamed from: b, reason: collision with root package name */
    public long f400506b;

    /* renamed from: c, reason: collision with root package name */
    public long f400507c;

    /* renamed from: d, reason: collision with root package name */
    public hs4.r f400508d;

    /* renamed from: e, reason: collision with root package name */
    public hs4.t f400509e;

    /* renamed from: f, reason: collision with root package name */
    public hs4.s f400510f;

    /* renamed from: g, reason: collision with root package name */
    public long f400511g;

    /* renamed from: h, reason: collision with root package name */
    public int f400512h;

    /* renamed from: i, reason: collision with root package name */
    public k f400513i;

    public d() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f400505a = codedInputByteBufferNano.readInt64();
            } else if (readTag == 16) {
                this.f400506b = codedInputByteBufferNano.readInt64();
            } else if (readTag == 24) {
                this.f400507c = codedInputByteBufferNano.readInt64();
            } else if (readTag == 34) {
                if (this.f400508d == null) {
                    this.f400508d = new hs4.r();
                }
                codedInputByteBufferNano.readMessage(this.f400508d);
            } else if (readTag == 42) {
                if (this.f400509e == null) {
                    this.f400509e = new hs4.t();
                }
                codedInputByteBufferNano.readMessage(this.f400509e);
            } else if (readTag == 50) {
                if (this.f400510f == null) {
                    this.f400510f = new hs4.s();
                }
                codedInputByteBufferNano.readMessage(this.f400510f);
            } else if (readTag == 56) {
                this.f400511g = codedInputByteBufferNano.readInt64();
            } else if (readTag == 64) {
                this.f400512h = codedInputByteBufferNano.readInt32();
            } else if (readTag != 74) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f400513i == null) {
                    this.f400513i = new k();
                }
                codedInputByteBufferNano.readMessage(this.f400513i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f400505a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j3);
        }
        long j16 = this.f400506b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j16);
        }
        long j17 = this.f400507c;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j17);
        }
        hs4.r rVar = this.f400508d;
        if (rVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, rVar);
        }
        hs4.t tVar = this.f400509e;
        if (tVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, tVar);
        }
        hs4.s sVar = this.f400510f;
        if (sVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, sVar);
        }
        long j18 = this.f400511g;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(7, j18);
        }
        int i3 = this.f400512h;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i3);
        }
        k kVar = this.f400513i;
        return kVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(9, kVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f400505a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(1, j3);
        }
        long j16 = this.f400506b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j16);
        }
        long j17 = this.f400507c;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeInt64(3, j17);
        }
        hs4.r rVar = this.f400508d;
        if (rVar != null) {
            codedOutputByteBufferNano.writeMessage(4, rVar);
        }
        hs4.t tVar = this.f400509e;
        if (tVar != null) {
            codedOutputByteBufferNano.writeMessage(5, tVar);
        }
        hs4.s sVar = this.f400510f;
        if (sVar != null) {
            codedOutputByteBufferNano.writeMessage(6, sVar);
        }
        long j18 = this.f400511g;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeInt64(7, j18);
        }
        int i3 = this.f400512h;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i3);
        }
        k kVar = this.f400513i;
        if (kVar != null) {
            codedOutputByteBufferNano.writeMessage(9, kVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public d a() {
        this.f400505a = 0L;
        this.f400506b = 0L;
        this.f400507c = 0L;
        this.f400508d = null;
        this.f400509e = null;
        this.f400510f = null;
        this.f400511g = 0L;
        this.f400512h = 0;
        this.f400513i = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
