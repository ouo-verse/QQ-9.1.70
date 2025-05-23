package com.tencent.mobileqq.vas;

import android.text.TextUtils;
import com.tencent.cachedrawable.dynamicdrawable.api.a;
import com.tencent.mobileqq.transfile.BasePicDownloadProcessor;
import com.tencent.mobileqq.vas.VasTempConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/vas/VasDynamicDrawableCache;", "Lcom/tencent/cachedrawable/dynamicdrawable/api/a$b;", "", "url", "", "isFilePath", "getCacheFilePath", "<init>", "()V", "vas_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasDynamicDrawableCache implements a.b {

    @NotNull
    public static final VasDynamicDrawableCache INSTANCE = new VasDynamicDrawableCache();

    VasDynamicDrawableCache() {
    }

    private final boolean isFilePath(String url) {
        boolean startsWith$default;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "http", false, 2, null);
        return !startsWith$default;
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.api.a.b
    @NotNull
    public String getCacheFilePath(@NotNull String url) {
        boolean endsWith$default;
        boolean endsWith$default2;
        Intrinsics.checkNotNullParameter(url, "url");
        if (TextUtils.isEmpty(url) || !isFilePath(url)) {
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(url, "avif", false, 2, null);
            if (!endsWith$default) {
                endsWith$default2 = StringsKt__StringsJVMKt.endsWith$default(url, "png", false, 2, null);
                if (endsWith$default2) {
                    return VasTempConstant.External.DYNAMIC_DRAWABLE_DIR + url.hashCode() + ".png";
                }
                return VasTempConstant.External.DYNAMIC_DRAWABLE_DIR + url.hashCode();
            }
            return VasTempConstant.External.DYNAMIC_DRAWABLE_DIR + url.hashCode() + BasePicDownloadProcessor.AVIF_FILE_SUFFIX;
        }
        return url;
    }
}
