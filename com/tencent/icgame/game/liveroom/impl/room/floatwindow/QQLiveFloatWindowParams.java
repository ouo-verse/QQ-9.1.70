package com.tencent.icgame.game.liveroom.impl.room.floatwindow;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u001a\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0015\u001a\u0004\b\u000f\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\n\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/floatwindow/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "d", "()J", "roomId", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "roomCoverUrl", "Landroid/content/Intent;", "Landroid/content/Intent;", "()Landroid/content/Intent;", "resumeIntent", "Z", "()Z", "playerMute", "<init>", "(JLjava/lang/String;Landroid/content/Intent;Z)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.icgame.game.liveroom.impl.room.floatwindow.i, reason: from toString */
/* loaded from: classes7.dex */
public final /* data */ class QQLiveFloatWindowParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long roomId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String roomCoverUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Intent resumeIntent;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean playerMute;

    public QQLiveFloatWindowParams(long j3, @Nullable String str, @Nullable Intent intent, boolean z16) {
        this.roomId = j3;
        this.roomCoverUrl = str;
        this.resumeIntent = intent;
        this.playerMute = z16;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getPlayerMute() {
        return this.playerMute;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final Intent getResumeIntent() {
        return this.resumeIntent;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getRoomCoverUrl() {
        return this.roomCoverUrl;
    }

    /* renamed from: d, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QQLiveFloatWindowParams)) {
            return false;
        }
        QQLiveFloatWindowParams qQLiveFloatWindowParams = (QQLiveFloatWindowParams) other;
        if (this.roomId == qQLiveFloatWindowParams.roomId && Intrinsics.areEqual(this.roomCoverUrl, qQLiveFloatWindowParams.roomCoverUrl) && Intrinsics.areEqual(this.resumeIntent, qQLiveFloatWindowParams.resumeIntent) && this.playerMute == qQLiveFloatWindowParams.playerMute) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int a16 = androidx.fragment.app.a.a(this.roomId) * 31;
        String str = this.roomCoverUrl;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (a16 + hashCode) * 31;
        Intent intent = this.resumeIntent;
        if (intent != null) {
            i3 = intent.hashCode();
        }
        int i17 = (i16 + i3) * 31;
        boolean z16 = this.playerMute;
        int i18 = z16;
        if (z16 != 0) {
            i18 = 1;
        }
        return i17 + i18;
    }

    @NotNull
    public String toString() {
        return "QQLiveFloatWindowParams(roomId=" + this.roomId + ", roomCoverUrl=" + this.roomCoverUrl + ", resumeIntent=" + this.resumeIntent + ", playerMute=" + this.playerMute + ")";
    }
}
