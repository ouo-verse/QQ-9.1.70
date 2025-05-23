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
public final class GroupMemberRsp extends ExtendableMessageNano<GroupMemberRsp> {
    private static volatile GroupMemberRsp[] _emptyArray;
    public MemberInfo[] bodyMemberinfo;
    public long result;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static final class MemberInfo extends ExtendableMessageNano<MemberInfo> {
        private static volatile MemberInfo[] _emptyArray;
        public long uid;
        public int uint32IsMember;

        public MemberInfo() {
            clear();
        }

        public static MemberInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new MemberInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static MemberInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (MemberInfo) MessageNano.mergeFrom(new MemberInfo(), bArr);
        }

        public MemberInfo clear() {
            this.uid = 0L;
            this.uint32IsMember = 0;
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
            int i3 = this.uint32IsMember;
            if (i3 != 0) {
                return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(2, i3);
            }
            return computeSerializedSize;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            long j3 = this.uid;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j3);
            }
            int i3 = this.uint32IsMember;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i3);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        public static MemberInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new MemberInfo().mergeFrom(codedInputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public MemberInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                    this.uint32IsMember = codedInputByteBufferNano.readUInt32();
                }
            }
        }
    }

    public GroupMemberRsp() {
        clear();
    }

    public static GroupMemberRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GroupMemberRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GroupMemberRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GroupMemberRsp) MessageNano.mergeFrom(new GroupMemberRsp(), bArr);
    }

    public GroupMemberRsp clear() {
        this.result = 0L;
        this.bodyMemberinfo = MemberInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.result;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        MemberInfo[] memberInfoArr = this.bodyMemberinfo;
        if (memberInfoArr != null && memberInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                MemberInfo[] memberInfoArr2 = this.bodyMemberinfo;
                if (i3 >= memberInfoArr2.length) {
                    break;
                }
                MemberInfo memberInfo = memberInfoArr2[i3];
                if (memberInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, memberInfo);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.result;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        MemberInfo[] memberInfoArr = this.bodyMemberinfo;
        if (memberInfoArr != null && memberInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                MemberInfo[] memberInfoArr2 = this.bodyMemberinfo;
                if (i3 >= memberInfoArr2.length) {
                    break;
                }
                MemberInfo memberInfo = memberInfoArr2[i3];
                if (memberInfo != null) {
                    codedOutputByteBufferNano.writeMessage(2, memberInfo);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GroupMemberRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GroupMemberRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GroupMemberRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.result = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                MemberInfo[] memberInfoArr = this.bodyMemberinfo;
                int length = memberInfoArr == null ? 0 : memberInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                MemberInfo[] memberInfoArr2 = new MemberInfo[i3];
                if (length != 0) {
                    System.arraycopy(memberInfoArr, 0, memberInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    MemberInfo memberInfo = new MemberInfo();
                    memberInfoArr2[length] = memberInfo;
                    codedInputByteBufferNano.readMessage(memberInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                MemberInfo memberInfo2 = new MemberInfo();
                memberInfoArr2[length] = memberInfo2;
                codedInputByteBufferNano.readMessage(memberInfo2);
                this.bodyMemberinfo = memberInfoArr2;
            }
        }
    }
}
