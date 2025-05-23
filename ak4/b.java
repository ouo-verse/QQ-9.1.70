package ak4;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import mqq.app.NewIntent;
import pl4.a;
import trpc.yes.common.OneLiveServerOuterClass$OffLiveCliReq;
import trpc.yes.common.OneLiveServerOuterClass$OffLiveCliRsp;
import trpc.yes.common.OneLiveServerOuterClass$SGameRoleInfo;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b extends pl4.a {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements pl4.d<OneLiveServerOuterClass$OffLiveCliRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener f26254a;

        a(IResultListener iResultListener) {
            this.f26254a = iResultListener;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable OneLiveServerOuterClass$OffLiveCliRsp oneLiveServerOuterClass$OffLiveCliRsp, @Nullable FromServiceMsg fromServiceMsg) {
            if (z16) {
                i3 = i16;
            }
            if (!z16) {
                str2 = "\u7f51\u7edc\u4e0d\u7ed9\u529b";
            }
            IResultListener iResultListener = this.f26254a;
            if (iResultListener != null) {
                iResultListener.onError(i3, str2);
            }
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(OneLiveServerOuterClass$OffLiveCliRsp oneLiveServerOuterClass$OffLiveCliRsp, FromServiceMsg fromServiceMsg) {
            IResultListener iResultListener = this.f26254a;
            if (iResultListener != null) {
                iResultListener.onSuccess(oneLiveServerOuterClass$OffLiveCliRsp);
            }
        }
    }

    private static NewIntent d(String str, boolean z16) {
        OneLiveServerOuterClass$OffLiveCliReq oneLiveServerOuterClass$OffLiveCliReq = new OneLiveServerOuterClass$OffLiveCliReq();
        if (!TextUtils.isEmpty(str)) {
            OneLiveServerOuterClass$SGameRoleInfo oneLiveServerOuterClass$SGameRoleInfo = new OneLiveServerOuterClass$SGameRoleInfo();
            oneLiveServerOuterClass$SGameRoleInfo.OpenID.set(str);
            oneLiveServerOuterClass$OffLiveCliReq.RoleInfo.set(oneLiveServerOuterClass$SGameRoleInfo);
        }
        oneLiveServerOuterClass$OffLiveCliReq.SwitchOn.set(z16);
        return a.C11028a.a(oneLiveServerOuterClass$OffLiveCliReq, b.class);
    }

    public static void e(String str, IResultListener<OneLiveServerOuterClass$OffLiveCliRsp> iResultListener) {
        l.h("NetCore_BaseTimiGameServlet_", 1, "sendStopLiveRequest- " + str);
        ((pl4.c) mm4.b.b(pl4.c.class)).F1(d(str, false), OneLiveServerOuterClass$OffLiveCliRsp.class, new a(iResultListener));
    }

    @Override // pl4.a
    protected int b() {
        return 1612;
    }
}
