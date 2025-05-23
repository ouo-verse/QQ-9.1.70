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
public final class ReportInfoGetReq extends ExtendableMessageNano<ReportInfoGetReq> {
    private static volatile ReportInfoGetReq[] _emptyArray;
    public int flag;
    public int pageNo;
    public int perPageNum;

    public ReportInfoGetReq() {
        clear();
    }

    public static ReportInfoGetReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ReportInfoGetReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ReportInfoGetReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ReportInfoGetReq) MessageNano.mergeFrom(new ReportInfoGetReq(), bArr);
    }

    public ReportInfoGetReq clear() {
        this.perPageNum = 0;
        this.pageNo = 0;
        this.flag = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.perPageNum;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.pageNo;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        int i17 = this.flag;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.perPageNum;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.pageNo;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        int i17 = this.flag;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ReportInfoGetReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ReportInfoGetReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ReportInfoGetReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.perPageNum = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.pageNo = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.flag = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
