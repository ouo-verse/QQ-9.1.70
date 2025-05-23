package com.tencent.ecommerce.biz.live.ui.viewmodel;

import android.app.Application;
import android.content.Intent;
import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.biz.common.RefreshStatus;
import com.tencent.ecommerce.biz.live.LiveTabId;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.ecommerce.repo.live.ActivityStatus;
import com.tencent.ecommerce.repo.live.ActivityType;
import com.tencent.ecommerce.repo.live.ECLiveTabInfoRepo;
import com.tencent.ecommerce.repo.live.ECLiveWindowProductRepo;
import com.tencent.ecommerce.repo.live.LiveActivity;
import com.tencent.ecommerce.repo.live.LiveCouponDetail;
import com.tencent.ecommerce.repo.live.LiveProduct;
import com.tencent.ecommerce.repo.live.TabInfo;
import com.tencent.ecommerce.repo.live.k;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import ei0.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import wg0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00a2\u00012\u00020\u0001:\u0002\u00a3\u0001B\t\u00a2\u0006\u0006\b\u00a0\u0001\u0010\u00a1\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J(\u0010\r\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000bJ\u0016\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000bJ\u0014\u0010\u0019\u001a\u00020\u00062\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0017J\u0014\u0010\u001a\u001a\u00020\u00062\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0017J\u0006\u0010\u001b\u001a\u00020\u0006J&\u0010!\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001fJ(\u0010&\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010\u0013J\u0016\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001fJ\u0016\u0010)\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u001fJ\u000e\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u000eJ\u0016\u0010-\u001a\u00020\u00062\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0017J\u0006\u0010.\u001a\u00020\u000eJ\u000e\u0010/\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0006\u00100\u001a\u00020\u0006J\u0006\u00101\u001a\u00020\u000bJ \u00102\u001a\u00020\u00062\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00130\u00172\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u00103\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0013H\u0002J\u001c\u00105\u001a\u00020\u00062\b\u00104\u001a\u0004\u0018\u00010\u00132\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002J\u0012\u00106\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002J\u0018\u00108\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0010\u00109\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0013H\u0002J*\u0010<\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010;\u001a\u00020\u000bH\u0002J\u0012\u0010>\u001a\u00020\u00062\b\b\u0001\u0010=\u001a\u00020\u000eH\u0002J\u0018\u0010A\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020\bH\u0002J\u0018\u0010B\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020\bH\u0002J\u000e\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00130\u0017H\u0002R\u0016\u0010F\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\"\u0010K\u001a\u0010\u0012\f\u0012\n H*\u0004\u0018\u00010\u000b0\u000b0G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00130L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR$\u0010T\u001a\u0012\u0012\u0004\u0012\u00020\u00130Pj\b\u0012\u0004\u0012\u00020\u0013`Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010X\u001a\u00020U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010[\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u001f\u0010_\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130G8\u0006\u00a2\u0006\f\n\u0004\b\\\u0010J\u001a\u0004\b]\u0010^R\u001d\u0010e\u001a\b\u0012\u0004\u0012\u00020\u000b0`8\u0006\u00a2\u0006\f\n\u0004\ba\u0010b\u001a\u0004\bc\u0010dR#\u0010h\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00170G8\u0006\u00a2\u0006\f\n\u0004\bf\u0010J\u001a\u0004\bg\u0010^R#\u0010k\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00170G8\u0006\u00a2\u0006\f\n\u0004\bi\u0010J\u001a\u0004\bj\u0010^R%\u0010n\u001a\u0010\u0012\f\u0012\n H*\u0004\u0018\u00010\u000e0\u000e0G8\u0006\u00a2\u0006\f\n\u0004\bl\u0010J\u001a\u0004\bm\u0010^R\u0017\u0010t\u001a\u00020o8\u0006\u00a2\u0006\f\n\u0004\bp\u0010q\u001a\u0004\br\u0010sR\"\u0010z\u001a\u00020\u000e8F@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bu\u0010f\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u0016\u0010~\u001a\u00020{8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b|\u0010}R\"\u0010\u0081\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u007f0\u00170G8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0080\u0001\u0010JR&\u0010\u0084\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u007f0\u00170`8\u0006\u00a2\u0006\u000e\n\u0005\b\u0082\u0001\u0010b\u001a\u0005\b\u0083\u0001\u0010dR\u001d\u0010\u0087\u0001\u001a\t\u0012\u0005\u0012\u00030\u0085\u00010G8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0086\u0001\u0010JR!\u0010\u008a\u0001\u001a\t\u0012\u0005\u0012\u00030\u0085\u00010`8\u0006\u00a2\u0006\u000e\n\u0005\b\u0088\u0001\u0010b\u001a\u0005\b\u0089\u0001\u0010dR\u0019\u0010\u008d\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0018\u0010\u008f\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008e\u0001\u0010ER\u0019\u0010\u0092\u0001\u001a\u00030\u0090\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0091\u0001\u0010iR\u0018\u0010\u0094\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0093\u0001\u0010fR\u0019\u0010\u0096\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0095\u0001\u0010\u008c\u0001R\u0018\u0010\u0098\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0097\u0001\u0010ER\u0018\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u008c\u0001\u0010\u0099\u0001R\u0018\u0010\u009b\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u009a\u0001\u0010ER\u0018\u0010\u009f\u0001\u001a\u00030\u009c\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001\u00a8\u0006\u00a4\u0001"}, d2 = {"Lcom/tencent/ecommerce/biz/live/ui/viewmodel/ECLiveWindowSubViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroid/content/Intent;", "intent", "Lcom/tencent/ecommerce/repo/live/TabInfo;", "tabInfo", "", "z2", "", "couponId", "successToast", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "V2", "", ICustomDataEditor.STRING_PARAM_2, NowProxyConstants.AccountInfoKey.A2, "editable", "M2", "Lcom/tencent/ecommerce/repo/live/q;", "selectedProduct", "isSelected", "L2", "", "liveProducts", "j2", "S2", "i2", "position", "productId", "sellingPointTxt", "Lfi0/a;", "adapter", "R2", "Lcom/tencent/ecommerce/biz/live/LiveTabId;", "eventTabId", "eventProductId", "liveProduct", "x2", "mediaProductId", "y2", "U2", "event", Constants.BASE_IN_PLUGIN_VERSION, "productList", "T2", "m2", SemanticAttributes.DbSystemValues.H2, "I2", "C2", "O2", Constants.MMCCID, "newTopProduct", "K2", "J2", "product", "E2", "F2", "failureToast", "needReqListIfFailure", "H2", "status", "Q2", "errorCode", "errorMsg", "l2", "k2", ICustomDataEditor.NUMBER_PARAM_2, "i", "Ljava/lang/String;", "logTag", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_isEditable", "Ljava/util/concurrent/CopyOnWriteArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/concurrent/CopyOnWriteArrayList;", "_liveProductList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "D", "Ljava/util/ArrayList;", "_selectedProductList", "Ljava/util/concurrent/atomic/AtomicInteger;", "E", "Ljava/util/concurrent/atomic/AtomicInteger;", "_refreshStatus", UserInfo.SEX_FEMALE, "Lcom/tencent/ecommerce/repo/live/q;", "_topProduct", "G", "w2", "()Landroidx/lifecycle/MutableLiveData;", "topProduct", "Landroidx/lifecycle/LiveData;", "H", "Landroidx/lifecycle/LiveData;", "o2", "()Landroidx/lifecycle/LiveData;", "editableLiveData", "I", "t2", "liveProductListLiveData", "J", "v2", "selectedProductListLiveData", "K", "u2", "refreshStatusLiveData", "Ljava/util/concurrent/atomic/AtomicBoolean;", "L", "Ljava/util/concurrent/atomic/AtomicBoolean;", "B2", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "isListEnd", "M", "p2", "()I", "N2", "(I)V", "lastVisibleIndexOfFirstScreen", "Lcom/tencent/ecommerce/repo/live/k;", "N", "Lcom/tencent/ecommerce/repo/live/k;", "repo", "Lcom/tencent/ecommerce/repo/live/l;", "P", "_liveActivityListLiveData", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "q2", "liveActivityListLiveData", "Lcom/tencent/ecommerce/repo/live/n;", BdhLogUtil.LogTag.Tag_Req, "_liveCouponLabelLiveData", ExifInterface.LATITUDE_SOUTH, "r2", "liveCouponLabelLiveData", "T", "Z", "isMaster", "U", "liveUserId", "", "V", "liveRoomId", "W", WadlProxyConsts.CHANNEL, "X", "isLiveOpened", "Y", "programId", "Lcom/tencent/ecommerce/repo/live/TabInfo;", "a0", "clickId", "Landroid/app/Application;", "b0", "Landroid/app/Application;", "ctx", "<init>", "()V", "c0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECLiveWindowSubViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final CopyOnWriteArrayList<LiveProduct> _liveProductList;

    /* renamed from: D, reason: from kotlin metadata */
    private final ArrayList<LiveProduct> _selectedProductList;

    /* renamed from: E, reason: from kotlin metadata */
    private final AtomicInteger _refreshStatus;

    /* renamed from: F, reason: from kotlin metadata */
    private LiveProduct _topProduct;

    /* renamed from: G, reason: from kotlin metadata */
    private final MutableLiveData<LiveProduct> topProduct;

    /* renamed from: H, reason: from kotlin metadata */
    private final LiveData<Boolean> editableLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    private final MutableLiveData<List<LiveProduct>> liveProductListLiveData;

    /* renamed from: J, reason: from kotlin metadata */
    private final MutableLiveData<List<LiveProduct>> selectedProductListLiveData;

    /* renamed from: K, reason: from kotlin metadata */
    private final MutableLiveData<Integer> refreshStatusLiveData;

    /* renamed from: L, reason: from kotlin metadata */
    private final AtomicBoolean isListEnd;

    /* renamed from: M, reason: from kotlin metadata */
    private int lastVisibleIndexOfFirstScreen;

    /* renamed from: N, reason: from kotlin metadata */
    private k repo;

    /* renamed from: P, reason: from kotlin metadata */
    private final MutableLiveData<List<LiveActivity>> _liveActivityListLiveData;

    /* renamed from: Q, reason: from kotlin metadata */
    private final LiveData<List<LiveActivity>> liveActivityListLiveData;

    /* renamed from: R, reason: from kotlin metadata */
    private final MutableLiveData<LiveCouponDetail> _liveCouponLabelLiveData;

    /* renamed from: S, reason: from kotlin metadata */
    private final LiveData<LiveCouponDetail> liveCouponLabelLiveData;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean isMaster;

    /* renamed from: U, reason: from kotlin metadata */
    private String liveUserId;

    /* renamed from: V, reason: from kotlin metadata */
    private long liveRoomId;

    /* renamed from: W, reason: from kotlin metadata */
    private int channel;

    /* renamed from: X, reason: from kotlin metadata */
    private boolean isLiveOpened;

    /* renamed from: Y, reason: from kotlin metadata */
    private String programId;

    /* renamed from: Z, reason: from kotlin metadata */
    private TabInfo tabInfo;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private String clickId;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private final Application ctx;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String logTag;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Boolean> _isEditable;

    public ECLiveWindowSubViewModel() {
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>(Boolean.FALSE);
        this._isEditable = mutableLiveData;
        this._liveProductList = new CopyOnWriteArrayList<>();
        ArrayList<LiveProduct> arrayList = new ArrayList<>();
        this._selectedProductList = arrayList;
        AtomicInteger atomicInteger = new AtomicInteger(0);
        this._refreshStatus = atomicInteger;
        this.topProduct = new MutableLiveData<>();
        this.editableLiveData = mutableLiveData;
        this.liveProductListLiveData = new MutableLiveData<>();
        this.selectedProductListLiveData = new MutableLiveData<>(arrayList);
        this.refreshStatusLiveData = new MutableLiveData<>(Integer.valueOf(atomicInteger.get()));
        this.isListEnd = new AtomicBoolean(false);
        this.lastVisibleIndexOfFirstScreen = -1;
        MutableLiveData<List<LiveActivity>> mutableLiveData2 = new MutableLiveData<>();
        this._liveActivityListLiveData = mutableLiveData2;
        this.liveActivityListLiveData = mutableLiveData2;
        MutableLiveData<LiveCouponDetail> mutableLiveData3 = new MutableLiveData<>();
        this._liveCouponLabelLiveData = mutableLiveData3;
        this.liveCouponLabelLiveData = mutableLiveData3;
        this.liveUserId = "";
        this.programId = "";
        this.clickId = "";
        this.ctx = a.a();
    }

    private final void E2(LiveProduct product, fi0.a adapter) {
        int lastIndexOf = this._liveProductList.lastIndexOf(product);
        if (lastIndexOf >= 0) {
            adapter.notifyItemChanged(lastIndexOf);
        }
        String str = this.logTag;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logTag");
        }
        cg0.a.b(str, "notifyProductChanged, position=" + lastIndexOf + ", product=" + product);
    }

    private final void F2(LiveProduct liveProduct) {
        if (liveProduct.getIsExplaining()) {
            k kVar = this.repo;
            if (kVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repo");
            }
            kVar.l(liveProduct, new Function1<k.CommonResponse, Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.viewmodel.ECLiveWindowSubViewModel$reqSetExplainStatus$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(k.CommonResponse commonResponse) {
                    invoke2(commonResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(final k.CommonResponse commonResponse) {
                    boolean z16;
                    int i3;
                    long j3;
                    ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.viewmodel.ECLiveWindowSubViewModel$reqSetExplainStatus$1.1
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
                            Application application;
                            CharSequence text;
                            Application application2;
                            if (commonResponse.isSuccess) {
                                application2 = ECLiveWindowSubViewModel.this.ctx;
                                text = application2.getText(R.string.wmk);
                            } else {
                                application = ECLiveWindowSubViewModel.this.ctx;
                                text = application.getText(R.string.wmj);
                            }
                            i.f101155b.d(text, ECToastIcon.ICON_SUCCESS, 0);
                        }
                    });
                    ECLiveWindowSubViewModel.this.D2(2);
                    ECLiveTabInfoRepo eCLiveTabInfoRepo = ECLiveTabInfoRepo.f105070b;
                    z16 = ECLiveWindowSubViewModel.this.isMaster;
                    i3 = ECLiveWindowSubViewModel.this.channel;
                    j3 = ECLiveWindowSubViewModel.this.liveRoomId;
                    eCLiveTabInfoRepo.j(z16, i3, j3);
                    if (commonResponse.isSuccess) {
                        return;
                    }
                    ECLiveWindowSubViewModel.this.k2(commonResponse.code, commonResponse.msg);
                }
            });
            return;
        }
        k kVar2 = this.repo;
        if (kVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repo");
        }
        kVar2.j(liveProduct, new Function1<k.CommonResponse, Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.viewmodel.ECLiveWindowSubViewModel$reqSetExplainStatus$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(k.CommonResponse commonResponse) {
                invoke2(commonResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final k.CommonResponse commonResponse) {
                boolean z16;
                int i3;
                long j3;
                ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.viewmodel.ECLiveWindowSubViewModel$reqSetExplainStatus$2.1
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
                        Application application;
                        CharSequence text;
                        Application application2;
                        if (commonResponse.isSuccess) {
                            application2 = ECLiveWindowSubViewModel.this.ctx;
                            text = application2.getText(R.string.wmu);
                        } else {
                            application = ECLiveWindowSubViewModel.this.ctx;
                            text = application.getText(R.string.wmt);
                        }
                        i.f101155b.d(text, ECToastIcon.ICON_SUCCESS, 0);
                    }
                });
                ECLiveTabInfoRepo eCLiveTabInfoRepo = ECLiveTabInfoRepo.f105070b;
                z16 = ECLiveWindowSubViewModel.this.isMaster;
                i3 = ECLiveWindowSubViewModel.this.channel;
                j3 = ECLiveWindowSubViewModel.this.liveRoomId;
                eCLiveTabInfoRepo.j(z16, i3, j3);
                if (commonResponse.isSuccess) {
                    return;
                }
                ECLiveWindowSubViewModel.this.k2(commonResponse.code, commonResponse.msg);
            }
        });
    }

    private final void G2(final LiveProduct liveProduct) {
        k kVar = this.repo;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repo");
        }
        kVar.k(liveProduct, new Function1<k.CommonResponse, Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.viewmodel.ECLiveWindowSubViewModel$reqSetSellingPoint$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(k.CommonResponse commonResponse) {
                invoke2(commonResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(k.CommonResponse commonResponse) {
                if (commonResponse.isSuccess) {
                    cg0.a.b(ECLiveWindowSubViewModel.S1(ECLiveWindowSubViewModel.this), "reqSetSellingPoint onSuccess, liveProduct:" + liveProduct);
                    ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.viewmodel.ECLiveWindowSubViewModel$reqSetSellingPoint$1.1
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
                            Application application;
                            i iVar = i.f101155b;
                            application = ECLiveWindowSubViewModel.this.ctx;
                            iVar.d(application.getText(R.string.wmn), ECToastIcon.ICON_SUCCESS, 0);
                        }
                    });
                    return;
                }
                cg0.a.a(ECLiveWindowSubViewModel.S1(ECLiveWindowSubViewModel.this), "reqSetSellingPoint", "rsp error, code=" + commonResponse.code + ", msg=" + commonResponse.msg);
                ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.viewmodel.ECLiveWindowSubViewModel$reqSetSellingPoint$1.2
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
                        Application application;
                        i iVar = i.f101155b;
                        application = ECLiveWindowSubViewModel.this.ctx;
                        iVar.d(application.getText(R.string.wmm), ECToastIcon.ICON_ERROR, 0);
                    }
                });
            }
        });
    }

    private final void H2(final String successToast, final String failureToast, final boolean needReqListIfFailure) {
        String str = this.logTag;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logTag");
        }
        cg0.a.b(str, "reqSyncLiveProductList start, successToast:" + successToast + " failureToast:" + failureToast + " needReqListIfFailure:" + needReqListIfFailure);
        k kVar = this.repo;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repo");
        }
        kVar.h(this._liveProductList, new Function1<k.CommonResponse, Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.viewmodel.ECLiveWindowSubViewModel$reqSyncLiveProductList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(k.CommonResponse commonResponse) {
                invoke2(commonResponse);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:16:0x006c, code lost:
            
                if (r7 != false) goto L15;
             */
            /* JADX WARN: Code restructure failed: missing block: B:6:0x002b, code lost:
            
                if (r7 != false) goto L8;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(k.CommonResponse commonResponse) {
                boolean isBlank;
                boolean isBlank2;
                boolean z16 = false;
                if (commonResponse.isSuccess) {
                    cg0.a.b(ECLiveWindowSubViewModel.S1(ECLiveWindowSubViewModel.this), "reqSyncLiveProductList onSuccess, successToast:" + successToast);
                    String str2 = successToast;
                    if (str2 != null) {
                        isBlank2 = StringsKt__StringsJVMKt.isBlank(str2);
                    }
                    z16 = true;
                    if (z16) {
                        return;
                    }
                    ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.viewmodel.ECLiveWindowSubViewModel$reqSyncLiveProductList$1.1
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
                            i.f101155b.d(successToast, ECToastIcon.ICON_SUCCESS, 0);
                        }
                    });
                    return;
                }
                cg0.a.a(ECLiveWindowSubViewModel.S1(ECLiveWindowSubViewModel.this), "syncListSequenceToRemote", "rsp error, code=" + commonResponse.code + ", msg=" + commonResponse.msg);
                String str3 = failureToast;
                if (str3 != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(str3);
                }
                z16 = true;
                if (!z16) {
                    ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.viewmodel.ECLiveWindowSubViewModel$reqSyncLiveProductList$1.2
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
                            i.f101155b.d(failureToast, ECToastIcon.ICON_ERROR, 0);
                        }
                    });
                }
                if (needReqListIfFailure) {
                    ECLiveWindowSubViewModel.W2(ECLiveWindowSubViewModel.this, null, null, false, 7, null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J2(fi0.a adapter) {
        LiveProduct liveProduct;
        k kVar = this.repo;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repo");
        }
        LiveProduct hotPushProduct = kVar.getHotPushProduct();
        if (hotPushProduct != null) {
            String str = this.logTag;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logTag");
            }
            cg0.a.b(str, "resetGokHotPushStyle top==hotpush: " + Intrinsics.areEqual(this._topProduct, hotPushProduct) + ", hotPushProduct:" + hotPushProduct);
            if (Intrinsics.areEqual(this._topProduct, hotPushProduct) && (liveProduct = this._topProduct) != null && !liveProduct.getIsExplaining()) {
                hotPushProduct.P(null);
            } else {
                hotPushProduct.P(new LiveProduct.UIStyle(1, ""));
            }
            if (adapter != null) {
                Iterator<LiveProduct> it = this._liveProductList.iterator();
                while (it.hasNext()) {
                    LiveProduct next = it.next();
                    if (Intrinsics.areEqual(next, hotPushProduct)) {
                        next.P(hotPushProduct.getTempUIStyle());
                        E2(next, adapter);
                    }
                }
                adapter.notifyItemChanged(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K2(LiveProduct newTopProduct, fi0.a adapter) {
        String str = this.logTag;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logTag");
        }
        cg0.a.b(str, "resetTopProduct, lastVisibleIndexOfFirstScreen=" + p2() + ", newTopProduct=" + newTopProduct + ", lastTopProduct:" + this._topProduct + '}');
        if (Intrinsics.areEqual(newTopProduct, this._topProduct)) {
            return;
        }
        LiveProduct liveProduct = this._topProduct;
        if (liveProduct != null) {
            if (Intrinsics.areEqual(this._liveProductList.get(0), this._topProduct)) {
                liveProduct.Q(false);
                if (liveProduct.getIndex() <= p2()) {
                    this._liveProductList.remove(0);
                    this._liveProductList.add(liveProduct.getIndex(), liveProduct);
                    if (adapter != null) {
                        adapter.n0(this._liveProductList);
                    }
                    if (adapter != null) {
                        adapter.notifyItemRangeChanged(0, liveProduct.getIndex() + 1);
                    }
                } else {
                    this._liveProductList.remove(0);
                    if (adapter != null) {
                        adapter.n0(this._liveProductList);
                    }
                    if (adapter != null) {
                        adapter.notifyItemRemoved(0);
                    }
                }
            } else {
                String str2 = this.logTag;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("logTag");
                }
                cg0.a.a(str2, "resetTopProduct", "");
            }
        }
        this._topProduct = newTopProduct;
        this.topProduct.postValue(newTopProduct);
        if (newTopProduct != null) {
            newTopProduct.Q(true);
            if (newTopProduct.getIndex() <= p2()) {
                this._liveProductList.remove(newTopProduct);
                this._liveProductList.add(0, newTopProduct);
                if (adapter != null) {
                    adapter.n0(this._liveProductList);
                }
                if (adapter != null) {
                    adapter.notifyItemRangeChanged(0, newTopProduct.getIndex() + 1);
                }
            } else {
                this._liveProductList.add(0, newTopProduct);
                if (adapter != null) {
                    adapter.n0(this._liveProductList);
                }
                if (adapter != null) {
                    adapter.notifyItemInserted(0);
                }
            }
        }
        if (adapter == null) {
            this.liveProductListLiveData.postValue(this._liveProductList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q2(@RefreshStatus int status) {
        this._refreshStatus.set(status);
        this.refreshStatusLiveData.postValue(Integer.valueOf(status));
    }

    public static final /* synthetic */ String S1(ECLiveWindowSubViewModel eCLiveWindowSubViewModel) {
        String str = eCLiveWindowSubViewModel.logTag;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logTag");
        }
        return str;
    }

    public static final /* synthetic */ k U1(ECLiveWindowSubViewModel eCLiveWindowSubViewModel) {
        k kVar = eCLiveWindowSubViewModel.repo;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repo");
        }
        return kVar;
    }

    public static final /* synthetic */ TabInfo W1(ECLiveWindowSubViewModel eCLiveWindowSubViewModel) {
        TabInfo tabInfo = eCLiveWindowSubViewModel.tabInfo;
        if (tabInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabInfo");
        }
        return tabInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k2(final int errorCode, final String errorMsg) {
        ECThreadUtilKt.a(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.viewmodel.ECLiveWindowSubViewModel$doReportExplainError$1
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
                String str;
                long j3;
                String str2;
                d dVar = d.f396304b;
                str = ECLiveWindowSubViewModel.this.liveUserId;
                j3 = ECLiveWindowSubViewModel.this.liveRoomId;
                str2 = ECLiveWindowSubViewModel.this.programId;
                dVar.s(str, j3, str2, errorCode, errorMsg);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l2(final int errorCode, final String errorMsg) {
        ECThreadUtilKt.a(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.viewmodel.ECLiveWindowSubViewModel$doReportLiveWindowError$1
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
                boolean z16;
                boolean z17;
                String str;
                String str2;
                long j3;
                String str3;
                z16 = ECLiveWindowSubViewModel.this.isMaster;
                if (z16) {
                    z17 = ECLiveWindowSubViewModel.this.isLiveOpened;
                    str = z17 ? "qlive_anchor_live_window_error" : "qlive_entry_live_window_error";
                } else {
                    str = "qlive_audinece_live_window_error";
                }
                String str4 = str;
                d dVar = d.f396304b;
                str2 = ECLiveWindowSubViewModel.this.liveUserId;
                j3 = ECLiveWindowSubViewModel.this.liveRoomId;
                str3 = ECLiveWindowSubViewModel.this.programId;
                dVar.z(str4, str2, j3, str3, errorCode, errorMsg);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0042 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x000b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<LiveProduct> n2() {
        boolean z16;
        CopyOnWriteArrayList<LiveProduct> copyOnWriteArrayList = this._liveProductList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : copyOnWriteArrayList) {
            LiveProduct liveProduct = (LiveProduct) obj;
            if (liveProduct.getLiveActivity() != null) {
                LiveActivity liveActivity = liveProduct.getLiveActivity();
                if ((liveActivity != null ? liveActivity.getActivityType() : null) == ActivityType.ACTIVITY_TYPE_LIVE) {
                    LiveActivity liveActivity2 = liveProduct.getLiveActivity();
                    if ((liveActivity2 != null ? liveActivity2.getActivityStatus() : null) != ActivityStatus.ACTIVITY_STATUS_END) {
                        z16 = true;
                        if (!z16) {
                            arrayList.add(obj);
                        }
                    }
                }
            }
            z16 = false;
            if (!z16) {
            }
        }
        return arrayList;
    }

    public final boolean A2() {
        return this._liveProductList.isEmpty();
    }

    /* renamed from: B2, reason: from getter */
    public final AtomicBoolean getIsListEnd() {
        return this.isListEnd;
    }

    public final boolean C2() {
        return !n2().isEmpty();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void D2(int event) {
        boolean z16;
        LiveTabId[] values = LiveTabId.values();
        ArrayList arrayList = new ArrayList();
        for (LiveTabId liveTabId : values) {
            if (liveTabId != LiveTabId.LIVE_TAB_NONE) {
                TabInfo tabInfo = this.tabInfo;
                if (tabInfo == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tabInfo");
                }
                if (liveTabId != tabInfo.id) {
                    z16 = true;
                    if (!z16) {
                        arrayList.add(liveTabId);
                    }
                }
            }
            z16 = false;
            if (!z16) {
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.tencent.ecommerce.biz.live.a.f102661d.r(event, (LiveTabId) it.next(), this.isMaster, this.channel, null, this.liveUserId, this.liveRoomId);
        }
    }

    public final void I2() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECLiveWindowSubViewModel$requestUpdateActivityList$1(this, null), 3, null);
    }

    public final void L2(LiveProduct selectedProduct, boolean isSelected) {
        Iterator<LiveProduct> it = this._liveProductList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            LiveProduct next = it.next();
            if (Intrinsics.areEqual(next, selectedProduct)) {
                next.O(isSelected);
                break;
            }
        }
        selectedProduct.O(isSelected);
        this.liveProductListLiveData.setValue(this._liveProductList);
        if (isSelected) {
            this._selectedProductList.add(selectedProduct);
        } else {
            this._selectedProductList.remove(selectedProduct);
        }
        this.selectedProductListLiveData.setValue(this._selectedProductList);
    }

    public final void M2(boolean editable) {
        this._isEditable.setValue(Boolean.valueOf(editable));
    }

    public final void N2(int i3) {
        this.lastVisibleIndexOfFirstScreen = i3;
    }

    public final void R2(int position, String productId, String sellingPointTxt, fi0.a adapter) {
        if (position >= 0 && position < this._liveProductList.size()) {
            if (Intrinsics.areEqual(productId, this._liveProductList.get(position).getMediaProductId())) {
                this._liveProductList.get(position).K(sellingPointTxt);
                adapter.notifyItemChanged(position);
                G2(this._liveProductList.get(position));
                return;
            }
            String str = this.logTag;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logTag");
            }
            cg0.a.a(str, "setSellingPoint", "productId not match. position:" + position + ", productId:" + productId + ", sellingPointTxt:" + sellingPointTxt);
            return;
        }
        String str2 = this.logTag;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logTag");
        }
        cg0.a.a(str2, "setSellingPoint", "wrong position:" + position + " !!! productId:" + productId + ", sellingPointTxt:" + sellingPointTxt);
    }

    public final void S2(List<LiveProduct> liveProducts) {
        if (liveProducts.size() == this._liveProductList.size()) {
            String str = this.logTag;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logTag");
            }
            cg0.a.f(str, "setTopProduct all selected, just ignore! selectedProductList.size:" + liveProducts.size() + ", dataSize:" + this._liveProductList.size());
            i2();
            Iterator<LiveProduct> it = this._liveProductList.iterator();
            while (it.hasNext()) {
                LiveProduct next = it.next();
                if (next.getIsSelected()) {
                    next.O(false);
                }
            }
            this.liveProductListLiveData.setValue(this._liveProductList);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<LiveProduct> it5 = this._liveProductList.iterator();
        while (it5.hasNext()) {
            LiveProduct next2 = it5.next();
            if (next2.getIsSelected()) {
                arrayList.add(next2);
            }
        }
        Iterator<LiveProduct> it6 = liveProducts.iterator();
        while (it6.hasNext()) {
            this._liveProductList.remove(it6.next());
        }
        this._liveProductList.addAll(0, arrayList);
        this.liveProductListLiveData.setValue(this._liveProductList);
        i2();
        H2(this.ctx.getString(R.string.wmq), this.ctx.getString(R.string.wmp), true);
    }

    public final void T2(List<LiveProduct> productList) {
        String str = this.logTag;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logTag");
        }
        cg0.a.b(str, "syncProductListSequence");
        if (productList != null) {
            P2(this, productList, false, 2, null);
        }
        H2(null, this.ctx.getString(R.string.wlq), true);
    }

    public final void U2(LiveProduct liveProduct, final fi0.a adapter) {
        liveProduct.L(!liveProduct.getIsExplaining());
        F2(liveProduct);
        TabInfo tabInfo = this.tabInfo;
        if (tabInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabInfo");
        }
        if (tabInfo.id == LiveTabId.LIVE_TAB_GOK) {
            k kVar = this.repo;
            if (kVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repo");
            }
            kVar.i(new Function1<LiveProduct, Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.viewmodel.ECLiveWindowSubViewModel$toggleExplainingStatus$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LiveProduct liveProduct2) {
                    invoke2(liveProduct2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LiveProduct liveProduct2) {
                    ECLiveWindowSubViewModel.this.K2(liveProduct2, adapter);
                    ECLiveWindowSubViewModel.this.J2(adapter);
                }
            });
        }
        E2(liveProduct, adapter);
        Iterator<LiveProduct> it = this._liveProductList.iterator();
        while (it.hasNext()) {
            LiveProduct next = it.next();
            if ((!Intrinsics.areEqual(next, liveProduct)) && next.getIsExplaining()) {
                next.L(false);
                E2(next, adapter);
            }
        }
    }

    public final void V2(String couponId, String successToast, boolean isLoadMore) {
        String str = this.logTag;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logTag");
        }
        cg0.a.b(str, "updateProductList start, couponId:" + couponId + ", isMaster:" + this.isMaster + ", liveUserId:" + this.liveUserId + ", liveRoomId:" + this.liveRoomId + ", successToast:" + successToast + ", isLoadMore:" + isLoadMore + ", _refreshStatus:" + this._refreshStatus + ", _isListEnd:" + this.isListEnd);
        if (this._refreshStatus.get() != 1) {
            if (isLoadMore && this.isListEnd.get()) {
                return;
            }
            Q2(1);
            final ECLiveWindowSubViewModel$updateProductList$1 eCLiveWindowSubViewModel$updateProductList$1 = new ECLiveWindowSubViewModel$updateProductList$1(this, isLoadMore, couponId, successToast);
            if (isLoadMore) {
                k kVar = this.repo;
                if (kVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("repo");
                }
                kVar.c(couponId, new Function1<k.PageResponse, Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.viewmodel.ECLiveWindowSubViewModel$updateProductList$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(k.PageResponse pageResponse) {
                        invoke2(pageResponse);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(k.PageResponse pageResponse) {
                        ECLiveWindowSubViewModel$updateProductList$1.this.invoke2(pageResponse);
                    }
                });
                return;
            }
            k kVar2 = this.repo;
            if (kVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repo");
            }
            k.c.a(kVar2, null, couponId, new Function1<k.PageResponse, Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.viewmodel.ECLiveWindowSubViewModel$updateProductList$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(k.PageResponse pageResponse) {
                    invoke2(pageResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(k.PageResponse pageResponse) {
                    ECLiveWindowSubViewModel$updateProductList$1.this.invoke2(pageResponse);
                }
            }, 1, null);
        }
    }

    public final void h2(String couponId) {
        if (this.isListEnd.get() || this._liveProductList.size() > 10) {
            return;
        }
        String str = this.logTag;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logTag");
        }
        cg0.a.b(str, "checkNeedLoadMore fetch more data");
        V2(couponId, null, true);
    }

    public final void i2() {
        Iterator<LiveProduct> it = this._selectedProductList.iterator();
        while (it.hasNext()) {
            it.next().O(false);
        }
        this._selectedProductList.clear();
        this.selectedProductListLiveData.postValue(this._selectedProductList);
    }

    public final void j2(List<LiveProduct> liveProducts) {
        for (LiveProduct liveProduct : liveProducts) {
            this._liveProductList.remove(liveProduct);
            if (liveProduct.getIsExplaining()) {
                liveProduct.L(false);
                F2(liveProduct);
            }
        }
        this.liveProductListLiveData.setValue(this._liveProductList);
        i2();
        H2(this.ctx.getString(R.string.wlp), this.ctx.getString(R.string.wlo), true);
    }

    public final int m2() {
        Iterator<T> it = this._liveProductList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (((LiveProduct) it.next()).getIsExplaining()) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public final LiveData<Boolean> o2() {
        return this.editableLiveData;
    }

    public final int p2() {
        int i3 = this.lastVisibleIndexOfFirstScreen;
        if (i3 < 0) {
            return 4;
        }
        return i3;
    }

    public final LiveData<List<LiveActivity>> q2() {
        return this.liveActivityListLiveData;
    }

    public final LiveData<LiveCouponDetail> r2() {
        return this.liveCouponLabelLiveData;
    }

    public final int s2() {
        return this._liveProductList.size();
    }

    public final MutableLiveData<List<LiveProduct>> t2() {
        return this.liveProductListLiveData;
    }

    public final MutableLiveData<Integer> u2() {
        return this.refreshStatusLiveData;
    }

    public final MutableLiveData<List<LiveProduct>> v2() {
        return this.selectedProductListLiveData;
    }

    public final MutableLiveData<LiveProduct> w2() {
        return this.topProduct;
    }

    public final void x2(LiveTabId eventTabId, String eventProductId, final fi0.a adapter, LiveProduct liveProduct) {
        String str = this.logTag;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logTag");
        }
        cg0.a.b(str, "handleExplainStartEvent eventTabId:" + eventTabId + " eventProductId:" + eventProductId + ", topProduct=" + this._topProduct);
        if (!(eventProductId.length() == 0) || this._topProduct == null) {
            k kVar = this.repo;
            if (kVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repo");
            }
            LiveProduct e16 = kVar.e(eventProductId, liveProduct);
            if (e16 != null) {
                e16.L(true);
            }
            TabInfo tabInfo = this.tabInfo;
            if (tabInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabInfo");
            }
            if (tabInfo.id == LiveTabId.LIVE_TAB_GOK) {
                k kVar2 = this.repo;
                if (kVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("repo");
                }
                kVar2.i(new Function1<LiveProduct, Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.viewmodel.ECLiveWindowSubViewModel$handleExplainStartEvent$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(LiveProduct liveProduct2) {
                        invoke2(liveProduct2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LiveProduct liveProduct2) {
                        ECLiveWindowSubViewModel.this.K2(liveProduct2, adapter);
                        ECLiveWindowSubViewModel.this.J2(adapter);
                    }
                });
            }
            Iterator<LiveProduct> it = this._liveProductList.iterator();
            while (it.hasNext()) {
                LiveProduct next = it.next();
                if (Intrinsics.areEqual(next.getMediaProductId(), eventProductId)) {
                    next.L(true);
                    E2(next, adapter);
                } else if (next.getIsExplaining()) {
                    next.L(false);
                    E2(next, adapter);
                }
            }
        }
    }

    public final void y2(String mediaProductId, final fi0.a adapter) {
        LiveProduct liveProduct;
        String str = this.logTag;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logTag");
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("handleRemoteExplainStop mediaProductId:");
        sb5.append(mediaProductId);
        sb5.append(", topProductId:");
        LiveProduct liveProduct2 = this._topProduct;
        sb5.append(liveProduct2 != null ? liveProduct2.getMediaProductId() : null);
        cg0.a.b(str, sb5.toString());
        if (Intrinsics.areEqual(mediaProductId, "") && ((liveProduct = this._topProduct) == null || (mediaProductId = liveProduct.getMediaProductId()) == null)) {
            return;
        }
        k kVar = this.repo;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repo");
        }
        LiveProduct a16 = kVar.a(mediaProductId);
        if (a16 != null) {
            a16.L(false);
        }
        TabInfo tabInfo = this.tabInfo;
        if (tabInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabInfo");
        }
        if (tabInfo.id == LiveTabId.LIVE_TAB_GOK) {
            k kVar2 = this.repo;
            if (kVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repo");
            }
            kVar2.i(new Function1<LiveProduct, Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.viewmodel.ECLiveWindowSubViewModel$handleExplainStopEvent$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LiveProduct liveProduct3) {
                    invoke2(liveProduct3);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LiveProduct liveProduct3) {
                    ECLiveWindowSubViewModel.this.K2(liveProduct3, adapter);
                    ECLiveWindowSubViewModel.this.J2(adapter);
                }
            });
        }
        Iterator<LiveProduct> it = this._liveProductList.iterator();
        while (it.hasNext()) {
            LiveProduct next = it.next();
            if (Intrinsics.areEqual(next.getMediaProductId(), mediaProductId)) {
                next.L(false);
                E2(next, adapter);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O2(List<LiveProduct> productList, boolean isLoadMore) {
        if (!isLoadMore) {
            this._liveProductList.clear();
            this._liveProductList.addAll(productList);
        } else {
            this._liveProductList.addAll(productList);
        }
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            this.liveProductListLiveData.setValue(this._liveProductList);
        } else {
            this.liveProductListLiveData.postValue(this._liveProductList);
        }
    }

    public final void z2(Intent intent, TabInfo tabInfo) {
        if (intent != null) {
            this.isMaster = Intrinsics.areEqual(intent.getStringExtra("is_master"), "1");
            String stringExtra = intent.getStringExtra("live_user_id");
            if (stringExtra == null) {
                stringExtra = "";
            }
            this.liveUserId = stringExtra;
            String stringExtra2 = intent.getStringExtra("live_room_id");
            if (stringExtra2 == null) {
                stringExtra2 = "0";
            }
            this.liveRoomId = Long.parseLong(stringExtra2);
            String stringExtra3 = intent.getStringExtra(WadlProxyConsts.CHANNEL);
            this.channel = Integer.parseInt(stringExtra3 != null ? stringExtra3 : "0");
            this.isLiveOpened = Intrinsics.areEqual(intent.getStringExtra("is_live_opened"), "1");
            String stringExtra4 = intent.getStringExtra("live_program_id");
            if (stringExtra4 == null) {
                stringExtra4 = "";
            }
            this.programId = stringExtra4;
            String stringExtra5 = intent.getStringExtra("qz_gdt");
            this.clickId = stringExtra5 != null ? stringExtra5 : "";
        }
        this.tabInfo = tabInfo;
        this.repo = new ECLiveWindowProductRepo(this.isMaster, this.liveUserId, this.liveRoomId, this.channel, tabInfo, this.clickId);
        String str = "ECLiveWindowSubViewModel_" + tabInfo.id;
        this.logTag = str;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logTag");
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("initArguments, intent.extras:");
        sb5.append(String.valueOf(intent != null ? intent.getExtras() : null));
        cg0.a.b(str, sb5.toString());
    }

    static /* synthetic */ void P2(ECLiveWindowSubViewModel eCLiveWindowSubViewModel, List list, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        eCLiveWindowSubViewModel.O2(list, z16);
    }

    public static /* synthetic */ void W2(ECLiveWindowSubViewModel eCLiveWindowSubViewModel, String str, String str2, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        if ((i3 & 2) != 0) {
            str2 = null;
        }
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        eCLiveWindowSubViewModel.V2(str, str2, z16);
    }
}
