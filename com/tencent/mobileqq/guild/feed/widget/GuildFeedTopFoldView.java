package com.tencent.mobileqq.guild.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u000e\u0010\u0012B#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u000e\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/widget/GuildFeedTopFoldView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "", "a", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "foldTv", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "foldIv", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedTopFoldView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView foldTv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView foldIv;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildFeedTopFoldView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.ern, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.v3t);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.feed_top_fold_item_iv)");
        this.foldIv = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.v3u);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.feed_top_fold_item_tv)");
        this.foldTv = (TextView) findViewById2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildFeedTopFoldView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedTopFoldView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        a(context);
    }
}
