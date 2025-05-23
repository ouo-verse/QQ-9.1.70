package com.tencent.mobileqq.weather.debug;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.ad.cardad.data.z;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.inputview.QUISingleLineInputView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes20.dex */
public class WeatherDebugFragment extends QIphoneTitleBarFragment {
    static IPatchRedirector $redirector_;

    public WeatherDebugFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Ah(QUISingleLineInputView qUISingleLineInputView, TextView textView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        String charSequence = qUISingleLineInputView.d().toString();
        if (!TextUtils.isEmpty(charSequence)) {
            com.tencent.mobileqq.weather.util.g.f313646a.O(textView.getContext(), charSequence);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public static void Bh(Activity activity) {
        if (activity == null) {
            QLog.e("WeatherDebugFragment", 1, "start error");
        } else {
            QPublicFragmentActivity.start(activity, WeatherDebugFragment.class);
        }
    }

    private void initView(View view) {
        if (view == null) {
            return;
        }
        FormSwitchItem formSwitchItem = (FormSwitchItem) view.findViewById(R.id.f121097ab);
        g gVar = g.f313380a;
        formSwitchItem.setChecked(gVar.c());
        formSwitchItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.weather.debug.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                WeatherDebugFragment.vh(compoundButton, z16);
            }
        });
        FormSwitchItem formSwitchItem2 = (FormSwitchItem) view.findViewById(R.id.f121067a9);
        formSwitchItem2.setChecked(gVar.b());
        formSwitchItem2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.weather.debug.b
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                WeatherDebugFragment.wh(compoundButton, z16);
            }
        });
        FormSwitchItem formSwitchItem3 = (FormSwitchItem) view.findViewById(R.id.f121117ad);
        formSwitchItem3.setChecked(gVar.d());
        formSwitchItem3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.weather.debug.c
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                WeatherDebugFragment.xh(compoundButton, z16);
            }
        });
        FormSwitchItem formSwitchItem4 = (FormSwitchItem) view.findViewById(R.id.f121057a8);
        formSwitchItem4.setChecked(z.f186721a.a());
        formSwitchItem4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.weather.debug.d
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                WeatherDebugFragment.yh(compoundButton, z16);
            }
        });
        FormSwitchItem formSwitchItem5 = (FormSwitchItem) view.findViewById(R.id.f121127ae);
        formSwitchItem5.setChecked(gVar.e());
        formSwitchItem5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.weather.debug.e
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                WeatherDebugFragment.zh(compoundButton, z16);
            }
        });
        final QUISingleLineInputView qUISingleLineInputView = (QUISingleLineInputView) view.findViewById(R.id.f121087aa);
        final TextView textView = (TextView) view.findViewById(R.id.f121077a_);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.weather.debug.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WeatherDebugFragment.Ah(QUISingleLineInputView.this, textView, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void vh(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        g.f313380a.g(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void wh(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        g.f313380a.f(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void xh(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        g.f313380a.h(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void yh(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        z.f186721a.c(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void zh(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        g.f313380a.i(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.h78;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) bundle);
            return;
        }
        super.onViewCreated(view, bundle);
        setTitle("QQ\u5929\u6c14");
        initView(view);
    }
}
