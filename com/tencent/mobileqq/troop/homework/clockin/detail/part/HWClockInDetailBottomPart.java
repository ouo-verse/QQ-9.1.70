package com.tencent.mobileqq.troop.homework.clockin.detail.part;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.clockin.detail.vm.HWClockInDetailViewModel;
import com.tencent.mobileqq.troop.homework.clockin.detail.vm.a;
import com.tencent.mobileqq.troop.homework.clockin.detail.vm.b;
import com.tencent.mobileqq.troop.homework.clockin.remind.HWClockInRemindFragment;
import com.tencent.mobileqq.troop.utils.h;
import com.tencent.mobileqq.utils.TriggerRunnerKt;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LoadingUtil;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/detail/part/HWClockInDetailBottomPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/vm/a$l;", "data", "", "J9", "Lcom/tencent/mobileqq/troop/homework/clockin/remind/data/a;", "pageDate", "G9", "H9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/vm/HWClockInDetailViewModel;", "d", "Lkotlin/Lazy;", "F9", "()Lcom/tencent/mobileqq/troop/homework/clockin/detail/vm/HWClockInDetailViewModel;", "viewModel", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "e", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "button", "f", "Landroid/view/View;", "bottomLayout", "Landroid/app/Dialog;", h.F, "Landroid/app/Dialog;", "loadingDialog", "", "i", "Z", "isJumpingToNotifyPage", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWClockInDetailBottomPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QUIButton button;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View bottomLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Dialog loadingDialog;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isJumpingToNotifyPage;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00028\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/homework/clockin/detail/part/HWClockInDetailBottomPart$a", "Lkotlin/Lazy;", "", "isInitialized", "d", "Landroidx/lifecycle/ViewModel;", "cached", "a", "()Landroidx/lifecycle/ViewModel;", "value", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements Lazy<HWClockInDetailViewModel> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private HWClockInDetailViewModel cached;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Part f296370e;

        public a(Part part) {
            this.f296370e = part;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) part);
            }
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [androidx.lifecycle.ViewModel, java.lang.Object, com.tencent.mobileqq.troop.homework.clockin.detail.vm.HWClockInDetailViewModel] */
        /* JADX WARN: Type inference failed for: r0v6, types: [androidx.lifecycle.ViewModel, com.tencent.mobileqq.troop.homework.clockin.detail.vm.HWClockInDetailViewModel] */
        @Override // kotlin.Lazy
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HWClockInDetailViewModel getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ViewModel) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            HWClockInDetailViewModel hWClockInDetailViewModel = this.cached;
            Object partHost = this.f296370e.getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            Fragment fragment = (Fragment) partHost;
            if (hWClockInDetailViewModel == null) {
                ViewModelProvider.Factory a16 = com.tencent.mobileqq.troop.homework.common.b.a(fragment);
                ViewModelStore viewModelStore = fragment.getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "fragment.viewModelStore");
                ?? r06 = new ViewModelProvider(viewModelStore, a16).get(HWClockInDetailViewModel.class);
                this.cached = r06;
                Intrinsics.checkNotNullExpressionValue(r06, "{\n                val fa\u2026          }\n            }");
                return r06;
            }
            return hWClockInDetailViewModel;
        }

        @Override // kotlin.Lazy
        public boolean isInitialized() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            if (this.cached != null) {
                return true;
            }
            return false;
        }
    }

    public HWClockInDetailBottomPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.viewModel = new a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HWClockInDetailViewModel F9() {
        return (HWClockInDetailViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G9(com.tencent.mobileqq.troop.homework.clockin.remind.data.a pageDate) {
        if (!this.isJumpingToNotifyPage) {
            return;
        }
        this.isJumpingToNotifyPage = false;
        Dialog dialog = this.loadingDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        HWClockInRemindFragment hWClockInRemindFragment = new HWClockInRemindFragment(pageDate);
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        hWClockInRemindFragment.show(((FragmentActivity) context).getSupportFragmentManager(), HWClockInRemindFragment.class.getSimpleName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H9() {
        Dialog dialog = this.loadingDialog;
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        QQToast.makeText(BaseApplication.getContext(), 1, R.string.f171155cp4, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9(final a.l data) {
        QUIButton qUIButton;
        View view = this.bottomLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomLayout");
            view = null;
        }
        view.setVisibility(data.f());
        QUIButton qUIButton2 = this.button;
        if (qUIButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("button");
            qUIButton2 = null;
        }
        qUIButton2.setClickable(data.d());
        QUIButton qUIButton3 = this.button;
        if (qUIButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("button");
            qUIButton3 = null;
        }
        qUIButton3.setEnabled(data.d());
        QUIButton qUIButton4 = this.button;
        if (qUIButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("button");
            qUIButton4 = null;
        }
        qUIButton4.setType(data.b());
        QUIButton qUIButton5 = this.button;
        if (qUIButton5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("button");
            qUIButton5 = null;
        }
        qUIButton5.setSizeType(data.a());
        QUIButton qUIButton6 = this.button;
        if (qUIButton6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("button");
            qUIButton6 = null;
        }
        qUIButton6.setText(data.e());
        QUIButton qUIButton7 = this.button;
        if (qUIButton7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("button");
            qUIButton = null;
        } else {
            qUIButton = qUIButton7;
        }
        TriggerRunnerKt.c(qUIButton, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.clockin.detail.part.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HWClockInDetailBottomPart.K9(a.l.this, this, view2);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(a.l data, final HWClockInDetailBottomPart this$0, View view) {
        QUIButton qUIButton;
        Activity activity;
        Window window;
        View decorView;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if ((data.c() instanceof b.C8708b) && (activity = this$0.getActivity()) != null && (window = activity.getWindow()) != null && (decorView = window.getDecorView()) != null) {
            ((b.C8708b) data.c()).b(new WeakReference<>(decorView));
        }
        if (data.c() instanceof b.f) {
            if (this$0.loadingDialog == null) {
                Dialog showLoadingDialog = LoadingUtil.showLoadingDialog(this$0.getContext(), "\u52a0\u8f7d\u4e2d", true);
                showLoadingDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.mobileqq.troop.homework.clockin.detail.part.c
                    @Override // android.content.DialogInterface.OnCancelListener
                    public final void onCancel(DialogInterface dialogInterface) {
                        HWClockInDetailBottomPart.L9(HWClockInDetailBottomPart.this, dialogInterface);
                    }
                });
                this$0.loadingDialog = showLoadingDialog;
            }
            Dialog dialog = this$0.loadingDialog;
            if (dialog != null && !dialog.isShowing()) {
                dialog.show();
            }
            this$0.isJumpingToNotifyPage = true;
            com.tencent.mobileqq.troop.homework.clockin.report.a aVar = com.tencent.mobileqq.troop.homework.clockin.report.a.f296532a;
            QUIButton qUIButton2 = this$0.button;
            if (qUIButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("button");
                qUIButton = null;
            } else {
                qUIButton = qUIButton2;
            }
            h.a.f(aVar, qUIButton, "em_group_remind_confirm", null, null, 12, null);
        }
        BuildersKt__Builders_commonKt.launch$default(com.tencent.mobileqq.troop.homework.common.b.b(this$0), null, null, new HWClockInDetailBottomPart$updateButton$1$4(this$0, data, null), 3, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(HWClockInDetailBottomPart this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isJumpingToNotifyPage = false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView == null) {
            return;
        }
        View findViewById = rootView.findViewById(R.id.t_6);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.bottom_button)");
        this.button = (QUIButton) findViewById;
        View findViewById2 = rootView.findViewById(R.id.acy);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.bottom_layout)");
        this.bottomLayout = findViewById2;
        MutableLiveData<com.tencent.mobileqq.troop.homework.clockin.detail.vm.a> obtainUiState = F9().obtainUiState();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.troop.homework.clockin.detail.vm.a, Unit> function1 = new Function1<com.tencent.mobileqq.troop.homework.clockin.detail.vm.a, Unit>() { // from class: com.tencent.mobileqq.troop.homework.clockin.detail.part.HWClockInDetailBottomPart$onInitView$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWClockInDetailBottomPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.homework.clockin.detail.vm.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.homework.clockin.detail.vm.a it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                if (it instanceof a.l) {
                    HWClockInDetailBottomPart hWClockInDetailBottomPart = HWClockInDetailBottomPart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    hWClockInDetailBottomPart.J9((a.l) it);
                } else if (it instanceof a.h) {
                    HWClockInDetailBottomPart.this.G9(((a.h) it).a());
                } else if (it instanceof a.i) {
                    HWClockInDetailBottomPart.this.H9();
                }
            }
        };
        obtainUiState.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.homework.clockin.detail.part.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HWClockInDetailBottomPart.I9(Function1.this, obj);
            }
        });
    }
}
