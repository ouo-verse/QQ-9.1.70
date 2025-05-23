package com.tencent.mobileqq.icgame.data.ilive.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class LinkMicAnonGiftEvent extends ExtendableMessageNano<LinkMicAnonGiftEvent> {
    private static volatile LinkMicAnonGiftEvent[] _emptyArray;
    public long giftId;
    public long giftNum;
    public int giftType;
    public String sendLogo;
    public String sendNick;
    public long sendUid;
    public long uid;

    public LinkMicAnonGiftEvent() {
        clear();
    }

    public static LinkMicAnonGiftEvent[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LinkMicAnonGiftEvent[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LinkMicAnonGiftEvent parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LinkMicAnonGiftEvent) MessageNano.mergeFrom(new LinkMicAnonGiftEvent(), bArr);
    }

    public LinkMicAnonGiftEvent clear() {
        this.uid = 0L;
        this.sendUid = 0L;
        this.giftType = 0;
        this.giftId = 0L;
        this.giftNum = 0L;
        this.sendNick = "";
        this.sendLogo = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.uid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.sendUid;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        int i3 = this.giftType;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        long j17 = this.giftId;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j17);
        }
        long j18 = this.giftNum;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j18);
        }
        if (!this.sendNick.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.sendNick);
        }
        if (!this.sendLogo.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.sendLogo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.sendUid;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        int i3 = this.giftType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        long j17 = this.giftId;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j17);
        }
        long j18 = this.giftNum;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j18);
        }
        if (!this.sendNick.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.sendNick);
        }
        if (!this.sendLogo.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.sendLogo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static LinkMicAnonGiftEvent parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LinkMicAnonGiftEvent().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LinkMicAnonGiftEvent mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.sendUid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.giftType = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.giftId = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 40) {
                this.giftNum = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 50) {
                this.sendNick = codedInputByteBufferNano.readString();
            } else if (readTag != 58) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.sendLogo = codedInputByteBufferNano.readString();
            }
        }
    }
}
