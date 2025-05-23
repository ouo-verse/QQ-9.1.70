package com.tencent.mobileqq.icgame.data.mgr.nano;

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
public final class FmRoomList extends ExtendableMessageNano<FmRoomList> {
    private static volatile FmRoomList[] _emptyArray;
    public LoveRoom[] loveFmRoomList;

    public FmRoomList() {
        clear();
    }

    public static FmRoomList[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new FmRoomList[0];
                }
            }
        }
        return _emptyArray;
    }

    public static FmRoomList parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (FmRoomList) MessageNano.mergeFrom(new FmRoomList(), bArr);
    }

    public FmRoomList clear() {
        this.loveFmRoomList = LoveRoom.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        LoveRoom[] loveRoomArr = this.loveFmRoomList;
        if (loveRoomArr != null && loveRoomArr.length > 0) {
            int i3 = 0;
            while (true) {
                LoveRoom[] loveRoomArr2 = this.loveFmRoomList;
                if (i3 >= loveRoomArr2.length) {
                    break;
                }
                LoveRoom loveRoom = loveRoomArr2[i3];
                if (loveRoom != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, loveRoom);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        LoveRoom[] loveRoomArr = this.loveFmRoomList;
        if (loveRoomArr != null && loveRoomArr.length > 0) {
            int i3 = 0;
            while (true) {
                LoveRoom[] loveRoomArr2 = this.loveFmRoomList;
                if (i3 >= loveRoomArr2.length) {
                    break;
                }
                LoveRoom loveRoom = loveRoomArr2[i3];
                if (loveRoom != null) {
                    codedOutputByteBufferNano.writeMessage(1, loveRoom);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static FmRoomList parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new FmRoomList().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public FmRoomList mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                LoveRoom[] loveRoomArr = this.loveFmRoomList;
                int length = loveRoomArr == null ? 0 : loveRoomArr.length;
                int i3 = repeatedFieldArrayLength + length;
                LoveRoom[] loveRoomArr2 = new LoveRoom[i3];
                if (length != 0) {
                    System.arraycopy(loveRoomArr, 0, loveRoomArr2, 0, length);
                }
                while (length < i3 - 1) {
                    LoveRoom loveRoom = new LoveRoom();
                    loveRoomArr2[length] = loveRoom;
                    codedInputByteBufferNano.readMessage(loveRoom);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                LoveRoom loveRoom2 = new LoveRoom();
                loveRoomArr2[length] = loveRoom2;
                codedInputByteBufferNano.readMessage(loveRoom2);
                this.loveFmRoomList = loveRoomArr2;
            }
        }
    }
}
