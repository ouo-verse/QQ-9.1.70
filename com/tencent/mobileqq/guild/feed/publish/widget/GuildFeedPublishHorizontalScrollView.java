package com.tencent.mobileqq.guild.feed.publish.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/widget/GuildFeedPublishHorizontalScrollView;", "Landroid/widget/HorizontalScrollView;", "", "l", "t", "oldl", "oldt", "", "onScrollChanged", "Lcom/tencent/mobileqq/guild/feed/publish/widget/k;", "listener", "setHorizontalScrollChangeListener", "d", "Lcom/tencent/mobileqq/guild/feed/publish/widget/k;", "onScrollChangeListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedPublishHorizontalScrollView extends HorizontalScrollView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private k onScrollChangeListener;

    public GuildFeedPublishHorizontalScrollView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    protected void onScrollChanged(int l3, int t16, int oldl, int oldt) {
        super.onScrollChanged(l3, t16, oldl, oldt);
        if (getScrollX() == getChildAt(0).getMeasuredWidth() - getMeasuredWidth()) {
            k kVar = this.onScrollChangeListener;
            if (kVar != null) {
                kVar.b();
                return;
            }
            return;
        }
        k kVar2 = this.onScrollChangeListener;
        if (kVar2 != null) {
            kVar2.a();
        }
    }

    public final void setHorizontalScrollChangeListener(@NotNull k listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onScrollChangeListener = listener;
    }
}
