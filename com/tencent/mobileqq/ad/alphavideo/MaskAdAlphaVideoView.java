package com.tencent.mobileqq.ad.alphavideo;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.jalpha.videoplayer.interfaces.IVideoPLayListener;
import com.tencent.jalpha.videoplayer.render.BaseRender;
import com.tencent.jalpha.videoplayer.render.RenderFactory;
import com.tencent.jalpha.videoplayer.view.JalphaTextureView;
import com.tencent.mobileqq.ad.alphavideo.MaskAdAlphaVideoView;
import com.tencent.mobileqq.ad.alphavideo.b;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0002/0B\u0011\b\u0016\u0012\u0006\u0010(\u001a\u00020'\u00a2\u0006\u0004\b)\u0010*B\u001b\b\u0016\u0012\u0006\u0010(\u001a\u00020'\u0012\b\u0010,\u001a\u0004\u0018\u00010+\u00a2\u0006\u0004\b)\u0010-J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\bH\u0002J\u0018\u0010\f\u001a\u00020\u00032\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\bH\u0002J\u000e\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\nJ\u0010\u0010\u0012\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0013\u001a\u00020\u0003J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0014\u0010\u0018\u001a\u00020\u00032\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001eR\u0016\u0010!\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010 R\u0016\u0010#\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\"R\u0016\u0010$\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\"R\u0016\u0010&\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010 \u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/ad/alphavideo/MaskAdAlphaVideoView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/jalpha/videoplayer/render/RenderFactory;", "", "f", "Lcom/tencent/mobileqq/ad/alphavideo/MaskAdAlphaVideoView$b;", "playResultCallback", h.F, "Ljava/lang/ref/WeakReference;", "weakPlayResultCallback", "", "g", "k", "", "url", "setResUrl", "isLoop", "setIsLoop", "e", "l", "Lcom/tencent/jalpha/videoplayer/render/BaseRender;", "createRender", "Lkotlin/Function0;", "runnable", "i", "Lcom/tencent/jalpha/videoplayer/view/JalphaTextureView;", "d", "Lcom/tencent/jalpha/videoplayer/view/JalphaTextureView;", "mAlphaVideoView", "Lcom/tencent/mobileqq/ad/alphavideo/c;", "Lcom/tencent/mobileqq/ad/alphavideo/c;", "mMaskAdRender", "Z", "mIsLoop", "Ljava/lang/String;", "mFileName", "mUrl", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mIsPlaying", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class MaskAdAlphaVideoView extends FrameLayout implements RenderFactory {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private JalphaTextureView mAlphaVideoView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.ad.alphavideo.c mMaskAdRender;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsLoop;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mFileName;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mUrl;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private volatile boolean mIsPlaying;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/ad/alphavideo/MaskAdAlphaVideoView$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.ad.alphavideo.MaskAdAlphaVideoView$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/ad/alphavideo/MaskAdAlphaVideoView$b;", "", "", "isSuccess", "", "errMsg", "", "a", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public interface b {
        void a(boolean isSuccess, @NotNull String errMsg);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/ad/alphavideo/MaskAdAlphaVideoView$c", "Lcom/tencent/mobileqq/ad/alphavideo/b$a;", "", WadlProxyConsts.PARAM_FILENAME, "", "b", "a", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c implements b.a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f186681b;

        c(b bVar) {
            this.f186681b = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MaskAdAlphaVideoView.this, (Object) bVar);
            }
        }

        @Override // com.tencent.mobileqq.ad.alphavideo.b.a
        public void a(@NotNull String fileName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) fileName);
                return;
            }
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            QLog.d("MaskAdAlphaVideoView", 1, "onFileExist");
            MaskAdAlphaVideoView.this.mFileName = fileName;
            MaskAdAlphaVideoView.this.h(this.f186681b);
        }

        @Override // com.tencent.mobileqq.ad.alphavideo.b.a
        public void b(@NotNull String fileName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) fileName);
                return;
            }
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            QLog.d("MaskAdAlphaVideoView", 1, "onDownloadDone");
            MaskAdAlphaVideoView.this.mFileName = fileName;
            MaskAdAlphaVideoView.this.h(this.f186681b);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/ad/alphavideo/MaskAdAlphaVideoView$d", "Lcom/tencent/jalpha/videoplayer/interfaces/IVideoPLayListener;", "", "i", "i1", "", "onVideoSize", "onStart", "onEnd", "", "l", "onPlayAtTime", "onError", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class d implements IVideoPLayListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JalphaTextureView f186682a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WeakReference<b> f186683b;

        d(JalphaTextureView jalphaTextureView, WeakReference<b> weakReference) {
            this.f186682a = jalphaTextureView;
            this.f186683b = weakReference;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) jalphaTextureView, (Object) weakReference);
            }
        }

        @Override // com.tencent.jalpha.videoplayer.interfaces.IVideoPLayListener
        public void onEnd() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                this.f186682a.setVisibility(0);
            }
        }

        @Override // com.tencent.jalpha.videoplayer.interfaces.IVideoPLayListener
        public void onError(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, i3);
                return;
            }
            QLog.e("MaskAdAlphaVideoView", 1, "play onError:" + i3);
            b bVar = this.f186683b.get();
            if (bVar != null) {
                bVar.a(false, "play onError:" + i3);
            }
        }

        @Override // com.tencent.jalpha.videoplayer.interfaces.IVideoPLayListener
        public void onPlayAtTime(long l3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, l3);
            }
        }

        @Override // com.tencent.jalpha.videoplayer.interfaces.IVideoPLayListener
        public void onStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.jalpha.videoplayer.interfaces.IVideoPLayListener
        public void onVideoSize(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26466);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskAdAlphaVideoView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mFileName = "";
        this.mUrl = "";
        f();
    }

    private final void f() {
        this.mAlphaVideoView = new JalphaTextureView(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean g(WeakReference<b> weakPlayResultCallback) {
        boolean z16;
        if (!TextUtils.isEmpty(this.mFileName) && this.mAlphaVideoView != null) {
            if (this.mIsPlaying) {
                QLog.e("MaskAdAlphaVideoView", 1, "play error: is playing");
                return false;
            }
            k(weakPlayResultCallback);
            QLog.d("MaskAdAlphaVideoView", 1, "play");
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            View rootView = getRootView();
            Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) rootView).addView(this.mAlphaVideoView, layoutParams);
            JalphaTextureView jalphaTextureView = this.mAlphaVideoView;
            if (jalphaTextureView != null) {
                jalphaTextureView.playFile(this.mFileName);
            }
            this.mIsPlaying = true;
            return true;
        }
        Object[] objArr = new Object[4];
        objArr[0] = "play error:";
        objArr[1] = this.mFileName;
        objArr[2] = ",view is null:";
        if (this.mAlphaVideoView == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        objArr[3] = Boolean.valueOf(z16);
        QLog.e("MaskAdAlphaVideoView", 1, objArr);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(final b playResultCallback) {
        i(new Function0<Unit>(this) { // from class: com.tencent.mobileqq.ad.alphavideo.MaskAdAlphaVideoView$playOnMainThread$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ MaskAdAlphaVideoView this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) MaskAdAlphaVideoView.b.this, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                boolean g16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                g16 = this.this$0.g(new WeakReference(MaskAdAlphaVideoView.b.this));
                String str = g16 ? "play success" : "play error";
                MaskAdAlphaVideoView.b bVar = MaskAdAlphaVideoView.b.this;
                if (bVar != null) {
                    bVar.a(g16, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function0 runnable) {
        Intrinsics.checkNotNullParameter(runnable, "$runnable");
        runnable.invoke();
    }

    private final void k(WeakReference<b> weakPlayResultCallback) {
        JalphaTextureView jalphaTextureView = this.mAlphaVideoView;
        if (jalphaTextureView != null) {
            jalphaTextureView.setLoopState(this.mIsLoop);
            jalphaTextureView.setRenderFactory(this);
            jalphaTextureView.setEnabled(true);
            jalphaTextureView.setOpaque(false);
            jalphaTextureView.setContentVisible(true);
            jalphaTextureView.setPlayListener(new d(jalphaTextureView, weakPlayResultCallback));
        }
    }

    @Override // com.tencent.jalpha.videoplayer.render.RenderFactory
    @NotNull
    public BaseRender createRender() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (BaseRender) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        com.tencent.mobileqq.ad.alphavideo.c cVar = new com.tencent.mobileqq.ad.alphavideo.c();
        this.mMaskAdRender = cVar;
        Intrinsics.checkNotNull(cVar, "null cannot be cast to non-null type com.tencent.mobileqq.ad.alphavideo.MaskAdAlphaVideoRender");
        return cVar;
    }

    public final void e(@Nullable b playResultCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) playResultCallback);
        } else {
            com.tencent.mobileqq.ad.alphavideo.b.f186687a.b(this.mUrl, new WeakReference<>(new c(playResultCallback)));
        }
    }

    public final void i(@NotNull final Function0<Unit> runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) runnable);
            return;
        }
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            runnable.invoke();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.ad.alphavideo.d
                @Override // java.lang.Runnable
                public final void run() {
                    MaskAdAlphaVideoView.j(Function0.this);
                }
            });
        }
    }

    public final void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        JalphaTextureView jalphaTextureView = this.mAlphaVideoView;
        if (jalphaTextureView != null) {
            jalphaTextureView.setVisibility(8);
        }
        com.tencent.mobileqq.ad.alphavideo.c cVar = this.mMaskAdRender;
        if (cVar != null) {
            cVar.a();
        }
        this.mIsPlaying = false;
    }

    public final void setIsLoop(boolean isLoop) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, isLoop);
        } else {
            this.mIsLoop = isLoop;
        }
    }

    public final void setResUrl(@NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) url);
        } else {
            Intrinsics.checkNotNullParameter(url, "url");
            this.mUrl = url;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskAdAlphaVideoView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mFileName = "";
        this.mUrl = "";
        f();
    }
}
