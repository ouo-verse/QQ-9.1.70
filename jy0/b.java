package jy0;

import android.text.TextUtils;
import com.tencent.icgame.game.userinfo.api.IUserInfo;
import com.tencent.icgame.game.userinfo.impl.db.UserInfoEntity;
import com.tencent.icgame.game.utils.g;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.icgame.trpc.yes.common.UserProxyCmdOuterClass$BatchGetUserInfoRsp;
import com.tencent.icgame.trpc.yes.common.UserProxyCmdOuterClass$QQUserInfo;
import com.tencent.icgame.trpc.yes.common.UserProxyCmdOuterClass$RetQQUserInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.utils.IResultListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ly0.k;
import ly0.m;
import ly0.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ*\u0010\t\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0014\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0002\u0018\u00010\u0005\u00a8\u0006\f"}, d2 = {"Ljy0/b;", "", "", "Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;", "userIdListParam", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/icgame/game/userinfo/api/IUserInfo;", "callback", "", "a", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f411152a = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016JP\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"jy0/b$a", "Lox0/c;", "Lcom/tencent/icgame/trpc/yes/common/UserProxyCmdOuterClass$BatchGetUserInfoRsp;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "originalMsfRsp", "", "d", "", "isMsfSuccess", "", "msfResultCode", "timiErrCode", "timiSubErrCode", "", "timiErrMsg", "timiDisplayErrMsg", "c", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class a implements ox0.c<UserProxyCmdOuterClass$BatchGetUserInfoRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener<List<IUserInfo>> f411153a;

        a(IResultListener<List<IUserInfo>> iResultListener) {
            this.f411153a = iResultListener;
        }

        @Override // ox0.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean isMsfSuccess, int msfResultCode, int timiErrCode, int timiSubErrCode, @Nullable String timiErrMsg, @Nullable String timiDisplayErrMsg, @Nullable UserProxyCmdOuterClass$BatchGetUserInfoRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            g.d("ICGameBatchGetUserInfoRequest", "batchUserInfo - onError " + isMsfSuccess + "-" + msfResultCode + " -- " + timiErrCode + "-" + timiErrMsg + "-" + timiDisplayErrMsg);
            IResultListener<List<IUserInfo>> iResultListener = this.f411153a;
            if (iResultListener != null) {
                iResultListener.onError(timiErrCode, timiErrMsg);
            }
        }

        @Override // ox0.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable UserProxyCmdOuterClass$BatchGetUserInfoRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            List<UserProxyCmdOuterClass$RetQQUserInfo> list;
            g.h("ICGameBatchGetUserInfoRequest", "batchUserInfo - success ");
            if (response != null) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                PBRepeatMessageField<UserProxyCmdOuterClass$RetQQUserInfo> pBRepeatMessageField = response.ret_user_info_list;
                if (pBRepeatMessageField != null && (list = pBRepeatMessageField.get()) != null) {
                    for (UserProxyCmdOuterClass$RetQQUserInfo userProxyCmdOuterClass$RetQQUserInfo : list) {
                        if (TextUtils.isEmpty(userProxyCmdOuterClass$RetQQUserInfo.user_info.mini_info.avatar.get())) {
                            g.d("ICGameBatchGetUserInfoRequest", "batchUserInfo - error " + g.i(userProxyCmdOuterClass$RetQQUserInfo.user_info.uid.get()));
                        }
                        UserProxyCmdOuterClass$QQUserInfo userProxyCmdOuterClass$QQUserInfo = userProxyCmdOuterClass$RetQQUserInfo.user_info;
                        if (userProxyCmdOuterClass$QQUserInfo != null) {
                            n nVar = n.f415773a;
                            Intrinsics.checkNotNullExpressionValue(userProxyCmdOuterClass$QQUserInfo, "info.user_info");
                            UserInfoEntity g16 = nVar.g(userProxyCmdOuterClass$QQUserInfo);
                            if (g16.uid != 0) {
                                arrayList.add(g16);
                                arrayList2.add(k.f415769a.i(g16));
                            }
                        }
                    }
                }
                k.f415769a.l(arrayList);
                IResultListener<List<IUserInfo>> iResultListener = this.f411153a;
                if (iResultListener != null) {
                    iResultListener.onSuccess(arrayList2);
                    return;
                }
                return;
            }
            IResultListener<List<IUserInfo>> iResultListener2 = this.f411153a;
            if (iResultListener2 != null) {
                iResultListener2.onSuccess(new ArrayList());
            }
        }
    }

    b() {
    }

    public final void a(@NotNull List<CommonOuterClass$QQUserId> userIdListParam, @Nullable IResultListener<List<IUserInfo>> callback) {
        Intrinsics.checkNotNullParameter(userIdListParam, "userIdListParam");
        List<CommonOuterClass$QQUserId> a16 = m.f415772a.a(userIdListParam);
        g.h("ICGameBatchGetUserInfoRequest", "batchUserInfo ");
        ((ox0.b) qx0.a.b(ox0.b.class)).E0(ky0.b.INSTANCE.a(a16), UserProxyCmdOuterClass$BatchGetUserInfoRsp.class, new a(callback));
    }
}
