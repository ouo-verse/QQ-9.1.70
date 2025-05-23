package com.tencent.mobileqq.troop.troopidentity.parts;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopidentity.TroopIdentityAppTagFragment;
import com.tencent.mobileqq.troop.troopidentity.util.TroopIdentityHonorUtil;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.GetIdentityListRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupIdentityAppTag;
import cooperation.qzone.QzoneIPCModule;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u001e\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0002J\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\"\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016R\"\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/parts/TroopIdentityAppIconPart;", "Lcom/tencent/mobileqq/troop/troopidentity/parts/TroopIdentityIconBasePart;", "", "M9", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupIdentityAppTag;", "iconInfo", "O9", "Landroid/view/View$OnClickListener;", "J9", "appTag", "", "", "", "L9", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "E9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$d;", "e", "Lcom/tencent/mobileqq/widget/listitem/x;", "appIconConfig", "<init>", "()V", "f", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopIdentityAppIconPart extends TroopIdentityIconBasePart {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private x<x.b.d, x.c.d> appIconConfig;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/parts/TroopIdentityAppIconPart$a;", "", "", "REQUEST_CODE_IDENTITY_APP", "I", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopidentity.parts.TroopIdentityAppIconPart$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57738);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopIdentityAppIconPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final View.OnClickListener J9() {
        if (!B9()) {
            return null;
        }
        return new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopidentity.parts.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopIdentityAppIconPart.K9(TroopIdentityAppIconPart.this, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(TroopIdentityAppIconPart this$0, View view) {
        GroupIdentityAppTag W1;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity != null && (W1 = this$0.A9().W1()) != null) {
            TroopIdentityAppTagFragment.INSTANCE.a(activity, this$0.A9().g2(), this$0.A9().c2(), W1, 5000);
            this$0.z9().b("em_group_app_interact", this$0.L9(this$0.A9().W1()));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> L9(GroupIdentityAppTag appTag) {
        String str;
        Map<String, Object> mapOf;
        int i3 = 2;
        Pair[] pairArr = new Pair[2];
        if (appTag != null) {
            str = appTag.appTagId;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        pairArr[0] = TuplesKt.to("group_app_id", str);
        if (appTag != null) {
            i3 = 1;
        }
        pairArr[1] = TuplesKt.to("group_identity_situa", Integer.valueOf(i3));
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        return mapOf;
    }

    private final void M9() {
        LiveData<GetIdentityListRsp> Z1 = A9().Z1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<GetIdentityListRsp, Unit> function1 = new Function1<GetIdentityListRsp, Unit>() { // from class: com.tencent.mobileqq.troop.troopidentity.parts.TroopIdentityAppIconPart$initObserver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopIdentityAppIconPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GetIdentityListRsp getIdentityListRsp) {
                invoke2(getIdentityListRsp);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GetIdentityListRsp getIdentityListRsp) {
                Map<String, ? extends Object> L9;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) getIdentityListRsp);
                    return;
                }
                GroupIdentityAppTag W1 = TroopIdentityAppIconPart.this.A9().W1();
                if (W1 != null) {
                    TroopIdentityAppIconPart troopIdentityAppIconPart = TroopIdentityAppIconPart.this;
                    troopIdentityAppIconPart.O9(W1);
                    com.tencent.mobileqq.troop.troopidentity.util.a z95 = troopIdentityAppIconPart.z9();
                    L9 = troopIdentityAppIconPart.L9(W1);
                    z95.d("em_group_app_interact", L9);
                }
            }
        };
        Z1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.troopidentity.parts.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopIdentityAppIconPart.N9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O9(GroupIdentityAppTag iconInfo) {
        boolean z16;
        x<x.b.d, x.c.d> xVar = null;
        if (iconInfo != null) {
            String str = iconInfo.appTagId;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                if (iconInfo.status) {
                    x<x.b.d, x.c.d> xVar2 = this.appIconConfig;
                    if (xVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("appIconConfig");
                        xVar2 = null;
                    }
                    x.c.d O = xVar2.O();
                    String str2 = iconInfo.name;
                    Intrinsics.checkNotNullExpressionValue(str2, "iconInfo.name");
                    O.h(str2);
                    x<x.b.d, x.c.d> xVar3 = this.appIconConfig;
                    if (xVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("appIconConfig");
                        xVar3 = null;
                    }
                    x.c.d O2 = xVar3.O();
                    String str3 = iconInfo.icon;
                    Intrinsics.checkNotNullExpressionValue(str3, "iconInfo.icon");
                    O2.j(str3);
                } else {
                    x<x.b.d, x.c.d> xVar4 = this.appIconConfig;
                    if (xVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("appIconConfig");
                        xVar4 = null;
                    }
                    xVar4.O().h("\u672a\u4f69\u6234");
                    x<x.b.d, x.c.d> xVar5 = this.appIconConfig;
                    if (xVar5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("appIconConfig");
                        xVar5 = null;
                    }
                    xVar5.O().j("");
                }
                x<x.b.d, x.c.d> xVar6 = this.appIconConfig;
                if (xVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("appIconConfig");
                    xVar6 = null;
                }
                D9(xVar6, true);
                x<x.b.d, x.c.d> xVar7 = this.appIconConfig;
                if (xVar7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("appIconConfig");
                } else {
                    xVar = xVar7;
                }
                C9(xVar);
                return;
            }
        }
        x<x.b.d, x.c.d> xVar8 = this.appIconConfig;
        if (xVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appIconConfig");
        } else {
            xVar = xVar8;
        }
        D9(xVar, false);
    }

    @Override // com.tencent.mobileqq.troop.troopidentity.parts.TroopIdentityIconBasePart
    @NotNull
    public Group[] E9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Group[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Group[] groupArr = new Group[1];
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = new com.tencent.mobileqq.widget.listitem.a[1];
        x<x.b.d, x.c.d> xVar = this.appIconConfig;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appIconConfig");
            xVar = null;
        }
        aVarArr[0] = xVar;
        groupArr[0] = new Group(aVarArr);
        return groupArr;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        GroupIdentityAppTag groupIdentityAppTag;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        if (requestCode == 5000 && resultCode == -1 && data != null) {
            Serializable serializableExtra = data.getSerializableExtra("identity_app_icon_info");
            if (serializableExtra instanceof GroupIdentityAppTag) {
                groupIdentityAppTag = (GroupIdentityAppTag) serializableExtra;
            } else {
                groupIdentityAppTag = null;
            }
            A9().o2(groupIdentityAppTag);
            O9(A9().W1());
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
        x<x.b.d, x.c.d> xVar = new x<>(new x.b.d("\u5e94\u7528\u6807\u8bc6"), new x.c.d("", "", B9(), false, 8, null));
        xVar.p(false);
        xVar.T(TroopIdentityHonorUtil.f300410a.f());
        xVar.x(J9());
        this.appIconConfig = xVar;
        M9();
    }
}
