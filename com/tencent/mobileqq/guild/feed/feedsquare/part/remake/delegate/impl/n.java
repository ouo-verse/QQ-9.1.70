package com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl;

import android.app.Activity;
import androidx.core.util.Supplier;
import androidx.lifecycle.LiveData;
import bk1.a;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.FeedSectionListPartDelegate;
import com.tencent.mobileqq.guild.feed.feedsquare.part.remake.msgintent.FeedSectionListPartCallerMsgIntent;
import com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.FeedSquareHeaderAdapterWorker;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedMainInitBean;
import com.tencent.mobileqq.guild.feed.morepanel.cooperate.FeedListPartMorePanelCooperateHelper;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u001b07\u00a2\u0006\u0004\b9\u0010:J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001c\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0094\u0001\u0010 \u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022h\u0010\u001f\u001ad\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u001b\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015j\u0004\u0018\u0001`\u001eH\u0016J\b\u0010!\u001a\u00020\u0004H\u0016J\u0012\u0010$\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020%H\u0016R\u0016\u0010)\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R0\u00106\u001a\u0012\u0012\u000e\u0012\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00020/0.8\u0016X\u0096\u0004\u00a2\u0006\u0012\n\u0004\b0\u00101\u0012\u0004\b4\u00105\u001a\u0004\b2\u00103\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/delegate/impl/n;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/delegate/impl/FeedSectionListPartDelegate;", "", "extendArgs", "", "L", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartCallerMsgIntent$CallFirstDataShowOnScreen;", "event", "J", "Lcom/tencent/biz/richframework/part/Part;", "part", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/b;", "sectionContext", "q7", "Lak1/a;", "partApi", "M2", "", "enableUseCache", "isShowHeadRefresher", "forceScrollTop", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "isSuccess", "", "errMsg", "", QzoneIPCModule.RESULT_CODE, QAdRewardDefine$VideoParams.ISCACHE, "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/api/IFeedSectionRefreshApiCallback;", "callback", "X4", tl.h.F, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/tencent/mvi/base/route/MsgIntent;", "E", "Lcom/tencent/mobileqq/guild/feed/morepanel/cooperate/FeedListPartMorePanelCooperateHelper;", "Lcom/tencent/mobileqq/guild/feed/morepanel/cooperate/FeedListPartMorePanelCooperateHelper;", "morePanelLauncherIoc", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/worker/FeedSquareHeaderAdapterWorker;", "M", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/worker/FeedSquareHeaderAdapterWorker;", "headerWorker", "", "Lbk1/a$a;", "N", "[Lbk1/a$a;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()[Lbk1/a$a;", "getWorkers$annotations", "()V", "workers", "Landroidx/lifecycle/LiveData;", "sortMode", "<init>", "(Landroidx/lifecycle/LiveData;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class n extends FeedSectionListPartDelegate {

    /* renamed from: L, reason: from kotlin metadata */
    private FeedListPartMorePanelCooperateHelper morePanelLauncherIoc;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final FeedSquareHeaderAdapterWorker headerWorker;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final a.AbstractC0131a<?, Object>[] workers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(@NotNull LiveData<Integer> sortMode) {
        super("SecondaryLevelListPartDelegate", sortMode);
        Intrinsics.checkNotNullParameter(sortMode, "sortMode");
        FeedSquareHeaderAdapterWorker feedSquareHeaderAdapterWorker = new FeedSquareHeaderAdapterWorker();
        this.headerWorker = feedSquareHeaderAdapterWorker;
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(feedSquareHeaderAdapterWorker);
        spreadBuilder.addSpread(super.a2());
        this.workers = (a.AbstractC0131a[]) spreadBuilder.toArray(new a.AbstractC0131a[spreadBuilder.size()]);
    }

    private final void J(FeedSectionListPartCallerMsgIntent.CallFirstDataShowOnScreen event) {
        com.tencent.mobileqq.guild.feed.feedsquare.part.remake.i<GuildFeedMainInitBean> d16 = u().d();
        hj1.b.b(getTag(), "handleAction-CallFirstDataShowOnScreen-listPartChannelId:" + d16.getContact().getChannelId() + ",msgChannelId:" + event.getChannelId() + ", isSame:" + Intrinsics.areEqual(d16.getContact().getChannelId(), event.getChannelId()));
        if (!Intrinsics.areEqual(d16.getContact().getChannelId(), event.getChannelId())) {
            return;
        }
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String K(com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b sectionContext) {
        Intrinsics.checkNotNullParameter(sectionContext, "$sectionContext");
        String a16 = co1.e.a(sectionContext.getVmApi());
        if (a16 == null) {
            return "";
        }
        return a16;
    }

    private final void L(Object extendArgs) {
        FeedSectionListPartDelegate.a aVar;
        if (extendArgs instanceof FeedSectionListPartDelegate.a) {
            aVar = (FeedSectionListPartDelegate.a) extendArgs;
        } else {
            aVar = null;
        }
        if (aVar == null) {
            return;
        }
        QLog.i(getTag(), 2, "[setDelayRefreshMode]--hostFragment.isResumed:" + r().getHostFragment().isResumed() + ", refreshExtendArgs.isFirstRefresh: " + aVar.getIsFirstRefresh());
        if (!r().getHostFragment().isResumed() && aVar.getIsFirstRefresh()) {
            aVar.g(true);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.FeedSectionListPartDelegate, com.tencent.input.base.mvicompat.ex.a
    public void E(@NotNull MsgIntent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof FeedSectionListPartCallerMsgIntent.CallFirstDataShowOnScreen) {
            J((FeedSectionListPartCallerMsgIntent.CallFirstDataShowOnScreen) event);
        } else {
            super.E(event);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.FeedSectionListPartDelegate, bk1.a
    public void M2(@NotNull Part part, @NotNull ak1.a partApi) {
        Intrinsics.checkNotNullParameter(part, "part");
        Intrinsics.checkNotNullParameter(partApi, "partApi");
        super.M2(part, partApi);
        this.headerWorker.h(partApi);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.FeedSectionListPartDelegate, ak1.b
    public void X4(boolean enableUseCache, boolean isShowHeadRefresher, boolean forceScrollTop, @Nullable Object extendArgs, @Nullable Function4<? super Boolean, ? super String, ? super Integer, ? super Boolean, Unit> callback) {
        if (forceScrollTop) {
            s().B1(0);
        }
        if (extendArgs instanceof FeedSectionListPartDelegate.a) {
            L(extendArgs);
        }
        super.X4(enableUseCache, isShowHeadRefresher, forceScrollTop, extendArgs, callback);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.FeedSectionListPartDelegate, bk1.a
    @NotNull
    public a.AbstractC0131a<?, Object>[] a2() {
        return this.workers;
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.FeedSectionListPartDelegate, bk1.a
    public void h() {
        u().getVmApi().h();
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.FeedSectionListPartDelegate, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        PartIOCKt.unregisterIoc(r(), zp1.a.class);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.FeedSectionListPartDelegate, bk1.a
    public void q7(@NotNull Part part, @NotNull final com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<?> sectionContext) {
        Intrinsics.checkNotNullParameter(part, "part");
        Intrinsics.checkNotNullParameter(sectionContext, "sectionContext");
        super.q7(part, sectionContext);
        C(part);
        FeedListPartMorePanelCooperateHelper feedListPartMorePanelCooperateHelper = new FeedListPartMorePanelCooperateHelper(part, new Supplier() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.m
            @Override // androidx.core.util.Supplier
            public final Object get() {
                String K;
                K = n.K(com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b.this);
                return K;
            }
        });
        PartIOCKt.registerIoc(part, feedListPartMorePanelCooperateHelper, zp1.a.class);
        com.tencent.mobileqq.guild.feed.part.a.c(part).getLifecycle().addObserver(feedListPartMorePanelCooperateHelper);
        this.morePanelLauncherIoc = feedListPartMorePanelCooperateHelper;
    }
}
