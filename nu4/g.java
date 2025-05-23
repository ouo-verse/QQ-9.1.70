package nu4;

import com.google.gson.annotations.SerializedName;
import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: a, reason: collision with root package name */
    private static volatile g[] f421360a;

    @SerializedName("defaultUrl")
    public String defaultUrl;

    @SerializedName("event")
    public c event;

    @SerializedName("gender")
    public int gender;

    /* renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    public int f421361id;

    @SerializedName("inBoundsClipper")
    public b inBoundsClipper;

    @SerializedName("inBoundsId")
    public int inBoundsId;

    @SerializedName("maskRate")
    public float maskRate;

    @SerializedName("name")
    public String name;

    @SerializedName("outBoundsClipper")
    public b outBoundsClipper;

    @SerializedName("sortWeight")
    public int sortWeight;

    public g() {
        a();
    }

    public static g[] b() {
        if (f421360a == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f421360a == null) {
                    f421360a = new g[0];
                }
            }
        }
        return f421360a;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f421361id = codedInputByteBufferNano.readInt32();
                    break;
                case 18:
                    this.name = codedInputByteBufferNano.readString();
                    break;
                case 24:
                    this.gender = codedInputByteBufferNano.readInt32();
                    break;
                case 34:
                    this.defaultUrl = codedInputByteBufferNano.readString();
                    break;
                case 45:
                    this.maskRate = codedInputByteBufferNano.readFloat();
                    break;
                case 50:
                    if (this.inBoundsClipper == null) {
                        this.inBoundsClipper = new b();
                    }
                    codedInputByteBufferNano.readMessage(this.inBoundsClipper);
                    break;
                case 58:
                    if (this.outBoundsClipper == null) {
                        this.outBoundsClipper = new b();
                    }
                    codedInputByteBufferNano.readMessage(this.outBoundsClipper);
                    break;
                case 66:
                    if (this.event == null) {
                        this.event = new c();
                    }
                    codedInputByteBufferNano.readMessage(this.event);
                    break;
                case 72:
                    this.inBoundsId = codedInputByteBufferNano.readInt32();
                    break;
                case 80:
                    this.sortWeight = codedInputByteBufferNano.readInt32();
                    break;
                default:
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f421361id;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.name.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.name);
        }
        int i16 = this.gender;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i16);
        }
        if (!this.defaultUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.defaultUrl);
        }
        if (Float.floatToIntBits(this.maskRate) != Float.floatToIntBits(0.0f)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(5, this.maskRate);
        }
        b bVar = this.inBoundsClipper;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, bVar);
        }
        b bVar2 = this.outBoundsClipper;
        if (bVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, bVar2);
        }
        c cVar = this.event;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, cVar);
        }
        int i17 = this.inBoundsId;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, i17);
        }
        int i18 = this.sortWeight;
        return i18 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(10, i18) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f421361id;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.name.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.name);
        }
        int i16 = this.gender;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i16);
        }
        if (!this.defaultUrl.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.defaultUrl);
        }
        if (Float.floatToIntBits(this.maskRate) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(5, this.maskRate);
        }
        b bVar = this.inBoundsClipper;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(6, bVar);
        }
        b bVar2 = this.outBoundsClipper;
        if (bVar2 != null) {
            codedOutputByteBufferNano.writeMessage(7, bVar2);
        }
        c cVar = this.event;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(8, cVar);
        }
        int i17 = this.inBoundsId;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(9, i17);
        }
        int i18 = this.sortWeight;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(10, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public g a() {
        this.f421361id = 0;
        this.name = "";
        this.gender = 0;
        this.defaultUrl = "";
        this.maskRate = 0.0f;
        this.inBoundsClipper = null;
        this.outBoundsClipper = null;
        this.event = null;
        this.inBoundsId = 0;
        this.sortWeight = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
