package com.tencent.mobileqq.guild.feed.gallery.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerViewHelper;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.IocPromise;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDefaultInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes13.dex */
public class b implements SimpleEventReceiver, RFWLayoutPreLoader.RequestPreloadViewListener {
    private Map<String, Object> C = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    protected jk1.a f219730d;

    /* renamed from: e, reason: collision with root package name */
    protected int f219731e;

    /* renamed from: f, reason: collision with root package name */
    protected int f219732f;

    /* renamed from: h, reason: collision with root package name */
    protected kk1.d f219733h;

    /* renamed from: i, reason: collision with root package name */
    protected View f219734i;

    /* renamed from: m, reason: collision with root package name */
    protected GuildFeedDefaultInitBean f219735m;

    public b(GuildFeedDefaultInitBean guildFeedDefaultInitBean) {
        this.f219732f = 0;
        this.f219735m = guildFeedDefaultInitBean;
        this.f219732f = guildFeedDefaultInitBean.getBusinessType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit i(GProStFeed gProStFeed, GuildFeedGalleryInitBean guildFeedGalleryInitBean, int i3, int i16, IGProGuildInfo iGProGuildInfo) {
        String str;
        Serializable serializable = this.f219735m.getAttrs().get(JumpGuildParam.EXTRA_KEY_TRACE_ID);
        if (!(serializable instanceof String)) {
            str = "";
        } else {
            str = (String) serializable;
        }
        GuildFeedDetailInitBean initFeedDetailInitBeanFromFeed = GuildFeedDetailInitBean.initFeedDetailInitBeanFromFeed(gProStFeed, this.f219735m, str);
        if (iGProGuildInfo == null) {
            QLog.e("Guild_Feed_GAL_GuildBaseFeedGalleryChildPresenter", 1, "fetchGuildInfoAnyway failed guildId=" + initFeedDetailInitBeanFromFeed.getGuildId());
            initFeedDetailInitBeanFromFeed.setIsMember(true);
        } else {
            initFeedDetailInitBeanFromFeed.setIsMember(iGProGuildInfo.isMember());
        }
        initFeedDetailInitBeanFromFeed.setBusinessType(guildFeedGalleryInitBean.getBusinessType());
        initFeedDetailInitBeanFromFeed.setPosition(i3);
        initFeedDetailInitBeanFromFeed.setFromPage(i16);
        initFeedDetailInitBeanFromFeed.setImmersiveSource(this.f219735m.getImmersiveSource());
        initFeedDetailInitBeanFromFeed.setAttrs(this.f219735m.getAttrs());
        JumpGuildParam.JoinInfoParam joinInfoParam = guildFeedGalleryInitBean.getJoinInfoParam();
        if (joinInfoParam == null || !joinInfoParam.isValid()) {
            joinInfoParam = new JumpGuildParam.JoinInfoParam("", gProStFeed.channelInfo.sign.joinGuildSig, "immersive_feed", "others");
        }
        initFeedDetailInitBeanFromFeed.setJoinInfoParam(joinInfoParam);
        initFeedDetailInitBeanFromFeed.setJoinGuildSig(joinInfoParam.getJoinSignature());
        initFeedDetailInitBeanFromFeed.getFeedReportSourceInfo().addReportItem("extra_feeds_page_id", "pg_sgrp_forum_viewer_feeds");
        initFeedDetailInitBeanFromFeed.setShareSource(15);
        boolean needOpenNativeDetailPage = ((IGuildFeedNativeDetailApi) QRoute.api(IGuildFeedNativeDetailApi.class)).needOpenNativeDetailPage(gProStFeed);
        initFeedDetailInitBeanFromFeed.setStFeed(gProStFeed);
        initFeedDetailInitBeanFromFeed.setTroopUin(guildFeedGalleryInitBean.getTroopUin());
        GuildFeedLauncher.x(this.f219734i.getContext(), initFeedDetailInitBeanFromFeed, Boolean.valueOf(needOpenNativeDetailPage));
        return Unit.INSTANCE;
    }

    public void c(Map<String, Object> map) {
        if (map != null) {
            this.C.putAll(map);
        }
    }

    public HashMap<String, Object> d() {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (!TextUtils.isEmpty(this.f219730d.c())) {
            hashMap.put("sgrp_forum_trace_id", this.f219730d.c());
        }
        return hashMap;
    }

    public <T> T e(Class<T> cls) {
        return (T) RFWIocAbilityProvider.g().getIocInterface(cls, this.f219734i, RecyclerViewHelper.INSTANCE.getOwnerRecyclerView(this.f219734i));
    }

    public <T> IocPromise<T> f(Class<T> cls) {
        return RFWIocAbilityProvider.g().getIoc(cls).originView(this.f219734i);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        return null;
    }

    public void h(Context context, final GuildFeedGalleryInitBean guildFeedGalleryInitBean, final int i3, final int i16) {
        final GProStFeed feed = guildFeedGalleryInitBean.getFeed();
        GuildMainFrameUtils.l(String.valueOf(feed.channelInfo.sign.guildId), false, new Function1() { // from class: com.tencent.mobileqq.guild.feed.gallery.presenter.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit i17;
                i17 = b.this.i(feed, guildFeedGalleryInitBean, i3, i16, (IGProGuildInfo) obj);
                return i17;
            }
        });
    }

    @CallSuper
    public void j() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @CallSuper
    public void k(jk1.a aVar, int i3) {
        this.f219730d = aVar;
        this.f219731e = i3;
    }

    @CallSuper
    public void l(jk1.a aVar, int i3, List<Object> list) {
        this.f219730d = aVar;
        this.f219731e = i3;
    }

    @CallSuper
    public void m() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    public void r(@NonNull View view) {
        this.f219734i = view;
    }

    public void s(kk1.d dVar) {
        this.f219733h = dVar;
    }

    public void n() {
    }

    public void o() {
    }

    public void onPreloadResult(View view) {
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
    }

    public void p(com.tencent.mobileqq.guild.feed.manager.f fVar) {
    }

    public void q(com.tencent.mobileqq.guild.feed.manager.f fVar) {
    }

    public void g(String str, Object obj) {
    }
}
