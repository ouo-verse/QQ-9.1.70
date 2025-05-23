package gx0;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.liveroom.impl.room.profile.UserFileds;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.icgame.api.sso.IQQLiveSsoProxyModule;
import com.tencent.mobileqq.qqlive.callback.sso.IQQLiveProxySsoObserver;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import mz0.b;
import mz0.c;
import mz0.d;
import mz0.e;
import mz0.f;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static IAegisLogApi f403680a = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: gx0.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C10399a implements IQQLiveProxySsoObserver {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ix0.a f403681a;

        C10399a(ix0.a aVar) {
            this.f403681a = aVar;
        }

        @Override // com.tencent.mobileqq.qqlive.callback.sso.IQQLiveProxySsoObserver
        public void onFail(int i3, String str) {
            a.f403680a.i("ICGameUserCardInfoUtil", 1, "getUserCardInfo errCode=" + i3 + ",errMsg=" + str);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.sso.IQQLiveProxySsoObserver
        public void onReceive(byte[] bArr) {
            try {
                this.f403681a.a(a.c(d.c(bArr)));
            } catch (InvalidProtocolBufferNanoException e16) {
                a.f403680a.i("ICGameUserCardInfoUtil", 1, "getUserCardInfo e=" + e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NotNull
    public static hx0.a c(d dVar) {
        hx0.a aVar = new hx0.a();
        f fVar = dVar.f417851a;
        if (fVar != null) {
            aVar.uid = fVar.f417861a;
            aVar.nick = fVar.f417862b;
            aVar.sex = fVar.f417863c;
            aVar.headUrl = fVar.f417864d;
            aVar.hometown = fVar.f417865e;
            aVar.explicitUid = fVar.f417866f;
            aVar.signature = fVar.f417867g;
            aVar.f237299qq = fVar.f417868h;
            aVar.circleId = fVar.f417869i;
        }
        b bVar = dVar.f417852b;
        if (bVar != null) {
            aVar.fansNum = bVar.f417845b;
            aVar.followNum = bVar.f417844a;
            aVar.isFollow = bVar.f417846c;
        }
        mz0.a aVar2 = dVar.f417854d;
        if (aVar2 != null) {
            aVar.f406541b = aVar2.f417842b;
            aVar.f406542c = aVar2.f417843c;
            aVar.f406540a = aVar2.f417841a;
        }
        aVar.f406544e = dVar.f417856f;
        e eVar = dVar.f417857g;
        if (eVar != null) {
            aVar.f406547h = eVar.f417859a;
            aVar.f406548i = eVar.f417860b;
        }
        aVar.enterRoomTips = dVar.f417858h;
        return aVar;
    }

    public static void d(IQQLiveSDK iQQLiveSDK, long j3, ArrayList<UserFileds> arrayList, ix0.a aVar) {
        if (iQQLiveSDK != null && aVar != null) {
            if (!iQQLiveSDK.isInited()) {
                iQQLiveSDK.init(MobileQQ.sMobileQQ.peekAppRuntime(), QQLiveSDKConfigHelper.getDefIQQLiveSDK());
            }
            IQQLiveSsoProxyModule proxySsoService = iQQLiveSDK.getProxySsoService();
            c cVar = new c();
            cVar.f417847a = j3;
            xw0.b bVar = xw0.b.f448881a;
            cVar.f417850d = bVar.d();
            cVar.f417849c = bVar.h();
            if (arrayList != null && !arrayList.isEmpty()) {
                int[] iArr = new int[arrayList.size()];
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    iArr[i3] = arrayList.get(i3).ordinal();
                }
                cVar.f417848b = iArr;
            }
            proxySsoService.sendQQLiveProxyReq("trpc.qlive.trpc_user_info_svr.trpc_user_info_svr", "GetUserInfo", MessageNano.toByteArray(cVar), new C10399a(aVar));
            return;
        }
        f403680a.e("ICGameUserCardInfoUtil", 1, "getUserCardInfo sdkImpl=" + iQQLiveSDK + ",cardInfoCallback=" + aVar);
    }
}
