package ga;

import com.tencent.biz.richframework.localupload.recommend.bean.RFWUploadRecommendInfo;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a%\u0010\u0005\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\t\"5\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nj\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u000b`\f*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"(\u0010\u0015\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00038F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\"(\u0010\u001a\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00078F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWUploadRecommendInfo;", "", "key", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "b", "(Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWUploadRecommendInfo;Ljava/lang/String;I)Ljava/lang/Integer;", "", "a", "(Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWUploadRecommendInfo;Ljava/lang/String;Z)Ljava/lang/Boolean;", "Ljava/util/HashMap;", "Ljava/io/Serializable;", "Lkotlin/collections/HashMap;", "d", "(Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWUploadRecommendInfo;)Ljava/util/HashMap;", "nonNullExtData", "value", "e", "(Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWUploadRecommendInfo;)I", "g", "(Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWUploadRecommendInfo;I)V", "viewTypeInMediaList", "c", "(Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWUploadRecommendInfo;)Z", "f", "(Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWUploadRecommendInfo;Z)V", "itemViewNeedShowReason", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {
    public static final Boolean a(RFWUploadRecommendInfo rFWUploadRecommendInfo, String key, boolean z16) {
        Serializable serializable;
        Intrinsics.checkNotNullParameter(rFWUploadRecommendInfo, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        HashMap<String, Serializable> extData = rFWUploadRecommendInfo.getExtData();
        if (extData != null) {
            Serializable serializable2 = extData.get(key);
            if (serializable2 == null) {
                serializable2 = Boolean.valueOf(z16);
            }
            serializable = serializable2;
        } else {
            serializable = null;
        }
        if (serializable instanceof Boolean) {
            return (Boolean) serializable;
        }
        return null;
    }

    public static final Integer b(RFWUploadRecommendInfo rFWUploadRecommendInfo, String key, int i3) {
        Serializable serializable;
        Intrinsics.checkNotNullParameter(rFWUploadRecommendInfo, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        HashMap<String, Serializable> extData = rFWUploadRecommendInfo.getExtData();
        if (extData != null) {
            Serializable serializable2 = extData.get(key);
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

    public static final boolean c(RFWUploadRecommendInfo rFWUploadRecommendInfo) {
        Intrinsics.checkNotNullParameter(rFWUploadRecommendInfo, "<this>");
        Boolean a16 = a(rFWUploadRecommendInfo, "itemViewNeedShowReason", false);
        if (a16 != null) {
            return a16.booleanValue();
        }
        return false;
    }

    public static final HashMap<String, Serializable> d(RFWUploadRecommendInfo rFWUploadRecommendInfo) {
        Intrinsics.checkNotNullParameter(rFWUploadRecommendInfo, "<this>");
        if (rFWUploadRecommendInfo.getExtData() == null) {
            rFWUploadRecommendInfo.setExtData(new HashMap<>());
        }
        HashMap<String, Serializable> extData = rFWUploadRecommendInfo.getExtData();
        Intrinsics.checkNotNull(extData, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, java.io.Serializable?>");
        return extData;
    }

    public static final int e(RFWUploadRecommendInfo rFWUploadRecommendInfo) {
        Intrinsics.checkNotNullParameter(rFWUploadRecommendInfo, "<this>");
        Integer b16 = b(rFWUploadRecommendInfo, "viewTypeInMediaList", 0);
        if (b16 != null) {
            return b16.intValue();
        }
        return 0;
    }

    public static final void f(RFWUploadRecommendInfo rFWUploadRecommendInfo, boolean z16) {
        Intrinsics.checkNotNullParameter(rFWUploadRecommendInfo, "<this>");
        d(rFWUploadRecommendInfo).put("itemViewNeedShowReason", Boolean.valueOf(z16));
    }

    public static final void g(RFWUploadRecommendInfo rFWUploadRecommendInfo, int i3) {
        Intrinsics.checkNotNullParameter(rFWUploadRecommendInfo, "<this>");
        d(rFWUploadRecommendInfo).put("viewTypeInMediaList", Integer.valueOf(i3));
    }
}
