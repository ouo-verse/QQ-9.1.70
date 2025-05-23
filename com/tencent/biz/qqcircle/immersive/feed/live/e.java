package com.tencent.biz.qqcircle.immersive.feed.live;

import android.animation.ObjectAnimator;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.immersive.feed.live.e;
import com.tencent.biz.qqcircle.immersive.views.QFSLiveAnimation;
import com.tencent.image.URLDrawable;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.image.ILoaderSucessCallback;
import com.tencent.mobileqq.vas.ui.APNGDrawable;
import com.tencent.qqlive.common.api.IAegisLogApi;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \f2\u00020\u0001:\u0001\u0013B)\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\u0006\u0010\u000e\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u0010\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0002R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\b\u0010\"R\u0016\u0010'\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010&R\u0016\u0010*\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/live/e;", "", "", "k", "l", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "g", "f", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "i", "j", DomainData.DOMAIN_NAME, "o", "r", ReportConstant.COSTREPORT_PREFIX, "Landroid/widget/FrameLayout;", "a", "Landroid/widget/FrameLayout;", "expContainer", "b", "notExpContainer", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "c", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "aegisLog", "Lcom/tencent/mobileqq/utils/abtest/ExpEntityInfo;", "d", "Lcom/tencent/mobileqq/utils/abtest/ExpEntityInfo;", "expEntityInfo", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "expAnimImageView", "expAnimBkgImageView", "Lcom/tencent/biz/qqcircle/immersive/views/QFSLiveAnimation;", "Lcom/tencent/biz/qqcircle/immersive/views/QFSLiveAnimation;", "notExpAnimation", tl.h.F, "Z", "initState", "<init>", "(Landroid/widget/FrameLayout;Landroid/widget/FrameLayout;Lcom/tencent/qqlive/common/api/IAegisLogApi;Lcom/tencent/mobileqq/utils/abtest/ExpEntityInfo;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout expContainer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout notExpContainer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi aegisLog;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ExpEntityInfo expEntityInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView expAnimImageView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView expAnimBkgImageView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private QFSLiveAnimation notExpAnimation;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean initState;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/feed/live/e$b", "Lcom/tencent/mobileqq/qcircle/picload/listener/QCirclePicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends QCirclePicStateListener {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes4.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f86286a;

            static {
                int[] iArr = new int[LoadState.values().length];
                try {
                    iArr[LoadState.STATE_SUCCESS.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                f86286a = iArr;
            }
        }

        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(LoadState state, e this$0) {
            Intrinsics.checkNotNullParameter(state, "$state");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (a.f86286a[state.ordinal()] == 1) {
                this$0.f();
                return;
            }
            ImageView imageView = this$0.expAnimBkgImageView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("expAnimBkgImageView");
                imageView = null;
            }
            imageView.setAlpha(1.0f);
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(@NotNull final LoadState state, @NotNull Option option) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(option, "option");
            e.this.aegisLog.i("FeedLiveVoiceAnimController", 1, "delayShowAnimBkg, state " + state);
            ImageView imageView = e.this.expAnimBkgImageView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("expAnimBkgImageView");
                imageView = null;
            }
            final e eVar = e.this;
            imageView.post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.live.f
                @Override // java.lang.Runnable
                public final void run() {
                    e.b.b(LoadState.this, eVar);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/biz/qqcircle/immersive/feed/live/e$c", "Lcom/tencent/mobileqq/vas/image/ILoaderSucessCallback;", "", "onLoadSucceed", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c implements ILoaderSucessCallback {
        c() {
        }

        @Override // com.tencent.mobileqq.vas.image.ILoaderSucessCallback
        public void onLoadSucceed() {
            e.this.aegisLog.i("FeedLiveVoiceAnimController", "apngDrawable onLoadSucceed");
            e.this.g();
        }
    }

    public e(@NotNull FrameLayout expContainer, @NotNull FrameLayout notExpContainer, @NotNull IAegisLogApi aegisLog, @Nullable ExpEntityInfo expEntityInfo) {
        Intrinsics.checkNotNullParameter(expContainer, "expContainer");
        Intrinsics.checkNotNullParameter(notExpContainer, "notExpContainer");
        Intrinsics.checkNotNullParameter(aegisLog, "aegisLog");
        this.expContainer = expContainer;
        this.notExpContainer = notExpContainer;
        this.aegisLog = aegisLog;
        this.expEntityInfo = expEntityInfo;
        this.initState = true;
        aegisLog.i("FeedLiveVoiceAnimController", 1, "isExperiment " + m());
        k();
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        ImageView imageView = this.expAnimBkgImageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expAnimBkgImageView");
            imageView = null;
        }
        ObjectAnimator.ofFloat(imageView, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f).setDuration(1000L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        this.aegisLog.i("FeedLiveVoiceAnimController", 1, "delayShowAnimBkg");
        final Option option = new Option();
        option.setUrl(j());
        ImageView imageView = this.expAnimBkgImageView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expAnimBkgImageView");
            imageView = null;
        }
        option.setTargetView(imageView);
        option.setLoadingDrawable(new ColorDrawable(0));
        ImageView imageView3 = this.expAnimBkgImageView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expAnimBkgImageView");
        } else {
            imageView2 = imageView3;
        }
        imageView2.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.live.d
            @Override // java.lang.Runnable
            public final void run() {
                e.h(e.this, option);
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(e this$0, Option option) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(option, "$option");
        ImageView imageView = this$0.expAnimBkgImageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expAnimBkgImageView");
            imageView = null;
        }
        imageView.setAlpha(0.0f);
        QCircleFeedPicLoader.g().loadImage(option, new b());
    }

    private final String i() {
        ExpEntityInfo expEntityInfo = this.expEntityInfo;
        if (expEntityInfo == null) {
            return "";
        }
        String str = expEntityInfo.getTabParams().get("anim_url");
        this.aegisLog.i("FeedLiveVoiceAnimController", "getExpAnimUrl, " + str);
        if (str == null) {
            return "";
        }
        return str;
    }

    private final String j() {
        ExpEntityInfo expEntityInfo = this.expEntityInfo;
        if (expEntityInfo == null) {
            return "";
        }
        String str = expEntityInfo.getTabParams().get("bkg_url");
        this.aegisLog.i("FeedLiveVoiceAnimController", "getExpBkgUrl, " + str);
        if (str == null) {
            return "";
        }
        return str;
    }

    private final void k() {
        View findViewById = this.expContainer.findViewById(R.id.f165115uy1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "expContainer.findViewById(R.id.exp_anim_image_bkg)");
        this.expAnimBkgImageView = (ImageView) findViewById;
        View findViewById2 = this.expContainer.findViewById(R.id.f165114uy0);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "expContainer.findViewById(R.id.exp_anim_image)");
        this.expAnimImageView = (ImageView) findViewById2;
    }

    private final void l() {
        View findViewById = this.notExpContainer.findViewById(R.id.f1200278f);
        Intrinsics.checkNotNullExpressionValue(findViewById, "notExpContainer.findView\u2026Id(R.id.voice_anim_image)");
        this.notExpAnimation = new QFSLiveAnimation((ImageView) findViewById, "https://downv6.qq.com/video_story/qcircle/live/living_voice2.zip", this.aegisLog);
    }

    private final boolean m() {
        return !TextUtils.isEmpty(i());
    }

    private final void p() {
        this.aegisLog.i("FeedLiveVoiceAnimController", 1, "showExpStyle1Anim");
        URLDrawable apngURLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("FeedLiveVoiceAnimController", i());
        ImageView imageView = this.expAnimImageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expAnimImageView");
            imageView = null;
        }
        imageView.setImageDrawable(apngURLDrawable);
    }

    private final void q() {
        this.aegisLog.i("FeedLiveVoiceAnimController", 1, "showExpStyle2Anim");
        APNGDrawable apngDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngDrawable("FeedLiveVoiceAnimController", i());
        ImageView imageView = this.expAnimImageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expAnimImageView");
            imageView = null;
        }
        imageView.setImageDrawable(apngDrawable);
        apngDrawable.doLoadTask(new c());
    }

    public final void n() {
        boolean m3 = m();
        this.aegisLog.i("FeedLiveVoiceAnimController", 1, "onSelected, isExperiment " + m3 + ", initState " + this.initState);
        if (m3) {
            this.expContainer.setVisibility(0);
            this.notExpContainer.setVisibility(8);
            if (this.initState) {
                if (TextUtils.isEmpty(j())) {
                    p();
                } else {
                    q();
                }
                this.initState = false;
                return;
            }
            return;
        }
        this.expContainer.setVisibility(8);
        this.notExpContainer.setVisibility(0);
    }

    public final void o() {
        this.aegisLog.i("FeedLiveVoiceAnimController", 1, "resetStatus " + m());
        this.initState = true;
        this.expContainer.setVisibility(8);
        ImageView imageView = this.expAnimImageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expAnimImageView");
            imageView = null;
        }
        imageView.setImageBitmap(null);
        ImageView imageView2 = this.expAnimBkgImageView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expAnimBkgImageView");
            imageView2 = null;
        }
        imageView2.setAlpha(1.0f);
        ImageView imageView3 = this.expAnimBkgImageView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expAnimBkgImageView");
            imageView3 = null;
        }
        imageView3.setImageBitmap(null);
        this.notExpContainer.setVisibility(8);
    }

    public final void r() {
        this.aegisLog.i("FeedLiveVoiceAnimController", 1, "startAnim");
        if (m()) {
            this.expContainer.setVisibility(0);
            return;
        }
        QFSLiveAnimation qFSLiveAnimation = this.notExpAnimation;
        if (qFSLiveAnimation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notExpAnimation");
            qFSLiveAnimation = null;
        }
        qFSLiveAnimation.f();
    }

    public final void s() {
        this.aegisLog.i("FeedLiveVoiceAnimController", 1, "stopAnim");
        if (m()) {
            this.expContainer.setVisibility(8);
            return;
        }
        QFSLiveAnimation qFSLiveAnimation = this.notExpAnimation;
        if (qFSLiveAnimation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notExpAnimation");
            qFSLiveAnimation = null;
        }
        qFSLiveAnimation.h();
    }
}
