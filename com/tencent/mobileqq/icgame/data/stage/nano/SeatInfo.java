package com.tencent.mobileqq.icgame.data.stage.nano;

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
public final class SeatInfo extends ExtendableMessageNano<SeatInfo> {
    private static volatile SeatInfo[] _emptyArray;
    public int seatType;
    public SeatUser[] seatUsers;

    public SeatInfo() {
        clear();
    }

    public static SeatInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SeatInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SeatInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SeatInfo) MessageNano.mergeFrom(new SeatInfo(), bArr);
    }

    public SeatInfo clear() {
        this.seatType = 0;
        this.seatUsers = SeatUser.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.seatType;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        SeatUser[] seatUserArr = this.seatUsers;
        if (seatUserArr != null && seatUserArr.length > 0) {
            int i16 = 0;
            while (true) {
                SeatUser[] seatUserArr2 = this.seatUsers;
                if (i16 >= seatUserArr2.length) {
                    break;
                }
                SeatUser seatUser = seatUserArr2[i16];
                if (seatUser != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, seatUser);
                }
                i16++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.seatType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        SeatUser[] seatUserArr = this.seatUsers;
        if (seatUserArr != null && seatUserArr.length > 0) {
            int i16 = 0;
            while (true) {
                SeatUser[] seatUserArr2 = this.seatUsers;
                if (i16 >= seatUserArr2.length) {
                    break;
                }
                SeatUser seatUser = seatUserArr2[i16];
                if (seatUser != null) {
                    codedOutputByteBufferNano.writeMessage(2, seatUser);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SeatInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SeatInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SeatInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.seatType = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                SeatUser[] seatUserArr = this.seatUsers;
                int length = seatUserArr == null ? 0 : seatUserArr.length;
                int i3 = repeatedFieldArrayLength + length;
                SeatUser[] seatUserArr2 = new SeatUser[i3];
                if (length != 0) {
                    System.arraycopy(seatUserArr, 0, seatUserArr2, 0, length);
                }
                while (length < i3 - 1) {
                    SeatUser seatUser = new SeatUser();
                    seatUserArr2[length] = seatUser;
                    codedInputByteBufferNano.readMessage(seatUser);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                SeatUser seatUser2 = new SeatUser();
                seatUserArr2[length] = seatUser2;
                codedInputByteBufferNano.readMessage(seatUser2);
                this.seatUsers = seatUserArr2;
            }
        }
    }
}
