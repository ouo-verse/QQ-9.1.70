package com.tencent.ecommerce.biz.detail.viewmodel.shop;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import bh0.ECPageParserParams;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.ecommerce.base.style.service.ECPTSStyleManager;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.component.IECPTSProcessor;
import com.tencent.ecommerce.base.ui.e;
import com.tencent.ecommerce.biz.detail.dataprocessor.processor.ECProductDetailDataParserType;
import com.tencent.ecommerce.biz.detail.repo.saas.ECDetailCustomRelatedRepo;
import com.tencent.ecommerce.biz.detail.repo.shop.data.ECShopProductDetailData;
import com.tencent.ecommerce.biz.detail.repo.shop.data.ECShopProductDetailInfo;
import com.tencent.ecommerce.biz.recommend.models.ECShopRecommendScene;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import gh0.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0001/B+\u0012\u0006\u0010*\u001a\u00020\r\u0012\u0006\u0010,\u001a\u00020+\u0012\b\b\u0002\u0010&\u001a\u00020\u001b\u0012\b\b\u0002\u0010)\u001a\u00020\r\u00a2\u0006\u0004\b-\u0010.J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J3\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0014\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\u001b\u0010\u0017\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u0019\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u0018J\u001b\u0010\u001a\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0014\u0010&\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010\u001dR\u0014\u0010)\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00060"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopProductDetailOffSaleViewModel;", "Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopProductDetailBaseViewModel;", "", "Lcom/tencent/ecommerce/base/ui/b;", "pageDataList", "", "z2", "Lorg/json/JSONObject;", "data", "requestParams", "x2", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/c;", "shopProductDetailInfo", "", "y2", "service", "method", "requestExtraParams", "C2", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", ICustomDataEditor.NUMBER_PARAM_2, "B2", "(Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", NowProxyConstants.AccountInfoKey.A2, "w2", "", "V", "Z", "isSaasRecommendRetNull", "Lcom/tencent/ecommerce/biz/detail/repo/saas/ECDetailCustomRelatedRepo;", "W", "Lkotlin/Lazy;", "v2", "()Lcom/tencent/ecommerce/biz/detail/repo/saas/ECDetailCustomRelatedRepo;", "customRelatedRepo", "X", "isProductFromWindow", "Y", "Ljava/lang/String;", "mediaId", "bizType", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "<init>", "(Ljava/lang/String;Landroidx/fragment/app/FragmentManager;ZLjava/lang/String;)V", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopProductDetailOffSaleViewModel extends ECShopProductDetailBaseViewModel {

    /* renamed from: V, reason: from kotlin metadata */
    private boolean isSaasRecommendRetNull;

    /* renamed from: W, reason: from kotlin metadata */
    private final Lazy customRelatedRepo;

    /* renamed from: X, reason: from kotlin metadata */
    private final boolean isProductFromWindow;

    /* renamed from: Y, reason: from kotlin metadata */
    private final String mediaId;

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J<\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopProductDetailOffSaleViewModel$b", "Lcom/tencent/ecommerce/base/ui/e;", "", IECDtReport.ACTION_IDENTIFIER, "Ljava/util/HashMap;", "dataMap", "Landroid/view/View;", "view", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "onTapEventTriggered", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends e {
        b() {
        }

        @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
        public void onTapEventTriggered(String identifier, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
            Integer value = ECShopProductDetailOffSaleViewModel.this.c2().getValue();
            if (value != null && value.intValue() == 5) {
                return;
            }
            if (ECShopProductDetailOffSaleViewModel.this.isProductFromWindow) {
                ECScheme.g("mqqapi://ecommerce/open?target=7&media_id=" + ECShopProductDetailOffSaleViewModel.this.mediaId, null, 2, null);
            } else {
                ECShopProductDetailOffSaleViewModel eCShopProductDetailOffSaleViewModel = ECShopProductDetailOffSaleViewModel.this;
                ECScheme.g(eCShopProductDetailOffSaleViewModel.y2(eCShopProductDetailOffSaleViewModel.e2().getValue()), null, 2, null);
            }
            cg0.a.b("ECDetailPageViewModel", "[onTapEventTriggered] ");
        }
    }

    public /* synthetic */ ECShopProductDetailOffSaleViewModel(String str, FragmentManager fragmentManager, boolean z16, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, fragmentManager, (i3 & 4) != 0 ? false : z16, (i3 & 8) != 0 ? "" : str2);
    }

    private final ECDetailCustomRelatedRepo v2() {
        return (ECDetailCustomRelatedRepo) this.customRelatedRepo.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ECBasePtsViewData> x2(JSONObject data, JSONObject requestParams) {
        String str;
        IECPTSProcessor a16 = com.tencent.ecommerce.biz.detail.dataprocessor.processor.b.f102022b.a(ECProductDetailDataParserType.ECProductDetailDataBizTypeShopOffSale);
        JSONObject jSONObject = new JSONObject();
        if (this.isProductFromWindow) {
            str = "1";
        } else {
            str = "0";
        }
        jSONObject.put("is_from_window", str);
        List<ECPageParserParams> processRemoteParserParamsArray = a16.processRemoteParserParamsArray(data, jSONObject);
        if (processRemoteParserParamsArray == null) {
            processRemoteParserParamsArray = a16.localPageParserParamsArray(jSONObject);
        }
        List<ECBasePtsViewData> process = a16.process(processRemoteParserParamsArray, data, requestParams);
        return process != null ? process : new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z2(List<ECBasePtsViewData> pageDataList) {
        for (ECBasePtsViewData eCBasePtsViewData : pageDataList) {
            String pageName = eCBasePtsViewData.getPageName();
            if (Intrinsics.areEqual(pageName, "qshop_detail_off_sale_recom_title")) {
                try {
                    String proteusData = eCBasePtsViewData.getProteusData();
                    if (proteusData == null) {
                        proteusData = "";
                    }
                    JSONObject jSONObject = new JSONObject(proteusData);
                    jSONObject.put("hide_arrow", true);
                    PTSComposer b16 = d.f402041a.b(pageName, ECPTSStyleManager.e(pageName, wg0.a.a()), jSONObject.toString(), null);
                    eCBasePtsViewData.d(jSONObject.toString());
                    eCBasePtsViewData.e(b16);
                } catch (Exception e16) {
                    cg0.a.a("ECDetailPageViewModel", "rebuildPtsViewData", "parse proteus data error, proteusData = " + eCBasePtsViewData.getProteusData() + ", error = " + e16);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object A2(JSONObject jSONObject, Continuation<? super Unit> continuation) {
        ECShopProductDetailOffSaleViewModel$requestMoreRecommendData$1 eCShopProductDetailOffSaleViewModel$requestMoreRecommendData$1;
        Object coroutine_suspended;
        int i3;
        ECShopProductDetailOffSaleViewModel eCShopProductDetailOffSaleViewModel;
        JSONObject jSONObject2;
        List<ECBasePtsViewData> a16;
        if (continuation instanceof ECShopProductDetailOffSaleViewModel$requestMoreRecommendData$1) {
            eCShopProductDetailOffSaleViewModel$requestMoreRecommendData$1 = (ECShopProductDetailOffSaleViewModel$requestMoreRecommendData$1) continuation;
            int i16 = eCShopProductDetailOffSaleViewModel$requestMoreRecommendData$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCShopProductDetailOffSaleViewModel$requestMoreRecommendData$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCShopProductDetailOffSaleViewModel$requestMoreRecommendData$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCShopProductDetailOffSaleViewModel$requestMoreRecommendData$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (this.isProductFromWindow) {
                        eCShopProductDetailOffSaleViewModel$requestMoreRecommendData$1.L$0 = this;
                        eCShopProductDetailOffSaleViewModel$requestMoreRecommendData$1.L$1 = jSONObject;
                        eCShopProductDetailOffSaleViewModel$requestMoreRecommendData$1.label = 1;
                        obj = w2(jSONObject, eCShopProductDetailOffSaleViewModel$requestMoreRecommendData$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        eCShopProductDetailOffSaleViewModel = this;
                        a16 = eCShopProductDetailOffSaleViewModel.v2().a((JSONObject) obj, jSONObject);
                    } else {
                        JSONObject jSONObject3 = new JSONObject(jSONObject.toString());
                        ECShopRecommendScene eCShopRecommendScene = ECShopRecommendScene.QQ_OFF_SALE_SCENE;
                        jSONObject3.put("recom_scene", eCShopRecommendScene.value);
                        jSONObject3.put("scene", eCShopRecommendScene.value);
                        ECShopProductDetailData j26 = j2();
                        eCShopProductDetailOffSaleViewModel$requestMoreRecommendData$1.L$0 = this;
                        eCShopProductDetailOffSaleViewModel$requestMoreRecommendData$1.L$1 = jSONObject3;
                        eCShopProductDetailOffSaleViewModel$requestMoreRecommendData$1.label = 2;
                        Object i17 = j26.i(jSONObject3, eCShopProductDetailOffSaleViewModel$requestMoreRecommendData$1);
                        if (i17 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        eCShopProductDetailOffSaleViewModel = this;
                        obj = i17;
                        jSONObject2 = jSONObject3;
                        a16 = eCShopProductDetailOffSaleViewModel.j2().e((JSONObject) obj, jSONObject2);
                    }
                } else if (i3 == 1) {
                    jSONObject = (JSONObject) eCShopProductDetailOffSaleViewModel$requestMoreRecommendData$1.L$1;
                    eCShopProductDetailOffSaleViewModel = (ECShopProductDetailOffSaleViewModel) eCShopProductDetailOffSaleViewModel$requestMoreRecommendData$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    a16 = eCShopProductDetailOffSaleViewModel.v2().a((JSONObject) obj, jSONObject);
                } else if (i3 == 2) {
                    jSONObject2 = (JSONObject) eCShopProductDetailOffSaleViewModel$requestMoreRecommendData$1.L$1;
                    eCShopProductDetailOffSaleViewModel = (ECShopProductDetailOffSaleViewModel) eCShopProductDetailOffSaleViewModel$requestMoreRecommendData$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    a16 = eCShopProductDetailOffSaleViewModel.j2().e((JSONObject) obj, jSONObject2);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (!a16.isEmpty()) {
                    eCShopProductDetailOffSaleViewModel.Z1().postValue(a16);
                }
                return Unit.INSTANCE;
            }
        }
        eCShopProductDetailOffSaleViewModel$requestMoreRecommendData$1 = new ECShopProductDetailOffSaleViewModel$requestMoreRecommendData$1(this, continuation);
        Object obj2 = eCShopProductDetailOffSaleViewModel$requestMoreRecommendData$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCShopProductDetailOffSaleViewModel$requestMoreRecommendData$1.label;
        if (i3 != 0) {
        }
        if (!a16.isEmpty()) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object B2(JSONObject jSONObject, Continuation<? super JSONObject> continuation) {
        ECShopProductDetailOffSaleViewModel$requestPageRelatedData$1 eCShopProductDetailOffSaleViewModel$requestPageRelatedData$1;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof ECShopProductDetailOffSaleViewModel$requestPageRelatedData$1) {
            eCShopProductDetailOffSaleViewModel$requestPageRelatedData$1 = (ECShopProductDetailOffSaleViewModel$requestPageRelatedData$1) continuation;
            int i16 = eCShopProductDetailOffSaleViewModel$requestPageRelatedData$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCShopProductDetailOffSaleViewModel$requestPageRelatedData$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCShopProductDetailOffSaleViewModel$requestPageRelatedData$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCShopProductDetailOffSaleViewModel$requestPageRelatedData$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                        return (JSONObject) obj;
                    }
                    if (i3 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return (JSONObject) obj;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (this.isProductFromWindow) {
                    eCShopProductDetailOffSaleViewModel$requestPageRelatedData$1.label = 1;
                    obj = w2(jSONObject, eCShopProductDetailOffSaleViewModel$requestPageRelatedData$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return (JSONObject) obj;
                }
                JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
                ECShopRecommendScene eCShopRecommendScene = ECShopRecommendScene.QQ_OFF_SALE_SCENE;
                jSONObject2.put("recom_scene", eCShopRecommendScene.value);
                jSONObject2.put("scene", eCShopRecommendScene.value);
                ECShopProductDetailData j26 = j2();
                eCShopProductDetailOffSaleViewModel$requestPageRelatedData$1.label = 2;
                obj = j26.i(jSONObject2, eCShopProductDetailOffSaleViewModel$requestPageRelatedData$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return (JSONObject) obj;
            }
        }
        eCShopProductDetailOffSaleViewModel$requestPageRelatedData$1 = new ECShopProductDetailOffSaleViewModel$requestPageRelatedData$1(this, continuation);
        Object obj2 = eCShopProductDetailOffSaleViewModel$requestPageRelatedData$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCShopProductDetailOffSaleViewModel$requestPageRelatedData$1.label;
        if (i3 == 0) {
        }
    }

    public Object C2(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        c2().postValue(Boxing.boxInt(3));
        Object withContext = BuildersKt.withContext(getDefaultDispatcher(), new ECShopProductDetailOffSaleViewModel$requestPtsDataWithModel$2(this, str, str2, jSONObject, jSONObject2, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return withContext == coroutine_suspended ? withContext : Unit.INSTANCE;
    }

    @Override // com.tencent.ecommerce.biz.detail.viewmodel.shop.ECShopProductDetailBaseViewModel
    public Map<String, IPTSLiteEventListener> n2() {
        Map<String, IPTSLiteEventListener> mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("JumpToWindowOrShopHome", new b()));
        return mapOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object w2(JSONObject jSONObject, Continuation<? super JSONObject> continuation) {
        ECShopProductDetailOffSaleViewModel$getSaasRecommend$1 eCShopProductDetailOffSaleViewModel$getSaasRecommend$1;
        Object coroutine_suspended;
        int i3;
        ECShopProductDetailOffSaleViewModel eCShopProductDetailOffSaleViewModel;
        JSONObject jSONObject2;
        if (continuation instanceof ECShopProductDetailOffSaleViewModel$getSaasRecommend$1) {
            eCShopProductDetailOffSaleViewModel$getSaasRecommend$1 = (ECShopProductDetailOffSaleViewModel$getSaasRecommend$1) continuation;
            int i16 = eCShopProductDetailOffSaleViewModel$getSaasRecommend$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCShopProductDetailOffSaleViewModel$getSaasRecommend$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCShopProductDetailOffSaleViewModel$getSaasRecommend$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCShopProductDetailOffSaleViewModel$getSaasRecommend$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    this.isSaasRecommendRetNull = false;
                    JSONObject jSONObject3 = new JSONObject(jSONObject.toString());
                    jSONObject3.put("media_id", this.mediaId);
                    jSONObject3.put("cookie", "");
                    jSONObject3.put("source", 3);
                    ECDetailCustomRelatedRepo v26 = v2();
                    eCShopProductDetailOffSaleViewModel$getSaasRecommend$1.L$0 = this;
                    eCShopProductDetailOffSaleViewModel$getSaasRecommend$1.label = 1;
                    obj = v26.c("trpc.ecom.show_window_svr.ShowWindowSvr", "/trpc.ecom.show_window_svr.ShowWindowSvr/RecommendProducts", jSONObject3, eCShopProductDetailOffSaleViewModel$getSaasRecommend$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    eCShopProductDetailOffSaleViewModel = this;
                } else if (i3 == 1) {
                    eCShopProductDetailOffSaleViewModel = (ECShopProductDetailOffSaleViewModel) eCShopProductDetailOffSaleViewModel$getSaasRecommend$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                jSONObject2 = (JSONObject) obj;
                if (jSONObject2 == null) {
                    eCShopProductDetailOffSaleViewModel.isSaasRecommendRetNull = true;
                }
                return jSONObject2 == null ? jSONObject2 : new JSONObject();
            }
        }
        eCShopProductDetailOffSaleViewModel$getSaasRecommend$1 = new ECShopProductDetailOffSaleViewModel$getSaasRecommend$1(this, continuation);
        Object obj2 = eCShopProductDetailOffSaleViewModel$getSaasRecommend$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCShopProductDetailOffSaleViewModel$getSaasRecommend$1.label;
        if (i3 != 0) {
        }
        jSONObject2 = (JSONObject) obj2;
        if (jSONObject2 == null) {
        }
        if (jSONObject2 == null) {
        }
    }

    public ECShopProductDetailOffSaleViewModel(String str, FragmentManager fragmentManager, boolean z16, String str2) {
        super(str, false, fragmentManager, null, 8, null);
        Lazy lazy;
        this.isProductFromWindow = z16;
        this.mediaId = str2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ECDetailCustomRelatedRepo>() { // from class: com.tencent.ecommerce.biz.detail.viewmodel.shop.ECShopProductDetailOffSaleViewModel$customRelatedRepo$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ECDetailCustomRelatedRepo invoke() {
                return new ECDetailCustomRelatedRepo();
            }
        });
        this.customRelatedRepo = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String y2(ECShopProductDetailInfo shopProductDetailInfo) {
        JSONObject jSONObject;
        if (shopProductDetailInfo == null || (jSONObject = shopProductDetailInfo.infoData) == null) {
            jSONObject = new JSONObject();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("shop");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("button");
        if (optJSONObject2 == null) {
            optJSONObject2 = new JSONObject();
        }
        return optJSONObject2.optString("jump_url", "");
    }
}
