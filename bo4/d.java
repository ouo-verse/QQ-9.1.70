package bo4;

import com.tencent.bugly.common.constants.Constants;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.utils.IResultListener;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.GameDataServerOuterClass$UserDefaultRole;
import trpc.yes.common.SafeOuterClass$GetUserPrivIdRsp;
import trpc.yes.common.UserProxyCmdOuterClass$QQUserInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H&J\u001a\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&J\u001a\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&J\"\u0010\r\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u000bH&J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH&J\"\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u000bH&J\"\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u000bH&J\"\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u000bH&J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H&J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H&J\b\u0010\u001c\u001a\u00020\u0003H&J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0016H&J\u0018\u0010 \u001a\u00020\u00032\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u000bH&J<\u0010'\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020!2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050#2\u0006\u0010%\u001a\u00020!2\u0014\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0#\u0018\u00010\u000bH&J&\u0010*\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020!2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u000bH&J\u001a\u0010,\u001a\u00020+2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0006\u0010\"\u001a\u00020!H&J\u0010\u0010-\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020!H&\u00a8\u0006."}, d2 = {"Lbo4/d;", "Lmm4/a;", "", "", "initRegisterDatabaseModelClass", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "qqUserId", "Lsg4/c;", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", Constants.BASE_IN_APP_NAME, "w2", "Lcom/tencent/timi/game/utils/IResultListener;", "callback", "l0", "Lco4/b;", "iUserInfoView", "Lco4/d;", ICustomDataEditor.NUMBER_PARAM_2, "I3", "c1", "Lbo4/f;", "N0", "Ltrpc/yes/common/UserProxyCmdOuterClass$QQUserInfo;", "qqUserInfo", "d1", "", "userId", "b2", "j", "info", "L3", "Ltrpc/yes/common/SafeOuterClass$GetUserPrivIdRsp;", ICustomDataEditor.NUMBER_PARAM_3, "", VirtualAppProxy.KEY_GAME_ID, "", "userIdListParam", "scene", "Ltrpc/yes/common/GameDataServerOuterClass$UserDefaultRole;", "W", "Lbo4/c;", "listener", Constants.EMULATOR_INFO, "", "W0", "t3", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public interface d extends mm4.a {
    @NotNull
    sg4.c<? extends IUserInfo> D3(@NotNull CommonOuterClass$QQUserId qqUserId);

    void G3(@NotNull CommonOuterClass$QQUserId qqUserId, int gameId, @NotNull IResultListener<c> listener);

    void I3(@NotNull CommonOuterClass$QQUserId qqUserId, @Nullable IResultListener<IUserInfo> callback);

    void L3(@NotNull UserProxyCmdOuterClass$QQUserInfo info);

    void N0(@NotNull CommonOuterClass$QQUserId qqUserId, @Nullable IResultListener<f> callback);

    void W(int gameId, @NotNull List<CommonOuterClass$QQUserId> userIdListParam, int scene, @Nullable IResultListener<List<GameDataServerOuterClass$UserDefaultRole>> callback);

    boolean W0(@Nullable CommonOuterClass$QQUserId userId, int gameId);

    @NotNull
    CommonOuterClass$QQUserId b2(long userId);

    void c1(@NotNull CommonOuterClass$QQUserId qqUserId, @Nullable IResultListener<IUserInfo> callback);

    @NotNull
    IUserInfo d1(@NotNull UserProxyCmdOuterClass$QQUserInfo qqUserInfo);

    void initRegisterDatabaseModelClass();

    void j();

    void l0(@NotNull CommonOuterClass$QQUserId qqUserId, @Nullable IResultListener<IUserInfo> callback);

    @NotNull
    co4.d n2(@NotNull co4.b iUserInfoView);

    void n3(@NotNull IResultListener<SafeOuterClass$GetUserPrivIdRsp> callback);

    long t3(int gameId);

    @NotNull
    sg4.c<? extends IUserInfo> w2(@NotNull CommonOuterClass$QQUserId qqUserId);
}
