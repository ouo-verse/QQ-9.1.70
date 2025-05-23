package com.tencent.mobileqq.icgame.data.play.nano;

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
    public FreePlayWaitingUser[] blueWaitingUsers;
    public int cas;
    public int redWaitingSeq;
    public FreePlayWaitingUser[] redWaitingUsers;

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
        this.redWaitingUsers = FreePlayWaitingUser.emptyArray();
        this.blueWaitingSeq = 0;
        this.blueWaitingUsers = FreePlayWaitingUser.emptyArray();
        this.cas = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.redWaitingSeq;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        FreePlayWaitingUser[] freePlayWaitingUserArr = this.redWaitingUsers;
        int i16 = 0;
        if (freePlayWaitingUserArr != null && freePlayWaitingUserArr.length > 0) {
            int i17 = 0;
            while (true) {
                FreePlayWaitingUser[] freePlayWaitingUserArr2 = this.redWaitingUsers;
                if (i17 >= freePlayWaitingUserArr2.length) {
                    break;
                }
                FreePlayWaitingUser freePlayWaitingUser = freePlayWaitingUserArr2[i17];
                if (freePlayWaitingUser != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, freePlayWaitingUser);
                }
                i17++;
            }
        }
        int i18 = this.blueWaitingSeq;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i18);
        }
        FreePlayWaitingUser[] freePlayWaitingUserArr3 = this.blueWaitingUsers;
        if (freePlayWaitingUserArr3 != null && freePlayWaitingUserArr3.length > 0) {
            while (true) {
                FreePlayWaitingUser[] freePlayWaitingUserArr4 = this.blueWaitingUsers;
                if (i16 >= freePlayWaitingUserArr4.length) {
                    break;
                }
                FreePlayWaitingUser freePlayWaitingUser2 = freePlayWaitingUserArr4[i16];
                if (freePlayWaitingUser2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, freePlayWaitingUser2);
                }
                i16++;
            }
        }
        int i19 = this.cas;
        if (i19 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, i19);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.redWaitingSeq;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        FreePlayWaitingUser[] freePlayWaitingUserArr = this.redWaitingUsers;
        int i16 = 0;
        if (freePlayWaitingUserArr != null && freePlayWaitingUserArr.length > 0) {
            int i17 = 0;
            while (true) {
                FreePlayWaitingUser[] freePlayWaitingUserArr2 = this.redWaitingUsers;
                if (i17 >= freePlayWaitingUserArr2.length) {
                    break;
                }
                FreePlayWaitingUser freePlayWaitingUser = freePlayWaitingUserArr2[i17];
                if (freePlayWaitingUser != null) {
                    codedOutputByteBufferNano.writeMessage(2, freePlayWaitingUser);
                }
                i17++;
            }
        }
        int i18 = this.blueWaitingSeq;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i18);
        }
        FreePlayWaitingUser[] freePlayWaitingUserArr3 = this.blueWaitingUsers;
        if (freePlayWaitingUserArr3 != null && freePlayWaitingUserArr3.length > 0) {
            while (true) {
                FreePlayWaitingUser[] freePlayWaitingUserArr4 = this.blueWaitingUsers;
                if (i16 >= freePlayWaitingUserArr4.length) {
                    break;
                }
                FreePlayWaitingUser freePlayWaitingUser2 = freePlayWaitingUserArr4[i16];
                if (freePlayWaitingUser2 != null) {
                    codedOutputByteBufferNano.writeMessage(4, freePlayWaitingUser2);
                }
                i16++;
            }
        }
        int i19 = this.cas;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i19);
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
                FreePlayWaitingUser[] freePlayWaitingUserArr = this.redWaitingUsers;
                int length = freePlayWaitingUserArr == null ? 0 : freePlayWaitingUserArr.length;
                int i3 = repeatedFieldArrayLength + length;
                FreePlayWaitingUser[] freePlayWaitingUserArr2 = new FreePlayWaitingUser[i3];
                if (length != 0) {
                    System.arraycopy(freePlayWaitingUserArr, 0, freePlayWaitingUserArr2, 0, length);
                }
                while (length < i3 - 1) {
                    FreePlayWaitingUser freePlayWaitingUser = new FreePlayWaitingUser();
                    freePlayWaitingUserArr2[length] = freePlayWaitingUser;
                    codedInputByteBufferNano.readMessage(freePlayWaitingUser);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                FreePlayWaitingUser freePlayWaitingUser2 = new FreePlayWaitingUser();
                freePlayWaitingUserArr2[length] = freePlayWaitingUser2;
                codedInputByteBufferNano.readMessage(freePlayWaitingUser2);
                this.redWaitingUsers = freePlayWaitingUserArr2;
            } else if (readTag == 24) {
                this.blueWaitingSeq = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 34) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                FreePlayWaitingUser[] freePlayWaitingUserArr3 = this.blueWaitingUsers;
                int length2 = freePlayWaitingUserArr3 == null ? 0 : freePlayWaitingUserArr3.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                FreePlayWaitingUser[] freePlayWaitingUserArr4 = new FreePlayWaitingUser[i16];
                if (length2 != 0) {
                    System.arraycopy(freePlayWaitingUserArr3, 0, freePlayWaitingUserArr4, 0, length2);
                }
                while (length2 < i16 - 1) {
                    FreePlayWaitingUser freePlayWaitingUser3 = new FreePlayWaitingUser();
                    freePlayWaitingUserArr4[length2] = freePlayWaitingUser3;
                    codedInputByteBufferNano.readMessage(freePlayWaitingUser3);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                FreePlayWaitingUser freePlayWaitingUser4 = new FreePlayWaitingUser();
                freePlayWaitingUserArr4[length2] = freePlayWaitingUser4;
                codedInputByteBufferNano.readMessage(freePlayWaitingUser4);
                this.blueWaitingUsers = freePlayWaitingUserArr4;
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
