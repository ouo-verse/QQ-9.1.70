package com.tencent.could.huiyansdk.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.could.huiyansdk.api.HuiYanAuthImp;
import com.tencent.could.huiyansdk.base.HuiYanBaseApi;
import com.tencent.could.huiyansdk.entity.CommonDataCache;
import com.tencent.could.huiyansdk.manager.b;
import com.tencent.could.huiyansdk.manager.d;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.could.huiyansdk.utils.CommonUtils;
import com.tencent.could.huiyansdk.view.ProtocolCheckView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

/* loaded from: classes5.dex */
public class ProtocolAllowFragment extends BaseFragment {
    static IPatchRedirector $redirector_;

    public ProtocolAllowFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        b.a.f100131a.a(getActivity());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(View view) {
        boolean checkBoxIsSelected;
        View view2;
        EventCollector.getInstance().onViewClickedBefore(view);
        View view3 = this.f100069a;
        if (view3 == null) {
            checkBoxIsSelected = false;
        } else {
            checkBoxIsSelected = ((ProtocolCheckView) view3.findViewById(R.id.f113736rf)).getCheckBoxIsSelected();
        }
        if (checkBoxIsSelected) {
            com.tencent.could.huiyansdk.manager.d dVar = d.b.f100161a;
            dVar.a("ProtocolStage", "ProtocolAllow", "");
            if (HuiYanBaseApi.b.f100031a.a() == null) {
                k.a.f100197a.a(2, "ProtocolAllowFragment", "Context is null");
                String str = c().getString(R.string.msg_inner_error) + " context is null";
                String a16 = com.tencent.could.huiyansdk.manager.d.a(213L, str);
                dVar.a("AuthCheckStage", "HuiYanSdkInnerError", a16);
                CommonUtils.sendErrorAndExitAuth(213, str);
                view2 = a16;
            } else {
                dVar.a("ProtocolStage", "OpenCheckPage", "");
                b.a.f100131a.b(new AuthingFragment());
                view2 = dVar;
            }
        } else {
            Toast.makeText(getActivity(), R.string.txy_select_allow_protocol_notice_toast, 0).show();
            view2 = view3;
        }
        EventCollector.getInstance().onViewClicked(view2);
    }

    @Override // com.tencent.could.huiyansdk.fragments.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View onCreateView;
        boolean checkBoxIsSelected;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            onCreateView = (View) iPatchRedirector.redirect((short) 2, this, layoutInflater, viewGroup, bundle);
        } else {
            if (this.f100069a == null) {
                View inflate = layoutInflater.inflate(R.layout.i2m, viewGroup, false);
                this.f100069a = inflate;
                inflate.findViewById(R.id.f113606r3).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.could.huiyansdk.fragments.x
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ProtocolAllowFragment.this.a(view);
                    }
                });
                Button button = (Button) this.f100069a.findViewById(R.id.f113726re);
                button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.could.huiyansdk.fragments.y
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ProtocolAllowFragment.this.b(view);
                    }
                });
                ((ProtocolCheckView) this.f100069a.findViewById(R.id.f113736rf)).setButton(button);
                View view = this.f100069a;
                if (view == null) {
                    checkBoxIsSelected = false;
                } else {
                    checkBoxIsSelected = ((ProtocolCheckView) view.findViewById(R.id.f113736rf)).getCheckBoxIsSelected();
                }
                if (checkBoxIsSelected) {
                    button.setEnabled(true);
                }
                d.b.f100161a.a("ProtocolStage", "EnterProtocol", "");
            }
            View view2 = this.f100069a;
            CommonDataCache commonDataCache = HuiYanAuthImp.getInstance().getCommonDataCache();
            if (commonDataCache != null && commonDataCache.getConfigEntity().isNeedLogo()) {
                view2.findViewById(R.id.f113576r0).setVisibility(0);
            }
            onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.could.huiyansdk.fragments.BaseFragment
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        com.tencent.could.huiyansdk.manager.d dVar = d.b.f100161a;
        dVar.a("ProtocolStage", "ExitProtocolPage", "");
        dVar.a("AuthCheckStage", "UserCancelAuth", "");
        CommonUtils.sendErrorAndExitAuth(212, c().getString(R.string.f237067g2));
    }
}
