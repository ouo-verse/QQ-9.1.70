package com.tencent.ecommerce.biz.detail.viewmodel.shop;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import bh0.d;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.biz.detail.repo.shop.data.ECShopProductDetailBuyFloatPageInfo;
import com.tencent.ecommerce.biz.detail.repo.shop.data.ECShopProductDetailSkuInfoData;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 P2\u00020\u0001:\u0001QB\u001f\u0012\u0006\u0010C\u001a\u00020@\u0012\u0006\u0010G\u001a\u00020D\u0012\u0006\u0010M\u001a\u00020H\u00a2\u0006\u0004\bN\u0010OJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0006\u0010\n\u001a\u00020\u0004J\b\u0010\u000b\u001a\u00020\u0004H\u0016R\u001b\u0010\u0011\u001a\u00020\f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R#\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00130\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0015R\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\u001bR\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010\u0015R\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b'\u0010\u0019\u001a\u0004\b(\u0010\u001bR\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010\u0015R\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b,\u0010\u0019\u001a\u0004\b-\u0010\u001bR\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020/0\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010\u0015R\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020/0\u00178\u0006\u00a2\u0006\f\n\u0004\b2\u0010\u0019\u001a\u0004\b3\u0010\u001bR$\u0010<\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010'R\u0014\u0010C\u001a\u00020@8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010G\u001a\u00020D8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0017\u0010M\u001a\u00020H8\u0006\u00a2\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\u00a8\u0006R"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopDetailSkuInfoViewModel;", "Lbh0/d;", "", "e2", "", "i2", "Lcom/tencent/ecommerce/base/ui/b;", "ptsViewData", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "N1", SemanticAttributes.DbSystemValues.H2, "destroy", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/ECShopProductDetailSkuInfoData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "c2", "()Lcom/tencent/ecommerce/biz/detail/repo/shop/data/ECShopProductDetailSkuInfoData;", "skuInfoData", "Landroidx/lifecycle/MutableLiveData;", "", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_adapterPtsData", "Landroidx/lifecycle/LiveData;", "D", "Landroidx/lifecycle/LiveData;", "X1", "()Landroidx/lifecycle/LiveData;", "adapterPtsLiveData", "E", "_isSoldOutStatus", UserInfo.SEX_FEMALE, "g2", "isSoldOutStatusData", "G", "Z", "_isActiveSoldOutStatus", "H", "_isDiscountActiveSoldOutStatus", "I", "f2", "isDiscountActiveSoldOutStatus", "J", "_closePageData", "K", "Z1", "closePageLiveData", "Lorg/json/JSONObject;", "L", "_productDetailData", "M", "b2", "productDetailDataLiveData", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/b;", "N", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/b;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Lcom/tencent/ecommerce/biz/detail/repo/shop/data/b;", "j2", "(Lcom/tencent/ecommerce/biz/detail/repo/shop/data/b;)V", "floatSkuInfoData", "", "P", "inputValue", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/String;", "spuId", "Landroid/os/Bundle;", BdhLogUtil.LogTag.Tag_Req, "Landroid/os/Bundle;", "bundle", "Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/SkuInfoType;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/SkuInfoType;", "d2", "()Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/SkuInfoType;", "type", "<init>", "(Ljava/lang/String;Landroid/os/Bundle;Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/SkuInfoType;)V", "T", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopDetailSkuInfoViewModel extends d {

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<List<ECBasePtsViewData>> _adapterPtsData;

    /* renamed from: D, reason: from kotlin metadata */
    private final LiveData<List<ECBasePtsViewData>> adapterPtsLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _isSoldOutStatus;

    /* renamed from: F, reason: from kotlin metadata */
    private final LiveData<Boolean> isSoldOutStatusData;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean _isActiveSoldOutStatus;

    /* renamed from: H, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _isDiscountActiveSoldOutStatus;

    /* renamed from: I, reason: from kotlin metadata */
    private final LiveData<Boolean> isDiscountActiveSoldOutStatus;

    /* renamed from: J, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _closePageData;

    /* renamed from: K, reason: from kotlin metadata */
    private final LiveData<Boolean> closePageLiveData;

    /* renamed from: L, reason: from kotlin metadata */
    private final MutableLiveData<JSONObject> _productDetailData;

    /* renamed from: M, reason: from kotlin metadata */
    private final LiveData<JSONObject> productDetailDataLiveData;

    /* renamed from: N, reason: from kotlin metadata */
    private ECShopProductDetailBuyFloatPageInfo floatSkuInfoData;

    /* renamed from: P, reason: from kotlin metadata */
    private int inputValue;

    /* renamed from: Q, reason: from kotlin metadata */
    public final String spuId;

    /* renamed from: R, reason: from kotlin metadata */
    public final Bundle bundle;

    /* renamed from: S, reason: from kotlin metadata */
    private final SkuInfoType type;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Lazy skuInfoData;

    public ECShopDetailSkuInfoViewModel(String str, Bundle bundle, SkuInfoType skuInfoType) {
        Lazy lazy;
        this.spuId = str;
        this.bundle = bundle;
        this.type = skuInfoType;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ECShopProductDetailSkuInfoData>() { // from class: com.tencent.ecommerce.biz.detail.viewmodel.shop.ECShopDetailSkuInfoViewModel$skuInfoData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ECShopProductDetailSkuInfoData invoke() {
                String string = ECShopDetailSkuInfoViewModel.this.bundle.getString("active_id", "");
                ECShopDetailSkuInfoViewModel eCShopDetailSkuInfoViewModel = ECShopDetailSkuInfoViewModel.this;
                return new ECShopProductDetailSkuInfoData(eCShopDetailSkuInfoViewModel.spuId, string, eCShopDetailSkuInfoViewModel.getType());
            }
        });
        this.skuInfoData = lazy;
        MutableLiveData<List<ECBasePtsViewData>> mutableLiveData = new MutableLiveData<>();
        this._adapterPtsData = mutableLiveData;
        this.adapterPtsLiveData = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this._isSoldOutStatus = mutableLiveData2;
        this.isSoldOutStatusData = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>();
        this._isDiscountActiveSoldOutStatus = mutableLiveData3;
        this.isDiscountActiveSoldOutStatus = mutableLiveData3;
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>();
        this._closePageData = mutableLiveData4;
        this.closePageLiveData = mutableLiveData4;
        MutableLiveData<JSONObject> mutableLiveData5 = new MutableLiveData<>();
        this._productDetailData = mutableLiveData5;
        this.productDetailDataLiveData = mutableLiveData5;
    }

    @Override // bh0.d
    public IPTSLiteEventListener N1(ECBasePtsViewData ptsViewData) {
        return new ECShopDetailSkuInfoViewModel$getPtsLiteEventListener$1(this);
    }

    public final LiveData<List<ECBasePtsViewData>> X1() {
        return this.adapterPtsLiveData;
    }

    public final LiveData<Boolean> Z1() {
        return this.closePageLiveData;
    }

    /* renamed from: a2, reason: from getter */
    public final ECShopProductDetailBuyFloatPageInfo getFloatSkuInfoData() {
        return this.floatSkuInfoData;
    }

    public final LiveData<JSONObject> b2() {
        return this.productDetailDataLiveData;
    }

    public final ECShopProductDetailSkuInfoData c2() {
        return (ECShopProductDetailSkuInfoData) this.skuInfoData.getValue();
    }

    /* renamed from: d2, reason: from getter */
    public final SkuInfoType getType() {
        return this.type;
    }

    public void destroy() {
        CoroutineScopeKt.cancel$default(ViewModelKt.getViewModelScope(this), null, 1, null);
        final ArrayList arrayList = new ArrayList();
        List<ECBasePtsViewData> value = this._adapterPtsData.getValue();
        if (value != null) {
            arrayList.addAll(value);
        }
        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.detail.viewmodel.shop.ECShopDetailSkuInfoViewModel$destroy$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    PTSComposer ptsComposer = ((ECBasePtsViewData) it.next()).getPtsComposer();
                    if (ptsComposer != null) {
                        ptsComposer.destroy();
                    }
                }
            }
        });
    }

    /* renamed from: e2, reason: from getter */
    public final boolean get_isActiveSoldOutStatus() {
        return this._isActiveSoldOutStatus;
    }

    public final LiveData<Boolean> f2() {
        return this.isDiscountActiveSoldOutStatus;
    }

    public final LiveData<Boolean> g2() {
        return this.isSoldOutStatusData;
    }

    public final void h2() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECShopDetailSkuInfoViewModel$onKeyboardHide$1(this, null), 3, null);
    }

    public final void i2() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECShopDetailSkuInfoViewModel$requestPtsData$1(this, null), 3, null);
    }

    public final void j2(ECShopProductDetailBuyFloatPageInfo eCShopProductDetailBuyFloatPageInfo) {
        this.floatSkuInfoData = eCShopProductDetailBuyFloatPageInfo;
    }
}
