package com.qzone.reborn.feedx.presenter.ad.basepresenter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.commoncode.module.gdt.e;
import com.qzone.commoncode.module.gdt.f;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.reborn.feedx.presenter.ad.basepresenter.QZoneAdFeedBaseVideoPresenter;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.qzone.reborn.feedx.widget.ad.QZoneAdFeedxSingleVideoWidgetView;
import com.qzone.reborn.feedx.widget.ad.QZoneAdVideoItemWidgetView;
import com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.drawable.BitmapRefDrawable;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import gf.r;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001-B\u0007\u00a2\u0006\u0004\bl\u0010mJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0014J\b\u0010\u001d\u001a\u00020\u0004H\u0014J\u0012\u0010 \u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0014J\u0012\u0010#\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010!H\u0014J\b\u0010$\u001a\u00020\u0006H&J\b\u0010%\u001a\u00020\u0006H\u0016J\b\u0010&\u001a\u00020\u0004H&J\b\u0010'\u001a\u00020\u0004H&J\b\u0010(\u001a\u00020\u0004H&J\b\u0010)\u001a\u00020\u0004H\u0016J\u0006\u0010*\u001a\u00020\u0006J\b\u0010+\u001a\u00020\u0006H\u0016J\b\u0010,\u001a\u00020\u0006H\u0016J\b\u0010-\u001a\u00020\u0006H\u0016J\n\u0010/\u001a\u0004\u0018\u00010.H\u0016R$\u00106\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u0010>\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R$\u0010F\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER$\u0010M\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010T\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR$\u0010[\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR$\u0010b\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR&\u0010j\u001a\u00060cR\u00020\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u0016\u0010k\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010G\u00a8\u0006n"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/basepresenter/QZoneAdFeedBaseVideoPresenter;", "Lvg/a;", "Lgf/r;", "Landroid/view/View$OnClickListener;", "", "Y", "", "m0", "n0", "o0", "c0", "b0", "k0", "", "aid", "traceId", "videoCoverUrl", "Lcom/qzone/reborn/feedx/widget/ad/QZoneAdVideoItemWidgetView$d;", "O", "Ljava/lang/Runnable;", "N", "Landroid/content/Context;", "context", "Landroid/graphics/Bitmap;", "srcBitmap", "Landroid/graphics/drawable/Drawable;", "P", "", ReportConstant.COSTREPORT_PREFIX, HippyTKDListViewAdapter.X, "Landroid/view/View;", "containerView", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "d0", "l0", "W", "X", "a0", "Z", "j0", "play", "pause", "a", "Lcom/qzone/reborn/feedx/widget/picmixvideo/QZoneVideoItemWidgetView;", "d", UserInfo.SEX_FEMALE, "Landroid/view/View;", "getMContainerView", "()Landroid/view/View;", "setMContainerView", "(Landroid/view/View;)V", "mContainerView", "Lcom/qzone/reborn/feedx/widget/ad/QZoneAdFeedxSingleVideoWidgetView;", "G", "Lcom/qzone/reborn/feedx/widget/ad/QZoneAdFeedxSingleVideoWidgetView;", "V", "()Lcom/qzone/reborn/feedx/widget/ad/QZoneAdFeedxSingleVideoWidgetView;", "setMVideoItemWidgetView", "(Lcom/qzone/reborn/feedx/widget/ad/QZoneAdFeedxSingleVideoWidgetView;)V", "mVideoItemWidgetView", "Landroid/widget/ImageView;", "H", "Landroid/widget/ImageView;", "T", "()Landroid/widget/ImageView;", "setMVideoCoverBlurImageView", "(Landroid/widget/ImageView;)V", "mVideoCoverBlurImageView", "I", "Lcom/qzone/reborn/feedx/widget/ad/QZoneAdVideoItemWidgetView$d;", "getMVideoCoverLoadStateListener", "()Lcom/qzone/reborn/feedx/widget/ad/QZoneAdVideoItemWidgetView$d;", "setMVideoCoverLoadStateListener", "(Lcom/qzone/reborn/feedx/widget/ad/QZoneAdVideoItemWidgetView$d;)V", "mVideoCoverLoadStateListener", "J", "Landroid/graphics/Bitmap;", BdhLogUtil.LogTag.Tag_Req, "()Landroid/graphics/Bitmap;", "f0", "(Landroid/graphics/Bitmap;)V", "mVideoCoverBitmap", "K", "Landroid/graphics/drawable/Drawable;", ExifInterface.LATITUDE_SOUTH, "()Landroid/graphics/drawable/Drawable;", "g0", "(Landroid/graphics/drawable/Drawable;)V", "mVideoCoverBlurDrawable", "L", "Ljava/lang/String;", "U", "()Ljava/lang/String;", "i0", "(Ljava/lang/String;)V", "mVideoCoverTraceId", "Lcom/qzone/reborn/feedx/presenter/ad/basepresenter/QZoneAdFeedBaseVideoPresenter$a;", "M", "Lcom/qzone/reborn/feedx/presenter/ad/basepresenter/QZoneAdFeedBaseVideoPresenter$a;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "()Lcom/qzone/reborn/feedx/presenter/ad/basepresenter/QZoneAdFeedBaseVideoPresenter$a;", "e0", "(Lcom/qzone/reborn/feedx/presenter/ad/basepresenter/QZoneAdFeedBaseVideoPresenter$a;)V", "mAdFeedVideoData", "mLastDuration", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class QZoneAdFeedBaseVideoPresenter extends vg.a implements r, View.OnClickListener {

    /* renamed from: F, reason: from kotlin metadata */
    private View mContainerView;

    /* renamed from: G, reason: from kotlin metadata */
    private QZoneAdFeedxSingleVideoWidgetView mVideoItemWidgetView;

    /* renamed from: H, reason: from kotlin metadata */
    private ImageView mVideoCoverBlurImageView;

    /* renamed from: I, reason: from kotlin metadata */
    private QZoneAdVideoItemWidgetView.d mVideoCoverLoadStateListener;

    /* renamed from: J, reason: from kotlin metadata */
    private volatile Bitmap mVideoCoverBitmap;

    /* renamed from: K, reason: from kotlin metadata */
    private volatile Drawable mVideoCoverBlurDrawable;

    /* renamed from: L, reason: from kotlin metadata */
    private volatile String mVideoCoverTraceId;

    /* renamed from: M, reason: from kotlin metadata */
    private a mAdFeedVideoData = new a();

    /* renamed from: N, reason: from kotlin metadata */
    private int mLastDuration;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R$\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/basepresenter/QZoneAdFeedBaseVideoPresenter$a;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "aid", "b", "e", "traceId", "Lcom/qzone/proxy/feedcomponent/model/VideoInfo;", "c", "Lcom/qzone/proxy/feedcomponent/model/VideoInfo;", "()Lcom/qzone/proxy/feedcomponent/model/VideoInfo;", "f", "(Lcom/qzone/proxy/feedcomponent/model/VideoInfo;)V", QCircleScheme.AttrDetail.VIDEO_INFO, "<init>", "(Lcom/qzone/reborn/feedx/presenter/ad/basepresenter/QZoneAdFeedBaseVideoPresenter;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private String aid = "";

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private String traceId = "";

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private VideoInfo videoInfo = new VideoInfo();

        public a() {
        }

        /* renamed from: a, reason: from getter */
        public final String getAid() {
            return this.aid;
        }

        /* renamed from: b, reason: from getter */
        public final String getTraceId() {
            return this.traceId;
        }

        /* renamed from: c, reason: from getter */
        public final VideoInfo getVideoInfo() {
            return this.videoInfo;
        }

        public final void d(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.aid = str;
        }

        public final void e(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.traceId = str;
        }

        public final void f(VideoInfo videoInfo) {
            this.videoInfo = videoInfo;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/feedx/presenter/ad/basepresenter/QZoneAdFeedBaseVideoPresenter$b", "Lcom/qzone/reborn/feedx/widget/ad/QZoneAdVideoItemWidgetView$d;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements QZoneAdVideoItemWidgetView.d {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f55445d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QZoneAdFeedBaseVideoPresenter f55446e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f55447f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f55448h;

        b(String str, QZoneAdFeedBaseVideoPresenter qZoneAdFeedBaseVideoPresenter, String str2, String str3) {
            this.f55445d = str;
            this.f55446e = qZoneAdFeedBaseVideoPresenter;
            this.f55447f = str2;
            this.f55448h = str3;
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState state, Option option) {
            boolean z16 = false;
            boolean z17 = !TextUtils.isEmpty(this.f55445d) && TextUtils.equals(this.f55445d, this.f55446e.getMAdFeedVideoData().getTraceId());
            if (state != null && state.isFinishSuccess()) {
                z16 = true;
            }
            Bitmap resultBitMap = option != null ? option.getResultBitMap() : null;
            QLog.i(this.f55446e.getTAG(), 2, "[CoverLoadStateListener][onStateChange] aid:" + this.f55447f + " isTheSameAd:" + z17 + " success:" + z16 + " url:" + this.f55448h);
            if (this.f55446e.getMVideoCoverBlurImageView() != null && z17 && z16 && resultBitMap != null) {
                this.f55446e.i0(this.f55445d);
                this.f55446e.f0(resultBitMap);
                RFWThreadManager.getInstance().execOnAsyncDisplayThread(this.f55446e.N());
                return;
            }
            QLog.e(this.f55446e.getTAG(), 1, "[CoverLoadStateListener][onStateChange] error");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/feedx/presenter/ad/basepresenter/QZoneAdFeedBaseVideoPresenter$c", "Lcom/qzone/commoncode/module/gdt/f;", "", "currentDuration", "", "onProgress", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements f {
        c() {
        }

        @Override // com.qzone.commoncode.module.gdt.f
        public void onProgress(int currentDuration) {
            if (Math.abs(currentDuration - QZoneAdFeedBaseVideoPresenter.this.mLastDuration) < 500) {
                return;
            }
            QZoneAdFeedBaseVideoPresenter.this.mLastDuration = currentDuration;
            QLog.e(QZoneAdFeedBaseVideoPresenter.this.getTAG(), 1, "[setVideoProgressCallBack] currentDuration, " + currentDuration);
            QZoneAdFeedBaseVideoPresenter.this.D(new cf.a("event_key_qzone_ad_feed_video_current_duration", currentDuration));
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/qzone/reborn/feedx/presenter/ad/basepresenter/QZoneAdFeedBaseVideoPresenter$d", "Lcom/qzone/commoncode/module/gdt/e;", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class d implements e {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(QZoneAdFeedBaseVideoPresenter this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.D(new cf.a(1008));
        }

        @Override // com.qzone.commoncode.module.gdt.e
        public void a() {
            Handler uIHandler = RFWThreadManager.getUIHandler();
            final QZoneAdFeedBaseVideoPresenter qZoneAdFeedBaseVideoPresenter = QZoneAdFeedBaseVideoPresenter.this;
            uIHandler.post(new Runnable() { // from class: com.qzone.reborn.feedx.presenter.ad.basepresenter.d
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneAdFeedBaseVideoPresenter.d.c(QZoneAdFeedBaseVideoPresenter.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Runnable N() {
        return new Runnable() { // from class: com.qzone.reborn.feedx.presenter.ad.basepresenter.QZoneAdFeedBaseVideoPresenter$createUpdateVideoCoverBlurDrawableRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                Drawable P;
                boolean z16 = false;
                boolean z17 = !TextUtils.isEmpty(QZoneAdFeedBaseVideoPresenter.this.getMVideoCoverTraceId()) && TextUtils.equals(QZoneAdFeedBaseVideoPresenter.this.getMVideoCoverTraceId(), QZoneAdFeedBaseVideoPresenter.this.getMAdFeedVideoData().getTraceId());
                if (QZoneAdFeedBaseVideoPresenter.this.getMVideoCoverBlurImageView() != null && QZoneAdFeedBaseVideoPresenter.this.getMVideoCoverBlurDrawable() != null) {
                    ImageView mVideoCoverBlurImageView = QZoneAdFeedBaseVideoPresenter.this.getMVideoCoverBlurImageView();
                    if ((mVideoCoverBlurImageView != null ? mVideoCoverBlurImageView.getDrawable() : null) == QZoneAdFeedBaseVideoPresenter.this.getMVideoCoverBlurDrawable()) {
                        z16 = true;
                    }
                }
                if (z16) {
                    QLog.i(QZoneAdFeedBaseVideoPresenter.this.getTAG(), 2, "[UpdateVideoCoverBlurDrawableRunnable][run] update already");
                    return;
                }
                if (QZoneAdFeedBaseVideoPresenter.this.getMVideoCoverBlurImageView() != null && z17 && QZoneAdFeedBaseVideoPresenter.this.getMVideoCoverBitmap() != null) {
                    if (QZoneAdFeedBaseVideoPresenter.this.getMVideoCoverBlurDrawable() == null) {
                        QZoneAdFeedBaseVideoPresenter qZoneAdFeedBaseVideoPresenter = QZoneAdFeedBaseVideoPresenter.this;
                        ImageView mVideoCoverBlurImageView2 = qZoneAdFeedBaseVideoPresenter.getMVideoCoverBlurImageView();
                        P = qZoneAdFeedBaseVideoPresenter.P(mVideoCoverBlurImageView2 != null ? mVideoCoverBlurImageView2.getContext() : null, QZoneAdFeedBaseVideoPresenter.this.getMVideoCoverBitmap());
                        qZoneAdFeedBaseVideoPresenter.g0(P);
                    }
                    if (QZoneAdFeedBaseVideoPresenter.this.getMVideoCoverBlurDrawable() == null) {
                        QLog.e(QZoneAdFeedBaseVideoPresenter.this.getTAG(), 1, "[UpdateVideoCoverBlurDrawableRunnable][run] error, mVideoCoverBlurDrawable is null");
                        return;
                    } else {
                        QLog.i(QZoneAdFeedBaseVideoPresenter.this.getTAG(), 2, "[UpdateVideoCoverBlurDrawableRunnable][run] update");
                        a(QZoneAdFeedBaseVideoPresenter.this.getMVideoCoverBlurDrawable());
                        return;
                    }
                }
                QLog.e(QZoneAdFeedBaseVideoPresenter.this.getTAG(), 1, "[UpdateVideoCoverBlurDrawableRunnable][run] error");
            }

            private final void a(final Drawable drawable) {
                if (drawable != null && QZoneAdFeedBaseVideoPresenter.this.getMVideoCoverBlurImageView() != null) {
                    ImageView mVideoCoverBlurImageView = QZoneAdFeedBaseVideoPresenter.this.getMVideoCoverBlurImageView();
                    if (mVideoCoverBlurImageView != null) {
                        final QZoneAdFeedBaseVideoPresenter qZoneAdFeedBaseVideoPresenter = QZoneAdFeedBaseVideoPresenter.this;
                        mVideoCoverBlurImageView.post(new Runnable() { // from class: com.qzone.reborn.feedx.presenter.ad.basepresenter.QZoneAdFeedBaseVideoPresenter$createUpdateVideoCoverBlurDrawableRunnable$1$update$1
                            @Override // java.lang.Runnable
                            public void run() {
                                ImageView mVideoCoverBlurImageView2 = QZoneAdFeedBaseVideoPresenter.this.getMVideoCoverBlurImageView();
                                if (mVideoCoverBlurImageView2 != null) {
                                    mVideoCoverBlurImageView2.setImageDrawable(drawable);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                QLog.e(QZoneAdFeedBaseVideoPresenter.this.getTAG(), 1, "[UpdateVideoCoverBlurDrawableRunnable][run] error");
            }
        };
    }

    private final QZoneAdVideoItemWidgetView.d O(String aid, String traceId, String videoCoverUrl) {
        return new b(traceId, this, aid, videoCoverUrl);
    }

    private final boolean Y() {
        return Build.VERSION.SDK_INT >= 26;
    }

    private final void b0() {
        PictureUrl pictureUrl;
        if (!Y()) {
            QLog.i(getTAG(), 2, "[registerListenersForVerticalVideo] CoverBlur is not supported");
            return;
        }
        String aid = this.mAdFeedVideoData.getAid();
        String traceId = this.mAdFeedVideoData.getTraceId();
        VideoInfo videoInfo = this.mAdFeedVideoData.getVideoInfo();
        String str = (videoInfo == null || (pictureUrl = videoInfo.coverUrl) == null) ? null : pictureUrl.url;
        if (str == null) {
            str = "";
        }
        if (TextUtils.isEmpty(traceId)) {
            return;
        }
        this.mVideoCoverLoadStateListener = O(aid, traceId, str);
        QZoneAdFeedxSingleVideoWidgetView qZoneAdFeedxSingleVideoWidgetView = this.mVideoItemWidgetView;
        if (qZoneAdFeedxSingleVideoWidgetView != null) {
            qZoneAdFeedxSingleVideoWidgetView.setVideoCoverLoadStateListener(new WeakReference<>(this.mVideoCoverLoadStateListener));
        }
    }

    private final void c0() {
        k0();
        if (X()) {
            b0();
        }
    }

    private final void m0() {
        if (W()) {
            n0();
        } else if (X()) {
            o0();
        } else {
            QLog.e(getTAG(), 1, "[updateViews] error, videotype error)");
        }
    }

    private final void n0() {
        View view = this.f441562d;
        if (view != null) {
            view.setPadding(view.getPaddingLeft(), this.f441562d.getPaddingTop(), this.f441562d.getPaddingRight(), 0);
        }
        ImageView imageView = this.mVideoCoverBlurImageView;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        ImageView imageView2 = this.mVideoCoverBlurImageView;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        QZoneAdFeedxSingleVideoWidgetView qZoneAdFeedxSingleVideoWidgetView = this.mVideoItemWidgetView;
        if ((qZoneAdFeedxSingleVideoWidgetView != null ? qZoneAdFeedxSingleVideoWidgetView.getLayoutParams() : null) instanceof ConstraintLayout.LayoutParams) {
            QZoneAdFeedxSingleVideoWidgetView qZoneAdFeedxSingleVideoWidgetView2 = this.mVideoItemWidgetView;
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) ConstraintLayout.LayoutParams.class.cast(qZoneAdFeedxSingleVideoWidgetView2 != null ? qZoneAdFeedxSingleVideoWidgetView2.getLayoutParams() : null);
            layoutParams.leftToLeft = 0;
            layoutParams.rightToRight = 0;
            QZoneAdFeedxSingleVideoWidgetView qZoneAdFeedxSingleVideoWidgetView3 = this.mVideoItemWidgetView;
            if (qZoneAdFeedxSingleVideoWidgetView3 != null) {
                qZoneAdFeedxSingleVideoWidgetView3.setLayoutParams(layoutParams);
            }
        }
    }

    private final void o0() {
        if (this.f441562d != null) {
            int D = QZoneAdFeedUtils.f55717a.D(this.f441565h, null);
            View view = this.f441562d;
            view.setPadding(view.getPaddingLeft(), this.f441562d.getPaddingTop(), this.f441562d.getPaddingRight(), D);
        }
        ImageView imageView = this.mVideoCoverBlurImageView;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        ImageView imageView2 = this.mVideoCoverBlurImageView;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        QZoneAdFeedxSingleVideoWidgetView qZoneAdFeedxSingleVideoWidgetView = this.mVideoItemWidgetView;
        if ((qZoneAdFeedxSingleVideoWidgetView != null ? qZoneAdFeedxSingleVideoWidgetView.getLayoutParams() : null) instanceof ConstraintLayout.LayoutParams) {
            QZoneAdFeedxSingleVideoWidgetView qZoneAdFeedxSingleVideoWidgetView2 = this.mVideoItemWidgetView;
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) ConstraintLayout.LayoutParams.class.cast(qZoneAdFeedxSingleVideoWidgetView2 != null ? qZoneAdFeedxSingleVideoWidgetView2.getLayoutParams() : null);
            ImageView imageView3 = this.mVideoCoverBlurImageView;
            if (imageView3 != null) {
                layoutParams.leftToLeft = imageView3.getId();
                layoutParams.rightToRight = imageView3.getId();
            }
            QZoneAdFeedxSingleVideoWidgetView qZoneAdFeedxSingleVideoWidgetView3 = this.mVideoItemWidgetView;
            if (qZoneAdFeedxSingleVideoWidgetView3 == null) {
                return;
            }
            qZoneAdFeedxSingleVideoWidgetView3.setLayoutParams(layoutParams);
        }
    }

    @Override // vg.a
    protected void A(BusinessFeedData feedData) {
        View view;
        if (this.f441565h != null && (view = this.f441562d) != null) {
            if (this.mVideoItemWidgetView != null && this.mVideoCoverBlurImageView != null) {
                view.setVisibility(0);
                if (a0()) {
                    QLog.e(getTAG(), 2, "[onBindData] ignore, is the same ad");
                    return;
                }
                this.mLastDuration = 0;
                d0();
                c0();
                l0();
                j0();
                return;
            }
            QLog.e(getTAG(), 1, "[onBindData] error");
            this.f441562d.setVisibility(8);
            k0();
            return;
        }
        QLog.e(getTAG(), 1, "[onBindData] error, containerView is null");
        k0();
    }

    /* renamed from: Q, reason: from getter */
    public final a getMAdFeedVideoData() {
        return this.mAdFeedVideoData;
    }

    /* renamed from: R, reason: from getter */
    public final Bitmap getMVideoCoverBitmap() {
        return this.mVideoCoverBitmap;
    }

    /* renamed from: S, reason: from getter */
    public final Drawable getMVideoCoverBlurDrawable() {
        return this.mVideoCoverBlurDrawable;
    }

    /* renamed from: T, reason: from getter */
    public final ImageView getMVideoCoverBlurImageView() {
        return this.mVideoCoverBlurImageView;
    }

    /* renamed from: U, reason: from getter */
    public final String getMVideoCoverTraceId() {
        return this.mVideoCoverTraceId;
    }

    /* renamed from: V, reason: from getter */
    public final QZoneAdFeedxSingleVideoWidgetView getMVideoItemWidgetView() {
        return this.mVideoItemWidgetView;
    }

    public abstract boolean W();

    public abstract boolean X();

    public boolean Z() {
        return false;
    }

    @Override // gf.r
    public void a() {
        QZoneAdFeedxSingleVideoWidgetView qZoneAdFeedxSingleVideoWidgetView = this.mVideoItemWidgetView;
        if (qZoneAdFeedxSingleVideoWidgetView != null) {
            qZoneAdFeedxSingleVideoWidgetView.a();
        }
    }

    public abstract boolean a0();

    @Override // gf.r
    public QZoneVideoItemWidgetView d() {
        QLog.d(getTAG(), 1, "getVideoItemView   | feedPos = " + this.f441567m + " | view = " + this.mVideoItemWidgetView);
        return this.mVideoItemWidgetView;
    }

    public abstract void d0();

    public final void e0(a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mAdFeedVideoData = aVar;
    }

    public final void f0(Bitmap bitmap) {
        this.mVideoCoverBitmap = bitmap;
    }

    public final void g0(Drawable drawable) {
        this.mVideoCoverBlurDrawable = drawable;
    }

    public final void i0(String str) {
        this.mVideoCoverTraceId = str;
    }

    public final void j0() {
        if (Z()) {
            QZoneAdFeedxSingleVideoWidgetView qZoneAdFeedxSingleVideoWidgetView = this.mVideoItemWidgetView;
            if (qZoneAdFeedxSingleVideoWidgetView != null) {
                qZoneAdFeedxSingleVideoWidgetView.setVideoProgressCallback(new c());
            }
            QZoneAdFeedxSingleVideoWidgetView qZoneAdFeedxSingleVideoWidgetView2 = this.mVideoItemWidgetView;
            if (qZoneAdFeedxSingleVideoWidgetView2 != null) {
                qZoneAdFeedxSingleVideoWidgetView2.setVideoLoopStartCallback(new d());
            }
        }
    }

    public void l0() {
        QZoneAdFeedxSingleVideoWidgetView qZoneAdFeedxSingleVideoWidgetView = this.mVideoItemWidgetView;
        if (qZoneAdFeedxSingleVideoWidgetView != null) {
            qZoneAdFeedxSingleVideoWidgetView.C1(this.f441565h, this.f441567m, this.mAdFeedVideoData.getVideoInfo());
        }
        ImageView imageView = this.mVideoCoverBlurImageView;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        QZoneAdFeedxSingleVideoWidgetView qZoneAdFeedxSingleVideoWidgetView2 = this.mVideoItemWidgetView;
        if (qZoneAdFeedxSingleVideoWidgetView2 != null) {
            qZoneAdFeedxSingleVideoWidgetView2.setOnClickListener(this);
        }
        QZoneAdFeedxSingleVideoWidgetView qZoneAdFeedxSingleVideoWidgetView3 = this.mVideoItemWidgetView;
        if (qZoneAdFeedxSingleVideoWidgetView3 != null) {
            qZoneAdFeedxSingleVideoWidgetView3.setTimeMuteLayoutMarginBottom(ef.d.b(10));
        }
        m0();
    }

    public void pause() {
        QZoneAdFeedxSingleVideoWidgetView qZoneAdFeedxSingleVideoWidgetView = this.mVideoItemWidgetView;
        if (qZoneAdFeedxSingleVideoWidgetView != null) {
            qZoneAdFeedxSingleVideoWidgetView.pause();
        }
    }

    public void play() {
        QZoneAdFeedxSingleVideoWidgetView qZoneAdFeedxSingleVideoWidgetView = this.mVideoItemWidgetView;
        if (qZoneAdFeedxSingleVideoWidgetView != null) {
            qZoneAdFeedxSingleVideoWidgetView.play();
        }
    }

    @Override // vg.a
    protected int s() {
        return R.id.nn8;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    private final void k0() {
        this.mVideoCoverLoadStateListener = null;
        QZoneAdFeedxSingleVideoWidgetView qZoneAdFeedxSingleVideoWidgetView = this.mVideoItemWidgetView;
        if (qZoneAdFeedxSingleVideoWidgetView != null) {
            qZoneAdFeedxSingleVideoWidgetView.setVideoCoverLoadStateListener(null);
        }
        this.mVideoCoverTraceId = null;
        this.mVideoCoverBitmap = null;
        this.mVideoCoverBlurDrawable = null;
    }

    @Override // vg.a
    protected void C(View containerView) {
        if (containerView == null) {
            QLog.e(getTAG(), 1, "[onInitView] error, containerView is null");
            return;
        }
        this.mContainerView = containerView;
        this.mVideoItemWidgetView = (QZoneAdFeedxSingleVideoWidgetView) containerView.findViewById(R.id.mvr);
        ImageView imageView = (ImageView) containerView.findViewById(R.id.mvq);
        this.mVideoCoverBlurImageView = imageView;
        GdtUIUtils.setViewRadius(imageView, 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Drawable P(Context context, Bitmap srcBitmap) {
        if (context != null && srcBitmap != null) {
            BitmapReference bitmapReference = BitmapReference.getBitmapReference(srcBitmap);
            if (bitmapReference == null) {
                QLog.e(getTAG(), 1, "[createVideoCoverBlurDrawable] error, bitmapReference is null");
                return null;
            }
            Drawable process = new uo.a(25).process(new BitmapRefDrawable(bitmapReference));
            Intrinsics.checkNotNullExpressionValue(process, "blurEffectProcessorDecorator.process(drawable)");
            return process;
        }
        QLog.e(getTAG(), 1, "[createVideoCoverBlurDrawable] error");
        return null;
    }
}
