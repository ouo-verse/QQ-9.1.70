package nr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f421191a;

    /* renamed from: b, reason: collision with root package name */
    public int f421192b;

    /* renamed from: c, reason: collision with root package name */
    public g f421193c;

    /* renamed from: d, reason: collision with root package name */
    public int f421194d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f421195e;

    /* renamed from: f, reason: collision with root package name */
    public long f421196f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f421197g;

    /* renamed from: h, reason: collision with root package name */
    public C10866a f421198h;

    /* compiled from: P */
    /* renamed from: nr4.a$a, reason: collision with other inner class name */
    /* loaded from: classes27.dex */
    public static final class C10866a extends ExtendableMessageNano<C10866a> {

        /* renamed from: a, reason: collision with root package name */
        public String f421199a;

        /* renamed from: b, reason: collision with root package name */
        public String f421200b;

        /* renamed from: c, reason: collision with root package name */
        public String f421201c;

        /* renamed from: d, reason: collision with root package name */
        public C10867a f421202d;

        /* compiled from: P */
        /* renamed from: nr4.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes27.dex */
        public static final class C10867a extends ExtendableMessageNano<C10867a> {

            /* renamed from: a, reason: collision with root package name */
            public String f421203a;

            /* renamed from: b, reason: collision with root package name */
            public String f421204b;

            public C10867a() {
                a();
            }

            public C10867a a() {
                this.f421203a = "";
                this.f421204b = "";
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.MessageNano
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public C10867a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag != 0) {
                        if (readTag != 10) {
                            if (readTag != 18) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f421204b = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f421203a = codedInputByteBufferNano.readString();
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
                if (!this.f421203a.equals("")) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f421203a);
                }
                if (!this.f421204b.equals("")) {
                    return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f421204b);
                }
                return computeSerializedSize;
            }

            @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
            public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                if (!this.f421203a.equals("")) {
                    codedOutputByteBufferNano.writeString(1, this.f421203a);
                }
                if (!this.f421204b.equals("")) {
                    codedOutputByteBufferNano.writeString(2, this.f421204b);
                }
                super.writeTo(codedOutputByteBufferNano);
            }
        }

        public C10866a() {
            a();
        }

        public C10866a a() {
            this.f421199a = "";
            this.f421200b = "";
            this.f421201c = "";
            this.f421202d = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C10866a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag != 0) {
                    if (readTag != 10) {
                        if (readTag != 18) {
                            if (readTag != 26) {
                                if (readTag != 34) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    if (this.f421202d == null) {
                                        this.f421202d = new C10867a();
                                    }
                                    codedInputByteBufferNano.readMessage(this.f421202d);
                                }
                            } else {
                                this.f421201c = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f421200b = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f421199a = codedInputByteBufferNano.readString();
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
            if (!this.f421199a.equals("")) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f421199a);
            }
            if (!this.f421200b.equals("")) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f421200b);
            }
            if (!this.f421201c.equals("")) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f421201c);
            }
            C10867a c10867a = this.f421202d;
            if (c10867a != null) {
                return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, c10867a);
            }
            return computeSerializedSize;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if (!this.f421199a.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.f421199a);
            }
            if (!this.f421200b.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.f421200b);
            }
            if (!this.f421201c.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.f421201c);
            }
            C10867a c10867a = this.f421202d;
            if (c10867a != null) {
                codedOutputByteBufferNano.writeMessage(4, c10867a);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public a() {
        a();
    }

    public a a() {
        this.f421191a = false;
        this.f421192b = 0;
        this.f421193c = null;
        this.f421194d = 0;
        this.f421195e = false;
        this.f421196f = 0L;
        this.f421197g = false;
        this.f421198h = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 64) {
                                if (readTag != 72) {
                                    if (readTag != 80) {
                                        if (readTag != 88) {
                                            if (readTag != 98) {
                                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                    return this;
                                                }
                                            } else {
                                                if (this.f421198h == null) {
                                                    this.f421198h = new C10866a();
                                                }
                                                codedInputByteBufferNano.readMessage(this.f421198h);
                                            }
                                        } else {
                                            this.f421197g = codedInputByteBufferNano.readBool();
                                        }
                                    } else {
                                        this.f421196f = codedInputByteBufferNano.readInt64();
                                    }
                                } else {
                                    this.f421195e = codedInputByteBufferNano.readBool();
                                }
                            } else {
                                this.f421194d = codedInputByteBufferNano.readUInt32();
                            }
                        } else {
                            if (this.f421193c == null) {
                                this.f421193c = new g();
                            }
                            codedInputByteBufferNano.readMessage(this.f421193c);
                        }
                    } else {
                        this.f421192b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    this.f421191a = codedInputByteBufferNano.readBool();
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
        boolean z16 = this.f421191a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        int i3 = this.f421192b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        g gVar = this.f421193c;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, gVar);
        }
        int i16 = this.f421194d;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i16);
        }
        boolean z17 = this.f421195e;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(9, z17);
        }
        long j3 = this.f421196f;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(10, j3);
        }
        boolean z18 = this.f421197g;
        if (z18) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(11, z18);
        }
        C10866a c10866a = this.f421198h;
        if (c10866a != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(12, c10866a);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f421191a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        int i3 = this.f421192b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        g gVar = this.f421193c;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(3, gVar);
        }
        int i16 = this.f421194d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i16);
        }
        boolean z17 = this.f421195e;
        if (z17) {
            codedOutputByteBufferNano.writeBool(9, z17);
        }
        long j3 = this.f421196f;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(10, j3);
        }
        boolean z18 = this.f421197g;
        if (z18) {
            codedOutputByteBufferNano.writeBool(11, z18);
        }
        C10866a c10866a = this.f421198h;
        if (c10866a != null) {
            codedOutputByteBufferNano.writeMessage(12, c10866a);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
