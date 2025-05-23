package com.tencent.mobileqq.icgame.data.diff.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class EditSeatOrderRsp extends ExtendableMessageNano<EditSeatOrderRsp> {
    private static volatile EditSeatOrderRsp[] _emptyArray;
    public EssentialDatingInfo essentialDatingInfo;

    public EditSeatOrderRsp() {
        clear();
    }

    public static EditSeatOrderRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new EditSeatOrderRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static EditSeatOrderRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (EditSeatOrderRsp) MessageNano.mergeFrom(new EditSeatOrderRsp(), bArr);
    }

    public EditSeatOrderRsp clear() {
        this.essentialDatingInfo = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        EssentialDatingInfo essentialDatingInfo = this.essentialDatingInfo;
        if (essentialDatingInfo != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, essentialDatingInfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        EssentialDatingInfo essentialDatingInfo = this.essentialDatingInfo;
        if (essentialDatingInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, essentialDatingInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static EditSeatOrderRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new EditSeatOrderRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public EditSeatOrderRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                if (this.essentialDatingInfo == null) {
                    this.essentialDatingInfo = new EssentialDatingInfo();
                }
                codedInputByteBufferNano.readMessage(this.essentialDatingInfo);
            }
        }
    }
}
