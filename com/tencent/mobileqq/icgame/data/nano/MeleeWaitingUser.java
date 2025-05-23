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
public final class MeleeWaitingUser extends ExtendableMessageNano<MeleeWaitingUser> {
    private static volatile MeleeWaitingUser[] _emptyArray;
    public long uid;
    public int waitingInTime;

    public MeleeWaitingUser() {
        clear();
    }

    public static MeleeWaitingUser[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new MeleeWaitingUser[0];
                }
            }
        }
        return _emptyArray;
    }

    public static MeleeWaitingUser parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (MeleeWaitingUser) MessageNano.mergeFrom(new MeleeWaitingUser(), bArr);
    }

    public MeleeWaitingUser clear() {
        this.uid = 0L;
        this.waitingInTime = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.uid);
        int i3 = this.waitingInTime;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt64(1, this.uid);
        int i3 = this.waitingInTime;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static MeleeWaitingUser parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new MeleeWaitingUser().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public MeleeWaitingUser mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.waitingInTime = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
