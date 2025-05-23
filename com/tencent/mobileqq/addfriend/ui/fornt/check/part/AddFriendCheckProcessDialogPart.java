package com.tencent.mobileqq.addfriend.ui.fornt.check.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001c\u0010\r\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/addfriend/ui/fornt/check/part/AddFriendCheckProcessDialogPart;", "Lcom/tencent/mobileqq/addfriend/ui/fornt/check/part/a;", "", "initViewModel", "O9", "Q9", "", "hide", "N9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Lcom/tencent/mobileqq/addfriend/ui/fornt/check/viewmodel/a;", "K", "Lcom/tencent/mobileqq/addfriend/ui/fornt/check/viewmodel/a;", "viewModel", "Lcom/tencent/mobileqq/addfriend/part/b;", "L", "Lcom/tencent/mobileqq/addfriend/part/b;", "mOpenAddFriendViewModel", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "M", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "mProgressDialog", "<init>", "()V", "N", "a", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AddFriendCheckProcessDialogPart extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.addfriend.ui.fornt.check.viewmodel.a viewModel;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.addfriend.part.b mOpenAddFriendViewModel;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private QQProgressDialog mProgressDialog;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/addfriend/ui/fornt/check/part/AddFriendCheckProcessDialogPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.addfriend.ui.fornt.check.part.AddFriendCheckProcessDialogPart$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21989);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AddFriendCheckProcessDialogPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N9(boolean hide) {
        QQProgressDialog qQProgressDialog;
        if (QLog.isColorLevel()) {
            QLog.i("AddFriendCheckProcessDialogPart", 2, "dismissOrHideProgress hide: " + hide);
        }
        QQProgressDialog qQProgressDialog2 = this.mProgressDialog;
        if (qQProgressDialog2 != null) {
            if (!qQProgressDialog2.isShowing()) {
                qQProgressDialog2 = null;
            }
            if (qQProgressDialog2 != null && (qQProgressDialog = this.mProgressDialog) != null) {
                if (hide) {
                    qQProgressDialog.hide();
                } else {
                    qQProgressDialog.dismiss();
                }
            }
        }
    }

    private final void O9() {
        final LifecycleOwner lifecycleOwner;
        com.tencent.mobileqq.addfriend.ui.fornt.check.viewmodel.a aVar;
        MutableLiveData<Integer> L1;
        String str;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("setObserver: ");
            com.tencent.mobileqq.addfriend.ui.fornt.check.viewmodel.a aVar2 = this.viewModel;
            String str2 = null;
            if (aVar2 != null) {
                str = aVar2.toString();
            } else {
                str = null;
            }
            sb5.append(str);
            sb5.append(",  ");
            com.tencent.mobileqq.addfriend.part.b bVar = this.mOpenAddFriendViewModel;
            if (bVar != null) {
                str2 = bVar.toString();
            }
            sb5.append(str2);
            QLog.i("AddFriendCheckProcessDialogPart", 2, sb5.toString());
        }
        IPartHost partHost = getPartHost();
        if (partHost != null && (lifecycleOwner = partHost.getLifecycleOwner()) != null && (aVar = this.viewModel) != null && (L1 = aVar.L1()) != null) {
            final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>(this) { // from class: com.tencent.mobileqq.addfriend.ui.fornt.check.part.AddFriendCheckProcessDialogPart$setObserver$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ AddFriendCheckProcessDialogPart this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) LifecycleOwner.this, (Object) this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke2(num);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Integer num) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) num);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("AddFriendCheckProcessDialogPart", 2, "Add Friend Check dialog state change " + LifecycleOwner.this);
                    }
                    if (num != null && num.intValue() == 2) {
                        this.this$0.N9(true);
                        return;
                    }
                    if (num != null && num.intValue() == 0) {
                        this.this$0.N9(false);
                    } else if (num != null && num.intValue() == 1) {
                        this.this$0.Q9();
                    }
                }
            };
            L1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.addfriend.ui.fornt.check.part.b
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AddFriendCheckProcessDialogPart.P9(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q9() {
        Window window;
        QBaseActivity qBaseActivity;
        if (G9()) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("AddFriendCheckProcessDialogPart", 2, "showProgress");
        }
        if (getActivity() != null && !getActivity().isFinishing()) {
            if (this.mProgressDialog == null) {
                Activity activity = getActivity();
                QQProgressDialog qQProgressDialog = null;
                if (activity instanceof QBaseActivity) {
                    qBaseActivity = (QBaseActivity) activity;
                } else {
                    qBaseActivity = null;
                }
                if (qBaseActivity != null) {
                    qQProgressDialog = new QQProgressDialog(getActivity(), qBaseActivity.getTitleBarHeight());
                }
                this.mProgressDialog = qQProgressDialog;
                if (qQProgressDialog != null) {
                    qQProgressDialog.O(new QQProgressDialog.b() { // from class: com.tencent.mobileqq.addfriend.ui.fornt.check.part.c
                        @Override // com.tencent.mobileqq.widget.QQProgressDialog.b
                        public final void onBackPressed() {
                            AddFriendCheckProcessDialogPart.R9(AddFriendCheckProcessDialogPart.this);
                        }
                    });
                }
            }
            QQProgressDialog qQProgressDialog2 = this.mProgressDialog;
            if (qQProgressDialog2 != null) {
                qQProgressDialog2.setMessage(R.string.bj_);
            }
            QQProgressDialog qQProgressDialog3 = this.mProgressDialog;
            if (qQProgressDialog3 != null && (window = qQProgressDialog3.getWindow()) != null) {
                window.setDimAmount(0.0f);
            }
            QQProgressDialog qQProgressDialog4 = this.mProgressDialog;
            if (qQProgressDialog4 != null) {
                qQProgressDialog4.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(AddFriendCheckProcessDialogPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.addfriend.part.b bVar = this$0.mOpenAddFriendViewModel;
        if (bVar != null) {
            bVar.L1(4, "");
        }
        this$0.getActivity().onBackPressed();
        QQProgressDialog qQProgressDialog = this$0.mProgressDialog;
        if (qQProgressDialog != null) {
            qQProgressDialog.O(null);
        }
    }

    private final void initViewModel() {
        this.viewModel = (com.tencent.mobileqq.addfriend.ui.fornt.check.viewmodel.a) getViewModel(com.tencent.mobileqq.addfriend.ui.fornt.check.viewmodel.a.class);
        this.mOpenAddFriendViewModel = (com.tencent.mobileqq.addfriend.part.b) getViewModel(com.tencent.mobileqq.addfriend.part.b.class);
        O9();
    }

    @Override // com.tencent.mobileqq.addfriend.ui.fornt.check.part.a, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
        } else {
            super.onPartCreate(activity, savedInstanceState);
            initViewModel();
        }
    }
}
