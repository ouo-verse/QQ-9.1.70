package com.tencent.mobileqq.icgame.data.stage.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class DeviceStatusReportRsp extends ExtendableMessageNano<DeviceStatusReportRsp> {
    private static volatile DeviceStatusReportRsp[] _emptyArray;
    public StageInfo stageInfo;

    public DeviceStatusReportRsp() {
        clear();
    }

    public static DeviceStatusReportRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new DeviceStatusReportRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static DeviceStatusReportRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (DeviceStatusReportRsp) MessageNano.mergeFrom(new DeviceStatusReportRsp(), bArr);
    }

    public DeviceStatusReportRsp clear() {
        this.stageInfo = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        StageInfo stageInfo = this.stageInfo;
        if (stageInfo != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, stageInfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        StageInfo stageInfo = this.stageInfo;
        if (stageInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, stageInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static DeviceStatusReportRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new DeviceStatusReportRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public DeviceStatusReportRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag != 10) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.stageInfo == null) {
                    this.stageInfo = new StageInfo();
                }
                codedInputByteBufferNano.readMessage(this.stageInfo);
            }
        }
    }
}
