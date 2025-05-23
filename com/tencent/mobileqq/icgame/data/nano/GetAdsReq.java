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
public final class GetAdsReq extends ExtendableMessageNano<GetAdsReq> {
    private static volatile GetAdsReq[] _emptyArray;
    public AdPosItem[] lstPos;
    public CommInfo stComminfo;

    public GetAdsReq() {
        clear();
    }

    public static GetAdsReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetAdsReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetAdsReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetAdsReq) MessageNano.mergeFrom(new GetAdsReq(), bArr);
    }

    public GetAdsReq clear() {
        this.stComminfo = null;
        this.lstPos = AdPosItem.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        CommInfo commInfo = this.stComminfo;
        if (commInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, commInfo);
        }
        AdPosItem[] adPosItemArr = this.lstPos;
        if (adPosItemArr != null && adPosItemArr.length > 0) {
            int i3 = 0;
            while (true) {
                AdPosItem[] adPosItemArr2 = this.lstPos;
                if (i3 >= adPosItemArr2.length) {
                    break;
                }
                AdPosItem adPosItem = adPosItemArr2[i3];
                if (adPosItem != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, adPosItem);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        CommInfo commInfo = this.stComminfo;
        if (commInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, commInfo);
        }
        AdPosItem[] adPosItemArr = this.lstPos;
        if (adPosItemArr != null && adPosItemArr.length > 0) {
            int i3 = 0;
            while (true) {
                AdPosItem[] adPosItemArr2 = this.lstPos;
                if (i3 >= adPosItemArr2.length) {
                    break;
                }
                AdPosItem adPosItem = adPosItemArr2[i3];
                if (adPosItem != null) {
                    codedOutputByteBufferNano.writeMessage(2, adPosItem);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetAdsReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetAdsReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetAdsReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.stComminfo == null) {
                    this.stComminfo = new CommInfo();
                }
                codedInputByteBufferNano.readMessage(this.stComminfo);
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                AdPosItem[] adPosItemArr = this.lstPos;
                int length = adPosItemArr == null ? 0 : adPosItemArr.length;
                int i3 = repeatedFieldArrayLength + length;
                AdPosItem[] adPosItemArr2 = new AdPosItem[i3];
                if (length != 0) {
                    System.arraycopy(adPosItemArr, 0, adPosItemArr2, 0, length);
                }
                while (length < i3 - 1) {
                    AdPosItem adPosItem = new AdPosItem();
                    adPosItemArr2[length] = adPosItem;
                    codedInputByteBufferNano.readMessage(adPosItem);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                AdPosItem adPosItem2 = new AdPosItem();
                adPosItemArr2[length] = adPosItem2;
                codedInputByteBufferNano.readMessage(adPosItem2);
                this.lstPos = adPosItemArr2;
            }
        }
    }
}
