package com.tencent.hippykotlin.demo.pages.retain.repo;

import com.heytap.mcssdk.a.a;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.ISSOModelFactory;
import com.tencent.hippykotlin.demo.pages.base.NetworkResponse;
import com.tencent.hippykotlin.demo.pages.base.NetworkUtils;
import com.tencent.hippykotlin.demo.pages.base.NetworkUtils$requestWithCmd$2;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheDiskLru$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.retain.model.GetPromotePopupReq;
import com.tencent.hippykotlin.demo.pages.retain.model.GetPromotePopupRsp;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ECRetainRepository {
    public static final ECRetainRepository INSTANCE = new ECRetainRepository();

    static {
        k kVar = (k) c.f117352a.k(BridgeManager.f117344a.u()).acquireModule("KRNotifyModule");
        k.b(kVar, "retain_mark_retain_notify", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.repo.ECRetainRepository.1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                e eVar2 = eVar;
                String p16 = eVar2 != null ? eVar2.p("retainId") : null;
                boolean z16 = false;
                if (p16 != null) {
                    if (p16.length() > 0) {
                        z16 = true;
                    }
                }
                if (z16) {
                    ECRetainCacheManager.INSTANCE.markRetainShowed(p16);
                }
                return Unit.INSTANCE;
            }
        }, 2, null);
        k.b(kVar, "DetailHalfViewExit", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.repo.ECRetainRepository.2
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                e eVar2 = eVar;
                String p16 = eVar2 != null ? eVar2.p("retainId") : null;
                boolean z16 = false;
                if (p16 != null) {
                    if (p16.length() > 0) {
                        z16 = true;
                    }
                }
                if (z16) {
                    ECRetainCacheManager.INSTANCE.markRetainShowed(p16);
                }
                return Unit.INSTANCE;
            }
        }, 2, null);
        k.b(kVar, "QQECShopDidCompletePayOrderEventNotification", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.repo.ECRetainRepository.3
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                ECRetainRepository eCRetainRepository = ECRetainRepository.INSTANCE;
                String str = ECRetainCacheManager.INSTANCE.getCacheInfo().spuId;
                if (str == null) {
                    str = "";
                }
                ECRetainCacheManager.isNeedRetain = false;
                eCRetainRepository.reportRetainPopup$1(str);
                return Unit.INSTANCE;
            }
        }, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object asyncGetRetainInfo(String str, String str2, Continuation<? super ECRetainInfoModel> continuation) {
        ECRetainRepository$asyncGetRetainInfo$2 eCRetainRepository$asyncGetRetainInfo$2;
        Object coroutine_suspended;
        int i3;
        NetworkResponse networkResponse;
        int i16;
        if (continuation instanceof ECRetainRepository$asyncGetRetainInfo$2) {
            eCRetainRepository$asyncGetRetainInfo$2 = (ECRetainRepository$asyncGetRetainInfo$2) continuation;
            int i17 = eCRetainRepository$asyncGetRetainInfo$2.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                eCRetainRepository$asyncGetRetainInfo$2.label = i17 - Integer.MIN_VALUE;
                Object obj = eCRetainRepository$asyncGetRetainInfo$2.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCRetainRepository$asyncGetRetainInfo$2.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    GetPromotePopupReq getPromotePopupReq = new GetPromotePopupReq(str, 2, str2);
                    NetworkUtils networkUtils = NetworkUtils.INSTANCE;
                    ISSOModelFactory<GetPromotePopupRsp> iSSOModelFactory = GetPromotePopupRsp.Factory;
                    eCRetainRepository$asyncGetRetainInfo$2.L$0 = str;
                    eCRetainRepository$asyncGetRetainInfo$2.label = 1;
                    obj = networkUtils.requestWithCmd("trpc.ecom.detain_user_srv.Detain/GetPromotePopup", getPromotePopupReq, iSSOModelFactory, eCRetainRepository$asyncGetRetainInfo$2);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    str = eCRetainRepository$asyncGetRetainInfo$2.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                networkResponse = (NetworkResponse) obj;
                if (networkResponse.code != 0) {
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = CacheDiskLru$$ExternalSyntheticOutline0.m("get retain info, spuId:[", str, "] type:[");
                    GetPromotePopupRsp getPromotePopupRsp = (GetPromotePopupRsp) networkResponse.data;
                    m3.append(getPromotePopupRsp != null ? Boxing.boxInt(getPromotePopupRsp.type) : null);
                    m3.append(']');
                    kLog.i("Retain", m3.toString());
                    GetPromotePopupRsp getPromotePopupRsp2 = (GetPromotePopupRsp) networkResponse.data;
                    e encode = getPromotePopupRsp2 != null ? getPromotePopupRsp2.encode() : null;
                    Intrinsics.checkNotNull(encode);
                    String valueOf = String.valueOf(Random.INSTANCE.nextInt(0, 100000));
                    int j3 = encode.j("type");
                    int[] values = BoxType$EnumUnboxingSharedUtility.values(4);
                    int length = values.length;
                    int i18 = 0;
                    while (true) {
                        if (i18 >= length) {
                            i16 = 0;
                            break;
                        }
                        i16 = values[i18];
                        if (BoxType$EnumUnboxingSharedUtility.ordinal(i16) == j3) {
                            break;
                        }
                        i18++;
                    }
                    if (i16 == 0) {
                        i16 = 1;
                    }
                    ECRetainInfoModel eCRetainInfoModel = new ECRetainInfoModel(valueOf, str, i16, encode);
                    ECRetainCacheManager eCRetainCacheManager = ECRetainCacheManager.INSTANCE;
                    if (valueOf.length() == 0) {
                        KLog.INSTANCE.e("Retain", "add retain info invalid");
                    } else if (i16 == 1) {
                        DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("the retain info is not retain, retainID:", valueOf, KLog.INSTANCE, "Retain");
                    } else if (!ECRetainCacheManager.isNeedRetain && (!ECRetainCacheManager.retainIdAry.isEmpty())) {
                        KLog.INSTANCE.i("Retain", "not need retain and retain id not empty");
                    } else {
                        ECRetainCacheManager.cacheInfo = eCRetainInfoModel;
                        ECRetainCacheManager.isNeedRetain = true;
                        ECRetainCacheManager.retainIdAry.add(valueOf);
                    }
                    k notifyModule = Utils.INSTANCE.notifyModule(BridgeManager.f117344a.u());
                    e eVar = new e();
                    eVar.w("shouldPop", INSTANCE.isNeedRetain(eCRetainCacheManager.getCacheInfo().retainId));
                    eVar.v(a.f36099i, str);
                    Unit unit = Unit.INSTANCE;
                    k.d(notifyModule, "has_retain_info", eVar, false, 4, null);
                    return eCRetainInfoModel;
                }
                KLog kLog2 = KLog.INSTANCE;
                StringBuilder m16 = CacheDiskLru$$ExternalSyntheticOutline0.m("getRetainInfoget retain info error, spuId:[", str, "] code:[");
                m16.append(networkResponse.code);
                m16.append("] msg:[");
                m16.append(networkResponse.message);
                m16.append(']');
                kLog2.e("Retain", m16.toString());
                return null;
            }
        }
        eCRetainRepository$asyncGetRetainInfo$2 = new ECRetainRepository$asyncGetRetainInfo$2(this, continuation);
        Object obj2 = eCRetainRepository$asyncGetRetainInfo$2.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCRetainRepository$asyncGetRetainInfo$2.label;
        if (i3 != 0) {
        }
        networkResponse = (NetworkResponse) obj2;
        if (networkResponse.code != 0) {
        }
    }

    public final boolean isNeedRetain(String str) {
        ECRetainCacheManager eCRetainCacheManager = ECRetainCacheManager.INSTANCE;
        return !(str.length() == 0) && ECRetainCacheManager.isNeedRetain && ECRetainCacheManager.retainIdAry.contains(str);
    }

    public final void reportRetainPopup$1(final String str) {
        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
        ISSOModelFactory<GetPromotePopupRsp> iSSOModelFactory = GetPromotePopupRsp.Factory;
        Function3<GetPromotePopupRsp, Integer, String, Unit> function3 = new Function3<GetPromotePopupRsp, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.repo.ECRetainRepository$reportRetainPopup$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(GetPromotePopupRsp getPromotePopupRsp, Integer num, String str2) {
                int intValue = num.intValue();
                String str3 = str2;
                if (intValue == 0) {
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("report retain popup success, spuId:[");
                    m3.append(str);
                    m3.append(']');
                    kLog.e("Retain", m3.toString());
                } else {
                    KLog kLog2 = KLog.INSTANCE;
                    StringBuilder m16 = PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("reportRetainPopup report retain popup error, spuId:["), str, "] code:[", intValue, "] msg:[");
                    m16.append(str3);
                    m16.append(']');
                    kLog2.e("Retain", m16.toString());
                }
                return Unit.INSTANCE;
            }
        };
        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
        e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("spu_id", str, "from", "500002");
        NetworkUtils$requestWithCmd$2 networkUtils$requestWithCmd$2 = new NetworkUtils$requestWithCmd$2(iSSOModelFactory, function3);
        int i3 = BridgeModule.$r8$clinit;
        currentBridgeModule.ssoRequest("trpc.ecom.detain_user_srv.Detain/ReportPopup", m3, false, networkUtils$requestWithCmd$2);
    }
}
