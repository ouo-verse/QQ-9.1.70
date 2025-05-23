package com.tencent.mobileqq.icgame.data.punish.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class CheckAreaRsp extends ExtendableMessageNano<CheckAreaRsp> {
    private static volatile CheckAreaRsp[] _emptyArray;
    public AreaInfo areaInfo;
    public int result;

    public CheckAreaRsp() {
        clear();
    }

    public static CheckAreaRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new CheckAreaRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static CheckAreaRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (CheckAreaRsp) MessageNano.mergeFrom(new CheckAreaRsp(), bArr);
    }

    public CheckAreaRsp clear() {
        this.result = 0;
        this.areaInfo = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.result;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        AreaInfo areaInfo = this.areaInfo;
        if (areaInfo != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, areaInfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.result;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        AreaInfo areaInfo = this.areaInfo;
        if (areaInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, areaInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static CheckAreaRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new CheckAreaRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public CheckAreaRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.result = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.areaInfo == null) {
                    this.areaInfo = new AreaInfo();
                }
                codedInputByteBufferNano.readMessage(this.areaInfo);
            }
        }
    }
}
