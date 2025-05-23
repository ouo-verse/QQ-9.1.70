package com.qzone.reborn.feedpro.section.ad.basepresenter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.feedpro.widget.ad.QZoneAdFeedProSingleVideoWidgetView;
import com.qzone.reborn.feedpro.widget.ad.QZoneAdFeedProVideoItemWidgetView;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.drawable.BitmapRefDrawable;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonImage;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonPicUrl;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonVideo;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import de.f;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xd.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001)B\u0007\u00a2\u0006\u0004\b[\u0010\\J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0014J\b\u0010\u001d\u001a\u00020\u0004H\u0014J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eH\u0014J\u0012\u0010#\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010!H\u0014J\b\u0010$\u001a\u00020\u0006H&J\b\u0010%\u001a\u00020\u0006H\u0016J\b\u0010&\u001a\u00020\u0004H&J\b\u0010'\u001a\u00020\u0004H&J\b\u0010(\u001a\u00020\u0004H&J\b\u0010)\u001a\u00020\u0006H\u0016J\n\u0010*\u001a\u0004\u0018\u00010\u001eH\u0016R$\u00102\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u0010:\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010A\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010G\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR$\u0010M\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010S\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR&\u0010Z\u001a\u00060TR\u00020\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bU\u0010W\"\u0004\bX\u0010Y\u00a8\u0006]"}, d2 = {"Lcom/qzone/reborn/feedpro/section/ad/basepresenter/QZoneAdFeedBaseVideoSection;", "Lne/a;", "Lde/f;", "Landroid/view/View$OnClickListener;", "", ExifInterface.LATITUDE_SOUTH, "", "d0", "e0", "f0", "V", "U", "b0", "", "aid", "traceId", "videoCoverUrl", "Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProVideoItemWidgetView$c;", "I", "Ljava/lang/Runnable;", "H", "Landroid/content/Context;", "context", "Landroid/graphics/Bitmap;", "srcBitmap", "Landroid/graphics/drawable/Drawable;", "J", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "Landroid/view/View;", "containerView", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", HippyTKDListViewAdapter.X, "W", "c0", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, "T", "a", "d", "Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProSingleVideoWidgetView;", "E", "Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProSingleVideoWidgetView;", "P", "()Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProSingleVideoWidgetView;", "setMVideoItemWidgetView", "(Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProSingleVideoWidgetView;)V", "mVideoItemWidgetView", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "N", "()Landroid/widget/ImageView;", "setMVideoCoverBlurImageView", "(Landroid/widget/ImageView;)V", "mVideoCoverBlurImageView", "G", "Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProVideoItemWidgetView$c;", "getMVideoCoverLoadStateListener", "()Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProVideoItemWidgetView$c;", "setMVideoCoverLoadStateListener", "(Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProVideoItemWidgetView$c;)V", "mVideoCoverLoadStateListener", "Landroid/graphics/Bitmap;", "L", "()Landroid/graphics/Bitmap;", "Y", "(Landroid/graphics/Bitmap;)V", "mVideoCoverBitmap", "Landroid/graphics/drawable/Drawable;", "M", "()Landroid/graphics/drawable/Drawable;", "Z", "(Landroid/graphics/drawable/Drawable;)V", "mVideoCoverBlurDrawable", "Ljava/lang/String;", "O", "()Ljava/lang/String;", "a0", "(Ljava/lang/String;)V", "mVideoCoverTraceId", "Lcom/qzone/reborn/feedpro/section/ad/basepresenter/QZoneAdFeedBaseVideoSection$a;", "K", "Lcom/qzone/reborn/feedpro/section/ad/basepresenter/QZoneAdFeedBaseVideoSection$a;", "()Lcom/qzone/reborn/feedpro/section/ad/basepresenter/QZoneAdFeedBaseVideoSection$a;", "X", "(Lcom/qzone/reborn/feedpro/section/ad/basepresenter/QZoneAdFeedBaseVideoSection$a;)V", "mAdFeedVideoData", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class QZoneAdFeedBaseVideoSection extends ne.a implements f, View.OnClickListener {

    /* renamed from: E, reason: from kotlin metadata */
    private QZoneAdFeedProSingleVideoWidgetView mVideoItemWidgetView;

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView mVideoCoverBlurImageView;

    /* renamed from: G, reason: from kotlin metadata */
    private QZoneAdFeedProVideoItemWidgetView.c mVideoCoverLoadStateListener;

    /* renamed from: H, reason: from kotlin metadata */
    private volatile Bitmap mVideoCoverBitmap;

    /* renamed from: I, reason: from kotlin metadata */
    private volatile Drawable mVideoCoverBlurDrawable;

    /* renamed from: J, reason: from kotlin metadata */
    private volatile String mVideoCoverTraceId;

    /* renamed from: K, reason: from kotlin metadata */
    private a mAdFeedVideoData = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\"\u0010\u0012\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/qzone/reborn/feedpro/section/ad/basepresenter/QZoneAdFeedBaseVideoSection$a;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "aid", "b", "e", "traceId", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMedia;", "c", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMedia;", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMedia;", "f", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonMedia;)V", QCircleScheme.AttrDetail.VIDEO_INFO, "<init>", "(Lcom/qzone/reborn/feedpro/section/ad/basepresenter/QZoneAdFeedBaseVideoSection;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private String aid = "";

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private String traceId = "";

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private CommonMedia videoInfo = new CommonMedia();

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
        public final CommonMedia getVideoInfo() {
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

        public final void f(CommonMedia commonMedia) {
            Intrinsics.checkNotNullParameter(commonMedia, "<set-?>");
            this.videoInfo = commonMedia;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/feedpro/section/ad/basepresenter/QZoneAdFeedBaseVideoSection$b", "Lcom/qzone/reborn/feedpro/widget/ad/QZoneAdFeedProVideoItemWidgetView$c;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements QZoneAdFeedProVideoItemWidgetView.c {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f54171d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QZoneAdFeedBaseVideoSection f54172e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f54173f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f54174h;

        b(String str, QZoneAdFeedBaseVideoSection qZoneAdFeedBaseVideoSection, String str2, String str3) {
            this.f54171d = str;
            this.f54172e = qZoneAdFeedBaseVideoSection;
            this.f54173f = str2;
            this.f54174h = str3;
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState state, Option option) {
            boolean z16 = false;
            boolean z17 = !TextUtils.isEmpty(this.f54171d) && TextUtils.equals(this.f54171d, this.f54172e.getMAdFeedVideoData().getTraceId());
            if (state != null && state.isFinishSuccess()) {
                z16 = true;
            }
            Bitmap resultBitMap = option != null ? option.getResultBitMap() : null;
            QLog.i(this.f54172e.h(), 2, "[CoverLoadStateListener][onStateChange] aid:" + this.f54173f + " isTheSameAd:" + z17 + " success:" + z16 + " url:" + this.f54174h);
            if (this.f54172e.getMVideoCoverBlurImageView() != null && z17 && z16 && resultBitMap != null) {
                this.f54172e.a0(this.f54171d);
                this.f54172e.Y(resultBitMap);
                RFWThreadManager.getInstance().execOnAsyncDisplayThread(this.f54172e.H());
                return;
            }
            QLog.e(this.f54172e.h(), 1, "[CoverLoadStateListener][onStateChange] error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Runnable H() {
        return new Runnable() { // from class: com.qzone.reborn.feedpro.section.ad.basepresenter.QZoneAdFeedBaseVideoSection$createUpdateVideoCoverBlurDrawableRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                Drawable J;
                boolean z16 = false;
                boolean z17 = !TextUtils.isEmpty(QZoneAdFeedBaseVideoSection.this.getMVideoCoverTraceId()) && TextUtils.equals(QZoneAdFeedBaseVideoSection.this.getMVideoCoverTraceId(), QZoneAdFeedBaseVideoSection.this.getMAdFeedVideoData().getTraceId());
                if (QZoneAdFeedBaseVideoSection.this.getMVideoCoverBlurImageView() != null && QZoneAdFeedBaseVideoSection.this.getMVideoCoverBlurDrawable() != null) {
                    ImageView mVideoCoverBlurImageView = QZoneAdFeedBaseVideoSection.this.getMVideoCoverBlurImageView();
                    if ((mVideoCoverBlurImageView != null ? mVideoCoverBlurImageView.getDrawable() : null) == QZoneAdFeedBaseVideoSection.this.getMVideoCoverBlurDrawable()) {
                        z16 = true;
                    }
                }
                if (z16) {
                    QLog.i(QZoneAdFeedBaseVideoSection.this.h(), 2, "[UpdateVideoCoverBlurDrawableRunnable][run] update already");
                    return;
                }
                if (QZoneAdFeedBaseVideoSection.this.getMVideoCoverBlurImageView() != null && z17 && QZoneAdFeedBaseVideoSection.this.getMVideoCoverBitmap() != null) {
                    if (QZoneAdFeedBaseVideoSection.this.getMVideoCoverBlurDrawable() == null) {
                        QZoneAdFeedBaseVideoSection qZoneAdFeedBaseVideoSection = QZoneAdFeedBaseVideoSection.this;
                        ImageView mVideoCoverBlurImageView2 = qZoneAdFeedBaseVideoSection.getMVideoCoverBlurImageView();
                        J = qZoneAdFeedBaseVideoSection.J(mVideoCoverBlurImageView2 != null ? mVideoCoverBlurImageView2.getContext() : null, QZoneAdFeedBaseVideoSection.this.getMVideoCoverBitmap());
                        qZoneAdFeedBaseVideoSection.Z(J);
                    }
                    if (QZoneAdFeedBaseVideoSection.this.getMVideoCoverBlurDrawable() == null) {
                        QLog.e(QZoneAdFeedBaseVideoSection.this.h(), 1, "[UpdateVideoCoverBlurDrawableRunnable][run] error, mVideoCoverBlurDrawable is null");
                        return;
                    } else {
                        QLog.i(QZoneAdFeedBaseVideoSection.this.h(), 2, "[UpdateVideoCoverBlurDrawableRunnable][run] update");
                        a(QZoneAdFeedBaseVideoSection.this.getMVideoCoverBlurDrawable());
                        return;
                    }
                }
                QLog.e(QZoneAdFeedBaseVideoSection.this.h(), 1, "[UpdateVideoCoverBlurDrawableRunnable][run] error");
            }

            private final void a(final Drawable drawable) {
                if (drawable != null && QZoneAdFeedBaseVideoSection.this.getMVideoCoverBlurImageView() != null) {
                    ImageView mVideoCoverBlurImageView = QZoneAdFeedBaseVideoSection.this.getMVideoCoverBlurImageView();
                    if (mVideoCoverBlurImageView != null) {
                        final QZoneAdFeedBaseVideoSection qZoneAdFeedBaseVideoSection = QZoneAdFeedBaseVideoSection.this;
                        mVideoCoverBlurImageView.post(new Runnable() { // from class: com.qzone.reborn.feedpro.section.ad.basepresenter.QZoneAdFeedBaseVideoSection$createUpdateVideoCoverBlurDrawableRunnable$1$update$1
                            @Override // java.lang.Runnable
                            public void run() {
                                ImageView mVideoCoverBlurImageView2 = QZoneAdFeedBaseVideoSection.this.getMVideoCoverBlurImageView();
                                if (mVideoCoverBlurImageView2 != null) {
                                    mVideoCoverBlurImageView2.setImageDrawable(drawable);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                QLog.e(QZoneAdFeedBaseVideoSection.this.h(), 1, "[UpdateVideoCoverBlurDrawableRunnable][run] error");
            }
        };
    }

    private final QZoneAdFeedProVideoItemWidgetView.c I(String aid, String traceId, String videoCoverUrl) {
        return new b(traceId, this, aid, videoCoverUrl);
    }

    private final boolean S() {
        return Build.VERSION.SDK_INT >= 26;
    }

    private final void U() {
        String str;
        CommonImage cover;
        CommonPicUrl e16;
        if (!S()) {
            QLog.i(h(), 2, "[registerListenersForVerticalVideo] CoverBlur is not supported");
            return;
        }
        String aid = this.mAdFeedVideoData.getAid();
        String traceId = this.mAdFeedVideoData.getTraceId();
        CommonVideo video = this.mAdFeedVideoData.getVideoInfo().getVideo();
        if (video == null || (cover = video.getCover()) == null || (e16 = d.e(cover)) == null || (str = e16.getUrl()) == null) {
            str = "";
        }
        if (TextUtils.isEmpty(traceId)) {
            return;
        }
        this.mVideoCoverLoadStateListener = I(aid, traceId, str);
        QZoneAdFeedProSingleVideoWidgetView qZoneAdFeedProSingleVideoWidgetView = this.mVideoItemWidgetView;
        if (qZoneAdFeedProSingleVideoWidgetView != null) {
            qZoneAdFeedProSingleVideoWidgetView.setVideoCoverLoadStateListener(new WeakReference<>(this.mVideoCoverLoadStateListener));
        }
    }

    private final void V() {
        b0();
        if (R()) {
            U();
        }
    }

    private final void d0() {
        if (Q()) {
            e0();
        } else if (R()) {
            f0();
        } else {
            QLog.e(h(), 1, "[updateViews] error, videotype error)");
        }
    }

    private final void e0() {
        ImageView imageView = this.mVideoCoverBlurImageView;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        ImageView imageView2 = this.mVideoCoverBlurImageView;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        QZoneAdFeedProSingleVideoWidgetView qZoneAdFeedProSingleVideoWidgetView = this.mVideoItemWidgetView;
        if ((qZoneAdFeedProSingleVideoWidgetView != null ? qZoneAdFeedProSingleVideoWidgetView.getLayoutParams() : null) instanceof ConstraintLayout.LayoutParams) {
            QZoneAdFeedProSingleVideoWidgetView qZoneAdFeedProSingleVideoWidgetView2 = this.mVideoItemWidgetView;
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) ConstraintLayout.LayoutParams.class.cast(qZoneAdFeedProSingleVideoWidgetView2 != null ? qZoneAdFeedProSingleVideoWidgetView2.getLayoutParams() : null);
            layoutParams.leftToLeft = 0;
            layoutParams.rightToRight = 0;
            QZoneAdFeedProSingleVideoWidgetView qZoneAdFeedProSingleVideoWidgetView3 = this.mVideoItemWidgetView;
            if (qZoneAdFeedProSingleVideoWidgetView3 != null) {
                qZoneAdFeedProSingleVideoWidgetView3.setLayoutParams(layoutParams);
            }
        }
    }

    private final void f0() {
        ImageView imageView = this.mVideoCoverBlurImageView;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        ImageView imageView2 = this.mVideoCoverBlurImageView;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        QZoneAdFeedProSingleVideoWidgetView qZoneAdFeedProSingleVideoWidgetView = this.mVideoItemWidgetView;
        if ((qZoneAdFeedProSingleVideoWidgetView != null ? qZoneAdFeedProSingleVideoWidgetView.getLayoutParams() : null) instanceof ConstraintLayout.LayoutParams) {
            QZoneAdFeedProSingleVideoWidgetView qZoneAdFeedProSingleVideoWidgetView2 = this.mVideoItemWidgetView;
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) ConstraintLayout.LayoutParams.class.cast(qZoneAdFeedProSingleVideoWidgetView2 != null ? qZoneAdFeedProSingleVideoWidgetView2.getLayoutParams() : null);
            ImageView imageView3 = this.mVideoCoverBlurImageView;
            if (imageView3 != null) {
                layoutParams.leftToLeft = imageView3.getId();
                layoutParams.rightToRight = imageView3.getId();
            }
            QZoneAdFeedProSingleVideoWidgetView qZoneAdFeedProSingleVideoWidgetView3 = this.mVideoItemWidgetView;
            if (qZoneAdFeedProSingleVideoWidgetView3 == null) {
                return;
            }
            qZoneAdFeedProSingleVideoWidgetView3.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: K, reason: from getter */
    public final a getMAdFeedVideoData() {
        return this.mAdFeedVideoData;
    }

    /* renamed from: L, reason: from getter */
    public final Bitmap getMVideoCoverBitmap() {
        return this.mVideoCoverBitmap;
    }

    /* renamed from: M, reason: from getter */
    public final Drawable getMVideoCoverBlurDrawable() {
        return this.mVideoCoverBlurDrawable;
    }

    /* renamed from: N, reason: from getter */
    public final ImageView getMVideoCoverBlurImageView() {
        return this.mVideoCoverBlurImageView;
    }

    /* renamed from: O, reason: from getter */
    public final String getMVideoCoverTraceId() {
        return this.mVideoCoverTraceId;
    }

    /* renamed from: P, reason: from getter */
    public final QZoneAdFeedProSingleVideoWidgetView getMVideoItemWidgetView() {
        return this.mVideoItemWidgetView;
    }

    public abstract boolean Q();

    public abstract boolean R();

    public abstract boolean T();

    public abstract void W();

    public final void X(a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mAdFeedVideoData = aVar;
    }

    public final void Y(Bitmap bitmap) {
        this.mVideoCoverBitmap = bitmap;
    }

    public final void Z(Drawable drawable) {
        this.mVideoCoverBlurDrawable = drawable;
    }

    @Override // de.f
    public void a() {
        QZoneAdFeedProSingleVideoWidgetView qZoneAdFeedProSingleVideoWidgetView = this.mVideoItemWidgetView;
        if (qZoneAdFeedProSingleVideoWidgetView != null) {
            qZoneAdFeedProSingleVideoWidgetView.a();
        }
    }

    public final void a0(String str) {
        this.mVideoCoverTraceId = str;
    }

    public void c0() {
        QZoneAdFeedProSingleVideoWidgetView qZoneAdFeedProSingleVideoWidgetView;
        CommonFeed mFeedData = getMFeedData();
        if (mFeedData != null && (qZoneAdFeedProSingleVideoWidgetView = this.mVideoItemWidgetView) != null) {
            qZoneAdFeedProSingleVideoWidgetView.U1(mFeedData, getMPosition(), this.mAdFeedVideoData.getVideoInfo());
        }
        ImageView imageView = this.mVideoCoverBlurImageView;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        QZoneAdFeedProSingleVideoWidgetView qZoneAdFeedProSingleVideoWidgetView2 = this.mVideoItemWidgetView;
        if (qZoneAdFeedProSingleVideoWidgetView2 != null) {
            qZoneAdFeedProSingleVideoWidgetView2.setOnClickListener(this);
        }
        d0();
    }

    @Override // de.f
    public View d() {
        QLog.d(h(), 1, "getVideoItemView   | feedPos = " + getMPosition() + " | view = " + this.mVideoItemWidgetView);
        return this.mVideoItemWidgetView;
    }

    @Override // ne.a
    protected int q() {
        return R.id.nn8;
    }

    @Override // ne.a
    protected boolean u() {
        return false;
    }

    @Override // ne.a
    protected void x(CommonFeed feedData) {
        if (getMFeedData() != null && getMContainerView() != null) {
            if (this.mVideoItemWidgetView != null && this.mVideoCoverBlurImageView != null) {
                View mContainerView = getMContainerView();
                if (mContainerView != null) {
                    mContainerView.setVisibility(0);
                }
                if (T()) {
                    QLog.e(h(), 2, "[onBindData] ignore, is the same ad");
                    return;
                }
                W();
                V();
                c0();
                return;
            }
            QLog.e(h(), 1, "[onBindData] error");
            View mContainerView2 = getMContainerView();
            if (mContainerView2 != null) {
                mContainerView2.setVisibility(8);
            }
            b0();
            return;
        }
        QLog.e(h(), 1, "[onBindData] error, containerView is null");
        b0();
    }

    @Override // ne.a
    protected void z(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.mVideoItemWidgetView = (QZoneAdFeedProSingleVideoWidgetView) containerView.findViewById(R.id.mvr);
        this.mVideoCoverBlurImageView = (ImageView) containerView.findViewById(R.id.mvq);
    }

    private final void b0() {
        this.mVideoCoverLoadStateListener = null;
        QZoneAdFeedProSingleVideoWidgetView qZoneAdFeedProSingleVideoWidgetView = this.mVideoItemWidgetView;
        if (qZoneAdFeedProSingleVideoWidgetView != null) {
            qZoneAdFeedProSingleVideoWidgetView.setVideoCoverLoadStateListener(null);
        }
        this.mVideoCoverTraceId = null;
        this.mVideoCoverBitmap = null;
        this.mVideoCoverBlurDrawable = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Drawable J(Context context, Bitmap srcBitmap) {
        if (context != null && srcBitmap != null) {
            BitmapReference bitmapReference = BitmapReference.getBitmapReference(srcBitmap);
            if (bitmapReference == null) {
                QLog.e(h(), 1, "[createVideoCoverBlurDrawable] error, bitmapReference is null");
                return null;
            }
            Drawable process = new uo.a(25).process(new BitmapRefDrawable(bitmapReference));
            Intrinsics.checkNotNullExpressionValue(process, "blurEffectProcessorDecorator.process(drawable)");
            return process;
        }
        QLog.e(h(), 1, "[createVideoCoverBlurDrawable] error");
        return null;
    }
}
