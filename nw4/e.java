package nw4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;
import pv4.y;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: g, reason: collision with root package name */
    private static volatile e[] f421468g;

    /* renamed from: a, reason: collision with root package name */
    public long f421469a;

    /* renamed from: b, reason: collision with root package name */
    public int f421470b;

    /* renamed from: c, reason: collision with root package name */
    public int f421471c;

    /* renamed from: d, reason: collision with root package name */
    public String f421472d;

    /* renamed from: e, reason: collision with root package name */
    public String f421473e;

    /* renamed from: f, reason: collision with root package name */
    public y f421474f;

    public e() {
        a();
    }

    public static e[] b() {
        if (f421468g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f421468g == null) {
                    f421468g = new e[0];
                }
            }
        }
        return f421468g;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f421469a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.f421470b = codedInputByteBufferNano.readInt32();
            } else if (readTag == 24) {
                this.f421471c = codedInputByteBufferNano.readInt32();
            } else if (readTag == 34) {
                this.f421472d = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.f421473e = codedInputByteBufferNano.readString();
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f421474f == null) {
                    this.f421474f = new y();
                }
                codedInputByteBufferNano.readMessage(this.f421474f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f421469a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.f421470b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        int i16 = this.f421471c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i16);
        }
        if (!this.f421472d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f421472d);
        }
        if (!this.f421473e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f421473e);
        }
        y yVar = this.f421474f;
        return yVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(6, yVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f421469a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.f421470b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        int i16 = this.f421471c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i16);
        }
        if (!this.f421472d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f421472d);
        }
        if (!this.f421473e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f421473e);
        }
        y yVar = this.f421474f;
        if (yVar != null) {
            codedOutputByteBufferNano.writeMessage(6, yVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public e a() {
        this.f421469a = 0L;
        this.f421470b = 0;
        this.f421471c = 0;
        this.f421472d = "";
        this.f421473e = "";
        this.f421474f = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
