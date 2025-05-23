package com.tencent.mobileqq.guild.feed.gallery.presenter;

import android.graphics.Color;
import android.view.View;
import android.view.ViewStub;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.event.GuildFeedGalleryCommonEleVisibleEvent;
import com.tencent.mobileqq.guild.feed.gallery.event.GuildFeedGalleryItemReLayoutEvent;
import com.tencent.mobileqq.guild.feed.gallery.event.GuildFeedGallerySeekbarShowEvent;
import com.tencent.mobileqq.guild.feed.gallery.widget.GuildFeedGalleryContentView;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDefaultInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import hk1.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0001+B\u000f\u0012\u0006\u0010/\u001a\u00020,\u00a2\u0006\u0004\b@\u0010AJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J*\u0010\u0017\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u00122\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0015H\u0016J\u001c\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0016J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\u0012\u0010\u001f\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010!\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\"\u001a\u00020\u0005H\u0016J\b\u0010#\u001a\u00020\u0005H\u0016J$\u0010'\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070%0$j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070%`&H\u0016J\u0012\u0010*\u001a\u00020\u00052\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\b\u0010+\u001a\u00020\u0012H\u0016R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00105R\u0018\u0010;\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010=\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010:R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/presenter/GuildFeedGalleryContentPresenter;", "Lcom/tencent/mobileqq/guild/feed/gallery/presenter/b;", "Lcom/tencent/mobileqq/guild/feed/gallery/presenter/r;", "", NodeProps.VISIBLE, "", "w", "", "data", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "r", "requestView", "onPreloadResult", "Ljk1/a;", "", "position", "k", "", "payloads", "l", "", "action", "g", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/feed/manager/f;", "selectInfo", "p", "unSelectInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", DomainData.DOMAIN_NAME, "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "a", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDefaultInitBean;", "D", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDefaultInitBean;", "defaultBean", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedGalleryContentView;", "E", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedGalleryContentView;", "mBannerContent", UserInfo.SEX_FEMALE, "Z", "mIsBannerInitialized", "G", "commentLayoutShow", "H", "Landroid/view/View;", "contentRootView", "I", "commonLayout", "J", "Ljk1/a;", "<init>", "(Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDefaultInitBean;)V", "K", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedGalleryContentPresenter extends b implements r {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final GuildFeedDefaultInitBean defaultBean;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private GuildFeedGalleryContentView mBannerContent;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mIsBannerInitialized;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean commentLayoutShow;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private View contentRootView;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private View commonLayout;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private jk1.a data;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedGalleryContentPresenter(@NotNull GuildFeedDefaultInitBean defaultBean) {
        super(defaultBean);
        Intrinsics.checkNotNullParameter(defaultBean, "defaultBean");
        this.defaultBean = defaultBean;
        this.commentLayoutShow = true;
    }

    private final void A() {
        if (!this.mIsBannerInitialized) {
            GuildFeedGalleryContentView guildFeedGalleryContentView = this.mBannerContent;
            if (guildFeedGalleryContentView != null) {
                guildFeedGalleryContentView.p();
            }
            this.mIsBannerInitialized = true;
            GuildFeedGalleryContentView guildFeedGalleryContentView2 = this.mBannerContent;
            if (guildFeedGalleryContentView2 != null) {
                guildFeedGalleryContentView2.r(this.defaultBean.getFeedId());
            }
        } else {
            QLog.d("Guild_Feed_GAL_GuildFeedGalleryContentPresenter", 4, "[initBanner] ignored");
        }
        GuildFeedGalleryContentView guildFeedGalleryContentView3 = this.mBannerContent;
        if (guildFeedGalleryContentView3 != null) {
            guildFeedGalleryContentView3.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(GuildFeedGalleryContentPresenter this$0, Object newData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(newData, "$newData");
        GuildFeedGalleryContentView guildFeedGalleryContentView = this$0.mBannerContent;
        if (guildFeedGalleryContentView != null) {
            guildFeedGalleryContentView.u(((jk1.a) newData).b());
        }
    }

    private final void w(boolean visible) {
        if (this.commentLayoutShow == visible) {
            return;
        }
        this.commentLayoutShow = visible;
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryContentPresenter", 1, "handleCommonElementVisible visible=" + visible);
        if (this.commentLayoutShow) {
            View view = this.commonLayout;
            if (view != null) {
                view.setVisibility(0);
            }
            mk1.i.d(this.commonLayout, new Pair(Float.valueOf(0.0f), Float.valueOf(1.0f)), 100L, null, 4, null);
        } else {
            mk1.i.c(this.commonLayout, new Pair(Float.valueOf(1.0f), Float.valueOf(0.0f)), 100L, new Function1<Unit, Unit>() { // from class: com.tencent.mobileqq.guild.feed.gallery.presenter.GuildFeedGalleryContentPresenter$handleCommonElementVisible$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                    invoke2(unit);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Unit it) {
                    View view2;
                    Intrinsics.checkNotNullParameter(it, "it");
                    view2 = GuildFeedGalleryContentPresenter.this.commonLayout;
                    if (view2 != null) {
                        view2.setVisibility(8);
                    }
                }
            });
        }
        SimpleEventBus.getInstance().dispatchEvent(new GuildFeedGallerySeekbarShowEvent(visible));
    }

    private final void x(Object data) {
        View view = this.commonLayout;
        if (view != null) {
            view.setBackgroundColor(Color.parseColor("#99000000"));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.gallery.presenter.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    GuildFeedGalleryContentPresenter.y(GuildFeedGalleryContentPresenter.this, view2);
                }
            });
            view.setClickable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(GuildFeedGalleryContentPresenter this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f219733h.a("message_action_fold_desc_content_text", null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void z(Object data) {
        View view = this.commonLayout;
        if (view != null) {
            view.setBackgroundColor(0);
            view.setOnClickListener(null);
            view.setClickable(false);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.r
    public int a() {
        GuildFeedGalleryContentView guildFeedGalleryContentView = this.mBannerContent;
        if (guildFeedGalleryContentView != null) {
            return guildFeedGalleryContentView.getMCurrentBannerPos();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b
    public void g(@Nullable String action, @Nullable Object data) {
        a.PanelHeightChangeEventDataArgs panelHeightChangeEventDataArgs;
        int i3;
        if (action != null) {
            Integer num = null;
            switch (action.hashCode()) {
                case -1130320924:
                    if (action.equals("message_on_expand_desc_content_text")) {
                        x(data);
                        return;
                    }
                    return;
                case -768227392:
                    if (action.equals("message_comment_panel_close_event")) {
                        w(true);
                        return;
                    }
                    return;
                case -133146741:
                    if (action.equals("message_on_fold_desc_content_text")) {
                        z(data);
                        return;
                    }
                    return;
                case 690308708:
                    if (action.equals("message_comment_panel_height_change_even")) {
                        if (data instanceof a.PanelHeightChangeEventDataArgs) {
                            panelHeightChangeEventDataArgs = (a.PanelHeightChangeEventDataArgs) data;
                        } else {
                            panelHeightChangeEventDataArgs = null;
                        }
                        if (panelHeightChangeEventDataArgs == null) {
                            panelHeightChangeEventDataArgs = new a.PanelHeightChangeEventDataArgs(0.0f, 0.0f, 3, null);
                        }
                        GuildFeedGalleryContentView guildFeedGalleryContentView = this.mBannerContent;
                        if (guildFeedGalleryContentView != null) {
                            guildFeedGalleryContentView.A(panelHeightChangeEventDataArgs);
                            return;
                        }
                        return;
                    }
                    return;
                case 1546149375:
                    if (action.equals("message_comment_panel_start_open_even")) {
                        GuildFeedGalleryContentView guildFeedGalleryContentView2 = this.mBannerContent;
                        if (guildFeedGalleryContentView2 != null) {
                            if (data instanceof Integer) {
                                num = (Integer) data;
                            }
                            if (num != null) {
                                i3 = num.intValue();
                            } else {
                                i3 = 0;
                            }
                            guildFeedGalleryContentView2.z(i3);
                        }
                        w(false);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<Object>> getEventClass() {
        ArrayList<Class<Object>> eventClass = super.getEventClass();
        if (eventClass == null) {
            eventClass = new ArrayList<>();
        }
        eventClass.add(GuildFeedGalleryItemReLayoutEvent.class);
        eventClass.add(GuildFeedGalleryCommonEleVisibleEvent.class);
        return eventClass;
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b
    public void j() {
        super.j();
        GuildFeedGalleryContentView guildFeedGalleryContentView = this.mBannerContent;
        if (guildFeedGalleryContentView != null) {
            guildFeedGalleryContentView.s();
        }
        RFWIocAbilityProvider.g().registerIoc(this.f219734i, this, r.class);
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b
    public void k(@Nullable jk1.a data, int position) {
        Integer num;
        GProStFeed gProStFeed;
        GuildFeedGalleryInitBean initBean;
        GuildFeedGalleryInitBean initBean2;
        GuildFeedGalleryInitBean guildFeedGalleryInitBean;
        GuildFeedGalleryInitBean initBean3;
        super.k(data, position);
        View view = this.commonLayout;
        if (view != null) {
            view.setBackgroundColor(0);
        }
        List<GuildFeedRichMediaData> list = null;
        if (data != null && (initBean3 = data.getInitBean()) != null) {
            num = Integer.valueOf(initBean3.getEnterPos());
        } else {
            num = null;
        }
        QLog.d("Guild_Feed_GAL_GuildFeedGalleryContentPresenter", 4, "[onBindData] pos: " + position + ", enterPos: " + num);
        this.data = data;
        GuildFeedGalleryContentView guildFeedGalleryContentView = this.mBannerContent;
        if (guildFeedGalleryContentView != null) {
            if (data != null) {
                guildFeedGalleryInitBean = data.getInitBean();
            } else {
                guildFeedGalleryInitBean = null;
            }
            guildFeedGalleryContentView.setInitBean(guildFeedGalleryInitBean);
        }
        A();
        GuildFeedGalleryContentView guildFeedGalleryContentView2 = this.mBannerContent;
        if (guildFeedGalleryContentView2 != null) {
            if (data != null && (initBean2 = data.getInitBean()) != null) {
                gProStFeed = initBean2.getFeed();
            } else {
                gProStFeed = null;
            }
            if (data != null && (initBean = data.getInitBean()) != null) {
                list = initBean.getRichMediaDataList();
            }
            guildFeedGalleryContentView2.setData(gProStFeed, list, position);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b
    public void l(@Nullable jk1.a data, int position, @Nullable List<Object> payloads) {
        Integer num;
        boolean z16;
        GuildFeedGalleryInitBean initBean;
        super.l(data, position, payloads);
        View view = this.commonLayout;
        if (view != null) {
            view.setBackgroundColor(0);
        }
        if (data != null && (initBean = data.getInitBean()) != null) {
            num = Integer.valueOf(initBean.getEnterPos());
        } else {
            num = null;
        }
        QLog.d("Guild_Feed_GAL_GuildFeedGalleryContentPresenter", 4, "[onBindData payload] pos: " + position + ", enterPos: " + num);
        List<Object> list = payloads;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            final Object obj = payloads.get(0);
            if (obj instanceof jk1.a) {
                GuildFeedGalleryContentView guildFeedGalleryContentView = this.mBannerContent;
                if (guildFeedGalleryContentView != null) {
                    jk1.a aVar = (jk1.a) obj;
                    guildFeedGalleryContentView.setData(aVar.b(), aVar.getInitBean().getRichMediaDataList(), position);
                }
                GuildFeedGalleryContentView guildFeedGalleryContentView2 = this.mBannerContent;
                if (guildFeedGalleryContentView2 != null) {
                    guildFeedGalleryContentView2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.gallery.presenter.l
                        @Override // java.lang.Runnable
                        public final void run() {
                            GuildFeedGalleryContentPresenter.B(GuildFeedGalleryContentPresenter.this, obj);
                        }
                    });
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b
    public void m() {
        GuildFeedGalleryContentView guildFeedGalleryContentView = this.mBannerContent;
        if (guildFeedGalleryContentView != null) {
            guildFeedGalleryContentView.B();
            guildFeedGalleryContentView.t();
        }
        super.m();
        RFWIocAbilityProvider.g().unregisterSingleIoc(this.f219734i, r.class);
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b
    public void n() {
        super.n();
        GuildFeedGalleryContentView guildFeedGalleryContentView = this.mBannerContent;
        if (guildFeedGalleryContentView != null) {
            guildFeedGalleryContentView.v();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b
    public void o() {
        super.o();
        GuildFeedGalleryContentView guildFeedGalleryContentView = this.mBannerContent;
        if (guildFeedGalleryContentView != null) {
            guildFeedGalleryContentView.w();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b, com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader.RequestPreloadViewListener
    public void onPreloadResult(@NotNull View requestView) {
        Intrinsics.checkNotNullParameter(requestView, "requestView");
        super.onPreloadResult(requestView);
        QLog.d("Guild_Feed_GAL_GuildFeedGalleryContentPresenter", 4, "[onPreloadResult] start");
        this.contentRootView = requestView;
        this.mBannerContent = (GuildFeedGalleryContentView) requestView.findViewById(R.id.wgg);
        this.commonLayout = this.f219734i.findViewById(R.id.w9h);
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof GuildFeedGalleryItemReLayoutEvent) {
            GuildFeedGalleryContentView guildFeedGalleryContentView = this.mBannerContent;
            if (guildFeedGalleryContentView != null) {
                guildFeedGalleryContentView.n();
                return;
            }
            return;
        }
        if (event instanceof GuildFeedGalleryCommonEleVisibleEvent) {
            w(((GuildFeedGalleryCommonEleVisibleEvent) event).getVisible());
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b
    public void p(@Nullable com.tencent.mobileqq.guild.feed.manager.f selectInfo) {
        super.p(selectInfo);
        GuildFeedGalleryContentView guildFeedGalleryContentView = this.mBannerContent;
        if (guildFeedGalleryContentView != null) {
            guildFeedGalleryContentView.x(selectInfo);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b
    public void q(@Nullable com.tencent.mobileqq.guild.feed.manager.f unSelectInfo) {
        super.q(unSelectInfo);
        GuildFeedGalleryContentView guildFeedGalleryContentView = this.mBannerContent;
        if (guildFeedGalleryContentView != null) {
            guildFeedGalleryContentView.y(unSelectInfo);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b
    public void r(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.r(rootView);
        RFWLayoutPreLoader e16 = gj1.a.a().e();
        View findViewById = rootView.findViewById(R.id.w9n);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.view.ViewStub");
        e16.requestPreloadViewForViewStub((ViewStub) findViewById, this);
    }
}
