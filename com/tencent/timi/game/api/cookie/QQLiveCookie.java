package com.tencent.timi.game.api.cookie;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/timi/game/api/cookie/QQLiveCookie;", "", "domain", "", "value", "(Ljava/lang/String;Ljava/lang/String;)V", "getDomain", "()Ljava/lang/String;", HippyTextInputController.COMMAND_getValue, "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "timi-game-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final /* data */ class QQLiveCookie {

    @NotNull
    private final String domain;

    @NotNull
    private final String value;

    public QQLiveCookie(@NotNull String domain, @NotNull String value) {
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(value, "value");
        this.domain = domain;
        this.value = value;
    }

    public static /* synthetic */ QQLiveCookie copy$default(QQLiveCookie qQLiveCookie, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = qQLiveCookie.domain;
        }
        if ((i3 & 2) != 0) {
            str2 = qQLiveCookie.value;
        }
        return qQLiveCookie.copy(str, str2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getDomain() {
        return this.domain;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    @NotNull
    public final QQLiveCookie copy(@NotNull String domain, @NotNull String value) {
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(value, "value");
        return new QQLiveCookie(domain, value);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QQLiveCookie)) {
            return false;
        }
        QQLiveCookie qQLiveCookie = (QQLiveCookie) other;
        if (Intrinsics.areEqual(this.domain, qQLiveCookie.domain) && Intrinsics.areEqual(this.value, qQLiveCookie.value)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getDomain() {
        return this.domain;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return (this.domain.hashCode() * 31) + this.value.hashCode();
    }

    @NotNull
    public String toString() {
        return "QQLiveCookie(domain=" + this.domain + ", value=" + this.value + ')';
    }
}
