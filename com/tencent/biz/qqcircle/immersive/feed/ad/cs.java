package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.immersive.feed.animwrap.QFSFeedAdCardAnimWrap;
import com.tencent.biz.qqcircle.widgets.QCircleRoundImageView;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0014J\b\u0010\u000b\u001a\u00020\u0002H\u0014R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001c\u00a8\u0006$"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/ad/cs;", "Lcom/tencent/biz/qqcircle/immersive/feed/ad/QFSFeedChildAdCardPresenter;", "", "P1", "R1", "Lfeedcloud/FeedCloudMeta$StFeed;", "data", "", "position", Constants.BASE_IN_PLUGIN_ID, "N1", "y1", "Landroid/view/View;", "p0", "Landroid/view/View;", "mAdPosterWindow", "Lcom/tencent/biz/qqcircle/widgets/QCircleRoundImageView;", "q0", "Lcom/tencent/biz/qqcircle/widgets/QCircleRoundImageView;", "mAdPosterCover", "Landroid/widget/ImageView;", "r0", "Landroid/widget/ImageView;", "mAdPosterFeedback", "s0", "mAdPosterClose", "", "t0", "Z", "mIsPosterCard", "u0", "mHasInitView", "<init>", "()V", "v0", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class cs extends QFSFeedChildAdCardPresenter {

    /* renamed from: v0, reason: collision with root package name */
    @NotNull
    private static final a f85569v0 = new a(null);

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mAdPosterWindow;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QCircleRoundImageView mAdPosterCover;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mAdPosterFeedback;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mAdPosterClose;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    private boolean mIsPosterCard;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    private boolean mHasInitView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/ad/cs$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    private final void P1() {
        ImageView imageView;
        ImageView imageView2;
        View view = this.f85356l0;
        if (view != null && !this.mHasInitView) {
            this.mHasInitView = true;
            if (this.mAdPosterWindow == null) {
                View inflate = ((ViewStub) view.findViewById(R.id.v__)).inflate();
                this.mAdPosterWindow = inflate;
                QCircleRoundImageView qCircleRoundImageView = null;
                if (inflate != null) {
                    imageView = (ImageView) inflate.findViewById(R.id.f38521_7);
                } else {
                    imageView = null;
                }
                this.mAdPosterFeedback = imageView;
                View view2 = this.mAdPosterWindow;
                if (view2 != null) {
                    imageView2 = (ImageView) view2.findViewById(R.id.f38541_9);
                } else {
                    imageView2 = null;
                }
                this.mAdPosterClose = imageView2;
                View view3 = this.mAdPosterWindow;
                if (view3 != null) {
                    qCircleRoundImageView = (QCircleRoundImageView) view3.findViewById(R.id.f38531_8);
                }
                this.mAdPosterCover = qCircleRoundImageView;
                F1(qCircleRoundImageView);
                ImageView imageView3 = this.mAdPosterFeedback;
                if (imageView3 != null) {
                    imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.feed.ad.cr
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view4) {
                            cs.Q1(cs.this, view4);
                        }
                    });
                }
                if (com.tencent.biz.qqcircle.immersive.utils.ad.a.f90082a.k(this.E)) {
                    af.p0(this.mAdPosterFeedback, Boolean.FALSE);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1(cs this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.E1(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void R1() {
        GdtAd gdtAd = this.W;
        if (gdtAd != null && this.mAdPosterCover != null) {
            String posterCoverUrl = gdtAd.getPosterCoverUrl();
            QCircleRoundImageView qCircleRoundImageView = this.mAdPosterCover;
            if (qCircleRoundImageView != null) {
                qCircleRoundImageView.setRoundRect(com.tencent.biz.qqcircle.utils.cx.a(4.0f));
            }
            if (!TextUtils.isEmpty(posterCoverUrl)) {
                Option regionWidth = Option.obtain().setRequestHeight(com.tencent.biz.qqcircle.utils.cx.a(138.0f)).setRequestWidth(com.tencent.biz.qqcircle.utils.cx.a(270.0f)).setTargetView(this.mAdPosterCover).setUrl(posterCoverUrl).setRegionHeight(com.tencent.biz.qqcircle.utils.cx.a(138.0f)).setRegionWidth(com.tencent.biz.qqcircle.utils.cx.a(270.0f));
                regionWidth.setSupportRecycler(false);
                QCircleFeedPicLoader.g().loadImage(regionWidth);
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: D1 */
    public void L0(@Nullable FeedCloudMeta$StFeed data, int position) {
        super.L0(data, position);
        boolean k3 = eq.f85700a.k(this.W, this.Y);
        this.mIsPosterCard = k3;
        if (!k3) {
            return;
        }
        P1();
        y1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter
    public void N1() {
        super.N1();
        if (!this.mIsPosterCard) {
            return;
        }
        R1();
        com.tencent.biz.qqcircle.immersive.utils.d.f90201a.n(QAdVrReport.ElementID.AD_POSTER, "1");
        QFSFeedAdCardAnimWrap qFSFeedAdCardAnimWrap = this.f85358n0;
        if (qFSFeedAdCardAnimWrap != null) {
            long j3 = 1000;
            qFSFeedAdCardAnimWrap.G(true, this.X.createTime.get() * j3, this.X.createTimeNs.get() * j3, this.X.syncTime.get() * j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter
    public void y1() {
        this.f85358n0 = new QFSFeedAdCardAnimWrap(this.f85356l0, this.mAdPosterWindow, this.mAdPosterClose, this.X, this.W);
        super.y1();
    }
}
