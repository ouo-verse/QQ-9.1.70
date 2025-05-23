package com.tencent.mobileqq.guild.channel.manage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.setting.GuildSettingsRecyclerView;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.cy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import vh2.bg;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQGuildChannelChooseCategoryFragment extends QQGuildTitleBarFragment implements View.OnClickListener {
    private GuildSettingsRecyclerView T;
    private b U;
    private String V;
    private long W;
    private String X;
    private final List<c> Y = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements bg {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f215057a;

        a(long j3) {
            this.f215057a = j3;
        }

        @Override // vh2.bg
        public void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
            if (i3 == 0 && ch.p(iGProSecurityResult)) {
                QQGuildChannelChooseCategoryFragment.this.U.y0(this.f215057a);
                QQGuildChannelChooseCategoryFragment.this.W = this.f215057a;
                return;
            }
            SecurityTipHelperKt.J(iGProSecurityResult, QQGuildChannelChooseCategoryFragment.this.getContext(), i3, BaseApplication.getContext().getString(R.string.f141910hy));
            QLog.w("Guild.mnr.QQGuildChannelChooseCategoryFragment", 1, "setChannelCategory result=" + i3 + " errMsg=" + str + " GuildId=" + QQGuildChannelChooseCategoryFragment.this.V + " ChannelId=" + QQGuildChannelChooseCategoryFragment.this.X + " CategoryId" + this.f215057a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class b extends QUIListItemAdapter implements com.tencent.mobileqq.widget.listitem.g {
        private final List<c> J;
        private View.OnClickListener K;
        private long L;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes12.dex */
        public class a implements com.tencent.mobileqq.widget.listitem.g {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ c f215059d;

            a(c cVar) {
                this.f215059d = cVar;
            }

            @Override // com.tencent.mobileqq.widget.listitem.g
            public void M(View view) {
                if (this.f215059d.f215063c) {
                    view.setOnClickListener(b.this.K);
                } else {
                    view.setOnClickListener(null);
                }
                view.setTag(this.f215059d);
                view.setId(R.id.wly);
            }
        }

        b(QUIListItemStyle qUIListItemStyle) {
            super(qUIListItemStyle);
            this.J = new ArrayList();
        }

        private void x0() {
            String str;
            com.tencent.mobileqq.widget.listitem.a<?>[] aVarArr = new com.tencent.mobileqq.widget.listitem.a[this.J.size()];
            int i3 = 0;
            while (true) {
                boolean z16 = true;
                if (i3 < this.J.size()) {
                    c cVar = this.J.get(i3);
                    if (TextUtils.isEmpty(cVar.f215062b)) {
                        str = BaseApplication.getContext().getString(R.string.f141790hm);
                    } else {
                        str = cVar.f215062b;
                    }
                    if (cVar.f215061a != this.L) {
                        z16 = false;
                    }
                    x xVar = new x(new x.b.d(str), new x.c.i(z16, null).b(this));
                    xVar.r(cVar.f215063c);
                    xVar.w(new a(cVar));
                    aVarArr[i3] = xVar;
                    i3++;
                } else {
                    t0(Group.INSTANCE.b(aVarArr));
                    return;
                }
            }
        }

        @Override // com.tencent.mobileqq.widget.listitem.g
        public void M(View view) {
            view.setClickable(false);
        }

        public void setData(List<c> list) {
            this.J.clear();
            this.J.addAll(list);
            x0();
        }

        public void w0(View.OnClickListener onClickListener) {
            this.K = onClickListener;
        }

        public void y0(long j3) {
            this.L = j3;
            x0();
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public long f215061a;

        /* renamed from: b, reason: collision with root package name */
        public String f215062b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f215063c;

        public c(long j3, String str, boolean z16) {
            this.f215061a = j3;
            this.f215062b = str;
            this.f215063c = z16;
        }
    }

    private void Hh(View view) {
        if (!NetworkUtil.isNetworkAvailable()) {
            ch.f1(BaseApplication.getContext().getString(R.string.f141910hy));
            return;
        }
        if (QQGuildUIUtil.v()) {
            ch.f1(BaseApplication.getContext().getString(R.string.f141240g5));
            return;
        }
        c cVar = (c) view.getTag();
        long j3 = this.W;
        long j16 = cVar.f215061a;
        if (j3 == j16) {
            return;
        }
        ((IGPSService) getAppInterface().getRuntimeService(IGPSService.class, "")).setChannelCategory(this.V, this.X, j16, new a(j16));
    }

    public static void Ih(Context context, String str, String str2, long j3) {
        QLog.i("Guild.mnr.QQGuildChannelChooseCategoryFragment", 1, "open gId:" + str + " channelId:" + str2 + " categoryId:" + j3);
        if (TextUtils.isEmpty(str)) {
            QQToastUtil.showQQToast(1, R.string.f143560me);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("extra_guild_id", str);
        intent.putExtra("extra_channel_category", j3);
        intent.putExtra("extra_channel_id", str2);
        QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivity.class, QQGuildChannelChooseCategoryFragment.class);
    }

    private void Jh() {
        boolean z16;
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        List<cy> channelCategoryList = iGPSService.getChannelCategoryList(this.V);
        if (channelCategoryList == null) {
            QLog.e("Guild.mnr.QQGuildChannelChooseCategoryFragment", 1, "getChannelCategoryList == null");
            QQToastUtil.showQQToast(1, R.string.f153041b1);
            requireActivity().finish();
            return;
        }
        ArrayList<Long> guildUserChannelCategoryAdminList = iGPSService.getGuildUserChannelCategoryAdminList(this.V, iGPSService.getSelfTinyId());
        if (guildUserChannelCategoryAdminList == null) {
            QLog.e("Guild.mnr.QQGuildChannelChooseCategoryFragment", 1, "getGuildUserChannelCategoryAdminList == null");
            guildUserChannelCategoryAdminList = new ArrayList<>();
        }
        boolean m06 = ch.m0(this.V);
        this.Y.clear();
        for (cy cyVar : channelCategoryList) {
            if (!m06 && !guildUserChannelCategoryAdminList.contains(Long.valueOf(cyVar.getCategoryId()))) {
                z16 = false;
            } else {
                z16 = true;
            }
            this.Y.add(new c(cyVar.getCategoryId(), cyVar.getCategoryName(), z16));
        }
        this.U.setData(this.Y);
    }

    private void Kh() {
        VideoReport.addToDetectionWhitelist(getQBaseActivity());
        VideoReport.setPageId(this.N, "pg_sgrp_channel_category_set");
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_sub_channel_id", this.X);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.N, this.V, hashMap);
    }

    private void initData() {
        Intent intent = getActivity().getIntent();
        this.V = intent.getStringExtra("extra_guild_id");
        this.W = intent.getLongExtra("extra_channel_category", 0L);
        this.X = intent.getStringExtra("extra_channel_id");
        b bVar = new b(QUIListItemStyle.FullWidth);
        this.U = bVar;
        bVar.w0(this);
        this.U.y0(this.W);
        this.T.setAdapter(this.U);
        this.T.setLayoutManager(new LinearLayoutManager(getContext()));
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.T.setItemAnimator(defaultItemAnimator);
        Jh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        setTitle(getResources().getString(R.string.f141250g6));
        GuildSettingsRecyclerView guildSettingsRecyclerView = (GuildSettingsRecyclerView) this.P.findViewById(R.id.f165452w25);
        this.T = guildSettingsRecyclerView;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) guildSettingsRecyclerView.getLayoutParams();
        layoutParams.topMargin = Utils.n(12.0f, getResources());
        this.T.setLayoutParams(layoutParams);
        m mVar = new m(getContext(), 0, 1, getResources().getColor(R.color.guild_skin_form_divider));
        mVar.b(QQGuildUIUtil.f(16.0f), 0);
        this.T.addItemDecoration(mVar);
        this.T.setHasTopSpace(false);
        initData();
        Kh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.ei7;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.wly) {
            Hh(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }
}
