package com.tencent.mobileqq.vas.api;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.vas.data.SquareRecordReason;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.state.square.api.RecordSuccessListener;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u001c\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u001c\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH&J\b\u0010\u0011\u001a\u00020\u0006H&JD\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\"\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0015j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012`\u0016H&J\u0018\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH&J\u0018\u0010!\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u001aH&J\b\u0010\"\u001a\u00020\u0006H&J\n\u0010#\u001a\u0004\u0018\u00010\u0012H&J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0012H&J\\\u0010/\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122:\u0010.\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u001c\u00a2\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00060)H&J$\u00101\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00122\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000600H&J\"\u00107\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u00122\u0006\u00104\u001a\u0002032\b\u00106\u001a\u0004\u0018\u000105H&J\u0010\u00109\u001a\u00020\u00182\u0006\u00108\u001a\u00020\u0012H&J\u0014\u0010<\u001a\u00020;2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010:H&J$\u0010A\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\u00122\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020?0>H&J\b\u0010B\u001a\u00020\u0018H&J\b\u0010C\u001a\u00020\u0018H&\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasSquareApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "", "startSquareActivity", "startLibraryActivity", "startChatLandActivity", "Lcom/tencent/mobileqq/vas/data/SquareRecordReason;", "reason", "recordFilamentAvatarCover", "Lcom/tencent/state/square/api/RecordSuccessListener;", "listener", "addRecordDoneListener", "removeRecordDoneListener", "initializeSquare", "", "url", "actionName", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "", "handleSquareScheme", "", "type", "", "data", "handleOIDBPush", "appearanceKey", "gender", "refreshAppearance", "doDns", "getDnsIp", "uin", "onMusicInfoChange", "scene", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "receiverUin", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "token", "receiverUid", "callback", "getSquareAioToken", "Lkotlin/Function1;", "checkTargetInSquare", "method", "Lcom/tencent/mtt/hippy/common/HippyMap;", "readableMap", "Lcom/tencent/mtt/hippy/modules/Promise;", "promise", "onHippyMethodCall", "moduleName", "isSquareHippyModule", "Lc33/a;", "Landroidx/fragment/app/Fragment;", "getSquareFragment", "eventId", "", "", "businessParams", "reportCustomEvent", "isUsedFilament", "isDeviceSupported", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasSquareApi extends QRouteApi {
    void addRecordDoneListener(@NotNull RecordSuccessListener listener);

    void checkTargetInSquare(@NotNull String uin, @NotNull Function1<? super Boolean, Unit> callback);

    void doDns();

    @Nullable
    String getDnsIp();

    void getSquareAioToken(int scene, @NotNull String senderUin, @NotNull String receiverUin, @NotNull Function2<? super byte[], ? super String, Unit> callback);

    @NotNull
    Fragment getSquareFragment(@Nullable c33.a params);

    void handleOIDBPush(int type, @NotNull byte[] data);

    boolean handleSquareScheme(@NotNull Context context, @NotNull String url, @NotNull String actionName, @NotNull HashMap<String, String> params);

    void initializeSquare();

    boolean isDeviceSupported();

    boolean isSquareHippyModule(@NotNull String moduleName);

    boolean isUsedFilament();

    void onHippyMethodCall(@NotNull String method, @NotNull HippyMap readableMap, @Nullable Promise promise);

    void onMusicInfoChange(@NotNull String uin);

    void recordFilamentAvatarCover(@NotNull SquareRecordReason reason);

    void refreshAppearance(@NotNull String appearanceKey, int gender);

    void removeRecordDoneListener(@NotNull RecordSuccessListener listener);

    void reportCustomEvent(@NotNull String eventId, @NotNull Map<String, Object> businessParams);

    void startChatLandActivity(@NotNull Context context, @Nullable Bundle bundle);

    void startLibraryActivity(@NotNull Context context, @Nullable Bundle bundle);

    void startSquareActivity(@NotNull Context context, @Nullable Bundle bundle);
}
