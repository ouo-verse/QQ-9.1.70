package com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.adapter.section.SectionIOCKt;
import com.tencent.biz.richframework.animation.transition.TransitionBean;
import com.tencent.biz.richframework.animation.transition.TransitionHelper;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.component.RoundImageView;
import com.tencent.mobileqq.guild.feed.api.impl.GuildFeedImagePreDecoder;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedPublishInfo;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.ShortFeedPicLineSection;
import com.tencent.mobileqq.guild.feed.nativedetail.content.part.ae;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 +2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003,-.B\u0007\u00a2\u0006\u0004\b)\u0010*J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J,\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\u0012\u0010\u0014\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014J(\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000b2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0014R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001d\u0010(\u001a\u0004\u0018\u00010#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/ShortFeedPicLineSection;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/c;", "", "url", "Landroid/widget/ImageView;", "imageView", "", "u", "Landroid/content/Context;", "context", "", "width", "height", "Lkotlin/Pair;", "t", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "position", "", "", "payload", "v", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/ShortFeedPicLineSection$SquareImageView;", "d", "Ljava/util/List;", "imageViews", "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "linearLayout", "Lrl1/a;", "f", "Lkotlin/Lazy;", ReportConstant.COSTREPORT_PREFIX, "()Lrl1/a;", "extraParamIoc", "<init>", "()V", tl.h.F, "a", "ImageItemView", com.tencent.qqmini.sdk.launcher.widget.SquareImageView.TAG, "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ShortFeedPicLineSection extends Section<com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.c> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<SquareImageView> imageViews = new ArrayList();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LinearLayout linearLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy extraParamIoc;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: collision with root package name */
    private static final int f221068i = ViewUtils.dpToPx(3.0f);

    /* renamed from: m, reason: collision with root package name */
    private static final int f221069m = ViewUtils.dpToPx(6.0f);
    private static final int C = ViewUtils.dpToPx(12.0f);

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u00a2\u0006\u0004\b$\u0010%J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0014R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00028\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/ShortFeedPicLineSection$ImageItemView;", "Landroid/widget/FrameLayout;", "", NodeProps.CUSTOM_PROP_ISGIF, "", "a", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/ShortFeedPicLineSection$SquareImageView;", "d", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/ShortFeedPicLineSection$SquareImageView;", "c", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/ShortFeedPicLineSection$SquareImageView;", "imageView", "Landroid/view/View;", "e", "Landroid/view/View;", "b", "()Landroid/view/View;", "setGifLabel", "(Landroid/view/View;)V", "gifLabel", "value", "f", "Z", "getEnableSquare", "()Z", "setEnableSquare", "(Z)V", "enableSquare", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class ImageItemView extends FrameLayout {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final SquareImageView imageView;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public View gifLabel;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private boolean enableSquare;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public ImageItemView(@NotNull Context context) {
            this(context, null, 2, 0 == true ? 1 : 0);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        public final void a(boolean isGif) {
            FrameLayout.LayoutParams layoutParams;
            if (isGif) {
                if (this.gifLabel == null) {
                    LayoutInflater.from(getContext()).inflate(R.layout.eoh, (ViewGroup) this, true);
                    View findViewById = findViewById(R.id.w9p);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.guild_feed_gif_label)");
                    setGifLabel(findViewById);
                    ViewGroup.LayoutParams layoutParams2 = b().getLayoutParams();
                    if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                        layoutParams = (FrameLayout.LayoutParams) layoutParams2;
                    } else {
                        layoutParams = null;
                    }
                    if (layoutParams != null) {
                        layoutParams.gravity = 8388693;
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.gifLabel != null) {
                b().setVisibility(8);
            }
        }

        @NotNull
        public final View b() {
            View view = this.gifLabel;
            if (view != null) {
                return view;
            }
            Intrinsics.throwUninitializedPropertyAccessException("gifLabel");
            return null;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final SquareImageView getImageView() {
            return this.imageView;
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            if (this.enableSquare) {
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824);
                super.onMeasure(makeMeasureSpec, makeMeasureSpec);
            } else {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            }
        }

        public final void setEnableSquare(boolean z16) {
            this.enableSquare = z16;
            requestLayout();
        }

        public final void setGifLabel(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.gifLabel = view;
        }

        public /* synthetic */ ImageItemView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(context, (i3 & 2) != 0 ? null : attributeSet);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public ImageItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            Intrinsics.checkNotNullParameter(context, "context");
            SquareImageView squareImageView = new SquareImageView(context, null, 2, 0 == true ? 1 : 0);
            squareImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.imageView = squareImageView;
            setBackgroundColor(0);
            addView(squareImageView, new FrameLayout.LayoutParams(-1, -1));
            this.enableSquare = true;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/ShortFeedPicLineSection$SquareImageView;", "Lcom/tencent/mobileqq/guild/component/RoundImageView;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class SquareImageView extends RoundImageView {
        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public SquareImageView(@NotNull Context context) {
            this(context, null, 2, 0 == true ? 1 : 0);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        public /* synthetic */ SquareImageView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(context, (i3 & 2) != 0 ? null : attributeSet);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public SquareImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            Intrinsics.checkNotNullParameter(context, "context");
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002R\u0017\u0010\t\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\n\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/ShortFeedPicLineSection$a;", "", "Landroid/content/Context;", "context", "", "size", "Landroid/graphics/drawable/Drawable;", "b", "", "RADIUS", "I", "c", "()I", "FIRST_LINE_MARGIN_TOP", "SPACING", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.ShortFeedPicLineSection$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Drawable b(Context context, float size) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{new ColorDrawable(context.getColor(R.color.qui_common_fill_standard_primary)), com.tencent.mobileqq.guild.util.qqui.d.d(context, 2)});
            layerDrawable.setLayerGravity(1, 17);
            layerDrawable.setLayerSize(1, ViewUtils.dpToPx(size), ViewUtils.dpToPx(size));
            return layerDrawable;
        }

        public final int c() {
            return ShortFeedPicLineSection.f221069m;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/ShortFeedPicLineSection$b", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends GuildPicStateListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ImageView f221076e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ImageView imageView) {
            super(true);
            this.f221076e = imageView;
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(@NotNull LoadState state, @Nullable Option option) {
            Intrinsics.checkNotNullParameter(state, "state");
            if (state.isFinishSuccess()) {
                this.f221076e.setBackground(null);
            }
        }
    }

    public ShortFeedPicLineSection() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<rl1.a>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.ShortFeedPicLineSection$extraParamIoc$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final rl1.a invoke() {
                return (rl1.a) SectionIOCKt.getIocInterface(ShortFeedPicLineSection.this, rl1.a.class);
            }
        });
        this.extraParamIoc = lazy;
    }

    private final rl1.a s() {
        return (rl1.a) this.extraParamIoc.getValue();
    }

    private final Pair<Integer, Integer> t(Context context, int width, int height) {
        float coerceIn;
        int i3 = GuildSplitViewUtils.f235370a.i(true, context) - (ViewUtils.dpToPx(16.0f) * 2);
        float f16 = (i3 * 4) / 3.0f;
        float f17 = i3;
        float f18 = f17 / 2.0f;
        if (width > 0 && height > 0) {
            coerceIn = RangesKt___RangesKt.coerceIn((f17 * height) / width, f18, f16);
            return TuplesKt.to(Integer.valueOf(i3), Integer.valueOf((int) coerceIn));
        }
        return TuplesKt.to(Integer.valueOf(i3), Integer.valueOf((int) f16));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void u(String url, ImageView imageView) {
        String str;
        List<String> listOfNotNull;
        boolean z16;
        float f16;
        if (MiscKt.f(url)) {
            imageView.setImageDrawable(com.tencent.mobileqq.urldrawable.b.f306350a);
            return;
        }
        String d16 = com.tencent.mobileqq.guild.picload.e.d(url);
        Object tag = imageView.getTag(R.id.jb9);
        if (tag instanceof String) {
            str = (String) tag;
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(d16, str)) {
            imageView.setTag(R.id.jb9, d16);
            Option obtain = Option.obtain();
            obtain.setTargetView(imageView);
            obtain.setUrl(url);
            GuildFeedImagePreDecoder guildFeedImagePreDecoder = GuildFeedImagePreDecoder.INSTANCE;
            listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull(url);
            Drawable drawable = guildFeedImagePreDecoder.get(listOfNotNull);
            if (drawable == null) {
                drawable = imageView.getDrawable();
            }
            obtain.setLoadingDrawable(drawable);
            if (obtain.getLoadingDrawable() != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            obtain.setNeedShowLoadingDrawable(z16);
            Companion companion = INSTANCE;
            Context context = imageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "imageView.context");
            if (((com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.c) this.mData).getSpanCount() == 3) {
                f16 = 24.0f;
            } else {
                f16 = 30.0f;
            }
            imageView.setBackground(companion.b(context, f16));
            com.tencent.mobileqq.guild.picload.e.a().f(obtain, new b(imageView));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(qj1.l lVar, SquareImageView imageView, com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.c data, ShortFeedPicLineSection this$0, View view) {
        GProStImage gProStImage;
        int i3;
        Integer businessType;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(imageView, "$imageView");
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object raw = lVar.getRaw();
        GuildFeedPublishInfo guildFeedPublishInfo = null;
        if (raw instanceof GProStImage) {
            gProStImage = (GProStImage) raw;
        } else {
            gProStImage = null;
        }
        if (gProStImage != null) {
            com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.j jVar = com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.j.f221614a;
            Object a16 = data.getFeedDetail().getFeedDetail().a();
            rl1.a s16 = this$0.s();
            if (s16 != null && (businessType = s16.getBusinessType()) != null) {
                i3 = businessType.intValue();
            } else {
                i3 = 0;
            }
            int i16 = i3;
            rl1.a aVar = (rl1.a) SectionIOCKt.getIocInterface(this$0, rl1.a.class);
            if (aVar != null) {
                guildFeedPublishInfo = aVar.e();
            }
            jVar.b(imageView, a16, gProStImage, i16, guildFeedPublishInfo);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TransitionBean x(SquareImageView imageView, qj1.l lVar, int i3) {
        Intrinsics.checkNotNullParameter(imageView, "$imageView");
        TransitionBean transitionBean = new TransitionBean();
        transitionBean.setEnterViewRect(imageView);
        transitionBean.setStImage(lVar.getPicUrl(), lVar.getWidth(), lVar.getHeight());
        transitionBean.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return transitionBean;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        if (containerView == null) {
            return;
        }
        View findViewById = containerView.findViewById(R.id.f24800_4);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.pic_line)");
        this.linearLayout = (LinearLayout) findViewById;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull final com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.c data, int position, @Nullable List<Object> payload) {
        int i3;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ae aeVar;
        Object orNull;
        Map mapOf;
        ImageItemView c16;
        String thumbUrl;
        boolean d16;
        Object orNull2;
        Object first;
        Object orNull3;
        Object first2;
        Object first3;
        Object first4;
        int i16;
        Object first5;
        ImageItemView c17;
        int i17;
        Intrinsics.checkNotNullParameter(data, "data");
        int i18 = 2;
        int i19 = -2;
        AttributeSet attributeSet = null;
        byte b16 = 0;
        if (this.imageViews.size() != data.getSpanCount()) {
            LinearLayout linearLayout = this.linearLayout;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
                linearLayout = null;
            }
            linearLayout.removeAllViews();
            this.imageViews.clear();
            LinearLayout linearLayout2 = this.linearLayout;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
                linearLayout2 = null;
            }
            Context context = linearLayout2.getContext();
            int spanCount = data.getSpanCount();
            for (int i26 = 0; i26 < spanCount; i26++) {
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ImageItemView imageItemView = new ImageItemView(context, attributeSet, i18, b16 == true ? 1 : 0);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                if (i26 > 0) {
                    i17 = f221068i;
                } else {
                    i17 = 0;
                }
                layoutParams.leftMargin = i17;
                imageItemView.setLayoutParams(layoutParams);
                ViewGroup viewGroup = this.linearLayout;
                if (viewGroup == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
                    viewGroup = null;
                }
                viewGroup.addView(imageItemView);
                this.imageViews.add(imageItemView.getImageView());
            }
            if (this.imageViews.size() == 1) {
                first5 = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.imageViews);
                c17 = w.c((SquareImageView) first5);
                if (c17 != null) {
                    c17.setEnableSquare(false);
                }
            }
        }
        LinearLayout linearLayout3 = this.linearLayout;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
            linearLayout3 = null;
        }
        if (data.getFirstLine()) {
            i3 = C;
        } else {
            i3 = f221068i;
        }
        ViewGroup.LayoutParams layoutParams2 = linearLayout3.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams == null) {
            ViewGroup.LayoutParams layoutParams3 = linearLayout3.getLayoutParams();
            if (layoutParams3 != null) {
                i16 = layoutParams3.width;
            } else {
                i16 = -2;
            }
            ViewGroup.LayoutParams layoutParams4 = linearLayout3.getLayoutParams();
            if (layoutParams4 != null) {
                i19 = layoutParams4.height;
            }
            marginLayoutParams = new ViewGroup.MarginLayoutParams(i16, i19);
        }
        if (i3 != marginLayoutParams.topMargin) {
            marginLayoutParams.topMargin = i3;
            linearLayout3.setLayoutParams(marginLayoutParams);
        }
        if (data.getSpanCount() == 1) {
            first3 = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.imageViews);
            View view = (View) first3;
            ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
            if (layoutParams5 != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams5;
                first4 = CollectionsKt___CollectionsKt.first((List<? extends Object>) data.h());
                qj1.l lVar = (qj1.l) first4;
                LinearLayout linearLayout4 = this.linearLayout;
                if (linearLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
                    linearLayout4 = null;
                }
                Context context2 = linearLayout4.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "linearLayout.context");
                Pair<Integer, Integer> t16 = t(context2, lVar.getWidth(), lVar.getHeight());
                int intValue = t16.component1().intValue();
                int intValue2 = t16.component2().intValue();
                marginLayoutParams2.width = intValue;
                marginLayoutParams2.height = intValue2;
                view.setLayoutParams(marginLayoutParams2);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
        }
        Iterator<T> it = this.imageViews.iterator();
        while (it.hasNext()) {
            ((SquareImageView) it.next()).setRadius(0);
        }
        if (data.getTopLeftRadius()) {
            first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.imageViews);
            ((SquareImageView) first2).setTopLeftRadius(f221069m);
        }
        if (data.getTopRightRadius()) {
            orNull3 = CollectionsKt___CollectionsKt.getOrNull(this.imageViews, data.h().size() - 1);
            SquareImageView squareImageView = (SquareImageView) orNull3;
            if (squareImageView != null) {
                squareImageView.setTopRightRadius(f221069m);
            }
        }
        if (data.getBottomLeftRadius()) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.imageViews);
            ((SquareImageView) first).setBottomLeftRadius(f221069m);
        }
        if (data.getBottomRightRadius()) {
            orNull2 = CollectionsKt___CollectionsKt.getOrNull(this.imageViews, data.h().size() - 1);
            SquareImageView squareImageView2 = (SquareImageView) orNull2;
            if (squareImageView2 != null) {
                squareImageView2.setBottomRightRadius(f221069m);
            }
        }
        Object iocInterface = SectionIOCKt.getIocInterface(this, TransitionHelper.TransitionBeanCreator.class);
        if (iocInterface instanceof ae) {
            aeVar = (ae) iocInterface;
        } else {
            aeVar = null;
        }
        int i27 = 0;
        for (Object obj : this.imageViews) {
            int i28 = i27 + 1;
            if (i27 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            final SquareImageView squareImageView3 = (SquareImageView) obj;
            orNull = CollectionsKt___CollectionsKt.getOrNull(data.h(), i27);
            final qj1.l lVar2 = (qj1.l) orNull;
            if (lVar2 != null) {
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_rank", Integer.valueOf(lVar2.getDisplayIndex())), TuplesKt.to("sgrp_type", Integer.valueOf(lVar2.getType())));
                com.tencent.mobileqq.guild.base.extension.g.a(squareImageView3, "em_sgrp_forum_full_screen", true, true, mapOf);
                c16 = w.c(squareImageView3);
                if (c16 != null) {
                    d16 = w.d(lVar2);
                    c16.a(d16);
                }
                if (data.getSpanCount() == 1) {
                    thumbUrl = lVar2.getPicUrl();
                } else {
                    thumbUrl = lVar2.getThumbUrl();
                }
                u(thumbUrl, squareImageView3);
                squareImageView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.u
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        ShortFeedPicLineSection.w(qj1.l.this, squareImageView3, data, this, view2);
                    }
                });
                if (aeVar != null) {
                    aeVar.x9(lVar2.getDisplayIndex(), new TransitionHelper.TransitionBeanCreator() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.v
                        @Override // com.tencent.biz.richframework.animation.transition.TransitionHelper.TransitionBeanCreator
                        public final TransitionBean generateTransitionBean(int i29) {
                            TransitionBean x16;
                            x16 = ShortFeedPicLineSection.x(ShortFeedPicLineSection.SquareImageView.this, lVar2, i29);
                            return x16;
                        }
                    });
                }
            } else {
                squareImageView3.setImageDrawable(com.tencent.mobileqq.urldrawable.b.f306350a);
                squareImageView3.setOnClickListener(null);
            }
            i27 = i28;
        }
    }
}
