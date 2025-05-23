package oa4;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mvvm.c;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.z1.download.data.ZootopiaDownloadParams;
import com.tencent.mobileqq.z1.download.data.ZootopiaExtraData;
import com.tencent.mobileqq.z1.download.data.ZootopiaSummaryData;
import com.tencent.mobileqq.zplan.download.api.ICommonDownloadHelper;
import com.tencent.sqshow.zootopia.data.ButtonStatus;
import com.tencent.sqshow.zootopia.data.ZootopiaMapDetail;
import com.tencent.sqshow.zootopia.data.ZootopiaMapSimpleInfo;
import com.tencent.sqshow.zootopia.mapstatus.MapStatus;
import com.tencent.sqshow.zootopia.mapstatus.ZootopiaMapStatusManager;
import com.tencent.sqshow.zootopia.mapstatus.b;
import id3.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yb4.j;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 C2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001DB\u0007\u00a2\u0006\u0004\bA\u0010BJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\tJ\u0018\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u0013J\u0018\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0019\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\b\u0010\u001a\u001a\u00020\u0007H\u0014J\u0006\u0010\u001b\u001a\u00020\u0007J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001cH\u0016J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"H\u0016R<\u0010*\u001a*\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0&0%j\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0&`'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R<\u0010,\u001a*\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0&0%j\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0&`'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020\u001c0&8\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020\u001c0&8\u0006\u00a2\u0006\f\n\u0004\b2\u0010.\u001a\u0004\b3\u00100R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?\u00a8\u0006E"}, d2 = {"Loa4/a;", "Lcom/tencent/mobileqq/mvvm/c;", "Lcom/tencent/mobileqq/mvvm/a;", "Lpb3/a;", "Lcom/tencent/sqshow/zootopia/mapstatus/a;", "Lcom/tencent/mobileqq/z1/download/data/ZootopiaDownloadParams;", "downloadParams", "", "S1", "", "id", "M1", "Landroidx/lifecycle/LiveData;", "Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "P1", "", "O1", "Lcom/tencent/sqshow/zootopia/data/m;", "map", "", "isAutoDownload", "T1", "Lcom/tencent/sqshow/zootopia/data/ZootopiaMapSimpleInfo;", "info", "U1", "R1", "onCleared", "L1", "", "curCount", "onDownloadCountChanged", "curDownloadingCount", "onDownloadingCountChanged", "onTaskDelete", "Lcom/tencent/sqshow/zootopia/mapstatus/b;", "result", "r1", "Ljava/util/HashMap;", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/collections/HashMap;", "i", "Ljava/util/HashMap;", "downloadProgressMap", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "downloadButtonStatusMap", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "N1", "()Landroidx/lifecycle/MutableLiveData;", "downloadMapCount", "D", "Q1", "hasDownloadingTask", "Lyb4/j;", "E", "Lyb4/j;", "reserveService", "Lid3/d;", UserInfo.SEX_FEMALE, "Lid3/d;", "dtReportHelper", "Lcom/tencent/mobileqq/zplan/download/api/ICommonDownloadHelper;", "G", "Lcom/tencent/mobileqq/zplan/download/api/ICommonDownloadHelper;", "downloadHelper", "<init>", "()V", "H", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends c<com.tencent.mobileqq.mvvm.a> implements pb3.a, com.tencent.sqshow.zootopia.mapstatus.a {

    /* renamed from: C */
    private final MutableLiveData<Integer> downloadMapCount;

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData<Integer> hasDownloadingTask;

    /* renamed from: E, reason: from kotlin metadata */
    private final j reserveService;

    /* renamed from: F */
    private final d dtReportHelper;

    /* renamed from: G, reason: from kotlin metadata */
    private final ICommonDownloadHelper downloadHelper;

    /* renamed from: i, reason: from kotlin metadata */
    private final HashMap<String, MutableLiveData<Float>> downloadProgressMap;

    /* renamed from: m */
    private final HashMap<String, MutableLiveData<ButtonStatus>> downloadButtonStatusMap;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes38.dex */
    public /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f422311a;

        static {
            int[] iArr = new int[MapStatus.values().length];
            try {
                iArr[MapStatus.MAP_STATUS_UNZIPPING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MapStatus.MAP_STATUS_DOWNLOAD_COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f422311a = iArr;
        }
    }

    private final void S1(ZootopiaDownloadParams downloadParams) {
        this.downloadHelper.startDownload(downloadParams);
    }

    public final void L1() {
        this.downloadHelper.addManagerListener(this);
        this.hasDownloadingTask.postValue(Integer.valueOf(this.downloadHelper.getDownloadingCount()));
        this.downloadMapCount.postValue(Integer.valueOf(this.downloadHelper.getCurrentDownloadCount()));
    }

    public final void M1(String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        if (this.downloadButtonStatusMap.containsKey(id5)) {
            return;
        }
        this.downloadProgressMap.put(id5, new MutableLiveData<>());
        this.downloadButtonStatusMap.put(id5, new MutableLiveData<>());
        ZootopiaMapStatusManager.f370743d.g(id5, this);
    }

    public final MutableLiveData<Integer> N1() {
        return this.downloadMapCount;
    }

    public final LiveData<Float> O1(String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        return this.downloadProgressMap.get(id5);
    }

    public final LiveData<ButtonStatus> P1(String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        return this.downloadButtonStatusMap.get(id5);
    }

    public final MutableLiveData<Integer> Q1() {
        return this.hasDownloadingTask;
    }

    public final void R1(String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        this.downloadHelper.pause(id5);
    }

    public final void T1(ZootopiaMapDetail map, boolean isAutoDownload) {
        Intrinsics.checkNotNullParameter(map, "map");
        S1(new ZootopiaDownloadParams(new ZootopiaSummaryData(String.valueOf(map.getId()), map.getMapType(), map.getTitle(), map.getBackground(), map.getButtonText(), map.getTypeIcon(), map.getTypeText()), map.getModVersionSimpleData().getCosUrl(), map.getModVersionSimpleData().getNowMapVer(), map.getModVersionSimpleData().getDataSize(), map.getModVersionSimpleData(), new ZootopiaExtraData(map.getMapProjName(), map.getIcon(), String.valueOf(map.getModVersionSimpleData().getScriptType()), map.getSceneType(), map.getShowGameHealthyLoading(), map.getModVersionSimpleData().getRunScript(), isAutoDownload, false, false, null, map.getLoadingParams(), false, 2944, null), map.getDiffPatchInfo()));
    }

    public final void U1(ZootopiaMapSimpleInfo info, boolean isAutoDownload) {
        Intrinsics.checkNotNullParameter(info, "info");
        S1(new ZootopiaDownloadParams(new ZootopiaSummaryData(String.valueOf(info.getMapID()), info.getType(), info.getName(), info.getBackground(), info.getButton(), info.getTypeIcon(), info.getTypeName()), info.getSimpleVerInfo().getModVersionSimpleData().getCosUrl(), info.getSimpleVerInfo().getModVersionSimpleData().getNowMapVer(), info.getSimpleVerInfo().getModVersionSimpleData().getDataSize(), info.getSimpleVerInfo().getModVersionSimpleData(), new ZootopiaExtraData(info.getMapProjName(), info.getBarPic(), String.valueOf(info.getSimpleVerInfo().getModVersionSimpleData().getScriptType()), info.getSceneType(), info.getShowGameHealthyLoading(), info.getSimpleVerInfo().getModVersionSimpleData().getRunScript(), isAutoDownload, false, false, null, info.getLoadingParams(), false, 2944, null), info.getSimpleVerInfo().getDiffPatchInfo()));
    }

    @Override // com.tencent.mobileqq.mvvm.c, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Iterator<Map.Entry<String, MutableLiveData<ButtonStatus>>> it = this.downloadButtonStatusMap.entrySet().iterator();
        while (it.hasNext()) {
            ZootopiaMapStatusManager.f370743d.h(it.next().getKey(), this);
        }
        this.downloadHelper.removeManagerListener(this);
    }

    @Override // pb3.a
    public void onDownloadCountChanged(int curCount) {
        this.downloadMapCount.postValue(Integer.valueOf(curCount));
    }

    @Override // pb3.a
    public void onDownloadingCountChanged(int curDownloadingCount) {
        this.hasDownloadingTask.postValue(Integer.valueOf(curDownloadingCount));
    }

    @Override // pb3.a
    public void onTaskDelete(String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        MutableLiveData<Float> mutableLiveData = this.downloadProgressMap.get(id5);
        if (mutableLiveData != null) {
            mutableLiveData.postValue(Float.valueOf(0.0f));
        }
    }

    @Override // com.tencent.sqshow.zootopia.mapstatus.a
    public void r1(com.tencent.sqshow.zootopia.mapstatus.b result) {
        Intrinsics.checkNotNullParameter(result, "result");
        String mapId = result.getMapId();
        b.MapStatusResult c16 = result.c();
        MapStatus mapStatus = c16.getMapStatus();
        float progress = c16.getProgress();
        ButtonStatus a16 = ButtonStatus.INSTANCE.a(mapStatus);
        MutableLiveData<ButtonStatus> mutableLiveData = this.downloadButtonStatusMap.get(mapId);
        if (mutableLiveData != null) {
            mutableLiveData.postValue(a16);
        }
        int i3 = b.f422311a[mapStatus.ordinal()];
        if (i3 == 1) {
            MutableLiveData<Float> mutableLiveData2 = this.downloadProgressMap.get(mapId);
            if (mutableLiveData2 != null) {
                mutableLiveData2.postValue(Float.valueOf(0.99f));
                return;
            }
            return;
        }
        if (i3 != 2) {
            MutableLiveData<Float> mutableLiveData3 = this.downloadProgressMap.get(mapId);
            if (mutableLiveData3 != null) {
                mutableLiveData3.postValue(Float.valueOf(progress * 0.99f));
                return;
            }
            return;
        }
        MutableLiveData<Float> mutableLiveData4 = this.downloadProgressMap.get(mapId);
        if (mutableLiveData4 != null) {
            mutableLiveData4.postValue(Float.valueOf(1.0f));
        }
    }

    public a() {
        super(null);
        this.downloadProgressMap = new HashMap<>();
        this.downloadButtonStatusMap = new HashMap<>();
        this.downloadMapCount = new MutableLiveData<>();
        this.hasDownloadingTask = new MutableLiveData<>();
        this.reserveService = new j();
        this.dtReportHelper = new d(null, 1, null);
        QRouteApi api = QRoute.api(ICommonDownloadHelper.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ICommonDownloadHelper::class.java)");
        this.downloadHelper = (ICommonDownloadHelper) api;
        L1();
    }

    public static /* synthetic */ void W1(a aVar, ZootopiaMapDetail zootopiaMapDetail, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        aVar.T1(zootopiaMapDetail, z16);
    }

    public static /* synthetic */ void X1(a aVar, ZootopiaMapSimpleInfo zootopiaMapSimpleInfo, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        aVar.U1(zootopiaMapSimpleInfo, z16);
    }
}
