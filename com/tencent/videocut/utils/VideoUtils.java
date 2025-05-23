package com.tencent.videocut.utils;

import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u001e\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J$\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/videocut/utils/VideoUtils;", "", "", "path", "", "a", "Lkotlin/Pair;", "", "c", "Lkotlin/Triple;", "d", "b", "<init>", "()V", "lib_utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class VideoUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final VideoUtils f384231a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9706);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f384231a = new VideoUtils();
        }
    }

    VideoUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    @WorkerThread
    public final long a(@Nullable String path) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Long) iPatchRedirector.redirect((short) 1, (Object) this, (Object) path)).longValue();
        }
        if (!TextUtils.isEmpty(path)) {
            MediaMetadataRetriever mediaMetadataRetriever = null;
            try {
                try {
                    MediaMetadataRetriever mediaMetadataRetriever2 = new MediaMetadataRetriever();
                    try {
                        mediaMetadataRetriever2.setDataSource(path);
                        r rVar = r.f384266a;
                        String extractMetadata = mediaMetadataRetriever2.extractMetadata(9);
                        if (extractMetadata != null) {
                            j3 = Long.parseLong(extractMetadata);
                        } else {
                            j3 = 0;
                        }
                        long a16 = rVar.a(j3);
                        mediaMetadataRetriever2.release();
                        return a16;
                    } catch (IllegalArgumentException e16) {
                        e = e16;
                        mediaMetadataRetriever = mediaMetadataRetriever2;
                        com.tencent.videocut.utils.log.b.a("VideoUtils", "" + String.valueOf(e.getMessage()));
                        if (mediaMetadataRetriever != null) {
                            mediaMetadataRetriever.release();
                        }
                        return 0L;
                    } catch (Throwable th5) {
                        th = th5;
                        mediaMetadataRetriever = mediaMetadataRetriever2;
                        if (mediaMetadataRetriever != null) {
                            mediaMetadataRetriever.release();
                        }
                        throw th;
                    }
                } catch (IllegalArgumentException e17) {
                    e = e17;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
        return 0L;
    }

    public final int b(@NotNull String path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) path)).intValue();
        }
        Intrinsics.checkNotNullParameter(path, "path");
        int i3 = 8000000;
        if (!g.f384239a.h(path)) {
            com.tencent.videocut.utils.log.b.a("VideoUtils", "Video not exist");
            return 8000000;
        }
        MediaMetadataRetriever mediaMetadataRetriever = null;
        try {
            try {
                MediaMetadataRetriever mediaMetadataRetriever2 = new MediaMetadataRetriever();
                try {
                    mediaMetadataRetriever2.setDataSource(path);
                    Integer valueOf = Integer.valueOf(mediaMetadataRetriever2.extractMetadata(20));
                    Intrinsics.checkNotNullExpressionValue(valueOf, "Integer.valueOf(bitRate)");
                    i3 = valueOf.intValue();
                    mediaMetadataRetriever2.release();
                } catch (IllegalArgumentException e16) {
                    e = e16;
                    mediaMetadataRetriever = mediaMetadataRetriever2;
                    com.tencent.videocut.utils.log.b.b("VideoUtils", "Get video bit rate error", e);
                    if (mediaMetadataRetriever != null) {
                        mediaMetadataRetriever.release();
                    }
                    return i3;
                } catch (Throwable th5) {
                    th = th5;
                    mediaMetadataRetriever = mediaMetadataRetriever2;
                    if (mediaMetadataRetriever != null) {
                        mediaMetadataRetriever.release();
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IllegalArgumentException e17) {
            e = e17;
        }
        return i3;
    }

    @WorkerThread
    @NotNull
    public final Pair<Integer, Integer> c(@Nullable String path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Pair) iPatchRedirector.redirect((short) 4, (Object) this, (Object) path);
        }
        Triple<Integer, Integer, Long> d16 = d(path);
        return new Pair<>(d16.getFirst(), d16.getSecond());
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00bd, code lost:
    
        if (r1 == null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b1, code lost:
    
        r1.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00af, code lost:
    
        if (r1 == null) goto L44;
     */
    @WorkerThread
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Triple<Integer, Integer, Long> d(@Nullable String path) {
        long j3;
        Triple<Integer, Integer, Long> triple;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Triple) iPatchRedirector.redirect((short) 5, (Object) this, (Object) path);
        }
        if (!TextUtils.isEmpty(path)) {
            MediaMetadataRetriever mediaMetadataRetriever = null;
            try {
                try {
                    MediaMetadataRetriever mediaMetadataRetriever2 = new MediaMetadataRetriever();
                    try {
                        mediaMetadataRetriever2.setDataSource(path);
                        VideoUtils$getWidthHeightAndDuration$safeToInt$1 videoUtils$getWidthHeightAndDuration$safeToInt$1 = VideoUtils$getWidthHeightAndDuration$safeToInt$1.INSTANCE;
                        int intValue = videoUtils$getWidthHeightAndDuration$safeToInt$1.invoke((VideoUtils$getWidthHeightAndDuration$safeToInt$1) mediaMetadataRetriever2.extractMetadata(24)).intValue();
                        int intValue2 = videoUtils$getWidthHeightAndDuration$safeToInt$1.invoke((VideoUtils$getWidthHeightAndDuration$safeToInt$1) mediaMetadataRetriever2.extractMetadata(19)).intValue();
                        int intValue3 = videoUtils$getWidthHeightAndDuration$safeToInt$1.invoke((VideoUtils$getWidthHeightAndDuration$safeToInt$1) mediaMetadataRetriever2.extractMetadata(18)).intValue();
                        String extractMetadata = mediaMetadataRetriever2.extractMetadata(9);
                        if (extractMetadata != null) {
                            j3 = Long.parseLong(extractMetadata);
                        } else {
                            j3 = 0;
                        }
                        long a16 = r.f384266a.a(j3);
                        if (intValue != 90 && intValue != 270) {
                            triple = new Triple<>(Integer.valueOf(intValue3), Integer.valueOf(intValue2), Long.valueOf(a16));
                            mediaMetadataRetriever2.release();
                            return triple;
                        }
                        triple = new Triple<>(Integer.valueOf(intValue2), Integer.valueOf(intValue3), Long.valueOf(a16));
                        mediaMetadataRetriever2.release();
                        return triple;
                    } catch (IllegalArgumentException e16) {
                        e = e16;
                        mediaMetadataRetriever = mediaMetadataRetriever2;
                        com.tencent.videocut.utils.log.b.a("VideoUtils", e.toString());
                    } catch (RuntimeException e17) {
                        e = e17;
                        mediaMetadataRetriever = mediaMetadataRetriever2;
                        com.tencent.videocut.utils.log.b.a("VideoUtils", e.toString());
                    } catch (Throwable th5) {
                        th = th5;
                        mediaMetadataRetriever = mediaMetadataRetriever2;
                        if (mediaMetadataRetriever != null) {
                            mediaMetadataRetriever.release();
                        }
                        throw th;
                    }
                } catch (IllegalArgumentException e18) {
                    e = e18;
                } catch (RuntimeException e19) {
                    e = e19;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
        return new Triple<>(0, 0, 0L);
    }
}
