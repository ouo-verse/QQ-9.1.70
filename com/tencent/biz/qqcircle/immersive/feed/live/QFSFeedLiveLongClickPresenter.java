package com.tencent.biz.qqcircle.immersive.feed.live;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.utils.au;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qqlive.common.api.IAegisLogApi;
import feedcloud.FeedCloudMeta$StFeed;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\"\u0010\u0015\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/live/QFSFeedLiveLongClickPresenter;", "Lcom/tencent/biz/qqcircle/immersive/feed/QFSBaseFeedChildPresenter;", "Lfeedcloud/FeedCloudMeta$StFeed;", "", "l1", "", "w0", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "N0", "Lcom/tencent/biz/richframework/video/rfw/drive/RFWFeedSelectInfo;", "selectInfo", "onFeedSelected", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "I", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "log", "Lkotlin/Function1;", "", "J", "Lkotlin/jvm/functions/Function1;", "longClickListener", "<init>", "()V", "K", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSFeedLiveLongClickPresenter extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final IAegisLogApi log;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Function1<View, Boolean> longClickListener;

    public QFSFeedLiveLongClickPresenter() {
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.log = (IAegisLogApi) api;
        this.longClickListener = new Function1<View, Boolean>() { // from class: com.tencent.biz.qqcircle.immersive.feed.live.QFSFeedLiveLongClickPresenter$longClickListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@Nullable View view) {
                Object obj;
                Object obj2;
                IAegisLogApi iAegisLogApi;
                obj = ((QFSBaseFeedChildPresenter) QFSFeedLiveLongClickPresenter.this).f85017h;
                int i3 = ((FeedCloudMeta$StFeed) obj).feedType.get();
                obj2 = ((QFSBaseFeedChildPresenter) QFSFeedLiveLongClickPresenter.this).f85017h;
                int i16 = ((FeedCloudMeta$StFeed) obj2).type.get();
                iAegisLogApi = QFSFeedLiveLongClickPresenter.this.log;
                iAegisLogApi.i("LiveLongClickPresenter", "LivePresenterLongClick, feedType: " + i3 + ", type: " + i16);
                QFSFeedLiveLongClickPresenter.this.l1();
                return Boolean.TRUE;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void l1() {
        QCircleShareInfo c16 = au.c((FeedCloudMeta$StFeed) this.f85017h);
        c16.isShowShareToFriend = true;
        c16.isShowShareToQZone = true;
        c16.isShowShareToWechat = false;
        c16.isShowShareToWechatCircle = false;
        c16.isShowShareToChannel = false;
        c16.feedBlockData = this.E;
        c16.extraTypeInfo.mDataPosition = this.f85018i;
        c16.mReportBean = getReportBean();
        c16.isShowReport = false;
        c16.isShowBarrageSwitch = false;
        c16.isShareBottomBarrageSwitch = com.tencent.biz.qqcircle.immersive.utils.o.e((FeedCloudMeta$StFeed) this.f85017h);
        c16.isShowCopySchemaLink = false;
        c16.isShowCollect = false;
        SimpleEventBus.getInstance().dispatchEvent(new StartingShareEvent(o40.a.b((FeedCloudMeta$StFeed) this.f85017h)));
        t40.a s06 = s0();
        if (s06 != null) {
            s06.onHandlerMessage("event_open_share", c16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m1(Function1 tmp0, View view) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(view)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n1(Function1 tmp0, View view) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(view)).booleanValue();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.N0(rootView);
        this.C = rootView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onFeedSelected(selectInfo);
        if (com.tencent.biz.qqcircle.immersive.adapter.n.g((FeedCloudMeta$StFeed) this.f85017h) == 2) {
            View findViewById = this.C.findViewById(R.id.f40791fb);
            this.f85016f = findViewById;
            findViewById.setLongClickable(true);
            View view = this.f85016f;
            final Function1<View, Boolean> function1 = this.longClickListener;
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.live.s
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view2) {
                    boolean m16;
                    m16 = QFSFeedLiveLongClickPresenter.m1(Function1.this, view2);
                    return m16;
                }
            });
            return;
        }
        this.C.setLongClickable(true);
        View view2 = this.C;
        final Function1<View, Boolean> function12 = this.longClickListener;
        view2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.live.t
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view3) {
                boolean n16;
                n16 = QFSFeedLiveLongClickPresenter.n1(Function1.this, view3);
                return n16;
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    @NotNull
    /* renamed from: w0 */
    public String getTAG() {
        return "LiveLongClickPresenter";
    }
}
