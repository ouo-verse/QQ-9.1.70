package go4;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.timi.game.userinfo.impl.loader.UserRoleInfoAutoLoader;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import io4.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jo4.g;
import jo4.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.GameDataServerOuterClass$BatchGetGameDefaultRoleRsp;
import trpc.yes.common.GameDataServerOuterClass$UserDefaultRole;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J:\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0014\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0004\u0018\u00010\u000b\u00a8\u0006\u0011"}, d2 = {"Lgo4/a;", "", "", VirtualAppProxy.KEY_GAME_ID, "", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "userIdList", "", "b", "scene", "qqUserIdList", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/GameDataServerOuterClass$UserDefaultRole;", "callback", "c", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f402743a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016JP\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"go4/a$a", "Lpl4/d;", "Ltrpc/yes/common/GameDataServerOuterClass$BatchGetGameDefaultRoleRsp;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "originalMsfRsp", "", "d", "", "isMsfSuccess", "", "msfResultCode", "timiErrCode", "timiSubErrCode", "", "timiErrMsg", "timiDisplayErrMsg", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: go4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C10393a implements pl4.d<GameDataServerOuterClass$BatchGetGameDefaultRoleRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f402744a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<CommonOuterClass$QQUserId> f402745b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ IResultListener<List<GameDataServerOuterClass$UserDefaultRole>> f402746c;

        C10393a(int i3, List<CommonOuterClass$QQUserId> list, IResultListener<List<GameDataServerOuterClass$UserDefaultRole>> iResultListener) {
            this.f402744a = i3;
            this.f402745b = list;
            this.f402746c = iResultListener;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean isMsfSuccess, int msfResultCode, int timiErrCode, int timiSubErrCode, @Nullable String timiErrMsg, @Nullable String timiDisplayErrMsg, @Nullable GameDataServerOuterClass$BatchGetGameDefaultRoleRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            l.e("BatchGetGameDefaultRoleRequest", "batchGemeDefaultRole - onError " + isMsfSuccess + "-" + msfResultCode + " -- " + timiErrCode + "-" + timiErrMsg + "-" + timiDisplayErrMsg);
            IResultListener<List<GameDataServerOuterClass$UserDefaultRole>> iResultListener = this.f402746c;
            if (iResultListener != null) {
                iResultListener.onError(timiErrCode, timiErrMsg);
            }
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable GameDataServerOuterClass$BatchGetGameDefaultRoleRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            l.i("BatchGetGameDefaultRoleRequest", "batchGemeDefaultRole - onSuccess");
            a.f402743a.b(this.f402744a, this.f402745b);
            if (response != null) {
                ArrayList arrayList = new ArrayList();
                List<GameDataServerOuterClass$UserDefaultRole> list = response.role_list.get();
                Intrinsics.checkNotNullExpressionValue(list, "response.role_list.get()");
                int i3 = this.f402744a;
                for (GameDataServerOuterClass$UserDefaultRole it : list) {
                    h hVar = h.f410758a;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    arrayList.add(hVar.c(i3, it));
                }
                g.f410756a.h(arrayList);
                IResultListener<List<GameDataServerOuterClass$UserDefaultRole>> iResultListener = this.f402746c;
                if (iResultListener != null) {
                    iResultListener.onSuccess(response.role_list.get());
                    return;
                }
                return;
            }
            IResultListener<List<GameDataServerOuterClass$UserDefaultRole>> iResultListener2 = this.f402746c;
            if (iResultListener2 != null) {
                iResultListener2.onSuccess(new ArrayList());
            }
        }
    }

    a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(int gameId, List<CommonOuterClass$QQUserId> userIdList) {
        Iterator<T> it = userIdList.iterator();
        while (it.hasNext()) {
            UserRoleInfoAutoLoader.INSTANCE.a().l().add(h.f410758a.b((CommonOuterClass$QQUserId) it.next(), Integer.valueOf(gameId)));
        }
    }

    public final void c(int gameId, int scene, @NotNull List<CommonOuterClass$QQUserId> qqUserIdList, @Nullable IResultListener<List<GameDataServerOuterClass$UserDefaultRole>> callback) {
        Intrinsics.checkNotNullParameter(qqUserIdList, "qqUserIdList");
        List<CommonOuterClass$QQUserId> a16 = m.f408122a.a(qqUserIdList);
        l.i("BatchGetGameDefaultRoleRequest", "batchGemeDefaultRole - start " + a16.size() + "," + gameId);
        ((pl4.c) mm4.b.b(pl4.c.class)).F1(ho4.a.INSTANCE.a(gameId, scene, a16), GameDataServerOuterClass$BatchGetGameDefaultRoleRsp.class, new C10393a(gameId, a16, callback));
    }
}
