package com.tencent.mobileqq.nearbypro.api;

import android.content.Context;
import android.content.Intent;
import ca2.ChatsListInteractiveEntryModel;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0005H&J\u001a\u0010\u0014\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0012H&JJ\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000228\u0010\u001b\u001a4\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00070\u0016H&\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/api/INearbyProChatApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "getNotificationTitle", "getNotificationContent", "", "tid", "", "reportJubao", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "openNearbyProAndAIO", "", "checkTidIsSelf", "Lca2/a;", "model", "", "unreadNum", "handleInteractiveMsg", "peerUid", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", PreloadTRTCPlayerParams.KEY_SIG, "cb", "getAioSign", "qq_nearby_pro_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface INearbyProChatApi extends QRouteApi {
    boolean checkTidIsSelf(long tid);

    void getAioSign(@NotNull String peerUid, @NotNull Function2<? super byte[], ? super String, Unit> cb5);

    @NotNull
    String getNotificationContent();

    @NotNull
    String getNotificationTitle();

    void handleInteractiveMsg(@Nullable ChatsListInteractiveEntryModel model, int unreadNum);

    void openNearbyProAndAIO(@NotNull Context context, @NotNull Intent intent);

    void reportJubao(long tid);
}
