package com.tencent.mobileqq.troopmanage.component;

import android.content.Intent;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.troopmanage.QTroopRobotAdminRoleHelper;
import com.tencent.mobileqq.troopmanage.event.TroopManageGetSmartEntranceEvent;
import com.tencent.mobileqq.troopmanage.event.TroopManageUpdateSmartManagerSettingEvent;
import com.tencent.mobileqq.troopmanage.repo.TroopManageViewModel;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010%\u001a\u00020$\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0003J\u0018\u0010\u0007\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002J\u0016\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0006\u0010\f\u001a\u00020\u0002R.\u0010\u0014\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/troopmanage/component/IntelligentManageConfigList;", "Lcom/tencent/mobileqq/troopmanage/component/bv;", "", "K", "", "Lcom/tencent/mobileqq/troopmanage/model/a;", "smartManagerItems", "O", "managerItem", "Lcom/tencent/mobileqq/widget/listitem/a;", UserInfo.SEX_FEMALE, "J", "N", "", "", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "g", "Ljava/util/Map;", "id2ConfigMap", "Lcom/tencent/mobileqq/troopmanage/QTroopRobotAdminRoleHelper;", tl.h.F, "Lcom/tencent/mobileqq/troopmanage/QTroopRobotAdminRoleHelper;", "helper", "I", "()Ljava/util/List;", "cachedManageItemList", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", "viewModel", "", "dtReportPgId", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;Ljava/lang/String;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class IntelligentManageConfigList extends bv {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private Map<Integer, com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g>> id2ConfigMap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final QTroopRobotAdminRoleHelper helper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\f\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/troopmanage/component/IntelligentManageConfigList$a", "Lkotlin/Function0;", "", "Lcom/tencent/mobileqq/troopmanage/TargetAction;", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements Function0<Unit> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.troopmanage.model.a f303049e;

        a(com.tencent.mobileqq.troopmanage.model.a aVar) {
            this.f303049e = aVar;
        }

        public void a() {
            IntelligentManageConfigList.this.J(this.f303049e);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002M\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0001j\u0002`\nJ#\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0002\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/troopmanage/component/IntelligentManageConfigList$b", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "troopUin", "memberUin", "", QCircleDaTongConstant.ElementParamValue.OPERATION, "", "Lcom/tencent/mobileqq/troopmanage/SetAdminSuccessCallback;", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements Function3<String, String, Byte, Unit> {
        b() {
        }

        public void a(String troopUin, String memberUin, byte operation) {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            IntelligentManageConfigList.this.h().X1().u(troopUin, memberUin, operation);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(String str, String str2, Byte b16) {
            a(str, str2, b16.byteValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntelligentManageConfigList(QBaseActivity activity, QUIListItemAdapter adapter, LifecycleOwner lifecycleOwner, TroopManageViewModel viewModel, String dtReportPgId) {
        super(activity, adapter, lifecycleOwner, viewModel, dtReportPgId);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(dtReportPgId, "dtReportPgId");
        this.id2ConfigMap = new LinkedHashMap();
        this.helper = new QTroopRobotAdminRoleHelper(activity, lifecycleOwner, g().j());
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> F(final com.tencent.mobileqq.troopmanage.model.a managerItem) {
        String str;
        final String title = managerItem.f303148b;
        if (title == null || title.length() == 0) {
            return null;
        }
        boolean z16 = managerItem.f303150d;
        if (z16 && managerItem.f303151e) {
            str = b().getString(R.string.f158651q7);
        } else if (z16 && !managerItem.f303151e) {
            str = b().getString(R.string.f172823ui2);
        } else {
            str = "";
        }
        String str2 = str;
        Intrinsics.checkNotNullExpressionValue(str2, "if (managerItem.needSetS\u2026\n            \"\"\n        }");
        Intrinsics.checkNotNullExpressionValue(title, "title");
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> w3 = bv.w(this, title, str2, null, null, 12, null);
        w3.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troopmanage.component.an
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                IntelligentManageConfigList.G(IntelligentManageConfigList.this, title, view);
            }
        });
        w3.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.component.ao
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IntelligentManageConfigList.H(IntelligentManageConfigList.this, managerItem, view);
            }
        });
        this.id2ConfigMap.put(Integer.valueOf(managerItem.f303147a), w3);
        return w3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(IntelligentManageConfigList this$0, String title, View view) {
        Map<String, ? extends Object> mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        Intrinsics.checkNotNullExpressionValue(title, "title");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("title", title));
        this$0.m("em_group_auto_manage", mapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(IntelligentManageConfigList this$0, com.tencent.mobileqq.troopmanage.model.a managerItem, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(managerItem, "$managerItem");
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(this$0.b(), 1, this$0.b().getString(R.string.f235097aq), 0).show();
        } else {
            this$0.helper.n(this$0.i(), managerItem.f303152f, new a(managerItem), new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<com.tencent.mobileqq.troopmanage.model.a> I() {
        return ap.f303070a.b(g().j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(com.tencent.mobileqq.troopmanage.model.a managerItem) {
        Map<String, ? extends Object> mapOf;
        Intent intent = new Intent(b(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra(AppConstants.LeftViewText.LEFTVIEWTEXT, b().getString(R.string.i7o));
        intent.putExtra("url", managerItem.f303149c);
        b().startActivity(intent);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("title", managerItem.f303148b));
        k("em_group_auto_manage", mapOf);
    }

    private final void K() {
        MutableLiveData<TroopManageGetSmartEntranceEvent> R1 = h().R1();
        LifecycleOwner e16 = e();
        final Function1<TroopManageGetSmartEntranceEvent, Unit> function1 = new Function1<TroopManageGetSmartEntranceEvent, Unit>() { // from class: com.tencent.mobileqq.troopmanage.component.IntelligentManageConfigList$registerListObserver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TroopManageGetSmartEntranceEvent troopManageGetSmartEntranceEvent) {
                invoke2(troopManageGetSmartEntranceEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TroopManageGetSmartEntranceEvent troopManageGetSmartEntranceEvent) {
                IntelligentManageConfigList.this.O(troopManageGetSmartEntranceEvent.getSmartManagerItems());
            }
        };
        R1.observe(e16, new Observer() { // from class: com.tencent.mobileqq.troopmanage.component.al
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                IntelligentManageConfigList.L(Function1.this, obj);
            }
        });
        MutableLiveData<TroopManageUpdateSmartManagerSettingEvent> c26 = h().c2();
        LifecycleOwner e17 = e();
        final Function1<TroopManageUpdateSmartManagerSettingEvent, Unit> function12 = new Function1<TroopManageUpdateSmartManagerSettingEvent, Unit>() { // from class: com.tencent.mobileqq.troopmanage.component.IntelligentManageConfigList$registerListObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TroopManageUpdateSmartManagerSettingEvent troopManageUpdateSmartManagerSettingEvent) {
                invoke2(troopManageUpdateSmartManagerSettingEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TroopManageUpdateSmartManagerSettingEvent troopManageUpdateSmartManagerSettingEvent) {
                Map map;
                List<com.tencent.mobileqq.troopmanage.model.a> I;
                String string;
                String str;
                map = IntelligentManageConfigList.this.id2ConfigMap;
                com.tencent.mobileqq.widget.listitem.x xVar = (com.tencent.mobileqq.widget.listitem.x) map.get(Integer.valueOf(troopManageUpdateSmartManagerSettingEvent.getId()));
                if (xVar != null) {
                    IntelligentManageConfigList intelligentManageConfigList = IntelligentManageConfigList.this;
                    x.c.g gVar = (x.c.g) xVar.O();
                    if (troopManageUpdateSmartManagerSettingEvent.isSet()) {
                        string = intelligentManageConfigList.b().getString(R.string.f158651q7);
                        str = "activity.getString(R.string.has_set)";
                    } else {
                        string = intelligentManageConfigList.b().getString(R.string.f172823ui2);
                        str = "activity.getString(R.str\u2026.qqstr_troopinf_41c10706)";
                    }
                    Intrinsics.checkNotNullExpressionValue(string, str);
                    gVar.h(string);
                    intelligentManageConfigList.c().l0(xVar);
                }
                I = IntelligentManageConfigList.this.I();
                if (I != null) {
                    for (com.tencent.mobileqq.troopmanage.model.a aVar : I) {
                        if (aVar.f303147a == troopManageUpdateSmartManagerSettingEvent.getId()) {
                            aVar.f303151e = troopManageUpdateSmartManagerSettingEvent.isSet();
                        }
                    }
                }
            }
        };
        c26.observe(e17, new Observer() { // from class: com.tencent.mobileqq.troopmanage.component.am
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                IntelligentManageConfigList.M(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void N() {
        K();
        List<com.tencent.mobileqq.troopmanage.model.a> I = I();
        if (!(I == null || I.isEmpty())) {
            O(I());
        } else {
            h().X1().l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(List<? extends com.tencent.mobileqq.troopmanage.model.a> smartManagerItems) {
        List<? extends com.tencent.mobileqq.troopmanage.model.a> list = smartManagerItems;
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (com.tencent.mobileqq.troopmanage.model.a aVar : smartManagerItems) {
            if (!aVar.f303153g || i()) {
                com.tencent.mobileqq.widget.listitem.a<?> F = F(aVar);
                if (F != null) {
                    arrayList.add(F);
                }
            }
        }
        QUIListItemAdapter c16 = c();
        Object[] array = arrayList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        c16.t0(new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length)));
    }
}
