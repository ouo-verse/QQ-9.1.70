package go4;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.impl.db.UserInfoEntity;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import io4.k;
import io4.m;
import io4.n;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.UserProxyCmdOuterClass$BatchGetUserInfoRsp;
import trpc.yes.common.UserProxyCmdOuterClass$QQUserInfo;
import trpc.yes.common.UserProxyCmdOuterClass$RetQQUserInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ*\u0010\t\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0014\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0002\u0018\u00010\u0005\u00a8\u0006\f"}, d2 = {"Lgo4/c;", "", "", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "userIdListParam", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "callback", "", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f402748a = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016JP\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"go4/c$a", "Lpl4/d;", "Ltrpc/yes/common/UserProxyCmdOuterClass$BatchGetUserInfoRsp;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "originalMsfRsp", "", "d", "", "isMsfSuccess", "", "msfResultCode", "timiErrCode", "timiSubErrCode", "", "timiErrMsg", "timiDisplayErrMsg", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements pl4.d<UserProxyCmdOuterClass$BatchGetUserInfoRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener<List<IUserInfo>> f402749a;

        a(IResultListener<List<IUserInfo>> iResultListener) {
            this.f402749a = iResultListener;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean isMsfSuccess, int msfResultCode, int timiErrCode, int timiSubErrCode, @Nullable String timiErrMsg, @Nullable String timiDisplayErrMsg, @Nullable UserProxyCmdOuterClass$BatchGetUserInfoRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            l.e("BatchGetUserInfoRequest", "batchUserInfo - onError " + isMsfSuccess + "-" + msfResultCode + " -- " + timiErrCode + "-" + timiErrMsg + "-" + timiDisplayErrMsg);
            IResultListener<List<IUserInfo>> iResultListener = this.f402749a;
            if (iResultListener != null) {
                iResultListener.onError(timiErrCode, timiErrMsg);
            }
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable UserProxyCmdOuterClass$BatchGetUserInfoRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            List<UserProxyCmdOuterClass$RetQQUserInfo> list;
            l.i("BatchGetUserInfoRequest", "batchUserInfo - success ");
            if (response != null) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                PBRepeatMessageField<UserProxyCmdOuterClass$RetQQUserInfo> pBRepeatMessageField = response.ret_user_info_list;
                if (pBRepeatMessageField != null && (list = pBRepeatMessageField.get()) != null) {
                    for (UserProxyCmdOuterClass$RetQQUserInfo userProxyCmdOuterClass$RetQQUserInfo : list) {
                        if (TextUtils.isEmpty(userProxyCmdOuterClass$RetQQUserInfo.user_info.mini_info.avatar.get())) {
                            l.e("BatchGetUserInfoRequest", "batchUserInfo - error " + l.j(userProxyCmdOuterClass$RetQQUserInfo.user_info.uid.get()));
                        }
                        UserProxyCmdOuterClass$QQUserInfo userProxyCmdOuterClass$QQUserInfo = userProxyCmdOuterClass$RetQQUserInfo.user_info;
                        if (userProxyCmdOuterClass$QQUserInfo != null) {
                            n nVar = n.f408123a;
                            Intrinsics.checkNotNullExpressionValue(userProxyCmdOuterClass$QQUserInfo, "info.user_info");
                            UserInfoEntity h16 = nVar.h(userProxyCmdOuterClass$QQUserInfo);
                            if (h16.uid != 0) {
                                arrayList.add(h16);
                                arrayList2.add(k.f408119a.i(h16));
                            }
                        }
                    }
                }
                k.f408119a.l(arrayList);
                IResultListener<List<IUserInfo>> iResultListener = this.f402749a;
                if (iResultListener != null) {
                    iResultListener.onSuccess(arrayList2);
                    return;
                }
                return;
            }
            IResultListener<List<IUserInfo>> iResultListener2 = this.f402749a;
            if (iResultListener2 != null) {
                iResultListener2.onSuccess(new ArrayList());
            }
        }
    }

    c() {
    }

    public final void a(@NotNull List<CommonOuterClass$QQUserId> userIdListParam, @Nullable IResultListener<List<IUserInfo>> callback) {
        Intrinsics.checkNotNullParameter(userIdListParam, "userIdListParam");
        List<CommonOuterClass$QQUserId> a16 = m.f408122a.a(userIdListParam);
        l.i("BatchGetUserInfoRequest", "batchUserInfo ");
        ((pl4.c) mm4.b.b(pl4.c.class)).F1(ho4.c.INSTANCE.a(a16), UserProxyCmdOuterClass$BatchGetUserInfoRsp.class, new a(callback));
    }
}
