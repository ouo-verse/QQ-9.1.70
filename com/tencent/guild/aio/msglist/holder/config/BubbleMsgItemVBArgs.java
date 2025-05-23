package com.tencent.guild.aio.msglist.holder.config;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\n\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u0010\u0010\u0016R\u0017\u0010\u001b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/config/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/view/View;", "a", "Landroid/view/View;", "c", "()Landroid/view/View;", "templateView", "Lcom/tencent/guild/aio/msglist/holder/config/d;", "b", "Lcom/tencent/guild/aio/msglist/holder/config/d;", "()Lcom/tencent/guild/aio/msglist/holder/config/d;", "componentProvider", "Lcom/tencent/guild/aio/msglist/holder/config/c;", "Lcom/tencent/guild/aio/msglist/holder/config/c;", "()Lcom/tencent/guild/aio/msglist/holder/config/c;", "factoryProvider", "d", "I", "()I", "viewType", "<init>", "(Landroid/view/View;Lcom/tencent/guild/aio/msglist/holder/config/d;Lcom/tencent/guild/aio/msglist/holder/config/c;I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.guild.aio.msglist.holder.config.a, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class BubbleMsgItemVBArgs {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final View templateView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final d componentProvider;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final c factoryProvider;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int viewType;

    public BubbleMsgItemVBArgs(@NotNull View templateView, @NotNull d componentProvider, @NotNull c factoryProvider, int i3) {
        Intrinsics.checkNotNullParameter(templateView, "templateView");
        Intrinsics.checkNotNullParameter(componentProvider, "componentProvider");
        Intrinsics.checkNotNullParameter(factoryProvider, "factoryProvider");
        this.templateView = templateView;
        this.componentProvider = componentProvider;
        this.factoryProvider = factoryProvider;
        this.viewType = i3;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final d getComponentProvider() {
        return this.componentProvider;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final c getFactoryProvider() {
        return this.factoryProvider;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final View getTemplateView() {
        return this.templateView;
    }

    /* renamed from: d, reason: from getter */
    public final int getViewType() {
        return this.viewType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BubbleMsgItemVBArgs)) {
            return false;
        }
        BubbleMsgItemVBArgs bubbleMsgItemVBArgs = (BubbleMsgItemVBArgs) other;
        if (Intrinsics.areEqual(this.templateView, bubbleMsgItemVBArgs.templateView) && Intrinsics.areEqual(this.componentProvider, bubbleMsgItemVBArgs.componentProvider) && Intrinsics.areEqual(this.factoryProvider, bubbleMsgItemVBArgs.factoryProvider) && this.viewType == bubbleMsgItemVBArgs.viewType) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.templateView.hashCode() * 31) + this.componentProvider.hashCode()) * 31) + this.factoryProvider.hashCode()) * 31) + this.viewType;
    }

    @NotNull
    public String toString() {
        return "BubbleMsgItemVBArgs(templateView=" + this.templateView + ", componentProvider=" + this.componentProvider + ", factoryProvider=" + this.factoryProvider + ", viewType=" + this.viewType + ")";
    }
}
