package ak4;

import androidx.annotation.Nullable;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import mqq.app.NewIntent;
import pl4.a;
import trpc.yes.common.OneLiveServerOuterClass$QueryChanelAnchorCliReq;
import trpc.yes.common.OneLiveServerOuterClass$QueryChanelAnchorCliRsp;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c extends pl4.a {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements pl4.d<OneLiveServerOuterClass$QueryChanelAnchorCliRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener f26255a;

        a(IResultListener iResultListener) {
            this.f26255a = iResultListener;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable OneLiveServerOuterClass$QueryChanelAnchorCliRsp oneLiveServerOuterClass$QueryChanelAnchorCliRsp, @Nullable FromServiceMsg fromServiceMsg) {
            if (z16) {
                i3 = i16;
            }
            if (!z16) {
                str2 = "\u7f51\u7edc\u4e0d\u7ed9\u529b";
            }
            IResultListener iResultListener = this.f26255a;
            if (iResultListener != null) {
                iResultListener.onError(i3, str2);
            }
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(OneLiveServerOuterClass$QueryChanelAnchorCliRsp oneLiveServerOuterClass$QueryChanelAnchorCliRsp, FromServiceMsg fromServiceMsg) {
            IResultListener iResultListener = this.f26255a;
            if (iResultListener != null) {
                iResultListener.onSuccess(oneLiveServerOuterClass$QueryChanelAnchorCliRsp);
            }
        }
    }

    private static NewIntent f(String str, String str2) {
        OneLiveServerOuterClass$QueryChanelAnchorCliReq oneLiveServerOuterClass$QueryChanelAnchorCliReq = new OneLiveServerOuterClass$QueryChanelAnchorCliReq();
        oneLiveServerOuterClass$QueryChanelAnchorCliReq.GuildID.set(str);
        oneLiveServerOuterClass$QueryChanelAnchorCliReq.ChannelID.set(str2);
        return a.C11028a.a(oneLiveServerOuterClass$QueryChanelAnchorCliReq, c.class);
    }

    public static void g(String str, String str2, IResultListener<OneLiveServerOuterClass$QueryChanelAnchorCliRsp> iResultListener) {
        l.h("NetCore_BaseTimiGameServlet_", 1, "queryChanelAnchorRequest- " + str);
        ((pl4.c) mm4.b.b(pl4.c.class)).F1(f(str, str2), OneLiveServerOuterClass$QueryChanelAnchorCliRsp.class, new a(iResultListener));
    }

    @Override // pl4.a
    protected int b() {
        return 1614;
    }
}
