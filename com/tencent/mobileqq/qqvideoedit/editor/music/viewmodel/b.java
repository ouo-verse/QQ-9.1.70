package com.tencent.mobileqq.qqvideoedit.editor.music.viewmodel;

import android.media.AudioManager;
import android.media.MediaPlayer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.Timer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001c\u001dB\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0014R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u00060\u0015R\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/music/viewmodel/b;", "Lcom/tencent/mobileqq/qqvideoedit/editor/music/viewmodel/a;", "", "Q1", "O1", "P1", "onCleared", "Landroid/media/AudioManager;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/media/AudioManager;", "getAm", "()Landroid/media/AudioManager;", "am", "Landroid/media/MediaPlayer;", "D", "Landroid/media/MediaPlayer;", "mediaPlayer", "Ljava/util/Timer;", "E", "Ljava/util/Timer;", SemanticAttributes.FaasTriggerValues.TIMER, "Lcom/tencent/mobileqq/qqvideoedit/editor/music/viewmodel/b$b;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/qqvideoedit/editor/music/viewmodel/b$b;", "playInterval", "<init>", "(Landroid/media/AudioManager;)V", "G", "a", "b", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b extends a {
    private static final String H = b.class.getSimpleName();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final AudioManager am;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private MediaPlayer mediaPlayer;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Timer timer;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final C8437b playInterval;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\n\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/music/viewmodel/b$b;", "", "", "a", "I", "b", "()I", "setStart", "(I)V", "start", "setEnd", "end", "<init>", "(Lcom/tencent/mobileqq/qqvideoedit/editor/music/viewmodel/b;II)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqvideoedit.editor.music.viewmodel.b$b, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public final class C8437b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int start;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int end;

        public C8437b(int i3, int i16) {
            this.start = i3;
            this.end = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getEnd() {
            return this.end;
        }

        /* renamed from: b, reason: from getter */
        public final int getStart() {
            return this.start;
        }

        public /* synthetic */ C8437b(b bVar, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) != 0 ? 15000 : i16);
        }
    }

    public b(@NotNull AudioManager am5) {
        Intrinsics.checkNotNullParameter(am5, "am");
        this.am = am5;
        this.playInterval = new C8437b(this, 0, 0, 3, null);
    }

    private final void O1() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
        }
        this.timer = null;
    }

    private final void P1() {
        Q1();
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        this.mediaPlayer = null;
    }

    private final void Q1() {
        try {
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.stop();
            }
        } catch (Exception unused) {
        }
        O1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        P1();
    }
}
