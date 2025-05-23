package com.tencent.mobileqq.dt.data;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile a[] f203761d;

    /* renamed from: a, reason: collision with root package name */
    public int f203762a;

    /* renamed from: b, reason: collision with root package name */
    public String f203763b;

    /* renamed from: c, reason: collision with root package name */
    public String f203764c;

    public a() {
        a();
    }

    public static a[] b() {
        if (f203761d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f203761d == null) {
                    f203761d = new a[0];
                }
            }
        }
        return f203761d;
    }

    public a a() {
        this.f203762a = 0;
        this.f203763b = "";
        this.f203764c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            this.f203764c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f203763b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f203762a = codedInputByteBufferNano.readUInt32();
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f203762a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f203763b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f203763b);
        }
        if (!this.f203764c.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f203764c);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f203762a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f203763b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f203763b);
        }
        if (!this.f203764c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f203764c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
