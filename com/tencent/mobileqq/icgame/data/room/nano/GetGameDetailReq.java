package com.tencent.mobileqq.icgame.data.room.nano;

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
public final class GetGameDetailReq extends ExtendableMessageNano<GetGameDetailReq> {
    private static volatile GetGameDetailReq[] _emptyArray;
    public int[] gameId;
    public int roomId;

    public GetGameDetailReq() {
        clear();
    }

    public static GetGameDetailReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetGameDetailReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetGameDetailReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetGameDetailReq) MessageNano.mergeFrom(new GetGameDetailReq(), bArr);
    }

    public GetGameDetailReq clear() {
        this.roomId = 0;
        this.gameId = WireFormatNano.EMPTY_INT_ARRAY;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.roomId);
        int[] iArr = this.gameId;
        if (iArr != null && iArr.length > 0) {
            int i3 = 0;
            int i16 = 0;
            while (true) {
                int[] iArr2 = this.gameId;
                if (i3 < iArr2.length) {
                    i16 += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr2[i3]);
                    i3++;
                } else {
                    return computeSerializedSize + i16 + (iArr2.length * 1);
                }
            }
        } else {
            return computeSerializedSize;
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.roomId);
        int[] iArr = this.gameId;
        if (iArr != null && iArr.length > 0) {
            int i3 = 0;
            while (true) {
                int[] iArr2 = this.gameId;
                if (i3 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(2, iArr2[i3]);
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetGameDetailReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetGameDetailReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetGameDetailReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 16);
                int[] iArr = this.gameId;
                int length = iArr == null ? 0 : iArr.length;
                int i3 = repeatedFieldArrayLength + length;
                int[] iArr2 = new int[i3];
                if (length != 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, length);
                }
                while (length < i3 - 1) {
                    iArr2[length] = codedInputByteBufferNano.readUInt32();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                iArr2[length] = codedInputByteBufferNano.readUInt32();
                this.gameId = iArr2;
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i16 = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readUInt32();
                    i16++;
                }
                codedInputByteBufferNano.rewindToPosition(position);
                int[] iArr3 = this.gameId;
                int length2 = iArr3 == null ? 0 : iArr3.length;
                int i17 = i16 + length2;
                int[] iArr4 = new int[i17];
                if (length2 != 0) {
                    System.arraycopy(iArr3, 0, iArr4, 0, length2);
                }
                while (length2 < i17) {
                    iArr4[length2] = codedInputByteBufferNano.readUInt32();
                    length2++;
                }
                this.gameId = iArr4;
                codedInputByteBufferNano.popLimit(pushLimit);
            }
        }
    }
}
