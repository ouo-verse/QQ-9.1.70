package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class QueryOriginIdByUidRsp extends ExtendableMessageNano<QueryOriginIdByUidRsp> {
    private static volatile QueryOriginIdByUidRsp[] _emptyArray;
    public UidInfo[] ids;

    /* renamed from: msg, reason: collision with root package name */
    public String f237288msg;
    public int result;

    public QueryOriginIdByUidRsp() {
        clear();
    }

    public static QueryOriginIdByUidRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new QueryOriginIdByUidRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static QueryOriginIdByUidRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (QueryOriginIdByUidRsp) MessageNano.mergeFrom(new QueryOriginIdByUidRsp(), bArr);
    }

    public QueryOriginIdByUidRsp clear() {
        this.result = 0;
        this.f237288msg = "";
        this.ids = UidInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.result;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f237288msg.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f237288msg);
        }
        UidInfo[] uidInfoArr = this.ids;
        if (uidInfoArr != null && uidInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                UidInfo[] uidInfoArr2 = this.ids;
                if (i16 >= uidInfoArr2.length) {
                    break;
                }
                UidInfo uidInfo = uidInfoArr2[i16];
                if (uidInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, uidInfo);
                }
                i16++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.result;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f237288msg.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f237288msg);
        }
        UidInfo[] uidInfoArr = this.ids;
        if (uidInfoArr != null && uidInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                UidInfo[] uidInfoArr2 = this.ids;
                if (i16 >= uidInfoArr2.length) {
                    break;
                }
                UidInfo uidInfo = uidInfoArr2[i16];
                if (uidInfo != null) {
                    codedOutputByteBufferNano.writeMessage(3, uidInfo);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static QueryOriginIdByUidRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new QueryOriginIdByUidRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public QueryOriginIdByUidRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.result = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.f237288msg = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                UidInfo[] uidInfoArr = this.ids;
                int length = uidInfoArr == null ? 0 : uidInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                UidInfo[] uidInfoArr2 = new UidInfo[i3];
                if (length != 0) {
                    System.arraycopy(uidInfoArr, 0, uidInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    UidInfo uidInfo = new UidInfo();
                    uidInfoArr2[length] = uidInfo;
                    codedInputByteBufferNano.readMessage(uidInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                UidInfo uidInfo2 = new UidInfo();
                uidInfoArr2[length] = uidInfo2;
                codedInputByteBufferNano.readMessage(uidInfo2);
                this.ids = uidInfoArr2;
            }
        }
    }
}
