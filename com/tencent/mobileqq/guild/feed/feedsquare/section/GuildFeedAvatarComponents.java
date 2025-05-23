package com.tencent.mobileqq.guild.feed.feedsquare.section;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarViewWithPendant;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 +2\u00020\u0001:\u0001,B*\u0012!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00020\u0011\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fJ\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0016R/\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0014R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010%\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedAvatarComponents;", "Landroid/view/View$OnClickListener;", "", "c", "", "b", "Landroid/view/View;", "containerView", "e", "", PhotoCategorySummaryInfo.AVATAR_URL, "pendantUrl", "", "position", "d", "view", NodeProps.ON_CLICK, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlin/jvm/functions/Function1;", "onClickAvatar", "Landroid/view/View;", "f", AIInput.KEY_FRAME, "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "avatarView", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarViewWithPendant;", "i", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarViewWithPendant;", "avatarWithPendantView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "avatarPadding", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "lastAvatarUrl", "D", "lastPendantUrl", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "E", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedAvatarComponents implements View.OnClickListener {

    @NotNull
    private static final a E = new a(null);

    @Deprecated
    @NotNull
    private static final String F = "GuildFeedAvatarComponents";

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String lastAvatarUrl;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String lastPendantUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<View, Unit> onClickAvatar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View containerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View frame;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView avatarView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private GuildUserAvatarViewWithPendant avatarWithPendantView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int avatarPadding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedAvatarComponents$a;", "", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GuildFeedAvatarComponents(@NotNull Function1<? super View, Unit> onClickAvatar) {
        Intrinsics.checkNotNullParameter(onClickAvatar, "onClickAvatar");
        this.onClickAvatar = onClickAvatar;
        this.avatarPadding = ViewUtils.dpToPx(5);
        this.lastAvatarUrl = "";
        this.lastPendantUrl = "";
    }

    private final void c() {
        ImageView imageView = this.avatarView;
        GuildUserAvatarViewWithPendant guildUserAvatarViewWithPendant = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
            imageView = null;
        }
        imageView.setOnClickListener(this);
        GuildUserAvatarViewWithPendant guildUserAvatarViewWithPendant2 = this.avatarWithPendantView;
        if (guildUserAvatarViewWithPendant2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarWithPendantView");
        } else {
            guildUserAvatarViewWithPendant = guildUserAvatarViewWithPendant2;
        }
        guildUserAvatarViewWithPendant.setOnClickListener(this);
    }

    @NotNull
    public final int[] b() {
        return new int[]{R.id.w9v};
    }

    public final void d(@NotNull String avatarUrl, @NotNull String pendantUrl, int position) {
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        Intrinsics.checkNotNullParameter(pendantUrl, "pendantUrl");
        boolean z16 = false;
        View view = null;
        if (!Intrinsics.areEqual(avatarUrl, this.lastAvatarUrl) || !Intrinsics.areEqual(pendantUrl, this.lastPendantUrl)) {
            ImageView imageView = this.avatarView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarView");
                imageView = null;
            }
            imageView.setVisibility(4);
            GuildUserAvatarViewWithPendant guildUserAvatarViewWithPendant = this.avatarWithPendantView;
            if (guildUserAvatarViewWithPendant == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarWithPendantView");
                guildUserAvatarViewWithPendant = null;
            }
            guildUserAvatarViewWithPendant.setVisibility(0);
            GuildUserAvatarViewWithPendant guildUserAvatarViewWithPendant2 = this.avatarWithPendantView;
            if (guildUserAvatarViewWithPendant2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarWithPendantView");
                guildUserAvatarViewWithPendant2 = null;
            }
            guildUserAvatarViewWithPendant2.setUrl(avatarUrl, pendantUrl);
            this.lastAvatarUrl = avatarUrl;
            this.lastPendantUrl = pendantUrl;
        }
        View view2 = this.frame;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AIInput.KEY_FRAME);
            view2 = null;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        GuildUserAvatarViewWithPendant guildUserAvatarViewWithPendant3 = this.avatarWithPendantView;
        if (guildUserAvatarViewWithPendant3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarWithPendantView");
            guildUserAvatarViewWithPendant3 = null;
        }
        if (guildUserAvatarViewWithPendant3.getPendantView().getVisibility() == 0) {
            z16 = true;
        }
        if (z16) {
            marginLayoutParams.setMarginEnd(ViewUtils.dpToPx(8) - this.avatarPadding);
            View view3 = this.containerView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerView");
                view3 = null;
            }
            view3.setPadding(ViewUtils.dpToPx(16) - this.avatarPadding, view3.getPaddingTop(), view3.getPaddingRight(), view3.getPaddingBottom());
        } else {
            marginLayoutParams.setMarginEnd(ViewUtils.dpToPx(8));
            View view4 = this.containerView;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerView");
                view4 = null;
            }
            view4.setPadding(ViewUtils.dpToPx(16), view4.getPaddingTop(), view4.getPaddingRight(), view4.getPaddingBottom());
        }
        View view5 = this.frame;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AIInput.KEY_FRAME);
        } else {
            view = view5;
        }
        view.setLayoutParams(marginLayoutParams);
    }

    public final void e(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.containerView = containerView;
        View findViewById = containerView.findViewById(R.id.wa_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026ader_author_avatar_frame)");
        this.frame = findViewById;
        View findViewById2 = containerView.findViewById(R.id.wa7);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026tem_header_author_avatar)");
        this.avatarView = (ImageView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.wac);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026thor_avatar_with_pendant)");
        GuildUserAvatarViewWithPendant guildUserAvatarViewWithPendant = (GuildUserAvatarViewWithPendant) findViewById3;
        this.avatarWithPendantView = guildUserAvatarViewWithPendant;
        if (guildUserAvatarViewWithPendant == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarWithPendantView");
            guildUserAvatarViewWithPendant = null;
        }
        guildUserAvatarViewWithPendant.getAvatarView().setAvatarSize(0);
        c();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable final View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        yl1.n.i(F, 0L, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedAvatarComponents$onClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Function1 function1;
                View view2 = view;
                if (view2 != null) {
                    GuildFeedAvatarComponents guildFeedAvatarComponents = this;
                    int id5 = view2.getId();
                    boolean z16 = true;
                    if (id5 != R.id.wa7 && id5 != R.id.wac) {
                        z16 = false;
                    }
                    if (z16) {
                        function1 = guildFeedAvatarComponents.onClickAvatar;
                        function1.invoke(view2);
                    }
                }
            }
        }, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }
}
