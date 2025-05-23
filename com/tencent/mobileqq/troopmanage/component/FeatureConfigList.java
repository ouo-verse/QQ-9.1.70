package com.tencent.mobileqq.troopmanage.component;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.CompoundButton;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardBlacklistReportConst;
import com.tencent.mobileqq.troopmanage.event.TroopManageSetLuckyCharacterSwitchEvent;
import com.tencent.mobileqq.troopmanage.repo.TroopManageViewModel;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.kernel.nativeinterface.GroupExt;
import com.tencent.qqnt.kernel.nativeinterface.GroupExtFlameData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0001$B/\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"J\f\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u000ej\b\u0012\u0004\u0012\u00020\u0004`\u000fR\"\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/component/FeatureConfigList;", "Lcom/tencent/mobileqq/troopmanage/component/bv;", "Lcom/tencent/mobileqq/widget/listitem/a;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/widget/listitem/Group;", "P", "", "isChecked", "", "I", "M", "isOldStateChecked", "isNewStateChecked", "O", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "H", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$f;", "g", "Lcom/tencent/mobileqq/widget/listitem/x;", "troopFlameConfig", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", "viewModel", "", "dtReportPgId", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;Ljava/lang/String;)V", tl.h.F, "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class FeatureConfigList extends bv {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> troopFlameConfig;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeatureConfigList(QBaseActivity activity, QUIListItemAdapter adapter, LifecycleOwner lifecycleOwner, TroopManageViewModel viewModel, String dtReportPgId) {
        super(activity, adapter, lifecycleOwner, viewModel, dtReportPgId);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(dtReportPgId, "dtReportPgId");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(boolean isChecked) {
        if (h().j2()) {
            if (isChecked) {
                h().m2(true);
                O(false, true);
                return;
            } else {
                DialogUtil.createCustomDialog(b(), 230, b().getString(R.string.f170511z94), b().getString(R.string.f170510z93), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.component.ac
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        FeatureConfigList.J(FeatureConfigList.this, dialogInterface, i3);
                    }
                }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.component.ad
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        FeatureConfigList.K(FeatureConfigList.this, dialogInterface, i3);
                    }
                }).show();
                return;
            }
        }
        com.tencent.mobileqq.troopmanage.base.g gVar = com.tencent.mobileqq.troopmanage.base.g.f303036a;
        String string = b().getString(R.string.f171139ci4);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(com.t\u2026api.R.string.net_disable)");
        gVar.d(string);
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar = this.troopFlameConfig;
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar2 = null;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopFlameConfig");
            xVar = null;
        }
        xVar.O().f(!isChecked);
        QUIListItemAdapter c16 = c();
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar3 = this.troopFlameConfig;
        if (xVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopFlameConfig");
        } else {
            xVar2 = xVar3;
        }
        c16.l0(xVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(FeatureConfigList this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h().m2(false);
        dialogInterface.dismiss();
        this$0.O(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(final FeatureConfigList this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar = this$0.troopFlameConfig;
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar2 = null;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopFlameConfig");
            xVar = null;
        }
        xVar.O().h(null);
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar3 = this$0.troopFlameConfig;
        if (xVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopFlameConfig");
            xVar3 = null;
        }
        xVar3.O().f(true);
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar4 = this$0.troopFlameConfig;
        if (xVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopFlameConfig");
            xVar4 = null;
        }
        xVar4.O().h(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.troopmanage.component.ae
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                FeatureConfigList.L(FeatureConfigList.this, compoundButton, z16);
            }
        });
        QUIListItemAdapter c16 = this$0.c();
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar5 = this$0.troopFlameConfig;
        if (xVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopFlameConfig");
        } else {
            xVar2 = xVar5;
        }
        c16.l0(xVar2);
        dialogInterface.dismiss();
        this$0.O(true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(FeatureConfigList this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I(z16);
    }

    private final void M() {
        h().Q1();
        MutableLiveData<Integer> P1 = h().P1();
        LifecycleOwner e16 = e();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.troopmanage.component.FeatureConfigList$initTroopFlameConfigObserver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                com.tencent.mobileqq.widget.listitem.x xVar;
                com.tencent.mobileqq.widget.listitem.x xVar2;
                com.tencent.mobileqq.widget.listitem.x xVar3;
                Map<String, ? extends Object> mapOf;
                com.tencent.mobileqq.widget.listitem.x xVar4;
                QUIListItemAdapter c16 = FeatureConfigList.this.c();
                xVar = FeatureConfigList.this.troopFlameConfig;
                com.tencent.mobileqq.widget.listitem.x xVar5 = null;
                if (xVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("troopFlameConfig");
                    xVar = null;
                }
                c16.m0(xVar, num == null || num.intValue() != 0);
                if (num != null && num.intValue() == 1) {
                    xVar4 = FeatureConfigList.this.troopFlameConfig;
                    if (xVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("troopFlameConfig");
                        xVar4 = null;
                    }
                    ((x.c.f) xVar4.O()).f(true);
                } else if (num != null && num.intValue() == 2) {
                    xVar2 = FeatureConfigList.this.troopFlameConfig;
                    if (xVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("troopFlameConfig");
                        xVar2 = null;
                    }
                    ((x.c.f) xVar2.O()).f(false);
                }
                QUIListItemAdapter c17 = FeatureConfigList.this.c();
                xVar3 = FeatureConfigList.this.troopFlameConfig;
                if (xVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("troopFlameConfig");
                } else {
                    xVar5 = xVar3;
                }
                c17.l0(xVar5);
                FeatureConfigList featureConfigList = FeatureConfigList.this;
                Pair[] pairArr = new Pair[2];
                pairArr[0] = TuplesKt.to(ProfileCardBlacklistReportConst.ELEM_PARAM_SWITCH_STATUS, Integer.valueOf((num != null && num.intValue() == 1) ? 1 : 2));
                pairArr[1] = TuplesKt.to("after_click_state", Integer.valueOf((num == null || num.intValue() != 1) ? 1 : 2));
                mapOf = MapsKt__MapsKt.mapOf(pairArr);
                featureConfigList.m("em_group_flame_switch", mapOf);
            }
        };
        P1.observe(e16, new Observer() { // from class: com.tencent.mobileqq.troopmanage.component.ab
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeatureConfigList.N(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(FeatureConfigList this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        bv.n(this$0, "em_group_nickname_sync", null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(FeatureConfigList this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        bv.l(this$0, "em_group_nickname_sync", null, 2, null);
        Intent intent = new Intent(this$0.b(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", "https://imgcache.qq.com/gc/social_gamecenterV2/dist/index/groupApp/nickNameChange.html?_wv=3&groupid=" + this$0.g().j());
        this$0.b().startActivity(intent);
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> S() {
        final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> p16 = p(R.string.z9c, new Function2<com.tencent.mobileqq.widget.listitem.x<?, x.c.f>, Boolean, Unit>() { // from class: com.tencent.mobileqq.troopmanage.component.FeatureConfigList$troopLuckWordConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.widget.listitem.x<?, x.c.f> xVar, Boolean bool) {
                invoke(xVar, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(com.tencent.mobileqq.widget.listitem.x<?, x.c.f> xVar, boolean z16) {
                Intrinsics.checkNotNullParameter(xVar, "<anonymous parameter 0>");
                FeatureConfigList.this.h().T1().getTroopManageHandler().U2(FeatureConfigList.this.g().j(), z16);
                HashMap hashMap = new HashMap();
                hashMap.put("after_click_state", Integer.valueOf(z16 ? 1 : 2));
                FeatureConfigList.this.k("em_group_luck_character", hashMap);
            }
        });
        p16.O().f((g().h().groupFlagExt4 & 32768) == 0);
        p16.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troopmanage.component.x
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                FeatureConfigList.T(com.tencent.mobileqq.widget.listitem.x.this, this, view);
            }
        });
        MutableLiveData<TroopManageSetLuckyCharacterSwitchEvent> a26 = h().a2();
        LifecycleOwner e16 = e();
        final Function1<TroopManageSetLuckyCharacterSwitchEvent, Unit> function1 = new Function1<TroopManageSetLuckyCharacterSwitchEvent, Unit>() { // from class: com.tencent.mobileqq.troopmanage.component.FeatureConfigList$troopLuckWordConfig$2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TroopManageSetLuckyCharacterSwitchEvent troopManageSetLuckyCharacterSwitchEvent) {
                invoke2(troopManageSetLuckyCharacterSwitchEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TroopManageSetLuckyCharacterSwitchEvent troopManageSetLuckyCharacterSwitchEvent) {
                if (troopManageSetLuckyCharacterSwitchEvent.getResult()) {
                    com.tencent.mobileqq.troopmanage.base.g gVar = com.tencent.mobileqq.troopmanage.base.g.f303036a;
                    String string = FeatureConfigList.this.b().getResources().getString(R.string.f1787337g);
                    Intrinsics.checkNotNullExpressionValue(string, "activity.resources.getSt\u2026ky_character_switch_succ)");
                    gVar.c(string);
                } else if (troopManageSetLuckyCharacterSwitchEvent.getResultCode() == 10007) {
                    com.tencent.mobileqq.troopmanage.base.g gVar2 = com.tencent.mobileqq.troopmanage.base.g.f303036a;
                    String string2 = FeatureConfigList.this.b().getResources().getString(R.string.f1787237f);
                    Intrinsics.checkNotNullExpressionValue(string2, "activity.resources.getSt\u2026r_switch_fail_due_to_gag)");
                    gVar2.b(string2);
                } else {
                    com.tencent.mobileqq.troopmanage.base.g gVar3 = com.tencent.mobileqq.troopmanage.base.g.f303036a;
                    String string3 = FeatureConfigList.this.b().getResources().getString(R.string.f1787137e);
                    Intrinsics.checkNotNullExpressionValue(string3, "activity.resources.getSt\u2026ky_character_switch_fail)");
                    gVar3.b(string3);
                }
                if (troopManageSetLuckyCharacterSwitchEvent.getResult()) {
                    return;
                }
                FeatureConfigList.this.j(p16, !r0.O().getIsChecked());
            }
        };
        a26.observe(e16, new Observer() { // from class: com.tencent.mobileqq.troopmanage.component.y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeatureConfigList.U(Function1.this, obj);
            }
        });
        return p16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(com.tencent.mobileqq.widget.listitem.x this_apply, FeatureConfigList this$0, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        HashMap hashMap = new HashMap();
        hashMap.put("after_click_state", Integer.valueOf(((x.c.f) this_apply.O()).getIsChecked() ? 1 : 2));
        this$0.m("em_group_luck_character", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final ArrayList<Group> H() {
        ArrayList<Group> arrayListOf;
        ArrayList arrayList = new ArrayList();
        if (g().h().isHomeworkTroop()) {
            arrayList.addAll(new bp(b(), c(), e(), h(), d()).E().a());
        } else {
            arrayList.addAll(new br(b(), c(), e(), h(), d()).y().a());
        }
        arrayList.add(S());
        Object[] array = arrayList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length)), P());
        return arrayListOf;
    }

    private final void O(boolean isOldStateChecked, boolean isNewStateChecked) {
        Map<String, ? extends Object> mapOf;
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to(ProfileCardBlacklistReportConst.ELEM_PARAM_SWITCH_STATUS, Integer.valueOf(isOldStateChecked ? 1 : 2));
        pairArr[1] = TuplesKt.to("after_click_state", Integer.valueOf(isNewStateChecked ? 1 : 2));
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        k("em_group_flame_switch", mapOf);
    }

    private final Group P() {
        GroupExtFlameData groupExtFlameData;
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = new com.tencent.mobileqq.widget.listitem.a[2];
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> p16 = p(R.string.f170509z92, new Function2<com.tencent.mobileqq.widget.listitem.x<?, x.c.f>, Boolean, Unit>() { // from class: com.tencent.mobileqq.troopmanage.component.FeatureConfigList$topGroup$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.widget.listitem.x<?, x.c.f> xVar, Boolean bool) {
                invoke(xVar, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(com.tencent.mobileqq.widget.listitem.x<?, x.c.f> xVar, boolean z16) {
                Intrinsics.checkNotNullParameter(xVar, "<anonymous parameter 0>");
                FeatureConfigList.this.I(z16);
            }
        });
        this.troopFlameConfig = p16;
        if (g().h().isOwner()) {
            GroupExt groupExt = g().h().groupExt;
            int i3 = (groupExt == null || (groupExtFlameData = groupExt.groupExtFlameData) == null) ? 0 : groupExtFlameData.switchState;
            p16.p(i3 != 0);
            p16.O().f(i3 == 1);
            M();
        } else {
            p16.p(false);
        }
        Unit unit = Unit.INSTANCE;
        aVarArr[0] = p16;
        com.tencent.mobileqq.widget.listitem.x v3 = bv.v(this, R.string.z9o, "", null, null, 12, null);
        v3.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troopmanage.component.z
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                FeatureConfigList.Q(FeatureConfigList.this, view);
            }
        });
        v3.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.component.aa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeatureConfigList.R(FeatureConfigList.this, view);
            }
        });
        v3.p(g().c());
        aVarArr[1] = v3;
        return new Group(aVarArr);
    }
}
