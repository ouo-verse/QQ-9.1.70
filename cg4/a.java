package cg4;

import ag4.i;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.utils.l;
import fg4.h;
import fg4.k;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameRoleListRsp;
import trpc.yes.common.YesGameInfoOuterClass$SetUserGameDefaultRoleRsp;
import trpc.yes.common.YesGameInfoOuterClass$YesGameRoleAbsInfo;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004J \u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0004J*\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0004\u00a8\u0006\u0011"}, d2 = {"Lcg4/a;", "", "", "yesGameId", "Lag4/i$b;", "Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameRoleListRsp;", "callback", "", "b", "Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;", "a", "Ltrpc/yes/common/YesGameInfoOuterClass$YesGameRoleAbsInfo;", "defaultAccountInfo", "Ltrpc/yes/common/YesGameInfoOuterClass$SetUserGameDefaultRoleRsp;", "c", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016JP\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"cg4/a$b", "Lpl4/d;", "Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "originalMsfRsp", "", "d", "", "isMsfSuccess", "", "msfResultCode", "timiErrCode", "timiSubErrCode", "", "timiErrMsg", "timiDisplayErrMsg", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements pl4.d<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i.b<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> f30798a;

        b(i.b<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> bVar) {
            this.f30798a = bVar;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean isMsfSuccess, int msfResultCode, int timiErrCode, int timiSubErrCode, @Nullable String timiErrMsg, @Nullable String timiDisplayErrMsg, @Nullable YesGameInfoOuterClass$GetUserGameDefaultRoleRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            i.b<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> bVar = this.f30798a;
            if (bVar != null) {
                bVar.i(false, timiErrCode, timiErrMsg, response);
            }
            l.e("GameAccountRepo_", "getDefaultGameAccountFromServer onError, isMsfSuccess:" + isMsfSuccess + ", msfResultCode:" + msfResultCode + ", timiErrCode:" + timiErrCode + ", timiSubErrCode:" + timiSubErrCode + ", timiErrMsg:" + timiErrMsg + " timiDisplayErrMsg:" + timiDisplayErrMsg);
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable YesGameInfoOuterClass$GetUserGameDefaultRoleRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            l.i("GameAccountRepo_", "getDefaultGameAccountFromServer onSuccess, rsp:" + response);
            i.b<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> bVar = this.f30798a;
            if (bVar != null) {
                bVar.i(true, 0, "", response);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016JP\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"cg4/a$c", "Lpl4/d;", "Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameRoleListRsp;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "originalMsfRsp", "", "d", "", "isMsfSuccess", "", "msfResultCode", "timiErrCode", "timiSubErrCode", "", "timiErrMsg", "timiDisplayErrMsg", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements pl4.d<YesGameInfoOuterClass$GetUserGameRoleListRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i.b<YesGameInfoOuterClass$GetUserGameRoleListRsp> f30799a;

        c(i.b<YesGameInfoOuterClass$GetUserGameRoleListRsp> bVar) {
            this.f30799a = bVar;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean isMsfSuccess, int msfResultCode, int timiErrCode, int timiSubErrCode, @Nullable String timiErrMsg, @Nullable String timiDisplayErrMsg, @Nullable YesGameInfoOuterClass$GetUserGameRoleListRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            i.b<YesGameInfoOuterClass$GetUserGameRoleListRsp> bVar = this.f30799a;
            if (bVar != null) {
                bVar.i(false, timiErrCode, timiErrMsg, response);
            }
            l.e("GameAccountRepo_", "getGameAccountListFromServer onError, isMsfSuccess:" + isMsfSuccess + ", msfResultCode:" + msfResultCode + ", timiErrCode:" + timiErrCode + ", timiSubErrCode:" + timiSubErrCode + ", timiErrMsg:" + timiErrMsg + " timiDisplayErrMsg:" + timiDisplayErrMsg);
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable YesGameInfoOuterClass$GetUserGameRoleListRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            l.i("GameAccountRepo_", "getGameAccountListFromServer onSuccess");
            if (response == null) {
                response = new YesGameInfoOuterClass$GetUserGameRoleListRsp();
            }
            i.b<YesGameInfoOuterClass$GetUserGameRoleListRsp> bVar = this.f30799a;
            if (bVar != null) {
                bVar.i(true, 0, "", response);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016JP\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"cg4/a$d", "Lpl4/d;", "Ltrpc/yes/common/YesGameInfoOuterClass$SetUserGameDefaultRoleRsp;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "originalMsfRsp", "", "d", "", "isMsfSuccess", "", "msfResultCode", "timiErrCode", "timiSubErrCode", "", "timiErrMsg", "timiDisplayErrMsg", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements pl4.d<YesGameInfoOuterClass$SetUserGameDefaultRoleRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i.b<YesGameInfoOuterClass$SetUserGameDefaultRoleRsp> f30800a;

        d(i.b<YesGameInfoOuterClass$SetUserGameDefaultRoleRsp> bVar) {
            this.f30800a = bVar;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean isMsfSuccess, int msfResultCode, int timiErrCode, int timiSubErrCode, @Nullable String timiErrMsg, @Nullable String timiDisplayErrMsg, @Nullable YesGameInfoOuterClass$SetUserGameDefaultRoleRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            i.b<YesGameInfoOuterClass$SetUserGameDefaultRoleRsp> bVar = this.f30800a;
            if (bVar != null) {
                bVar.i(false, timiErrCode, timiErrMsg, response);
            }
            l.e("GameAccountRepo_", "setDefaultGameAccount onError, isMsfSuccess:" + isMsfSuccess + ", msfResultCode:" + msfResultCode + ", timiErrCode:" + timiErrCode + ", timiSubErrCode:" + timiSubErrCode + ", timiErrMsg:" + timiErrMsg + " timiDisplayErrMsg:" + timiDisplayErrMsg);
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable YesGameInfoOuterClass$SetUserGameDefaultRoleRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            l.i("GameAccountRepo_", "setDefaultGameAccount onSuccess, rsp:" + response);
            i.b<YesGameInfoOuterClass$SetUserGameDefaultRoleRsp> bVar = this.f30800a;
            if (bVar != null) {
                bVar.i(true, 0, "", response);
            }
        }
    }

    public final void a(int yesGameId, @Nullable i.b<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> callback) {
        h.e(yesGameId, new b(callback));
    }

    public final void b(int yesGameId, @Nullable i.b<YesGameInfoOuterClass$GetUserGameRoleListRsp> callback) {
        fg4.i.e(yesGameId, new c(callback));
    }

    public final void c(int yesGameId, @Nullable YesGameInfoOuterClass$YesGameRoleAbsInfo defaultAccountInfo, @Nullable i.b<YesGameInfoOuterClass$SetUserGameDefaultRoleRsp> callback) {
        k.e(yesGameId, defaultAccountInfo, new d(callback));
    }
}
