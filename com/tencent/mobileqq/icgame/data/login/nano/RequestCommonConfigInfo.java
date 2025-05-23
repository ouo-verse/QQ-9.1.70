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
public final class RequestCommonConfigInfo extends ExtendableMessageNano<RequestCommonConfigInfo> {
    private static volatile RequestCommonConfigInfo[] _emptyArray;
    public CommonConfigItem[] configItems;
    public String localConfigMd5;
    public long localSettingsTimestamp;
    public long uid;

    public RequestCommonConfigInfo() {
        clear();
    }

    public static RequestCommonConfigInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new RequestCommonConfigInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static RequestCommonConfigInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (RequestCommonConfigInfo) MessageNano.mergeFrom(new RequestCommonConfigInfo(), bArr);
    }

    public RequestCommonConfigInfo clear() {
        this.uid = 0L;
        this.configItems = CommonConfigItem.emptyArray();
        this.localSettingsTimestamp = 0L;
        this.localConfigMd5 = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.uid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        CommonConfigItem[] commonConfigItemArr = this.configItems;
        if (commonConfigItemArr != null && commonConfigItemArr.length > 0) {
            int i3 = 0;
            while (true) {
                CommonConfigItem[] commonConfigItemArr2 = this.configItems;
                if (i3 >= commonConfigItemArr2.length) {
                    break;
                }
                CommonConfigItem commonConfigItem = commonConfigItemArr2[i3];
                if (commonConfigItem != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, commonConfigItem);
                }
                i3++;
            }
        }
        long j16 = this.localSettingsTimestamp;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j16);
        }
        if (!this.localConfigMd5.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.localConfigMd5);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        CommonConfigItem[] commonConfigItemArr = this.configItems;
        if (commonConfigItemArr != null && commonConfigItemArr.length > 0) {
            int i3 = 0;
            while (true) {
                CommonConfigItem[] commonConfigItemArr2 = this.configItems;
                if (i3 >= commonConfigItemArr2.length) {
                    break;
                }
                CommonConfigItem commonConfigItem = commonConfigItemArr2[i3];
                if (commonConfigItem != null) {
                    codedOutputByteBufferNano.writeMessage(2, commonConfigItem);
                }
                i3++;
            }
        }
        long j16 = this.localSettingsTimestamp;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j16);
        }
        if (!this.localConfigMd5.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.localConfigMd5);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static RequestCommonConfigInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new RequestCommonConfigInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public RequestCommonConfigInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                CommonConfigItem[] commonConfigItemArr = this.configItems;
                int length = commonConfigItemArr == null ? 0 : commonConfigItemArr.length;
                int i3 = repeatedFieldArrayLength + length;
                CommonConfigItem[] commonConfigItemArr2 = new CommonConfigItem[i3];
                if (length != 0) {
                    System.arraycopy(commonConfigItemArr, 0, commonConfigItemArr2, 0, length);
                }
                while (length < i3 - 1) {
                    CommonConfigItem commonConfigItem = new CommonConfigItem();
                    commonConfigItemArr2[length] = commonConfigItem;
                    codedInputByteBufferNano.readMessage(commonConfigItem);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                CommonConfigItem commonConfigItem2 = new CommonConfigItem();
                commonConfigItemArr2[length] = commonConfigItem2;
                codedInputByteBufferNano.readMessage(commonConfigItem2);
                this.configItems = commonConfigItemArr2;
            } else if (readTag == 24) {
                this.localSettingsTimestamp = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.localConfigMd5 = codedInputByteBufferNano.readString();
            }
        }
    }
}
