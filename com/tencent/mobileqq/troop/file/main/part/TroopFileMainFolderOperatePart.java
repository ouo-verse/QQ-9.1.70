package com.tencent.mobileqq.troop.file.main.part;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.core.internal.view.SupportMenu;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.file.main.vm.TroopFileMainVM;
import com.tencent.mobileqq.troop.file.main.vm.a;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.util.bc;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010*\u001a\u00020%\u00a2\u0006\u0004\bA\u0010BJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J8\u0010\u0018\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0017\u001a\u00020\bH\u0002J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\bH\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0002J\u001c\u0010 \u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u001c\u0010$\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\f2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016R\u0017\u0010*\u001a\u00020%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u001b\u00109\u001a\u0002048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0014\u0010=\u001a\u00020:8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b;\u0010<R\u0014\u0010@\u001a\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b>\u0010?\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/troop/file/main/part/TroopFileMainFolderOperatePart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/troop/file/main/vm/a$e;", "result", "", "U9", "Lcom/tencent/mobileqq/troop/file/main/vm/a$a;", "R9", "", "errorCode", "", "isCreate", "", "folderId", "S9", "Lcom/tencent/mobileqq/troop/file/main/vm/a$b;", "T9", "Lcom/tencent/mobileqq/troop/data/n;", "fileInfo", "aa", "title", "inputStr", "errorMsg", "type", "W9", "textResourceId", "ca", "M9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "action", "", "args", "handleBroadcastMessage", "Lcom/tencent/mobileqq/troop/file/main/vm/TroopFileMainVM;", "d", "Lcom/tencent/mobileqq/troop/file/main/vm/TroopFileMainVM;", "Q9", "()Lcom/tencent/mobileqq/troop/file/main/vm/TroopFileMainVM;", "viewModel", "e", "Ljava/lang/String;", "tempInputFolderName", "f", "I", "emojiStart", tl.h.F, "Z", "isEmoji", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "i", "Lkotlin/Lazy;", "N9", "()Lcom/tencent/mobileqq/widget/QQProgressDialog;", "loadingDialog", "", "O9", "()J", "troopUinL", "P9", "()Ljava/lang/String;", "troopUinStr", "<init>", "(Lcom/tencent/mobileqq/troop/file/main/vm/TroopFileMainVM;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopFileMainFolderOperatePart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final TroopFileMainVM viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String tempInputFolderName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int emojiStart;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isEmoji;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy loadingDialog;

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J(\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/troop/file/main/part/TroopFileMainFolderOperatePart$a", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "before", "count", "", "onTextChanged", "after", "beforeTextChanged", "Landroid/text/Editable;", "afterTextChanged", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements TextWatcher {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ EditText f295554e;

        a(EditText editText) {
            this.f295554e = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s16) {
            Intrinsics.checkNotNullParameter(s16, "s");
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s16, int start, int count, int after) {
            Intrinsics.checkNotNullParameter(s16, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s16, int start, int before, int count) {
            Intrinsics.checkNotNullParameter(s16, "s");
            if (count > 0) {
                String obj = s16.toString();
                String g16 = TroopFileUtils.g(obj);
                if (!Intrinsics.areEqual(obj, g16)) {
                    TroopFileMainFolderOperatePart.this.emojiStart = start;
                    TroopFileMainFolderOperatePart.this.isEmoji = true;
                    this.f295554e.setText(g16);
                } else if (TroopFileMainFolderOperatePart.this.isEmoji) {
                    this.f295554e.setSelection(TroopFileMainFolderOperatePart.this.emojiStart);
                    TroopFileMainFolderOperatePart.this.isEmoji = false;
                }
            }
        }
    }

    public TroopFileMainFolderOperatePart(TroopFileMainVM viewModel) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.viewModel = viewModel;
        this.tempInputFolderName = "";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQProgressDialog>() { // from class: com.tencent.mobileqq.troop.file.main.part.TroopFileMainFolderOperatePart$loadingDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QQProgressDialog invoke() {
                Activity activity = TroopFileMainFolderOperatePart.this.getActivity();
                Activity activity2 = TroopFileMainFolderOperatePart.this.getActivity();
                QBaseActivity qBaseActivity = activity2 instanceof QBaseActivity ? (QBaseActivity) activity2 : null;
                return new QQProgressDialog(activity, qBaseActivity != null ? qBaseActivity.getTitleBarHeight() : bc.e(TroopFileMainFolderOperatePart.this).getDimensionPixelSize(R.dimen.title_bar_height));
            }
        });
        this.loadingDialog = lazy;
    }

    private final void M9() {
        try {
            Result.Companion companion = Result.INSTANCE;
            if (N9().isShowing()) {
                N9().dismiss();
            }
            Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
    }

    private final QQProgressDialog N9() {
        return (QQProgressDialog) this.loadingDialog.getValue();
    }

    private final long O9() {
        return this.viewModel.T1().troopUinL;
    }

    private final String P9() {
        return this.viewModel.T1().troopUinStr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R9(a.C8684a result) {
        M9();
        if (result.getIsSuccess()) {
            ReportController.o(bc.a(this), "P_CliOper", "Grp_files", "", "file", "new_suc", 0, 0, P9(), result.getFileId(), "", "");
            bc.h(this, R.string.uf_, 2, 0, 4, null);
        } else {
            S9(result.getErrorCode(), true, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T9(a.b result) {
        M9();
        if (result.getIsSuccess()) {
            bc.h(this, R.string.uex, 2, 0, 4, null);
            ReportController.o(bc.a(this), "P_CliOper", "Grp_files", "", "file", "del_suc", 0, 0, P9(), result.getFileId(), "", "");
            return;
        }
        int errorCode = result.getErrorCode();
        if (errorCode == -136) {
            bc.h(this, R.string.ufi, 0, 0, 6, null);
        } else if (errorCode != -107 && errorCode != -102) {
            bc.h(this, R.string.dpu, 0, 0, 6, null);
        } else {
            bc.h(this, R.string.uer, 0, 0, 6, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U9(a.e result) {
        M9();
        if (result.getIsSuccess()) {
            broadcastMessage("notify_data_changed", Unit.INSTANCE);
            bc.h(this, R.string.uek, 2, 0, 4, null);
        } else {
            S9(result.getErrorCode(), false, result.getFolderId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void W9(String title, final String folderId, String inputStr, String errorMsg, final int type) {
        com.tencent.biz.widgets.a N = com.tencent.biz.widgets.a.N(getActivity(), title, "", R.string.cancel, R.string.a8j, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.file.main.part.j
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                TroopFileMainFolderOperatePart.X9(TroopFileMainFolderOperatePart.this, type, folderId, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.file.main.part.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                TroopFileMainFolderOperatePart.Y9(dialogInterface, i3);
            }
        });
        final EditText editText = N.getEditText();
        if (type == 0) {
            editText.setHint(R.string.erv);
        } else {
            editText.setHint(R.string.etp);
        }
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(48)});
        editText.addTextChangedListener(new a(editText));
        if (!TextUtils.isEmpty(errorMsg)) {
            N.P(errorMsg, SupportMenu.CATEGORY_MASK);
        }
        if (!TextUtils.isEmpty(inputStr)) {
            editText.setText(inputStr);
            editText.setSelectAllOnFocus(true);
        }
        N.show();
        editText.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.troop.file.main.part.l
            @Override // java.lang.Runnable
            public final void run() {
                TroopFileMainFolderOperatePart.Z9(editText);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(EditText editText) {
        editText.requestFocus();
        InputMethodUtil.show(editText);
    }

    private final void aa(final com.tencent.mobileqq.troop.data.n fileInfo) {
        Dialog createDialog = ActionSheetHelper.createDialog(getActivity(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        String string = getActivity().getResources().getString(R.string.elr);
        Intrinsics.checkNotNullExpressionValue(string, "activity.resources.getSt\u2026roop_folder_delete_sheet)");
        actionSheet.addButton(string, 3);
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.troop.file.main.part.m
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                TroopFileMainFolderOperatePart.ba(TroopFileMainFolderOperatePart.this, actionSheet, fileInfo, view, i3);
            }
        });
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ca(int textResourceId) {
        try {
            Result.Companion companion = Result.INSTANCE;
            QQProgressDialog N9 = N9();
            N9.setMessage(textResourceId);
            N9.setBackAndSearchFilter(false);
            N9.show();
            Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
    }

    /* renamed from: Q9, reason: from getter */
    public final TroopFileMainVM getViewModel() {
        return this.viewModel;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        super.handleBroadcastMessage(action, args);
        if (Intrinsics.areEqual(action, "show_create_or_rename_folder_dialog")) {
            Intrinsics.checkNotNull(args, "null cannot be cast to non-null type com.tencent.mobileqq.troop.file.main.model.CreateOrRenameFolderModel");
            ks2.a aVar = (ks2.a) args;
            W9(aVar.getTitle(), aVar.getFolderId(), aVar.getInputStr(), aVar.getErrorMsg(), aVar.getType());
        } else if (Intrinsics.areEqual(action, "show_delete_folder_dialog")) {
            Intrinsics.checkNotNull(args, "null cannot be cast to non-null type com.tencent.mobileqq.troop.data.TroopFileInfo");
            aa((com.tencent.mobileqq.troop.data.n) args);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        MutableLiveData<com.tencent.mobileqq.troop.file.main.vm.a> obtainUiState = this.viewModel.obtainUiState();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.troop.file.main.vm.a, Unit> function1 = new Function1<com.tencent.mobileqq.troop.file.main.vm.a, Unit>() { // from class: com.tencent.mobileqq.troop.file.main.part.TroopFileMainFolderOperatePart$onPartCreate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.file.main.vm.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.file.main.vm.a it) {
                if (it instanceof a.b) {
                    TroopFileMainFolderOperatePart troopFileMainFolderOperatePart = TroopFileMainFolderOperatePart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    troopFileMainFolderOperatePart.T9((a.b) it);
                } else if (it instanceof a.C8684a) {
                    TroopFileMainFolderOperatePart troopFileMainFolderOperatePart2 = TroopFileMainFolderOperatePart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    troopFileMainFolderOperatePart2.R9((a.C8684a) it);
                } else if (it instanceof a.e) {
                    TroopFileMainFolderOperatePart troopFileMainFolderOperatePart3 = TroopFileMainFolderOperatePart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    troopFileMainFolderOperatePart3.U9((a.e) it);
                }
            }
        };
        obtainUiState.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.file.main.part.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopFileMainFolderOperatePart.V9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(TroopFileMainFolderOperatePart this$0, ActionSheet sheet, com.tencent.mobileqq.troop.data.n fileInfo, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(sheet, "$sheet");
        Intrinsics.checkNotNullParameter(fileInfo, "$fileInfo");
        if (i3 == 0) {
            if (TroopFileUtils.d(bc.a(this$0), this$0.getActivity(), this$0.O9()) == 0) {
                return;
            }
            this$0.ca(R.string.ek_);
            BuildersKt__Builders_commonKt.launch$default(bc.d(this$0), null, null, new TroopFileMainFolderOperatePart$showDeleteFolderDialog$1$1(this$0, fileInfo, null), 3, null);
            ReportController.o(bc.a(this$0), "P_CliOper", "Grp_files", "", "file", "Clk_del", 0, 0, this$0.P9(), "", "", "");
        }
        sheet.dismiss();
    }

    private final void S9(int errorCode, boolean isCreate, String folderId) {
        String str;
        int i3;
        if (isCreate) {
            str = "0";
        } else {
            str = "1";
        }
        if (errorCode != -405) {
            if (errorCode == -313) {
                ReportController.o(bc.a(this), "P_CliOper", "Grp_files", "", "file", "repeat", 0, 0, P9(), str, "", "");
                i3 = R.string.elt;
            } else if (errorCode == -303) {
                bc.h(this, R.string.elz, 0, 0, 6, null);
                i3 = R.string.elz;
            } else {
                if (errorCode != -134) {
                    if (errorCode != -107 && errorCode != -102) {
                        bc.h(this, R.string.dpu, 0, 0, 6, null);
                        return;
                    } else {
                        bc.h(this, R.string.elv, 0, 0, 6, null);
                        return;
                    }
                }
                ReportController.o(bc.a(this), "P_CliOper", "Grp_files", "", "file", "sensitive", 0, 0, P9(), str, "", "");
                i3 = R.string.ely;
            }
            W9(bc.f(this, R.string.epv), folderId, this.tempInputFolderName, bc.f(this, i3), !isCreate ? 1 : 0);
            return;
        }
        bc.h(this, R.string.elw, 0, 0, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(TroopFileMainFolderOperatePart this$0, int i3, String str, DialogInterface dialogInterface, int i16) {
        String str2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(dialogInterface, "null cannot be cast to non-null type com.tencent.biz.widgets.InputDialog");
        com.tencent.biz.widgets.a aVar = (com.tencent.biz.widgets.a) dialogInterface;
        String inputValue = aVar.getInputValue();
        Intrinsics.checkNotNullExpressionValue(inputValue, "inputDialog.inputValue");
        int length = inputValue.length() - 1;
        int i17 = 0;
        boolean z16 = false;
        while (i17 <= length) {
            boolean z17 = Intrinsics.compare((int) inputValue.charAt(!z16 ? i17 : length), 32) <= 0;
            if (z16) {
                if (!z17) {
                    break;
                } else {
                    length--;
                }
            } else if (z17) {
                i17++;
            } else {
                z16 = true;
            }
        }
        String obj = inputValue.subSequence(i17, length + 1).toString();
        if (TextUtils.isEmpty(obj)) {
            bc.h(this$0, R.string.f180213ag, 0, 0, 6, null);
            return;
        }
        this$0.tempInputFolderName = obj;
        if (obj.length() > TroopFileUtils.f301968a) {
            aVar.P(bc.f(this$0, R.string.elx), SupportMenu.CATEGORY_MASK);
            ReportController.o(bc.a(this$0), "P_CliOper", "Grp_files", "", "file", "over_num", 0, 0, this$0.P9(), "", "", "");
            return;
        }
        if (TroopFileUtils.y(this$0.tempInputFolderName)) {
            aVar.P(bc.f(this$0, R.string.ely), SupportMenu.CATEGORY_MASK);
            if (i3 == 0) {
                str2 = "0";
            } else if (i3 != 1) {
                return;
            } else {
                str2 = "1";
            }
            ReportController.o(bc.a(this$0), "P_CliOper", "Grp_files", "", "file", "sensitive", 0, 0, this$0.P9(), str2, "", "");
            return;
        }
        aVar.dismiss();
        if (TroopFileUtils.d(bc.a(this$0), this$0.getContext(), this$0.O9()) == 0) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(bc.d(this$0), null, null, new TroopFileMainFolderOperatePart$showCreateOrRenameDialog$confirmListener$1$1(i3, this$0, str, null), 3, null);
    }
}
