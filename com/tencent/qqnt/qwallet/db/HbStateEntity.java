package com.tencent.qqnt.qwallet.db;

import androidx.room.Entity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Entity(primaryKeys = {"listId", "toUin"}, tableName = "hb_state_table")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\t\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017R\u0017\u0010\u001a\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u0011\u0010\u0017R\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u0019\u0010\f\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/qwallet/db/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "listId", "f", "toUin", "", "c", "J", "()J", "expireTime", "d", "I", "()I", "state", "e", "sendState", "text", "<init>", "(Ljava/lang/String;Ljava/lang/String;JIILjava/lang/String;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.qqnt.qwallet.db.f, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class HbStateEntity {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String listId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String toUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long expireTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int state;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int sendState;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String text;

    public HbStateEntity(@NotNull String listId, @NotNull String toUin, long j3, int i3, int i16, @NotNull String text) {
        Intrinsics.checkNotNullParameter(listId, "listId");
        Intrinsics.checkNotNullParameter(toUin, "toUin");
        Intrinsics.checkNotNullParameter(text, "text");
        this.listId = listId;
        this.toUin = toUin;
        this.expireTime = j3;
        this.state = i3;
        this.sendState = i16;
        this.text = text;
    }

    /* renamed from: a, reason: from getter */
    public final long getExpireTime() {
        return this.expireTime;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getListId() {
        return this.listId;
    }

    /* renamed from: c, reason: from getter */
    public final int getSendState() {
        return this.sendState;
    }

    /* renamed from: d, reason: from getter */
    public final int getState() {
        return this.state;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HbStateEntity)) {
            return false;
        }
        HbStateEntity hbStateEntity = (HbStateEntity) other;
        if (Intrinsics.areEqual(this.listId, hbStateEntity.listId) && Intrinsics.areEqual(this.toUin, hbStateEntity.toUin) && this.expireTime == hbStateEntity.expireTime && this.state == hbStateEntity.state && this.sendState == hbStateEntity.sendState && Intrinsics.areEqual(this.text, hbStateEntity.text)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getToUin() {
        return this.toUin;
    }

    public int hashCode() {
        return (((((((((this.listId.hashCode() * 31) + this.toUin.hashCode()) * 31) + androidx.fragment.app.a.a(this.expireTime)) * 31) + this.state) * 31) + this.sendState) * 31) + this.text.hashCode();
    }

    @NotNull
    public String toString() {
        return "HbStateEntity(listId=" + this.listId + ", toUin=" + this.toUin + ", expireTime=" + this.expireTime + ", state=" + this.state + ", sendState=" + this.sendState + ", text=" + this.text + ")";
    }
}
