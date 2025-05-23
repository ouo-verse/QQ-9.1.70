package com.qzone.reborn.intimate.part;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.airbnb.lottie.LottieDrawable;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.reborn.intimate.bean.QZoneIntimateSpaceBean;
import com.qzone.reborn.intimate.part.QZIntimateSpaceAvatarAnimPart;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.widget.lottie.LottieLoader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import pj.j;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 A2\u00020\u0001:\u0001BB\u0007\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u001c\u0010\u0019\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00109R\u0016\u0010>\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00109\u00a8\u0006C"}, d2 = {"Lcom/qzone/reborn/intimate/part/QZIntimateSpaceAvatarAnimPart;", "Lcom/qzone/reborn/base/k;", "", "initViewModel", "Lcom/qzone/reborn/intimate/bean/QZoneIntimateSpaceBean;", "spaceBean", "", "N9", "M9", "P9", "checkInAnimUrl", "Y9", "V9", "U9", "T9", "R9", "W9", "S9", "Q9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "action", "", "args", "handleBroadcastMessage", "Lnk/at;", "d", "Lnk/at;", "mainTabViewModel", "Lnk/i;", "e", "Lnk/i;", "styleViewModel", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "checkInAnimImg", "Landroid/widget/FrameLayout;", tl.h.F, "Landroid/widget/FrameLayout;", "avatarContainer", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "i", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "ivAvatar1", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "ivAvatar2", "Lcom/airbnb/lottie/LottieDrawable;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/airbnb/lottie/LottieDrawable;", "checkInLottieDrawable", "Lpj/j;", "D", "Lpj/j;", "checkInResLoadManager", "E", "Ljava/lang/String;", "checkInResUrl", UserInfo.SEX_FEMALE, "checkInLottieResPathSuffix", "G", "checkInImgResPathSuffix", "<init>", "()V", "H", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZIntimateSpaceAvatarAnimPart extends com.qzone.reborn.base.k {

    /* renamed from: C, reason: from kotlin metadata */
    private LottieDrawable checkInLottieDrawable;

    /* renamed from: D, reason: from kotlin metadata */
    private final pj.j checkInResLoadManager = new pj.j();

    /* renamed from: E, reason: from kotlin metadata */
    private String checkInResUrl = "";

    /* renamed from: F, reason: from kotlin metadata */
    private String checkInLottieResPathSuffix = "";

    /* renamed from: G, reason: from kotlin metadata */
    private String checkInImgResPathSuffix = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private nk.at mainTabViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private nk.i styleViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView checkInAnimImg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private FrameLayout avatarContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView ivAvatar1;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView ivAvatar2;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/qzone/reborn/intimate/part/QZIntimateSpaceAvatarAnimPart$e", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class e extends AnimatorListenerAdapter {
        e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);
            ImageView imageView = QZIntimateSpaceAvatarAnimPart.this.checkInAnimImg;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("checkInAnimImg");
                imageView = null;
            }
            imageView.setVisibility(8);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            super.onAnimationStart(animation);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/qzone/reborn/intimate/part/QZIntimateSpaceAvatarAnimPart$f", "Lpj/j$a;", "", "onLoadSucceed", HippyQQPagView.EventName.ON_LOAD_ERROR, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class f implements j.a {
        f() {
        }

        @Override // pj.j.a
        public void onLoadError() {
            QLog.d("QZIntimateSpaceAvatarAnimPart", 1, "[startLoadCheckInRes] load error");
        }

        @Override // pj.j.a
        public void onLoadSucceed() {
            QLog.d("QZIntimateSpaceAvatarAnimPart", 1, "[startLoadCheckInRes] load success");
        }
    }

    private final void M9() {
        ImageView imageView = this.checkInAnimImg;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkInAnimImg");
            imageView = null;
        }
        if (imageView.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            ImageView imageView3 = this.checkInAnimImg;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("checkInAnimImg");
                imageView3 = null;
            }
            ViewGroup.LayoutParams layoutParams = imageView3.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
            CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams2).width = pl.a.f426446a.i();
            ((ViewGroup.MarginLayoutParams) layoutParams2).height = (int) (r3.i() * 0.8426667f);
            ImageView imageView4 = this.checkInAnimImg;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("checkInAnimImg");
            } else {
                imageView2 = imageView4;
            }
            imageView2.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String N9(QZoneIntimateSpaceBean spaceBean) {
        int checkInAnimLevel = spaceBean.getCheckInAnimLevel();
        nk.i iVar = this.styleViewModel;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("styleViewModel");
            iVar = null;
        }
        JSONObject checkInSetting = iVar.getCheckInSetting();
        if (checkInSetting == null) {
            QLog.e("QZIntimateSpaceAvatarAnimPart", 1, "checkInSetting is still null");
            return spaceBean.getCheckInAnimUrl();
        }
        try {
            String string = checkInSetting.getJSONObject(String.valueOf(checkInAnimLevel)).getString("anim_url");
            Intrinsics.checkNotNullExpressionValue(string, "{\n            val jsonOb\u2026tring(ANIM_URL)\n        }");
            return string;
        } catch (Exception e16) {
            QLog.e("QZIntimateSpaceAvatarAnimPart", 1, "exception is " + e16);
            return spaceBean.getCheckInAnimUrl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q9() {
        FrameLayout frameLayout = this.avatarContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarContainer");
            frameLayout = null;
        }
        SpringAnimation springAnimation = new SpringAnimation(frameLayout, DynamicAnimation.SCALE_Y);
        springAnimation.setSpring(new SpringForce(1.0f).setStiffness(364.8f).setDampingRatio(0.2f));
        springAnimation.setStartValue(0.8666667f);
        springAnimation.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R9() {
        QLog.i("QZIntimateSpaceAvatarAnimPart", 1, "startAvatarMinifyAnim");
        FrameLayout frameLayout = this.avatarContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarContainer");
            frameLayout = null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(frameLayout, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.8666667f);
        ofFloat.setDuration(83L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat);
        animatorSet.setDuration(83L);
        animatorSet.addListener(new b());
        animatorSet.start();
    }

    private final void V9() {
        U9();
        W9();
    }

    private final void W9() {
        String str = this.checkInResLoadManager.c(this.checkInResUrl) + this.checkInLottieResPathSuffix;
        String str2 = this.checkInResLoadManager.c(this.checkInResUrl) + this.checkInImgResPathSuffix;
        QLog.d("QZIntimateSpaceAvatarAnimPart", 1, "[startCheckInLottieAnim] checkInRes = " + this.checkInResUrl + ", jsonFilePath = " + str + " , imgFilePath = " + str2);
        if (this.checkInResUrl.length() > 0) {
            if (this.checkInLottieResPathSuffix.length() > 0) {
                if (this.checkInImgResPathSuffix.length() > 0) {
                    P9();
                    LottieHelper.d dVar = new LottieHelper.d() { // from class: com.qzone.reborn.intimate.part.aq
                        @Override // com.tencent.mobileqq.onlinestatus.utils.LottieHelper.d
                        public final void onLoad(LottieDrawable lottieDrawable) {
                            QZIntimateSpaceAvatarAnimPart.X9(QZIntimateSpaceAvatarAnimPart.this, lottieDrawable);
                        }
                    };
                    ImageView imageView = this.checkInAnimImg;
                    ImageView imageView2 = null;
                    if (imageView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("checkInAnimImg");
                        imageView = null;
                    }
                    Context context = imageView.getContext();
                    ImageView imageView3 = this.checkInAnimImg;
                    if (imageView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("checkInAnimImg");
                        imageView3 = null;
                    }
                    int width = imageView3.getWidth();
                    ImageView imageView4 = this.checkInAnimImg;
                    if (imageView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("checkInAnimImg");
                    } else {
                        imageView2 = imageView4;
                    }
                    LottieHelper.c(context, str, str2, width, imageView2.getHeight(), dVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(QZIntimateSpaceAvatarAnimPart this$0, LottieDrawable lottieDrawable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LottieDrawable lottieDrawable2 = this$0.checkInLottieDrawable;
        if (lottieDrawable2 != null && lottieDrawable2.isRunning()) {
            lottieDrawable2.stop();
            lottieDrawable2.removeAllAnimatorListeners();
        }
        this$0.checkInLottieDrawable = lottieDrawable;
        if (lottieDrawable != null) {
            ImageView imageView = this$0.checkInAnimImg;
            ImageView imageView2 = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("checkInAnimImg");
                imageView = null;
            }
            imageView.setVisibility(0);
            ImageView imageView3 = this$0.checkInAnimImg;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("checkInAnimImg");
            } else {
                imageView2 = imageView3;
            }
            imageView2.setImageDrawable(lottieDrawable);
            lottieDrawable.addAnimatorListener(new e());
            lottieDrawable.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y9(String checkInAnimUrl) {
        List<String> mutableListOf;
        QLog.d("QZIntimateSpaceAvatarAnimPart", 1, "[startLoadCheckInRes] checkInAnimUrl=" + checkInAnimUrl);
        if (checkInAnimUrl.length() == 0) {
            return;
        }
        this.checkInResUrl = checkInAnimUrl;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(checkInAnimUrl);
        this.checkInResLoadManager.e(mutableListOf, new f());
        String str = File.separator;
        this.checkInLottieResPathSuffix = str + LottieLoader.FILE_DATA_JSON;
        this.checkInImgResPathSuffix = str + "images" + str;
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(nk.i.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZIntimateM\u2026yleViewModel::class.java)");
        this.styleViewModel = (nk.i) viewModel;
        ViewModel viewModel2 = getViewModel(nk.at.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(QZoneIntima\u2026TabViewModel::class.java)");
        nk.at atVar = (nk.at) viewModel2;
        this.mainTabViewModel = atVar;
        if (atVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
            atVar = null;
        }
        MutableLiveData<UIStateData<QZoneIntimateSpaceBean>> U1 = atVar.U1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<QZoneIntimateSpaceBean>, Unit> function1 = new Function1<UIStateData<QZoneIntimateSpaceBean>, Unit>() { // from class: com.qzone.reborn.intimate.part.QZIntimateSpaceAvatarAnimPart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<QZoneIntimateSpaceBean> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:23:0x005e, code lost:
            
                if (android.text.TextUtils.isEmpty(r0.getStyleResourcesString()) != false) goto L23;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(UIStateData<QZoneIntimateSpaceBean> uIStateData) {
                nk.i iVar;
                nk.i iVar2;
                String N9;
                nk.i iVar3;
                int state = uIStateData.getState();
                if (state != 2 && state != 3) {
                    if (state != 4) {
                        return;
                    }
                    QLog.e("QZIntimateSpaceAvatarAnimPart", 1, "handleSpaceInfoRsp error, recode is " + uIStateData.getRetCode());
                    return;
                }
                if (uIStateData.getData() == null) {
                    return;
                }
                iVar = QZIntimateSpaceAvatarAnimPart.this.styleViewModel;
                nk.i iVar4 = null;
                if (iVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("styleViewModel");
                    iVar = null;
                }
                if (iVar.getCheckInSetting() != null) {
                    iVar3 = QZIntimateSpaceAvatarAnimPart.this.styleViewModel;
                    if (iVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("styleViewModel");
                        iVar3 = null;
                    }
                }
                iVar2 = QZIntimateSpaceAvatarAnimPart.this.styleViewModel;
                if (iVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("styleViewModel");
                } else {
                    iVar4 = iVar2;
                }
                iVar4.S1(uIStateData.getData().getSpaceType());
                QZIntimateSpaceAvatarAnimPart qZIntimateSpaceAvatarAnimPart = QZIntimateSpaceAvatarAnimPart.this;
                QZoneIntimateSpaceBean data = uIStateData.getData();
                Intrinsics.checkNotNullExpressionValue(data, "it.data");
                N9 = qZIntimateSpaceAvatarAnimPart.N9(data);
                qZIntimateSpaceAvatarAnimPart.Y9(N9);
            }
        };
        U1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.intimate.part.ar
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZIntimateSpaceAvatarAnimPart.O9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        super.handleBroadcastMessage(action, args);
        if (TextUtils.equals(action, "START_PLAY_CHECK_IN_ANIM")) {
            V9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.n4i);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026imate_check_in_anim_view)");
        this.checkInAnimImg = (ImageView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.n5n);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026e_space_avatar_container)");
        this.avatarContainer = (FrameLayout) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.n5l);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026_intimate_space_avatar_1)");
        this.ivAvatar1 = (QZoneUserAvatarView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.n5m);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026_intimate_space_avatar_2)");
        this.ivAvatar2 = (QZoneUserAvatarView) findViewById4;
        M9();
        initViewModel();
    }

    private final void P9() {
        int[] iArr = new int[2];
        FrameLayout frameLayout = this.avatarContainer;
        ImageView imageView = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarContainer");
            frameLayout = null;
        }
        frameLayout.getLocationOnScreen(iArr);
        ImageView imageView2 = this.checkInAnimImg;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkInAnimImg");
            imageView2 = null;
        }
        ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i3 = iArr[0];
            int i16 = layoutParams.width;
            FrameLayout frameLayout2 = this.avatarContainer;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarContainer");
                frameLayout2 = null;
            }
            marginLayoutParams.leftMargin = i3 - ((i16 - frameLayout2.getWidth()) / 2);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
            int i17 = iArr[1];
            int i18 = layoutParams.height;
            FrameLayout frameLayout3 = this.avatarContainer;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarContainer");
                frameLayout3 = null;
            }
            marginLayoutParams2.topMargin = (i17 - ((i18 - frameLayout3.getHeight()) / 2)) + ef.d.b(10);
        }
        ImageView imageView3 = this.checkInAnimImg;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkInAnimImg");
        } else {
            imageView = imageView3;
        }
        imageView.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S9() {
        float dip2px = ViewUtils.dip2px(3.0f);
        FrameLayout frameLayout = this.avatarContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarContainer");
            frameLayout = null;
        }
        SpringAnimation springAnimation = new SpringAnimation(frameLayout, DynamicAnimation.TRANSLATION_Y);
        springAnimation.setSpring(new SpringForce(0.0f).setStiffness(364.8f).setDampingRatio(0.2f));
        springAnimation.setStartValue(dip2px);
        springAnimation.setMaxValue(ef.d.b(20));
        springAnimation.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T9() {
        float dip2px = ViewUtils.dip2px(3.0f) * 2;
        FrameLayout frameLayout = this.avatarContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarContainer");
            frameLayout = null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(frameLayout, "translationY", 0.0f, dip2px);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat);
        animatorSet.setDuration(150L);
        animatorSet.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.34f, 0.99f));
        animatorSet.addListener(new c());
        animatorSet.start();
    }

    private final void U9() {
        float dip2px = ViewUtils.dip2px(3.0f);
        FrameLayout frameLayout = this.avatarContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarContainer");
            frameLayout = null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(frameLayout, "translationY", 0.0f, -dip2px);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat);
        animatorSet.setDuration(167L);
        animatorSet.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.34f, 0.99f));
        animatorSet.addListener(new d());
        animatorSet.start();
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/qzone/reborn/intimate/part/QZIntimateSpaceAvatarAnimPart$b", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            QZIntimateSpaceAvatarAnimPart.this.Q9();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/qzone/reborn/intimate/part/QZIntimateSpaceAvatarAnimPart$c", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            QZIntimateSpaceAvatarAnimPart.this.S9();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            QZIntimateSpaceAvatarAnimPart.this.R9();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/qzone/reborn/intimate/part/QZIntimateSpaceAvatarAnimPart$d", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class d implements Animator.AnimatorListener {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(QZIntimateSpaceAvatarAnimPart this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.T9();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
            final QZIntimateSpaceAvatarAnimPart qZIntimateSpaceAvatarAnimPart = QZIntimateSpaceAvatarAnimPart.this;
            rFWThreadManager.postMainDelay(new Runnable() { // from class: com.qzone.reborn.intimate.part.as
                @Override // java.lang.Runnable
                public final void run() {
                    QZIntimateSpaceAvatarAnimPart.d.b(QZIntimateSpaceAvatarAnimPart.this);
                }
            }, 50L);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }
}
