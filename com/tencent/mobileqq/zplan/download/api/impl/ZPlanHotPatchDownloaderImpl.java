package com.tencent.mobileqq.zplan.download.api.impl;

import ah3.g;
import ah3.h;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.download.hotpatch.ZPlanUEHotPatchManager;
import com.tencent.mobileqq.zplan.download.api.IZPlanHotPatchDownloader;
import com.tencent.mobileqq.zplan.download.api.impl.ZPlanHotPatchDownloaderImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.resource.api.ZPlanSceneResourceErrType;
import cy4.ZPlanResourceBusinessData;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J \u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0014\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u001c\u0010\u0017\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/zplan/download/api/impl/ZPlanHotPatchDownloaderImpl;", "Lcom/tencent/mobileqq/zplan/download/api/IZPlanHotPatchDownloader;", "Landroid/content/Context;", "context", "Lah3/g;", "dialog", "", "lastSource", "Lcom/tencent/mobileqq/zplan/download/api/IZPlanHotPatchDownloader$a;", "cb", "", "continueDownload", "source", "checkHotPatch", "I", "", FavEmoConstant.ROAMING_TYPE_PANEL, "Z", "Lcom/tencent/mobileqq/widget/QQToast;", "kotlin.jvm.PlatformType", "completeToast", "Lcom/tencent/mobileqq/widget/QQToast;", "failureToast", "serverToast", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanHotPatchDownloaderImpl implements IZPlanHotPatchDownloader {
    public static final String TAG = "ZPlanHotPatchDownloaderImpl";
    private int lastSource;
    private boolean needDownload;
    private final QQToast completeToast = QQToast.makeText(BaseApplication.getContext(), 2, "\u8d85\u7ea7QQ\u79c0\u8d44\u6e90\u66f4\u65b0\u5b8c\u6210", 0);
    private final QQToast failureToast = QQToast.makeText(BaseApplication.getContext(), 1, "\u4e0b\u8f7d\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5", 0);
    private final QQToast serverToast = QQToast.makeText(BaseApplication.getContext(), "\u6b63\u5728\u540e\u53f0\u4e3a\u4f60\u4e0b\u8f7d", 0);

    /* JADX INFO: Access modifiers changed from: private */
    public final void continueDownload(Context context, g dialog, int lastSource, IZPlanHotPatchDownloader.a cb5) {
        ZPlanUEHotPatchManager.f328056a.g(new c(context, dialog, this, cb5, lastSource));
    }

    /* JADX WARN: Type inference failed for: r11v3, types: [ah3.g, T, java.lang.Object, android.app.Dialog] */
    @Override // com.tencent.mobileqq.zplan.download.api.IZPlanHotPatchDownloader
    public void checkHotPatch(Context context, int source, IZPlanHotPatchDownloader.a cb5) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        WeakReference weakReference = new WeakReference(context);
        this.lastSource = source;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (ZPlanUEHotPatchManager.f328056a.g(new b(weakReference, this, source, objectRef, cb5))) {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (activity.isFinishing() || activity.isDestroyed()) {
                    QLog.e(TAG, 1, "context isDestroyed ");
                    return;
                }
            }
            ?? gVar = new g(context);
            objectRef.element = gVar;
            Intrinsics.checkNotNull(gVar);
            gVar.show();
            QLog.d(TAG, 1, "isDownloading");
        }
    }

    @Metadata(d1 = {"\u0000I\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J2\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\u001a\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016\u00a8\u0006\u001b"}, d2 = {"com/tencent/mobileqq/zplan/download/api/impl/ZPlanHotPatchDownloaderImpl$b", "Lcom/tencent/mobileqq/zootopia/download/hotpatch/a;", "", "needDownloadSize", "Lvj3/c;", "resultCallback", "", "b", "e", "", "progress", "", "totalTaskCount", "completedTaskCount", "f", "Lcom/tencent/zplan/resource/api/ZPlanSceneResourceErrType;", ImageTaskConst.ERROR_TYPE, "errorCode", "", "errorMessage", "failedTaskCount", "d", "Lcy4/b;", OpenHippyInfo.EXTRA_KEY_BUSINESS_DATA, "Lcy4/c;", "statisticData", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.download.hotpatch.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference<Context> f332770a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ZPlanHotPatchDownloaderImpl f332771b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f332772c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<g> f332773d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IZPlanHotPatchDownloader.a f332774e;

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/zplan/download/api/impl/ZPlanHotPatchDownloaderImpl$b$a", "Lah3/h;", "", "a", "onClickPause", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes35.dex */
        public static final class a implements h {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ g f332775a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ vj3.c f332776b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ ZPlanHotPatchDownloaderImpl f332777c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Context f332778d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ IZPlanHotPatchDownloader.a f332779e;

            a(g gVar, vj3.c cVar, ZPlanHotPatchDownloaderImpl zPlanHotPatchDownloaderImpl, Context context, IZPlanHotPatchDownloader.a aVar) {
                this.f332775a = gVar;
                this.f332776b = cVar;
                this.f332777c = zPlanHotPatchDownloaderImpl;
                this.f332778d = context;
                this.f332779e = aVar;
            }

            @Override // ah3.h
            public void a() {
                if (this.f332775a.getDownloadCount() == 1) {
                    this.f332776b.a(true);
                    QLog.d(ZPlanHotPatchDownloaderImpl.TAG, 1, "confirmResult: true");
                } else {
                    ZPlanHotPatchDownloaderImpl zPlanHotPatchDownloaderImpl = this.f332777c;
                    zPlanHotPatchDownloaderImpl.continueDownload(this.f332778d, this.f332775a, zPlanHotPatchDownloaderImpl.lastSource, this.f332779e);
                    QLog.d(ZPlanHotPatchDownloaderImpl.TAG, 1, "continueDownload");
                }
            }

            @Override // ah3.h
            public void onClickPause() {
                ZPlanUEHotPatchManager.f328056a.f();
                QLog.d(ZPlanHotPatchDownloaderImpl.TAG, 1, "onClickPause");
            }
        }

        b(WeakReference<Context> weakReference, ZPlanHotPatchDownloaderImpl zPlanHotPatchDownloaderImpl, int i3, Ref.ObjectRef<g> objectRef, IZPlanHotPatchDownloader.a aVar) {
            this.f332770a = weakReference;
            this.f332771b = zPlanHotPatchDownloaderImpl;
            this.f332772c = i3;
            this.f332773d = objectRef;
            this.f332774e = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [ah3.g, T, android.app.Dialog] */
        public static final void k(final ZPlanHotPatchDownloaderImpl this$0, Context context, int i3, Ref.ObjectRef downloadDialog, final vj3.c resultCallback, IZPlanHotPatchDownloader.a cb5) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(downloadDialog, "$downloadDialog");
            Intrinsics.checkNotNullParameter(resultCallback, "$resultCallback");
            Intrinsics.checkNotNullParameter(cb5, "$cb");
            this$0.needDownload = true;
            final ?? gVar = new g(context);
            gVar.show();
            ch3.b.f30847a.d(gVar, i3);
            gVar.n(new a(gVar, resultCallback, this$0, context, cb5));
            gVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.zplan.download.api.impl.d
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    ZPlanHotPatchDownloaderImpl.b.l(g.this, this$0, resultCallback, dialogInterface);
                }
            });
            downloadDialog.element = gVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void l(final g dialog, final ZPlanHotPatchDownloaderImpl this$0, vj3.c resultCallback, DialogInterface dialogInterface) {
            Intrinsics.checkNotNullParameter(dialog, "$dialog");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(resultCallback, "$resultCallback");
            if (dialog.getIsDownloading()) {
                this$0.serverToast.show();
                ch3.b.f30847a.h(dialog);
                QLog.d(ZPlanHotPatchDownloaderImpl.TAG, 1, "downloading in the background");
                ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.zplan.download.api.impl.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZPlanHotPatchDownloaderImpl.b.m(ZPlanHotPatchDownloaderImpl.this, dialog);
                    }
                }, 16, null, true, 3000L);
                return;
            }
            if (dialog.getIsPaused()) {
                ZPlanUEHotPatchManager.f328056a.f();
                QLog.d(ZPlanHotPatchDownloaderImpl.TAG, 1, "isPaused, cancel download");
            } else {
                resultCallback.a(false);
                QLog.d(ZPlanHotPatchDownloaderImpl.TAG, 1, "cancel download");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(ZPlanHotPatchDownloaderImpl this$0, g dialog) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(dialog, "$dialog");
            if (this$0.serverToast.isShowing()) {
                return;
            }
            ch3.b.f30847a.i(dialog);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(ZPlanHotPatchDownloaderImpl this$0, g gVar) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!this$0.needDownload || this$0.completeToast.isShowing()) {
                return;
            }
            ch3.b.f30847a.c(gVar);
        }

        @Override // com.tencent.mobileqq.zootopia.download.hotpatch.a
        public void b(long needDownloadSize, final vj3.c resultCallback) {
            Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
            final Context context = this.f332770a.get();
            if (context == null) {
                return;
            }
            QLog.d(ZPlanHotPatchDownloaderImpl.TAG, 1, "needDownloadCheck, needDownloadSize:" + needDownloadSize + ", context:" + context);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (activity.isFinishing() || activity.isDestroyed()) {
                    resultCallback.a(false);
                    QLog.e(ZPlanHotPatchDownloaderImpl.TAG, 1, "context isDestroyed ");
                    return;
                }
            }
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final ZPlanHotPatchDownloaderImpl zPlanHotPatchDownloaderImpl = this.f332771b;
            final int i3 = this.f332772c;
            final Ref.ObjectRef<g> objectRef = this.f332773d;
            final IZPlanHotPatchDownloader.a aVar = this.f332774e;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.download.api.impl.c
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanHotPatchDownloaderImpl.b.k(ZPlanHotPatchDownloaderImpl.this, context, i3, objectRef, resultCallback, aVar);
                }
            });
        }

        @Override // com.tencent.zplan.resource.api.a
        public void c(ZPlanResourceBusinessData businessData, cy4.c statisticData) {
            Intrinsics.checkNotNullParameter(businessData, "businessData");
            Context context = this.f332770a.get();
            if (context == null) {
                return;
            }
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null && (activity.isFinishing() || activity.isDestroyed())) {
                QLog.e(ZPlanHotPatchDownloaderImpl.TAG, 1, "context isDestroyed onDownloadSuccess");
                return;
            }
            final g gVar = this.f332773d.element;
            if (gVar != null) {
                try {
                    if (gVar.isShowing()) {
                        gVar.dismiss();
                    }
                } catch (Exception e16) {
                    QLog.e(ZPlanHotPatchDownloaderImpl.TAG, 1, String.valueOf(e16));
                }
            }
            if (this.f332771b.needDownload) {
                this.f332771b.completeToast.show();
                ch3.b.f30847a.b(gVar);
                this.f332771b.needDownload = !r1.needDownload;
                final ZPlanHotPatchDownloaderImpl zPlanHotPatchDownloaderImpl = this.f332771b;
                ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.zplan.download.api.impl.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZPlanHotPatchDownloaderImpl.b.n(ZPlanHotPatchDownloaderImpl.this, gVar);
                    }
                }, 16, null, true, 3000L);
            }
            this.f332774e.a(this.f332771b.lastSource, true);
            if (gVar != null) {
                gVar.p(false);
            }
            QLog.d(ZPlanHotPatchDownloaderImpl.TAG, 1, "onDownloadSuccess");
        }

        @Override // com.tencent.zplan.resource.api.a
        public void d(ZPlanSceneResourceErrType errType, int errorCode, String errorMessage, int totalTaskCount, int failedTaskCount) {
            g gVar;
            Intrinsics.checkNotNullParameter(errType, "errType");
            this.f332771b.failureToast.show();
            this.f332774e.a(this.f332771b.lastSource, false);
            g gVar2 = this.f332773d.element;
            if ((gVar2 != null && gVar2.isShowing()) && (gVar = this.f332773d.element) != null) {
                gVar.l();
            }
            QLog.d(ZPlanHotPatchDownloaderImpl.TAG, 1, "onDownloadError: ", errorMessage);
        }

        @Override // com.tencent.zplan.resource.api.a
        public void f(float progress, int totalTaskCount, int completedTaskCount) {
            g gVar = this.f332773d.element;
            if (gVar != null) {
                gVar.v(progress);
            }
        }

        @Override // com.tencent.mobileqq.zootopia.download.hotpatch.a
        public void e() {
        }
    }

    @Metadata(d1 = {"\u0000G\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J2\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u001a\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J \u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000bH\u0016\u00a8\u0006\u001b"}, d2 = {"com/tencent/mobileqq/zplan/download/api/impl/ZPlanHotPatchDownloaderImpl$c", "Lcom/tencent/mobileqq/zootopia/download/hotpatch/a;", "", "needDownloadSize", "Lvj3/c;", "resultCallback", "", "b", "e", "Lcom/tencent/zplan/resource/api/ZPlanSceneResourceErrType;", ImageTaskConst.ERROR_TYPE, "", "errorCode", "", "errorMessage", "totalTaskCount", "failedTaskCount", "d", "Lcy4/b;", OpenHippyInfo.EXTRA_KEY_BUSINESS_DATA, "Lcy4/c;", "statisticData", "c", "", "progress", "completedTaskCount", "f", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.download.hotpatch.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f332780a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f332781b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ZPlanHotPatchDownloaderImpl f332782c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IZPlanHotPatchDownloader.a f332783d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f332784e;

        c(Context context, g gVar, ZPlanHotPatchDownloaderImpl zPlanHotPatchDownloaderImpl, IZPlanHotPatchDownloader.a aVar, int i3) {
            this.f332780a = context;
            this.f332781b = gVar;
            this.f332782c = zPlanHotPatchDownloaderImpl;
            this.f332783d = aVar;
            this.f332784e = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(ZPlanHotPatchDownloaderImpl this$0, g dialog) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(dialog, "$dialog");
            if (this$0.completeToast.isShowing()) {
                return;
            }
            ch3.b.f30847a.c(dialog);
        }

        @Override // com.tencent.mobileqq.zootopia.download.hotpatch.a
        public void b(long needDownloadSize, vj3.c resultCallback) {
            Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
            Context context = this.f332780a;
            if (context instanceof Activity) {
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                Activity activity = (Activity) context;
                if (activity.isFinishing() || activity.isDestroyed()) {
                    resultCallback.a(false);
                    QLog.e(ZPlanHotPatchDownloaderImpl.TAG, 1, "context isDestroyed ");
                    return;
                }
            }
            if (this.f332781b.getCanDownload()) {
                resultCallback.a(true);
                QLog.d(ZPlanHotPatchDownloaderImpl.TAG, 1, "continueDownload confirmResult true");
            }
        }

        @Override // com.tencent.zplan.resource.api.a
        public void c(ZPlanResourceBusinessData businessData, cy4.c statisticData) {
            Intrinsics.checkNotNullParameter(businessData, "businessData");
            Context context = this.f332780a;
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null && (activity.isFinishing() || activity.isDestroyed())) {
                QLog.e(ZPlanHotPatchDownloaderImpl.TAG, 1, "context isDestroyed onDownloadSuccess");
                return;
            }
            if (this.f332781b.isShowing()) {
                this.f332781b.dismiss();
            }
            if (this.f332782c.needDownload) {
                this.f332782c.completeToast.show();
                ch3.b.f30847a.b(this.f332781b);
                this.f332782c.needDownload = !r9.needDownload;
                final ZPlanHotPatchDownloaderImpl zPlanHotPatchDownloaderImpl = this.f332782c;
                final g gVar = this.f332781b;
                ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.zplan.download.api.impl.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZPlanHotPatchDownloaderImpl.c.h(ZPlanHotPatchDownloaderImpl.this, gVar);
                    }
                }, 16, null, true, 3000L);
            }
            this.f332783d.a(this.f332784e, true);
            this.f332781b.p(false);
            QLog.d(ZPlanHotPatchDownloaderImpl.TAG, 1, "continueDownload onDownloadSuccess");
        }

        @Override // com.tencent.zplan.resource.api.a
        public void d(ZPlanSceneResourceErrType errType, int errorCode, String errorMessage, int totalTaskCount, int failedTaskCount) {
            Intrinsics.checkNotNullParameter(errType, "errType");
            this.f332782c.failureToast.show();
            this.f332783d.a(this.f332784e, false);
            if (this.f332781b.isShowing()) {
                this.f332781b.l();
            }
            QLog.d(ZPlanHotPatchDownloaderImpl.TAG, 1, "continueDownload onDownloadError: ", errorMessage);
        }

        @Override // com.tencent.zplan.resource.api.a
        public void f(float progress, int totalTaskCount, int completedTaskCount) {
            this.f332781b.v(progress);
        }

        @Override // com.tencent.mobileqq.zootopia.download.hotpatch.a
        public void e() {
        }
    }
}
