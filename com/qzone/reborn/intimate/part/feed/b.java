package com.qzone.reborn.intimate.part.feed;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.airbnb.lottie.LottieDrawable;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellIntimateSpaceInfo;
import com.qzone.reborn.intimate.event.QZIntimateVipInfoUpdateEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.vas.widget.lottie.LottieLoader;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import pj.j;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 =2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001>B\u0007\u00a2\u0006\u0004\b;\u0010<J!\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\tH\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u001c\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J!\u0010\u0016\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u001c\u0010 \u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010!\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0016\u0010\"\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u001c\u0010%\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010(\u001a\u00020\u000e2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\u0014\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040*0)H\u0016R\u0018\u0010.\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00100R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109\u00a8\u0006?"}, d2 = {"Lcom/qzone/reborn/intimate/part/feed/b;", "Lcom/qzone/reborn/base/k;", "Lgf/c;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/qzone/reborn/intimate/event/QZIntimateVipInfoUpdateEvent;", "", "spaceType", "", "spaceId", "", "K9", "(Ljava/lang/Integer;Ljava/lang/String;)Z", "I9", "isVip", "", "E9", "Landroid/widget/ImageView;", "likeView", "L9", "Lcom/airbnb/lottie/LottieDrawable;", "lottieDrawable", "H9", "F9", "(Ljava/lang/Integer;Ljava/lang/String;)Ljava/lang/String;", "G9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "J9", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "r4", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "d", "Landroid/widget/ImageView;", "mLikeAnimView", "e", "Ljava/lang/String;", "mLottieResPathSuffix", "f", "mImgResPathSuffix", "Lpj/j;", tl.h.F, "Lpj/j;", "mResLoadManager", "i", "Lcom/airbnb/lottie/LottieDrawable;", "mLottieDrawable", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class b extends com.qzone.reborn.base.k implements gf.c, SimpleEventReceiver<QZIntimateVipInfoUpdateEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView mLikeAnimView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String mLottieResPathSuffix;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String mImgResPathSuffix;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final pj.j mResLoadManager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private LottieDrawable mLottieDrawable;
    private static final int C = ef.d.b(70);
    private static final int D = ef.d.b(100);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/qzone/reborn/intimate/part/feed/b$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.intimate.part.feed.b$b, reason: collision with other inner class name */
    /* loaded from: classes37.dex */
    public static final class C0480b extends AnimatorListenerAdapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ImageView f57524e;

        C0480b(ImageView imageView) {
            this.f57524e = imageView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);
            QLog.d(b.this.getTAG(), 1, "[startLottie] anim end");
            ImageView imageView = b.this.mLikeAnimView;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = this.f57524e;
            if (imageView2 == null) {
                return;
            }
            imageView2.setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            super.onAnimationStart(animation);
            QLog.d(b.this.getTAG(), 1, "[startLottie] anim start");
            ImageView imageView = this.f57524e;
            if (imageView == null) {
                return;
            }
            imageView.setVisibility(8);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/qzone/reborn/intimate/part/feed/b$c", "Lpj/j$a;", "", "onLoadSucceed", HippyQQPagView.EventName.ON_LOAD_ERROR, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements j.a {
        c() {
        }

        @Override // pj.j.a
        public void onLoadError() {
            QLog.d(b.this.getTAG(), 1, "[preloadLikeAnimRes] load error");
        }

        @Override // pj.j.a
        public void onLoadSucceed() {
            QLog.d(b.this.getTAG(), 1, "[preloadLikeAnimRes] load success");
        }
    }

    public b() {
        String str = File.separator;
        this.mLottieResPathSuffix = str + LottieLoader.FILE_DATA_JSON;
        this.mImgResPathSuffix = str + "images" + str;
        this.mResLoadManager = new pj.j();
    }

    private final void E9(boolean isVip) {
        int i3;
        if (getActivity() == null || this.mLikeAnimView != null) {
            return;
        }
        this.mLikeAnimView = new ImageView(getActivity());
        if (isVip) {
            i3 = D;
        } else {
            i3 = C;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i3);
        layoutParams.gravity = 48;
        ((FrameLayout) getActivity().findViewById(R.id.content)).addView(this.mLikeAnimView, layoutParams);
    }

    private final String F9(Integer spaceType, String spaceId) {
        if (spaceType == null) {
            return "https://qzonestyle.gtimg.cn/qzone/client/intimate_space/feed-like/lover/Lottie.zip";
        }
        if (I9(spaceId)) {
            return G9(spaceId);
        }
        mk.d dVar = mk.d.f416875a;
        if (dVar.y(spaceType)) {
            return "https://qzonestyle.gtimg.cn/qzone/client/intimate_space/feed-like/lover/Lottie.zip";
        }
        if (dVar.w(spaceType)) {
            return "https://qzonestyle.gtimg.cn/qzone/client/intimate_space/feed-like/brother/Lottie.zip";
        }
        if (dVar.H(spaceType)) {
            return "https://qzonestyle.gtimg.cn/qzone/client/intimate_space/feed-like/sister/Lottie.zip";
        }
        if (!dVar.t(spaceType)) {
            return "https://qzonestyle.gtimg.cn/qzone/client/intimate_space/feed-like/lover/Lottie.zip";
        }
        return "https://qzonestyle.gtimg.cn/qzone/client/intimate_space/feed-like/homie/Lottie.zip";
    }

    private final String G9(String spaceId) {
        return bk.a.f28490a.d(spaceId);
    }

    private final boolean I9(String spaceId) {
        return bk.a.f28490a.c(spaceId);
    }

    private final boolean K9(Integer spaceType, String spaceId) {
        return mk.d.f416875a.F(spaceType) && !I9(spaceId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(b this$0, ImageView imageView, LottieDrawable lottieDrawable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.H9(lottieDrawable, imageView);
    }

    public final void J9(int spaceType, String spaceId) {
        List<String> mutableListOf;
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        if (K9(Integer.valueOf(spaceType), spaceId)) {
            return;
        }
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(F9(Integer.valueOf(spaceType), spaceId));
        this.mResLoadManager.e(mutableListOf, new c());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        registerIoc(this, gf.c.class);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QZIntimateVipInfoUpdateEvent) {
            QZIntimateVipInfoUpdateEvent qZIntimateVipInfoUpdateEvent = (QZIntimateVipInfoUpdateEvent) event;
            J9(qZIntimateVipInfoUpdateEvent.getBean().getSpaceType(), qZIntimateVipInfoUpdateEvent.getBean().getSpaceId());
        }
    }

    private final void L9(ImageView likeView) {
        int[] iArr = new int[2];
        likeView.getLocationOnScreen(iArr);
        ImageView imageView = this.mLikeAnimView;
        ViewGroup.LayoutParams layoutParams = imageView != null ? imageView.getLayoutParams() : null;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = iArr[0] - ((((ViewGroup.LayoutParams) marginLayoutParams).width - likeView.getWidth()) / 2);
            marginLayoutParams.topMargin = iArr[1] - ((((ViewGroup.LayoutParams) marginLayoutParams).height - likeView.getHeight()) / 2);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<QZIntimateVipInfoUpdateEvent>> getEventClass() {
        ArrayList<Class<QZIntimateVipInfoUpdateEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QZIntimateVipInfoUpdateEvent.class);
        return arrayListOf;
    }

    private final void H9(LottieDrawable lottieDrawable, ImageView likeView) {
        if (lottieDrawable == null) {
            QLog.d(getTAG(), 1, "handleLottieDrawable fail: drawable is null");
            return;
        }
        LottieDrawable lottieDrawable2 = this.mLottieDrawable;
        if (lottieDrawable2 != null && lottieDrawable2.isRunning()) {
            lottieDrawable2.stop();
            lottieDrawable2.removeAllAnimatorListeners();
        }
        this.mLottieDrawable = lottieDrawable;
        ImageView imageView = this.mLikeAnimView;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        ImageView imageView2 = this.mLikeAnimView;
        if (imageView2 != null) {
            imageView2.setImageDrawable(lottieDrawable);
        }
        lottieDrawable.addAnimatorListener(new C0480b(likeView));
        lottieDrawable.start();
    }

    @Override // gf.c
    public void r4(final ImageView likeView, BusinessFeedData feedData) {
        if (likeView != null && feedData != null) {
            CellIntimateSpaceInfo cellIntimateSpaceInfo = feedData.cellIntimateSpaceInfo;
            Integer valueOf = Integer.valueOf(cellIntimateSpaceInfo != null ? cellIntimateSpaceInfo.spaceType : 0);
            CellIntimateSpaceInfo cellIntimateSpaceInfo2 = feedData.cellIntimateSpaceInfo;
            String str = cellIntimateSpaceInfo2 != null ? cellIntimateSpaceInfo2.spaceId : null;
            if (str == null) {
                str = "";
            }
            if (K9(valueOf, str)) {
                return;
            }
            CellIntimateSpaceInfo cellIntimateSpaceInfo3 = feedData.cellIntimateSpaceInfo;
            Integer valueOf2 = cellIntimateSpaceInfo3 != null ? Integer.valueOf(cellIntimateSpaceInfo3.spaceType) : null;
            CellIntimateSpaceInfo cellIntimateSpaceInfo4 = feedData.cellIntimateSpaceInfo;
            String str2 = cellIntimateSpaceInfo4 != null ? cellIntimateSpaceInfo4.spaceId : null;
            if (str2 == null) {
                str2 = "";
            }
            String F9 = F9(valueOf2, str2);
            String str3 = this.mResLoadManager.c(F9) + this.mLottieResPathSuffix;
            String str4 = this.mResLoadManager.c(F9) + this.mImgResPathSuffix;
            QLog.d(getTAG(), 1, "[startLikeLottieAnim] animResUrl = " + F9 + ", jsonFilePath = " + str3 + " , imgFilePath = " + str4);
            if (F9.length() > 0) {
                if (this.mLottieResPathSuffix.length() > 0) {
                    if (this.mImgResPathSuffix.length() > 0) {
                        CellIntimateSpaceInfo cellIntimateSpaceInfo5 = feedData.cellIntimateSpaceInfo;
                        String str5 = cellIntimateSpaceInfo5 != null ? cellIntimateSpaceInfo5.spaceId : null;
                        E9(I9(str5 != null ? str5 : ""));
                        L9(likeView);
                        LottieHelper.c(likeView.getContext(), str3, str4, likeView.getWidth(), likeView.getHeight(), new LottieHelper.d() { // from class: com.qzone.reborn.intimate.part.feed.a
                            @Override // com.tencent.mobileqq.onlinestatus.utils.LottieHelper.d
                            public final void onLoad(LottieDrawable lottieDrawable) {
                                b.M9(b.this, likeView, lottieDrawable);
                            }
                        });
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        QLog.d(getTAG(), 1, "showLikeAnim error: " + likeView + ", " + feedData);
    }
}
