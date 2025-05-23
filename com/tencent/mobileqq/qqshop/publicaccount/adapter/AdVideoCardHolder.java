package com.tencent.mobileqq.qqshop.publicaccount.adapter;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqshop.publicaccount.adapter.AdVideoCardHolder;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 C2\u00020\u0001:\u0001DB\u000f\u0012\u0006\u0010@\u001a\u00020?\u00a2\u0006\u0004\bA\u0010BJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0014J4\u0010\u0016\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0017\u001a\u00020\u0004H\u0014J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0014J\b\u0010\u001e\u001a\u00020\u0004H\u0014J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0016J\b\u0010#\u001a\u00020\u0004H\u0016J\b\u0010$\u001a\u00020\fH\u0014R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001b\u0010.\u001a\u00020)8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R$\u00104\u001a\u0004\u0018\u00010\u00028\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010*R\u0016\u00108\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010*R\u0016\u0010:\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010*R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/adapter/AdVideoCardHolder;", "Lcom/tencent/mobileqq/qqshop/publicaccount/adapter/AdCardHolder;", "Lcom/tencent/superplayer/api/ISuperPlayer;", "a0", "", "q0", "p0", "", "url", "r0", "Lcom/tencent/mobileqq/qqshop/publicaccount/adapter/p;", "headCardModel", "", "headPosition", "B", "o0", "player", "id", "width", "height", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "m0", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "isVisible", "M", "stop", "H", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Landroid/view/View;", "view", "onViewAttachedToWindow", "onViewDetachedFromWindow", "I", "k0", "Lml2/b;", "Y", "Lml2/b;", "adVideoReporter", "Lcom/tencent/superplayer/view/ISPlayerVideoView;", "Z", "Lkotlin/Lazy;", "j0", "()Lcom/tencent/superplayer/view/ISPlayerVideoView;", "videoView", "Lcom/tencent/superplayer/api/ISuperPlayer;", "i0", "()Lcom/tencent/superplayer/api/ISuperPlayer;", "setSuperPlayer", "(Lcom/tencent/superplayer/api/ISuperPlayer;)V", "superPlayer", "b0", "isVideoPrepared", "c0", "isOnResume", "d0", "isVideoStop", "", "e0", "J", "lastCurrentPositionMs", "Landroid/view/ViewGroup;", "itemView", "<init>", "(Landroid/view/ViewGroup;)V", "f0", "a", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public class AdVideoCardHolder extends AdCardHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: Y, reason: from kotlin metadata */
    private ml2.b adVideoReporter;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final Lazy videoView;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ISuperPlayer superPlayer;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private boolean isVideoPrepared;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private boolean isOnResume;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private boolean isVideoStop;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private long lastCurrentPositionMs;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/adapter/AdVideoCardHolder$a;", "", "", "c", "", "d", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqshop.publicaccount.adapter.AdVideoCardHolder$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e() {
            if (!QQVideoPlaySDKManager.isSDKReady()) {
                QQVideoPlaySDKManager.initSDKAsync(BaseApplication.getContext(), new SDKInitListener() { // from class: com.tencent.mobileqq.qqshop.publicaccount.adapter.m
                    @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
                    public final void onSDKInited(boolean z16) {
                        AdVideoCardHolder.Companion.f(z16);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(boolean z16) {
            QLog.i("AdVideoCardHolder", 1, "video sdk init.");
        }

        public final boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return com.tencent.mobileqq.ecshop.utils.d.f203953a.e("qqshop_hippy_video_no_autoplay");
        }

        public final void d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                if (c()) {
                    return;
                }
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqshop.publicaccount.adapter.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        AdVideoCardHolder.Companion.e();
                    }
                }, 16, null, false);
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J4\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\"\u0010\r\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqshop/publicaccount/adapter/AdVideoCardHolder$b", "Lcom/tencent/superplayer/api/ISuperPlayer$OnCaptureImageListener;", "Lcom/tencent/superplayer/api/ISuperPlayer;", "player", "", "id", "width", "height", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "onCaptureImageSucceed", "errCode", "onCaptureImageFailed", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements ISuperPlayer.OnCaptureImageListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AdVideoCardHolder.this);
            }
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener
        public void onCaptureImageFailed(@Nullable ISuperPlayer player, int id5, int errCode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, player, Integer.valueOf(id5), Integer.valueOf(errCode));
            }
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener
        public void onCaptureImageSucceed(@Nullable ISuperPlayer player, int id5, int width, int height, @Nullable Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, player, Integer.valueOf(id5), Integer.valueOf(width), Integer.valueOf(height), bitmap);
            } else {
                AdVideoCardHolder.this.m0(player, id5, width, height, bitmap);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31298);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdVideoCardHolder(@NotNull final ViewGroup itemView) {
        super(itemView);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<ISPlayerVideoView>(itemView) { // from class: com.tencent.mobileqq.qqshop.publicaccount.adapter.AdVideoCardHolder$videoView$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ ViewGroup $itemView;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$itemView = itemView;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) itemView);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ISPlayerVideoView invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? SuperPlayerFactory.createPlayerVideoView(this.$itemView.getContext()) : (ISPlayerVideoView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.videoView = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
        }
    }

    private final ISuperPlayer a0() {
        final ISuperPlayer createMediaPlayer = SuperPlayerFactory.createMediaPlayer(MobileQQ.sMobileQQ, 117, j0());
        createMediaPlayer.setXYaxis(k0());
        createMediaPlayer.setOnVideoPreparedListener(new ISuperPlayer.OnVideoPreparedListener() { // from class: com.tencent.mobileqq.qqshop.publicaccount.adapter.g
            @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
            public final void onVideoPrepared(ISuperPlayer iSuperPlayer) {
                AdVideoCardHolder.b0(AdVideoCardHolder.this, iSuperPlayer);
            }
        });
        createMediaPlayer.setOnCompletionListener(new ISuperPlayer.OnCompletionListener() { // from class: com.tencent.mobileqq.qqshop.publicaccount.adapter.h
            @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
            public final void onCompletion(ISuperPlayer iSuperPlayer) {
                AdVideoCardHolder.c0(AdVideoCardHolder.this, createMediaPlayer, iSuperPlayer);
            }
        });
        createMediaPlayer.setOnErrorListener(new ISuperPlayer.OnErrorListener() { // from class: com.tencent.mobileqq.qqshop.publicaccount.adapter.i
            @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
            public final boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
                boolean e06;
                e06 = AdVideoCardHolder.e0(AdVideoCardHolder.this, createMediaPlayer, iSuperPlayer, i3, i16, i17, str);
                return e06;
            }
        });
        createMediaPlayer.setOnCaptureImageListener(new b());
        createMediaPlayer.setLoopback(false);
        createMediaPlayer.setOutputMute(true);
        Intrinsics.checkNotNullExpressionValue(createMediaPlayer, "createMediaPlayer(Mobile\u2026tputMute = true\n        }");
        return createMediaPlayer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(AdVideoCardHolder this$0, ISuperPlayer iSuperPlayer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(final AdVideoCardHolder this$0, final ISuperPlayer iSuperPlayer, ISuperPlayer iSuperPlayer2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqshop.publicaccount.adapter.j
            @Override // java.lang.Runnable
            public final void run() {
                AdVideoCardHolder.d0(AdVideoCardHolder.this, iSuperPlayer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(AdVideoCardHolder this$0, ISuperPlayer iSuperPlayer) {
        View view;
        ml2.b bVar;
        long j3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("AdVideoCardHolder", 2, "onCompletion " + this$0.v());
        Object videoView = iSuperPlayer.getVideoView();
        if (videoView instanceof View) {
            view = (View) videoView;
        } else {
            view = null;
        }
        if (view != null) {
            view.setVisibility(8);
        }
        ml2.b bVar2 = this$0.adVideoReporter;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adVideoReporter");
            bVar = null;
        } else {
            bVar = bVar2;
        }
        ISuperPlayer iSuperPlayer2 = this$0.superPlayer;
        if (iSuperPlayer2 != null) {
            j3 = iSuperPlayer2.getCurrentPositionMs();
        } else {
            j3 = 0;
        }
        ml2.b.d(bVar, j3, 1, 0, 0, 0, 28, null);
        iSuperPlayer.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean e0(final AdVideoCardHolder this$0, final ISuperPlayer iSuperPlayer, final ISuperPlayer iSuperPlayer2, final int i3, final int i16, final int i17, final String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqshop.publicaccount.adapter.k
            @Override // java.lang.Runnable
            public final void run() {
                AdVideoCardHolder.f0(i3, i16, i17, str, this$0, iSuperPlayer, iSuperPlayer2);
            }
        });
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(int i3, int i16, int i17, String str, AdVideoCardHolder this$0, ISuperPlayer iSuperPlayer, ISuperPlayer iSuperPlayer2) {
        View view;
        ml2.b bVar;
        long j3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("AdVideoCardHolder", 1, "[onError]extra model = " + i3 + ", errorType = " + i16 + ", errorCode = " + i17 + ", detailInfo = " + str);
        String v3 = this$0.v();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onError ");
        sb5.append(v3);
        QLog.i("AdVideoCardHolder", 2, sb5.toString());
        Object videoView = iSuperPlayer.getVideoView();
        if (videoView instanceof View) {
            view = (View) videoView;
        } else {
            view = null;
        }
        if (view != null) {
            view.setVisibility(8);
        }
        ml2.b bVar2 = this$0.adVideoReporter;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adVideoReporter");
            bVar = null;
        } else {
            bVar = bVar2;
        }
        if (iSuperPlayer2 != null) {
            j3 = iSuperPlayer2.getCurrentPositionMs();
        } else {
            j3 = 0;
        }
        ml2.b.d(bVar, j3, 0, 0, 2, 0, 22, null);
        iSuperPlayer.release();
    }

    private final void p0() {
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null && iSuperPlayer.isPlaying()) {
            iSuperPlayer.pause();
            ml2.b bVar = this.adVideoReporter;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adVideoReporter");
                bVar = null;
            }
            ml2.b.d(bVar, iSuperPlayer.getCurrentPositionMs(), 0, 0, 0, 0, 30, null);
        }
    }

    private final void q0() {
        View view;
        ISuperPlayer iSuperPlayer;
        if (this.superPlayer != null && this.isOnResume && !this.isVideoStop && y()) {
            Object j06 = j0();
            if (j06 instanceof View) {
                view = (View) j06;
            } else {
                view = null;
            }
            boolean z16 = false;
            if (view != null && view.getVisibility() == 0) {
                z16 = true;
            }
            if (z16 && (iSuperPlayer = this.superPlayer) != null) {
                iSuperPlayer.start();
            }
        }
    }

    private final void r0(String url) {
        boolean z16;
        if (url.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.e("AdVideoCardHolder", 1, "openMediaPlayer url is empty");
            return;
        }
        QLog.i("AdVideoCardHolder", 2, "openMediaPlayer url is " + url + " " + v() + ", lastCurrentPositionMs=" + this.lastCurrentPositionMs);
        SuperPlayerVideoInfo createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl(url, 101, (String) null, (String) null);
        SuperPlayerOption obtain = SuperPlayerOption.obtain();
        obtain.accurateSeekOnOpen = true;
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.openMediaPlayer(MobileQQ.sMobileQQ, createVideoInfoForUrl, this.lastCurrentPositionMs, obtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqshop.publicaccount.adapter.AdCardHolder
    public void A() {
        View view;
        ml2.b bVar;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.A();
        QLog.i("AdVideoCardHolder", 2, "video click " + v());
        Object j06 = j0();
        if (j06 instanceof View) {
            view = (View) j06;
        } else {
            view = null;
        }
        if (view != null) {
            view.setVisibility(8);
        }
        ml2.b bVar2 = this.adVideoReporter;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adVideoReporter");
            bVar = null;
        } else {
            bVar = bVar2;
        }
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null) {
            j3 = iSuperPlayer.getCurrentPositionMs();
        } else {
            j3 = 0;
        }
        ml2.b.d(bVar, j3, 0, 2, 0, 0, 26, null);
        ISuperPlayer iSuperPlayer2 = this.superPlayer;
        if (iSuperPlayer2 != null) {
            iSuperPlayer2.release();
        }
        this.superPlayer = null;
        this.isVideoPrepared = false;
    }

    @Override // com.tencent.mobileqq.qqshop.publicaccount.adapter.AdCardHolder
    public void B(@NotNull p headCardModel, int headPosition) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) headCardModel, headPosition);
            return;
        }
        Intrinsics.checkNotNullParameter(headCardModel, "headCardModel");
        super.B(headCardModel, headPosition);
        this.adVideoReporter = new ml2.b(headCardModel.l());
        Object j06 = j0();
        View view2 = null;
        if (j06 instanceof View) {
            view = (View) j06;
        } else {
            view = null;
        }
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
            w().addView(view);
        }
        this.superPlayer = a0();
        r0(headCardModel.m());
        Object j07 = j0();
        if (j07 instanceof View) {
            view2 = (View) j07;
        }
        if (view2 != null) {
            q0();
        }
    }

    @Override // com.tencent.mobileqq.qqshop.publicaccount.adapter.AdCardHolder
    public void H(boolean stop) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, stop);
            return;
        }
        super.H(stop);
        this.isVideoStop = stop;
        if (!stop) {
            q0();
        } else {
            p0();
        }
    }

    @Override // com.tencent.mobileqq.qqshop.publicaccount.adapter.AdCardHolder
    public void I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        super.I();
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.release();
        }
        this.superPlayer = null;
        this.isVideoPrepared = false;
    }

    @Override // com.tencent.mobileqq.qqshop.publicaccount.adapter.AdCardHolder
    public void M(boolean isVisible) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, isVisible);
            return;
        }
        super.M(isVisible);
        if (isVisible) {
            q0();
        } else {
            p0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final ISuperPlayer i0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ISuperPlayer) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.superPlayer;
    }

    @NotNull
    protected final ISPlayerVideoView j0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ISPlayerVideoView) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Object value = this.videoView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-videoView>(...)");
        return (ISPlayerVideoView) value;
    }

    protected int k0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m0(@Nullable ISuperPlayer player, int id5, int width, int height, @Nullable Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, player, Integer.valueOf(id5), Integer.valueOf(width), Integer.valueOf(height), bitmap);
            return;
        }
        QLog.i("AdVideoCardHolder", 2, "onVideoPrepared " + v());
        this.isVideoPrepared = true;
        q0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        QLog.i("AdVideoCardHolder", 2, "onVideoPrepared " + v());
        this.isVideoPrepared = true;
        q0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqshop.publicaccount.adapter.AdCardHolder
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.onPause();
        QLog.i("AdVideoCardHolder", 2, "onPause " + v());
        this.isOnResume = false;
        p0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqshop.publicaccount.adapter.AdCardHolder
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.onResume();
        QLog.i("AdVideoCardHolder", 2, "onResume " + v());
        this.isOnResume = true;
        q0();
    }

    @Override // com.tencent.mobileqq.qqshop.publicaccount.adapter.AdCardHolder, android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(@NotNull View view) {
        View view2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewAttachedToWindow(view);
        Object j06 = j0();
        View view3 = null;
        if (j06 instanceof View) {
            view2 = (View) j06;
        } else {
            view2 = null;
        }
        boolean z16 = false;
        if (view2 != null && view2.getVisibility() == 0) {
            z16 = true;
        }
        if (!z16) {
            return;
        }
        if (this.superPlayer == null) {
            this.superPlayer = a0();
        }
        p u16 = u();
        if (u16 == null) {
            return;
        }
        r0(u16.m());
        Object j07 = j0();
        if (j07 instanceof View) {
            view3 = (View) j07;
        }
        if (view3 != null) {
            q0();
        }
    }

    @Override // com.tencent.mobileqq.qqshop.publicaccount.adapter.AdCardHolder, android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(@NotNull View view) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewDetachedFromWindow(view);
        ISuperPlayer iSuperPlayer = this.superPlayer;
        if (iSuperPlayer != null) {
            j3 = iSuperPlayer.getCurrentPositionMs();
        } else {
            j3 = 0;
        }
        this.lastCurrentPositionMs = j3;
        ISuperPlayer iSuperPlayer2 = this.superPlayer;
        if (iSuperPlayer2 != null) {
            iSuperPlayer2.release();
        }
        this.superPlayer = null;
        this.isVideoPrepared = false;
    }
}
