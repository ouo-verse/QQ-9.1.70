package com.tencent.mobileqq.wink.editor.sticker.sticker.p008new;

import android.support.v7.widget.GridLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/q;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/support/v7/widget/GridLayoutManager;", "a", "Landroid/support/v7/widget/GridLayoutManager;", "b", "()Landroid/support/v7/widget/GridLayoutManager;", "contentLayoutManager", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/StickerPanelContentAdapter;", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/StickerPanelContentAdapter;", "()Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/StickerPanelContentAdapter;", "contentAdapter", "<init>", "(Landroid/support/v7/widget/GridLayoutManager;Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/StickerPanelContentAdapter;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.editor.sticker.sticker.new.q, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class StickerRvConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final GridLayoutManager contentLayoutManager;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final StickerPanelContentAdapter contentAdapter;

    public StickerRvConfig(@NotNull GridLayoutManager contentLayoutManager, @NotNull StickerPanelContentAdapter contentAdapter) {
        Intrinsics.checkNotNullParameter(contentLayoutManager, "contentLayoutManager");
        Intrinsics.checkNotNullParameter(contentAdapter, "contentAdapter");
        this.contentLayoutManager = contentLayoutManager;
        this.contentAdapter = contentAdapter;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final StickerPanelContentAdapter getContentAdapter() {
        return this.contentAdapter;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final GridLayoutManager getContentLayoutManager() {
        return this.contentLayoutManager;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StickerRvConfig)) {
            return false;
        }
        StickerRvConfig stickerRvConfig = (StickerRvConfig) other;
        if (Intrinsics.areEqual(this.contentLayoutManager, stickerRvConfig.contentLayoutManager) && Intrinsics.areEqual(this.contentAdapter, stickerRvConfig.contentAdapter)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.contentLayoutManager.hashCode() * 31) + this.contentAdapter.hashCode();
    }

    @NotNull
    public String toString() {
        return "StickerRvConfig(contentLayoutManager=" + this.contentLayoutManager + ", contentAdapter=" + this.contentAdapter + ")";
    }
}
