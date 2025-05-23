package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class ActivityInfos extends ExtendableMessageNano<ActivityInfos> {
    private static volatile ActivityInfos[] _emptyArray;
    public ActivityInfo consumerActivityInfo;
    public ActivityInfo newUserActivityInfo;

    public ActivityInfos() {
        clear();
    }

    public static ActivityInfos[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ActivityInfos[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ActivityInfos parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ActivityInfos) MessageNano.mergeFrom(new ActivityInfos(), bArr);
    }

    public ActivityInfos clear() {
        this.newUserActivityInfo = null;
        this.consumerActivityInfo = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        ActivityInfo activityInfo = this.newUserActivityInfo;
        if (activityInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, activityInfo);
        }
        ActivityInfo activityInfo2 = this.consumerActivityInfo;
        if (activityInfo2 != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, activityInfo2);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        ActivityInfo activityInfo = this.newUserActivityInfo;
        if (activityInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, activityInfo);
        }
        ActivityInfo activityInfo2 = this.consumerActivityInfo;
        if (activityInfo2 != null) {
            codedOutputByteBufferNano.writeMessage(2, activityInfo2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ActivityInfos parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ActivityInfos().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ActivityInfos mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.newUserActivityInfo == null) {
                    this.newUserActivityInfo = new ActivityInfo();
                }
                codedInputByteBufferNano.readMessage(this.newUserActivityInfo);
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.consumerActivityInfo == null) {
                    this.consumerActivityInfo = new ActivityInfo();
                }
                codedInputByteBufferNano.readMessage(this.consumerActivityInfo);
            }
        }
    }
}
