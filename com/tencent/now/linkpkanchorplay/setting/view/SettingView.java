package com.tencent.now.linkpkanchorplay.setting.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.now.linkpkanchorplay.setting.view.SettingView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dn3.c;
import g55.ab;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class SettingView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private View f338483d;

    /* renamed from: e, reason: collision with root package name */
    private FormSwitchItem f338484e;

    /* renamed from: f, reason: collision with root package name */
    ab f338485f;

    /* renamed from: h, reason: collision with root package name */
    private dn3.c f338486h;

    /* renamed from: i, reason: collision with root package name */
    private c f338487i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (SettingView.this.f338487i != null) {
                SettingView.this.f338487i.onBack();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements c.a {
        b() {
        }

        @Override // dn3.c.a
        public void a(ab abVar) {
            if (abVar == null) {
                return;
            }
            SettingView settingView = SettingView.this;
            settingView.f338485f = abVar;
            settingView.f338484e.setChecked(abVar.f401289a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface c {
        void onBack();
    }

    public SettingView(@NonNull Context context) {
        super(context);
        this.f338485f = new ab();
        this.f338486h = new dn3.c();
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        h(z16);
        g(this.f338484e, "em_qqlive_lppk_set_accept_anchor", z16 ? 1 : 0);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private void g(View view, String str, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("qqlive_lppk_set", String.valueOf(i3));
        hashMap.put("eid", str);
        com.tencent.report.a.f364907a.g(view, hashMap);
    }

    private void h(boolean z16) {
        ab abVar = this.f338485f;
        abVar.f401289a = z16;
        abVar.f401290b = z16;
        this.f338486h.g(abVar);
    }

    public void d() {
        ab abVar = this.f338485f;
        abVar.f401289a = true;
        abVar.f401290b = false;
        this.f338486h.c();
        this.f338486h.f(new b());
    }

    public void e() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f168238ff2, (ViewGroup) this, true);
        View findViewById = inflate.findViewById(R.id.t2s);
        this.f338483d = findViewById;
        findViewById.setOnClickListener(new a());
        FormSwitchItem formSwitchItem = (FormSwitchItem) inflate.findViewById(R.id.s6p);
        this.f338484e = formSwitchItem;
        formSwitchItem.setBackgroundColor(Color.parseColor("#05001F"));
        this.f338484e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: en3.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                SettingView.this.f(compoundButton, z16);
            }
        });
        com.tencent.report.a.f364907a.c(this.f338484e, true, null, "em_qqlive_lppk_set_accept_anchor", new HashMap());
        d();
    }

    public void setCallback(c cVar) {
        this.f338487i = cVar;
    }

    public SettingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f338485f = new ab();
        this.f338486h = new dn3.c();
        e();
    }

    public SettingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f338485f = new ab();
        this.f338486h = new dn3.c();
        e();
    }
}
