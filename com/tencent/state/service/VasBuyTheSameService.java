package com.tencent.state.service;

import com.google.protobuf.nano.MessageNano;
import com.tencent.state.api.INetworkDelegate;
import com.tencent.state.api.INetworkDelegateCallBack;
import com.tencent.state.api.SquareErrorData;
import com.tencent.state.config.NetworkConfig;
import com.tencent.state.data.Gender;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.data.DressInfo;
import com.tencent.state.square.data.DressType;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tt4.a;
import tt4.b;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/state/service/VasBuyTheSameService;", "", "()V", "getDressInfo", "", "uin", "", "callback", "Lcom/tencent/state/service/ResultCallback;", "Lcom/tencent/state/square/data/DressInfo;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasBuyTheSameService {
    private static final String CMD_SERVICE = "trpc.qmeta.status_square_buysame_svr.StatusSquareBuysameSvr";
    private static final String METHOD = "GetAvatarInfo";
    private static final String TAG = "VasBuyTheSameService";

    public final void getDressInfo(long uin, final ResultCallback<DressInfo> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        a aVar = new a();
        aVar.f437468a = uin;
        INetworkDelegate networkDelegate = NetworkConfig.INSTANCE.getNetworkDelegate();
        if (networkDelegate != null) {
            byte[] byteArray = MessageNano.toByteArray(aVar);
            Intrinsics.checkNotNullExpressionValue(byteArray, "MessageNano.toByteArray(req)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            networkDelegate.sendVasProxyRequest(CMD_SERVICE, METHOD, byteArray, emptyMap, new INetworkDelegateCallBack() { // from class: com.tencent.state.service.VasBuyTheSameService$getDressInfo$1
                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onError(SquareErrorData data) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasBuyTheSameService", "errorCode " + data.getErrCode() + " msg: " + data.getErrMsg(), null, 4, null);
                    ResultCallback resultCallback = ResultCallback.this;
                    Integer errCode = data.getErrCode();
                    resultCallback.onResultFailure(errCode != null ? errCode.intValue() : -1, data.getErrMsg());
                }

                @Override // com.tencent.state.api.INetworkDelegateCallBack
                public void onReceive(byte[] rspData) {
                    Gender gender;
                    DressType dressType;
                    int collectionSizeOrDefault;
                    try {
                        b c16 = b.c(rspData);
                        if (c16 != null) {
                            SquareBaseKt.getSquareLog().d("VasBuyTheSameService", "rsp: " + c16);
                            int i3 = c16.f437472d;
                            if (i3 == 1) {
                                gender = Gender.MALE;
                            } else if (i3 != 2) {
                                gender = Gender.UNKNOWN;
                            } else {
                                gender = Gender.FEMALE;
                            }
                            Gender gender2 = gender;
                            int i16 = c16.f437469a;
                            if (i16 == 1) {
                                dressType = DressType.PGC;
                            } else if (i16 == 2) {
                                dressType = DressType.PART_UGC;
                            } else if (i16 != 3) {
                                dressType = DressType.UNKNOWN;
                            } else {
                                dressType = DressType.UGC;
                            }
                            DressType dressType2 = dressType;
                            String[] strArr = c16.f437471c;
                            Intrinsics.checkNotNullExpressionValue(strArr, "rsp.itemIds");
                            ArrayList<String> arrayList = new ArrayList();
                            for (String str : strArr) {
                                if (!Intrinsics.areEqual(str, "0")) {
                                    arrayList.add(str);
                                }
                            }
                            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                            for (String it : arrayList) {
                                Intrinsics.checkNotNullExpressionValue(it, "it");
                                arrayList2.add(Integer.valueOf(Integer.parseInt(it)));
                            }
                            ResultCallback.this.onResultSuccess(new DressInfo(gender2, dressType2, c16.f437470b, arrayList2, c16.f437473e));
                        }
                    } catch (Exception e16) {
                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "VasBuyTheSameService", "parse error " + e16, null, 4, null);
                        ResultCallback.this.onResultFailure(-1, e16.getMessage());
                    }
                }
            });
        }
    }
}
