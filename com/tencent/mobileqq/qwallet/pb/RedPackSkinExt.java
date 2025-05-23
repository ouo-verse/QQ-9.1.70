package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.qwallet.pb.a;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\u001a\u0012\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0012\u0010\u0004\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00000\u0005\u001a\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00000\u0005*\b\u0012\u0004\u0012\u00020\u00000\u0005\u001a\u0010\u0010\n\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\t0\u0005\"\u0015\u0010\u000e\u001a\u00020\u000b*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u0015\u0010\u0011\u001a\u00020\u0006*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0015\u0010\u0013\u001a\u00020\u0006*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010\"\u0015\u0010\u0015\u001a\u00020\u0006*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010\"\u0015\u0010\u0017\u001a\u00020\u0006*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$RecommendSkin;", "other", "", "i", "j", "", "", "b", "g", "Lcom/tencent/mobileqq/qwallet/pb/a;", "a", "", "f", "(Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$RecommendSkin;)I", "skinId", "c", "(Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$RecommendSkin;)Ljava/lang/String;", "firstLabel", h.F, "title", "e", "previewImg", "d", "previewContent", "qqpay-api_release"}, k = 2, mv = {1, 7, 1})
@JvmName(name = "RedPackSkinExt")
/* loaded from: classes16.dex */
public final class RedPackSkinExt {

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Boolean.valueOf(((RedPackSkin$RecommendSkin) t16).has_got.get()), Boolean.valueOf(((RedPackSkin$RecommendSkin) t17).has_got.get()));
            return compareValues;
        }
    }

    @NotNull
    public static final String a(@NotNull List<? extends com.tencent.mobileqq.qwallet.pb.a> list) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(list, "<this>");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, null, null, null, 0, null, new Function1<com.tencent.mobileqq.qwallet.pb.a, CharSequence>() { // from class: com.tencent.mobileqq.qwallet.pb.RedPackSkinExt$allItemIds$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull a it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (!(it instanceof a.Promotion)) {
                    if (it instanceof a.Skin) {
                        return String.valueOf(RedPackSkinExt.f(((a.Skin) it).getValue()));
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return "Promotion:" + ((a.Promotion) it).getValue().f278703id.get();
            }
        }, 31, null);
        return joinToString$default;
    }

    @NotNull
    public static final String b(@NotNull List<RedPackSkin$RecommendSkin> list) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(list, "<this>");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, null, null, null, 0, null, new Function1<RedPackSkin$RecommendSkin, CharSequence>() { // from class: com.tencent.mobileqq.qwallet.pb.RedPackSkinExt$allSkinIds$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull RedPackSkin$RecommendSkin it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return String.valueOf(RedPackSkinExt.f(it));
            }
        }, 31, null);
        return joinToString$default;
    }

    @NotNull
    public static final String c(@NotNull RedPackSkin$RecommendSkin redPackSkin$RecommendSkin) {
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(redPackSkin$RecommendSkin, "<this>");
        List<String> list = redPackSkin$RecommendSkin.skin.labels.get();
        Intrinsics.checkNotNullExpressionValue(list, "skin.labels.get()");
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                String it5 = (String) obj;
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                if (it5.length() > 0) {
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
        String str = (String) obj;
        if (str == null) {
            return "";
        }
        return str;
    }

    @NotNull
    public static final String d(@NotNull RedPackSkin$RecommendSkin redPackSkin$RecommendSkin) {
        Intrinsics.checkNotNullParameter(redPackSkin$RecommendSkin, "<this>");
        return "hashCode " + redPackSkin$RecommendSkin.hashCode() + ", id:" + f(redPackSkin$RecommendSkin) + ", title:" + h(redPackSkin$RecommendSkin) + ", firsLabel:" + c(redPackSkin$RecommendSkin) + ", hasGot:" + redPackSkin$RecommendSkin.has_got.get() + ", img:" + e(redPackSkin$RecommendSkin);
    }

    @NotNull
    public static final String e(@NotNull RedPackSkin$RecommendSkin redPackSkin$RecommendSkin) {
        Intrinsics.checkNotNullParameter(redPackSkin$RecommendSkin, "<this>");
        String str = redPackSkin$RecommendSkin.skin.aio_res_url.get();
        Intrinsics.checkNotNullExpressionValue(str, "skin.aio_res_url.get()");
        return str;
    }

    public static final int f(@NotNull RedPackSkin$RecommendSkin redPackSkin$RecommendSkin) {
        Intrinsics.checkNotNullParameter(redPackSkin$RecommendSkin, "<this>");
        return redPackSkin$RecommendSkin.skin.skin_id.get();
    }

    @NotNull
    public static final List<RedPackSkin$RecommendSkin> g(@NotNull List<RedPackSkin$RecommendSkin> list) {
        List<RedPackSkin$RecommendSkin> mutableList;
        Intrinsics.checkNotNullParameter(list, "<this>");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
        if (mutableList.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(mutableList, new a());
        }
        return mutableList;
    }

    @NotNull
    public static final String h(@NotNull RedPackSkin$RecommendSkin redPackSkin$RecommendSkin) {
        Intrinsics.checkNotNullParameter(redPackSkin$RecommendSkin, "<this>");
        String str = redPackSkin$RecommendSkin.skin.title.get();
        Intrinsics.checkNotNullExpressionValue(str, "skin.title.get()");
        return str;
    }

    public static final boolean i(@NotNull RedPackSkin$RecommendSkin redPackSkin$RecommendSkin, @NotNull RedPackSkin$RecommendSkin other) {
        Intrinsics.checkNotNullParameter(redPackSkin$RecommendSkin, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (redPackSkin$RecommendSkin != other && f(redPackSkin$RecommendSkin) != f(other)) {
            return false;
        }
        return true;
    }

    public static final boolean j(@NotNull RedPackSkin$RecommendSkin redPackSkin$RecommendSkin, @NotNull RedPackSkin$RecommendSkin other) {
        Intrinsics.checkNotNullParameter(redPackSkin$RecommendSkin, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (redPackSkin$RecommendSkin != other && (f(redPackSkin$RecommendSkin) != f(other) || !Intrinsics.areEqual(c(redPackSkin$RecommendSkin), c(other)) || !Intrinsics.areEqual(e(redPackSkin$RecommendSkin), e(other)) || redPackSkin$RecommendSkin.has_got.get() != other.has_got.get())) {
            return false;
        }
        return true;
    }
}
