package com.squareup.wire;

import com.tencent.mobileqq.transfile.dns.DomainData;
import cooperation.qzone.ShareElfFile;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\fJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nH\u0000\u00a2\u0006\u0002\b\u000eJ\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nJ\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/squareup/wire/ProtoWriter;", "", "sink", "Lokio/BufferedSink;", "(Lokio/BufferedSink;)V", "writeBytes", "", "value", "Lokio/ByteString;", "writeFixed32", "", "writeFixed64", "", "writeSignedVarint32", "writeSignedVarint32$wire_runtime", "writeString", "", "writeTag", "fieldNumber", "fieldEncoding", "Lcom/squareup/wire/FieldEncoding;", "writeVarint32", "writeVarint64", "Companion", "wire-runtime"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class ProtoWriter {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final BufferedSink sink;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0000\u00a2\u0006\u0002\b\u0006J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\bH\u0000\u00a2\u0006\u0002\b\tJ\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0000\u00a2\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\bH\u0000\u00a2\u0006\u0002\b\rJ\u0015\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0000\u00a2\u0006\u0002\b\u0010J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0015\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0000\u00a2\u0006\u0002\b\u0017J\u0015\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0000\u00a2\u0006\u0002\b\u0019J\u0015\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bH\u0000\u00a2\u0006\u0002\b\u001b\u00a8\u0006\u001c"}, d2 = {"Lcom/squareup/wire/ProtoWriter$Companion;", "", "()V", "decodeZigZag32", "", DomainData.DOMAIN_NAME, "decodeZigZag32$wire_runtime", "decodeZigZag64", "", "decodeZigZag64$wire_runtime", "encodeZigZag32", "encodeZigZag32$wire_runtime", "encodeZigZag64", "encodeZigZag64$wire_runtime", "int32Size", "value", "int32Size$wire_runtime", "makeTag", "fieldNumber", "fieldEncoding", "Lcom/squareup/wire/FieldEncoding;", "tagSize", "tag", "tagSize$wire_runtime", "varint32Size", "varint32Size$wire_runtime", "varint64Size", "varint64Size$wire_runtime", "wire-runtime"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int makeTag(int fieldNumber, FieldEncoding fieldEncoding) {
            return (fieldNumber << 3) | fieldEncoding.getValue();
        }

        public final int decodeZigZag32$wire_runtime(int n3) {
            return (-(n3 & 1)) ^ (n3 >>> 1);
        }

        public final long decodeZigZag64$wire_runtime(long n3) {
            return (-(n3 & 1)) ^ (n3 >>> 1);
        }

        public final int encodeZigZag32$wire_runtime(int n3) {
            return (n3 >> 31) ^ (n3 << 1);
        }

        public final long encodeZigZag64$wire_runtime(long n3) {
            return (n3 >> 63) ^ (n3 << 1);
        }

        public final int int32Size$wire_runtime(int value) {
            if (value >= 0) {
                return varint32Size$wire_runtime(value);
            }
            return 10;
        }

        public final int tagSize$wire_runtime(int tag) {
            return varint32Size$wire_runtime(makeTag(tag, FieldEncoding.VARINT));
        }

        public final int varint32Size$wire_runtime(int value) {
            if ((value & (-128)) == 0) {
                return 1;
            }
            if ((value & (-16384)) == 0) {
                return 2;
            }
            if (((-2097152) & value) == 0) {
                return 3;
            }
            if ((value & ShareElfFile.SectionHeader.SHF_MASKPROC) == 0) {
                return 4;
            }
            return 5;
        }

        public final int varint64Size$wire_runtime(long value) {
            if (((-128) & value) == 0) {
                return 1;
            }
            if (((-16384) & value) == 0) {
                return 2;
            }
            if (((-2097152) & value) == 0) {
                return 3;
            }
            if (((-268435456) & value) == 0) {
                return 4;
            }
            if (((-34359738368L) & value) == 0) {
                return 5;
            }
            if (((-4398046511104L) & value) == 0) {
                return 6;
            }
            if (((-562949953421312L) & value) == 0) {
                return 7;
            }
            if (((-72057594037927936L) & value) == 0) {
                return 8;
            }
            if ((value & Long.MIN_VALUE) == 0) {
                return 9;
            }
            return 10;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ProtoWriter(@NotNull BufferedSink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.sink = sink;
    }

    public final void writeBytes(@NotNull ByteString value) throws IOException {
        Intrinsics.checkNotNullParameter(value, "value");
        this.sink.write(value);
    }

    public final void writeFixed32(int value) throws IOException {
        this.sink.writeIntLe(value);
    }

    public final void writeFixed64(long value) throws IOException {
        this.sink.writeLongLe(value);
    }

    public final void writeSignedVarint32$wire_runtime(int value) throws IOException {
        if (value >= 0) {
            writeVarint32(value);
        } else {
            writeVarint64(value);
        }
    }

    public final void writeString(@NotNull String value) throws IOException {
        Intrinsics.checkNotNullParameter(value, "value");
        this.sink.writeUtf8(value);
    }

    public final void writeTag(int fieldNumber, @NotNull FieldEncoding fieldEncoding) throws IOException {
        Intrinsics.checkNotNullParameter(fieldEncoding, "fieldEncoding");
        writeVarint32(INSTANCE.makeTag(fieldNumber, fieldEncoding));
    }

    public final void writeVarint32(int value) throws IOException {
        while ((value & (-128)) != 0) {
            this.sink.writeByte((value & 127) | 128);
            value >>>= 7;
        }
        this.sink.writeByte(value);
    }

    public final void writeVarint64(long value) throws IOException {
        while (((-128) & value) != 0) {
            this.sink.writeByte((((int) value) & 127) | 128);
            value >>>= 7;
        }
        this.sink.writeByte((int) value);
    }
}
