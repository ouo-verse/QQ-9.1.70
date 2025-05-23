package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class MonitorReportReq extends ExtendableMessageNano<MonitorReportReq> {
    private static volatile MonitorReportReq[] _emptyArray;
    public MonitorItem[] item;

    public MonitorReportReq() {
        clear();
    }

    public static MonitorReportReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new MonitorReportReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static MonitorReportReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (MonitorReportReq) MessageNano.mergeFrom(new MonitorReportReq(), bArr);
    }

    public MonitorReportReq clear() {
        this.item = MonitorItem.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        MonitorItem[] monitorItemArr = this.item;
        if (monitorItemArr != null && monitorItemArr.length > 0) {
            int i3 = 0;
            while (true) {
                MonitorItem[] monitorItemArr2 = this.item;
                if (i3 >= monitorItemArr2.length) {
                    break;
                }
                MonitorItem monitorItem = monitorItemArr2[i3];
                if (monitorItem != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, monitorItem);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        MonitorItem[] monitorItemArr = this.item;
        if (monitorItemArr != null && monitorItemArr.length > 0) {
            int i3 = 0;
            while (true) {
                MonitorItem[] monitorItemArr2 = this.item;
                if (i3 >= monitorItemArr2.length) {
                    break;
                }
                MonitorItem monitorItem = monitorItemArr2[i3];
                if (monitorItem != null) {
                    codedOutputByteBufferNano.writeMessage(1, monitorItem);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static MonitorReportReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new MonitorReportReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public MonitorReportReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                MonitorItem[] monitorItemArr = this.item;
                int length = monitorItemArr == null ? 0 : monitorItemArr.length;
                int i3 = repeatedFieldArrayLength + length;
                MonitorItem[] monitorItemArr2 = new MonitorItem[i3];
                if (length != 0) {
                    System.arraycopy(monitorItemArr, 0, monitorItemArr2, 0, length);
                }
                while (length < i3 - 1) {
                    MonitorItem monitorItem = new MonitorItem();
                    monitorItemArr2[length] = monitorItem;
                    codedInputByteBufferNano.readMessage(monitorItem);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                MonitorItem monitorItem2 = new MonitorItem();
                monitorItemArr2[length] = monitorItem2;
                codedInputByteBufferNano.readMessage(monitorItem2);
                this.item = monitorItemArr2;
            }
        }
    }
}
