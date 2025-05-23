package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ad.tangram.views.button.AdAppDownloadButtonController;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqcircle.immersive.feed.ad.af;
import com.tencent.biz.qqcircle.immersive.feed.animwrap.QFSFeedAdCardAnimWrap;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.shake.GdtShakeIconView;
import com.tencent.image.URLImageView;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 Y2\u00020\u0001:\u0001ZB\u0007\u00a2\u0006\u0004\bW\u0010XJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\u001a\u0010\u0013\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0012\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0017\u001a\u00020\u0002H\u0014J\u0012\u0010\u001a\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001b\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001c\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001d\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001e\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001f\u001a\u00020\u0002H\u0016J\u0010\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0016J\b\u0010#\u001a\u00020\u0002H\u0014R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00105\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010.R\u0018\u00107\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010.R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010E\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010.R\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010L\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010V\u001a\u00020Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010S\u00a8\u0006["}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/ad/ca;", "Lcom/tencent/biz/qqcircle/immersive/feed/ad/QFSFeedChildAdCardPresenter;", "", "z1", "V1", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Landroid/widget/ImageView;", "feedbackView", "c2", "", "imageUrl", "Lcom/tencent/mobileqq/qcircle/picload/listener/QCirclePicStateListener;", "T1", "Z1", "U1", "Lfeedcloud/FeedCloudMeta$StFeed;", "data", "", "position", Constants.BASE_IN_PLUGIN_ID, "Lcom/tencent/biz/qqcircle/immersive/feed/event/f;", "event", "t1", "N1", "Lcom/tencent/biz/richframework/video/rfw/drive/RFWFeedSelectInfo;", "selectInfo", "onFeedSelected", "onFeedUnSelected", "onStart", "onResumed", DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "onViewHolderDetachedFromWindow", "y1", "Landroid/view/View;", "p0", "Landroid/view/View;", "mAdBannerLayoutOfIndustry", "Lcom/tencent/image/URLImageView;", "q0", "Lcom/tencent/image/URLImageView;", "mAdBannerIconOfIndustry", "Landroid/widget/TextView;", "r0", "Landroid/widget/TextView;", "mAdBannerLabelOfIndustry", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "s0", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "mAdBannerAvatarViewOfIndustry", "t0", "mAdBannerTitleOfIndustry", "u0", "mAdBannerPupDesOfIndustry", "Landroid/widget/FrameLayout;", "v0", "Landroid/widget/FrameLayout;", "mAdBannerButtonOfIndustry", "Lcom/tencent/ad/tangram/views/button/AdAppDownloadButtonController;", "w0", "Lcom/tencent/ad/tangram/views/button/AdAppDownloadButtonController;", "mBannerDownloadBtnController", "Lcom/tencent/biz/qqcircle/immersive/feed/ad/QFSAdDownloadButton;", "x0", "Lcom/tencent/biz/qqcircle/immersive/feed/ad/QFSAdDownloadButton;", "mBannerDownloadBtn", "y0", "mAdBannerButtonOfIndustryText", "Lcom/tencent/gdtad/views/shake/GdtShakeIconView;", "z0", "Lcom/tencent/gdtad/views/shake/GdtShakeIconView;", "mAdBannerButtonOfIndustryShakeIcon", "A0", "Landroid/widget/ImageView;", "mAdBigBannerFeedBackOfIndustry", "Landroid/graphics/drawable/Drawable;", "B0", "Landroid/graphics/drawable/Drawable;", "mAdBannerIndustryBackgroundDrawable", "", "C0", "Z", "mIsIndustryCard", "D0", "mHasInitView", "<init>", "()V", "E0", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class ca extends QFSFeedChildAdCardPresenter {

    @NotNull
    private static final a E0 = new a(null);

    /* renamed from: A0, reason: from kotlin metadata */
    @Nullable
    private ImageView mAdBigBannerFeedBackOfIndustry;

    /* renamed from: B0, reason: from kotlin metadata */
    @Nullable
    private Drawable mAdBannerIndustryBackgroundDrawable;

    /* renamed from: C0, reason: from kotlin metadata */
    private boolean mIsIndustryCard;

    /* renamed from: D0, reason: from kotlin metadata */
    private boolean mHasInitView;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mAdBannerLayoutOfIndustry;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private URLImageView mAdBannerIconOfIndustry;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mAdBannerLabelOfIndustry;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QCircleAvatarView mAdBannerAvatarViewOfIndustry;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mAdBannerTitleOfIndustry;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mAdBannerPupDesOfIndustry;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout mAdBannerButtonOfIndustry;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AdAppDownloadButtonController mBannerDownloadBtnController;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QFSAdDownloadButton mBannerDownloadBtn;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mAdBannerButtonOfIndustryText;

    /* renamed from: z0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GdtShakeIconView mAdBannerButtonOfIndustryShakeIcon;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/ad/ca$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/feed/ad/ca$b", "Lcom/tencent/mobileqq/qcircle/picload/listener/QCirclePicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends QCirclePicStateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f85556d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ca f85557e;

        b(String str, ca caVar) {
            this.f85556d = str;
            this.f85557e = caVar;
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(@NotNull LoadState state, @NotNull Option option) {
            Bitmap bitmap;
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(option, "option");
            super.onStateChange(state, option);
            if (state.isFinishSuccess()) {
                bitmap = option.getResultBitMap();
            } else {
                bitmap = null;
            }
            String url = option.getUrl();
            QLog.i("QFSFeedChildAdCardPresenter", 2, "[onStateChange] state:" + state + " url:" + url + " ");
            if (!state.isFinishSuccess()) {
                return;
            }
            if (bitmap == null) {
                QLog.e("QFSFeedChildAdIndustryCardPresenter", 1, "[onStateChange] error, bitmap is null");
                return;
            }
            if (!TextUtils.equals(url, this.f85556d)) {
                QLog.i("QFSFeedChildAdIndustryCardPresenter", 2, "[onStateChange] error, is not the same url");
                return;
            }
            if (this.f85557e.mAdBannerLayoutOfIndustry != null && this.f85557e.m0() != null) {
                RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(this.f85557e.m0().getResources(), bitmap);
                Intrinsics.checkNotNullExpressionValue(create, "create(context.resources, bitmap)");
                create.setAntiAlias(true);
                create.setCornerRadius(com.tencent.biz.qqcircle.utils.cx.a(4.0f));
                this.f85557e.mAdBannerIndustryBackgroundDrawable = create;
                View view = this.f85557e.mAdBannerLayoutOfIndustry;
                if (view != null) {
                    view.setBackground(create);
                    return;
                }
                return;
            }
            QLog.e("QFSFeedChildAdIndustryCardPresenter", 1, "[onStateChange] error");
        }
    }

    private final QCirclePicStateListener T1(String imageUrl) {
        return new b(imageUrl, this);
    }

    private final void U1() {
        if (this.mAdBannerLayoutOfIndustry == null) {
            QLog.e("QFSFeedChildAdIndustryCardPresenter", 2, "[hideAdBannerBackgroundOfIndustry] error, mAdBannerLayoutOfIndustry is null");
            return;
        }
        QLog.i("QFSFeedChildAdIndustryCardPresenter", 2, "[hideAdBannerBackgroundOfIndustry]");
        View view = this.mAdBannerLayoutOfIndustry;
        if (view != null) {
            view.setBackgroundResource(R.drawable.kdv);
        }
    }

    private final void V1() {
        View view = this.f85356l0;
        if (view != null && !this.mHasInitView) {
            this.mHasInitView = true;
            View findViewById = view.findViewById(R.id.f3743179);
            this.mAdBannerLayoutOfIndustry = findViewById;
            af.a(findViewById);
            this.mAdBannerIconOfIndustry = (URLImageView) this.f85356l0.findViewById(R.id.f376317s);
            this.mAdBannerLabelOfIndustry = (TextView) this.f85356l0.findViewById(R.id.f376417t);
            this.mAdBannerAvatarViewOfIndustry = (QCircleAvatarView) this.f85356l0.findViewById(R.id.f374717c);
            this.mAdBannerTitleOfIndustry = (TextView) this.f85356l0.findViewById(R.id.f376817x);
            this.mAdBannerPupDesOfIndustry = (TextView) this.f85356l0.findViewById(R.id.f375717m);
            this.mAdBannerButtonOfIndustry = (FrameLayout) this.f85356l0.findViewById(R.id.f375017f);
            QFSAdDownloadButton qFSAdDownloadButton = (QFSAdDownloadButton) this.f85356l0.findViewById(R.id.f380418w);
            this.mBannerDownloadBtn = qFSAdDownloadButton;
            if (qFSAdDownloadButton != null) {
                qFSAdDownloadButton.setPrefixTag("QFSFeedChildAdIndustryCardPresenter");
            }
            this.mAdBannerButtonOfIndustryText = (TextView) this.f85356l0.findViewById(R.id.f375217h);
            this.mAdBannerButtonOfIndustryShakeIcon = (GdtShakeIconView) this.f85356l0.findViewById(R.id.f375117g);
            this.mAdBigBannerFeedBackOfIndustry = (ImageView) this.f85356l0.findViewById(R.id.f374517a);
            GdtShakeIconView gdtShakeIconView = this.mAdBannerButtonOfIndustryShakeIcon;
            if (gdtShakeIconView != null) {
                gdtShakeIconView.setVisibility(8);
            }
            ImageView imageView = this.mAdBigBannerFeedBackOfIndustry;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            URLImageView uRLImageView = this.mAdBannerIconOfIndustry;
            if (uRLImageView != null) {
                uRLImageView.setVisibility(0);
            }
            F1(this.mAdBannerLayoutOfIndustry);
            F1(this.mAdBannerIconOfIndustry);
            F1(this.mAdBannerLabelOfIndustry);
            F1(this.mAdBannerAvatarViewOfIndustry);
            F1(this.mAdBannerTitleOfIndustry);
            F1(this.mAdBannerPupDesOfIndustry);
            F1(this.mAdBannerButtonOfIndustry);
            ImageView imageView2 = this.mAdBigBannerFeedBackOfIndustry;
            if (imageView2 != null) {
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.bz
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        ca.W1(ca.this, view2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(ca this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.E1(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X1(ca this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AdAppDownloadButtonController adAppDownloadButtonController = this$0.mBannerDownloadBtnController;
        if (adAppDownloadButtonController != null) {
            adAppDownloadButtonController.onViewResume();
        }
        if (!af.Z(this$0.W)) {
            return;
        }
        this$0.T0(new com.tencent.biz.qqcircle.immersive.feed.event.c(this$0.W.getTraceId(), true));
    }

    private final void Z1() {
        if (this.mAdBannerLayoutOfIndustry == null) {
            QLog.e("QFSFeedChildAdIndustryCardPresenter", 2, "[showAdBannerBackgroundOfIndustry] error, mAdBannerLayoutOfIndustry is null");
            return;
        }
        QLog.i("QFSFeedChildAdIndustryCardPresenter", 2, "[showAdBannerBackgroundOfIndustry]");
        Drawable drawable = this.mAdBannerIndustryBackgroundDrawable;
        if (drawable != null) {
            View view = this.mAdBannerLayoutOfIndustry;
            if (view != null) {
                view.setBackground(drawable);
                return;
            }
            return;
        }
        View view2 = this.mAdBannerLayoutOfIndustry;
        if (view2 != null) {
            view2.setBackgroundResource(R.drawable.kdv);
        }
    }

    private final void a2() {
        URLImageView uRLImageView;
        Integer num;
        Integer num2;
        GdtAd gdtAd = this.W;
        if (gdtAd != null && gdtAd.isValid() && this.mAdBannerLayoutOfIndustry != null && this.mAdBannerIconOfIndustry != null && this.mAdBannerLabelOfIndustry != null && this.mAdBannerAvatarViewOfIndustry != null && this.mAdBannerTitleOfIndustry != null && this.mAdBannerPupDesOfIndustry != null && this.mAdBannerButtonOfIndustry != null) {
            ImageView imageView = this.mAdBigBannerFeedBackOfIndustry;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            c2(this.mAdBigBannerFeedBackOfIndustry);
            View view = this.mAdBannerLayoutOfIndustry;
            Intrinsics.checkNotNull(view);
            view.setBackgroundResource(R.drawable.kdv);
            ImageView imageView2 = null;
            this.mAdBannerIndustryBackgroundDrawable = null;
            String backgroundUrl = this.W.getCardBackgroundUrl();
            if (!TextUtils.isEmpty(backgroundUrl)) {
                View view2 = this.mAdBannerLayoutOfIndustry;
                if (view2 != null) {
                    num = Integer.valueOf(view2.getWidth());
                } else {
                    num = null;
                }
                View view3 = this.mAdBannerLayoutOfIndustry;
                if (view3 != null) {
                    num2 = Integer.valueOf(view3.getHeight());
                } else {
                    num2 = null;
                }
                QLog.i("QFSFeedChildAdCardPresenter", 2, "[updateAdBigBannerOfIndustry] width:" + num + " height:" + num2);
                Option url = Option.obtain().setUrl(backgroundUrl);
                if (num2 != null) {
                    num2.intValue();
                    if (num != null) {
                        num.intValue();
                        if (num.intValue() > 0 && num2.intValue() > 0) {
                            url = url.setRequestWidth(num.intValue()).setRequestHeight(num2.intValue());
                        }
                    }
                }
                QCircleFeedPicLoader g16 = QCircleFeedPicLoader.g();
                Intrinsics.checkNotNullExpressionValue(backgroundUrl, "backgroundUrl");
                g16.loadImage(url, T1(backgroundUrl));
            }
            URLImageView uRLImageView2 = this.mAdBannerIconOfIndustry;
            if (uRLImageView2 != null) {
                uRLImageView2.setImageDrawable(null);
            }
            if (!TextUtils.isEmpty(this.W.getTopLeftIconUrl()) && (uRLImageView = this.mAdBannerIconOfIndustry) != null) {
                uRLImageView.setImageURL(this.W.getTopLeftIconUrl());
            }
            TextView textView = this.mAdBannerLabelOfIndustry;
            if (textView != null) {
                textView.setText(this.W.getLabel());
            }
            String str = this.X.poster.icon.iconUrl.get();
            if (!TextUtils.isEmpty(str)) {
                Option requestHeight = Option.obtain().setRequestWidth(com.tencent.biz.qqcircle.utils.cx.a(64.0f)).setRequestHeight(com.tencent.biz.qqcircle.utils.cx.a(64.0f));
                QCircleAvatarView qCircleAvatarView = this.mAdBannerAvatarViewOfIndustry;
                if (qCircleAvatarView != null) {
                    imageView2 = qCircleAvatarView.k();
                }
                Option regionWidth = requestHeight.setTargetView(imageView2).setUrl(str).setRegionHeight(com.tencent.biz.qqcircle.utils.cx.a(64.0f)).setRegionWidth(com.tencent.biz.qqcircle.utils.cx.a(64.0f));
                regionWidth.setSupportRecycler(true);
                QCircleFeedPicLoader.g().loadImage(regionWidth);
            }
            TextView textView2 = this.mAdBannerTitleOfIndustry;
            if (textView2 != null) {
                textView2.setText(this.X.poster.nick.get());
            }
            TextView textView3 = this.mAdBannerPupDesOfIndustry;
            if (textView3 != null) {
                textView3.setText(this.X.content.get());
            }
            QFSAdDownloadButton qFSAdDownloadButton = this.mBannerDownloadBtn;
            if (qFSAdDownloadButton != null) {
                qFSAdDownloadButton.setPrefixText("");
            }
            if (af.Z(this.W) && af.z(this.W) == 1) {
                String x16 = af.x(this.W);
                if (TextUtils.isEmpty(x16)) {
                    x16 = "\u6447\u52a8\u6216\u70b9\u51fb\u67e5\u770b\u8be6\u60c5";
                }
                QFSAdDownloadButton qFSAdDownloadButton2 = this.mBannerDownloadBtn;
                if (qFSAdDownloadButton2 != null) {
                    qFSAdDownloadButton2.setPrefixText("\u6447\u52a8\u6216\u70b9\u51fb");
                }
                TextView textView4 = this.mAdBannerButtonOfIndustryText;
                if (textView4 != null) {
                    textView4.setText(x16);
                }
                GdtShakeIconView gdtShakeIconView = this.mAdBannerButtonOfIndustryShakeIcon;
                if (gdtShakeIconView != null) {
                    gdtShakeIconView.setVisibility(0);
                    return;
                }
                return;
            }
            TextView textView5 = this.mAdBannerButtonOfIndustryText;
            if (textView5 != null) {
                textView5.setText(this.X.subtitle.get());
            }
            GdtShakeIconView gdtShakeIconView2 = this.mAdBannerButtonOfIndustryShakeIcon;
            if (gdtShakeIconView2 != null) {
                gdtShakeIconView2.setVisibility(8);
            }
            GdtShakeIconView gdtShakeIconView3 = this.mAdBannerButtonOfIndustryShakeIcon;
            if (gdtShakeIconView3 != null) {
                gdtShakeIconView3.stop();
                return;
            }
            return;
        }
        QLog.e("QFSFeedChildAdIndustryCardPresenter", 2, "[updateAdBigBannerOfIndustry] error");
    }

    private final void c2(ImageView feedbackView) {
        if (com.tencent.biz.qqcircle.immersive.utils.ad.a.f90082a.k(this.E) && feedbackView != null) {
            feedbackView.setImageResource(R.drawable.o1d);
            ViewGroup.LayoutParams layoutParams = feedbackView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams2).width = com.tencent.biz.qqcircle.utils.cx.a(78.0f);
            ((ViewGroup.MarginLayoutParams) layoutParams2).height = com.tencent.biz.qqcircle.utils.cx.a(17.0f);
            TextView textView = this.mAdBannerTitleOfIndustry;
            if (textView != null && textView != null) {
                textView.setMaxEms(5);
            }
        }
    }

    private final void z1() {
        if (this.mBannerDownloadBtnController != null) {
            return;
        }
        QLog.d("QFSFeedChildAdIndustryCardPresenter", 1, "initDownloadBtnView isValid: " + af.k(this.W));
        Context m06 = m0();
        Intrinsics.checkNotNull(m06, "null cannot be cast to non-null type android.app.Activity");
        this.mBannerDownloadBtnController = af.R((Activity) m06, this.W, this.mBannerDownloadBtn, this.mAdBannerButtonOfIndustry, R.drawable.kdt);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: D1 */
    public void L0(@Nullable FeedCloudMeta$StFeed data, int position) {
        super.L0(data, position);
        boolean g16 = eq.f85700a.g(this.W, this.Y);
        this.mIsIndustryCard = g16;
        if (!g16) {
            return;
        }
        V1();
        y1();
        z1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter
    public void N1() {
        super.N1();
        if (!this.mIsIndustryCard) {
            return;
        }
        a2();
        QFSFeedAdCardAnimWrap qFSFeedAdCardAnimWrap = this.f85358n0;
        if (qFSFeedAdCardAnimWrap != null) {
            long j3 = 1000;
            qFSFeedAdCardAnimWrap.G(true, this.X.createTime.get() * j3, this.X.createTimeNs.get() * j3, this.X.syncTime.get() * j3);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        QLog.i("QFSFeedChildAdIndustryCardPresenter", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        U1();
        AdAppDownloadButtonController adAppDownloadButtonController = this.mBannerDownloadBtnController;
        if (adAppDownloadButtonController != null) {
            adAppDownloadButtonController.unregisterView(new WeakReference<>(this.mBannerDownloadBtn));
        }
        this.mBannerDownloadBtnController = null;
        super.onDestroy();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onFeedSelected(selectInfo);
        Z1();
        z1();
        AdAppDownloadButtonController adAppDownloadButtonController = this.mBannerDownloadBtnController;
        if (adAppDownloadButtonController != null) {
            adAppDownloadButtonController.onViewResume();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(@Nullable RFWFeedSelectInfo selectInfo) {
        QLog.i("QFSFeedChildAdIndustryCardPresenter", 2, "onFeedUnSelected");
        if (!af.T(this.W)) {
            U1();
        }
        AdAppDownloadButtonController adAppDownloadButtonController = this.mBannerDownloadBtnController;
        if (adAppDownloadButtonController != null) {
            adAppDownloadButtonController.onViewPause();
        }
        super.onFeedUnSelected(selectInfo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onResumed(selectInfo);
        AdAppDownloadButtonController adAppDownloadButtonController = this.mBannerDownloadBtnController;
        if (adAppDownloadButtonController != null) {
            adAppDownloadButtonController.onViewResume();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onStart(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onStart(selectInfo);
        Z1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onStop(@Nullable RFWFeedSelectInfo selectInfo) {
        U1();
        super.onStop(selectInfo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus
    public void onViewHolderDetachedFromWindow(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        QLog.i("QFSFeedChildAdIndustryCardPresenter", 2, "onViewHolderDetachedFromWindow");
        U1();
        AdAppDownloadButtonController adAppDownloadButtonController = this.mBannerDownloadBtnController;
        if (adAppDownloadButtonController != null) {
            adAppDownloadButtonController.unregisterView(new WeakReference<>(this.mBannerDownloadBtn));
        }
        this.mBannerDownloadBtnController = null;
        super.onViewHolderDetachedFromWindow(holder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter
    public void t1(@Nullable com.tencent.biz.qqcircle.immersive.feed.event.f event) {
        super.t1(event);
        AdAppDownloadButtonController adAppDownloadButtonController = this.mBannerDownloadBtnController;
        if (adAppDownloadButtonController != null) {
            adAppDownloadButtonController.onViewResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter
    public void y1() {
        ImageView imageView;
        TextPaint textPaint;
        View view = this.f85356l0;
        View view2 = this.mAdBannerLayoutOfIndustry;
        TextPaint textPaint2 = null;
        if (view2 != null) {
            imageView = (ImageView) view2.findViewById(R.id.f375517k);
        } else {
            imageView = null;
        }
        QFSFeedAdCardAnimWrap qFSFeedAdCardAnimWrap = new QFSFeedAdCardAnimWrap(view, view2, imageView, this.X, this.W);
        this.f85358n0 = qFSFeedAdCardAnimWrap;
        qFSFeedAdCardAnimWrap.E(true);
        TextView textView = this.mAdBannerLabelOfIndustry;
        if (textView != null) {
            textPaint = textView.getPaint();
        } else {
            textPaint = null;
        }
        if (textPaint != null) {
            TextView textView2 = this.mAdBannerLabelOfIndustry;
            if (textView2 != null) {
                textPaint2 = textView2.getPaint();
            }
            if (textPaint2 != null) {
                textPaint2.setFakeBoldText(true);
            }
        }
        this.f85358n0.F(new af.c() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.bx
            @Override // com.tencent.biz.qqcircle.immersive.feed.ad.af.c
            public final void a() {
                ca.X1(ca.this);
            }
        });
    }
}
