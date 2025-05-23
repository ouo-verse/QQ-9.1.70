package com.tencent.mobileqq.stt.sub.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0002&'B\u000f\u0012\u0006\u0010\"\u001a\u00020!\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\b\u001a\u00020\u0002H\u0014R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001d\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/stt/sub/ui/f;", "Lcom/google/android/material/bottomsheet/a;", "", "initView", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "onStart", "Lcom/tencent/mobileqq/stt/sub/ui/f$b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/stt/sub/ui/f$b;", BdhLogUtil.LogTag.Tag_Req, "()Lcom/tencent/mobileqq/stt/sub/ui/f$b;", "X", "(Lcom/tencent/mobileqq/stt/sub/ui/f$b;)V", "listener", "Landroidx/constraintlayout/widget/ConstraintLayout;", "D", "Landroidx/constraintlayout/widget/ConstraintLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "textTitle", UserInfo.SEX_FEMALE, "textSummary", "Landroid/widget/Button;", "G", "Landroid/widget/Button;", "buttonCancel", "H", "buttonConfirm", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "I", "a", "b", "qq-ptt-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class f extends com.google.android.material.bottomsheet.a {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private b listener;

    /* renamed from: D, reason: from kotlin metadata */
    private ConstraintLayout rootView;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView textTitle;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView textSummary;

    /* renamed from: G, reason: from kotlin metadata */
    private Button buttonCancel;

    /* renamed from: H, reason: from kotlin metadata */
    private Button buttonConfirm;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/stt/sub/ui/f$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-ptt-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.stt.sub.ui.f$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/stt/sub/ui/f$b;", "", "", MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM, "", "onDismiss", "qq-ptt-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public interface b {
        void onDismiss(boolean confirm);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/stt/sub/ui/f$c", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$e;", "Landroid/view/View;", "bottomSheet", "", "newState", "", "onStateChanged", "", "slideOffset", "onSlide", "qq-ptt-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c extends BottomSheetBehavior.e {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(@NotNull View bottomSheet, float slideOffset) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, bottomSheet, Float.valueOf(slideOffset));
            } else {
                Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(@NotNull View bottomSheet, int newState) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bottomSheet, newState);
                return;
            }
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (newState == 4) {
                b R = f.this.R();
                if (R != null) {
                    R.onDismiss(false);
                }
                f.this.dismiss();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19538);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private final void Q() {
        Button button = null;
        if (!ThemeUtil.isNowThemeIsNight(null, false, null)) {
            return;
        }
        ConstraintLayout constraintLayout = this.rootView;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            constraintLayout = null;
        }
        constraintLayout.setBackgroundResource(R.drawable.f162430lm0);
        TextView textView = this.textTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textTitle");
            textView = null;
        }
        textView.setTextColor(getContext().getResources().getColor(R.color.f158017al3));
        Button button2 = this.buttonConfirm;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buttonConfirm");
            button2 = null;
        }
        button2.setTextColor(getContext().getResources().getColor(R.color.f158017al3));
        Button button3 = this.buttonCancel;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buttonCancel");
        } else {
            button = button3;
        }
        button.setTextColor(getContext().getResources().getColor(R.color.f158017al3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b bVar = this$0.listener;
        if (bVar != null) {
            bVar.onDismiss(false);
        }
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b bVar = this$0.listener;
        if (bVar != null) {
            bVar.onDismiss(true);
        }
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(f this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b bVar = this$0.listener;
        if (bVar != null) {
            bVar.onDismiss(false);
        }
    }

    private final void initView() {
        Button button = null;
        View inflate = getLayoutInflater().inflate(R.layout.e_x, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.rootView = constraintLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            constraintLayout = null;
        }
        View findViewById = constraintLayout.findViewById(R.id.f95035dw);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.textTitle)");
        this.textTitle = (TextView) findViewById;
        ConstraintLayout constraintLayout2 = this.rootView;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            constraintLayout2 = null;
        }
        View findViewById2 = constraintLayout2.findViewById(R.id.f95025dv);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.textSummary)");
        this.textSummary = (TextView) findViewById2;
        ConstraintLayout constraintLayout3 = this.rootView;
        if (constraintLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            constraintLayout3 = null;
        }
        View findViewById3 = constraintLayout3.findViewById(R.id.tin);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.buttonCancel)");
        Button button2 = (Button) findViewById3;
        this.buttonCancel = button2;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buttonCancel");
            button2 = null;
        }
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.stt.sub.ui.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.S(f.this, view);
            }
        });
        ConstraintLayout constraintLayout4 = this.rootView;
        if (constraintLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            constraintLayout4 = null;
        }
        View findViewById4 = constraintLayout4.findViewById(R.id.tio);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.buttonConfirm)");
        Button button3 = (Button) findViewById4;
        this.buttonConfirm = button3;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buttonConfirm");
        } else {
            button = button3;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.stt.sub.ui.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.U(f.this, view);
            }
        });
        Q();
    }

    @Nullable
    public final b R() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.listener;
    }

    public final void X(@Nullable b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
        } else {
            this.listener = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.bottomsheet.a, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        initView();
        ConstraintLayout constraintLayout = this.rootView;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            constraintLayout = null;
        }
        setContentView(constraintLayout);
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        window.setLayout(-1, -1);
        getBehavior().setState(3);
        getBehavior().setSkipCollapsed(true);
        getBehavior().setPeekHeight(0);
        getBehavior().addBottomSheetCallback(new c());
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.mobileqq.stt.sub.ui.c
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                f.W(f.this, dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.bottomsheet.a, android.app.Dialog
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onStart();
        ConstraintLayout constraintLayout = this.rootView;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            constraintLayout = null;
        }
        ViewParent parent = constraintLayout.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).setBackgroundColor(0);
    }
}
