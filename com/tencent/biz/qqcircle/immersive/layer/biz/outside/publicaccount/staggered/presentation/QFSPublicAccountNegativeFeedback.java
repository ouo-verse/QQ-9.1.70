package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation;

import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.events.QFSPublicAccountStaggerItemRemoveEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleSetUnCareRequest;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleKey;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import feedcloud.FeedCloudMeta$StFeed;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/QFSPublicAccountNegativeFeedback;", "", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/NegativeItem;", "negativeItem", "", "position", "pageId", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/a;", JsonRuleKey.OPERATOR, "", "c", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPublicAccountNegativeFeedback {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QFSPublicAccountNegativeFeedback f86879a = new QFSPublicAccountNegativeFeedback();

    QFSPublicAccountNegativeFeedback() {
    }

    @JvmStatic
    public static final void c(@NotNull final FeedCloudMeta$StFeed feed, @NotNull final NegativeItem negativeItem, int position, int pageId, @NotNull final a operator) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(negativeItem, "negativeItem");
        Intrinsics.checkNotNullParameter(operator, "operator");
        if (feed.isRecomFd.get()) {
            feed.f398449id.set(feed.recomForward.f398458id.get());
            feed.poster.set(feed.recomForward.poster.get());
        }
        if (negativeItem.getId() == 4) {
            VSNetworkHelper.getInstance().sendRequest(new QCircleSetUnCareRequest(feed.poster.f398463id.get(), 1, 0, null), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.b
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                    QFSPublicAccountNegativeFeedback.d(baseRequest, z16, j3, str, obj);
                }
            });
        }
        QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(ua0.c.a(feed).setToUin(feed.poster.f398463id.get()).setActionType(65).setSubActionType(negativeItem.getId()).setIndex(position).setExt3(feed.createTime.toString()).setPageId(pageId)));
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        String str = feed.f398449id.get();
        Intrinsics.checkNotNullExpressionValue(str, "feed.id.get()");
        simpleEventBus.dispatchEvent(new QFSPublicAccountStaggerItemRemoveEvent(str));
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.c
            @Override // java.lang.Runnable
            public final void run() {
                QFSPublicAccountNegativeFeedback.e(a.this, feed, negativeItem);
            }
        }, 300L);
        QCircleToast.i(QCircleToast.f91646f, R.string.f182873hn, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
        QLog.i("QFSPublicAccountNegativeFeedback", 1, "unCare person: isSuccess=" + z16 + " retCode=" + j3 + " errMsg=" + str);
        if (!z16 || j3 != 0) {
            QCircleToast.i(QCircleToast.f91645e, R.string.f19228473, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(a operator, final FeedCloudMeta$StFeed feed, final NegativeItem negativeItem) {
        Intrinsics.checkNotNullParameter(operator, "$operator");
        Intrinsics.checkNotNullParameter(feed, "$feed");
        Intrinsics.checkNotNullParameter(negativeItem, "$negativeItem");
        operator.removeAll(new Function1<e30.b, Boolean>() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.QFSPublicAccountNegativeFeedback$doNegativeFeedback$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull e30.b blockData) {
                Intrinsics.checkNotNullParameter(blockData, "blockData");
                return Boolean.valueOf(Intrinsics.areEqual(blockData.g().f398449id.get(), FeedCloudMeta$StFeed.this.f398449id.get()) || (negativeItem.getId() == 4 && Intrinsics.areEqual(blockData.g().poster.f398463id.get(), FeedCloudMeta$StFeed.this.poster.f398463id.get())));
            }
        });
    }
}
