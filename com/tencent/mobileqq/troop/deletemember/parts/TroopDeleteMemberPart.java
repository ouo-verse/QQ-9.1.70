package com.tencent.mobileqq.troop.deletemember.parts;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.q;
import com.tencent.mobileqq.troop.deletemember.event.TroopDeleteMemberEvent;
import com.tencent.mobileqq.troop.troopsetting.part.i;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.troop.ITroopMemberOperationRepoApi;
import com.tencent.qqnt.troop.TroopInfoRepo;
import com.tencent.state.data.SquareJSConst;
import com.tencent.util.LoadingUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 P2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001QB\u0007\u00a2\u0006\u0004\bN\u0010OJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0016\u0010\u000e\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\bH\u0002J\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\bH\u0002J&\u0010\u0015\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J>\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\bH\u0002J$\u0010\u001f\u001a\u00020\u00062\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\bH\u0002J\u0018\u0010\"\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u0016H\u0002J\u0016\u0010#\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\bH\u0002J\u001c\u0010(\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010*\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J\u0012\u0010,\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010.\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030-0\u001aj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030-`\u001cH\u0016R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R#\u0010<\u001a\n 7*\u0004\u0018\u00010\u00130\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R$\u0010?\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u001b\u0010B\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u00109\u001a\u0004\bA\u0010;R\u001b\u0010G\u001a\u00020C8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bD\u00109\u001a\u0004\bE\u0010FR\u001b\u0010\u0012\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bH\u00109\u001a\u0004\bI\u0010JR\u001b\u0010M\u001a\u00020C8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bK\u00109\u001a\u0004\bL\u0010F\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/troop/deletemember/parts/TroopDeleteMemberPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "K9", "", "Lcom/tencent/mobileqq/troop/selectmember/bean/c;", "list", "T9", "Lcom/tencent/mobileqq/troop/deletemember/inject/items/a;", "deleteMembers", "V9", "", "R9", "Landroid/widget/CheckBox;", "checkBox", "Landroid/app/Dialog;", "dialog", "H9", "", "isSuc", "", "code", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", SquareJSConst.Params.PARAMS_UIN_LIST, "S9", "G9", "btnType", "isChecked", "L9", "U9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onInitView", "onPartDestroy", "event", "onReceiveEvent", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/mobileqq/troop/deletemember/a;", "d", "Lcom/tencent/mobileqq/troop/deletemember/a;", "viewModel", "Lcom/tencent/mobileqq/troop/selectmember/vm/a;", "e", "Lcom/tencent/mobileqq/troop/selectmember/vm/a;", "vmOperator", "kotlin.jvm.PlatformType", "f", "Lkotlin/Lazy;", "P9", "()Landroid/app/Dialog;", "progressDialog", h.F, "Ljava/util/ArrayList;", "allDelMemberUinList", "i", "N9", "deleteDialog", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Q9", "()Landroid/widget/TextView;", "rightBtn", BdhLogUtil.LogTag.Tag_Conn, "M9", "()Landroid/widget/CheckBox;", "D", "O9", "dialogText", "<init>", "()V", "E", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopDeleteMemberPart extends Part implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy checkBox;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy dialogText;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.troop.deletemember.a viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.troop.selectmember.vm.a vmOperator;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy progressDialog;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<String> allDelMemberUinList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy deleteDialog;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy rightBtn;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/deletemember/parts/TroopDeleteMemberPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.deletemember.parts.TroopDeleteMemberPart$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31347);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopDeleteMemberPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<Dialog>() { // from class: com.tencent.mobileqq.troop.deletemember.parts.TroopDeleteMemberPart$progressDialog$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopDeleteMemberPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Dialog invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? LoadingUtil.showLoadingDialog(TroopDeleteMemberPart.this.getActivity(), HardCodeUtil.qqStr(R.string.f170846at4), true) : (Dialog) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.progressDialog = lazy;
            this.allDelMemberUinList = new ArrayList<>();
            lazy2 = LazyKt__LazyJVMKt.lazy(new TroopDeleteMemberPart$deleteDialog$2(this));
            this.deleteDialog = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.troop.deletemember.parts.TroopDeleteMemberPart$rightBtn$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopDeleteMemberPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TextView invoke() {
                    Dialog N9;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (TextView) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    N9 = TroopDeleteMemberPart.this.N9();
                    TextView textView = (TextView) N9.findViewById(R.id.dialogRightBtn);
                    textView.setText(R.string.f171151ok);
                    return textView;
                }
            });
            this.rightBtn = lazy3;
            lazy4 = LazyKt__LazyJVMKt.lazy(new TroopDeleteMemberPart$checkBox$2(this));
            this.checkBox = lazy4;
            lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.troop.deletemember.parts.TroopDeleteMemberPart$dialogText$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopDeleteMemberPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TextView invoke() {
                    Dialog N9;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (TextView) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    N9 = TroopDeleteMemberPart.this.N9();
                    TextView textView = (TextView) N9.findViewById(R.id.dialogText);
                    if (textView.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                        layoutParams2.addRule(14);
                        textView.setLayoutParams(layoutParams2);
                    }
                    return textView;
                }
            });
            this.dialogText = lazy5;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void G9(List<String> uinList, List<com.tencent.mobileqq.troop.deletemember.inject.items.a> deleteMembers) {
        Intent intent = new Intent();
        this.allDelMemberUinList.addAll(uinList);
        intent.putStringArrayListExtra(SquareJSConst.Params.PARAMS_UIN_LIST, this.allDelMemberUinList);
        getActivity().setResult(-1, intent);
        com.tencent.mobileqq.troop.selectmember.vm.a aVar = this.vmOperator;
        if (aVar != null) {
            aVar.A0(deleteMembers);
        }
    }

    private final void H9(final List<com.tencent.mobileqq.troop.deletemember.inject.items.a> deleteMembers, CheckBox checkBox, Dialog dialog) {
        com.tencent.qqnt.bean.b bVar = new com.tencent.qqnt.bean.b();
        com.tencent.mobileqq.troop.deletemember.a aVar = this.viewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            aVar = null;
        }
        bVar.troopUin = aVar.N1();
        bVar.isBlack = checkBox.isChecked();
        bVar.d(R9(deleteMembers));
        ((ITroopMemberOperationRepoApi) QRoute.api(ITroopMemberOperationRepoApi.class)).deleteTroopMember(bVar, i.a(this), "TroopDeleteMemberPart", new com.tencent.qqnt.troop.c() { // from class: com.tencent.mobileqq.troop.deletemember.parts.c
            @Override // com.tencent.qqnt.troop.c
            public final void a(boolean z16, int i3, ArrayList arrayList) {
                TroopDeleteMemberPart.I9(TroopDeleteMemberPart.this, deleteMembers, z16, i3, arrayList);
            }
        });
        try {
            P9().show();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
        U9(deleteMembers);
        L9(1, checkBox.isChecked());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(final TroopDeleteMemberPart this$0, final List deleteMembers, final boolean z16, final int i3, final ArrayList deleteUins) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(deleteMembers, "$deleteMembers");
        Intrinsics.checkNotNullParameter(deleteUins, "deleteUins");
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.troop.deletemember.parts.d
            @Override // java.lang.Runnable
            public final void run() {
                TroopDeleteMemberPart.J9(TroopDeleteMemberPart.this, z16, i3, deleteUins, deleteMembers);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(TroopDeleteMemberPart this$0, boolean z16, int i3, ArrayList deleteUins, List deleteMembers) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(deleteUins, "$deleteUins");
        Intrinsics.checkNotNullParameter(deleteMembers, "$deleteMembers");
        this$0.S9(z16, i3, deleteUins, deleteMembers);
    }

    private final void K9(View rootView) {
        VideoReport.setPageId(rootView, "pg_group_batch_manage_members");
        com.tencent.mobileqq.troop.deletemember.a aVar = this.viewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            aVar = null;
        }
        VideoReport.setPageParams(rootView, new PageParams((Map<String, ?>) aVar.L1()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9(int btnType, boolean isChecked) {
        com.tencent.mobileqq.troop.deletemember.a aVar = this.viewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            aVar = null;
        }
        Map<String, Object> L1 = aVar.L1();
        L1.put("btn_type", Integer.valueOf(btnType));
        L1.put("is_check_not_accepting_anymore", Integer.valueOf(isChecked ? 1 : 0));
        VideoReport.reportEvent("ev_group_confirm_pop_clck", L1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CheckBox M9() {
        Object value = this.checkBox.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-checkBox>(...)");
        return (CheckBox) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Dialog N9() {
        return (Dialog) this.deleteDialog.getValue();
    }

    private final TextView O9() {
        Object value = this.dialogText.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-dialogText>(...)");
        return (TextView) value;
    }

    private final Dialog P9() {
        return (Dialog) this.progressDialog.getValue();
    }

    private final TextView Q9() {
        Object value = this.rightBtn.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-rightBtn>(...)");
        return (TextView) value;
    }

    private final List<Long> R9(List<com.tencent.mobileqq.troop.deletemember.inject.items.a> deleteMembers) {
        int collectionSizeOrDefault;
        boolean z16;
        List<com.tencent.mobileqq.troop.deletemember.inject.items.a> list = deleteMembers;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            String e16 = ((com.tencent.mobileqq.troop.deletemember.inject.items.a) it.next()).e();
            Intrinsics.checkNotNullExpressionValue(e16, "it.getSelectKey()");
            arrayList.add(Long.valueOf(Long.parseLong(e16)));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((Number) obj).longValue() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    private final void S9(boolean isSuc, int code, ArrayList<String> uinList, List<com.tencent.mobileqq.troop.deletemember.inject.items.a> deleteMembers) {
        QLog.i("TroopDeleteMemberPart", 1, "[handleDeleteTroopMember] isSuc:" + isSuc + ", code:" + code + ", size:" + uinList.size());
        if (P9().isShowing()) {
            P9().dismiss();
        }
        if (isSuc) {
            Activity activity = getActivity();
            String qqStr = HardCodeUtil.qqStr(R.string.ajw);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(com.tencent.mobile\u2026del_troop_member_success)");
            com.tencent.qqnt.e.k(activity, 0, qqStr, 0, null, 26, null);
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102362", true)) {
                G9(uinList, deleteMembers);
                return;
            }
            Intent intent = new Intent();
            intent.putStringArrayListExtra(SquareJSConst.Params.PARAMS_UIN_LIST, uinList);
            getActivity().setResult(-1, intent);
            getActivity().onBackPressed();
            return;
        }
        Activity activity2 = getActivity();
        String qqStr2 = HardCodeUtil.qqStr(R.string.ajv);
        Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(com.tencent.mobile\u2026ng.del_troop_member_fail)");
        com.tencent.qqnt.e.k(activity2, 0, qqStr2, 0, null, 26, null);
    }

    private final void T9(List<? extends com.tencent.mobileqq.troop.selectmember.bean.c> list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof com.tencent.mobileqq.troop.deletemember.inject.items.a) {
                arrayList.add(obj);
            }
        }
        V9(arrayList);
        q d16 = new q(bg.e()).i("dc00899").a("Grp_mber").f("del_mber").d("del_confirm");
        com.tencent.mobileqq.troop.deletemember.a aVar = this.viewModel;
        com.tencent.mobileqq.troop.deletemember.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            aVar = null;
        }
        q c16 = d16.c(aVar.M1());
        String[] strArr = new String[1];
        com.tencent.mobileqq.troop.deletemember.a aVar3 = this.viewModel;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            aVar2 = aVar3;
        }
        strArr[0] = aVar2.N1();
        c16.b(strArr).g();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void U9(List<com.tencent.mobileqq.troop.deletemember.inject.items.a> deleteMembers) {
        String str;
        int i3;
        com.tencent.mobileqq.troop.deletemember.a aVar;
        com.tencent.mobileqq.troop.deletemember.a aVar2;
        int size = deleteMembers.size();
        StringBuffer stringBuffer = new StringBuffer();
        HashSet hashSet = new HashSet();
        Iterator<T> it = deleteMembers.iterator();
        while (it.hasNext()) {
            hashSet.add(((com.tencent.mobileqq.troop.deletemember.inject.items.a) it.next()).i());
        }
        Iterator it5 = hashSet.iterator();
        while (true) {
            boolean z16 = false;
            if (!it5.hasNext()) {
                break;
            }
            com.tencent.mobileqq.troop.deletemember.inject.items.b bVar = (com.tencent.mobileqq.troop.deletemember.inject.items.b) it5.next();
            if (stringBuffer.length() == 0) {
                z16 = true;
            }
            if (z16) {
                stringBuffer.append(bVar.getItemData());
            } else {
                stringBuffer.append("-");
                stringBuffer.append(bVar.getItemData());
            }
        }
        AppInterface e16 = bg.e();
        com.tencent.mobileqq.troop.deletemember.a aVar3 = null;
        if (e16 != null) {
            str = e16.getCurrentUin();
        } else {
            str = null;
        }
        TroopInfoRepo troopInfoRepo = TroopInfoRepo.INSTANCE;
        com.tencent.mobileqq.troop.deletemember.a aVar4 = this.viewModel;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            aVar4 = null;
        }
        TroopInfo troopInfoFromCache = troopInfoRepo.getTroopInfoFromCache(aVar4.N1());
        if (troopInfoFromCache != null) {
            if (troopInfoFromCache.isTroopAdmin(str)) {
                i3 = 1;
            } else if (troopInfoFromCache.isTroopOwner(str)) {
                i3 = 2;
            }
            q d16 = new q(e16).i("dc00899").a("Grp_mber").f("del_mber").d("confirm_ver");
            aVar = this.viewModel;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                aVar = null;
            }
            q c16 = d16.c(aVar.M1());
            String[] strArr = new String[4];
            aVar2 = this.viewModel;
            if (aVar2 != null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                aVar3 = aVar2;
            }
            strArr[0] = aVar3.N1();
            strArr[1] = String.valueOf(size);
            strArr[2] = stringBuffer.toString();
            strArr[3] = String.valueOf(i3);
            c16.b(strArr).g();
        }
        i3 = 3;
        q d162 = new q(e16).i("dc00899").a("Grp_mber").f("del_mber").d("confirm_ver");
        aVar = this.viewModel;
        if (aVar == null) {
        }
        q c162 = d162.c(aVar.M1());
        String[] strArr2 = new String[4];
        aVar2 = this.viewModel;
        if (aVar2 != null) {
        }
        strArr2[0] = aVar3.N1();
        strArr2[1] = String.valueOf(size);
        strArr2[2] = stringBuffer.toString();
        strArr2[3] = String.valueOf(i3);
        c162.b(strArr2).g();
    }

    private final void V9(final List<com.tencent.mobileqq.troop.deletemember.inject.items.a> deleteMembers) {
        String str;
        boolean z16;
        com.tencent.mobileqq.troop.deletemember.a aVar = this.viewModel;
        com.tencent.mobileqq.troop.deletemember.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            aVar = null;
        }
        final String N1 = aVar.N1();
        com.tencent.mobileqq.troop.deletemember.a aVar3 = this.viewModel;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            aVar3 = null;
        }
        final int M1 = aVar3.M1();
        TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(N1);
        if (troopInfoFromCache == null) {
            Activity activity = getActivity();
            if (activity != null) {
                activity.onBackPressed();
                return;
            }
            return;
        }
        final AppInterface e16 = bg.e();
        if (e16 != null) {
            str = e16.getCurrentUin();
        } else {
            str = null;
        }
        if (!troopInfoFromCache.isTroopAdmin(str) && !troopInfoFromCache.isTroopOwner(str) && troopInfoFromCache.allowMemberKick == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        O9().setVisibility(8);
        M9().setText(HardCodeUtil.qqStr(R.string.h0e));
        if (z16) {
            M9().setVisibility(8);
        }
        M9().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.deletemember.parts.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopDeleteMemberPart.W9(TroopDeleteMemberPart.this, e16, M1, N1, view);
            }
        });
        Q9().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.deletemember.parts.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopDeleteMemberPart.X9(TroopDeleteMemberPart.this, deleteMembers, view);
            }
        });
        N9().show();
        new q(e16).i("dc00899").a("Grp_mber").f("del_mber").d("confirm_exp").c(M1).b(N1).g();
        com.tencent.mobileqq.troop.deletemember.a aVar4 = this.viewModel;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            aVar2 = aVar4;
        }
        VideoReport.reportEvent("ev_group_confirm_pop_imp", aVar2.L1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(TroopDeleteMemberPart this$0, AppInterface appInterface, int i3, String troopUin, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        if (this$0.M9().isChecked()) {
            new q(appInterface).i("dc00899").a("Grp_mber").f("del_mber").d("confirm_nomore").c(i3).b(troopUin).g();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(TroopDeleteMemberPart this$0, List deleteMembers, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(deleteMembers, "$deleteMembers");
        this$0.H9(deleteMembers, this$0.M9(), this$0.N9());
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(TroopDeleteMemberEvent.ClickBackEvent.class);
        arrayList.add(TroopDeleteMemberEvent.ClickRemoveEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        K9(rootView);
        VideoReport.reportPgIn(rootView);
        q d16 = new q(bg.e()).i("dc00899").a("Grp_mber").f("del_mber").d("exp");
        com.tencent.mobileqq.troop.deletemember.a aVar = this.viewModel;
        com.tencent.mobileqq.troop.deletemember.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            aVar = null;
        }
        q c16 = d16.c(aVar.M1());
        String[] strArr = new String[1];
        com.tencent.mobileqq.troop.deletemember.a aVar3 = this.viewModel;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            aVar2 = aVar3;
        }
        strArr[0] = aVar2.N1();
        c16.b(strArr).g();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        ViewModel viewModel = getViewModel(com.tencent.mobileqq.troop.deletemember.a.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(TroopDeleteMemberVM::class.java)");
        this.viewModel = (com.tencent.mobileqq.troop.deletemember.a) viewModel;
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        VideoReport.reportPgOut(getPartRootView());
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) event);
            return;
        }
        if (event instanceof TroopDeleteMemberEvent.ClickRemoveEvent) {
            TroopDeleteMemberEvent.ClickRemoveEvent clickRemoveEvent = (TroopDeleteMemberEvent.ClickRemoveEvent) event;
            this.vmOperator = clickRemoveEvent.getVmOperator();
            List<com.tencent.mobileqq.troop.selectmember.bean.c> value = clickRemoveEvent.getVmOperator().P().getValue();
            if (value != null) {
                T9(value);
                return;
            }
            return;
        }
        if (event instanceof TroopDeleteMemberEvent.ClickBackEvent) {
            q d16 = new q(bg.e()).i("dc00899").a("Grp_mber").f("del_mber").d("del_return");
            com.tencent.mobileqq.troop.deletemember.a aVar = this.viewModel;
            com.tencent.mobileqq.troop.deletemember.a aVar2 = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                aVar = null;
            }
            q c16 = d16.c(aVar.M1());
            String[] strArr = new String[1];
            com.tencent.mobileqq.troop.deletemember.a aVar3 = this.viewModel;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                aVar2 = aVar3;
            }
            strArr[0] = aVar2.N1();
            c16.b(strArr).g();
            getActivity().onBackPressed();
        }
    }
}
