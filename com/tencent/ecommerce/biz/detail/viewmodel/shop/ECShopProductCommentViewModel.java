package com.tencent.ecommerce.biz.detail.viewmodel.shop;

import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import bh0.d;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.e;
import com.tencent.ecommerce.biz.detail.ProductCommentSortType;
import com.tencent.ecommerce.biz.detail.repo.shop.data.ECShopProductCommentData;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 ;2\u00020\u0001:\u0002<=B\u000f\u0012\u0006\u00108\u001a\u000205\u00a2\u0006\u0004\b9\u0010:J/\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ'\u0010\f\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R$\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u001aj\b\u0012\u0004\u0012\u00020\u000e`\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dRG\u0010%\u001a2\u0012.\u0012,\u0012\u0004\u0012\u00020\u000e  *\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u000e`\u001b0\u001f8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020&0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010\"R\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020&0)8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0017\u00104\u001a\u00020/8\u0006\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0014\u00108\u001a\u0002058\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006>"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopProductCommentViewModel;", "Lbh0/d;", "", "sortType", "", "isRefreshFetch", "isFetchBackground", "", "W1", "(IZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/ECShopProductCommentData$a;", "result", "R1", "(ILcom/tencent/ecommerce/biz/detail/repo/shop/data/ECShopProductCommentData$a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/ecommerce/base/ui/b;", "ptsViewData", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "N1", "Lkotlinx/coroutines/CoroutineDispatcher;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlinx/coroutines/CoroutineDispatcher;", "defaultDispatcher", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/ECShopProductCommentData;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/ECShopProductCommentData;", "commentData", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "D", "Ljava/util/ArrayList;", "_adapterPtsData", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "E", "Landroidx/lifecycle/MutableLiveData;", "S1", "()Landroidx/lifecycle/MutableLiveData;", "adapterPtsLiveData", "Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopProductCommentViewModel$b;", UserInfo.SEX_FEMALE, "_pageStatus", "Landroidx/lifecycle/LiveData;", "G", "Landroidx/lifecycle/LiveData;", "T1", "()Landroidx/lifecycle/LiveData;", "pageStatus", "Ljava/util/concurrent/atomic/AtomicBoolean;", "H", "Ljava/util/concurrent/atomic/AtomicBoolean;", "U1", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "isListEnd", "", "I", "Ljava/lang/String;", "spuId", "<init>", "(Ljava/lang/String;)V", "J", "a", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopProductCommentViewModel extends d {

    /* renamed from: J, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: D, reason: from kotlin metadata */
    private final ArrayList<ECBasePtsViewData> _adapterPtsData;

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData<ArrayList<ECBasePtsViewData>> adapterPtsLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    private final MutableLiveData<b> _pageStatus;

    /* renamed from: G, reason: from kotlin metadata */
    private final LiveData<b> pageStatus;

    /* renamed from: H, reason: from kotlin metadata */
    private final AtomicBoolean isListEnd;

    /* renamed from: I, reason: from kotlin metadata */
    public final String spuId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final CoroutineDispatcher defaultDispatcher = Dispatchers.getIO();

    /* renamed from: C, reason: from kotlin metadata */
    private final ECShopProductCommentData commentData = new ECShopProductCommentData();

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopProductCommentViewModel$a;", "", "", "photoData", "", "a", "", "MIN_ITEM_LIST", "I", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.detail.viewmodel.shop.ECShopProductCommentViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final List<String> a(String photoData) {
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(photoData);
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
                cg0.a.a("ECDetailPageViewModel", "photoBrowser", "[photoBrowser] parse photoData:" + photoData + " error");
            }
            return arrayList;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopProductCommentViewModel$b;", "", "<init>", "()V", "a", "b", "c", "d", "Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopProductCommentViewModel$b$a;", "Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopProductCommentViewModel$b$d;", "Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopProductCommentViewModel$b$c;", "Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopProductCommentViewModel$b$b;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static abstract class b {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopProductCommentViewModel$b$a;", "Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopProductCommentViewModel$b;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class a extends b {

            /* renamed from: a, reason: collision with root package name */
            public static final a f102478a = new a();

            a() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopProductCommentViewModel$b$b;", "Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopProductCommentViewModel$b;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* renamed from: com.tencent.ecommerce.biz.detail.viewmodel.shop.ECShopProductCommentViewModel$b$b, reason: collision with other inner class name */
        /* loaded from: classes31.dex */
        public static final class C1054b extends b {

            /* renamed from: a, reason: collision with root package name */
            public static final C1054b f102479a = new C1054b();

            C1054b() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopProductCommentViewModel$b$c;", "Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopProductCommentViewModel$b;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class c extends b {

            /* renamed from: a, reason: collision with root package name */
            public static final c f102480a = new c();

            c() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopProductCommentViewModel$b$d;", "Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopProductCommentViewModel$b;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class d extends b {

            /* renamed from: a, reason: collision with root package name */
            public static final d f102481a = new d();

            d() {
                super(null);
            }
        }

        b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ECShopProductCommentViewModel(String str) {
        this.spuId = str;
        ArrayList<ECBasePtsViewData> arrayList = new ArrayList<>();
        this._adapterPtsData = arrayList;
        this.adapterPtsLiveData = new MutableLiveData<>(arrayList);
        MutableLiveData<b> mutableLiveData = new MutableLiveData<>(b.d.f102481a);
        this._pageStatus = mutableLiveData;
        this.pageStatus = mutableLiveData;
        this.isListEnd = new AtomicBoolean(false);
    }

    @Override // bh0.d
    public IPTSLiteEventListener N1(ECBasePtsViewData ptsViewData) {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object R1(@ProductCommentSortType int i3, ECShopProductCommentData.CommentListRequestResult commentListRequestResult, Continuation<? super Unit> continuation) {
        ECShopProductCommentViewModel$checkIsNeedRequstMore$1 eCShopProductCommentViewModel$checkIsNeedRequstMore$1;
        Object coroutine_suspended;
        int i16;
        if (continuation instanceof ECShopProductCommentViewModel$checkIsNeedRequstMore$1) {
            eCShopProductCommentViewModel$checkIsNeedRequstMore$1 = (ECShopProductCommentViewModel$checkIsNeedRequstMore$1) continuation;
            int i17 = eCShopProductCommentViewModel$checkIsNeedRequstMore$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                eCShopProductCommentViewModel$checkIsNeedRequstMore$1.label = i17 - Integer.MIN_VALUE;
                Object obj = eCShopProductCommentViewModel$checkIsNeedRequstMore$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = eCShopProductCommentViewModel$checkIsNeedRequstMore$1.label;
                if (i16 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (commentListRequestResult != null && (!commentListRequestResult.a().isEmpty()) && !this.isListEnd.get() && this._adapterPtsData.size() < 15) {
                        eCShopProductCommentViewModel$checkIsNeedRequstMore$1.label = 1;
                        if (W1(i3, false, true, eCShopProductCommentViewModel$checkIsNeedRequstMore$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else if (i16 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }
        eCShopProductCommentViewModel$checkIsNeedRequstMore$1 = new ECShopProductCommentViewModel$checkIsNeedRequstMore$1(this, continuation);
        Object obj2 = eCShopProductCommentViewModel$checkIsNeedRequstMore$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = eCShopProductCommentViewModel$checkIsNeedRequstMore$1.label;
        if (i16 != 0) {
        }
        return Unit.INSTANCE;
    }

    public final MutableLiveData<ArrayList<ECBasePtsViewData>> S1() {
        return this.adapterPtsLiveData;
    }

    public final LiveData<b> T1() {
        return this.pageStatus;
    }

    /* renamed from: U1, reason: from getter */
    public final AtomicBoolean getIsListEnd() {
        return this.isListEnd;
    }

    public final Object W1(@ProductCommentSortType int i3, boolean z16, boolean z17, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        if (this.isListEnd.get() && !z16) {
            return Unit.INSTANCE;
        }
        if (z16) {
            if (!z17) {
                this._pageStatus.postValue(b.c.f102480a);
            }
            this._adapterPtsData.clear();
            this.adapterPtsLiveData.postValue(this._adapterPtsData);
        }
        Object withContext = BuildersKt.withContext(this.defaultDispatcher, new ECShopProductCommentViewModel$requestData$2(this, i3, z16, z17, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return withContext == coroutine_suspended ? withContext : Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JN\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopProductCommentViewModel$c", "Lcom/tencent/ecommerce/base/ui/e;", "", IECDtReport.ACTION_IDENTIFIER, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "dataMap", "Landroid/view/View;", "view", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "", "onTapEventTriggered", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c extends e {
        c() {
        }

        @Override // com.tencent.pts.core.lite.IPTSLiteEventListener
        public void onTapEventTriggered(String identifier, HashMap<String, String> dataMap, View view, PTSComposer ptsComposer) {
            String str;
            String str2;
            if (dataMap == null || (str = dataMap.get("eventType")) == null) {
                return;
            }
            cg0.a.b("ECDetailPageViewModel", "[onTapEventTriggered] " + str);
            int hashCode = str.hashCode();
            if (hashCode != -931150290) {
                if (hashCode == 433923123 && str.equals("showPhotoBrowser") && (str2 = dataMap.get("photosData")) != null) {
                    lg0.a.b(lg0.a.f414523b, ECShopProductCommentViewModel.INSTANCE.a(str2), identifier != null ? Integer.parseInt(identifier) : 0, null, 4, null);
                    return;
                }
                return;
            }
            if (str.equals("allInOneJump")) {
                String str3 = dataMap.get(WadlProxyConsts.KEY_JUMP_URL);
                if (str3 == null) {
                    str3 = "";
                }
                cg0.a.b("ECDetailPageViewModel", "[onTapEventTriggered] type: " + str + " jumpUrl:" + str3);
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                ECScheme.g(str3, null, 2, null);
            }
        }
    }
}
