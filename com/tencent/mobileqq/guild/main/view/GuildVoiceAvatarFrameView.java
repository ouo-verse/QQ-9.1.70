package com.tencent.mobileqq.guild.main.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.TraceUtils;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 42\u00020\u0001:\u00025\u0007B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010.\u0012\b\b\u0002\u00100\u001a\u00020\u0011\u0012\b\b\u0002\u00101\u001a\u00020\u0011\u00a2\u0006\u0004\b2\u00103J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\b\u0010\r\u001a\u00020\u0004H\u0014J\b\u0010\u000e\u001a\u00020\u0004H\u0014J\u001e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0019R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010%R\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001b\u0010-\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\u001a\u0004\b)\u0010**\u0004\b+\u0010,\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/guild/main/view/GuildVoiceAvatarFrameView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "", "d", "Landroid/animation/ObjectAnimator;", "b", "Lcom/tencent/mobileqq/guild/main/view/GuildVoiceAvatarFrameView$a;", "avatarInfo", "setAvatarData", "e", "f", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "", "outerFrameMaxAlpha", "", "innerFrameStrokeWidth", "outerFrameStrokeWidth", "setAvatarStyle", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "avatarView", "Landroid/view/View;", "Landroid/view/View;", "innerFrame", "outerFrame", "", h.F, "Z", "isVoicing", "Lkotlin/Lazy;", "i", "Lkotlin/Lazy;", "alphaAnimatorDelegate", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", BdhLogUtil.LogTag.Tag_Conn, "D", UserInfo.SEX_FEMALE, "c", "()Landroid/animation/ObjectAnimator;", "getAlphaAnimator$delegate", "(Lcom/tencent/mobileqq/guild/main/view/GuildVoiceAvatarFrameView;)Ljava/lang/Object;", "alphaAnimator", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "E", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildVoiceAvatarFrameView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private int outerFrameStrokeWidth;

    /* renamed from: D, reason: from kotlin metadata */
    private float outerFrameMaxAlpha;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private GuildUserAvatarView avatarView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View innerFrame;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View outerFrame;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isVoicing;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy<ObjectAnimator> alphaAnimatorDelegate;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int innerFrameStrokeWidth;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/guild/main/view/GuildVoiceAvatarFrameView$a;", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final /* data */ class a {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildVoiceAvatarFrameView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ObjectAnimator b() {
        View view = this.outerFrame;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("outerFrame");
            view = null;
        }
        float f16 = this.outerFrameMaxAlpha;
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, f16, 0.0f, f16);
        alphaAnimator.setDuration(900L);
        alphaAnimator.setRepeatCount(-1);
        Intrinsics.checkNotNullExpressionValue(alphaAnimator, "alphaAnimator");
        return alphaAnimator;
    }

    private final ObjectAnimator c() {
        return this.alphaAnimatorDelegate.getValue();
    }

    private final void d(Context context) {
        View view = new View(context);
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        view.setVisibility(8);
        view.setBackgroundResource(R.drawable.guild_avatar_frame_circle);
        this.outerFrame = view;
        addView(view);
        GuildUserAvatarView guildUserAvatarView = new GuildUserAvatarView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        int i3 = this.outerFrameStrokeWidth;
        layoutParams.setMargins(i3, i3, i3, i3);
        guildUserAvatarView.setLayoutParams(layoutParams);
        guildUserAvatarView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        guildUserAvatarView.setAvatarSize(3);
        guildUserAvatarView.setLogTag("GuildVoiceAvatarFrameView");
        this.avatarView = guildUserAvatarView;
        addView(guildUserAvatarView);
        View view2 = new View(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        int i16 = this.outerFrameStrokeWidth;
        layoutParams2.setMargins(i16, i16, i16, i16);
        view2.setLayoutParams(layoutParams2);
        view2.setVisibility(8);
        view2.setBackgroundResource(R.drawable.guild_avatar_frame_circle);
        this.innerFrame = view2;
        addView(view2);
    }

    public final void e() {
        if (this.isVoicing) {
            c().start();
        }
    }

    public final void f() {
        if (this.alphaAnimatorDelegate.isInitialized() && c().isRunning()) {
            c().end();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.isVoicing) {
            e();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f();
    }

    public final void setAvatarData(@NotNull a avatarInfo) {
        Intrinsics.checkNotNullParameter(avatarInfo, "avatarInfo");
        TraceUtils.h("GuildVoiceAvatarFrameView_setAvatarData");
        throw null;
    }

    public final void setAvatarStyle(float outerFrameMaxAlpha, int innerFrameStrokeWidth, int outerFrameStrokeWidth) {
        this.outerFrameMaxAlpha = outerFrameMaxAlpha;
        this.innerFrameStrokeWidth = innerFrameStrokeWidth;
        this.outerFrameStrokeWidth = outerFrameStrokeWidth;
        View view = this.innerFrame;
        GuildUserAvatarView guildUserAvatarView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("innerFrame");
            view = null;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(outerFrameStrokeWidth, outerFrameStrokeWidth, outerFrameStrokeWidth, outerFrameStrokeWidth);
        GuildUserAvatarView guildUserAvatarView2 = this.avatarView;
        if (guildUserAvatarView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
        } else {
            guildUserAvatarView = guildUserAvatarView2;
        }
        ViewGroup.LayoutParams layoutParams2 = guildUserAvatarView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams2).setMargins(outerFrameStrokeWidth, outerFrameStrokeWidth, outerFrameStrokeWidth, outerFrameStrokeWidth);
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildVoiceAvatarFrameView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildVoiceAvatarFrameView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildVoiceAvatarFrameView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildVoiceAvatarFrameView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Lazy<ObjectAnimator> lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ObjectAnimator>() { // from class: com.tencent.mobileqq.guild.main.view.GuildVoiceAvatarFrameView$alphaAnimatorDelegate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ObjectAnimator invoke() {
                ObjectAnimator b16;
                b16 = GuildVoiceAvatarFrameView.this.b();
                return b16;
            }
        });
        this.alphaAnimatorDelegate = lazy;
        this.innerFrameStrokeWidth = QQGuildUIUtil.f(1.0f);
        this.outerFrameStrokeWidth = QQGuildUIUtil.f(1.0f);
        this.outerFrameMaxAlpha = 0.3f;
        d(context);
    }
}
