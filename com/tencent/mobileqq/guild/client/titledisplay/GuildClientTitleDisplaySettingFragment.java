package com.tencent.mobileqq.guild.client.titledisplay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.data.w;
import com.tencent.mobileqq.guild.profile.profilecard.main.l;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.C11728RoundRectUrlImageView;
import com.tencent.mobileqq.mvvm.h;
import com.tencent.mobileqq.qqguildsdk.data.da;
import com.tencent.mobileqq.qqguildsdk.data.du;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildClientTitleDisplaySettingFragment extends QQGuildTitleBarFragment {
    private ListView T;
    private TextView U;
    private TextView V;
    private TextView W;
    private C11728RoundRectUrlImageView X;
    private TextView Y;
    private C11728RoundRectUrlImageView Z;

    /* renamed from: a0, reason: collision with root package name */
    private QQProgressDialog f215460a0;

    /* renamed from: b0, reason: collision with root package name */
    private com.tencent.mobileqq.guild.client.titledisplay.c f215461b0;

    /* renamed from: c0, reason: collision with root package name */
    public com.tencent.mobileqq.guild.client.titledisplay.d f215462c0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements Observer<da> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(da daVar) {
            if (daVar != null) {
                GuildClientTitleDisplaySettingFragment.this.f215461b0.d(daVar);
                GuildClientTitleDisplaySettingFragment.this.W.setText(GuildClientTitleDisplaySettingFragment.this.getString(R.string.f139640bt));
                GuildClientTitleDisplaySettingFragment.this.Y.setText(GuildClientTitleDisplaySettingFragment.this.getString(R.string.f139660bv));
                GuildClientTitleDisplaySettingFragment.this.Jh(daVar.a());
                return;
            }
            GuildClientTitleDisplaySettingFragment.this.f215461b0.c();
            List<da> value = GuildClientTitleDisplaySettingFragment.this.f215462c0.W1().getValue();
            if (value != null && !value.isEmpty()) {
                GuildClientTitleDisplaySettingFragment.this.W.setText(String.format(GuildClientTitleDisplaySettingFragment.this.getString(R.string.f139650bu), value.get(0).getClientName()));
                GuildClientTitleDisplaySettingFragment.this.Y.setText(String.format(GuildClientTitleDisplaySettingFragment.this.getString(R.string.f139670bw), value.get(0).getClientName()));
                GuildClientTitleDisplaySettingFragment.this.Jh(value.get(0).a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements Observer<List<da>> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(List<da> list) {
            if (GuildClientTitleDisplaySettingFragment.this.f215460a0 != null && GuildClientTitleDisplaySettingFragment.this.f215460a0.isShowing()) {
                GuildClientTitleDisplaySettingFragment.this.f215460a0.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d implements Observer<l> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(l lVar) {
            if (lVar.a() == -952356) {
                ch.f1(GuildClientTitleDisplaySettingFragment.this.getQBaseActivity().getString(R.string.f142460jf));
            } else if (lVar.a() == -952358) {
                String c16 = lVar.c();
                if (TextUtils.isEmpty(c16)) {
                    c16 = GuildClientTitleDisplaySettingFragment.this.getQBaseActivity().getString(R.string.f142440jd);
                }
                ch.f1(c16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jh(du duVar) {
        this.U.setText(duVar.b());
        this.V.setText(duVar.c());
        Nh(this.X, duVar.d());
        Nh(this.Z, duVar.a());
    }

    private void Kh(String str) {
        this.f215462c0 = (com.tencent.mobileqq.guild.client.titledisplay.d) h.b(this, com.tencent.mobileqq.guild.client.titledisplay.d.J).get(com.tencent.mobileqq.guild.client.titledisplay.d.class);
        com.tencent.mobileqq.guild.client.titledisplay.c cVar = new com.tencent.mobileqq.guild.client.titledisplay.c(this);
        this.f215461b0 = cVar;
        this.T.setAdapter((ListAdapter) cVar);
        this.T.setOnScrollListener(new a());
        this.f215462c0.c2(getAppInterface(), str);
        this.f215462c0.a2().observe(getViewLifecycleOwner(), new b());
        this.f215462c0.W1().observe(getViewLifecycleOwner(), new c());
        this.f215462c0.b2().observe(getViewLifecycleOwner(), new d());
    }

    private void Lh(C11728RoundRectUrlImageView c11728RoundRectUrlImageView) {
        c11728RoundRectUrlImageView.setAllRadius(x.c(getContext(), 6.0f));
        int c16 = x.f(getContext()).f185860a - (x.c(getContext(), 18.0f) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c11728RoundRectUrlImageView.getLayoutParams();
        layoutParams.width = c16;
        layoutParams.height = (int) ((c16 * 291.0f) / 792.0f);
        c11728RoundRectUrlImageView.setLayoutParams(layoutParams);
    }

    public static void Mh(Context context, String str) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("guild_id", str);
        intent.putExtras(bundle);
        QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivity.class, GuildClientTitleDisplaySettingFragment.class);
    }

    private void Nh(ImageView imageView, String str) {
        imageView.setImageDrawable(URLDrawable.getDrawable(str, URLDrawable.URLDrawableOptions.obtain()));
    }

    private void Oh() {
        if (TextUtils.isEmpty(this.f215462c0.getGuildId())) {
            return;
        }
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.N, "pg_sgrp_otherapp_identity_set");
        HashMap hashMap = new HashMap();
        w.a(hashMap);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.N, this.f215462c0.getGuildId(), hashMap);
    }

    private void initUI() {
        setTitle(getString(R.string.f156451k9));
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ejm, (ViewGroup) null);
        this.T = (ListView) this.P.findViewById(R.id.tyi);
        this.T.addHeaderView(LayoutInflater.from(getContext()).inflate(R.layout.ejn, (ViewGroup) null));
        this.T.addFooterView(inflate);
        this.U = (TextView) inflate.findViewById(R.id.xp7);
        this.V = (TextView) inflate.findViewById(R.id.far);
        this.W = (TextView) inflate.findViewById(R.id.tsi);
        C11728RoundRectUrlImageView c11728RoundRectUrlImageView = (C11728RoundRectUrlImageView) inflate.findViewById(R.id.f124987ku);
        this.X = c11728RoundRectUrlImageView;
        c11728RoundRectUrlImageView.setAllRadius(x.c(getContext(), 6.0f));
        Lh(this.X);
        this.Y = (TextView) inflate.findViewById(R.id.f166219z22);
        C11728RoundRectUrlImageView c11728RoundRectUrlImageView2 = (C11728RoundRectUrlImageView) inflate.findViewById(R.id.f166218z21);
        this.Z = c11728RoundRectUrlImageView2;
        c11728RoundRectUrlImageView2.setAllRadius(x.c(getContext(), 6.0f));
        Lh(this.Z);
        this.f215460a0 = new QQProgressDialog(getActivity());
        this.P.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.client.titledisplay.GuildClientTitleDisplaySettingFragment.1
            @Override // java.lang.Runnable
            public void run() {
                if (GuildClientTitleDisplaySettingFragment.this.f215462c0.W1().getValue() == null) {
                    GuildClientTitleDisplaySettingFragment.this.f215460a0.show();
                }
            }
        }, 700L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        String string = getActivity().getIntent().getExtras().getString("guild_id");
        if (TextUtils.isEmpty(string)) {
            QLog.e("GuildClientTitleDisplaySettingFragment", 2, "open GuildClientTitleDisplaySettingFragment guildId is null");
            getActivity().finish();
        }
        initUI();
        Kh(string);
        Oh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.ejl;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        QQProgressDialog qQProgressDialog = this.f215460a0;
        if (qQProgressDialog != null) {
            qQProgressDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements AbsListView.OnScrollListener {
        a() {
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            if (GuildClientTitleDisplaySettingFragment.this.f215461b0.getCount() - GuildClientTitleDisplaySettingFragment.this.T.getLastVisiblePosition() <= 20 && !GuildClientTitleDisplaySettingFragment.this.f215462c0.X1().getValue().booleanValue() && !GuildClientTitleDisplaySettingFragment.this.f215462c0.Z1().getValue().booleanValue()) {
                GuildClientTitleDisplaySettingFragment.this.f215462c0.d2();
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        }
    }
}
