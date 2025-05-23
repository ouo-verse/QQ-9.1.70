package com.tencent.biz.qqcircle.immersive.personal.part;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.immersive.events.QFSResetPersonalInfoEvent;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSUserResetEvent;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSRankTagListView;
import com.tencent.biz.qqcircle.richframework.compat.CompatSlideFragment;
import com.tencent.biz.qqcircle.widgets.person.QCirclePersonalPymkContainerView;
import com.tencent.biz.qqcircle.widgets.textview.QCircleTailExpandText;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.biz.richframework.compat.CompatPublicFragment;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 W2\u00020\u00012\u00020\u0002:\u0001XB\u0007\u00a2\u0006\u0004\bU\u0010VJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\rH\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001dR\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00104\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010\u001dR\u0018\u00106\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010\u001dR\u0018\u00108\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010\u001dR\u0018\u0010:\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010\u001dR\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010T\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010Q\u00a8\u0006Y"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/part/av;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "Landroid/view/View$OnClickListener;", "", "C9", "z9", "F9", "E9", "D9", "B9", "G9", "", "x9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "getLogTag", "Lfeedcloud/FeedCloudMeta$StFeed;", "stFeed", "A9", "v", NodeProps.ON_CLICK, "Lcom/tencent/biz/qqcircle/widgets/textview/QCircleTailExpandText;", "d", "Lcom/tencent/biz/qqcircle/widgets/textview/QCircleTailExpandText;", "mTailExpandText", "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "mLlInfo", "f", "mLlOwnerOpt", tl.h.F, "mLlClientOpt", "Landroidx/recyclerview/widget/RecyclerView;", "i", "Landroidx/recyclerview/widget/RecyclerView;", "mRcvShopList", "Landroid/widget/FrameLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/FrameLayout;", "mFlPymkOpt", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "mIvPymkOpt", "Lcom/tencent/biz/qqcircle/widgets/person/QCirclePersonalPymkContainerView;", "D", "Lcom/tencent/biz/qqcircle/widgets/person/QCirclePersonalPymkContainerView;", "mPymkPanel", "E", "mLlJustWatched", UserInfo.SEX_FEMALE, "mLlFollowPanel", "G", "mLlUrgePanel", "H", "mLlRecommendLayout", "Lcom/tencent/biz/qqcircle/immersive/personal/widget/QFSRankTagListView;", "I", "Lcom/tencent/biz/qqcircle/immersive/personal/widget/QFSRankTagListView;", "mRankTagListView", "Lcom/tencent/biz/qqcircle/immersive/personal/viewmodel/r;", "J", "Lcom/tencent/biz/qqcircle/immersive/personal/viewmodel/r;", "mViewModel", "Lcom/tencent/biz/qqcircle/immersive/personal/viewmodel/e;", "K", "Lcom/tencent/biz/qqcircle/immersive/personal/viewmodel/e;", "mJustWatchViewModel", "Lcom/tencent/biz/qqcircle/immersive/personal/viewmodel/c;", "L", "Lcom/tencent/biz/qqcircle/immersive/personal/viewmodel/c;", "mFollowPanelViewModel", "Lcom/tencent/biz/qqcircle/immersive/personal/viewmodel/s;", "M", "Lcom/tencent/biz/qqcircle/immersive/personal/viewmodel/s;", "mUrgePanelViewModel", "Lcom/tencent/biz/qqcircle/immersive/personal/viewmodel/d;", "N", "Lcom/tencent/biz/qqcircle/immersive/personal/viewmodel/d;", "mPraisedViewModel", "P", "mPushedViewModel", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class av extends com.tencent.biz.qqcircle.immersive.part.u implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ImageView mIvPymkOpt;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private QCirclePersonalPymkContainerView mPymkPanel;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private LinearLayout mLlJustWatched;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private LinearLayout mLlFollowPanel;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private LinearLayout mLlUrgePanel;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private LinearLayout mLlRecommendLayout;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private QFSRankTagListView mRankTagListView;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.r mViewModel;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.e mJustWatchViewModel;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.c mFollowPanelViewModel;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.s mUrgePanelViewModel;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.d mPraisedViewModel;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.d mPushedViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QCircleTailExpandText mTailExpandText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout mLlInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout mLlOwnerOpt;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout mLlClientOpt;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView mRcvShopList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout mFlPymkOpt;

    private final void B9() {
        Runnable runnable;
        Runnable runnable2;
        LinearLayout linearLayout;
        MutableLiveData<com.tencent.biz.qqcircle.immersive.personal.bean.c> mutableLiveData = null;
        if (this.mLlFollowPanel == null) {
            View partRootView = getPartRootView();
            if (partRootView != null) {
                linearLayout = (LinearLayout) partRootView.findViewById(R.id.f46041ti);
            } else {
                linearLayout = null;
            }
            this.mLlFollowPanel = linearLayout;
        }
        LinearLayout linearLayout2 = this.mLlFollowPanel;
        if (linearLayout2 != null) {
            com.tencent.biz.qqcircle.immersive.personal.viewmodel.c cVar = this.mFollowPanelViewModel;
            if (cVar != null) {
                runnable2 = cVar.O1();
            } else {
                runnable2 = null;
            }
            linearLayout2.removeCallbacks(runnable2);
        }
        LinearLayout linearLayout3 = this.mLlFollowPanel;
        if (linearLayout3 != null) {
            com.tencent.biz.qqcircle.immersive.personal.viewmodel.c cVar2 = this.mFollowPanelViewModel;
            if (cVar2 != null) {
                runnable = cVar2.N1();
            } else {
                runnable = null;
            }
            linearLayout3.removeCallbacks(runnable);
        }
        LinearLayout linearLayout4 = this.mLlFollowPanel;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.c cVar3 = this.mFollowPanelViewModel;
        if (cVar3 != null) {
            mutableLiveData = cVar3.M1();
        }
        if (mutableLiveData != null) {
            mutableLiveData.setValue(new com.tencent.biz.qqcircle.immersive.personal.bean.c());
        }
    }

    private final void C9() {
        QCirclePersonalPymkContainerView qCirclePersonalPymkContainerView;
        ImageView imageView;
        FrameLayout frameLayout;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        QCircleTailExpandText qCircleTailExpandText;
        RecyclerView recyclerView = null;
        if (this.mTailExpandText == null) {
            View partRootView = getPartRootView();
            if (partRootView != null) {
                qCircleTailExpandText = (QCircleTailExpandText) partRootView.findViewById(R.id.f56042jj);
            } else {
                qCircleTailExpandText = null;
            }
            this.mTailExpandText = qCircleTailExpandText;
        }
        QCircleTailExpandText qCircleTailExpandText2 = this.mTailExpandText;
        if (qCircleTailExpandText2 != null) {
            qCircleTailExpandText2.setOpen(false);
        }
        if (this.mLlInfo == null) {
            View partRootView2 = getPartRootView();
            if (partRootView2 != null) {
                linearLayout3 = (LinearLayout) partRootView2.findViewById(R.id.f46081tm);
            } else {
                linearLayout3 = null;
            }
            this.mLlInfo = linearLayout3;
        }
        LinearLayout linearLayout4 = this.mLlInfo;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        if (this.mLlOwnerOpt == null) {
            View partRootView3 = getPartRootView();
            if (partRootView3 != null) {
                linearLayout2 = (LinearLayout) partRootView3.findViewById(R.id.f46211tz);
            } else {
                linearLayout2 = null;
            }
            this.mLlOwnerOpt = linearLayout2;
        }
        LinearLayout linearLayout5 = this.mLlOwnerOpt;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        if (this.mLlClientOpt == null) {
            View partRootView4 = getPartRootView();
            if (partRootView4 != null) {
                linearLayout = (LinearLayout) partRootView4.findViewById(R.id.f45941t9);
            } else {
                linearLayout = null;
            }
            this.mLlClientOpt = linearLayout;
        }
        LinearLayout linearLayout6 = this.mLlClientOpt;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(8);
        }
        if (this.mFlPymkOpt == null) {
            View partRootView5 = getPartRootView();
            if (partRootView5 != null) {
                frameLayout = (FrameLayout) partRootView5.findViewById(R.id.f41831i5);
            } else {
                frameLayout = null;
            }
            this.mFlPymkOpt = frameLayout;
        }
        FrameLayout frameLayout2 = this.mFlPymkOpt;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(0);
        }
        if (this.mIvPymkOpt == null) {
            View partRootView6 = getPartRootView();
            if (partRootView6 != null) {
                imageView = (ImageView) partRootView6.findViewById(R.id.f44531pf);
            } else {
                imageView = null;
            }
            this.mIvPymkOpt = imageView;
        }
        ImageView imageView2 = this.mIvPymkOpt;
        if (imageView2 != null) {
            imageView2.setSelected(false);
        }
        ImageView imageView3 = this.mIvPymkOpt;
        if (imageView3 != null) {
            imageView3.setRotation(0.0f);
        }
        if (this.mPymkPanel == null) {
            View partRootView7 = getPartRootView();
            if (partRootView7 != null) {
                qCirclePersonalPymkContainerView = (QCirclePersonalPymkContainerView) partRootView7.findViewById(R.id.f513227s);
            } else {
                qCirclePersonalPymkContainerView = null;
            }
            this.mPymkPanel = qCirclePersonalPymkContainerView;
        }
        QCirclePersonalPymkContainerView qCirclePersonalPymkContainerView2 = this.mPymkPanel;
        if (qCirclePersonalPymkContainerView2 != null) {
            qCirclePersonalPymkContainerView2.e();
        }
        if (this.mRcvShopList == null) {
            View partRootView8 = getPartRootView();
            if (partRootView8 != null) {
                recyclerView = (RecyclerView) partRootView8.findViewById(R.id.f515928i);
            }
            this.mRcvShopList = recyclerView;
        }
        RecyclerView recyclerView2 = this.mRcvShopList;
        if (recyclerView2 != null) {
            recyclerView2.setVisibility(8);
        }
        SimpleEventBus.getInstance().dispatchEvent(new QFSResetPersonalInfoEvent(getHostFragment().hashCode()));
    }

    private final void D9() {
        LinearLayout linearLayout;
        MutableLiveData<com.tencent.biz.qqcircle.immersive.personal.bean.d> mutableLiveData = null;
        if (this.mLlJustWatched == null) {
            View partRootView = getPartRootView();
            if (partRootView != null) {
                linearLayout = (LinearLayout) partRootView.findViewById(R.id.f46091tn);
            } else {
                linearLayout = null;
            }
            this.mLlJustWatched = linearLayout;
        }
        LinearLayout linearLayout2 = this.mLlJustWatched;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.e eVar = this.mJustWatchViewModel;
        if (eVar != null) {
            mutableLiveData = eVar.M1();
        }
        if (mutableLiveData != null) {
            mutableLiveData.setValue(new com.tencent.biz.qqcircle.immersive.personal.bean.d());
        }
        com.tencent.mobileqq.qui.b.f276860a.a(this.mLlJustWatched, RFWNavigationBarImmersiveHelper.ImmersiveType.ABOVE);
    }

    private final void E9() {
        LinearLayout linearLayout;
        if (this.mLlRecommendLayout == null) {
            View partRootView = getPartRootView();
            if (partRootView != null) {
                linearLayout = (LinearLayout) partRootView.findViewById(R.id.f46221u0);
            } else {
                linearLayout = null;
            }
            this.mLlRecommendLayout = linearLayout;
        }
        LinearLayout linearLayout2 = this.mLlRecommendLayout;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
    }

    private final void F9() {
        QFSRankTagListView qFSRankTagListView;
        if (this.mRankTagListView == null) {
            View partRootView = getPartRootView();
            if (partRootView != null) {
                qFSRankTagListView = (QFSRankTagListView) partRootView.findViewById(R.id.f5147287);
            } else {
                qFSRankTagListView = null;
            }
            this.mRankTagListView = qFSRankTagListView;
        }
        QFSRankTagListView qFSRankTagListView2 = this.mRankTagListView;
        if (qFSRankTagListView2 != null) {
            qFSRankTagListView2.setVisibility(8);
        }
    }

    private final void G9() {
        Runnable runnable;
        Runnable runnable2;
        LinearLayout linearLayout;
        MutableLiveData<com.tencent.biz.qqcircle.immersive.personal.bean.u> mutableLiveData = null;
        if (this.mLlUrgePanel == null) {
            View partRootView = getPartRootView();
            if (partRootView != null) {
                linearLayout = (LinearLayout) partRootView.findViewById(R.id.f46301u8);
            } else {
                linearLayout = null;
            }
            this.mLlUrgePanel = linearLayout;
        }
        LinearLayout linearLayout2 = this.mLlUrgePanel;
        if (linearLayout2 != null) {
            com.tencent.biz.qqcircle.immersive.personal.viewmodel.c cVar = this.mFollowPanelViewModel;
            if (cVar != null) {
                runnable2 = cVar.O1();
            } else {
                runnable2 = null;
            }
            linearLayout2.removeCallbacks(runnable2);
        }
        LinearLayout linearLayout3 = this.mLlUrgePanel;
        if (linearLayout3 != null) {
            com.tencent.biz.qqcircle.immersive.personal.viewmodel.c cVar2 = this.mFollowPanelViewModel;
            if (cVar2 != null) {
                runnable = cVar2.N1();
            } else {
                runnable = null;
            }
            linearLayout3.removeCallbacks(runnable);
        }
        LinearLayout linearLayout4 = this.mLlUrgePanel;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.s sVar = this.mUrgePanelViewModel;
        if (sVar != null) {
            mutableLiveData = sVar.L1();
        }
        if (mutableLiveData != null) {
            mutableLiveData.setValue(new com.tencent.biz.qqcircle.immersive.personal.bean.u());
        }
    }

    private final boolean x9() {
        if (getActivity() instanceof CompatPublicActivity) {
            Activity activity = getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.tencent.biz.richframework.activity.CompatPublicActivity");
            CompatPublicFragment fragment = ((CompatPublicActivity) activity).getFragment();
            Intrinsics.checkNotNullExpressionValue(fragment, "activity as CompatPublicActivity).fragment");
            if (fragment instanceof CompatSlideFragment) {
                ((CompatSlideFragment) fragment).ph(0);
                return true;
            }
        }
        return false;
    }

    private final void z9() {
        com.tencent.biz.qqcircle.immersive.personal.data.w wVar;
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar = this.mViewModel;
        if (rVar != null) {
            wVar = rVar.v2();
        } else {
            wVar = null;
        }
        if (wVar == null) {
            return;
        }
        if (!RFWApplication.isPublicVersion() || RFWConfig.getConfigValue("qqcircle_enable_release_user_info_9_0_70", false)) {
            wVar.F();
        }
    }

    public final void A9(@Nullable FeedCloudMeta$StFeed stFeed) {
        String str;
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        PBStringField pBStringField;
        String str2 = null;
        if (stFeed != null && (feedCloudMeta$StUser = stFeed.poster) != null && (pBStringField = feedCloudMeta$StUser.f398463id) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.r rVar = this.mViewModel;
        if (rVar != null) {
            str2 = rVar.i2();
        }
        if (TextUtils.equals(str, str2)) {
            return;
        }
        C9();
        D9();
        B9();
        G9();
        E9();
        F9();
        z9();
        SimpleEventBus.getInstance().dispatchEvent(new QFSUserResetEvent(getHostFragment().hashCode()));
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSRightProfilePart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (v3.getId() == R.id.f44611pn && !getHostFragment().onBackEvent()) {
            x9();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        this.mViewModel = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.r) getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.r.class);
        this.mJustWatchViewModel = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.e) getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.e.class);
        this.mFollowPanelViewModel = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.c) getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.c.class);
        this.mUrgePanelViewModel = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.s) getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.s.class);
        this.mPraisedViewModel = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.d) getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.d.class);
        this.mPushedViewModel = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.d) getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.d.class);
    }
}
