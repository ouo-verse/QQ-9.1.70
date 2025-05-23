package jy0;

import android.text.TextUtils;
import com.tencent.icgame.game.userinfo.api.IUserInfo;
import com.tencent.icgame.game.userinfo.impl.db.UserInfoEntity;
import com.tencent.icgame.game.utils.g;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$OnlineRouteInfoList;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.icgame.trpc.yes.common.UserProxyCmdOuterClass$GetUserInfoRsp;
import com.tencent.icgame.trpc.yes.common.UserProxyCmdOuterClass$MiniInfo;
import com.tencent.icgame.trpc.yes.common.UserProxyCmdOuterClass$QQUserInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.utils.IResultListener;
import ey0.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ly0.k;
import ly0.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ2\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0004J \u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004\u00a8\u0006\u000e"}, d2 = {"Ljy0/c;", "", "Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;", "qqUserId", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/icgame/game/userinfo/api/IUserInfo;", "callback", "Ley0/e;", "rspCallBack", "", "b", "a", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f411154a = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016JP\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"jy0/c$a", "Lox0/c;", "Lcom/tencent/icgame/trpc/yes/common/UserProxyCmdOuterClass$GetUserInfoRsp;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "originalMsfRsp", "", "d", "", "isMsfSuccess", "", "msfResultCode", "timiErrCode", "timiSubErrCode", "", "timiErrMsg", "timiDisplayErrMsg", "c", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class a implements ox0.c<UserProxyCmdOuterClass$GetUserInfoRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f411155a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IResultListener<IUserInfo> f411156b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ IResultListener<e> f411157c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f411158d;

        a(String str, IResultListener<IUserInfo> iResultListener, IResultListener<e> iResultListener2, long j3) {
            this.f411155a = str;
            this.f411156b = iResultListener;
            this.f411157c = iResultListener2;
            this.f411158d = j3;
        }

        @Override // ox0.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean isMsfSuccess, int msfResultCode, int timiErrCode, int timiSubErrCode, @Nullable String timiErrMsg, @Nullable String timiDisplayErrMsg, @Nullable UserProxyCmdOuterClass$GetUserInfoRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            IResultListener<IUserInfo> iResultListener = this.f411156b;
            if (iResultListener != null) {
                iResultListener.onError(timiErrCode, timiErrMsg);
            }
            IResultListener<e> iResultListener2 = this.f411157c;
            if (iResultListener2 != null) {
                iResultListener2.onError(timiErrCode, timiErrMsg);
            }
            g.d("ICGameGetUserInfoRequest", "requestUserInfo - onError -" + timiErrMsg + "-" + timiDisplayErrMsg + " " + this.f411155a);
        }

        @Override // ox0.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable UserProxyCmdOuterClass$GetUserInfoRsp response, @NotNull FromServiceMsg originalMsfRsp) {
            UserProxyCmdOuterClass$QQUserInfo userProxyCmdOuterClass$QQUserInfo;
            String str;
            IUserInfo iUserInfo;
            int i3;
            UserProxyCmdOuterClass$QQUserInfo userProxyCmdOuterClass$QQUserInfo2;
            PBInt32Field pBInt32Field;
            CommonOuterClass$OnlineRouteInfoList commonOuterClass$OnlineRouteInfoList;
            UserProxyCmdOuterClass$QQUserInfo userProxyCmdOuterClass$QQUserInfo3;
            UserProxyCmdOuterClass$MiniInfo userProxyCmdOuterClass$MiniInfo;
            PBStringField pBStringField;
            UserProxyCmdOuterClass$QQUserInfo userProxyCmdOuterClass$QQUserInfo4;
            Intrinsics.checkNotNullParameter(originalMsfRsp, "originalMsfRsp");
            CommonOuterClass$OnlineRouteInfoList commonOuterClass$OnlineRouteInfoList2 = null;
            if (response != null && (userProxyCmdOuterClass$QQUserInfo4 = response.user_info) != null) {
                userProxyCmdOuterClass$QQUserInfo = userProxyCmdOuterClass$QQUserInfo4.get();
            } else {
                userProxyCmdOuterClass$QQUserInfo = null;
            }
            if (response != null && (userProxyCmdOuterClass$QQUserInfo3 = response.user_info) != null && (userProxyCmdOuterClass$MiniInfo = userProxyCmdOuterClass$QQUserInfo3.mini_info) != null && (pBStringField = userProxyCmdOuterClass$MiniInfo.avatar) != null) {
                str = pBStringField.get();
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                g.d("ICGameGetUserInfoRequest", "requestUserInfo - avatarUrl error " + str + " " + this.f411155a);
            }
            boolean z16 = false;
            if (userProxyCmdOuterClass$QQUserInfo != null) {
                UserInfoEntity g16 = n.f415773a.g(userProxyCmdOuterClass$QQUserInfo);
                k kVar = k.f415769a;
                kVar.j(g16);
                iUserInfo = kVar.i(g16);
                IResultListener<IUserInfo> iResultListener = this.f411156b;
                if (iResultListener != null) {
                    iResultListener.onSuccess(iUserInfo);
                }
                if (userProxyCmdOuterClass$QQUserInfo.uid.get() == ((mx0.a) qx0.a.b(mx0.a.class)).h()) {
                    ((mx0.a) qx0.a.b(mx0.a.class)).v(vx0.a.a(userProxyCmdOuterClass$QQUserInfo.uid.get()), userProxyCmdOuterClass$QQUserInfo.yes_uid.get());
                }
            } else {
                IResultListener<IUserInfo> iResultListener2 = this.f411156b;
                if (iResultListener2 != null) {
                    iResultListener2.onError(0, "data error");
                }
                iUserInfo = null;
            }
            if (response != null && (commonOuterClass$OnlineRouteInfoList = response.route_list) != null) {
                commonOuterClass$OnlineRouteInfoList2 = commonOuterClass$OnlineRouteInfoList.get();
            }
            e eVar = new e(iUserInfo, commonOuterClass$OnlineRouteInfoList2);
            if (response != null && (userProxyCmdOuterClass$QQUserInfo2 = response.user_info) != null && (pBInt32Field = userProxyCmdOuterClass$QQUserInfo2.friend_switch) != null) {
                i3 = pBInt32Field.get();
            } else {
                i3 = 1;
            }
            if (i3 == 0) {
                z16 = true;
            }
            eVar.b(z16);
            IResultListener<e> iResultListener3 = this.f411157c;
            if (iResultListener3 != null) {
                iResultListener3.onSuccess(eVar);
            }
            g.h("ICGameGetUserInfoRequest", "requestUserInfo - success " + this.f411155a + " " + this.f411158d + " " + eVar.getCanAddQQFriendOpen());
        }
    }

    c() {
    }

    public final void a(@NotNull CommonOuterClass$QQUserId qqUserId, @Nullable IResultListener<IUserInfo> callback) {
        Intrinsics.checkNotNullParameter(qqUserId, "qqUserId");
        b(qqUserId, callback, null);
    }

    public final void b(@NotNull CommonOuterClass$QQUserId qqUserId, @Nullable IResultListener<IUserInfo> callback, @Nullable IResultListener<e> rspCallBack) {
        Intrinsics.checkNotNullParameter(qqUserId, "qqUserId");
        long j3 = qqUserId.yes_uid.get();
        String i3 = g.i(qqUserId.uid.get());
        g.h("ICGameGetUserInfoRequest", "GetUserInfoRequest - " + i3 + " " + j3);
        ((ox0.b) qx0.a.b(ox0.b.class)).E0(ky0.c.INSTANCE.a(qqUserId), UserProxyCmdOuterClass$GetUserInfoRsp.class, new a(i3, callback, rspCallBack, j3));
    }
}
