package com.tencent.mobileqq.guild.media.core.data;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0000H\u0016J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0000J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\"\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u001b\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/data/m;", "", "", "a", "b", TtmlNode.ATTR_TTS_ORIGIN, "c", "", "other", "", "equals", "", "hashCode", "", "toString", "d", "I", "()I", "f", "(I)V", "userAVState", "Lcom/tencent/mobileqq/guild/media/core/data/o;", "e", "Lcom/tencent/mobileqq/guild/media/core/data/o;", "()Lcom/tencent/mobileqq/guild/media/core/data/o;", "setUserDevState", "(Lcom/tencent/mobileqq/guild/media/core/data/o;)V", "userDevState", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.media.core.data.m, reason: from toString */
/* loaded from: classes14.dex */
public final class UserAVInfo implements Cloneable {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int userAVState;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private o userDevState = new o();

    public final void a() {
        this.userAVState = 0;
        this.userDevState.a();
    }

    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public UserAVInfo clone() {
        Object clone = super.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.core.data.UserAVInfo");
        UserAVInfo userAVInfo = (UserAVInfo) clone;
        userAVInfo.userDevState = this.userDevState.clone();
        return userAVInfo;
    }

    public final void c(@NotNull UserAVInfo origin) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        this.userAVState = origin.userAVState;
        this.userDevState.c(origin.userDevState);
    }

    /* renamed from: d, reason: from getter */
    public final int getUserAVState() {
        return this.userAVState;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final o getUserDevState() {
        return this.userDevState;
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(UserAVInfo.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.core.data.UserAVInfo");
        UserAVInfo userAVInfo = (UserAVInfo) other;
        if (this.userAVState == userAVInfo.userAVState && Intrinsics.areEqual(this.userDevState, userAVInfo.userDevState)) {
            return true;
        }
        return false;
    }

    public final void f(int i3) {
        this.userAVState = i3;
    }

    public int hashCode() {
        return (this.userAVState * 31) + this.userDevState.hashCode();
    }

    @NotNull
    public String toString() {
        return "UserAVInfo(userAVState=" + this.userAVState + ", userDevState=" + this.userDevState + ")";
    }
}
