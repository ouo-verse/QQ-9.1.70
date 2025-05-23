package com.tencent.mobileqq.guild.feed.presenter;

import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.UnderlineSpan;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi;
import com.tencent.mobileqq.guild.feed.event.GuildFeedThemeChangeEvent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDefaultInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.slf4j.Marker;

/* loaded from: classes13.dex */
public class GuildBaseFeedChildPresenter<T> implements SimpleEventReceiver, RFWLayoutPreLoader.RequestPreloadViewListener {
    private static final String[] E = {"\\", "$", "(", ")", "*", Marker.ANY_NON_NULL_MARKER, ".", "[", "]", QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, AECameraConstants.WIDGETINFO_SEPARATE, "{", "}", "|"};
    protected int C;
    protected GuildFeedDefaultInitBean D;

    /* renamed from: d, reason: collision with root package name */
    protected T f222800d;

    /* renamed from: e, reason: collision with root package name */
    protected int f222801e;

    /* renamed from: f, reason: collision with root package name */
    protected int f222802f;

    /* renamed from: h, reason: collision with root package name */
    private Map<String, Object> f222803h;

    /* renamed from: i, reason: collision with root package name */
    protected com.tencent.mobileqq.guild.feed.manager.d f222804i;

    /* renamed from: m, reason: collision with root package name */
    protected View f222805m;

    /* loaded from: classes13.dex */
    private static class MyUnderlineSpan extends UnderlineSpan {

        /* renamed from: d, reason: collision with root package name */
        private final int f222806d;

        @Override // android.text.style.UnderlineSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            textPaint.setColor(this.f222806d);
            textPaint.setUnderlineText(false);
        }
    }

    /* loaded from: classes13.dex */
    class a implements Function1<IGProGuildInfo, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ GProStFeed f222807d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f222808e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f222809f;

        a(GProStFeed gProStFeed, int i3, int i16) {
            this.f222807d = gProStFeed;
            this.f222808e = i3;
            this.f222809f = i16;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(IGProGuildInfo iGProGuildInfo) {
            GProStFeed gProStFeed = this.f222807d;
            GuildBaseFeedChildPresenter guildBaseFeedChildPresenter = GuildBaseFeedChildPresenter.this;
            GuildFeedDetailInitBean initFeedDetailInitBeanFromFeed = GuildFeedDetailInitBean.initFeedDetailInitBeanFromFeed(gProStFeed, guildBaseFeedChildPresenter.D, guildBaseFeedChildPresenter.f());
            if (iGProGuildInfo == null) {
                QLog.e("QFSBaseFeedChildPresenter", 1, "fetchGuildInfoAnyway failed guildId=" + initFeedDetailInitBeanFromFeed.getGuildId());
                initFeedDetailInitBeanFromFeed.setIsMember(true);
            } else {
                initFeedDetailInitBeanFromFeed.setIsMember(iGProGuildInfo.isMember());
            }
            initFeedDetailInitBeanFromFeed.setPosition(this.f222808e);
            initFeedDetailInitBeanFromFeed.setFromPage(this.f222809f);
            GuildBaseFeedChildPresenter guildBaseFeedChildPresenter2 = GuildBaseFeedChildPresenter.this;
            initFeedDetailInitBeanFromFeed.setImmersiveSource(mk1.e.f(guildBaseFeedChildPresenter2.D, guildBaseFeedChildPresenter2.C));
            mk1.e.a(initFeedDetailInitBeanFromFeed, GuildBaseFeedChildPresenter.this.e());
            initFeedDetailInitBeanFromFeed.setStFeed(this.f222807d);
            GuildFeedLauncher.x(GuildBaseFeedChildPresenter.this.f222805m.getContext(), initFeedDetailInitBeanFromFeed, Boolean.valueOf(((IGuildFeedNativeDetailApi) QRoute.api(IGuildFeedNativeDetailApi.class)).needOpenNativeDetailPage(this.f222807d)));
            return null;
        }
    }

    public GuildBaseFeedChildPresenter() {
        this.f222802f = 0;
        this.f222803h = new ConcurrentHashMap();
    }

    public void b(Map<String, Object> map) {
        if (map != null) {
            this.f222803h.putAll(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, String str) {
        T t16;
        if (view != null && (t16 = this.f222800d) != null) {
            com.tencent.mobileqq.guild.feed.report.d.b(view, str, String.valueOf(t16.hashCode()), e());
        }
    }

    public Map<String, Object> e() {
        String pageForumType;
        T t16 = this.f222800d;
        if (t16 instanceof ij1.g) {
            GProStFeed b16 = ((ij1.g) t16).b();
            if (b16 != null) {
                GuildFeedBaseInitBean q16 = ax.q(this.f222805m.getContext());
                Map<String, Object> map = this.f222803h;
                if (q16 == null) {
                    pageForumType = "";
                } else {
                    pageForumType = q16.getPageForumType(q16.getPageId());
                }
                map.putAll(com.tencent.mobileqq.guild.feed.report.f.d(b16, pageForumType));
            }
            if (!TextUtils.isEmpty(((ij1.g) this.f222800d).c())) {
                this.f222803h.put("sgrp_forum_trace_id", ((ij1.g) this.f222800d).c());
            }
        }
        return new ConcurrentHashMap(this.f222803h);
    }

    public String f() {
        Object obj = this.f222803h.get(JumpGuildParam.EXTRA_KEY_TRACE_ID);
        if (obj instanceof String) {
            return (String) obj;
        }
        return "";
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(GuildFeedThemeChangeEvent.class);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean h() {
        return !com.tencent.mobileqq.guild.feed.util.f.b(this.f222802f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(GProStFeed gProStFeed, int i3, int i16) {
        GuildMainFrameUtils.l(String.valueOf(gProStFeed.channelInfo.sign.guildId), false, new a(gProStFeed, i3, i16));
    }

    public void k(T t16, int i3) {
        this.f222800d = t16;
        this.f222801e = i3;
    }

    public void l(T t16, int i3, List<Object> list) {
        this.f222800d = t16;
        this.f222801e = i3;
    }

    public void o(@NonNull View view) {
        this.f222805m = view;
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof GuildFeedThemeChangeEvent) {
            s();
        }
    }

    public void p(com.tencent.mobileqq.guild.feed.event.a aVar) {
        com.tencent.mobileqq.guild.feed.manager.d dVar = this.f222804i;
        if (dVar == null) {
            return;
        }
        dVar.a(aVar);
    }

    public void q(com.tencent.mobileqq.guild.feed.manager.d dVar) {
        this.f222804i = dVar;
    }

    public void r(int i3) {
        this.C = i3;
    }

    public GuildBaseFeedChildPresenter(GuildFeedDefaultInitBean guildFeedDefaultInitBean) {
        this.f222802f = 0;
        this.f222803h = new ConcurrentHashMap();
        this.D = guildFeedDefaultInitBean;
        this.f222802f = guildFeedDefaultInitBean.getBusinessType();
    }

    public void j() {
    }

    public void m() {
    }

    public void n() {
    }

    protected void s() {
    }

    public void g(com.tencent.mobileqq.guild.feed.event.a aVar) {
    }

    @Override // com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader.RequestPreloadViewListener
    public void onPreloadResult(View view) {
    }
}
