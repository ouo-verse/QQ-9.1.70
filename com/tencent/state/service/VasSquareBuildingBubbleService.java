package com.tencent.state.service;

import com.google.protobuf.nano.MessageNano;
import com.tencent.state.api.INetworkDelegate;
import com.tencent.state.api.INetworkDelegateCallBack;
import com.tencent.state.api.SquareErrorData;
import com.tencent.state.config.NetworkConfig;
import com.tencent.state.square.EntranceLink;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.data.BuildingBubble;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import st4.a;
import st4.b;
import st4.c;
import st4.d;
import st4.e;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\u0010%\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J:\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00042\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012J.\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u001e\u0010\u0011\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u00170\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/state/service/VasSquareBuildingBubbleService;", "", "()V", "BUBBLE_SCENE_BUILDING", "", "BUBBLE_SCENE_SQUARE_TOP", "CMD_SERVICE", "", "METHOD_DEL_BUILDING_BUBBLES", "METHOD_GET_BUILDING_BUBBLES", "TAG", "delBuildingBubbles", "", "buildingId", "bubbleType", "bubbleId", "scene", "callback", "Lcom/tencent/state/service/ResultCallback;", "", "getBuildingBubbles", "buildingIds", "", "", "", "Lcom/tencent/state/square/data/BuildingBubble;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasSquareBuildingBubbleService {
    public static final int BUBBLE_SCENE_BUILDING = 0;
    public static final int BUBBLE_SCENE_SQUARE_TOP = 1;
    private static final String CMD_SERVICE = "trpc.qmeta.status_square_bubble_svr.StatusSquareBubbleSvr";
    public static final VasSquareBuildingBubbleService INSTANCE = new VasSquareBuildingBubbleService();
    private static final String METHOD_DEL_BUILDING_BUBBLES = "DelBuildingBubble";
    private static final String METHOD_GET_BUILDING_BUBBLES = "GetBuildingBubble";
    private static final String TAG = "VasSquareBuildingBubbleService";

    VasSquareBuildingBubbleService() {
    }

    public final void delBuildingBubbles(final int buildingId, final int bubbleType, final String bubbleId, int scene, final ResultCallback<Boolean> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(bubbleId, "bubbleId");
        c cVar = new c();
        cVar.f434746a = buildingId;
        cVar.f434747b = bubbleType;
        cVar.f434748c = bubbleId;
        cVar.f434749d = scene;
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(cVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE, METHOD_DEL_BUILDING_BUBBLES, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasSquareBuildingBubbleService$delBuildingBubbles$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasSquareBuildingBubbleService", "delBuildingBubbles on error, buildingId:" + buildingId + ", bubbleType:" + bubbleType + ", bubbleId:" + bubbleId + ", " + data.getErrCode() + ", " + data.getErrMsg(), null, 4, null);
                    ResultCallback resultCallback = ResultCallback.this;
                    if (resultCallback != null) {
                        Integer errCode = data.getErrCode();
                        resultCallback.onResultFailure(errCode != null ? errCode.intValue() : -1, data.getErrMsg());
                    }
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    ResultCallback resultCallback = ResultCallback.this;
                    if (resultCallback != null) {
                        resultCallback.onResultSuccess(Boolean.TRUE);
                    }
                }
            });
        }
    }

    public final void getBuildingBubbles(final int[] buildingIds, final ResultCallback<Map<Integer, List<BuildingBubble>>> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(buildingIds, "buildingIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        d dVar = new d();
        dVar.f434750a = buildingIds;
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(dVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE, METHOD_GET_BUILDING_BUBBLES, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasSquareBuildingBubbleService$getBuildingBubbles$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasSquareBuildingBubbleService", "getBuildingBubbles on error, buildingIds:" + buildingIds + ", " + data.getErrCode() + ", " + data.getErrMsg(), null, 4, null);
                    ResultCallback resultCallback = ResultCallback.this;
                    Integer errCode = data.getErrCode();
                    resultCallback.onResultFailure(errCode != null ? errCode.intValue() : -1, data.getErrMsg());
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    b[] bVarArr;
                    int i3;
                    try {
                        e c16 = e.c(rspData);
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        SquareLogger squareLog = SquareBaseKt.getSquareLog();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("getBuildingBubbles size:");
                        b[] bVarArr2 = c16.f434751a;
                        sb5.append(bVarArr2 != null ? Integer.valueOf(bVarArr2.length) : null);
                        squareLog.d("VasSquareBuildingBubbleService", sb5.toString());
                        b[] bVarArr3 = c16.f434751a;
                        if (bVarArr3 != null) {
                            int length = bVarArr3.length;
                            int i16 = 0;
                            while (i16 < length) {
                                b bVar = bVarArr3[i16];
                                if (!linkedHashMap.containsKey(Integer.valueOf(bVar.f434744a))) {
                                    linkedHashMap.put(Integer.valueOf(bVar.f434744a), new ArrayList());
                                }
                                List list = (List) linkedHashMap.get(Integer.valueOf(bVar.f434744a));
                                if (list != null) {
                                    a[] aVarArr = bVar.f434745b;
                                    Intrinsics.checkNotNullExpressionValue(aVarArr, "buildingBubble.bubbles");
                                    ArrayList arrayList = new ArrayList(aVarArr.length);
                                    int length2 = aVarArr.length;
                                    int i17 = 0;
                                    while (i17 < length2) {
                                        a aVar = aVarArr[i17];
                                        int i18 = aVar.f434740f;
                                        int i19 = 1;
                                        if (i18 != 1) {
                                            i19 = 2;
                                            if (i18 != 2) {
                                                i19 = 0;
                                            }
                                        }
                                        int i26 = aVar.f434735a;
                                        String str = aVar.f434736b;
                                        b[] bVarArr4 = bVarArr3;
                                        Intrinsics.checkNotNullExpressionValue(str, "bubbleItem.bubbleId");
                                        String str2 = aVar.f434738d;
                                        int i27 = length;
                                        Intrinsics.checkNotNullExpressionValue(str2, "bubbleItem.content");
                                        String str3 = aVar.f434737c;
                                        Intrinsics.checkNotNullExpressionValue(str3, "bubbleItem.icon");
                                        int i28 = length2;
                                        String str4 = aVar.f434739e;
                                        Intrinsics.checkNotNullExpressionValue(str4, "bubbleItem.link");
                                        arrayList.add(new BuildingBubble(i26, str, str2, str3, new EntranceLink(str4, i19), aVar.f434742h, 0, null, 192, null));
                                        i17++;
                                        bVarArr3 = bVarArr4;
                                        length = i27;
                                        aVarArr = aVarArr;
                                        length2 = i28;
                                    }
                                    bVarArr = bVarArr3;
                                    i3 = length;
                                    list.addAll(arrayList);
                                } else {
                                    bVarArr = bVarArr3;
                                    i3 = length;
                                }
                                i16++;
                                bVarArr3 = bVarArr;
                                length = i3;
                            }
                        }
                        ResultCallback.this.onResultSuccess(linkedHashMap);
                    } catch (Throwable th5) {
                        SquareBaseKt.getSquareLog().e("VasSquareBuildingBubbleService", "getBuildingBubbles on receive but parse throw:", th5);
                        ResultCallback.this.onResultFailure(-2, "getBuildingBubbles parse error");
                    }
                }
            });
        }
    }

    public static /* synthetic */ void delBuildingBubbles$default(VasSquareBuildingBubbleService vasSquareBuildingBubbleService, int i3, int i16, String str, int i17, ResultCallback resultCallback, int i18, Object obj) {
        if ((i18 & 4) != 0) {
            str = "";
        }
        String str2 = str;
        if ((i18 & 16) != 0) {
            resultCallback = null;
        }
        vasSquareBuildingBubbleService.delBuildingBubbles(i3, i16, str2, i17, resultCallback);
    }
}
