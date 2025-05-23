package com.tencent.mobileqq.troop.jointype.parts;

import android.app.Dialog;
import android.view.View;
import android.widget.CompoundButton;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\nH\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\nH\u0002J\u0012\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0015\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\"\u0010%\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\"\u0010)\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010$R\u0016\u0010,\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/troop/jointype/parts/TroopJoinTypeMemberInvitePart;", "Lcom/tencent/mobileqq/troop/jointype/parts/a;", "", "M9", "Landroid/view/View$OnClickListener;", "I9", "P9", "", "option", "X9", "", "isVisible", "T9", "isChecked", "W9", "V9", "U9", "S9", "", "L9", "O9", "R9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "C9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "e", "Lcom/tencent/mobileqq/widget/listitem/Group;", VipFunCallConstants.KEY_GROUP, "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$f;", "f", "Lcom/tencent/mobileqq/widget/listitem/x;", "inviteSwitchConfig", "Lcom/tencent/mobileqq/widget/listitem/x$b$b;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", tl.h.F, "inviteModeConfig", "i", "Z", "mIsSelectedInviteModeInNeedVerify", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "lastSelectedJoinOption", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopJoinTypeMemberInvitePart extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Group group;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> inviteSwitchConfig;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> inviteModeConfig;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mIsSelectedInviteModeInNeedVerify;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int lastSelectedJoinOption;

    public TroopJoinTypeMemberInvitePart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.group = new Group(new com.tencent.mobileqq.widget.listitem.a[0]);
            this.lastSelectedJoinOption = -1;
        }
    }

    private final View.OnClickListener I9() {
        return new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.jointype.parts.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopJoinTypeMemberInvitePart.J9(TroopJoinTypeMemberInvitePart.this, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(final TroopJoinTypeMemberInvitePart this$0, View view) {
        boolean z16;
        boolean z17;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final ActionSheet actionSheet = null;
        Dialog createDialog = ActionSheetHelper.createDialog(this$0.getContext(), null);
        if (createDialog instanceof ActionSheet) {
            actionSheet = (ActionSheet) createDialog;
        }
        if (actionSheet != null) {
            boolean z18 = true;
            if (this$0.A9().b2() == 1048576) {
                z16 = true;
            } else {
                z16 = false;
            }
            actionSheet.addRadioButton(R.string.f234557__, z16);
            if (this$0.A9().b2() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            actionSheet.addRadioButton(R.string.f234547_9, z17);
            if (this$0.A9().b2() != 67108864) {
                z18 = false;
            }
            actionSheet.addRadioButton(R.string.f234567_a, z18);
            actionSheet.addCancelButton(R.string.f2059456z);
            actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.troop.jointype.parts.k
                @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                public final void onClick(View view2, int i3) {
                    TroopJoinTypeMemberInvitePart.K9(TroopJoinTypeMemberInvitePart.this, actionSheet, view2, i3);
                }
            });
            actionSheet.show();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(TroopJoinTypeMemberInvitePart this$0, ActionSheet sheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(sheet, "$sheet");
        this$0.mIsSelectedInviteModeInNeedVerify = true;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    this$0.A9().O2(67108864L);
                }
            } else {
                this$0.A9().O2(0L);
            }
        } else {
            this$0.A9().O2(1048576L);
        }
        this$0.U9();
        sheet.dismiss();
    }

    private final String L9() {
        if (A9().c2()) {
            String string = getContext().getString(R.string.f234527_7);
            Intrinsics.checkNotNullExpressionValue(string, "{\n            context.ge\u2026mode_desc_open)\n        }");
            return string;
        }
        String string2 = getContext().getString(R.string.f234517_6);
        Intrinsics.checkNotNullExpressionValue(string2, "{\n            context.ge\u2026ode_desc_close)\n        }");
        return string2;
    }

    private final void M9() {
        String string = getContext().getString(R.string.f234627_g);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026low_member_invite_switch)");
        this.inviteSwitchConfig = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d(string), new x.c.f(A9().c2(), new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.troop.jointype.parts.i
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                TroopJoinTypeMemberInvitePart.N9(TroopJoinTypeMemberInvitePart.this, compoundButton, z16);
            }
        }));
        String string2 = getContext().getString(R.string.f234537_8);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026.troop_invite_mode_title)");
        com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.C8996b(string2, R.drawable.qui_list_symbol), new x.c.g("", false, false, 6, null));
        xVar.x(I9());
        this.inviteModeConfig = xVar;
        Integer value = A9().d2().getValue();
        if (value == null) {
            value = 0;
        }
        X9(value.intValue());
        String string3 = getContext().getString(R.string.f234797_x);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026mamage_invite_permission)");
        String L9 = L9();
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
        this.group = new Group(string3, L9, aVarArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(TroopJoinTypeMemberInvitePart this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.A9().P2(z16);
        this$0.S9();
        this$0.V9(z16);
        this$0.R9(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private final boolean O9() {
        int i3;
        if (!this.mIsSelectedInviteModeInNeedVerify && (i3 = this.lastSelectedJoinOption) != -1 && i3 != 2 && i3 != 4 && i3 != 5) {
            return true;
        }
        return false;
    }

    private final void P9() {
        LiveData<Integer> d26 = A9().d2();
        LifecycleOwner viewLifecycleOwner = getPartHost().getViewLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.troop.jointype.parts.TroopJoinTypeMemberInvitePart$registerObserver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopJoinTypeMemberInvitePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                TroopJoinTypeMemberInvitePart troopJoinTypeMemberInvitePart = TroopJoinTypeMemberInvitePart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                troopJoinTypeMemberInvitePart.X9(it.intValue());
            }
        };
        d26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.jointype.parts.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopJoinTypeMemberInvitePart.Q9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void R9(boolean isChecked) {
        String str;
        String str2;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        TroopInfo troopInfo = new TroopInfo("");
        if (isChecked) {
            str = "Clk_open";
        } else {
            str = "Clk_close";
        }
        String str3 = str;
        String str4 = troopInfo.troopuin;
        if (troopInfo.isOwner()) {
            str2 = "0";
        } else {
            str2 = "1";
        }
        ReportController.r(peekAppRuntime, "dc00899", "Grp_manage", "", "invite", str3, 0, 0, str4, str2, "", "");
    }

    private final void S9() {
        Object last;
        if (!this.group.a().isEmpty()) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) this.group.a());
            com.tencent.mobileqq.widget.listitem.a<?> aVar = (com.tencent.mobileqq.widget.listitem.a) last;
            if (aVar instanceof Group.b) {
                ((Group.b) aVar).F(L9());
                QUIListItemAdapter x95 = x9();
                if (x95 != null) {
                    x95.l0(aVar);
                }
            }
        }
    }

    private final void T9(boolean isVisible) {
        QUIListItemAdapter x95 = x9();
        if (x95 != null) {
            x95.n0(this.group, isVisible);
        }
    }

    private final void U9() {
        long b26 = A9().b2();
        com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar = null;
        if (b26 == 1048576) {
            com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar2 = this.inviteModeConfig;
            if (xVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteModeConfig");
                xVar2 = null;
            }
            x.c.g O = xVar2.O();
            String string = getContext().getString(R.string.f234557__);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026mode_without_examination)");
            O.h(string);
        } else if (b26 == 0) {
            com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar3 = this.inviteModeConfig;
            if (xVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteModeConfig");
                xVar3 = null;
            }
            x.c.g O2 = xVar3.O();
            String string2 = getContext().getString(R.string.f234547_9);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026te_mode_with_examination)");
            O2.h(string2);
        } else {
            boolean z16 = true;
            if (b26 != 33554432 && b26 != 67108864) {
                z16 = false;
            }
            if (z16) {
                com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar4 = this.inviteModeConfig;
                if (xVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inviteModeConfig");
                    xVar4 = null;
                }
                x.c.g O3 = xVar4.O();
                String string3 = getContext().getString(R.string.f234567_a);
                Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026t_review_memcount_in_100)");
                O3.h(string3);
            }
        }
        QUIListItemAdapter x95 = x9();
        if (x95 != null) {
            com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar5 = this.inviteModeConfig;
            if (xVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteModeConfig");
            } else {
                xVar = xVar5;
            }
            x95.l0(xVar);
        }
    }

    private final void V9(boolean isVisible) {
        QUIListItemAdapter x95 = x9();
        if (x95 != null) {
            com.tencent.mobileqq.widget.listitem.x<x.b.C8996b, x.c.g> xVar = this.inviteModeConfig;
            if (xVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteModeConfig");
                xVar = null;
            }
            x95.m0(xVar, isVisible);
        }
    }

    private final void W9(boolean isChecked) {
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar = this.inviteSwitchConfig;
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar2 = null;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteSwitchConfig");
            xVar = null;
        }
        xVar.O().f(isChecked);
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
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0011, code lost:
    
        if (r6 != 5) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void X9(int option) {
        if (option != 1) {
            if (option != 2) {
                if (option != 3) {
                    if (option != 4) {
                    }
                } else {
                    A9().P2(false);
                    T9(false);
                    this.mIsSelectedInviteModeInNeedVerify = false;
                }
            }
            if (O9()) {
                A9().P2(true);
                A9().O2(67108864L);
            }
            T9(true);
            W9(A9().c2());
            V9(A9().c2());
            U9();
        } else {
            A9().P2(true);
            A9().O2(67108864L);
            T9(false);
            this.mIsSelectedInviteModeInNeedVerify = false;
        }
        this.lastSelectedJoinOption = option;
        S9();
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

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        M9();
        P9();
    }
}
