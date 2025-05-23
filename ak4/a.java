package ak4;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import mqq.app.NewIntent;
import pl4.a;
import trpc.yes.common.OneLiveServerOuterClass$GetRoomSettingCliReq;
import trpc.yes.common.OneLiveServerOuterClass$GetRoomSettingCliRsp;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a extends pl4.a {

    /* compiled from: P */
    /* renamed from: ak4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    class C0042a implements pl4.d<OneLiveServerOuterClass$GetRoomSettingCliRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener f26253a;

        C0042a(IResultListener iResultListener) {
            this.f26253a = iResultListener;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable OneLiveServerOuterClass$GetRoomSettingCliRsp oneLiveServerOuterClass$GetRoomSettingCliRsp, @Nullable FromServiceMsg fromServiceMsg) {
            if (z16) {
                i3 = i16;
            }
            if (!z16) {
                str2 = "\u7f51\u7edc\u4e0d\u7ed9\u529b";
            }
            IResultListener iResultListener = this.f26253a;
            if (iResultListener != null) {
                iResultListener.onError(i3, str2);
            }
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(OneLiveServerOuterClass$GetRoomSettingCliRsp oneLiveServerOuterClass$GetRoomSettingCliRsp, FromServiceMsg fromServiceMsg) {
            IResultListener iResultListener = this.f26253a;
            if (iResultListener != null) {
                iResultListener.onSuccess(oneLiveServerOuterClass$GetRoomSettingCliRsp);
            }
        }
    }

    private static NewIntent d(int i3, String str, long j3) {
        long j16;
        OneLiveServerOuterClass$GetRoomSettingCliReq oneLiveServerOuterClass$GetRoomSettingCliReq = new OneLiveServerOuterClass$GetRoomSettingCliReq();
        if (!TextUtils.isEmpty(str)) {
            try {
                j16 = Long.parseLong(str);
            } catch (Exception e16) {
                l.f("NetCore_BaseTimiGameServlet_", "parse liveAppId error", e16);
                j16 = 0;
            }
            oneLiveServerOuterClass$GetRoomSettingCliReq.AppID.set(j16);
        }
        oneLiveServerOuterClass$GetRoomSettingCliReq.AnchorID.set(j3);
        return a.C11028a.a(oneLiveServerOuterClass$GetRoomSettingCliReq, a.class);
    }

    public static void e(int i3, String str, long j3, IResultListener<OneLiveServerOuterClass$GetRoomSettingCliRsp> iResultListener) {
        l.h("TgLiveTag_NetCore_BaseTimiGameServlet_", 1, "GetRoomSettingCliServlet sendRequest- scene_" + i3);
        ((pl4.c) mm4.b.b(pl4.c.class)).F1(d(i3, str, j3), OneLiveServerOuterClass$GetRoomSettingCliRsp.class, new C0042a(iResultListener));
    }

    @Override // pl4.a
    protected int b() {
        return 1611;
    }
}
