package com.tencent.mobileqq.icgame.data.draw.nano;

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
public final class RankItem extends ExtendableMessageNano<RankItem> {
    private static volatile RankItem[] _emptyArray;
    public ContributorInfo[] contributorInfo;
    public String data;
    public int rank;
    public int score;
    public int seatNo;
    public long uid;

    public RankItem() {
        clear();
    }

    public static RankItem[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new RankItem[0];
                }
            }
        }
        return _emptyArray;
    }

    public static RankItem parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (RankItem) MessageNano.mergeFrom(new RankItem(), bArr);
    }

    public RankItem clear() {
        this.uid = 0L;
        this.seatNo = 0;
        this.score = 0;
        this.rank = 0;
        this.data = "";
        this.contributorInfo = ContributorInfo.emptyArray();
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
        int i3 = this.seatNo;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        int i16 = this.score;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        int i17 = this.rank;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        if (!this.data.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.data);
        }
        ContributorInfo[] contributorInfoArr = this.contributorInfo;
        if (contributorInfoArr != null && contributorInfoArr.length > 0) {
            int i18 = 0;
            while (true) {
                ContributorInfo[] contributorInfoArr2 = this.contributorInfo;
                if (i18 >= contributorInfoArr2.length) {
                    break;
                }
                ContributorInfo contributorInfo = contributorInfoArr2[i18];
                if (contributorInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, contributorInfo);
                }
                i18++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.seatNo;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        int i16 = this.score;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        int i17 = this.rank;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        if (!this.data.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.data);
        }
        ContributorInfo[] contributorInfoArr = this.contributorInfo;
        if (contributorInfoArr != null && contributorInfoArr.length > 0) {
            int i18 = 0;
            while (true) {
                ContributorInfo[] contributorInfoArr2 = this.contributorInfo;
                if (i18 >= contributorInfoArr2.length) {
                    break;
                }
                ContributorInfo contributorInfo = contributorInfoArr2[i18];
                if (contributorInfo != null) {
                    codedOutputByteBufferNano.writeMessage(6, contributorInfo);
                }
                i18++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static RankItem parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new RankItem().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public RankItem mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.seatNo = codedInputByteBufferNano.readInt32();
            } else if (readTag == 24) {
                this.score = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.rank = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 42) {
                this.data = codedInputByteBufferNano.readString();
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                ContributorInfo[] contributorInfoArr = this.contributorInfo;
                int length = contributorInfoArr == null ? 0 : contributorInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                ContributorInfo[] contributorInfoArr2 = new ContributorInfo[i3];
                if (length != 0) {
                    System.arraycopy(contributorInfoArr, 0, contributorInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    ContributorInfo contributorInfo = new ContributorInfo();
                    contributorInfoArr2[length] = contributorInfo;
                    codedInputByteBufferNano.readMessage(contributorInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                ContributorInfo contributorInfo2 = new ContributorInfo();
                contributorInfoArr2[length] = contributorInfo2;
                codedInputByteBufferNano.readMessage(contributorInfo2);
                this.contributorInfo = contributorInfoArr2;
            }
        }
    }
}
