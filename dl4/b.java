package dl4;

import android.text.TextUtils;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.data.user.SkinInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.timi.game.liveroom.impl.room.profile.data.UserFileds;
import com.tencent.timi.game.liveroom.impl.room.userlevel.bean.UserLevelToggle;
import com.tencent.timi.game.sso.request.QQLiveUserCardInfoRequest;
import java.util.ArrayList;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;
import rr4.d;
import rr4.e;
import rr4.f;
import rr4.h;
import rr4.i;
import sr4.g;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static IAegisLogApi f394065a = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    @NotNull
    private static el4.a b(d dVar) {
        h[] hVarArr;
        el4.a aVar = new el4.a();
        i iVar = dVar.f432104a;
        if (iVar != null) {
            aVar.uid = iVar.f432126a;
            aVar.nick = iVar.f432127b;
            aVar.sex = iVar.f432128c;
            aVar.headUrl = iVar.f432129d;
            aVar.hometown = iVar.f432130e;
            aVar.explicitUid = iVar.f432131f;
            aVar.signature = iVar.f432132g;
            aVar.f271218qq = iVar.f432133h;
            aVar.circleId = iVar.f432134i;
        }
        rr4.b bVar = dVar.f432105b;
        if (bVar != null) {
            aVar.fansNum = bVar.f432097b;
            aVar.followNum = bVar.f432096a;
            aVar.isFollow = bVar.f432098c;
        }
        rr4.a aVar2 = dVar.f432108e;
        if (aVar2 != null) {
            aVar.f396564e = aVar2.f432092b;
            aVar.f396565f = aVar2.f432093c;
            aVar.f396563d = aVar2.f432091a;
            aVar.f396566g = aVar2.f432094d;
            aVar.f396567h = aVar2.f432095e;
        }
        aVar.f396569j = dVar.f432110g;
        g[] gVarArr = dVar.f432106c;
        if (gVarArr != null && gVarArr.length > 0) {
            aVar.medalInfoNews = Arrays.asList(gVarArr);
            for (g gVar : dVar.f432106c) {
                if (gVar.f434388d == 7 && UserLevelToggle.INSTANCE.e()) {
                    aVar.userLevel = gVar.f434397m;
                    aVar.userLevelIcon = gVar.f434387c;
                } else if (4 == gVar.f434388d && TextUtils.isEmpty(aVar.fanIconUrl)) {
                    aVar.fansLevel = gVar.f434397m;
                    aVar.fansName = gVar.f434386b;
                    aVar.fanIconUrl = gVar.f434403s;
                    aVar.fansMedalBgImgStyle = gVar.f434407w;
                    aVar.diamondMedalBgImgStyle = gVar.f434408z;
                }
            }
        }
        e eVar = dVar.f432111h;
        if (eVar != null) {
            aVar.f396572m = eVar.f432116a;
            aVar.f396573n = eVar.f432117b;
        }
        f fVar = dVar.f432114k;
        if (fVar != null) {
            aVar.avatarStaticPendantUrl = fVar.f432118a;
            aVar.avatarDynamicPendantUrl = fVar.f432119b;
            aVar.avatarPendantResources = fVar.f432120c;
        }
        f fVar2 = dVar.f432115l;
        if (fVar2 != null && (hVarArr = fVar2.f432120c) != null) {
            aVar.skinInfo = SkinInfo.parseFrom(hVarArr);
        }
        aVar.suspectUrl = dVar.f432113j;
        aVar.enterRoomTips = dVar.f432112i;
        return aVar;
    }

    public static void c(long j3, long j16, long j17, ArrayList<UserFileds> arrayList, final fl4.a aVar) {
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveUserCardInfoRequest(j3, j16, j17, arrayList), new ILiveNetRequest.Callback() { // from class: dl4.a
            @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
            public final void onResponse(QQLiveResponse qQLiveResponse) {
                b.d(fl4.a.this, qQLiveResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(fl4.a aVar, QQLiveResponse qQLiveResponse) {
        d dVar = (d) qQLiveResponse.getRsp();
        if (!qQLiveResponse.isFailed() && dVar != null) {
            aVar.a(b(dVar));
            return;
        }
        f394065a.i("UserCardInfoUtil", 1, "[getUserCardInfo] errCode=" + qQLiveResponse.getRetCode() + ", errMsg=" + qQLiveResponse.getErrMsg());
    }
}
