package com.tencent.mobileqq.guild.feed.nativepublish.viewbinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditText;
import com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.SimplifiedFeedEditorViewBinding;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 +2\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010>\u001a\u00020=\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0006\u0010\n\u001a\u00020\u0002J\u0019\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u0010\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0002J\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0012J\b\u0010\u0015\u001a\u00020\u0014H\u0016R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\"\u0010(\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010/\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00107\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010:\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010#\u001a\u0004\b8\u0010%\"\u0004\b9\u0010'R\"\u0010;\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010#\u001a\u0004\b;\u0010%\"\u0004\b<\u0010'\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/viewbinding/b;", "Landroidx/viewbinding/ViewBinding;", "", "k", "l", "g", "", "isWrap", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", "", "lineCount", "r", "(Ljava/lang/Integer;)V", "u", "v", "w", "Lkotlin/Triple;", "f", "Landroid/view/View;", "getRoot", "Landroid/view/ViewGroup;", "a", "Landroid/view/ViewGroup;", "i", "()Landroid/view/ViewGroup;", "grayFrame", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditText;", "b", "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditText;", "j", "()Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditText;", "input", "c", "Z", "getCouldLineCountAffectFullScreenArrowVisibility", "()Z", DomainData.DOMAIN_NAME, "(Z)V", "couldLineCountAffectFullScreenArrowVisibility", "d", "Landroid/view/View;", h.F, "()Landroid/view/View;", "setFullScreenSwitchArrowLayout", "(Landroid/view/View;)V", "fullScreenSwitchArrowLayout", "Landroid/view/View$OnClickListener;", "e", "Landroid/view/View$OnClickListener;", "getFullScreenSwitchArrowLayoutClickListener", "()Landroid/view/View$OnClickListener;", "o", "(Landroid/view/View$OnClickListener;)V", "fullScreenSwitchArrowLayoutClickListener", "getDoesFullScreenSwitchArrowOccupySpace", "setDoesFullScreenSwitchArrowOccupySpace", "doesFullScreenSwitchArrowOccupySpace", "isEnableGrayFrameSizeAnimation", "setEnableGrayFrameSizeAnimation", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b implements ViewBinding {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup grayFrame;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildFeedEditText input;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean couldLineCountAffectFullScreenArrowVisibility;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View fullScreenSwitchArrowLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View.OnClickListener fullScreenSwitchArrowLayoutClickListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean doesFullScreenSwitchArrowOccupySpace;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean isEnableGrayFrameSizeAnimation;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\t\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\r\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/viewbinding/b$a;", "", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "b", "", "e", "()I", "grayFrameCornerRadiusPx", "f", "inputVerticalPadding", "d", "arrowTopToInputBottomMargin", "c", "arrowSize", "REQUIREMENT_FULLSCREEN_ARROW_LINE_COUNT", "I", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int e() {
            return ViewUtils.dpToPx(6.0f);
        }

        @NotNull
        public final ConstraintLayout.LayoutParams b() {
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, -2);
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = ViewUtils.dpToPx(16.0f);
            layoutParams.topToTop = 0;
            SimplifiedFeedEditorViewBinding.Companion companion = SimplifiedFeedEditorViewBinding.INSTANCE;
            layoutParams.bottomToTop = companion.g();
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            layoutParams.goneBottomMargin = companion.d();
            return layoutParams;
        }

        public final int c() {
            return ViewUtils.dpToPx(24.0f);
        }

        public final int d() {
            return ViewUtils.dpToPx(10.0f);
        }

        public final int f() {
            return ViewUtils.dpToPx(12.0f);
        }

        Companion() {
        }
    }

    public b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        GuildFeedEditText guildFeedEditText = new GuildFeedEditText(context);
        guildFeedEditText.setId(R.id.wcw);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            guildFeedEditText.setTextCursorDrawable(R.drawable.guild_feed_publish_input_cursor);
        }
        guildFeedEditText.setMinLines(2);
        guildFeedEditText.setTextSize(16.0f);
        guildFeedEditText.setHintTextColor(context.getColorStateList(R.color.qui_common_text_secondary));
        guildFeedEditText.setTextColor(context.getColorStateList(R.color.qui_common_text_primary));
        guildFeedEditText.setHighlightColor(context.getColor(R.color.qui_common_brand_light));
        int spToPx = ViewUtils.spToPx(24.0f);
        if (i3 >= 28) {
            guildFeedEditText.setLineHeight(spToPx);
        } else {
            if (guildFeedEditText.getPaint() != null) {
                guildFeedEditText.setLineSpacing(spToPx - r1.getFontMetricsInt(null), 1.0f);
            }
        }
        this.input = guildFeedEditText;
        this.couldLineCountAffectFullScreenArrowVisibility = true;
        this.doesFullScreenSwitchArrowOccupySpace = true;
        this.isEnableGrayFrameSizeAnimation = true;
        FrameLayout frameLayout = new FrameLayout(guildFeedEditText.getContext());
        frameLayout.setId(SimplifiedFeedEditorViewBinding.INSTANCE.e());
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(context.getColorStateList(R.color.qui_common_fill_standard_primary));
        gradientDrawable.setShape(0);
        Companion companion = INSTANCE;
        gradientDrawable.setCornerRadius(companion.e());
        frameLayout.setBackground(gradientDrawable);
        frameLayout.addView(guildFeedEditText, new LinearLayout.LayoutParams(-1, -2));
        int dpToPx = ViewUtils.dpToPx(16.0f);
        frameLayout.setPadding(dpToPx, companion.f(), dpToPx, companion.f());
        this.grayFrame = frameLayout;
        t(true);
        if (this.isEnableGrayFrameSizeAnimation) {
            m();
        }
    }

    private final void g() {
        boolean z16;
        int i3;
        View view = this.fullScreenSwitchArrowLayout;
        if (view != null) {
            int i16 = 0;
            if (view.getVisibility() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && this.doesFullScreenSwitchArrowOccupySpace) {
                Companion companion = INSTANCE;
                i3 = companion.d() + companion.c();
            } else {
                i3 = 0;
            }
            ViewGroup.LayoutParams layoutParams = this.input.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams != null) {
                i16 = marginLayoutParams.bottomMargin;
            }
            if (i16 != i3) {
                GuildFeedEditText guildFeedEditText = this.input;
                ViewGroup.LayoutParams layoutParams2 = guildFeedEditText.getLayoutParams();
                if (layoutParams2 != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                    marginLayoutParams2.bottomMargin = i3;
                    guildFeedEditText.setLayoutParams(marginLayoutParams2);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
        }
    }

    private final void k() {
        View view;
        if (this.fullScreenSwitchArrowLayout != null) {
            return;
        }
        l();
        View.OnClickListener onClickListener = this.fullScreenSwitchArrowLayoutClickListener;
        if (onClickListener != null && (view = this.fullScreenSwitchArrowLayout) != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    private final void l() {
        View view = new View(getRoot().getContext());
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(view.getContext().getColorStateList(R.color.qui_common_bg_bottom_light));
        gradientDrawable.setShape(1);
        Unit unit = Unit.INSTANCE;
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, view.getContext().getDrawable(R.drawable.qui_chevron_up)});
        int dpToPx = ViewUtils.dpToPx(16.0f);
        layerDrawable.setLayerSize(1, dpToPx, dpToPx);
        layerDrawable.setLayerGravity(1, 17);
        view.setBackground(layerDrawable);
        this.fullScreenSwitchArrowLayout = view;
        ViewGroup viewGroup = this.grayFrame;
        Companion companion = INSTANCE;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(companion.c(), companion.c());
        layoutParams.gravity = 8388693;
        viewGroup.addView(view, layoutParams);
        g();
        View view2 = this.fullScreenSwitchArrowLayout;
        Intrinsics.checkNotNull(view2);
        view2.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(b this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        s(this$0, null, 1, null);
    }

    public static /* synthetic */ void s(b bVar, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            num = null;
        }
        bVar.r(num);
    }

    private final void t(boolean isWrap) {
        if (isWrap) {
            GuildFeedEditText guildFeedEditText = this.input;
            ViewGroup.LayoutParams layoutParams = guildFeedEditText.getLayoutParams();
            if (layoutParams != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.height = -2;
                guildFeedEditText.setLayoutParams(marginLayoutParams);
                this.input.setMaxLines(6);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        GuildFeedEditText guildFeedEditText2 = this.input;
        ViewGroup.LayoutParams layoutParams2 = guildFeedEditText2.getLayoutParams();
        if (layoutParams2 != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
            marginLayoutParams2.height = -1;
            marginLayoutParams2.bottomMargin = 0;
            guildFeedEditText2.setLayoutParams(marginLayoutParams2);
            this.input.setMaxLines(Integer.MAX_VALUE);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    @NotNull
    public final Triple<Integer, Integer, Integer> f() {
        int f16;
        t(true);
        GuildFeedEditText guildFeedEditText = this.input;
        guildFeedEditText.measure(View.MeasureSpec.makeMeasureSpec(guildFeedEditText.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredHeight = this.input.getMeasuredHeight();
        int lineCount = this.input.getLineCount();
        if (this.input.getLineCount() > 3) {
            Companion companion = INSTANCE;
            f16 = companion.d() + companion.c() + (companion.f() * 2);
        } else {
            f16 = INSTANCE.f() * 2;
        }
        int i3 = f16 + measuredHeight;
        t(false);
        return new Triple<>(Integer.valueOf(measuredHeight), Integer.valueOf(i3), Integer.valueOf(lineCount));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NotNull
    public View getRoot() {
        return this.grayFrame;
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final View getFullScreenSwitchArrowLayout() {
        return this.fullScreenSwitchArrowLayout;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final ViewGroup getGrayFrame() {
        return this.grayFrame;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final GuildFeedEditText getInput() {
        return this.input;
    }

    public final void n(boolean z16) {
        this.couldLineCountAffectFullScreenArrowVisibility = z16;
    }

    public final void o(@Nullable View.OnClickListener onClickListener) {
        this.fullScreenSwitchArrowLayoutClickListener = onClickListener;
    }

    public final void p() {
        this.input.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.a
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                b.q(b.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        });
        this.input.addTextChangedListener(new C7769b());
    }

    public final void r(@Nullable Integer lineCount) {
        int lineCount2;
        if (!this.couldLineCountAffectFullScreenArrowVisibility) {
            return;
        }
        if (lineCount != null) {
            lineCount2 = lineCount.intValue();
        } else {
            lineCount2 = this.input.getLineCount();
        }
        if (lineCount2 > 3) {
            k();
            View view = this.fullScreenSwitchArrowLayout;
            if (view != null) {
                view.setVisibility(0);
            }
        } else {
            View view2 = this.fullScreenSwitchArrowLayout;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
        g();
    }

    public final void u() {
        this.input.setMaxLines(Integer.MAX_VALUE);
        this.doesFullScreenSwitchArrowOccupySpace = false;
        g();
    }

    public final void v() {
        t(false);
        ViewGroup viewGroup = this.grayFrame;
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        if (layoutParams != null) {
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams2).height = 0;
            layoutParams2.topToTop = 0;
            viewGroup.setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void w() {
        t(true);
        this.grayFrame.setLayoutParams(INSTANCE.b());
        this.couldLineCountAffectFullScreenArrowVisibility = true;
        this.doesFullScreenSwitchArrowOccupySpace = true;
        s(this, null, 1, null);
    }

    private final void m() {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000f\u00b8\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", ReportConstant.COSTREPORT_PREFIX, "", "afterTextChanged", "", "text", "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.b$b, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static final class C7769b implements TextWatcher {
        public C7769b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            b.s(b.this, null, 1, null);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
        }
    }
}
