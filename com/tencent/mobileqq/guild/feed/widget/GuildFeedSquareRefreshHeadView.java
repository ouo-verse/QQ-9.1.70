package com.tencent.mobileqq.guild.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.util.LoadingUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0003B\u0013\b\u0016\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013B\u001d\b\u0016\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0012\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/widget/GuildFeedSquareRefreshHeadView;", "Landroid/widget/LinearLayout;", "", "a", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", "mContentLayout", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mProgressBar", "", "f", "I", "mMeasuredHeight", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", tl.h.F, "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedSquareRefreshHeadView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout mContentLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mProgressBar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mMeasuredHeight;

    public GuildFeedSquareRefreshHeadView(@Nullable Context context) {
        super(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        setLayoutParams(layoutParams);
        setPadding(0, 0, 0, 0);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.eqf, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) inflate;
        this.mContentLayout = frameLayout;
        addView(frameLayout, new LinearLayout.LayoutParams(-1, 0));
        ImageView imageView = (ImageView) findViewById(R.id.wdg);
        this.mProgressBar = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(LoadingUtil.getLoadingDrawable(getContext(), 2));
        }
        a();
        measure(-2, -2);
        this.mMeasuredHeight = getMeasuredHeight();
    }

    private final void a() {
        int i3;
        if (GuildThemeManager.f235286a.b()) {
            i3 = 1;
        } else {
            i3 = 3;
        }
        ImageView imageView = this.mProgressBar;
        if (imageView != null) {
            imageView.setImageDrawable(LoadingUtil.getLoadingDrawable(getContext(), i3));
        }
    }

    public GuildFeedSquareRefreshHeadView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        setLayoutParams(layoutParams);
        setPadding(0, 0, 0, 0);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.eqf, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) inflate;
        this.mContentLayout = frameLayout;
        addView(frameLayout, new LinearLayout.LayoutParams(-1, 0));
        ImageView imageView = (ImageView) findViewById(R.id.wdg);
        this.mProgressBar = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(LoadingUtil.getLoadingDrawable(getContext(), 2));
        }
        a();
        measure(-2, -2);
        this.mMeasuredHeight = getMeasuredHeight();
    }
}
