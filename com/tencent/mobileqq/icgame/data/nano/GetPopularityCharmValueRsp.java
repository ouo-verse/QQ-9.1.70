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
public final class GetPopularityCharmValueRsp extends ExtendableMessageNano<GetPopularityCharmValueRsp> {
    private static volatile GetPopularityCharmValueRsp[] _emptyArray;
    public PopularityCharmInfo[] infos;
    public int result;

    public GetPopularityCharmValueRsp() {
        clear();
    }

    public static GetPopularityCharmValueRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetPopularityCharmValueRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetPopularityCharmValueRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetPopularityCharmValueRsp) MessageNano.mergeFrom(new GetPopularityCharmValueRsp(), bArr);
    }

    public GetPopularityCharmValueRsp clear() {
        this.result = 0;
        this.infos = PopularityCharmInfo.emptyArray();
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
        PopularityCharmInfo[] popularityCharmInfoArr = this.infos;
        if (popularityCharmInfoArr != null && popularityCharmInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                PopularityCharmInfo[] popularityCharmInfoArr2 = this.infos;
                if (i16 >= popularityCharmInfoArr2.length) {
                    break;
                }
                PopularityCharmInfo popularityCharmInfo = popularityCharmInfoArr2[i16];
                if (popularityCharmInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, popularityCharmInfo);
                }
                i16++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.result;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        PopularityCharmInfo[] popularityCharmInfoArr = this.infos;
        if (popularityCharmInfoArr != null && popularityCharmInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                PopularityCharmInfo[] popularityCharmInfoArr2 = this.infos;
                if (i16 >= popularityCharmInfoArr2.length) {
                    break;
                }
                PopularityCharmInfo popularityCharmInfo = popularityCharmInfoArr2[i16];
                if (popularityCharmInfo != null) {
                    codedOutputByteBufferNano.writeMessage(2, popularityCharmInfo);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetPopularityCharmValueRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetPopularityCharmValueRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetPopularityCharmValueRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.result = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                PopularityCharmInfo[] popularityCharmInfoArr = this.infos;
                int length = popularityCharmInfoArr == null ? 0 : popularityCharmInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                PopularityCharmInfo[] popularityCharmInfoArr2 = new PopularityCharmInfo[i3];
                if (length != 0) {
                    System.arraycopy(popularityCharmInfoArr, 0, popularityCharmInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    PopularityCharmInfo popularityCharmInfo = new PopularityCharmInfo();
                    popularityCharmInfoArr2[length] = popularityCharmInfo;
                    codedInputByteBufferNano.readMessage(popularityCharmInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                PopularityCharmInfo popularityCharmInfo2 = new PopularityCharmInfo();
                popularityCharmInfoArr2[length] = popularityCharmInfo2;
                codedInputByteBufferNano.readMessage(popularityCharmInfo2);
                this.infos = popularityCharmInfoArr2;
            }
        }
    }
}
