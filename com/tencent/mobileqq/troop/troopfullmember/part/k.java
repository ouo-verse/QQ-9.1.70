package com.tencent.mobileqq.troop.troopfullmember.part;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import androidx.lifecycle.ViewModel;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopTrpcHandlerService;
import com.tencent.mobileqq.troop.api.TroopTrpcRemoteResponse;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.trpcprotocol.TroopJoinQunAutoSwitch$SetAutoCreateGroupSwitchReq;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 22\u00020\u0001:\u00013B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\u0012\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R,\u0010'\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030#0\"j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030#`$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R&\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u00170\"j\b\u0012\u0004\u0012\u00020\u0017`$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010&R\"\u0010/\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/troop/troopfullmember/part/k;", "Lcom/tencent/mobileqq/troop/troopfullmember/part/a;", "", "S9", "", "isChecked", "R9", "Z9", "U9", "L9", "aa", "", "troopUin", "ba", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "A9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "d", "Ljava/lang/String;", "Q9", "()Ljava/lang/String;", "Lcom/tencent/mobileqq/troop/troopfullmember/c;", "e", "Lcom/tencent/mobileqq/troop/troopfullmember/c;", "viewModel", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/widget/listitem/a;", "Lkotlin/collections/ArrayList;", "f", "Ljava/util/ArrayList;", "configList", tl.h.F, "groups", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$f;", "i", "Lcom/tencent/mobileqq/widget/listitem/x;", "troopFullSwitchConfig", "<init>", "(Ljava/lang/String;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class k extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.troop.troopfullmember.c viewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<com.tencent.mobileqq.widget.listitem.a<?>> configList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<Group> groups;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private x<x.b.d, x.c.f> troopFullSwitchConfig;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/troop/troopfullmember/part/k$a;", "", "", "CLOSE_SWITCH", "I", "", "CMD_METHOD_SET_AUTO_CREATE_GROUPS_SWITCH", "Ljava/lang/String;", "CMD_SERVICE_JOIN_QUN_AUTO_SWITCH", "FROM_TROOPINFO", "KEY_AFTER_CLICK_STATE", "OPEN_SWITCH", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopfullmember.part.k$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/troopfullmember/part/k$b", "Lcom/tencent/mobileqq/troop/api/f;", "Lcom/tencent/mobileqq/troop/api/TroopTrpcRemoteResponse;", "successResponse", "", "b", "errorResponse", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements com.tencent.mobileqq.troop.api.f {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f300203b;

        b(boolean z16) {
            this.f300203b = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, k.this, Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void a(@NotNull TroopTrpcRemoteResponse errorResponse) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) errorResponse);
                return;
            }
            Intrinsics.checkNotNullParameter(errorResponse, "errorResponse");
            String Q9 = k.this.Q9();
            int i3 = errorResponse.code;
            String str = errorResponse.f293941msg;
            if (str == null) {
                str = "";
            }
            QLog.e("TroopInfoPart", 1, "onError: " + Q9 + " set switch err code:" + i3 + " msg:" + str);
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void b(@NotNull TroopTrpcRemoteResponse successResponse) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) successResponse);
                return;
            }
            Intrinsics.checkNotNullParameter(successResponse, "successResponse");
            k kVar = k.this;
            kVar.ba(kVar.Q9(), this.f300203b);
            QLog.d("TroopInfoPart", 1, "onSuccess");
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57541);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public k(@NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopUin);
            return;
        }
        this.troopUin = troopUin;
        this.configList = new ArrayList<>();
        this.groups = new ArrayList<>();
    }

    private final void L9() {
        DialogUtil.createCustomDialog((Activity) getContext(), 230, HardCodeUtil.qqStr(R.string.f2332076m), HardCodeUtil.qqStr(R.string.f2331976l), HardCodeUtil.qqStr(R.string.f2059456z), HardCodeUtil.qqStr(R.string.f20595570), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopfullmember.part.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                k.M9(k.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopfullmember.part.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                k.O9(k.this, dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(final k this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialogInterface.dismiss();
        this$0.aa(false);
        x<x.b.d, x.c.f> xVar = this$0.troopFullSwitchConfig;
        x<x.b.d, x.c.f> xVar2 = null;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopFullSwitchConfig");
            xVar = null;
        }
        xVar.O().h(null);
        x<x.b.d, x.c.f> xVar3 = this$0.troopFullSwitchConfig;
        if (xVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopFullSwitchConfig");
            xVar3 = null;
        }
        xVar3.O().f(false);
        x<x.b.d, x.c.f> xVar4 = this$0.troopFullSwitchConfig;
        if (xVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopFullSwitchConfig");
        } else {
            xVar2 = xVar4;
        }
        xVar2.O().h(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.troop.troopfullmember.part.h
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                k.N9(k.this, compoundButton, z16);
            }
        });
        this$0.Z9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(k this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.R9(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(final k this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialogInterface.dismiss();
        x<x.b.d, x.c.f> xVar = this$0.troopFullSwitchConfig;
        x<x.b.d, x.c.f> xVar2 = null;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopFullSwitchConfig");
            xVar = null;
        }
        xVar.O().h(null);
        x<x.b.d, x.c.f> xVar3 = this$0.troopFullSwitchConfig;
        if (xVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopFullSwitchConfig");
            xVar3 = null;
        }
        xVar3.O().f(true);
        x<x.b.d, x.c.f> xVar4 = this$0.troopFullSwitchConfig;
        if (xVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopFullSwitchConfig");
            xVar4 = null;
        }
        xVar4.O().h(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.troop.troopfullmember.part.g
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                k.P9(k.this, compoundButton, z16);
            }
        });
        QUIListItemAdapter x95 = this$0.x9();
        Intrinsics.checkNotNull(x95);
        x<x.b.d, x.c.f> xVar5 = this$0.troopFullSwitchConfig;
        if (xVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopFullSwitchConfig");
        } else {
            xVar2 = xVar5;
        }
        x95.l0(xVar2);
        this$0.Z9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(k this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.R9(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private final void R9(boolean isChecked) {
        if (isChecked) {
            U9();
        } else {
            L9();
        }
    }

    private final void S9() {
        String str;
        com.tencent.mobileqq.troop.troopfullmember.c cVar = this.viewModel;
        com.tencent.mobileqq.troop.troopfullmember.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar = null;
        }
        boolean z16 = true;
        QLog.d("TroopInfoPart", 1, "fullGroupExpansionSwitch: " + cVar.O1().groupExt.fullGroupExpansionSwitch);
        ArrayList<com.tencent.mobileqq.widget.listitem.a<?>> arrayList = this.configList;
        arrayList.add(new com.tencent.mobileqq.troop.troopfullmember.config.e(0, 0));
        String str2 = this.troopUin;
        com.tencent.mobileqq.troop.troopfullmember.c cVar3 = this.viewModel;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar3 = null;
        }
        String newTroopNameOrTroopName = cVar3.O1().getNewTroopNameOrTroopName();
        if (newTroopNameOrTroopName == null) {
            str = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(newTroopNameOrTroopName, "viewModel.troopInfo.newTroopNameOrTroopName?:\"\"");
            str = newTroopNameOrTroopName;
        }
        com.tencent.mobileqq.troop.troopfullmember.c cVar4 = this.viewModel;
        if (cVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar4 = null;
        }
        int i3 = cVar4.O1().wMemberNum;
        com.tencent.mobileqq.troop.troopfullmember.c cVar5 = this.viewModel;
        if (cVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar5 = null;
        }
        arrayList.add(new com.tencent.mobileqq.troop.troopfullmember.config.d(str2, str, i3, cVar5.O1().wMemberMax, false, null));
        String qqStr = HardCodeUtil.qqStr(R.string.f2331876k);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.troop_ful\u2026ember_change_auto_change)");
        x.b.d dVar = new x.b.d(qqStr);
        com.tencent.mobileqq.troop.troopfullmember.c cVar6 = this.viewModel;
        if (cVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            cVar2 = cVar6;
        }
        if (cVar2.O1().groupExt.fullGroupExpansionSwitch != 1) {
            z16 = false;
        }
        x<x.b.d, x.c.f> xVar = new x<>(dVar, new x.c.f(z16, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.troop.troopfullmember.part.b
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z17) {
                k.T9(k.this, compoundButton, z17);
            }
        }));
        this.troopFullSwitchConfig = xVar;
        arrayList.add(xVar);
        ArrayList<Group> arrayList2 = this.groups;
        String qqStr2 = HardCodeUtil.qqStr(R.string.f2332676s);
        Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.troop_full_member_change_sub_group)");
        Object[] array = this.configList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        arrayList2.add(new Group("", qqStr2, (com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(k this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.R9(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private final void U9() {
        DialogUtil.createCustomDialog((Activity) getContext(), 230, HardCodeUtil.qqStr(R.string.f2332576r), HardCodeUtil.qqStr(R.string.f2332476q), HardCodeUtil.qqStr(R.string.f2059456z), HardCodeUtil.qqStr(R.string.f2332376p), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopfullmember.part.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                k.V9(k.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopfullmember.part.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                k.X9(k.this, dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(final k this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialogInterface.dismiss();
        this$0.aa(true);
        x<x.b.d, x.c.f> xVar = this$0.troopFullSwitchConfig;
        x<x.b.d, x.c.f> xVar2 = null;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopFullSwitchConfig");
            xVar = null;
        }
        xVar.O().h(null);
        x<x.b.d, x.c.f> xVar3 = this$0.troopFullSwitchConfig;
        if (xVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopFullSwitchConfig");
            xVar3 = null;
        }
        xVar3.O().f(true);
        x<x.b.d, x.c.f> xVar4 = this$0.troopFullSwitchConfig;
        if (xVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopFullSwitchConfig");
        } else {
            xVar2 = xVar4;
        }
        xVar2.O().h(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.troop.troopfullmember.part.j
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                k.W9(k.this, compoundButton, z16);
            }
        });
        this$0.Z9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(k this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.R9(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(final k this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialogInterface.dismiss();
        x<x.b.d, x.c.f> xVar = this$0.troopFullSwitchConfig;
        x<x.b.d, x.c.f> xVar2 = null;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopFullSwitchConfig");
            xVar = null;
        }
        xVar.O().h(null);
        x<x.b.d, x.c.f> xVar3 = this$0.troopFullSwitchConfig;
        if (xVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopFullSwitchConfig");
            xVar3 = null;
        }
        xVar3.O().f(false);
        x<x.b.d, x.c.f> xVar4 = this$0.troopFullSwitchConfig;
        if (xVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopFullSwitchConfig");
            xVar4 = null;
        }
        xVar4.O().h(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.troop.troopfullmember.part.i
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                k.Y9(k.this, compoundButton, z16);
            }
        });
        QUIListItemAdapter x95 = this$0.x9();
        Intrinsics.checkNotNull(x95);
        x<x.b.d, x.c.f> xVar5 = this$0.troopFullSwitchConfig;
        if (xVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopFullSwitchConfig");
        } else {
            xVar2 = xVar5;
        }
        x95.l0(xVar2);
        this$0.Z9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(k this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.R9(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private final void Z9() {
        int i3;
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", "pg_group_full_swap");
        hashMap.put("pgid", "pg_group_full_swap");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("cur_pg", hashMap);
        hashMap2.put("dt_eid", "em_group_full_create_switch");
        hashMap2.put("eid", "em_group_full_create_switch");
        x<x.b.d, x.c.f> xVar = this.troopFullSwitchConfig;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopFullSwitchConfig");
            xVar = null;
        }
        if (xVar.O().getIsChecked()) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        hashMap2.put("after_click_state", Integer.valueOf(i3));
        VideoReport.reportEvent("dt_clck", hashMap2);
    }

    private final void aa(boolean isChecked) {
        int i3;
        TroopJoinQunAutoSwitch$SetAutoCreateGroupSwitchReq troopJoinQunAutoSwitch$SetAutoCreateGroupSwitchReq = new TroopJoinQunAutoSwitch$SetAutoCreateGroupSwitchReq();
        troopJoinQunAutoSwitch$SetAutoCreateGroupSwitchReq.group_id.set(Long.parseLong(this.troopUin));
        PBUInt32Field pBUInt32Field = troopJoinQunAutoSwitch$SetAutoCreateGroupSwitchReq.switch_value;
        if (isChecked) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        pBUInt32Field.set(i3);
        ((ITroopTrpcHandlerService) QRoute.api(ITroopTrpcHandlerService.class)).sendRequest("trpc.iqun.join_qun_auto_switch.JoinQunAutoSwitch", "/trpc.iqun.join_qun_auto_switch.JoinQunAutoSwitch/SetAutoCreateGroupSwitch", troopJoinQunAutoSwitch$SetAutoCreateGroupSwitchReq.toByteArray(), 1, null, new b(isChecked));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ba(String troopUin, boolean isChecked) {
        int i3;
        if (isChecked) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        com.tencent.mobileqq.troop.troopfullmember.c cVar = this.viewModel;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar = null;
        }
        cVar.O1().groupExt.fullGroupExpansionSwitch = i3;
        ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).updateFullGroupExpansionSwitch(troopUin, i3);
    }

    @Override // com.tencent.mobileqq.troop.troopfullmember.part.a
    @NotNull
    public Group[] A9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Group[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        Object[] array = this.groups.toArray(new Group[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (Group[]) array;
    }

    @NotNull
    public final String Q9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.troopUin;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) rootView);
        } else {
            super.onInitView(rootView);
            S9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        ViewModel viewModel = getViewModel(com.tencent.mobileqq.troop.troopfullmember.c.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(TroopFullMe\u2026ngeViewModel::class.java)");
        this.viewModel = (com.tencent.mobileqq.troop.troopfullmember.c) viewModel;
    }
}
