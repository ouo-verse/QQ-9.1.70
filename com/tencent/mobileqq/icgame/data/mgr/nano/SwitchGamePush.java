package com.tencent.mobileqq.icgame.data.mgr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class SwitchGamePush extends ExtendableMessageNano<SwitchGamePush> {
    private static volatile SwitchGamePush[] _emptyArray;
    public GameInfo dstGame;
    public String oldVersionTxt;
    public int roomId;
    public GameInfo srcGame;
    public int[] supportItem;
    public String txt;

    public SwitchGamePush() {
        clear();
    }

    public static SwitchGamePush[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SwitchGamePush[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SwitchGamePush parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SwitchGamePush) MessageNano.mergeFrom(new SwitchGamePush(), bArr);
    }

    public SwitchGamePush clear() {
        this.roomId = 0;
        this.srcGame = null;
        this.dstGame = null;
        this.txt = "";
        this.oldVersionTxt = "";
        this.supportItem = WireFormatNano.EMPTY_INT_ARRAY;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.roomId;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        GameInfo gameInfo = this.srcGame;
        if (gameInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, gameInfo);
        }
        GameInfo gameInfo2 = this.dstGame;
        if (gameInfo2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, gameInfo2);
        }
        if (!this.txt.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.txt);
        }
        if (!this.oldVersionTxt.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.oldVersionTxt);
        }
        int[] iArr = this.supportItem;
        if (iArr != null && iArr.length > 0) {
            int i16 = 0;
            int i17 = 0;
            while (true) {
                int[] iArr2 = this.supportItem;
                if (i16 < iArr2.length) {
                    i17 += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr2[i16]);
                    i16++;
                } else {
                    return computeSerializedSize + i17 + (iArr2.length * 1);
                }
            }
        } else {
            return computeSerializedSize;
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.roomId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        GameInfo gameInfo = this.srcGame;
        if (gameInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, gameInfo);
        }
        GameInfo gameInfo2 = this.dstGame;
        if (gameInfo2 != null) {
            codedOutputByteBufferNano.writeMessage(3, gameInfo2);
        }
        if (!this.txt.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.txt);
        }
        if (!this.oldVersionTxt.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.oldVersionTxt);
        }
        int[] iArr = this.supportItem;
        if (iArr != null && iArr.length > 0) {
            int i16 = 0;
            while (true) {
                int[] iArr2 = this.supportItem;
                if (i16 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(10, iArr2[i16]);
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SwitchGamePush parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SwitchGamePush().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SwitchGamePush mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                if (this.srcGame == null) {
                    this.srcGame = new GameInfo();
                }
                codedInputByteBufferNano.readMessage(this.srcGame);
            } else if (readTag == 26) {
                if (this.dstGame == null) {
                    this.dstGame = new GameInfo();
                }
                codedInputByteBufferNano.readMessage(this.dstGame);
            } else if (readTag == 34) {
                this.txt = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.oldVersionTxt = codedInputByteBufferNano.readString();
            } else if (readTag == 80) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 80);
                int[] iArr = this.supportItem;
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
                this.supportItem = iArr2;
            } else if (readTag != 82) {
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
                int[] iArr3 = this.supportItem;
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
                this.supportItem = iArr4;
                codedInputByteBufferNano.popLimit(pushLimit);
            }
        }
    }
}
