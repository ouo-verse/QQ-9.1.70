package com.tencent.ecommerce.biz.register.refactoring.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.Observer;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import com.tencent.ecommerce.base.ui.ECBaseDialogFragment;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.biz.register.a;
import com.tencent.ecommerce.biz.register.refactoring.utils.ECRegisterReportScene;
import com.tencent.ecommerce.biz.register.refactoring.utils.ECRegisterSuccessEvent;
import com.tencent.ecommerce.biz.register.refactoring.viewmodel.ECRegisterConfirmViewModel;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 22\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000234B\u0007\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\u001a\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0016\u0010 \u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00065"}, d2 = {"Lcom/tencent/ecommerce/biz/register/refactoring/dialog/ECCheckOriginPhoneNumDialog;", "Lcom/tencent/ecommerce/base/ui/ECBaseDialogFragment;", "Lcom/tencent/ecommerce/biz/register/refactoring/dialog/ECCheckOriginPhoneNumDialog$CheckOriginPhoneNumResult;", "Landroid/view/View;", "view", "", "initUI", "Bh", "initListener", "Eh", "", "tips", "Dh", "", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/tencent/ecommerce/biz/register/refactoring/viewmodel/ECRegisterConfirmViewModel;", "viewModel", "Ch", "Landroid/content/DialogInterface;", "dialog", "onDismiss", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/widget/Button;", "G", "Landroid/widget/Button;", "cancelBtn", "H", "confirmBtn", "I", "sendSmsCodeBtn", "Landroid/widget/TextView;", "J", "Landroid/widget/TextView;", "checkPhoneNumDesTv", "Landroid/widget/EditText;", "K", "Landroid/widget/EditText;", "smsCodeEditTx", "L", "Lcom/tencent/ecommerce/biz/register/refactoring/viewmodel/ECRegisterConfirmViewModel;", "registerConfirmViewModel", "Landroid/os/CountDownTimer;", "M", "Landroid/os/CountDownTimer;", "sendCaptchaCountDownTimer", "<init>", "()V", "N", "CheckOriginPhoneNumResult", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECCheckOriginPhoneNumDialog extends ECBaseDialogFragment<CheckOriginPhoneNumResult> {

    /* renamed from: G, reason: from kotlin metadata */
    private Button cancelBtn;

    /* renamed from: H, reason: from kotlin metadata */
    private Button confirmBtn;

    /* renamed from: I, reason: from kotlin metadata */
    private Button sendSmsCodeBtn;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView checkPhoneNumDesTv;

    /* renamed from: K, reason: from kotlin metadata */
    private EditText smsCodeEditTx;

    /* renamed from: L, reason: from kotlin metadata */
    private ECRegisterConfirmViewModel registerConfirmViewModel;

    /* renamed from: M, reason: from kotlin metadata */
    private CountDownTimer sendCaptchaCountDownTimer;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b6\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/ecommerce/biz/register/refactoring/dialog/ECCheckOriginPhoneNumDialog$CheckOriginPhoneNumResult;", "Landroid/os/Parcelable;", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static abstract class CheckOriginPhoneNumResult implements Parcelable {
        CheckOriginPhoneNumResult() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECCheckOriginPhoneNumDialog.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECCheckOriginPhoneNumDialog.wh(ECCheckOriginPhoneNumDialog.this).r2();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            String obj = ECCheckOriginPhoneNumDialog.yh(ECCheckOriginPhoneNumDialog.this).getText().toString();
            if (obj.length() > 0) {
                ECCheckOriginPhoneNumDialog.wh(ECCheckOriginPhoneNumDialog.this).q2(obj);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e<T> implements Observer<Boolean> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Boolean bool) {
            if (bool.booleanValue()) {
                ECCheckOriginPhoneNumDialog.this.Eh();
            } else {
                ECCheckOriginPhoneNumDialog eCCheckOriginPhoneNumDialog = ECCheckOriginPhoneNumDialog.this;
                eCCheckOriginPhoneNumDialog.Dh(eCCheckOriginPhoneNumDialog.getResources().getString(R.string.weu));
                Button xh5 = ECCheckOriginPhoneNumDialog.xh(ECCheckOriginPhoneNumDialog.this);
                xh5.setEnabled(true);
                xh5.setText(xh5.getResources().getString(R.string.wdn));
                xh5.setBackground(ResourcesCompat.getDrawable(xh5.getResources(), R.drawable.bx6, null));
            }
            a.f103962b.j(1, ECRegisterReportScene.SEND_SMS_CODE_BY_SESSION.sceneType, !bool.booleanValue() ? 1 : 0);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/ecommerce/biz/register/refactoring/dialog/ECCheckOriginPhoneNumDialog$f", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "onFinish", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f extends CountDownTimer {
        f(long j3, long j16) {
            super(j3, j16);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Button xh5 = ECCheckOriginPhoneNumDialog.xh(ECCheckOriginPhoneNumDialog.this);
            xh5.setEnabled(true);
            xh5.setText(xh5.getResources().getString(R.string.wdn));
            xh5.setBackground(ECSkin.INSTANCE.getDrawable(R.drawable.bx6));
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            Button xh5 = ECCheckOriginPhoneNumDialog.xh(ECCheckOriginPhoneNumDialog.this);
            xh5.setEnabled(false);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(ECCheckOriginPhoneNumDialog.this.requireContext().getString(R.string.f169580we4), Arrays.copyOf(new Object[]{Long.valueOf(millisUntilFinished / 1000)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            xh5.setText(format);
            xh5.setBackground(ECSkin.INSTANCE.getDrawable(R.drawable.bx5));
        }
    }

    private final void Bh() {
        ECRegisterConfirmViewModel eCRegisterConfirmViewModel = this.registerConfirmViewModel;
        if (eCRegisterConfirmViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("registerConfirmViewModel");
        }
        eCRegisterConfirmViewModel.h2().observe(getViewLifecycleOwner(), new e());
        ECRegisterConfirmViewModel eCRegisterConfirmViewModel2 = this.registerConfirmViewModel;
        if (eCRegisterConfirmViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("registerConfirmViewModel");
        }
        eCRegisterConfirmViewModel2.d2().observe(getViewLifecycleOwner(), new Observer<Integer>() { // from class: com.tencent.ecommerce.biz.register.refactoring.dialog.ECCheckOriginPhoneNumDialog$initObserve$2
            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void onChanged(Integer num) {
                a.f103962b.j(1, ECRegisterReportScene.REGISTER_BY_SESSION.sceneType, num.intValue());
                if (num.intValue() == 0) {
                    Dialog dialog = ECCheckOriginPhoneNumDialog.this.getDialog();
                    if (dialog != null) {
                        dialog.hide();
                    }
                    final ECRegisterSuccessDialog eCRegisterSuccessDialog = new ECRegisterSuccessDialog();
                    new Handler().postDelayed(new Runnable() { // from class: com.tencent.ecommerce.biz.register.refactoring.dialog.ECCheckOriginPhoneNumDialog$initObserve$2$runnable$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            ECRegisterSuccessDialog.this.dismiss();
                            yi0.a.r(Uri.parse(String.valueOf(5)));
                            LifecycleEventBus.f100688b.f(new ECRegisterSuccessEvent(true));
                        }
                    }, 800L);
                    return;
                }
                if (num.intValue() == 5) {
                    ECCheckOriginPhoneNumDialog eCCheckOriginPhoneNumDialog = ECCheckOriginPhoneNumDialog.this;
                    eCCheckOriginPhoneNumDialog.Dh(eCCheckOriginPhoneNumDialog.getResources().getString(R.string.wer));
                } else if (num.intValue() == 7) {
                    ECCheckOriginPhoneNumDialog eCCheckOriginPhoneNumDialog2 = ECCheckOriginPhoneNumDialog.this;
                    eCCheckOriginPhoneNumDialog2.Dh(eCCheckOriginPhoneNumDialog2.getResources().getString(R.string.wes));
                } else {
                    ECCheckOriginPhoneNumDialog eCCheckOriginPhoneNumDialog3 = ECCheckOriginPhoneNumDialog.this;
                    eCCheckOriginPhoneNumDialog3.Dh(eCCheckOriginPhoneNumDialog3.getResources().getString(R.string.wet));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Dh(final String tips) {
        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.dialog.ECCheckOriginPhoneNumDialog$showTips$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                i.f101155b.d(tips, ECToastIcon.ICON_ERROR, 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Eh() {
        f fVar = new f(60000L, 1000L);
        this.sendCaptchaCountDownTimer = fVar;
        fVar.start();
    }

    private final void initListener() {
        Button button = this.cancelBtn;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelBtn");
        }
        button.setOnClickListener(new b());
        Button button2 = this.sendSmsCodeBtn;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendSmsCodeBtn");
        }
        button2.setOnClickListener(new c());
        Button button3 = this.confirmBtn;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
        }
        button3.setOnClickListener(new d());
    }

    public static final /* synthetic */ ECRegisterConfirmViewModel wh(ECCheckOriginPhoneNumDialog eCCheckOriginPhoneNumDialog) {
        ECRegisterConfirmViewModel eCRegisterConfirmViewModel = eCCheckOriginPhoneNumDialog.registerConfirmViewModel;
        if (eCRegisterConfirmViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("registerConfirmViewModel");
        }
        return eCRegisterConfirmViewModel;
    }

    public static final /* synthetic */ Button xh(ECCheckOriginPhoneNumDialog eCCheckOriginPhoneNumDialog) {
        Button button = eCCheckOriginPhoneNumDialog.sendSmsCodeBtn;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendSmsCodeBtn");
        }
        return button;
    }

    public static final /* synthetic */ EditText yh(ECCheckOriginPhoneNumDialog eCCheckOriginPhoneNumDialog) {
        EditText editText = eCCheckOriginPhoneNumDialog.smsCodeEditTx;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("smsCodeEditTx");
        }
        return editText;
    }

    public final void Ch(ECRegisterConfirmViewModel viewModel) {
        this.registerConfirmViewModel = viewModel;
    }

    @Override // com.tencent.ecommerce.base.ui.ECBaseDialogFragment
    public int getContentLayoutId() {
        return R.layout.cqk;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        CountDownTimer countDownTimer = this.sendCaptchaCountDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        super.onDestroy();
    }

    @Override // com.tencent.ecommerce.base.ui.ECBaseDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        CountDownTimer countDownTimer = this.sendCaptchaCountDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        super.onDismiss(dialog);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
        Bh();
        initListener();
        ECRegisterConfirmViewModel eCRegisterConfirmViewModel = this.registerConfirmViewModel;
        if (eCRegisterConfirmViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("registerConfirmViewModel");
        }
        eCRegisterConfirmViewModel.r2();
    }

    private final void initUI(View view) {
        this.cancelBtn = (Button) view.findViewById(R.id.nwb);
        this.confirmBtn = (Button) view.findViewById(R.id.nwe);
        this.sendSmsCodeBtn = (Button) view.findViewById(R.id.nwc);
        this.checkPhoneNumDesTv = (TextView) view.findViewById(R.id.nwf);
        this.smsCodeEditTx = (EditText) view.findViewById(R.id.nwd);
        TextView textView = this.checkPhoneNumDesTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkPhoneNumDesTv");
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getResources().getString(R.string.wh_);
        Object[] objArr = new Object[1];
        ECRegisterConfirmViewModel eCRegisterConfirmViewModel = this.registerConfirmViewModel;
        if (eCRegisterConfirmViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("registerConfirmViewModel");
        }
        objArr[0] = eCRegisterConfirmViewModel.getOriginPhoneNum();
        String format = String.format(string, Arrays.copyOf(objArr, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        textView.setText(format);
    }
}
