package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class Privilege_Time_Data extends ExtendableMessageNano<Privilege_Time_Data> {
    private static volatile Privilege_Time_Data[] _emptyArray;
    public PrivilegeExtInfo extendedInfo;
    public int failTime;
    public int privilegeEffective;
    public int privilegeLevel;
    public String privilegeName;
    public int privilegeTimeEffective;
    public int privilegeType;

    public Privilege_Time_Data() {
        clear();
    }

    public static Privilege_Time_Data[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new Privilege_Time_Data[0];
                }
            }
        }
        return _emptyArray;
    }

    public static Privilege_Time_Data parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Privilege_Time_Data) MessageNano.mergeFrom(new Privilege_Time_Data(), bArr);
    }

    public Privilege_Time_Data clear() {
        this.privilegeType = 0;
        this.privilegeEffective = 0;
        this.privilegeLevel = 0;
        this.privilegeTimeEffective = 0;
        this.failTime = 0;
        this.extendedInfo = null;
        this.privilegeName = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.privilegeType;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.privilegeEffective;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        int i17 = this.privilegeLevel;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i17);
        }
        int i18 = this.privilegeTimeEffective;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i18);
        }
        int i19 = this.failTime;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i19);
        }
        PrivilegeExtInfo privilegeExtInfo = this.extendedInfo;
        if (privilegeExtInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, privilegeExtInfo);
        }
        if (!this.privilegeName.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.privilegeName);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.privilegeType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.privilegeEffective;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        int i17 = this.privilegeLevel;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        int i18 = this.privilegeTimeEffective;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i18);
        }
        int i19 = this.failTime;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i19);
        }
        PrivilegeExtInfo privilegeExtInfo = this.extendedInfo;
        if (privilegeExtInfo != null) {
            codedOutputByteBufferNano.writeMessage(6, privilegeExtInfo);
        }
        if (!this.privilegeName.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.privilegeName);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static Privilege_Time_Data parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Privilege_Time_Data().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public Privilege_Time_Data mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.privilegeType = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.privilegeEffective = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.privilegeLevel = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.privilegeTimeEffective = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 40) {
                this.failTime = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 50) {
                if (this.extendedInfo == null) {
                    this.extendedInfo = new PrivilegeExtInfo();
                }
                codedInputByteBufferNano.readMessage(this.extendedInfo);
            } else if (readTag != 58) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.privilegeName = codedInputByteBufferNano.readString();
            }
        }
    }
}
