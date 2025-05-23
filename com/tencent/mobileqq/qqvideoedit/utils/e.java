package com.tencent.mobileqq.qqvideoedit.utils;

import android.media.MediaMetadataRetriever;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/utils/e;", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMediaInfo", "a", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f276246a = new e();

    e() {
    }

    @NotNull
    public final LocalMediaInfo a(@NotNull LocalMediaInfo localMediaInfo) {
        boolean z16;
        long j3;
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        String str = localMediaInfo.path;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return localMediaInfo;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                File file = new File(localMediaInfo.path);
                if (file.exists()) {
                    j3 = file.length();
                } else {
                    j3 = 0;
                }
                localMediaInfo.fileSize = j3;
                mediaMetadataRetriever.setDataSource(localMediaInfo.path);
                String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
                Intrinsics.checkNotNull(extractMetadata);
                long parseLong = Long.parseLong(extractMetadata);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(18);
                Intrinsics.checkNotNull(extractMetadata2);
                int parseInt = Integer.parseInt(extractMetadata2);
                String extractMetadata3 = mediaMetadataRetriever.extractMetadata(19);
                Intrinsics.checkNotNull(extractMetadata3);
                int parseInt2 = Integer.parseInt(extractMetadata3);
                String extractMetadata4 = mediaMetadataRetriever.extractMetadata(20);
                Intrinsics.checkNotNull(extractMetadata4);
                long parseLong2 = Long.parseLong(extractMetadata4);
                localMediaInfo.mDuration = parseLong;
                localMediaInfo.mediaWidth = parseInt;
                localMediaInfo.mediaHeight = parseInt2;
                localMediaInfo.mediaBitrate = parseLong2;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            return localMediaInfo;
        } finally {
            mediaMetadataRetriever.release();
        }
    }
}
