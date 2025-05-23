package com.tencent.mobileqq.activity.aio.intimate.reborn.section;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.intimate.e;
import com.tencent.mobileqq.activity.aio.intimate.header.IntimateHeaderCardUtil;
import com.tencent.mobileqq.activity.aio.intimate.header.l;
import com.tencent.mobileqq.activity.aio.intimate.reborn.section.IntimateUnbindCircleSection;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.intimate.CircleLayout;
import com.tencent.mobileqq.mutualmark.g;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import f61.j;
import j61.IntimateBaseModel;
import java.util.ArrayList;
import java.util.List;
import k61.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bD\u0010EJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u001e\u0010\r\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014J*\u0010\u0017\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u00022\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0014J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016R\u0016\u0010\u001d\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010&\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R$\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u001e0'j\b\u0012\u0004\u0012\u00020\u001e`(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001e\u00101\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R$\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u001e0'j\b\u0012\u0004\u0012\u00020\u001e`(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010)R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010?\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00106R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/reborn/section/IntimateUnbindCircleSection;", "Lk61/d;", "", "index", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "v", "w", "", "Lf61/j;", "dataList", "Lcom/tencent/mobileqq/intimate/CircleLayout;", TtmlNode.TAG_LAYOUT, "t", "Landroid/view/View;", "containerView", "onInitView", "Lj61/a;", "data", "position", "", "", "payload", "y", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "e", "Lcom/tencent/mobileqq/intimate/CircleLayout;", "mCircleLayout", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "mCenterImageView", h.F, "mElectricWaveCenterView", "i", "Landroid/view/View;", "mViewNightCover", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mImageViewList", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "mFriendUin", "D", "Ljava/util/List;", "mPartnerInfo", "E", "mNewTypeView", "", UserInfo.SEX_FEMALE, "Z", "isInit", "G", "I", "childViewSize", "Landroid/animation/AnimatorSet;", "H", "Landroid/animation/AnimatorSet;", "mAnimatorSet", "mIsDrawerOpen", "Ljava/lang/Runnable;", "J", "Ljava/lang/Runnable;", "mAniRunnable", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class IntimateUnbindCircleSection extends d {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private List<j> mPartnerInfo;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isInit;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private AnimatorSet mAnimatorSet;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean mIsDrawerOpen;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private CircleLayout mCircleLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView mCenterImageView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView mElectricWaveCenterView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View mViewNightCover;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<ImageView> mImageViewList = new ArrayList<>();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String mFriendUin = "";

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<ImageView> mNewTypeView = new ArrayList<>();

    /* renamed from: G, reason: from kotlin metadata */
    private int childViewSize = ViewUtils.dpToPx(60.0f);

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Runnable mAniRunnable = new Runnable() { // from class: k61.s
        @Override // java.lang.Runnable
        public final void run() {
            IntimateUnbindCircleSection.x(IntimateUnbindCircleSection.this);
        }
    };

    private final void t(final List<j> dataList, CircleLayout layout) {
        int size = dataList.size();
        for (final int i3 = 0; i3 < size; i3++) {
            CircleLayout circleLayout = this.mCircleLayout;
            CircleLayout circleLayout2 = null;
            if (circleLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCircleLayout");
                circleLayout = null;
            }
            ImageView imageView = new ImageView(circleLayout.getContext());
            imageView.setTag(dataList.get(i3));
            CircleLayout circleLayout3 = this.mCircleLayout;
            if (circleLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCircleLayout");
                circleLayout3 = null;
            }
            Resources resources = circleLayout3.getResources();
            CircleLayout circleLayout4 = this.mCircleLayout;
            if (circleLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCircleLayout");
            } else {
                circleLayout2 = circleLayout4;
            }
            imageView.setBackground(ResourcesCompat.getDrawable(resources, R.drawable.qui_common_fill_light_secondary_bg_oval, circleLayout2.getContext().getTheme()));
            AccessibilityUtil.p(imageView, dataList.get(i3).getName());
            String urlV2 = g.r(dataList.get(i3).getIconUrl());
            Intrinsics.checkNotNullExpressionValue(urlV2, "urlV2");
            IntimateHeaderCardUtil.X(imageView, urlV2, new ColorDrawable(0));
            int dpToPx = ViewUtils.dpToPx(44.0f);
            int dpToPx2 = ViewUtils.dpToPx(10.0f);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(dpToPx, dpToPx));
            imageView.setPadding(dpToPx2, dpToPx2, dpToPx2, dpToPx2);
            imageView.setElevation(10.0f);
            layout.addView(imageView);
            if (FontSettingManager.getFontLevel() > 17.0f) {
                FontSettingManager.resetViewSize2Normal(this.mRootView.getContext(), imageView);
            }
            this.mImageViewList.add(imageView);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: k61.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IntimateUnbindCircleSection.u(IntimateUnbindCircleSection.this, dataList, i3, view);
                }
            });
            if (dataList.get(i3).getIsNew()) {
                this.mNewTypeView.add(imageView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(IntimateUnbindCircleSection this$0, List dataList, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dataList, "$dataList");
        e.g(view.getContext(), this$0.mFriendUin, ((j) dataList.get(i3)).getId());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void v() {
        w();
        for (ImageView imageView : this.mImageViewList) {
            if (imageView.getAnimation() != null) {
                imageView.getAnimation().cancel();
            }
            imageView.clearAnimation();
        }
    }

    private final void w() {
        AnimatorSet animatorSet = this.mAnimatorSet;
        if (animatorSet != null) {
            QLog.i("IntimateBaseSection", 1, "clearAnimatorSet, hash=" + animatorSet.hashCode());
            animatorSet.removeAllListeners();
            animatorSet.cancel();
        }
        this.mAnimatorSet = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(IntimateUnbindCircleSection this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.z(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(int index) {
        if (index >= this.mImageViewList.size()) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(this.mAniRunnable, 2000L);
            return;
        }
        if (!this.mIsDrawerOpen) {
            return;
        }
        ImageView imageView = this.mImageViewList.get(index);
        Intrinsics.checkNotNullExpressionValue(imageView, "mImageViewList[index]");
        ImageView imageView2 = imageView;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView2, BasicAnimation.KeyPath.SCALE_X, 1.0f, 1.15f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView2, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 1.15f);
        ofFloat.setDuration(300L);
        ofFloat2.setDuration(300L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView2, BasicAnimation.KeyPath.SCALE_X, 1.15f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView2, BasicAnimation.KeyPath.SCALE_Y, 1.15f, 1.0f);
        ofFloat3.setStartDelay(1000L);
        ofFloat4.setStartDelay(1000L);
        ofFloat3.setDuration(300L);
        ofFloat4.setDuration(300L);
        w();
        AnimatorSet animatorSet = new AnimatorSet();
        this.mAnimatorSet = animatorSet;
        QLog.i("IntimateBaseSection", 1, "new AnimatorSet, hash=" + Integer.valueOf(animatorSet.hashCode()));
        AnimatorSet animatorSet2 = this.mAnimatorSet;
        if (animatorSet2 != null) {
            animatorSet2.play(ofFloat).with(ofFloat2).before(ofFloat3).before(ofFloat4);
            animatorSet2.addListener(new a(index));
            animatorSet2.start();
        }
    }

    @Override // k61.d, h61.a
    public void k() {
        super.k();
        this.mIsDrawerOpen = true;
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.mAniRunnable);
        v();
        ThreadManagerV2.getUIHandlerV2().post(this.mAniRunnable);
    }

    @Override // k61.d, h61.a
    public void m() {
        super.m();
        this.mIsDrawerOpen = false;
        v();
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.mAniRunnable);
    }

    @Override // k61.d, com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        QLog.i("IntimateBaseSection", 1, "onDestroy, hash=" + hashCode());
        v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        if (containerView == null) {
            return;
        }
        View findViewById = containerView.findViewById(R.id.f165837xr2);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026mate_unbind_circlelayout)");
        CircleLayout circleLayout = (CircleLayout) findViewById;
        this.mCircleLayout = circleLayout;
        CircleLayout circleLayout2 = null;
        if (circleLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCircleLayout");
            circleLayout = null;
        }
        circleLayout.setMRadius(ViewUtils.dpToPx(110.0f));
        CircleLayout circleLayout3 = this.mCircleLayout;
        if (circleLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCircleLayout");
            circleLayout3 = null;
        }
        circleLayout3.setClipChildren(false);
        CircleLayout circleLayout4 = this.mCircleLayout;
        if (circleLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCircleLayout");
            circleLayout4 = null;
        }
        circleLayout4.setChildViewSize(this.childViewSize);
        View findViewById2 = containerView.findViewById(R.id.f165836xr1);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026_unbind_center_icon_view)");
        this.mCenterImageView = (ImageView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.f165839xr4);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026ind_electric_wave_center)");
        this.mElectricWaveCenterView = (ImageView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.xr7);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026imate_unbind_night_cover)");
        this.mViewNightCover = findViewById4;
        if (QQTheme.isNowThemeIsNight()) {
            View view = this.mViewNightCover;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewNightCover");
                view = null;
            }
            view.setVisibility(0);
            View view2 = this.mViewNightCover;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewNightCover");
                view2 = null;
            }
            IntimateHeaderCardUtil intimateHeaderCardUtil = IntimateHeaderCardUtil.f178990a;
            view2.setBackground(intimateHeaderCardUtil.w(intimateHeaderCardUtil.i()));
        }
        if (FontSettingManager.getFontLevel() > 17.0f) {
            CircleLayout circleLayout5 = this.mCircleLayout;
            if (circleLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCircleLayout");
            } else {
                circleLayout2 = circleLayout5;
            }
            circleLayout2.setMRadius((int) FontSettingManager.revertSize2Normal(this.mRootView.getContext(), ViewUtils.dpToPx(100.0f)));
            FontSettingManager.resetViewSize2Normal(this.mRootView.getContext(), this.mRootView);
        }
        this.isInit = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable IntimateBaseModel data, int position, @Nullable List<Object> payload) {
        List<j> list;
        final j jVar;
        int i3;
        int i16;
        int i17;
        if (data == null) {
            return;
        }
        this.mFriendUin = data.getFriendUin();
        f61.h hVar = data.getIntimateInfo().mutualMarkList;
        if (hVar != null) {
            list = hVar.f397927h;
        } else {
            list = null;
        }
        this.mPartnerInfo = list;
        CircleLayout circleLayout = this.mCircleLayout;
        if (circleLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCircleLayout");
            circleLayout = null;
        }
        circleLayout.removeAllViews();
        this.mImageViewList.clear();
        this.mNewTypeView.clear();
        List<j> list2 = this.mPartnerInfo;
        if (list2 != null) {
            if (list2.isEmpty()) {
                return;
            }
            if (list2.size() > 7) {
                list2 = list2.subList(0, 7);
            }
            int size = list2.size();
            ImageView imageView = this.mCenterImageView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterImageView");
                imageView = null;
            }
            int i18 = 8;
            if (size == 1) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageView.setVisibility(i3);
            ImageView imageView2 = this.mElectricWaveCenterView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mElectricWaveCenterView");
                imageView2 = null;
            }
            if (size == 1) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            imageView2.setVisibility(i16);
            CircleLayout circleLayout2 = this.mCircleLayout;
            if (circleLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCircleLayout");
                circleLayout2 = null;
            }
            if (size > 1) {
                i17 = 0;
            } else {
                i17 = 8;
            }
            circleLayout2.setVisibility(i17);
            ImageView imageView3 = this.mElectricWaveCenterView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mElectricWaveCenterView");
                imageView3 = null;
            }
            if (size == 1) {
                i18 = 0;
            }
            imageView3.setVisibility(i18);
            if (size == 1) {
                String urlV2 = g.r(list2.get(0).getIconUrl());
                ImageView imageView4 = this.mCenterImageView;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCenterImageView");
                    imageView4 = null;
                }
                Intrinsics.checkNotNullExpressionValue(urlV2, "urlV2");
                IntimateHeaderCardUtil.X(imageView4, urlV2, new ColorDrawable(0));
            } else {
                CircleLayout circleLayout3 = this.mCircleLayout;
                if (circleLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCircleLayout");
                    circleLayout3 = null;
                }
                t(list2, circleLayout3);
            }
        }
        for (final ImageView imageView5 : this.mNewTypeView) {
            Object tag = imageView5.getTag();
            if (tag instanceof j) {
                jVar = (j) tag;
            } else {
                jVar = null;
            }
            if (jVar != null && !l.f179061a.d(jVar.getId())) {
                imageView5.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.intimate.reborn.section.IntimateUnbindCircleSection$onBindData$lambda$2$$inlined$postDelayed$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        QUIDefaultBubbleTip.r(imageView5.getContext()).S(imageView5).k0(0).R(0).m0(4).o0(jVar.getName() + "\u4e0a\u65b0\u5566").s0();
                        QLog.i("IntimateBaseSection", 1, "newTypeDialogShow " + jVar.getId());
                        l.f179061a.l(jVar.getId());
                    }
                }, 1000L);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/activity/aio/intimate/reborn/section/IntimateUnbindCircleSection$a", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a implements Animator.AnimatorListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f179208e;

        a(int i3) {
            this.f179208e = i3;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            if (IntimateUnbindCircleSection.this.mIsDrawerOpen) {
                IntimateUnbindCircleSection.this.z(this.f179208e + 1);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
        }
    }
}
