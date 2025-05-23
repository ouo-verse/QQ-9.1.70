package nu4;

import com.google.gson.annotations.SerializedName;
import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b extends ExtendableMessageNano<b> {

    @SerializedName("height")
    public float height;

    @SerializedName("width")
    public float width;

    /* renamed from: x, reason: collision with root package name */
    @SerializedName(HippyTKDListViewAdapter.X)
    public float f421349x;

    /* renamed from: y, reason: collision with root package name */
    @SerializedName("y")
    public float f421350y;

    public b() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 13) {
                this.f421349x = codedInputByteBufferNano.readFloat();
            } else if (readTag == 21) {
                this.f421350y = codedInputByteBufferNano.readFloat();
            } else if (readTag == 29) {
                this.width = codedInputByteBufferNano.readFloat();
            } else if (readTag != 37) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.height = codedInputByteBufferNano.readFloat();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (Float.floatToIntBits(this.f421349x) != Float.floatToIntBits(0.0f)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(1, this.f421349x);
        }
        if (Float.floatToIntBits(this.f421350y) != Float.floatToIntBits(0.0f)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(2, this.f421350y);
        }
        if (Float.floatToIntBits(this.width) != Float.floatToIntBits(0.0f)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(3, this.width);
        }
        return Float.floatToIntBits(this.height) != Float.floatToIntBits(0.0f) ? computeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(4, this.height) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (Float.floatToIntBits(this.f421349x) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(1, this.f421349x);
        }
        if (Float.floatToIntBits(this.f421350y) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(2, this.f421350y);
        }
        if (Float.floatToIntBits(this.width) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(3, this.width);
        }
        if (Float.floatToIntBits(this.height) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(4, this.height);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public b a() {
        this.f421349x = 0.0f;
        this.f421350y = 0.0f;
        this.width = 0.0f;
        this.height = 0.0f;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
