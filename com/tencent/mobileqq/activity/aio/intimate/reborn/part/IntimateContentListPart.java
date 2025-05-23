package com.tencent.mobileqq.activity.aio.intimate.reborn.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.IntimateClueItemDelegate;
import com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.f;
import com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.g;
import com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.i;
import com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.j;
import com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.k;
import com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.l;
import com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.m;
import com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.n;
import com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.o;
import com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.p;
import com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.q;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.partner.IPartnerApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import j61.IntimateBaseModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u0000 22\u00020\u0001:\u00013B\u0007\u00a2\u0006\u0004\b0\u00101J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\u001c\u0010\u0010\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0014\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R!\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\"\u0010/\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0006\u0012\u0004\u0018\u00010,0*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/reborn/part/IntimateContentListPart;", "Lcom/tencent/mobileqq/activity/aio/intimate/reborn/part/c;", "", "Li61/b;", "C9", "Lj61/a;", "intimateBaseModel", "", "F9", "A9", "z9", "x9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onPartDestroy", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "e", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "adapter", "Lj61/c;", "f", "Lj61/c;", "viewModel", "Landroidx/lifecycle/Observer;", h.F, "Landroidx/lifecycle/Observer;", "observer", "i", "Lkotlin/Lazy;", "D9", "()Ljava/util/List;", "intimateAdapters", "", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/Map;", "intimateItemDelegates", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class IntimateContentListPart extends c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView recyclerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RFWConcatAdapter adapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private j61.c viewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<IntimateBaseModel> observer = new Observer() { // from class: com.tencent.mobileqq.activity.aio.intimate.reborn.part.d
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            IntimateContentListPart.E9(IntimateContentListPart.this, (IntimateBaseModel) obj);
        }
    };

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy intimateAdapters;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Object> intimateItemDelegates;

    public IntimateContentListPart() {
        Lazy lazy;
        Map mutableMapOf;
        Map plus;
        Map mapOf;
        Map<String, Object> plus2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends i61.b>>() { // from class: com.tencent.mobileqq.activity.aio.intimate.reborn.part.IntimateContentListPart$intimateAdapters$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends i61.b> invoke() {
                return IntimateContentListPart.this.C9();
            }
        });
        this.intimateAdapters = lazy;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("HeaderBlockItemDelegate", new f()), TuplesKt.to("HeaderCardItemDelegate", new g()), TuplesKt.to("IntimateUnbindItemDelegate", new o()), TuplesKt.to("IntimateFriendInfoItemDelegate", new k()), TuplesKt.to("MemoryDayItemDelegate", new q()), TuplesKt.to("IntimateElegantCardItemDelegate", new j()), TuplesKt.to("IntimateUpgradeBannerItemDelegate", new p()), TuplesKt.to("GenericCardGroupItemDelegate", new com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.e()));
        plus = MapsKt__MapsKt.plus(mutableMapOf, ((IPartnerApi) QRoute.api(IPartnerApi.class)).getPartnerSignInDelegate());
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("IntimateLoverEntranceItemDelegate", new m()), TuplesKt.to("ElegantNovelGroupTitleItemDelegate", new com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.b()), TuplesKt.to("ElegantSpecialWordItemDelegate", new com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.d()), TuplesKt.to("ElegantNovelSpeciesItemDelegate", new com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.c()), TuplesKt.to("ElegantGiftItemDelegate", new com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.a()), TuplesKt.to("IntimateDNAItemDelegate", new i()), TuplesKt.to("IntimateLoverAchievementItemDelegate", new l()), TuplesKt.to("IntimatePlayTogetherMiniGameItemDelegate", new n()), TuplesKt.to("IntimateClueItemDelegate", new IntimateClueItemDelegate()));
        plus2 = MapsKt__MapsKt.plus(plus, mapOf);
        this.intimateItemDelegates = plus2;
    }

    private final List<i61.b> D9() {
        return (List) this.intimateAdapters.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(IntimateContentListPart this$0, IntimateBaseModel it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.F9(it);
    }

    @NotNull
    public final List<i61.b> C9() {
        List<i61.b> list;
        com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.h hVar;
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Object> entry : this.intimateItemDelegates.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.h) {
                hVar = (com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.h) value;
            } else {
                hVar = null;
            }
            if (hVar != null) {
                QLog.i("IntimateContentListPart", 1, "add itemDelegate=" + ((Object) entry.getKey()));
                arrayList.add(new i61.b(entry.getKey(), hVar));
            }
        }
        list = CollectionsKt___CollectionsKt.toList(arrayList);
        return list;
    }

    public final void F9(@NotNull IntimateBaseModel intimateBaseModel) {
        List list;
        Intrinsics.checkNotNullParameter(intimateBaseModel, "intimateBaseModel");
        QLog.i("IntimateContentListPart", 1, "refresh. uin=" + StringUtil.getSimpleUinForPrint(intimateBaseModel.getFriendUin()));
        for (i61.b bVar : D9()) {
            if (bVar.j0(intimateBaseModel)) {
                list = CollectionsKt__CollectionsJVMKt.listOf(intimateBaseModel);
            } else {
                list = null;
            }
            bVar.setItems(list);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        MutableLiveData<IntimateBaseModel> M1;
        super.onInitView(rootView);
        if (rootView != null) {
            RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.i4m);
            this.recyclerView = recyclerView;
            if (recyclerView != null) {
                recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
            }
            RFWConcatAdapter rFWConcatAdapter = new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), D9());
            this.adapter = rFWConcatAdapter;
            RecyclerView recyclerView2 = this.recyclerView;
            if (recyclerView2 != null) {
                recyclerView2.setAdapter(rFWConcatAdapter);
            }
            j61.c cVar = this.viewModel;
            if (cVar != null && (M1 = cVar.M1()) != null) {
                M1.observe(getPartHost().getLifecycleOwner(), this.observer);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        this.viewModel = (j61.c) getViewModel(j61.c.class);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.reborn.part.c
    public void A9() {
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.reborn.part.c
    public void x9() {
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.reborn.part.c
    public void z9() {
    }
}
