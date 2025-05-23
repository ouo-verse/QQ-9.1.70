package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class HyPayModel extends ExtendableMessageNano<HyPayModel> {
    private static volatile HyPayModel[] _emptyArray;
    public int appid;
    public int mode;
    public String openid;
    public String openkey;
    public String skey;
    public long uin;
    public String vask;

    public HyPayModel() {
        clear();
    }

    public static HyPayModel[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new HyPayModel[0];
                }
            }
        }
        return _emptyArray;
    }

    public static HyPayModel parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (HyPayModel) MessageNano.mergeFrom(new HyPayModel(), bArr);
    }

    public HyPayModel clear() {
        this.mode = 1;
        this.openid = "";
        this.openkey = "";
        this.appid = 0;
        this.uin = 0L;
        this.skey = "";
        this.vask = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeInt32Size(2, this.mode);
        if (!this.openid.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.openid);
        }
        if (!this.openkey.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.openkey);
        }
        int i3 = this.appid;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i3);
        }
        long j3 = this.uin;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(13, j3);
        }
        if (!this.skey.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.skey);
        }
        if (!this.vask.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(20, this.vask);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeInt32(2, this.mode);
        if (!this.openid.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.openid);
        }
        if (!this.openkey.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.openkey);
        }
        int i3 = this.appid;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i3);
        }
        long j3 = this.uin;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(13, j3);
        }
        if (!this.skey.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.skey);
        }
        if (!this.vask.equals("")) {
            codedOutputByteBufferNano.writeString(20, this.vask);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static HyPayModel parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new HyPayModel().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public HyPayModel mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 16) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 1 || readInt32 == 2 || readInt32 == 3 || readInt32 == 4) {
                    this.mode = readInt32;
                }
            } else if (readTag == 42) {
                this.openid = codedInputByteBufferNano.readString();
            } else if (readTag == 50) {
                this.openkey = codedInputByteBufferNano.readString();
            } else if (readTag == 56) {
                this.appid = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 104) {
                this.uin = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 114) {
                this.skey = codedInputByteBufferNano.readString();
            } else if (readTag != 162) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.vask = codedInputByteBufferNano.readString();
            }
        }
    }
}
