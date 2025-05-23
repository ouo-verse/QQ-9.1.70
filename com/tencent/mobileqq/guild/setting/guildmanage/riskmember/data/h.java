package com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data;

import com.tencent.mobileqq.wink.api.QQWinkConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/h;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/e;", "", "other", "", "equals", "", "hashCode", "", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "title", QQWinkConstants.TAB_SUBTITLE, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class h extends e {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String title;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String subTitle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull String title, @NotNull String subTitle) {
        super(3);
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subTitle, "subTitle");
        this.title = title;
        this.subTitle = subTitle;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getSubTitle() {
        return this.subTitle;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Override // com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.e
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
        if (!Intrinsics.areEqual(h.class, cls) || !super.equals(other)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.GuildRiskTipsData");
        h hVar = (h) other;
        if (Intrinsics.areEqual(this.title, hVar.title) && Intrinsics.areEqual(this.subTitle, hVar.subTitle)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.e
    public int hashCode() {
        return (((super.hashCode() * 31) + this.title.hashCode()) * 31) + this.subTitle.hashCode();
    }
}
