package com.tencent.mobileqq.guild.feed.gallery.widget.item;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/widget/item/c;", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/item/b;", "Landroid/view/View;", "I", "Landroid/view/View;", "o", "()Landroid/view/View;", "rootItemView", "<init>", "(Landroid/view/View;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c extends b {

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final View rootItemView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull View rootItemView) {
        super(rootItemView);
        Intrinsics.checkNotNullParameter(rootItemView, "rootItemView");
        this.rootItemView = rootItemView;
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.widget.item.b
    @NotNull
    /* renamed from: o, reason: from getter */
    public View getRootItemView() {
        return this.rootItemView;
    }
}
