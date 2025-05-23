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
public final class GetAdsRsp extends ExtendableMessageNano<GetAdsRsp> {
    private static volatile GetAdsRsp[] _emptyArray;
    public AdPlacementInfo[] ads;
    public int code;
    public String errmsg;
    public String rspExtInfo;

    public GetAdsRsp() {
        clear();
    }

    public static GetAdsRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetAdsRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetAdsRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetAdsRsp) MessageNano.mergeFrom(new GetAdsRsp(), bArr);
    }

    public GetAdsRsp clear() {
        this.code = 0;
        this.errmsg = "";
        this.ads = AdPlacementInfo.emptyArray();
        this.rspExtInfo = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.code;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.errmsg.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.errmsg);
        }
        AdPlacementInfo[] adPlacementInfoArr = this.ads;
        if (adPlacementInfoArr != null && adPlacementInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                AdPlacementInfo[] adPlacementInfoArr2 = this.ads;
                if (i16 >= adPlacementInfoArr2.length) {
                    break;
                }
                AdPlacementInfo adPlacementInfo = adPlacementInfoArr2[i16];
                if (adPlacementInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, adPlacementInfo);
                }
                i16++;
            }
        }
        if (!this.rspExtInfo.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.rspExtInfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.code;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.errmsg.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.errmsg);
        }
        AdPlacementInfo[] adPlacementInfoArr = this.ads;
        if (adPlacementInfoArr != null && adPlacementInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                AdPlacementInfo[] adPlacementInfoArr2 = this.ads;
                if (i16 >= adPlacementInfoArr2.length) {
                    break;
                }
                AdPlacementInfo adPlacementInfo = adPlacementInfoArr2[i16];
                if (adPlacementInfo != null) {
                    codedOutputByteBufferNano.writeMessage(3, adPlacementInfo);
                }
                i16++;
            }
        }
        if (!this.rspExtInfo.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.rspExtInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetAdsRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetAdsRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetAdsRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.code = codedInputByteBufferNano.readInt32();
            } else if (readTag == 18) {
                this.errmsg = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                AdPlacementInfo[] adPlacementInfoArr = this.ads;
                int length = adPlacementInfoArr == null ? 0 : adPlacementInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                AdPlacementInfo[] adPlacementInfoArr2 = new AdPlacementInfo[i3];
                if (length != 0) {
                    System.arraycopy(adPlacementInfoArr, 0, adPlacementInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    AdPlacementInfo adPlacementInfo = new AdPlacementInfo();
                    adPlacementInfoArr2[length] = adPlacementInfo;
                    codedInputByteBufferNano.readMessage(adPlacementInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                AdPlacementInfo adPlacementInfo2 = new AdPlacementInfo();
                adPlacementInfoArr2[length] = adPlacementInfo2;
                codedInputByteBufferNano.readMessage(adPlacementInfo2);
                this.ads = adPlacementInfoArr2;
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.rspExtInfo = codedInputByteBufferNano.readString();
            }
        }
    }
}
