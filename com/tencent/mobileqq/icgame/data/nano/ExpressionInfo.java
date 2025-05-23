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
public final class ExpressionInfo extends ExtendableMessageNano<ExpressionInfo> {
    private static volatile ExpressionInfo[] _emptyArray;
    public String displayUrl;
    public String effectUrl;
    public int expressionId;
    public String expressionName;
    public int expressionType;
    public String[] resultUrls;

    public ExpressionInfo() {
        clear();
    }

    public static ExpressionInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ExpressionInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ExpressionInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ExpressionInfo) MessageNano.mergeFrom(new ExpressionInfo(), bArr);
    }

    public ExpressionInfo clear() {
        this.expressionType = 0;
        this.expressionId = 0;
        this.expressionName = "";
        this.displayUrl = "";
        this.effectUrl = "";
        this.resultUrls = WireFormatNano.EMPTY_STRING_ARRAY;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.expressionType;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.expressionId;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        if (!this.expressionName.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.expressionName);
        }
        if (!this.displayUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.displayUrl);
        }
        if (!this.effectUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.effectUrl);
        }
        String[] strArr = this.resultUrls;
        if (strArr != null && strArr.length > 0) {
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            while (true) {
                String[] strArr2 = this.resultUrls;
                if (i17 < strArr2.length) {
                    String str = strArr2[i17];
                    if (str != null) {
                        i19++;
                        i18 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                    }
                    i17++;
                } else {
                    return computeSerializedSize + i18 + (i19 * 1);
                }
            }
        } else {
            return computeSerializedSize;
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.expressionType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.expressionId;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        if (!this.expressionName.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.expressionName);
        }
        if (!this.displayUrl.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.displayUrl);
        }
        if (!this.effectUrl.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.effectUrl);
        }
        String[] strArr = this.resultUrls;
        if (strArr != null && strArr.length > 0) {
            int i17 = 0;
            while (true) {
                String[] strArr2 = this.resultUrls;
                if (i17 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i17];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(6, str);
                }
                i17++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ExpressionInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ExpressionInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ExpressionInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.expressionType = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.expressionId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 26) {
                this.expressionName = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.displayUrl = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.effectUrl = codedInputByteBufferNano.readString();
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                String[] strArr = this.resultUrls;
                int length = strArr == null ? 0 : strArr.length;
                int i3 = repeatedFieldArrayLength + length;
                String[] strArr2 = new String[i3];
                if (length != 0) {
                    System.arraycopy(strArr, 0, strArr2, 0, length);
                }
                while (length < i3 - 1) {
                    strArr2[length] = codedInputByteBufferNano.readString();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                strArr2[length] = codedInputByteBufferNano.readString();
                this.resultUrls = strArr2;
            }
        }
    }
}
