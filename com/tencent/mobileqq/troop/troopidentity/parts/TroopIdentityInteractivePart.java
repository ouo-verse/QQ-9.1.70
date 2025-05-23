package com.tencent.mobileqq.troop.troopidentity.parts;

import android.content.Intent;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopidentity.TroopAllInteractiveTagsFragment;
import com.tencent.mobileqq.troop.troopidentity.util.TroopIdentityHonorUtil;
import com.tencent.mobileqq.troop.troopidentity.view.c;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.GetIdentityListRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupIdentityInteractionTag;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u001e\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\"\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016R\u0016\u0010\u001c\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/parts/TroopIdentityInteractivePart;", "Lcom/tencent/mobileqq/troop/troopidentity/parts/TroopIdentityIconBasePart;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupIdentityInteractionTag;", "selectedTag", "", "Q9", "Landroid/view/View$OnClickListener;", "O9", "L9", "", "", "", "K9", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "E9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "e", "Lcom/tencent/mobileqq/widget/listitem/Group;", "interactiveGroup", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$d;", "f", "Lcom/tencent/mobileqq/widget/listitem/x;", "interactiveConfig", "<init>", "()V", tl.h.F, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopIdentityInteractivePart extends TroopIdentityIconBasePart {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Group interactiveGroup;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private x<x.b.d, x.c.d> interactiveConfig;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/parts/TroopIdentityInteractivePart$a;", "", "", "REQUEST_CODE_INTERACTIVE", "I", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopidentity.parts.TroopIdentityInteractivePart$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57755);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopIdentityInteractivePart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> K9(GroupIdentityInteractionTag selectedTag) {
        String str;
        Map<String, Object> mapOf;
        int i3 = 2;
        Pair[] pairArr = new Pair[2];
        if (selectedTag != null) {
            str = selectedTag.interactionTagId;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        pairArr[0] = TuplesKt.to("group_interact_id", str);
        if (selectedTag != null) {
            i3 = 1;
        }
        pairArr[1] = TuplesKt.to("group_identity_situa", Integer.valueOf(i3));
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        return mapOf;
    }

    private final void L9() {
        LiveData<GetIdentityListRsp> Z1 = A9().Z1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<GetIdentityListRsp, Unit> function1 = new Function1<GetIdentityListRsp, Unit>() { // from class: com.tencent.mobileqq.troop.troopidentity.parts.TroopIdentityInteractivePart$initObserver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopIdentityInteractivePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GetIdentityListRsp getIdentityListRsp) {
                invoke2(getIdentityListRsp);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GetIdentityListRsp getIdentityListRsp) {
                Map<String, ? extends Object> K9;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) getIdentityListRsp);
                    return;
                }
                TroopIdentityInteractivePart troopIdentityInteractivePart = TroopIdentityInteractivePart.this;
                troopIdentityInteractivePart.Q9(troopIdentityInteractivePart.A9().d2());
                com.tencent.mobileqq.troop.troopidentity.util.a z95 = TroopIdentityInteractivePart.this.z9();
                TroopIdentityInteractivePart troopIdentityInteractivePart2 = TroopIdentityInteractivePart.this;
                K9 = troopIdentityInteractivePart2.K9(troopIdentityInteractivePart2.A9().d2());
                z95.d("em_group_interact", K9);
            }
        };
        Z1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.troopidentity.parts.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopIdentityInteractivePart.M9(Function1.this, obj);
            }
        });
        LiveData<com.tencent.mobileqq.troop.troopidentity.view.c> h26 = A9().h2();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.troop.troopidentity.view.c, Unit> function12 = new Function1<com.tencent.mobileqq.troop.troopidentity.view.c, Unit>() { // from class: com.tencent.mobileqq.troop.troopidentity.parts.TroopIdentityInteractivePart$initObserver$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopIdentityInteractivePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.troopidentity.view.c cVar) {
                invoke2(cVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.troopidentity.view.c cVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
                } else if (cVar instanceof c.b) {
                    TroopIdentityInteractivePart.this.Q9(((c.b) cVar).a());
                }
            }
        };
        h26.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.troop.troopidentity.parts.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopIdentityInteractivePart.N9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final View.OnClickListener O9() {
        if (!B9()) {
            return null;
        }
        return new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopidentity.parts.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopIdentityInteractivePart.P9(TroopIdentityInteractivePart.this, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(TroopIdentityInteractivePart this$0, View view) {
        ArrayList<GroupIdentityInteractionTag> arrayList;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String g26 = this$0.A9().g2();
        String c26 = this$0.A9().c2();
        GetIdentityListRsp value = this$0.A9().Z1().getValue();
        if (value != null) {
            arrayList = value.interactionTags;
        } else {
            arrayList = null;
        }
        TroopAllInteractiveTagsFragment.INSTANCE.a(this$0.getPartHost(), new com.tencent.mobileqq.troop.troopidentity.data.a(g26, c26, arrayList, 4000));
        this$0.z9().b("em_group_interact", this$0.K9(this$0.A9().d2()));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q9(GroupIdentityInteractionTag selectedTag) {
        Unit unit;
        Integer intOrNull;
        x<x.b.d, x.c.d> xVar = null;
        if (selectedTag != null) {
            x<x.b.d, x.c.d> xVar2 = this.interactiveConfig;
            if (xVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("interactiveConfig");
                xVar2 = null;
            }
            x.c.d O = xVar2.O();
            String str = selectedTag.name;
            Intrinsics.checkNotNullExpressionValue(str, "it.name");
            O.h(str);
            x<x.b.d, x.c.d> xVar3 = this.interactiveConfig;
            if (xVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("interactiveConfig");
                xVar3 = null;
            }
            x.c.d O2 = xVar3.O();
            TroopIdentityHonorUtil troopIdentityHonorUtil = TroopIdentityHonorUtil.f300410a;
            String str2 = selectedTag.interactionTagId;
            Intrinsics.checkNotNullExpressionValue(str2, "it.interactionTagId");
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str2);
            O2.j(troopIdentityHonorUtil.e(intOrNull));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            x<x.b.d, x.c.d> xVar4 = this.interactiveConfig;
            if (xVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("interactiveConfig");
                xVar4 = null;
            }
            xVar4.O().h("\u672a\u4f69\u6234");
            x<x.b.d, x.c.d> xVar5 = this.interactiveConfig;
            if (xVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("interactiveConfig");
                xVar5 = null;
            }
            xVar5.O().j("");
        }
        x<x.b.d, x.c.d> xVar6 = this.interactiveConfig;
        if (xVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactiveConfig");
        } else {
            xVar = xVar6;
        }
        C9(xVar);
    }

    @Override // com.tencent.mobileqq.troop.troopidentity.parts.TroopIdentityIconBasePart
    @NotNull
    public Group[] E9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Group[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Group[] groupArr = new Group[1];
        Group group = this.interactiveGroup;
        if (group == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactiveGroup");
            group = null;
        }
        groupArr[0] = group;
        return groupArr;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
        } else if (requestCode == 4000 && resultCode == -1 && data != null) {
            A9().v2(data.getStringExtra("selected_identity_interaction_id"));
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        x<x.b.d, x.c.d> xVar = new x<>(new x.b.d("\u4e92\u52a8\u6807\u8bc6"), new x.c.d("", "", B9(), false, 8, null));
        xVar.T(TroopIdentityHonorUtil.f300410a.f());
        xVar.x(O9());
        this.interactiveConfig = xVar;
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = new com.tencent.mobileqq.widget.listitem.a[1];
        x<x.b.d, x.c.d> xVar2 = this.interactiveConfig;
        if (xVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactiveConfig");
            xVar2 = null;
        }
        aVarArr[0] = xVar2;
        this.interactiveGroup = new Group(aVarArr);
        L9();
    }
}
