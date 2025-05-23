package com.tencent.mobileqq.icgame.data.lucky.nano;

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
public final class StoreRecord extends ExtendableMessageNano<StoreRecord> {
    private static volatile StoreRecord[] _emptyArray;
    public int comboSeq;
    public int giftCoin;
    public Gift[] gifts;
    public int luckyNum;

    /* renamed from: ts, reason: collision with root package name */
    public int f237269ts;
    public long uid;

    public StoreRecord() {
        clear();
    }

    public static StoreRecord[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new StoreRecord[0];
                }
            }
        }
        return _emptyArray;
    }

    public static StoreRecord parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (StoreRecord) MessageNano.mergeFrom(new StoreRecord(), bArr);
    }

    public StoreRecord clear() {
        this.gifts = Gift.emptyArray();
        this.f237269ts = 0;
        this.luckyNum = 0;
        this.giftCoin = 0;
        this.comboSeq = 0;
        this.uid = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        Gift[] giftArr = this.gifts;
        if (giftArr != null && giftArr.length > 0) {
            int i3 = 0;
            while (true) {
                Gift[] giftArr2 = this.gifts;
                if (i3 >= giftArr2.length) {
                    break;
                }
                Gift gift = giftArr2[i3];
                if (gift != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, gift);
                }
                i3++;
            }
        }
        int i16 = this.f237269ts;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        int i17 = this.luckyNum;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i17);
        }
        int i18 = this.giftCoin;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i18);
        }
        int i19 = this.comboSeq;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i19);
        }
        long j3 = this.uid;
        if (j3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(6, j3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Gift[] giftArr = this.gifts;
        if (giftArr != null && giftArr.length > 0) {
            int i3 = 0;
            while (true) {
                Gift[] giftArr2 = this.gifts;
                if (i3 >= giftArr2.length) {
                    break;
                }
                Gift gift = giftArr2[i3];
                if (gift != null) {
                    codedOutputByteBufferNano.writeMessage(1, gift);
                }
                i3++;
            }
        }
        int i16 = this.f237269ts;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        int i17 = this.luckyNum;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        int i18 = this.giftCoin;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i18);
        }
        int i19 = this.comboSeq;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i19);
        }
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static StoreRecord parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new StoreRecord().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public StoreRecord mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                Gift[] giftArr = this.gifts;
                int length = giftArr == null ? 0 : giftArr.length;
                int i3 = repeatedFieldArrayLength + length;
                Gift[] giftArr2 = new Gift[i3];
                if (length != 0) {
                    System.arraycopy(giftArr, 0, giftArr2, 0, length);
                }
                while (length < i3 - 1) {
                    Gift gift = new Gift();
                    giftArr2[length] = gift;
                    codedInputByteBufferNano.readMessage(gift);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                Gift gift2 = new Gift();
                giftArr2[length] = gift2;
                codedInputByteBufferNano.readMessage(gift2);
                this.gifts = giftArr2;
            } else if (readTag == 16) {
                this.f237269ts = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.luckyNum = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.giftCoin = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 40) {
                this.comboSeq = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 48) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.uid = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
