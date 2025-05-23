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
public final class ItemList extends ExtendableMessageNano<ItemList> {
    private static volatile ItemList[] _emptyArray;
    public ItemInfo[] items;

    public ItemList() {
        clear();
    }

    public static ItemList[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ItemList[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ItemList parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ItemList) MessageNano.mergeFrom(new ItemList(), bArr);
    }

    public ItemList clear() {
        this.items = ItemInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        ItemInfo[] itemInfoArr = this.items;
        if (itemInfoArr != null && itemInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                ItemInfo[] itemInfoArr2 = this.items;
                if (i3 >= itemInfoArr2.length) {
                    break;
                }
                ItemInfo itemInfo = itemInfoArr2[i3];
                if (itemInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, itemInfo);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        ItemInfo[] itemInfoArr = this.items;
        if (itemInfoArr != null && itemInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                ItemInfo[] itemInfoArr2 = this.items;
                if (i3 >= itemInfoArr2.length) {
                    break;
                }
                ItemInfo itemInfo = itemInfoArr2[i3];
                if (itemInfo != null) {
                    codedOutputByteBufferNano.writeMessage(1, itemInfo);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ItemList parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ItemList().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ItemList mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                ItemInfo[] itemInfoArr = this.items;
                int length = itemInfoArr == null ? 0 : itemInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                ItemInfo[] itemInfoArr2 = new ItemInfo[i3];
                if (length != 0) {
                    System.arraycopy(itemInfoArr, 0, itemInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    ItemInfo itemInfo = new ItemInfo();
                    itemInfoArr2[length] = itemInfo;
                    codedInputByteBufferNano.readMessage(itemInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                ItemInfo itemInfo2 = new ItemInfo();
                itemInfoArr2[length] = itemInfo2;
                codedInputByteBufferNano.readMessage(itemInfo2);
                this.items = itemInfoArr2;
            }
        }
    }
}
