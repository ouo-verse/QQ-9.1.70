package pq4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: j, reason: collision with root package name */
    private static volatile d[] f427028j;

    /* renamed from: a, reason: collision with root package name */
    public String f427029a;

    /* renamed from: b, reason: collision with root package name */
    public int f427030b;

    /* renamed from: c, reason: collision with root package name */
    public int f427031c;

    /* renamed from: d, reason: collision with root package name */
    public int f427032d;

    /* renamed from: e, reason: collision with root package name */
    public String f427033e;

    /* renamed from: f, reason: collision with root package name */
    public String f427034f;

    /* renamed from: g, reason: collision with root package name */
    public String f427035g;

    /* renamed from: h, reason: collision with root package name */
    public String f427036h;

    /* renamed from: i, reason: collision with root package name */
    public String f427037i;

    public d() {
        a();
    }

    public static d[] b() {
        if (f427028j == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f427028j == null) {
                    f427028j = new d[0];
                }
            }
        }
        return f427028j;
    }

    public d a() {
        this.f427029a = "";
        this.f427030b = 0;
        this.f427031c = 0;
        this.f427032d = 0;
        this.f427033e = "";
        this.f427034f = "";
        this.f427035g = "";
        this.f427036h = "";
        this.f427037i = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 24) {
                            if (readTag != 32) {
                                if (readTag != 42) {
                                    if (readTag != 50) {
                                        if (readTag != 58) {
                                            if (readTag != 66) {
                                                if (readTag != 74) {
                                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                        return this;
                                                    }
                                                } else {
                                                    this.f427037i = codedInputByteBufferNano.readString();
                                                }
                                            } else {
                                                this.f427036h = codedInputByteBufferNano.readString();
                                            }
                                        } else {
                                            this.f427035g = codedInputByteBufferNano.readString();
                                        }
                                    } else {
                                        this.f427034f = codedInputByteBufferNano.readString();
                                    }
                                } else {
                                    this.f427033e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f427032d = codedInputByteBufferNano.readUInt32();
                            }
                        } else {
                            this.f427031c = codedInputByteBufferNano.readUInt32();
                        }
                    } else {
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                            this.f427030b = readInt32;
                        }
                    }
                } else {
                    this.f427029a = codedInputByteBufferNano.readString();
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f427029a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f427029a);
        }
        int i3 = this.f427030b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        int i16 = this.f427031c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        int i17 = this.f427032d;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        if (!this.f427033e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f427033e);
        }
        if (!this.f427034f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f427034f);
        }
        if (!this.f427035g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f427035g);
        }
        if (!this.f427036h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f427036h);
        }
        if (!this.f427037i.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(9, this.f427037i);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f427029a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f427029a);
        }
        int i3 = this.f427030b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        int i16 = this.f427031c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        int i17 = this.f427032d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        if (!this.f427033e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f427033e);
        }
        if (!this.f427034f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f427034f);
        }
        if (!this.f427035g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f427035g);
        }
        if (!this.f427036h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f427036h);
        }
        if (!this.f427037i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f427037i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
