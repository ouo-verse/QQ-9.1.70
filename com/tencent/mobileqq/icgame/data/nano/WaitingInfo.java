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
public final class WaitingInfo extends ExtendableMessageNano<WaitingInfo> {
    private static volatile WaitingInfo[] _emptyArray;
    public int blueWaitingSeq;
    public MeleeWaitingUser[] blueWaitingUsers;
    public int cas;
    public int redWaitingSeq;
    public MeleeWaitingUser[] redWaitingUsers;

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
        this.redWaitingSeq = 0;
        this.redWaitingUsers = MeleeWaitingUser.emptyArray();
        this.blueWaitingSeq = 0;
        this.blueWaitingUsers = MeleeWaitingUser.emptyArray();
        this.cas = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.redWaitingSeq);
        MeleeWaitingUser[] meleeWaitingUserArr = this.redWaitingUsers;
        int i3 = 0;
        if (meleeWaitingUserArr != null && meleeWaitingUserArr.length > 0) {
            int i16 = 0;
            while (true) {
                MeleeWaitingUser[] meleeWaitingUserArr2 = this.redWaitingUsers;
                if (i16 >= meleeWaitingUserArr2.length) {
                    break;
                }
                MeleeWaitingUser meleeWaitingUser = meleeWaitingUserArr2[i16];
                if (meleeWaitingUser != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, meleeWaitingUser);
                }
                i16++;
            }
        }
        int computeUInt32Size = computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, this.blueWaitingSeq);
        MeleeWaitingUser[] meleeWaitingUserArr3 = this.blueWaitingUsers;
        if (meleeWaitingUserArr3 != null && meleeWaitingUserArr3.length > 0) {
            while (true) {
                MeleeWaitingUser[] meleeWaitingUserArr4 = this.blueWaitingUsers;
                if (i3 >= meleeWaitingUserArr4.length) {
                    break;
                }
                MeleeWaitingUser meleeWaitingUser2 = meleeWaitingUserArr4[i3];
                if (meleeWaitingUser2 != null) {
                    computeUInt32Size += CodedOutputByteBufferNano.computeMessageSize(4, meleeWaitingUser2);
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
        codedOutputByteBufferNano.writeUInt32(1, this.redWaitingSeq);
        MeleeWaitingUser[] meleeWaitingUserArr = this.redWaitingUsers;
        int i3 = 0;
        if (meleeWaitingUserArr != null && meleeWaitingUserArr.length > 0) {
            int i16 = 0;
            while (true) {
                MeleeWaitingUser[] meleeWaitingUserArr2 = this.redWaitingUsers;
                if (i16 >= meleeWaitingUserArr2.length) {
                    break;
                }
                MeleeWaitingUser meleeWaitingUser = meleeWaitingUserArr2[i16];
                if (meleeWaitingUser != null) {
                    codedOutputByteBufferNano.writeMessage(2, meleeWaitingUser);
                }
                i16++;
            }
        }
        codedOutputByteBufferNano.writeUInt32(3, this.blueWaitingSeq);
        MeleeWaitingUser[] meleeWaitingUserArr3 = this.blueWaitingUsers;
        if (meleeWaitingUserArr3 != null && meleeWaitingUserArr3.length > 0) {
            while (true) {
                MeleeWaitingUser[] meleeWaitingUserArr4 = this.blueWaitingUsers;
                if (i3 >= meleeWaitingUserArr4.length) {
                    break;
                }
                MeleeWaitingUser meleeWaitingUser2 = meleeWaitingUserArr4[i3];
                if (meleeWaitingUser2 != null) {
                    codedOutputByteBufferNano.writeMessage(4, meleeWaitingUser2);
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
                this.redWaitingSeq = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                MeleeWaitingUser[] meleeWaitingUserArr = this.redWaitingUsers;
                int length = meleeWaitingUserArr == null ? 0 : meleeWaitingUserArr.length;
                int i3 = repeatedFieldArrayLength + length;
                MeleeWaitingUser[] meleeWaitingUserArr2 = new MeleeWaitingUser[i3];
                if (length != 0) {
                    System.arraycopy(meleeWaitingUserArr, 0, meleeWaitingUserArr2, 0, length);
                }
                while (length < i3 - 1) {
                    MeleeWaitingUser meleeWaitingUser = new MeleeWaitingUser();
                    meleeWaitingUserArr2[length] = meleeWaitingUser;
                    codedInputByteBufferNano.readMessage(meleeWaitingUser);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                MeleeWaitingUser meleeWaitingUser2 = new MeleeWaitingUser();
                meleeWaitingUserArr2[length] = meleeWaitingUser2;
                codedInputByteBufferNano.readMessage(meleeWaitingUser2);
                this.redWaitingUsers = meleeWaitingUserArr2;
            } else if (readTag == 24) {
                this.blueWaitingSeq = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 34) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                MeleeWaitingUser[] meleeWaitingUserArr3 = this.blueWaitingUsers;
                int length2 = meleeWaitingUserArr3 == null ? 0 : meleeWaitingUserArr3.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                MeleeWaitingUser[] meleeWaitingUserArr4 = new MeleeWaitingUser[i16];
                if (length2 != 0) {
                    System.arraycopy(meleeWaitingUserArr3, 0, meleeWaitingUserArr4, 0, length2);
                }
                while (length2 < i16 - 1) {
                    MeleeWaitingUser meleeWaitingUser3 = new MeleeWaitingUser();
                    meleeWaitingUserArr4[length2] = meleeWaitingUser3;
                    codedInputByteBufferNano.readMessage(meleeWaitingUser3);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                MeleeWaitingUser meleeWaitingUser4 = new MeleeWaitingUser();
                meleeWaitingUserArr4[length2] = meleeWaitingUser4;
                codedInputByteBufferNano.readMessage(meleeWaitingUser4);
                this.blueWaitingUsers = meleeWaitingUserArr4;
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
