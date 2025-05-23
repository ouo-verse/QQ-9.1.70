package com.tencent.mobileqq.sharepanel.fragment;

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
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
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
import com.tencent.mobileqq.sharepanel.action.i;
import com.tencent.mobileqq.sharepanel.k;
import com.tencent.mobileqq.sharepanel.l;
import com.tencent.mobileqq.sharepanel.launcher.SharePanelParam;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 H2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001IB\u0013\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010(\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00142\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\u0006\u0010\u001d\u001a\u00020\u0004J\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0006\u0010!\u001a\u00020\u0004J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"H\u0016J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"H\u0016J\u0006\u0010&\u001a\u00020\u0004J\u0006\u0010'\u001a\u00020\u0004R\u0019\u0010-\u001a\u0004\u0018\u00010(8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001b\u00103\u001a\u00020.8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001e\u00106\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00109\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u00108R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u001a\u0010E\u001a\u00020@8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/fragment/SharePanelDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/tencent/biz/richframework/part/IPartFragmentHost;", "Lcom/tencent/mobileqq/sharepanel/fragment/a;", "", "ph", "Landroid/content/Context;", "context", "onAttach", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/app/Dialog;", "onCreateDialog", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "dismiss", "dismissAllowingStateLoss", "th", "", "isForceCancel", "Nd", "sh", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "onCancel", "vh", "uh", "Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;", "qh", "()Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;", "param", "Lcom/tencent/biz/richframework/part/FragmentPartProvider;", "D", "Lkotlin/Lazy;", "rh", "()Lcom/tencent/biz/richframework/part/FragmentPartProvider;", "partProvider", "E", "Ljava/util/List;", "partList", UserInfo.SEX_FEMALE, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "G", "contentView", "Lcom/tencent/mobileqq/sharepanel/action/i;", "H", "Lcom/tencent/mobileqq/sharepanel/action/i;", "actionViewModel", "Landroidx/fragment/app/Fragment;", "I", "Landroidx/fragment/app/Fragment;", "getHostFragment", "()Landroidx/fragment/app/Fragment;", "hostFragment", "<init>", "(Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;)V", "J", "a", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SharePanelDialogFragment extends ReportAndroidXDialogFragment implements IPartFragmentHost, a {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private final SharePanelParam param;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy partProvider;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private List<Part> partList;

    /* renamed from: F, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: G, reason: from kotlin metadata */
    private View contentView;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private i actionViewModel;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Fragment hostFragment;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/fragment/SharePanelDialogFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.sharepanel.fragment.SharePanelDialogFragment$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35797);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SharePanelDialogFragment() {
        this(null, 1, 0 == true ? 1 : 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
            return;
        }
        iPatchRedirector.redirect((short) 20, (Object) this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:
    
        if (r1.e() == true) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void ph() {
        boolean z16;
        FragmentActivity activity;
        boolean areEqual = Intrinsics.areEqual(MobileQQ.PACKAGE_NAME, BaseApplication.processName);
        SharePanelParam sharePanelParam = this.param;
        if (sharePanelParam != null) {
            z16 = true;
        }
        z16 = false;
        if ((z16 || !areEqual) && (activity = getActivity()) != null && !activity.isFinishing()) {
            activity.finish();
            activity.overridePendingTransition(0, 0);
        }
    }

    private final FragmentPartProvider rh() {
        return (FragmentPartProvider) this.partProvider.getValue();
    }

    @Override // com.tencent.mobileqq.sharepanel.fragment.a
    public boolean Nd(boolean isForceCancel) {
        DismissType dismissType;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, isForceCancel)).booleanValue();
        }
        List<Part> list = this.partList;
        if (list == null) {
            return false;
        }
        for (Part part : list) {
            if (part instanceof com.tencent.mobileqq.sharepanel.part.i) {
                com.tencent.mobileqq.sharepanel.part.i iVar = (com.tencent.mobileqq.sharepanel.part.i) part;
                if (isForceCancel) {
                    dismissType = DismissType.FORCE_CANCEL;
                } else {
                    dismissType = DismissType.CANCEL;
                }
                if (iVar.G9(dismissType)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
    
        r0 = kotlin.collections.CollectionsKt__CollectionsKt.mutableListOf(new com.tencent.mobileqq.sharepanel.report.SharePanelReportPart(r0), new com.tencent.mobileqq.sharepanel.preview.SharePanelPreviewImagePart(r0), new com.tencent.mobileqq.sharepanel.preview.SharePanelCustomTopPreviewPart(r0), new com.tencent.mobileqq.sharepanel.multiSelect.MultiSelectContactPart(r0), new com.tencent.mobileqq.sharepanel.preview.SharePanelSinglePreviewPart(r0), new com.tencent.mobileqq.sharepanel.part.SharePanelTitlePart(r0), new com.tencent.mobileqq.sharepanel.action.ShareActionPart(r0), new com.tencent.mobileqq.sharepanel.part.j(r0), new com.tencent.mobileqq.sharepanel.part.SharePanelAnimationPart(r0));
     */
    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<Part> assembleParts() {
        List<Part> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        SharePanelParam sharePanelParam = this.param;
        if (sharePanelParam == null || arrayList == null) {
            arrayList = new ArrayList<>();
        }
        this.partList = arrayList;
        return arrayList;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            dismissAllowingStateLoss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismissAllowingStateLoss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
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
                if ((next instanceof com.tencent.mobileqq.sharepanel.part.i) && ((com.tencent.mobileqq.sharepanel.part.i) next).G9(DismissType.DISMISS)) {
                    z16 = true;
                    break;
                }
            }
        }
        if (!z16) {
            th();
        }
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Fragment) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.hostFragment;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    /* renamed from: getHostLifecycleOwner */
    public /* synthetic */ LifecycleOwner getLifecycleOwner() {
        return com.tencent.biz.richframework.part.a.c(this);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        rh().initProvider();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(@NotNull DialogInterface dialog) {
        com.tencent.mobileqq.sharepanel.i k3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) dialog);
            return;
        }
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        SharePanelParam sharePanelParam = this.param;
        if (sharePanelParam != null && (k3 = sharePanelParam.k()) != null) {
            k3.a();
        }
        ph();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) newConfig);
            return;
        }
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        PartManager partManager = rh().getPartManager();
        if (partManager != null) {
            partManager.onConfigurationChanged(newConfig);
        }
        View view = this.contentView;
        if (view != null) {
            com.tencent.mobileqq.sharepanel.util.b bVar = com.tencent.mobileqq.sharepanel.util.b.f287600a;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentView");
                view = null;
            }
            bVar.a(view);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Dialog) iPatchRedirector.redirect((short) 6, (Object) this, (Object) savedInstanceState);
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        b bVar = new b(requireContext, R.style.a9g);
        bVar.P(this);
        bVar.setCanceledOnTouchOutside(true);
        Window window = bVar.getWindow();
        if (window != null) {
            com.tencent.mobileqq.sharepanel.util.b.f287600a.d(window);
            window.setNavigationBarColor(ContextCompat.getColor(requireContext(), R.color.qui_common_bg_middle_standard));
        }
        com.tencent.mobileqq.sharepanel.util.b.f287600a.b(bVar);
        return bVar;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            view = (View) iPatchRedirector.redirect((short) 8, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            View inflate = inflater.inflate(R.layout.h4l, container, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026layout, container, false)");
            this.rootView = inflate;
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                inflate = null;
            }
            View findViewById = inflate.findViewById(R.id.b9t);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.content_container)");
            this.contentView = findViewById;
            com.tencent.mobileqq.sharepanel.util.b bVar = com.tencent.mobileqq.sharepanel.util.b.f287600a;
            if (findViewById == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentView");
                findViewById = null;
            }
            bVar.a(findViewById);
            view = this.rootView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                view = null;
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        k n3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) dialog);
            return;
        }
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        QLog.d("SharePanelDialogFragment", 1, "onDismiss");
        SharePanelParam sharePanelParam = this.param;
        if (sharePanelParam != null && (n3 = sharePanelParam.n()) != null) {
            n3.a();
        }
        ph();
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        l o16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (this.param == null) {
            th();
        }
        this.actionViewModel = (i) getViewModel(i.class);
        SharePanelParam sharePanelParam = this.param;
        if (sharePanelParam != null && (o16 = sharePanelParam.o()) != null) {
            o16.a();
        }
    }

    @Nullable
    public final SharePanelParam qh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SharePanelParam) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.param;
    }

    public final void sh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        try {
            Dialog dialog = getDialog();
            if (dialog != null) {
                dialog.cancel();
            }
        } catch (Exception e16) {
            QLog.e("SharePanelDialogFragment", 1, "superCancel error: ", e16);
        }
    }

    public final void th() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        try {
            super.dismissAllowingStateLoss();
        } catch (Exception e16) {
            QLog.e("SharePanelDialogFragment", 1, "superDismiss error: ", e16);
        }
    }

    public final void uh() {
        MutableLiveData<Unit> L1;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        QLog.d("SharePanelDialogFragment", 1, "updateAppendActionList");
        i iVar = this.actionViewModel;
        if (iVar != null && (L1 = iVar.L1()) != null) {
            L1.postValue(null);
        }
    }

    public final void vh() {
        MutableLiveData<Unit> M1;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        QLog.d("SharePanelDialogFragment", 1, "updateShareChannelList");
        i iVar = this.actionViewModel;
        if (iVar != null && (M1 = iVar.M1()) != null) {
            M1.postValue(null);
        }
    }

    public /* synthetic */ SharePanelDialogFragment(SharePanelParam sharePanelParam, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : sharePanelParam);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, sharePanelParam, Integer.valueOf(i3), defaultConstructorMarker);
    }

    public /* synthetic */ ViewModel getViewModel(Class cls) {
        return ne0.a.b(this, cls);
    }

    public SharePanelDialogFragment(@Nullable SharePanelParam sharePanelParam) {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) sharePanelParam);
            return;
        }
        this.param = sharePanelParam;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FragmentPartProvider>() { // from class: com.tencent.mobileqq.sharepanel.fragment.SharePanelDialogFragment$partProvider$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SharePanelDialogFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FragmentPartProvider invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new FragmentPartProvider(SharePanelDialogFragment.this) : (FragmentPartProvider) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.partProvider = lazy;
        this.hostFragment = this;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
