package com.tencent.mobileqq.guild.inbox.centerpanel.notice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.IGuildWebApi;
import com.tencent.mobileqq.guild.component.GuildQUIEmptyState;
import com.tencent.mobileqq.guild.inbox.startpanel.dialog.InboxNoticeNodeSettingDialog;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter;
import com.tencent.mobileqq.guild.widget.RecyclerViewWithHeaderFooter;
import com.tencent.mobileqq.guild.widget.anim.GuildScaleInItemAnimator;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.co;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import oh1.DrawableType;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildNoticeFragment extends QPublicBaseFragment {
    private View C;
    private View D;
    private TextView E;
    private LinearLayout F;
    private OverScrollRecyclerViewWithHeaderFooter G;
    private com.tencent.mobileqq.guild.mainframe.i H;
    private com.tencent.mobileqq.guild.inbox.centerpanel.notice.c I;
    private w J;
    private InboxNoticeNodeSettingDialog K;
    private final RecyclerView.ItemDecoration L = new a();

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class a extends RecyclerView.ItemDecoration {
        a() {
        }

        private int a() {
            return GuildNoticeFragment.this.J.f2();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            if (recyclerView.getChildAdapterPosition(view) == a() - 1) {
                rect.set(0, 0, 0, ViewUtils.dpToPx(12.0f));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class b implements kv1.a {
        b() {
        }

        @Override // kv1.a
        public void a() {
            if (GuildNoticeFragment.this.I.getNUM_BACKGOURND_ICON() > 0) {
                com.tencent.mobileqq.guild.performance.report.q.b(GuildNoticeFragment.this.I.getNUM_BACKGOURND_ICON());
                GuildNoticeFragment.this.G.O();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class d extends RecyclerView.OnScrollListener {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            if (i3 != 0) {
                return;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (!(layoutManager instanceof LinearLayoutManager)) {
                return;
            }
            if (GuildNoticeFragment.this.I.getNUM_BACKGOURND_ICON() - ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition() < 10 && !GuildNoticeFragment.this.J.j2()) {
                GuildNoticeFragment.this.J.q2(GuildNoticeFragment.this.getGuildId());
            } else if (GuildNoticeFragment.this.J.j2()) {
                GuildNoticeFragment.this.E.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class e implements y {
        e() {
        }

        @Override // com.tencent.mobileqq.guild.inbox.centerpanel.notice.y
        public void a(@NonNull co coVar) {
            int i3 = coVar.f265899o;
            if (i3 != 11) {
                return;
            }
            if (i3 == 11 && !coVar.f265898n.isEmpty()) {
                if (ch.j0(coVar.f265890f)) {
                    GuildNoticeFragment.this.J.g2(coVar, GuildNoticeFragment.this.H, GuildNoticeFragment.this.getContext());
                    return;
                } else {
                    ((IGuildWebApi) QRoute.api(IGuildWebApi.class)).openWebUrlOnlyForGuild(GuildNoticeFragment.this.getActivity(), coVar.f265898n.get(0).f265912b, null, "", coVar.f265890f);
                    return;
                }
            }
            if (GuildNoticeFragment.this.getActivity().getIntent().getBooleanExtra("is_from_feed_notice", false)) {
                GuildNoticeFragment.this.getActivity().setResult(1001);
                GuildNoticeFragment.this.onBackEvent();
            } else {
                GuildNoticeFragment.this.J.i2(coVar, GuildNoticeFragment.this.H, GuildNoticeFragment.this.getContext());
            }
        }

        @Override // com.tencent.mobileqq.guild.inbox.centerpanel.notice.y
        public void b(@NonNull String str) {
            QLog.d("Guild.C2C.GuildNoticeFragment", 1, "urlJumpCallback ", str);
            ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).openGuildByShareUrl(GuildNoticeFragment.this.getActivity(), str, "");
        }

        @Override // com.tencent.mobileqq.guild.inbox.centerpanel.notice.y
        public void c(@NonNull String str, @NonNull String str2) {
            GuildNoticeFragment.this.J.h2(str, str2);
        }

        @Override // com.tencent.mobileqq.guild.inbox.centerpanel.notice.y
        public void d(String str, Function1<? super IGProGuildInfo, Unit> function1) {
            GuildNoticeFragment.this.J.W1(str, function1);
        }
    }

    @NonNull
    private y Ah() {
        return new e();
    }

    @NonNull
    private RecyclerView.OnScrollListener Bh() {
        return new d();
    }

    private void Ch() {
        LinearLayout linearLayout = (LinearLayout) this.C.findViewById(R.id.wsu);
        this.F = linearLayout;
        linearLayout.setVisibility(8);
        this.F.addView(new GuildQUIEmptyState.a(getContext()).s(3).u(HardCodeUtil.qqStr(R.string.f1513817j)).r(false).o(0).a());
    }

    private void Dh(View view) {
        view.setFitsSystemWindows(false);
        View findViewById = view.findViewById(R.id.xl7);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.height = ImmersiveUtils.getStatusBarHeight(getContext());
        layoutParams.width = -2;
        findViewById.setLayoutParams(layoutParams);
        findViewById.setBackgroundColor(view.getContext().getResources().getColor(R.color.qui_common_fill_light_primary));
    }

    private void Eh() {
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = (OverScrollRecyclerViewWithHeaderFooter) this.C.findViewById(R.id.w28);
        this.G = overScrollRecyclerViewWithHeaderFooter;
        overScrollRecyclerViewWithHeaderFooter.setDrawListener(new b());
        this.D = LayoutInflater.from(getActivity()).inflate(R.layout.eju, (ViewGroup) null);
        this.G.setVerticalScrollBarEnabled(false);
        this.G.addOnScrollListener(Bh());
        this.G.setItemAnimator(new GuildScaleInItemAnimator());
        this.G.setHasFixedSize(false);
    }

    private void Fh() {
        TextView textView = new TextView(getContext());
        this.E = textView;
        textView.setText(R.string.f1514517q);
        this.E.setGravity(17);
        this.E.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.E.setPadding(0, QQGuildUIUtil.f(16.0f), 0, QQGuildUIUtil.f(10.0f));
        oh1.a.a(this.E, R.color.qui_common_text_tertiary);
        this.E.setTextSize(13.0f);
        this.E.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Gh(Boolean bool) {
        Rh(bool, this.D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Hh(Boolean bool) {
        int i3;
        TextView textView = this.E;
        if (bool.booleanValue()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ih(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        onBackEvent();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Jh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Lh();
        EventCollector.getInstance().onViewClicked(view);
    }

    public static GuildNoticeFragment Kh(Intent intent) {
        GuildNoticeFragment guildNoticeFragment = new GuildNoticeFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("data", intent);
        guildNoticeFragment.setArguments(bundle);
        return guildNoticeFragment;
    }

    private void Lh() {
        if (QQGuildUIUtil.v()) {
            return;
        }
        if (this.K == null) {
            this.K = new InboxNoticeNodeSettingDialog(null, false);
        }
        if (this.K.isAdded()) {
            return;
        }
        this.K.Ph(yp1.a.b(6));
        com.tencent.mobileqq.guild.base.extension.d.a(this.K, getParentFragmentManager(), "Guild.C2C.GuildNoticeFragment");
    }

    public static void Mh(Context context, String str) {
        Nh(context, str, 0, false, null);
    }

    public static void Nh(Context context, String str, int i3, boolean z16, Bundle bundle) {
        Intent intent = new Intent();
        if (!StringUtil.isEmpty(str)) {
            try {
                Long.parseLong(str);
                intent.putExtra("extra_guild_id", str);
            } catch (NumberFormatException unused) {
                QLog.e("Guild.C2C.GuildNoticeFragment", 1, "\u8df3\u8f6c\u9891\u9053\u7ba1\u7406\u7c7b\u901a\u77e5\u9875\u9762\uff0cguildId\u4e0d\u5408\u6cd5\uff0c\u8f6c\u6362\u4e3along\u7c7b\u578b\u5931\u8d25");
                QQToast.makeText(context, "\u6682\u65f6\u65e0\u6cd5\u67e5\u770b", 1).show();
                return;
            }
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("is_from_feed_notice", z16);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (i3 == 0) {
            QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivity.class, GuildNoticeFragment.class);
        } else {
            QPublicFragmentActivity.b.f(context, intent, QPublicFragmentActivity.class, GuildNoticeFragment.class, i3);
        }
    }

    private void Oh() {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.C, "pg_sgrp_auditnotification_set");
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_channel_id", getGuildId());
        hashMap.put("sgrp_user_type", Integer.valueOf(com.tencent.mobileqq.guild.data.v.c(getGuildId())));
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        VideoReport.setPageParams(this.C, new PageParams(hashMap));
    }

    private void Qh(boolean z16) {
        if (z16) {
            this.F.setVisibility(0);
            this.G.setVisibility(8);
        } else {
            this.F.setVisibility(8);
            this.G.setVisibility(0);
        }
    }

    private void Rh(Boolean bool, View view) {
        if (bool != null && bool.booleanValue()) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sh(List<co> list) {
        boolean z16;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        Qh(z16);
        if (!z16) {
            this.I.setItems(list);
        }
        VideoReport.traversePage(this.C);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getGuildId() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            QLog.e("Guild.C2C.GuildNoticeFragment", 1, "activity is null");
            return "";
        }
        String stringExtra = activity.getIntent().getStringExtra("extra_guild_id");
        if (stringExtra == null) {
            return "";
        }
        return stringExtra;
    }

    private void initData() {
        this.G.setLayoutManager(new LinearLayoutManager(getContext()));
        com.tencent.mobileqq.guild.inbox.centerpanel.notice.c cVar = new com.tencent.mobileqq.guild.inbox.centerpanel.notice.c(Ah());
        this.I = cVar;
        cVar.o0(new c());
        RecyclerViewWithHeaderFooter.c cVar2 = new RecyclerViewWithHeaderFooter.c(this.I);
        cVar2.k0(this.E);
        cVar2.k0(this.D);
        this.G.setAdapter(cVar2);
        this.G.addItemDecoration(this.L);
        w wVar = (w) com.tencent.mobileqq.mvvm.h.a(this).get(w.class);
        this.J = wVar;
        wVar.a2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.notice.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildNoticeFragment.this.Sh((List) obj);
            }
        });
        MutableLiveData<Integer> c26 = this.J.c2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final com.tencent.mobileqq.guild.inbox.centerpanel.notice.c cVar3 = this.I;
        Objects.requireNonNull(cVar3);
        c26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.notice.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                c.this.notifyItemChanged(((Integer) obj).intValue());
            }
        });
        LiveData<Integer> e26 = this.J.e2();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final com.tencent.mobileqq.guild.inbox.centerpanel.notice.c cVar4 = this.I;
        Objects.requireNonNull(cVar4);
        e26.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.notice.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                c.this.n0(((Integer) obj).intValue());
            }
        });
        this.J.k2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.notice.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildNoticeFragment.this.Gh((Boolean) obj);
            }
        });
        this.J.initData();
        this.J.r2(getGuildId());
        this.J.b2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.notice.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildNoticeFragment.this.Hh((Boolean) obj);
            }
        });
    }

    private void initTitleBar() {
        ImageView imageView = (ImageView) this.C.findViewById(R.id.wkn);
        ImageView imageView2 = (ImageView) this.C.findViewById(R.id.wkk);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.notice.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildNoticeFragment.this.Ih(view);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.notice.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildNoticeFragment.this.Jh(view);
            }
        });
        Integer valueOf = Integer.valueOf(R.color.qui_common_icon_primary);
        new DrawableType(R.drawable.guild_back_left, valueOf).b(imageView);
        new DrawableType(R.drawable.guild_skin_cover_more_black, valueOf).b(imageView2);
        Dh(this.C);
    }

    private void initView() {
        initTitleBar();
        Ch();
        Fh();
        Eh();
    }

    public void Ph(com.tencent.mobileqq.guild.mainframe.i iVar) {
        this.H = iVar;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        com.tencent.mobileqq.guild.mainframe.i iVar = this.H;
        if (iVar != null) {
            iVar.guildCenterPanelInOrOut(2, true);
            return false;
        }
        if (getActivity() != null) {
            getActivity().finish();
            return false;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.tencent.mobileqq.guild.performance.report.q.c();
        this.C = layoutInflater.inflate(R.layout.eig, viewGroup, false);
        initView();
        initData();
        Oh();
        View view = this.C;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.J.s2(getGuildId());
        this.J.removeListener();
        this.K = null;
        if (QLog.isColorLevel()) {
            QLog.d("Guild.C2C.GuildNoticeFragment", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        w wVar;
        super.onResume();
        com.tencent.mobileqq.guild.mainframe.i iVar = this.H;
        if ((iVar == null || iVar.Z0().q()) && (wVar = this.J) != null) {
            wVar.u2(getGuildId());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class c implements x {
        c() {
        }

        private boolean c() {
            if (!NetworkUtil.isNetworkAvailable()) {
                com.tencent.mobileqq.guild.util.qqui.g.f(1, GuildNoticeFragment.this.getString(R.string.f1514417p));
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.guild.inbox.centerpanel.notice.x
        public void a(int i3) {
            if (!c() && GuildNoticeFragment.this.J != null) {
                GuildNoticeFragment.this.J.U1(i3);
            }
        }

        @Override // com.tencent.mobileqq.guild.inbox.centerpanel.notice.x
        public void b(int i3, boolean z16) {
        }
    }
}
