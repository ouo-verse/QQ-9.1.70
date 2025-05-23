package gc4;

import android.content.Context;
import android.media.MediaPlayer;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0006\u00a8\u0006\r"}, d2 = {"Lgc4/b;", "", "Landroid/content/Context;", "context", "", "path", "Landroid/media/MediaPlayer;", "b", "mediaPlayer", "", "c", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f401925a = new b();

    b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(MediaPlayer mediaPlayer, MediaPlayer mediaPlayer2) {
        Intrinsics.checkNotNullParameter(mediaPlayer, "$mediaPlayer");
        mediaPlayer.release();
        QLog.d("SoundUtils", 1, "release success");
    }

    public final MediaPlayer b(Context context, String path) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setDataSource(path);
        mediaPlayer.prepare();
        return mediaPlayer;
    }

    public final void c(final MediaPlayer mediaPlayer) {
        Intrinsics.checkNotNullParameter(mediaPlayer, "mediaPlayer");
        QLog.d("SoundUtils", 1, "play mediaPlayer:" + mediaPlayer);
        try {
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: gc4.a
                @Override // android.media.MediaPlayer.OnCompletionListener
                public final void onCompletion(MediaPlayer mediaPlayer2) {
                    b.d(mediaPlayer, mediaPlayer2);
                }
            });
        } catch (IllegalStateException e16) {
            QLog.e("SoundUtils", 1, "stop mediaPlayer IllegalStateException, " + e16.getLocalizedMessage());
        }
    }
}
