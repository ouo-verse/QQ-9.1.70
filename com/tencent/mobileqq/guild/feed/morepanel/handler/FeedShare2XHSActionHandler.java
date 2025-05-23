package com.tencent.mobileqq.guild.feed.morepanel.handler;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.event.GuildFeedShareChannelEvent;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedPublishInfo;
import com.tencent.mobileqq.guild.feed.morepanel.PanelContext;
import com.tencent.mobileqq.guild.feed.morepanel.handler.x;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.compat.FeedDetailMainDisplayableParser;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.util.LoadingUtil;
import com.tencent.util.QQToastUtil;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J \u0010\b\u001a\u00020\u00072\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0002J0\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016J(\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0016R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/handler/FeedShare2XHSActionHandler;", "Lcom/tencent/mobileqq/guild/feed/morepanel/handler/x;", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Landroid/app/Activity;", "Lvk1/b;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/MorePanelContext;", "panelContext", "", "e", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "c", "", "id", "b", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "a", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "task", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedShare2XHSActionHandler implements x {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final a f220274b = new a(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qcoroutine.api.coroutine.b task;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/handler/FeedShare2XHSActionHandler$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    private final boolean e(PanelContext<Activity, vk1.b> panelContext) {
        GuildFeedPublishInfo guildFeedPublishInfo;
        Job f16;
        if (FastClickUtils.isFastDoubleClick("SPic.FeedShare2XHSActionHandler", 1000L)) {
            return true;
        }
        GuildFeedShareChannelEvent.INSTANCE.a("feedShare2XHSActionHandler", new GuildFeedShareChannelEvent(String.valueOf(panelContext.j().getGuildId()), String.valueOf(panelContext.j().getChannelId()), panelContext.j().getFeedId(), 6, null, 16, null));
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToastUtil.showQQToast(1, R.string.f1511016s);
            return true;
        }
        if (!m02.d.f415923a.d(panelContext.h())) {
            return true;
        }
        GenerateFeedSharePictureV2Handler.INSTANCE.l(new FeedDetailMainDisplayableParser(panelContext.j()));
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this.task;
        if (bVar != null && (f16 = bVar.f()) != null) {
            f16.cancel(new CancellationException("cancel for generate picture first"));
        }
        Dialog showOnlyLoadingImageDialog = LoadingUtil.showOnlyLoadingImageDialog(panelContext.h(), 2, true);
        showOnlyLoadingImageDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.l
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                FeedShare2XHSActionHandler.f(FeedShare2XHSActionHandler.this, dialogInterface);
            }
        });
        showOnlyLoadingImageDialog.show();
        com.tencent.mobileqq.guild.feed.morepanel.cooperate.l lVar = (com.tencent.mobileqq.guild.feed.morepanel.cooperate.l) panelContext.getApiRouter().b(com.tencent.mobileqq.guild.feed.morepanel.cooperate.l.class);
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar2 = null;
        if (lVar != null) {
            guildFeedPublishInfo = lVar.provide();
        } else {
            guildFeedPublishInfo = null;
        }
        boolean e16 = com.tencent.mobileqq.guild.feed.feedsquare.data.g.e(guildFeedPublishInfo);
        CoroutineScope f17 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        if (f17 != null) {
            bVar2 = CorountineFunKt.e(f17, "SPic.FeedShare2XHSActionHandler handle fetch url", null, null, Boolean.TRUE, new FeedShare2XHSActionHandler$realHandle$1(showOnlyLoadingImageDialog, panelContext, e16, null), 6, null);
        }
        this.task = bVar2;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(FeedShare2XHSActionHandler this$0, DialogInterface dialogInterface) {
        Job f16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.f235387a.d().i("SPic.FeedShare2XHSActionHandler", 1, "cancel share");
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar = this$0.task;
        if (bVar != null && (f16 = bVar.f()) != null) {
            f16.cancel(new CancellationException("SPic.FeedShare2XHSActionHandler,cancel for generate picture by cancel dialog"));
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.y
    public boolean a(@NotNull String str, @NotNull PanelContext<Activity, vk1.b> panelContext) {
        return x.a.b(this, str, panelContext);
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.y
    public boolean b(@NotNull String id5, @NotNull PanelContext<Activity, vk1.b> panelContext) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(panelContext, "panelContext");
        return e(panelContext);
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.x
    public boolean c(@NotNull ShareActionSheetBuilder.ActionSheetItem item, @NotNull PanelContext<Activity, vk1.b> panelContext, @NotNull ShareActionSheet shareActionSheet) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(panelContext, "panelContext");
        Intrinsics.checkNotNullParameter(shareActionSheet, "shareActionSheet");
        shareActionSheet.dismiss();
        return e(panelContext);
    }
}
