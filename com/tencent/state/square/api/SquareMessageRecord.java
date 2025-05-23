package com.tencent.state.square.api;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.state.square.SquareBase;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\b\u0010\u0017\u001a\u00020\u0001H\u0016J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006 "}, d2 = {"Lcom/tencent/state/square/api/SquareMessageRecord;", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "uin", "", "recordType", "Lcom/tencent/state/square/api/MessageRecordType;", "(Ljava/lang/String;Lcom/tencent/state/square/api/MessageRecordType;)V", "lastMsgType", "Lcom/tencent/state/square/api/MsgType;", "getLastMsgType", "()Lcom/tencent/state/square/api/MsgType;", "setLastMsgType", "(Lcom/tencent/state/square/api/MsgType;)V", QQBrowserActivity.KEY_MSG_TYPE, "getMsgType", "setMsgType", "getRecordType", "()Lcom/tencent/state/square/api/MessageRecordType;", "getUin", "()Ljava/lang/String;", "component1", "component2", "copy", "copyDepth", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final /* data */ class SquareMessageRecord extends SquareBaseMessageRecord {
    private static final ArrayList<MessageRecordType> supportType;

    @NotNull
    private MsgType lastMsgType;

    @NotNull
    private MsgType msgType;

    @NotNull
    private final MessageRecordType recordType;

    @NotNull
    private final String uin;

    static {
        ArrayList<MessageRecordType> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(MessageRecordType.RECORD_TYPE_NONE, MessageRecordType.RECORD_TYPE_FRIEND, MessageRecordType.RECORD_TYPE_SQUARE_TEMP);
        supportType = arrayListOf;
    }

    public /* synthetic */ SquareMessageRecord(String str, MessageRecordType messageRecordType, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? MessageRecordType.RECORD_TYPE_FRIEND : messageRecordType);
    }

    public static /* synthetic */ SquareMessageRecord copy$default(SquareMessageRecord squareMessageRecord, String str, MessageRecordType messageRecordType, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = squareMessageRecord.getUin();
        }
        if ((i3 & 2) != 0) {
            messageRecordType = squareMessageRecord.getRecordType();
        }
        return squareMessageRecord.copy(str, messageRecordType);
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
    public final SquareMessageRecord copy(@NotNull String uin, @NotNull MessageRecordType recordType) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(recordType, "recordType");
        return new SquareMessageRecord(uin, recordType);
    }

    @Override // com.tencent.state.square.api.SquareBaseMessageRecord
    @NotNull
    public SquareBaseMessageRecord copyDepth() {
        SquareMessageRecord squareMessageRecord = new SquareMessageRecord(getUin(), getRecordType());
        squareMessageRecord.lastMsgType = this.lastMsgType;
        squareMessageRecord.msgType = this.msgType;
        copyValue(squareMessageRecord);
        return squareMessageRecord;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof SquareMessageRecord) {
                SquareMessageRecord squareMessageRecord = (SquareMessageRecord) other;
                if (!Intrinsics.areEqual(getUin(), squareMessageRecord.getUin()) || !Intrinsics.areEqual(getRecordType(), squareMessageRecord.getRecordType())) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final MsgType getLastMsgType() {
        return this.lastMsgType;
    }

    @NotNull
    public final MsgType getMsgType() {
        return this.msgType;
    }

    @Override // com.tencent.state.square.api.SquareBaseMessageRecord
    @NotNull
    public MessageRecordType getRecordType() {
        return this.recordType;
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

    public final void setLastMsgType(@NotNull MsgType msgType) {
        Intrinsics.checkNotNullParameter(msgType, "<set-?>");
        this.lastMsgType = msgType;
    }

    public final void setMsgType(@NotNull MsgType msgType) {
        Intrinsics.checkNotNullParameter(msgType, "<set-?>");
        this.msgType = msgType;
    }

    @NotNull
    public String toString() {
        return "SquareMessageRecord(uin=" + getUin() + ", recordType=" + getRecordType() + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareMessageRecord(@NotNull String uin, @NotNull MessageRecordType recordType) {
        super(uin, recordType);
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(recordType, "recordType");
        this.uin = uin;
        this.recordType = recordType;
        MsgType msgType = MsgType.TEXT;
        this.lastMsgType = msgType;
        this.msgType = msgType;
        if (!supportType.contains(getRecordType()) && SquareBase.INSTANCE.getConfig().isDebug()) {
            throw new Throwable("unSupport msg type!");
        }
    }
}
