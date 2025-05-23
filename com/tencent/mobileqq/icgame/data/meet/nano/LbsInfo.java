package com.tencent.mobileqq.icgame.data.meet.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class LbsInfo extends ExtendableMessageNano<LbsInfo> {
    private static volatile LbsInfo[] _emptyArray;
    public String city;
    public String lat;
    public String lng;
    public String name;

    public LbsInfo() {
        clear();
    }

    public static LbsInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LbsInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LbsInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LbsInfo) MessageNano.mergeFrom(new LbsInfo(), bArr);
    }

    public LbsInfo clear() {
        this.lng = "";
        this.lat = "";
        this.city = "";
        this.name = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.lng.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.lng);
        }
        if (!this.lat.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.lat);
        }
        if (!this.city.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.city);
        }
        if (!this.name.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.name);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.lng.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.lng);
        }
        if (!this.lat.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.lat);
        }
        if (!this.city.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.city);
        }
        if (!this.name.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.name);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static LbsInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LbsInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LbsInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.lng = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.lat = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.city = codedInputByteBufferNano.readString();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.name = codedInputByteBufferNano.readString();
            }
        }
    }
}
