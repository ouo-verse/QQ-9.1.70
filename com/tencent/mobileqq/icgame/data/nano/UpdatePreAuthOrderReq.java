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
public final class UpdatePreAuthOrderReq extends ExtendableMessageNano<UpdatePreAuthOrderReq> {
    private static volatile UpdatePreAuthOrderReq[] _emptyArray;
    public long uid;
    public PreAuthOrder[] updateOrderList;

    public UpdatePreAuthOrderReq() {
        clear();
    }

    public static UpdatePreAuthOrderReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new UpdatePreAuthOrderReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static UpdatePreAuthOrderReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (UpdatePreAuthOrderReq) MessageNano.mergeFrom(new UpdatePreAuthOrderReq(), bArr);
    }

    public UpdatePreAuthOrderReq clear() {
        this.uid = 0L;
        this.updateOrderList = PreAuthOrder.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.uid);
        PreAuthOrder[] preAuthOrderArr = this.updateOrderList;
        if (preAuthOrderArr != null && preAuthOrderArr.length > 0) {
            int i3 = 0;
            while (true) {
                PreAuthOrder[] preAuthOrderArr2 = this.updateOrderList;
                if (i3 >= preAuthOrderArr2.length) {
                    break;
                }
                PreAuthOrder preAuthOrder = preAuthOrderArr2[i3];
                if (preAuthOrder != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, preAuthOrder);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt64(1, this.uid);
        PreAuthOrder[] preAuthOrderArr = this.updateOrderList;
        if (preAuthOrderArr != null && preAuthOrderArr.length > 0) {
            int i3 = 0;
            while (true) {
                PreAuthOrder[] preAuthOrderArr2 = this.updateOrderList;
                if (i3 >= preAuthOrderArr2.length) {
                    break;
                }
                PreAuthOrder preAuthOrder = preAuthOrderArr2[i3];
                if (preAuthOrder != null) {
                    codedOutputByteBufferNano.writeMessage(2, preAuthOrder);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static UpdatePreAuthOrderReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new UpdatePreAuthOrderReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public UpdatePreAuthOrderReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                PreAuthOrder[] preAuthOrderArr = this.updateOrderList;
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
                this.updateOrderList = preAuthOrderArr2;
            }
        }
    }
}
