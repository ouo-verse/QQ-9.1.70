package com.tencent.mobileqq.guild.discovery.search;

import ah1.a;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.banner.DownToUpViewSwitcher;
import com.tencent.mobileqq.guild.discovery.search.GuildSearchEntryView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001)B'\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010%\u001a\u00020$\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0003J\u0010\u0010\u000b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tJ\b\u0010\f\u001a\u00020\u0003H\u0014J\b\u0010\r\u001a\u00020\u0003H\u0014J\u0006\u0010\u000e\u001a\u00020\u0003J\u0006\u0010\u000f\u001a\u00020\u0003J\u0006\u0010\u0010\u001a\u00020\u0003J\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/search/GuildSearchEntryView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/theme/SkinnableView;", "", "g", "", "isUseTokenType", "setIsUseTokenType", "setCenterAlign", "Landroid/view/View$OnClickListener;", "l", "setSearchClickListener", NodeProps.ON_DETACHED_FROM_WINDOW, NodeProps.ON_ATTACHED_TO_WINDOW, "e", "d", "f", "", "c", "onThemeChanged", "Landroid/view/View;", "Landroid/view/View;", "mRootView", "Lcom/tencent/mobileqq/guild/component/banner/DownToUpViewSwitcher;", "Lcom/tencent/mobileqq/guild/component/banner/DownToUpViewSwitcher;", "mSearchHotWordHintTv", "Lah1/a;", "Lah1/a;", "mHotSearchAnimController", h.F, "Z", "mIsUseTokenType", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "i", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildSearchEntryView extends RelativeLayout implements SkinnableView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View mRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private DownToUpViewSwitcher mSearchHotWordHintTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private a mHotSearchAnimController;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mIsUseTokenType;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildSearchEntryView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildSearchEntryView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewCompat.setImportantForAccessibility(this$0.mSearchHotWordHintTv, 2);
    }

    private final void g() {
        QLog.i("Guild.search.GuildSearchBar", 1, "mIsUseTokenType: " + this.mIsUseTokenType);
        if (this.mIsUseTokenType) {
            this.mSearchHotWordHintTv.setBackgroundResource(R.drawable.guild_token_discover_new_search_bar_bg_select);
            this.mSearchHotWordHintTv.setStateListAnimator(null);
        } else {
            this.mSearchHotWordHintTv.setBackgroundResource(R.drawable.guild_discover_search_box_bg);
            this.mSearchHotWordHintTv.setStateListAnimator(AnimatorInflater.loadStateListAnimator(getContext(), R.animator.f155134n));
        }
    }

    @NotNull
    public final String c() {
        return this.mHotSearchAnimController.f();
    }

    public final void d() {
        this.mHotSearchAnimController.h();
    }

    public final void e() {
        this.mHotSearchAnimController.g();
    }

    public final void f() {
        this.mHotSearchAnimController.n();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        this.mHotSearchAnimController.i();
    }

    public final void setCenterAlign() {
        this.mHotSearchAnimController.k();
    }

    public final void setIsUseTokenType(boolean isUseTokenType) {
        if (this.mIsUseTokenType != isUseTokenType) {
            this.mIsUseTokenType = isUseTokenType;
            g();
            this.mHotSearchAnimController.l(isUseTokenType);
        }
    }

    public final void setSearchClickListener(@Nullable View.OnClickListener l3) {
        this.mSearchHotWordHintTv.setOnClickListener(l3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildSearchEntryView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildSearchEntryView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildSearchEntryView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ekn, (ViewGroup) this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(getContext()).infla\u2026w_search_bar, this, true)");
        this.mRootView = inflate;
        View findViewById = findViewById(R.id.wzq);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.guild_search_tip_hot_word)");
        this.mSearchHotWordHintTv = (DownToUpViewSwitcher) findViewById;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, up1.a.V4, i3, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026efStyleAttrs, 0\n        )");
        this.mIsUseTokenType = obtainStyledAttributes.getBoolean(up1.a.W4, false);
        obtainStyledAttributes.recycle();
        this.mHotSearchAnimController = new a(this, this.mIsUseTokenType);
        g();
        post(new Runnable() { // from class: nh1.a
            @Override // java.lang.Runnable
            public final void run() {
                GuildSearchEntryView.b(GuildSearchEntryView.this);
            }
        });
    }
}
