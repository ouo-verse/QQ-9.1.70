package com.tencent.mobileqq.exportfile.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.exportfile.global.QFileBridgeService;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.ConfigClearableEditText;
import com.tencent.mobileqq.widget.PastablePwdEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.util.LoadingUtil;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RoutePage(desc = "\u5bfc\u51fa\u7535\u8111\u6587\u4ef6\u8f93\u5165\u5bc6\u7801\u9875", path = "/export_file/input_pwd")
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 82\u00020\u00012\u00020\u00022\u00020\u0003:\u00019B\u0007\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0013H\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0013H\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\b\u0010 \u001a\u00020\u0004H\u0016R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R#\u0010/\u001a\n **\u0004\u0018\u00010)0)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00104\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/exportfile/fragment/ExportFileInputPwdFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/exportfile/fragment/w;", "", "initPasswordArea", "updatePwdStates", "showPasswordEditTextHint", "updateLoginBtnAndPasswordEditTextStatus", "updatePasswordTextSize", "", "getInputPassword", "disconnect", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onAttach", "onResume", "v", NodeProps.ON_CLICK, "view", "onBackClick", "", "onBackEvent", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lm53/c;", "binding", "Lm53/c;", "Landroid/view/inputmethod/InputMethodManager;", "inputManager", "Landroid/view/inputmethod/InputMethodManager;", "mIsShowingPassword", "Z", "Landroid/app/Dialog;", "kotlin.jvm.PlatformType", "loadingDialog$delegate", "Lkotlin/Lazy;", "getLoadingDialog", "()Landroid/app/Dialog;", "loadingDialog", "Landroid/text/TextWatcher;", "onTextChangedListenerForPwd", "Landroid/text/TextWatcher;", "Landroid/view/View$OnFocusChangeListener;", "mFocusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "<init>", "()V", "Companion", "a", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class ExportFileInputPwdFragment extends QPublicBaseFragment implements View.OnClickListener, w {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "ExportFileInputPwdFragment";
    private m53.c binding;
    private InputMethodManager inputManager;

    /* renamed from: loadingDialog$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy loadingDialog;

    @NotNull
    private final View.OnFocusChangeListener mFocusChangeListener;
    private boolean mIsShowingPassword;

    @NotNull
    private final TextWatcher onTextChangedListenerForPwd;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/exportfile/fragment/ExportFileInputPwdFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.exportfile.fragment.ExportFileInputPwdFragment$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
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

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/exportfile/fragment/ExportFileInputPwdFragment$b", "Lcom/tencent/mobileqq/widget/ConfigClearableEditText$d;", "", NodeProps.VISIBLE, "", "Af", "", "w9", "pressed", "Mg", "v2", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements ConfigClearableEditText.d {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ExportFileInputPwdFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.ConfigClearableEditText.d
        public void Af(boolean visible) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                m53.c cVar = ExportFileInputPwdFragment.this.binding;
                if (cVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    cVar = null;
                }
                ImageView imageView = cVar.f416200e;
                if (visible) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                imageView.setVisibility(i3);
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, visible);
        }

        @Override // com.tencent.mobileqq.widget.ConfigClearableEditText.d
        public void Mg(boolean pressed) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, pressed);
                return;
            }
            m53.c cVar = null;
            if (pressed) {
                m53.c cVar2 = ExportFileInputPwdFragment.this.binding;
                if (cVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    cVar = cVar2;
                }
                cVar.f416200e.setAlpha(0.5f);
                return;
            }
            m53.c cVar3 = ExportFileInputPwdFragment.this.binding;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                cVar = cVar3;
            }
            cVar.f416200e.setAlpha(1.0f);
        }

        @Override // com.tencent.mobileqq.widget.ConfigClearableEditText.d
        public void v2() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                m53.c cVar = ExportFileInputPwdFragment.this.binding;
                if (cVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    cVar = null;
                }
                cVar.f416200e.setAlpha(1.0f);
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this);
        }

        @Override // com.tencent.mobileqq.widget.ConfigClearableEditText.d
        public int w9() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return ViewUtils.dpToPx(16.0f);
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J(\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/exportfile/fragment/ExportFileInputPwdFragment$c", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements TextWatcher {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ExportFileInputPwdFragment.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NotNull Editable s16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) s16);
                return;
            }
            Intrinsics.checkNotNullParameter(s16, "s");
            QLog.d(ExportFileInputPwdFragment.TAG, 2, "afterTextChanged mPasswordEditText");
            ExportFileInputPwdFragment.this.updateLoginBtnAndPasswordEditTextStatus();
            ExportFileInputPwdFragment.this.updatePasswordTextSize();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@NotNull CharSequence s16, int start, int count, int after) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, s16, Integer.valueOf(start), Integer.valueOf(count), Integer.valueOf(after));
            } else {
                Intrinsics.checkNotNullParameter(s16, "s");
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@NotNull CharSequence s16, int start, int before, int count) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, s16, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
                return;
            }
            Intrinsics.checkNotNullParameter(s16, "s");
            QLog.d(ExportFileInputPwdFragment.TAG, 2, "onTextChanged mPasswordEditText");
            ExportFileInputPwdFragment.this.updatePwdStates();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19940);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ExportFileInputPwdFragment() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<Dialog>() { // from class: com.tencent.mobileqq.exportfile.fragment.ExportFileInputPwdFragment$loadingDialog$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ExportFileInputPwdFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Dialog invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? LoadingUtil.createLoadingDialog(ExportFileInputPwdFragment.this.requireContext(), "\u8bf7\u7a0d\u540e", true) : (Dialog) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.loadingDialog = lazy;
            this.onTextChangedListenerForPwd = new c();
            this.mFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.tencent.mobileqq.exportfile.fragment.q
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z16) {
                    ExportFileInputPwdFragment.mFocusChangeListener$lambda$0(ExportFileInputPwdFragment.this, view, z16);
                }
            };
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void disconnect() {
        QFileBridgeService.f205517a.x(100107);
    }

    private final String getInputPassword() {
        m53.c cVar = this.binding;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar = null;
        }
        return cVar.f416201f.getText().toString();
    }

    private final Dialog getLoadingDialog() {
        return (Dialog) this.loadingDialog.getValue();
    }

    private final void initPasswordArea() {
        m53.c cVar = this.binding;
        m53.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar = null;
        }
        cVar.f416198c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.exportfile.fragment.p
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                ExportFileInputPwdFragment.initPasswordArea$lambda$6(compoundButton, z16);
            }
        });
        m53.c cVar3 = this.binding;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar3 = null;
        }
        cVar3.f416200e.setOnClickListener(this);
        m53.c cVar4 = this.binding;
        if (cVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar4 = null;
        }
        cVar4.f416201f.setCustomClearButtonCallback(new b());
        m53.c cVar5 = this.binding;
        if (cVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar5 = null;
        }
        cVar5.f416201f.setHintTextColor(getResources().getColor(R.color.qui_common_text_tertiary));
        showPasswordEditTextHint();
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                Method method = View.class.getMethod("setImportantForAutofill", Integer.TYPE);
                m53.c cVar6 = this.binding;
                if (cVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    cVar6 = null;
                }
                method.invoke(cVar6.f416201f, 8);
            } catch (Exception e16) {
                QLog.w(TAG, 2, "disable auto fill error", e16);
            }
        }
        m53.c cVar7 = this.binding;
        if (cVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar7 = null;
        }
        cVar7.f416201f.addTextChangedListener(this.onTextChangedListenerForPwd);
        m53.c cVar8 = this.binding;
        if (cVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar8 = null;
        }
        cVar8.f416201f.setOnFocusChangeListener(this.mFocusChangeListener);
        m53.c cVar9 = this.binding;
        if (cVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar9 = null;
        }
        cVar9.f416201f.setLongClickable(true);
        m53.c cVar10 = this.binding;
        if (cVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar10 = null;
        }
        cVar10.f416202g.setOnClickListener(this);
        m53.c cVar11 = this.binding;
        if (cVar11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar11 = null;
        }
        cVar11.f416197b.setOnClickListener(this);
        m53.c cVar12 = this.binding;
        if (cVar12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            cVar2 = cVar12;
        }
        cVar2.f416203h.setOnClickListener(this);
        updatePwdStates();
        updateLoginBtnAndPasswordEditTextStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initPasswordArea$lambda$6(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        com.tencent.mobileqq.wifiphoto.data.a.e("em_bas_non_encryption_check", "pg_bas_access_computer_files", null, 4, null);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mFocusChangeListener$lambda$0(ExportFileInputPwdFragment this$0, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(TAG, 1, "mPasswordEditText onFocusChange hasFocus=" + z16);
        this$0.updatePwdStates();
        if (z16) {
            m53.c cVar = this$0.binding;
            m53.c cVar2 = null;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                cVar = null;
            }
            PastablePwdEditText pastablePwdEditText = cVar.f416201f;
            m53.c cVar3 = this$0.binding;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                cVar3 = null;
            }
            pastablePwdEditText.setSelection(cVar3.f416201f.length());
            InputMethodManager inputMethodManager = this$0.inputManager;
            if (inputMethodManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputManager");
                inputMethodManager = null;
            }
            m53.c cVar4 = this$0.binding;
            if (cVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                cVar4 = null;
            }
            if (inputMethodManager.isActive(cVar4.f416201f)) {
                InputMethodManager inputMethodManager2 = this$0.inputManager;
                if (inputMethodManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inputManager");
                    inputMethodManager2 = null;
                }
                m53.c cVar5 = this$0.binding;
                if (cVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    cVar5 = null;
                }
                inputMethodManager2.showSoftInput(cVar5.f416201f, 2);
            }
            m53.c cVar6 = this$0.binding;
            if (cVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                cVar2 = cVar6;
            }
            cVar2.f416201f.setHint("");
            return;
        }
        this$0.showPasswordEditTextHint();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onAttach$lambda$1(View view, ExportFileInputPwdFragment this$0, View view2, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getAction() == 1) {
            view2.getWindowVisibleDisplayFrame(new Rect());
            if (motionEvent.getY() > r0.top && motionEvent.getY() < r0.bottom) {
                Object systemService = view2.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
                m53.c cVar = this$0.binding;
                if (cVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    cVar = null;
                }
                cVar.f416201f.clearFocus();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onClick$lambda$4(final ExportFileInputPwdFragment this$0, final View v3, final int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v3, "$v");
        QLog.i(TAG, 2, "authenticateWithPassword result=" + i3 + ", msg: " + str);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.exportfile.fragment.o
            @Override // java.lang.Runnable
            public final void run() {
                ExportFileInputPwdFragment.onClick$lambda$4$lambda$3(ExportFileInputPwdFragment.this, i3, v3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onClick$lambda$4$lambda$3(final ExportFileInputPwdFragment this$0, final int i3, View v3) {
        int i16;
        int i17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v3, "$v");
        this$0.getLoadingDialog().dismiss();
        if (i3 != 0) {
            if (i3 != 100007) {
                if (i3 == 100004) {
                    i16 = R.string.f2318172v;
                    i17 = R.string.zoe;
                } else {
                    i16 = R.string.f2318372x;
                    i17 = R.string.zod;
                }
                if (this$0.isAdded()) {
                    DialogHelperKt.i(this$0, i16, i17).setPositiveButton(R.string.prz, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.exportfile.fragment.m
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i18) {
                            ExportFileInputPwdFragment.onClick$lambda$4$lambda$3$lambda$2(i3, this$0, dialogInterface, i18);
                        }
                    }).show();
                    return;
                }
                return;
            }
            QQToast.makeText(v3.getContext(), 1, "\u6388\u6743\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5", 0).show();
            return;
        }
        Fragment parentFragment = this$0.getParentFragment();
        if (parentFragment != null) {
            com.tencent.mobileqq.exportfile.fragment.c.c(parentFragment, "/export_file/browser_file", null, 2, null);
        }
        QQToast.makeText(v3.getContext(), 2, "\u6388\u6743\u6210\u529f", 0).show();
        Dialog loadingDialog = this$0.getLoadingDialog();
        if (loadingDialog != null) {
            loadingDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onClick$lambda$4$lambda$3$lambda$2(int i3, ExportFileInputPwdFragment this$0, DialogInterface dialogInterface, int i16) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 100004 && (activity = this$0.getActivity()) != null) {
            activity.finish();
        }
    }

    private final void showPasswordEditTextHint() {
        m53.c cVar = this.binding;
        m53.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar = null;
        }
        PastablePwdEditText pastablePwdEditText = cVar.f416201f;
        m53.c cVar3 = this.binding;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar3 = null;
        }
        pastablePwdEditText.setContentDescription(cVar3.getRoot().getResources().getString(R.string.f211465kw));
        m53.c cVar4 = this.binding;
        if (cVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            cVar2 = cVar4;
        }
        cVar2.f416201f.setHint(R.string.f160801w0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateLoginBtnAndPasswordEditTextStatus() {
        m53.c cVar = null;
        if (!TextUtils.isEmpty(getInputPassword())) {
            m53.c cVar2 = this.binding;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                cVar = cVar2;
            }
            cVar.f416197b.o();
            return;
        }
        m53.c cVar3 = this.binding;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            cVar = cVar3;
        }
        cVar.f416197b.setBackgroundDisabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePasswordTextSize() {
        m53.c cVar = null;
        if (TextUtils.isEmpty(getInputPassword())) {
            m53.c cVar2 = this.binding;
            if (cVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                cVar = cVar2;
            }
            cVar.f416201f.setTextSize(17.0f);
            return;
        }
        m53.c cVar3 = this.binding;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            cVar = cVar3;
        }
        cVar.f416201f.setTextSize(20.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePwdStates() {
        m53.c cVar = this.binding;
        m53.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar = null;
        }
        if (cVar.f416201f.isFocused()) {
            m53.c cVar3 = this.binding;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                cVar3 = null;
            }
            cVar3.f416202g.setVisibility(0);
        } else {
            m53.c cVar4 = this.binding;
            if (cVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                cVar4 = null;
            }
            cVar4.f416202g.setVisibility(8);
        }
        if (this.mIsShowingPassword) {
            m53.c cVar5 = this.binding;
            if (cVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                cVar5 = null;
            }
            cVar5.f416201f.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            m53.c cVar6 = this.binding;
            if (cVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                cVar6 = null;
            }
            cVar6.f416202g.setImageResource(R.drawable.qui_eye_on_secondary_01_selector);
            m53.c cVar7 = this.binding;
            if (cVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                cVar2 = cVar7;
            }
            cVar2.f416202g.setContentDescription(HardCodeUtil.qqStr(R.string.zwm));
            return;
        }
        m53.c cVar8 = this.binding;
        if (cVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar8 = null;
        }
        cVar8.f416201f.setTransformationMethod(PasswordTransformationMethod.getInstance());
        m53.c cVar9 = this.binding;
        if (cVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar9 = null;
        }
        cVar9.f416202g.setImageResource(R.drawable.qui_eye_off_secondary_01_selector);
        m53.c cVar10 = this.binding;
        if (cVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            cVar2 = cVar10;
        }
        cVar2.f416202g.setContentDescription(HardCodeUtil.qqStr(R.string.zwg));
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onAttach(activity);
        final View rootView = activity.getWindow().getDecorView().getRootView();
        rootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.exportfile.fragment.n
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean onAttach$lambda$1;
                onAttach$lambda$1 = ExportFileInputPwdFragment.onAttach$lambda$1(rootView, this, view, motionEvent);
                return onAttach$lambda$1;
            }
        });
    }

    @Override // com.tencent.mobileqq.exportfile.fragment.w
    public void onBackClick(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
            disconnect();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        disconnect();
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull final View v3) {
        boolean z16;
        long j3;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) v3);
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
            int id5 = v3.getId();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onClick id=" + id5);
            }
            m53.c cVar = null;
            if (id5 == R.id.fiu) {
                this.mIsShowingPassword = !this.mIsShowingPassword;
                updatePwdStates();
                m53.c cVar2 = this.binding;
                if (cVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    cVar2 = null;
                }
                PastablePwdEditText pastablePwdEditText = cVar2.f416201f;
                m53.c cVar3 = this.binding;
                if (cVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    cVar = cVar3;
                }
                pastablePwdEditText.setSelection(cVar.f416201f.length());
            } else if (id5 == R.id.fis) {
                m53.c cVar4 = this.binding;
                if (cVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    cVar = cVar4;
                }
                cVar.f416201f.h();
            } else if (id5 == R.id.f166147yu4) {
                m53.c cVar5 = this.binding;
                if (cVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    cVar5 = null;
                }
                Object systemService = cVar5.getRoot().getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                m53.c cVar6 = this.binding;
                if (cVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    cVar6 = null;
                }
                inputMethodManager.hideSoftInputFromWindow(cVar6.getRoot().getWindowToken(), 0);
                com.tencent.mobileqq.wifiphoto.data.a.e("em_bas_apply_authorization", "pg_bas_access_computer_files", null, 4, null);
                m53.c cVar7 = this.binding;
                if (cVar7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    cVar7 = null;
                }
                String obj = cVar7.f416201f.getText().toString();
                if (obj.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    if (!AppNetConnInfo.isNetSupport()) {
                        QQToast.makeText(v3.getContext(), 1, "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u91cd\u8bd5", 0).show();
                    }
                    getLoadingDialog().show();
                    com.tencent.qqnt.kernel.api.p A = QFileBridgeService.f205517a.A();
                    if (A != null) {
                        String md5 = MD5.toMD5(obj);
                        Intrinsics.checkNotNullExpressionValue(md5, "toMD5(pwd)");
                        String lowerCase = md5.toLowerCase();
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
                        String md52 = MD5.toMD5(lowerCase);
                        Intrinsics.checkNotNullExpressionValue(md52, "toMD5(MD5.toMD5(pwd).toLowerCase())");
                        String lowerCase2 = md52.toLowerCase();
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
                        m53.c cVar8 = this.binding;
                        if (cVar8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        } else {
                            cVar = cVar8;
                        }
                        if (cVar.f416198c.isChecked()) {
                            j3 = 1;
                        } else {
                            j3 = 0;
                        }
                        A.authenticateWithPassword(lowerCase2, j3, new IOperateCallback() { // from class: com.tencent.mobileqq.exportfile.fragment.l
                            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                            public final void onResult(int i3, String str) {
                                ExportFileInputPwdFragment.onClick$lambda$4(ExportFileInputPwdFragment.this, v3, i3, str);
                            }
                        });
                    }
                }
            } else if (id5 == R.id.f226704c) {
                com.tencent.mobileqq.wifiphoto.data.a.e("em_bas_forgot_password", "pg_bas_access_computer_files", null, 4, null);
                Fragment parentFragment = getParentFragment();
                if (parentFragment != null) {
                    Bundle bundle = new Bundle();
                    bundle.putInt(ExportFileErrorFragment.ERROR_TYPE, 3);
                    Unit unit = Unit.INSTANCE;
                    com.tencent.mobileqq.exportfile.fragment.c.b(parentFragment, "/export_file/error", bundle);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        boolean z16;
        View root;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            root = (View) iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            m53.c g16 = m53.c.g(inflater);
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater)");
            this.binding = g16;
            m53.c cVar = null;
            if (g16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                g16 = null;
            }
            VideoReport.setPageId(g16.getRoot(), "pg_bas_access_computer_files");
            Fragment parentFragment = getParentFragment();
            if (parentFragment != null) {
                String string = getString(R.string.f2318072u);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.title_export_file)");
                com.tencent.mobileqq.exportfile.fragment.c.a(parentFragment, string, false);
            }
            Object systemService = inflater.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            this.inputManager = (InputMethodManager) systemService;
            QFileBridgeService qFileBridgeService = QFileBridgeService.f205517a;
            if (qFileBridgeService.z().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                m53.c cVar2 = this.binding;
                if (cVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    cVar2 = null;
                }
                cVar2.f416204i.setText(qFileBridgeService.z());
                m53.c cVar3 = this.binding;
                if (cVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    cVar3 = null;
                }
                cVar3.f416204i.setContentDescription(qFileBridgeService.z());
            }
            initPasswordArea();
            m53.c cVar4 = this.binding;
            if (cVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                cVar4 = null;
            }
            cVar4.f416199d.setText(getString(R.string.f171012ml, Integer.valueOf(qFileBridgeService.F())));
            m53.c cVar5 = this.binding;
            if (cVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                cVar = cVar5;
            }
            root = cVar.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, root);
        return root;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Window window;
        View decorView;
        View rootView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onDestroy();
        Dialog loadingDialog = getLoadingDialog();
        if (loadingDialog != null) {
            loadingDialog.dismiss();
        }
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null && (decorView = window.getDecorView()) != null && (rootView = decorView.getRootView()) != null) {
            rootView.setOnTouchListener(null);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onPause();
        m53.c cVar = this.binding;
        m53.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar = null;
        }
        VideoReport.reportPgOut(cVar.getRoot());
        m53.c cVar3 = this.binding;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar3 = null;
        }
        Object systemService = cVar3.getRoot().getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        m53.c cVar4 = this.binding;
        if (cVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            cVar2 = cVar4;
        }
        inputMethodManager.hideSoftInputFromWindow(cVar2.getRoot().getWindowToken(), 0);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onResume();
        m53.c cVar = this.binding;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            cVar = null;
        }
        VideoReport.reportPgIn(cVar.getRoot());
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
