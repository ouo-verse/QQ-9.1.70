package jy2;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tvideo.Video;
import tvideo.VideoBaseInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\t"}, d2 = {"Ljy2/c;", "", "Ltvideo/Video;", "tVideoFeed", "", "a", "b", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f411160a = new c();

    c() {
    }

    public final long a(@Nullable Video tVideoFeed) {
        VideoBaseInfo videoBaseInfo;
        int i3;
        if (hy2.a.f406605a.b()) {
            if (tVideoFeed != null) {
                videoBaseInfo = tVideoFeed.video_base_info;
            } else {
                videoBaseInfo = null;
            }
            if (videoBaseInfo != null && (i3 = tVideoFeed.video_base_info.skip_end) != 0) {
                return i3;
            }
            return 0L;
        }
        return 0L;
    }

    public final long b(@Nullable Video tVideoFeed) {
        VideoBaseInfo videoBaseInfo;
        int max;
        if (tVideoFeed != null) {
            videoBaseInfo = tVideoFeed.video_base_info;
        } else {
            videoBaseInfo = null;
        }
        if (videoBaseInfo == null) {
            return 0L;
        }
        if (!hy2.a.f406605a.b()) {
            max = tVideoFeed.video_base_info.material_starting_time;
        } else {
            VideoBaseInfo videoBaseInfo2 = tVideoFeed.video_base_info;
            max = Math.max(videoBaseInfo2.material_starting_time, videoBaseInfo2.skip_start);
        }
        return max;
    }
}
