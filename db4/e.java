package db4;

import android.app.Activity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ErrorMessage;
import com.tencent.sqshow.zootopia.data.ZootopiaDetailFeedsCardData;
import com.tencent.sqshow.zootopia.data.ZootopiaDetailFeedsListData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import pu4.l;
import pu4.n;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 A2\u00020\u0001:\u0001BB)\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u0012\u0006\u0010!\u001a\u00020\u001c\u0012\b\u0010'\u001a\u0004\u0018\u00010\"\u0012\u0006\u0010-\u001a\u00020(\u00a2\u0006\u0004\b?\u0010@J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J,\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ \u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u000f\u001a\u00020\u000eJ\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u0006\u0010\u0015\u001a\u00020\nR\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010'\u001a\u0004\u0018\u00010\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010-\u001a\u00020(8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R2\u00106\u001a\u0012\u0012\u0004\u0012\u00020\b0.j\b\u0012\u0004\u0012\u00020\b`/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u0010>\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=\u00a8\u0006C"}, d2 = {"Ldb4/e;", "Lcom/tencent/mobileqq/mvvm/b;", "Lhb4/b;", "adapter", "", ReportConstant.COSTREPORT_PREFIX, "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "Lcom/tencent/sqshow/zootopia/data/g;", "firstData", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "j", "id", "", "type", "p", "", DomainData.DOMAIN_NAME, "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "Landroidx/lifecycle/LifecycleOwner;", "d", "Landroidx/lifecycle/LifecycleOwner;", "getOwner", "()Landroidx/lifecycle/LifecycleOwner;", "owner", "Landroid/app/Activity;", "e", "Landroid/app/Activity;", "getContext", "()Landroid/app/Activity;", "context", "Lfb4/b;", "f", "Lfb4/b;", "getViewModel", "()Lfb4/b;", "viewModel", "Ldb4/a;", h.F, "Ldb4/a;", "getVmHandler", "()Ldb4/a;", "vmHandler", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "i", "Ljava/util/ArrayList;", "getCurrentCardList", "()Ljava/util/ArrayList;", "setCurrentCardList", "(Ljava/util/ArrayList;)V", "currentCardList", "Lcom/tencent/sqshow/zootopia/data/h;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/sqshow/zootopia/data/h;", "getCurrentPageData", "()Lcom/tencent/sqshow/zootopia/data/h;", "setCurrentPageData", "(Lcom/tencent/sqshow/zootopia/data/h;)V", "currentPageData", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Landroid/app/Activity;Lfb4/b;Ldb4/a;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e extends com.tencent.mobileqq.mvvm.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final LifecycleOwner owner;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Activity context;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final fb4.b viewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final a vmHandler;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ArrayList<ZootopiaDetailFeedsCardData> currentCardList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ZootopiaDetailFeedsListData currentPageData;

    public e(LifecycleOwner owner, Activity context, fb4.b bVar, a vmHandler) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(vmHandler, "vmHandler");
        this.owner = owner;
        this.context = context;
        this.viewModel = bVar;
        this.vmHandler = vmHandler;
        this.currentCardList = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(e this$0, hb4.b bVar, ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData, String str, ZootopiaDetailFeedsListData zootopiaDetailFeedsListData) {
        ZootopiaDetailFeedsCardData currentData;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (zootopiaDetailFeedsListData != null && (zootopiaDetailFeedsListData.getIsRefresh() || zootopiaDetailFeedsListData.getCurrentData() != null)) {
            if (zootopiaDetailFeedsListData.getIsRefresh() && zootopiaDetailFeedsListData.a().isEmpty()) {
                this$0.vmHandler.I4(5);
                return;
            }
            QLog.d("ZPlanDressDetailViewBinder", 1, "taskList:" + zootopiaDetailFeedsListData);
            this$0.currentCardList.clear();
            if (!zootopiaDetailFeedsListData.getIsRefresh() && (currentData = zootopiaDetailFeedsListData.getCurrentData()) != null) {
                this$0.currentCardList.add(currentData);
            }
            ZootopiaDetailFeedsCardData currentData2 = zootopiaDetailFeedsListData.getCurrentData();
            boolean z16 = !Intrinsics.areEqual(currentData2 != null ? Integer.valueOf(currentData2.getStatus()) : null, zootopiaDetailFeedsCardData != null ? Integer.valueOf(zootopiaDetailFeedsCardData.getStatus()) : null);
            if (!zootopiaDetailFeedsListData.a().isEmpty()) {
                this$0.currentCardList.addAll(zootopiaDetailFeedsListData.a());
                this$0.currentPageData = zootopiaDetailFeedsListData;
                if (bVar != null) {
                    bVar.p0(this$0.currentCardList, !zootopiaDetailFeedsListData.getIsRefresh(), z16, str);
                }
            } else if (z16 && bVar != null) {
                bVar.p0(this$0.currentCardList, !zootopiaDetailFeedsListData.getIsRefresh(), z16, str);
            }
            this$0.vmHandler.I4(4);
            return;
        }
        this$0.s(bVar);
        this$0.currentCardList.clear();
        this$0.currentPageData = null;
        QLog.d("ZPlanDressDetailViewBinder", 1, "listData is empty");
        this$0.vmHandler.I4(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(e this$0, hb4.b bVar, ZootopiaDetailFeedsListData zootopiaDetailFeedsListData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (zootopiaDetailFeedsListData != null) {
            ArrayList<ZootopiaDetailFeedsCardData> a16 = zootopiaDetailFeedsListData.a();
            if (!(a16 == null || a16.isEmpty())) {
                QLog.d("ZPlanDressDetailViewBinder", 1, "cardList, size:" + zootopiaDetailFeedsListData.a().size() + ", detail: " + ZootopiaDetailFeedsListData.INSTANCE.f(zootopiaDetailFeedsListData));
                this$0.currentCardList.addAll(zootopiaDetailFeedsListData.a());
                this$0.currentPageData = zootopiaDetailFeedsListData;
                if (bVar != null) {
                    hb4.b.q0(bVar, this$0.currentCardList, true, false, null, 12, null);
                }
                this$0.vmHandler.I4(4);
            }
        }
        Activity activity = this$0.context;
        QQToast.makeText(activity, 0, activity.getString(R.string.xns), 0).show();
        QLog.d("ZPlanDressDetailViewBinder", 1, "more list is empty");
        this$0.vmHandler.I4(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(e this$0, hb4.b bVar, ErrorMessage errorMessage) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("ZPlanDressDetailViewBinder", 1, "show errorMessage");
        this$0.s(bVar);
        this$0.vmHandler.I4(2);
    }

    public final void j(ViewPager2 viewPager, final hb4.b adapter, final ZootopiaDetailFeedsCardData firstData, final String requestId) {
        MutableLiveData<ErrorMessage> L1;
        MutableLiveData<ZootopiaDetailFeedsListData> N1;
        MutableLiveData<ZootopiaDetailFeedsListData> M1;
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        QLog.d("ZPlanDressDetailViewBinder", 1, "bindViewPager");
        viewPager.setAdapter(adapter);
        fb4.b bVar = this.viewModel;
        if (bVar != null && (M1 = bVar.M1()) != null) {
            M1.observe(this.owner, new Observer() { // from class: db4.b
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    e.k(e.this, adapter, firstData, requestId, (ZootopiaDetailFeedsListData) obj);
                }
            });
        }
        fb4.b bVar2 = this.viewModel;
        if (bVar2 != null && (N1 = bVar2.N1()) != null) {
            N1.observe(this.owner, new Observer() { // from class: db4.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    e.l(e.this, adapter, (ZootopiaDetailFeedsListData) obj);
                }
            });
        }
        fb4.b bVar3 = this.viewModel;
        if (bVar3 == null || (L1 = bVar3.L1()) == null) {
            return;
        }
        L1.observe(this.owner, new Observer() { // from class: db4.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                e.m(e.this, adapter, (ErrorMessage) obj);
            }
        });
    }

    public final boolean n(int type) {
        ZootopiaDetailFeedsListData zootopiaDetailFeedsListData = this.currentPageData;
        if (zootopiaDetailFeedsListData != null) {
            return zootopiaDetailFeedsListData.getHasMore();
        }
        return false;
    }

    public final void p(String id5, hb4.b adapter, int type) {
        n outfitWorksInfo;
        l lVar;
        n outfitWorksInfo2;
        l lVar2;
        Intrinsics.checkNotNullParameter(id5, "id");
        int i3 = -1;
        int i16 = 0;
        if (type == 1) {
            Iterator<ZootopiaDetailFeedsCardData> it = this.currentCardList.iterator();
            int i17 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ZootopiaDetailFeedsCardData next = it.next();
                if (!(next instanceof ZootopiaDetailFeedsCardData)) {
                    next = null;
                }
                if (((next == null || (outfitWorksInfo2 = next.getOutfitWorksInfo()) == null || (lVar2 = outfitWorksInfo2.f427499b) == null) ? null : lVar2.f427476a) == null) {
                    i3 = i17;
                    break;
                }
                i17++;
            }
        } else {
            Iterator<ZootopiaDetailFeedsCardData> it5 = this.currentCardList.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                ZootopiaDetailFeedsCardData next2 = it5.next();
                if (!(next2 instanceof ZootopiaDetailFeedsCardData)) {
                    next2 = null;
                }
                if (Intrinsics.areEqual((next2 == null || (outfitWorksInfo = next2.getOutfitWorksInfo()) == null || (lVar = outfitWorksInfo.f427499b) == null) ? null : lVar.f427476a, id5)) {
                    i3 = i16;
                    break;
                }
                i16++;
            }
        }
        QLog.d("ZPlanDressDetailViewBinder", 1, "deleteItem " + id5 + ", index: " + i3);
        if (i3 >= 0) {
            if (adapter != null) {
                adapter.notifyItemRemoved(i3);
            }
            this.currentCardList.remove(i3);
            if (adapter != null) {
                hb4.b.q0(adapter, this.currentCardList, true, false, null, 12, null);
            }
        }
        if (this.currentCardList.isEmpty()) {
            this.context.finish();
        }
    }

    public final byte[] q() {
        ZootopiaDetailFeedsListData zootopiaDetailFeedsListData = this.currentPageData;
        if (zootopiaDetailFeedsListData != null) {
            return zootopiaDetailFeedsListData.getPagInfo();
        }
        return null;
    }

    public final String r() {
        Object firstOrNull;
        n outfitWorksInfo;
        l lVar;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.currentCardList);
        ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData = (ZootopiaDetailFeedsCardData) firstOrNull;
        String str = (zootopiaDetailFeedsCardData == null || (outfitWorksInfo = zootopiaDetailFeedsCardData.getOutfitWorksInfo()) == null || (lVar = outfitWorksInfo.f427499b) == null) ? null : lVar.f427476a;
        return str == null ? "" : str;
    }

    private final void s(hb4.b adapter) {
        ArrayList<ZootopiaDetailFeedsCardData> i06;
        if (adapter == null || (i06 = adapter.i0()) == null) {
            return;
        }
        adapter.notifyItemRangeRemoved(0, i06.size());
        ArrayList<ZootopiaDetailFeedsCardData> i07 = adapter.i0();
        if (i07 != null) {
            i07.clear();
        }
    }

    public static /* synthetic */ boolean o(e eVar, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 0;
        }
        return eVar.n(i3);
    }
}
