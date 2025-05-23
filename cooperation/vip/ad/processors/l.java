package cooperation.vip.ad.processors;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import cooperation.vip.ad.processors.a;
import cooperation.vip.ad.v;
import cooperation.vip.pb.TianShuAccess;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J4\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcooperation/vip/ad/processors/l;", "Lcooperation/vip/ad/processors/a;", "", "time", "", "Lcom/tencent/mobileqq/tianshu/data/TianShuAdPosItemData;", "d", "", "f", "Lcooperation/vip/pb/TianShuAccess$GetAdsRsp;", "getAdsRsp", "", "Lcooperation/vip/pb/TianShuAccess$RspEntry;", "mapEntries", "", "traceId", InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, "", "i", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "e", "Lcooperation/vip/ad/v;", "Lcooperation/vip/ad/v;", "renewalsBarManager", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public final class l implements a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private v renewalsBarManager;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(l this$0, Map mapEntries, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mapEntries, "$mapEntries");
        if (this$0.renewalsBarManager == null) {
            this$0.renewalsBarManager = new v();
        }
        v vVar = this$0.renewalsBarManager;
        if (vVar != null) {
            vVar.g(mapEntries, i3);
        }
    }

    @Override // cooperation.vip.ad.processors.a
    public int a() {
        return a.C10126a.h(this);
    }

    @Override // cooperation.vip.ad.processors.a
    public void b(int i3) {
        a.C10126a.a(this, i3);
    }

    @Override // cooperation.vip.ad.processors.a
    public boolean c(int i3) {
        return a.C10126a.e(this, i3);
    }

    @Override // cooperation.vip.ad.processors.a
    @NotNull
    public List<TianShuAdPosItemData> d(int time) {
        ArrayList arrayList = new ArrayList();
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        tianShuAdPosItemData.mNeedCnt = 1;
        tianShuAdPosItemData.mPosId = 596;
        arrayList.add(tianShuAdPosItemData);
        return arrayList;
    }

    @Override // cooperation.vip.ad.processors.a
    @NotNull
    public int[] e() {
        return new int[]{1, 3, 2, 99};
    }

    @Override // cooperation.vip.ad.processors.a
    @NotNull
    public int[] f() {
        return new int[]{596};
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
    public void i(@NotNull TianShuAccess.GetAdsRsp getAdsRsp, @NotNull final Map<Integer, TianShuAccess.RspEntry> mapEntries, @NotNull String traceId, final int currentTime) {
        Intrinsics.checkNotNullParameter(getAdsRsp, "getAdsRsp");
        Intrinsics.checkNotNullParameter(mapEntries, "mapEntries");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: cooperation.vip.ad.processors.k
            @Override // java.lang.Runnable
            public final void run() {
                l.l(l.this, mapEntries, currentTime);
            }
        }, 500L);
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
        v vVar = this.renewalsBarManager;
        if (vVar != null) {
            vVar.h();
        }
        this.renewalsBarManager = null;
    }
}
