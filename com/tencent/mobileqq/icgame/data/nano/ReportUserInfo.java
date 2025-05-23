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
public final class ReportUserInfo extends ExtendableMessageNano<ReportUserInfo> {
    private static volatile ReportUserInfo[] _emptyArray;
    public long reportTime;
    public UserInfo reporter;

    public ReportUserInfo() {
        clear();
    }

    public static ReportUserInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ReportUserInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ReportUserInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ReportUserInfo) MessageNano.mergeFrom(new ReportUserInfo(), bArr);
    }

    public ReportUserInfo clear() {
        this.reporter = null;
        this.reportTime = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        UserInfo userInfo = this.reporter;
        if (userInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, userInfo);
        }
        long j3 = this.reportTime;
        if (j3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        UserInfo userInfo = this.reporter;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, userInfo);
        }
        long j3 = this.reportTime;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ReportUserInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ReportUserInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ReportUserInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.reporter == null) {
                    this.reporter = new UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.reporter);
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.reportTime = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
