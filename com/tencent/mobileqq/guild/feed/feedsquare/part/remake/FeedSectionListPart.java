package com.tencent.mobileqq.guild.feed.feedsquare.part.remake;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import bk1.a;
import ck1.a;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.guild.api.theme.QQGuildThemeManager;
import com.tencent.input.base.mvicompat.ex.VMMessengerProtocolSupport;
import com.tencent.mobileqq.guild.data.n;
import com.tencent.mobileqq.guild.data.s;
import com.tencent.mobileqq.guild.event.GuildFeedSharePanelLaunchEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedSquareFeedRefreshEvent;
import com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.FeedSectionListPartDelegate;
import com.tencent.mobileqq.guild.feed.feedsquare.part.remake.msgintent.FeedSectionListPartCallerMsgIntent;
import com.tencent.mobileqq.guild.feed.feedsquare.part.remake.msgintent.FeedSectionListPartMsgIntent;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedMediaSizeUtils;
import com.tencent.mobileqq.guild.feed.util.RecyclerViewExtKt;
import com.tencent.mobileqq.guild.feed.util.bl;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00e3\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001d\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\b\u0012\u0004\u0012\u00020\u00060\u0005B\u0017\u0012\u0006\u0010Q\u001a\u00020N\u0012\u0006\u0010U\u001a\u00020R\u00a2\u0006\u0004\bl\u0010mJ\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u0010\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0016J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0094\u0001\u0010$\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182h\u0010#\u001ad\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u001f\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\r\u0018\u00010\u001aj\u0004\u0018\u0001`\"H\u0016J\u0012\u0010'\u001a\u00020\r2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010(\u001a\u00020\r2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010)\u001a\u00020\r2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010+\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u001fH\u0016J\b\u0010,\u001a\u00020\rH\u0017J\u0010\u0010.\u001a\u00020\r2\u0006\u0010-\u001a\u00020\u0018H\u0016J\u0010\u0010/\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u001fH\u0016J\b\u00100\u001a\u00020\rH\u0016J\u0010\u00102\u001a\u00020\r2\u0006\u00101\u001a\u00020\u001fH\u0016J\u0012\u00103\u001a\u00020\r2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\u001c\u00106\u001a\u00020\r2\b\u0010&\u001a\u0004\u0018\u00010%2\b\u00105\u001a\u0004\u0018\u000104H\u0016J\b\u00107\u001a\u00020\bH\u0016J\u0012\u00108\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010;\u001a\u00020\r2\b\u0010:\u001a\u0004\u0018\u000109H\u0016J\u0014\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060=0<H\u0016J\u0010\u0010?\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010A\u001a\u00020@H\u0002J\u0010\u0010C\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020BH\u0002Jz\u0010E\u001a\u00020\r2\u0006\u0010D\u001a\u00020B2h\u0010#\u001ad\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u001f\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\r\u0018\u00010\u001aj\u0004\u0018\u0001`\"H\u0002J\b\u0010F\u001a\u00020\u0014H\u0002J!\u0010K\u001a\u00020\r2\u0017\u0010J\u001a\u0013\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020\r0G\u00a2\u0006\u0002\bIH\u0002J\u0019\u0010M\u001a\u0013\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\r0G\u00a2\u0006\u0002\bIH\u0002R\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010U\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010X\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010`\u001a\u00020]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010c\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0014\u0010g\u001a\u00020d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\be\u0010fR\u001e\u0010k\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00180h8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bi\u0010j\u00a8\u0006n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/FeedSectionListPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lak1/a;", "Lcom/tencent/biz/richframework/part/PartLifecycleCallbacks;", "Lcom/tencent/input/base/mvicompat/ex/a;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "", "J2", "f0", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Lcom/tencent/mvi/base/route/MsgIntent;", "event", "E", "Lcom/tencent/mvi/base/route/k;", "I", "", "enableUseCache", "isShowHeadRefresher", "forceScrollTop", "", "extendArgs", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "isSuccess", "errMsg", "", QzoneIPCModule.RESULT_CODE, QAdRewardDefine$VideoParams.ISCACHE, "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/api/IFeedSectionRefreshApiCallback;", "callback", "X4", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartPause", "onPartStop", "onPartResume", "position", "m6", "notifyDataSetChanged", "payload", "U0", "B1", "g6", "y", "V3", "onPartDestroy", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "getLogTag", "onReceiveEvent", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "I9", "Lck1/a$a;", "H9", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartCallerMsgIntent$CallRefreshMsgIntent;", "G9", "reqEvent", "J9", "D9", "Lkotlin/Function1;", "Landroidx/recyclerview/widget/RecyclerView;", "Lkotlin/ExtensionFunctionType;", "block", "K9", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "E9", "Lbk1/a;", "d", "Lbk1/a;", "delegate", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/h;", "e", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/h;", "dependOns", "f", "Landroidx/recyclerview/widget/RecyclerView;", "feedRecyclerView", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", tl.h.F, "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "concatAdapter", "Lcom/tencent/input/base/mvicompat/ex/VMMessengerProtocolSupport;", "i", "Lcom/tencent/input/base/mvicompat/ex/VMMessengerProtocolSupport;", "messageRegistry", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "hasPaused", "com/tencent/mobileqq/guild/feed/feedsquare/part/remake/FeedSectionListPart$onThemeChanged$1", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/FeedSectionListPart$onThemeChanged$1;", "onThemeChanged", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;", "F9", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;", SessionDbHelper.SESSION_ID, "<init>", "(Lbk1/a;Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/h;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedSectionListPart extends Part implements ak1.a, com.tencent.input.base.mvicompat.ex.a, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final FeedSectionListPart$onThemeChanged$1 onThemeChanged;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final bk1.a delegate;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final h dependOns;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RecyclerView feedRecyclerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RFWConcatAdapter concatAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final VMMessengerProtocolSupport messageRegistry;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean hasPaused;

    /* JADX WARN: Type inference failed for: r2v2, types: [com.tencent.mobileqq.guild.feed.feedsquare.part.remake.FeedSectionListPart$onThemeChanged$1] */
    public FeedSectionListPart(@NotNull bk1.a delegate, @NotNull h dependOns) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(dependOns, "dependOns");
        this.delegate = delegate;
        this.dependOns = dependOns;
        this.messageRegistry = new VMMessengerProtocolSupport(this);
        this.onThemeChanged = new or0.a() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.FeedSectionListPart$onThemeChanged$1
            @Override // or0.a
            public void onThemeChanged() {
                QLog.d(FeedSectionListPart.this.getTAG(), 1, "[onThemeChanged]: theme changed");
                final FeedSectionListPart feedSectionListPart = FeedSectionListPart.this;
                feedSectionListPart.K9(new Function1<RecyclerView, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.FeedSectionListPart$onThemeChanged$1$onThemeChanged$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(RecyclerView recyclerView) {
                        invoke2(recyclerView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull RecyclerView withInitializedRecyclerView) {
                        Function1 E9;
                        Intrinsics.checkNotNullParameter(withInitializedRecyclerView, "$this$withInitializedRecyclerView");
                        E9 = FeedSectionListPart.this.E9();
                        RecyclerViewExtKt.c(withInitializedRecyclerView, E9);
                    }
                });
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean D9() {
        boolean z16;
        try {
        } catch (Exception e16) {
            QLog.d(getTAG(), 1, "checkHasPaused error:" + e16.getMessage());
        }
        if (this.hasPaused) {
            return true;
        }
        if (getPartHost() instanceof Fragment) {
            Object partHost = getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            Bundle arguments = ((Fragment) partHost).getArguments();
            if (arguments != null) {
                if (arguments.getBoolean("key_has_parent_paused")) {
                    z16 = true;
                    if (!z16) {
                        return true;
                    }
                }
            }
            z16 = false;
            if (!z16) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function1<RecyclerView.RecycledViewPool, Unit> E9() {
        return new Function1<RecyclerView.RecycledViewPool, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.FeedSectionListPart$getClearRecycledViewPoolMethod$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RecyclerView.RecycledViewPool recycledViewPool) {
                invoke2(recycledViewPool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull RecyclerView.RecycledViewPool recycledViewPool) {
                Intrinsics.checkNotNullParameter(recycledViewPool, "$this$null");
                if (recycledViewPool instanceof com.tencent.mobileqq.guild.feed.feedsquare.widget.a) {
                    ((com.tencent.mobileqq.guild.feed.feedsquare.widget.a) recycledViewPool).b();
                } else {
                    recycledViewPool.clear();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final i<? extends Object> F9() {
        return this.dependOns.b().d();
    }

    private final void G9(FeedSectionListPartCallerMsgIntent.CallRefreshMsgIntent event) {
        s contact = event.getContact();
        if (contact != null && !n.a(F9().a(), contact)) {
            return;
        }
        QLog.d(getTAG(), 1, "[handleCallRefreshMsgIntent]: " + event);
        J9(event, null);
    }

    private final a.C0197a H9() {
        RFWConcatAdapter rFWConcatAdapter = this.concatAdapter;
        if (rFWConcatAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
            rFWConcatAdapter = null;
        }
        return new a.C0197a(wj1.d.b(rFWConcatAdapter));
    }

    private final void I9(View rootView) {
        RFWConcatAdapter rFWConcatAdapter = null;
        this.feedRecyclerView = this.delegate.v5().a(null, rootView, this.dependOns.a());
        IPerformanceReportTask g16 = qw1.b.g(this.dependOns.b().getFragment().getArguments(), null, 1, null);
        RecyclerView recyclerView = this.feedRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedRecyclerView");
            recyclerView = null;
        }
        qw1.b.j(g16, recyclerView, new Function1<IPerformanceReportTask, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.FeedSectionListPart$initializeRecyclerViewAndAdapters$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IPerformanceReportTask iPerformanceReportTask) {
                invoke2(iPerformanceReportTask);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull IPerformanceReportTask reportOnFirstFrame) {
                h hVar;
                Intrinsics.checkNotNullParameter(reportOnFirstFrame, "$this$reportOnFirstFrame");
                cp1.d.f391542a.b(reportOnFirstFrame);
                hVar = FeedSectionListPart.this.dependOns;
                qw1.b.n(qw1.b.c(hVar.b().getFragment().getArguments(), "_extra_param_report_task_view_pager_tab"));
            }
        });
        a.AbstractC0131a<?, Object>[] a26 = this.delegate.a2();
        ArrayList arrayList = new ArrayList(this.delegate.a2().length);
        for (a.AbstractC0131a<?, Object> abstractC0131a : a26) {
            arrayList.add(abstractC0131a.a(this.dependOns.a()));
        }
        this.concatAdapter = new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(false).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), arrayList);
        RecyclerView recyclerView2 = this.feedRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedRecyclerView");
            recyclerView2 = null;
        }
        RFWConcatAdapter rFWConcatAdapter2 = this.concatAdapter;
        if (rFWConcatAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
        } else {
            rFWConcatAdapter = rFWConcatAdapter2;
        }
        recyclerView2.setAdapter(rFWConcatAdapter);
    }

    private final void J9(final FeedSectionListPartCallerMsgIntent.CallRefreshMsgIntent reqEvent, final Function4<? super Boolean, ? super String, ? super Integer, ? super Boolean, Unit> callback) {
        final boolean z16;
        IPerformanceReportTask iPerformanceReportTask;
        this.dependOns.b().getMessenger().h(new FeedSectionListPartMsgIntent.OnRefreshMsgIntent(F9(), reqEvent));
        if ((reqEvent.getExtendArgs() instanceof FeedSectionListPartDelegate.a) && ((FeedSectionListPartDelegate.a) reqEvent.getExtendArgs()).getIsFirstRefresh()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && !D9()) {
            com.tencent.mobileqq.guild.feed.report.c cVar = com.tencent.mobileqq.guild.feed.report.c.f223280a;
            g gVar = (g) PartIOCKt.getIocInterface(this, g.class);
            if (gVar != null) {
                iPerformanceReportTask = gVar.a();
            } else {
                iPerformanceReportTask = null;
            }
            cVar.v(iPerformanceReportTask);
        }
        this.delegate.X4(reqEvent.getEnableUseCache(), reqEvent.getIsShowHeadRefresher(), reqEvent.getForceScrollTop(), reqEvent.getExtendArgs(), new Function4<Boolean, String, Integer, Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.FeedSectionListPart$refreshDataInternal$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str, Integer num, Boolean bool2) {
                invoke(bool.booleanValue(), str, num.intValue(), bool2.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z17, @NotNull String errMsg, int i3, boolean z18) {
                h hVar;
                i F9;
                boolean D9;
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                if (z16) {
                    D9 = this.D9();
                    if (!D9) {
                        com.tencent.mobileqq.guild.feed.report.c cVar2 = com.tencent.mobileqq.guild.feed.report.c.f223280a;
                        g gVar2 = (g) PartIOCKt.getIocInterface(this, g.class);
                        cVar2.w(gVar2 != null ? gVar2.a() : null, errMsg, i3, z18);
                    }
                }
                hVar = this.dependOns;
                com.tencent.mvi.base.route.j messenger = hVar.b().getMessenger();
                F9 = this.F9();
                messenger.h(new FeedSectionListPartMsgIntent.OnRefreshFinishMsgIntent(F9, z17, errMsg, reqEvent));
                Function4<Boolean, String, Integer, Boolean, Unit> function4 = callback;
                if (function4 != null) {
                    function4.invoke(Boolean.valueOf(z17), errMsg, Integer.valueOf(i3), Boolean.valueOf(z18));
                }
                bl.c().a(new GuildFeedSquareFeedRefreshEvent());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9(Function1<? super RecyclerView, Unit> block) {
        RecyclerView recyclerView = this.feedRecyclerView;
        if (recyclerView != null) {
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedRecyclerView");
                recyclerView = null;
            }
            block.invoke(recyclerView);
        }
    }

    @Override // vi1.h
    public void B1(final int position) {
        K9(new Function1<RecyclerView, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.FeedSectionListPart$scrollToPosition$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RecyclerView recyclerView) {
                invoke2(recyclerView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull RecyclerView withInitializedRecyclerView) {
                Intrinsics.checkNotNullParameter(withInitializedRecyclerView, "$this$withInitializedRecyclerView");
                withInitializedRecyclerView.scrollToPosition(position);
            }
        });
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    public void E(@NotNull MsgIntent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof FeedSectionListPartCallerMsgIntent.CallRefreshMsgIntent) {
            G9((FeedSectionListPartCallerMsgIntent.CallRefreshMsgIntent) event);
        }
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    @NotNull
    public k I(@NotNull MsgIntent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof FeedSectionListPartMsgIntent.GetFeedListAdapterPosMsgIntent) {
            return H9();
        }
        return new com.tencent.input.base.utils.a();
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    @NotNull
    public List<String> J2() {
        List<String> listOf;
        String b16 = com.tencent.mvi.base.route.c.b(FeedSectionListPartCallerMsgIntent.CallRefreshMsgIntent.class);
        Intrinsics.checkNotNullExpressionValue(b16, "get(java)");
        String b17 = com.tencent.mvi.base.route.c.b(FeedSectionListPartCallerMsgIntent.CallFirstDataShowOnScreen.class);
        Intrinsics.checkNotNullExpressionValue(b17, "get(java)");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{b16, b17});
        return listOf;
    }

    @Override // vi1.a
    public void U0(@NotNull Object payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        K9(new Function1<RecyclerView, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.FeedSectionListPart$notifyAllItemChanged$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RecyclerView recyclerView) {
                invoke2(recyclerView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull RecyclerView withInitializedRecyclerView) {
                Intrinsics.checkNotNullParameter(withInitializedRecyclerView, "$this$withInitializedRecyclerView");
                RecyclerView.Adapter adapter = withInitializedRecyclerView.getAdapter();
                if (adapter != null) {
                    RecyclerView.Adapter adapter2 = withInitializedRecyclerView.getAdapter();
                    adapter.notifyItemRangeChanged(0, adapter2 != null ? adapter2.getNUM_BACKGOURND_ICON() : 0);
                }
            }
        });
    }

    @Override // ak1.b
    public void X4(boolean enableUseCache, boolean isShowHeadRefresher, boolean forceScrollTop, @Nullable Object extendArgs, @Nullable Function4<? super Boolean, ? super String, ? super Integer, ? super Boolean, Unit> callback) {
        J9(new FeedSectionListPartCallerMsgIntent.CallRefreshMsgIntent(F9().a(), enableUseCache, isShowHeadRefresher, forceScrollTop, extendArgs), callback);
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    @NotNull
    public List<String> f0() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Reflection.getOrCreateKotlinClass(FeedSectionListPartMsgIntent.GetFeedListAdapterPosMsgIntent.class).getQualifiedName());
        return listOf;
    }

    @Override // vi1.h
    public void g6() {
        K9(new Function1<RecyclerView, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.FeedSectionListPart$fastSmoothScrollToTop$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RecyclerView recyclerView) {
                invoke2(recyclerView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull RecyclerView withInitializedRecyclerView) {
                Intrinsics.checkNotNullParameter(withInitializedRecyclerView, "$this$withInitializedRecyclerView");
                RecyclerViewExtKt.b(withInitializedRecyclerView);
            }
        });
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildFeedSharePanelLaunchEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "FeedSection." + this.delegate.getTag();
    }

    @Override // vi1.a
    public void m6(int position) {
        RecyclerView recyclerView = this.feedRecyclerView;
        if (recyclerView != null) {
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedRecyclerView");
                recyclerView = null;
            }
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter != null) {
                adapter.notifyItemChanged(position);
            }
        }
    }

    @Override // vi1.a
    @SuppressLint({"NotifyDataSetChanged"})
    public void notifyDataSetChanged() {
        K9(new Function1<RecyclerView, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.FeedSectionListPart$notifyDataSetChanged$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RecyclerView recyclerView) {
                invoke2(recyclerView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull RecyclerView withInitializedRecyclerView) {
                Intrinsics.checkNotNullParameter(withInitializedRecyclerView, "$this$withInitializedRecyclerView");
                RecyclerView.Adapter adapter = withInitializedRecyclerView.getAdapter();
                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            K9(new Function1<RecyclerView, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.FeedSectionListPart$onConfigurationChanged$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(RecyclerView recyclerView) {
                    invoke2(recyclerView);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull RecyclerView withInitializedRecyclerView) {
                    Function1 E9;
                    Intrinsics.checkNotNullParameter(withInitializedRecyclerView, "$this$withInitializedRecyclerView");
                    GuildFeedMediaSizeUtils guildFeedMediaSizeUtils = GuildFeedMediaSizeUtils.f219296d;
                    Context context = withInitializedRecyclerView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    guildFeedMediaSizeUtils.j(context);
                    E9 = FeedSectionListPart.this.E9();
                    RecyclerViewExtKt.e(withInitializedRecyclerView, 0, E9, 1, null);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        if (rootView == null) {
            QLog.e(getTAG(), 1, "[onInitView]: rootView should not be null");
            return;
        }
        PartIOCKt.registerIoc(this, this, ak1.a.class);
        this.messageRegistry.d(this.dependOns.b().getMessenger());
        this.delegate.q7(this, this.dependOns.b());
        I9(rootView);
        this.delegate.M2(this, this);
        QQGuildThemeManager.c(this.onThemeChanged);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        PartIOCKt.unregisterIoc(this, ak1.a.class);
        this.delegate.onPartDestroy(activity);
        this.messageRegistry.e(this.dependOns.b().getMessenger());
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        QQGuildThemeManager.d(this.onThemeChanged);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        super.onPartPause(activity);
        this.hasPaused = true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        this.delegate.h();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(@Nullable Activity activity) {
        super.onPartStop(activity);
        this.hasPaused = true;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        zp1.a aVar;
        if (event instanceof GuildFeedSharePanelLaunchEvent) {
            Object iocInterface = PartIOCKt.getIocInterface(this, zp1.a.class);
            if (iocInterface instanceof zp1.a) {
                aVar = (zp1.a) iocInterface;
            } else {
                aVar = null;
            }
            if (aVar != null) {
                GuildFeedSharePanelLaunchEvent guildFeedSharePanelLaunchEvent = (GuildFeedSharePanelLaunchEvent) event;
                aVar.f(guildFeedSharePanelLaunchEvent.getPosition(), new ij1.g(guildFeedSharePanelLaunchEvent.getStFeed()), guildFeedSharePanelLaunchEvent.getDtParamSupplier(), guildFeedSharePanelLaunchEvent.getMediaIndex());
            }
        }
    }

    @Override // vi1.h
    public void V3(int y16) {
    }
}
