package dg4;

import ag4.i;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.utils.l;
import fg4.g;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import pl4.d;
import trpc.yes.common.GameAuthOuterClass$CancelGameAuthRsp;
import trpc.yes.common.GameAuthOuterClass$GetGameAuthRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004J \u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0004\u00a8\u0006\u000e"}, d2 = {"Ldg4/a;", "", "", "yesGameId", "Lag4/i$b;", "Ltrpc/yes/common/GameAuthOuterClass$GetGameAuthRsp;", "callback", "", "b", "Ltrpc/yes/common/GameAuthOuterClass$CancelGameAuthRsp;", "cb", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016JP\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"dg4/a$b", "Lpl4/d;", "Ltrpc/yes/common/GameAuthOuterClass$CancelGameAuthRsp;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "originalMsfRsp", "", "d", "", "isMsfSuccess", "", "msfResultCode", "timiErrCode", "timiSubErrCode", "", "timiErrMsg", "timiDisplayErrMsg", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements d<GameAuthOuterClass$CancelGameAuthRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i.b<GameAuthOuterClass$CancelGameAuthRsp> f393803a;

        b(i.b<GameAuthOuterClass$CancelGameAuthRsp> bVar) {
            this.f393803a = bVar;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean isMsfSuccess, int msfResultCode, int timiErrCode, int timiSubErrCode, @Nullable String timiErrMsg, @Nullable String timiDisplayErrMsg, @Nullable GameAuthOuterClass$CancelGameAuthRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            l.e("AuthToGetGameInfoRepo_", "cancelGameAuth onError, isMsfSuccess:" + isMsfSuccess + ", msfResultCode:" + msfResultCode + ", timiErrCode:" + timiErrCode + ", timiSubErrCode:" + timiSubErrCode + ", timiErrMsg:" + timiErrMsg + " timiDisplayErrMsg:" + timiDisplayErrMsg);
            i.b<GameAuthOuterClass$CancelGameAuthRsp> bVar = this.f393803a;
            if (bVar != null) {
                bVar.i(false, timiErrCode, timiErrMsg, response);
            }
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable GameAuthOuterClass$CancelGameAuthRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            l.i("AuthToGetGameInfoRepo_", "cancelGameAuth onSuccess");
            i.b<GameAuthOuterClass$CancelGameAuthRsp> bVar = this.f393803a;
            if (bVar != null) {
                bVar.i(true, 0, "", response);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016JP\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"dg4/a$c", "Lpl4/d;", "Ltrpc/yes/common/GameAuthOuterClass$GetGameAuthRsp;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "originalMsfRsp", "", "d", "", "isMsfSuccess", "", "msfResultCode", "timiErrCode", "timiSubErrCode", "", "timiErrMsg", "timiDisplayErrMsg", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements d<GameAuthOuterClass$GetGameAuthRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i.b<GameAuthOuterClass$GetGameAuthRsp> f393804a;

        c(i.b<GameAuthOuterClass$GetGameAuthRsp> bVar) {
            this.f393804a = bVar;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean isMsfSuccess, int msfResultCode, int timiErrCode, int timiSubErrCode, @Nullable String timiErrMsg, @Nullable String timiDisplayErrMsg, @Nullable GameAuthOuterClass$GetGameAuthRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            l.e("AuthToGetGameInfoRepo_", "getAuthInfoRsp onError, isMsfSuccess:" + isMsfSuccess + ", msfResultCode:" + msfResultCode + ", timiErrCode:" + timiErrCode + ", timiSubErrCode:" + timiSubErrCode + ", timiErrMsg:" + timiErrMsg + " timiDisplayErrMsg:" + timiDisplayErrMsg);
            i.b<GameAuthOuterClass$GetGameAuthRsp> bVar = this.f393804a;
            if (bVar != null) {
                bVar.i(false, timiErrCode, timiErrMsg, response);
            }
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable GameAuthOuterClass$GetGameAuthRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            l.i("AuthToGetGameInfoRepo_", "getAuthInfoRsp onSuccess");
            if (response != null) {
                i.b<GameAuthOuterClass$GetGameAuthRsp> bVar = this.f393804a;
                if (bVar != null) {
                    bVar.i(true, 0, "", response);
                    return;
                }
                return;
            }
            i.b<GameAuthOuterClass$GetGameAuthRsp> bVar2 = this.f393804a;
            if (bVar2 != null) {
                bVar2.i(false, -1, "", null);
            }
        }
    }

    public final void a(int yesGameId, @Nullable i.b<GameAuthOuterClass$CancelGameAuthRsp> cb5) {
        fg4.b.e(yesGameId, 0, new b(cb5));
    }

    public final void b(int yesGameId, @Nullable i.b<GameAuthOuterClass$GetGameAuthRsp> callback) {
        g.e(yesGameId, 0, new c(callback));
    }
}
