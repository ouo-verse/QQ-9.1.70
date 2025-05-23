package com.tencent.mobileqq.guild.feed.gallery.presenter;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.util.Supplier;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.feed.event.GuildFeedGalleryCloseEvent;
import com.tencent.mobileqq.guild.feed.gallery.event.GuildFeedGalleryPagerEvent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDefaultInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 82\u00020\u00012\u00020\u0002:\u00019B\u000f\u0012\u0006\u00105\u001a\u000204\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0012\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J*\u0010\u0016\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0016J$\u0010\u001a\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00180\u0017j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0018`\u0019H\u0016J\u0012\u0010\u001d\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001f\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006H\u0016R\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00103\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00101\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/presenter/q;", "Lcom/tencent/mobileqq/guild/feed/gallery/presenter/b;", "Landroid/view/View$OnClickListener;", "", "v", "w", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "r", "requestView", "onPreloadResult", "Lcom/tencent/mobileqq/guild/feed/manager/f;", "selectInfo", "p", "Ljk1/a;", "data", "", "position", "k", "", "", "payloads", "l", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "view", NodeProps.ON_CLICK, "Landroid/widget/LinearLayout;", "D", "Landroid/widget/LinearLayout;", "backIv", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "pageIndexTv", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "moreIv", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", "G", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", "initBean", "H", "I", "curHorizontalPos", "curVerticalPos", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDefaultInitBean;", "defaultBean", "<init>", "(Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDefaultInitBean;)V", "J", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class q extends b implements View.OnClickListener {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private LinearLayout backIv;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private TextView pageIndexTv;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private ImageView moreIv;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private GuildFeedGalleryInitBean initBean;

    /* renamed from: H, reason: from kotlin metadata */
    private int curHorizontalPos;

    /* renamed from: I, reason: from kotlin metadata */
    private int curVerticalPos;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(@NotNull GuildFeedDefaultInitBean defaultBean) {
        super(defaultBean);
        Intrinsics.checkNotNullParameter(defaultBean, "defaultBean");
    }

    private final void v() {
        int i3;
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.initBean;
        Intrinsics.checkNotNull(guildFeedGalleryInitBean);
        int size = guildFeedGalleryInitBean.getRichMediaDataList().size();
        TextView textView = this.pageIndexTv;
        if (textView != null) {
            if (size > 1) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            textView.setVisibility(i3);
        }
        QLog.d("Guild_Feed_GAL_GuildFeedGalleryTitlePresenter", 1, "initPageIndex, curPos: " + this.curHorizontalPos + ", totalSize: " + size);
        TextView textView2 = this.pageIndexTv;
        if (textView2 != null) {
            textView2.setText((this.curHorizontalPos + 1) + "/" + size);
        }
    }

    private final void w() {
        if (this.f219730d.j()) {
            mk1.e eVar = mk1.e.f416895a;
            GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.initBean;
            int i3 = this.curHorizontalPos;
            Context context = this.f219734i.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "mRootView.context");
            eVar.k(guildFeedGalleryInitBean, i3, context, this.curVerticalPos);
            return;
        }
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryTitlePresenter", 1, "openMorePanelCaseByCase curHorizontalPos=" + this.curHorizontalPos);
        f(zp1.a.class).done(new OnPromiseResolved() { // from class: com.tencent.mobileqq.guild.feed.gallery.presenter.o
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                q.x(q.this, (zp1.a) obj);
            }
        }).originView(this.f219734i).run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(q this$0, zp1.a aVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (aVar == null) {
            aVar = null;
        }
        if (aVar != null) {
            int i3 = this$0.curVerticalPos;
            jk1.a mData = this$0.f219730d;
            Intrinsics.checkNotNullExpressionValue(mData, "mData");
            aVar.f(i3, mData, new Supplier() { // from class: com.tencent.mobileqq.guild.feed.gallery.presenter.p
                @Override // androidx.core.util.Supplier
                public final Object get() {
                    Map y16;
                    y16 = q.y();
                    return y16;
                }
            }, this$0.curHorizontalPos);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map y() {
        Map emptyMap;
        emptyMap = MapsKt__MapsKt.emptyMap();
        return emptyMap;
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<Object>> getEventClass() {
        ArrayList<Class<Object>> eventClass = super.getEventClass();
        if (eventClass == null) {
            eventClass = new ArrayList<>();
        }
        eventClass.add(GuildFeedGalleryPagerEvent.class);
        return eventClass;
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b
    public void k(@Nullable jk1.a data, int position) {
        int i3;
        String str;
        super.k(data, position);
        this.curVerticalPos = position;
        if (data == null) {
            TextView textView = this.pageIndexTv;
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        GuildFeedGalleryInitBean initBean = data.getInitBean();
        this.initBean = initBean;
        if (initBean != null) {
            i3 = initBean.getEnterPos();
        } else {
            i3 = 0;
        }
        this.curHorizontalPos = i3;
        v();
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.initBean;
        if (guildFeedGalleryInitBean != null) {
            str = guildFeedGalleryInitBean.getFeedId();
        } else {
            str = null;
        }
        QLog.d("Guild_Feed_GAL_GuildFeedGalleryTitlePresenter", 4, "[onBindData]initBean.feedId=" + str);
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b
    public void l(@Nullable jk1.a data, int position, @Nullable List<Object> payloads) {
        super.l(data, position, payloads);
        if (data == null) {
            TextView textView = this.pageIndexTv;
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        this.initBean = data.getInitBean();
        v();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            int id5 = view.getId();
            if (id5 == R.id.w9d) {
                SimpleEventBus.getInstance().dispatchEvent(new GuildFeedGalleryCloseEvent());
            } else if (id5 == R.id.w9f) {
                w();
                ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(this.moreIv, "em_sgrp_forum_viewer_more", "clck", d());
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b, com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader.RequestPreloadViewListener
    public void onPreloadResult(@NotNull View requestView) {
        Intrinsics.checkNotNullParameter(requestView, "requestView");
        super.onPreloadResult(requestView);
        this.backIv = (LinearLayout) requestView.findViewById(R.id.w9d);
        this.pageIndexTv = (TextView) requestView.findViewById(R.id.w9e);
        this.moreIv = (ImageView) requestView.findViewById(R.id.w9f);
        LinearLayout linearLayout = this.backIv;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(this);
        }
        ImageView imageView = this.moreIv;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        ViewExtKt.f(requestView, requestView.getPaddingTop() + ImmersiveUtils.getStatusBarHeight(requestView.getContext()));
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        String str;
        int i3;
        if (event instanceof GuildFeedGalleryPagerEvent) {
            GuildFeedGalleryPagerEvent guildFeedGalleryPagerEvent = (GuildFeedGalleryPagerEvent) event;
            QLog.d("Guild_Feed_GAL_GuildFeedGalleryTitlePresenter", 1, "onReceiveEvent[GuildFeedGalleryPagerEvent], curPos: " + guildFeedGalleryPagerEvent.getCurPos() + ", totalSize: " + guildFeedGalleryPagerEvent.getTotalSize() + ", feedId: " + guildFeedGalleryPagerEvent.getFeedId());
            String feedId = guildFeedGalleryPagerEvent.getFeedId();
            GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.initBean;
            if (guildFeedGalleryInitBean != null) {
                str = guildFeedGalleryInitBean.getFeedId();
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(feedId, str)) {
                return;
            }
            TextView textView = this.pageIndexTv;
            if (textView != null) {
                if (guildFeedGalleryPagerEvent.getTotalSize() > 1) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                textView.setVisibility(i3);
            }
            GuildFeedGalleryInitBean guildFeedGalleryInitBean2 = this.initBean;
            if (guildFeedGalleryInitBean2 != null) {
                guildFeedGalleryInitBean2.setEnterPos(guildFeedGalleryPagerEvent.getCurPos());
            }
            TextView textView2 = this.pageIndexTv;
            if (textView2 != null) {
                textView2.setText((guildFeedGalleryPagerEvent.getCurPos() + 1) + "/" + guildFeedGalleryPagerEvent.getTotalSize());
            }
            this.curHorizontalPos = guildFeedGalleryPagerEvent.getCurPos();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b
    public void p(@Nullable com.tencent.mobileqq.guild.feed.manager.f selectInfo) {
        super.p(selectInfo);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(this.moreIv, "em_sgrp_forum_viewer_more", "imp", d());
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.presenter.b
    public void r(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.r(rootView);
        RFWLayoutPreLoader e16 = gj1.a.a().e();
        View findViewById = rootView.findViewById(R.id.w9l);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.view.ViewStub");
        e16.requestPreloadViewForViewStub((ViewStub) findViewById, this);
    }
}
