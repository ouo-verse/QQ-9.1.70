package com.tencent.state.square.api;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.state.square.SquareBase;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\b\u0010\u0012\u001a\u00020\u0001H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u0003H\u00d6\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/state/square/api/SquareTroopMessageRecord;", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "uin", "", "recordType", "Lcom/tencent/state/square/api/MessageRecordType;", "(Ljava/lang/String;Lcom/tencent/state/square/api/MessageRecordType;)V", "getRecordType", "()Lcom/tencent/state/square/api/MessageRecordType;", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "getSenderUin", "()Ljava/lang/String;", "setSenderUin", "(Ljava/lang/String;)V", "getUin", "component1", "component2", "copy", "copyDepth", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final /* data */ class SquareTroopMessageRecord extends SquareBaseMessageRecord {
    private static final ArrayList<MessageRecordType> supportType;

    @NotNull
    private final MessageRecordType recordType;

    @NotNull
    private String senderUin;

    @NotNull
    private final String uin;

    static {
        ArrayList<MessageRecordType> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(MessageRecordType.RECORD_TYPE_NONE, MessageRecordType.RECORD_TYPE_TROOP);
        supportType = arrayListOf;
    }

    public /* synthetic */ SquareTroopMessageRecord(String str, MessageRecordType messageRecordType, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? MessageRecordType.RECORD_TYPE_TROOP : messageRecordType);
    }

    public static /* synthetic */ SquareTroopMessageRecord copy$default(SquareTroopMessageRecord squareTroopMessageRecord, String str, MessageRecordType messageRecordType, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = squareTroopMessageRecord.getUin();
        }
        if ((i3 & 2) != 0) {
            messageRecordType = squareTroopMessageRecord.getRecordType();
        }
        return squareTroopMessageRecord.copy(str, messageRecordType);
    }

    @NotNull
    public final String component1() {
        return getUin();
    }

    @NotNull
    public final MessageRecordType component2() {
        return getRecordType();
    }

    @NotNull
    public final SquareTroopMessageRecord copy(@NotNull String uin, @NotNull MessageRecordType recordType) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(recordType, "recordType");
        return new SquareTroopMessageRecord(uin, recordType);
    }

    @Override // com.tencent.state.square.api.SquareBaseMessageRecord
    @NotNull
    public SquareBaseMessageRecord copyDepth() {
        SquareTroopMessageRecord squareTroopMessageRecord = new SquareTroopMessageRecord(getUin(), getRecordType());
        squareTroopMessageRecord.senderUin = this.senderUin;
        copyValue(squareTroopMessageRecord);
        return squareTroopMessageRecord;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof SquareTroopMessageRecord) {
                SquareTroopMessageRecord squareTroopMessageRecord = (SquareTroopMessageRecord) other;
                if (!Intrinsics.areEqual(getUin(), squareTroopMessageRecord.getUin()) || !Intrinsics.areEqual(getRecordType(), squareTroopMessageRecord.getRecordType())) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // com.tencent.state.square.api.SquareBaseMessageRecord
    @NotNull
    public MessageRecordType getRecordType() {
        return this.recordType;
    }

    @NotNull
    public final String getSenderUin() {
        return this.senderUin;
    }

    @Override // com.tencent.state.square.api.SquareBaseMessageRecord
    @NotNull
    public String getUin() {
        return this.uin;
    }

    public int hashCode() {
        int i3;
        String uin = getUin();
        int i16 = 0;
        if (uin != null) {
            i3 = uin.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        MessageRecordType recordType = getRecordType();
        if (recordType != null) {
            i16 = recordType.hashCode();
        }
        return i17 + i16;
    }

    public final void setSenderUin(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.senderUin = str;
    }

    @NotNull
    public String toString() {
        return "SquareTroopMessageRecord(uin=" + getUin() + ", recordType=" + getRecordType() + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareTroopMessageRecord(@NotNull String uin, @NotNull MessageRecordType recordType) {
        super(uin, recordType);
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(recordType, "recordType");
        this.uin = uin;
        this.recordType = recordType;
        this.senderUin = "";
        if (!supportType.contains(getRecordType()) && SquareBase.INSTANCE.getConfig().isDebug()) {
            throw new Throwable("unSupport troop type!");
        }
    }
}
