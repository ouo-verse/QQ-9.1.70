package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class BadgeItem extends ExtendableMessageNano<BadgeItem> {
    private static volatile BadgeItem[] _emptyArray;
    public int badgeId;
    public int badgeLevel;
    public String badgeName;
    public String badgePic;
    public int badgeType;
    public String badgeUnit;

    public BadgeItem() {
        clear();
    }

    public static BadgeItem[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new BadgeItem[0];
                }
            }
        }
        return _emptyArray;
    }

    public static BadgeItem parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (BadgeItem) MessageNano.mergeFrom(new BadgeItem(), bArr);
    }

    public BadgeItem clear() {
        this.badgeId = 0;
        this.badgeLevel = 0;
        this.badgeName = "";
        this.badgePic = "";
        this.badgeUnit = "";
        this.badgeType = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.badgeId;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.badgeLevel;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        if (!this.badgeName.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.badgeName);
        }
        if (!this.badgePic.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.badgePic);
        }
        if (!this.badgeUnit.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.badgeUnit);
        }
        int i17 = this.badgeType;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(100, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.badgeId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.badgeLevel;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        if (!this.badgeName.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.badgeName);
        }
        if (!this.badgePic.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.badgePic);
        }
        if (!this.badgeUnit.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.badgeUnit);
        }
        int i17 = this.badgeType;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(100, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static BadgeItem parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new BadgeItem().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public BadgeItem mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.badgeId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.badgeLevel = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 26) {
                this.badgeName = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.badgePic = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.badgeUnit = codedInputByteBufferNano.readString();
            } else if (readTag != 800) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.badgeType = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
