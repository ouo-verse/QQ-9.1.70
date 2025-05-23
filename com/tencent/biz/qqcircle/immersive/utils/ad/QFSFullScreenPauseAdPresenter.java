package com.tencent.biz.qqcircle.immersive.utils.ad;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.KeyEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.event.ac;
import com.tencent.biz.qqcircle.immersive.feed.event.am;
import com.tencent.biz.qqcircle.immersive.feed.event.ap;
import com.tencent.biz.qqcircle.immersive.utils.ad.QFSPauseAdBaseView;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.superplayer.view.ISPlayerVideoView;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 >2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001?B\u0007\u00a2\u0006\u0004\b<\u0010=J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\"\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0012\u0010\u001c\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001f\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u0011H\u0016J\u0012\u0010 \u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010!\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\"\u001a\u00020\u0005H\u0016J\b\u0010$\u001a\u00020#H\u0016J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020%H\u0016R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00106R\u0016\u0010;\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00106\u00a8\u0006@"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/utils/ad/QFSFullScreenPauseAdPresenter;", "Lcom/tencent/biz/qqcircle/immersive/feed/QFSBaseFeedChildPresenter;", "Lfeedcloud/FeedCloudMeta$StFeed;", "Lcom/tencent/biz/qqcircle/immersive/feed/event/ap;", "event", "", ICustomDataEditor.NUMBER_PARAM_1, "Lcom/tencent/biz/qqcircle/immersive/feed/event/am;", "m1", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "q1", "p1", "", "k1", "Landroid/view/ViewGroup;", "videoView", "", "viewWidth", "viewHeight", "Landroid/graphics/Bitmap;", "l1", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "N0", "Lcom/tencent/biz/richframework/video/rfw/drive/RFWFeedSelectInfo;", "selectInfo", "onFeedSelected", "onFeedUnSelected", "stFeed", com.tencent.luggage.wxa.c8.c.G, "o1", "onResumed", "onPaused", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "w0", "Lcom/tencent/biz/qqcircle/immersive/feed/event/h;", "C0", "Landroid/widget/RelativeLayout;", "I", "Landroid/widget/RelativeLayout;", "adContainer", "J", "Landroid/view/View;", "adMask", "Lcom/tencent/biz/qqcircle/immersive/views/QFSVideoView;", "K", "Lcom/tencent/biz/qqcircle/immersive/views/QFSVideoView;", "playView", "L", "Lfeedcloud/FeedCloudMeta$StFeed;", "feedData", "M", "Z", "isVideoPause", "N", "isResume", "P", "isFeedSelected", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSFullScreenPauseAdPresenter extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {

    /* renamed from: I, reason: from kotlin metadata */
    private RelativeLayout adContainer;

    /* renamed from: J, reason: from kotlin metadata */
    private View adMask;

    /* renamed from: K, reason: from kotlin metadata */
    private QFSVideoView playView;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StFeed feedData;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isVideoPause;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean isResume;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean isFeedSelected;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/qqcircle/immersive/utils/ad/QFSFullScreenPauseAdPresenter$b", "Lcom/tencent/biz/qqcircle/immersive/utils/ad/QFSPauseAdBaseView$a;", "", "restartVideo", "", "onDismiss", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b implements QFSPauseAdBaseView.a {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.utils.ad.QFSPauseAdBaseView.a
        public void onDismiss(boolean restartVideo) {
            String str;
            PBStringField pBStringField;
            if (!restartVideo) {
                QFSFullScreenPauseAdPresenter.this.p1();
                return;
            }
            QFSFullScreenPauseAdPresenter qFSFullScreenPauseAdPresenter = QFSFullScreenPauseAdPresenter.this;
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = qFSFullScreenPauseAdPresenter.feedData;
            if (feedCloudMeta$StFeed != null && (pBStringField = feedCloudMeta$StFeed.f398449id) != null) {
                str = pBStringField.get();
            } else {
                str = null;
            }
            qFSFullScreenPauseAdPresenter.T0(new ac(str));
        }
    }

    private final boolean k1() {
        if (this.isVideoPause && this.isResume && this.isFeedSelected) {
            return true;
        }
        return false;
    }

    private final Bitmap l1(ViewGroup videoView, int viewWidth, int viewHeight) {
        ISPlayerVideoView iSPlayerVideoView;
        View view;
        KeyEvent.Callback childAt = videoView.getChildAt(0);
        if (childAt instanceof ISPlayerVideoView) {
            iSPlayerVideoView = (ISPlayerVideoView) childAt;
        } else {
            iSPlayerVideoView = null;
        }
        if (iSPlayerVideoView != null) {
            view = iSPlayerVideoView.getRenderView();
        } else {
            view = null;
        }
        if (view instanceof TextureView) {
            try {
                Bitmap bitmap = ((TextureView) view).getBitmap(viewWidth, viewHeight);
                Log.d("QDM-QFSFullScreenPauseAdPresenter", "fetchSnapshot: success ");
                return bitmap;
            } catch (Throwable th5) {
                QLog.w("QDM-QFSFullScreenPauseAdPresenter", 1, th5.getMessage(), th5);
            }
        }
        return null;
    }

    private final void m1(am event) {
        String str;
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        this.isVideoPause = event.a();
        if (event.a() && k1()) {
            t tVar = t.f90109a;
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.feedData;
            String str2 = null;
            if (feedCloudMeta$StFeed != null && (pBStringField2 = feedCloudMeta$StFeed.f398449id) != null) {
                str = pBStringField2.get();
            } else {
                str = null;
            }
            FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.feedData;
            if (feedCloudMeta$StFeed2 != null && (feedCloudMeta$StUser = feedCloudMeta$StFeed2.poster) != null && (pBStringField = feedCloudMeta$StUser.f398463id) != null) {
                str2 = pBStringField.get();
            }
            tVar.b(str, str2, new QFSFullScreenPauseAdPresenter$handlerVideoPlayClickEvent$1(this));
        }
    }

    private final void n1(ap event) {
        boolean b16 = event.b();
        this.isVideoPause = b16;
        if (!b16) {
            p1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p1() {
        View view = this.adMask;
        RelativeLayout relativeLayout = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adMask");
            view = null;
        }
        view.setVisibility(8);
        RelativeLayout relativeLayout2 = this.adContainer;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adContainer");
        } else {
            relativeLayout = relativeLayout2;
        }
        relativeLayout.removeAllViews();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void q1(GdtAd gdtAd) {
        QFSPauseAdCardView qFSPauseAdCardView;
        if (k1()) {
            String experimentParam = gdtAd.getExperimentParam(123202);
            QLog.d("QDM-QFSFullScreenPauseAdPresenter", 1, "showAdView: style=" + experimentParam);
            View view = null;
            if (Intrinsics.areEqual(experimentParam, "2")) {
                RelativeLayout relativeLayout = this.adContainer;
                if (relativeLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adContainer");
                    relativeLayout = null;
                }
                Context context = relativeLayout.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "adContainer.context");
                QFSPauseAdFullView qFSPauseAdFullView = new QFSPauseAdFullView(context, null, 0, 0, 14, null);
                QFSVideoView qFSVideoView = this.playView;
                if (qFSVideoView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playView");
                    qFSVideoView = null;
                }
                QFSVideoView qFSVideoView2 = this.playView;
                if (qFSVideoView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playView");
                    qFSVideoView2 = null;
                }
                int width = qFSVideoView2.getWidth();
                QFSVideoView qFSVideoView3 = this.playView;
                if (qFSVideoView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playView");
                    qFSVideoView3 = null;
                }
                qFSPauseAdFullView.setSnapshot(l1(qFSVideoView, width, qFSVideoView3.getHeight()));
                qFSPauseAdCardView = qFSPauseAdFullView;
            } else {
                RelativeLayout relativeLayout2 = this.adContainer;
                if (relativeLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adContainer");
                    relativeLayout2 = null;
                }
                Context context2 = relativeLayout2.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "adContainer.context");
                qFSPauseAdCardView = new QFSPauseAdCardView(context2, null, 0, 0, 14, null);
            }
            if (!qFSPauseAdCardView.L0(gdtAd)) {
                QLog.d("QDM-QFSFullScreenPauseAdPresenter", 1, "showAdView: return !renderSuccess");
                return;
            }
            qFSPauseAdCardView.setDismissCallback(new b());
            RelativeLayout relativeLayout3 = this.adContainer;
            RelativeLayout relativeLayout4 = relativeLayout3;
            if (relativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adContainer");
                relativeLayout4 = null;
            }
            relativeLayout4.addView(qFSPauseAdCardView, new RelativeLayout.LayoutParams(-1, -1));
            View view2 = this.adMask;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adMask");
            } else {
                view = view2;
            }
            view.setVisibility(0);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(@NotNull com.tencent.biz.qqcircle.immersive.feed.event.h event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof ap) {
            n1((ap) event);
        }
        if (event instanceof am) {
            m1((am) event);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.N0(rootView);
        View findViewById = rootView.findViewById(R.id.f57172ml);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026full_screen_ad_container)");
        this.adContainer = (RelativeLayout) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f74163vi);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.rfw_video_view_id)");
        this.playView = (QFSVideoView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f57182mm);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026ideo_full_screen_ad_mask)");
        this.adMask = findViewById3;
        this.isResume = true;
        QLog.d("QDM-QFSFullScreenPauseAdPresenter", 1, "onInitView: ");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: o1, reason: merged with bridge method [inline-methods] */
    public void L0(@Nullable FeedCloudMeta$StFeed stFeed, int pos) {
        this.feedData = stFeed;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        super.onDestroy();
        this.isResume = false;
        p1();
        QLog.d("QDM-QFSFullScreenPauseAdPresenter", 1, "onDestroy: ");
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(@NotNull RFWFeedSelectInfo selectInfo) {
        Intrinsics.checkNotNullParameter(selectInfo, "selectInfo");
        super.onFeedSelected(selectInfo);
        this.isFeedSelected = true;
        p1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onFeedUnSelected(selectInfo);
        this.isFeedSelected = false;
        p1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onPaused(selectInfo);
        this.isResume = false;
        p1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onResumed(selectInfo);
        this.isResume = true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    @NotNull
    public String w0() {
        return "QDM-QFSFullScreenPauseAdPresenter";
    }
}
