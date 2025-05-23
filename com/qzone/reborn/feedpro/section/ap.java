package com.qzone.reborn.feedpro.section;

import android.app.Activity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.feedpro.event.QzoneFeedProDetailFirstRefreshEvent;
import com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProMixBaseWidgetView;
import com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProPicMixVideoView;
import com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProVideoItemWidgetView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMedia;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.anim.RFWTransAnimBean;
import com.tencent.richframework.gallery.anim.RFWTransitionHelper;
import com.tencent.util.ArrayUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00102\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001)B\u0007\u00a2\u0006\u0004\bE\u0010FJ\"\u0010\r\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\"\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\"\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0014J\b\u0010 \u001a\u00020\bH\u0014J\b\u0010!\u001a\u00020\u0011H\u0014J\u0010\u0010#\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u0006H\u0014J\u0012\u0010&\u001a\u00020\f2\b\u0010%\u001a\u0004\u0018\u00010$H\u0014J\b\u0010'\u001a\u00020\fH\u0016J\b\u0010(\u001a\u00020\fH\u0016J\b\u0010)\u001a\u00020\fH\u0016J\n\u0010*\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010,\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u001eH\u0016J \u0010.\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010/\u001a\u00020\fH\u0016J\b\u00100\u001a\u00020\fH\u0016J\u0012\u00103\u001a\u00020\f2\b\u00102\u001a\u0004\u0018\u000101H\u0016J$\u00107\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050504j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000505`6H\u0016R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010A\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010\rR\u0016\u0010B\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\rR\u0016\u0010D\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010C\u00a8\u0006G"}, d2 = {"Lcom/qzone/reborn/feedpro/section/ap;", "Lne/a;", "Lde/f;", "Lcom/tencent/richframework/gallery/anim/RFWTransitionHelper$TransAnimCreator;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/qzone/reborn/feedpro/event/QzoneFeedProDetailFirstRefreshEvent;", "Landroid/view/View;", "view", "", "index", "Lcom/qzone/proxy/feedcomponent/model/f;", "clickedPicture", "", "I", "Landroid/widget/ImageView;", "coverImageView", "J", "", "K", ViewStickEventHelper.IS_SHOW, "M", "Ljava/util/UUID;", "uuid", "i", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMedia;", "commonMedia", "Lcom/tencent/richframework/gallery/anim/RFWTransAnimBean;", "H", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProMixBaseWidgetView;", "N", "", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "containerView", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", HippyTKDListViewAdapter.X, "play", "pause", "a", "d", "id", "generateTransAnimBean", "picId", "updateOriginContainer", "w", "y", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProPicMixVideoView;", "E", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProPicMixVideoView;", "mPicMixVideoView", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView;", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProVideoItemWidgetView;", "mSelectedVideoItemView", "G", "mTransCreatorKey", "mSelectedIndex", "Z", "mIsFinishDetailFirstRefresh", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ap extends ne.a implements de.f, RFWTransitionHelper.TransAnimCreator, SimpleEventReceiver<QzoneFeedProDetailFirstRefreshEvent> {

    /* renamed from: E, reason: from kotlin metadata */
    private QzoneFeedProPicMixVideoView mPicMixVideoView;

    /* renamed from: F, reason: from kotlin metadata */
    private QzoneFeedProVideoItemWidgetView mSelectedVideoItemView;

    /* renamed from: G, reason: from kotlin metadata */
    private int mTransCreatorKey;

    /* renamed from: H, reason: from kotlin metadata */
    private int mSelectedIndex;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean mIsFinishDetailFirstRefresh;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/qzone/reborn/feedpro/section/ap$b", "Lcom/qzone/reborn/feedpro/widget/picmix/QzoneFeedProPicMixVideoView$b;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMedia;", QAdVrReportParams.ParamKey.MEDIA, "", "index", "Landroid/view/View;", "view", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements QzoneFeedProPicMixVideoView.b {
        b() {
        }

        @Override // com.qzone.reborn.feedpro.widget.picmix.QzoneFeedProPicMixVideoView.b
        public void a(CommonMedia media, int index, View view) {
            boolean z16 = view instanceof QzoneFeedProMixBaseWidgetView;
            if (z16) {
                ap.this.N((QzoneFeedProMixBaseWidgetView) view);
            }
            QLog.i("QzoneFeedProPicMixVideoSection", 1, "index is " + index);
            if (z16 && ((QzoneFeedProMixBaseWidgetView) view).y0()) {
                ap.this.I(view, index, new com.qzone.proxy.feedcomponent.model.f(0, index, true, false));
            } else {
                ap.this.I(view, index, new com.qzone.proxy.feedcomponent.model.f(0, index, false));
            }
        }
    }

    private final RFWTransAnimBean H(UUID uuid, int i3, CommonMedia commonMedia) {
        ImageView mImageView;
        QzoneFeedProPicMixVideoView qzoneFeedProPicMixVideoView = this.mPicMixVideoView;
        if (qzoneFeedProPicMixVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPicMixVideoView");
            qzoneFeedProPicMixVideoView = null;
        }
        RecyclerView A0 = qzoneFeedProPicMixVideoView.A0();
        if (A0 == null || A0.getChildCount() <= i3) {
            return null;
        }
        View childAt = A0.getChildAt(i3);
        QzoneFeedProMixBaseWidgetView qzoneFeedProMixBaseWidgetView = childAt instanceof QzoneFeedProMixBaseWidgetView ? (QzoneFeedProMixBaseWidgetView) childAt : null;
        if (qzoneFeedProMixBaseWidgetView == null || (mImageView = qzoneFeedProMixBaseWidgetView.getMImageView()) == null) {
            return null;
        }
        return RFWLayerLaunchUtil.getTransAnimBean(uuid, mImageView, je.a.x(commonMedia, getMFeedData()), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(View view, int index, com.qzone.proxy.feedcomponent.model.f clickedPicture) {
        ImageView imageView = null;
        QzoneFeedProMixBaseWidgetView qzoneFeedProMixBaseWidgetView = view instanceof QzoneFeedProMixBaseWidgetView ? (QzoneFeedProMixBaseWidgetView) view : null;
        if (qzoneFeedProMixBaseWidgetView != null) {
            ImageView mImageView = qzoneFeedProMixBaseWidgetView.getMImageView();
            if (mImageView != null) {
                mImageView.setTag(R.id.f100755tc, Integer.valueOf(this.mTransCreatorKey));
            }
            imageView = qzoneFeedProMixBaseWidgetView.getMImageView();
        }
        J(clickedPicture, imageView, index);
    }

    private final void J(com.qzone.proxy.feedcomponent.model.f clickedPicture, ImageView coverImageView, int index) {
        ie.b.f407555a.b(getMFeedData(), getMForwardFeedData(), getActivity(), coverImageView, index);
    }

    private final boolean K() {
        if (n() == 10) {
            return false;
        }
        if (com.qzone.reborn.feedx.util.x.f55790a.c(n())) {
            return this.mIsFinishDetailFirstRefresh;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean L(ap this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getAction() == 1 && !com.qzone.reborn.feedx.util.x.f55790a.c(this$0.n())) {
            ho.m f16 = ho.i.f();
            Intrinsics.checkNotNullExpressionValue(f16, "detailPro()");
            Activity activity = this$0.getActivity();
            CommonFeed mFeedData = this$0.getMFeedData();
            QzoneFeedProPicMixVideoView qzoneFeedProPicMixVideoView = this$0.mPicMixVideoView;
            if (qzoneFeedProPicMixVideoView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPicMixVideoView");
                qzoneFeedProPicMixVideoView = null;
            }
            ho.m.c(f16, activity, mFeedData, qzoneFeedProPicMixVideoView, 0, 8, null);
        }
        return false;
    }

    private final void M(boolean isShow) {
        QzoneFeedProVideoItemWidgetView qzoneFeedProVideoItemWidgetView = this.mSelectedVideoItemView;
        if (qzoneFeedProVideoItemWidgetView != null) {
            qzoneFeedProVideoItemWidgetView.g1().setVisibility(isShow ? 0 : 4);
            qzoneFeedProVideoItemWidgetView.setPlayIconVisible(isShow);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(QzoneFeedProMixBaseWidgetView view) {
        this.mSelectedVideoItemView = view instanceof QzoneFeedProVideoItemWidgetView ? (QzoneFeedProVideoItemWidgetView) view : null;
    }

    @Override // de.f
    public void a() {
        QzoneFeedProPicMixVideoView qzoneFeedProPicMixVideoView = this.mPicMixVideoView;
        if (qzoneFeedProPicMixVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPicMixVideoView");
            qzoneFeedProPicMixVideoView = null;
        }
        qzoneFeedProPicMixVideoView.a();
    }

    @Override // de.f
    public View d() {
        QzoneFeedProPicMixVideoView qzoneFeedProPicMixVideoView = this.mPicMixVideoView;
        if (qzoneFeedProPicMixVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPicMixVideoView");
            qzoneFeedProPicMixVideoView = null;
        }
        return qzoneFeedProPicMixVideoView.d();
    }

    @Override // com.tencent.richframework.gallery.anim.RFWTransitionHelper.TransAnimCreator
    public RFWTransAnimBean generateTransAnimBean(UUID uuid, String id5) {
        CommonCellMedia cellMedia;
        List<CommonMedia> mediaItems;
        int lastIndex;
        int coerceAtMost;
        int coerceAtLeast;
        int coerceAtMost2;
        int lastIndex2;
        int coerceAtMost3;
        int coerceAtLeast2;
        int lastIndex3;
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(id5, "id");
        CommonFeed mFeedData = getMFeedData();
        if (mFeedData == null || (cellMedia = mFeedData.getCellMedia()) == null || (mediaItems = cellMedia.getMediaItems()) == null || ArrayUtils.isOutOfArrayIndex(0, mediaItems)) {
            return null;
        }
        if (com.qzone.reborn.feedx.util.x.f55790a.c(n())) {
            coerceAtMost = CollectionsKt__CollectionsKt.getLastIndex(mediaItems);
        } else {
            lastIndex = CollectionsKt__CollectionsKt.getLastIndex(mediaItems);
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(lastIndex, 8);
        }
        if (coerceAtMost >= 0) {
            int i3 = 0;
            while (true) {
                CommonMedia commonMedia = mediaItems.get(i3);
                if (!TextUtils.equals(je.a.C(commonMedia), id5)) {
                    if (i3 == coerceAtMost) {
                        break;
                    }
                    i3++;
                } else {
                    this.mSelectedIndex = i3;
                    QLog.i("QzoneFeedProPicMixVideoSection", 1, " generateTransAnimBean data index:" + i3 + " (clamped to " + i3 + ")");
                    return H(uuid, i3, commonMedia);
                }
            }
        }
        if (com.qzone.reborn.feedx.util.x.f55790a.c(n())) {
            coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(this.mSelectedIndex, 0);
            lastIndex3 = CollectionsKt__CollectionsKt.getLastIndex(mediaItems);
            coerceAtMost3 = RangesKt___RangesKt.coerceAtMost(coerceAtLeast2, lastIndex3);
        } else {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(this.mSelectedIndex, 0);
            coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(coerceAtLeast, 8);
            lastIndex2 = CollectionsKt__CollectionsKt.getLastIndex(mediaItems);
            coerceAtMost3 = RangesKt___RangesKt.coerceAtMost(coerceAtMost2, lastIndex2);
        }
        return H(uuid, coerceAtMost3, mediaItems.get(coerceAtMost3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ne.a
    /* renamed from: h */
    public String getTAG() {
        return "QzoneFeedProPicMixVideoSection";
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if ((event instanceof QzoneFeedProDetailFirstRefreshEvent) && ((QzoneFeedProDetailFirstRefreshEvent) event).getSuccess()) {
            this.mIsFinishDetailFirstRefresh = true;
            QzoneFeedProPicMixVideoView qzoneFeedProPicMixVideoView = this.mPicMixVideoView;
            if (qzoneFeedProPicMixVideoView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPicMixVideoView");
                qzoneFeedProPicMixVideoView = null;
            }
            qzoneFeedProPicMixVideoView.setEnableOverLimit(K());
        }
    }

    @Override // de.f
    public void pause() {
        QzoneFeedProPicMixVideoView qzoneFeedProPicMixVideoView = this.mPicMixVideoView;
        if (qzoneFeedProPicMixVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPicMixVideoView");
            qzoneFeedProPicMixVideoView = null;
        }
        qzoneFeedProPicMixVideoView.pause();
    }

    @Override // de.f
    public void play() {
        QzoneFeedProPicMixVideoView qzoneFeedProPicMixVideoView = this.mPicMixVideoView;
        if (qzoneFeedProPicMixVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPicMixVideoView");
            qzoneFeedProPicMixVideoView = null;
        }
        qzoneFeedProPicMixVideoView.play();
    }

    @Override // ne.a
    protected int q() {
        return R.id.no6;
    }

    @Override // ne.a
    protected boolean u() {
        return true;
    }

    @Override // com.tencent.richframework.gallery.anim.RFWTransitionHelper.TransAnimCreator
    public void updateOriginContainer(UUID uuid, String picId, boolean isShow) {
        CommonCellMedia cellMedia;
        List<CommonMedia> mediaItems;
        int coerceAtMost;
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(picId, "picId");
        if (TextUtils.isEmpty(picId)) {
            M(isShow);
            return;
        }
        CommonFeed mFeedData = getMFeedData();
        if (mFeedData == null || (cellMedia = mFeedData.getCellMedia()) == null || (mediaItems = cellMedia.getMediaItems()) == null) {
            return;
        }
        M(isShow);
        int i3 = 0;
        for (Object obj : mediaItems) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (TextUtils.equals(je.a.C((CommonMedia) obj), picId)) {
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(i3, 8);
                QLog.i("QzoneFeedProPicMixVideoSection", 1, "data index:" + coerceAtMost);
                QzoneFeedProPicMixVideoView qzoneFeedProPicMixVideoView = this.mPicMixVideoView;
                if (qzoneFeedProPicMixVideoView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPicMixVideoView");
                    qzoneFeedProPicMixVideoView = null;
                }
                RecyclerView A0 = qzoneFeedProPicMixVideoView.A0();
                if (A0 == null || A0.getChildCount() <= coerceAtMost) {
                    return;
                }
                View childAt = A0.getChildAt(coerceAtMost);
                QzoneFeedProMixBaseWidgetView qzoneFeedProMixBaseWidgetView = childAt instanceof QzoneFeedProMixBaseWidgetView ? (QzoneFeedProMixBaseWidgetView) childAt : null;
                if (qzoneFeedProMixBaseWidgetView != null) {
                    N(qzoneFeedProMixBaseWidgetView);
                }
            }
            i3 = i16;
        }
    }

    @Override // ne.a
    public void w() {
        super.w();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // ne.a
    protected void x(CommonFeed feedData) {
        QzoneFeedProPicMixVideoView qzoneFeedProPicMixVideoView = this.mPicMixVideoView;
        if (qzoneFeedProPicMixVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPicMixVideoView");
            qzoneFeedProPicMixVideoView = null;
        }
        qzoneFeedProPicMixVideoView.setData(feedData, getMPosition());
    }

    @Override // ne.a
    public void y() {
        super.y();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // ne.a
    protected void z(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.n9_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026qzone_pic_mix_video_view)");
        QzoneFeedProPicMixVideoView qzoneFeedProPicMixVideoView = (QzoneFeedProPicMixVideoView) findViewById;
        this.mPicMixVideoView = qzoneFeedProPicMixVideoView;
        QzoneFeedProPicMixVideoView qzoneFeedProPicMixVideoView2 = null;
        if (qzoneFeedProPicMixVideoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPicMixVideoView");
            qzoneFeedProPicMixVideoView = null;
        }
        qzoneFeedProPicMixVideoView.setEnableOverLimit(K());
        this.mTransCreatorKey = RFWTransitionHelper.INSTANCE.registerTransitionBeanCreator(this);
        QzoneFeedProPicMixVideoView qzoneFeedProPicMixVideoView3 = this.mPicMixVideoView;
        if (qzoneFeedProPicMixVideoView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPicMixVideoView");
            qzoneFeedProPicMixVideoView3 = null;
        }
        qzoneFeedProPicMixVideoView3.setOnItemClickListener(new b());
        QzoneFeedProPicMixVideoView qzoneFeedProPicMixVideoView4 = this.mPicMixVideoView;
        if (qzoneFeedProPicMixVideoView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPicMixVideoView");
        } else {
            qzoneFeedProPicMixVideoView2 = qzoneFeedProPicMixVideoView4;
        }
        qzoneFeedProPicMixVideoView2.setOnEmptyTouchListener(new View.OnTouchListener() { // from class: com.qzone.reborn.feedpro.section.ao
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean L;
                L = ap.L(ap.this, view, motionEvent);
                return L;
            }
        });
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<QzoneFeedProDetailFirstRefreshEvent>> getEventClass() {
        ArrayList<Class<QzoneFeedProDetailFirstRefreshEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QzoneFeedProDetailFirstRefreshEvent.class);
        return arrayListOf;
    }
}
