package com.tencent.mobileqq.icgame.data.stage.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class AdminPush extends ExtendableMessageNano<AdminPush> {
    private static volatile AdminPush[] _emptyArray;
    public int adminType;
    public long adminUid;
    public long editUid;
    public String ext;

    public AdminPush() {
        clear();
    }

    public static AdminPush[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AdminPush[0];
                }
            }
        }
        return _emptyArray;
    }

    public static AdminPush parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (AdminPush) MessageNano.mergeFrom(new AdminPush(), bArr);
    }

    public AdminPush clear() {
        this.adminUid = 0L;
        this.editUid = 0L;
        this.adminType = 0;
        this.ext = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.adminUid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.editUid;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        int i3 = this.adminType;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        if (!this.ext.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(10, this.ext);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.adminUid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.editUid;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        int i3 = this.adminType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        if (!this.ext.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.ext);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static AdminPush parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new AdminPush().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public AdminPush mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.adminUid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.editUid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.adminType = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 82) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.ext = codedInputByteBufferNano.readString();
            }
        }
    }
}
