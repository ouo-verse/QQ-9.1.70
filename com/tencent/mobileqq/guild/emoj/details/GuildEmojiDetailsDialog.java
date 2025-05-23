package com.tencent.mobileqq.guild.emoj.details;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.data.GuildEmojiDetailsData;
import com.tencent.mobileqq.guild.emoj.details.a;
import com.tencent.mobileqq.guild.emoj.details.b;
import com.tencent.mobileqq.guild.util.bp;
import com.tencent.mobileqq.guild.util.bv;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.n;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildEmojiDetailsDialog extends BottomSheetDialogFragment {
    private static GuildEmojiDetailsData S;
    private AppInterface C;
    private View D;
    private com.google.android.material.bottomsheet.a I;
    private RecyclerView E = null;
    private RecyclerView F = null;
    private com.tencent.mobileqq.guild.emoj.details.b G = null;
    private com.tencent.mobileqq.guild.emoj.details.a H = null;
    private int J = 0;
    private String K = "";
    BottomSheetBehavior L = null;
    private boolean M = true;
    private b.InterfaceC7733b N = new a();
    private a.d P = new b();
    private pi1.a Q = new c();
    private com.tencent.mobileqq.guild.emoj.d R = new d();

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class a implements b.InterfaceC7733b {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.emoj.details.b.InterfaceC7733b
        public void a(int i3, String str, int i16) {
            if (GuildEmojiDetailsDialog.this.H != null) {
                GuildEmojiDetailsDialog.this.J = i3;
                GuildEmojiDetailsDialog.this.H.t0(new ArrayList(), true);
                GuildEmojiDetailsDialog.this.M = true;
                GuildEmojiDetailsDialog.this.H.q0(true);
                GuildEmojiDetailsDialog.this.H.p0(false);
                GuildEmojiDetailsDialog.this.K = "";
                GuildEmojiDetailsDialog guildEmojiDetailsDialog = GuildEmojiDetailsDialog.this;
                guildEmojiDetailsDialog.Mh(str, i16, guildEmojiDetailsDialog.K);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class b implements a.d {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.emoj.details.a.d
        public void a(int i3, String str, View view) {
            if (!TextUtils.isEmpty(str)) {
                GuildEmojiDetailsDialog.this.Kh(str, view);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class c implements pi1.a {
        c() {
        }

        @Override // pi1.a
        public void Z() {
            GuildEmojiDetailsDialog.this.dismissDialog();
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class d extends com.tencent.mobileqq.guild.emoj.d {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.emoj.d
        protected void a(boolean z16, String str, String str2, long j3, String str3, int i3, String str4, String str5, boolean z17, List<com.tencent.mobileqq.guild.emoj.a> list) {
            int size;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onGetLikesUserListResult isSuccess: ");
            sb5.append(z16);
            sb5.append(" ,guildId : ");
            sb5.append(str);
            sb5.append(" ,channelId : ");
            sb5.append(str2);
            sb5.append(" ,shmsgseq : ");
            sb5.append(j3);
            sb5.append(" ,emojId : ");
            sb5.append(str3);
            sb5.append(" ,requestCookie : ");
            sb5.append(str4);
            sb5.append(" ,cookie : ");
            sb5.append(str5);
            sb5.append(" ,isLastPage : ");
            sb5.append(z17);
            sb5.append(" ,likesDatas.size : ");
            if (list == null) {
                size = 0;
            } else {
                size = list.size();
            }
            sb5.append(size);
            QLog.d("GuildEmojiDetailsDialog", 4, sb5.toString());
            if (!z16 || GuildEmojiDetailsDialog.this.H == null || !GuildEmojiDetailsDialog.this.Jh(str3, i3) || !GuildEmojiDetailsDialog.this.K.equals(str4)) {
                return;
            }
            GuildEmojiDetailsDialog.this.H.t0(list, GuildEmojiDetailsDialog.this.M);
            if (!GuildEmojiDetailsDialog.this.Eh(str3, i3)) {
                GuildEmojiDetailsDialog.this.K = str5;
                if (z17) {
                    GuildEmojiDetailsDialog.this.H.q0(false);
                    GuildEmojiDetailsDialog.this.G.s0(str3, i3, GuildEmojiDetailsDialog.this.H.getItemCount() - 1);
                } else {
                    GuildEmojiDetailsDialog.this.H.p0(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class e extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name */
        private int f217888d = 0;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f217889e;

        e(LinearLayoutManager linearLayoutManager) {
            this.f217889e = linearLayoutManager;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0 && this.f217888d + 1 == GuildEmojiDetailsDialog.this.H.getItemCount() && GuildEmojiDetailsDialog.this.H.m0()) {
                if (GuildEmojiDetailsDialog.this.G != null && GuildEmojiDetailsDialog.this.G.k0().size() > GuildEmojiDetailsDialog.this.J) {
                    b.c cVar = GuildEmojiDetailsDialog.this.G.k0().get(GuildEmojiDetailsDialog.this.J);
                    GuildEmojiDetailsDialog.this.M = false;
                    GuildEmojiDetailsDialog guildEmojiDetailsDialog = GuildEmojiDetailsDialog.this;
                    guildEmojiDetailsDialog.Mh(cVar.f217902a, cVar.f217903b, guildEmojiDetailsDialog.K);
                }
                GuildEmojiDetailsDialog.this.H.p0(false);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
            this.f217888d = this.f217889e.findLastVisibleItemPosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class f implements DialogInterface.OnDismissListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            GuildEmojiDetailsDialog.this.Fh();
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class g extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name */
        private int f217892d;

        /* renamed from: e, reason: collision with root package name */
        private int f217893e;

        public g(int i3, int i16) {
            this.f217892d = i3;
            this.f217893e = i16;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            if (recyclerView.getChildPosition(view) != 0) {
                rect.left = this.f217892d;
            } else {
                rect.left = this.f217893e;
            }
            if (recyclerView.getAdapter().getItemCount() - 1 == recyclerView.getChildAdapterPosition(view)) {
                rect.right = this.f217893e;
            }
        }
    }

    private int Dh() {
        int a16 = bv.a(QBaseActivity.sTopActivity);
        int a17 = (a16 - bp.a(getActivity())) - ViewUtils.dip2px(416.6f);
        if (a17 < 0) {
            a17 = 0;
        }
        if (a16 > 2778) {
            return (ViewUtils.dip2px(416.6f) + a16) - 2778;
        }
        return a17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Eh(String str, int i3) {
        if (this.H.getItemCount() > 1) {
            return false;
        }
        this.G.n0(str, i3);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fh() {
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            activity.getSupportFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
        }
    }

    private void Gh() {
        this.H = new com.tencent.mobileqq.guild.emoj.details.a(this.C, getActivity(), S);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.F.setLayoutManager(linearLayoutManager);
        this.F.setAdapter(this.H);
        this.H.s0(this.Q);
        this.H.r0(this.P);
        this.F.addOnScrollListener(new e(linearLayoutManager));
    }

    private void Hh() {
        com.tencent.mobileqq.guild.emoj.details.b bVar;
        if (S != null && (bVar = this.G) != null && bVar.getItemCount() > S.e()) {
            int e16 = S.e();
            this.E.scrollToPosition(e16);
            this.G.m0(e16);
        }
    }

    private void Ih() {
        this.G = new com.tencent.mobileqq.guild.emoj.details.b();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.E.setLayoutManager(linearLayoutManager);
        this.E.setAdapter(this.G);
        this.E.addItemDecoration(new g(ViewUtils.dip2px(7.0f), ViewUtils.dip2px(16.0f)));
        this.G.q0(this.N);
        this.G.p0(this.Q);
        this.E.setNestedScrollingEnabled(false);
        GuildEmojiDetailsData guildEmojiDetailsData = S;
        if (guildEmojiDetailsData != null) {
            com.tencent.mobileqq.guild.emoj.details.b bVar = this.G;
            bVar.r0(bVar.l0(guildEmojiDetailsData.b()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Jh(String str, int i3) {
        int g16;
        com.tencent.mobileqq.guild.emoj.details.b bVar = this.G;
        if (bVar == null) {
            return false;
        }
        List<b.c> k06 = bVar.k0();
        if (k06.size() <= this.J || (g16 = n.g(str, i3)) == -1 || !k06.get(this.J).f217902a.equals(String.valueOf(g16)) || k06.get(this.J).f217903b != i3) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kh(String str, View view) {
        com.tencent.mobileqq.guild.emoj.details.b bVar = this.G;
        if (bVar == null) {
            return;
        }
        List<b.c> k06 = bVar.k0();
        int size = k06.size();
        int i3 = this.J;
        if (size <= i3) {
            return;
        }
        int i16 = k06.get(i3).f217903b;
        String str2 = k06.get(this.J).f217902a;
        HashMap hashMap = new HashMap();
        hashMap.put("emoji_tab", Integer.valueOf(i16));
        hashMap.put("emoji_id", Integer.valueOf(n.f(str2, i16)));
        hashMap.put("emoji_location", Integer.valueOf(this.J + 1));
        hashMap.put("emoji_name", n.e(i16, str2));
        hashMap.put("emoji_clicked_user_id", str);
        ch.Y0(view, "em_aio_click_other_user", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_clck", view, hashMap);
    }

    public static void Lh(Activity activity, GuildEmojiDetailsData guildEmojiDetailsData) {
        if (guildEmojiDetailsData != null && guildEmojiDetailsData.b() != null && guildEmojiDetailsData.b().size() != 0) {
            S = guildEmojiDetailsData;
            FragmentManager supportFragmentManager = ((QBaseActivity) activity).getSupportFragmentManager();
            supportFragmentManager.beginTransaction().add(new GuildEmojiDetailsDialog(), "GuildEmojiDetailsDialog").commitAllowingStateLoss();
            return;
        }
        QLog.d("GuildEmojiDetailsDialog", 1, "openEmojiDetails fail: detailsData == null or detailsData.getEmojiList() error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mh(String str, int i3, String str2) {
        if (this.C != null && S != null && !TextUtils.isEmpty(str)) {
            n.f(str, i3);
        } else {
            QLog.d("GuildEmojiDetailsDialog", 4, "sendMsg2GetLikes Err : mApp = null or mEmojiDetailsData = null or emojiId is null");
        }
    }

    private void Nh() {
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) getDialog();
        this.I = aVar;
        aVar.setOnDismissListener(new f());
        Ph();
    }

    private void Oh() {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.D, "pg_sgrp_aio_emoji_comment_info");
        HashMap hashMap = new HashMap();
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildBasePageParams(S.a(), hashMap);
        VideoReport.setPageParams(this.D, new PageParams(hashMap));
    }

    private void Ph() {
        this.L = this.I.getBehavior();
        int Dh = Dh();
        this.L.setSkipCollapsed(true);
        this.D.getLayoutParams().height = Dh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissDialog() {
        com.google.android.material.bottomsheet.a aVar = this.I;
        if (aVar != null) {
            aVar.dismiss();
            this.I = null;
        }
    }

    private void initView() {
        this.E = (RecyclerView) this.D.findViewById(R.id.f918656b);
        this.F = (RecyclerView) this.D.findViewById(R.id.yi8);
        Ih();
        Gh();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
        this.C = appInterface;
        if (appInterface != null) {
            appInterface.addObserver(this.R);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.D = layoutInflater.inflate(R.layout.emb, viewGroup, false);
        QLog.d("GuildEmojiDetailsDialog", 4, "onCreateView");
        initView();
        Oh();
        View view = this.D;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        AppInterface appInterface = this.C;
        if (appInterface != null) {
            appInterface.removeObserver(this.R);
        }
        super.onDestroy();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ((ViewGroup) this.D.getParent()).setBackgroundColor(0);
        Nh();
        Hh();
    }
}
