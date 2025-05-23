package com.tencent.could.huiyansdk.fragments;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import com.tencent.could.huiyansdk.api.HuiYanAuthImp;
import com.tencent.could.huiyansdk.entity.CommonDataCache;
import com.tencent.could.huiyansdk.manager.b;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

/* loaded from: classes5.dex */
public class ProtocolShowFragment extends BaseFragment {
    static IPatchRedirector $redirector_;

    public ProtocolShowFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.tencent.could.huiyansdk.manager.b, android.view.View] */
    public static void a(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ?? r26 = b.a.f100131a;
        FragmentManager fragmentManager = r26.f100129b;
        if (fragmentManager != null || fragmentManager.getBackStackEntryCount() > 1) {
            r26.f100129b.popBackStack();
        }
        EventCollector.getInstance().onViewClicked(r26);
    }

    @Override // com.tencent.could.huiyansdk.fragments.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View onCreateView;
        String authText;
        Spanned fromHtml;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            onCreateView = (View) iPatchRedirector.redirect((short) 2, this, layoutInflater, viewGroup, bundle);
        } else {
            if (this.f100069a == null) {
                View inflate = layoutInflater.inflate(R.layout.i2n, viewGroup, false);
                this.f100069a = inflate;
                inflate.findViewById(R.id.f113656r8).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.could.huiyansdk.fragments.z
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ProtocolShowFragment.a(view);
                    }
                });
                TextView textView = (TextView) this.f100069a.findViewById(R.id.f113626r5);
                CommonDataCache commonDataCache = HuiYanAuthImp.getInstance().getCommonDataCache();
                if (commonDataCache == null) {
                    authText = c().getString(R.string.txy_users_protocol_content1);
                } else {
                    authText = commonDataCache.getConfigEntity().getAuthText();
                    if (TextUtils.isEmpty(authText)) {
                        authText = c().getString(R.string.txy_users_protocol_content1);
                    }
                }
                if (Build.VERSION.SDK_INT >= 24) {
                    fromHtml = Html.fromHtml(authText, 0);
                    textView.setText(fromHtml);
                } else {
                    textView.setText(Html.fromHtml(authText));
                }
            }
            onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }
}
