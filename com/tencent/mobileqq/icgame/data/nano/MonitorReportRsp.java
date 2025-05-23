package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class MonitorReportRsp extends ExtendableMessageNano<MonitorReportRsp> {
    private static volatile MonitorReportRsp[] _emptyArray;

    public MonitorReportRsp() {
        clear();
    }

    public static MonitorReportRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new MonitorReportRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static MonitorReportRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (MonitorReportRsp) MessageNano.mergeFrom(new MonitorReportRsp(), bArr);
    }

    public MonitorReportRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static MonitorReportRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new MonitorReportRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public MonitorReportRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int readTag;
        do {
            readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            }
        } while (storeUnknownField(codedInputByteBufferNano, readTag));
        return this;
    }
}
