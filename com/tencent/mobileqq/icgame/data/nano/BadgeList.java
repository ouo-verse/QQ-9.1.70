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
public final class BadgeList extends ExtendableMessageNano<BadgeList> {
    private static volatile BadgeList[] _emptyArray;
    public BadgeItem[] items;

    public BadgeList() {
        clear();
    }

    public static BadgeList[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new BadgeList[0];
                }
            }
        }
        return _emptyArray;
    }

    public static BadgeList parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (BadgeList) MessageNano.mergeFrom(new BadgeList(), bArr);
    }

    public BadgeList clear() {
        this.items = BadgeItem.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        BadgeItem[] badgeItemArr = this.items;
        if (badgeItemArr != null && badgeItemArr.length > 0) {
            int i3 = 0;
            while (true) {
                BadgeItem[] badgeItemArr2 = this.items;
                if (i3 >= badgeItemArr2.length) {
                    break;
                }
                BadgeItem badgeItem = badgeItemArr2[i3];
                if (badgeItem != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, badgeItem);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        BadgeItem[] badgeItemArr = this.items;
        if (badgeItemArr != null && badgeItemArr.length > 0) {
            int i3 = 0;
            while (true) {
                BadgeItem[] badgeItemArr2 = this.items;
                if (i3 >= badgeItemArr2.length) {
                    break;
                }
                BadgeItem badgeItem = badgeItemArr2[i3];
                if (badgeItem != null) {
                    codedOutputByteBufferNano.writeMessage(1, badgeItem);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static BadgeList parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new BadgeList().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public BadgeList mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                BadgeItem[] badgeItemArr = this.items;
                int length = badgeItemArr == null ? 0 : badgeItemArr.length;
                int i3 = repeatedFieldArrayLength + length;
                BadgeItem[] badgeItemArr2 = new BadgeItem[i3];
                if (length != 0) {
                    System.arraycopy(badgeItemArr, 0, badgeItemArr2, 0, length);
                }
                while (length < i3 - 1) {
                    BadgeItem badgeItem = new BadgeItem();
                    badgeItemArr2[length] = badgeItem;
                    codedInputByteBufferNano.readMessage(badgeItem);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                BadgeItem badgeItem2 = new BadgeItem();
                badgeItemArr2[length] = badgeItem2;
                codedInputByteBufferNano.readMessage(badgeItem2);
                this.items = badgeItemArr2;
            }
        }
    }
}
