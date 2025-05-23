package com.tencent.mobileqq.guild.setting.guildmanage.blacklist;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.impl.GuildDTReportApiImpl;
import com.tencent.mobileqq.guild.component.GuildQUIEmptyState;
import com.tencent.mobileqq.guild.setting.guildmanage.blacklist.GuildBlacklistViewModel;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import er1.DrawableType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import vp1.q;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildBlacklistContentFragment extends QPublicBaseFragment implements p, TextWatcher {
    private q C;
    private View D;
    private String E;
    private com.tencent.mobileqq.guild.setting.guildmanage.blacklist.a F;
    private com.tencent.mobileqq.guild.setting.guildmanage.blacklist.a G;
    private GuildBlacklistViewModel H;
    private boolean I = false;
    private ViewTreeObserver.OnGlobalLayoutListener J = new a();
    private GuildQUIEmptyState K;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (GuildBlacklistContentFragment.this.C.f443082e.getVisibility() == 0 && !GuildBlacklistContentFragment.this.I) {
                GuildBlacklistContentFragment.this.I = true;
                VideoReport.reportPgIn(GuildBlacklistContentFragment.this.C.f443082e);
            } else if (GuildBlacklistContentFragment.this.C.f443082e.getVisibility() == 8 && GuildBlacklistContentFragment.this.I) {
                GuildBlacklistContentFragment.this.I = false;
                VideoReport.reportPgOut(GuildBlacklistContentFragment.this.C.f443082e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            if (GuildBlacklistContentFragment.this.H != null && GuildBlacklistContentFragment.this.H.h2()) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if ((layoutManager instanceof LinearLayoutManager) && ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition() >= layoutManager.getItemCount() - 1) {
                    GuildBlacklistContentFragment.this.H.loadMore();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
            if (i3 != 0 || i16 != 0) {
                GuildBlacklistContentFragment.this.H.s2(false);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void Ch(boolean z16) {
        if (z16) {
            this.C.f443083f.getRoot().setVisibility(0);
            this.C.f443083f.f443087b.clearFocus();
            this.C.f443083f.f443087b.addTextChangedListener(this);
            this.C.f443083f.f443092g.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.blacklist.i
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean Gh;
                    Gh = GuildBlacklistContentFragment.this.Gh(view, motionEvent);
                    return Gh;
                }
            });
            this.C.getRoot().setFocusableInTouchMode(true);
            this.C.f443082e.getViewTreeObserver().addOnGlobalLayoutListener(this.J);
        }
    }

    private void Dh() {
        GuildQUIEmptyState a16 = new GuildQUIEmptyState.a(getContext()).s(6).u(HardCodeUtil.qqStr(R.string.f155541hs)).o(0).a();
        this.C.f443084g.removeAllViews();
        this.C.f443084g.addView(a16);
        Eh();
    }

    private void Eh() {
        GuildQUIEmptyState a16 = new GuildQUIEmptyState.a(getContext()).s(3).u(QQGuildUIUtil.r(R.string.f140800ey)).r(false).o(0).a();
        this.K = a16;
        this.C.f443081d.addView(a16);
    }

    private boolean Fh() {
        return TextUtils.isEmpty(this.C.f443083f.f443087b.getText().toString().trim());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean Gh(View view, MotionEvent motionEvent) {
        this.H.s2(true);
        if (motionEvent.getAction() == 0) {
            VideoReport.reportEvent("clck", this.C.f443083f, new HashMap());
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Hh(GuildBlacklistViewModel.c cVar) {
        if (cVar != null) {
            Rh(cVar.f233710a, cVar.f233711b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Ih(cf1.b bVar) {
        if (bVar != null) {
            if (bVar.f30775b == 0) {
                QQToast.makeText(BaseApplication.getContext(), 2, bVar.f30774a, 1).show();
            } else {
                QQToast.makeText(BaseApplication.getContext(), 1, bVar.f30774a, 1).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Jh(Boolean bool) {
        if (bool.booleanValue()) {
            Th();
        } else {
            Sh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Kh(List list) {
        if (list.isEmpty() && !Fh()) {
            this.C.f443082e.setVisibility(8);
            this.C.f443084g.setVisibility(0);
        } else {
            this.C.f443082e.setVisibility(0);
            this.C.f443084g.setVisibility(8);
        }
        this.G.submitList(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Lh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.C.f443083f.f443087b.setText("");
        Sh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Mh(String str, ActionSheet actionSheet, View view, int i3) {
        this.H.o2(str);
        Qh(this.C.f443079b, str);
        actionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Nh() {
        Ph(this.C.f443079b);
    }

    public static GuildBlacklistContentFragment Oh(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("extra_guild_id", str);
        GuildBlacklistContentFragment guildBlacklistContentFragment = new GuildBlacklistContentFragment();
        guildBlacklistContentFragment.setArguments(bundle);
        return guildBlacklistContentFragment;
    }

    private void Ph(View view) {
        ch.Y0(view, "em_sgrp_blacklist_cancel", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent("clck", view, new HashMap());
    }

    private void Qh(View view, String str) {
        ch.Y0(view, "em_sgrp_blacklist_recover", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_touin", str);
        VideoReport.reportEvent("clck", view, hashMap);
    }

    private void Rh(int i3, List<fz1.b> list) {
        if (i3 != 1 && i3 != 5) {
            if (i3 != 2 && i3 != 3 && i3 != 4) {
                this.F.submitList(null);
            } else {
                this.F.submitList(list);
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new fz1.d());
            this.F.submitList(arrayList);
        }
        if (i3 == 6) {
            this.C.f443079b.setVisibility(8);
            this.C.f443081d.setVisibility(0);
            this.C.f443083f.getRoot().setVisibility(8);
            this.C.f443085h.setVisibility(8);
            this.C.f443083f.f443087b.setText("");
            Sh();
        } else {
            this.C.f443079b.setVisibility(0);
            this.C.f443081d.setVisibility(8);
            this.C.f443083f.getRoot().setVisibility(0);
        }
        if (i3 == 3) {
            this.D.setVisibility(0);
        } else {
            this.D.setVisibility(8);
        }
    }

    private void Sh() {
        this.C.f443080c.setVisibility(0);
        this.C.f443085h.setVisibility(8);
        this.C.f443083f.f443089d.setVisibility(8);
        this.C.f443083f.f443092g.setVisibility(0);
        this.C.f443083f.f443087b.setHint((CharSequence) null);
        this.C.f443083f.f443092g.setVisibility(0);
        InputMethodUtil.hide(this.C.f443083f.f443087b);
        this.C.f443083f.f443087b.clearFocus();
        this.C.f443083f.f443087b.setVisibility(8);
    }

    private void Th() {
        this.C.f443080c.setVisibility(8);
        this.C.f443085h.setVisibility(0);
        if (this.C.f443083f.f443087b.hasFocus()) {
            InputMethodUtil.show(this.C.f443083f.f443087b);
            return;
        }
        this.C.f443083f.f443092g.setVisibility(8);
        this.C.f443083f.f443087b.setHint(getString(R.string.f155451hj));
        this.C.f443083f.f443089d.setVisibility(0);
        this.C.f443083f.f443087b.setVisibility(0);
        this.C.f443083f.f443087b.setFocusable(true);
        this.C.f443083f.f443087b.setFocusableInTouchMode(true);
        this.C.f443083f.f443087b.requestFocus();
        InputMethodUtil.show(this.C.f443083f.f443087b);
    }

    private void initData() {
        this.E = getActivity().getIntent().getStringExtra("extra_guild_id");
        GuildBlacklistViewModel guildBlacklistViewModel = (GuildBlacklistViewModel) com.tencent.mobileqq.mvvm.h.b(this, GuildBlacklistViewModel.L).get(GuildBlacklistViewModel.class);
        this.H = guildBlacklistViewModel;
        guildBlacklistViewModel.g2(getContext(), this.E);
        this.H.addObserver();
        this.H.a2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.blacklist.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildBlacklistContentFragment.this.Hh((GuildBlacklistViewModel.c) obj);
            }
        });
        this.H.d2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.blacklist.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildBlacklistContentFragment.Ih((cf1.b) obj);
            }
        });
        this.H.b2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.blacklist.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildBlacklistContentFragment.this.Jh((Boolean) obj);
            }
        });
        this.H.getSearchResultData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.blacklist.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildBlacklistContentFragment.this.Kh((List) obj);
            }
        });
    }

    private void initDtReport() {
        GuildDTReportApiImpl guildDTReportApiImpl = new GuildDTReportApiImpl();
        VideoReport.addToDetectionWhitelist(getQBaseActivity());
        VideoReport.setPageId(this.C.getRoot(), "pg_sgrp_blacklist");
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_duration_flag", 1);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.C.getRoot(), this.E, hashMap);
        VideoReport.setPageId(this.C.f443082e, "pg_sgrp_blacklist_search_activation");
        guildDTReportApiImpl.setGuildPageParams(this.C.f443082e, this.E, new HashMap());
        q qVar = this.C;
        VideoReport.setLogicParent(qVar.f443082e, qVar.getRoot());
        VideoReport.setElementId(this.C.f443083f, "em_sgrp_search_box");
        VideoReport.setElementParams(this.C.f443083f, new HashMap());
    }

    private void initView() {
        new DrawableType(R.drawable.guild_member_search_box_close, Integer.valueOf(R.color.qui_common_icon_secondary)).b(this.C.f443083f.f443088c);
        Dh();
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.eju, (ViewGroup) null);
        this.D = inflate;
        this.C.f443079b.C(inflate);
        this.C.f443079b.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.F = new com.tencent.mobileqq.guild.setting.guildmanage.blacklist.a(new p() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.blacklist.b
            @Override // com.tencent.mobileqq.guild.setting.guildmanage.blacklist.p
            public final void E1(String str, String str2) {
                GuildBlacklistContentFragment.this.E1(str, str2);
            }
        });
        this.G = new com.tencent.mobileqq.guild.setting.guildmanage.blacklist.a(new p() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.blacklist.b
            @Override // com.tencent.mobileqq.guild.setting.guildmanage.blacklist.p
            public final void E1(String str, String str2) {
                GuildBlacklistContentFragment.this.E1(str, str2);
            }
        });
        this.C.f443079b.setAdapter(this.F);
        this.C.f443079b.H();
        this.C.f443079b.setHasFixedSize(true);
        this.C.f443082e.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.C.f443082e.setAdapter(this.G);
        Ch(true);
        this.C.f443083f.f443088c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.blacklist.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildBlacklistContentFragment.this.lambda$initView$0(view);
            }
        });
        this.C.f443083f.f443089d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.blacklist.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildBlacklistContentFragment.this.Lh(view);
            }
        });
        this.C.f443079b.addOnScrollListener(new b());
        this.C.f443082e.setItemAnimator(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.C.f443083f.f443087b.setText("");
        EventCollector.getInstance().onViewClicked(view);
    }

    private void startSearch(String str) {
        if (TextUtils.isEmpty(str)) {
            this.C.f443083f.f443088c.setVisibility(8);
            this.C.f443082e.setVisibility(8);
            this.C.f443084g.setVisibility(8);
        } else {
            this.C.f443083f.f443088c.setVisibility(0);
            this.H.r2(str);
        }
    }

    @Override // com.tencent.mobileqq.guild.setting.guildmanage.blacklist.p
    public void E1(final String str, String str2) {
        final ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(getActivity(), null);
        actionSheet.setMainTitle("\u5bf9 " + str2);
        actionSheet.addButton(getResources().getString(R.string.f152891am), 0);
        actionSheet.addCancelButton(R.string.f140850f3);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.blacklist.j
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                GuildBlacklistContentFragment.this.Mh(str, actionSheet, view, i3);
            }
        });
        actionSheet.setOnDismissListener(new ActionSheet.OnDismissListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.blacklist.k
            @Override // com.tencent.widget.ActionSheet.OnDismissListener
            public final void onDismiss() {
                GuildBlacklistContentFragment.this.Nh();
            }
        });
        actionSheet.show();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        startSearch(this.C.f443083f.f443087b.getText().toString().trim());
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.C = q.g(layoutInflater, viewGroup, false);
        initView();
        initData();
        initDtReport();
        LinearLayout root = this.C.getRoot();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, root);
        return root;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.H.removeObserver();
        this.C.f443082e.getViewTreeObserver().removeOnGlobalLayoutListener(this.J);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        VideoReport.traverseExposure();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
    }
}
