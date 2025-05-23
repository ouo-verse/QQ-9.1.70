package com.tencent.mobileqq.kandian.base.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.net.URL;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002J*\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0002J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0002J\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0002R\u001a\u0010\u001d\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001f\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u001a\u0010!\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b \u0010\u001cR\u001a\u0010#\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\"\u0010\u001cR\u001a\u0010%\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0011\u0010\u001a\u001a\u0004\b$\u0010\u001c\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/kandian/base/image/e;", "", "", "url", "c", "type", "d", "originType", "b", "filePath", "", "width", "height", "Landroid/graphics/Bitmap;", "reuseBitmap", "e", "Landroid/graphics/BitmapFactory$Options;", "f", "g", "Lcom/tencent/mobileqq/kandian/base/image/b;", "imageRequest", "originUrl", "", "a", "", tl.h.F, "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "getTYPE_SHARPP", "TYPE_SHARPP", "getTYPE_WEBP", "TYPE_WEBP", "getSUFFIX_SHARPP", "SUFFIX_SHARPP", "getSUFFIX_WEBP", "SUFFIX_WEBP", "<init>", "()V", "kandian-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f239030a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG = "RIJImageSharpHelper";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TYPE_SHARPP = "sharp";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TYPE_WEBP = "webp";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String SUFFIX_SHARPP = "tp=sharp";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String SUFFIX_WEBP = "tp=webp";

    e() {
    }

    public final void a(@NotNull b imageRequest, @NotNull String originUrl) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        Intrinsics.checkNotNullParameter(originUrl, "originUrl");
        try {
            imageRequest.f239025v = g(originUrl);
            imageRequest.f239004a = new URL(c(originUrl));
        } catch (Exception e16) {
            QLog.d(TAG, 1, e16.getMessage());
        }
    }

    @NotNull
    public final String b(@NotNull String url, @NotNull String originType) {
        String replace$default;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(originType, "originType");
        Map<String, String> argumentsFromURL = URLUtil.getArgumentsFromURL(url);
        if (argumentsFromURL.containsKey("tp")) {
            String str = argumentsFromURL.get("tp");
            if (TYPE_WEBP.equals(str) || TYPE_SHARPP.equals(str)) {
                if (!TextUtils.isEmpty(originType)) {
                    replace$default = StringsKt__StringsJVMKt.replace$default(url, "tp=" + str, "tp=" + originType, false, 4, (Object) null);
                    return replace$default;
                }
                String deleteParameter = URLUtil.deleteParameter(url, "tp");
                Intrinsics.checkNotNullExpressionValue(deleteParameter, "deleteParameter(url, \"tp\")");
                return deleteParameter;
            }
            return url;
        }
        return url;
    }

    @NotNull
    public final String c(@NotNull String url) {
        boolean contains$default;
        Intrinsics.checkNotNullParameter(url, "url");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "fmt=gif", false, 2, (Object) null);
        if (contains$default) {
            return url;
        }
        if (((IRIJImageOptConfig) QRoute.api(IRIJImageOptConfig.class)).useWebp()) {
            return d(url, TYPE_WEBP);
        }
        if (((IRIJImageOptConfig) QRoute.api(IRIJImageOptConfig.class)).useSharpP() && ((IRIJImageOptConfig) QRoute.api(IRIJImageOptConfig.class)).isSharpPAvailable()) {
            return d(url, TYPE_SHARPP);
        }
        return url;
    }

    @NotNull
    public final String d(@NotNull String url, @NotNull String type) {
        String replace$default;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(type, "type");
        Map<String, String> argumentsFromURL = URLUtil.getArgumentsFromURL(url);
        if (argumentsFromURL.containsKey("tp")) {
            replace$default = StringsKt__StringsJVMKt.replace$default(url, "tp=" + argumentsFromURL.get("tp"), "tp=" + type, false, 4, (Object) null);
            return replace$default;
        }
        if (argumentsFromURL.size() > 0) {
            return url + "&tp=" + type;
        }
        return url + "?tp=" + type;
    }

    @Nullable
    public final Bitmap e(@NotNull String filePath, int width, int height, @Nullable Bitmap reuseBitmap) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        QRouteApi api = QRoute.api(IRIJImageOptConfig.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IRIJImageOptConfig::class.java)");
        return IRIJImageOptConfig.a.a((IRIJImageOptConfig) api, filePath, width, height, reuseBitmap, null, 16, null);
    }

    @NotNull
    public final BitmapFactory.Options f(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return ((IRIJImageOptConfig) QRoute.api(IRIJImageOptConfig.class)).decodeSharpPInBounds(filePath);
    }

    @Nullable
    public final String g(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Map<String, String> argumentsFromURL = URLUtil.getArgumentsFromURL(url);
        if (argumentsFromURL.containsKey("tp")) {
            return argumentsFromURL.get("tp");
        }
        return "";
    }

    public final boolean h(@NotNull String url) {
        boolean contains$default;
        Intrinsics.checkNotNullParameter(url, "url");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) SUFFIX_SHARPP, false, 2, (Object) null);
        return contains$default;
    }
}
