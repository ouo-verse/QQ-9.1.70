package com.qzone.reborn.intimate.part.manage;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.base.k;
import com.qzone.reborn.intimate.bean.QZIntimateSpaceVipInfoBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateManageInitBean;
import com.qzone.reborn.util.e;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.util.ArrayUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import hj.d;
import hj.f;
import hj.g;
import ij.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nk.aw;
import nk.n;
import tl.h;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 L2\u00020\u0001:\u0001MB\u0007\u00a2\u0006\u0004\bJ\u0010KJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u001c\u0010\u000b\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0002J\u001c\u0010\r\u001a\u00020\u00022\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0002J\u001c\u0010\u000e\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0002J\u0016\u0010\u0010\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0016\u0010\u0011\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0016\u0010\u0014\u001a\u00020\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\b\u0010\u0016\u001a\u00020\u0002H\u0002J\b\u0010\u0017\u001a\u00020\u0002H\u0002J\b\u0010\u0018\u001a\u00020\u0002H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0012\u0010 \u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010F\u00a8\u0006N"}, d2 = {"Lcom/qzone/reborn/intimate/part/manage/QZoneIntimateManageBodyPart;", "Lcom/qzone/reborn/base/k;", "", "O9", "H9", "Q9", "initData", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lij/i;", "uiStateData", "L9", "listUIStateData", "J9", "K9", "beanList", "U9", "I9", "spaceList", "", "P9", "S9", "T9", "R9", "showErrorView", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "e", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "concatAdapter", "Lhj/d;", "f", "Lhj/d;", "guestDraftAdapter", "Lhj/g;", h.F, "Lhj/g;", "normalSpaceListAdapter", "Lhj/f;", "i", "Lhj/f;", "historyBannerAdapter", "Lhj/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lhj/b;", "bottomManualAdapter", "Lnk/aw;", BdhLogUtil.LogTag.Tag_Conn, "Lnk/aw;", "manageViewModel", "Lnk/n;", "D", "Lnk/n;", "vipViewModel", "Lcom/qzone/reborn/intimate/widget/k;", "E", "Lcom/qzone/reborn/intimate/widget/k;", "mRecyclerViewDecoration", UserInfo.SEX_FEMALE, "Z", "mIsSetupItemDecoration", "G", "isFirstLaunchCreatePage", "<init>", "()V", "H", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateManageBodyPart extends k {

    /* renamed from: C, reason: from kotlin metadata */
    private aw manageViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private n vipViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    private com.qzone.reborn.intimate.widget.k mRecyclerViewDecoration;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mIsSetupItemDecoration;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isFirstLaunchCreatePage = true;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RFWConcatAdapter concatAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private d guestDraftAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private g normalSpaceListAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private f historyBannerAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private hj.b bottomManualAdapter;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/qzone/reborn/intimate/part/manage/QZoneIntimateManageBodyPart$b", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends GridLayoutManager.SpanSizeLookup {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ SafeGridLayoutManager f57572b;

        b(SafeGridLayoutManager safeGridLayoutManager) {
            this.f57572b = safeGridLayoutManager;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            g gVar = QZoneIntimateManageBodyPart.this.normalSpaceListAdapter;
            d dVar = null;
            if (gVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("normalSpaceListAdapter");
                gVar = null;
            }
            List<i> items = gVar.getItems();
            List<i> list = items;
            if (!(list == null || list.isEmpty())) {
                d dVar2 = QZoneIntimateManageBodyPart.this.guestDraftAdapter;
                if (dVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guestDraftAdapter");
                } else {
                    dVar = dVar2;
                }
                if (dVar.getNUM_BACKGOURND_ICON() > 0) {
                    if (position == 0) {
                        return 2;
                    }
                    position--;
                }
                return position >= items.size() ? 2 : 1;
            }
            return this.f57572b.getSpanCount();
        }
    }

    private final void H9() {
        d dVar = new d();
        this.guestDraftAdapter = dVar;
        dVar.setHasStableIds(true);
        g gVar = new g();
        this.normalSpaceListAdapter = gVar;
        gVar.setHasStableIds(true);
        hj.b bVar = new hj.b();
        this.bottomManualAdapter = bVar;
        bVar.setHasStableIds(true);
        f fVar = new f();
        this.historyBannerAdapter = fVar;
        fVar.setHasStableIds(true);
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[4];
        d dVar2 = this.guestDraftAdapter;
        RFWConcatAdapter rFWConcatAdapter = null;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guestDraftAdapter");
            dVar2 = null;
        }
        adapterArr[0] = dVar2;
        g gVar2 = this.normalSpaceListAdapter;
        if (gVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("normalSpaceListAdapter");
            gVar2 = null;
        }
        adapterArr[1] = gVar2;
        f fVar2 = this.historyBannerAdapter;
        if (fVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("historyBannerAdapter");
            fVar2 = null;
        }
        adapterArr[2] = fVar2;
        hj.b bVar2 = this.bottomManualAdapter;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomManualAdapter");
            bVar2 = null;
        }
        adapterArr[3] = bVar2;
        this.concatAdapter = new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr);
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        RFWConcatAdapter rFWConcatAdapter2 = this.concatAdapter;
        if (rFWConcatAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
        } else {
            rFWConcatAdapter = rFWConcatAdapter2;
        }
        recyclerView.setAdapter(rFWConcatAdapter);
        Q9();
    }

    private final void J9(UIStateData<List<i>> listUIStateData) {
        if (this.isFirstLaunchCreatePage) {
            aw awVar = this.manageViewModel;
            if (awVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("manageViewModel");
                awVar = null;
            }
            QZoneIntimateManageInitBean initBean = awVar.getInitBean();
            if (initBean != null && initBean.getOpenCreatePage()) {
                this.isFirstLaunchCreatePage = false;
                ho.i.q(getActivity(), com.qzone.reborn.configx.g.f53821a.h().D());
            }
        }
        QLog.i(getTAG(), 1, "handleSpaceListDataRsp()  state = " + listUIStateData.getState());
        int state = listUIStateData.getState();
        if (state == 0) {
            T9();
            return;
        }
        if (state == 2 || state == 3) {
            K9(listUIStateData);
        } else {
            if (state != 4) {
                return;
            }
            showErrorView();
        }
    }

    private final void K9(UIStateData<List<i>> uiStateData) {
        d dVar;
        List<i> data = uiStateData.getData();
        Intrinsics.checkNotNullExpressionValue(data, "uiStateData.data");
        if (P9(data)) {
            T9();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<i> it = uiStateData.getData().iterator();
        while (true) {
            dVar = null;
            aw awVar = null;
            if (!it.hasNext()) {
                break;
            }
            i next = it.next();
            aw awVar2 = this.manageViewModel;
            if (awVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("manageViewModel");
            } else {
                awVar = awVar2;
            }
            if (awVar.getIsGuest()) {
                if (next.getStatus() == 3) {
                    arrayList2.add(next);
                } else {
                    arrayList.add(next);
                }
            } else {
                arrayList.add(next);
            }
        }
        U9(arrayList);
        QLog.d(getTAG(), 1, "handleSuccessState  | normalList.size = " + arrayList.size() + " | draftList.size = " + arrayList2.size());
        g gVar = this.normalSpaceListAdapter;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("normalSpaceListAdapter");
            gVar = null;
        }
        gVar.setItems(arrayList);
        aw awVar3 = this.manageViewModel;
        if (awVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageViewModel");
            awVar3 = null;
        }
        if (awVar3.getIsGuest()) {
            if (arrayList2.isEmpty()) {
                d dVar2 = this.guestDraftAdapter;
                if (dVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guestDraftAdapter");
                    dVar2 = null;
                }
                dVar2.k0(null);
            } else {
                d dVar3 = this.guestDraftAdapter;
                if (dVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guestDraftAdapter");
                } else {
                    dVar = dVar3;
                }
                dVar.k0((i) arrayList2.get(0));
            }
        } else {
            d dVar4 = this.guestDraftAdapter;
            if (dVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guestDraftAdapter");
                dVar4 = null;
            }
            dVar4.k0(null);
        }
        S9();
        R9();
        I9(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9(UIStateData<List<i>> uiStateData) {
        QLog.i(getTAG(), 1, "handleVipSpaceListData()  state = " + uiStateData.getState());
        int state = uiStateData.getState();
        if (state == 2 || state == 3) {
            g gVar = this.normalSpaceListAdapter;
            g gVar2 = null;
            if (gVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("normalSpaceListAdapter");
                gVar = null;
            }
            gVar.setItems(uiStateData.getData());
            g gVar3 = this.normalSpaceListAdapter;
            if (gVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("normalSpaceListAdapter");
            } else {
                gVar2 = gVar3;
            }
            gVar2.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(QZoneIntimateManageBodyPart this$0, UIStateData it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.J9(it);
    }

    private final void O9() {
        View findViewById = getPartRootView().findViewById(R.id.nfb);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.rv_space_list)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.recyclerView = recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setItemAnimator(null);
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        ViewExtKt.f(recyclerView3, ImmersiveUtils.getStatusBarHeight(getContext()) + mk.d.f416875a.s() + ImmersiveUtils.dpToPx(16.0f));
        SafeGridLayoutManager safeGridLayoutManager = new SafeGridLayoutManager(getContext(), 2);
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView2 = recyclerView4;
        }
        recyclerView2.setLayoutManager(safeGridLayoutManager);
    }

    private final void Q9() {
        RecyclerView recyclerView = this.recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        if (recyclerView.getLayoutManager() instanceof SafeGridLayoutManager) {
            RecyclerView recyclerView3 = this.recyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                recyclerView2 = recyclerView3;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager");
            SafeGridLayoutManager safeGridLayoutManager = (SafeGridLayoutManager) layoutManager;
            safeGridLayoutManager.setSpanSizeLookup(new b(safeGridLayoutManager));
        }
    }

    private final void R9() {
        if (this.mIsSetupItemDecoration || getActivity() == null) {
            return;
        }
        this.mIsSetupItemDecoration = true;
        d dVar = this.guestDraftAdapter;
        RecyclerView recyclerView = null;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guestDraftAdapter");
            dVar = null;
        }
        boolean z16 = dVar.getNUM_BACKGOURND_ICON() > 0;
        aw awVar = this.manageViewModel;
        if (awVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageViewModel");
            awVar = null;
        }
        boolean showHistorySpace = awVar.getShowHistorySpace();
        aw awVar2 = this.manageViewModel;
        if (awVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageViewModel");
            awVar2 = null;
        }
        boolean showManual = awVar2.getShowManual();
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
        this.mRecyclerViewDecoration = new com.qzone.reborn.intimate.widget.k(z16, showHistorySpace, showManual, layoutManager != null ? layoutManager.getItemCount() : 0);
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView = recyclerView3;
        }
        com.qzone.reborn.intimate.widget.k kVar = this.mRecyclerViewDecoration;
        Intrinsics.checkNotNull(kVar);
        recyclerView.addItemDecoration(kVar);
    }

    private final void S9() {
        f fVar = this.historyBannerAdapter;
        aw awVar = null;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("historyBannerAdapter");
            fVar = null;
        }
        aw awVar2 = this.manageViewModel;
        if (awVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageViewModel");
            awVar2 = null;
        }
        fVar.k0(awVar2.getShowHistorySpace());
        hj.b bVar = this.bottomManualAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomManualAdapter");
            bVar = null;
        }
        aw awVar3 = this.manageViewModel;
        if (awVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageViewModel");
        } else {
            awVar = awVar3;
        }
        bVar.k0(awVar.getShowManual());
    }

    private final void T9() {
        S9();
        if (e.c("QZIntimateManageCreateSpaceSection", 2000L)) {
            return;
        }
        aw awVar = this.manageViewModel;
        if (awVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageViewModel");
            awVar = null;
        }
        if (awVar.getShowHistorySpace() || !this.isFirstLaunchCreatePage) {
            return;
        }
        this.isFirstLaunchCreatePage = false;
        ho.i.q(getActivity(), com.qzone.reborn.configx.g.f53821a.h().D());
    }

    private final void initData() {
        ViewModel viewModel = getViewModel(n.class);
        n nVar = (n) viewModel;
        MutableLiveData<UIStateData<List<i>>> T1 = nVar.T1();
        Fragment hostFragment = getHostFragment();
        final Function1<UIStateData<List<i>>, Unit> function1 = new Function1<UIStateData<List<i>>, Unit>() { // from class: com.qzone.reborn.intimate.part.manage.QZoneIntimateManageBodyPart$initData$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<i>> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<List<i>> it) {
                QZoneIntimateManageBodyPart qZoneIntimateManageBodyPart = QZoneIntimateManageBodyPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qZoneIntimateManageBodyPart.L9(it);
            }
        };
        T1.observe(hostFragment, new Observer() { // from class: com.qzone.reborn.intimate.part.manage.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneIntimateManageBodyPart.M9(Function1.this, obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZIntimateM\u2026\n            })\n        }");
        this.vipViewModel = nVar;
        ViewModel viewModel2 = getViewModel(aw.class);
        aw awVar = (aw) viewModel2;
        awVar.e2(getActivity());
        awVar.a2().observe(getHostFragment(), new Observer() { // from class: com.qzone.reborn.intimate.part.manage.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneIntimateManageBodyPart.N9(QZoneIntimateManageBodyPart.this, (UIStateData) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(QZoneIntima\u2026\n            })\n        }");
        this.manageViewModel = awVar;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneIntimateManageBodyPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        initData();
        O9();
        H9();
        aw awVar = this.manageViewModel;
        if (awVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageViewModel");
            awVar = null;
        }
        awVar.f2(false);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
    }

    private final void I9(List<i> beanList) {
        if (ArrayUtils.isOutOfArrayIndex(0, beanList)) {
            return;
        }
        n nVar = this.vipViewModel;
        if (nVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vipViewModel");
            nVar = null;
        }
        nVar.N1(beanList);
    }

    private final boolean P9(List<i> spaceList) {
        if (!ArrayUtils.isOutOfArrayIndex(0, spaceList) && spaceList.size() == 1) {
            return mk.d.f416875a.z(spaceList.get(0));
        }
        return false;
    }

    private final void U9(List<i> beanList) {
        if (ArrayUtils.isOutOfArrayIndex(0, beanList)) {
            return;
        }
        n nVar = this.vipViewModel;
        n nVar2 = null;
        if (nVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vipViewModel");
            nVar = null;
        }
        if (ArrayUtils.isOutOfArrayIndex(0, nVar.U1())) {
            return;
        }
        n nVar3 = this.vipViewModel;
        if (nVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vipViewModel");
        } else {
            nVar2 = nVar3;
        }
        List<QZIntimateSpaceVipInfoBean> U1 = nVar2.U1();
        for (i iVar : beanList) {
            Iterator<QZIntimateSpaceVipInfoBean> it = U1.iterator();
            while (true) {
                if (it.hasNext()) {
                    QZIntimateSpaceVipInfoBean next = it.next();
                    if (TextUtils.equals(iVar.getSpaceAbsData().space_id.get(), next.getSpaceId()) && next.getMemberStatus() == 0) {
                        iVar.k(next);
                        break;
                    }
                }
            }
        }
    }

    private final void showErrorView() {
    }
}
