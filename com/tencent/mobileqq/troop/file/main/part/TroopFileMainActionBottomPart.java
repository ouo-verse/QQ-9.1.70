package com.tencent.mobileqq.troop.file.main.part;

import android.app.Dialog;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.history.widget.a;
import com.tencent.mobileqq.troop.file.main.vm.TroopFileMainVM;
import com.tencent.mobileqq.util.bc;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0002J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\u0012\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001b\u0010%\u001a\u00020 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/troop/file/main/part/TroopFileMainActionBottomPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "actionType", "", "F9", "G9", "L9", "", "Lcom/tencent/mobileqq/troop/data/n;", "D9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "action", "", "args", "handleBroadcastMessage", "Lcom/tencent/mobileqq/troop/file/main/vm/TroopFileMainVM;", "d", "Lcom/tencent/mobileqq/troop/file/main/vm/TroopFileMainVM;", "E9", "()Lcom/tencent/mobileqq/troop/file/main/vm/TroopFileMainVM;", "viewModel", "Lcom/tencent/mobileqq/activity/history/widget/a;", "e", "Lcom/tencent/mobileqq/activity/history/widget/a;", "actionBar", "f", "Landroid/view/View;", "editDownloadBtn", "Lcom/tencent/mobileqq/filemanager/multioperate/d;", tl.h.F, "Lkotlin/Lazy;", "C9", "()Lcom/tencent/mobileqq/filemanager/multioperate/d;", "multiOperate", "<init>", "(Lcom/tencent/mobileqq/troop/file/main/vm/TroopFileMainVM;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopFileMainActionBottomPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final TroopFileMainVM viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.activity.history.widget.a actionBar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View editDownloadBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy multiOperate;

    public TroopFileMainActionBottomPart(TroopFileMainVM viewModel) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.viewModel = viewModel;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.filemanager.multioperate.d>() { // from class: com.tencent.mobileqq.troop.file.main.part.TroopFileMainActionBottomPart$multiOperate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.filemanager.multioperate.d invoke() {
                return new com.tencent.mobileqq.filemanager.multioperate.d(bc.a(TroopFileMainActionBottomPart.this), TroopFileMainActionBottomPart.this.getActivity(), TroopFileMainActionBottomPart.this.getViewModel().T1().troopUinL);
            }
        });
        this.multiOperate = lazy;
    }

    private final com.tencent.mobileqq.filemanager.multioperate.d C9() {
        return (com.tencent.mobileqq.filemanager.multioperate.d) this.multiOperate.getValue();
    }

    private final List<com.tencent.mobileqq.troop.data.n> D9() {
        Object broadcastGetMessage = broadcastGetMessage("get_select_list", Unit.INSTANCE);
        if (broadcastGetMessage instanceof List) {
            return (List) broadcastGetMessage;
        }
        return null;
    }

    private final void F9(int actionType) {
        List<com.tencent.mobileqq.troop.data.n> D9 = D9();
        if (actionType == 1) {
            View view = this.editDownloadBtn;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editDownloadBtn");
                view = null;
            }
            com.tencent.mobileqq.troop.file.data.d.c(view);
            C9().e(D9, 1, null);
            L9();
            return;
        }
        if (actionType == 2) {
            C9().e(D9, 2, null);
            L9();
            return;
        }
        if (actionType == 3) {
            C9().e(D9, 4, null);
            L9();
        } else if (actionType == 4) {
            G9();
        } else {
            if (actionType != 5) {
                return;
            }
            C9().e(D9, 5, null);
            L9();
        }
    }

    private final void G9() {
        List<com.tencent.mobileqq.troop.data.n> D9 = D9();
        if (D9 == null || D9.isEmpty()) {
            return;
        }
        Dialog createDialog = ActionSheetHelper.createDialog(getActivity(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.setMainTitle(R.string.dq9);
        actionSheet.addButton(getActivity().getString(R.string.b5u), 3);
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.troop.file.main.part.c
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                TroopFileMainActionBottomPart.H9(TroopFileMainActionBottomPart.this, actionSheet, view, i3);
            }
        });
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(TroopFileMainActionBottomPart this$0, ActionSheet alertSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(alertSheet, "$alertSheet");
        List<com.tencent.mobileqq.troop.data.n> D9 = this$0.D9();
        if (D9 == null || D9.isEmpty()) {
            return;
        }
        this$0.C9().e(new ArrayList(D9), 3, new com.tencent.mobileqq.filemanager.multioperate.c() { // from class: com.tencent.mobileqq.troop.file.main.part.d
            @Override // com.tencent.mobileqq.filemanager.multioperate.c
            public final void a(int i16, int i17) {
                TroopFileMainActionBottomPart.I9(i16, i17);
            }
        });
        this$0.L9();
        if (alertSheet.isShowing()) {
            alertSheet.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(TroopFileMainActionBottomPart this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.editDownloadBtn;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editDownloadBtn");
            view = null;
        }
        com.tencent.mobileqq.troop.file.data.d.d(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(TroopFileMainActionBottomPart this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.F9(i3);
    }

    private final void L9() {
        broadcastMessage("exit_select_mode", Unit.INSTANCE);
    }

    /* renamed from: E9, reason: from getter */
    public final TroopFileMainVM getViewModel() {
        return this.viewModel;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        com.tencent.mobileqq.troop.data.n nVar;
        Object obj;
        if (action != null) {
            com.tencent.mobileqq.activity.history.widget.a aVar = null;
            switch (action.hashCode()) {
                case -1313317857:
                    if (action.equals("enter_select_mode")) {
                        com.tencent.mobileqq.activity.history.widget.a aVar2 = this.actionBar;
                        if (aVar2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("actionBar");
                            aVar2 = null;
                        }
                        aVar2.l();
                        com.tencent.mobileqq.activity.history.widget.a aVar3 = this.actionBar;
                        if (aVar3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("actionBar");
                        } else {
                            aVar = aVar3;
                        }
                        aVar.i(false);
                        return;
                    }
                    return;
                case -1132604059:
                    if (action.equals("exit_select_mode")) {
                        com.tencent.mobileqq.activity.history.widget.a aVar4 = this.actionBar;
                        if (aVar4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("actionBar");
                        } else {
                            aVar = aVar4;
                        }
                        aVar.d();
                        return;
                    }
                    return;
                case 517167311:
                    if (action.equals("on_multi_selected_empty")) {
                        com.tencent.mobileqq.activity.history.widget.a aVar5 = this.actionBar;
                        if (aVar5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("actionBar");
                        } else {
                            aVar = aVar5;
                        }
                        aVar.i(false);
                        return;
                    }
                    return;
                case 1664217953:
                    if (action.equals("on_multi_item_selected")) {
                        if (Intrinsics.areEqual(args, Boolean.TRUE)) {
                            com.tencent.mobileqq.activity.history.widget.a aVar6 = this.actionBar;
                            if (aVar6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("actionBar");
                                aVar6 = null;
                            }
                            aVar6.i(true);
                        }
                        List<com.tencent.mobileqq.troop.data.n> D9 = D9();
                        if (D9 != null) {
                            Iterator<T> it = D9.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    obj = it.next();
                                    if (((com.tencent.mobileqq.troop.data.n) obj).f294918d > GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT) {
                                    }
                                } else {
                                    obj = null;
                                }
                            }
                            nVar = (com.tencent.mobileqq.troop.data.n) obj;
                        } else {
                            nVar = null;
                        }
                        com.tencent.mobileqq.activity.history.widget.a aVar7 = this.actionBar;
                        if (aVar7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("actionBar");
                        } else {
                            aVar = aVar7;
                        }
                        aVar.h(5, nVar == null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        ArrayList arrayListOf;
        if (rootView == null) {
            return;
        }
        View findViewById = rootView.findViewById(R.id.jyd);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.actionBar = new com.tencent.mobileqq.activity.history.widget.a(getActivity(), (RelativeLayout) findViewById);
        View findViewById2 = rootView.findViewById(R.id.brq);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.editDownloadBtn)");
        this.editDownloadBtn = findViewById2;
        com.tencent.mobileqq.activity.history.widget.a aVar = null;
        if (findViewById2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editDownloadBtn");
            findViewById2 = null;
        }
        com.tencent.mobileqq.troop.file.data.d.h(findViewById2);
        com.tencent.mobileqq.activity.history.widget.a aVar2 = this.actionBar;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBar");
            aVar2 = null;
        }
        aVar2.k(new a.d() { // from class: com.tencent.mobileqq.troop.file.main.part.a
            @Override // com.tencent.mobileqq.activity.history.widget.a.d
            public final void a(boolean z16) {
                TroopFileMainActionBottomPart.J9(TroopFileMainActionBottomPart.this, z16);
            }
        });
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(1, 2, 3, 4, 5);
        com.tencent.mobileqq.activity.history.widget.a aVar3 = this.actionBar;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBar");
            aVar3 = null;
        }
        aVar3.g(arrayListOf);
        com.tencent.mobileqq.activity.history.widget.a aVar4 = this.actionBar;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionBar");
        } else {
            aVar = aVar4;
        }
        aVar.j(new a.c() { // from class: com.tencent.mobileqq.troop.file.main.part.b
            @Override // com.tencent.mobileqq.activity.history.widget.a.c
            public final void c(int i3) {
                TroopFileMainActionBottomPart.K9(TroopFileMainActionBottomPart.this, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(int i3, int i16) {
    }
}
