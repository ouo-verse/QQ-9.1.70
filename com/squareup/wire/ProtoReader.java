package com.squareup.wire;

import cooperation.qzone.QZoneHelper;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jf.dexlib2.analysis.RegisterType;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 /2\u00020\u0001:\u0001/B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J\b\u0010\u0017\u001a\u00020\tH\u0002J\u0006\u0010\u0018\u001a\u00020\tJ\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\tH\u0007J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\tJ%\u0010\u001d\u001a\u00020\u001c2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u001fH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\b J\b\u0010!\u001a\u00020\u000fH\u0002J\u0006\u0010\"\u001a\u00020\u000fJ\b\u0010#\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010$\u001a\u00020\u001cJ\u0006\u0010%\u001a\u00020\u000fJ\u0006\u0010&\u001a\u00020\tJ\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u000fJ\u0006\u0010*\u001a\u00020\u000fJ\u0006\u0010+\u001a\u00020\tJ\u0006\u0010,\u001a\u00020\u0013J\u0010\u0010-\u001a\u00020\u00132\u0006\u0010.\u001a\u00020\u000fH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u00060"}, d2 = {"Lcom/squareup/wire/ProtoReader;", "", "source", "Lokio/BufferedSource;", "(Lokio/BufferedSource;)V", "bufferStack", "", "Lokio/Buffer;", "limit", "", "nextFieldEncoding", "Lcom/squareup/wire/FieldEncoding;", com.tencent.luggage.wxa.c8.c.G, "pushedLimit", "recursionDepth", "", "state", "tag", "addUnknownField", "", "fieldEncoding", "value", "afterPackableScalar", "beforeLengthDelimitedScalar", "beginMessage", "endMessage", "token", "endMessageAndGetUnknownFields", "Lokio/ByteString;", "forEachTag", "tagHandler", "Lkotlin/Function1;", "-forEachTag", "internalReadVarint32", "nextTag", "peekFieldEncoding", "readBytes", "readFixed32", "readFixed64", "readString", "", "readUnknownField", "readVarint32", "readVarint64", "skip", "skipGroup", "expectedEndTag", "Companion", "wire-runtime"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class ProtoReader {
    private static final int FIELD_ENCODING_MASK = 7;
    private static final int RECURSION_LIMIT = 65;
    private static final int STATE_END_GROUP = 4;
    private static final int STATE_FIXED32 = 5;
    private static final int STATE_FIXED64 = 1;
    private static final int STATE_LENGTH_DELIMITED = 2;
    private static final int STATE_PACKED_TAG = 7;
    private static final int STATE_START_GROUP = 3;
    private static final int STATE_TAG = 6;
    private static final int STATE_VARINT = 0;
    public static final int TAG_FIELD_ENCODING_BITS = 3;
    private final List<Buffer> bufferStack;
    private long limit;
    private FieldEncoding nextFieldEncoding;
    private long pos;
    private long pushedLimit;
    private int recursionDepth;
    private final BufferedSource source;
    private int state;
    private int tag;

    public ProtoReader(@NotNull BufferedSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        this.limit = Long.MAX_VALUE;
        this.state = 2;
        this.tag = -1;
        this.pushedLimit = -1L;
        this.bufferStack = new ArrayList();
    }

    private final void afterPackableScalar(int fieldEncoding) throws IOException {
        if (this.state == fieldEncoding) {
            this.state = 6;
            return;
        }
        long j3 = this.pos;
        long j16 = this.limit;
        if (j3 <= j16) {
            if (j3 == j16) {
                this.limit = this.pushedLimit;
                this.pushedLimit = -1L;
                this.state = 6;
                return;
            }
            this.state = 7;
            return;
        }
        throw new IOException("Expected to end at " + this.limit + " but was " + this.pos);
    }

    private final long beforeLengthDelimitedScalar() throws IOException {
        if (this.state == 2) {
            long j3 = this.limit - this.pos;
            this.source.require(j3);
            this.state = 6;
            this.pos = this.limit;
            this.limit = this.pushedLimit;
            this.pushedLimit = -1L;
            return j3;
        }
        throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.state);
    }

    private final int internalReadVarint32() {
        int i3;
        this.source.require(1L);
        this.pos++;
        byte readByte = this.source.readByte();
        if (readByte >= 0) {
            return readByte;
        }
        int i16 = readByte & Byte.MAX_VALUE;
        this.source.require(1L);
        this.pos++;
        byte readByte2 = this.source.readByte();
        if (readByte2 >= 0) {
            i3 = readByte2 << 7;
        } else {
            i16 |= (readByte2 & Byte.MAX_VALUE) << 7;
            this.source.require(1L);
            this.pos++;
            byte readByte3 = this.source.readByte();
            if (readByte3 >= 0) {
                i3 = readByte3 << RegisterType.DOUBLE_LO;
            } else {
                i16 |= (readByte3 & Byte.MAX_VALUE) << 14;
                this.source.require(1L);
                this.pos++;
                byte readByte4 = this.source.readByte();
                if (readByte4 >= 0) {
                    i3 = readByte4 << QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER;
                } else {
                    int i17 = i16 | ((readByte4 & Byte.MAX_VALUE) << 21);
                    this.source.require(1L);
                    this.pos++;
                    byte readByte5 = this.source.readByte();
                    int i18 = i17 | (readByte5 << 28);
                    if (readByte5 < 0) {
                        for (int i19 = 0; i19 <= 4; i19++) {
                            this.source.require(1L);
                            this.pos++;
                            if (this.source.readByte() >= 0) {
                                return i18;
                            }
                        }
                        throw new ProtocolException("Malformed VARINT");
                    }
                    return i18;
                }
            }
        }
        return i16 | i3;
    }

    private final void skipGroup(int expectedEndTag) {
        while (this.pos < this.limit && !this.source.exhausted()) {
            int internalReadVarint32 = internalReadVarint32();
            if (internalReadVarint32 != 0) {
                int i3 = internalReadVarint32 >> 3;
                int i16 = internalReadVarint32 & 7;
                if (i16 != 0) {
                    if (i16 != 1) {
                        if (i16 != 2) {
                            if (i16 != 3) {
                                if (i16 != 4) {
                                    if (i16 == 5) {
                                        this.state = 5;
                                        readFixed32();
                                    } else {
                                        throw new ProtocolException("Unexpected field encoding: " + i16);
                                    }
                                } else if (i3 == expectedEndTag) {
                                    return;
                                } else {
                                    throw new ProtocolException("Unexpected end group");
                                }
                            } else {
                                skipGroup(i3);
                            }
                        } else {
                            long internalReadVarint322 = internalReadVarint32();
                            this.pos += internalReadVarint322;
                            this.source.skip(internalReadVarint322);
                        }
                    } else {
                        this.state = 1;
                        readFixed64();
                    }
                } else {
                    this.state = 0;
                    readVarint64();
                }
            } else {
                throw new ProtocolException("Unexpected tag 0");
            }
        }
        throw new EOFException();
    }

    @JvmName(name = "-forEachTag")
    @NotNull
    /* renamed from: -forEachTag, reason: not valid java name */
    public final ByteString m86forEachTag(@NotNull Function1<? super Integer, ? extends Object> tagHandler) {
        Intrinsics.checkNotNullParameter(tagHandler, "tagHandler");
        long beginMessage = beginMessage();
        while (true) {
            int nextTag = nextTag();
            if (nextTag == -1) {
                return endMessageAndGetUnknownFields(beginMessage);
            }
            tagHandler.invoke(Integer.valueOf(nextTag));
        }
    }

    public final void addUnknownField(int tag, @NotNull FieldEncoding fieldEncoding, @Nullable Object value) {
        Intrinsics.checkNotNullParameter(fieldEncoding, "fieldEncoding");
        ProtoWriter protoWriter = new ProtoWriter(this.bufferStack.get(this.recursionDepth - 1));
        ProtoAdapter<?> rawProtoAdapter = fieldEncoding.rawProtoAdapter();
        if (rawProtoAdapter != null) {
            rawProtoAdapter.encodeWithTag(protoWriter, tag, value);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
    }

    public final long beginMessage() throws IOException {
        boolean z16;
        if (this.state == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            int i3 = this.recursionDepth + 1;
            this.recursionDepth = i3;
            if (i3 <= 65) {
                if (i3 > this.bufferStack.size()) {
                    this.bufferStack.add(new Buffer());
                }
                long j3 = this.pushedLimit;
                this.pushedLimit = -1L;
                this.state = 6;
                return j3;
            }
            throw new IOException("Wire recursion limit exceeded");
        }
        throw new IllegalStateException("Unexpected call to beginMessage()".toString());
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "prefer endMessageAndGetUnknownFields()", replaceWith = @ReplaceWith(expression = "endMessageAndGetUnknownFields(token)", imports = {}))
    public final void endMessage(long token) throws IOException {
        endMessageAndGetUnknownFields(token);
    }

    @NotNull
    public final ByteString endMessageAndGetUnknownFields(long token) throws IOException {
        boolean z16;
        boolean z17 = true;
        if (this.state == 6) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            int i3 = this.recursionDepth - 1;
            this.recursionDepth = i3;
            if (i3 < 0 || this.pushedLimit != -1) {
                z17 = false;
            }
            if (z17) {
                if (this.pos != this.limit && i3 != 0) {
                    throw new IOException("Expected to end at " + this.limit + " but was " + this.pos);
                }
                this.limit = token;
                Buffer buffer = this.bufferStack.get(i3);
                if (buffer.size() > 0) {
                    return buffer.readByteString();
                }
                return ByteString.EMPTY;
            }
            throw new IllegalStateException("No corresponding call to beginMessage()".toString());
        }
        throw new IllegalStateException("Unexpected call to endMessage()".toString());
    }

    public final int nextTag() throws IOException {
        int i3 = this.state;
        if (i3 == 7) {
            this.state = 2;
            return this.tag;
        }
        if (i3 == 6) {
            while (this.pos < this.limit && !this.source.exhausted()) {
                int internalReadVarint32 = internalReadVarint32();
                if (internalReadVarint32 != 0) {
                    int i16 = internalReadVarint32 >> 3;
                    this.tag = i16;
                    int i17 = internalReadVarint32 & 7;
                    if (i17 != 0) {
                        if (i17 != 1) {
                            if (i17 != 2) {
                                if (i17 != 3) {
                                    if (i17 != 4) {
                                        if (i17 == 5) {
                                            this.nextFieldEncoding = FieldEncoding.FIXED32;
                                            this.state = 5;
                                            return i16;
                                        }
                                        throw new ProtocolException("Unexpected field encoding: " + i17);
                                    }
                                    throw new ProtocolException("Unexpected end group");
                                }
                                skipGroup(i16);
                            } else {
                                this.nextFieldEncoding = FieldEncoding.LENGTH_DELIMITED;
                                this.state = 2;
                                int internalReadVarint322 = internalReadVarint32();
                                if (internalReadVarint322 >= 0) {
                                    if (this.pushedLimit == -1) {
                                        long j3 = this.limit;
                                        this.pushedLimit = j3;
                                        long j16 = this.pos + internalReadVarint322;
                                        this.limit = j16;
                                        if (j16 <= j3) {
                                            return this.tag;
                                        }
                                        throw new EOFException();
                                    }
                                    throw new IllegalStateException();
                                }
                                throw new ProtocolException("Negative length: " + internalReadVarint322);
                            }
                        } else {
                            this.nextFieldEncoding = FieldEncoding.FIXED64;
                            this.state = 1;
                            return i16;
                        }
                    } else {
                        this.nextFieldEncoding = FieldEncoding.VARINT;
                        this.state = 0;
                        return i16;
                    }
                } else {
                    throw new ProtocolException("Unexpected tag 0");
                }
            }
            return -1;
        }
        throw new IllegalStateException("Unexpected call to nextTag()");
    }

    @Nullable
    /* renamed from: peekFieldEncoding, reason: from getter */
    public final FieldEncoding getNextFieldEncoding() {
        return this.nextFieldEncoding;
    }

    @NotNull
    public final ByteString readBytes() throws IOException {
        long beforeLengthDelimitedScalar = beforeLengthDelimitedScalar();
        this.source.require(beforeLengthDelimitedScalar);
        return this.source.readByteString(beforeLengthDelimitedScalar);
    }

    public final int readFixed32() throws IOException {
        int i3 = this.state;
        if (i3 != 5 && i3 != 2) {
            throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.state);
        }
        this.source.require(4L);
        this.pos += 4;
        int readIntLe = this.source.readIntLe();
        afterPackableScalar(5);
        return readIntLe;
    }

    public final long readFixed64() throws IOException {
        int i3 = this.state;
        if (i3 != 1 && i3 != 2) {
            throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.state);
        }
        this.source.require(8L);
        this.pos += 8;
        long readLongLe = this.source.readLongLe();
        afterPackableScalar(1);
        return readLongLe;
    }

    @NotNull
    public final String readString() throws IOException {
        long beforeLengthDelimitedScalar = beforeLengthDelimitedScalar();
        this.source.require(beforeLengthDelimitedScalar);
        return this.source.readUtf8(beforeLengthDelimitedScalar);
    }

    public final void readUnknownField(int tag) {
        FieldEncoding nextFieldEncoding = getNextFieldEncoding();
        Intrinsics.checkNotNull(nextFieldEncoding);
        addUnknownField(tag, nextFieldEncoding, nextFieldEncoding.rawProtoAdapter().decode(this));
    }

    public final int readVarint32() throws IOException {
        int i3 = this.state;
        if (i3 != 0 && i3 != 2) {
            throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.state);
        }
        int internalReadVarint32 = internalReadVarint32();
        afterPackableScalar(0);
        return internalReadVarint32;
    }

    public final long readVarint64() throws IOException {
        int i3 = this.state;
        if (i3 != 0 && i3 != 2) {
            throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.state);
        }
        long j3 = 0;
        for (int i16 = 0; i16 < 64; i16 += 7) {
            this.source.require(1L);
            this.pos++;
            j3 |= (r4 & Byte.MAX_VALUE) << i16;
            if ((this.source.readByte() & 128) == 0) {
                afterPackableScalar(0);
                return j3;
            }
        }
        throw new ProtocolException("WireInput encountered a malformed varint");
    }

    public final void skip() throws IOException {
        int i3 = this.state;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 5) {
                        readFixed32();
                        return;
                    }
                    throw new IllegalStateException("Unexpected call to skip()");
                }
                this.source.skip(beforeLengthDelimitedScalar());
                return;
            }
            readFixed64();
            return;
        }
        readVarint64();
    }
}
