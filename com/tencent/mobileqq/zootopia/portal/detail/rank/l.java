package com.tencent.mobileqq.zootopia.portal.detail.rank;

import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zootopia.portal.detail.ao;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.widget.ToastView;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.sqshow.zootopia.data.ErrorMessage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import zb3.ZootopiaRankConfigData;
import zb3.ZootopiaRankHeadNickData;
import zb3.ZootopiaRankShowInfo;
import zb3.ZootopiaUserRankData;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0019\u0018\u0000 I2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002JKB\u001f\u0012\u0006\u0010!\u001a\u00020\u0006\u0012\u0006\u0010$\u001a\u00020\u0006\u0012\u0006\u0010F\u001a\u00020\u0002\u00a2\u0006\u0004\bG\u0010HJ.\u0010\u000b\u001a\u00020\n2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\"\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0002J.\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0006R\u0017\u0010!\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010$\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010 R\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00140%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020+0%8\u0006\u00a2\u0006\f\n\u0004\b,\u0010'\u001a\u0004\b-\u0010)R\u001d\u00102\u001a\b\u0012\u0004\u0012\u00020/0%8\u0006\u00a2\u0006\f\n\u0004\b0\u0010'\u001a\u0004\b1\u0010)R#\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006038\u0006\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R#\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004038\u0006\u00a2\u0006\f\n\u0004\b9\u00105\u001a\u0004\b:\u00107R#\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0014038\u0006\u00a2\u0006\f\n\u0004\b<\u00105\u001a\u0004\b=\u00107R#\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0014038\u0006\u00a2\u0006\f\n\u0004\b\u001e\u00105\u001a\u0004\b?\u00107R\"\u0010E\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010\u001e\u001a\u0004\bB\u0010 \"\u0004\bC\u0010D\u00a8\u0006L"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/detail/rank/l;", "Lcom/tencent/mobileqq/mvvm/c;", "Lcom/tencent/mobileqq/zootopia/portal/detail/ao;", "", "", "openIds", "", "showSwitch", "start", "end", "", ICustomDataEditor.STRING_ARRAY_PARAM_2, "c2", "error", "message", "d2", "", "Lzb3/l;", "userDetailList", "X1", "Lzb3/k;", "result", "Z1", "Lzb3/m;", "switchInfo", "f2", "b2", "switchType", "e2", "i", "I", "getMapId", "()I", "mapId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getRankId", "rankId", "Landroidx/lifecycle/MutableLiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "W1", "()Landroidx/lifecycle/MutableLiveData;", "rank", "Lcom/tencent/mobileqq/zootopia/portal/detail/rank/l$b;", "D", "U1", ToastView.ICON_LOADING, "Lcom/tencent/sqshow/zootopia/data/a;", "E", "S1", "errorMessage", "", UserInfo.SEX_FEMALE, "Ljava/util/Map;", "getSwitchDetailLoadMoreMap", "()Ljava/util/Map;", "switchDetailLoadMoreMap", "G", "getSwitchSummeryLoadMoreMap", "switchSummeryLoadMoreMap", "H", "getSwitchSummeryCacheDataMap", "switchSummeryCacheDataMap", "getSwitchDetailCacheDataMap", "switchDetailCacheDataMap", "J", "T1", "setLastLoadingSwitchType", "(I)V", "lastLoadingSwitchType", "repository", "<init>", "(IILcom/tencent/mobileqq/zootopia/portal/detail/ao;)V", "K", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class l extends com.tencent.mobileqq.mvvm.c<ao> {

    /* renamed from: K, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int L = 1;
    private static final int M = 2;
    private static final int N = 3;
    private static final int P = 4;
    private static final int Q = 30;

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<zb3.k> rank;

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData<LoadingMessage> loading;

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData<ErrorMessage> errorMessage;

    /* renamed from: F, reason: from kotlin metadata */
    private final Map<Integer, Integer> switchDetailLoadMoreMap;

    /* renamed from: G, reason: from kotlin metadata */
    private final Map<Integer, String> switchSummeryLoadMoreMap;

    /* renamed from: H, reason: from kotlin metadata */
    private final Map<Integer, zb3.k> switchSummeryCacheDataMap;

    /* renamed from: I, reason: from kotlin metadata */
    private final Map<Integer, zb3.k> switchDetailCacheDataMap;

    /* renamed from: J, reason: from kotlin metadata */
    private int lastLoadingSwitchType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int mapId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int rankId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/detail/rank/l$a;", "", "", "RANK_LOADING_STATUS_LOADING", "I", "d", "()I", "RANK_LOADING_STATUS_ERROR", "b", "RANK_LOADING_STATUS_EMPTY", "a", "RANK_LOADING_STATUS_HIDE", "c", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.portal.detail.rank.l$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return l.N;
        }

        public final int b() {
            return l.M;
        }

        public final int c() {
            return l.P;
        }

        public final int d() {
            return l.L;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/portal/detail/rank/l$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "", "Lzb3/l;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.api.e<List<? extends ZootopiaRankHeadNickData>> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f328828e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f328829f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f328830h;

        c(int i3, int i16, int i17) {
            this.f328828e = i3;
            this.f328829f = i16;
            this.f328830h = i17;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(List<ZootopiaRankHeadNickData> result) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (!result.isEmpty()) {
                l.this.U1().setValue(new LoadingMessage(l.INSTANCE.c()));
            }
            l.this.X1(this.f328828e, this.f328829f, this.f328830h, result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            l.this.d2(this.f328828e, error, message);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zootopia/portal/detail/rank/l$d", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lzb3/k;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements com.tencent.mobileqq.zootopia.api.e<zb3.k> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f328832e;

        d(int i3) {
            this.f328832e = i3;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(zb3.k result) {
            Intrinsics.checkNotNullParameter(result, "result");
            l.this.Z1(result, result.getShowSwitch());
            if (l.this.getLastLoadingSwitchType() == result.getShowSwitch() || l.this.getLastLoadingSwitchType() == 0) {
                l.this.b2(result.getShowSwitch());
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            l.this.d2(this.f328832e, error, message);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(int i3, int i16, ao repository) {
        super(repository);
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.mapId = i3;
        this.rankId = i16;
        this.rank = new MutableLiveData<>();
        this.loading = new MutableLiveData<>();
        this.errorMessage = new MutableLiveData<>();
        this.switchDetailLoadMoreMap = new LinkedHashMap();
        this.switchSummeryLoadMoreMap = new LinkedHashMap();
        this.switchSummeryCacheDataMap = new LinkedHashMap();
        this.switchDetailCacheDataMap = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z1(zb3.k result, int showSwitch) {
        result.g();
        zb3.k kVar = this.switchSummeryCacheDataMap.get(Integer.valueOf(showSwitch));
        ZootopiaRankConfigData rankConfig = result.getRankConfig();
        List<ZootopiaRankConfigData> c16 = result.c();
        ZootopiaUserRankData selfRankData = result.getSelfRankData();
        ArrayList arrayList = new ArrayList();
        zb3.k kVar2 = kVar;
        if (kVar2 != null) {
            arrayList.addAll(kVar2.g());
        }
        arrayList.addAll(result.g());
        Unit unit = Unit.INSTANCE;
        zb3.k kVar3 = new zb3.k(rankConfig, c16, selfRankData, arrayList, result.getShowSwitch(), result.getServerKey(), result.getHasMore());
        this.switchSummeryCacheDataMap.put(Integer.valueOf(showSwitch), kVar3);
        this.switchSummeryLoadMoreMap.put(Integer.valueOf(showSwitch), result.getServerKey());
    }

    private final void a2(List<String> openIds, int showSwitch, int start, int end) {
        getRepository().k(openIds, new c(showSwitch, start, end));
    }

    private final void c2(int showSwitch) {
        int i3 = this.mapId;
        if (i3 != 0 && this.rankId != 0) {
            ao repository = getRepository();
            int i16 = this.mapId;
            int i17 = this.rankId;
            String str = this.switchSummeryLoadMoreMap.get(Integer.valueOf(showSwitch));
            repository.j(i16, i17, showSwitch, str == null ? "" : str, new d(showSwitch));
            return;
        }
        QLog.e("ZootopiaRankViewModel", 1, "loadRankFromNet but invalid param! - mapId = " + i3 + " rankId = " + this.rankId, new Throwable(""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d2(int showSwitch, int error, String message) {
        List<ZootopiaUserRankData> g16;
        if (this.switchSummeryCacheDataMap.get(Integer.valueOf(showSwitch)) != null) {
            zb3.k kVar = this.switchSummeryCacheDataMap.get(Integer.valueOf(showSwitch));
            boolean z16 = false;
            if (kVar != null && (g16 = kVar.g()) != null && (!g16.isEmpty())) {
                z16 = true;
            }
            if (z16) {
                this.loading.setValue(new LoadingMessage(P));
            } else {
                this.loading.setValue(new LoadingMessage(N));
            }
        } else {
            this.loading.setValue(new LoadingMessage(M));
        }
        this.errorMessage.setValue(new ErrorMessage(error, message));
    }

    public final MutableLiveData<ErrorMessage> S1() {
        return this.errorMessage;
    }

    /* renamed from: T1, reason: from getter */
    public final int getLastLoadingSwitchType() {
        return this.lastLoadingSwitchType;
    }

    public final MutableLiveData<LoadingMessage> U1() {
        return this.loading;
    }

    public final MutableLiveData<zb3.k> W1() {
        return this.rank;
    }

    public final void e2(int switchType) {
        this.switchSummeryLoadMoreMap.remove(Integer.valueOf(switchType));
        this.switchSummeryCacheDataMap.remove(Integer.valueOf(switchType));
        this.switchDetailCacheDataMap.remove(Integer.valueOf(switchType));
        this.switchDetailLoadMoreMap.remove(Integer.valueOf(switchType));
    }

    public final void f2(ZootopiaRankShowInfo switchInfo) {
        Intrinsics.checkNotNullParameter(switchInfo, "switchInfo");
        zb3.k kVar = this.switchSummeryCacheDataMap.get(Integer.valueOf(switchInfo.getShowType()));
        zb3.k kVar2 = this.switchDetailCacheDataMap.get(Integer.valueOf(switchInfo.getShowType()));
        this.lastLoadingSwitchType = switchInfo.getShowType();
        if (kVar != null && kVar2 != null) {
            if (!kVar.g().isEmpty()) {
                this.loading.setValue(new LoadingMessage(P));
            } else {
                this.loading.setValue(new LoadingMessage(N));
            }
            this.rank.setValue(kVar2);
            e2(switchInfo.getShowType());
            b2(switchInfo.getShowType());
            return;
        }
        this.loading.setValue(new LoadingMessage(L));
        b2(switchInfo.getShowType());
    }

    public final void b2(int showSwitch) {
        String str;
        ZootopiaUserRankData zootopiaUserRankData;
        ZootopiaUserRankData zootopiaUserRankData2;
        if (showSwitch == 0) {
            this.loading.setValue(new LoadingMessage(L));
        }
        zb3.k kVar = this.switchSummeryCacheDataMap.get(Integer.valueOf(showSwitch));
        List<ZootopiaUserRankData> g16 = kVar != null ? kVar.g() : null;
        zb3.k kVar2 = this.switchSummeryCacheDataMap.get(Integer.valueOf(showSwitch));
        boolean hasMore = kVar2 != null ? kVar2.getHasMore() : true;
        boolean z16 = false;
        int size = g16 != null ? g16.size() : 0;
        Integer num = this.switchDetailLoadMoreMap.get(Integer.valueOf(showSwitch));
        int intValue = num != null ? num.intValue() : 0;
        int i3 = Q + intValue;
        if (i3 > size && hasMore) {
            c2(showSwitch);
            return;
        }
        if (g16 != null && g16.isEmpty()) {
            this.loading.setValue(new LoadingMessage(N));
            X1(showSwitch, 0, 0, new ArrayList());
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (intValue <= i3) {
            int i16 = intValue;
            while (true) {
                if (i16 < size) {
                    ZootopiaRankHeadNickData zootopiaRankHeadNickData = (g16 == null || (zootopiaUserRankData2 = g16.get(i16)) == null) ? null : zootopiaUserRankData2.getZootopiaRankHeadNickData();
                    if (zootopiaRankHeadNickData == null || zootopiaRankHeadNickData.d()) {
                        z16 = true;
                    } else {
                        arrayList2.add(zootopiaRankHeadNickData);
                    }
                    if (g16 == null || (zootopiaUserRankData = g16.get(i16)) == null || (str = zootopiaUserRankData.getOpenId()) == null) {
                        str = "";
                    }
                    arrayList.add(str);
                }
                if (i16 == i3) {
                    break;
                } else {
                    i16++;
                }
            }
        }
        if (!z16) {
            this.loading.setValue(new LoadingMessage(P));
            X1(showSwitch, intValue, i3, arrayList2);
        } else {
            a2(arrayList, showSwitch, intValue, i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0004\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/detail/rank/l$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "loadingViewStatus", "<init>", "(I)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.portal.detail.rank.l$b, reason: from toString */
    /* loaded from: classes35.dex */
    public static final /* data */ class LoadingMessage {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int loadingViewStatus;

        public LoadingMessage(int i3) {
            this.loadingViewStatus = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getLoadingViewStatus() {
            return this.loadingViewStatus;
        }

        public int hashCode() {
            return this.loadingViewStatus;
        }

        public String toString() {
            return "LoadingMessage(loadingViewStatus=" + this.loadingViewStatus + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof LoadingMessage) && this.loadingViewStatus == ((LoadingMessage) other).loadingViewStatus;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r8v0, types: [T, java.util.Collection, java.util.ArrayList] */
    public final void X1(int showSwitch, int start, int end, List<ZootopiaRankHeadNickData> userDetailList) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (ZootopiaRankHeadNickData zootopiaRankHeadNickData : userDetailList) {
            linkedHashMap.put(zootopiaRankHeadNickData.getOpenId(), zootopiaRankHeadNickData);
        }
        zb3.k kVar = this.switchSummeryCacheDataMap.get(Integer.valueOf(showSwitch));
        if (kVar != null) {
            boolean z16 = kVar.g().size() > end || kVar.getHasMore();
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            List<ZootopiaUserRankData> g16 = kVar.g();
            ?? arrayList = new ArrayList();
            int i3 = 0;
            for (Object obj : g16) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                ZootopiaUserRankData zootopiaUserRankData = (ZootopiaUserRankData) obj;
                ZootopiaRankHeadNickData zootopiaRankHeadNickData2 = (ZootopiaRankHeadNickData) linkedHashMap.get(zootopiaUserRankData.getOpenId());
                if (zootopiaRankHeadNickData2 != null) {
                    zootopiaUserRankData.i(zootopiaRankHeadNickData2);
                }
                if (start <= i3 && i3 < end) {
                    arrayList.add(obj);
                }
                i3 = i16;
            }
            objectRef.element = arrayList;
            zb3.k kVar2 = this.switchDetailCacheDataMap.get(Integer.valueOf(showSwitch));
            ZootopiaRankConfigData rankConfig = kVar.getRankConfig();
            List<ZootopiaRankConfigData> c16 = kVar.c();
            ZootopiaUserRankData selfRankData = kVar.getSelfRankData();
            ArrayList arrayList2 = new ArrayList();
            zb3.k kVar3 = kVar2;
            if (kVar3 != null) {
                arrayList2.addAll(kVar3.g());
            }
            arrayList2.addAll((Collection) objectRef.element);
            Unit unit = Unit.INSTANCE;
            this.switchDetailCacheDataMap.put(Integer.valueOf(showSwitch), new zb3.k(rankConfig, c16, selfRankData, arrayList2, kVar.getShowSwitch(), kVar.getServerKey(), z16));
            this.switchDetailLoadMoreMap.put(Integer.valueOf(showSwitch), Integer.valueOf(end));
            int i17 = this.lastLoadingSwitchType;
            if (i17 == showSwitch || i17 == 0) {
                this.rank.setValue(this.switchDetailCacheDataMap.get(Integer.valueOf(showSwitch)));
            }
        }
    }
}
