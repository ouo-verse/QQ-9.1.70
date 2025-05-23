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
public final class AdItem extends ExtendableMessageNano<AdItem> {
    private static volatile AdItem[] _emptyArray;
    public String argList;
    public String desc;
    public String extInfo;
    public int iAdId;
    public String iconurl;
    public String jumpurl;
    public String[] lstPic;
    public String title;
    public String traceinfo;

    public AdItem() {
        clear();
    }

    public static AdItem[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AdItem[0];
                }
            }
        }
        return _emptyArray;
    }

    public static AdItem parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (AdItem) MessageNano.mergeFrom(new AdItem(), bArr);
    }

    public AdItem clear() {
        this.iAdId = 0;
        this.traceinfo = "";
        this.title = "";
        this.desc = "";
        this.jumpurl = "";
        this.iconurl = "";
        this.lstPic = WireFormatNano.EMPTY_STRING_ARRAY;
        this.argList = "";
        this.extInfo = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.iAdId;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.traceinfo.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.traceinfo);
        }
        if (!this.title.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.title);
        }
        if (!this.desc.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.desc);
        }
        if (!this.jumpurl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.jumpurl);
        }
        if (!this.iconurl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.iconurl);
        }
        String[] strArr = this.lstPic;
        if (strArr != null && strArr.length > 0) {
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            while (true) {
                String[] strArr2 = this.lstPic;
                if (i16 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i16];
                if (str != null) {
                    i18++;
                    i17 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i16++;
            }
            computeSerializedSize = computeSerializedSize + i17 + (i18 * 1);
        }
        if (!this.argList.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(15, this.argList);
        }
        if (!this.extInfo.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(20, this.extInfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.iAdId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.traceinfo.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.traceinfo);
        }
        if (!this.title.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.title);
        }
        if (!this.desc.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.desc);
        }
        if (!this.jumpurl.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.jumpurl);
        }
        if (!this.iconurl.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.iconurl);
        }
        String[] strArr = this.lstPic;
        if (strArr != null && strArr.length > 0) {
            int i16 = 0;
            while (true) {
                String[] strArr2 = this.lstPic;
                if (i16 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i16];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(14, str);
                }
                i16++;
            }
        }
        if (!this.argList.equals("")) {
            codedOutputByteBufferNano.writeString(15, this.argList);
        }
        if (!this.extInfo.equals("")) {
            codedOutputByteBufferNano.writeString(20, this.extInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static AdItem parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new AdItem().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public AdItem mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.iAdId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 42) {
                this.traceinfo = codedInputByteBufferNano.readString();
            } else if (readTag == 82) {
                this.title = codedInputByteBufferNano.readString();
            } else if (readTag == 90) {
                this.desc = codedInputByteBufferNano.readString();
            } else if (readTag == 98) {
                this.jumpurl = codedInputByteBufferNano.readString();
            } else if (readTag == 106) {
                this.iconurl = codedInputByteBufferNano.readString();
            } else if (readTag == 114) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 114);
                String[] strArr = this.lstPic;
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
                this.lstPic = strArr2;
            } else if (readTag == 122) {
                this.argList = codedInputByteBufferNano.readString();
            } else if (readTag != 162) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.extInfo = codedInputByteBufferNano.readString();
            }
        }
    }
}
