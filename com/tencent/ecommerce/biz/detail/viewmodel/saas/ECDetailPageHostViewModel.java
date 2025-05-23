package com.tencent.ecommerce.biz.detail.viewmodel.saas;

import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import bh0.d;
import ck0.Product;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.e;
import com.tencent.ecommerce.biz.common.c;
import com.tencent.ecommerce.biz.detail.repo.saas.ECDetailHostRepo;
import com.tencent.ecommerce.biz.detail.viewmodel.shop.ECShopProductCommentViewModel;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b6\u0018\u0000 s2\u00020\u0001:\u0001tBk\u0012\b\b\u0002\u0010I\u001a\u00020\u0006\u0012\b\b\u0002\u0010M\u001a\u00020\u0006\u0012\b\b\u0002\u0010Q\u001a\u00020\u0006\u0012\b\b\u0002\u0010U\u001a\u00020\u0006\u0012\b\b\u0002\u0010Y\u001a\u00020\u0006\u0012\b\b\u0002\u0010]\u001a\u00020\u0006\u0012\b\b\u0002\u0010d\u001a\u00020.\u0012\b\b\u0002\u0010h\u001a\u00020\u0006\u0012\b\b\u0002\u0010l\u001a\u00020\u0006\u0012\b\b\u0002\u0010p\u001a\u00020\u0006\u00a2\u0006\u0004\bq\u0010rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002J3\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR \u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u001e0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R#\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u001e0\u001d8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010 \u001a\u0004\b#\u0010$R$\u0010*\u001a\u0010\u0012\f\u0012\n '*\u0004\u0018\u00010\u00040\u00040&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d8\u0006\u00a2\u0006\f\n\u0004\b+\u0010 \u001a\u0004\b,\u0010$R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020.0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010 R\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020.0\u001d8\u0006\u00a2\u0006\f\n\u0004\b1\u0010 \u001a\u0004\b2\u0010$R\u001a\u00106\u001a\b\u0012\u0004\u0012\u0002040\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u0010 R\u001d\u00109\u001a\b\u0012\u0004\u0012\u0002040\u001d8\u0006\u00a2\u0006\f\n\u0004\b7\u0010 \u001a\u0004\b8\u0010$R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u0002040\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010 R\u001d\u0010>\u001a\b\u0012\u0004\u0012\u0002040\u001d8\u0006\u00a2\u0006\f\n\u0004\b<\u0010 \u001a\u0004\b=\u0010$R\u001d\u0010B\u001a\b\u0012\u0004\u0012\u00020?0\u001d8\u0006\u00a2\u0006\f\n\u0004\b@\u0010 \u001a\u0004\bA\u0010$R\"\u0010I\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010M\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010D\u001a\u0004\bK\u0010F\"\u0004\bL\u0010HR\"\u0010Q\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010D\u001a\u0004\bO\u0010F\"\u0004\bP\u0010HR\"\u0010U\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010D\u001a\u0004\bS\u0010F\"\u0004\bT\u0010HR\"\u0010Y\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010D\u001a\u0004\bW\u0010F\"\u0004\bX\u0010HR\"\u0010]\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bZ\u0010D\u001a\u0004\b[\u0010F\"\u0004\b\\\u0010HR\"\u0010d\u001a\u00020.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\"\u0010h\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\be\u0010D\u001a\u0004\bf\u0010F\"\u0004\bg\u0010HR\"\u0010l\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bi\u0010D\u001a\u0004\bj\u0010F\"\u0004\bk\u0010HR\"\u0010p\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bm\u0010D\u001a\u0004\bn\u0010F\"\u0004\bo\u0010H\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006u"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/viewmodel/saas/ECDetailPageHostViewModel;", "Lbh0/d;", "Lorg/json/JSONObject;", "data", "", "index", "", "k2", "offset", "", "l2", "requestParams", "i2", "service", "method", "requestExtraParams", "j2", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/ecommerce/base/ui/b;", "ptsViewData", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "N1", "destroy", "Lcom/tencent/ecommerce/biz/detail/repo/saas/ECDetailHostRepo;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "Z1", "()Lcom/tencent/ecommerce/biz/detail/repo/saas/ECDetailHostRepo;", "hostDetailRepo", "Landroidx/lifecycle/LiveData;", "", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "_adapterData", "D", "S1", "()Landroidx/lifecycle/LiveData;", "adapterLiveDataPts", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "E", "Landroidx/lifecycle/MutableLiveData;", "_scrollOffset", UserInfo.SEX_FEMALE, "e2", "scrollOffsetLiveData", "", "G", "_isAdded", "H", "g2", "isAddedLiveData", "", "I", "_activityStartTime", "J", "R1", "activityStartTime", "K", "_activityEndTime", "L", "Q1", "activityEndTime", "Lck0/c;", "M", "b2", "productLiveData", "N", "Ljava/lang/String;", "d2", "()Ljava/lang/String;", "setSaasType", "(Ljava/lang/String;)V", "saasType", "P", "c2", "setSaasProductId", "saasProductId", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "W1", "setCategoryId", "categoryId", BdhLogUtil.LogTag.Tag_Req, "getCategoryName", "setCategoryName", "categoryName", ExifInterface.LATITUDE_SOUTH, ICustomDataEditor.STRING_ARRAY_PARAM_2, "setMediaId", "mediaId", "T", "X1", "setGoodsType", "goodsType", "U", "Z", SemanticAttributes.DbSystemValues.H2, "()Z", "setNightMode", "(Z)V", MiniGamePAHippyBaseFragment.KEY_THEME, "V", "f2", "setSourceFrom", GetAdInfoRequest.SOURCE_FROM, "W", "T1", "setBannerId", "bannerId", "X", "U1", "setBannerName", "bannerName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Y", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECDetailPageHostViewModel extends d {

    /* renamed from: C, reason: from kotlin metadata */
    private final LiveData<List<ECBasePtsViewData>> _adapterData;

    /* renamed from: D, reason: from kotlin metadata */
    private final LiveData<List<ECBasePtsViewData>> adapterLiveDataPts;

    /* renamed from: E, reason: from kotlin metadata */
    private MutableLiveData<Integer> _scrollOffset;

    /* renamed from: F, reason: from kotlin metadata */
    private final LiveData<Integer> scrollOffsetLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    private final LiveData<Boolean> _isAdded;

    /* renamed from: H, reason: from kotlin metadata */
    private final LiveData<Boolean> isAddedLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    private final LiveData<Long> _activityStartTime;

    /* renamed from: J, reason: from kotlin metadata */
    private final LiveData<Long> activityStartTime;

    /* renamed from: K, reason: from kotlin metadata */
    private final LiveData<Long> _activityEndTime;

    /* renamed from: L, reason: from kotlin metadata */
    private final LiveData<Long> activityEndTime;

    /* renamed from: M, reason: from kotlin metadata */
    private final LiveData<Product> productLiveData;

    /* renamed from: N, reason: from kotlin metadata */
    private String saasType;

    /* renamed from: P, reason: from kotlin metadata */
    private String saasProductId;

    /* renamed from: Q, reason: from kotlin metadata */
    private String categoryId;

    /* renamed from: R, reason: from kotlin metadata */
    private String categoryName;

    /* renamed from: S, reason: from kotlin metadata */
    private String mediaId;

    /* renamed from: T, reason: from kotlin metadata */
    private String goodsType;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean isNightMode;

    /* renamed from: V, reason: from kotlin metadata */
    private String sourceFrom;

    /* renamed from: W, reason: from kotlin metadata */
    private String bannerId;

    /* renamed from: X, reason: from kotlin metadata */
    private String bannerName;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Lazy hostDetailRepo;

    public ECDetailPageHostViewModel() {
        this(null, null, null, null, null, null, false, null, null, null, 1023, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECDetailHostRepo Z1() {
        return (ECDetailHostRepo) this.hostDetailRepo.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String k2(JSONObject data, int index) {
        JSONArray jSONArray;
        JSONArray optJSONArray;
        JSONObject optJSONObject = data.optJSONObject("honor_king_product");
        if (optJSONObject == null || (jSONArray = optJSONObject.optJSONArray("skills")) == null) {
            jSONArray = new JSONArray();
        }
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject2 = jSONArray.optJSONObject(i3);
            if (optJSONObject2 != null) {
                optJSONObject2.put("selected", false);
            }
        }
        JSONObject optJSONObject3 = jSONArray.optJSONObject(index);
        if (optJSONObject3 != null) {
            optJSONObject3.put("selected", true);
        }
        data.put("skill_img_url", (optJSONObject3 == null || (optJSONArray = optJSONObject3.optJSONArray("main_pics")) == null) ? null : optJSONArray.optString(0));
        cg0.a.b("ECDetailPageHostViewModel", String.valueOf(data));
        return data.toString();
    }

    @Override // bh0.d
    public IPTSLiteEventListener N1(ECBasePtsViewData ptsViewData) {
        return new b(ptsViewData);
    }

    public final LiveData<Long> Q1() {
        return this.activityEndTime;
    }

    public final LiveData<Long> R1() {
        return this.activityStartTime;
    }

    public final LiveData<List<ECBasePtsViewData>> S1() {
        return this.adapterLiveDataPts;
    }

    /* renamed from: T1, reason: from getter */
    public final String getBannerId() {
        return this.bannerId;
    }

    /* renamed from: U1, reason: from getter */
    public final String getBannerName() {
        return this.bannerName;
    }

    /* renamed from: W1, reason: from getter */
    public final String getCategoryId() {
        return this.categoryId;
    }

    /* renamed from: X1, reason: from getter */
    public final String getGoodsType() {
        return this.goodsType;
    }

    /* renamed from: a2, reason: from getter */
    public final String getMediaId() {
        return this.mediaId;
    }

    public final LiveData<Product> b2() {
        return this.productLiveData;
    }

    /* renamed from: c2, reason: from getter */
    public final String getSaasProductId() {
        return this.saasProductId;
    }

    /* renamed from: d2, reason: from getter */
    public final String getSaasType() {
        return this.saasType;
    }

    public void destroy() {
        final ArrayList arrayList = new ArrayList();
        List<ECBasePtsViewData> value = this._adapterData.getValue();
        if (value != null) {
            arrayList.addAll(value);
        }
        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.detail.viewmodel.saas.ECDetailPageHostViewModel$destroy$2
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

    public final LiveData<Integer> e2() {
        return this.scrollOffsetLiveData;
    }

    /* renamed from: f2, reason: from getter */
    public final String getSourceFrom() {
        return this.sourceFrom;
    }

    public final LiveData<Boolean> g2() {
        return this.isAddedLiveData;
    }

    public final String getCategoryName() {
        return this.categoryName;
    }

    /* renamed from: h2, reason: from getter */
    public final boolean getIsNightMode() {
        return this.isNightMode;
    }

    public final void i2(JSONObject requestParams) {
        Z1().o(requestParams);
    }

    public Object j2(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object r16 = Z1().r(str, str2, jSONObject, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return r16 == coroutine_suspended ? r16 : Unit.INSTANCE;
    }

    public final void l2(int offset) {
        this._scrollOffset.postValue(Integer.valueOf(offset));
    }

    public /* synthetic */ ECDetailPageHostViewModel(String str, String str2, String str3, String str4, String str5, String str6, boolean z16, String str7, String str8, String str9, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? "" : str5, (i3 & 32) != 0 ? "" : str6, (i3 & 64) != 0 ? false : z16, (i3 & 128) != 0 ? "" : str7, (i3 & 256) != 0 ? "" : str8, (i3 & 512) == 0 ? str9 : "");
    }

    public ECDetailPageHostViewModel(String str, String str2, String str3, String str4, String str5, String str6, boolean z16, String str7, String str8, String str9) {
        Lazy lazy;
        this.saasType = str;
        this.saasProductId = str2;
        this.categoryId = str3;
        this.categoryName = str4;
        this.mediaId = str5;
        this.goodsType = str6;
        this.isNightMode = z16;
        this.sourceFrom = str7;
        this.bannerId = str8;
        this.bannerName = str9;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ECDetailHostRepo>() { // from class: com.tencent.ecommerce.biz.detail.viewmodel.saas.ECDetailPageHostViewModel$hostDetailRepo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ECDetailHostRepo invoke() {
                return new ECDetailHostRepo(ECDetailPageHostViewModel.this.getSaasProductId(), ECDetailPageHostViewModel.this.getSaasType(), ECDetailPageHostViewModel.this.getMediaId(), ECDetailPageHostViewModel.this.getCategoryId(), ECDetailPageHostViewModel.this.getCategoryName(), ECDetailPageHostViewModel.this.getGoodsType(), ECDetailPageHostViewModel.this.getIsNightMode(), ECDetailPageHostViewModel.this.getSourceFrom(), ECDetailPageHostViewModel.this.getBannerId(), ECDetailPageHostViewModel.this.getBannerName());
            }
        });
        this.hostDetailRepo = lazy;
        LiveData<List<ECBasePtsViewData>> i3 = Z1().i();
        this._adapterData = i3;
        this.adapterLiveDataPts = i3;
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>(0);
        this._scrollOffset = mutableLiveData;
        this.scrollOffsetLiveData = mutableLiveData;
        LiveData<Boolean> n3 = Z1().n();
        this._isAdded = n3;
        this.isAddedLiveData = n3;
        LiveData<Long> h16 = Z1().h();
        this._activityStartTime = h16;
        this.activityStartTime = h16;
        LiveData<Long> g16 = Z1().g();
        this._activityEndTime = g16;
        this.activityEndTime = g16;
        this.productLiveData = Z1().l();
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JN\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/biz/detail/viewmodel/saas/ECDetailPageHostViewModel$b", "Lcom/tencent/ecommerce/base/ui/e;", "", IECDtReport.ACTION_IDENTIFIER, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "dataMap", "Landroid/view/View;", "view", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "onTapEventTriggered", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends e {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ECBasePtsViewData f102472b;

        b(ECBasePtsViewData eCBasePtsViewData) {
            this.f102472b = eCBasePtsViewData;
        }

        @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
        public void onTapEventTriggered(String identifier, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
            String str;
            String title;
            String saasProductId;
            String str2;
            if (dataMap == null || (str = dataMap.get("eventType")) == null) {
                return;
            }
            cg0.a.b("ECDetailPageHostViewModel", "[onTapEventTriggered] " + str);
            switch (str.hashCode()) {
                case -931150290:
                    if (str.equals("allInOneJump")) {
                        String str3 = dataMap.get(WadlProxyConsts.KEY_JUMP_URL);
                        if (str3 == null) {
                            str3 = "";
                        }
                        if (identifier != null && identifier.equals("detail-url")) {
                            com.tencent.ecommerce.biz.detail.utils.d dVar = com.tencent.ecommerce.biz.detail.utils.d.f102466a;
                            String str4 = ECDetailPageHostViewModel.this.Z1().mediaId;
                            String str5 = ECDetailPageHostViewModel.this.Z1().saasType;
                            Product value = ECDetailPageHostViewModel.this.Z1().l().getValue();
                            String str6 = (value == null || (saasProductId = value.getSaasProductId()) == null) ? "" : saasProductId;
                            Product value2 = ECDetailPageHostViewModel.this.Z1().l().getValue();
                            String str7 = (value2 == null || (title = value2.getTitle()) == null) ? "" : title;
                            String str8 = ECDetailPageHostViewModel.this.Z1().categoryId;
                            Product value3 = ECDetailPageHostViewModel.this.Z1().l().getValue();
                            long commission = value3 != null ? value3.getCommission() : 0L;
                            Product value4 = ECDetailPageHostViewModel.this.Z1().l().getValue();
                            long price = value4 != null ? value4.getPrice() : 0L;
                            Product value5 = ECDetailPageHostViewModel.this.Z1().l().getValue();
                            dVar.h(str4, str5, str6, str7, str8, commission, price, value5 != null ? value5.getSales() : 0L);
                        }
                        cg0.a.b("ECDetailPageHostViewModel", "[onTapEventTriggered] type: " + str + " jumpUrl:" + str3);
                        if (TextUtils.isEmpty(str3)) {
                            return;
                        }
                        ECScheme.g(str3, null, 2, null);
                        return;
                    }
                    return;
                case -594560141:
                    if (str.equals("jumpScheme")) {
                        String str9 = dataMap.get(WadlProxyConsts.KEY_JUMP_URL);
                        String str10 = str9 != null ? str9 : "";
                        cg0.a.b("ECDetailPageHostViewModel", "[onTapEventTriggered] type: " + str + " jumpUrl:" + str10);
                        if (TextUtils.isEmpty(str10)) {
                            return;
                        }
                        ECScheme.g(str10, null, 2, null);
                        c.f101553a.d();
                        return;
                    }
                    return;
                case -299328916:
                    if (str.equals("skillNameClick")) {
                        int parseInt = identifier != null ? Integer.parseInt(identifier) : 0;
                        cg0.a.b("ECDetailPageHostViewModel", "[onTapEventTriggered] " + parseInt);
                        ECBasePtsViewData eCBasePtsViewData = this.f102472b;
                        String proteusData = eCBasePtsViewData != null ? eCBasePtsViewData.getProteusData() : null;
                        if (proteusData != null) {
                            String k26 = ECDetailPageHostViewModel.this.k2(new JSONObject(proteusData), parseInt);
                            if (ptsComposer != null) {
                                ptsComposer.setData(k26);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 433923123:
                    if (!str.equals("showPhotoBrowser") || (str2 = dataMap.get("photosData")) == null) {
                        return;
                    }
                    lg0.a.b(lg0.a.f414523b, ECShopProductCommentViewModel.INSTANCE.a(str2), identifier != null ? Integer.parseInt(identifier) : 0, null, 4, null);
                    return;
                default:
                    return;
            }
        }
    }
}
