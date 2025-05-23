package com.tencent.zplan.meme.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/zplan/meme/model/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lgx4/a;", "a", "Lgx4/a;", "()Lgx4/a;", "character", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "dressKey", "<init>", "(Lgx4/a;Ljava/lang/String;)V", "record_debug"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.tencent.zplan.meme.model.a, reason: from toString */
/* loaded from: classes27.dex */
public final /* data */ class AvatarCharacterInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final gx4.a character;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String dressKey;

    public AvatarCharacterInfo(@NotNull gx4.a character, @NotNull String dressKey) {
        Intrinsics.checkNotNullParameter(character, "character");
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        this.character = character;
        this.dressKey = dressKey;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final gx4.a getCharacter() {
        return this.character;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getDressKey() {
        return this.dressKey;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof AvatarCharacterInfo) {
                AvatarCharacterInfo avatarCharacterInfo = (AvatarCharacterInfo) other;
                if (!Intrinsics.areEqual(this.character, avatarCharacterInfo.character) || !Intrinsics.areEqual(this.dressKey, avatarCharacterInfo.dressKey)) {
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
        gx4.a aVar = this.character;
        int i16 = 0;
        if (aVar != null) {
            i3 = aVar.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        String str = this.dressKey;
        if (str != null) {
            i16 = str.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "AvatarCharacterInfo(character=" + this.character + ", dressKey=" + this.dressKey + ")";
    }
}
