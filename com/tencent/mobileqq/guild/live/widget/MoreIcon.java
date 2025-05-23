package com.tencent.mobileqq.guild.live.widget;

import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\b\u0082\b\u0018\u00002\u00020\u0001B:\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u0013\u00a2\u0006\u0004\b+\u0010,J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R2\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u00138\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\"\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001f\"\u0004\b \u0010!R\"\u0010$\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\u000e\u0010\u001f\"\u0004\b#\u0010!R\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b%\u0010&R\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\n\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010&\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/guild/live/widget/s;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "content", "b", "I", "e", "()I", "iconRes", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/live/widget/MoreIconViewHolder;", "Lkotlin/ParameterName;", "name", "viewHolder", "", "Lkotlin/jvm/functions/Function1;", "f", "()Lkotlin/jvm/functions/Function1;", "onclick", "d", "Z", "()Z", "setEnabled", "(Z)V", NodeProps.ENABLED, "g", "animating", "setAnimateJson", "(Ljava/lang/String;)V", "animateJson", "getAnimateImagePath", "setAnimateImagePath", "animateImagePath", "<init>", "(Ljava/lang/String;ILkotlin/jvm/functions/Function1;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.live.widget.s, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class MoreIcon {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String content;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int iconRes;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Function1<MoreIconViewHolder, Unit> onclick;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean enabled;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean animating;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String animateJson;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String animateImagePath;

    /* JADX WARN: Multi-variable type inference failed */
    public MoreIcon(@NotNull String content, int i3, @NotNull Function1<? super MoreIconViewHolder, Unit> onclick) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(onclick, "onclick");
        this.content = content;
        this.iconRes = i3;
        this.onclick = onclick;
        this.enabled = true;
        this.animateJson = "";
        this.animateImagePath = "";
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAnimateJson() {
        return this.animateJson;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getAnimating() {
        return this.animating;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* renamed from: e, reason: from getter */
    public final int getIconRes() {
        return this.iconRes;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MoreIcon)) {
            return false;
        }
        MoreIcon moreIcon = (MoreIcon) other;
        if (Intrinsics.areEqual(this.content, moreIcon.content) && this.iconRes == moreIcon.iconRes && Intrinsics.areEqual(this.onclick, moreIcon.onclick)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Function1<MoreIconViewHolder, Unit> f() {
        return this.onclick;
    }

    public final void g(boolean z16) {
        this.animating = z16;
    }

    public int hashCode() {
        return (((this.content.hashCode() * 31) + this.iconRes) * 31) + this.onclick.hashCode();
    }

    @NotNull
    public String toString() {
        return "MoreIcon(content=" + this.content + ", iconRes=" + this.iconRes + ", onclick=" + this.onclick + ")";
    }
}
