package com.tencent.qqnt.qwallet.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.tencent.mobileqq.app.AppConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Entity(tableName = "hb_command_table")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0019\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u0012\u0006\u0010\u0017\u001a\u00020\u0011\u0012\u0006\u0010\u001a\u001a\u00020\u0011\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u0012\u0006\u0010\"\u001a\u00020\u0004\u0012\u0006\u0010#\u001a\u00020\u0004\u0012\u0006\u0010$\u001a\u00020\u0004\u0012\u0006\u0010&\u001a\u00020\u0004\u0012\u0006\u0010'\u001a\u00020\u0004\u00a2\u0006\u0004\b(\u0010)J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0017\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014R\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u001f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\u000e\u0010\u001eR\u0017\u0010\"\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b \u0010\u001d\u001a\u0004\b!\u0010\u001eR\u0017\u0010#\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001d\u001a\u0004\b \u0010\u001eR\u0017\u0010$\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\u0018\u0010\u001eR\u0017\u0010&\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u001d\u001a\u0004\b%\u0010\u001eR\u0017\u0010'\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u001d\u001a\u0004\b\u001b\u0010\u001e\u00a8\u0006*"}, d2 = {"Lcom/tencent/qqnt/qwallet/db/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "listId", "b", "c", "command", "", "J", "d", "()J", "expireTime", "l", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "e", "i", "peerUin", "f", "authKey", "I", "()I", "chatType", tl.h.F, "j", "redChannel", "payFlag", "hbFlag", "k", "resourceType", "hbFrom", "<init>", "(Ljava/lang/String;Ljava/lang/String;JJJLjava/lang/String;IIIIII)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.qqnt.qwallet.db.c, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class HbCommandEntity {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @PrimaryKey
    @NotNull
    private final String listId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String command;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long expireTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final long senderUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final long peerUin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String authKey;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final int chatType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final int redChannel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final int payFlag;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private final int hbFlag;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private final int resourceType;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private final int hbFrom;

    public HbCommandEntity(@NotNull String listId, @NotNull String command, long j3, long j16, long j17, @NotNull String authKey, int i3, int i16, int i17, int i18, int i19, int i26) {
        Intrinsics.checkNotNullParameter(listId, "listId");
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(authKey, "authKey");
        this.listId = listId;
        this.command = command;
        this.expireTime = j3;
        this.senderUin = j16;
        this.peerUin = j17;
        this.authKey = authKey;
        this.chatType = i3;
        this.redChannel = i16;
        this.payFlag = i17;
        this.hbFlag = i18;
        this.resourceType = i19;
        this.hbFrom = i26;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAuthKey() {
        return this.authKey;
    }

    /* renamed from: b, reason: from getter */
    public final int getChatType() {
        return this.chatType;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getCommand() {
        return this.command;
    }

    /* renamed from: d, reason: from getter */
    public final long getExpireTime() {
        return this.expireTime;
    }

    /* renamed from: e, reason: from getter */
    public final int getHbFlag() {
        return this.hbFlag;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HbCommandEntity)) {
            return false;
        }
        HbCommandEntity hbCommandEntity = (HbCommandEntity) other;
        if (Intrinsics.areEqual(this.listId, hbCommandEntity.listId) && Intrinsics.areEqual(this.command, hbCommandEntity.command) && this.expireTime == hbCommandEntity.expireTime && this.senderUin == hbCommandEntity.senderUin && this.peerUin == hbCommandEntity.peerUin && Intrinsics.areEqual(this.authKey, hbCommandEntity.authKey) && this.chatType == hbCommandEntity.chatType && this.redChannel == hbCommandEntity.redChannel && this.payFlag == hbCommandEntity.payFlag && this.hbFlag == hbCommandEntity.hbFlag && this.resourceType == hbCommandEntity.resourceType && this.hbFrom == hbCommandEntity.hbFrom) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getHbFrom() {
        return this.hbFrom;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getListId() {
        return this.listId;
    }

    /* renamed from: h, reason: from getter */
    public final int getPayFlag() {
        return this.payFlag;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.listId.hashCode() * 31) + this.command.hashCode()) * 31) + androidx.fragment.app.a.a(this.expireTime)) * 31) + androidx.fragment.app.a.a(this.senderUin)) * 31) + androidx.fragment.app.a.a(this.peerUin)) * 31) + this.authKey.hashCode()) * 31) + this.chatType) * 31) + this.redChannel) * 31) + this.payFlag) * 31) + this.hbFlag) * 31) + this.resourceType) * 31) + this.hbFrom;
    }

    /* renamed from: i, reason: from getter */
    public final long getPeerUin() {
        return this.peerUin;
    }

    /* renamed from: j, reason: from getter */
    public final int getRedChannel() {
        return this.redChannel;
    }

    /* renamed from: k, reason: from getter */
    public final int getResourceType() {
        return this.resourceType;
    }

    /* renamed from: l, reason: from getter */
    public final long getSenderUin() {
        return this.senderUin;
    }

    @NotNull
    public String toString() {
        return "HbCommandEntity(listId=" + this.listId + ", command=" + this.command + ", expireTime=" + this.expireTime + ", senderUin=" + this.senderUin + ", peerUin=" + this.peerUin + ", authKey=" + this.authKey + ", chatType=" + this.chatType + ", redChannel=" + this.redChannel + ", payFlag=" + this.payFlag + ", hbFlag=" + this.hbFlag + ", resourceType=" + this.resourceType + ", hbFrom=" + this.hbFrom + ")";
    }
}
