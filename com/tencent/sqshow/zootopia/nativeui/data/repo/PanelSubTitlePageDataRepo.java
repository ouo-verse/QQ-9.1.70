package com.tencent.sqshow.zootopia.nativeui.data.repo;

import android.os.Handler;
import androidx.lifecycle.MutableLiveData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.data.repo.PanelSubTitlePageDataRepo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import m94.DressControllerInitData;
import mqq.util.WeakReference;
import uv4.aa;
import uv4.ah;
import uv4.ao;
import uv4.bj;
import uv4.bk;
import uv4.z;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \b2\u00020\u0001:\u0002\u001eGB\u000f\u0012\u0006\u0010 \u001a\u00020\u001d\u00a2\u0006\u0004\bE\u0010FJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u001a\u0010\r\u001a\u00020\f2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0002J\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u0016\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007J\u0006\u0010\u0016\u001a\u00020\u0007J\u0006\u0010\u0017\u001a\u00020\u0007J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018J\u0018\u0010\u001b\u001a\u00020\u00022\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tJ\u0018\u0010\u001c\u001a\u00020\u00022\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020(0!8\u0006\u00a2\u0006\f\n\u0004\b)\u0010$\u001a\u0004\b*\u0010&R\u0018\u0010.\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R2\u00108\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t05j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t`68\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u00107R\u0016\u0010:\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u00109R\u0016\u0010;\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010<R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020?0>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010@R$\u0010B\u001a\u0012\u0012\u0004\u0012\u00020\u000505j\b\u0012\u0004\u0012\u00020\u0005`68\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u00107R\u0014\u0010D\u001a\u00020\u00058\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001a\u0010C\u00a8\u0006H"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/repo/PanelSubTitlePageDataRepo;", "", "", "w", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "o", "", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/aa;", "cb", "", "i", "result", "r", "Luv4/bj;", "cfg", tl.h.F, "Luv4/ao;", "selectedItem", "g", "k", "j", "", "Luv4/ah;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, ReportConstant.COSTREPORT_PREFIX, "u", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "a", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/t;", "b", "Landroidx/lifecycle/MutableLiveData;", "p", "()Landroidx/lifecycle/MutableLiveData;", "storeItemData", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/PanelSubTitlePageDataRepo$Error;", "c", "l", "loadError", "d", "Luv4/bj;", "mStoreTypeCfg", "e", "Luv4/aa;", "mLastStoreItemRsp", "f", "Z", "mStoreItemPageRequesting", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "mRequestingCallbackPool", "I", "mCurrentOrderType", "mCurrentPage", "Ljava/lang/Integer;", "mLastReqOrderType", "Ljava/util/LinkedList;", "Ljava/lang/Runnable;", "Ljava/util/LinkedList;", "mPendingTask", "mCurrentItemIdPool", "Ljava/lang/String;", "EXP_ZPLAN_MALL_NEW_DESIGN_TEST_B", "<init>", "(Lcom/tencent/sqshow/zootopia/nativeui/data/j;)V", "Error", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PanelSubTitlePageDataRepo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.sqshow.zootopia.nativeui.data.j channel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<t> storeItemData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Error> loadError;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private bj mStoreTypeCfg;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private aa mLastStoreItemRsp;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mStoreItemPageRequesting;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private HashSet<com.tencent.mobileqq.zootopia.api.e<aa>> mRequestingCallbackPool;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mCurrentOrderType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mCurrentPage;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private Integer mLastReqOrderType;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final LinkedList<Runnable> mPendingTask;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final HashSet<String> mCurrentItemIdPool;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final String EXP_ZPLAN_MALL_NEW_DESIGN_TEST_B;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/repo/PanelSubTitlePageDataRepo$Error;", "", "(Ljava/lang/String;I)V", "REFRESH_ERROR", "LOAD_MORE_ERROR", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public enum Error {
        REFRESH_ERROR,
        LOAD_MORE_ERROR
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/data/repo/PanelSubTitlePageDataRepo$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/aa;", "result", "", "b", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<aa> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f371083d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ bj f371084e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ PanelSubTitlePageDataRepo f371085f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<aa> f371086h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f371087i;

        b(int i3, bj bjVar, PanelSubTitlePageDataRepo panelSubTitlePageDataRepo, com.tencent.mobileqq.zootopia.api.e<aa> eVar, boolean z16) {
            this.f371083d = i3;
            this.f371084e = bjVar;
            this.f371085f = panelSubTitlePageDataRepo;
            this.f371086h = eVar;
            this.f371087i = z16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(com.tencent.mobileqq.zootopia.api.e eVar, aa result) {
            Intrinsics.checkNotNullParameter(result, "$result");
            if (eVar != null) {
                eVar.onResultSuccess(result);
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(final aa result) {
            Intrinsics.checkNotNullParameter(result, "result");
            int i3 = this.f371083d;
            bj bjVar = this.f371084e;
            QLog.i("PanelSubTitlePageDataRepo", 1, "onResultSuccess page:" + i3 + " name:" + bjVar.f440351c + ", id:" + bjVar.f440349a);
            this.f371085f.r(result);
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final com.tencent.mobileqq.zootopia.api.e<aa> eVar = this.f371086h;
            uIHandlerV2.postDelayed(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.data.repo.l
                @Override // java.lang.Runnable
                public final void run() {
                    PanelSubTitlePageDataRepo.b.c(com.tencent.mobileqq.zootopia.api.e.this, result);
                }
            }, 100L);
            this.f371085f.q();
            this.f371085f.mRequestingCallbackPool.remove(this);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            Error error2;
            this.f371085f.mStoreItemPageRequesting = false;
            int i3 = this.f371083d;
            bj bjVar = this.f371084e;
            QLog.e("PanelSubTitlePageDataRepo", 1, "onResultFailure error:" + error + ", message:" + message + ", page:" + i3 + ", name:" + bjVar.f440351c + ", id:" + bjVar.f440349a);
            MutableLiveData<Error> l3 = this.f371085f.l();
            if (this.f371087i) {
                error2 = Error.REFRESH_ERROR;
            } else {
                error2 = Error.LOAD_MORE_ERROR;
            }
            l3.postValue(error2);
            com.tencent.mobileqq.zootopia.api.e<aa> eVar = this.f371086h;
            if (eVar != null) {
                eVar.onResultFailure(error, message);
            }
            this.f371085f.q();
            this.f371085f.mRequestingCallbackPool.remove(this);
        }
    }

    public PanelSubTitlePageDataRepo(com.tencent.sqshow.zootopia.nativeui.data.j channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.storeItemData = new MutableLiveData<>();
        this.loadError = new MutableLiveData<>();
        this.mRequestingCallbackPool = new HashSet<>();
        this.mCurrentOrderType = -1;
        this.mCurrentPage = -1;
        this.mPendingTask = new LinkedList<>();
        this.mCurrentItemIdPool = new HashSet<>();
        this.EXP_ZPLAN_MALL_NEW_DESIGN_TEST_B = "exp_zplan_mall_new_design_test_copy_B";
    }

    private final int n() {
        DressControllerInitData mInitData;
        b94.d avatarDressController = this.channel.getAvatarDressController();
        if (avatarDressController == null || (mInitData = avatarDressController.getMInitData()) == null) {
            return 0;
        }
        return mInitData.getReqSource();
    }

    private final String o() {
        String str;
        DressControllerInitData mInitData;
        b94.d avatarDressController = this.channel.getAvatarDressController();
        if (avatarDressController == null || (mInitData = avatarDressController.getMInitData()) == null || (str = mInitData.getSchemeParams()) == null) {
            str = "";
        }
        return xb4.b.f447772a.k(com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.n(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        Runnable pollLast = this.mPendingTask.pollLast();
        if (pollLast == null) {
            return;
        }
        QLog.i("PanelSubTitlePageDataRepo", 1, "handlePendingTask ");
        pollLast.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(PanelSubTitlePageDataRepo this$0, com.tencent.mobileqq.zootopia.api.e eVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.s(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(PanelSubTitlePageDataRepo this$0, com.tencent.mobileqq.zootopia.api.e eVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u(eVar);
    }

    public final void g(ao cfg, int selectedItem) {
        Intrinsics.checkNotNullParameter(cfg, "cfg");
        bj[] bjVarArr = cfg.f440189g;
        boolean z16 = true;
        if (bjVarArr != null) {
            if (!(bjVarArr.length == 0)) {
                z16 = false;
            }
        }
        if (z16 || bjVarArr.length <= selectedItem) {
            return;
        }
        this.mStoreTypeCfg = bjVarArr[selectedItem];
    }

    public final void h(bj cfg) {
        Intrinsics.checkNotNullParameter(cfg, "cfg");
        this.mStoreTypeCfg = cfg;
    }

    public final int j() {
        return com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.n().getIndex();
    }

    public final int k() {
        List list;
        List list2;
        Object orNull;
        List list3;
        Object orNull2;
        bj bjVar = this.mStoreTypeCfg;
        int i3 = 0;
        if (bjVar == null) {
            return 0;
        }
        Integer currentOrderType = this.channel.getPanelSortData().getCurrentOrderType();
        if (currentOrderType == null) {
            int[] iArr = bjVar.f440355g;
            Intrinsics.checkNotNullExpressionValue(iArr, "cfg.orderTypes");
            list3 = ArraysKt___ArraysKt.toList(iArr);
            orNull2 = CollectionsKt___CollectionsKt.getOrNull(list3, 0);
            Integer num = (Integer) orNull2;
            if (num != null) {
                i3 = num.intValue();
            }
        } else {
            int[] iArr2 = bjVar.f440355g;
            Intrinsics.checkNotNullExpressionValue(iArr2, "cfg.orderTypes");
            list = ArraysKt___ArraysKt.toList(iArr2);
            if (list.contains(currentOrderType)) {
                i3 = currentOrderType.intValue();
            } else {
                int i16 = this.mCurrentOrderType;
                if (i16 == -1) {
                    int[] iArr3 = bjVar.f440355g;
                    Intrinsics.checkNotNullExpressionValue(iArr3, "cfg.orderTypes");
                    list2 = ArraysKt___ArraysKt.toList(iArr3);
                    orNull = CollectionsKt___CollectionsKt.getOrNull(list2, 0);
                    Integer num2 = (Integer) orNull;
                    if (num2 != null) {
                        i3 = num2.intValue();
                    }
                } else {
                    i3 = i16;
                }
            }
        }
        this.mCurrentOrderType = i3;
        return i3;
    }

    public final MutableLiveData<Error> l() {
        return this.loadError;
    }

    public final List<ah> m() {
        Object obj;
        List<ah> emptyList;
        bj bjVar = this.mStoreTypeCfg;
        if (bjVar == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        int[] iArr = bjVar.f440356h;
        Intrinsics.checkNotNullExpressionValue(iArr, "cfg.filterTypes");
        int length = iArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            int i16 = iArr[i3];
            Iterator<T> it = this.channel.getPanelSortData().c().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((ah) obj).f440138a == i16) {
                    break;
                }
            }
            ah ahVar = (ah) obj;
            if (ahVar != null) {
                ah ahVar2 = new ah();
                ahVar2.f440138a = i16;
                ahVar2.f440139b = ahVar.f440139b;
                arrayList.add(ahVar2);
            }
        }
        return arrayList;
    }

    public final MutableLiveData<t> p() {
        return this.storeItemData;
    }

    public final void s(final com.tencent.mobileqq.zootopia.api.e<aa> cb5) {
        Runnable runnable = new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.data.repo.k
            @Override // java.lang.Runnable
            public final void run() {
                PanelSubTitlePageDataRepo.t(PanelSubTitlePageDataRepo.this, cb5);
            }
        };
        if (this.mStoreItemPageRequesting) {
            QLog.i("PanelSubTitlePageDataRepo", 1, " push requestFirstPage in pending task");
            this.mPendingTask.push(runnable);
        } else {
            w();
            i(cb5);
        }
    }

    public final void u(final com.tencent.mobileqq.zootopia.api.e<aa> cb5) {
        Runnable runnable = new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.data.repo.j
            @Override // java.lang.Runnable
            public final void run() {
                PanelSubTitlePageDataRepo.v(PanelSubTitlePageDataRepo.this, cb5);
            }
        };
        if (this.mStoreItemPageRequesting) {
            QLog.i("PanelSubTitlePageDataRepo", 1, " push requestNextPage in pending task");
            this.mPendingTask.push(runnable);
        } else {
            i(cb5);
        }
    }

    private final void w() {
        this.mCurrentPage = -1;
        this.mStoreItemPageRequesting = false;
        this.mLastStoreItemRsp = null;
        this.mCurrentItemIdPool.clear();
    }

    private final boolean i(com.tencent.mobileqq.zootopia.api.e<aa> cb5) {
        String str;
        boolean z16;
        Error error;
        this.channel.getEngineApi();
        boolean z17 = this.mCurrentPage == -1;
        IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        if (!iZPlanApi.isNetworkAvailable(context)) {
            QLog.e("PanelSubTitlePageDataRepo", 1, "requestNextPage network invalid");
            MutableLiveData<Error> mutableLiveData = this.loadError;
            if (z17) {
                error = Error.REFRESH_ERROR;
            } else {
                error = Error.LOAD_MORE_ERROR;
            }
            mutableLiveData.postValue(error);
            if (cb5 != null) {
                cb5.onResultFailure(-66601, "");
            }
            return false;
        }
        bj bjVar = this.mStoreTypeCfg;
        if (bjVar == null) {
            return false;
        }
        int i3 = this.mCurrentPage + 1;
        int k3 = k();
        List<ah> m3 = m();
        int j3 = j();
        QLog.i("PanelSubTitlePageDataRepo", 1, "requestNextPage page:" + i3 + " name:" + bjVar.f440351c + ", id:" + bjVar.f440349a + ", orderType:" + k3 + ",gender=" + j3 + ", filters:" + r94.b.H(m3) + "mStoreItemPageRequesting:" + this.mStoreItemPageRequesting);
        aa aaVar = this.mLastStoreItemRsp;
        if (aaVar != null && !(z16 = aaVar.f440105c)) {
            QLog.i("PanelSubTitlePageDataRepo", 1, "requestNextPage page:" + i3 + " name:" + bjVar.f440351c + ", id:" + bjVar.f440349a + ", lastRsp.hasMore:" + z16 + ", on last page!");
            if (cb5 == null) {
                return false;
            }
            cb5.onResultSuccess(aaVar);
            return false;
        }
        if (this.mStoreItemPageRequesting) {
            return false;
        }
        this.mStoreItemPageRequesting = true;
        z zVar = new z();
        zVar.f440474b = bjVar.f440349a;
        zVar.f440476d = i3;
        zVar.f440475c = k3;
        Object[] array = m3.toArray(new ah[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        zVar.f440477e = (ah[]) array;
        zVar.f440478f = j3;
        zVar.f440473a = xb4.b.f447772a.q(o());
        zVar.f440479g = this.channel.getEngineApi().getType().getEngineId();
        zVar.f440480h = this.EXP_ZPLAN_MALL_NEW_DESIGN_TEST_B;
        zVar.f440481i = n();
        zVar.f440482j = com.tencent.sqshow.zootopia.nativeui.data.q.f371046a.i(this.channel);
        zVar.f440483k = (aaVar == null || (str = aaVar.f440106d) == null) ? "" : str;
        this.mLastReqOrderType = Integer.valueOf(zVar.f440475c);
        QLog.d("PanelSubTitlePageDataRepo", 1, "request SubList -> " + zVar);
        b bVar = new b(i3, bjVar, this, cb5, z17);
        this.mRequestingCallbackPool.add(bVar);
        com.tencent.sqshow.zootopia.nativeui.data.k.b(com.tencent.sqshow.zootopia.nativeui.data.k.f371036a, zVar, a94.a.f25732a.a(new WeakReference(bVar)), 0, 4, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0039, code lost:
    
        r7 = kotlin.collections.ArraysKt___ArraysKt.toList(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0019, code lost:
    
        r2 = kotlin.collections.ArraysKt___ArraysKt.toList(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void r(aa result) {
        List emptyList;
        List emptyList2;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        int i3 = this.mCurrentPage;
        boolean z16 = i3 == -1;
        this.mCurrentPage = i3 + 1;
        this.mLastStoreItemRsp = result;
        this.mStoreItemPageRequesting = false;
        bk[] bkVarArr = result.f440103a;
        if (bkVarArr == null || emptyList == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        List<bk> c16 = r94.b.c(emptyList, this.mCurrentItemIdPool);
        this.mCurrentItemIdPool.addAll(r94.b.u(c16));
        bk[] bkVarArr2 = result.f440107e;
        if (bkVarArr2 == null || emptyList2 == null) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        }
        List<bk> c17 = r94.b.c(emptyList2, this.mCurrentItemIdPool);
        this.mCurrentItemIdPool.addAll(r94.b.u(c17));
        bj bjVar = this.mStoreTypeCfg;
        String str = bjVar != null ? bjVar.f440351c : null;
        String str2 = bjVar != null ? bjVar.f440349a : null;
        QLog.i("PanelSubTitlePageDataRepo", 1, "handleStoreItemListRsp name: " + str + ",  id: " + str2 + " mCurrentPage:" + this.mCurrentPage + ", hasMore:" + result.f440105c + ", originDataListSize:" + emptyList.size() + ", dataListFilterSameId:" + c16.size() + ",  recommendDataList:" + emptyList2.size() + ",  recommendDataListFilterSameId:" + c17.size());
        int i16 = z16 ? 1 : 2;
        boolean z17 = result.f440105c;
        ArrayList arrayList = new ArrayList();
        if (!c16.isEmpty()) {
            List<bk> list = c16;
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(new g(1, (bk) it.next(), null, 4, null));
            }
            arrayList.addAll(arrayList2);
        }
        if (!c17.isEmpty()) {
            if (i16 == 1) {
                if (c16.isEmpty()) {
                    arrayList.add(0, new g(5, null, null, 6, null));
                }
                arrayList.add(new g(4, null, result.f440108f, 2, null));
            }
            List<bk> list2 = c17;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it5 = list2.iterator();
            while (it5.hasNext()) {
                arrayList3.add(new g(1, (bk) it5.next(), null, 4, null));
            }
            arrayList.addAll(arrayList3);
        }
        t tVar = new t(i16, arrayList, z17);
        this.channel.getStoreItemPool().e(tVar.a());
        this.storeItemData.postValue(tVar);
    }
}
