package com.tencent.biz.qqcircle.immersive.part;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.immersive.adapter.q;
import com.tencent.biz.qqcircle.immersive.events.QFSShowLongPressSharePanelEvent;
import com.tencent.biz.qqcircle.immersive.part.cp;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.event.QCircleSeekAreaEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleSelectTabEvent;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\u0018\u0000 L2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001MB\u0007\u00a2\u0006\u0004\bJ\u0010KJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0002J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u001a\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J$\u0010$\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\"0!j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\"`#H\u0016J\b\u0010%\u001a\u00020\u0014H\u0016J\b\u0010&\u001a\u00020\u0010H\u0014J\u0010\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020'H\u0016J\u0010\u0010+\u001a\u00020\u00072\u0006\u0010*\u001a\u00020'H\u0016R\u0016\u0010.\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020\u000e0C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010H\u00a8\u0006N"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/cp;", "Lcom/tencent/biz/qqcircle/bizparts/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/biz/qqcircle/immersive/events/QFSShowLongPressSharePanelEvent;", "event", "", "N9", "L9", "K9", "Lcom/tencent/mobileqq/qcircle/api/event/QCircleSeekAreaEvent;", "M9", "O9", "Lcom/tencent/mobileqq/data/RecentUser;", "data", "", com.tencent.luggage.wxa.c8.c.G, "J9", "I9", "", "show", "Landroid/animation/AnimatorSet;", "F9", "H9", "G9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "onBackEvent", "getInitRelyViewStubId", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "v", NodeProps.ON_CLICK, "d", "Landroid/view/View;", "mContainer", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mAnchor", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "Lcom/tencent/biz/qqcircle/immersive/adapter/q;", tl.h.F, "Lcom/tencent/biz/qqcircle/immersive/adapter/q;", "mAdapter", "Le30/b;", "i", "Le30/b;", "mFeedBlockData", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "mPageId", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "mRecentUserList", "D", "Z", ViewStickEventHelper.IS_SHOW, "<init>", "()V", "E", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class cp extends com.tencent.biz.qqcircle.bizparts.b implements SimpleEventReceiver<SimpleBaseEvent>, View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private List<RecentUser> mRecentUserList;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isShow;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View mContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView mAnchor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RecyclerView mRecyclerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.biz.qqcircle.immersive.adapter.q mAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private e30.b mFeedBlockData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String mPageId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/qqcircle/immersive/part/cp$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            ImageView imageView = cp.this.mAnchor;
            e30.b bVar = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAnchor");
                imageView = null;
            }
            com.tencent.biz.qqcircle.utils.ce.e(false, imageView.getParent());
            cp.this.isShow = false;
            View view = cp.this.mContainer;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                view = null;
            }
            view.setVisibility(8);
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            e30.b bVar2 = cp.this.mFeedBlockData;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFeedBlockData");
            } else {
                bVar = bVar2;
            }
            simpleEventBus.dispatchEvent(new QCirclePanelStateEvent(38, com.tencent.biz.qqcircle.utils.bj.g(com.tencent.biz.qqcircle.utils.bj.f(bVar)), false));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/part/cp$c", "Lcom/tencent/biz/qqcircle/immersive/adapter/q$a;", "Lcom/tencent/mobileqq/data/RecentUser;", "data", "", com.tencent.luggage.wxa.c8.c.G, "", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c implements q.a {
        c() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.adapter.q.a
        public void a(@NotNull RecentUser data, int pos) {
            Intrinsics.checkNotNullParameter(data, "data");
            cp.this.J9(data, pos);
            cp.this.G9(data);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/qqcircle/immersive/part/cp$d", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class d extends AnimatorListenerAdapter {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(cp this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.K9();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            Handler mainHandler = cp.this.getMainHandler();
            final cp cpVar = cp.this;
            mainHandler.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.cq
                @Override // java.lang.Runnable
                public final void run() {
                    cp.d.b(cp.this);
                }
            }, 3000L);
        }
    }

    private final AnimatorSet F9(boolean show) {
        float f16;
        int i3;
        RecyclerView recyclerView = this.mRecyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        float[] fArr = new float[2];
        float f17 = 0.0f;
        if (show) {
            f16 = 0.0f;
        } else {
            f16 = 1.0f;
        }
        fArr[0] = f16;
        if (show) {
            f17 = 1.0f;
        }
        fArr[1] = f17;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(recyclerView, com.tencent.luggage.wxa.c8.c.f123400v, fArr);
        int dpToPx = ImmersiveUtils.dpToPx(22.0f);
        RecyclerView recyclerView3 = this.mRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        } else {
            recyclerView2 = recyclerView3;
        }
        float[] fArr2 = new float[2];
        if (show) {
            i3 = dpToPx;
        } else {
            i3 = 0;
        }
        fArr2[0] = i3;
        if (show) {
            dpToPx = 0;
        }
        fArr2[1] = dpToPx;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(recyclerView2, "translationX", fArr2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G9(RecentUser data) {
        String str;
        Map<String, Object> map = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        map.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_QUICK_SHARE_GUIDE_PANEL);
        String str2 = this.mPageId;
        e30.b bVar = null;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPageId");
            str2 = null;
        }
        map.put("xsj_custom_pgid", str2);
        e30.b bVar2 = this.mFeedBlockData;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedBlockData");
            bVar2 = null;
        }
        map.put("xsj_feed_id", bVar2.g().f398449id.get());
        e30.b bVar3 = this.mFeedBlockData;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedBlockData");
        } else {
            bVar = bVar3;
        }
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, bVar.g().poster.f398463id.get());
        map.put("xsj_target_qq", data.uin);
        if (data.type == 1) {
            str = "2";
        } else {
            str = "1";
        }
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_SHARE_TARGET_TYPE, str);
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_SCENE, QCircleDaTongConstant.ElementParamValue.SHARE_BUBBLE);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", map);
    }

    private final void H9() {
        View view = this.mContainer;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            view = null;
        }
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_QUICK_SHARE_GUIDE_PANEL);
        View view3 = this.mContainer;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            view3 = null;
        }
        VideoReport.setElementExposePolicy(view3, ExposurePolicy.REPORT_ALL);
        View view4 = this.mContainer;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            view4 = null;
        }
        VideoReport.setElementEndExposePolicy(view4, EndExposurePolicy.REPORT_ALL);
        Map<String, Object> map = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        e30.b bVar = this.mFeedBlockData;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedBlockData");
            bVar = null;
        }
        map.put("xsj_feed_id", bVar.g().f398449id.get());
        e30.b bVar2 = this.mFeedBlockData;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedBlockData");
            bVar2 = null;
        }
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, bVar2.g().poster.f398463id.get());
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_SCENE, QCircleDaTongConstant.ElementParamValue.SHARE_BUBBLE);
        View view5 = this.mContainer;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            view5 = null;
        }
        VideoReport.setElementParams(view5, map);
        View view6 = this.mContainer;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
        } else {
            view2 = view6;
        }
        VideoReport.traversePage(view2);
    }

    private final void I9(RecentUser data) {
        e30.b bVar = this.mFeedBlockData;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedBlockData");
            bVar = null;
        }
        QCircleShareInfo c16 = com.tencent.biz.qqcircle.immersive.utils.au.c(bVar.g());
        c16.silentShareType = 2;
        c16.mShareUin = data.uin;
        c16.mShareUinType = data.type;
        c16.mShareUinName = data.displayName;
        c16.mNeedShowShareDialog = false;
        broadcastMessage("share_action_silent_share", c16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9(RecentUser data, int pos) {
        K9();
        I9(data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9() {
        if (!this.isShow) {
            return;
        }
        AnimatorSet F9 = F9(false);
        F9.addListener(new b());
        F9.start();
    }

    private final void L9() {
        startInit();
        O9();
        H9();
    }

    private final void M9(QCircleSeekAreaEvent event) {
        if (event.getEvent().getAction() == 2) {
            K9();
        }
    }

    private final void N9(QFSShowLongPressSharePanelEvent event) {
        if (event.mHashCode != getContext().hashCode()) {
            return;
        }
        this.mFeedBlockData = event.getFeedBlockData();
        List<RecentUser> recentUserList = event.getRecentUserList();
        this.mRecentUserList = recentUserList.subList(0, Math.min(recentUserList.size(), 4));
        this.mPageId = event.getPageId();
        this.mAnchor = event.getAnchor();
        L9();
    }

    private final void O9() {
        ImageView imageView = this.mAnchor;
        e30.b bVar = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnchor");
            imageView = null;
        }
        com.tencent.biz.qqcircle.utils.ce.e(true, imageView.getParent());
        com.tencent.biz.qqcircle.immersive.adapter.q qVar = this.mAdapter;
        if (qVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            qVar = null;
        }
        e30.b bVar2 = this.mFeedBlockData;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedBlockData");
            bVar2 = null;
        }
        qVar.k0(bVar2);
        com.tencent.biz.qqcircle.immersive.adapter.q qVar2 = this.mAdapter;
        if (qVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            qVar2 = null;
        }
        String str = this.mPageId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPageId");
            str = null;
        }
        qVar2.m0(str);
        com.tencent.biz.qqcircle.immersive.adapter.q qVar3 = this.mAdapter;
        if (qVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            qVar3 = null;
        }
        List<RecentUser> list = this.mRecentUserList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecentUserList");
            list = null;
        }
        qVar3.setDatas(list);
        this.isShow = true;
        View view = this.mContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            view = null;
        }
        view.setVisibility(0);
        int[] iArr = new int[2];
        ImageView imageView2 = this.mAnchor;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnchor");
            imageView2 = null;
        }
        imageView2.getLocationInWindow(iArr);
        QLog.d("QFSLongPressSharePanelPart", 1, "[showPanel] anchorX:" + iArr[0] + " anchorY:" + iArr[1]);
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        ImageView imageView3 = this.mAnchor;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnchor");
            imageView3 = null;
        }
        layoutParams2.rightMargin = imageView3.getWidth() - ImmersiveUtils.dpToPx(5.0f);
        layoutParams2.topMargin = iArr[1] + ImmersiveUtils.dpToPx(14.0f);
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView2 = null;
        }
        recyclerView2.setLayoutParams(layoutParams2);
        AnimatorSet F9 = F9(true);
        F9.addListener(new d());
        F9.start();
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        e30.b bVar3 = this.mFeedBlockData;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFeedBlockData");
        } else {
            bVar = bVar3;
        }
        simpleEventBus.dispatchEvent(new QCirclePanelStateEvent(38, com.tencent.biz.qqcircle.utils.bj.g(com.tencent.biz.qqcircle.utils.bj.f(bVar)), true));
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QFSShowLongPressSharePanelEvent.class, QCircleSelectTabEvent.class, QCircleSeekAreaEvent.class);
        return arrayListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        return R.id.f46561ux;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        QLog.d("QFSLongPressSharePanelPart", 1, "[onBackEvent]");
        if (this.isShow) {
            K9();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (v3.getId() == R.id.f46571uy) {
            K9();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.f46571uy);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026ng_press_share_container)");
        this.mContainer = findViewById;
        View findViewById2 = rootView.findViewById(R.id.i4m);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.recycler_view)");
        this.mRecyclerView = (RecyclerView) findViewById2;
        View view = this.mContainer;
        com.tencent.biz.qqcircle.immersive.adapter.q qVar = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            view = null;
        }
        view.setOnClickListener(this);
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        com.tencent.biz.qqcircle.immersive.adapter.q qVar2 = new com.tencent.biz.qqcircle.immersive.adapter.q();
        this.mAdapter = qVar2;
        qVar2.l0(new c());
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView2 = null;
        }
        com.tencent.biz.qqcircle.immersive.adapter.q qVar3 = this.mAdapter;
        if (qVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        } else {
            qVar = qVar3;
        }
        recyclerView2.setAdapter(qVar);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@NotNull SimpleBaseEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof QFSShowLongPressSharePanelEvent) {
            N9((QFSShowLongPressSharePanelEvent) event);
        } else if (event instanceof QCircleSelectTabEvent) {
            K9();
        } else if (event instanceof QCircleSeekAreaEvent) {
            M9((QCircleSeekAreaEvent) event);
        }
    }
}
