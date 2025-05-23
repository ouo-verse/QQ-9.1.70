package com.tencent.mobileqq.guild.feed.part;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDeleteEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedGalleryShareViewEvent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.feed.morepanel.FeedMorePanelLauncher;
import com.tencent.mobileqq.guild.feed.morepanel.FeedSharePanelReportHelper;
import com.tencent.mobileqq.guild.feed.morepanel.PanelContext;
import com.tencent.mobileqq.guild.feed.morepanel.impl.FeedMorePanelBusiImpl;
import com.tencent.mobileqq.guild.feed.morepanel.impl.NewFeedMorePanelBusiImpl;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper;
import com.tencent.mobileqq.guild.feed.publish.event.GuildFeedMoveEvent2;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes13.dex */
public class x extends f {

    @Nullable
    private yl1.k<? extends com.tencent.mobileqq.guild.feed.morepanel.f> C;

    /* renamed from: h, reason: collision with root package name */
    private boolean f222626h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f222627i = false;

    /* renamed from: m, reason: collision with root package name */
    private String f222628m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a implements com.tencent.mobileqq.guild.feed.morepanel.handler.x {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.y
        public boolean a(@NonNull String str, @NonNull PanelContext<Activity, vk1.b> panelContext) {
            if (!str.equals("save_to_phone")) {
                return false;
            }
            return new com.tencent.mobileqq.guild.feed.morepanel.handler.t(x.this.getPartManager()).a(str, panelContext);
        }

        @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.y
        public boolean b(@NonNull String str, @NonNull PanelContext<Activity, vk1.b> panelContext) {
            return false;
        }

        @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.x
        public boolean c(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, PanelContext<Activity, vk1.b> panelContext, ShareActionSheet shareActionSheet) {
            if (39 != actionSheetItem.action) {
                return false;
            }
            return new com.tencent.mobileqq.guild.feed.morepanel.handler.t(x.this.getPartManager()).c(actionSheetItem, panelContext, shareActionSheet);
        }
    }

    private boolean C9(GuildFeedGalleryInitBean guildFeedGalleryInitBean) {
        if (guildFeedGalleryInitBean == null) {
            QLog.d("Guild.share.GuildFeedGalleryPageSharePart", 1, "checkIsCommentOrReply initBean is Null");
            return false;
        }
        QLog.d("Guild.share.GuildFeedGalleryPageSharePart", 1, "checkIsCommentOrReply commentId:", guildFeedGalleryInitBean.getCommentId(), " replyId:", guildFeedGalleryInitBean.getReplyId());
        if (TextUtils.isEmpty(guildFeedGalleryInitBean.getCommentId()) && TextUtils.isEmpty(guildFeedGalleryInitBean.getReplyId())) {
            return false;
        }
        return true;
    }

    private void D9(String str) {
        Activity activity;
        if (TextUtils.equals(this.f222628m, str) && !this.f222627i && (activity = getActivity()) != null) {
            activity.onBackPressed();
        }
    }

