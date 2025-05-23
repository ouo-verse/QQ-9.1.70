package com.qzone.reborn.feedpro.part.userhome;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.feedpro.event.QzoneFeedProRefreshEvent;
import com.qzone.reborn.feedpro.event.QzoneFeedProUserHomeRefreshEvent;
import com.qzone.reborn.feedpro.widget.QzoneFriendFeedProTitle;
import com.qzone.reborn.feedpro.widget.header.QzoneBaseFeedProHeaderContainerView;
import com.qzone.reborn.feedpro.widget.title.QzoneFeedProUserHomeTitle;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.util.ah;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetMainPageHeadRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.IntimateSpaceInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchConfigUtilFetcher;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.TokenResUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u0000 Q2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001RB\u0007\u00a2\u0006\u0004\bO\u0010PJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\u0018\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u001a\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0016J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020\u0011H\u0016J\u001c\u0010%\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010'\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010+\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030)0(j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030)`*H\u0016R\u0018\u0010.\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u0016\u00103\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\"\u0010>\u001a\u00020\u00078\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010H\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010-R\u0018\u0010K\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010M\u00a8\u0006S"}, d2 = {"Lcom/qzone/reborn/feedpro/part/userhome/QZoneFeedProUserHomeTitlePart;", "Lcom/qzone/reborn/feedx/part/g;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "X9", "ba", "Lcom/qzone/reborn/feedpro/widget/title/QzoneFeedProUserHomeTitle;", "feedxTitle", "ia", "T9", "Z9", "ga", "V9", "N9", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "firstVisiblePosition", "O9", "", "elementId", "Landroid/view/View;", "view", "P9", "getLogTag", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "Q9", "Y9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "S9", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "d", "Landroid/view/View;", "mMoreBtn", "e", "mSearchBtn", "f", "Z", "mDisableTitleAlpha", "Landroid/content/BroadcastReceiver;", tl.h.F, "Landroid/content/BroadcastReceiver;", "mPublishBroadcastReceiver", "i", "Lcom/qzone/reborn/feedpro/widget/title/QzoneFeedProUserHomeTitle;", "R9", "()Lcom/qzone/reborn/feedpro/widget/title/QzoneFeedProUserHomeTitle;", "ha", "(Lcom/qzone/reborn/feedpro/widget/title/QzoneFeedProUserHomeTitle;)V", "mFeedProTitle", "Lcom/qzone/reborn/feedpro/viewmodel/n;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedpro/viewmodel/n;", "mScrollViewModel", "Lcom/qzone/reborn/feedpro/viewmodel/m;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/feedpro/viewmodel/m;", "mUserHomeViewModel", "D", "btnIntimateSpace", "E", "Ljava/lang/String;", "intimateSpaceJumpUrl", UserInfo.SEX_FEMALE, "I", "mTotalDistance", "<init>", "()V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QZoneFeedProUserHomeTitlePart extends com.qzone.reborn.feedx.part.g implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private com.qzone.reborn.feedpro.viewmodel.m mUserHomeViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private View btnIntimateSpace;

    /* renamed from: E, reason: from kotlin metadata */
    private String intimateSpaceJumpUrl;

    /* renamed from: F, reason: from kotlin metadata */
    private int mTotalDistance;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View mMoreBtn;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View mSearchBtn;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mDisableTitleAlpha;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private BroadcastReceiver mPublishBroadcastReceiver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public QzoneFeedProUserHomeTitle mFeedProTitle;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedpro.viewmodel.n mScrollViewModel;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/qzone/reborn/feedpro/part/userhome/QZoneFeedProUserHomeTitlePart$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            QZoneFeedProUserHomeTitlePart.this.R9().setTitleAlpha(QZoneFeedProUserHomeTitlePart.this.O9(recyclerView, ah.a(recyclerView)));
        }
    }

    private final void N9() {
        com.qzone.reborn.feedpro.viewmodel.n nVar = this.mScrollViewModel;
        if (nVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScrollViewModel");
            nVar = null;
        }
        nVar.N1(new b());
    }

    private final void T9() {
        com.qzone.reborn.feedpro.viewmodel.m mVar = this.mUserHomeViewModel;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            mVar = null;
        }
        if (mVar.m2()) {
            int tokenRes = TokenResUtils.getTokenRes(R.drawable.qui_intimates_space, R.drawable.qui_intimates_space);
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.part.userhome.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QZoneFeedProUserHomeTitlePart.U9(QZoneFeedProUserHomeTitlePart.this, view);
                }
            };
            String string = getContext().getResources().getString(R.string.w9s);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026ing.qzone_intimate_space)");
            View c16 = QzoneFriendFeedProTitle.c(R9(), new uh.d(tokenRes, null, onClickListener, null, string, false, 42, null), false, true, 2, null);
            this.btnIntimateSpace = c16;
            if (c16 != null) {
                c16.setVisibility(8);
            }
            P9("em_bas_chum_space_entry", this.btnIntimateSpace);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(QZoneFeedProUserHomeTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        yo.d.d(this$0.intimateSpaceJumpUrl, this$0.getContext(), null);
        fo.c.b("dt_clck", this$0.btnIntimateSpace, "em_bas_chum_space_entry", null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void V9() {
        int tokenRes = TokenResUtils.getTokenRes(R.drawable.qui_more, R.drawable.qui_more);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.part.userhome.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneFeedProUserHomeTitlePart.W9(QZoneFeedProUserHomeTitlePart.this, view);
            }
        };
        String string = getContext().getResources().getString(R.string.w_g);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getString(R.string.qzone_more)");
        this.mMoreBtn = QzoneFriendFeedProTitle.c(R9(), new uh.d(tokenRes, null, onClickListener, null, string, false, 42, null), false, true, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(QZoneFeedProUserHomeTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.broadcastMessage("OPEN_FEED_PRO_USER_HOME_ACTION_PANEL", null);
        fo.c.b("dt_clck", this$0.mMoreBtn, "em_qz_set_en", null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void X9() {
        com.qzone.reborn.feedpro.viewmodel.m mVar = this.mUserHomeViewModel;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            mVar = null;
        }
        if (mVar.m2()) {
            P9("em_qz_outbox", R9().t(true));
        }
    }

    private final void Z9() {
        com.qzone.reborn.feedpro.viewmodel.m mVar = this.mUserHomeViewModel;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            mVar = null;
        }
        if (mVar.m2() && ((ISearchConfigUtilFetcher) QRoute.api(ISearchConfigUtilFetcher.class)).isEnableQzoneSearch()) {
            int tokenRes = TokenResUtils.getTokenRes(R.drawable.qui_search, R.drawable.qui_search);
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.part.userhome.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QZoneFeedProUserHomeTitlePart.aa(QZoneFeedProUserHomeTitlePart.this, view);
                }
            };
            String string = getContext().getResources().getString(R.string.wbj);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getString(R.string.qzone_search)");
            this.mSearchBtn = QzoneFriendFeedProTitle.c(R9(), new uh.d(tokenRes, null, onClickListener, null, string, false, 42, null), false, true, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(QZoneFeedProUserHomeTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((ho.j) ho.i.t(ho.j.class)).u(this$0.getContext());
        fo.c.b("dt_clck", this$0.mSearchBtn, "em_qz_search_entry", null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void ba() {
        com.qzone.reborn.feedpro.viewmodel.m mVar = this.mUserHomeViewModel;
        com.qzone.reborn.feedpro.viewmodel.m mVar2 = null;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            mVar = null;
        }
        mVar.e2().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.feedpro.part.userhome.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneFeedProUserHomeTitlePart.ca(QZoneFeedProUserHomeTitlePart.this, (Integer) obj);
            }
        });
        com.qzone.reborn.feedpro.viewmodel.m mVar3 = this.mUserHomeViewModel;
        if (mVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
        } else {
            mVar2 = mVar3;
        }
        MutableLiveData<wd.h> d26 = mVar2.d2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<wd.h, Unit> function1 = new Function1<wd.h, Unit>() { // from class: com.qzone.reborn.feedpro.part.userhome.QZoneFeedProUserHomeTitlePart$observeHeaderState$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(wd.h hVar) {
                invoke2(hVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(wd.h hVar) {
                com.qzone.reborn.feedpro.viewmodel.m mVar4;
                View view;
                View view2;
                IntimateSpaceInfo intimateSpaceInfo;
                mVar4 = QZoneFeedProUserHomeTitlePart.this.mUserHomeViewModel;
                if (mVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
                    mVar4 = null;
                }
                if (mVar4.m2()) {
                    GetMainPageHeadRsp headRsp = hVar.getHeadRsp();
                    if ((headRsp == null || (intimateSpaceInfo = headRsp.intimateSpaceInfo) == null || !intimateSpaceInfo.isShow) ? false : true) {
                        GetMainPageHeadRsp headRsp2 = hVar.getHeadRsp();
                        IntimateSpaceInfo intimateSpaceInfo2 = headRsp2 != null ? headRsp2.intimateSpaceInfo : null;
                        Intrinsics.checkNotNull(intimateSpaceInfo2);
                        if (intimateSpaceInfo2.jumpUrl.length() > 0) {
                            QZoneFeedProUserHomeTitlePart qZoneFeedProUserHomeTitlePart = QZoneFeedProUserHomeTitlePart.this;
                            GetMainPageHeadRsp headRsp3 = hVar.getHeadRsp();
                            IntimateSpaceInfo intimateSpaceInfo3 = headRsp3 != null ? headRsp3.intimateSpaceInfo : null;
                            Intrinsics.checkNotNull(intimateSpaceInfo3);
                            qZoneFeedProUserHomeTitlePart.intimateSpaceJumpUrl = intimateSpaceInfo3.jumpUrl;
                            view2 = QZoneFeedProUserHomeTitlePart.this.btnIntimateSpace;
                            if (view2 == null) {
                                return;
                            }
                            view2.setVisibility(0);
                            return;
                        }
                    }
                }
                view = QZoneFeedProUserHomeTitlePart.this.btnIntimateSpace;
                if (view == null) {
                    return;
                }
                view.setVisibility(8);
            }
        };
        d26.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.feedpro.part.userhome.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneFeedProUserHomeTitlePart.da(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(QZoneFeedProUserHomeTitlePart this$0, Integer num) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (num != null && num.intValue() == 2) {
            this$0.R9().setTitleAlpha(255);
            z16 = true;
        } else {
            z16 = false;
        }
        this$0.mDisableTitleAlpha = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ea(QZoneFeedProUserHomeTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.qzone.reborn.feedpro.viewmodel.m mVar = this$0.mUserHomeViewModel;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            mVar = null;
        }
        mVar.B2();
        com.qzone.reborn.feedpro.viewmodel.m mVar2 = this$0.mUserHomeViewModel;
        if (mVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            mVar2 = null;
        }
        mVar2.G2();
        com.qzone.reborn.feedpro.viewmodel.m mVar3 = this$0.mUserHomeViewModel;
        if (mVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            mVar3 = null;
        }
        mVar3.b2();
        this$0.broadcastMessage("SCROLL_TO_TOP", null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void ga() {
        IntentFilter intentFilter = new IntentFilter(new IntentFilter(QzoneFrame.QZONE_PUBLISH_QUEUE_NOTIFY));
        this.mPublishBroadcastReceiver = new BroadcastReceiver() { // from class: com.qzone.reborn.feedpro.part.userhome.QZoneFeedProUserHomeTitlePart$registerPublishBroadcast$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent != null) {
                    QZoneFeedProUserHomeTitlePart.this.R9().A(intent);
                }
            }
        };
        getActivity().registerReceiver(this.mPublishBroadcastReceiver, intentFilter);
    }

    private final void ia(QzoneFeedProUserHomeTitle feedxTitle) {
        int e16 = QZoneFeedxViewUtils.e(getActivity());
        if (feedxTitle.getLayoutParams() == null) {
            feedxTitle.setLayoutParams(new ViewGroup.LayoutParams(-1, e16));
        } else {
            feedxTitle.getLayoutParams().height = e16;
        }
    }

    public boolean Q9() {
        return true;
    }

    public final QzoneFeedProUserHomeTitle R9() {
        QzoneFeedProUserHomeTitle qzoneFeedProUserHomeTitle = this.mFeedProTitle;
        if (qzoneFeedProUserHomeTitle != null) {
            return qzoneFeedProUserHomeTitle;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mFeedProTitle");
        return null;
    }

    public int S9() {
        return R.id.mxn;
    }

    public void Y9() {
        T9();
        Z9();
        V9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedProUserHomeTitlePart";
    }

    public final void ha(QzoneFeedProUserHomeTitle qzoneFeedProUserHomeTitle) {
        Intrinsics.checkNotNullParameter(qzoneFeedProUserHomeTitle, "<set-?>");
        this.mFeedProTitle = qzoneFeedProUserHomeTitle;
    }

    @Override // com.qzone.reborn.feedx.part.g, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ViewModel viewModel = getViewModel(com.qzone.reborn.feedpro.viewmodel.m.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QzoneFeedPr\u2026omeViewModel::class.java)");
        this.mUserHomeViewModel = (com.qzone.reborn.feedpro.viewmodel.m) viewModel;
        ViewModel viewModel2 = getViewModel(com.qzone.reborn.feedpro.viewmodel.n.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(QzoneFriend\u2026ollViewModel::class.java)");
        this.mScrollViewModel = (com.qzone.reborn.feedpro.viewmodel.n) viewModel2;
        View findViewById = rootView.findViewById(S9());
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(getTitleViewId())");
        ha((QzoneFeedProUserHomeTitle) findViewById);
        ia(R9());
        X9();
        if (Q9()) {
            N9();
        }
        R9().setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.part.userhome.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneFeedProUserHomeTitlePart.ea(QZoneFeedProUserHomeTitlePart.this, view);
            }
        });
        com.qzone.reborn.feedpro.viewmodel.m mVar = this.mUserHomeViewModel;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            mVar = null;
        }
        if (mVar.m2()) {
            ga();
        }
        Y9();
        ba();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        BroadcastReceiver broadcastReceiver = this.mPublishBroadcastReceiver;
        if (broadcastReceiver != null) {
            activity.unregisterReceiver(broadcastReceiver);
        }
        R9().u();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        com.qzone.reborn.feedpro.viewmodel.m mVar;
        com.qzone.reborn.feedpro.viewmodel.m mVar2 = null;
        if (event instanceof QzoneFeedProUserHomeRefreshEvent) {
            com.qzone.reborn.feedpro.viewmodel.m mVar3 = this.mUserHomeViewModel;
            if (mVar3 != null) {
                if (mVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
                    mVar3 = null;
                }
                mVar3.b2();
                broadcastMessage("SCROLL_TO_TOP", null);
                return;
            }
            return;
        }
        if (!(event instanceof QzoneFeedProRefreshEvent) || (mVar = this.mUserHomeViewModel) == null) {
            return;
        }
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
        } else {
            mVar2 = mVar;
        }
        mVar2.b2();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QzoneFeedProUserHomeRefreshEvent.class, QzoneFeedProRefreshEvent.class);
        return arrayListOf;
    }

    private final void P9(String elementId, View view) {
        if (view != null) {
            fo.c.r(view, elementId, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int O9(RecyclerView recyclerView, int firstVisiblePosition) {
        if (firstVisiblePosition > 1 || this.mDisableTitleAlpha) {
            return 255;
        }
        View childAt = recyclerView.getChildAt(0);
        if (!(childAt instanceof QzoneBaseFeedProHeaderContainerView)) {
            return 0;
        }
        QzoneBaseFeedProHeaderContainerView qzoneBaseFeedProHeaderContainerView = (QzoneBaseFeedProHeaderContainerView) childAt;
        int abs = Math.abs(qzoneBaseFeedProHeaderContainerView.getTop());
        int e16 = qzoneBaseFeedProHeaderContainerView.e();
        if (e16 == 0) {
            e16 = qzoneBaseFeedProHeaderContainerView.getMeasuredHeight();
        }
        if (abs <= 0 || e16 <= 0) {
            return 0;
        }
        if (this.mTotalDistance <= 0) {
            this.mTotalDistance = e16 - R9().getMeasuredHeight();
        }
        int i3 = this.mTotalDistance;
        if (abs >= i3) {
            return 255;
        }
        return (abs * 255) / i3;
    }
}
