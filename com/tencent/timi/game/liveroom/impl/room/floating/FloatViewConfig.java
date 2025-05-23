package com.tencent.timi.game.liveroom.impl.room.floating;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0012\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/floating/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "isAnchor", "Landroid/content/Intent;", "Landroid/content/Intent;", "()Landroid/content/Intent;", "resumeIntent", "c", "isGameLive", "<init>", "(ZLandroid/content/Intent;Z)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.timi.game.liveroom.impl.room.floating.a, reason: from toString */
/* loaded from: classes26.dex */
public final /* data */ class FloatViewConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isAnchor;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Intent resumeIntent;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isGameLive;

    @JvmOverloads
    public FloatViewConfig(boolean z16, @Nullable Intent intent) {
        this(z16, intent, false, 4, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Intent getResumeIntent() {
        return this.resumeIntent;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsAnchor() {
        return this.isAnchor;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsGameLive() {
        return this.isGameLive;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FloatViewConfig)) {
            return false;
        }
        FloatViewConfig floatViewConfig = (FloatViewConfig) other;
        if (this.isAnchor == floatViewConfig.isAnchor && Intrinsics.areEqual(this.resumeIntent, floatViewConfig.resumeIntent) && this.isGameLive == floatViewConfig.isGameLive) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        int hashCode;
        boolean z16 = this.isAnchor;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        Intent intent = this.resumeIntent;
        if (intent == null) {
            hashCode = 0;
        } else {
            hashCode = intent.hashCode();
        }
        int i17 = (i16 + hashCode) * 31;
        boolean z17 = this.isGameLive;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return i17 + i3;
    }

    @NotNull
    public String toString() {
        return "FloatViewConfig(isAnchor=" + this.isAnchor + ", resumeIntent=" + this.resumeIntent + ", isGameLive=" + this.isGameLive + ")";
    }

    @JvmOverloads
    public FloatViewConfig(boolean z16, @Nullable Intent intent, boolean z17) {
        this.isAnchor = z16;
        this.resumeIntent = intent;
        this.isGameLive = z17;
    }

    public /* synthetic */ FloatViewConfig(boolean z16, Intent intent, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, intent, (i3 & 4) != 0 ? false : z17);
    }
}
