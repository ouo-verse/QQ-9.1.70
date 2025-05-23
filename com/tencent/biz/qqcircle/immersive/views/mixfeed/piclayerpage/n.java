package com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSRecyclerViewScrollEvent;
import com.tencent.biz.qqcircle.immersive.gallery.viewmodel.QFSGalleryDetailViewModel;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QFSFollowView;
import com.tencent.biz.qqcircle.widgets.aa;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010!\u001a\u00020\u0012\u00a2\u0006\u0004\bG\u0010HJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\"\u0010\t\u001a\u00020\u00032\u0018\u0010\b\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006\u0018\u00010\u0005H\u0002J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0003H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0012\u0010\u001c\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0018H\u0016R\u0017\u0010!\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00104R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010E\u00a8\u0006I"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/n;", "Lcom/tencent/biz/qqcircle/bizparts/b;", "Landroid/view/View$OnClickListener;", "", "initViewModel", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Le30/b;", "uiStateData", "F9", "Lfeedcloud/FeedCloudMeta$StFeed;", "stFeed", "B9", "J9", "G9", "C9", "I9", "H9", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "initBean", "E9", "D9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "view", NodeProps.ON_CLICK, "d", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "getMInitBean", "()Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "mInitBean", "Landroid/widget/FrameLayout;", "e", "Landroid/widget/FrameLayout;", "mTitleBar", "Landroid/widget/LinearLayout;", "f", "Landroid/widget/LinearLayout;", "mTitleInfoLl", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "mIvBack", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "i", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "mAvatar", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "mTvNickName", BdhLogUtil.LogTag.Tag_Conn, "mTvPublishTime", "Lcom/tencent/biz/qqcircle/widgets/QFSFollowView;", "D", "Lcom/tencent/biz/qqcircle/widgets/QFSFollowView;", "mFollowBtn", "Landroid/util/Size;", "E", "Landroid/util/Size;", "mDefAvatarSize", UserInfo.SEX_FEMALE, "Lfeedcloud/FeedCloudMeta$StFeed;", "mFeed", "Lcom/tencent/biz/qqcircle/immersive/gallery/viewmodel/QFSGalleryDetailViewModel;", "G", "Lcom/tencent/biz/qqcircle/immersive/gallery/viewmodel/QFSGalleryDetailViewModel;", "mViewModel", "<init>", "(Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class n extends com.tencent.biz.qqcircle.bizparts.b implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView mTvPublishTime;

    /* renamed from: D, reason: from kotlin metadata */
    private QFSFollowView mFollowBtn;

    /* renamed from: E, reason: from kotlin metadata */
    private Size mDefAvatarSize;

    /* renamed from: F, reason: from kotlin metadata */
    private FeedCloudMeta$StFeed mFeed;

    /* renamed from: G, reason: from kotlin metadata */
    private QFSGalleryDetailViewModel mViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QCircleInitBean mInitBean;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mTitleBar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mTitleInfoLl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView mIvBack;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QCircleAvatarView mAvatar;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mTvNickName;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0016\u0012\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001J\"\u0010\u0007\u001a\u00020\u00062\u0018\u0010\u0005\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/n$b", "Landroidx/lifecycle/Observer;", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Le30/b;", "listUIStateData", "", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b implements Observer<UIStateData<List<e30.b>>> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable UIStateData<List<e30.b>> listUIStateData) {
            n.this.F9(listUIStateData);
        }
    }

    public n(@NotNull QCircleInitBean mInitBean) {
        Intrinsics.checkNotNullParameter(mInitBean, "mInitBean");
        this.mInitBean = mInitBean;
    }

    private final void B9(FeedCloudMeta$StFeed stFeed) {
        if (stFeed != null && stFeed.poster != null) {
            LinearLayout linearLayout = this.mTitleInfoLl;
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = null;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleInfoLl");
                linearLayout = null;
            }
            linearLayout.setVisibility(0);
            this.mFeed = stFeed;
            G9();
            TextView textView = this.mTvNickName;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvNickName");
                textView = null;
            }
            FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.mFeed;
            if (feedCloudMeta$StFeed2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFeed");
            } else {
                feedCloudMeta$StFeed = feedCloudMeta$StFeed2;
            }
            textView.setText(feedCloudMeta$StFeed.poster.nick.get());
            I9();
            J9();
            H9();
        }
    }

    private final void C9() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.mFeed;
        QCircleAvatarView qCircleAvatarView = null;
        if (feedCloudMeta$StFeed == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeed");
            feedCloudMeta$StFeed = null;
        }
        if (feedCloudMeta$StFeed.poster == null) {
            return;
        }
        QCircleAvatarView qCircleAvatarView2 = this.mAvatar;
        if (qCircleAvatarView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatar");
            qCircleAvatarView2 = null;
        }
        VideoReport.setElementId(qCircleAvatarView2, "em_xsj_author_avatar");
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.mFeed;
        if (feedCloudMeta$StFeed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeed");
            feedCloudMeta$StFeed2 = null;
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, feedCloudMeta$StFeed2.poster.f398463id.get());
        QCircleAvatarView qCircleAvatarView3 = this.mAvatar;
        if (qCircleAvatarView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatar");
            qCircleAvatarView3 = null;
        }
        VideoReport.setElementParams(qCircleAvatarView3, buildElementParams);
        QCircleAvatarView qCircleAvatarView4 = this.mAvatar;
        if (qCircleAvatarView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatar");
        } else {
            qCircleAvatarView = qCircleAvatarView4;
        }
        VideoReport.setElementEndExposePolicy(qCircleAvatarView, EndExposurePolicy.REPORT_ALL);
    }

    private final void D9() {
        QFSFollowView qFSFollowView = this.mFollowBtn;
        if (qFSFollowView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFollowBtn");
            qFSFollowView = null;
        }
        qFSFollowView.setItemReportListener(new a());
    }

    private final QCircleInitBean E9(QCircleInitBean initBean) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = null;
        if (initBean == null) {
            return null;
        }
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        String uin = initBean.getUin();
        if (TextUtils.isEmpty(uin)) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.mFeed;
            if (feedCloudMeta$StFeed2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFeed");
            } else {
                feedCloudMeta$StFeed = feedCloudMeta$StFeed2;
            }
            uin = feedCloudMeta$StFeed.poster.get().f398463id.get();
        }
        qCircleInitBean.setUin(uin);
        qCircleInitBean.setFromReportBean(initBean.getFromReportBean());
        qCircleInitBean.setEnableReleaseAudioFocus(false);
        return qCircleInitBean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9(UIStateData<List<e30.b>> uiStateData) {
        List<e30.b> data;
        e30.b bVar;
        if (uiStateData == null) {
            QLog.e(getTAG(), 1, "[handleUiStatus] uiStateData == null");
            return;
        }
        int state = uiStateData.getState();
        QLog.d(getTAG(), 1, "[handleUiStatus] state = " + state);
        if ((state == 2 || state == 3) && (data = uiStateData.getData()) != null && (bVar = data.get(0)) != null) {
            B9(bVar.g());
        }
    }

    private final void G9() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.mFeed;
        Size size = null;
        if (feedCloudMeta$StFeed == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeed");
            feedCloudMeta$StFeed = null;
        }
        if (feedCloudMeta$StFeed.poster == null) {
            return;
        }
        QCircleAvatarView qCircleAvatarView = this.mAvatar;
        if (qCircleAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatar");
            qCircleAvatarView = null;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.mFeed;
        if (feedCloudMeta$StFeed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeed");
            feedCloudMeta$StFeed2 = null;
        }
        FeedCloudMeta$StUser feedCloudMeta$StUser = feedCloudMeta$StFeed2.poster;
        Size size2 = this.mDefAvatarSize;
        if (size2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDefAvatarSize");
        } else {
            size = size2;
        }
        qCircleAvatarView.setAvatar(feedCloudMeta$StUser, size);
        C9();
    }

    private final void H9() {
        QFSFollowView qFSFollowView = this.mFollowBtn;
        QFSFollowView qFSFollowView2 = null;
        if (qFSFollowView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFollowBtn");
            qFSFollowView = null;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.mFeed;
        if (feedCloudMeta$StFeed == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeed");
            feedCloudMeta$StFeed = null;
        }
        qFSFollowView.setUserData(feedCloudMeta$StFeed.poster.get());
        QFSFollowView qFSFollowView3 = this.mFollowBtn;
        if (qFSFollowView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFollowBtn");
        } else {
            qFSFollowView2 = qFSFollowView3;
        }
        qFSFollowView2.setFollowedDismiss(false);
        D9();
    }

    private final void I9() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.mFeed;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = null;
        TextView textView = null;
        if (feedCloudMeta$StFeed == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeed");
            feedCloudMeta$StFeed = null;
        }
        if (feedCloudMeta$StFeed.createTime.get() <= 0) {
            QLog.e(getTAG(), 1, "[updatePublishTimeView] createTime is empty");
            TextView textView2 = this.mTvPublishTime;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvPublishTime");
            } else {
                textView = textView2;
            }
            textView.setVisibility(8);
            return;
        }
        TextView textView3 = this.mTvPublishTime;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvPublishTime");
            textView3 = null;
        }
        textView3.setVisibility(0);
        TextView textView4 = this.mTvPublishTime;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvPublishTime");
            textView4 = null;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed3 = this.mFeed;
        if (feedCloudMeta$StFeed3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeed");
        } else {
            feedCloudMeta$StFeed2 = feedCloudMeta$StFeed3;
        }
        textView4.setText(QCirclePluginUtil.formatData(feedCloudMeta$StFeed2.createTime.get() * 1000));
    }

    private final void J9() {
        QFSFollowView qFSFollowView = this.mFollowBtn;
        QFSFollowView qFSFollowView2 = null;
        if (qFSFollowView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFollowBtn");
            qFSFollowView = null;
        }
        VideoReport.setElementId(qFSFollowView, QCircleDaTongConstant.ElementId.EM_XSJ_FOLLOW_BUTTON);
        HashMap hashMap = new HashMap();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.mFeed;
        if (feedCloudMeta$StFeed == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeed");
            feedCloudMeta$StFeed = null;
        }
        hashMap.put("xsj_target_qq", feedCloudMeta$StFeed.poster.f398463id.get());
        hashMap.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.mFeed;
        if (feedCloudMeta$StFeed2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeed");
            feedCloudMeta$StFeed2 = null;
        }
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FOLLOW_STATUS, r.F(feedCloudMeta$StFeed2.poster.followState.get()));
        QFSFollowView qFSFollowView3 = this.mFollowBtn;
        if (qFSFollowView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFollowBtn");
            qFSFollowView3 = null;
        }
        VideoReport.setElementParams(qFSFollowView3, hashMap);
        QFSFollowView qFSFollowView4 = this.mFollowBtn;
        if (qFSFollowView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFollowBtn");
        } else {
            qFSFollowView2 = qFSFollowView4;
        }
        VideoReport.setElementClickPolicy(qFSFollowView2, ClickPolicy.REPORT_ALL);
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(QFSGalleryDetailViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel<QFSGalleryD\u2026ailViewModel::class.java)");
        QFSGalleryDetailViewModel qFSGalleryDetailViewModel = (QFSGalleryDetailViewModel) viewModel;
        this.mViewModel = qFSGalleryDetailViewModel;
        if (qFSGalleryDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            qFSGalleryDetailViewModel = null;
        }
        qFSGalleryDetailViewModel.j().observe(getHostFragment(), new b());
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSNewContentDetailTitlePart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        Activity activity;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            int id5 = view.getId();
            if (id5 == R.id.f43051lf) {
                if (!getPartManager().onBackEvent() && (activity = getActivity()) != null) {
                    activity.finish();
                }
            } else if (id5 == R.id.f43021lc) {
                com.tencent.biz.qqcircle.launcher.c.d0(view.getContext(), E9(this.mInitBean));
            } else if (id5 == R.id.f43061lg && fb0.a.a("QFSNewContentDetailTitlePartDoubleClick")) {
                SimpleEventBus.getInstance().dispatchEvent(new QFSRecyclerViewScrollEvent(0.0f, 0.0f));
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.f43051lf);
        ImageView imageView = (ImageView) findViewById;
        imageView.setOnClickListener(this);
        VideoReport.setElementId(imageView, "em_xsj_back_button");
        VideoReport.setElementClickPolicy(imageView, ClickPolicy.REPORT_ALL);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<Im\u2026icy.REPORT_ALL)\n        }");
        this.mIvBack = imageView;
        View findViewById2 = rootView.findViewById(R.id.f43021lc);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById<QC\u2026lery_detail_title_avatar)");
        this.mAvatar = (QCircleAvatarView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f43071lh);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById<Te\u2026y_detail_title_nick_name)");
        this.mTvNickName = (TextView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.f43081li);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById<Te\u2026etail_title_publish_time)");
        this.mTvPublishTime = (TextView) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.f43031ld);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById<QF\u2026lery_detail_title_follow)");
        this.mFollowBtn = (QFSFollowView) findViewById5;
        Size a16 = com.tencent.biz.qqcircle.immersive.utils.n.a(rootView.getContext(), R.dimen.d2l);
        Intrinsics.checkNotNullExpressionValue(a16, "buildAvatarSize(\n       \u2026tle_avatar_size\n        )");
        this.mDefAvatarSize = a16;
        QCircleAvatarView qCircleAvatarView = this.mAvatar;
        FrameLayout frameLayout = null;
        if (qCircleAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatar");
            qCircleAvatarView = null;
        }
        qCircleAvatarView.setOnClickListener(this);
        View findViewById6 = rootView.findViewById(R.id.f43061lg);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById<Fr\u2026lery_detail_title_layout)");
        this.mTitleBar = (FrameLayout) findViewById6;
        View findViewById7 = rootView.findViewById(R.id.f43041le);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById<Li\u2026ery_detail_title_info_ll)");
        this.mTitleInfoLl = (LinearLayout) findViewById7;
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(rootView.getContext());
        FrameLayout frameLayout2 = this.mTitleBar;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            frameLayout2 = null;
        }
        ViewGroup.LayoutParams layoutParams = frameLayout2.getLayoutParams();
        int dimension = (int) (getContext().getResources().getDimension(R.dimen.d2m) + statusBarHeight);
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, dimension);
        }
        layoutParams.height = dimension;
        FrameLayout frameLayout3 = this.mTitleBar;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            frameLayout3 = null;
        }
        frameLayout3.setLayoutParams(layoutParams);
        FrameLayout frameLayout4 = this.mTitleBar;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            frameLayout4 = null;
        }
        frameLayout4.setPadding(0, statusBarHeight, 0, 0);
        FrameLayout frameLayout5 = this.mTitleBar;
        if (frameLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
        } else {
            frameLayout = frameLayout5;
        }
        frameLayout.setOnClickListener(this);
        if (!this.mInitBean.isForceFromNetwork()) {
            B9(this.mInitBean.getFeed());
        }
        initViewModel();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/views/mixfeed/piclayerpage/n$a", "Lcom/tencent/biz/qqcircle/widgets/QFSFollowView$d;", "", "state", "", "c", NodeProps.ON_CLICK, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class a implements QFSFollowView.d {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void a() {
            HashMap hashMap = new HashMap();
            hashMap.put("xsj_action_type", "cancel");
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = n.this.mFeed;
            QFSFollowView qFSFollowView = null;
            if (feedCloudMeta$StFeed == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFeed");
                feedCloudMeta$StFeed = null;
            }
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FOLLOW_STATUS, r.F(feedCloudMeta$StFeed.poster.followState.get()));
            QFSFollowView qFSFollowView2 = n.this.mFollowBtn;
            if (qFSFollowView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFollowBtn");
            } else {
                qFSFollowView = qFSFollowView2;
            }
            VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_FOLLOW, qFSFollowView, hashMap);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public /* synthetic */ void b() {
            aa.a(this);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void onClick(int state) {
            if (state == 0) {
                HashMap hashMap = new HashMap();
                hashMap.put("xsj_action_type", "follow");
                FeedCloudMeta$StFeed feedCloudMeta$StFeed = n.this.mFeed;
                QFSFollowView qFSFollowView = null;
                if (feedCloudMeta$StFeed == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFeed");
                    feedCloudMeta$StFeed = null;
                }
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FOLLOW_STATUS, r.F(feedCloudMeta$StFeed.poster.followState.get()));
                QFSFollowView qFSFollowView2 = n.this.mFollowBtn;
                if (qFSFollowView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFollowBtn");
                } else {
                    qFSFollowView = qFSFollowView2;
                }
                VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_FOLLOW, qFSFollowView, hashMap);
            }
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void c(int state) {
        }
    }
}
