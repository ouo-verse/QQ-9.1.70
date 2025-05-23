package com.tencent.mobileqq.icgame.data.av.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class AvRoomStatusChgReq extends ExtendableMessageNano<AvRoomStatusChgReq> {
    private static volatile AvRoomStatusChgReq[] _emptyArray;
    public int clientType;
    public Extinfo extInfo;
    public int roomId;

    public AvRoomStatusChgReq() {
        clear();
    }

    public static AvRoomStatusChgReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AvRoomStatusChgReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static AvRoomStatusChgReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (AvRoomStatusChgReq) MessageNano.mergeFrom(new AvRoomStatusChgReq(), bArr);
    }

    public AvRoomStatusChgReq clear() {
        this.roomId = 0;
        this.clientType = 0;
        this.extInfo = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.roomId;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.clientType;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        Extinfo extinfo = this.extInfo;
        if (extinfo != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, extinfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.roomId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.clientType;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        Extinfo extinfo = this.extInfo;
        if (extinfo != null) {
            codedOutputByteBufferNano.writeMessage(3, extinfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static AvRoomStatusChgReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new AvRoomStatusChgReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public AvRoomStatusChgReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.clientType = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.extInfo == null) {
                    this.extInfo = new Extinfo();
                }
                codedInputByteBufferNano.readMessage(this.extInfo);
            }
        }
    }
}
