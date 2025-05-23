package com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.gamecenter.kuikly.api.IQQKuiklyViewCreatorApi;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedDetailMainData;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.event.FeedContentScrollEvent;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 52\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00016B\u0007\u00a2\u0006\u0004\b3\u00104J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\nH\u0002J4\u0010\u0017\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0014J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u0015H\u0014J\b\u0010\u001b\u001a\u00020\u001aH\u0014J\u0012\u0010\u001e\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001f\u001a\u00020\nH\u0016J\u0012\u0010!\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010%\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030#0\"j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030#`$H\u0016R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u001e\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/FeedBusinessCardSection;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/e;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "feedId", "guildId", "Lqj1/a;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/BusinessCardInfo;", "businessCardInfo", "", "B", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData;", "data", "", "position", "", "", "payloads", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData$c$c;", "payload", "t", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Landroid/view/ViewGroup;", "d", "Landroid/view/ViewGroup;", "busiCardLayout", "Ldd1/b;", "e", "Ldd1/b;", "kuiklyView", "f", "Lqj1/a;", tl.h.F, "Z", "hasExposed", "<init>", "()V", "i", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedBusinessCardSection extends e implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup busiCardLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private dd1.b kuiklyView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private qj1.a businessCardInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean hasExposed;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(FeedBusinessCardSection this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.y();
    }

    private final void B(String feedId, String guildId, qj1.a businessCardInfo) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        HashMap<String, Object> hashMapOf;
        if (this.kuiklyView == null) {
            long currentTimeMillis = System.currentTimeMillis();
            IQQKuiklyViewCreatorApi iQQKuiklyViewCreatorApi = (IQQKuiklyViewCreatorApi) QRoute.api(IQQKuiklyViewCreatorApi.class);
            Context context = this.mRootView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "mRootView.context");
            dd1.b createGuildBizCardView = iQQKuiklyViewCreatorApi.createGuildBizCardView(context);
            this.kuiklyView = createGuildBizCardView;
            if (createGuildBizCardView != null) {
                String str = businessCardInfo.getCooperation.qzone.report.datong.QZoneDTLoginReporter.SCHEMA java.lang.String();
                hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("feedId", feedId), TuplesKt.to("guildId", guildId));
                createGuildBizCardView.b(str, hashMapOf);
            }
            dd1.b bVar = this.kuiklyView;
            if (bVar != null) {
                bVar.onResume();
            }
            if (businessCardInfo.getWidth() > 0) {
                float j3 = GuildSplitViewUtils.j(GuildSplitViewUtils.f235370a, false, null, 3, null) / businessCardInfo.getWidth();
                ViewGroup viewGroup = this.busiCardLayout;
                if (viewGroup != null) {
                    layoutParams2 = viewGroup.getLayoutParams();
                } else {
                    layoutParams2 = null;
                }
                if (layoutParams2 != null) {
                    layoutParams2.height = (int) (businessCardInfo.getHeight() * j3);
                }
            } else {
                ViewGroup viewGroup2 = this.busiCardLayout;
                if (viewGroup2 != null) {
                    layoutParams = viewGroup2.getLayoutParams();
                } else {
                    layoutParams = null;
                }
                if (layoutParams != null) {
                    layoutParams.height = businessCardInfo.getHeight();
                }
            }
            GuildSplitViewUtils guildSplitViewUtils = GuildSplitViewUtils.f235370a;
            if (guildSplitViewUtils.n(this.mRootView.getContext())) {
                ViewGroup viewGroup3 = this.busiCardLayout;
                if (viewGroup3 != null) {
                    Object obj = this.kuiklyView;
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.View");
                    viewGroup3.addView((View) obj, GuildSplitViewUtils.j(guildSplitViewUtils, false, null, 3, null), -1);
                }
            } else {
                ViewGroup viewGroup4 = this.busiCardLayout;
                if (viewGroup4 != null) {
                    Object obj2 = this.kuiklyView;
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.view.View");
                    viewGroup4.addView((View) obj2, -1, -1);
                }
            }
            ViewGroup viewGroup5 = this.busiCardLayout;
            if (viewGroup5 != null) {
                viewGroup5.setVisibility(0);
            }
            z();
            getRootView().findViewById(R.id.v1c).setVisibility(8);
            if (QLog.isDevelopLevel()) {
                QLog.i("FeedBusinessCardSection", 1, "cost: " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void y() {
        dd1.b bVar;
        boolean z16;
        if (!this.hasExposed && (bVar = this.kuiklyView) != 0) {
            View view = (View) bVar;
            if (view.getVisibility() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                Rect rect = new Rect();
                view.getGlobalVisibleRect(rect);
                if (rect.top < ViewUtils.getScreenHeight() && !this.hasExposed) {
                    if (QLog.isColorLevel()) {
                        QLog.i("FeedBusinessCardSection", 2, "reportOnExpose");
                    }
                    this.hasExposed = true;
                    SimpleEventBus.getInstance().unRegisterReceiver(this);
                    bVar.a();
                }
            }
        }
    }

    private final void z() {
        Map mapOf;
        Object obj = this.kuiklyView;
        if (obj instanceof View) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.View");
            ((View) obj).postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.a
                @Override // java.lang.Runnable
                public final void run() {
                    FeedBusinessCardSection.A(FeedBusinessCardSection.this);
                }
            }, 200L);
            dd1.b bVar = this.kuiklyView;
            if (bVar != null) {
                bVar.setReportHandler(new Function1<HashMap<String, String>, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.FeedBusinessCardSection$setUpForReport$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, String> hashMap) {
                        invoke2(hashMap);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:8:0x002c, code lost:
                    
                        r4 = r0.businessCardInfo;
                     */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void invoke2(@NotNull HashMap<String, String> it) {
                        qj1.a aVar;
                        dd1.b bVar2;
                        Map mapOf2;
                        Intrinsics.checkNotNullParameter(it, "it");
                        if (QLog.isColorLevel()) {
                            QLog.i("FeedBusinessCardSection", 2, "kuiklyView callback onReport");
                        }
                        String str = it.get("report_button");
                        if (str != null) {
                            FeedBusinessCardSection feedBusinessCardSection = FeedBusinessCardSection.this;
                            if (!Intrinsics.areEqual("all_card_button", str) || aVar == null) {
                                return;
                            }
                            bVar2 = feedBusinessCardSection.kuiklyView;
                            mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_module_id", aVar.getModuleId()));
                            VideoReport.reportEvent("dt_clck", bVar2, mapOf2);
                        }
                    }
                });
            }
            qj1.a aVar = this.businessCardInfo;
            if (aVar != null) {
                Object obj2 = this.kuiklyView;
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.view.View");
                ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
                ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
                EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_NONE;
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_module_id", aVar.getModuleId()));
                com.tencent.mobileqq.guild.feed.report.d.d((View) obj2, "em_sgrp_module", clickPolicy, exposurePolicy, endExposurePolicy, mapOf);
            }
        }
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(FeedContentScrollEvent.class);
        return arrayListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.v1b};
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        dd1.b bVar = this.kuiklyView;
        if (bVar != null) {
            bVar.onDestroy();
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        ViewGroup viewGroup;
        if (containerView != null) {
            viewGroup = (ViewGroup) containerView.findViewById(R.id.v1o);
        } else {
            viewGroup = null;
        }
        this.busiCardLayout = viewGroup;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if ((event instanceof FeedContentScrollEvent) && ((FeedContentScrollEvent) event).getNewState() == 0) {
            y();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.e
    public boolean q(@NotNull FeedDetailMainData.c.C7755c payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        if (!super.q(payload) && payload.getType() != 2) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.e
    protected void t(@Nullable FeedDetailMainData data, int position, @Nullable List<Object> payloads, @Nullable FeedDetailMainData.c.C7755c payload) {
        String str;
        if (data == 0) {
            return;
        }
        this.mData = data;
        qj1.a l3 = data.getFeedDetail().l();
        this.businessCardInfo = l3;
        if (l3 != null) {
            str = l3.c();
        } else {
            str = null;
        }
        boolean z16 = true;
        QLog.i("FeedBusinessCardSection", 1, str);
        qj1.a aVar = this.businessCardInfo;
        if (aVar == null || !aVar.a()) {
            z16 = false;
        }
        if (z16) {
            String feedId = data.getFeedDetail().getFeedId();
            String valueOf = String.valueOf(data.getFeedDetail().getGuildId());
            qj1.a aVar2 = this.businessCardInfo;
            Intrinsics.checkNotNull(aVar2);
            B(feedId, valueOf, aVar2);
            return;
        }
        ViewGroup viewGroup = this.busiCardLayout;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }
}
