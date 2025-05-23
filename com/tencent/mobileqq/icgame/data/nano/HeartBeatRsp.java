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
public final class HeartBeatRsp extends ExtendableMessageNano<HeartBeatRsp> {
    private static volatile HeartBeatRsp[] _emptyArray;
    public ConfItem[] confItems;
    public long interval;

    public HeartBeatRsp() {
        clear();
    }

    public static HeartBeatRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new HeartBeatRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static HeartBeatRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (HeartBeatRsp) MessageNano.mergeFrom(new HeartBeatRsp(), bArr);
    }

    public HeartBeatRsp clear() {
        this.confItems = ConfItem.emptyArray();
        this.interval = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        ConfItem[] confItemArr = this.confItems;
        if (confItemArr != null && confItemArr.length > 0) {
            int i3 = 0;
            while (true) {
                ConfItem[] confItemArr2 = this.confItems;
                if (i3 >= confItemArr2.length) {
                    break;
                }
                ConfItem confItem = confItemArr2[i3];
                if (confItem != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, confItem);
                }
                i3++;
            }
        }
        long j3 = this.interval;
        if (j3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(2, j3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        ConfItem[] confItemArr = this.confItems;
        if (confItemArr != null && confItemArr.length > 0) {
            int i3 = 0;
            while (true) {
                ConfItem[] confItemArr2 = this.confItems;
                if (i3 >= confItemArr2.length) {
                    break;
                }
                ConfItem confItem = confItemArr2[i3];
                if (confItem != null) {
                    codedOutputByteBufferNano.writeMessage(1, confItem);
                }
                i3++;
            }
        }
        long j3 = this.interval;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static HeartBeatRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new HeartBeatRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public HeartBeatRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                ConfItem[] confItemArr = this.confItems;
                int length = confItemArr == null ? 0 : confItemArr.length;
                int i3 = repeatedFieldArrayLength + length;
                ConfItem[] confItemArr2 = new ConfItem[i3];
                if (length != 0) {
                    System.arraycopy(confItemArr, 0, confItemArr2, 0, length);
                }
                while (length < i3 - 1) {
                    ConfItem confItem = new ConfItem();
                    confItemArr2[length] = confItem;
                    codedInputByteBufferNano.readMessage(confItem);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                ConfItem confItem2 = new ConfItem();
                confItemArr2[length] = confItem2;
                codedInputByteBufferNano.readMessage(confItem2);
                this.confItems = confItemArr2;
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.interval = codedInputByteBufferNano.readInt64();
            }
        }
    }
}
