package com.tencent.mobileqq.studymode;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.l;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J(\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010$\u001a\u00020 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\u0017\u001a\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/studymode/StudyModeSwitchDialog;", "Landroid/app/Dialog;", "Lcom/tencent/mobileqq/studymode/l$a;", "", "initView", "Z", "", "targetType", "oldType", "Aa", "", "isSuccess", "", "message", "j7", "W1", "ed", "Lcom/tencent/mobileqq/app/BaseActivity;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/app/BaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/widget/ImageView;", "D", "Lkotlin/Lazy;", ExifInterface.LATITUDE_SOUTH, "()Landroid/widget/ImageView;", "ivClose", "Landroid/widget/Button;", "E", BdhLogUtil.LogTag.Tag_Req, "()Landroid/widget/Button;", "btnSwitchOn", "Lcom/tencent/mobileqq/studymode/l;", UserInfo.SEX_FEMALE, "U", "()Lcom/tencent/mobileqq/studymode/l;", "manager", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "G", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "loadingDialog", "<init>", "(Lcom/tencent/mobileqq/app/BaseActivity;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class StudyModeSwitchDialog extends ReportDialog implements l.a {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final BaseActivity activity;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy ivClose;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy btnSwitchOn;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy manager;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private QQProgressDialog loadingDialog;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StudyModeSwitchDialog(@NotNull BaseActivity activity) {
        super(activity, R.style.f173448dl);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(activity, "activity");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
            return;
        }
        this.activity = activity;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.studymode.StudyModeSwitchDialog$ivClose$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) StudyModeSwitchDialog.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (ImageView) StudyModeSwitchDialog.this.findViewById(R.id.dum) : (ImageView) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.ivClose = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Button>() { // from class: com.tencent.mobileqq.studymode.StudyModeSwitchDialog$btnSwitchOn$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) StudyModeSwitchDialog.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Button invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (Button) StudyModeSwitchDialog.this.findViewById(R.id.tha) : (Button) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.btnSwitchOn = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<l>() { // from class: com.tencent.mobileqq.studymode.StudyModeSwitchDialog$manager$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) StudyModeSwitchDialog.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final l invoke() {
                BaseActivity baseActivity;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (l) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                baseActivity = StudyModeSwitchDialog.this.activity;
                Manager manager = baseActivity.app.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER);
                Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.studymode.ModeSwitchManager");
                return (l) manager;
            }
        });
        this.manager = lazy3;
        Window window = getWindow();
        if (window != null) {
            if (ImmersiveUtils.isSupporImmersive() == 1) {
                window.addFlags(67108864);
            }
            ImmersiveUtils.clearCoverForStatus(window, true);
        }
        setContentView(R.layout.e3m);
        initView();
        U().d(this);
        ReportController.o(activity.app, "dc00898", "", "", "0X800ADD4", "0X800ADD4", 0, 0, "", "", "", "");
    }

    private final Button R() {
        Object value = this.btnSwitchOn.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-btnSwitchOn>(...)");
        return (Button) value;
    }

    private final ImageView S() {
        Object value = this.ivClose.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-ivClose>(...)");
        return (ImageView) value;
    }

    private final l U() {
        return (l) this.manager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(StudyModeSwitchDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        ReportController.o(this$0.activity.app, "dc00898", "", "", "0X800ADD6", "0X800ADD6", 0, 0, "", "", "", "");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(StudyModeSwitchDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Z();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(StudyModeSwitchDialog this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.U().v(this$0);
    }

    private final void Z() {
        if (U().o()) {
            QQToast.makeText(this.activity, 0, R.string.f173119hi2, 0).show();
            return;
        }
        if (g.a() == 2) {
            QQToast.makeText(this.activity, 0, R.string.f229556wr, 0).show();
            dismiss();
            return;
        }
        l.b f16 = U().f(this.activity, 2, SimpleUIUtil.getSimpleUIPref(), true);
        if (!f16.c() && f16.b() == f16.a()) {
            QQToast.makeText(this.activity, 0, R.string.f229556wr, 0).show();
            dismiss();
        }
        ReportController.o(this.activity.app, "dc00898", "", "", "0X800ADD5", "0X800ADD5", 0, 0, "", "", "", "");
    }

    private final void initView() {
        S().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.studymode.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StudyModeSwitchDialog.W(StudyModeSwitchDialog.this, view);
            }
        });
        R().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.studymode.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StudyModeSwitchDialog.X(StudyModeSwitchDialog.this, view);
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.studymode.z
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                StudyModeSwitchDialog.Y(StudyModeSwitchDialog.this, dialogInterface);
            }
        });
    }

    @Override // com.tencent.mobileqq.studymode.l.a
    public void Aa(int targetType, int oldType) {
        QQProgressDialog qQProgressDialog;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(targetType), Integer.valueOf(oldType));
            return;
        }
        QQProgressDialog qQProgressDialog2 = this.loadingDialog;
        if (qQProgressDialog2 == null || !qQProgressDialog2.isShowing()) {
            z16 = false;
        }
        if (z16 && (qQProgressDialog = this.loadingDialog) != null) {
            qQProgressDialog.dismiss();
        }
        QQProgressDialog qQProgressDialog3 = new QQProgressDialog(this.activity);
        this.loadingDialog = qQProgressDialog3;
        Intrinsics.checkNotNull(qQProgressDialog3);
        Window window = qQProgressDialog3.getWindow();
        if (window != null) {
            window.setDimAmount(0.0f);
        }
        qQProgressDialog3.show();
    }

    @Override // com.tencent.mobileqq.studymode.l.a
    public void C6(boolean z16, @NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), obj);
        } else {
            l.a.C8630a.a(this, z16, obj);
        }
    }

    @Override // com.tencent.mobileqq.studymode.l.a
    public void W1(int targetType, int oldType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(targetType), Integer.valueOf(oldType));
            return;
        }
        QQProgressDialog qQProgressDialog = this.loadingDialog;
        if (qQProgressDialog != null) {
            qQProgressDialog.dismiss();
        }
    }

    @Override // com.tencent.mobileqq.studymode.l.a
    public void ed(int targetType, int oldType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(targetType), Integer.valueOf(oldType));
        } else {
            QQToast.makeText(this.activity, 0, R.string.f173119hi2, 0).show();
        }
    }

    @Override // com.tencent.mobileqq.studymode.l.a
    public void j7(boolean isSuccess, int targetType, int oldType, @NotNull String message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(isSuccess), Integer.valueOf(targetType), Integer.valueOf(oldType), message);
            return;
        }
        Intrinsics.checkNotNullParameter(message, "message");
        if (!TextUtils.isEmpty(message)) {
            BaseActivity baseActivity = this.activity;
            if (!isSuccess) {
                i3 = 1;
            }
            QQToast.makeText(baseActivity, i3, message, 0).show();
        }
        QQProgressDialog qQProgressDialog = this.loadingDialog;
        if (qQProgressDialog != null) {
            qQProgressDialog.dismiss();
        }
        dismiss();
    }

    @Override // com.tencent.mobileqq.studymode.l.a
    public void wa(boolean z16, boolean z17, boolean z18, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i3));
        } else {
            l.a.C8630a.b(this, z16, z17, z18, i3);
        }
    }
}
