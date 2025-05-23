package com.tencent.timi.game.api.ticket;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0006H\u00c6\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/timi/game/api/ticket/PSKey;", "", "domain", "", "value", "isExpired", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getDomain", "()Ljava/lang/String;", "()Z", HippyTextInputController.COMMAND_getValue, "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "timi-game-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final /* data */ class PSKey {

    @NotNull
    private final String domain;
    private final boolean isExpired;

    @Nullable
    private final String value;

    public PSKey(@NotNull String domain, @Nullable String str, boolean z16) {
        Intrinsics.checkNotNullParameter(domain, "domain");
        this.domain = domain;
        this.value = str;
        this.isExpired = z16;
    }

    public static /* synthetic */ PSKey copy$default(PSKey pSKey, String str, String str2, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = pSKey.domain;
        }
        if ((i3 & 2) != 0) {
            str2 = pSKey.value;
        }
        if ((i3 & 4) != 0) {
            z16 = pSKey.isExpired;
        }
        return pSKey.copy(str, str2, z16);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getDomain() {
        return this.domain;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsExpired() {
        return this.isExpired;
    }

    @NotNull
    public final PSKey copy(@NotNull String domain, @Nullable String value, boolean isExpired) {
        Intrinsics.checkNotNullParameter(domain, "domain");
        return new PSKey(domain, value, isExpired);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PSKey)) {
            return false;
        }
        PSKey pSKey = (PSKey) other;
        if (Intrinsics.areEqual(this.domain, pSKey.domain) && Intrinsics.areEqual(this.value, pSKey.value) && this.isExpired == pSKey.isExpired) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getDomain() {
        return this.domain;
    }

    @Nullable
    public final String getValue() {
        return this.value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = this.domain.hashCode() * 31;
        String str = this.value;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i3 = (hashCode2 + hashCode) * 31;
        boolean z16 = this.isExpired;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        return i3 + i16;
    }

    public final boolean isExpired() {
        return this.isExpired;
    }

    @NotNull
    public String toString() {
        return "PSKey(domain=" + this.domain + ", value=" + this.value + ", isExpired=" + this.isExpired + ')';
    }
}
