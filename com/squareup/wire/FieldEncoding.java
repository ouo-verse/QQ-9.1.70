package com.squareup.wire;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\u000e"}, d2 = {"Lcom/squareup/wire/FieldEncoding;", "", "value", "", "(Ljava/lang/String;II)V", "getValue$wire_runtime", "()I", "rawProtoAdapter", "Lcom/squareup/wire/ProtoAdapter;", "VARINT", "FIXED64", "LENGTH_DELIMITED", "FIXED32", "Companion", "wire-runtime"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public enum FieldEncoding {
    VARINT(0),
    FIXED64(1),
    LENGTH_DELIMITED(2),
    FIXED32(5);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0081\u0002\u00a2\u0006\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/squareup/wire/FieldEncoding$Companion;", "", "()V", "get", "Lcom/squareup/wire/FieldEncoding;", "value", "", "get$wire_runtime", "wire-runtime"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class Companion {
        Companion() {
        }

        @JvmStatic
        @NotNull
        public final FieldEncoding get$wire_runtime(int value) throws IOException {
            if (value != 0) {
                if (value != 1) {
                    if (value != 2) {
                        if (value == 5) {
                            return FieldEncoding.FIXED32;
                        }
                        throw new ProtocolException("Unexpected FieldEncoding: " + value);
                    }
                    return FieldEncoding.LENGTH_DELIMITED;
                }
                return FieldEncoding.FIXED64;
            }
            return FieldEncoding.VARINT;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FieldEncoding.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[FieldEncoding.VARINT.ordinal()] = 1;
            iArr[FieldEncoding.FIXED32.ordinal()] = 2;
            iArr[FieldEncoding.FIXED64.ordinal()] = 3;
            iArr[FieldEncoding.LENGTH_DELIMITED.ordinal()] = 4;
        }
    }

    FieldEncoding(int i3) {
        this.value = i3;
    }

    /* renamed from: getValue$wire_runtime, reason: from getter */
    public final int getValue() {
        return this.value;
    }

    @NotNull
    public final ProtoAdapter<?> rawProtoAdapter() {
        int i3 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        return ProtoAdapter.BYTES;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return ProtoAdapter.FIXED64;
            }
            return ProtoAdapter.FIXED32;
        }
        return ProtoAdapter.UINT64;
    }
}
