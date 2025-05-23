package com.tencent.mobileqq.troop.jointype.parts;

import android.app.Dialog;
import android.view.View;
import android.widget.CompoundButton;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004R\u0016\u0010\u0019\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\"\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\"\u0010#\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001e\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/troop/jointype/parts/TroopJoinTypeRobotInvitePart;", "Lcom/tencent/mobileqq/troop/jointype/parts/a;", "", "isVisible", "", "Q9", "", "option", "T9", "N9", "Landroid/view/View$OnClickListener;", "I9", "S9", "R9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "C9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "L9", "O9", "e", "Lcom/tencent/mobileqq/widget/listitem/Group;", VipFunCallConstants.KEY_GROUP, "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$f;", "f", "Lcom/tencent/mobileqq/widget/listitem/x;", "inviteSwitchConfig", "Lcom/tencent/mobileqq/widget/listitem/x$b$b;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", tl.h.F, "inviteModeConfig", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopJoinTypeRobotInvitePart extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Group group;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> inviteSwitchConfig;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> inviteModeConfig;

    public TroopJoinTypeRobotInvitePart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.group = new Group(new com.tencent.mobileqq.widget.listitem.a[0]);
        }
    }

    private final View.OnClickListener I9() {
        return new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.jointype.parts.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopJoinTypeRobotInvitePart.J9(TroopJoinTypeRobotInvitePart.this, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(final TroopJoinTypeRobotInvitePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final ActionSheet actionSheet = null;
        Dialog createDialog = ActionSheetHelper.createDialog(this$0.getContext(), null);
        if (createDialog instanceof ActionSheet) {
            actionSheet = (ActionSheet) createDialog;
        }
        if (actionSheet != null) {
            actionSheet.addRadioButton(R.string.f234557__, this$0.A9().f2());
            actionSheet.addRadioButton(R.string.f234547_9, !this$0.A9().f2());
            actionSheet.addCancelButton(R.string.f2059456z);
            actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.troop.jointype.parts.o
                @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                public final void onClick(View view2, int i3) {
                    TroopJoinTypeRobotInvitePart.K9(TroopJoinTypeRobotInvitePart.this, actionSheet, view2, i3);
                }
            });
            actionSheet.show();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(TroopJoinTypeRobotInvitePart this$0, ActionSheet sheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(sheet, "$sheet");
        if (i3 != 0) {
            if (i3 == 1) {
                this$0.A9().R2(false);
            }
        } else {
            this$0.A9().R2(true);
        }
        this$0.R9();
        sheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(TroopJoinTypeRobotInvitePart this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.A9().S2(z16);
        this$0.R9();
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private final boolean N9() {
        return A9().s2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Q9(boolean isVisible) {
        QUIListItemAdapter x95 = x9();
        if (x95 != null) {
            x95.n0(this.group, isVisible);
        }
    }

    private final void R9() {
        String string;
        com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar = this.inviteModeConfig;
        com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar2 = null;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteModeConfig");
            xVar = null;
        }
        x.c.g O = xVar.O();
        if (A9().f2()) {
            string = getContext().getString(R.string.f234557__);
            Intrinsics.checkNotNullExpressionValue(string, "{\n            context.ge\u2026ut_examination)\n        }");
        } else {
            string = getContext().getString(R.string.f234547_9);
            Intrinsics.checkNotNullExpressionValue(string, "{\n            context.ge\u2026th_examination)\n        }");
        }
        O.h(string);
        QUIListItemAdapter x95 = x9();
        if (x95 != null) {
            com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar3 = this.inviteModeConfig;
            if (xVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteModeConfig");
                xVar3 = null;
            }
            x95.l0(xVar3);
        }
        QUIListItemAdapter x96 = x9();
        if (x96 != null) {
            com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar4 = this.inviteModeConfig;
            if (xVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteModeConfig");
            } else {
                xVar2 = xVar4;
            }
            x96.m0(xVar2, A9().g2());
        }
    }

    private final void S9() {
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar = this.inviteSwitchConfig;
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar2 = null;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteSwitchConfig");
            xVar = null;
        }
        xVar.O().f(A9().g2());
        QUIListItemAdapter x95 = x9();
        if (x95 != null) {
            com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar3 = this.inviteSwitchConfig;
            if (xVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteSwitchConfig");
            } else {
                xVar2 = xVar3;
            }
            x95.l0(xVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T9(int option) {
        if (option != 1) {
            if (option != 2) {
                if (option != 3) {
                    if (option != 4 && option != 5) {
                        return;
                    }
                }
            }
            if (N9()) {
                Q9(false);
                return;
            } else {
                if (!N9() && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101745", false)) {
                    Q9(true);
                    S9();
                    R9();
                    return;
                }
                return;
            }
        }
        Q9(false);
    }

    @Override // com.tencent.mobileqq.troop.jointype.parts.a
    @NotNull
    public Group[] C9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Group[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new Group[]{this.group};
    }

    public final void L9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        String string = getContext().getString(R.string.f234587_c);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026roop_invite_robot_switch)");
        this.inviteSwitchConfig = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d(string), new x.c.f(A9().g2(), new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.troop.jointype.parts.m
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                TroopJoinTypeRobotInvitePart.M9(TroopJoinTypeRobotInvitePart.this, compoundButton, z16);
            }
        }));
        String string2 = getContext().getString(R.string.f234577_b);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026invite_robot_examination)");
        com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.C8996b(string2, R.drawable.qui_list_symbol), new x.c.g("", false, false, 6, null));
        xVar.x(I9());
        this.inviteModeConfig = xVar;
        T9(A9().h2());
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = new com.tencent.mobileqq.widget.listitem.a[2];
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar2 = this.inviteSwitchConfig;
        com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar3 = null;
        if (xVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteSwitchConfig");
            xVar2 = null;
        }
        aVarArr[0] = xVar2;
        com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar4 = this.inviteModeConfig;
        if (xVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteModeConfig");
        } else {
            xVar3 = xVar4;
        }
        aVarArr[1] = xVar3;
        this.group = new Group(aVarArr);
    }

    public final void O9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        LiveData<Integer> d26 = A9().d2();
        LifecycleOwner viewLifecycleOwner = getPartHost().getViewLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.troop.jointype.parts.TroopJoinTypeRobotInvitePart$registerObserver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopJoinTypeRobotInvitePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                TroopJoinTypeRobotInvitePart troopJoinTypeRobotInvitePart = TroopJoinTypeRobotInvitePart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                troopJoinTypeRobotInvitePart.T9(it.intValue());
            }
        };
        d26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.jointype.parts.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopJoinTypeRobotInvitePart.P9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        L9();
        O9();
    }
}
