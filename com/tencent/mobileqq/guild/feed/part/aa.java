package com.tencent.mobileqq.guild.feed.part;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Supplier;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDeleteEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedGalleryShareViewEvent;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedPublishInfo;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.feed.morepanel.FeedMorePanelLauncher;
import com.tencent.mobileqq.guild.feed.morepanel.FeedSharePanelReportHelper;
import com.tencent.mobileqq.guild.feed.morepanel.PanelContext;
import com.tencent.mobileqq.guild.feed.morepanel.impl.FeedMorePanelBusiImpl;
import com.tencent.mobileqq.guild.feed.morepanel.impl.NewFeedMorePanelBusiImpl;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper;
import com.tencent.mobileqq.guild.feed.publish.event.GuildFeedMoveEvent2;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.util.bn;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes13.dex */
public class aa extends f {
    private GuildFeedGalleryInitBean C;
    private String D;

    @Nullable
    private yl1.k<? extends com.tencent.mobileqq.guild.feed.morepanel.f> E;

    /* renamed from: m, reason: collision with root package name */
    private View f222491m;

    /* renamed from: h, reason: collision with root package name */
    private boolean f222489h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f222490i = false;
    private final zp1.a<jk1.a> F = new a();

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class a implements zp1.a<jk1.a> {
        a() {
        }

        @Override // zp1.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void f(int i3, jk1.a aVar, Supplier<Map<String, Object>> supplier, int i16) {
            GuildFeedRichMediaData guildFeedRichMediaData;
            if (bn.l(aa.this.M9())) {
                return;
            }
            QLog.d("Guild_Feed_GAL_GuildFeedGallerySharePart", 1, "openMorePanel mediaIndex:", Integer.valueOf(i16), " position:", Integer.valueOf(i3));
            if (aa.this.E != null && aa.this.E.b() != null && ((com.tencent.mobileqq.guild.feed.morepanel.f) aa.this.E.b()).isShowing()) {
                return;
            }
            if (aVar != null) {
                aa.this.R9(aVar.getInitBean());
                if (aa.this.C != null && aa.this.C.getRichMediaDataList() != null && i16 >= 0 && i16 < aa.this.C.getRichMediaDataList().size()) {
                    guildFeedRichMediaData = aa.this.C.getRichMediaDataList().get(i16);
                } else {
                    guildFeedRichMediaData = null;
                }
                QLog.d("Guild_Feed_GAL_GuildFeedGallerySharePart", 1, "openMorePanel currentMediaData:", guildFeedRichMediaData);
                aa.this.T9(aVar.b(), guildFeedRichMediaData, null, i16);
                return;
            }
            QLog.w("Guild_Feed_GAL_GuildFeedGallerySharePart", 1, "openMorePanel feed == null, return");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class b implements com.tencent.mobileqq.guild.feed.morepanel.handler.x {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GuildFeedRichMediaData f222493a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f222494b;

        b(GuildFeedRichMediaData guildFeedRichMediaData, int i3) {
            this.f222493a = guildFeedRichMediaData;
            this.f222494b = i3;
        }

        @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.y
        public boolean a(@NonNull String str, @NonNull PanelContext<Activity, vk1.b> panelContext) {
            if (str.equals("save_to_phone")) {
                return new com.tencent.mobileqq.guild.feed.morepanel.handler.t(aa.this.getPartManager()).a(str, panelContext);
            }
            if (str.equals("floating_window")) {
                return aa.this.Q9(this.f222493a, this.f222494b);
            }
            return false;
        }

        @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.y
        public boolean b(@NonNull String str, @NonNull PanelContext<Activity, vk1.b> panelContext) {
            return false;
        }

        @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.x
        public boolean c(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, PanelContext<Activity, vk1.b> panelContext, ShareActionSheet shareActionSheet) {
            int i3 = actionSheetItem.action;
            if (39 == i3) {
                return new com.tencent.mobileqq.guild.feed.morepanel.handler.t(aa.this.getPartManager()).c(actionSheetItem, panelContext, shareActionSheet);
            }
            if (179 == i3 || i3 == 216) {
                return aa.this.Q9(this.f222493a, this.f222494b);
            }
            return false;
        }
    }

    private void J9(String str) {
        Activity activity;
        if (TextUtils.equals(this.D, str) && !this.f222490i && (activity = getActivity()) != null) {
            activity.onBackPressed();
        }
    }

    private com.tencent.mobileqq.guild.feed.share.c K9(GuildFeedRichMediaData guildFeedRichMediaData, int i3) {
        com.tencent.mobileqq.guild.feed.share.c cVar = new com.tencent.mobileqq.guild.feed.share.c();
        cVar.l(M9().getFeed());
        cVar.k(getContext().hashCode());
        cVar.o(guildFeedRichMediaData);
        cVar.p(i3);
        cVar.n(M9().getGuildId());
        cVar.j(M9().getChannelId());
        cVar.q(M9().getPosterId());
        cVar.m(M9().getFromPage());
        cVar.i(M9().getBusinessType());
        return cVar;
    }

    private FeedMorePanelBusiImpl.OperationListProvider.e L9(final vk1.b bVar) {
        return new FeedMorePanelBusiImpl.OperationListProvider.e() { // from class: com.tencent.mobileqq.guild.feed.part.z
            @Override // com.tencent.mobileqq.guild.feed.morepanel.impl.FeedMorePanelBusiImpl.OperationListProvider.e
            public final boolean a(String str) {
                boolean O9;
                O9 = aa.O9(vk1.b.this, str);
                return O9;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GuildFeedGalleryInitBean M9() {
        if (this.C == null) {
            N9();
        }
        return this.C;
    }

    private void N9() {
        GuildFeedBaseInitBean o16 = ax.o(getHostFragment());
        if (o16 instanceof GuildFeedGalleryInitBean) {
            R9((GuildFeedGalleryInitBean) o16);
            QLog.d("Guild_Feed_GAL_GuildFeedGallerySharePart", 4, "[initPageBean] getInitBeanSuccess:" + this.C);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean O9(vk1.b bVar, String str) {
        boolean z16 = true;
        if (!str.equals("") && !bVar.B()) {
            Boolean d16 = yl1.i.f450608a.d(String.valueOf(bVar.getGuildId()), bVar.getFeedId(), str);
            if (d16 == null) {
                if (bVar.g() <= 0) {
                    z16 = false;
                }
                d16 = Boolean.valueOf(z16);
            }
            return d16.booleanValue();
        }
        Boolean d17 = yl1.i.f450608a.d(String.valueOf(bVar.getGuildId()), bVar.getFeedId(), "");
        if (d17 == null) {
            if (bVar.getTopTimestamp() <= 0) {
                z16 = false;
            }
            d17 = Boolean.valueOf(z16);
        }
        return d17.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P9(GuildFeedGalleryShareViewEvent guildFeedGalleryShareViewEvent) {
        T9(guildFeedGalleryShareViewEvent.getGalleryShareInfo().c(), guildFeedGalleryShareViewEvent.getGalleryShareInfo().f(), guildFeedGalleryShareViewEvent.getGalleryShareInfo(), guildFeedGalleryShareViewEvent.getGalleryShareInfo().g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Q9(GuildFeedRichMediaData guildFeedRichMediaData, int i3) {
        if (getHostFragment() != null && !getHostFragment().isDetached() && getHostFragment().getActivity() != null && M9() != null) {
            com.tencent.mobileqq.guild.feed.share.p pVar = new com.tencent.mobileqq.guild.feed.share.p();
            pVar.d(getHostFragment().getActivity());
            pVar.e(K9(guildFeedRichMediaData, i3));
            String name = com.tencent.mobileqq.guild.feed.share.x.class.getName();
            pVar.A(name);
            S9(name);
            return true;
        }
        QLog.e("Guild_Feed_GAL_GuildFeedGallerySharePart", 1, "playerByFloatWindow position=" + i3);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R9(GuildFeedGalleryInitBean guildFeedGalleryInitBean) {
        this.C = guildFeedGalleryInitBean;
    }

    private void S9(String str) {
        com.tencent.mobileqq.qqfloatingwindow.a floatingProxyWrapper = ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).getFloatingProxyWrapper(BaseApplication.getContext(), str);
        if (floatingProxyWrapper instanceof com.tencent.mobileqq.guild.feed.share.x) {
            ((com.tencent.mobileqq.guild.feed.share.x) floatingProxyWrapper).t0(M9());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T9(@NonNull GProStFeed gProStFeed, @Nullable GuildFeedRichMediaData guildFeedRichMediaData, @Nullable com.tencent.mobileqq.guild.feed.share.c cVar, int i3) {
        if (bn.l(M9())) {
            return;
        }
        yl1.k<? extends com.tencent.mobileqq.guild.feed.morepanel.f> kVar = this.E;
        if (kVar != null && kVar.b() != null && this.E.b().isShowing()) {
            return;
        }
        Activity activity = getActivity();
        if (!(activity instanceof FragmentActivity)) {
            return;
        }
        this.D = gProStFeed.idd;
        vk1.a aVar = new vk1.a(new GProStFeedDetailRspWrapper(gProStFeed, guildFeedRichMediaData));
        FeedMorePanelLauncher feedMorePanelLauncher = new FeedMorePanelLauncher("pindao_feedimmersion");
        com.tencent.mobileqq.guild.feed.morepanel.k d16 = feedMorePanelLauncher.d(activity, aVar, null);
        d16.e().getExtra().putBoolean("extra_key_preserve_generate_share_pic_action", true);
        Bundle extra = d16.e().getExtra();
        GuildSharePageSource guildSharePageSource = GuildSharePageSource.GALLERY_FEED_SHARE;
        extra.putInt(AppConstants.Key.SHARE_PANEL_PAGE_SOURCE, guildSharePageSource.ordinal());
        d16.e().getApiRouter().a(FeedMorePanelBusiImpl.OperationListProvider.e.class, L9(aVar));
        d16.e().getApiRouter().a(com.tencent.mobileqq.guild.feed.morepanel.g.class, new FeedSharePanelReportHelper(aVar, d16.getOperationListProvider(), guildSharePageSource));
        com.tencent.mobileqq.guild.feed.morepanel.i.c(d16.e().getApiRouter(), com.tencent.mobileqq.guild.feed.part.a.d(this));
        d16.e().getExtra().putBoolean("EXTRA_KEY_9090_IMPROVE_SHARE_ACTION", true);
        d16.e().getExtra().putBoolean("EXTRA_KEY_PRESERVE_SAVE_ACTION", true);
        d16.e().getExtra().putBoolean("EXTRA_KEY_FINISH_WHEN_FLOAT_WINDOW_OK", true);
        Bundle extra2 = d16.e().getExtra();
        GuildFeedPublishInfo guildFeedPublishInfo = this.C.getGuildFeedPublishInfo();
        if (guildFeedPublishInfo != null) {
            extra2.putSerializable("guild_feed_publish_info", guildFeedPublishInfo);
        }
        ShareActionSheet.c itemClickListener = d16.getItemClickListener();
        com.tencent.mobileqq.sharepanel.j newItemClickListener = d16.getNewItemClickListener();
        b bVar = new b(guildFeedRichMediaData, i3);
        if (itemClickListener instanceof FeedMorePanelBusiImpl.a) {
            ((FeedMorePanelBusiImpl.a) itemClickListener).a().add(bVar);
        }
        if (newItemClickListener instanceof NewFeedMorePanelBusiImpl.a) {
            ((NewFeedMorePanelBusiImpl.a) newItemClickListener).c().add(bVar);
        }
        d16.h(new com.tencent.mobileqq.guild.feed.morepanel.impl.c(d16));
        this.E = feedMorePanelLauncher.h();
    }

    private void U9(final GuildFeedGalleryShareViewEvent guildFeedGalleryShareViewEvent) {
        if (!this.f222489h) {
            QLog.i("Guild_Feed_GAL_GuildFeedGallerySharePart", 1, "the part is not alive " + hashCode());
            return;
        }
        QLog.i("Guild_Feed_GAL_GuildFeedGallerySharePart", 1, "showShareView " + hashCode());
        if (guildFeedGalleryShareViewEvent.getGalleryShareInfo() != null && guildFeedGalleryShareViewEvent.getGalleryShareInfo().b() == getActivity().hashCode()) {
            this.f222491m.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.part.y
                @Override // java.lang.Runnable
                public final void run() {
                    aa.this.P9(guildFeedGalleryShareViewEvent);
                }
            });
        }
    }

    private void V9(GuildFeedGalleryInitBean guildFeedGalleryInitBean) {
        this.C = guildFeedGalleryInitBean;
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
    public void handleBroadcastMessage(String str, Object obj) {
        if ("message_on_page_select".equals(str) && (obj instanceof jk1.a)) {
            this.D = ((jk1.a) obj).b().idd;
        } else if ("message_on_init_bean_changed".equals(str)) {
            V9((GuildFeedGalleryInitBean) obj);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f222491m = view;
        RFWIocAbilityProvider.g().registerIoc(view, this.F, zp1.a.class);
    }

    @Override // com.tencent.mobileqq.guild.feed.part.f, com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        RFWIocAbilityProvider.g().unregisterSingleIoc(getPartRootView(), zp1.a.class);
        this.E = null;
        this.f222490i = true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        this.f222489h = false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        this.f222489h = true;
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        QLog.d("Guild_Feed_GAL_GuildFeedGallerySharePart", 1, "onReceiveEvent_event:", simpleBaseEvent);
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof GuildFeedGalleryShareViewEvent) {
            U9((GuildFeedGalleryShareViewEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof GuildFeedDeleteEvent) {
            J9(((GuildFeedDeleteEvent) simpleBaseEvent).getFeedId());
        } else if (simpleBaseEvent instanceof GuildFeedMoveEvent2) {
            J9(((GuildFeedMoveEvent2) simpleBaseEvent).getFeedId());
        }
    }
}
