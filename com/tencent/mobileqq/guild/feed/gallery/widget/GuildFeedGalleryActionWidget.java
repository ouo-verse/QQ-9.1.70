package com.tencent.mobileqq.guild.feed.gallery.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0004\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u001c\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001c\u0010\r\u001a\n \u0006*\u0004\u0018\u00010\n0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedGalleryActionWidget;", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "e", "Landroid/widget/ImageView;", "imgView", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "numberView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedGalleryActionWidget extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout rootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ImageView imgView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final TextView numberView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedGalleryActionWidget(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        View inflate = View.inflate(context, R.layout.env, this);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) inflate;
        this.rootView = frameLayout;
        ImageView imageView = (ImageView) frameLayout.findViewById(R.id.w97);
        this.imgView = imageView;
        TextView textView = (TextView) frameLayout.findViewById(R.id.w98);
        this.numberView = textView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, w12.a.f444204e2);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026dFeedGalleryActionWidget)");
        imageView.setImageResource(obtainStyledAttributes.getResourceId(w12.a.f444214f2, -1));
        int i3 = obtainStyledAttributes.getInt(w12.a.f444224g2, 0);
        if (i3 == 0) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(String.valueOf(i3));
        }
    }
}
