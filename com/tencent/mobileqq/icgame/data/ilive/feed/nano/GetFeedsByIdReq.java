package com.tencent.mobileqq.icgame.data.ilive.feed.nano;

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
public final class GetFeedsByIdReq extends ExtendableMessageNano<GetFeedsByIdReq> {
    private static volatile GetFeedsByIdReq[] _emptyArray;
    public byte[][] feedsIds;

    public GetFeedsByIdReq() {
        clear();
    }

    public static GetFeedsByIdReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetFeedsByIdReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetFeedsByIdReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetFeedsByIdReq) MessageNano.mergeFrom(new GetFeedsByIdReq(), bArr);
    }

    public GetFeedsByIdReq clear() {
        this.feedsIds = WireFormatNano.EMPTY_BYTES_ARRAY;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        byte[][] bArr = this.feedsIds;
        if (bArr != null && bArr.length > 0) {
            int i3 = 0;
            int i16 = 0;
            int i17 = 0;
            while (true) {
                byte[][] bArr2 = this.feedsIds;
                if (i3 < bArr2.length) {
                    byte[] bArr3 = bArr2[i3];
                    if (bArr3 != null) {
                        i17++;
                        i16 += CodedOutputByteBufferNano.computeBytesSizeNoTag(bArr3);
                    }
                    i3++;
                } else {
                    return computeSerializedSize + i16 + (i17 * 1);
                }
            }
        } else {
            return computeSerializedSize;
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        byte[][] bArr = this.feedsIds;
        if (bArr != null && bArr.length > 0) {
            int i3 = 0;
            while (true) {
                byte[][] bArr2 = this.feedsIds;
                if (i3 >= bArr2.length) {
                    break;
                }
                byte[] bArr3 = bArr2[i3];
                if (bArr3 != null) {
                    codedOutputByteBufferNano.writeBytes(1, bArr3);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetFeedsByIdReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetFeedsByIdReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetFeedsByIdReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag != 10) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                byte[][] bArr = this.feedsIds;
                int length = bArr == null ? 0 : bArr.length;
                int i3 = repeatedFieldArrayLength + length;
                byte[][] bArr2 = new byte[i3];
                if (length != 0) {
                    System.arraycopy(bArr, 0, bArr2, 0, length);
                }
                while (length < i3 - 1) {
                    bArr2[length] = codedInputByteBufferNano.readBytes();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                bArr2[length] = codedInputByteBufferNano.readBytes();
                this.feedsIds = bArr2;
            }
        }
    }
}
