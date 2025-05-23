package iq1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Liq1/a;", "", "", "toString", "Lcom/tencent/mobileqq/guild/live/danmu/item/a;", "a", "Lcom/tencent/mobileqq/guild/live/danmu/item/a;", "()Lcom/tencent/mobileqq/guild/live/danmu/item/a;", "content", "", "b", "Z", "()Z", "needBg", "<init>", "(Lcom/tencent/mobileqq/guild/live/danmu/item/a;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: iq1.a, reason: from toString */
/* loaded from: classes14.dex */
public final class DanmakuDataBean {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final com.tencent.mobileqq.guild.live.danmu.item.a content;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean bg;

    public DanmakuDataBean(@NotNull com.tencent.mobileqq.guild.live.danmu.item.a content, boolean z16) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.content = content;
        this.bg = z16;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final com.tencent.mobileqq.guild.live.danmu.item.a getContent() {
        return this.content;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getBg() {
        return this.bg;
    }

    @NotNull
    public String toString() {
        return "DanmakuDataBean(content=" + this.content + ", bg=" + this.bg + ")";
    }
}
