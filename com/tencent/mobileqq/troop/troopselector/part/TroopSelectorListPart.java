package com.tencent.mobileqq.troop.troopselector.part;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectfriend.api.IForwardFriendApi;
import com.tencent.mobileqq.selectfriend.relationlist.BaseRelationSectionedNodeList;
import com.tencent.mobileqq.selectfriend.relationlist.SharedNode;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.troop.troopselector.TroopSelectorConfig;
import com.tencent.mobileqq.troop.troopselector.TroopSelectorVM;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0011\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b \u0010!J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R#\u0010\u001b\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/troop/troopselector/part/TroopSelectorListPart;", "Lcom/tencent/mobileqq/troop/troopselector/part/a;", "", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "allTroopsList", "", "D9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/tencent/mobileqq/troop/troopselector/TroopSelectorConfig;", "d", "Lcom/tencent/mobileqq/troop/troopselector/TroopSelectorConfig;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/selectfriend/relationlist/BaseRelationSectionedNodeList;", "e", "Lcom/tencent/mobileqq/selectfriend/relationlist/BaseRelationSectionedNodeList;", "troopList", "Lcom/tencent/mobileqq/troop/troopselector/TroopSelectorVM;", "kotlin.jvm.PlatformType", "f", "Lkotlin/Lazy;", "C9", "()Lcom/tencent/mobileqq/troop/troopselector/TroopSelectorVM;", "vm", "Lcom/tencent/mobileqq/selectfriend/relationlist/b;", h.F, "Lcom/tencent/mobileqq/selectfriend/relationlist/b;", "listChangeListener", "<init>", "(Lcom/tencent/mobileqq/troop/troopselector/TroopSelectorConfig;)V", "i", "a", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopSelectorListPart extends a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final TroopSelectorConfig config;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private BaseRelationSectionedNodeList troopList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy vm;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.selectfriend.relationlist.b listChangeListener;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/troopselector/part/TroopSelectorListPart$b", "Lcom/tencent/mobileqq/selectfriend/relationlist/c;", "", "currentCount", "Lcom/tencent/mobileqq/selectfriend/relationlist/SharedNode;", "node", "", "a", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.mobileqq.selectfriend.relationlist.c {
        b() {
        }

        @Override // com.tencent.mobileqq.selectfriend.relationlist.c
        public void a(int currentCount, SharedNode node) {
            Intrinsics.checkNotNullParameter(node, "node");
            TroopSelectorListPart.this.C9().Z1(node);
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/troop/troopselector/part/TroopSelectorListPart$c", "Lcom/tencent/mobileqq/selectfriend/relationlist/b;", "", "Lcom/tencent/mobileqq/selectfriend/relationlist/SharedNode;", "changedList", "", "b", "sharedNode", "a", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.mobileqq.selectfriend.relationlist.b {
        c() {
        }

        @Override // com.tencent.mobileqq.selectfriend.relationlist.b
        public void a(SharedNode sharedNode) {
            Intrinsics.checkNotNullParameter(sharedNode, "sharedNode");
            TroopSelectorListPart.this.C9().b2(sharedNode);
        }

        @Override // com.tencent.mobileqq.selectfriend.relationlist.b
        public void b(List<SharedNode> changedList) {
            TroopSelectorListPart.this.C9().a2(com.tencent.mobileqq.selectfriend.relationlist.e.f285562a.f());
        }
    }

    public TroopSelectorListPart(TroopSelectorConfig troopSelectorConfig) {
        Lazy lazy;
        this.config = troopSelectorConfig;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TroopSelectorVM>() { // from class: com.tencent.mobileqq.troop.troopselector.part.TroopSelectorListPart$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TroopSelectorVM invoke() {
                return (TroopSelectorVM) TroopSelectorListPart.this.getViewModel(TroopSelectorVM.class);
            }
        });
        this.vm = lazy;
        this.listChangeListener = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopSelectorVM C9() {
        return (TroopSelectorVM) this.vm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D9(List<? extends TroopInfo> allTroopsList) {
        ArrayList<ResultRecord> c16;
        com.tencent.mobileqq.selectfriend.relationlist.e.f285562a.k();
        IForwardFriendApi iForwardFriendApi = (IForwardFriendApi) QRoute.api(IForwardFriendApi.class);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        BaseRelationSectionedNodeList userList = iForwardFriendApi.getUserList(context, new rt2.a(this.config, allTroopsList));
        this.troopList = userList;
        if (userList != null) {
            if (!(userList.getChildCount() != 0)) {
                userList = null;
            }
            if (userList != null) {
                userList.c();
                userList.e(false);
                TroopSelectorConfig troopSelectorConfig = this.config;
                if ((troopSelectorConfig == null || (c16 = troopSelectorConfig.c()) == null || !(c16.isEmpty() ^ true)) ? false : true) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList<ResultRecord> c17 = this.config.c();
                    if (c17 != null) {
                        for (ResultRecord resultRecord : c17) {
                            st2.b bVar = st2.b.f434715a;
                            String str = resultRecord.uin;
                            Intrinsics.checkNotNullExpressionValue(str, "it.uin");
                            SharedNode c18 = bVar.c(str);
                            arrayList.add(c18);
                            com.tencent.mobileqq.selectfriend.relationlist.e.f285562a.c(c18);
                        }
                    }
                    C9().a2(arrayList);
                }
                userList.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                userList.a(0);
                TroopSelectorConfig troopSelectorConfig2 = this.config;
                userList.setMultiSelectMode(troopSelectorConfig2 != null && troopSelectorConfig2.e(), false);
                TroopSelectorConfig troopSelectorConfig3 = this.config;
                if (troopSelectorConfig3 != null && troopSelectorConfig3.e()) {
                    com.tencent.mobileqq.selectfriend.relationlist.e.f285562a.o(this.config.b(), "TroopSelectorListPart");
                }
            }
        }
        com.tencent.mobileqq.selectfriend.relationlist.e eVar = com.tencent.mobileqq.selectfriend.relationlist.e.f285562a;
        eVar.n(new b(), "TroopSelectorListPart");
        FrameLayout listRootView = getPartHost().getListRootView();
        if (listRootView != null) {
            listRootView.addView(this.troopList);
        }
        eVar.a(this.listChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        LifecycleOwner viewLifecycleOwner = getPartHost().getViewLifecycleOwner();
        LiveData<List<TroopInfo>> P1 = C9().P1();
        final Function1<List<? extends TroopInfo>, Unit> function1 = new Function1<List<? extends TroopInfo>, Unit>() { // from class: com.tencent.mobileqq.troop.troopselector.part.TroopSelectorListPart$onInitView$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends TroopInfo> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends TroopInfo> it) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (!it.isEmpty()) {
                    TroopSelectorListPart.this.D9(it);
                }
            }
        };
        P1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.troopselector.part.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopSelectorListPart.E9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        BaseRelationSectionedNodeList baseRelationSectionedNodeList = this.troopList;
        if (baseRelationSectionedNodeList != null) {
            baseRelationSectionedNodeList.d();
        }
        com.tencent.mobileqq.selectfriend.relationlist.e eVar = com.tencent.mobileqq.selectfriend.relationlist.e.f285562a;
        eVar.n(null, "TroopSelectorListPart");
        eVar.l(this.listChangeListener);
    }
}
