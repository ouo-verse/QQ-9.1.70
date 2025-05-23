package go4;

import androidx.annotation.Nullable;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.utils.IResultListener;
import java.util.List;
import trpc.yes.common.UserProxyCmdOuterClass$BatchGetUidByTinyIdRsp;
import trpc.yes.common.UserProxyCmdOuterClass$TinyIdUinPair;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements pl4.d<UserProxyCmdOuterClass$BatchGetUidByTinyIdRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener f402747a;

        a(IResultListener iResultListener) {
            this.f402747a = iResultListener;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable UserProxyCmdOuterClass$BatchGetUidByTinyIdRsp userProxyCmdOuterClass$BatchGetUidByTinyIdRsp, @Nullable FromServiceMsg fromServiceMsg) {
            this.f402747a.onError(i16, str2);
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(UserProxyCmdOuterClass$BatchGetUidByTinyIdRsp userProxyCmdOuterClass$BatchGetUidByTinyIdRsp, FromServiceMsg fromServiceMsg) {
            if (userProxyCmdOuterClass$BatchGetUidByTinyIdRsp != null && userProxyCmdOuterClass$BatchGetUidByTinyIdRsp.has()) {
                this.f402747a.onSuccess(userProxyCmdOuterClass$BatchGetUidByTinyIdRsp.tiny_id_uid_pair_list.get());
            } else {
                this.f402747a.onError(-1, "response is null");
            }
        }
    }

    public static void a(List<Long> list, IResultListener<List<UserProxyCmdOuterClass$TinyIdUinPair>> iResultListener) {
        ((pl4.c) mm4.b.b(pl4.c.class)).F1(ho4.b.d(list), UserProxyCmdOuterClass$BatchGetUidByTinyIdRsp.class, new a(iResultListener));
    }
}
