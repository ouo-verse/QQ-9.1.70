package com.tencent.mobileqq.qqvideoedit.zplan.export;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.zootopia.service.api.IZootopiaTextSecurityService;
import com.tencent.qphone.base.util.QLog;
import ik2.GifClipData;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0010BC\u0012\b\u0010.\u001a\u0004\u0018\u00010-\u0012\u0006\u00100\u001a\u00020/\u0012\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0012\u0012\u0012\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u0016\u00a2\u0006\u0004\b1\u00102J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0016J\u001c\u0010\u000f\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016R\"\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R \u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0004\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0014\u0010!\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R#\u0010,\u001a\n '*\u0004\u0018\u00010&0&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/zplan/export/VideoEditTextGifExportTask;", "Lcom/tencent/mobileqq/qqvideoedit/zplan/export/b;", "", "isTextValid", "isExportSuccess", "", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, ReportConstant.COSTREPORT_PREFIX, DomainData.DOMAIN_NAME, "d", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", QAdVrReportParams.ParamKey.MEDIA, "Lik2/d;", "clipData", "c", "a", "b", "Lkotlin/Function1;", "f", "Lkotlin/jvm/functions/Function1;", "showGifProgress", "Lkotlin/Function0;", "", "", "g", "Lkotlin/jvm/functions/Function0;", "getVideoTextList", "Ljava/util/concurrent/atomic/AtomicBoolean;", h.F, "Ljava/util/concurrent/atomic/AtomicBoolean;", "i", "j", "isExportCanceled", "Ljava/util/concurrent/CountDownLatch;", "k", "Ljava/util/concurrent/CountDownLatch;", "latch", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "kotlin.jvm.PlatformType", "l", "Lkotlin/Lazy;", "o", "()Lcom/tencent/mobileqq/utils/QQCustomDialog;", "dialog", "Landroid/content/Context;", "context", "Lik2/h;", "callback", "<init>", "(Landroid/content/Context;Lik2/h;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class VideoEditTextGifExportTask extends b {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<Boolean, Unit> showGifProgress;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<List<String>> getVideoTextList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean isTextValid;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean isExportSuccess;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean isExportCanceled;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CountDownLatch latch;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy dialog;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public VideoEditTextGifExportTask(@Nullable Context context, @NotNull ik2.h callback, @NotNull Function1<? super Boolean, Unit> showGifProgress, @NotNull Function0<? extends List<String>> getVideoTextList) {
        super(context, callback);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(showGifProgress, "showGifProgress");
        Intrinsics.checkNotNullParameter(getVideoTextList, "getVideoTextList");
        this.showGifProgress = showGifProgress;
        this.getVideoTextList = getVideoTextList;
        this.isTextValid = new AtomicBoolean(false);
        this.isExportSuccess = new AtomicBoolean(false);
        this.isExportCanceled = new AtomicBoolean(false);
        this.latch = new CountDownLatch(2);
        lazy = LazyKt__LazyJVMKt.lazy(new VideoEditTextGifExportTask$dialog$2(context));
        this.dialog = lazy;
    }

    private final void m() {
        boolean z16;
        try {
            QLog.i("VideoEditTextGifExportTask", 1, "start awaitLatch.");
            if (!this.latch.await(45L, TimeUnit.SECONDS)) {
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.i("VideoEditTextGifExportTask", 1, "stop awaitLatch: isTimeout=" + z16);
        } catch (InterruptedException e16) {
            QLog.e("VideoEditTextGifExportTask", 1, "awaitLatch InterruptedException: " + e16.getMessage());
        }
    }

    private final void n() {
        LocalMediaInfo exportedVideo = getExportedVideo();
        if (exportedVideo != null) {
            FileUtils.deleteFile(exportedVideo.path);
        }
    }

    private final QQCustomDialog o() {
        return (QQCustomDialog) this.dialog.getValue();
    }

    private final void p(boolean isTextValid, boolean isExportSuccess) {
        QLog.i("VideoEditTextGifExportTask", 4, "onResultReceived: isTextValid=" + isTextValid + ", isExportSuccess=" + isExportSuccess);
        if (isTextValid) {
            if (isExportSuccess) {
                h();
            }
        } else {
            this.showGifProgress.invoke(Boolean.FALSE);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.zplan.export.d
                @Override // java.lang.Runnable
                public final void run() {
                    VideoEditTextGifExportTask.q(VideoEditTextGifExportTask.this);
                }
            });
            if (isExportSuccess) {
                n();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(VideoEditTextGifExportTask this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(VideoEditTextGifExportTask this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m();
        if (this$0.isExportCanceled.get()) {
            QLog.i("VideoEditTextGifExportTask", 1, "await latch finished, but export is canceled.");
        } else {
            this$0.p(this$0.isTextValid.get(), this$0.isExportSuccess.get());
        }
    }

    private final void s() {
        for (int i3 = 0; i3 < 2; i3++) {
            this.latch.countDown();
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.zplan.export.b, com.tencent.mobileqq.qqvideoedit.zplan.export.a
    public void a() {
        this.isExportSuccess.set(false);
        this.latch.countDown();
    }

    @Override // com.tencent.mobileqq.qqvideoedit.zplan.export.b, com.tencent.mobileqq.qqvideoedit.zplan.export.a
    public void b() {
        this.isExportCanceled.set(true);
        s();
    }

    @Override // com.tencent.mobileqq.qqvideoedit.zplan.export.b, com.tencent.mobileqq.qqvideoedit.zplan.export.a
    public void c(@Nullable LocalMediaInfo media, @Nullable GifClipData clipData) {
        this.isExportSuccess.set(true);
        g(media);
        f(clipData);
        this.latch.countDown();
        if (this.isExportCanceled.get()) {
            QLog.w("VideoEditTextGifExportTask", 1, "onVideoExportSuccess, but export is canceled.");
        } else {
            this.showGifProgress.invoke(Boolean.TRUE);
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.zplan.export.b, com.tencent.mobileqq.qqvideoedit.zplan.export.a
    public void d() {
        AppInterface appInterface = null;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.zplan.export.c
            @Override // java.lang.Runnable
            public final void run() {
                VideoEditTextGifExportTask.r(VideoEditTextGifExportTask.this);
            }
        }, 16, null, true);
        AppRuntime appRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("peak");
        if (appRuntime instanceof AppInterface) {
            appInterface = (AppInterface) appRuntime;
        }
        ((IZootopiaTextSecurityService) QRoute.api(IZootopiaTextSecurityService.class)).checkTextSecurity(appInterface, this.getVideoTextList.invoke(), new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qqvideoedit.zplan.export.VideoEditTextGifExportTask$onVideoExportStart$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                AtomicBoolean atomicBoolean;
                CountDownLatch countDownLatch;
                QLog.i("VideoEditTextGifExportTask", 1, "checkTextSecurity result: " + z16);
                atomicBoolean = VideoEditTextGifExportTask.this.isTextValid;
                atomicBoolean.set(z16);
                countDownLatch = VideoEditTextGifExportTask.this.latch;
                countDownLatch.countDown();
            }
        });
    }
}
