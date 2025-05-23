package com.tencent.ecommerce.biz.detail.viewmodel.shop;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import bh0.d;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.report.service.ECShowPageCostTimeScene;
import com.tencent.ecommerce.base.report.service.k;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.base.style.service.ECPTSStyleManager;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.ECFloatCommonDetailBulletinFragment;
import com.tencent.ecommerce.base.ui.e;
import com.tencent.ecommerce.biz.bulletin.BulletinScene;
import com.tencent.ecommerce.biz.detail.repo.shop.data.ECShopProductDetailData;
import com.tencent.ecommerce.biz.detail.repo.shop.data.ECShopProductDetailInfo;
import com.tencent.ecommerce.biz.detail.ui.view.ECShopDetailBrandFragment;
import com.tencent.ecommerce.biz.detail.ui.view.ECShopDetailServiceFragment;
import com.tencent.ecommerce.biz.retain.repo.ECRetainRepository;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.biz.shophome.ui.dialog.ECShopManageDialog;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000 c2\u00020\u0001:\u0001dB)\u0012\u0006\u0010U\u001a\u00020\u0002\u0012\u0006\u0010X\u001a\u00020\u0013\u0012\u0006\u0010\\\u001a\u00020Y\u0012\b\b\u0002\u0010`\u001a\u00020\u0002\u00a2\u0006\u0004\ba\u0010bJ\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\rJ\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0016J\u0014\u0010\u0014\u001a\u00020\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0004J\u0014\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u0015H\u0016R\u001a\u0010\u001c\u001a\u00020\u00178\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\"\u001a\u00020\u001d8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R(\u0010*\u001a\b\u0012\u0004\u0012\u00020\n0#8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020\n0+8\u0006\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R&\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00040#8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b1\u0010%\u001a\u0004\b2\u0010'R#\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00040+8\u0006\u00a2\u0006\f\n\u0004\b4\u0010-\u001a\u0004\b5\u0010/R$\u00109\u001a\u0010\u0012\f\u0012\n 7*\u0004\u0018\u00010\n0\n0#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010%R\u001d\u0010<\u001a\b\u0012\u0004\u0012\u00020\n0+8\u0006\u00a2\u0006\f\n\u0004\b:\u0010-\u001a\u0004\b;\u0010/R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020=0+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010-R\u001d\u0010B\u001a\b\u0012\u0004\u0012\u00020=0+8\u0006\u00a2\u0006\f\n\u0004\b@\u0010-\u001a\u0004\bA\u0010/R4\u0010F\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00150#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010%\u001a\u0004\bD\u0010'\"\u0004\bE\u0010)R)\u0010I\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00150+8\u0006\u00a2\u0006\f\n\u0004\bG\u0010-\u001a\u0004\bH\u0010/R\u0017\u0010O\u001a\u00020J8\u0006\u00a2\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\"\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010U\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010X\u001a\u00020\u00138\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010\\\u001a\u00020Y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0017\u0010`\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b]\u0010T\u001a\u0004\b^\u0010_\u00a8\u0006e"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopProductDetailBaseViewModel;", "Lbh0/d;", "", "photoDataStr", "", "m2", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "W1", "", "offset", "o2", "Lcom/tencent/ecommerce/base/ui/b;", "f2", "ptsViewData", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "N1", "list", "", "l2", "", ICustomDataEditor.NUMBER_PARAM_2, "Lkotlinx/coroutines/CoroutineDispatcher;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlinx/coroutines/CoroutineDispatcher;", "b2", "()Lkotlinx/coroutines/CoroutineDispatcher;", "defaultDispatcher", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/ECShopProductDetailData;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "j2", "()Lcom/tencent/ecommerce/biz/detail/repo/shop/data/ECShopProductDetailData;", "shopProductDetailData", "Landroidx/lifecycle/MutableLiveData;", "D", "Landroidx/lifecycle/MutableLiveData;", "c2", "()Landroidx/lifecycle/MutableLiveData;", "setPageErrorStatus", "(Landroidx/lifecycle/MutableLiveData;)V", "pageErrorStatus", "Landroidx/lifecycle/LiveData;", "E", "Landroidx/lifecycle/LiveData;", "d2", "()Landroidx/lifecycle/LiveData;", "pageErrorStatusLiveData", UserInfo.SEX_FEMALE, "Z1", "adapterData", "G", ICustomDataEditor.STRING_ARRAY_PARAM_2, "adapterLiveDataPts", "kotlin.jvm.PlatformType", "H", "_scrollOffset", "I", "i2", "scrollOffsetLiveData", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/c;", "J", "_productData", "K", "e2", "productDetailLiveData", "L", "g2", "setReportStatus", "reportStatus", "M", SemanticAttributes.DbSystemValues.H2, "reportStatusLiveData", "Lcom/tencent/ecommerce/base/report/service/k;", "N", "Lcom/tencent/ecommerce/base/report/service/k;", "k2", "()Lcom/tencent/ecommerce/base/report/service/k;", "showPageCostTime", "P", "Ljava/util/Map;", "eventHandlerMap", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/String;", "bizType", BdhLogUtil.LogTag.Tag_Req, "Z", "isSelect", "Landroidx/fragment/app/FragmentManager;", ExifInterface.LATITUDE_SOUTH, "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "T", "X1", "()Ljava/lang/String;", "adClickId", "<init>", "(Ljava/lang/String;ZLandroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", "U", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public abstract class ECShopProductDetailBaseViewModel extends d {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy shopProductDetailData;

    /* renamed from: D, reason: from kotlin metadata */
    private MutableLiveData<Integer> pageErrorStatus;

    /* renamed from: E, reason: from kotlin metadata */
    private final LiveData<Integer> pageErrorStatusLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    private final MutableLiveData<List<ECBasePtsViewData>> adapterData;

    /* renamed from: G, reason: from kotlin metadata */
    private final LiveData<List<ECBasePtsViewData>> adapterLiveDataPts;

    /* renamed from: H, reason: from kotlin metadata */
    private MutableLiveData<Integer> _scrollOffset;

    /* renamed from: I, reason: from kotlin metadata */
    private final LiveData<Integer> scrollOffsetLiveData;

    /* renamed from: J, reason: from kotlin metadata */
    private final LiveData<ECShopProductDetailInfo> _productData;

    /* renamed from: K, reason: from kotlin metadata */
    private final LiveData<ECShopProductDetailInfo> productDetailLiveData;

    /* renamed from: L, reason: from kotlin metadata */
    private MutableLiveData<Map<String, String>> reportStatus;

    /* renamed from: M, reason: from kotlin metadata */
    private final LiveData<Map<String, String>> reportStatusLiveData;

    /* renamed from: N, reason: from kotlin metadata */
    private final k showPageCostTime;

    /* renamed from: P, reason: from kotlin metadata */
    private Map<String, ? extends IPTSLiteEventListener> eventHandlerMap;

    /* renamed from: Q, reason: from kotlin metadata */
    private final String bizType;

    /* renamed from: R, reason: from kotlin metadata */
    public final boolean isSelect;

    /* renamed from: S, reason: from kotlin metadata */
    private final FragmentManager fragmentManager;

    /* renamed from: T, reason: from kotlin metadata */
    private final String adClickId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final CoroutineDispatcher defaultDispatcher;

    public /* synthetic */ ECShopProductDetailBaseViewModel(String str, boolean z16, FragmentManager fragmentManager, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z16, fragmentManager, (i3 & 8) != 0 ? "" : str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W1(PTSComposer ptsComposer) {
        String jsonData = ptsComposer != null ? ptsComposer.getJsonData() : null;
        if (jsonData == null || jsonData.length() == 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(jsonData);
            JSONObject optJSONObject = jSONObject.optJSONObject("product");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            optJSONObject.put("showAll", optJSONObject.optBoolean("showAll", true) ? false : true);
            ptsComposer.setData(jSONObject.toString());
        } catch (JSONException unused) {
            cg0.a.a("ECDetailPageCustomViewModel", "onTapEventTriggered", "[onTapEventTriggered] parse proteusJson:" + jsonData + " error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<String> m2(String photoDataStr) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(photoDataStr);
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                String str = "";
                Object obj = jSONArray.get(i3);
                boolean z16 = true;
                if (obj instanceof JSONObject) {
                    str = ((JSONObject) obj).optString("url");
                    if (str.length() == 0) {
                        str = ((JSONObject) obj).optString("mainPics");
                    }
                } else if (obj instanceof String) {
                    str = (String) obj;
                }
                if (str.length() <= 0) {
                    z16 = false;
                }
                if (z16) {
                    arrayList.add(str);
                }
            }
        } catch (JSONException unused) {
            cg0.a.a("ECDetailPageCustomViewModel", "photoBrowser", "[photoBrowser] parse photoData:" + photoDataStr + " error");
        }
        return arrayList;
    }

    @Override // bh0.d
    public IPTSLiteEventListener N1(ECBasePtsViewData ptsViewData) {
        return new e() { // from class: com.tencent.ecommerce.biz.detail.viewmodel.shop.ECShopProductDetailBaseViewModel$getPtsLiteEventListener$1

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopProductDetailBaseViewModel$getPtsLiteEventListener$1$a", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "Lorg/json/JSONObject;", "data", "", "onCallbackFinished", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
            /* loaded from: classes31.dex */
            public static final class a implements IECSchemeCallback {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ String f102484a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ String f102485b;

                a(String str, String str2) {
                    this.f102484a = str;
                    this.f102485b = str2;
                }

                @Override // com.tencent.ecommerce.base.router.api.IECSchemeCallback
                public void onCallbackFinished(JSONObject data) {
                    if (Intrinsics.areEqual(this.f102484a, "jumpToCouponPage")) {
                        ECRetainRepository.f104121b.refreshRetainInfo(this.f102485b);
                    }
                }
            }

            @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
            public void onTapEventTriggered(String identifier, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
                String str;
                Map map;
                Map map2;
                FragmentManager fragmentManager;
                Context context;
                LiveData liveData;
                String str2;
                String str3;
                List m26;
                Context a16;
                Context a17;
                LiveData liveData2;
                Context context2;
                Map map3;
                if (dataMap == null || (str = dataMap.get("eventType")) == null) {
                    return;
                }
                cg0.a.b("ECDetailPageCustomViewModel", "[onTapEventTriggered] " + str);
                String str4 = dataMap.get("pts:pageName");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (str4 != null) {
                    int hashCode = str4.hashCode();
                    if (hashCode != -1817114101) {
                        if (hashCode != 435819191) {
                            if (hashCode == 1053881545 && str4.equals("qshop_detail_comment")) {
                                linkedHashMap.put("QSTORE_PRD_DETAIL_EVENT_CODE", "qstore_prd_detail_pg_comment_ck");
                                ECShopProductDetailBaseViewModel.this.g2().postValue(linkedHashMap);
                            }
                        } else if (str4.equals("qshop_head_card")) {
                            linkedHashMap.put("QSTORE_PRD_DETAIL_EVENT_CODE", "qstore_prd_detail_pg_store_info_ck");
                            ECShopProductDetailBaseViewModel.this.g2().postValue(linkedHashMap);
                        }
                    } else if (str4.equals("qshop_detail_pictures")) {
                        linkedHashMap.put("QSTORE_PRD_DETAIL_EVENT_CODE", "qstore_prd_detail_pg_detail_ck");
                        ECShopProductDetailBaseViewModel.this.g2().postValue(linkedHashMap);
                    }
                }
                map = ECShopProductDetailBaseViewModel.this.eventHandlerMap;
                if (map.isEmpty()) {
                    ECShopProductDetailBaseViewModel eCShopProductDetailBaseViewModel = ECShopProductDetailBaseViewModel.this;
                    eCShopProductDetailBaseViewModel.eventHandlerMap = eCShopProductDetailBaseViewModel.n2();
                }
                map2 = ECShopProductDetailBaseViewModel.this.eventHandlerMap;
                if (map2.containsKey(str)) {
                    map3 = ECShopProductDetailBaseViewModel.this.eventHandlerMap;
                    IPTSLiteEventListener iPTSLiteEventListener = (IPTSLiteEventListener) map3.get(str);
                    if (iPTSLiteEventListener != null) {
                        iPTSLiteEventListener.onTapEventTriggered(identifier, dataMap, view, ptsComposer);
                        return;
                    }
                    return;
                }
                switch (str.hashCode()) {
                    case -2103673948:
                        if (str.equals("showAlertView")) {
                            String str5 = dataMap.get("alertMsg");
                            if (str5 == null) {
                                str5 = "";
                            }
                            String str6 = dataMap.get("copyUrl");
                            if (str6 == null) {
                                str6 = "";
                            }
                            ECShopManageDialog eCShopManageDialog = new ECShopManageDialog();
                            Bundle bundle = new Bundle();
                            bundle.putString("MANAGE_SHOP_DES", str5);
                            bundle.putString("MANAGE_SHOP_URL", str6);
                            Unit unit = Unit.INSTANCE;
                            eCShopManageDialog.setArguments(bundle);
                            fragmentManager = ECShopProductDetailBaseViewModel.this.fragmentManager;
                            eCShopManageDialog.uh(fragmentManager, new Function1<ECShopManageDialog.ECShopManageDialogResult, Unit>() { // from class: com.tencent.ecommerce.biz.detail.viewmodel.shop.ECShopProductDetailBaseViewModel$getPtsLiteEventListener$1$onTapEventTriggered$6
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(ECShopManageDialog.ECShopManageDialogResult eCShopManageDialogResult) {
                                    invoke2(eCShopManageDialogResult);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(ECShopManageDialog.ECShopManageDialogResult eCShopManageDialogResult) {
                                    if (Intrinsics.areEqual(eCShopManageDialogResult, ECShopManageDialog.ECShopManageDialogResult.Cancel.f104358d)) {
                                        cg0.a.b("ECDetailPageCustomViewModel", "showAlertView cancel");
                                    } else if (Intrinsics.areEqual(eCShopManageDialogResult, ECShopManageDialog.ECShopManageDialogResult.PageReady.f104359d)) {
                                        cg0.a.b("ECDetailPageCustomViewModel", "showAlertView confirm");
                                    }
                                }
                            });
                            return;
                        }
                        return;
                    case -1838883096:
                        if (str.equals("showShippingTipsView")) {
                            String str7 = dataMap.get("tipsMsg");
                            if (str7 == null) {
                                str7 = "";
                            }
                            if (view == null || (context = view.getContext()) == null) {
                                return;
                            }
                            ECFloatCommonDetailBulletinFragment.INSTANCE.a(context, str7, "\u7269\u6d41");
                            return;
                        }
                        return;
                    case -1303051865:
                        if (str.equals("expand_detail_list")) {
                            ECShopProductDetailBaseViewModel.this.W1(ptsComposer);
                            return;
                        }
                        return;
                    case -931150290:
                        if (str.equals("allInOneJump")) {
                            String str8 = dataMap.get(WadlProxyConsts.KEY_JUMP_URL);
                            if (str8 == null) {
                                str8 = "";
                            }
                            liveData = ECShopProductDetailBaseViewModel.this._productData;
                            ECShopProductDetailInfo eCShopProductDetailInfo = (ECShopProductDetailInfo) liveData.getValue();
                            if (eCShopProductDetailInfo == null || (str2 = eCShopProductDetailInfo.productID) == null) {
                                str2 = "";
                            }
                            cg0.a.b("ECDetailPageCustomViewModel", "[onTapEventTriggered] type: " + str + " jumpUrl:" + str8);
                            if (Intrinsics.areEqual(identifier, "jumpToCouponPage")) {
                                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                                linkedHashMap2.put("QSTORE_PRD_DETAIL_EVENT_CODE", "qstore_prd_detail_price_reduce_clk");
                                ECShopProductDetailBaseViewModel.this.g2().postValue(linkedHashMap2);
                            }
                            if (TextUtils.isEmpty(str8)) {
                                return;
                            }
                            if (ECShopProductDetailBaseViewModel.this.getAdClickId().length() > 0) {
                                str8 = str8 + "&qz_gdt=" + ECShopProductDetailBaseViewModel.this.getAdClickId();
                            }
                            ECScheme.f(str8, new a(identifier, str2), null, 4, null);
                            return;
                        }
                        return;
                    case -594560141:
                        if (str.equals("jumpScheme")) {
                            String str9 = dataMap.get(WadlProxyConsts.KEY_JUMP_URL);
                            if (str9 == null) {
                                str9 = "";
                            }
                            cg0.a.b("ECDetailPageCustomViewModel", "[onTapEventTriggered] type: " + str + " jumpUrl:" + str9);
                            if (TextUtils.isEmpty(str9)) {
                                return;
                            }
                            ECScheme.g(str9, null, 2, null);
                            com.tencent.ecommerce.biz.common.c.f101553a.d();
                            return;
                        }
                        return;
                    case 433923123:
                        if (str.equals("showPhotoBrowser")) {
                            if (!dataMap.containsKey("originalPhotosData") ? (str3 = dataMap.get("photosData")) == null : (str3 = dataMap.get("originalPhotosData")) == null) {
                                str3 = "";
                            }
                            if (str3.length() == 0) {
                                return;
                            }
                            m26 = ECShopProductDetailBaseViewModel.this.m2(str3);
                            lg0.a.b(lg0.a.f414523b, m26, identifier != null ? Integer.parseInt(identifier) : 0, null, 4, null);
                            return;
                        }
                        return;
                    case 437490454:
                        if (str.equals("showBrandInfoList")) {
                            String str10 = dataMap.get("shopId");
                            if (str10 == null) {
                                str10 = "";
                            }
                            String str11 = dataMap.get("brandId");
                            if (str11 == null) {
                                str11 = "";
                            }
                            Bundle bundle2 = new Bundle();
                            bundle2.putString("is_trans_activity", "1");
                            bundle2.putString("shopId", str10);
                            bundle2.putString("brandId", str11);
                            if (view == null || (a16 = view.getContext()) == null) {
                                a16 = wg0.a.a();
                            }
                            yi0.a.p(a16, ECShopDetailBrandFragment.class, bundle2, 0, null);
                            return;
                        }
                        return;
                    case 1500436910:
                        if (str.equals("showServiceDetailView")) {
                            String str12 = dataMap.get("serviceInfo");
                            if (str12 == null) {
                                str12 = "";
                            }
                            Bundle bundle3 = new Bundle();
                            bundle3.putString("is_trans_activity", "1");
                            bundle3.putString("service", str12);
                            if (view == null || (a17 = view.getContext()) == null) {
                                a17 = wg0.a.a();
                            }
                            yi0.a.p(a17, ECShopDetailServiceFragment.class, bundle3, 0, null);
                            return;
                        }
                        return;
                    case 1829253601:
                        if (str.equals("showBulletinTipsView")) {
                            String str13 = dataMap.get("tipsMsg");
                            if (str13 == null) {
                                str13 = "";
                            }
                            if (view != null && (context2 = view.getContext()) != null) {
                                ECFloatCommonDetailBulletinFragment.INSTANCE.a(context2, str13, "\u516c\u544a");
                            }
                            liveData2 = ECShopProductDetailBaseViewModel.this._productData;
                            ECShopProductDetailInfo eCShopProductDetailInfo2 = (ECShopProductDetailInfo) liveData2.getValue();
                            if (eCShopProductDetailInfo2 != null) {
                                com.tencent.ecommerce.biz.bulletin.b.c(com.tencent.ecommerce.biz.bulletin.b.f101349a, eCShopProductDetailInfo2.getShopId(), eCShopProductDetailInfo2.productID, BulletinScene.GOOD_DETAIL_PAGE, null, 8, null);
                                return;
                            }
                            return;
                        }
                        return;
                    case 1861829178:
                        if (str.equals("collapse_detail_list")) {
                            ECShopProductDetailBaseViewModel.this.W1(ptsComposer);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
    }

    /* renamed from: X1, reason: from getter */
    public final String getAdClickId() {
        return this.adClickId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MutableLiveData<List<ECBasePtsViewData>> Z1() {
        return this.adapterData;
    }

    public final LiveData<List<ECBasePtsViewData>> a2() {
        return this.adapterLiveDataPts;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b2, reason: from getter */
    public final CoroutineDispatcher getDefaultDispatcher() {
        return this.defaultDispatcher;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MutableLiveData<Integer> c2() {
        return this.pageErrorStatus;
    }

    public final LiveData<Integer> d2() {
        return this.pageErrorStatusLiveData;
    }

    public final LiveData<ECShopProductDetailInfo> e2() {
        return this.productDetailLiveData;
    }

    public final ECBasePtsViewData f2() {
        return new ECBasePtsViewData(null, "qshop_detail_invalid", "", gh0.d.f402041a.b("qshop_detail_invalid", ECPTSStyleManager.e("qshop_detail_invalid", wg0.a.a()), "", null), 1, null);
    }

    public final MutableLiveData<Map<String, String>> g2() {
        return this.reportStatus;
    }

    public final LiveData<Map<String, String>> h2() {
        return this.reportStatusLiveData;
    }

    public final LiveData<Integer> i2() {
        return this.scrollOffsetLiveData;
    }

    public final ECShopProductDetailData j2() {
        return (ECShopProductDetailData) this.shopProductDetailData.getValue();
    }

    /* renamed from: k2, reason: from getter */
    public final k getShowPageCostTime() {
        return this.showPageCostTime;
    }

    public final boolean l2(List<ECBasePtsViewData> list) {
        if (list.isEmpty()) {
            return false;
        }
        return Intrinsics.areEqual("shop_home_product_card", list.get(0).getPageName()) || Intrinsics.areEqual("qshop_detail_footer_cell", list.get(0).getPageName()) || Intrinsics.areEqual("apply_sample_recommend_card", list.get(0).getPageName()) || Intrinsics.areEqual("product_detail_saas_card", list.get(0).getPageName());
    }

    public Map<String, IPTSLiteEventListener> n2() {
        Map<String, IPTSLiteEventListener> emptyMap;
        emptyMap = MapsKt__MapsKt.emptyMap();
        return emptyMap;
    }

    public final void o2(int offset) {
        this._scrollOffset.postValue(Integer.valueOf(offset));
    }

    public ECShopProductDetailBaseViewModel(String str, boolean z16, FragmentManager fragmentManager, String str2) {
        Lazy lazy;
        this.bizType = str;
        this.isSelect = z16;
        this.fragmentManager = fragmentManager;
        this.adClickId = str2;
        this.defaultDispatcher = Dispatchers.getIO();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ECShopProductDetailData>() { // from class: com.tencent.ecommerce.biz.detail.viewmodel.shop.ECShopProductDetailBaseViewModel$shopProductDetailData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ECShopProductDetailData invoke() {
                String str3;
                str3 = ECShopProductDetailBaseViewModel.this.bizType;
                return new ECShopProductDetailData(str3);
            }
        });
        this.shopProductDetailData = lazy;
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
        this.pageErrorStatus = mutableLiveData;
        this.pageErrorStatusLiveData = mutableLiveData;
        MutableLiveData<List<ECBasePtsViewData>> mutableLiveData2 = new MutableLiveData<>();
        this.adapterData = mutableLiveData2;
        this.adapterLiveDataPts = mutableLiveData2;
        MutableLiveData<Integer> mutableLiveData3 = new MutableLiveData<>(0);
        this._scrollOffset = mutableLiveData3;
        this.scrollOffsetLiveData = mutableLiveData3;
        LiveData<ECShopProductDetailInfo> c16 = j2().c();
        this._productData = c16;
        this.productDetailLiveData = c16;
        MutableLiveData<Map<String, String>> mutableLiveData4 = new MutableLiveData<>();
        this.reportStatus = mutableLiveData4;
        this.reportStatusLiveData = mutableLiveData4;
        this.showPageCostTime = new k(ECShowPageCostTimeScene.SHOW_COST_TIME_SCENE_DETAIL);
        this.eventHandlerMap = new HashMap();
    }
}
