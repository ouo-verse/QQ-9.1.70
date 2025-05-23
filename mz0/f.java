package mz0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public long f417861a;

    /* renamed from: b, reason: collision with root package name */
    public String f417862b;

    /* renamed from: c, reason: collision with root package name */
    public int f417863c;

    /* renamed from: d, reason: collision with root package name */
    public String f417864d;

    /* renamed from: e, reason: collision with root package name */
    public String f417865e;

    /* renamed from: f, reason: collision with root package name */
    public long f417866f;

    /* renamed from: g, reason: collision with root package name */
    public String f417867g;

    /* renamed from: h, reason: collision with root package name */
    public long f417868h;

    /* renamed from: i, reason: collision with root package name */
    public String f417869i;

    public f() {
        a();
    }

    public f a() {
        this.f417861a = 0L;
        this.f417862b = "";
        this.f417863c = 0;
        this.f417864d = "";
        this.f417865e = "";
        this.f417866f = 0L;
        this.f417867g = "";
        this.f417868h = 0L;
        this.f417869i = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (readTag != 48) {
                                        if (readTag != 58) {
                                            if (readTag != 64) {
                                                if (readTag != 74) {
                                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                        return this;
                                                    }
                                                } else {
                                                    this.f417869i = codedInputByteBufferNano.readString();
                                                }
                                            } else {
                                                this.f417868h = codedInputByteBufferNano.readUInt64();
                                            }
                                        } else {
                                            this.f417867g = codedInputByteBufferNano.readString();
                                        }
                                    } else {
                                        this.f417866f = codedInputByteBufferNano.readUInt64();
                                    }
                                } else {
                                    this.f417865e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f417864d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f417863c = codedInputByteBufferNano.readUInt32();
                        }
                    } else {
                        this.f417862b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f417861a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f417861a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f417862b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f417862b);
        }
        int i3 = this.f417863c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        if (!this.f417864d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f417864d);
        }
        if (!this.f417865e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f417865e);
        }
        long j16 = this.f417866f;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j16);
        }
        if (!this.f417867g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f417867g);
        }
        long j17 = this.f417868h;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j17);
        }
        if (!this.f417869i.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(9, this.f417869i);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f417861a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f417862b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f417862b);
        }
        int i3 = this.f417863c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        if (!this.f417864d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f417864d);
        }
        if (!this.f417865e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f417865e);
        }
        long j16 = this.f417866f;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j16);
        }
        if (!this.f417867g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f417867g);
        }
        long j17 = this.f417868h;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j17);
        }
        if (!this.f417869i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f417869i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
