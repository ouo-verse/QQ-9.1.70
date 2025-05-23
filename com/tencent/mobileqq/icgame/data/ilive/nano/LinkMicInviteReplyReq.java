package com.tencent.mobileqq.icgame.data.ilive.nano;

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
public final class LinkMicInviteReplyReq extends ExtendableMessageNano<LinkMicInviteReplyReq> {
    private static volatile LinkMicInviteReplyReq[] _emptyArray;
    public long anchorUid;
    public int linkMicType;
    public int replyState;
    public long[] sendInviteAnchorUid;

    public LinkMicInviteReplyReq() {
        clear();
    }

    public static LinkMicInviteReplyReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LinkMicInviteReplyReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LinkMicInviteReplyReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LinkMicInviteReplyReq) MessageNano.mergeFrom(new LinkMicInviteReplyReq(), bArr);
    }

    public LinkMicInviteReplyReq clear() {
        this.anchorUid = 0L;
        this.sendInviteAnchorUid = WireFormatNano.EMPTY_LONG_ARRAY;
        this.replyState = 0;
        this.linkMicType = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        long[] jArr;
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.anchorUid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long[] jArr2 = this.sendInviteAnchorUid;
        if (jArr2 != null && jArr2.length > 0) {
            int i3 = 0;
            int i16 = 0;
            while (true) {
                jArr = this.sendInviteAnchorUid;
                if (i3 >= jArr.length) {
                    break;
                }
                i16 += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr[i3]);
                i3++;
            }
            computeSerializedSize = computeSerializedSize + i16 + (jArr.length * 1);
        }
        int i17 = this.replyState;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i17);
        }
        int i18 = this.linkMicType;
        if (i18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.anchorUid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long[] jArr = this.sendInviteAnchorUid;
        if (jArr != null && jArr.length > 0) {
            int i3 = 0;
            while (true) {
                long[] jArr2 = this.sendInviteAnchorUid;
                if (i3 >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(2, jArr2[i3]);
                i3++;
            }
        }
        int i16 = this.replyState;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        int i17 = this.linkMicType;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static LinkMicInviteReplyReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LinkMicInviteReplyReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LinkMicInviteReplyReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.anchorUid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 16);
                long[] jArr = this.sendInviteAnchorUid;
                int length = jArr == null ? 0 : jArr.length;
                int i3 = repeatedFieldArrayLength + length;
                long[] jArr2 = new long[i3];
                if (length != 0) {
                    System.arraycopy(jArr, 0, jArr2, 0, length);
                }
                while (length < i3 - 1) {
                    jArr2[length] = codedInputByteBufferNano.readUInt64();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                jArr2[length] = codedInputByteBufferNano.readUInt64();
                this.sendInviteAnchorUid = jArr2;
            } else if (readTag == 18) {
                int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i16 = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readUInt64();
                    i16++;
                }
                codedInputByteBufferNano.rewindToPosition(position);
                long[] jArr3 = this.sendInviteAnchorUid;
                int length2 = jArr3 == null ? 0 : jArr3.length;
                int i17 = i16 + length2;
                long[] jArr4 = new long[i17];
                if (length2 != 0) {
                    System.arraycopy(jArr3, 0, jArr4, 0, length2);
                }
                while (length2 < i17) {
                    jArr4[length2] = codedInputByteBufferNano.readUInt64();
                    length2++;
                }
                this.sendInviteAnchorUid = jArr4;
                codedInputByteBufferNano.popLimit(pushLimit);
            } else if (readTag == 24) {
                this.replyState = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.linkMicType = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
