package o83;

import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.request.QFSBatchAddCollectionRequest;
import com.tencent.mobileqq.wink.request.QFSDeleteCollectionRequest;
import com.tencent.mobileqq.wink.request.QFSGetCollectionRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.TagCollection$BatchAddReq;
import feedcloud.TagCollection$DeleteReq;
import feedcloud.TagCollection$ReadListReq;
import feedcloud.TagCollection$ReadListRsp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u0003\u001a\u00020\u0002J&\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002J,\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fJ&\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fJ\u001e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\fR&\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00160\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lo83/a;", "", "", "d", "", "unifiedType", "isSuccess", "collectionAction", "isFromMusic", "c", "", "favoriteList", "Lcom/tencent/biz/richframework/network/observer/VSDispatchObserver$OnVSRspCallBack;", "onVSRspCallBack", "", "e", "unifiedId", "callback", "a", "Lfeedcloud/TagCollection$ReadListRsp;", "b", "", "", "Ljava/util/Map;", "ACTION_MESSAGES", "<init>", "()V", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f422212a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, String[]> ACTION_MESSAGES;

    static {
        HashMap hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("libTemplate", new String[]{"\u6a21\u7248\u6536\u85cf\u6210\u529f", "\u5df2\u53d6\u6d88\u6536\u85cf\u6a21\u7248"}), TuplesKt.to("meterial", new String[]{"\u9053\u5177\u6536\u85cf\u6210\u529f", "\u5df2\u53d6\u6d88\u6536\u85cf\u9053\u5177"}), TuplesKt.to("music", new String[]{"\u97f3\u4e50\u6536\u85cf\u6210\u529f", "\u5df2\u53d6\u6d88\u6536\u85cf\u97f3\u4e50"}), TuplesKt.to("default", new String[]{"\u6536\u85cf\u6210\u529f", "\u5df2\u53d6\u6d88\u6536\u85cf"}));
        ACTION_MESSAGES = hashMapOf;
    }

    a() {
    }

    public final void a(@NotNull String unifiedType, @NotNull String unifiedId, @NotNull VSDispatchObserver.OnVSRspCallBack<Object> callback) {
        Intrinsics.checkNotNullParameter(unifiedType, "unifiedType");
        Intrinsics.checkNotNullParameter(unifiedId, "unifiedId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!d()) {
            return;
        }
        QLog.i("AggregationExpController", 1, "deleteFavorite... unifiedType:" + unifiedType + " unifiedId:" + unifiedId);
        TagCollection$DeleteReq tagCollection$DeleteReq = new TagCollection$DeleteReq();
        tagCollection$DeleteReq.unified_type.set(unifiedType);
        tagCollection$DeleteReq.unified_id.set(unifiedId);
        VSNetworkHelper.getInstance().sendRequest(new QFSDeleteCollectionRequest(tagCollection$DeleteReq), callback);
    }

    public final void b(@NotNull String unifiedType, @NotNull VSDispatchObserver.OnVSRspCallBack<TagCollection$ReadListRsp> callback) {
        Intrinsics.checkNotNullParameter(unifiedType, "unifiedType");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!d()) {
            return;
        }
        QLog.i("AggregationExpController", 1, "getFavoriteListFromServer... unifiedType:" + unifiedType);
        TagCollection$ReadListReq tagCollection$ReadListReq = new TagCollection$ReadListReq();
        tagCollection$ReadListReq.unified_type.set(unifiedType);
        VSNetworkHelper.getInstance().sendRequest(new QFSGetCollectionRequest(tagCollection$ReadListReq), callback);
    }

    @NotNull
    public final String c(@NotNull String unifiedType, boolean isSuccess, boolean collectionAction, boolean isFromMusic) {
        String str;
        Intrinsics.checkNotNullParameter(unifiedType, "unifiedType");
        if (!isSuccess) {
            return "\u6536\u85cf\u5931\u8d25";
        }
        Map<String, String[]> map = ACTION_MESSAGES;
        String[] strArr = map.get(unifiedType);
        if (strArr == null) {
            if (isFromMusic) {
                strArr = map.get("music");
            } else {
                strArr = map.get("default");
            }
        }
        if (collectionAction) {
            if (strArr == null || (str = strArr[0]) == null) {
                return "";
            }
        } else if (strArr == null || (str = strArr[1]) == null) {
            return "";
        }
        return str;
    }

    public final boolean d() {
        return ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExperiment("xsp_xsj_fabuqi_sucaijuheyezhichishoucanghefenxiang");
    }

    public final void e(@NotNull String unifiedType, @NotNull List<String> favoriteList, @NotNull VSDispatchObserver.OnVSRspCallBack<Object> onVSRspCallBack) {
        Intrinsics.checkNotNullParameter(unifiedType, "unifiedType");
        Intrinsics.checkNotNullParameter(favoriteList, "favoriteList");
        Intrinsics.checkNotNullParameter(onVSRspCallBack, "onVSRspCallBack");
        if (!d()) {
            return;
        }
        if (favoriteList.isEmpty()) {
            QLog.i("AggregationExpController", 1, "sendLocalFavoriteListToServer... materialList.isEmpty");
            return;
        }
        QLog.i("AggregationExpController", 1, "sendLocalFavoriteListToServer... unifiedType:" + unifiedType + " favoriteList:" + favoriteList);
        TagCollection$BatchAddReq tagCollection$BatchAddReq = new TagCollection$BatchAddReq();
        tagCollection$BatchAddReq.unified_type.set(unifiedType);
        tagCollection$BatchAddReq.unified_id.set(favoriteList);
        VSNetworkHelper.getInstance().sendRequest(new QFSBatchAddCollectionRequest(tagCollection$BatchAddReq), onVSRspCallBack);
    }
}
