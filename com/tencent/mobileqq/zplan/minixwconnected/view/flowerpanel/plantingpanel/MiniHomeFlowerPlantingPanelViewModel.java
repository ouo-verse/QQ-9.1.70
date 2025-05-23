package com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel;

import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.google.protobuf.nano.MessageNano;
import com.tencent.filament.zplan.scene.xwconnect.data.CoinType;
import com.tencent.filament.zplan.scene.xwconnect.data.FlowerStatus;
import com.tencent.filament.zplan.scene.xwconnect.data.h;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.zplan.minihome.aq;
import com.tencent.mobileqq.zplan.nativeui.impl.view.dialog.views.SingleItemShoppingCartData;
import com.tencent.mobileqq.zplan.utils.SknNetworkUtilKt;
import com.tencent.mobileqq.zplan.utils.ZPlanRequestReq;
import com.tencent.mobileqq.zplan.utils.at;
import com.tencent.mobileqq.zplan.utils.av;
import com.tencent.mobileqq.zplan.utils.aw;
import com.tencent.mobileqq.zplan.utils.o;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00192\u00020\u0001:\u0003\u001a\u001b\u001cB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u001d\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/MiniHomeFlowerPlantingPanelViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/MiniHomeFlowerPlantingPanelViewModel$c;", "P1", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/lifecycle/LifecycleCoroutineScope;", "scope", "", "N1", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/MiniHomeFlowerPlantingPanelViewModel$b;", "flowerData", "Lp55/j;", "Q1", "(Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/MiniHomeFlowerPlantingPanelViewModel$b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "_flowerData", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "O1", "()Landroidx/lifecycle/LiveData;", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MiniHomeFlowerPlantingPanelViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<FlowerPanelData> _flowerData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final LiveData<FlowerPanelData> flowerData;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0003R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/MiniHomeFlowerPlantingPanelViewModel$a;", "", "", "", "max", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel.MiniHomeFlowerPlantingPanelViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(String str, int i3) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            if (i3 <= 0 || str.length() <= i3) {
                return str;
            }
            String substring = str.substring(0, i3 - 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            return substring + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }

        Companion() {
        }

        public static /* synthetic */ String b(Companion companion, String str, int i3, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                i3 = 4;
            }
            return companion.a(str, i3);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\t\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/MiniHomeFlowerPlantingPanelViewModel$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "illustrationUrl", "", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/MiniHomeFlowerPlantingPanelViewModel$b;", "Ljava/util/List;", "()Ljava/util/List;", "flowerDataList", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel.MiniHomeFlowerPlantingPanelViewModel$c, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class FlowerPanelData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final String illustrationUrl;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final List<FlowerData> flowerDataList;

        public FlowerPanelData() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public final List<FlowerData> a() {
            return this.flowerDataList;
        }

        /* renamed from: b, reason: from getter */
        public final String getIllustrationUrl() {
            return this.illustrationUrl;
        }

        public int hashCode() {
            return (this.illustrationUrl.hashCode() * 31) + this.flowerDataList.hashCode();
        }

        public String toString() {
            return "FlowerPanelData(illustrationUrl=" + this.illustrationUrl + ", flowerDataList=" + this.flowerDataList + ")";
        }

        public FlowerPanelData(String illustrationUrl, List<FlowerData> flowerDataList) {
            Intrinsics.checkNotNullParameter(illustrationUrl, "illustrationUrl");
            Intrinsics.checkNotNullParameter(flowerDataList, "flowerDataList");
            this.illustrationUrl = illustrationUrl;
            this.flowerDataList = flowerDataList;
        }

        public /* synthetic */ FlowerPanelData(String str, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FlowerPanelData)) {
                return false;
            }
            FlowerPanelData flowerPanelData = (FlowerPanelData) other;
            return Intrinsics.areEqual(this.illustrationUrl, flowerPanelData.illustrationUrl) && Intrinsics.areEqual(this.flowerDataList, flowerPanelData.flowerDataList);
        }
    }

    public MiniHomeFlowerPlantingPanelViewModel() {
        MutableLiveData<FlowerPanelData> mutableLiveData = new MutableLiveData<>();
        this._flowerData = mutableLiveData;
        this.flowerData = mutableLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(16:1|(2:3|(14:5|6|7|(1:(2:10|11)(2:67|68))(3:69|70|(1:72)(1:73))|12|(1:14)(1:66)|15|(1:17)(1:64)|(1:19)(1:63)|(1:21)(1:62)|22|(1:24)(1:61)|25|(2:27|28)(8:30|(4:32|(1:41)(1:35)|(2:37|38)(1:40)|39)|42|43|(6:46|47|48|(3:50|51|52)(1:54)|53|44)|58|59|60)))|76|6|7|(0)(0)|12|(0)(0)|15|(0)(0)|(0)(0)|(0)(0)|22|(0)(0)|25|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x008f, code lost:
    
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0090, code lost:
    
        com.tencent.qphone.base.util.QLog.i("MiniHomeFlowerPlantingPanelViewModel", 1, "requestPanelData fail=" + r12);
        r7 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0075 A[Catch: all -> 0x008f, TryCatch #1 {all -> 0x008f, blocks: (B:11:0x002e, B:12:0x006a, B:14:0x0075, B:15:0x007d, B:70:0x003e), top: B:7:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object P1(Continuation<? super FlowerPanelData> continuation) {
        MiniHomeFlowerPlantingPanelViewModel$requestPanelData$1 miniHomeFlowerPlantingPanelViewModel$requestPanelData$1;
        int i3;
        p55.b bVar;
        FlowerData flowerData;
        MessageNano messageNano;
        if (continuation instanceof MiniHomeFlowerPlantingPanelViewModel$requestPanelData$1) {
            miniHomeFlowerPlantingPanelViewModel$requestPanelData$1 = (MiniHomeFlowerPlantingPanelViewModel$requestPanelData$1) continuation;
            int i16 = miniHomeFlowerPlantingPanelViewModel$requestPanelData$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                miniHomeFlowerPlantingPanelViewModel$requestPanelData$1.label = i16 - Integer.MIN_VALUE;
                Object obj = miniHomeFlowerPlantingPanelViewModel$requestPanelData$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = miniHomeFlowerPlantingPanelViewModel$requestPanelData$1.label;
                String str = null;
                byte b16 = 0;
                byte b17 = 0;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    o g16 = SknNetworkUtilKt.g(aw.f335800a, 1000L, 2);
                    p55.a aVar = new p55.a();
                    p55.b bVar2 = new p55.b();
                    Unit unit = Unit.INSTANCE;
                    ZPlanRequestReq zPlanRequestReq = new ZPlanRequestReq("trpc.zplan.mini_home_huateng_svr.Manager.SsoFetchFlowerPanel", SknNetworkUtilKt.i(aVar));
                    miniHomeFlowerPlantingPanelViewModel$requestPanelData$1.L$0 = bVar2;
                    miniHomeFlowerPlantingPanelViewModel$requestPanelData$1.label = 1;
                    obj = g16.a(zPlanRequestReq, miniHomeFlowerPlantingPanelViewModel$requestPanelData$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    messageNano = bVar2;
                } else if (i3 == 1) {
                    messageNano = (MessageNano) miniHomeFlowerPlantingPanelViewModel$requestPanelData$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                av avVar = (av) obj;
                Object data = avVar.getData();
                aq aqVar = new aq(data == null ? SknNetworkUtilKt.c((byte[]) data, messageNano) : null, avVar.getSsoResultCode(), avVar.getTrpcRspFuncRetCode(), avVar.getTrpcRspErrorMsg());
                QLog.i("MiniHomeFlowerPlantingPanelViewModel", 1, "requestPanelData ssoResultCode=" + (aqVar == null ? Boxing.boxInt(aqVar.getSsoResultCode()) : null) + ", trpcRspFuncRetCode=" + (aqVar == null ? Boxing.boxInt(aqVar.getTrpcRspFuncRetCode()) : null) + ", trpcRspErrorMsg=" + (aqVar == null ? aqVar.getTrpcRspErrorMsg() : null));
                bVar = aqVar == null ? (p55.b) aqVar.a() : null;
                QLog.i("MiniHomeFlowerPlantingPanelViewModel", 1, "requestPanelData info=" + bVar);
                if (bVar != null) {
                    return new FlowerPanelData(str, b17 == true ? 1 : 0, 3, b16 == true ? 1 : 0);
                }
                p55.e[] eVarArr = bVar.f425369a;
                Intrinsics.checkNotNullExpressionValue(eVarArr, "rsp.flowerPanelData");
                ArrayList<p55.e> arrayList = new ArrayList();
                for (p55.e eVar : eVarArr) {
                    int i17 = eVar.f425380b;
                    if ((i17 == 1 || i17 == 2) != false) {
                        arrayList.add(eVar);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                for (p55.e it : arrayList) {
                    try {
                        FlowerData.Companion companion = FlowerData.INSTANCE;
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        flowerData = companion.a(it);
                    } catch (Throwable th5) {
                        QLog.e("MiniHomeFlowerPlantingPanelViewModel", 1, "FlowerData error, " + th5);
                        flowerData = null;
                    }
                    if (flowerData != null) {
                        arrayList2.add(flowerData);
                    }
                }
                String str2 = bVar.f425370b;
                Intrinsics.checkNotNullExpressionValue(str2, "rsp.illustrationH5Url");
                return new FlowerPanelData(str2, arrayList2);
            }
        }
        miniHomeFlowerPlantingPanelViewModel$requestPanelData$1 = new MiniHomeFlowerPlantingPanelViewModel$requestPanelData$1(this, continuation);
        Object obj2 = miniHomeFlowerPlantingPanelViewModel$requestPanelData$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = miniHomeFlowerPlantingPanelViewModel$requestPanelData$1.label;
        String str3 = null;
        byte b162 = 0;
        byte b172 = 0;
        if (i3 != 0) {
        }
        av avVar2 = (av) obj2;
        Object data2 = avVar2.getData();
        aq aqVar2 = new aq(data2 == null ? SknNetworkUtilKt.c((byte[]) data2, messageNano) : null, avVar2.getSsoResultCode(), avVar2.getTrpcRspFuncRetCode(), avVar2.getTrpcRspErrorMsg());
        if (aqVar2 == null) {
        }
        if (aqVar2 == null) {
        }
        if (aqVar2 == null) {
        }
        QLog.i("MiniHomeFlowerPlantingPanelViewModel", 1, "requestPanelData ssoResultCode=" + (aqVar2 == null ? Boxing.boxInt(aqVar2.getSsoResultCode()) : null) + ", trpcRspFuncRetCode=" + (aqVar2 == null ? Boxing.boxInt(aqVar2.getTrpcRspFuncRetCode()) : null) + ", trpcRspErrorMsg=" + (aqVar2 == null ? aqVar2.getTrpcRspErrorMsg() : null));
        if (aqVar2 == null) {
        }
        QLog.i("MiniHomeFlowerPlantingPanelViewModel", 1, "requestPanelData info=" + bVar);
        if (bVar != null) {
        }
    }

    public final void N1(LifecycleCoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        QLog.i("MiniHomeFlowerPlantingPanelViewModel", 1, "fetchFlowerData");
        CorountineFunKt.e(scope, "MiniHomeFlowerPlantingPanelViewModel_fetchFlowerData", null, null, null, new MiniHomeFlowerPlantingPanelViewModel$fetch$1(this, null), 14, null);
    }

    public final LiveData<FlowerPanelData> O1() {
        return this.flowerData;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0083 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:11:0x002d, B:12:0x007b, B:14:0x0083, B:15:0x0088), top: B:10:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object Q1(FlowerData flowerData, Continuation<? super p55.j> continuation) {
        MiniHomeFlowerPlantingPanelViewModel$requestUnlockFlower$1 miniHomeFlowerPlantingPanelViewModel$requestUnlockFlower$1;
        int i3;
        FlowerData flowerData2;
        MessageNano messageNano;
        Object data;
        if (continuation instanceof MiniHomeFlowerPlantingPanelViewModel$requestUnlockFlower$1) {
            miniHomeFlowerPlantingPanelViewModel$requestUnlockFlower$1 = (MiniHomeFlowerPlantingPanelViewModel$requestUnlockFlower$1) continuation;
            int i16 = miniHomeFlowerPlantingPanelViewModel$requestUnlockFlower$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                miniHomeFlowerPlantingPanelViewModel$requestUnlockFlower$1.label = i16 - Integer.MIN_VALUE;
                Object obj = miniHomeFlowerPlantingPanelViewModel$requestUnlockFlower$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = miniHomeFlowerPlantingPanelViewModel$requestUnlockFlower$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        o g16 = SknNetworkUtilKt.g(at.f335791a, 1000L, 2);
                        p55.i iVar = new p55.i();
                        p55.j jVar = new p55.j();
                        iVar.f425405b = flowerData.getId();
                        iVar.f425406c = flowerData.getFlowerOwnStatus();
                        Unit unit = Unit.INSTANCE;
                        ZPlanRequestReq zPlanRequestReq = new ZPlanRequestReq("trpc.zplan.mini_home_huateng_svr.Manager.SsoUnlockFlower", SknNetworkUtilKt.i(iVar));
                        miniHomeFlowerPlantingPanelViewModel$requestUnlockFlower$1.L$0 = flowerData;
                        miniHomeFlowerPlantingPanelViewModel$requestUnlockFlower$1.L$1 = jVar;
                        miniHomeFlowerPlantingPanelViewModel$requestUnlockFlower$1.label = 1;
                        obj = g16.a(zPlanRequestReq, miniHomeFlowerPlantingPanelViewModel$requestUnlockFlower$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        flowerData2 = flowerData;
                        messageNano = jVar;
                    } catch (Throwable unused) {
                        QLog.e("MiniHomeFlowerPlantingPanelViewModel", 1, "requestUnlockFlower exception, flowerData:" + flowerData);
                        return null;
                    }
                } else if (i3 == 1) {
                    messageNano = (MessageNano) miniHomeFlowerPlantingPanelViewModel$requestUnlockFlower$1.L$1;
                    flowerData2 = (FlowerData) miniHomeFlowerPlantingPanelViewModel$requestUnlockFlower$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable unused2) {
                        flowerData = flowerData2;
                        QLog.e("MiniHomeFlowerPlantingPanelViewModel", 1, "requestUnlockFlower exception, flowerData:" + flowerData);
                        return null;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                data = ((av) obj).getData();
                if (data != null) {
                    SknNetworkUtilKt.c((byte[]) data, messageNano);
                }
                return (p55.j) messageNano;
            }
        }
        miniHomeFlowerPlantingPanelViewModel$requestUnlockFlower$1 = new MiniHomeFlowerPlantingPanelViewModel$requestUnlockFlower$1(this, continuation);
        Object obj2 = miniHomeFlowerPlantingPanelViewModel$requestUnlockFlower$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = miniHomeFlowerPlantingPanelViewModel$requestUnlockFlower$1.label;
        if (i3 != 0) {
        }
        data = ((av) obj2).getData();
        if (data != null) {
        }
        return (p55.j) messageNano;
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u0000 /2\u00020\u0001:\u0001\tBo\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001a\u0012\b\b\u0002\u0010\"\u001a\u00020\u001f\u0012\b\b\u0002\u0010$\u001a\u00020\u0004\u0012\b\b\u0002\u0010'\u001a\u00020\u0004\u0012\f\u0010,\u001a\b\u0012\u0004\u0012\u00020)0(\u00a2\u0006\u0004\b-\u0010.J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\fR\u0017\u0010\u001e\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001dR\u0017\u0010\"\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b\t\u0010!R\u0017\u0010$\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b\u000e\u0010\fR\"\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0017\u0010\f\"\u0004\b%\u0010&R\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020)0(8\u0006\u00a2\u0006\f\n\u0004\b%\u0010*\u001a\u0004\b#\u0010+\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/MiniHomeFlowerPlantingPanelViewModel$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "i", "()I", "id", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "flowerIcon", "d", "flowerName", "g", "flowerSummary", "e", "getFlowerLevel", "flowerLevel", "Lcom/tencent/filament/zplan/scene/xwconnect/data/FlowerStatus;", "f", "Lcom/tencent/filament/zplan/scene/xwconnect/data/FlowerStatus;", "()Lcom/tencent/filament/zplan/scene/xwconnect/data/FlowerStatus;", "flowerStatus", "Lcom/tencent/filament/zplan/scene/xwconnect/data/CoinType;", "Lcom/tencent/filament/zplan/scene/xwconnect/data/CoinType;", "()Lcom/tencent/filament/zplan/scene/xwconnect/data/CoinType;", "flowerCoinType", tl.h.F, "flowerCost", "j", "(I)V", "flowerOwnStatus", "", "Lp55/h;", "[Lp55/h;", "()[Lp55/h;", "flowerViewDataList", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/filament/zplan/scene/xwconnect/data/FlowerStatus;Lcom/tencent/filament/zplan/scene/xwconnect/data/CoinType;II[Lp55/h;)V", "k", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel.MiniHomeFlowerPlantingPanelViewModel$b, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class FlowerData {

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int id;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final String flowerIcon;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final String flowerName;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final String flowerSummary;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final int flowerLevel;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final FlowerStatus flowerStatus;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private final CoinType flowerCoinType;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private final int flowerCost;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        private int flowerOwnStatus;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
        private final p55.h[] flowerViewDataList;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/MiniHomeFlowerPlantingPanelViewModel$b$a;", "", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/flowerpanel/plantingpanel/MiniHomeFlowerPlantingPanelViewModel$b;", "Lcom/tencent/mobileqq/zplan/nativeui/impl/view/dialog/views/a;", "b", "Lp55/e;", "flowerPanelData", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel.MiniHomeFlowerPlantingPanelViewModel$b$a, reason: from kotlin metadata */
        /* loaded from: classes34.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final SingleItemShoppingCartData b(FlowerData flowerData) {
                Intrinsics.checkNotNullParameter(flowerData, "<this>");
                return new SingleItemShoppingCartData(String.valueOf(flowerData.getId()), flowerData.getFlowerName(), flowerData.getFlowerCost(), flowerData.getFlowerIcon(), "");
            }

            Companion() {
            }

            public final FlowerData a(p55.e flowerPanelData) {
                FlowerStatus flowerStatus;
                CoinType coinType;
                Intrinsics.checkNotNullParameter(flowerPanelData, "flowerPanelData");
                int i3 = flowerPanelData.f425379a.f425375a.f425371a;
                String str = flowerPanelData.f425383e;
                Intrinsics.checkNotNullExpressionValue(str, "flowerPanelData.flowerIcon");
                String str2 = flowerPanelData.f425379a.f425375a.f425372b;
                Intrinsics.checkNotNullExpressionValue(str2, "flowerPanelData.flowerData.basicInfo.name");
                String str3 = flowerPanelData.f425381c;
                Intrinsics.checkNotNullExpressionValue(str3, "flowerPanelData.flowerText");
                p55.g gVar = flowerPanelData.f425379a.f425376b;
                int i16 = gVar.f425393a;
                h.Companion companion = com.tencent.filament.zplan.scene.xwconnect.data.h.INSTANCE;
                int i17 = gVar.f425394b;
                FlowerStatus[] values = FlowerStatus.values();
                int length = values.length;
                int i18 = 0;
                while (true) {
                    if (i18 >= length) {
                        flowerStatus = null;
                        break;
                    }
                    FlowerStatus flowerStatus2 = values[i18];
                    if (flowerStatus2.getValue() == i17) {
                        flowerStatus = flowerStatus2;
                        break;
                    }
                    i18++;
                }
                if (flowerStatus != null) {
                    h.Companion companion2 = com.tencent.filament.zplan.scene.xwconnect.data.h.INSTANCE;
                    int i19 = flowerPanelData.f425379a.f425375a.f425373c;
                    CoinType[] values2 = CoinType.values();
                    int length2 = values2.length;
                    int i26 = 0;
                    while (true) {
                        if (i26 >= length2) {
                            coinType = null;
                            break;
                        }
                        CoinType coinType2 = values2[i26];
                        if (coinType2.getValue() == i19) {
                            coinType = coinType2;
                            break;
                        }
                        i26++;
                    }
                    if (coinType != null) {
                        int i27 = flowerPanelData.f425379a.f425375a.f425374d;
                        int i28 = flowerPanelData.f425380b;
                        p55.h[] hVarArr = flowerPanelData.f425384f;
                        Intrinsics.checkNotNullExpressionValue(hVarArr, "flowerPanelData.flowerViewList");
                        return new FlowerData(i3, str, str2, str3, i16, flowerStatus, coinType, i27, i28, hVarArr);
                    }
                    throw new IllegalArgumentException("Invalid value: " + i19);
                }
                throw new IllegalArgumentException("Invalid value: " + i17);
            }
        }

        public FlowerData(int i3, String flowerIcon, String flowerName, String flowerSummary, int i16, FlowerStatus flowerStatus, CoinType flowerCoinType, int i17, int i18, p55.h[] flowerViewDataList) {
            Intrinsics.checkNotNullParameter(flowerIcon, "flowerIcon");
            Intrinsics.checkNotNullParameter(flowerName, "flowerName");
            Intrinsics.checkNotNullParameter(flowerSummary, "flowerSummary");
            Intrinsics.checkNotNullParameter(flowerStatus, "flowerStatus");
            Intrinsics.checkNotNullParameter(flowerCoinType, "flowerCoinType");
            Intrinsics.checkNotNullParameter(flowerViewDataList, "flowerViewDataList");
            this.id = i3;
            this.flowerIcon = flowerIcon;
            this.flowerName = flowerName;
            this.flowerSummary = flowerSummary;
            this.flowerLevel = i16;
            this.flowerStatus = flowerStatus;
            this.flowerCoinType = flowerCoinType;
            this.flowerCost = i17;
            this.flowerOwnStatus = i18;
            this.flowerViewDataList = flowerViewDataList;
        }

        /* renamed from: a, reason: from getter */
        public final CoinType getFlowerCoinType() {
            return this.flowerCoinType;
        }

        /* renamed from: b, reason: from getter */
        public final int getFlowerCost() {
            return this.flowerCost;
        }

        /* renamed from: c, reason: from getter */
        public final String getFlowerIcon() {
            return this.flowerIcon;
        }

        /* renamed from: d, reason: from getter */
        public final String getFlowerName() {
            return this.flowerName;
        }

        /* renamed from: e, reason: from getter */
        public final int getFlowerOwnStatus() {
            return this.flowerOwnStatus;
        }

        /* renamed from: f, reason: from getter */
        public final FlowerStatus getFlowerStatus() {
            return this.flowerStatus;
        }

        /* renamed from: g, reason: from getter */
        public final String getFlowerSummary() {
            return this.flowerSummary;
        }

        /* renamed from: h, reason: from getter */
        public final p55.h[] getFlowerViewDataList() {
            return this.flowerViewDataList;
        }

        public int hashCode() {
            return (((((((((((((((((this.id * 31) + this.flowerIcon.hashCode()) * 31) + this.flowerName.hashCode()) * 31) + this.flowerSummary.hashCode()) * 31) + this.flowerLevel) * 31) + this.flowerStatus.hashCode()) * 31) + this.flowerCoinType.hashCode()) * 31) + this.flowerCost) * 31) + this.flowerOwnStatus) * 31) + Arrays.hashCode(this.flowerViewDataList);
        }

        /* renamed from: i, reason: from getter */
        public final int getId() {
            return this.id;
        }

        public final void j(int i3) {
            this.flowerOwnStatus = i3;
        }

        public String toString() {
            return "FlowerData(id=" + this.id + ", flowerIcon=" + this.flowerIcon + ", flowerName=" + this.flowerName + ", flowerSummary=" + this.flowerSummary + ", flowerLevel=" + this.flowerLevel + ", flowerStatus=" + this.flowerStatus + ", flowerCoinType=" + this.flowerCoinType + ", flowerCost=" + this.flowerCost + ", flowerOwnStatus=" + this.flowerOwnStatus + ", flowerViewDataList=" + Arrays.toString(this.flowerViewDataList) + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FlowerData)) {
                return false;
            }
            FlowerData flowerData = (FlowerData) other;
            return this.id == flowerData.id && Intrinsics.areEqual(this.flowerIcon, flowerData.flowerIcon) && Intrinsics.areEqual(this.flowerName, flowerData.flowerName) && Intrinsics.areEqual(this.flowerSummary, flowerData.flowerSummary) && this.flowerLevel == flowerData.flowerLevel && this.flowerStatus == flowerData.flowerStatus && this.flowerCoinType == flowerData.flowerCoinType && this.flowerCost == flowerData.flowerCost && this.flowerOwnStatus == flowerData.flowerOwnStatus && Intrinsics.areEqual(this.flowerViewDataList, flowerData.flowerViewDataList);
        }
    }
}
