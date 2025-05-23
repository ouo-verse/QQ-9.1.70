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
public final class MeleeVipUser extends ExtendableMessageNano<MeleeVipUser> {
    private static volatile MeleeVipUser[] _emptyArray;
    public boolean micStatus;
    public int seatNo;
    public int seatType;
    public long uid;

    public MeleeVipUser() {
        clear();
    }

    public static MeleeVipUser[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new MeleeVipUser[0];
                }
            }
        }
        return _emptyArray;
    }

    public static MeleeVipUser parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (MeleeVipUser) MessageNano.mergeFrom(new MeleeVipUser(), bArr);
    }

    public MeleeVipUser clear() {
        this.seatType = 0;
        this.seatNo = 0;
        this.uid = 0L;
        this.micStatus = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.seatType;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.seatNo;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        long j3 = this.uid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        boolean z16 = this.micStatus;
        if (z16) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(4, z16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.seatType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.seatNo;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        boolean z16 = this.micStatus;
        if (z16) {
            codedOutputByteBufferNano.writeBool(4, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static MeleeVipUser parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new MeleeVipUser().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public MeleeVipUser mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                switch (readInt32) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        this.seatType = readInt32;
                        break;
                }
            } else if (readTag == 16) {
                this.seatNo = codedInputByteBufferNano.readInt32();
            } else if (readTag == 24) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.micStatus = codedInputByteBufferNano.readBool();
            }
        }
    }
}
