package com.tencent.mobileqq.onlinestatus.view.zplan;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.aelight.camera.filament.api.BaseZShowFilamentPreviewView;
import com.tencent.aelight.camera.filament.api.IZShowFilamentPreviewProvider;
import com.tencent.ams.dsdk.view.webview.DKWebViewController;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.onlinestatus.view.zplan.AvatarStatusFilamentView;
import com.tencent.mobileqq.onlinestatus.view.zplan.j;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 52\u00020\u0001:\u0003\u0016\u001d\u001fB\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0018\u00a2\u0006\u0004\b9\u0010:J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0016JX\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000726\u0010\u0015\u001a2\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0016R\u0017\u0010\u001c\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010 R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010,\u001a\u00020\u00078\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001d\u00102\u001a\u0004\u0018\u00010-8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R$\u00108\u001a\u0004\u0018\u0001038\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b0\u00104\u001a\u0004\b5\u00106\"\u0004\b\u001d\u00107\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusFilamentView;", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/j;", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusFilamentView$c;", "loadParam", "", "uin", "baseResPath", "", "k", "Landroid/view/View;", "getView", "Lcom/tencent/mobileqq/onlinestatus/model/b;", "res", DKWebViewController.DKHippyWebviewFunction.RELOAD, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "success", "", "error", "", "callback", "a", "release", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "b", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusFilamentView$c;", "c", "Ljava/lang/String;", "loadedUin", "d", "loadedBaseRes", "e", "loadedActionRes", "Landroid/os/Handler;", "f", "Landroid/os/Handler;", "uiHandler", "g", "Z", "notifyAtFirstFrame", "Lcom/tencent/aelight/camera/filament/api/BaseZShowFilamentPreviewView;", tl.h.F, "Lkotlin/Lazy;", "i", "()Lcom/tencent/aelight/camera/filament/api/BaseZShowFilamentPreviewView;", "filamentView", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/j$a;", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/j$a;", "j", "()Lcom/tencent/mobileqq/onlinestatus/view/zplan/j$a;", "(Lcom/tencent/mobileqq/onlinestatus/view/zplan/j$a;)V", "listener", "<init>", "(Landroid/content/Context;)V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class AvatarStatusFilamentView implements j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c loadParam;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String loadedUin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String loadedBaseRes;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String loadedActionRes;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Handler uiHandler;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final boolean notifyAtFirstFrame;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy filamentView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private j.a listener;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\"\u0010\r\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusFilamentView$b;", "Lcom/tencent/aelight/camera/filament/api/BaseZShowFilamentPreviewView$a;", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "", "a", "errorCode", "c", "", "moodPath", "b", "Landroid/graphics/Bitmap;", "snapshot", "d", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusFilamentView$c;", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusFilamentView$c;", "getParam", "()Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusFilamentView$c;", "param", "<init>", "(Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusFilamentView;Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusFilamentView$c;)V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public final class b implements BaseZShowFilamentPreviewView.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final c param;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AvatarStatusFilamentView f256757b;

        public b(@NotNull AvatarStatusFilamentView avatarStatusFilamentView, c param) {
            Intrinsics.checkNotNullParameter(param, "param");
            this.f256757b = avatarStatusFilamentView;
            this.param = param;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(AvatarStatusFilamentView this$0, b this$1, String moodPath, int i3, Bitmap bitmap) {
            j.a listener;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(moodPath, "$moodPath");
            c cVar = this$0.loadParam;
            c cVar2 = this$1.param;
            boolean z16 = true;
            if (cVar != cVar2) {
                QLog.i("AvatarStatus.FilamentView", 1, "[onChangeMoodSnapshot] load param changed, " + cVar2 + "->" + this$0.loadParam);
                return;
            }
            if (!Intrinsics.areEqual(cVar2.getResource().getAction(), moodPath)) {
                QLog.i("AvatarStatus.FilamentView", 1, "[onChangeMoodSnapshot] mood path changed, param=" + this$1.param + " moodPath=" + moodPath);
                return;
            }
            QLog.i("AvatarStatus.FilamentView", 1, "[onChangeMoodSnapshot] param=" + this$1.param + ", errorCode=" + i3 + " moodPath=" + moodPath + " snapshot=" + bitmap);
            if (this$0.notifyAtFirstFrame) {
                c cVar3 = this$1.param;
                if (i3 != 0) {
                    z16 = false;
                }
                cVar3.d(z16, i3);
            }
            if (bitmap != null && (listener = this$0.getListener()) != null) {
                listener.a(this$1.param.getUin(), this$1.param.getResource(), bitmap);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(AvatarStatusFilamentView this$0, b this$1, int i3, int i16) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            c cVar = this$0.loadParam;
            c cVar2 = this$1.param;
            if (cVar == cVar2 && cVar2.getRequestId() == i3) {
                QLog.i("AvatarStatus.FilamentView", 1, "[onLoadFail] error-code=" + i16);
                this$1.param.d(false, i16);
                return;
            }
            QLog.i("AvatarStatus.FilamentView", 1, "[onLoadFail] load param changed, " + this$1.param + "->" + this$0.loadParam + ", requestId=" + i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(AvatarStatusFilamentView this$0, b this$1, String moodPath, int i3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(moodPath, "$moodPath");
            c cVar = this$0.loadParam;
            c cVar2 = this$1.param;
            boolean z16 = true;
            if (cVar != cVar2) {
                QLog.i("AvatarStatus.FilamentView", 1, "[onSetMoodSucc] load param changed, " + cVar2 + "->" + this$0.loadParam);
                return;
            }
            if (!Intrinsics.areEqual(cVar2.getResource().getAction(), moodPath)) {
                QLog.i("AvatarStatus.FilamentView", 1, "[onSetMoodSucc] mood path changed, param=" + this$1.param + " moodPath=" + moodPath);
                return;
            }
            QLog.i("AvatarStatus.FilamentView", 1, "[onSetMoodSucc] errorCode=" + i3 + ", moodPath=" + moodPath);
            if (i3 == 0) {
                this$0.loadedActionRes = this$1.param.getResource().getAction();
            }
            if (this$0.notifyAtFirstFrame) {
                if (i3 != 0) {
                    this$1.param.d(false, i3);
                }
            } else {
                c cVar3 = this$1.param;
                if (i3 != 0) {
                    z16 = false;
                }
                cVar3.d(z16, i3);
            }
        }

        @Override // com.tencent.aelight.camera.filament.api.BaseZShowFilamentPreviewView.a
        public void a(int requestId) {
            c cVar = this.f256757b.loadParam;
            c cVar2 = this.param;
            if (cVar == cVar2 && cVar2.getRequestId() == requestId) {
                QLog.i("AvatarStatus.FilamentView", 1, "[onLoadSucc] start load action, uin=" + this.param.getUin() + " action=" + this.param.getResource().getAction());
                this.f256757b.loadedUin = this.param.getUin();
                this.f256757b.loadedBaseRes = this.param.getResource().getCom.qq.e.comm.managers.plugin.PM.BASE java.lang.String();
                BaseZShowFilamentPreviewView i3 = this.f256757b.i();
                Intrinsics.checkNotNull(i3);
                i3.setMoodType(this.param.getResource().getAction());
                return;
            }
            QLog.i("AvatarStatus.FilamentView", 1, "[onLoadSucc] load param changed, " + this.param + "->" + this.f256757b.loadParam + ", requestId=" + requestId);
        }

        @Override // com.tencent.aelight.camera.filament.api.BaseZShowFilamentPreviewView.a
        public void b(final int errorCode, @NotNull final String moodPath) {
            Intrinsics.checkNotNullParameter(moodPath, "moodPath");
            Handler handler = this.f256757b.uiHandler;
            final AvatarStatusFilamentView avatarStatusFilamentView = this.f256757b;
            handler.post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.view.zplan.c
                @Override // java.lang.Runnable
                public final void run() {
                    AvatarStatusFilamentView.b.j(AvatarStatusFilamentView.this, this, moodPath, errorCode);
                }
            });
        }

        @Override // com.tencent.aelight.camera.filament.api.BaseZShowFilamentPreviewView.a
        public void c(final int requestId, final int errorCode) {
            Handler handler = this.f256757b.uiHandler;
            final AvatarStatusFilamentView avatarStatusFilamentView = this.f256757b;
            handler.post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.view.zplan.b
                @Override // java.lang.Runnable
                public final void run() {
                    AvatarStatusFilamentView.b.i(AvatarStatusFilamentView.this, this, requestId, errorCode);
                }
            });
        }

        @Override // com.tencent.aelight.camera.filament.api.BaseZShowFilamentPreviewView.a
        public void d(final int errorCode, @NotNull final String moodPath, @Nullable final Bitmap snapshot) {
            Intrinsics.checkNotNullParameter(moodPath, "moodPath");
            Handler handler = this.f256757b.uiHandler;
            final AvatarStatusFilamentView avatarStatusFilamentView = this.f256757b;
            handler.post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.view.zplan.a
                @Override // java.lang.Runnable
                public final void run() {
                    AvatarStatusFilamentView.b.h(AvatarStatusFilamentView.this, this, moodPath, errorCode, snapshot);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0082\b\u0018\u0000 %2\u00020\u0001:\u0001\rBQ\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u00128\u0010\u001f\u001a4\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0017\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\t\u0010\n\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015RT\u0010\u001f\u001a4\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0017\u0010\"\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b\r\u0010!\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusFilamentView$c;", "", "", "toString", "", "success", "", "error", "", "d", "hashCode", "other", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "uin", "Lcom/tencent/mobileqq/onlinestatus/model/b;", "b", "Lcom/tencent/mobileqq/onlinestatus/model/b;", "()Lcom/tencent/mobileqq/onlinestatus/model/b;", "resource", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lkotlin/jvm/functions/Function2;", "getCallback", "()Lkotlin/jvm/functions/Function2;", IECSearchBar.METHOD_SET_CALLBACK, "(Lkotlin/jvm/functions/Function2;)V", "callback", "I", "()I", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/onlinestatus/model/b;Lkotlin/jvm/functions/Function2;)V", "e", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final /* data */ class c {

        /* renamed from: f, reason: collision with root package name */
        @NotNull
        private static final AtomicInteger f256759f = new AtomicInteger(1);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String uin;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.onlinestatus.model.b resource;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Function2<? super Boolean, ? super Integer, Unit> callback;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int requestId;

        public c(@NotNull String uin, @NotNull com.tencent.mobileqq.onlinestatus.model.b resource, @Nullable Function2<? super Boolean, ? super Integer, Unit> function2) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            Intrinsics.checkNotNullParameter(resource, "resource");
            this.uin = uin;
            this.resource = resource;
            this.callback = function2;
            this.requestId = f256759f.getAndIncrement();
        }

        /* renamed from: a, reason: from getter */
        public final int getRequestId() {
            return this.requestId;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final com.tencent.mobileqq.onlinestatus.model.b getResource() {
            return this.resource;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getUin() {
            return this.uin;
        }

        public final void d(boolean success, int error) {
            Function2<? super Boolean, ? super Integer, Unit> function2 = this.callback;
            if (function2 != null) {
                function2.invoke(Boolean.valueOf(success), Integer.valueOf(error));
            }
            this.callback = null;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof c)) {
                return false;
            }
            c cVar = (c) other;
            if (Intrinsics.areEqual(this.uin, cVar.uin) && Intrinsics.areEqual(this.resource, cVar.resource) && Intrinsics.areEqual(this.callback, cVar.callback)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((this.uin.hashCode() * 31) + this.resource.hashCode()) * 31;
            Function2<? super Boolean, ? super Integer, Unit> function2 = this.callback;
            if (function2 == null) {
                hashCode = 0;
            } else {
                hashCode = function2.hashCode();
            }
            return hashCode2 + hashCode;
        }

        @NotNull
        public String toString() {
            return "{uin:" + this.uin + ",resource:" + this.resource.getKey() + ",requestId:" + this.requestId + "}";
        }
    }

    public AvatarStatusFilamentView(@NotNull Context context) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.uiHandler = new Handler(Looper.getMainLooper());
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<BaseZShowFilamentPreviewView>() { // from class: com.tencent.mobileqq.onlinestatus.view.zplan.AvatarStatusFilamentView$filamentView$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final BaseZShowFilamentPreviewView invoke() {
                try {
                    return ((IZShowFilamentPreviewProvider) QRoute.api(IZShowFilamentPreviewProvider.class)).getView();
                } catch (Exception e16) {
                    QLog.i("AvatarStatus.FilamentView", 1, "create view fail, exc=" + e16);
                    return null;
                }
            }
        });
        this.filamentView = lazy;
    }

    private final boolean k(c loadParam, String uin, String baseResPath) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            BaseZShowFilamentPreviewView i3 = i();
            Intrinsics.checkNotNull(i3);
            i3.setupBaseTemplate(uin, baseResPath, loadParam.getRequestId());
            QLog.i("AvatarStatus.FilamentView", 1, "[loadBaseTemplate] setupBaseTemplate, time=" + (System.currentTimeMillis() - currentTimeMillis) + " uin=" + uin + " res=" + baseResPath);
            return true;
        } catch (Throwable th5) {
            QLog.i("AvatarStatus.FilamentView", 1, "[loadBaseTemplate] fail, uin=" + uin + " res=" + baseResPath + " exc=" + th5);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.zplan.j
    public void a(@NotNull String uin, @NotNull com.tencent.mobileqq.onlinestatus.model.b res, boolean reload, @NotNull Function2<? super Boolean, ? super Integer, Unit> callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("AvatarStatus.FilamentView", 1, "[load] uin=" + uin + ", res=" + res);
        this.loadParam = new c(uin, res, callback);
        if (i() == null) {
            QLog.i("AvatarStatus.FilamentView", 1, "[load] filament view is null, res=" + res);
            callback.invoke(Boolean.FALSE, 102);
            return;
        }
        BaseZShowFilamentPreviewView i3 = i();
        Intrinsics.checkNotNull(i3);
        c cVar = this.loadParam;
        Intrinsics.checkNotNull(cVar);
        i3.setOnStatusListener(new b(this, cVar));
        if (!reload && Intrinsics.areEqual(this.loadedUin, uin) && Intrinsics.areEqual(this.loadedBaseRes, res.getCom.qq.e.comm.managers.plugin.PM.BASE java.lang.String())) {
            if (QLog.isColorLevel()) {
                QLog.i("AvatarStatus.FilamentView", 1, "[load] base templated loaded, apply action, uin=" + uin);
            }
            BaseZShowFilamentPreviewView i16 = i();
            Intrinsics.checkNotNull(i16);
            i16.setMoodType(res.getAction());
            return;
        }
        c cVar2 = this.loadParam;
        Intrinsics.checkNotNull(cVar2);
        if (!k(cVar2, uin, res.getCom.qq.e.comm.managers.plugin.PM.BASE java.lang.String())) {
            callback.invoke(Boolean.FALSE, 101);
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.zplan.j
    public void b(@Nullable j.a aVar) {
        this.listener = aVar;
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.zplan.j
    @NotNull
    public View getView() {
        BaseZShowFilamentPreviewView i3 = i();
        if (i3 == null) {
            return new View(this.context);
        }
        return i3;
    }

    @Nullable
    public final BaseZShowFilamentPreviewView i() {
        return (BaseZShowFilamentPreviewView) this.filamentView.getValue();
    }

    @Nullable
    /* renamed from: j, reason: from getter */
    public j.a getListener() {
        return this.listener;
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.zplan.j
    public void release() {
        BaseZShowFilamentPreviewView i3 = i();
        if (i3 != null) {
            i3.a();
        }
    }
}
