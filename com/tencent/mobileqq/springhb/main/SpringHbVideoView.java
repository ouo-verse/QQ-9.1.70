package com.tencent.mobileqq.springhb.main;

import android.content.Context;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.qqvideoplatform.api.SceneID;
import com.tencent.mobileqq.springhb.prize.ae;
import com.tencent.mobileqq.videoplatform.api.IBaseVideoView;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0002 \u0003B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\u0004J\u0016\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000fJ\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0019R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/springhb/main/SpringHbVideoView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mobileqq/videoplatform/api/VideoPlayParam;", "b", "", "f", "", "isMute", "setMute", "c", "d", "e", "isPlaying", "setIsPlaying", "g", "", "filePath", "isLoop", "setVideoNativeFilePath", AppConstants.Key.KEY_QZONE_VIDEO_URL, "setVideoNetUrl", "Lcom/tencent/mobileqq/springhb/main/SpringHbVideoView$b;", "onPlayListener", "setPlayListener", "Lcom/tencent/mobileqq/videoplatform/view/BaseVideoView;", "Lcom/tencent/mobileqq/videoplatform/view/BaseVideoView;", "baseVideoView", "Lcom/tencent/mobileqq/springhb/main/SpringHbVideoView$b;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SpringHbVideoView extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BaseVideoView baseVideoView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b onPlayListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/springhb/main/SpringHbVideoView$a;", "", "", "SCENE_ID", "I", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.springhb.main.SpringHbVideoView$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/springhb/main/SpringHbVideoView$b;", "", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public interface b {
        void a();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/springhb/main/SpringHbVideoView$c", "Lcom/tencent/mobileqq/springhb/prize/ae;", "", "id", "", "state", "", "onStateChange", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c extends ae {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SpringHbVideoView.this);
            }
        }

        @Override // com.tencent.mobileqq.springhb.prize.ae, com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onStateChange(long id5, int state) {
            b bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(id5), Integer.valueOf(state));
                return;
            }
            super.onStateChange(id5, state);
            if (state == 8 && (bVar = SpringHbVideoView.this.onPlayListener) != null) {
                bVar.a();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61121);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpringHbVideoView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        IBaseVideoView createBaseVideoViewFS = QQVideoViewFactory.createBaseVideoViewFS(context, 108L, null, null);
        Intrinsics.checkNotNull(createBaseVideoViewFS, "null cannot be cast to non-null type com.tencent.mobileqq.videoplatform.view.BaseVideoView");
        BaseVideoView baseVideoView = (BaseVideoView) createBaseVideoViewFS;
        this.baseVideoView = baseVideoView;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        baseVideoView.setLayoutParams(layoutParams);
        super.addView(baseVideoView);
    }

    private final VideoPlayParam b() {
        VideoPlayParam videoPlayParam = new VideoPlayParam();
        videoPlayParam.mSceneId = 108;
        videoPlayParam.mSceneName = SceneID.getSceneStr(108);
        videoPlayParam.mIsMute = true;
        videoPlayParam.mCallback = new c();
        return videoPlayParam;
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.baseVideoView.isMute();
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.baseVideoView.isPlaying();
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.baseVideoView.pause();
        }
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.baseVideoView.play();
        }
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.baseVideoView.releasePlayer(false);
        }
    }

    public final void setIsPlaying(boolean isPlaying) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, isPlaying);
        } else {
            this.baseVideoView.mIsPlayVideo = isPlaying;
        }
    }

    public final void setMute(boolean isMute) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, isMute);
        } else {
            this.baseVideoView.setMute(isMute);
        }
    }

    public final void setPlayListener(@NotNull b onPlayListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) onPlayListener);
        } else {
            Intrinsics.checkNotNullParameter(onPlayListener, "onPlayListener");
            this.onPlayListener = onPlayListener;
        }
    }

    public final void setVideoNativeFilePath(@NotNull String filePath, boolean isLoop) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, filePath, Boolean.valueOf(isLoop));
            return;
        }
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        VideoPlayParam b16 = b();
        b16.mVideoPath = filePath;
        b16.mIsLocal = true;
        b16.mIsLoop = isLoop;
        this.baseVideoView.setVideoParam(b16);
    }

    public final void setVideoNetUrl(@NotNull String videoUrl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) videoUrl);
            return;
        }
        Intrinsics.checkNotNullParameter(videoUrl, "videoUrl");
        VideoPlayParam b16 = b();
        b16.mUrls = new String[]{videoUrl};
        b16.mIsLocal = false;
        this.baseVideoView.setVideoParam(b16);
    }
}
