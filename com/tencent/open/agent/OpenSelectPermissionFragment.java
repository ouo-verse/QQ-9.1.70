package com.tencent.open.agent;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.report.OpenAuthTelemetryProxy;
import com.tencent.open.agent.util.AuthUIUtil;
import com.tencent.open.agent.util.r;
import com.tencent.open.agent.util.t;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.widget.Switch;
import java.util.List;
import mqq.app.MobileQQ;

/* loaded from: classes22.dex */
public class OpenSelectPermissionFragment extends QPublicBaseFragment implements ep3.k, View.OnClickListener {
    private View C;
    private View D;
    private Button E;
    private ImageView F;
    private QQProgressDialog G;
    private ep3.j H;
    private boolean I;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* loaded from: classes22.dex */
    private class b extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        List<hp3.e> f339929d;

        /* loaded from: classes22.dex */
        class a implements CompoundButton.OnCheckedChangeListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ hp3.e f339931d;

            a(hp3.e eVar) {
                this.f339931d = eVar;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
                t.b("OpenSelectPermissionFragment", "onCheckedChanged item=" + this.f339931d.f405820b + ", isChecked=" + z16);
                this.f339931d.f405825g = z16;
                b.this.notifyDataSetChanged();
                Intent intent = OpenSelectPermissionFragment.this.getQBaseActivity().getIntent();
                com.tencent.open.agent.util.g.Q(null, "0X800B936", z16 ? 1 : 0, new String[]{OpenSelectPermissionFragment.rh(intent), "", intent.getStringExtra("appName"), this.f339931d.f405820b});
                EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
            }
        }

        b() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<hp3.e> list = this.f339929d;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            List<hp3.e> list = this.f339929d;
            if (list != null && i3 < list.size()) {
                return this.f339929d.get(i3);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            c cVar;
            hp3.e eVar = this.f339929d.get(i3);
            if (view == null) {
                view = OpenSelectPermissionFragment.this.getQBaseActivity().getLayoutInflater().inflate(R.layout.f168472x3, viewGroup, false);
                cVar = new c();
                cVar.f339933a = (TextView) view.findViewById(R.id.f240107z);
                cVar.f339934b = (TextView) view.findViewById(R.id.f237907d);
                cVar.f339935c = (Switch) view.findViewById(R.id.flh);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            cVar.f339935c.setChecked(eVar.f405825g);
            cVar.f339935c.setOnCheckedChangeListener(new a(eVar));
            cVar.f339933a.setText(eVar.f405820b);
            if (!TextUtils.isEmpty(eVar.f405821c)) {
                cVar.f339934b.setVisibility(0);
                cVar.f339934b.setText(eVar.f405821c);
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }

        public void setData(List<hp3.e> list) {
            this.f339929d = list;
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes22.dex */
    private static class c {

        /* renamed from: a, reason: collision with root package name */
        TextView f339933a;

        /* renamed from: b, reason: collision with root package name */
        TextView f339934b;

        /* renamed from: c, reason: collision with root package name */
        Switch f339935c;

        c() {
        }
    }

    private boolean qh() {
        if (!NetworkUtil.isNetworkAvailable(MobileQQ.sMobileQQ)) {
            AuthUIUtil.f(getQBaseActivity(), HardCodeUtil.qqStr(R.string.f171155cp4), new a());
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String rh(Intent intent) {
        long c16 = com.tencent.open.agent.util.o.c(intent.getStringExtra("appId"));
        long c17 = com.tencent.open.agent.util.o.c(intent.getStringExtra("key_proxy_appid"));
        if (c17 <= 0) {
            return String.valueOf(c16);
        }
        return String.valueOf(c17);
    }

    @Override // ep3.k
    public void Dc(ep3.j jVar) {
        this.H = jVar;
    }

    @Override // ep3.k
    public void L() {
        AuthUIUtil.c(getQBaseActivity(), this.G);
    }

    @Override // ep3.k
    @Nullable
    public /* bridge */ /* synthetic */ Activity getActivity() {
        return super.getActivity();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, @Nullable Intent intent) {
        if (com.tencent.open.agent.auth.api.impl.a.a(getQBaseActivity(), i3, i16, intent)) {
            return;
        }
        super.onActivityResult(i3, i16, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.C) {
            if (getQBaseActivity() != null) {
                getQBaseActivity().finish();
            }
        } else if (view == this.E) {
            if (!r.a(view) && qh()) {
                this.H.c(true);
                com.tencent.open.agent.util.g.O("0X800BA7E");
                OpenAuthTelemetryProxy.d();
            }
        } else if (view == this.D) {
            Intent intent = new Intent();
            intent.putExtra("key_cancel_auth", 1);
            getQBaseActivity().setResult(102, intent);
            getQBaseActivity().finish();
            com.tencent.open.agent.util.g.O("0X800BA7F");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @SuppressLint({"UseCompatLoadingForDrawables"})
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.f168469x0, viewGroup, false);
        this.C = inflate.findViewById(R.id.a47);
        this.D = inflate.findViewById(R.id.aou);
        inflate.findViewById(R.id.jq6).setBackgroundColor(0);
        this.F = (ImageView) inflate.findViewById(R.id.f164385vs);
        this.C.setOnClickListener(this);
        Button button = (Button) inflate.findViewById(R.id.b7p);
        this.E = button;
        button.setOnClickListener(this);
        this.D.setOnClickListener(this);
        b bVar = new b();
        Intent intent = getQBaseActivity().getIntent();
        ep3.a.d(this, getContext());
        this.H.b(intent);
        ListView listView = (ListView) inflate.findViewById(R.id.fle);
        listView.setDivider(requireContext().getDrawable(R.drawable.qui_common_border_standard_bg));
        listView.setDividerHeight(1);
        listView.addHeaderView(new View(getContext()));
        listView.setHeaderDividersEnabled(true);
        listView.setFooterDividersEnabled(true);
        listView.setAdapter((ListAdapter) bVar);
        bVar.setData(this.H.e());
        this.H.d(intent.getBooleanExtra("hasIcon", false));
        String stringExtra = intent.getStringExtra("appName");
        t.b("OpenSelectPermissionFragment", "onCreateView appName=", stringExtra);
        if (!TextUtils.isEmpty(stringExtra)) {
            ((TextView) inflate.findViewById(R.id.f164387vu)).setText(getResources().getString(R.string.f172772rc, stringExtra));
        }
        com.tencent.open.agent.util.g.R(null, "0X800B935", new String[]{rh(intent), "", stringExtra, this.H.a()});
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        t.b("OpenSelectPermissionFragment", "onResume--hasSetStateBar=", Boolean.valueOf(this.I));
        super.onResume();
        if (!this.I) {
            com.tencent.open.agent.util.g.Y(getQBaseActivity());
            this.I = true;
        }
    }

    @Override // ep3.k
    public void setImageBitmap(Bitmap bitmap) {
        this.F.setImageBitmap(bitmap);
    }

    @Override // ep3.k
    public void showLoading() {
        t.b("OpenSelectPermissionFragment", UIJsPlugin.EVENT_SHOW_LOADING);
        this.G = AuthUIUtil.k(getQBaseActivity(), null, R.layout.b17);
    }
}
