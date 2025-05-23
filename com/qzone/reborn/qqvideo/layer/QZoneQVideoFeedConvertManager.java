package com.qzone.reborn.qqvideo.layer;

import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellOperationInfo;
import com.qzone.publish.business.publishqueue.intimate.QZoneCoroutineScopes;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ \u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/qzone/reborn/qqvideo/layer/QZoneQVideoFeedConvertManager;", "", "Lcom/qzone/proxy/feedcomponent/manager/d;", "fakeFeedLogic", "", "clientKey", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "", "a", "Lkotlinx/coroutines/CoroutineScope;", "b", "Lkotlinx/coroutines/CoroutineScope;", "NETWORK_SCOPE", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneQVideoFeedConvertManager {

    /* renamed from: a, reason: collision with root package name */
    public static final QZoneQVideoFeedConvertManager f58793a = new QZoneQVideoFeedConvertManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final CoroutineScope NETWORK_SCOPE = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(QZoneCoroutineScopes.f51155a.a()));

    QZoneQVideoFeedConvertManager() {
    }

    public final boolean a(com.qzone.proxy.feedcomponent.manager.d fakeFeedLogic, String clientKey, BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        if (feedData.qqVideoFeedStatus != 0) {
            return false;
        }
        CellOperationInfo operationInfo = feedData.getOperationInfo();
        String str = operationInfo != null ? operationInfo.qzoneFeedid : null;
        if (TextUtils.isEmpty(str)) {
            RFWLog.e("upload2-QZoneQVideoFeedConvertManager", RFWLog.USR, "[interceptRealFeedResp] qzoneFeedid is empty");
            return false;
        }
        if (!xm.c.e(feedData)) {
            return false;
        }
        if (QZoneGetQQVideoFeedFeature.INSTANCE.a()) {
            BuildersKt__Builders_commonKt.launch$default(NETWORK_SCOPE, null, null, new QZoneQVideoFeedConvertManager$interceptRealFeedResp$1(str, feedData, fakeFeedLogic, clientKey, null), 3, null);
            return true;
        }
        RFWLog.e("upload2-QZoneQVideoFeedConvertManager", RFWLog.USR, "[interceptRealFeedResp] enableConvertFeed return false");
        return false;
    }
}
