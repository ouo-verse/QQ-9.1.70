package com.tencent.mobileqq.guild.feed.morepanel.handler;

import android.app.Activity;
import android.app.Dialog;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedPublishInfo;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedPublishEditPostInitBean;
import com.tencent.mobileqq.guild.feed.manager.GuildInfoManager;
import com.tencent.mobileqq.guild.feed.morepanel.PanelContext;
import com.tencent.mobileqq.guild.feed.morepanel.handler.x;
import com.tencent.mobileqq.guild.feed.nativepublish.utils.GuildFeedPublishUtils;
import com.tencent.mobileqq.guild.feed.util.bn;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichText;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import com.tencent.troopguild.api.ITroopGuildApi;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b#\u0010$J \u0010\b\u001a\u00020\u00072\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0002J \u0010\t\u001a\u00020\u00072\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0002J(\u0010\f\u001a\u00020\u000b2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u00052\u0006\u0010\n\u001a\u00020\u0004H\u0002J(\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0002J\u0014\u0010\u0012\u001a\u00020\u000b2\n\u0010\n\u001a\u00060\u0010j\u0002`\u0011H\u0002J0\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J(\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00182\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0018\u0010\"\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010!\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/handler/EditFeedActionHandler;", "Lcom/tencent/mobileqq/guild/feed/morepanel/handler/x;", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Landroid/app/Activity;", "Lvk1/b;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/MorePanelContext;", "panelContext", "", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "feed", "", "l", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "bean", "k", "Lqj1/o;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IRawDataProvider;", "j", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "c", "", "id", "a", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "startEditorTask", "b", "showLoadingTask", "Landroid/app/Dialog;", "Landroid/app/Dialog;", "loadDialog", "<init>", "()V", "d", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class EditFeedActionHandler implements x {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final a f220266d = new a(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qcoroutine.api.coroutine.b startEditorTask;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qcoroutine.api.coroutine.b showLoadingTask;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Dialog loadDialog;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/handler/EditFeedActionHandler$a;", "", "", "FEED_EDIT_FAILED", "Ljava/lang/String;", "", "GET_FEED_DETAIL_TIME_OUT", "J", "LOADING_DIALOG_DELAY_SHOW", "TAG", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(qj1.o feed) {
        Integer num;
        ArrayList<GProStRichTextContent> arrayList;
        Object a16 = feed.a();
        if (a16 instanceof GProStFeed) {
            GProStRichText gProStRichText = ((GProStFeed) a16).contents;
            if (gProStRichText != null && (arrayList = gProStRichText.contents) != null) {
                num = Integer.valueOf(arrayList.size());
            } else {
                num = null;
            }
            QLog.d("EditFeedActionHandler", 1, "[debugFeedContent]: content.length=" + num);
            return;
        }
        QLog.e("EditFeedActionHandler", 1, "raw data isn't target type, " + a16.getClass());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(GuildFeedBaseInitBean bean, PanelContext<Activity, vk1.b> panelContext) {
        GProStFeed gProStFeed;
        if (panelContext.getExtra().getInt("src_business_type") != 7) {
            return;
        }
        bean.setBusinessType(7);
        Object a16 = panelContext.j().a();
        Long l3 = null;
        if (a16 instanceof GProStFeed) {
            gProStFeed = (GProStFeed) a16;
        } else {
            gProStFeed = null;
        }
        if (gProStFeed != null) {
            l3 = Long.valueOf(gProStFeed.groupCode);
        }
        if (l3 != null && l3.longValue() > 0) {
            bean.setTroopUin(l3.toString());
            ITroopGuildApi iTroopGuildApi = (ITroopGuildApi) QRoute.api(ITroopGuildApi.class);
            String troopUin = bean.getTroopUin();
            Intrinsics.checkNotNullExpressionValue(troopUin, "bean.troopUin");
            bean.setTroopRole(iTroopGuildApi.getTroopGuildRole(troopUin));
            return;
        }
        vk1.b j3 = panelContext.j();
        QLog.e("EditFeedActionHandler", 1, "fillBeanIfTroop err feedId:" + j3.getFeedId() + " guild:" + j3.getGuildId() + " channel:" + j3.getChannelId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(PanelContext<Activity, vk1.b> panelContext, vk1.b feed) {
        Activity h16 = panelContext.h();
        GuildFeedPublishEditPostInitBean guildFeedPublishEditPostInitBean = new GuildFeedPublishEditPostInitBean();
        guildFeedPublishEditPostInitBean.setBusinessType(5);
        guildFeedPublishEditPostInitBean.setGuildId(String.valueOf(feed.getGuildId()));
        guildFeedPublishEditPostInitBean.setChannelId(String.valueOf(feed.getChannelId()));
        guildFeedPublishEditPostInitBean.setChannelName(feed.q());
        guildFeedPublishEditPostInitBean.setFeedId(feed.getFeedId());
        guildFeedPublishEditPostInitBean.setPosterTinyId(feed.r());
        guildFeedPublishEditPostInitBean.setCreateTime(feed.getCreateTime());
        k(guildFeedPublishEditPostInitBean, panelContext);
        HashMap<String, Serializable> attrs = guildFeedPublishEditPostInitBean.getAttrs();
        Intrinsics.checkNotNullExpressionValue(attrs, "attrs");
        attrs.put("launch_request_id", Integer.valueOf(panelContext.h().hashCode()));
        GuildFeedLauncher.C(h16, guildFeedPublishEditPostInitBean);
    }

    private final boolean m(PanelContext<Activity, vk1.b> panelContext) {
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar;
        Job f16;
        Job f17;
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar2 = this.startEditorTask;
        if (bVar2 != null && (f17 = bVar2.f()) != null) {
            f17.cancel(new CancellationException("EditFeedActionHandler,cancel for prepareArgsAndStartEditor first"));
        }
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar3 = this.showLoadingTask;
        if (bVar3 != null && (f16 = bVar3.f()) != null) {
            f16.cancel(new CancellationException("EditFeedActionHandler,cancel for prepareArgsAndStartEditor first"));
        }
        Dialog dialog = this.loadDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        com.tencent.mobileqq.qcoroutine.framework.impl.a aVar = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a;
        i.e eVar = i.e.f261783e;
        CoroutineScope f18 = aVar.f(eVar);
        com.tencent.mobileqq.qcoroutine.api.coroutine.b bVar4 = null;
        if (f18 != null) {
            bVar = CorountineFunKt.e(f18, "EditFeedActionHandler delay show dialog", null, null, null, new EditFeedActionHandler$prepareArgsAndStartEditor$1(panelContext, this, null), 14, null);
        } else {
            bVar = null;
        }
        this.showLoadingTask = bVar;
        CoroutineScope f19 = aVar.f(eVar);
        if (f19 != null) {
            bVar4 = CorountineFunKt.e(f19, "EditFeedActionHandler handle get feed", null, null, Boolean.TRUE, new EditFeedActionHandler$prepareArgsAndStartEditor$2(this, panelContext, null), 6, null);
        }
        this.startEditorTask = bVar4;
        return true;
    }

    private final boolean n(PanelContext<Activity, vk1.b> panelContext) {
        GuildFeedPublishInfo guildFeedPublishInfo;
        com.tencent.mobileqq.guild.feed.morepanel.cooperate.l lVar = (com.tencent.mobileqq.guild.feed.morepanel.cooperate.l) panelContext.getApiRouter().b(com.tencent.mobileqq.guild.feed.morepanel.cooperate.l.class);
        if (lVar != null) {
            guildFeedPublishInfo = lVar.provide();
        } else {
            guildFeedPublishInfo = null;
        }
        QLog.d("EditFeedActionHandler", 1, "obtain publishInfo: " + guildFeedPublishInfo);
        boolean z16 = false;
        if (guildFeedPublishInfo != null && bn.f223895a.a(guildFeedPublishInfo)) {
            z16 = true;
        }
        if (z16) {
            return true;
        }
        if (!GuildFeedPublishUtils.f222315a.j(panelContext.h(), String.valueOf(panelContext.j().getGuildId()), String.valueOf(panelContext.j().getChannelId()), !GuildInfoManager.q().P(r0))) {
            return true;
        }
        return m(panelContext);
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.y
    public boolean a(@NotNull String id5, @NotNull PanelContext<Activity, vk1.b> panelContext) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(panelContext, "panelContext");
        return n(panelContext);
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.y
    public boolean b(@NotNull String str, @NotNull PanelContext<Activity, vk1.b> panelContext) {
        return x.a.c(this, str, panelContext);
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.x
    public boolean c(@NotNull ShareActionSheetBuilder.ActionSheetItem item, @NotNull PanelContext<Activity, vk1.b> panelContext, @NotNull ShareActionSheet shareActionSheet) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(panelContext, "panelContext");
        Intrinsics.checkNotNullParameter(shareActionSheet, "shareActionSheet");
        shareActionSheet.dismiss();
        return n(panelContext);
    }
}
