package com.tencent.mobileqq.album.media;

import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000\u001a\"\u0010\b\u001a\u00020\u0007*\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "Landroid/net/Uri;", "a", "", "extra", "", com.tencent.luggage.wxa.c8.c.Y, "Lcom/tencent/mobileqq/album/media/c;", "b", "album_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b {
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0065, code lost:
    
        if (r1 != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0067, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0076, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0073, code lost:
    
        if (r1 == null) goto L27;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Uri a(@NotNull LocalMediaInfo localMediaInfo) {
        Cursor cursor;
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        Cursor cursor2 = null;
        Uri withAppendedId = null;
        if (com.tencent.qqnt.qbasealbum.ktx.b.j(localMediaInfo)) {
            try {
                String path = localMediaInfo.getPath();
                Intrinsics.checkNotNull(path);
                cursor = ContactsMonitor.query(com.tencent.qqnt.qbasealbum.inject.a.f361230a.a().getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=? ", new String[]{path}, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            long j3 = cursor.getLong(cursor.getColumnIndex("_id"));
                            if (com.tencent.qqnt.qbasealbum.ktx.b.n(localMediaInfo)) {
                                withAppendedId = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, j3);
                            } else if (com.tencent.qqnt.qbasealbum.ktx.b.o(localMediaInfo)) {
                                withAppendedId = ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, j3);
                            }
                            cursor.close();
                            return withAppendedId;
                        }
                    } catch (Exception unused) {
                    } catch (Throwable th5) {
                        th = th5;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                }
            } catch (Exception unused2) {
                cursor = null;
            } catch (Throwable th6) {
                th = th6;
            }
        } else {
            if (com.tencent.qqnt.qbasealbum.ktx.b.n(localMediaInfo)) {
                return ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, localMediaInfo.get_id());
            }
            if (com.tencent.qqnt.qbasealbum.ktx.b.o(localMediaInfo)) {
                return ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, localMediaInfo.get_id());
            }
            if (!com.tencent.qqnt.util.b.f362976b.isDebugVersion()) {
                return null;
            }
            throw new IllegalArgumentException("unknown media type");
        }
    }

    @NotNull
    public static final c b(@NotNull LocalMediaInfo localMediaInfo, @Nullable Object obj, @Nullable String str) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        return new c(a(localMediaInfo), localMediaInfo.getPath(), localMediaInfo.getMMediaType(), obj, null, str, 16, null);
    }

    public static /* synthetic */ c c(LocalMediaInfo localMediaInfo, Object obj, String str, int i3, Object obj2) {
        if ((i3 & 1) != 0) {
            obj = null;
        }
        if ((i3 & 2) != 0) {
            str = null;
        }
        return b(localMediaInfo, obj, str);
    }
}
