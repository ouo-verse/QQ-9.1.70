package com.tencent.mobileqq.guild.feed.widget;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDefaultInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher;
import com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter;
import com.tencent.mobileqq.guild.feed.presenter.GuildFeedAvatarPresenter;
import com.tencent.mobileqq.guild.feed.presenter.GuildFeedChildBottomPresenter;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedBaseItemView extends GuildBaseWidgetView<ij1.g> implements View.OnClickListener, View.OnLongClickListener {

    /* renamed from: d, reason: collision with root package name */
    protected com.tencent.mobileqq.guild.feed.manager.d f224137d;

    /* renamed from: e, reason: collision with root package name */
    protected int f224138e;

    /* renamed from: f, reason: collision with root package name */
    protected GuildFeedDefaultInitBean f224139f;

    /* renamed from: h, reason: collision with root package name */
    private HashMap<Class, GuildBaseFeedChildPresenter<ij1.g>> f224140h;

    /* renamed from: i, reason: collision with root package name */
    private int f224141i;

    /* renamed from: m, reason: collision with root package name */
    private ConcurrentHashMap<String, Object> f224142m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a implements Function1<IGProGuildInfo, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ GProStFeed f224143d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f224144e;

        a(GProStFeed gProStFeed, int i3) {
            this.f224143d = gProStFeed;
            this.f224144e = i3;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(IGProGuildInfo iGProGuildInfo) {
            String str;
            Object obj = GuildFeedBaseItemView.this.f224142m.get(JumpGuildParam.EXTRA_KEY_TRACE_ID);
            if (obj instanceof String) {
                str = (String) obj;
            } else {
                str = "";
            }
            GuildFeedDetailInitBean initFeedDetailInitBeanFromFeed = GuildFeedDetailInitBean.initFeedDetailInitBeanFromFeed(this.f224143d, GuildFeedBaseItemView.this.f224139f, str);
            if (iGProGuildInfo == null) {
                QLog.e("GuildFeedItemView", 1, "fetchGuildInfoAnyway failed");
                initFeedDetailInitBeanFromFeed.setIsMember(true);
            } else {
                initFeedDetailInitBeanFromFeed.setIsMember(iGProGuildInfo.isMember());
            }
            initFeedDetailInitBeanFromFeed.setFromPage(this.f224144e);
            mk1.e.a(initFeedDetailInitBeanFromFeed, GuildFeedBaseItemView.this.p0());
            GuildFeedBaseItemView guildFeedBaseItemView = GuildFeedBaseItemView.this;
            initFeedDetailInitBeanFromFeed.setImmersiveSource(mk1.e.f(guildFeedBaseItemView.f224139f, guildFeedBaseItemView.f224141i));
            initFeedDetailInitBeanFromFeed.setStFeed(this.f224143d);
            GuildFeedLauncher.x(GuildFeedBaseItemView.this.getContext(), initFeedDetailInitBeanFromFeed, Boolean.valueOf(((IGuildFeedNativeDetailApi) QRoute.api(IGuildFeedNativeDetailApi.class)).needOpenNativeDetailPage(this.f224143d)));
            return null;
        }
    }

    public GuildFeedBaseItemView(@NonNull Context context) {
        this(context, 0);
    }

    private void B0() {
        if (this.f224137d == null) {
            return;
        }
        for (GuildBaseFeedChildPresenter<ij1.g> guildBaseFeedChildPresenter : r0().values()) {
            if (guildBaseFeedChildPresenter != null && !this.f224137d.b(guildBaseFeedChildPresenter)) {
                this.f224137d.e(guildBaseFeedChildPresenter);
                guildBaseFeedChildPresenter.q(this.f224137d);
            }
        }
    }

    private void C0() {
        com.tencent.mobileqq.guild.feed.manager.d dVar = this.f224137d;
        if (dVar == null) {
            return;
        }
        dVar.c();
    }

    private void initView() {
        s0();
        z0(getContext(), this);
        setOnClickListener(this);
    }

    private List<GuildBaseFeedChildPresenter<ij1.g>> n0() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(o0());
        List<GuildBaseFeedChildPresenter<ij1.g>> q06 = q0();
        if (q06 != null && q06.size() > 0) {
            linkedList.addAll(q06);
        }
        return linkedList;
    }

    private List<GuildBaseFeedChildPresenter<ij1.g>> o0() {
        if (com.tencent.mobileqq.guild.feed.util.f.a(this.f224138e)) {
            return new ArrayList(Arrays.asList(new GuildFeedAvatarPresenter(this.f224139f), new com.tencent.mobileqq.guild.feed.presenter.e(this.f224139f), new GuildFeedChildBottomPresenter(this.f224139f), new com.tencent.mobileqq.guild.feed.presenter.d(this.f224139f)));
        }
        return new ArrayList(Arrays.asList(new GuildFeedAvatarPresenter(this.f224139f), new com.tencent.mobileqq.guild.feed.presenter.e(this.f224139f), new GuildFeedChildBottomPresenter(this.f224139f), new com.tencent.mobileqq.guild.feed.presenter.d(this.f224139f)));
    }

    private void s0() {
        Map<Class, GuildBaseFeedChildPresenter<ij1.g>> r06 = r0();
        this.f224137d = new com.tencent.mobileqq.guild.feed.manager.d();
        for (GuildBaseFeedChildPresenter<ij1.g> guildBaseFeedChildPresenter : n0()) {
            this.f224137d.e(guildBaseFeedChildPresenter);
            guildBaseFeedChildPresenter.q(this.f224137d);
            r06.put(guildBaseFeedChildPresenter.getClass(), guildBaseFeedChildPresenter);
        }
    }

    private void v0() {
        for (GuildBaseFeedChildPresenter<ij1.g> guildBaseFeedChildPresenter : r0().values()) {
            if (guildBaseFeedChildPresenter != null) {
                guildBaseFeedChildPresenter.j();
            }
        }
    }

    private void w0(ij1.g gVar, int i3) {
        if (gVar == null) {
            return;
        }
        for (GuildBaseFeedChildPresenter<ij1.g> guildBaseFeedChildPresenter : r0().values()) {
            if (guildBaseFeedChildPresenter != null) {
                guildBaseFeedChildPresenter.r(this.f224141i);
                guildBaseFeedChildPresenter.b(this.f224142m);
                guildBaseFeedChildPresenter.k(gVar, i3);
            }
        }
    }

    private void x0(ij1.g gVar, int i3, List<Object> list) {
        if (gVar == null) {
            return;
        }
        for (GuildBaseFeedChildPresenter<ij1.g> guildBaseFeedChildPresenter : r0().values()) {
            if (guildBaseFeedChildPresenter != null) {
                guildBaseFeedChildPresenter.r(this.f224141i);
                guildBaseFeedChildPresenter.b(this.f224142m);
                guildBaseFeedChildPresenter.l(gVar, i3, list);
            }
        }
    }

    private void y0() {
        for (GuildBaseFeedChildPresenter<ij1.g> guildBaseFeedChildPresenter : r0().values()) {
            if (guildBaseFeedChildPresenter != null) {
                guildBaseFeedChildPresenter.m();
            }
        }
    }

    private void z0(Context context, View view) {
        if (view == null) {
            QLog.d("GuildFeedItemView", 1, "[notifyInitView] root view should not be null.");
            return;
        }
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        for (GuildBaseFeedChildPresenter<ij1.g> guildBaseFeedChildPresenter : r0().values()) {
            if (guildBaseFeedChildPresenter != null) {
                long currentTimeMillis = System.currentTimeMillis();
                guildBaseFeedChildPresenter.o(view);
                QLog.d("GuildFeedItemView", 4, "[notifyInitView] [" + guildBaseFeedChildPresenter + "], cost=" + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    public void A0() {
        setParentView(null);
        for (GuildBaseFeedChildPresenter<ij1.g> guildBaseFeedChildPresenter : r0().values()) {
            if (guildBaseFeedChildPresenter != null) {
                guildBaseFeedChildPresenter.n();
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.er7;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public RFWLayoutPreLoader getLayoutPreLoader() {
        return gj1.a.a().d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    @NonNull
    public FrameLayout.LayoutParams getPreLoadLayoutParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void bindData(ij1.g gVar, int i3) {
        if (gVar != null && gVar.b() != null) {
            w0(gVar, i3);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        v0();
        B0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        u0(1);
        com.tencent.mobileqq.guild.feed.manager.d dVar = this.f224137d;
        if (dVar != null) {
            dVar.a(new com.tencent.mobileqq.guild.feed.event.a(1));
        }
        GuildFeedBaseInitBean q16 = ax.q(getContext());
        if (q16 != null && getData() != null) {
            com.tencent.mobileqq.guild.feed.report.e.c(getData().b(), "click", q16.getPageId(), q16.getPageForumType(q16.getPageId()), q16.getPrePageId(), q16.getPrePageForumType(q16.getPrePageId()));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        y0();
        C0();
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        EventCollector.getInstance().onViewLongClickedBefore(view);
        EventCollector.getInstance().onViewLongClicked(view);
        return false;
    }

    public Map<String, Object> p0() {
        return this.f224142m;
    }

    protected List<GuildBaseFeedChildPresenter<ij1.g>> q0() {
        return new ArrayList();
    }

    public Map<Class, GuildBaseFeedChildPresenter<ij1.g>> r0() {
        if (this.f224140h == null) {
            this.f224140h = new HashMap<>();
        }
        return this.f224140h;
    }

    public void setData(ij1.g gVar, int i3, @NonNull List<Object> list) {
        if (gVar != null && gVar.b() != null) {
            x0(gVar, i3, list);
        }
    }

    public void setSortMode(int i3) {
        this.f224141i = i3;
    }

    protected void u0(int i3) {
        GProStFeed b16 = getData().b();
        GuildMainFrameUtils.l(String.valueOf(b16.channelInfo.sign.guildId), false, new a(b16, i3));
    }

    public GuildFeedBaseItemView(@NonNull Context context, Integer num) {
        super(context, num);
        this.f224138e = 0;
        this.f224141i = 0;
        this.f224142m = new ConcurrentHashMap<>();
        initView();
    }

    public GuildFeedBaseItemView(@NonNull Context context, Integer num, GuildFeedDefaultInitBean guildFeedDefaultInitBean) {
        super(context, num);
        this.f224138e = 0;
        this.f224141i = 0;
        this.f224142m = new ConcurrentHashMap<>();
        this.f224139f = guildFeedDefaultInitBean;
        this.f224138e = guildFeedDefaultInitBean.getBusinessType();
        initView();
    }
}
