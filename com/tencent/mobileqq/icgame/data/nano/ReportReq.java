package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class ReportReq extends ExtendableMessageNano<ReportReq> {
    private static volatile ReportReq[] _emptyArray;
    public int clientType;
    public int reportType;
    public String reporteeNick;
    public long reporteeUid;
    public int reporteeUserType;
    public String reporterNick;
    public long reporterUid;
    public long roomId;
    public String text;

    public ReportReq() {
        clear();
    }

    public static ReportReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ReportReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ReportReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ReportReq) MessageNano.mergeFrom(new ReportReq(), bArr);
    }

    public ReportReq clear() {
        this.reporterUid = 0L;
        this.reporterNick = "";
        this.reporteeUid = 0L;
        this.reporteeNick = "";
        this.roomId = 0L;
        this.clientType = 0;
        this.text = "";
        this.reportType = 0;
        this.reporteeUserType = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.reporterUid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.reporterNick.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.reporterNick);
        }
        long j16 = this.reporteeUid;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j16);
        }
        if (!this.reporteeNick.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.reporteeNick);
        }
        long j17 = this.roomId;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j17);
        }
        int i3 = this.clientType;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i3);
        }
        if (!this.text.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.text);
        }
        int i16 = this.reportType;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i16);
        }
        int i17 = this.reporteeUserType;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(9, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.reporterUid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.reporterNick.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.reporterNick);
        }
        long j16 = this.reporteeUid;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j16);
        }
        if (!this.reporteeNick.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.reporteeNick);
        }
        long j17 = this.roomId;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j17);
        }
        int i3 = this.clientType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i3);
        }
        if (!this.text.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.text);
        }
        int i16 = this.reportType;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i16);
        }
        int i17 = this.reporteeUserType;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(9, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ReportReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ReportReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ReportReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.reporterUid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.reporterNick = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                this.reporteeUid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 34) {
                this.reporteeNick = codedInputByteBufferNano.readString();
            } else if (readTag == 40) {
                this.roomId = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 48) {
                this.clientType = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 58) {
                this.text = codedInputByteBufferNano.readString();
            } else if (readTag == 64) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                    this.reportType = readInt32;
                }
            } else if (readTag != 72) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int readInt322 = codedInputByteBufferNano.readInt32();
                if (readInt322 == 0 || readInt322 == 1 || readInt322 == 2 || readInt322 == 3) {
                    this.reporteeUserType = readInt322;
                }
            }
        }
    }
}
