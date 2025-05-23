package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class ExperimentInfo extends ExtendableMessageNano<ExperimentInfo> {
    private static volatile ExperimentInfo[] _emptyArray;
    public long endTime;
    public String expKey;
    public String groupKey;

    /* renamed from: id, reason: collision with root package name */
    public long f237278id;
    public boolean isControl;
    public boolean isDefault;
    public String moduleCode;
    public Map<String, String> params;
    public long startTime;

    public ExperimentInfo() {
        clear();
    }

    public static ExperimentInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ExperimentInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ExperimentInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ExperimentInfo) MessageNano.mergeFrom(new ExperimentInfo(), bArr);
    }

    public ExperimentInfo clear() {
        this.f237278id = 0L;
        this.startTime = 0L;
        this.endTime = 0L;
        this.groupKey = "";
        this.expKey = "";
        this.params = null;
        this.isDefault = false;
        this.isControl = false;
        this.moduleCode = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f237278id;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j3);
        }
        long j16 = this.startTime;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j16);
        }
        long j17 = this.endTime;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j17);
        }
        if (!this.groupKey.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.groupKey);
        }
        if (!this.expKey.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.expKey);
        }
        Map<String, String> map = this.params;
        if (map != null) {
            computeSerializedSize += InternalNano.computeMapFieldSize(map, 6, 9, 9);
        }
        boolean z16 = this.isDefault;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, z16);
        }
        boolean z17 = this.isControl;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(8, z17);
        }
        if (!this.moduleCode.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(9, this.moduleCode);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f237278id;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(1, j3);
        }
        long j16 = this.startTime;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j16);
        }
        long j17 = this.endTime;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeInt64(3, j17);
        }
        if (!this.groupKey.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.groupKey);
        }
        if (!this.expKey.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.expKey);
        }
        Map<String, String> map = this.params;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 6, 9, 9);
        }
        boolean z16 = this.isDefault;
        if (z16) {
            codedOutputByteBufferNano.writeBool(7, z16);
        }
        boolean z17 = this.isControl;
        if (z17) {
            codedOutputByteBufferNano.writeBool(8, z17);
        }
        if (!this.moduleCode.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.moduleCode);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ExperimentInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ExperimentInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ExperimentInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f237278id = codedInputByteBufferNano.readInt64();
            } else if (readTag == 16) {
                this.startTime = codedInputByteBufferNano.readInt64();
            } else if (readTag == 24) {
                this.endTime = codedInputByteBufferNano.readInt64();
            } else if (readTag == 34) {
                this.groupKey = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.expKey = codedInputByteBufferNano.readString();
            } else if (readTag == 50) {
                this.params = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.params, mapFactory, 9, 9, null, 10, 18);
            } else if (readTag == 56) {
                this.isDefault = codedInputByteBufferNano.readBool();
            } else if (readTag == 64) {
                this.isControl = codedInputByteBufferNano.readBool();
            } else if (readTag != 74) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.moduleCode = codedInputByteBufferNano.readString();
            }
        }
    }
}
