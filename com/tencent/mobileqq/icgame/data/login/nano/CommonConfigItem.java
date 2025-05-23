package com.tencent.mobileqq.icgame.data.login.nano;

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
public final class CommonConfigItem extends ExtendableMessageNano<CommonConfigItem> {
    private static volatile CommonConfigItem[] _emptyArray;
    public String configMd5;
    public long currentSettingsTimestamp;
    public int onOff;
    public PairMessage[] parameterList;
    public int type;

    public CommonConfigItem() {
        clear();
    }

    public static CommonConfigItem[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new CommonConfigItem[0];
                }
            }
        }
        return _emptyArray;
    }

    public static CommonConfigItem parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (CommonConfigItem) MessageNano.mergeFrom(new CommonConfigItem(), bArr);
    }

    public CommonConfigItem clear() {
        this.type = 0;
        this.parameterList = PairMessage.emptyArray();
        this.onOff = 0;
        this.currentSettingsTimestamp = 0L;
        this.configMd5 = "";
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
        PairMessage[] pairMessageArr = this.parameterList;
        if (pairMessageArr != null && pairMessageArr.length > 0) {
            int i16 = 0;
            while (true) {
                PairMessage[] pairMessageArr2 = this.parameterList;
                if (i16 >= pairMessageArr2.length) {
                    break;
                }
                PairMessage pairMessage = pairMessageArr2[i16];
                if (pairMessage != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, pairMessage);
                }
                i16++;
            }
        }
        int i17 = this.onOff;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i17);
        }
        long j3 = this.currentSettingsTimestamp;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j3);
        }
        if (!this.configMd5.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.configMd5);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.type;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        PairMessage[] pairMessageArr = this.parameterList;
        if (pairMessageArr != null && pairMessageArr.length > 0) {
            int i16 = 0;
            while (true) {
                PairMessage[] pairMessageArr2 = this.parameterList;
                if (i16 >= pairMessageArr2.length) {
                    break;
                }
                PairMessage pairMessage = pairMessageArr2[i16];
                if (pairMessage != null) {
                    codedOutputByteBufferNano.writeMessage(2, pairMessage);
                }
                i16++;
            }
        }
        int i17 = this.onOff;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        long j3 = this.currentSettingsTimestamp;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j3);
        }
        if (!this.configMd5.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.configMd5);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static CommonConfigItem parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new CommonConfigItem().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public CommonConfigItem mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.type = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                PairMessage[] pairMessageArr = this.parameterList;
                int length = pairMessageArr == null ? 0 : pairMessageArr.length;
                int i3 = repeatedFieldArrayLength + length;
                PairMessage[] pairMessageArr2 = new PairMessage[i3];
                if (length != 0) {
                    System.arraycopy(pairMessageArr, 0, pairMessageArr2, 0, length);
                }
                while (length < i3 - 1) {
                    PairMessage pairMessage = new PairMessage();
                    pairMessageArr2[length] = pairMessage;
                    codedInputByteBufferNano.readMessage(pairMessage);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                PairMessage pairMessage2 = new PairMessage();
                pairMessageArr2[length] = pairMessage2;
                codedInputByteBufferNano.readMessage(pairMessage2);
                this.parameterList = pairMessageArr2;
            } else if (readTag == 24) {
                this.onOff = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.currentSettingsTimestamp = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.configMd5 = codedInputByteBufferNano.readString();
            }
        }
    }
}
