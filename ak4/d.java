package ak4;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import mqq.app.NewIntent;
import nf4.i;
import pl4.a;
import trpc.yes.common.OneLiveServerOuterClass$SRegisterInfo;
import trpc.yes.common.OneLiveServerOuterClass$SetRoomCliReq;
import trpc.yes.common.OneLiveServerOuterClass$SetRoomCliRsp;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d extends pl4.a {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements pl4.d<OneLiveServerOuterClass$SetRoomCliRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener f26256a;

        a(IResultListener iResultListener) {
            this.f26256a = iResultListener;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable OneLiveServerOuterClass$SetRoomCliRsp oneLiveServerOuterClass$SetRoomCliRsp, @Nullable FromServiceMsg fromServiceMsg) {
            if (z16) {
                i3 = i16;
            }
            if (!z16) {
                str2 = "\u7f51\u7edc\u4e0d\u7ed9\u529b";
            }
            IResultListener iResultListener = this.f26256a;
            if (iResultListener != null) {
                iResultListener.onError(i3, str2);
            }
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(OneLiveServerOuterClass$SetRoomCliRsp oneLiveServerOuterClass$SetRoomCliRsp, FromServiceMsg fromServiceMsg) {
            IResultListener iResultListener = this.f26256a;
            if (iResultListener != null) {
                iResultListener.onSuccess(oneLiveServerOuterClass$SetRoomCliRsp);
            }
        }
    }

    private static NewIntent d(int i3, String str, long j3, i iVar) {
        long j16;
        OneLiveServerOuterClass$SetRoomCliReq oneLiveServerOuterClass$SetRoomCliReq = new OneLiveServerOuterClass$SetRoomCliReq();
        if (!TextUtils.isEmpty(str)) {
            try {
                j16 = Long.parseLong(str);
            } catch (Exception e16) {
                l.f("NetCore_BaseTimiGameServlet_", "parse liveAppId error", e16);
                j16 = 0;
            }
            oneLiveServerOuterClass$SetRoomCliReq.AppID.set(j16);
        }
        oneLiveServerOuterClass$SetRoomCliReq.AnchorID.set(j3);
        oneLiveServerOuterClass$SetRoomCliReq.Scene.set(i3);
        if (iVar != null) {
            if (!TextUtils.isEmpty(iVar.f420104i)) {
                oneLiveServerOuterClass$SetRoomCliReq.StartLiveScheme.set(iVar.f420104i);
            }
            if (!TextUtils.isEmpty(iVar.f420101f)) {
                oneLiveServerOuterClass$SetRoomCliReq.BackScheme.set(iVar.f420101f);
            }
            if (!TextUtils.isEmpty(iVar.f420102g)) {
                oneLiveServerOuterClass$SetRoomCliReq.ShareQQScheme.set(iVar.f420102g);
            }
            if (!TextUtils.isEmpty(iVar.f420103h)) {
                oneLiveServerOuterClass$SetRoomCliReq.ShareWxScheme.set(iVar.f420103h);
            }
            kf4.a aVar = iVar.f420105j;
            if (aVar != null) {
                oneLiveServerOuterClass$SetRoomCliReq.GuildID.set(aVar.f412310a);
                oneLiveServerOuterClass$SetRoomCliReq.ChannelID.set(iVar.f420105j.f412311b);
            }
            OneLiveServerOuterClass$SRegisterInfo oneLiveServerOuterClass$SRegisterInfo = new OneLiveServerOuterClass$SRegisterInfo();
            oneLiveServerOuterClass$SRegisterInfo.RoomTitle.set(iVar.f420097b);
            oneLiveServerOuterClass$SRegisterInfo.CoverImg.set(iVar.f420098c);
            oneLiveServerOuterClass$SRegisterInfo.Latitude.set(iVar.f420100e);
            oneLiveServerOuterClass$SRegisterInfo.Longitude.set(iVar.f420099d);
            oneLiveServerOuterClass$SetRoomCliReq.RegInfo.set(oneLiveServerOuterClass$SRegisterInfo);
        }
        return a.C11028a.a(oneLiveServerOuterClass$SetRoomCliReq, d.class);
    }

    public static void e(int i3, String str, long j3, i iVar, IResultListener<OneLiveServerOuterClass$SetRoomCliRsp> iResultListener) {
        String str2;
        if (("sendRequest- SetRoomCliServlet - scene_" + i3 + " " + iVar) != null) {
            str2 = iVar.toString();
        } else {
            str2 = "";
        }
        l.h("TgLiveTag_NetCore_BaseTimiGameServlet_", 1, str2);
        ((pl4.c) mm4.b.b(pl4.c.class)).F1(d(i3, str, j3, iVar), OneLiveServerOuterClass$SetRoomCliRsp.class, new a(iResultListener));
    }

    @Override // pl4.a
    protected int b() {
        return 1610;
    }
}
