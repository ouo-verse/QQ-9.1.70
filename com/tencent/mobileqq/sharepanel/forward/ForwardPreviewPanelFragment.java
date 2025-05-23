package com.tencent.mobileqq.sharepanel.forward;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.FragmentPartProvider;
import com.tencent.biz.richframework.part.IPartFragmentHost;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.sharepanel.forward.part.ForwardPreviewAnimationPart;
import com.tencent.mobileqq.sharepanel.forward.part.ForwardPreviewBasePart;
import com.tencent.mobileqq.sharepanel.forward.part.ForwardPreviewInputPart;
import com.tencent.mobileqq.sharepanel.forward.part.o;
import com.tencent.mobileqq.sharepanel.fragment.DismissType;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 K2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001LB\u0013\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010$\u00a2\u0006\u0004\bJ\u0010*J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016J$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0006\u0010\u001f\u001a\u00020\u0006J\u0006\u0010 \u001a\u00020\u0006J\u0010\u0010#\u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0016R$\u0010+\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001b\u00101\u001a\u00020,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R*\u00108\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010?\u001a\u00020\u00148\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010C\u001a\u00020\u00148\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b@\u0010:\u001a\u0004\bA\u0010<\"\u0004\bB\u0010>R\u001a\u0010I\u001a\u00020D8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/forward/ForwardPreviewPanelFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/tencent/biz/richframework/part/IPartFragmentHost;", "Lcom/tencent/mobileqq/sharepanel/fragment/a;", "Landroid/content/Context;", "context", "", "onAttach", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/app/Dialog;", "onCreateDialog", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "dismiss", "dismissAllowingStateLoss", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "onCancel", "vh", "uh", "", "isForceCancel", "Nd", "Lcom/tencent/mobileqq/sharepanel/forward/d;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/sharepanel/forward/d;", "ph", "()Lcom/tencent/mobileqq/sharepanel/forward/d;", "setParam", "(Lcom/tencent/mobileqq/sharepanel/forward/d;)V", "param", "Lcom/tencent/biz/richframework/part/FragmentPartProvider;", "D", "Lkotlin/Lazy;", "rh", "()Lcom/tencent/biz/richframework/part/FragmentPartProvider;", "partProvider", "E", "Ljava/util/List;", "qh", "()Ljava/util/List;", "setPartList", "(Ljava/util/List;)V", "partList", UserInfo.SEX_FEMALE, "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "th", "(Landroid/view/View;)V", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "G", "getContentView", "sh", "contentView", "Landroidx/fragment/app/Fragment;", "H", "Landroidx/fragment/app/Fragment;", "getHostFragment", "()Landroidx/fragment/app/Fragment;", "hostFragment", "<init>", "I", "a", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public class ForwardPreviewPanelFragment extends ReportAndroidXDialogFragment implements IPartFragmentHost, com.tencent.mobileqq.sharepanel.fragment.a {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private d param;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy partProvider;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private List<Part> partList;

    /* renamed from: F, reason: from kotlin metadata */
    protected View rootView;

    /* renamed from: G, reason: from kotlin metadata */
    protected View contentView;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Fragment hostFragment;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/forward/ForwardPreviewPanelFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.sharepanel.forward.ForwardPreviewPanelFragment$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33235);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 26)) {
            redirector.redirect((short) 26);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ForwardPreviewPanelFragment() {
        this(null, 1, 0 == true ? 1 : 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 25)) {
            return;
        }
        iPatchRedirector.redirect((short) 25, (Object) this);
    }

    private final FragmentPartProvider rh() {
        return (FragmentPartProvider) this.partProvider.getValue();
    }

    @Override // com.tencent.mobileqq.sharepanel.fragment.a
    public boolean Nd(boolean isForceCancel) {
        DismissType dismissType;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, isForceCancel)).booleanValue();
        }
        List<Part> list = this.partList;
        if (list == null) {
            return false;
        }
        for (Part part : list) {
            if (part instanceof ForwardPreviewBasePart) {
                ForwardPreviewBasePart forwardPreviewBasePart = (ForwardPreviewBasePart) part;
                if (isForceCancel) {
                    dismissType = DismissType.FORCE_CANCEL;
                } else {
                    dismissType = DismissType.CANCEL;
                }
                if (forwardPreviewBasePart.D9(dismissType)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (List) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        d dVar = this.param;
        if (dVar != null) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new ForwardPreviewInputPart(dVar), new com.tencent.mobileqq.sharepanel.forward.part.g(dVar), new o(dVar), new ForwardPreviewAnimationPart(dVar));
            this.partList = mutableListOf;
            return mutableListOf;
        }
        return new ArrayList();
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            dismissAllowingStateLoss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismissAllowingStateLoss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        List<Part> list = this.partList;
        boolean z16 = false;
        if (list != null) {
            Iterator<Part> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Part next = it.next();
                if ((next instanceof ForwardPreviewBasePart) && ((ForwardPreviewBasePart) next).D9(DismissType.DISMISS)) {
                    z16 = true;
                    break;
                }
            }
        }
        if (!z16) {
            vh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final View getContentView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (View) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        View view = this.contentView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
        return null;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost, com.qzone.publish.ui.controller.a
    public /* synthetic */ Activity getHostActivity() {
        return com.tencent.biz.richframework.part.a.a(this);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* synthetic */ Context getHostContext() {
        return com.tencent.biz.richframework.part.a.b(this);
    }

    @Override // com.tencent.biz.richframework.part.IPartFragmentHost
    @NotNull
    public Fragment getHostFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Fragment) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.hostFragment;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    /* renamed from: getHostLifecycleOwner */
    public /* synthetic */ LifecycleOwner getLifecycleOwner() {
        return com.tencent.biz.richframework.part.a.c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final View getRootView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        View view = this.rootView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        return null;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* synthetic */ Object getViewTagData() {
        return ne0.a.d(this);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        rh().initProvider();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(@NotNull DialogInterface dialog) {
        a a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) dialog);
            return;
        }
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        d dVar = this.param;
        if (dVar != null && (a16 = dVar.a()) != null) {
            a16.onCancel();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) newConfig);
            return;
        }
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        PartManager partManager = rh().getPartManager();
        if (partManager != null) {
            partManager.onConfigurationChanged(newConfig);
        }
        if (this.contentView != null) {
            com.tencent.mobileqq.sharepanel.util.b.f287600a.a(getContentView());
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        if (this.param == null) {
            QLog.e("ForwardPreviewPanelFragment", 1, "onCreate but param is null.");
            vh();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Dialog) iPatchRedirector.redirect((short) 14, (Object) this, (Object) savedInstanceState);
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        com.tencent.mobileqq.sharepanel.fragment.b bVar = new com.tencent.mobileqq.sharepanel.fragment.b(requireContext, R.style.a9g);
        bVar.P(this);
        bVar.setCanceledOnTouchOutside(true);
        Window window = bVar.getWindow();
        if (window != null) {
            QLog.i("ForwardPreviewPanelFragment", 1, "softInputMode=" + window.getAttributes().softInputMode);
            com.tencent.mobileqq.sharepanel.util.b.f287600a.d(window);
            window.setNavigationBarColor(ContextCompat.getColor(requireContext(), R.color.qui_common_bg_middle_standard));
        }
        com.tencent.mobileqq.sharepanel.util.b.f287600a.b(bVar);
        return bVar;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            rootView = (View) iPatchRedirector.redirect((short) 16, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            View inflate = inflater.inflate(R.layout.e9f, container, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026layout, container, false)");
            th(inflate);
            View findViewById = getRootView().findViewById(R.id.b9t);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.content_container)");
            sh(findViewById);
            com.tencent.mobileqq.sharepanel.util.b.f287600a.a(getContentView());
            rootView = getRootView();
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, rootView);
        return rootView;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        a a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) dialog);
            return;
        }
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        d dVar = this.param;
        if (dVar != null && (a16 = dVar.a()) != null) {
            a16.onDismiss();
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Nullable
    public final d ph() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (d) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.param;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final List<Part> qh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.partList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void sh(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.contentView = view;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void th(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.rootView = view;
        }
    }

    public final void uh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        try {
            Dialog dialog = getDialog();
            if (dialog != null) {
                dialog.cancel();
            }
        } catch (Exception e16) {
            QLog.e("ForwardPreviewPanelFragment", 1, "superCancel error: ", e16);
        }
    }

    public final void vh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        try {
            super.dismissAllowingStateLoss();
        } catch (Exception e16) {
            QLog.e("ForwardPreviewPanelFragment", 1, "superDismiss error: ", e16);
        }
    }

    public ForwardPreviewPanelFragment(@Nullable d dVar) {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar);
            return;
        }
        this.param = dVar;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FragmentPartProvider>() { // from class: com.tencent.mobileqq.sharepanel.forward.ForwardPreviewPanelFragment$partProvider$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ForwardPreviewPanelFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FragmentPartProvider invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new FragmentPartProvider(ForwardPreviewPanelFragment.this) : (FragmentPartProvider) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.partProvider = lazy;
        this.hostFragment = this;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }

    public /* synthetic */ ForwardPreviewPanelFragment(d dVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : dVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, dVar, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
