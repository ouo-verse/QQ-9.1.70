package com.tencent.mobileqq.icgame.data.echo.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class ForbidReq extends ExtendableMessageNano<ForbidReq> {
    private static volatile ForbidReq[] _emptyArray;
    public String alertTips;
    public boolean forbidForever;
    public String officialAccReporterTips;
    public String officialAccTips;
    public String reason;
    public long reporterTinyId;
    public int time;
    public long tinyId;
    public int type;
    public long uid;

    public ForbidReq() {
        clear();
    }

    public static ForbidReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ForbidReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ForbidReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ForbidReq) MessageNano.mergeFrom(new ForbidReq(), bArr);
    }

    public ForbidReq clear() {
        this.type = 0;
        this.tinyId = 0L;
        this.reporterTinyId = 0L;
        this.time = 0;
        this.forbidForever = false;
        this.reason = "";
        this.alertTips = "";
        this.officialAccTips = "";
        this.officialAccReporterTips = "";
        this.uid = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.type;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        long j3 = this.tinyId;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        long j16 = this.reporterTinyId;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j16);
        }
        int i16 = this.time;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        boolean z16 = this.forbidForever;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z16);
        }
        if (!this.reason.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.reason);
        }
        if (!this.alertTips.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.alertTips);
        }
        if (!this.officialAccTips.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.officialAccTips);
        }
        if (!this.officialAccReporterTips.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.officialAccReporterTips);
        }
        long j17 = this.uid;
        if (j17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(10, j17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.type;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        long j3 = this.tinyId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        long j16 = this.reporterTinyId;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j16);
        }
        int i16 = this.time;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        boolean z16 = this.forbidForever;
        if (z16) {
            codedOutputByteBufferNano.writeBool(5, z16);
        }
        if (!this.reason.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.reason);
        }
        if (!this.alertTips.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.alertTips);
        }
        if (!this.officialAccTips.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.officialAccTips);
        }
        if (!this.officialAccReporterTips.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.officialAccReporterTips);
        }
        long j17 = this.uid;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(10, j17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ForbidReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ForbidReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ForbidReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.type = codedInputByteBufferNano.readUInt32();
                    break;
                case 16:
                    this.tinyId = codedInputByteBufferNano.readUInt64();
                    break;
                case 24:
                    this.reporterTinyId = codedInputByteBufferNano.readUInt64();
                    break;
                case 32:
                    this.time = codedInputByteBufferNano.readUInt32();
                    break;
                case 40:
                    this.forbidForever = codedInputByteBufferNano.readBool();
                    break;
                case 50:
                    this.reason = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.alertTips = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.officialAccTips = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.officialAccReporterTips = codedInputByteBufferNano.readString();
                    break;
                case 80:
                    this.uid = codedInputByteBufferNano.readUInt64();
                    break;
                default:
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                    break;
            }
        }
    }
}
