package com.tencent.could.huiyansdk.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.could.huiyansdk.api.HuiYanAuthImp;
import com.tencent.could.huiyansdk.entity.CompareResult;
import com.tencent.could.huiyansdk.enums.PageColorStyle;
import com.tencent.could.huiyansdk.manager.d;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.could.huiyansdk.utils.HYPCommonUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AuthResultFragment extends BaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public RelativeLayout f100041b;

    /* renamed from: c, reason: collision with root package name */
    public ImageView f100042c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f100043d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f100044e;

    /* renamed from: f, reason: collision with root package name */
    public Button f100045f;

    /* renamed from: g, reason: collision with root package name */
    public CompareResult f100046g;

    public AuthResultFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        HYPCommonUtils.doResultCallBackResult(this.f100046g);
        b();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        HYPCommonUtils.doResultCallBackResult(this.f100046g);
        b();
    }

    @Override // com.tencent.could.huiyansdk.fragments.BaseFragment
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            k.a.f100197a.a(1, "AuthResultFragment", "back pop event!");
            a(new Runnable() { // from class: com.tencent.could.huiyansdk.fragments.j
                @Override // java.lang.Runnable
                public final void run() {
                    AuthResultFragment.this.d();
                }
            });
        }
    }

    @Override // com.tencent.could.huiyansdk.fragments.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View onCreateView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            onCreateView = (View) iPatchRedirector.redirect((short) 2, this, layoutInflater, viewGroup, bundle);
        } else {
            this.f100069a = layoutInflater.inflate(R.layout.i2j, viewGroup, false);
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f100046g = (CompareResult) arguments.getParcelable("compareResult");
            } else {
                this.f100046g = new CompareResult();
            }
            a(this.f100069a);
            d.b.f100161a.a("ShowResultStage", "EnterShowResultPage", "");
            onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.could.huiyansdk.fragments.BaseFragment
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.b();
        k.a.f100197a.a(1, "AuthResultFragment", "auth result exit!");
        d.b.f100161a.a("ShowResultStage", "LiveAuthResultPage", "");
    }

    public final void a(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
            return;
        }
        this.f100041b = (RelativeLayout) view.findViewById(R.id.f113696rb);
        this.f100042c = (ImageView) view.findViewById(R.id.f113686ra);
        this.f100043d = (TextView) view.findViewById(R.id.f113716rd);
        this.f100044e = (TextView) view.findViewById(R.id.f113706rc);
        this.f100045f = (Button) view.findViewById(R.id.f113676r_);
        if (HuiYanAuthImp.getInstance().getPageColorStyle() == PageColorStyle.Dark) {
            this.f100041b.setBackgroundColor(c().getColor(R.color.cwu));
            this.f100043d.setTextColor(c().getColor(R.color.cxh));
            this.f100045f.setTextColor(c().getColor(R.color.cxh));
        }
        CompareResult compareResult = this.f100046g;
        if (compareResult == null) {
            k.a.f100197a.a(2, "AuthResultFragment", "compare result is null");
            return;
        }
        if (compareResult.getErrorCode() != 0) {
            this.f100042c.setImageResource(R.drawable.f162631lz3);
            this.f100043d.setText(R.string.txy_auth_fail);
            this.f100045f.setText(R.string.txy_exit);
            if (this.f100046g.getErrorMsg().equals("")) {
                this.f100044e.setText(getText(R.string.txy_show_auth_result_error));
            } else {
                this.f100044e.setText(this.f100046g.getErrorMsg());
            }
        }
        this.f100045f.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.could.huiyansdk.fragments.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AuthResultFragment.this.b(view2);
            }
        });
    }
}
