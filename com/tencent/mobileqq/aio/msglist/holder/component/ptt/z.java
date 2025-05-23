package com.tencent.mobileqq.aio.msglist.holder.component.ptt;

import android.media.MediaPlayer;
import com.tencent.mobileqq.aio.msglist.holder.component.ptt.z;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/z;", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class z {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private static MediaPlayer f191820b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/ptt/z$a;", "", "", "d", "", "resId", "Landroid/media/MediaPlayer$OnCompletionListener;", "listener", "b", "", "TAG", "Ljava/lang/String;", "Landroid/media/MediaPlayer;", "mediaPlayer", "Landroid/media/MediaPlayer;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.ptt.z$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(MediaPlayer.OnCompletionListener listener, MediaPlayer mediaPlayer) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            z.INSTANCE.d();
            listener.onCompletion(z.f191820b);
        }

        private final void d() {
            MediaPlayer mediaPlayer = z.f191820b;
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            z.f191820b = null;
        }

        public final synchronized void b(int resId, @NotNull final MediaPlayer.OnCompletionListener listener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, resId, (Object) listener);
                return;
            }
            Intrinsics.checkNotNullParameter(listener, "listener");
            try {
                MediaPlayer mediaPlayer = z.f191820b;
                if (mediaPlayer != null) {
                    if (mediaPlayer.isPlaying()) {
                        return;
                    } else {
                        z.INSTANCE.d();
                    }
                }
                z.f191820b = MediaPlayer.create(BaseApplication.context, resId);
                MediaPlayer mediaPlayer2 = z.f191820b;
                if (mediaPlayer2 != null) {
                    mediaPlayer2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ptt.y
                        @Override // android.media.MediaPlayer.OnCompletionListener
                        public final void onCompletion(MediaPlayer mediaPlayer3) {
                            z.Companion.c(listener, mediaPlayer3);
                        }
                    });
                    mediaPlayer2.start();
                    mediaPlayer2.setLooping(false);
                }
            } catch (Exception e16) {
                listener.onCompletion(z.f191820b);
                QLog.e("AudioUtil", 1, e16, new Object[0]);
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63125);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new Companion(null);
        }
    }
}
