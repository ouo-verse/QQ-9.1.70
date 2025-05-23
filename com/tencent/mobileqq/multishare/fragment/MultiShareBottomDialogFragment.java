package com.tencent.mobileqq.multishare.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.FragmentPartProvider;
import com.tencent.biz.richframework.part.IPartFragmentHost;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.multishare.part.MultiSharePreviewPart;
import com.tencent.mobileqq.multishare.part.MultiShareRecentFriendsPart;
import com.tencent.mobileqq.multishare.part.MultiShareTitlePart;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment;
import j92.d;
import j92.e;
import j92.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00be\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 v2\u00020\u00012\u00020\u0002:\u0001wB\u000f\u0012\u0006\u0010/\u001a\u00020,\u00a2\u0006\u0004\bt\u0010uJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000e\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\u001a\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u0007H\u0016J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016J\u000e\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 J\u001c\u0010(\u001a\u00020\u00072\u0006\u0010$\u001a\u00020#2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%J\u0010\u0010+\u001a\u00020\u00072\u0006\u0010*\u001a\u00020)H\u0016R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u001a\u00108\u001a\u0002038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R$\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001d\u0010C\u001a\b\u0012\u0004\u0012\u00020&0\u001d8\u0006\u00a2\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR$\u0010K\u001a\u0004\u0018\u00010D8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR$\u0010S\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR$\u0010[\u001a\u0004\u0018\u00010T8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR$\u0010c\u001a\u0004\u0018\u00010\\8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR$\u0010k\u001a\u0004\u0018\u00010d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u0018\u0010o\u001a\u0004\u0018\u00010l8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010nR\u0018\u0010s\u001a\u0004\u0018\u00010p8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010r\u00a8\u0006x"}, d2 = {"Lcom/tencent/mobileqq/multishare/fragment/MultiShareBottomDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/tencent/biz/richframework/part/IPartFragmentHost;", "", "xh", "Landroid/content/Context;", "context", "", "onAttach", "onDetach", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/app/Dialog;", "onCreateDialog", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "onStart", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/content/DialogInterface;", "dialog", "onCancel", "onDismiss", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/content/Intent;", "forwardIntent", "Eh", "", "index", "", "Lcom/tencent/mobileqq/multishare/action/b;", "actions", "Dh", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Lcom/tencent/mobileqq/multishare/config/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/multishare/config/a;", DownloadInfo.spKey_Config, "D", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroidx/fragment/app/Fragment;", "E", "Landroidx/fragment/app/Fragment;", "getHostFragment", "()Landroidx/fragment/app/Fragment;", "hostFragment", UserInfo.SEX_FEMALE, "Landroid/content/Intent;", "rh", "()Landroid/content/Intent;", "setForwardIntent", "(Landroid/content/Intent;)V", "G", "Ljava/util/List;", "vh", "()Ljava/util/List;", "shareActionsList", "Lj92/c;", "H", "Lj92/c;", "th", "()Lj92/c;", "Bh", "(Lj92/c;)V", "previewLayoutCreator", "Lj92/d;", "I", "Lj92/d;", "wh", "()Lj92/d;", "Ch", "(Lj92/d;)V", "titleLayoutCreator", "Lj92/b;", "J", "Lj92/b;", "sh", "()Lj92/b;", "setItemClickListener", "(Lj92/b;)V", "itemClickListener", "Landroid/content/DialogInterface$OnDismissListener;", "K", "Landroid/content/DialogInterface$OnDismissListener;", "getDismissListener", "()Landroid/content/DialogInterface$OnDismissListener;", "Ah", "(Landroid/content/DialogInterface$OnDismissListener;)V", "dismissListener", "Lj92/e;", "L", "Lj92/e;", "uh", "()Lj92/e;", "setRecentShareSorter", "(Lj92/e;)V", "recentShareSorter", "Lcom/tencent/mobileqq/multishare/viewmodel/a;", "M", "Lcom/tencent/mobileqq/multishare/viewmodel/a;", "multiShareViewModel", "Lcom/tencent/mobileqq/multishare/part/a;", "N", "Lcom/tencent/mobileqq/multishare/part/a;", "mMultiShareActionPart", "<init>", "(Lcom/tencent/mobileqq/multishare/config/a;)V", "P", "a", "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class MultiShareBottomDialogFragment extends ReportAndroidXDialogFragment implements IPartFragmentHost {
    static IPatchRedirector $redirector_;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.multishare.config.a config;

    /* renamed from: D, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Fragment hostFragment;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Intent forwardIntent;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.multishare.action.b> shareActionsList;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private j92.c previewLayoutCreator;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private d titleLayoutCreator;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private j92.b itemClickListener;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private DialogInterface.OnDismissListener dismissListener;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private e recentShareSorter;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.multishare.viewmodel.a multiShareViewModel;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.multishare.part.a mMultiShareActionPart;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/multishare/fragment/MultiShareBottomDialogFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.multishare.fragment.MultiShareBottomDialogFragment$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(VasWebviewConstants.REPORT_FROM_AIO_EMOTICON_PANEL_AD);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 30)) {
            redirector.redirect((short) 30);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public MultiShareBottomDialogFragment(@NotNull com.tencent.mobileqq.multishare.config.a config) {
        Intrinsics.checkNotNullParameter(config, "config");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) config);
            return;
        }
        this.config = config;
        this.hostFragment = this;
        ArrayList arrayList = new ArrayList();
        this.shareActionsList = arrayList;
        this.itemClickListener = config.d();
        this.recentShareSorter = config.k();
        List<com.tencent.mobileqq.multishare.action.b> a16 = config.a();
        if (a16 != null) {
            arrayList.addAll(a16);
        }
    }

    private final boolean xh() {
        Context context = getContext();
        if (context != null) {
            return com.tencent.mobileqq.multishare.util.c.f251800a.g(context);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat yh(MultiShareBottomDialogFragment this$0, View view, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i3 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.ime()).bottom;
        View view2 = this$0.rootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view2 = null;
        }
        View findViewById = view2.findViewById(R.id.ziw);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.multi_share_ime_layout)");
        if (i3 == 0) {
            i3 = ViewUtils.dip2px(1.0f);
        }
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = i3;
        findViewById.setLayoutParams(layoutParams);
        QLog.d("MultiShareBottomDialogFragment", 1, "imeHeight: " + i3);
        return windowInsetsCompat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zh(MultiShareBottomDialogFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void Ah(@Nullable DialogInterface.OnDismissListener onDismissListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) onDismissListener);
        } else {
            this.dismissListener = onDismissListener;
        }
    }

    public final void Bh(@Nullable j92.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) cVar);
        } else {
            this.previewLayoutCreator = cVar;
        }
    }

    public final void Ch(@Nullable d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) dVar);
        } else {
            this.titleLayoutCreator = dVar;
        }
    }

    public final void Dh(int index, @NotNull List<? extends com.tencent.mobileqq.multishare.action.b> actions) {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, index, (Object) actions);
            return;
        }
        Intrinsics.checkNotNullParameter(actions, "actions");
        com.tencent.mobileqq.multishare.part.a aVar = this.mMultiShareActionPart;
        if (aVar != null) {
            aVar.A9(index, actions);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.e("MultiShareBottomDialogFragment", 1, "[updateActionSheet] mMultiShareActionPart is null");
        }
    }

    public final void Eh(@NotNull Intent forwardIntent) {
        MutableLiveData<Intent> M1;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) forwardIntent);
            return;
        }
        Intrinsics.checkNotNullParameter(forwardIntent, "forwardIntent");
        this.forwardIntent = forwardIntent;
        com.tencent.mobileqq.multishare.viewmodel.a aVar = this.multiShareViewModel;
        if (aVar != null && (M1 = aVar.M1()) != null) {
            M1.postValue(forwardIntent);
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        boolean z16;
        MultiShareRecentFriendsPart multiShareRecentFriendsPart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (List) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MultiShareTitlePart());
        if (this.config.p()) {
            if (this.config.l() != null) {
                f l3 = this.config.l();
                Intrinsics.checkNotNull(l3);
                multiShareRecentFriendsPart = new com.tencent.mobileqq.multishare.part.d(l3, this.config.b());
            } else {
                multiShareRecentFriendsPart = new MultiShareRecentFriendsPart();
            }
            multiShareRecentFriendsPart.T9(this.config.m());
            arrayList.add(multiShareRecentFriendsPart);
        }
        com.tencent.mobileqq.multishare.part.a aVar = new com.tencent.mobileqq.multishare.part.a();
        this.mMultiShareActionPart = aVar;
        Intrinsics.checkNotNull(aVar);
        arrayList.add(aVar);
        MultiSharePreviewPart multiSharePreviewPart = new MultiSharePreviewPart();
        multiSharePreviewPart.V9(this.config.f());
        multiSharePreviewPart.Z9(this.config.n());
        multiSharePreviewPart.W9(this.config.j());
        if (this.config.b() && this.config.p()) {
            z16 = true;
        } else {
            z16 = false;
        }
        multiSharePreviewPart.T9(z16);
        multiSharePreviewPart.U9(this.config.e());
        arrayList.add(multiSharePreviewPart);
        List<Part> c16 = this.config.c();
        if (c16 != null) {
            List<Part> list = c16;
            if (!list.isEmpty()) {
                arrayList.addAll(list);
            }
        }
        return arrayList;
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Fragment) iPatchRedirector.redirect((short) 2, (Object) this);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        new FragmentPartProvider(this).initProvider();
        this.multiShareViewModel = (com.tencent.mobileqq.multishare.viewmodel.a) getViewModel(this, null, com.tencent.mobileqq.multishare.viewmodel.a.class);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(@NotNull DialogInterface dialog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) dialog);
            return;
        }
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        DialogInterface.OnCancelListener g16 = this.config.g();
        if (g16 != null) {
            g16.onCancel(dialog);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) newConfig);
            return;
        }
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        boolean xh5 = xh();
        QLog.d("MultiShareBottomDialogFragment", 2, "[onCreate] isLandscape: " + xh5);
        if (xh5) {
            i3 = R.style.a3o;
        } else if (Build.VERSION.SDK_INT <= 29) {
            i3 = R.style.a3n;
        } else {
            i3 = R.style.a3l;
        }
        setStyle(0, i3);
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Dialog) iPatchRedirector.redirect((short) 18, (Object) this, (Object) savedInstanceState);
        }
        if (!this.config.p() && !xh()) {
            return new com.google.android.material.bottomsheet.a(requireContext(), getTheme());
        }
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Window window;
        View view;
        Window window2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            view = (View) iPatchRedirector.redirect((short) 20, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            if (Build.VERSION.SDK_INT <= 29) {
                Dialog dialog = getDialog();
                if (dialog != null && (window2 = dialog.getWindow()) != null) {
                    window2.setSoftInputMode(16);
                }
                QLog.d("MultiShareBottomDialogFragment", 1, "[onCreateView] os version <= Q, SoftInputMode set SOFT_INPUT_ADJUST_RESIZE.");
            } else {
                Dialog dialog2 = getDialog();
                if (dialog2 != null && (window = dialog2.getWindow()) != null) {
                    window.setSoftInputMode(48);
                }
            }
            boolean xh5 = xh();
            QLog.d("MultiShareBottomDialogFragment", 2, "[onCreateView] isLandscape: " + xh5);
            Dialog dialog3 = getDialog();
            if (dialog3 != null) {
                com.tencent.mobileqq.multishare.util.c cVar = com.tencent.mobileqq.multishare.util.c.f251800a;
                cVar.j(dialog3, xh5, -2);
                cVar.c(dialog3, xh5);
            }
            View inflate = inflater.inflate(R.layout.fmk, container, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026layout, container, false)");
            this.rootView = inflate;
            com.tencent.mobileqq.multishare.util.c cVar2 = com.tencent.mobileqq.multishare.util.c.f251800a;
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                inflate = null;
            }
            cVar2.o(inflate, R.id.zjg, xh5);
            view = this.rootView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                view = null;
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
        } else {
            super.onDestroy();
            com.tencent.mobileqq.multishare.util.d.f251801a.f();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            super.onDetach();
            this.multiShareViewModel = null;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) dialog);
            return;
        }
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        DialogInterface.OnDismissListener h16 = this.config.h();
        if (h16 != null) {
            h16.onDismiss(dialog);
        }
        DialogInterface.OnDismissListener onDismissListener = this.dismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialog);
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        super.onStart();
        if (Build.VERSION.SDK_INT <= 29 && !xh()) {
            QLog.d("MultiShareBottomDialogFragment", 1, "[onStart] os version <= Q && !isLandscape");
            Dialog dialog = getDialog();
            if (dialog != null && (window = dialog.getWindow()) != null) {
                window.setLayout(-1, -2);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        View view2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View view3 = this.rootView;
        View view4 = null;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view3 = null;
        }
        TextView textView = (TextView) view3.findViewById(R.id.zj5);
        if (this.config.o() != null && textView != null) {
            textView.setText(this.config.o());
        }
        if (Build.VERSION.SDK_INT > 29) {
            Window window = requireDialog().getWindow();
            if (window != null) {
                view2 = window.getDecorView();
            } else {
                view2 = null;
            }
            Intrinsics.checkNotNull(view2);
            ViewCompat.setOnApplyWindowInsetsListener(view2, new OnApplyWindowInsetsListener() { // from class: com.tencent.mobileqq.multishare.fragment.a
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat onApplyWindowInsets(View view5, WindowInsetsCompat windowInsetsCompat) {
                    WindowInsetsCompat yh5;
                    yh5 = MultiShareBottomDialogFragment.yh(MultiShareBottomDialogFragment.this, view5, windowInsetsCompat);
                    return yh5;
                }
            });
        }
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnShowListener(this.config.i());
        }
        com.tencent.mobileqq.multishare.util.c cVar = com.tencent.mobileqq.multishare.util.c.f251800a;
        View view5 = this.rootView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        } else {
            view4 = view5;
        }
        cVar.h(view4, getDialog(), new View.OnClickListener() { // from class: com.tencent.mobileqq.multishare.fragment.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view6) {
                MultiShareBottomDialogFragment.zh(MultiShareBottomDialogFragment.this, view6);
            }
        });
    }

    @Nullable
    public final Intent rh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Intent) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.forwardIntent;
    }

    @Nullable
    public final j92.b sh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (j92.b) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.itemClickListener;
    }

    @Nullable
    public final j92.c th() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (j92.c) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.previewLayoutCreator;
    }

    @Nullable
    public final e uh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (e) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.recentShareSorter;
    }

    @NotNull
    public final List<com.tencent.mobileqq.multishare.action.b> vh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.shareActionsList;
    }

    @Nullable
    public final d wh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (d) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.titleLayoutCreator;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
