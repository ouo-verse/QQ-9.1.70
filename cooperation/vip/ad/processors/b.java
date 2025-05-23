package cooperation.vip.ad.processors;

import com.tencent.mobileqq.cardcontainer.api.ICardContainerDataApi;
import com.tencent.mobileqq.cardcontainer.api.impl.CardContainerDataServiceImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.ad.processors.a;
import cooperation.vip.pb.TianShuAccess;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J4\u0010\u0015\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016R\u0016\u0010\u0018\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcooperation/vip/ad/processors/b;", "Lcooperation/vip/ad/processors/a;", "", "time", "", "Lcom/tencent/mobileqq/tianshu/data/TianShuAdPosItemData;", "d", "nowTime", "", "c", "", "f", "Lcooperation/vip/pb/TianShuAccess$GetAdsRsp;", "getAdsRsp", "", "Lcooperation/vip/pb/TianShuAccess$RspEntry;", "mapEntries", "", "traceId", InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, "", "i", "e", "Z", "canRequest", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public final class b implements a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean canRequest;

    @Override // cooperation.vip.ad.processors.a
    public int a() {
        return a.C10126a.h(this);
    }

    @Override // cooperation.vip.ad.processors.a
    public void b(int i3) {
        a.C10126a.a(this, i3);
    }

    @Override // cooperation.vip.ad.processors.a
    public boolean c(int nowTime) {
        this.canRequest = ((ICardContainerDataApi) QRoute.api(ICardContainerDataApi.class)).canReqContainerDataAd();
        if (a.C10126a.e(this, nowTime) && this.canRequest) {
            return true;
        }
        return false;
    }

    @Override // cooperation.vip.ad.processors.a
    @NotNull
    public List<TianShuAdPosItemData> d(int time) {
        ArrayList arrayList = new ArrayList();
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        tianShuAdPosItemData.mPosId = CardContainerDataServiceImpl.CARD_CONTAINER_POS_ID;
        tianShuAdPosItemData.mNeedCnt = 1;
        arrayList.add(tianShuAdPosItemData);
        QLog.i("ChatCardProcessor", 1, "requestAdv");
        return arrayList;
    }

    @Override // cooperation.vip.ad.processors.a
    @NotNull
    public int[] e() {
        return new int[]{1, 99};
    }

    @Override // cooperation.vip.ad.processors.a
    @NotNull
    public int[] f() {
        return new int[]{CardContainerDataServiceImpl.CARD_CONTAINER_POS_ID};
    }

    @Override // cooperation.vip.ad.processors.a
    public void g(long j3) {
        a.C10126a.i(this, j3);
    }

    @Override // cooperation.vip.ad.processors.a
    public boolean h(int i3) {
        return a.C10126a.d(this, i3);
    }

    @Override // cooperation.vip.ad.processors.a
    public void i(@NotNull TianShuAccess.GetAdsRsp getAdsRsp, @NotNull Map<Integer, TianShuAccess.RspEntry> mapEntries, @NotNull String traceId, int currentTime) {
        TianShuAccess.AdPlacementInfo adPlacementInfo;
        Intrinsics.checkNotNullParameter(getAdsRsp, "getAdsRsp");
        Intrinsics.checkNotNullParameter(mapEntries, "mapEntries");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        if (!this.canRequest) {
            return;
        }
        ICardContainerDataApi iCardContainerDataApi = (ICardContainerDataApi) QRoute.api(ICardContainerDataApi.class);
        TianShuAccess.RspEntry rspEntry = mapEntries.get(Integer.valueOf(CardContainerDataServiceImpl.CARD_CONTAINER_POS_ID));
        if (rspEntry != null) {
            adPlacementInfo = rspEntry.value;
        } else {
            adPlacementInfo = null;
        }
        iCardContainerDataApi.setNetAdPlacementInfo(adPlacementInfo);
    }

    @Override // cooperation.vip.ad.processors.a
    public long j() {
        return a.C10126a.b(this);
    }

    @Override // cooperation.vip.ad.processors.a
    public void onAccountChange() {
        a.C10126a.f(this);
    }

    @Override // cooperation.vip.ad.processors.a
    public void onDestroy() {
        a.C10126a.g(this);
    }
}
