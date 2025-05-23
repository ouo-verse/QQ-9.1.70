package com.tencent.mobileqq.wifiphoto.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.SystemBarCompact;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/wifiphoto/fragment/BaseWifiPhotoFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/content/Intent;", "intent", "", "dealIntent", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onNewIntent", "Lm53/i;", BdhLogUtil.LogTag.Tag_Conn, "Lm53/i;", "binding", "<init>", "()V", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class BaseWifiPhotoFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private m53.i binding;

    public BaseWifiPhotoFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void dealIntent(Intent intent) {
        String stringExtra = intent.getStringExtra("FRAGMENT_INDEX");
        if (stringExtra == null) {
            return;
        }
        QBaseFragment qBaseFragment = (QBaseFragment) QRoute.createNavigator(requireContext(), stringExtra).requestWithReturn();
        qBaseFragment.setArguments(intent.getExtras());
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        m53.i iVar = this.binding;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            iVar = null;
        }
        beginTransaction.replace(iVar.f416273d.getId(), qBaseFragment).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qh(BaseWifiPhotoFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requireActivity().finish();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            root = (View) iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            m53.i g16 = m53.i.g(getLayoutInflater());
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(layoutInflater)");
            this.binding = g16;
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNull(requireActivity, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
            SystemBarActivityModule.setImmersiveStatus((QBaseActivity) requireActivity);
            FragmentActivity requireActivity2 = requireActivity();
            Intrinsics.checkNotNull(requireActivity2, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
            SystemBarCompact systemBarComp = SystemBarActivityModule.getSystemBarComp((QBaseActivity) requireActivity2);
            if (systemBarComp != null) {
                systemBarComp.init();
                systemBarComp.setStatusBarDrawable(getResources().getDrawable(R.drawable.qui_common_bg_bottom_standard_bg));
            }
            m53.i iVar = this.binding;
            m53.i iVar2 = null;
            if (iVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                iVar = null;
            }
            View view = iVar.f416272c;
            Intrinsics.checkNotNullExpressionValue(view, "binding.vClose");
            com.tencent.mobileqq.wifiphoto.data.a.c("em_bas_close", view);
            m53.i iVar3 = this.binding;
            if (iVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                iVar3 = null;
            }
            iVar3.f416272c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wifiphoto.fragment.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BaseWifiPhotoFragment.qh(BaseWifiPhotoFragment.this, view2);
                }
            });
            Intent intent = requireActivity().getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "requireActivity().intent");
            dealIntent(intent);
            m53.i iVar4 = this.binding;
            if (iVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                iVar2 = iVar4;
            }
            root = iVar2.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, root);
        return root;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(@Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
        } else if (intent != null) {
            dealIntent(intent);
        }
    }
}
