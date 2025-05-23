package com.tencent.mobileqq.multishare.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 82\u00020\u00012\u00020\u0002:\u00019B\u0007\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\u0012\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J$\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0012\u0010\u0019\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016R*\u0010%\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010-\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00100\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/multishare/fragment/MultiShareUsersListBottomFragment;", "Landroidx/fragment/app/DialogFragment;", "Landroid/view/View$OnClickListener;", "", "sh", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, MiniChatConstants.MINI_APP_LANDSCAPE, "", "rh", "qh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/content/DialogInterface;", "dialog", "onDismiss", "v", NodeProps.ON_CLICK, "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "", "Lcom/tencent/mobileqq/multishare/bean/a;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "getUsers", "()Ljava/util/List;", "vh", "(Ljava/util/List;)V", "users", "Landroid/content/DialogInterface$OnDismissListener;", "D", "Landroid/content/DialogInterface$OnDismissListener;", "getDismissListener", "()Landroid/content/DialogInterface$OnDismissListener;", "uh", "(Landroid/content/DialogInterface$OnDismissListener;)V", "dismissListener", "E", "Z", "isOutSideClick", "()Z", "setOutSideClick", "(Z)V", UserInfo.SEX_FEMALE, "Landroid/view/View;", "<init>", "()V", "G", "a", "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class MultiShareUsersListBottomFragment extends ReportAndroidXDialogFragment implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private List<com.tencent.mobileqq.multishare.bean.a> users;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private DialogInterface.OnDismissListener dismissListener;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isOutSideClick;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private View rootView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/multishare/fragment/MultiShareUsersListBottomFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.multishare.fragment.MultiShareUsersListBottomFragment$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/multishare/fragment/MultiShareUsersListBottomFragment$b", "Landroidx/recyclerview/widget/LinearLayoutManager;", "", "canScrollHorizontally", "canScrollVertically", "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b extends LinearLayoutManager {
        static IPatchRedirector $redirector_;

        b(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            }
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return true;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40547);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public MultiShareUsersListBottomFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.isOutSideClick = true;
        }
    }

    private final void qh(View rootView, boolean isLandscape) {
        int dip2px;
        View findViewById = rootView.findViewById(R.id.zjc);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026hare_users_list_recycler)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        if (isLandscape) {
            dip2px = 0;
        } else {
            dip2px = ViewUtils.dip2px(15.0f);
        }
        layoutParams2.topMargin = dip2px;
        recyclerView.setLayoutParams(layoutParams2);
        b bVar = new b(getContext());
        bVar.setOrientation(1);
        recyclerView.setLayoutManager(bVar);
        com.tencent.mobileqq.multishare.adapter.c cVar = new com.tencent.mobileqq.multishare.adapter.c();
        recyclerView.setAdapter(new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{cVar}));
        List<com.tencent.mobileqq.multishare.bean.a> list = this.users;
        if (list != null) {
            cVar.setItems(list);
        }
    }

    private final void rh(View rootView, boolean isLandscape) {
        View findViewById = rootView.findViewById(R.id.zj9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026ull_screen_title_wrapper)");
        FrameLayout frameLayout = (FrameLayout) findViewById;
        View findViewById2 = rootView.findViewById(R.id.zjd);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026sers_list_title_back_btn)");
        ImageView imageView = (ImageView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.zje);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026rtical_screen_title_icon)");
        ImageView imageView2 = (ImageView) findViewById3;
        if (isLandscape) {
            frameLayout.setVisibility(0);
            imageView2.setVisibility(8);
            imageView.setOnClickListener(this);
        } else {
            frameLayout.setVisibility(8);
            imageView2.setVisibility(0);
        }
    }

    private final boolean sh() {
        Context context = getContext();
        if (context != null) {
            return com.tencent.mobileqq.multishare.util.c.f251800a.g(context);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void th(MultiShareUsersListBottomFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) v3);
        } else {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.zjd) {
                this.isOutSideClick = false;
                dismiss();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) newConfig);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        boolean sh5 = sh();
        QLog.d("MultiShareUsersListBottomFragment", 2, "[onCreate] isLandscape: " + sh5);
        if (sh5) {
            i3 = R.style.a3o;
        } else {
            i3 = R.style.a3p;
        }
        setStyle(0, i3);
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            rootView = (View) iPatchRedirector.redirect((short) 9, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            boolean sh5 = sh();
            QLog.d("MultiShareUsersListBottomFragment", 2, "[onCreateView] isLandscape: " + sh5);
            Dialog dialog = getDialog();
            if (dialog != null) {
                com.tencent.mobileqq.multishare.util.c cVar = com.tencent.mobileqq.multishare.util.c.f251800a;
                cVar.j(dialog, sh5, ViewUtils.dip2px(400.0f));
                cVar.c(dialog, sh5);
            }
            rootView = inflater.inflate(R.layout.fmm, container, false);
            com.tencent.mobileqq.multishare.util.c cVar2 = com.tencent.mobileqq.multishare.util.c.f251800a;
            Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
            cVar2.o(rootView, R.id.zjf, sh5);
            View findViewById = rootView.findViewById(R.id.zjf);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026share_users_list_wrapper)");
            LinearLayout linearLayout = (LinearLayout) findViewById;
            Context context = getContext();
            if (context != null) {
                cVar2.i(context, linearLayout);
            }
            rh(rootView, sh5);
            qh(rootView, sh5);
            this.rootView = rootView;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, rootView);
        return rootView;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        DialogInterface.OnDismissListener onDismissListener;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) dialog);
            return;
        }
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        boolean sh5 = sh();
        QLog.d("MultiShareUsersListBottomFragment", 2, "[onDismiss] isLandscape: " + sh5 + ", isOutSideClick: " + this.isOutSideClick);
        if (sh5 && this.isOutSideClick && (onDismissListener = this.dismissListener) != null) {
            onDismissListener.onDismiss(dialog);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        com.tencent.mobileqq.multishare.util.c.f251800a.h(this.rootView, getDialog(), new View.OnClickListener() { // from class: com.tencent.mobileqq.multishare.fragment.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MultiShareUsersListBottomFragment.th(MultiShareUsersListBottomFragment.this, view2);
            }
        });
    }

    public final void uh(@Nullable DialogInterface.OnDismissListener onDismissListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) onDismissListener);
        } else {
            this.dismissListener = onDismissListener;
        }
    }

    public final void vh(@Nullable List<com.tencent.mobileqq.multishare.bean.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
        } else {
            this.users = list;
        }
    }
}
