package com.tencent.mobileqq.guild.feed.feedsquare.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\"\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007R\u001b\u0010\u000f\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/GuildPublishV2Layout;", "Landroid/widget/LinearLayout;", "", "c", "b", "", "content", "", "color", QAdVrReportParams.ParamKey.MEDIA, "d", "Lwq0/l;", "Lkotlin/Lazy;", "a", "()Lwq0/l;", "mTextContent", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mImageMedia", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mImageMediaCount", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildPublishV2Layout extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mTextContent;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mImageMedia;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mImageMediaCount;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildPublishV2Layout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final wq0.l a() {
        return (wq0.l) this.mTextContent.getValue();
    }

    private final void b() {
        ImageView imageView = new ImageView(getContext());
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        imageView.setImageDrawable(GuildUIUtils.w(context, R.drawable.guild_feed_publish_image, Integer.valueOf(R.color.qui_common_text_primary)));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mImageMedia = imageView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) cw.b(24), (int) cw.b(24));
        layoutParams.setMarginStart((int) cw.b(18));
        addView(this.mImageMedia, layoutParams);
    }

    private final void c() {
        TextView textView = new TextView(getContext());
        textView.setTextSize(16.0f);
        textView.setTextColor(textView.getResources().getColor(R.color.qui_common_text_primary));
        this.mImageMediaCount = textView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMarginStart((int) cw.b(2));
        addView(this.mImageMediaCount, layoutParams);
    }

    public static /* synthetic */ void e(GuildPublishV2Layout guildPublishV2Layout, CharSequence charSequence, int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i3 = guildPublishV2Layout.getResources().getColor(R.color.qui_common_text_secondary);
        }
        if ((i17 & 4) != 0) {
            i16 = 0;
        }
        guildPublishV2Layout.d(charSequence, i3, i16);
    }

    public final void d(@NotNull CharSequence content, int color, int media) {
        Intrinsics.checkNotNullParameter(content, "content");
        wq0.l a16 = a();
        a16.f(content, "");
        a16.setTextColor(color);
        if (media > 0) {
            ImageView imageView = this.mImageMedia;
            if (imageView == null) {
                b();
            } else {
                Intrinsics.checkNotNull(imageView);
                imageView.setVisibility(0);
            }
            TextView textView = this.mImageMediaCount;
            if (textView == null) {
                c();
            } else {
                Intrinsics.checkNotNull(textView);
                textView.setVisibility(0);
            }
            TextView textView2 = this.mImageMediaCount;
            Intrinsics.checkNotNull(textView2);
            textView2.setText(String.valueOf(media));
            return;
        }
        ImageView imageView2 = this.mImageMedia;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        TextView textView3 = this.mImageMediaCount;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildPublishV2Layout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildPublishV2Layout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildPublishV2Layout(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<wq0.l>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.widget.GuildPublishV2Layout$mTextContent$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final wq0.l invoke() {
                com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.b bVar = com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.b.f221402a;
                Context context2 = context;
                String string = this.getResources().getString(R.string.f1522619x);
                Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026g.guild_publish_new_feed)");
                return bVar.e(context2, string, this.getResources().getColor(R.color.qui_common_text_secondary));
            }
        });
        this.mTextContent = lazy;
        addView(a().getView(), new LinearLayout.LayoutParams(0, -2, 1.0f));
        setBackgroundResource(R.drawable.guild_input_view_background);
        setGravity(16);
    }
}
