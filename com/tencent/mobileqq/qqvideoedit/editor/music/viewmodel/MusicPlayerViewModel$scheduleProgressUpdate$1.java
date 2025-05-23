package com.tencent.mobileqq.qqvideoedit.editor.music.viewmodel;

import android.media.MediaPlayer;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qqvideoedit.editor.music.viewmodel.b;
import java.util.TimerTask;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/music/viewmodel/MusicPlayerViewModel$scheduleProgressUpdate$1", "Ljava/util/TimerTask;", "", TencentLocation.RUN_MODE, "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class MusicPlayerViewModel$scheduleProgressUpdate$1 extends TimerTask {
    final /* synthetic */ b this$0;

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0030, code lost:
    
        r0 = r1.mediaPlayer;
     */
    @Override // java.util.TimerTask, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        MediaPlayer mediaPlayer;
        b.C8437b c8437b;
        MediaPlayer mediaPlayer2;
        b.C8437b c8437b2;
        try {
            mediaPlayer = this.this$0.mediaPlayer;
            if (mediaPlayer != null) {
                b bVar = this.this$0;
                if (mediaPlayer.isPlaying()) {
                    int currentPosition = mediaPlayer.getCurrentPosition();
                    bVar.L1().postValue(Integer.valueOf(currentPosition));
                    c8437b = bVar.playInterval;
                    int end = c8437b.getEnd();
                    boolean z16 = false;
                    if (1 <= end && end <= currentPosition) {
                        z16 = true;
                    }
                    if (z16 && mediaPlayer2 != null) {
                        c8437b2 = bVar.playInterval;
                        mediaPlayer2.seekTo(c8437b2.getStart());
                    }
                }
            }
        } catch (Exception unused) {
        }
    }
}