    private static Boolean E9(String str, String str2, String str3, long j3) {
        boolean z16;
        Boolean d16 = yl1.i.f450608a.d(str, str3, str2);
        if (d16 == null) {
            if (j3 > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            return Boolean.valueOf(z16);
        }
        return d16;
    }

    private FeedMorePanelBusiImpl.OperationListProvider.e F9(final vk1.b bVar) {
        return new FeedMorePanelBusiImpl.OperationListProvider.e() { // from class: com.tencent.mobileqq.guild.feed.part.w
            @Override // com.tencent.mobileqq.guild.feed.morepanel.impl.FeedMorePanelBusiImpl.OperationListProvider.e
            public final boolean a(String str) {
                boolean G9;
                G9 = x.G9(vk1.b.this, str);
                return G9;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean G9(vk1.b bVar, String str) {
        if (!str.equals("") && !bVar.B()) {
            return E9(String.valueOf(bVar.getGuildId()), String.valueOf(bVar.getChannelId()), bVar.getFeedId(), bVar.g()).booleanValue();
        }
        return E9(String.valueOf(bVar.getGuildId()), "", bVar.getFeedId(), bVar.getTopTimestamp()).booleanValue();
    }

    private void H9(@NonNull GProStFeed gProStFeed, @Nullable GuildFeedRichMediaData guildFeedRichMediaData) {
        yl1.k<? extends com.tencent.mobileqq.guild.feed.morepanel.f> kVar = this.C;
        if (kVar != null && kVar.b() != null && this.C.b().isShowing()) {
            return;
        }
        Activity activity = getActivity();
        if (!(activity instanceof FragmentActivity)) {
            return;
        }
        this.f222628m = gProStFeed.idd;
        vk1.a aVar = new vk1.a(new GProStFeedDetailRspWrapper(gProStFeed, guildFeedRichMediaData));
        FeedMorePanelLauncher feedMorePanelLauncher = new FeedMorePanelLauncher("pindao_feedpicture");
        com.tencent.mobileqq.guild.feed.morepanel.k d16 = feedMorePanelLauncher.d(activity, aVar, null);
        d16.e().getExtra().putBoolean("extra_key_preserve_generate_share_pic_action", true);
        d16.e().getApiRouter().a(FeedMorePanelBusiImpl.OperationListProvider.e.class, F9(aVar));
        d16.e().getApiRouter().a(com.tencent.mobileqq.guild.feed.morepanel.g.class, new FeedSharePanelReportHelper(aVar, d16.getOperationListProvider(), GuildSharePageSource.FEED_DETAIL));
        d16.e().getExtra().putBoolean("EXTRA_KEY_9090_IMPROVE_SHARE_ACTION", true);
        d16.e().getExtra().putBoolean("EXTRA_KEY_PRESERVE_SAVE_ACTION", true);
        d16.e().getExtra().putBoolean("EXTRA_KEY_FINISH_WHEN_FLOAT_WINDOW_OK", true);
        ShareActionSheet.c itemClickListener = d16.getItemClickListener();
        com.tencent.mobileqq.sharepanel.j newItemClickListener = d16.getNewItemClickListener();
        a aVar2 = new a();
        if (itemClickListener instanceof FeedMorePanelBusiImpl.a) {
            ((FeedMorePanelBusiImpl.a) itemClickListener).a().add(aVar2);
        }
        if (newItemClickListener instanceof NewFeedMorePanelBusiImpl.a) {
            ((NewFeedMorePanelBusiImpl.a) newItemClickListener).c().add(aVar2);
        }
        d16.h(new com.tencent.mobileqq.guild.feed.morepanel.impl.b(d16));
        this.C = feedMorePanelLauncher.h();
    }

    private void I9(GuildFeedGalleryShareViewEvent guildFeedGalleryShareViewEvent) {
        com.tencent.mobileqq.guild.feed.share.l lVar = new com.tencent.mobileqq.guild.feed.share.l(getActivity(), guildFeedGalleryShareViewEvent.getGalleryShareInfo(), guildFeedGalleryShareViewEvent.getSource());
        lVar.I(getPartManager());
        lVar.L(getPartRootView());
    }

    private void J9(GuildFeedGalleryShareViewEvent guildFeedGalleryShareViewEvent) {
        if (!this.f222626h) {
            QLog.i("Guild.share.GuildFeedGalleryPageSharePart", 1, "the part is not alive " + hashCode());
            return;
        }
        QLog.i("Guild.share.GuildFeedGalleryPageSharePart", 1, "showShareView");
        if (guildFeedGalleryShareViewEvent.getGalleryShareInfo() != null && guildFeedGalleryShareViewEvent.getGalleryShareInfo().b() == getActivity().hashCode()) {
            if (C9(guildFeedGalleryShareViewEvent.getGalleryInitBean())) {
                I9(guildFeedGalleryShareViewEvent);
            } else {
                H9(guildFeedGalleryShareViewEvent.getGalleryShareInfo().c(), guildFeedGalleryShareViewEvent.getGalleryShareInfo().f());
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        eventClass.add(GuildFeedGalleryShareViewEvent.class);
        eventClass.add(GuildFeedDeleteEvent.class);
        eventClass.add(GuildFeedMoveEvent2.class);
        return eventClass;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
    }

    @Override // com.tencent.mobileqq.guild.feed.part.f, com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        this.f222627i = true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        this.f222626h = false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        this.f222626h = true;
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        QLog.d("Guild.share.GuildFeedGalleryPageSharePart", 1, "onReceiveEvent_event:", simpleBaseEvent);
        if (simpleBaseEvent instanceof GuildFeedGalleryShareViewEvent) {
            J9((GuildFeedGalleryShareViewEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof GuildFeedDeleteEvent) {
            D9(((GuildFeedDeleteEvent) simpleBaseEvent).getFeedId());
        } else if (simpleBaseEvent instanceof GuildFeedMoveEvent2) {
            D9(((GuildFeedMoveEvent2) simpleBaseEvent).getFeedId());
        }
    }
}
