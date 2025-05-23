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
public final class HandInHandInfo extends ExtendableMessageNano<HandInHandInfo> {
    private static volatile HandInHandInfo[] _emptyArray;
    public HandInHandItem[] items;

    public HandInHandInfo() {
        clear();
    }

    public static HandInHandInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new HandInHandInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static HandInHandInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (HandInHandInfo) MessageNano.mergeFrom(new HandInHandInfo(), bArr);
    }

    public HandInHandInfo clear() {
        this.items = HandInHandItem.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        HandInHandItem[] handInHandItemArr = this.items;
        if (handInHandItemArr != null && handInHandItemArr.length > 0) {
            int i3 = 0;
            while (true) {
                HandInHandItem[] handInHandItemArr2 = this.items;
                if (i3 >= handInHandItemArr2.length) {
                    break;
                }
                HandInHandItem handInHandItem = handInHandItemArr2[i3];
                if (handInHandItem != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, handInHandItem);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        HandInHandItem[] handInHandItemArr = this.items;
        if (handInHandItemArr != null && handInHandItemArr.length > 0) {
            int i3 = 0;
            while (true) {
                HandInHandItem[] handInHandItemArr2 = this.items;
                if (i3 >= handInHandItemArr2.length) {
                    break;
                }
                HandInHandItem handInHandItem = handInHandItemArr2[i3];
                if (handInHandItem != null) {
                    codedOutputByteBufferNano.writeMessage(1, handInHandItem);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static HandInHandInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new HandInHandInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public HandInHandInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                HandInHandItem[] handInHandItemArr = this.items;
                int length = handInHandItemArr == null ? 0 : handInHandItemArr.length;
                int i3 = repeatedFieldArrayLength + length;
                HandInHandItem[] handInHandItemArr2 = new HandInHandItem[i3];
                if (length != 0) {
                    System.arraycopy(handInHandItemArr, 0, handInHandItemArr2, 0, length);
                }
                while (length < i3 - 1) {
                    HandInHandItem handInHandItem = new HandInHandItem();
                    handInHandItemArr2[length] = handInHandItem;
                    codedInputByteBufferNano.readMessage(handInHandItem);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                HandInHandItem handInHandItem2 = new HandInHandItem();
                handInHandItemArr2[length] = handInHandItem2;
                codedInputByteBufferNano.readMessage(handInHandItem2);
                this.items = handInHandItemArr2;
            }
        }
    }
}
