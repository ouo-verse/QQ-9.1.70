package com.tencent.mobileqq.icgame.data.av.nano;

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
public final class QueryH5UrlRsp extends ExtendableMessageNano<QueryH5UrlRsp> {
    private static volatile QueryH5UrlRsp[] _emptyArray;
    public String[] flvUrl;
    public String[] hlsUrl;
    public int result;
    public String[] rtmpUrl;

    public QueryH5UrlRsp() {
        clear();
    }

    public static QueryH5UrlRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new QueryH5UrlRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static QueryH5UrlRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (QueryH5UrlRsp) MessageNano.mergeFrom(new QueryH5UrlRsp(), bArr);
    }

    public QueryH5UrlRsp clear() {
        this.result = 0;
        String[] strArr = WireFormatNano.EMPTY_STRING_ARRAY;
        this.rtmpUrl = strArr;
        this.hlsUrl = strArr;
        this.flvUrl = strArr;
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
        String[] strArr = this.rtmpUrl;
        int i16 = 0;
        if (strArr != null && strArr.length > 0) {
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            while (true) {
                String[] strArr2 = this.rtmpUrl;
                if (i17 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i17];
                if (str != null) {
                    i19++;
                    i18 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i17++;
            }
            computeSerializedSize = computeSerializedSize + i18 + (i19 * 1);
        }
        String[] strArr3 = this.hlsUrl;
        if (strArr3 != null && strArr3.length > 0) {
            int i26 = 0;
            int i27 = 0;
            int i28 = 0;
            while (true) {
                String[] strArr4 = this.hlsUrl;
                if (i26 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i26];
                if (str2 != null) {
                    i28++;
                    i27 += CodedOutputByteBufferNano.computeStringSizeNoTag(str2);
                }
                i26++;
            }
            computeSerializedSize = computeSerializedSize + i27 + (i28 * 1);
        }
        String[] strArr5 = this.flvUrl;
        if (strArr5 != null && strArr5.length > 0) {
            int i29 = 0;
            int i36 = 0;
            while (true) {
                String[] strArr6 = this.flvUrl;
                if (i16 < strArr6.length) {
                    String str3 = strArr6[i16];
                    if (str3 != null) {
                        i36++;
                        i29 += CodedOutputByteBufferNano.computeStringSizeNoTag(str3);
                    }
                    i16++;
                } else {
                    return computeSerializedSize + i29 + (i36 * 1);
                }
            }
        } else {
            return computeSerializedSize;
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.result;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        String[] strArr = this.rtmpUrl;
        int i16 = 0;
        if (strArr != null && strArr.length > 0) {
            int i17 = 0;
            while (true) {
                String[] strArr2 = this.rtmpUrl;
                if (i17 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i17];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(2, str);
                }
                i17++;
            }
        }
        String[] strArr3 = this.hlsUrl;
        if (strArr3 != null && strArr3.length > 0) {
            int i18 = 0;
            while (true) {
                String[] strArr4 = this.hlsUrl;
                if (i18 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i18];
                if (str2 != null) {
                    codedOutputByteBufferNano.writeString(3, str2);
                }
                i18++;
            }
        }
        String[] strArr5 = this.flvUrl;
        if (strArr5 != null && strArr5.length > 0) {
            while (true) {
                String[] strArr6 = this.flvUrl;
                if (i16 >= strArr6.length) {
                    break;
                }
                String str3 = strArr6[i16];
                if (str3 != null) {
                    codedOutputByteBufferNano.writeString(4, str3);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static QueryH5UrlRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new QueryH5UrlRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public QueryH5UrlRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.result = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                String[] strArr = this.rtmpUrl;
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
                this.rtmpUrl = strArr2;
            } else if (readTag == 26) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                String[] strArr3 = this.hlsUrl;
                int length2 = strArr3 == null ? 0 : strArr3.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                String[] strArr4 = new String[i16];
                if (length2 != 0) {
                    System.arraycopy(strArr3, 0, strArr4, 0, length2);
                }
                while (length2 < i16 - 1) {
                    strArr4[length2] = codedInputByteBufferNano.readString();
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                strArr4[length2] = codedInputByteBufferNano.readString();
                this.hlsUrl = strArr4;
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                String[] strArr5 = this.flvUrl;
                int length3 = strArr5 == null ? 0 : strArr5.length;
                int i17 = repeatedFieldArrayLength3 + length3;
                String[] strArr6 = new String[i17];
                if (length3 != 0) {
                    System.arraycopy(strArr5, 0, strArr6, 0, length3);
                }
                while (length3 < i17 - 1) {
                    strArr6[length3] = codedInputByteBufferNano.readString();
                    codedInputByteBufferNano.readTag();
                    length3++;
                }
                strArr6[length3] = codedInputByteBufferNano.readString();
                this.flvUrl = strArr6;
            }
        }
    }
}
