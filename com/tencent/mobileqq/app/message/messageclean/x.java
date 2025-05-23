package com.tencent.mobileqq.app.message.messageclean;

import android.text.TextUtils;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.app.message.filescan.api.IStorageFileHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/app/message/messageclean/x;", "", "", "getCacheSize", "", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "Ljava/util/concurrent/CopyOnWriteArrayList;", "", "a", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "cachePathList", "storage-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public interface x {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public static final class a {
        public static void a(@NotNull x xVar) {
            CharSequence trim;
            QRouteApi api = QRoute.api(IStorageFileHelperApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IStorageFileHelperApi::class.java)");
            IStorageFileHelperApi iStorageFileHelperApi = (IStorageFileHelperApi) api;
            Iterator<String> it = xVar.a().iterator();
            while (it.hasNext()) {
                String path = it.next();
                Intrinsics.checkNotNullExpressionValue(path, "path");
                trim = StringsKt__StringsKt.trim((CharSequence) path);
                if (!TextUtils.isEmpty(trim.toString())) {
                    File file = new File(path);
                    if (file.isFile()) {
                        if (file.exists()) {
                            file.delete();
                        }
                    } else {
                        iStorageFileHelperApi.deleteFilesInDirectory(path);
                    }
                }
            }
        }

        public static long b(@NotNull x xVar) {
            QRouteApi api = QRoute.api(IStorageFileHelperApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IStorageFileHelperApi::class.java)");
            IStorageFileHelperApi iStorageFileHelperApi = (IStorageFileHelperApi) api;
            Iterator<String> it = xVar.a().iterator();
            long j3 = 0;
            while (it.hasNext()) {
                String path = it.next();
                Intrinsics.checkNotNullExpressionValue(path, "path");
                j3 += iStorageFileHelperApi.getDirSize(path);
            }
            return j3;
        }
    }

    @NotNull
    CopyOnWriteArrayList<String> a();

    void clearCache();

    long getCacheSize();
}
