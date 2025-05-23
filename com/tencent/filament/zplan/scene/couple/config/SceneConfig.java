package com.tencent.filament.zplan.scene.couple.config;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0015\u001a\u0004\b\t\u0010\u0016R\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u000f\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/filament/zplan/scene/couple/config/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "d", "()I", WadlProxyConsts.SCENE_ID, "Lcom/tencent/filament/zplan/scene/couple/config/BpConfig;", "b", "Lcom/tencent/filament/zplan/scene/couple/config/BpConfig;", "c", "()Lcom/tencent/filament/zplan/scene/couple/config/BpConfig;", "room", "Lcom/tencent/filament/zplan/scene/couple/config/a;", "Lcom/tencent/filament/zplan/scene/couple/config/a;", "()Lcom/tencent/filament/zplan/scene/couple/config/a;", "leftAvatarConfig", "rightAvatarConfig", "<init>", "(ILcom/tencent/filament/zplan/scene/couple/config/BpConfig;Lcom/tencent/filament/zplan/scene/couple/config/a;Lcom/tencent/filament/zplan/scene/couple/config/a;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.tencent.filament.zplan.scene.couple.config.c, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class SceneConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int sceneId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final BpConfig room;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final AvatarConfig leftAvatarConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final AvatarConfig rightAvatarConfig;

    public SceneConfig(int i3, @NotNull BpConfig room, @NotNull AvatarConfig leftAvatarConfig, @NotNull AvatarConfig rightAvatarConfig) {
        Intrinsics.checkNotNullParameter(room, "room");
        Intrinsics.checkNotNullParameter(leftAvatarConfig, "leftAvatarConfig");
        Intrinsics.checkNotNullParameter(rightAvatarConfig, "rightAvatarConfig");
        this.sceneId = i3;
        this.room = room;
        this.leftAvatarConfig = leftAvatarConfig;
        this.rightAvatarConfig = rightAvatarConfig;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final AvatarConfig getLeftAvatarConfig() {
        return this.leftAvatarConfig;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final AvatarConfig getRightAvatarConfig() {
        return this.rightAvatarConfig;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final BpConfig getRoom() {
        return this.room;
    }

    /* renamed from: d, reason: from getter */
    public final int getSceneId() {
        return this.sceneId;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof SceneConfig) {
                SceneConfig sceneConfig = (SceneConfig) other;
                if (this.sceneId != sceneConfig.sceneId || !Intrinsics.areEqual(this.room, sceneConfig.room) || !Intrinsics.areEqual(this.leftAvatarConfig, sceneConfig.leftAvatarConfig) || !Intrinsics.areEqual(this.rightAvatarConfig, sceneConfig.rightAvatarConfig)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17 = this.sceneId * 31;
        BpConfig bpConfig = this.room;
        int i18 = 0;
        if (bpConfig != null) {
            i3 = bpConfig.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = (i17 + i3) * 31;
        AvatarConfig avatarConfig = this.leftAvatarConfig;
        if (avatarConfig != null) {
            i16 = avatarConfig.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        AvatarConfig avatarConfig2 = this.rightAvatarConfig;
        if (avatarConfig2 != null) {
            i18 = avatarConfig2.hashCode();
        }
        return i26 + i18;
    }

    @NotNull
    public String toString() {
        return "SceneConfig(sceneId=" + this.sceneId + ", room=" + this.room + ", leftAvatarConfig=" + this.leftAvatarConfig + ", rightAvatarConfig=" + this.rightAvatarConfig + ")";
    }
}
