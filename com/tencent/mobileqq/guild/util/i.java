package com.tencent.mobileqq.guild.util;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypesTools;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/util/i;", "", "", "mimeString", "", "b", "(Ljava/lang/String;)[Ljava/lang/String;", "Lcom/tencent/mobileqq/guild/data/g;", "info", "", "a", "path", "c", "localMediaInfo", "", "f", "mediaInfo", "e", "d", "", "Ljava/util/Map;", "MEDIA_TYPE_MAPS", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f235563a = new i();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, Integer> MEDIA_TYPE_MAPS;

    static {
        Map<String, Integer> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("image", 0), TuplesKt.to("video", 1), TuplesKt.to(MimeHelper.MIME_TYPE_MOBILEQQ, 2));
        MEDIA_TYPE_MAPS = mapOf;
    }

    i() {
    }

    private final String[] b(String mimeString) {
        List split$default;
        List emptyList;
        boolean z16;
        if (TextUtils.isEmpty(mimeString)) {
            return null;
        }
        Intrinsics.checkNotNull(mimeString);
        split$default = StringsKt__StringsKt.split$default((CharSequence) mimeString, new String[]{"/"}, false, 0, 6, (Object) null);
        if (!split$default.isEmpty()) {
            ListIterator listIterator = split$default.listIterator(split$default.size());
            while (listIterator.hasPrevious()) {
                if (((String) listIterator.previous()).length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    emptyList = CollectionsKt___CollectionsKt.take(split$default, listIterator.nextIndex() + 1);
                    break;
                }
            }
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        Object[] array = emptyList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) array;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int a(@Nullable com.tencent.mobileqq.guild.data.g info) {
        boolean z16;
        boolean z17;
        if (info == null) {
            return -1;
        }
        String[] b16 = b(info.getMimeType());
        if (b16 != null) {
            if (b16.length == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                z16 = false;
                if (!z16) {
                    return 0;
                }
                Integer num = MEDIA_TYPE_MAPS.get(b16[0]);
                if (num == null) {
                    QLog.w("GuildAlbumUtil", 1, "getMediaType fail : " + info.getMimeType() + " - " + b16[0]);
                    return -1;
                }
                return num.intValue();
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    @Nullable
    public final String c(@NotNull String path) {
        boolean z16;
        Intrinsics.checkNotNullParameter(path, "path");
        if (path.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return null;
        }
        try {
            return MimeTypesTools.getMimeType(BaseApplication.getContext(), FileUtils.getFileName(path));
        } catch (Exception e16) {
            QLog.i("GuildAlbumUtil", 1, "getMimeTypeFromPath, e = " + e16);
            return null;
        }
    }

    public final boolean d(@Nullable com.tencent.mobileqq.guild.data.g mediaInfo) {
        String str;
        if (mediaInfo != null) {
            str = mediaInfo.getMimeType();
        } else {
            str = null;
        }
        return Intrinsics.areEqual(str, "image/gif");
    }

    public final boolean e(@Nullable com.tencent.mobileqq.guild.data.g mediaInfo) {
        if (a(mediaInfo) == 0) {
            return true;
        }
        return false;
    }

    public final boolean f(@Nullable com.tencent.mobileqq.guild.data.g localMediaInfo) {
        if (a(localMediaInfo) == 1) {
            return true;
        }
        return false;
    }
}
