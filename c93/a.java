package c93;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.utils.l;
import e93.i;
import java.io.File;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w53.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\tR\u001c\u0010\u000e\u001a\n \f*\u0004\u0018\u00010\u00040\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lc93/a;", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMediaInfo", "", "b", "mediaPath", "c", "a", "", "e", "d", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "COMPRESS_FOLDER", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f30473a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String COMPRESS_FOLDER = u53.a.f438361b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: c93.a$a, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static final class C0177a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((File) t16).lastModified()), Long.valueOf(((File) t17).lastModified()));
            return compareValues;
        }
    }

    a() {
    }

    @Nullable
    public final String a(@NotNull String mediaPath) {
        boolean endsWith$default;
        Intrinsics.checkNotNullParameter(mediaPath, "mediaPath");
        String str = ".png";
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(mediaPath, ".png", false, 2, null);
        if (!endsWith$default) {
            str = ".jpg";
        }
        l lVar = l.f326716a;
        String COMPRESS_FOLDER2 = COMPRESS_FOLDER;
        Intrinsics.checkNotNullExpressionValue(COMPRESS_FOLDER2, "COMPRESS_FOLDER");
        return lVar.c(mediaPath, COMPRESS_FOLDER2, str);
    }

    @Nullable
    public final String b(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        if (i.I(localMediaInfo)) {
            String str = localMediaInfo.path;
            Intrinsics.checkNotNullExpressionValue(str, "localMediaInfo.path");
            return c(str);
        }
        if (i.G(localMediaInfo)) {
            String str2 = localMediaInfo.path;
            Intrinsics.checkNotNullExpressionValue(str2, "localMediaInfo.path");
            return a(str2);
        }
        return null;
    }

    @Nullable
    public final String c(@NotNull String mediaPath) {
        Intrinsics.checkNotNullParameter(mediaPath, "mediaPath");
        l lVar = l.f326716a;
        String COMPRESS_FOLDER2 = COMPRESS_FOLDER;
        Intrinsics.checkNotNullExpressionValue(COMPRESS_FOLDER2, "COMPRESS_FOLDER");
        return lVar.c(mediaPath, COMPRESS_FOLDER2, "mp4");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0074 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d() {
        boolean z16;
        boolean z17;
        b.f("CompressCacheManager", "[refreshCache]");
        File file = new File(COMPRESS_FOLDER);
        if (!file.exists()) {
            return;
        }
        File[] cacheList = file.listFiles();
        if (cacheList != null) {
            if (cacheList.length == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                z16 = false;
                if (z16) {
                    if (cacheList.length > 70) {
                        Intrinsics.checkNotNullExpressionValue(cacheList, "cacheList");
                        if (cacheList.length > 1) {
                            ArraysKt___ArraysJvmKt.sortWith(cacheList, new C0177a());
                        }
                        int length = cacheList.length - 70;
                        for (int i3 = 0; i3 < length; i3++) {
                            FileUtils.deleteFile(cacheList[i3]);
                        }
                    }
                    Intrinsics.checkNotNullExpressionValue(cacheList, "cacheList");
                    for (File file2 : cacheList) {
                        if (file2.exists() && System.currentTimeMillis() - file2.lastModified() > 604800000) {
                            FileUtils.deleteFile(file2);
                        }
                    }
                    return;
                }
                return;
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    public final void e(@NotNull LocalMediaInfo localMediaInfo) {
        String b16;
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        b.f("CompressCacheManager", "[removeCache] path = " + localMediaInfo.path);
        if (new File(COMPRESS_FOLDER).exists() && (b16 = b(localMediaInfo)) != null) {
            new File(b16).delete();
        }
    }
}
