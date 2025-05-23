package ea;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\u001a%\u0010\u0005\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006\"5\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007j\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\b`\t*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"(\u0010\u0012\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\r\u001a\u00020\u00038F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\"(\u0010\u0015\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\r\u001a\u00020\u00038F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011\"(\u0010\u0018\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\r\u001a\u00020\u00038F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011\"(\u0010\u001b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\r\u001a\u00020\u00038F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011\"(\u0010\u001e\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\r\u001a\u00020\u00038F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "", "key", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "a", "(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;Ljava/lang/String;I)Ljava/lang/Integer;", "Ljava/util/HashMap;", "Ljava/io/Serializable;", "Lkotlin/collections/HashMap;", "d", "(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)Ljava/util/HashMap;", "nonNullExtData", "value", "e", "(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)I", "j", "(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;I)V", "validStatus", "g", "l", "viewTypeInMediaList", "f", "k", "viewTypeCount", "c", "i", "indexInSelectedMedia", "b", h.F, "imageLayoutPosition", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {
    public static final Integer a(LocalMediaInfo localMediaInfo, String key, int i3) {
        Serializable serializable;
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        HashMap<String, Serializable> hashMap = localMediaInfo.extData;
        if (hashMap != null) {
            Serializable serializable2 = hashMap.get(key);
            if (serializable2 == null) {
                serializable2 = Integer.valueOf(i3);
            }
            serializable = serializable2;
        } else {
            serializable = null;
        }
        if (serializable instanceof Integer) {
            return (Integer) serializable;
        }
        return null;
    }

    public static final int b(LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        Integer a16 = a(localMediaInfo, "extImageLayoutPosition", 0);
        if (a16 != null) {
            return a16.intValue();
        }
        return 0;
    }

    public static final int c(LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        Integer a16 = a(localMediaInfo, "extIndexInSelectedMedia", 0);
        if (a16 != null) {
            return a16.intValue();
        }
        return 0;
    }

    public static final HashMap<String, Serializable> d(LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        if (localMediaInfo.extData == null) {
            localMediaInfo.extData = new HashMap<>();
        }
        HashMap<String, Serializable> extData = localMediaInfo.extData;
        Intrinsics.checkNotNullExpressionValue(extData, "extData");
        return extData;
    }

    public static final int e(LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        Integer a16 = a(localMediaInfo, "validStatus", 0);
        if (a16 != null) {
            return a16.intValue();
        }
        return 0;
    }

    public static final int f(LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        Integer a16 = a(localMediaInfo, "viewTypeCount", 0);
        if (a16 != null) {
            return a16.intValue();
        }
        return 0;
    }

    public static final int g(LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        Integer a16 = a(localMediaInfo, "viewTypeInMediaList", 0);
        if (a16 != null) {
            return a16.intValue();
        }
        return 0;
    }

    public static final void h(LocalMediaInfo localMediaInfo, int i3) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        d(localMediaInfo).put("extImageLayoutPosition", Integer.valueOf(i3));
    }

    public static final void i(LocalMediaInfo localMediaInfo, int i3) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        d(localMediaInfo).put("extIndexInSelectedMedia", Integer.valueOf(i3));
    }

    public static final void j(LocalMediaInfo localMediaInfo, int i3) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        d(localMediaInfo).put("validStatus", Integer.valueOf(i3));
    }

    public static final void k(LocalMediaInfo localMediaInfo, int i3) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        d(localMediaInfo).put("viewTypeCount", Integer.valueOf(i3));
    }

    public static final void l(LocalMediaInfo localMediaInfo, int i3) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        d(localMediaInfo).put("viewTypeInMediaList", Integer.valueOf(i3));
    }
}
