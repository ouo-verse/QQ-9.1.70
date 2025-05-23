package com.tencent.sqshow.zootopia.samestyle.mix.helper;

import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.videoplatform.VideoPlayerProxy;
import com.tencent.mobileqq.videoplatform.api.IBaseVideoView;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zplan.share.ZPlanShareLaunchParam;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.samestyle.TemplatePreviewViewModel;
import com.tencent.sqshow.zootopia.samestyle.ZPlanVideoClipInfo;
import com.tencent.sqshow.zootopia.samestyle.ZPlanVideoProgressBar;
import com.tencent.sqshow.zootopia.samestyle.mix.helper.PreviewVideoPlayHelper;
import com.tencent.superplayer.api.ISuperPlayer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import n74.dh;

@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\b*\u0001#\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001)B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0004J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\u0006\u0010\u0013\u001a\u00020\u0004R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006*"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/PreviewVideoPlayHelper;", "Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/d;", "", "totalTime", "", "G", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, HippyTKDListViewAdapter.X, "B", "", "time", "u", "w", "k", "l", "E", "D", UserInfo.SEX_FEMALE, "i", "v", "Lsb4/a;", "Lsb4/a;", "previewPage", "J", "mPlayTotalDuration", "Lcom/tencent/mobileqq/videoplatform/api/IBaseVideoView;", "Lcom/tencent/mobileqq/videoplatform/api/IBaseVideoView;", "mVideoPlayView", "Lcom/tencent/superplayer/api/ISuperPlayer;", "Lcom/tencent/superplayer/api/ISuperPlayer;", "mSuperPlayer", "", "H", "Z", "mPauseByLifecycle", "com/tencent/sqshow/zootopia/samestyle/mix/helper/PreviewVideoPlayHelper$c", "I", "Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/PreviewVideoPlayHelper$c;", "mVideoPlayCallback", "<init>", "(Lsb4/a;)V", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PreviewVideoPlayHelper extends d {

    /* renamed from: D, reason: from kotlin metadata */
    private final sb4.a previewPage;

    /* renamed from: E, reason: from kotlin metadata */
    private long mPlayTotalDuration;

    /* renamed from: F, reason: from kotlin metadata */
    private IBaseVideoView mVideoPlayView;

    /* renamed from: G, reason: from kotlin metadata */
    private ISuperPlayer mSuperPlayer;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean mPauseByLifecycle;

    /* renamed from: I, reason: from kotlin metadata */
    private final c mVideoPlayCallback;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/sqshow/zootopia/samestyle/mix/helper/PreviewVideoPlayHelper$b", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanVideoProgressBar$b;", "", "time", "", "c", "b", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements ZPlanVideoProgressBar.b {
        b() {
        }

        @Override // com.tencent.sqshow.zootopia.samestyle.ZPlanVideoProgressBar.b
        public void a(long time) {
            QLog.i("PreviewVideoPlayHelper_", 4, "seek time to " + time);
            PreviewVideoPlayHelper.this.getMViewModel().R1(time);
            PreviewVideoPlayHelper.this.u((int) time);
        }

        @Override // com.tencent.sqshow.zootopia.samestyle.ZPlanVideoProgressBar.b
        public void b(long time) {
            PreviewVideoPlayHelper.this.getMViewModel().R1(time);
        }

        @Override // com.tencent.sqshow.zootopia.samestyle.ZPlanVideoProgressBar.b
        public void c(long time) {
            PreviewVideoPlayHelper.this.getMViewModel().S1(time, false);
        }
    }

    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J0\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J0\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0016\u00a8\u0006\u001d"}, d2 = {"com/tencent/sqshow/zootopia/samestyle/mix/helper/PreviewVideoPlayHelper$c", "Lcom/tencent/mobileqq/videoplatform/api/VideoPlayerCallback;", "", "id", "", "state", "", "onStateChange", "onDownloadComplete", "downSize", "onDownloadProgress", "positionMs", "onPlayProgress", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "", "exInfo", "onPlayError", "", "isSuccess", "width", "height", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "onCapFrame", "onFirstFrameRendered", "position", "onLoopBack", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements VideoPlayerCallback {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(PreviewVideoPlayHelper this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            IBaseVideoView iBaseVideoView = this$0.mVideoPlayView;
            long videoDurationMs = iBaseVideoView != null ? iBaseVideoView.getVideoDurationMs() : 0L;
            if (videoDurationMs <= 0) {
                videoDurationMs = this$0.getMTemplate().getLength();
            }
            this$0.G(videoDurationMs);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(PreviewVideoPlayHelper this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            QQToast.makeText(this$0.getMContext(), 1, "\u89c6\u9891\u64ad\u653e\u5931\u8d25", 0).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(PreviewVideoPlayHelper this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.getMBinding().f419267v.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(PreviewVideoPlayHelper this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.getMBinding().f419267v.setVisibility(0);
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onCapFrame(long id5, boolean isSuccess, int width, int height, Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onFirstFrameRendered(long id5) {
            IBaseVideoView iBaseVideoView = PreviewVideoPlayHelper.this.mVideoPlayView;
            QLog.i("PreviewVideoPlayHelper_", 1, "onVideoFirstFrame, video duration = " + (iBaseVideoView != null ? Long.valueOf(iBaseVideoView.getVideoDurationMs()) : null));
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final PreviewVideoPlayHelper previewVideoPlayHelper = PreviewVideoPlayHelper.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.samestyle.mix.helper.s
                @Override // java.lang.Runnable
                public final void run() {
                    PreviewVideoPlayHelper.c.e(PreviewVideoPlayHelper.this);
                }
            });
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onLoopBack(long id5, long position) {
            QLog.i("PreviewVideoPlayHelper_", 4, "on loopback, position = " + position);
            PreviewVideoPlayHelper.this.getMViewModel().R1(position);
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onPlayError(long id5, int module, int errorType, int errorCode, String exInfo) {
            Intrinsics.checkNotNullParameter(exInfo, "exInfo");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final PreviewVideoPlayHelper previewVideoPlayHelper = PreviewVideoPlayHelper.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.samestyle.mix.helper.r
                @Override // java.lang.Runnable
                public final void run() {
                    PreviewVideoPlayHelper.c.f(PreviewVideoPlayHelper.this);
                }
            });
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onPlayProgress(long id5, long positionMs) {
            QLog.i("PreviewVideoPlayHelper_", 4, "onPlayProgress, postionMs = " + positionMs);
            PreviewVideoPlayHelper.this.getMViewModel().R1(positionMs);
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onStateChange(long id5, int state) {
            QLog.i("PreviewVideoPlayHelper_", 1, "player state change to " + state);
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final PreviewVideoPlayHelper previewVideoPlayHelper = PreviewVideoPlayHelper.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.samestyle.mix.helper.p
                @Override // java.lang.Runnable
                public final void run() {
                    PreviewVideoPlayHelper.c.g(PreviewVideoPlayHelper.this);
                }
            });
            if (state == 4) {
                com.tencent.sqshow.zootopia.utils.b.f373264a.b(PreviewVideoPlayHelper.this.getMContext());
                return;
            }
            if (state != 5) {
                if (state != 6) {
                    if (state == 8) {
                        PreviewVideoPlayHelper.this.getMViewModel().S1(PreviewVideoPlayHelper.this.mPlayTotalDuration, false);
                        return;
                    } else if (state != 9) {
                        return;
                    }
                }
                com.tencent.sqshow.zootopia.utils.b.f373264a.a(PreviewVideoPlayHelper.this.getMContext());
                return;
            }
            Handler uIHandlerV22 = ThreadManagerV2.getUIHandlerV2();
            final PreviewVideoPlayHelper previewVideoPlayHelper2 = PreviewVideoPlayHelper.this;
            uIHandlerV22.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.samestyle.mix.helper.q
                @Override // java.lang.Runnable
                public final void run() {
                    PreviewVideoPlayHelper.c.h(PreviewVideoPlayHelper.this);
                }
            });
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onDownloadComplete(long id5) {
            QLog.d("PreviewVideoPlayHelper_", 1, "videoPlayCallback onDownloadComplete");
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onDownloadProgress(long id5, long downSize) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewVideoPlayHelper(sb4.a previewPage) {
        super(previewPage.getF372926a(), previewPage.getF372927b(), previewPage.getF372928c(), previewPage.getF372929d(), previewPage.b(), previewPage.getLifecycleOwner(), previewPage.getSource());
        Intrinsics.checkNotNullParameter(previewPage, "previewPage");
        this.previewPage = previewPage;
        this.mVideoPlayCallback = new c();
    }

    private final void A() {
        dh mBinding = getMBinding();
        if (mBinding == null) {
            return;
        }
        mBinding.f419268w.setVisibility(0);
        mBinding.f419268w.setSeekListener(new b());
    }

    private final void B() {
        LiveData<TemplatePreviewViewModel.VideoPlayState> N1 = getMViewModel().N1();
        LifecycleOwner mViewLifecycleOwner = getMViewLifecycleOwner();
        final Function1<TemplatePreviewViewModel.VideoPlayState, Unit> function1 = new Function1<TemplatePreviewViewModel.VideoPlayState, Unit>() { // from class: com.tencent.sqshow.zootopia.samestyle.mix.helper.PreviewVideoPlayHelper$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TemplatePreviewViewModel.VideoPlayState videoPlayState) {
                invoke2(videoPlayState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TemplatePreviewViewModel.VideoPlayState videoPlayState) {
                PreviewVideoPlayHelper.this.getMBinding().f419268w.setPlayPosition(videoPlayState.getPlayPositionMs());
                if (videoPlayState.getIsPlay()) {
                    PreviewVideoPlayHelper.this.getMBinding().f419258m.setVisibility(8);
                    PreviewVideoPlayHelper.this.E();
                } else {
                    PreviewVideoPlayHelper.this.getMBinding().f419258m.setVisibility(0);
                    PreviewVideoPlayHelper.this.D();
                }
            }
        };
        N1.observe(mViewLifecycleOwner, new Observer() { // from class: com.tencent.sqshow.zootopia.samestyle.mix.helper.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PreviewVideoPlayHelper.C(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(long totalTime) {
        Long[] lArr;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        this.mPlayTotalDuration = totalTime;
        if (!(!getMTemplate().getVideoClips().isEmpty())) {
            lArr = new Long[0];
        } else if (getMTemplate().getVideoClips().get(0).getStartTime() == 0) {
            List<ZPlanVideoClipInfo> subList = getMTemplate().getVideoClips().subList(1, getMTemplate().getClipCount());
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(subList, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault2);
            Iterator<T> it = subList.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(Math.min(((ZPlanVideoClipInfo) it.next()).getStartTime(), totalTime)));
            }
            Object[] array = arrayList.toArray(new Long[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            lArr = (Long[]) array;
        } else {
            List<ZPlanVideoClipInfo> videoClips = getMTemplate().getVideoClips();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(videoClips, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it5 = videoClips.iterator();
            while (it5.hasNext()) {
                arrayList2.add(Long.valueOf(Math.min(((ZPlanVideoClipInfo) it5.next()).getStartTime(), totalTime)));
            }
            Object[] array2 = arrayList2.toArray(new Long[0]);
            Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            lArr = (Long[]) array2;
        }
        getMBinding().f419268w.setVideoLengthInfo(totalTime, lArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003e A[Catch: Exception -> 0x0070, TryCatch #0 {Exception -> 0x0070, blocks: (B:7:0x0008, B:11:0x001a, B:17:0x002d, B:19:0x0038, B:21:0x003e, B:23:0x004c, B:29:0x0061, B:31:0x006c, B:25:0x005b, B:13:0x0027), top: B:6:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void u(int time) {
        Field field;
        VideoPlayerProxy videoPlayerProxy;
        Field field2;
        IBaseVideoView iBaseVideoView = this.mVideoPlayView;
        if (iBaseVideoView == null) {
            return;
        }
        ISuperPlayer iSuperPlayer = null;
        try {
            Field[] declaredFields = BaseVideoView.class.getDeclaredFields();
            Intrinsics.checkNotNullExpressionValue(declaredFields, "BaseVideoView::class.java.declaredFields");
            int length = declaredFields.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    field = null;
                    break;
                }
                field = declaredFields[i3];
                if (Intrinsics.areEqual(field.getType(), VideoPlayerProxy.class)) {
                    break;
                } else {
                    i3++;
                }
            }
        } catch (Exception e16) {
            QLog.e("PreviewVideoPlayHelper_", 1, e16, "obtain SuperPlayer failed");
        }
        if (field != null) {
            field.setAccessible(true);
            Object obj = field.get(iBaseVideoView);
            if (obj instanceof VideoPlayerProxy) {
                videoPlayerProxy = (VideoPlayerProxy) obj;
                if (videoPlayerProxy != null) {
                    Field[] declaredFields2 = VideoPlayerProxy.class.getDeclaredFields();
                    Intrinsics.checkNotNullExpressionValue(declaredFields2, "VideoPlayerProxy::class.java.declaredFields");
                    int length2 = declaredFields2.length;
                    int i16 = 0;
                    while (true) {
                        if (i16 >= length2) {
                            field2 = null;
                            break;
                        }
                        field2 = declaredFields2[i16];
                        if (Intrinsics.areEqual(field2.getType(), ISuperPlayer.class)) {
                            break;
                        } else {
                            i16++;
                        }
                    }
                    if (field2 != null) {
                        field2.setAccessible(true);
                        Object obj2 = field2.get(videoPlayerProxy);
                        if (obj2 instanceof ISuperPlayer) {
                            iSuperPlayer = (ISuperPlayer) obj2;
                        }
                    }
                }
                if (iSuperPlayer == null) {
                    iSuperPlayer.seekTo(time, 3);
                } else {
                    iBaseVideoView.seekTo(time);
                }
                getMViewModel().P1();
            }
        }
        videoPlayerProxy = null;
        if (videoPlayerProxy != null) {
        }
        if (iSuperPlayer == null) {
        }
        getMViewModel().P1();
    }

    private final void x() {
        VideoPlayParam videoPlayParam = new VideoPlayParam();
        videoPlayParam.mIsLoop = false;
        videoPlayParam.mIsLocal = false;
        videoPlayParam.mIsMute = false;
        videoPlayParam.mVideoFormat = 101;
        videoPlayParam.mNeedPlayProgress = true;
        TemplatePreviewViewModel.VideoPlayState value = getMViewModel().N1().getValue();
        videoPlayParam.mStartPlayPosMs = value != null ? value.getPlayPositionMs() : 0L;
        videoPlayParam.mSceneId = 126;
        videoPlayParam.mUrls = new String[]{getMTemplate().getPreviewUrl()};
        videoPlayParam.mCallback = this.mVideoPlayCallback;
        IBaseVideoView createBaseVideoView = QQVideoViewFactory.createBaseVideoView(getMContext(), 126L, null, null);
        Intrinsics.checkNotNull(createBaseVideoView, "null cannot be cast to non-null type com.tencent.mobileqq.videoplatform.view.BaseVideoView");
        BaseVideoView baseVideoView = (BaseVideoView) createBaseVideoView;
        this.mVideoPlayView = baseVideoView;
        if (baseVideoView != null) {
            baseVideoView.setVideoParam(videoPlayParam);
        }
        IBaseVideoView iBaseVideoView = this.mVideoPlayView;
        final BaseVideoView baseVideoView2 = iBaseVideoView instanceof BaseVideoView ? (BaseVideoView) iBaseVideoView : null;
        if (baseVideoView2 == null) {
            return;
        }
        baseVideoView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.samestyle.mix.helper.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PreviewVideoPlayHelper.y(BaseVideoView.this, this, view);
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        getMBinding().f419260o.addView(baseVideoView2, layoutParams);
        getMBinding().f419258m.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.samestyle.mix.helper.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PreviewVideoPlayHelper.z(PreviewVideoPlayHelper.this, view);
            }
        });
        FrameLayout frameLayout = getMBinding().f419260o;
        if (frameLayout == null) {
            return;
        }
        id3.d mReporter = getMReporter();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(ZPlanShareLaunchParam.KEY_BIZ_SAMESTYLE_ID, Integer.valueOf(getMTemplate().getId()));
        Unit unit = Unit.INSTANCE;
        id3.d.h(mReporter, frameLayout, "em_zplan_samestyle_preview_content", linkedHashMap, false, false, null, 56, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(BaseVideoView videoView, PreviewVideoPlayHelper this$0, View view) {
        Intrinsics.checkNotNullParameter(videoView, "$videoView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (videoView.isPlaying()) {
            this$0.getMViewModel().O1();
        } else {
            this$0.getMViewModel().P1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(PreviewVideoPlayHelper this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getMViewModel().P1();
    }

    public final void D() {
        IBaseVideoView iBaseVideoView;
        getMBinding().f419268w.f();
        IBaseVideoView iBaseVideoView2 = this.mVideoPlayView;
        boolean z16 = false;
        if (iBaseVideoView2 != null && iBaseVideoView2.isPlaying()) {
            z16 = true;
        }
        if (!z16 || (iBaseVideoView = this.mVideoPlayView) == null) {
            return;
        }
        iBaseVideoView.pause();
    }

    public final void E() {
        IBaseVideoView iBaseVideoView;
        getMBinding().f419268w.g();
        IBaseVideoView iBaseVideoView2 = this.mVideoPlayView;
        boolean z16 = false;
        if (iBaseVideoView2 != null && !iBaseVideoView2.isPlaying()) {
            z16 = true;
        }
        if (!z16 || (iBaseVideoView = this.mVideoPlayView) == null) {
            return;
        }
        iBaseVideoView.play();
    }

    public final void F() {
        IBaseVideoView iBaseVideoView = this.mVideoPlayView;
        boolean z16 = false;
        if (iBaseVideoView != null && iBaseVideoView.isPlaying()) {
            z16 = true;
        }
        if (z16) {
            IBaseVideoView iBaseVideoView2 = this.mVideoPlayView;
            if (iBaseVideoView2 != null) {
                iBaseVideoView2.pause();
            }
            ISuperPlayer iSuperPlayer = this.mSuperPlayer;
            if (iSuperPlayer != null) {
                iSuperPlayer.pause();
            }
        }
    }

    @Override // com.tencent.sqshow.zootopia.samestyle.mix.helper.d
    public void i() {
        super.i();
        IBaseVideoView iBaseVideoView = this.mVideoPlayView;
        if (iBaseVideoView != null) {
            iBaseVideoView.pause();
        }
        ISuperPlayer iSuperPlayer = this.mSuperPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.release();
        }
    }

    @Override // com.tencent.sqshow.zootopia.samestyle.mix.helper.d
    public void k() {
        IBaseVideoView iBaseVideoView = this.mVideoPlayView;
        boolean isPlaying = iBaseVideoView != null ? iBaseVideoView.isPlaying() : false;
        QLog.i("PreviewVideoPlayHelper_", 1, "onPause isPlaying:" + isPlaying);
        if (isPlaying) {
            this.mPauseByLifecycle = true;
        }
        getMViewModel().O1();
    }

    @Override // com.tencent.sqshow.zootopia.samestyle.mix.helper.d
    public void l() {
        boolean z16 = this.mPauseByLifecycle;
        IBaseVideoView iBaseVideoView = this.mVideoPlayView;
        QLog.i("PreviewVideoPlayHelper_", 1, "onResume mPauseByLifecycle:" + z16 + ", isPlaying:" + (iBaseVideoView != null ? Boolean.valueOf(iBaseVideoView.isPlaying()) : null));
        if (this.mPauseByLifecycle) {
            this.mPauseByLifecycle = false;
            getMViewModel().P1();
        }
    }

    public final void v() {
        getMViewModel().O1();
        getMBinding().f419258m.setVisibility(8);
        getMBinding().f419268w.f();
        F();
        getMBinding().f419268w.setVisibility(8);
    }

    public void w() {
        A();
        x();
        B();
    }
}
