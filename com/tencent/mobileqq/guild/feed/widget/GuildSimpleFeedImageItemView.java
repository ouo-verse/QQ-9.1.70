package com.tencent.mobileqq.guild.feed.widget;

import android.content.Context;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDefaultInitBean;
import com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\b\u0010\fB!\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\b\u0010\u000fJ\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0014\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/widget/GuildSimpleFeedImageItemView;", "Lcom/tencent/mobileqq/guild/feed/widget/GuildFeedBaseItemView;", "", "Lcom/tencent/mobileqq/guild/feed/presenter/GuildBaseFeedChildPresenter;", "Lij1/g;", "q0", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "viewType", "(Landroid/content/Context;I)V", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDefaultInitBean;", "defaultInitBean", "(Landroid/content/Context;ILcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDefaultInitBean;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildSimpleFeedImageItemView extends GuildFeedBaseItemView {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildSimpleFeedImageItemView(@NotNull Context context) {
        this(context, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.mobileqq.guild.feed.widget.GuildFeedBaseItemView
    @NotNull
    protected List<GuildBaseFeedChildPresenter<ij1.g>> q0() {
        List<GuildBaseFeedChildPresenter<ij1.g>> listOf;
        GuildFeedDefaultInitBean bean = this.f224139f;
        Intrinsics.checkNotNullExpressionValue(bean, "bean");
        GuildFeedDefaultInitBean bean2 = this.f224139f;
        Intrinsics.checkNotNullExpressionValue(bean2, "bean");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new GuildBaseFeedChildPresenter[]{new com.tencent.mobileqq.guild.feed.presenter.m(bean), new com.tencent.mobileqq.guild.feed.presenter.n(bean2)});
        return listOf;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildSimpleFeedImageItemView(@NotNull Context context, int i3) {
        super(context, Integer.valueOf(i3));
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildSimpleFeedImageItemView(@NotNull Context context, int i3, @NotNull GuildFeedDefaultInitBean defaultInitBean) {
        super(context, Integer.valueOf(i3), defaultInitBean);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(defaultInitBean, "defaultInitBean");
    }
}
