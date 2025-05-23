package com.tencent.qqnt.aio.adapter.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mvi.base.mvi.MviUIState;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H&J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H&J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0004H&J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H&J\u001a\u0010\u0011\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u0004H&J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004H&J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H&J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0004H&J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0004H&J\u0018\u0010\u001a\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0018\u0012\u0006\b\u0001\u0012\u00020\u00190\u0017H&J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH&J*\u0010\"\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020 \u0018\u00010\u001fH&\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/ITroopApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "", "groupUin", "", "openGroupProfile", "uin", "", "isGagMode", "isExitTroop", "troopUin", "isTroopMember", "memberUin", "isTroopOwner", "peerUinStr", "goToAppealForTempBlock", "showExitTroopPinToTopMsg", "ext", "openTroopSquarePage", "isTroopSquareSwitchOn", "hasTroopFlame", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "getAIVoiceChatVB", "", "groupCode", "clearGroupSquareRedpointCache", "event", "", "", "params", "troopBeaconReport", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface ITroopApi extends QRouteApi {
    void clearGroupSquareRedpointCache(long groupCode);

    @NotNull
    com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> getAIVoiceChatVB();

    void goToAppealForTempBlock(@Nullable Context context, @NotNull String peerUinStr);

    boolean hasTroopFlame(@NotNull String troopUin);

    boolean isExitTroop(@NotNull String uin);

    boolean isGagMode(@NotNull String uin);

    boolean isTroopMember(@NotNull String troopUin);

    boolean isTroopOwner(@NotNull String troopUin, @NotNull String memberUin);

    boolean isTroopSquareSwitchOn(@NotNull String troopUin);

    void openGroupProfile(@NotNull Context context, @NotNull String groupUin);

    void openTroopSquarePage(@NotNull String troopUin, @NotNull String ext);

    void showExitTroopPinToTopMsg(@NotNull String troopUin);

    void troopBeaconReport(@Nullable String event, @Nullable Map<String, ? extends Object> params);
}
