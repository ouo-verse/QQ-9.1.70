package pl1;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImageUrl;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0006\u001a\u00020\u0003*\u00020\u0000\u001a\u0016\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u0000\u001a\u0012\u0010\u000b\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\n\u001a\u00020\b\u001a\u001e\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u00002\u0006\u0010\n\u001a\u00020\b\u001a\u0012\u0010\r\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\n\u001a\u00020\b\u001a\n\u0010\u000e\u001a\u00020\u0003*\u00020\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStImage;", "", "g", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStImageUrl;", h.F, "d", "e", "Lkotlin/Pair;", "", "f", "level", "c", "b", "a", "i", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {
    @NotNull
    public static final GProStImageUrl a(@NotNull GProStImage gProStImage, int i3) {
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(gProStImage, "<this>");
        if (gProStImage.isGif) {
            return i(gProStImage);
        }
        ArrayList<GProStImageUrl> vecImageUrlList = gProStImage.vecImageUrlList;
        Intrinsics.checkNotNullExpressionValue(vecImageUrlList, "vecImageUrlList");
        Iterator<T> it = vecImageUrlList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((GProStImageUrl) obj).levelType == i3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        GProStImageUrl gProStImageUrl = (GProStImageUrl) obj;
        if (gProStImageUrl == null) {
            return i(gProStImage);
        }
        return gProStImageUrl;
    }

    @NotNull
    public static final Pair<Integer, Integer> b(@NotNull GProStImage gProStImage, int i3) {
        boolean z16;
        GProStImageUrl gProStImageUrl;
        Object obj;
        Pair<Integer, Integer> pair;
        boolean z17;
        Intrinsics.checkNotNullParameter(gProStImage, "<this>");
        if (gProStImage.isGif) {
            return TuplesKt.to(Integer.valueOf(gProStImage.width), Integer.valueOf(gProStImage.height));
        }
        ArrayList<GProStImageUrl> vecImageUrlList = gProStImage.vecImageUrlList;
        Intrinsics.checkNotNullExpressionValue(vecImageUrlList, "vecImageUrlList");
        Iterator<T> it = vecImageUrlList.iterator();
        while (true) {
            z16 = true;
            gProStImageUrl = null;
            if (it.hasNext()) {
                obj = it.next();
                if (((GProStImageUrl) obj).levelType == i3) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        GProStImageUrl gProStImageUrl2 = (GProStImageUrl) obj;
        if (gProStImageUrl2 != null) {
            if (gProStImageUrl2.width <= 0 || gProStImageUrl2.height <= 0) {
                z16 = false;
            }
            if (z16) {
                gProStImageUrl = gProStImageUrl2;
            }
            if (gProStImageUrl != null && (pair = TuplesKt.to(Integer.valueOf(gProStImageUrl.width), Integer.valueOf(gProStImageUrl.height))) != null) {
                return pair;
            }
        }
        return TuplesKt.to(Integer.valueOf(gProStImage.width), Integer.valueOf(gProStImage.height));
    }

    @NotNull
    public static final String c(@NotNull GProStImage gProStImage, int i3) {
        Object obj;
        String str;
        String str2;
        boolean z16;
        Intrinsics.checkNotNullParameter(gProStImage, "<this>");
        if (gProStImage.isGif) {
            String str3 = gProStImage.picUrl;
            Intrinsics.checkNotNullExpressionValue(str3, "{\n        picUrl\n    }");
            return str3;
        }
        ArrayList<GProStImageUrl> vecImageUrlList = gProStImage.vecImageUrlList;
        Intrinsics.checkNotNullExpressionValue(vecImageUrlList, "vecImageUrlList");
        Iterator<T> it = vecImageUrlList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((GProStImageUrl) obj).levelType == i3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        GProStImageUrl gProStImageUrl = (GProStImageUrl) obj;
        if (gProStImageUrl != null && (str2 = gProStImageUrl.url) != null) {
            str = str2;
        } else {
            str = gProStImage.picUrl;
        }
        Intrinsics.checkNotNullExpressionValue(str, "{\n        vecImageUrlLis\u2026 ?: picUrl  // \u4fdd\u5e95\u539f\u56fe\n    }");
        return str;
    }

    @NotNull
    public static final String d(@NotNull GProStImage gProStImage) {
        Intrinsics.checkNotNullParameter(gProStImage, "<this>");
        return c(gProStImage, 3);
    }

    @NotNull
    public static final GProStImageUrl e(@NotNull GProStImage gProStImage) {
        Intrinsics.checkNotNullParameter(gProStImage, "<this>");
        return a(gProStImage, 3);
    }

    @NotNull
    public static final Pair<Integer, Integer> f(@NotNull GProStImage gProStImage) {
        Intrinsics.checkNotNullParameter(gProStImage, "<this>");
        return b(gProStImage, 3);
    }

    @NotNull
    public static final String g(@NotNull GProStImage gProStImage) {
        Intrinsics.checkNotNullParameter(gProStImage, "<this>");
        return c(gProStImage, 2);
    }

    @NotNull
    public static final GProStImageUrl h(@NotNull GProStImage gProStImage) {
        Intrinsics.checkNotNullParameter(gProStImage, "<this>");
        return a(gProStImage, 2);
    }

    @NotNull
    public static final GProStImageUrl i(@NotNull GProStImage gProStImage) {
        Intrinsics.checkNotNullParameter(gProStImage, "<this>");
        GProStImageUrl gProStImageUrl = new GProStImageUrl();
        gProStImageUrl.url = gProStImage.picUrl;
        gProStImageUrl.height = gProStImage.height;
        gProStImageUrl.width = gProStImage.width;
        return gProStImageUrl;
    }
}
