package com.tencent.mobileqq.exportfile.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.exportfile.global.QFileBridgeService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeClientState;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0016R\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/exportfile/fragment/BaseExportFileFragment;", "Lcom/tencent/mobileqq/exportfile/fragment/DisconnectListenerFragment;", "Landroid/content/Intent;", "intent", "", "dealIntent", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onNewIntent", "", "error", "ph", "", "onBackEvent", "Lm53/a;", "D", "Lm53/a;", "th", "()Lm53/a;", "vh", "(Lm53/a;)V", "binding", "<init>", "()V", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public class BaseExportFileFragment extends DisconnectListenerFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    public m53.a binding;

    public BaseExportFileFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void dealIntent(Intent intent) {
        th().f416189d.setVisibility(8);
        th().f416189d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.exportfile.fragment.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseExportFileFragment.sh(BaseExportFileFragment.this, view);
            }
        });
        String stringExtra = intent.getStringExtra("FRAGMENT_INDEX");
        if (stringExtra == null) {
            stringExtra = "/export_file/input_pwd";
        }
        QBaseFragment qBaseFragment = (QBaseFragment) QRoute.createNavigator(requireContext(), stringExtra).requestWithReturn();
        qBaseFragment.setArguments(intent.getExtras());
        getChildFragmentManager().beginTransaction().replace(th().f416187b.getId(), qBaseFragment).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sh(BaseExportFileFragment this$0, View view) {
        int i3;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HashMap hashMap = new HashMap();
        com.tencent.mobileqq.wifiphoto.data.a.a(hashMap);
        if (QFileBridgeService.f205517a.y() == FileBridgeClientState.KFILETRANSFERING) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        hashMap.put("is_transmission_behavior", Integer.valueOf(i3));
        Unit unit = Unit.INSTANCE;
        com.tencent.mobileqq.wifiphoto.data.a.d("em_bas_disconnect_link_switch", "pg_bas_access_computer_folder", hashMap);
        DialogHelperKt.j(this$0);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uh(BaseExportFileFragment this$0, View it) {
        w wVar;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActivityResultCaller findFragmentById = this$0.getChildFragmentManager().findFragmentById(this$0.th().f416187b.getId());
        if (findFragmentById instanceof w) {
            wVar = (w) findFragmentById;
        } else {
            wVar = null;
        }
        if (wVar != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            wVar.onBackClick(it);
        }
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        BasePartFragment basePartFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        Fragment findFragmentById = getChildFragmentManager().findFragmentById(th().f416187b.getId());
        if (findFragmentById instanceof BasePartFragment) {
            basePartFragment = (BasePartFragment) findFragmentById;
        } else {
            basePartFragment = null;
        }
        if (basePartFragment != null) {
            return basePartFragment.onBackEvent();
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            root = (View) iPatchRedirector.redirect((short) 4, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            m53.a g16 = m53.a.g(inflater);
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater)");
            vh(g16);
            th().f416188c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.exportfile.fragment.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseExportFileFragment.uh(BaseExportFileFragment.this, view);
                }
            });
            Intent intent = requireActivity().getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "requireActivity().intent");
            dealIntent(intent);
            root = th().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, root);
        return root;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(@Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent);
        } else if (intent != null) {
            dealIntent(intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNull(requireActivity, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        SystemBarActivityModule.setImmersiveStatus((QBaseActivity) requireActivity);
        FragmentActivity requireActivity2 = requireActivity();
        Intrinsics.checkNotNull(requireActivity2, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        SystemBarCompact systemBarComp = SystemBarActivityModule.getSystemBarComp((QBaseActivity) requireActivity2);
        if (systemBarComp != null) {
            systemBarComp.init();
            systemBarComp.setStatusBarDrawable(getResources().getDrawable(R.drawable.qui_bg_nav_secondary));
            view.setPadding(0, RFWImmersiveUtils.getStatusBarHeight(getContext()) - 1, 0, 0);
        }
    }

    @Override // com.tencent.mobileqq.exportfile.fragment.DisconnectListenerFragment
    protected void ph(int error) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, error);
        } else {
            th().f416189d.setVisibility(8);
        }
    }

    @NotNull
    public final m53.a th() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (m53.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        m53.a aVar = this.binding;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void vh(@NotNull m53.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            Intrinsics.checkNotNullParameter(aVar, "<set-?>");
            this.binding = aVar;
        }
    }
}
