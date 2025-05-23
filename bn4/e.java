package bn4;

import androidx.annotation.Nullable;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import trpc.yes.common.UserProxyCmdOuterClass$ShareArkToGuildRsp;

/* compiled from: P */
/* loaded from: classes26.dex */
public class e {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements pl4.d<UserProxyCmdOuterClass$ShareArkToGuildRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener f28704a;

        a(IResultListener iResultListener) {
            this.f28704a = iResultListener;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable UserProxyCmdOuterClass$ShareArkToGuildRsp userProxyCmdOuterClass$ShareArkToGuildRsp, @Nullable FromServiceMsg fromServiceMsg) {
            l.e("ShareArkToGuildRequest", "ShareArkToGuildRequest failed : errorCode == " + i16 + ",errorMessage == " + str2);
            IResultListener iResultListener = this.f28704a;
            if (iResultListener != null) {
                iResultListener.onError(i16, str2);
            }
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(UserProxyCmdOuterClass$ShareArkToGuildRsp userProxyCmdOuterClass$ShareArkToGuildRsp, FromServiceMsg fromServiceMsg) {
            l.i("ShareArkToGuildRequest", "ShareArkToGuildRequest success");
            IResultListener iResultListener = this.f28704a;
            if (iResultListener != null) {
                iResultListener.onSuccess(userProxyCmdOuterClass$ShareArkToGuildRsp);
            }
        }
    }

    public static void a(int i3, long j3, long j16, String str, IResultListener<UserProxyCmdOuterClass$ShareArkToGuildRsp> iResultListener) {
        l.i("ShareArkToGuildRequest", "ShareArkToGuildRequest start : gameId == " + i3 + ", guildId == " + j3 + ", channelId == " + j16 + ", meta == " + str);
        ((pl4.c) mm4.b.b(pl4.c.class)).F1(f.d(j3, j16, i3, str), UserProxyCmdOuterClass$ShareArkToGuildRsp.class, new a(iResultListener));
    }
}
