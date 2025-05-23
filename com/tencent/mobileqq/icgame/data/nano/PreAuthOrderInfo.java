package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class PreAuthOrderInfo extends ExtendableMessageNano<PreAuthOrderInfo> {
    private static volatile PreAuthOrderInfo[] _emptyArray;
    public int cas;
    public PreAuthOrder[] orderList;

    public PreAuthOrderInfo() {
        clear();
    }

    public static PreAuthOrderInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new PreAuthOrderInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static PreAuthOrderInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (PreAuthOrderInfo) MessageNano.mergeFrom(new PreAuthOrderInfo(), bArr);
    }

    public PreAuthOrderInfo clear() {
        this.orderList = PreAuthOrder.emptyArray();
        this.cas = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        PreAuthOrder[] preAuthOrderArr = this.orderList;
        if (preAuthOrderArr != null && preAuthOrderArr.length > 0) {
            int i3 = 0;
            while (true) {
                PreAuthOrder[] preAuthOrderArr2 = this.orderList;
                if (i3 >= preAuthOrderArr2.length) {
                    break;
                }
                PreAuthOrder preAuthOrder = preAuthOrderArr2[i3];
                if (preAuthOrder != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, preAuthOrder);
                }
                i3++;
            }
        }
        int i16 = this.cas;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        PreAuthOrder[] preAuthOrderArr = this.orderList;
        if (preAuthOrderArr != null && preAuthOrderArr.length > 0) {
            int i3 = 0;
            while (true) {
                PreAuthOrder[] preAuthOrderArr2 = this.orderList;
                if (i3 >= preAuthOrderArr2.length) {
                    break;
                }
                PreAuthOrder preAuthOrder = preAuthOrderArr2[i3];
                if (preAuthOrder != null) {
                    codedOutputByteBufferNano.writeMessage(1, preAuthOrder);
                }
                i3++;
            }
        }
        int i16 = this.cas;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static PreAuthOrderInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new PreAuthOrderInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public PreAuthOrderInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                PreAuthOrder[] preAuthOrderArr = this.orderList;
                int length = preAuthOrderArr == null ? 0 : preAuthOrderArr.length;
                int i3 = repeatedFieldArrayLength + length;
                PreAuthOrder[] preAuthOrderArr2 = new PreAuthOrder[i3];
                if (length != 0) {
                    System.arraycopy(preAuthOrderArr, 0, preAuthOrderArr2, 0, length);
                }
                while (length < i3 - 1) {
                    PreAuthOrder preAuthOrder = new PreAuthOrder();
                    preAuthOrderArr2[length] = preAuthOrder;
                    codedInputByteBufferNano.readMessage(preAuthOrder);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                PreAuthOrder preAuthOrder2 = new PreAuthOrder();
                preAuthOrderArr2[length] = preAuthOrder2;
                codedInputByteBufferNano.readMessage(preAuthOrder2);
                this.orderList = preAuthOrderArr2;
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.cas = codedInputByteBufferNano.readInt32();
            }
        }
    }
}
