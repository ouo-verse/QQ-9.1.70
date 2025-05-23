package com.tencent.mobileqq.guild.feed.presenter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedAvatarComponents;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDefaultInitBean;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStUser;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u001a\u0010\r\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0016\u0010\b\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/presenter/GuildFeedAvatarPresenter;", "Lcom/tencent/mobileqq/guild/feed/presenter/GuildBaseFeedChildPresenter;", "Lij1/g;", "Landroid/view/View;", "view", "", "w", "u", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "o", "data", "", "position", "v", UserInfo.SEX_FEMALE, "Landroid/view/View;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedAvatarComponents;", "G", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedAvatarComponents;", "components", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDefaultInitBean;", "bean", "<init>", "(Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDefaultInitBean;)V", "H", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedAvatarPresenter extends GuildBaseFeedChildPresenter<ij1.g> {

    /* renamed from: F, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final GuildFeedAvatarComponents components;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedAvatarPresenter(@NotNull GuildFeedDefaultInitBean bean) {
        super(bean);
        Intrinsics.checkNotNullParameter(bean, "bean");
        this.components = new GuildFeedAvatarComponents(new GuildFeedAvatarPresenter$components$1(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void u(View view) {
        T t16;
        if (view != null && (t16 = this.f222800d) != 0 && ((ij1.g) t16).b() != null) {
            View view2 = this.rootView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                view2 = null;
            }
            GuildFeedBaseInitBean q16 = ax.q(view2.getContext());
            if (q16 != null) {
                com.tencent.mobileqq.guild.feed.report.e.c(((ij1.g) this.f222800d).b(), "avatar_click", q16.getPageId(), q16.getPageForumType(q16.getPageId()), q16.getPrePageId(), q16.getPrePageForumType(q16.getPrePageId()));
            }
            com.tencent.mobileqq.guild.feed.report.d.a("clck", view, "em_sgrp_forum_avatar", e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void w(View view) {
        if (this.D.getBusinessType() == 7) {
            GProStUser gProStUser = ((ij1.g) this.f222800d).b().poster;
            if (gProStUser != null) {
                long j3 = ((ij1.g) this.f222800d).b().groupCode;
                long j16 = gProStUser.uin;
                QLog.d("GuildFeedAvatarPresenter", 1, "\u8c03\u8d77\u7fa4\u5e16\u5b50\u6210\u5458\u8d44\u6599\u5361 groupId = " + j3 + ", uin = " + j16);
                ax.M(String.valueOf(j3), String.valueOf(j16));
            }
        } else {
            String valueOf = String.valueOf(((ij1.g) this.f222800d).b().channelInfo.sign.guildId);
            String str = ((ij1.g) this.f222800d).b().idd.toString();
            QLog.d("GuildFeedAvatarPresenter", 1, "\u8c03\u8d77\u9891\u9053\u5e16\u5b50\u8d44\u6599\u5361 guildId:" + valueOf + ", feedId:" + str + ", tinyId:" + String.valueOf(((ij1.g) this.f222800d).b().channelInfo.sign.channelId) + ", getChannelId: " + this.D.getChannelId());
            Context context = view.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            ax.I((Activity) context, valueOf, this.D.getChannelId(), ((ij1.g) this.f222800d).b().poster.idd, str, this.D.getBusinessType(), this.D.getJoinInfoParam());
        }
        u(view);
    }

    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter
    public void o(@NotNull View rootView) {
        int first;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.o(rootView);
        this.rootView = rootView;
        RFWLayoutPreLoader d16 = gj1.a.a().d();
        first = ArraysKt___ArraysKt.first(this.components.b());
        View findViewById = rootView.findViewById(first);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.view.ViewStub");
        d16.requestPreloadViewForViewStub((ViewStub) findViewById, this);
        GuildFeedAvatarComponents guildFeedAvatarComponents = this.components;
        View findViewById2 = rootView.findViewById(R.id.v3b);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026.feed_square_item_layout)");
        guildFeedAvatarComponents.e(findViewById2);
    }

    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void k(@Nullable ij1.g data, int position) {
        GProStFeed b16;
        GProStUser gProStUser;
        super.k(data, position);
        if (data != null && (b16 = data.b()) != null && (gProStUser = b16.poster) != null) {
            GuildFeedAvatarComponents guildFeedAvatarComponents = this.components;
            String str = gProStUser.icon.iconUrl;
            Intrinsics.checkNotNullExpressionValue(str, "user.icon.iconUrl");
            String str2 = gProStUser.avatarPendant;
            Intrinsics.checkNotNullExpressionValue(str2, "user.avatarPendant");
            guildFeedAvatarComponents.d(str, str2, position);
        }
    }
}
