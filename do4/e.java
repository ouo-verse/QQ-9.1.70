package do4;

import android.content.Context;
import android.text.TextUtils;
import bo4.f;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.timi.game.databasecore.impl.YesDataBaseHelper;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.impl.db.UserInfoEntity;
import com.tencent.timi.game.userinfo.impl.db.UserInfoLiveData;
import com.tencent.timi.game.userinfo.impl.db.role.UserDefaultRoleEntity;
import com.tencent.timi.game.userinfo.impl.loader.UserRoleInfoAutoLoader;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import io4.k;
import io4.n;
import java.util.List;
import jo4.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.GameDataServerOuterClass$UserDefaultRole;
import trpc.yes.common.SafeOuterClass$GetUserPrivIdRsp;
import trpc.yes.common.UserProxyCmdOuterClass$QQGroupProInfo;
import trpc.yes.common.UserProxyCmdOuterClass$QQGroupProUserInfo;
import trpc.yes.common.UserProxyCmdOuterClass$QQUserInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 62\u00020\u0001:\u00016B\u0007\u00a2\u0006\u0004\b4\u00105J,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0016J\u001a\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\"\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006H\u0016J\"\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006H\u0016J\"\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u0006H\u0016J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u0018H\u0016J\u0012\u0010#\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u0018\u0010%\u001a\u00020\t2\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0\u0006H\u0016J<\u0010,\u001a\u00020\t2\u0006\u0010'\u001a\u00020&2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020(2\u0006\u0010*\u001a\u00020&2\u0014\u0010\b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0(\u0018\u00010\u0006H\u0016J&\u0010/\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010'\u001a\u00020&2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0\u0006H\u0016J\u001a\u00101\u001a\u0002002\b\u0010\u001c\u001a\u0004\u0018\u00010\u00022\u0006\u0010'\u001a\u00020&H\u0016J\u0010\u00102\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020&H\u0016J\b\u00103\u001a\u00020\tH\u0016\u00a8\u00067"}, d2 = {"Ldo4/e;", "Lbo4/d;", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "qqUserId", "Lcom/tencent/timi/game/userinfo/impl/db/UserInfoLiveData;", "ret", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "callback", "", "N3", "initRegisterDatabaseModelClass", "Lsg4/c;", Constants.BASE_IN_APP_NAME, "w2", "l0", "Lco4/b;", "iUserInfoView", "Lco4/d;", ICustomDataEditor.NUMBER_PARAM_2, "I3", "c1", "Lbo4/f;", "N0", "Ltrpc/yes/common/UserProxyCmdOuterClass$QQUserInfo;", "qqUserInfo", "d1", "", "userId", "b2", "j", "info", "L3", "Landroid/content/Context;", "context", "init", "Ltrpc/yes/common/SafeOuterClass$GetUserPrivIdRsp;", ICustomDataEditor.NUMBER_PARAM_3, "", VirtualAppProxy.KEY_GAME_ID, "", "userIdListParam", "scene", "Ltrpc/yes/common/GameDataServerOuterClass$UserDefaultRole;", "W", "Lbo4/c;", "listener", Constants.EMULATOR_INFO, "", "W0", "t3", "o2", "<init>", "()V", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class e implements bo4.d {

    /* renamed from: b, reason: collision with root package name */
    private static boolean f394423b;

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016JP\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"do4/e$b", "Lpl4/d;", "Ltrpc/yes/common/SafeOuterClass$GetUserPrivIdRsp;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "originalMsfRsp", "", "d", "", "isMsfSuccess", "", "msfResultCode", "timiErrCode", "timiSubErrCode", "", "timiErrMsg", "timiDisplayErrMsg", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements pl4.d<SafeOuterClass$GetUserPrivIdRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener<SafeOuterClass$GetUserPrivIdRsp> f394424a;

        b(IResultListener<SafeOuterClass$GetUserPrivIdRsp> iResultListener) {
            this.f394424a = iResultListener;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean isMsfSuccess, int msfResultCode, int timiErrCode, int timiSubErrCode, @Nullable String timiErrMsg, @Nullable String timiDisplayErrMsg, @Nullable SafeOuterClass$GetUserPrivIdRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            this.f394424a.onError(timiErrCode, timiDisplayErrMsg);
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable SafeOuterClass$GetUserPrivIdRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            this.f394424a.onSuccess(response);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"do4/e$c", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements IResultListener<IUserInfo> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener<IUserInfo> f394425a;

        c(IResultListener<IUserInfo> iResultListener) {
            this.f394425a = iResultListener;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable IUserInfo result) {
            IResultListener<IUserInfo> iResultListener = this.f394425a;
            if (iResultListener != null) {
                iResultListener.onSuccess(result);
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            IResultListener<IUserInfo> iResultListener = this.f394425a;
            if (iResultListener != null) {
                iResultListener.onError(errorCode, errorMessage);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"do4/e$d", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements IResultListener<IUserInfo> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener<IUserInfo> f394426a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CommonOuterClass$QQUserId f394427b;

        d(IResultListener<IUserInfo> iResultListener, CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
            this.f394426a = iResultListener;
            this.f394427b = commonOuterClass$QQUserId;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable IUserInfo result) {
            if (result != null) {
                IResultListener<IUserInfo> iResultListener = this.f394426a;
                if (iResultListener != null) {
                    iResultListener.onSuccess(result);
                    return;
                }
                return;
            }
            go4.d.f402750a.a(this.f394427b, this.f394426a);
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            go4.d.f402750a.a(this.f394427b, this.f394426a);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"do4/e$e", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: do4.e$e, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C10195e implements IResultListener<IUserInfo> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ UserInfoLiveData f394428a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IResultListener<IUserInfo> f394429b;

        C10195e(UserInfoLiveData userInfoLiveData, IResultListener<IUserInfo> iResultListener) {
            this.f394428a = userInfoLiveData;
            this.f394429b = iResultListener;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable IUserInfo result) {
            UserInfoLiveData userInfoLiveData = this.f394428a;
            if (userInfoLiveData != null) {
                userInfoLiveData.l(result, 2);
            }
            IResultListener<IUserInfo> iResultListener = this.f394429b;
            if (iResultListener != null) {
                iResultListener.onSuccess(result);
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            UserInfoLiveData userInfoLiveData = this.f394428a;
            if (userInfoLiveData != null) {
                userInfoLiveData.m(errorCode, errorMessage);
            }
            IResultListener<IUserInfo> iResultListener = this.f394429b;
            if (iResultListener != null) {
                iResultListener.onError(errorCode, errorMessage);
            }
        }
    }

    private final void N3(CommonOuterClass$QQUserId qqUserId, UserInfoLiveData ret, IResultListener<IUserInfo> callback) {
        go4.d.f402750a.a(qqUserId, new C10195e(ret, callback));
    }

    @Override // bo4.d
    @NotNull
    public sg4.c<? extends IUserInfo> D3(@NotNull CommonOuterClass$QQUserId qqUserId) {
        Intrinsics.checkNotNullParameter(qqUserId, "qqUserId");
        UserInfoLiveData userInfoLiveData = new UserInfoLiveData(qqUserId);
        if (!userInfoLiveData.k()) {
            N3(qqUserId, userInfoLiveData, null);
        }
        return userInfoLiveData;
    }

    @Override // bo4.d
    public void G3(@NotNull CommonOuterClass$QQUserId qqUserId, int gameId, @NotNull IResultListener<bo4.c> listener) {
        Intrinsics.checkNotNullParameter(qqUserId, "qqUserId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        g.f410756a.m(qqUserId, gameId, listener);
    }

    @Override // bo4.d
    public void I3(@NotNull CommonOuterClass$QQUserId qqUserId, @Nullable IResultListener<IUserInfo> callback) {
        Intrinsics.checkNotNullParameter(qqUserId, "qqUserId");
        k.f408119a.s(qqUserId, new d(callback, qqUserId));
    }

    @Override // bo4.d
    public void L3(@NotNull UserProxyCmdOuterClass$QQUserInfo info) {
        String str;
        UserProxyCmdOuterClass$QQGroupProUserInfo userProxyCmdOuterClass$QQGroupProUserInfo;
        PBStringField pBStringField;
        Intrinsics.checkNotNullParameter(info, "info");
        k.f408119a.j(n.f408123a.h(info));
        String str2 = info.mini_info.avatar.get();
        String str3 = info.mini_info.base_info.nick.get();
        String j3 = l.j(info.uid.get());
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            l.i("UserInfoServiceImpl ", "updateQQUserInfoToDB - " + j3);
        } else {
            l.e("UserInfoServiceImpl ", "updateQQUserInfoToDB - avatar or nick error  " + j3 + "," + str3 + "," + str2);
        }
        UserProxyCmdOuterClass$QQGroupProInfo userProxyCmdOuterClass$QQGroupProInfo = info.group_pro_info;
        if (userProxyCmdOuterClass$QQGroupProInfo != null && (userProxyCmdOuterClass$QQGroupProUserInfo = userProxyCmdOuterClass$QQGroupProInfo.group_pro_user_info) != null && (pBStringField = userProxyCmdOuterClass$QQGroupProUserInfo.avatar) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            l.b("UserInfoServiceImpl ", "updateQQUserInfoToDB - communityAvatar null  " + j3 + "," + str3 + " " + str);
        }
    }

    @Override // bo4.d
    public void N0(@NotNull CommonOuterClass$QQUserId qqUserId, @Nullable IResultListener<f> callback) {
        Intrinsics.checkNotNullParameter(qqUserId, "qqUserId");
        go4.d.f402750a.b(qqUserId, null, callback);
    }

    @Override // bo4.d
    public void W(int gameId, @NotNull List<CommonOuterClass$QQUserId> userIdListParam, int scene, @Nullable IResultListener<List<GameDataServerOuterClass$UserDefaultRole>> callback) {
        Intrinsics.checkNotNullParameter(userIdListParam, "userIdListParam");
        go4.a.f402743a.c(gameId, scene, userIdListParam, callback);
    }

    @Override // bo4.d
    public boolean W0(@Nullable CommonOuterClass$QQUserId userId, int gameId) {
        return n.f408123a.i(userId, gameId);
    }

    @Override // bo4.d
    @NotNull
    public CommonOuterClass$QQUserId b2(long userId) {
        CommonOuterClass$QQUserId commonOuterClass$QQUserId = new CommonOuterClass$QQUserId();
        commonOuterClass$QQUserId.uid.set(userId);
        commonOuterClass$QQUserId.user_from.set(1);
        return commonOuterClass$QQUserId;
    }

    @Override // bo4.d
    public void c1(@NotNull CommonOuterClass$QQUserId qqUserId, @Nullable IResultListener<IUserInfo> callback) {
        Intrinsics.checkNotNullParameter(qqUserId, "qqUserId");
        go4.d.f402750a.a(qqUserId, callback);
    }

    @Override // bo4.d
    @NotNull
    public IUserInfo d1(@NotNull UserProxyCmdOuterClass$QQUserInfo qqUserInfo) {
        Intrinsics.checkNotNullParameter(qqUserInfo, "qqUserInfo");
        return new do4.b(n.f408123a.h(qqUserInfo));
    }

    @Override // bo4.d
    public void initRegisterDatabaseModelClass() {
        YesDataBaseHelper.l(new UserInfoEntity(), new eo4.c());
        YesDataBaseHelper.l(new UserDefaultRoleEntity(), new fo4.a());
    }

    @Override // bo4.d
    public void j() {
        fo4.b.INSTANCE.a().c();
        eo4.a.INSTANCE.a().c();
        UserRoleInfoAutoLoader.INSTANCE.a().l().clear();
        f394423b = false;
    }

    @Override // bo4.d
    public void l0(@NotNull CommonOuterClass$QQUserId qqUserId, @Nullable IResultListener<IUserInfo> callback) {
        Intrinsics.checkNotNullParameter(qqUserId, "qqUserId");
        k.f408119a.s(qqUserId, new c(callback));
    }

    @Override // bo4.d
    @NotNull
    public co4.d n2(@NotNull co4.b iUserInfoView) {
        Intrinsics.checkNotNullParameter(iUserInfoView, "iUserInfoView");
        return new com.tencent.timi.game.userinfo.impl.view.a(iUserInfoView);
    }

    @Override // bo4.d
    public void n3(@NotNull IResultListener<SafeOuterClass$GetUserPrivIdRsp> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ho4.e.INSTANCE.b(new b(callback));
    }

    @Override // mm4.a
    public void o2() {
        eo4.b.INSTANCE.a().c();
        fo4.c.INSTANCE.a().c();
    }

    @Override // bo4.d
    public long t3(int gameId) {
        return n.f408123a.d(gameId);
    }

    @Override // bo4.d
    @NotNull
    public sg4.c<? extends IUserInfo> w2(@NotNull CommonOuterClass$QQUserId qqUserId) {
        Intrinsics.checkNotNullParameter(qqUserId, "qqUserId");
        return new UserInfoLiveData(qqUserId);
    }

    @Override // mm4.a
    public void init(@Nullable Context context) {
    }
}
