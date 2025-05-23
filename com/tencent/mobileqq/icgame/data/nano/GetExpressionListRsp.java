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
public final class GetExpressionListRsp extends ExtendableMessageNano<GetExpressionListRsp> {
    private static volatile GetExpressionListRsp[] _emptyArray;
    public ExpressionInfo[] expressions;
    public int retCode;
    public String retMsg;

    public GetExpressionListRsp() {
        clear();
    }

    public static GetExpressionListRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetExpressionListRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetExpressionListRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetExpressionListRsp) MessageNano.mergeFrom(new GetExpressionListRsp(), bArr);
    }

    public GetExpressionListRsp clear() {
        this.retCode = 0;
        this.retMsg = "";
        this.expressions = ExpressionInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.retCode;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.retMsg.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.retMsg);
        }
        ExpressionInfo[] expressionInfoArr = this.expressions;
        if (expressionInfoArr != null && expressionInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                ExpressionInfo[] expressionInfoArr2 = this.expressions;
                if (i16 >= expressionInfoArr2.length) {
                    break;
                }
                ExpressionInfo expressionInfo = expressionInfoArr2[i16];
                if (expressionInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, expressionInfo);
                }
                i16++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.retCode;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.retMsg.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.retMsg);
        }
        ExpressionInfo[] expressionInfoArr = this.expressions;
        if (expressionInfoArr != null && expressionInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                ExpressionInfo[] expressionInfoArr2 = this.expressions;
                if (i16 >= expressionInfoArr2.length) {
                    break;
                }
                ExpressionInfo expressionInfo = expressionInfoArr2[i16];
                if (expressionInfo != null) {
                    codedOutputByteBufferNano.writeMessage(3, expressionInfo);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetExpressionListRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetExpressionListRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetExpressionListRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.retCode = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.retMsg = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                ExpressionInfo[] expressionInfoArr = this.expressions;
                int length = expressionInfoArr == null ? 0 : expressionInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                ExpressionInfo[] expressionInfoArr2 = new ExpressionInfo[i3];
                if (length != 0) {
                    System.arraycopy(expressionInfoArr, 0, expressionInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    ExpressionInfo expressionInfo = new ExpressionInfo();
                    expressionInfoArr2[length] = expressionInfo;
                    codedInputByteBufferNano.readMessage(expressionInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                ExpressionInfo expressionInfo2 = new ExpressionInfo();
                expressionInfoArr2[length] = expressionInfo2;
                codedInputByteBufferNano.readMessage(expressionInfo2);
                this.expressions = expressionInfoArr2;
            }
        }
    }
}
