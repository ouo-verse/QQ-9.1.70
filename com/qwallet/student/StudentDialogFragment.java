package com.qwallet.student;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qwallet.QWalletBottomSheetDialogFragment;
import com.tencent.mobileqq.qwallet.pb.StudentPB$GetAuthPanelRsp;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.LoadingUtil;
import cooperation.qwallet.plugin.QWalletPicHelper;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 >2\u00020\u0001:\u0001?B\u0007\u00a2\u0006\u0004\b<\u0010=J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J&\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010'\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010\"R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0016\u0010/\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010\"R\u0016\u00101\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u0010*R\u001b\u00107\u001a\u0002028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:\u00a8\u0006@"}, d2 = {"Lcom/qwallet/student/StudentDialogFragment;", "Lcom/tencent/mobileqq/qwallet/QWalletBottomSheetDialogFragment;", "Landroid/view/View;", "view", "", "initView", "initData", "initHandle", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/content/DialogInterface;", "dialog", "onCancel", "", "getTheme", "Landroid/app/Dialog;", "onCreateDialog", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "successLayout", "D", "errorLayout", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "channelLogo", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "channelName", "G", "studentTitle", "H", "studentContent", "Landroid/widget/Button;", "I", "Landroid/widget/Button;", "disagreeBtn", "J", "agreeBtn", "K", "errorTitle", "L", "errorBtn", "Lcom/qwallet/student/n;", "M", "Lkotlin/Lazy;", "Ah", "()Lcom/qwallet/student/n;", "viewModel", "", "N", "Ljava/lang/String;", "refuseResult", "<init>", "()V", "P", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class StudentDialogFragment extends QWalletBottomSheetDialogFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private View successLayout;

    /* renamed from: D, reason: from kotlin metadata */
    private View errorLayout;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView channelLogo;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView channelName;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView studentTitle;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView studentContent;

    /* renamed from: I, reason: from kotlin metadata */
    private Button disagreeBtn;

    /* renamed from: J, reason: from kotlin metadata */
    private Button agreeBtn;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView errorTitle;

    /* renamed from: L, reason: from kotlin metadata */
    private Button errorBtn;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(n.class), new Function0<ViewModelStore>() { // from class: com.qwallet.student.StudentDialogFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelStore invoke() {
            FragmentActivity requireActivity = Fragment.this.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            ViewModelStore viewModelStore = requireActivity.get_viewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<ViewModelProvider.Factory>() { // from class: com.qwallet.student.StudentDialogFragment$special$$inlined$activityViewModels$default$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelProvider.Factory invoke() {
            FragmentActivity requireActivity = Fragment.this.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            return requireActivity.getDefaultViewModelProviderFactory();
        }
    });

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private String refuseResult;

    private final n Ah() {
        return (n) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(StudentDialogFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Bundle bundle = new Bundle();
        bundle.putInt("extra_key_result_code", -1);
        bundle.putString("extra_key_result_msg", "\u7528\u6237\u62d2\u7edd");
        String str = this$0.refuseResult;
        if (str == null) {
            str = "";
        }
        bundle.putString("extra_key_result_data", str);
        Unit unit = Unit.INSTANCE;
        FragmentKt.setFragmentResult(this$0, "qwallet_student_request", bundle);
        com.tencent.mobileqq.qwallet.c.f("studentAuth.popupDeny.click", null, null, null, null, 30, null);
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(StudentDialogFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Bundle bundle = new Bundle();
        bundle.putInt("extra_key_result_code", -2);
        bundle.putString("extra_key_result_msg", "\u975e\u5b66\u751f\u72b6\u6001");
        String str = this$0.refuseResult;
        if (str == null) {
            str = "";
        }
        bundle.putString("extra_key_result_data", str);
        Unit unit = Unit.INSTANCE;
        FragmentKt.setFragmentResult(this$0, "qwallet_student_request", bundle);
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(final StudentDialogFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final Dialog showLoadingDialog = LoadingUtil.showLoadingDialog(this$0.getContext(), "\u52a0\u8f7d\u4e2d", false);
        Window window = showLoadingDialog.getWindow();
        if (window != null) {
            window.setDimAmount(0.0f);
        }
        showLoadingDialog.show();
        com.tencent.mobileqq.qwallet.c.f("studentAuth.popupAllow.click", null, null, null, null, 30, null);
        this$0.Ah().M1(new Function2<Boolean, String, Unit>() { // from class: com.qwallet.student.StudentDialogFragment$initHandle$3$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                invoke(bool.booleanValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, @NotNull String dataStr) {
                Intrinsics.checkNotNullParameter(dataStr, "dataStr");
                showLoadingDialog.dismiss();
                if (z16) {
                    StudentDialogFragment studentDialogFragment = this$0;
                    Bundle bundle = new Bundle();
                    bundle.putInt("extra_key_result_code", 0);
                    bundle.putString("extra_key_result_data", dataStr);
                    Unit unit = Unit.INSTANCE;
                    FragmentKt.setFragmentResult(studentDialogFragment, "qwallet_student_request", bundle);
                    this$0.dismiss();
                }
            }
        });
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void initData() {
        MutableLiveData<StudentPB$GetAuthPanelRsp> L1 = Ah().L1();
        final Function1<StudentPB$GetAuthPanelRsp, Unit> function1 = new Function1<StudentPB$GetAuthPanelRsp, Unit>() { // from class: com.qwallet.student.StudentDialogFragment$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(StudentPB$GetAuthPanelRsp studentPB$GetAuthPanelRsp) {
                invoke2(studentPB$GetAuthPanelRsp);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(StudentPB$GetAuthPanelRsp studentPB$GetAuthPanelRsp) {
                View view;
                View view2;
                ImageView imageView;
                TextView textView;
                TextView textView2;
                TextView textView3;
                if (studentPB$GetAuthPanelRsp == null) {
                    return;
                }
                StudentDialogFragment.this.refuseResult = studentPB$GetAuthPanelRsp.refuse_result.get();
                view = StudentDialogFragment.this.successLayout;
                TextView textView4 = null;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("successLayout");
                    view = null;
                }
                view.setVisibility(0);
                view2 = StudentDialogFragment.this.errorLayout;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("errorLayout");
                    view2 = null;
                }
                view2.setVisibility(8);
                imageView = StudentDialogFragment.this.channelLogo;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("channelLogo");
                    imageView = null;
                }
                imageView.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(studentPB$GetAuthPanelRsp.app_icon.get()));
                textView = StudentDialogFragment.this.channelName;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("channelName");
                    textView = null;
                }
                textView.setText(studentPB$GetAuthPanelRsp.app_name.get());
                textView2 = StudentDialogFragment.this.studentTitle;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("studentTitle");
                    textView2 = null;
                }
                textView2.setText(studentPB$GetAuthPanelRsp.title.get());
                textView3 = StudentDialogFragment.this.studentContent;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("studentContent");
                } else {
                    textView4 = textView3;
                }
                textView4.setText(studentPB$GetAuthPanelRsp.content.get());
            }
        };
        L1.observe(this, new Observer() { // from class: com.qwallet.student.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                StudentDialogFragment.Bh(Function1.this, obj);
            }
        });
        com.tencent.mobileqq.qwallet.c.f("studentAuth.popup.show", null, null, null, null, 30, null);
    }

    private final void initHandle() {
        Button button = this.disagreeBtn;
        Button button2 = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disagreeBtn");
            button = null;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.qwallet.student.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StudentDialogFragment.Ch(StudentDialogFragment.this, view);
            }
        });
        Button button3 = this.errorBtn;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorBtn");
            button3 = null;
        }
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.qwallet.student.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StudentDialogFragment.Dh(StudentDialogFragment.this, view);
            }
        });
        Button button4 = this.agreeBtn;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("agreeBtn");
        } else {
            button2 = button4;
        }
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.qwallet.student.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StudentDialogFragment.Eh(StudentDialogFragment.this, view);
            }
        });
    }

    private final void initView(View view) {
        View findViewById = view.findViewById(R.id.f89514zz);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.student_success_layout)");
        this.successLayout = findViewById;
        View findViewById2 = view.findViewById(R.id.f89474zv);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.student_error_layout)");
        this.errorLayout = findViewById2;
        View findViewById3 = view.findViewById(R.id.f89404zo);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.student_channel_logo)");
        this.channelLogo = (ImageView) findViewById3;
        View findViewById4 = view.findViewById(R.id.f89414zp);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.student_channel_name)");
        this.channelName = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.f89434zr);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.student_content_title)");
        this.studentTitle = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.f89424zq);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.student_content_text)");
        this.studentContent = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.f89444zs);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.student_disagree_btn)");
        this.disagreeBtn = (Button) findViewById7;
        View findViewById8 = view.findViewById(R.id.f89394zn);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.student_agree_btn)");
        this.agreeBtn = (Button) findViewById8;
        View findViewById9 = view.findViewById(R.id.f89484zw);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById(R.id.student_error_title)");
        this.errorTitle = (TextView) findViewById9;
        View findViewById10 = view.findViewById(R.id.f89454zt);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "view.findViewById(R.id.student_error_btn)");
        this.errorBtn = (Button) findViewById10;
    }

    @Override // androidx.fragment.app.DialogFragment
    public int getTheme() {
        return R.style.a76;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        Bundle bundle = new Bundle();
        bundle.putInt("extra_key_result_code", -1);
        bundle.putString("extra_key_result_msg", "\u7528\u6237\u62d2\u7edd");
        String str = this.refuseResult;
        if (str == null) {
            str = "";
        }
        bundle.putString("extra_key_result_data", str);
        com.tencent.mobileqq.qwallet.c.f("studentAuth.popupDeny.click", null, null, null, null, 30, null);
        Unit unit = Unit.INSTANCE;
        FragmentKt.setFragmentResult(this, "qwallet_student_request", bundle);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
        aVar.getBehavior().setSkipCollapsed(true);
        aVar.getBehavior().setState(3);
        aVar.getBehavior().setHideable(false);
        aVar.setCanceledOnTouchOutside(false);
        Window window = aVar.getWindow();
        if (window != null) {
            window.setDimAmount(0.0f);
        }
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.hk9, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
        initHandle();
    }
}
