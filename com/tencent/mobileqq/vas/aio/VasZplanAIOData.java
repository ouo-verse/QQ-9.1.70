package com.tencent.mobileqq.vas.aio;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010+\u00a2\u0006\u0004\b2\u00103J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0019\u001a\u0004\b\t\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010$\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010*\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010&\u001a\u0004\b\u0011\u0010'\"\u0004\b(\u0010)R$\u00101\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b,\u0010.\"\u0004\b/\u00100\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/vas/aio/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "d", "()I", "setConfigType", "(I)V", "configType", "Lcom/tencent/mobileqq/vas/aio/h;", "b", "Lcom/tencent/mobileqq/vas/aio/h;", "c", "()Lcom/tencent/mobileqq/vas/aio/h;", "i", "(Lcom/tencent/mobileqq/vas/aio/h;)V", "bubble", "Lcom/tencent/mobileqq/vas/aio/e;", "Lcom/tencent/mobileqq/vas/aio/e;", "()Lcom/tencent/mobileqq/vas/aio/e;", "g", "(Lcom/tencent/mobileqq/vas/aio/e;)V", "advIcon", "Lcom/tencent/mobileqq/vas/aio/i;", "Lcom/tencent/mobileqq/vas/aio/i;", "e", "()Lcom/tencent/mobileqq/vas/aio/i;", "j", "(Lcom/tencent/mobileqq/vas/aio/i;)V", "cycleIcon", "Lcom/tencent/mobileqq/vas/aio/g;", "Lcom/tencent/mobileqq/vas/aio/g;", "()Lcom/tencent/mobileqq/vas/aio/g;", tl.h.F, "(Lcom/tencent/mobileqq/vas/aio/g;)V", "avatarInfo", "Lcom/tencent/mobileqq/vas/aio/k;", "f", "Lcom/tencent/mobileqq/vas/aio/k;", "()Lcom/tencent/mobileqq/vas/aio/k;", "k", "(Lcom/tencent/mobileqq/vas/aio/k;)V", "info", "<init>", "(ILcom/tencent/mobileqq/vas/aio/h;Lcom/tencent/mobileqq/vas/aio/e;Lcom/tencent/mobileqq/vas/aio/i;Lcom/tencent/mobileqq/vas/aio/g;Lcom/tencent/mobileqq/vas/aio/k;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.vas.aio.c, reason: from toString */
/* loaded from: classes20.dex */
public final /* data */ class VasZplanAIOData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int configType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private VasZplanBubble bubble;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private VasZplanAdvIcon advIcon;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private VasZplanCycleIcon cycleIcon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private VasZplanAvatarInfo avatarInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private VasZplanInfo info;

    public VasZplanAIOData() {
        this(0, null, null, null, null, null, 63, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final VasZplanAdvIcon getAdvIcon() {
        return this.advIcon;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final VasZplanAvatarInfo getAvatarInfo() {
        return this.avatarInfo;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final VasZplanBubble getBubble() {
        return this.bubble;
    }

    /* renamed from: d, reason: from getter */
    public final int getConfigType() {
        return this.configType;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final VasZplanCycleIcon getCycleIcon() {
        return this.cycleIcon;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VasZplanAIOData)) {
            return false;
        }
        VasZplanAIOData vasZplanAIOData = (VasZplanAIOData) other;
        if (this.configType == vasZplanAIOData.configType && Intrinsics.areEqual(this.bubble, vasZplanAIOData.bubble) && Intrinsics.areEqual(this.advIcon, vasZplanAIOData.advIcon) && Intrinsics.areEqual(this.cycleIcon, vasZplanAIOData.cycleIcon) && Intrinsics.areEqual(this.avatarInfo, vasZplanAIOData.avatarInfo) && Intrinsics.areEqual(this.info, vasZplanAIOData.info)) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final VasZplanInfo getInfo() {
        return this.info;
    }

    public final void g(@Nullable VasZplanAdvIcon vasZplanAdvIcon) {
        this.advIcon = vasZplanAdvIcon;
    }

    public final void h(@Nullable VasZplanAvatarInfo vasZplanAvatarInfo) {
        this.avatarInfo = vasZplanAvatarInfo;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int i3 = this.configType * 31;
        VasZplanBubble vasZplanBubble = this.bubble;
        int i16 = 0;
        if (vasZplanBubble == null) {
            hashCode = 0;
        } else {
            hashCode = vasZplanBubble.hashCode();
        }
        int i17 = (i3 + hashCode) * 31;
        VasZplanAdvIcon vasZplanAdvIcon = this.advIcon;
        if (vasZplanAdvIcon == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = vasZplanAdvIcon.hashCode();
        }
        int i18 = (i17 + hashCode2) * 31;
        VasZplanCycleIcon vasZplanCycleIcon = this.cycleIcon;
        if (vasZplanCycleIcon == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = vasZplanCycleIcon.hashCode();
        }
        int i19 = (i18 + hashCode3) * 31;
        VasZplanAvatarInfo vasZplanAvatarInfo = this.avatarInfo;
        if (vasZplanAvatarInfo == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = vasZplanAvatarInfo.hashCode();
        }
        int i26 = (i19 + hashCode4) * 31;
        VasZplanInfo vasZplanInfo = this.info;
        if (vasZplanInfo != null) {
            i16 = vasZplanInfo.hashCode();
        }
        return i26 + i16;
    }

    public final void i(@Nullable VasZplanBubble vasZplanBubble) {
        this.bubble = vasZplanBubble;
    }

    public final void j(@Nullable VasZplanCycleIcon vasZplanCycleIcon) {
        this.cycleIcon = vasZplanCycleIcon;
    }

    public final void k(@Nullable VasZplanInfo vasZplanInfo) {
        this.info = vasZplanInfo;
    }

    @NotNull
    public String toString() {
        return "VasZplanAIOData(configType=" + this.configType + ", bubble=" + this.bubble + ", advIcon=" + this.advIcon + ", cycleIcon=" + this.cycleIcon + ", avatarInfo=" + this.avatarInfo + ", info=" + this.info + ')';
    }

    public VasZplanAIOData(int i3, @Nullable VasZplanBubble vasZplanBubble, @Nullable VasZplanAdvIcon vasZplanAdvIcon, @Nullable VasZplanCycleIcon vasZplanCycleIcon, @Nullable VasZplanAvatarInfo vasZplanAvatarInfo, @Nullable VasZplanInfo vasZplanInfo) {
        this.configType = i3;
        this.bubble = vasZplanBubble;
        this.advIcon = vasZplanAdvIcon;
        this.cycleIcon = vasZplanCycleIcon;
        this.avatarInfo = vasZplanAvatarInfo;
        this.info = vasZplanInfo;
    }

    public /* synthetic */ VasZplanAIOData(int i3, VasZplanBubble vasZplanBubble, VasZplanAdvIcon vasZplanAdvIcon, VasZplanCycleIcon vasZplanCycleIcon, VasZplanAvatarInfo vasZplanAvatarInfo, VasZplanInfo vasZplanInfo, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? null : vasZplanBubble, (i16 & 4) != 0 ? null : vasZplanAdvIcon, (i16 & 8) != 0 ? null : vasZplanCycleIcon, (i16 & 16) != 0 ? null : vasZplanAvatarInfo, (i16 & 32) == 0 ? vasZplanInfo : null);
    }
}
