package com.tencent.ecommerce.biz.detail.viewmodel.saas;

import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import bh0.d;
import bk0.ECProductArkShareRequestParams;
import ck0.Product;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.ecommerce.base.share.api.ECQQShareData;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.e;
import com.tencent.ecommerce.biz.common.c;
import com.tencent.ecommerce.biz.detail.repo.saas.ECDetailCustomRepo;
import com.tencent.ecommerce.biz.detail.viewmodel.shop.ECShopProductCommentViewModel;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.biz.util.ECPtsConstants$ECProductDetailClickArea;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b*\u0018\u0000 t2\u00020\u0001:\u0001uBM\u0012\b\b\u0002\u0010V\u001a\u00020\t\u0012\b\b\u0002\u0010Z\u001a\u00020\t\u0012\b\b\u0002\u0010^\u001a\u00020\t\u0012\b\b\u0002\u0010b\u001a\u00020\t\u0012\b\b\u0002\u0010f\u001a\u00020\t\u0012\b\b\u0002\u0010m\u001a\u00020\u0016\u0012\b\b\u0002\u0010q\u001a\u00020\t\u00a2\u0006\u0004\br\u0010sJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J3\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\u0006\u0010\u0014\u001a\u00020\u0004J\u0016\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016J&\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0002R\u001b\u0010\"\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R \u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0$0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R#\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0$0#8\u0006\u00a2\u0006\f\n\u0004\b(\u0010&\u001a\u0004\b)\u0010*R$\u00100\u001a\u0010\u0012\f\u0012\n -*\u0004\u0018\u00010\u00020\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020\u00020#8\u0006\u00a2\u0006\f\n\u0004\b1\u0010&\u001a\u0004\b2\u0010*R\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020\t0#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010&R\u001d\u00108\u001a\b\u0012\u0004\u0012\u00020\t0#8\u0006\u00a2\u0006\f\n\u0004\b6\u0010&\u001a\u0004\b7\u0010*R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00060#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010&R\u001d\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00060#8\u0006\u00a2\u0006\f\n\u0004\b;\u0010&\u001a\u0004\b<\u0010*R\u001d\u0010A\u001a\b\u0012\u0004\u0012\u00020>0#8\u0006\u00a2\u0006\f\n\u0004\b?\u0010&\u001a\u0004\b@\u0010*R\u001c\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010B0,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010/R\u001f\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010B0#8\u0006\u00a2\u0006\f\n\u0004\bE\u0010&\u001a\u0004\bF\u0010*R\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u001c\u0010O\u001a\b\u0012\u0004\u0012\u00020\t0L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\"\u0010V\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010Z\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010Q\u001a\u0004\bX\u0010S\"\u0004\bY\u0010UR\"\u0010^\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b[\u0010Q\u001a\u0004\b\\\u0010S\"\u0004\b]\u0010UR\"\u0010b\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b_\u0010Q\u001a\u0004\b`\u0010S\"\u0004\ba\u0010UR\"\u0010f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bc\u0010Q\u001a\u0004\bd\u0010S\"\u0004\be\u0010UR\"\u0010m\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\"\u0010q\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bn\u0010Q\u001a\u0004\bo\u0010S\"\u0004\bp\u0010U\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006v"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/viewmodel/saas/ECDetailPageCustomViewModel;", "Lbh0/d;", "", "offset", "", "k2", "Lorg/json/JSONObject;", "requestParams", "g2", "", "service", "method", "requestExtraParams", SemanticAttributes.DbSystemValues.H2, "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/ecommerce/base/ui/b;", "ptsViewData", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "N1", "destroy", "j2", "shareAction", "", "isSucceed", "R1", "shareToFriendUin", "shareToFriendUinName", "shareToFriendUinType", "i2", "Lcom/tencent/ecommerce/biz/detail/repo/saas/ECDetailCustomRepo;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "U1", "()Lcom/tencent/ecommerce/biz/detail/repo/saas/ECDetailCustomRepo;", "customDetailRepo", "Landroidx/lifecycle/LiveData;", "", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "_adapterData", "D", "S1", "()Landroidx/lifecycle/LiveData;", "adapterLiveDataPts", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "E", "Landroidx/lifecycle/MutableLiveData;", "_scrollOffset", UserInfo.SEX_FEMALE, "d2", "scrollOffsetLiveData", "G", "_buyItemUrl", "H", "T1", "buyItemUrlData", "I", "_sourceData", "J", "e2", "sourceLiveData", "Lck0/c;", "K", ICustomDataEditor.STRING_ARRAY_PARAM_2, "productLiveData", "Lcom/tencent/ecommerce/base/share/api/c;", "L", "_qqShareData", "M", "b2", "qqShareData", "Lcom/tencent/ecommerce/biz/detail/a;", "N", "Lcom/tencent/ecommerce/biz/detail/a;", "shareSpan", "", "P", "Ljava/util/Set;", "mainPicExpReportSet", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/String;", "getCategoryId", "()Ljava/lang/String;", "setCategoryId", "(Ljava/lang/String;)V", "categoryId", BdhLogUtil.LogTag.Tag_Req, "getCategoryName", "setCategoryName", "categoryName", ExifInterface.LATITUDE_SOUTH, "X1", "setMediaId", "mediaId", "T", "Z1", "setMediaProductID", "mediaProductID", "U", "W1", "setGoodsType", "goodsType", "V", "Z", "f2", "()Z", "setNightMode", "(Z)V", MiniGamePAHippyBaseFragment.KEY_THEME, "W", "c2", "setSaasId", "saasId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "X", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECDetailPageCustomViewModel extends d {

    /* renamed from: C, reason: from kotlin metadata */
    private final LiveData<List<ECBasePtsViewData>> _adapterData;

    /* renamed from: D, reason: from kotlin metadata */
    private final LiveData<List<ECBasePtsViewData>> adapterLiveDataPts;

    /* renamed from: E, reason: from kotlin metadata */
    private MutableLiveData<Integer> _scrollOffset;

    /* renamed from: F, reason: from kotlin metadata */
    private final LiveData<Integer> scrollOffsetLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    private LiveData<String> _buyItemUrl;

    /* renamed from: H, reason: from kotlin metadata */
    private final LiveData<String> buyItemUrlData;

    /* renamed from: I, reason: from kotlin metadata */
    private final LiveData<JSONObject> _sourceData;

    /* renamed from: J, reason: from kotlin metadata */
    private final LiveData<JSONObject> sourceLiveData;

    /* renamed from: K, reason: from kotlin metadata */
    private final LiveData<Product> productLiveData;

    /* renamed from: L, reason: from kotlin metadata */
    private final MutableLiveData<ECQQShareData> _qqShareData;

    /* renamed from: M, reason: from kotlin metadata */
    private final LiveData<ECQQShareData> qqShareData;

    /* renamed from: N, reason: from kotlin metadata */
    private com.tencent.ecommerce.biz.detail.a shareSpan;

    /* renamed from: P, reason: from kotlin metadata */
    private Set<String> mainPicExpReportSet;

    /* renamed from: Q, reason: from kotlin metadata */
    private String categoryId;

    /* renamed from: R, reason: from kotlin metadata */
    private String categoryName;

    /* renamed from: S, reason: from kotlin metadata */
    private String mediaId;

    /* renamed from: T, reason: from kotlin metadata */
    private String mediaProductID;

    /* renamed from: U, reason: from kotlin metadata */
    private String goodsType;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean isNightMode;

    /* renamed from: W, reason: from kotlin metadata */
    private String saasId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Lazy customDetailRepo;

    public ECDetailPageCustomViewModel() {
        this(null, null, null, null, null, false, null, 127, null);
    }

    private final ECDetailCustomRepo U1() {
        return (ECDetailCustomRepo) this.customDetailRepo.getValue();
    }

    @Override // bh0.d
    public IPTSLiteEventListener N1(ECBasePtsViewData ptsViewData) {
        return new b();
    }

    public final void R1(int shareAction, boolean isSucceed) {
        com.tencent.ecommerce.biz.detail.a aVar = this.shareSpan;
        if (aVar != null) {
            aVar.c(shareAction, this.mediaProductID, isSucceed);
        }
        this.shareSpan = null;
    }

    public final LiveData<List<ECBasePtsViewData>> S1() {
        return this.adapterLiveDataPts;
    }

    public final LiveData<String> T1() {
        return this.buyItemUrlData;
    }

    /* renamed from: W1, reason: from getter */
    public final String getGoodsType() {
        return this.goodsType;
    }

    /* renamed from: X1, reason: from getter */
    public final String getMediaId() {
        return this.mediaId;
    }

    /* renamed from: Z1, reason: from getter */
    public final String getMediaProductID() {
        return this.mediaProductID;
    }

    public final LiveData<Product> a2() {
        return this.productLiveData;
    }

    public final LiveData<ECQQShareData> b2() {
        return this.qqShareData;
    }

    /* renamed from: c2, reason: from getter */
    public final String getSaasId() {
        return this.saasId;
    }

    public final LiveData<Integer> d2() {
        return this.scrollOffsetLiveData;
    }

    public void destroy() {
        final ArrayList arrayList = new ArrayList();
        List<ECBasePtsViewData> value = this._adapterData.getValue();
        if (value != null) {
            arrayList.addAll(value);
        }
        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.detail.viewmodel.saas.ECDetailPageCustomViewModel$destroy$2
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

    public final LiveData<JSONObject> e2() {
        return this.sourceLiveData;
    }

    /* renamed from: f2, reason: from getter */
    public final boolean getIsNightMode() {
        return this.isNightMode;
    }

    public final void g2(JSONObject requestParams) {
        U1().o(requestParams);
    }

    public final String getCategoryName() {
        return this.categoryName;
    }

    public Object h2(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object s16 = U1().s(str, str2, jSONObject, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return s16 == coroutine_suspended ? s16 : Unit.INSTANCE;
    }

    public final void i2(final int shareAction, final String shareToFriendUin, final String shareToFriendUinName, final int shareToFriendUinType) {
        bk0.b.f28528a.a(new ECProductArkShareRequestParams(this.mediaProductID, this.mediaId, "com.tencent.eccommerce", "eccommerce", "0.0.0.11"), new Function1<String, Unit>() { // from class: com.tencent.ecommerce.biz.detail.viewmodel.saas.ECDetailPageCustomViewModel$requestShareArkData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                MutableLiveData mutableLiveData;
                com.tencent.ecommerce.biz.detail.a aVar;
                MutableLiveData mutableLiveData2;
                com.tencent.ecommerce.biz.detail.a aVar2;
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    mutableLiveData2 = ECDetailPageCustomViewModel.this._qqShareData;
                    mutableLiveData2.postValue(new ECQQShareData(shareToFriendUin, shareToFriendUinName, shareToFriendUinType, jSONObject, null, null, 48, null));
                    aVar2 = ECDetailPageCustomViewModel.this.shareSpan;
                    if (aVar2 != null) {
                        aVar2.b(shareAction, ECDetailPageCustomViewModel.this.getMediaProductID(), ECDetailPageCustomViewModel.this.getMediaId(), true);
                    }
                } catch (JSONException unused) {
                    mutableLiveData = ECDetailPageCustomViewModel.this._qqShareData;
                    mutableLiveData.postValue(null);
                    aVar = ECDetailPageCustomViewModel.this.shareSpan;
                    if (aVar != null) {
                        aVar.b(shareAction, ECDetailPageCustomViewModel.this.getMediaProductID(), ECDetailPageCustomViewModel.this.getMediaId(), false);
                    }
                }
            }
        });
    }

    public final void j2() {
        com.tencent.ecommerce.biz.detail.a aVar = new com.tencent.ecommerce.biz.detail.a(com.tencent.ecommerce.biz.detail.a.INSTANCE.a());
        aVar.d();
        Unit unit = Unit.INSTANCE;
        this.shareSpan = aVar;
    }

    public final void k2(int offset) {
        this._scrollOffset.postValue(Integer.valueOf(offset));
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JN\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016JN\u0010\r\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016JN\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/ecommerce/biz/detail/viewmodel/saas/ECDetailPageCustomViewModel$b", "Lcom/tencent/ecommerce/base/ui/e;", "", IECDtReport.ACTION_IDENTIFIER, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "dataMap", "Landroid/view/View;", "view", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "onTapEventTriggered", "onSwiperItemExposureTriggered", "onSwiperDragTriggered", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends e {
        b() {
        }

        @Override // com.tencent.ecommerce.base.ui.e, com.tencent.pts.core.lite.IPTSLiteEventListener
        public void onSwiperDragTriggered(String identifier, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
            String str;
            Integer intOrNull;
            String title;
            String saasProductId;
            if (dataMap == null || (str = dataMap.get("swiperDragEventType")) == null || str.hashCode() != -1464214043 || !str.equals("mainPicDrag")) {
                return;
            }
            com.tencent.ecommerce.biz.detail.utils.d dVar = com.tencent.ecommerce.biz.detail.utils.d.f102466a;
            String valueOf = String.valueOf(ug0.b.f438933d.e());
            long currentAccount = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getAccountManager().getCurrentAccount();
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(ECDetailPageCustomViewModel.this.getGoodsType());
            int intValue = intOrNull != null ? intOrNull.intValue() : 0;
            String saasId = ECDetailPageCustomViewModel.this.getSaasId();
            Product value = ECDetailPageCustomViewModel.this.a2().getValue();
            String str2 = (value == null || (saasProductId = value.getSaasProductId()) == null) ? "" : saasProductId;
            Product value2 = ECDetailPageCustomViewModel.this.a2().getValue();
            dVar.l(valueOf, currentAccount, intValue, saasId, str2, (value2 == null || (title = value2.getTitle()) == null) ? "" : title, 2);
        }

        @Override // com.tencent.ecommerce.base.ui.e, com.tencent.pts.core.lite.IPTSLiteEventListener
        public void onSwiperItemExposureTriggered(String identifier, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
            String str;
            Integer intOrNull;
            String title;
            String saasProductId;
            if (dataMap == null || (str = dataMap.get("swiperExpEventType")) == null) {
                return;
            }
            String str2 = dataMap.get("expNum");
            if (str2 == null) {
                str2 = "";
            }
            if (ECDetailPageCustomViewModel.this.mainPicExpReportSet.contains(str2)) {
                return;
            }
            ECDetailPageCustomViewModel.this.mainPicExpReportSet.add(str2);
            if (str.hashCode() == 368410444 && str.equals("mainPicExp")) {
                com.tencent.ecommerce.biz.detail.utils.d dVar = com.tencent.ecommerce.biz.detail.utils.d.f102466a;
                String valueOf = String.valueOf(ug0.b.f438933d.e());
                long currentAccount = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getAccountManager().getCurrentAccount();
                intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(ECDetailPageCustomViewModel.this.getGoodsType());
                int intValue = intOrNull != null ? intOrNull.intValue() : 0;
                String saasId = ECDetailPageCustomViewModel.this.getSaasId();
                Product value = ECDetailPageCustomViewModel.this.a2().getValue();
                String str3 = (value == null || (saasProductId = value.getSaasProductId()) == null) ? "" : saasProductId;
                Product value2 = ECDetailPageCustomViewModel.this.a2().getValue();
                dVar.k(valueOf, currentAccount, intValue, saasId, str3, (value2 == null || (title = value2.getTitle()) == null) ? "" : title, 2);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0068, code lost:
        
            r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r1);
         */
        @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onTapEventTriggered(String identifier, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
            String str;
            String str2;
            String str3;
            Integer intOrNull;
            String title;
            String saasProductId;
            Integer intOrNull2;
            if (dataMap == null || (str = dataMap.get("eventType")) == null) {
                return;
            }
            cg0.a.b("ECDetailPageCustomViewModel", "[onTapEventTriggered] " + str);
            switch (str.hashCode()) {
                case -931150290:
                    if (str.equals("allInOneJump")) {
                        String str4 = dataMap.get(WadlProxyConsts.KEY_JUMP_URL);
                        str2 = str4 != null ? str4 : "";
                        cg0.a.b("ECDetailPageCustomViewModel", "[onTapEventTriggered] type: " + str + " jumpUrl:" + str2);
                        if (TextUtils.isEmpty(str2)) {
                            return;
                        }
                        ECScheme.g(str2, null, 2, null);
                        return;
                    }
                    return;
                case -594560141:
                    if (str.equals("jumpScheme")) {
                        String str5 = dataMap.get(WadlProxyConsts.KEY_JUMP_URL);
                        str2 = str5 != null ? str5 : "";
                        cg0.a.b("ECDetailPageCustomViewModel", "[onTapEventTriggered] type: " + str + " jumpUrl:" + str2);
                        if (TextUtils.isEmpty(str2)) {
                            return;
                        }
                        ECScheme.g(str2, null, 2, null);
                        c.f101553a.d();
                        return;
                    }
                    return;
                case 433923123:
                    if (!str.equals("showPhotoBrowser") || (str3 = dataMap.get("photosData")) == null) {
                        return;
                    }
                    lg0.a.b(lg0.a.f414523b, ECShopProductCommentViewModel.INSTANCE.a(str3), identifier != null ? Integer.parseInt(identifier) : 0, null, 4, null);
                    return;
                case 1265976857:
                    if (str.equals("jumpGuestSaasPage")) {
                        String value = ECDetailPageCustomViewModel.this.T1().getValue();
                        if (value == null) {
                            value = "";
                        }
                        ECScheme.g(value, null, 2, null);
                        String str6 = dataMap.get("eventArea");
                        int intValue = (str6 == null || intOrNull2 == null) ? 0 : intOrNull2.intValue();
                        int i3 = intValue == ECPtsConstants$ECProductDetailClickArea.CLICK_AREA_MAIN_PIC.ordinal() ? 1 : 2;
                        com.tencent.ecommerce.biz.detail.utils.d dVar = com.tencent.ecommerce.biz.detail.utils.d.f102466a;
                        String valueOf = String.valueOf(ug0.b.f438933d.e());
                        long currentAccount = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getAccountManager().getCurrentAccount();
                        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(ECDetailPageCustomViewModel.this.getGoodsType());
                        int intValue2 = intOrNull != null ? intOrNull.intValue() : 0;
                        String saasId = ECDetailPageCustomViewModel.this.getSaasId();
                        Product value2 = ECDetailPageCustomViewModel.this.a2().getValue();
                        String str7 = (value2 == null || (saasProductId = value2.getSaasProductId()) == null) ? "" : saasProductId;
                        Product value3 = ECDetailPageCustomViewModel.this.a2().getValue();
                        dVar.j(valueOf, currentAccount, intValue2, saasId, str7, (value3 == null || (title = value3.getTitle()) == null) ? "" : title, 2, i3);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public /* synthetic */ ECDetailPageCustomViewModel(String str, String str2, String str3, String str4, String str5, boolean z16, String str6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? "" : str5, (i3 & 32) != 0 ? false : z16, (i3 & 64) != 0 ? "" : str6);
    }

    public ECDetailPageCustomViewModel(String str, String str2, String str3, String str4, String str5, boolean z16, String str6) {
        Lazy lazy;
        this.categoryId = str;
        this.categoryName = str2;
        this.mediaId = str3;
        this.mediaProductID = str4;
        this.goodsType = str5;
        this.isNightMode = z16;
        this.saasId = str6;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ECDetailCustomRepo>() { // from class: com.tencent.ecommerce.biz.detail.viewmodel.saas.ECDetailPageCustomViewModel$customDetailRepo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ECDetailCustomRepo invoke() {
                return new ECDetailCustomRepo(ECDetailPageCustomViewModel.this.getMediaProductID(), ECDetailPageCustomViewModel.this.getMediaId(), ECDetailPageCustomViewModel.this.getCategoryName(), ECDetailPageCustomViewModel.this.getGoodsType(), ECDetailPageCustomViewModel.this.getIsNightMode());
            }
        });
        this.customDetailRepo = lazy;
        LiveData<List<ECBasePtsViewData>> h16 = U1().h();
        this._adapterData = h16;
        this.adapterLiveDataPts = h16;
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>(0);
        this._scrollOffset = mutableLiveData;
        this.scrollOffsetLiveData = mutableLiveData;
        LiveData<String> i3 = U1().i();
        this._buyItemUrl = i3;
        this.buyItemUrlData = i3;
        LiveData<JSONObject> n3 = U1().n();
        this._sourceData = n3;
        this.sourceLiveData = n3;
        this.productLiveData = U1().m();
        MutableLiveData<ECQQShareData> mutableLiveData2 = new MutableLiveData<>();
        this._qqShareData = mutableLiveData2;
        this.qqShareData = mutableLiveData2;
        this.mainPicExpReportSet = new LinkedHashSet();
    }
}
