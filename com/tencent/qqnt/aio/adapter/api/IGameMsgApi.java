package com.tencent.qqnt.aio.adapter.api;

import android.app.Activity;
import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IGameMsgApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/qqnt/aio/interceptor/sendmsg/c;", "paramWrapper", "Lcom/tencent/qqnt/aio/interceptor/sendmsg/d;", "onSendMsgIntercept", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/aio/data/AIOParam;", "aioParam", "", "startGameTeaming", "", "isShowGameTeamingIcon", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IGameMsgApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {
        public static boolean a(@NotNull IGameMsgApi iGameMsgApi) {
            return false;
        }

        public static void b(@NotNull IGameMsgApi iGameMsgApi, @NotNull Activity activity, @NotNull AIOParam aioParam) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(aioParam, "aioParam");
        }
    }

    boolean isShowGameTeamingIcon();

    @NotNull
    com.tencent.qqnt.aio.interceptor.sendmsg.d onSendMsgIntercept(@NotNull com.tencent.qqnt.aio.interceptor.sendmsg.c paramWrapper);

    void startGameTeaming(@NotNull Activity activity, @NotNull AIOParam aioParam);
}
