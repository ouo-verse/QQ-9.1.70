package com.tencent.qqnt.markdown.data.multipic;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pic.api.IPicAIOApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RoundRectImageView;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00104\u001a\u000203\u00a2\u0006\u0004\b5\u00106J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J&\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rJ&\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nR\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010!\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010 R\u001b\u0010$\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010\u0019\u001a\u0004\b#\u0010 R\u001b\u0010(\u001a\u00020%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0019\u001a\u0004\b&\u0010'R\u001b\u0010,\u001a\u00020)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b*\u0010+R\u0018\u0010.\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010-R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010/R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u00100R\u0014\u00102\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u00101\u00a8\u00067"}, d2 = {"Lcom/tencent/qqnt/markdown/data/multipic/PicViewWrapper;", "", "Landroid/widget/FrameLayout;", "j", "Lcom/tencent/qqnt/markdown/data/multipic/c;", "listener", "", "k", "", "url", "", "width", "height", "", "showMore", "l", "text", "Landroid/graphics/drawable/Drawable;", "icon", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/widget/RoundRectImageView;", "a", "Lcom/tencent/widget/RoundRectImageView;", "imageView", "b", "Lkotlin/Lazy;", "e", "()Lcom/tencent/widget/RoundRectImageView;", "maskView", "Landroid/widget/TextView;", "c", "f", "()Landroid/widget/TextView;", "moreView", "d", tl.h.F, "statusText", "Landroid/widget/ImageView;", "g", "()Landroid/widget/ImageView;", "statusIcon", "Landroid/widget/LinearLayout;", "i", "()Landroid/widget/LinearLayout;", "statusView", "Lcom/tencent/qqnt/markdown/data/multipic/c;", "onClickListener", "Z", "Ljava/lang/String;", "Landroid/widget/FrameLayout;", ParseCommon.CONTAINER, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class PicViewWrapper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RoundRectImageView imageView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy maskView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy moreView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy statusText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy statusIcon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy statusView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c onClickListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean showMore;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String url;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout container;

    public PicViewWrapper(@NotNull final Context context) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        RoundRectImageView roundRectImageView = new RoundRectImageView(context);
        roundRectImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        roundRectImageView.setCornerRadiusAndMode(ViewUtils.dpToPx(4.0f), 1);
        roundRectImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.imageView = roundRectImageView;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RoundRectImageView>(context) { // from class: com.tencent.qqnt.markdown.data.multipic.PicViewWrapper$maskView$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context $context;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$context = context;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) context);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RoundRectImageView invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (RoundRectImageView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                RoundRectImageView roundRectImageView2 = new RoundRectImageView(this.$context);
                roundRectImageView2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                roundRectImageView2.setCornerRadiusAndMode(ViewUtils.dpToPx(4.0f), 1);
                return roundRectImageView2;
            }
        });
        this.maskView = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>(context) { // from class: com.tencent.qqnt.markdown.data.multipic.PicViewWrapper$moreView$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context $context;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$context = context;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) context);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (TextView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                TextView textView = new TextView(this.$context);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                textView.setLayoutParams(layoutParams);
                textView.setTextSize(14.0f);
                textView.setTextColor(-1);
                textView.setText("\u67e5\u770b\u66f4\u591a");
                return textView;
            }
        });
        this.moreView = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>(context) { // from class: com.tencent.qqnt.markdown.data.multipic.PicViewWrapper$statusText$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context $context;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$context = context;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) context);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (TextView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                TextView textView = new TextView(this.$context);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.topMargin = ViewUtils.dpToPx(4.0f);
                layoutParams.gravity = 17;
                textView.setLayoutParams(layoutParams);
                textView.setTextSize(12.0f);
                textView.setTextColor(textView.getResources().getColor(R.color.qui_common_text_tertiary));
                return textView;
            }
        });
        this.statusText = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>(context) { // from class: com.tencent.qqnt.markdown.data.multipic.PicViewWrapper$statusIcon$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context $context;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$context = context;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) context);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ImageView invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (ImageView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                ImageView imageView = new ImageView(this.$context);
                int dpToPx = ViewUtils.dpToPx(28.0f);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dpToPx, dpToPx);
                layoutParams.gravity = 17;
                imageView.setLayoutParams(layoutParams);
                return imageView;
            }
        });
        this.statusIcon = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>(context, this) { // from class: com.tencent.qqnt.markdown.data.multipic.PicViewWrapper$statusView$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context $context;
            final /* synthetic */ PicViewWrapper this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$context = context;
                this.this$0 = this;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) context, (Object) this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LinearLayout invoke() {
                ImageView g16;
                TextView h16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (LinearLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                LinearLayout linearLayout = new LinearLayout(this.$context);
                PicViewWrapper picViewWrapper = this.this$0;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                linearLayout.setLayoutParams(layoutParams);
                linearLayout.setOrientation(1);
                g16 = picViewWrapper.g();
                linearLayout.addView(g16);
                h16 = picViewWrapper.h();
                linearLayout.addView(h16);
                return linearLayout;
            }
        });
        this.statusView = lazy5;
        this.url = "";
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.markdown.data.multipic.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PicViewWrapper.d(PicViewWrapper.this, view);
            }
        });
        this.container = frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(PicViewWrapper this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        c cVar = this$0.onClickListener;
        if (cVar != null) {
            cVar.a(this$0.url, this$0.showMore);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final RoundRectImageView e() {
        return (RoundRectImageView) this.maskView.getValue();
    }

    private final TextView f() {
        return (TextView) this.moreView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView g() {
        return (ImageView) this.statusIcon.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView h() {
        return (TextView) this.statusText.getValue();
    }

    private final LinearLayout i() {
        return (LinearLayout) this.statusView.getValue();
    }

    @NotNull
    public final FrameLayout j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.container;
    }

    public final void k(@NotNull c listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.onClickListener = listener;
        }
    }

    public final void l(@NotNull String url, int width, int height, boolean showMore) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, url, Integer.valueOf(width), Integer.valueOf(height), Boolean.valueOf(showMore));
            return;
        }
        Intrinsics.checkNotNullParameter(url, "url");
        this.container.removeAllViews();
        if (!URLUtil.isNetworkUrl(url)) {
            return;
        }
        this.container.setLayoutParams(new ViewGroup.LayoutParams(width, height));
        Option options = new Option().setTargetView(this.imageView).setUrl(url);
        IPicAIOApi iPicAIOApi = (IPicAIOApi) QRoute.api(IPicAIOApi.class);
        Intrinsics.checkNotNullExpressionValue(options, "options");
        iPicAIOApi.loadPic(options, null);
        this.container.addView(this.imageView);
        if (showMore) {
            this.container.addView(e());
            e().setBackgroundColor(e().getContext().getResources().getColor(R.color.qui_common_overlay_dark));
            this.container.addView(f());
        }
        this.showMore = showMore;
        this.url = url;
    }

    public final void m(@NotNull String text, @NotNull Drawable icon, int width, int height) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, text, icon, Integer.valueOf(width), Integer.valueOf(height));
            return;
        }
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.container.removeAllViews();
        this.container.setLayoutParams(new ViewGroup.LayoutParams(width, height));
        this.container.addView(e());
        e().setBackgroundColor(e().getContext().getResources().getColor(R.color.qui_common_fill_standard_primary));
        this.container.addView(i());
        h().setText(text);
        g().setImageDrawable(icon);
    }
}
