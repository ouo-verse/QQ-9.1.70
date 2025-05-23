package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class AdPlacementInfo extends ExtendableMessageNano<AdPlacementInfo> {
    private static volatile AdPlacementInfo[] _emptyArray;
    public String ctlInfo;
    public String extInfo;
    public AdItem[] lst;
    public int nextQueryTs;
    public int posId;
    public int type;

    public AdPlacementInfo() {
        clear();
    }

    public static AdPlacementInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AdPlacementInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static AdPlacementInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (AdPlacementInfo) MessageNano.mergeFrom(new AdPlacementInfo(), bArr);
    }

    public AdPlacementInfo clear() {
        this.type = 0;
        this.lst = AdItem.emptyArray();
        this.nextQueryTs = 0;
        this.extInfo = "";
        this.ctlInfo = "";
        this.posId = 0;
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
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        AdItem[] adItemArr = this.lst;
        if (adItemArr != null && adItemArr.length > 0) {
            int i16 = 0;
            while (true) {
                AdItem[] adItemArr2 = this.lst;
                if (i16 >= adItemArr2.length) {
                    break;
                }
                AdItem adItem = adItemArr2[i16];
                if (adItem != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, adItem);
                }
                i16++;
            }
        }
        int i17 = this.nextQueryTs;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i17);
        }
        if (!this.extInfo.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.extInfo);
        }
        if (!this.ctlInfo.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.ctlInfo);
        }
        int i18 = this.posId;
        if (i18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(6, i18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.type;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        AdItem[] adItemArr = this.lst;
        if (adItemArr != null && adItemArr.length > 0) {
            int i16 = 0;
            while (true) {
                AdItem[] adItemArr2 = this.lst;
                if (i16 >= adItemArr2.length) {
                    break;
                }
                AdItem adItem = adItemArr2[i16];
                if (adItem != null) {
                    codedOutputByteBufferNano.writeMessage(2, adItem);
                }
                i16++;
            }
        }
        int i17 = this.nextQueryTs;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        if (!this.extInfo.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.extInfo);
        }
        if (!this.ctlInfo.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.ctlInfo);
        }
        int i18 = this.posId;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static AdPlacementInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new AdPlacementInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public AdPlacementInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.type = codedInputByteBufferNano.readInt32();
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                AdItem[] adItemArr = this.lst;
                int length = adItemArr == null ? 0 : adItemArr.length;
                int i3 = repeatedFieldArrayLength + length;
                AdItem[] adItemArr2 = new AdItem[i3];
                if (length != 0) {
                    System.arraycopy(adItemArr, 0, adItemArr2, 0, length);
                }
                while (length < i3 - 1) {
                    AdItem adItem = new AdItem();
                    adItemArr2[length] = adItem;
                    codedInputByteBufferNano.readMessage(adItem);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                AdItem adItem2 = new AdItem();
                adItemArr2[length] = adItem2;
                codedInputByteBufferNano.readMessage(adItem2);
                this.lst = adItemArr2;
            } else if (readTag == 24) {
                this.nextQueryTs = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 34) {
                this.extInfo = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.ctlInfo = codedInputByteBufferNano.readString();
            } else if (readTag != 48) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.posId = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
