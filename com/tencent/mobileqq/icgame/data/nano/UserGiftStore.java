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
public final class UserGiftStore extends ExtendableMessageNano<UserGiftStore> {
    private static volatile UserGiftStore[] _emptyArray;
    public GiftStore[] giftStore;

    public UserGiftStore() {
        clear();
    }

    public static UserGiftStore[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new UserGiftStore[0];
                }
            }
        }
        return _emptyArray;
    }

    public static UserGiftStore parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (UserGiftStore) MessageNano.mergeFrom(new UserGiftStore(), bArr);
    }

    public UserGiftStore clear() {
        this.giftStore = GiftStore.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        GiftStore[] giftStoreArr = this.giftStore;
        if (giftStoreArr != null && giftStoreArr.length > 0) {
            int i3 = 0;
            while (true) {
                GiftStore[] giftStoreArr2 = this.giftStore;
                if (i3 >= giftStoreArr2.length) {
                    break;
                }
                GiftStore giftStore = giftStoreArr2[i3];
                if (giftStore != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, giftStore);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        GiftStore[] giftStoreArr = this.giftStore;
        if (giftStoreArr != null && giftStoreArr.length > 0) {
            int i3 = 0;
            while (true) {
                GiftStore[] giftStoreArr2 = this.giftStore;
                if (i3 >= giftStoreArr2.length) {
                    break;
                }
                GiftStore giftStore = giftStoreArr2[i3];
                if (giftStore != null) {
                    codedOutputByteBufferNano.writeMessage(1, giftStore);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static UserGiftStore parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new UserGiftStore().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public UserGiftStore mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                GiftStore[] giftStoreArr = this.giftStore;
                int length = giftStoreArr == null ? 0 : giftStoreArr.length;
                int i3 = repeatedFieldArrayLength + length;
                GiftStore[] giftStoreArr2 = new GiftStore[i3];
                if (length != 0) {
                    System.arraycopy(giftStoreArr, 0, giftStoreArr2, 0, length);
                }
                while (length < i3 - 1) {
                    GiftStore giftStore = new GiftStore();
                    giftStoreArr2[length] = giftStore;
                    codedInputByteBufferNano.readMessage(giftStore);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                GiftStore giftStore2 = new GiftStore();
                giftStoreArr2[length] = giftStore2;
                codedInputByteBufferNano.readMessage(giftStore2);
                this.giftStore = giftStoreArr2;
            }
        }
    }
}
