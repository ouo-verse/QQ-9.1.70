package com.tencent.aio.stranger.api;

import android.app.Activity;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J0\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/aio/stranger/api/IStrangerAdapterApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "addContactFriend", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "uid", "", "nickName", "addFriendFromStrangerChat", IProfileProtocolConst.PARAM_TROOP_CODE, "chatType", "", "aio_stranger_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IStrangerAdapterApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        public static void a(@NotNull IStrangerAdapterApi iStrangerAdapterApi, @NotNull Activity activity, @NotNull String uid, @NotNull String nickName) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(uid, "uid");
            Intrinsics.checkNotNullParameter(nickName, "nickName");
        }
    }

    void addContactFriend(@NotNull Activity activity, @NotNull String uid, @NotNull String nickName);

    void addFriendFromStrangerChat(@NotNull Activity activity, @NotNull String nickName, @NotNull String troopCode, @NotNull String uid, int chatType);
}
