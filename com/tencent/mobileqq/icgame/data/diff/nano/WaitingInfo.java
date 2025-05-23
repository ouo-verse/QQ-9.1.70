package com.tencent.mobileqq.icgame.data.diff.nano;

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
public final class WaitingInfo extends ExtendableMessageNano<WaitingInfo> {
    private static volatile WaitingInfo[] _emptyArray;
    public int cas;
    public int femaleWaitingSeq;
    public ODWaitingUser[] femaleWaitingUsers;
    public int maleWaitingSeq;
    public ODWaitingUser[] maleWaitingUsers;

    public WaitingInfo() {
        clear();
    }

    public static WaitingInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new WaitingInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static WaitingInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (WaitingInfo) MessageNano.mergeFrom(new WaitingInfo(), bArr);
    }

    public WaitingInfo clear() {
        this.maleWaitingSeq = 0;
        this.maleWaitingUsers = ODWaitingUser.emptyArray();
        this.femaleWaitingSeq = 0;
        this.femaleWaitingUsers = ODWaitingUser.emptyArray();
        this.cas = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.maleWaitingSeq);
        ODWaitingUser[] oDWaitingUserArr = this.maleWaitingUsers;
        int i3 = 0;
        if (oDWaitingUserArr != null && oDWaitingUserArr.length > 0) {
            int i16 = 0;
            while (true) {
                ODWaitingUser[] oDWaitingUserArr2 = this.maleWaitingUsers;
                if (i16 >= oDWaitingUserArr2.length) {
                    break;
                }
                ODWaitingUser oDWaitingUser = oDWaitingUserArr2[i16];
                if (oDWaitingUser != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, oDWaitingUser);
                }
                i16++;
            }
        }
        int computeUInt32Size = computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, this.femaleWaitingSeq);
        ODWaitingUser[] oDWaitingUserArr3 = this.femaleWaitingUsers;
        if (oDWaitingUserArr3 != null && oDWaitingUserArr3.length > 0) {
            while (true) {
                ODWaitingUser[] oDWaitingUserArr4 = this.femaleWaitingUsers;
                if (i3 >= oDWaitingUserArr4.length) {
                    break;
                }
                ODWaitingUser oDWaitingUser2 = oDWaitingUserArr4[i3];
                if (oDWaitingUser2 != null) {
                    computeUInt32Size += CodedOutputByteBufferNano.computeMessageSize(4, oDWaitingUser2);
                }
                i3++;
            }
        }
        int i17 = this.cas;
        if (i17 != 0) {
            return computeUInt32Size + CodedOutputByteBufferNano.computeInt32Size(5, i17);
        }
        return computeUInt32Size;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.maleWaitingSeq);
        ODWaitingUser[] oDWaitingUserArr = this.maleWaitingUsers;
        int i3 = 0;
        if (oDWaitingUserArr != null && oDWaitingUserArr.length > 0) {
            int i16 = 0;
            while (true) {
                ODWaitingUser[] oDWaitingUserArr2 = this.maleWaitingUsers;
                if (i16 >= oDWaitingUserArr2.length) {
                    break;
                }
                ODWaitingUser oDWaitingUser = oDWaitingUserArr2[i16];
                if (oDWaitingUser != null) {
                    codedOutputByteBufferNano.writeMessage(2, oDWaitingUser);
                }
                i16++;
            }
        }
        codedOutputByteBufferNano.writeUInt32(3, this.femaleWaitingSeq);
        ODWaitingUser[] oDWaitingUserArr3 = this.femaleWaitingUsers;
        if (oDWaitingUserArr3 != null && oDWaitingUserArr3.length > 0) {
            while (true) {
                ODWaitingUser[] oDWaitingUserArr4 = this.femaleWaitingUsers;
                if (i3 >= oDWaitingUserArr4.length) {
                    break;
                }
                ODWaitingUser oDWaitingUser2 = oDWaitingUserArr4[i3];
                if (oDWaitingUser2 != null) {
                    codedOutputByteBufferNano.writeMessage(4, oDWaitingUser2);
                }
                i3++;
            }
        }
        int i17 = this.cas;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static WaitingInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new WaitingInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public WaitingInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.maleWaitingSeq = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                ODWaitingUser[] oDWaitingUserArr = this.maleWaitingUsers;
                int length = oDWaitingUserArr == null ? 0 : oDWaitingUserArr.length;
                int i3 = repeatedFieldArrayLength + length;
                ODWaitingUser[] oDWaitingUserArr2 = new ODWaitingUser[i3];
                if (length != 0) {
                    System.arraycopy(oDWaitingUserArr, 0, oDWaitingUserArr2, 0, length);
                }
                while (length < i3 - 1) {
                    ODWaitingUser oDWaitingUser = new ODWaitingUser();
                    oDWaitingUserArr2[length] = oDWaitingUser;
                    codedInputByteBufferNano.readMessage(oDWaitingUser);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                ODWaitingUser oDWaitingUser2 = new ODWaitingUser();
                oDWaitingUserArr2[length] = oDWaitingUser2;
                codedInputByteBufferNano.readMessage(oDWaitingUser2);
                this.maleWaitingUsers = oDWaitingUserArr2;
            } else if (readTag == 24) {
                this.femaleWaitingSeq = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 34) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                ODWaitingUser[] oDWaitingUserArr3 = this.femaleWaitingUsers;
                int length2 = oDWaitingUserArr3 == null ? 0 : oDWaitingUserArr3.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                ODWaitingUser[] oDWaitingUserArr4 = new ODWaitingUser[i16];
                if (length2 != 0) {
                    System.arraycopy(oDWaitingUserArr3, 0, oDWaitingUserArr4, 0, length2);
                }
                while (length2 < i16 - 1) {
                    ODWaitingUser oDWaitingUser3 = new ODWaitingUser();
                    oDWaitingUserArr4[length2] = oDWaitingUser3;
                    codedInputByteBufferNano.readMessage(oDWaitingUser3);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                ODWaitingUser oDWaitingUser4 = new ODWaitingUser();
                oDWaitingUserArr4[length2] = oDWaitingUser4;
                codedInputByteBufferNano.readMessage(oDWaitingUser4);
                this.femaleWaitingUsers = oDWaitingUserArr4;
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.cas = codedInputByteBufferNano.readInt32();
            }
        }
    }
}
