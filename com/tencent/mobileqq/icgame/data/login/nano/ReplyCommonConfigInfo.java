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
public final class ReplyCommonConfigInfo extends ExtendableMessageNano<ReplyCommonConfigInfo> {
    private static volatile ReplyCommonConfigInfo[] _emptyArray;
    public CommonConfigItem[] configItems;
    public ErrorInfo errInfo;
    public long loginControlBit;
    public long uid;

    public ReplyCommonConfigInfo() {
        clear();
    }

    public static ReplyCommonConfigInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ReplyCommonConfigInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ReplyCommonConfigInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ReplyCommonConfigInfo) MessageNano.mergeFrom(new ReplyCommonConfigInfo(), bArr);
    }

    public ReplyCommonConfigInfo clear() {
        this.uid = 0L;
        this.configItems = CommonConfigItem.emptyArray();
        this.errInfo = null;
        this.loginControlBit = 0L;
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
        ErrorInfo errorInfo = this.errInfo;
        if (errorInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, errorInfo);
        }
        long j16 = this.loginControlBit;
        if (j16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, j16);
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
        ErrorInfo errorInfo = this.errInfo;
        if (errorInfo != null) {
            codedOutputByteBufferNano.writeMessage(3, errorInfo);
        }
        long j16 = this.loginControlBit;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ReplyCommonConfigInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ReplyCommonConfigInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ReplyCommonConfigInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
            } else if (readTag == 26) {
                if (this.errInfo == null) {
                    this.errInfo = new ErrorInfo();
                }
                codedInputByteBufferNano.readMessage(this.errInfo);
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.loginControlBit = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
