package com.tencent.mobileqq.troop.troopidentity.parts;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopidentity.view.c;
import com.tencent.mobileqq.troop.widget.troopmemberlevel.TroopMemberNewLevelView;
import com.tencent.mobileqq.widget.listitem.Group;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0006\u0010\n\u001a\u00020\bR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/parts/TroopIdentityTitleCustomPart;", "Lcom/tencent/mobileqq/troop/troopidentity/parts/TroopIdentityIconBasePart;", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "E9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "H9", "Lcom/tencent/mobileqq/troop/troopidentity/configs/a;", "e", "Lcom/tencent/mobileqq/troop/troopidentity/configs/a;", "titleConfig", "Lcom/tencent/mobileqq/troop/widget/troopmemberlevel/TroopMemberNewLevelView;", "f", "Lcom/tencent/mobileqq/troop/widget/troopmemberlevel/TroopMemberNewLevelView;", "memberLevelView", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopIdentityTitleCustomPart extends TroopIdentityIconBasePart {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.troop.troopidentity.configs.a<View> titleConfig;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TroopMemberNewLevelView memberLevelView;

    public TroopIdentityTitleCustomPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
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
        com.tencent.mobileqq.troop.troopidentity.configs.a<View> aVar = this.titleConfig;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleConfig");
            aVar = null;
        }
        aVarArr[0] = aVar;
        groupArr[0] = new Group(aVarArr);
        return groupArr;
    }

    public final void H9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        LiveData<com.tencent.mobileqq.troop.troopidentity.view.c> h26 = A9().h2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.troop.troopidentity.view.c, Unit> function1 = new Function1<com.tencent.mobileqq.troop.troopidentity.view.c, Unit>() { // from class: com.tencent.mobileqq.troop.troopidentity.parts.TroopIdentityTitleCustomPart$initObserver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopIdentityTitleCustomPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.troopidentity.view.c cVar) {
                invoke2(cVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.troopidentity.view.c cVar) {
                TroopMemberNewLevelView troopMemberNewLevelView;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) cVar);
                    return;
                }
                if (cVar instanceof c.C8816c) {
                    troopMemberNewLevelView = TroopIdentityTitleCustomPart.this.memberLevelView;
                    if (troopMemberNewLevelView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("memberLevelView");
                        troopMemberNewLevelView = null;
                    }
                    troopMemberNewLevelView.setTroopMemberNewLevel(((c.C8816c) cVar).a());
                }
            }
        };
        h26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.troopidentity.parts.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopIdentityTitleCustomPart.I9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        View configItemView = View.inflate(getContext(), R.layout.hzk, null);
        View findViewById = configItemView.findViewById(R.id.f102225xb);
        Intrinsics.checkNotNullExpressionValue(findViewById, "configItemView.findViewB\u2026ntity_preview_level_view)");
        this.memberLevelView = (TroopMemberNewLevelView) findViewById;
        Intrinsics.checkNotNullExpressionValue(configItemView, "configItemView");
        this.titleConfig = new com.tencent.mobileqq.troop.troopidentity.configs.a<>(configItemView);
        H9();
    }
}
