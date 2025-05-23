package com.tencent.mobileqq.icgame.data.punish.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class RecordUser extends ExtendableMessageNano<RecordUser> {
    private static volatile RecordUser[] _emptyArray;
    public String avatar;
    public String nick;
    public long uid;

    public RecordUser() {
        clear();
    }

    public static RecordUser[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new RecordUser[0];
                }
            }
        }
        return _emptyArray;
    }

    public static RecordUser parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (RecordUser) MessageNano.mergeFrom(new RecordUser(), bArr);
    }

    public RecordUser clear() {
        this.uid = 0L;
        this.nick = "";
        this.avatar = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.uid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.nick.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.nick);
        }
        if (!this.avatar.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.avatar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.nick.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.nick);
        }
        if (!this.avatar.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.avatar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static RecordUser parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new RecordUser().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public RecordUser mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.nick = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.avatar = codedInputByteBufferNano.readString();
            }
        }
    }
}
