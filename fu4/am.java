package fu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class am extends ExtendableMessageNano<am> {

    /* renamed from: a, reason: collision with root package name */
    public int f400708a;

    /* renamed from: b, reason: collision with root package name */
    public int f400709b;

    /* renamed from: c, reason: collision with root package name */
    public int f400710c;

    /* renamed from: d, reason: collision with root package name */
    public int f400711d;

    /* renamed from: e, reason: collision with root package name */
    public b f400712e;

    /* renamed from: f, reason: collision with root package name */
    public u f400713f;

    /* renamed from: g, reason: collision with root package name */
    public c f400714g;

    /* renamed from: h, reason: collision with root package name */
    public i f400715h;

    /* renamed from: i, reason: collision with root package name */
    public byte[] f400716i;

    public am() {
        a();
    }

    public am a() {
        this.f400708a = 0;
        this.f400709b = 0;
        this.f400710c = 0;
        this.f400711d = 0;
        this.f400712e = null;
        this.f400713f = null;
        this.f400714g = null;
        this.f400715h = null;
        this.f400716i = WireFormatNano.EMPTY_BYTES;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public am mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 808) {
                    if (readTag != 816) {
                        if (readTag != 824) {
                            if (readTag != 1600) {
                                if (readTag != 1610) {
                                    if (readTag != 1618) {
                                        if (readTag != 1626) {
                                            if (readTag != 1634) {
                                                if (readTag != 1642) {
                                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                        return this;
                                                    }
                                                } else {
                                                    this.f400716i = codedInputByteBufferNano.readBytes();
                                                }
                                            } else {
                                                if (this.f400715h == null) {
                                                    this.f400715h = new i();
                                                }
                                                codedInputByteBufferNano.readMessage(this.f400715h);
                                            }
                                        } else {
                                            if (this.f400714g == null) {
                                                this.f400714g = new c();
                                            }
                                            codedInputByteBufferNano.readMessage(this.f400714g);
                                        }
                                    } else {
                                        if (this.f400713f == null) {
                                            this.f400713f = new u();
                                        }
                                        codedInputByteBufferNano.readMessage(this.f400713f);
                                    }
                                } else {
                                    if (this.f400712e == null) {
                                        this.f400712e = new b();
                                    }
                                    codedInputByteBufferNano.readMessage(this.f400712e);
                                }
                            } else {
                                int readInt32 = codedInputByteBufferNano.readInt32();
                                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3 || readInt32 == 4 || readInt32 == 5) {
                                    this.f400711d = readInt32;
                                }
                            }
                        } else {
                            int readInt322 = codedInputByteBufferNano.readInt32();
                            switch (readInt322) {
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                    this.f400710c = readInt322;
                                    break;
                            }
                        }
                    } else {
                        int readInt323 = codedInputByteBufferNano.readInt32();
                        if (readInt323 == 0 || readInt323 == 1 || readInt323 == 2 || readInt323 == 3 || readInt323 == 4) {
                            this.f400709b = readInt323;
                        }
                    }
                } else {
                    int readInt324 = codedInputByteBufferNano.readInt32();
                    if (readInt324 == 0 || readInt324 == 1 || readInt324 == 2) {
                        this.f400708a = readInt324;
                    }
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
        int i3 = this.f400708a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(101, i3);
        }
        int i16 = this.f400709b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(102, i16);
        }
        int i17 = this.f400710c;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(103, i17);
        }
        int i18 = this.f400711d;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(200, i18);
        }
        b bVar = this.f400712e;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(201, bVar);
        }
        u uVar = this.f400713f;
        if (uVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(202, uVar);
        }
        c cVar = this.f400714g;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(203, cVar);
        }
        i iVar = this.f400715h;
        if (iVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(204, iVar);
        }
        if (!Arrays.equals(this.f400716i, WireFormatNano.EMPTY_BYTES)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(205, this.f400716i);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f400708a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(101, i3);
        }
        int i16 = this.f400709b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(102, i16);
        }
        int i17 = this.f400710c;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(103, i17);
        }
        int i18 = this.f400711d;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(200, i18);
        }
        b bVar = this.f400712e;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(201, bVar);
        }
        u uVar = this.f400713f;
        if (uVar != null) {
            codedOutputByteBufferNano.writeMessage(202, uVar);
        }
        c cVar = this.f400714g;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(203, cVar);
        }
        i iVar = this.f400715h;
        if (iVar != null) {
            codedOutputByteBufferNano.writeMessage(204, iVar);
        }
        if (!Arrays.equals(this.f400716i, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(205, this.f400716i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
