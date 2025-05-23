package com.tencent.mobileqq.guild.inbox.startpanel;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.data.w;
import com.tencent.mobileqq.guild.inbox.startpanel.GuildInboxC2CViewModel;
import com.tencent.mobileqq.guild.inbox.startpanel.d;
import com.tencent.mobileqq.guild.inbox.startpanel.dialog.InboxNodeSettingBaseDialog;
import com.tencent.mobileqq.guild.main.viewmodel.base.BaseChannelViewModel;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.centerpanel.GuildCenterPanelController;
import com.tencent.mobileqq.guild.mainframe.helper.c;
import com.tencent.mobileqq.guild.mainframe.helper.jump.GuildMainFrameJumpParam;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.DirectMessageNodeRepository;
import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import com.tencent.mobileqq.guild.message.unread.api.IGuildTotalUnreadService;
import com.tencent.mobileqq.guild.profile.me.GuildMeViewModel;
import com.tencent.mobileqq.guild.profile.me.GuildProfileBannerLayout;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes13.dex */
public class GuildMyProfileWithInboxFragment extends QPublicBaseFragment implements DragFrameLayout.b, com.tencent.mobileqq.guild.theme.d, QUIBadgeDragLayout.IDragViewProvider {
    private ViewGroup C;
    private DragFrameLayout D;
    private OverScrollRecyclerViewWithHeaderFooter E;
    private LinearLayoutManager F;
    private GuildInboxTitleHeaderView G;
    private GuildInboxTitleHeaderView H;
    private View I;
    private ImageView J;
    private com.tencent.mobileqq.guild.mainframe.i K;
    private com.tencent.mobileqq.guild.inbox.startpanel.b L;
    private GuildInboxC2CViewModel M;
    private GuildMeViewModel N;
    private GuildProfileBannerLayout P;
    private InboxNodeSettingBaseDialog Q;
    private com.tencent.mobileqq.guild.inbox.startpanel.dialog.k R;
    private long V;
    private boolean S = false;
    private String T = "";
    private String U = "";
    private final AfterSubmitRunnable W = new AfterSubmitRunnable();
    private final f X = new f();
    private final e Y = new e();
    private final RecyclerView.OnScrollListener Z = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class AfterSubmitRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private int f226234d = 0;

        /* renamed from: e, reason: collision with root package name */
        private int f226235e = 0;

        /* renamed from: f, reason: collision with root package name */
        private boolean f226236f = false;

        /* renamed from: h, reason: collision with root package name */
        private long f226237h = 0;

        AfterSubmitRunnable() {
        }

        private boolean h() {
            if (this.f226237h > 0 && SystemClock.uptimeMillis() - this.f226237h < 1000) {
                return true;
            }
            return false;
        }

        public void e() {
            this.f226236f = true;
            QLog.d("Guild.C2C.GuildMyProfileWithInboxFragment", 2, "AfterSubmitRunnable::markSelected() adapterSize=" + GuildMyProfileWithInboxFragment.this.L.getItemCount());
        }

        public void f() {
            int i3;
            this.f226235e = GuildMyProfileWithInboxFragment.this.E.computeVerticalScrollOffset();
            View childAt = GuildMyProfileWithInboxFragment.this.E.getChildAt(0);
            if (childAt != null) {
                i3 = GuildMyProfileWithInboxFragment.this.E.getChildAdapterPosition(childAt);
            } else {
                i3 = -1;
            }
            QLog.d("Guild.C2C.GuildMyProfileWithInboxFragment", 2, "AfterSubmitRunnable::markBeforeSubmit(), beforeOffset=" + this.f226235e + " child(0) pos: " + i3);
        }

        public void g() {
            this.f226237h = SystemClock.uptimeMillis();
            QLog.d("Guild.C2C.GuildMyProfileWithInboxFragment", 2, "AfterSubmitRunnable::markSelectLater() adapterSize=" + GuildMyProfileWithInboxFragment.this.L.getItemCount());
        }

        @Override // java.lang.Runnable
        public void run() {
            QLog.d("Guild.C2C.GuildMyProfileWithInboxFragment", 2, "AfterSubmitRunnable::run() selectedLater: " + this.f226237h + " selectedFlag: " + this.f226236f);
            int itemCount = GuildMyProfileWithInboxFragment.this.L.getItemCount();
            if (h()) {
                Iterator<p> it = GuildMyProfileWithInboxFragment.this.L.getCurrentList().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    p next = it.next();
                    if (next.E) {
                        GuildMyProfileWithInboxFragment.this.Vh(next.f226296e, "AfterSubmitRunnable");
                        break;
                    }
                }
            } else if (this.f226235e == 0 && !this.f226236f) {
                QLog.d("Guild.C2C.GuildMyProfileWithInboxFragment", 2, "AfterSubmitRunnable::run() scrollToPositionWithOffset(0)" + this.f226234d + " -> " + itemCount);
                if (GuildMyProfileWithInboxFragment.this.P != null) {
                    GuildMyProfileWithInboxFragment.this.P.U0();
                }
                GuildMyProfileWithInboxFragment.this.F.scrollToPositionWithOffset(0, 0);
            } else {
                QLog.d("Guild.C2C.GuildMyProfileWithInboxFragment", 2, "AfterSubmitRunnable::run() scroll nothing, beforeSubmitOffset: " + this.f226235e);
            }
            this.f226234d = itemCount;
            this.f226236f = false;
            this.f226237h = 0L;
            GuildMyProfileWithInboxFragment.this.Sh(true);
        }
    }

    /* loaded from: classes13.dex */
    class a extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name */
        private int f226238d = 0;

        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            if (GuildMyProfileWithInboxFragment.this.P != null) {
                GuildMyProfileWithInboxFragment.this.P.Y0(recyclerView, i3);
            }
            if (i3 != 0) {
                return;
            }
            VideoReport.traversePage(GuildMyProfileWithInboxFragment.this.E);
            int Wh = GuildMyProfileWithInboxFragment.this.Wh(false);
            if (Wh == -1) {
                return;
            }
            GuildMyProfileWithInboxFragment.this.M.t2(Wh);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
            if (GuildMyProfileWithInboxFragment.this.P != null) {
                GuildMyProfileWithInboxFragment.this.P.Z0(recyclerView);
            }
            int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
            int i17 = this.f226238d;
            if (computeVerticalScrollOffset > i17) {
                if (computeVerticalScrollOffset - i17 >= recyclerView.getMeasuredHeight()) {
                    this.f226238d = computeVerticalScrollOffset;
                    GuildMyProfileWithInboxFragment.this.Sh(false);
                    return;
                }
                return;
            }
            this.f226238d = computeVerticalScrollOffset;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class b implements kv1.a {
        b() {
        }

        @Override // kv1.a
        public void a() {
            if (com.tencent.mobileqq.guild.performance.report.f.c()) {
                com.tencent.mobileqq.guild.performance.report.f.b(GuildMyProfileWithInboxFragment.this.M.h2());
                GuildMyProfileWithInboxFragment.this.E.O();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class c implements Observer<GuildInboxC2CViewModel.c> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(GuildInboxC2CViewModel.c cVar) {
            GuildMyProfileWithInboxFragment.this.xi(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class d implements d.b {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.inbox.startpanel.d.b
        public void a(View view, p pVar) {
            if (pVar.f226295d == 0) {
                GuildMyProfileWithInboxFragment guildMyProfileWithInboxFragment = GuildMyProfileWithInboxFragment.this;
                guildMyProfileWithInboxFragment.Q = guildMyProfileWithInboxFragment.R.a(1);
            } else if (GuildMyProfileWithInboxFragment.this.fi(pVar.f226296e)) {
                GuildMyProfileWithInboxFragment guildMyProfileWithInboxFragment2 = GuildMyProfileWithInboxFragment.this;
                guildMyProfileWithInboxFragment2.Q = guildMyProfileWithInboxFragment2.R.a(2);
            } else {
                GuildMyProfileWithInboxFragment guildMyProfileWithInboxFragment3 = GuildMyProfileWithInboxFragment.this;
                guildMyProfileWithInboxFragment3.Q = guildMyProfileWithInboxFragment3.R.a(3);
            }
            GuildMyProfileWithInboxFragment.this.Q.Ph(pVar);
            com.tencent.mobileqq.guild.base.extension.d.a(GuildMyProfileWithInboxFragment.this.Q, GuildMyProfileWithInboxFragment.this.getParentFragmentManager(), "Guild.C2C.GuildMyProfileWithInboxFragment");
        }

        @Override // com.tencent.mobileqq.guild.inbox.startpanel.d.b
        public void b(View view, p pVar) {
            GuildMyProfileWithInboxFragment.this.M.v2(pVar.f226296e);
            int i3 = pVar.f226295d;
            if (i3 == 1) {
                GuildMyProfileWithInboxFragment.this.ai(pVar, null);
            } else if (i3 == 0) {
                GuildMyProfileWithInboxFragment guildMyProfileWithInboxFragment = GuildMyProfileWithInboxFragment.this;
                guildMyProfileWithInboxFragment.Xh(pVar, guildMyProfileWithInboxFragment.K.f0(), null);
            }
        }

        @Override // com.tencent.mobileqq.guild.inbox.startpanel.d.b
        public void c(View view, p pVar) {
            GuildMyProfileWithInboxFragment.this.Zh(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class e extends RecyclerView.AdapterDataObserver {
        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i3, int i16, int i17) {
            super.onItemRangeMoved(i3, i16, i17);
            if (i16 >= GuildMyProfileWithInboxFragment.this.L.getCurrentList().size()) {
                QLog.w("Guild.C2C.GuildMyProfileWithInboxFragment", 1, "onItemRangeMoved to=" + i16 + " list size=" + GuildMyProfileWithInboxFragment.this.L.getCurrentList().size());
                return;
            }
            p pVar = GuildMyProfileWithInboxFragment.this.L.getCurrentList().get(i16);
            if (!pVar.E) {
                return;
            }
            if (GuildMyProfileWithInboxFragment.this.S) {
                GuildMyProfileWithInboxFragment.this.Vh(pVar.f226296e, "onItemRangeMoved");
            } else {
                QLog.d("Guild.C2C.GuildMyProfileWithInboxFragment", 2, "EnsureVisibleAdapterDataChangeObserver::onItemRangeMoved() won't ensureVisible mRightPanelOpen = false");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class f extends rr1.a {
        f() {
        }

        private void d() {
            List<p> currentList = GuildMyProfileWithInboxFragment.this.L.getCurrentList();
            c.a j3 = com.tencent.mobileqq.guild.mainframe.helper.c.k(GuildMyProfileWithInboxFragment.this.K).j();
            for (p pVar : currentList) {
                if (pVar.E) {
                    if (!j3.equals(new c.a(pVar.f226295d, pVar.f226296e))) {
                        GuildMyProfileWithInboxFragment.this.M.v2(j3.f227422b);
                    }
                    if (!GuildMyProfileWithInboxFragment.this.Vh(j3.f227422b, "EnsureVisibleGestureListener")) {
                        GuildMyProfileWithInboxFragment.this.W.g();
                        return;
                    }
                    return;
                }
            }
        }

        private boolean e(rr1.i iVar) {
            if (iVar.f() == 3 && iVar.c() == 3) {
                return true;
            }
            return false;
        }

        private boolean f(rr1.i iVar) {
            if (iVar.g() == 1 || iVar.g() == 3) {
                return true;
            }
            return false;
        }

        private boolean g(rr1.i iVar) {
            if (iVar.f() == 3 && iVar.c() == 1) {
                return true;
            }
            return false;
        }

        @Override // rr1.a
        public void c(rr1.i iVar) {
            if (e(iVar)) {
                d();
                GuildMyProfileWithInboxFragment.this.S = false;
                if (f(iVar) && GuildMyProfileWithInboxFragment.this.isVisible()) {
                    GuildMyProfileWithInboxFragment.this.qi("pgin");
                    GuildMyProfileWithInboxFragment.this.ri("imp");
                    return;
                }
                return;
            }
            if (g(iVar)) {
                GuildMyProfileWithInboxFragment.this.S = true;
                if (GuildMyProfileWithInboxFragment.this.isVisible()) {
                    GuildMyProfileWithInboxFragment.this.qi("pgout");
                    GuildMyProfileWithInboxFragment.this.ri("imp_end");
                }
            }
        }
    }

    private void Qh() {
        GuildThemeManager.g(this);
        this.K.N().addGestureListener(this.X);
    }

    private void Rh(Map<String, Object> map) {
        GuildAppReportSourceInfo guildAppReportSourceInfo;
        Bundle arguments = getArguments();
        if (arguments == null || (guildAppReportSourceInfo = (GuildAppReportSourceInfo) arguments.getParcelable("GuildAppReportSourceInfo")) == null) {
            return;
        }
        arguments.putParcelable("GuildAppReportSourceInfo", null);
        Map<String, String> reportInfoMap = guildAppReportSourceInfo.getReportInfoMap();
        for (String str : reportInfoMap.keySet()) {
            map.put(str, reportInfoMap.get(str));
        }
        if (QLog.isColorLevel()) {
            QLog.d("Guild.C2C.GuildMyProfileWithInboxFragment", 2, "addReportInfoToParams sourceInfo ", guildAppReportSourceInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sh(boolean z16) {
        int Wh = Wh(true);
        int Wh2 = Wh(false);
        if (Wh >= 0 && Wh2 >= 0) {
            this.M.X1(Wh, Wh2, z16);
        }
    }

    private void Th() {
        DragFrameLayout dragFrameLayout = this.D;
        if (dragFrameLayout == null) {
            return;
        }
        dragFrameLayout.removeOnDragModeChangeListener(this);
        this.D.removeDragViewProviderByGroup(fs1.b.x(4, ""), this);
        DragFrameLayout dragFrameLayout2 = (DragFrameLayout) this.K.getActivity().findViewById(tp1.a.a());
        if (dragFrameLayout2 != null) {
            dragFrameLayout2.removeDragViewProviderByGroup(com.tencent.mobileqq.activity.home.impl.b.f183056s, this);
        }
    }

    private d.b Uh() {
        return new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Vh(String str, String str2) {
        List<p> currentList = this.L.getCurrentList();
        int i3 = 0;
        while (true) {
            if (i3 < currentList.size()) {
                if (TextUtils.equals(currentList.get(i3).f226296e, str)) {
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 < 0) {
            QLog.d("Guild.C2C.GuildMyProfileWithInboxFragment", 2, "ensureSelectedNodeVisible() not find select item! won't scroll, source: " + str2);
            return false;
        }
        int Wh = Wh(true);
        int Wh2 = Wh(false);
        if (i3 >= Wh && i3 <= Wh2) {
            QLog.d("Guild.C2C.GuildMyProfileWithInboxFragment", 2, "ensureSelectedNodeVisible() need not scroll, source: " + str2);
            return false;
        }
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.E.findViewHolderForAdapterPosition(i3);
        if (findViewHolderForAdapterPosition != null && findViewHolderForAdapterPosition.itemView.getTop() >= 0 && findViewHolderForAdapterPosition.getLayoutPosition() == i3) {
            QLog.d("Guild.C2C.GuildMyProfileWithInboxFragment", 2, "ensureSelectedNodeVisible(" + str + ") viewHolder top = " + findViewHolderForAdapterPosition.itemView.getTop() + " won't scroll viewHolder height = " + findViewHolderForAdapterPosition.itemView.getHeight() + " viewHolder isRecyclable = " + findViewHolderForAdapterPosition.isRecyclable() + " viewHolder layoutPosition = " + findViewHolderForAdapterPosition.getLayoutPosition() + " pos = " + i3 + " source: " + str2);
            return false;
        }
        if (findViewHolderForAdapterPosition == null && i3 == 0 && this.E.computeVerticalScrollOffset() == 0) {
            QLog.d("Guild.C2C.GuildMyProfileWithInboxFragment", 2, "ensureSelectedNodeVisible(" + str + ") scroll to " + i3 + "computeVerticalScrollOffset=0 ignore!(viewHolder=null) source: " + str2);
            return false;
        }
        QLog.d("Guild.C2C.GuildMyProfileWithInboxFragment", 2, "ensureSelectedNodeVisible(" + str + ") scroll to " + i3 + " source: " + str2);
        GuildProfileBannerLayout guildProfileBannerLayout = this.P;
        if (guildProfileBannerLayout != null && i3 == 0) {
            guildProfileBannerLayout.U0();
        }
        this.F.scrollToPositionWithOffset(i3, 0);
        this.W.e();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Wh(boolean z16) {
        RecyclerView.LayoutManager layoutManager = this.E.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return -1;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        if (z16) {
            return linearLayoutManager.findFirstVisibleItemPosition();
        }
        return linearLayoutManager.findLastVisibleItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xh(p pVar, @Nullable GuildAppReportSourceInfo guildAppReportSourceInfo, Bundle bundle) {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.C2C.GuildMyProfileWithInboxFragment", 1, "handleC2CNodeClick, uiData:", pVar, " reportSourceInfo:", guildAppReportSourceInfo);
        }
        com.tencent.mobileqq.guild.mainframe.helper.c.k(this.K).o(pVar.f226295d, pVar.f226296e);
        this.M.v2(com.tencent.mobileqq.guild.mainframe.helper.c.k(this.K).j().f227422b);
        Bundle bundle2 = new Bundle();
        bundle2.putByte(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG, (byte) 1);
        if (guildAppReportSourceInfo != null) {
            bundle2.putParcelable("GuildAppReportSourceInfo", guildAppReportSourceInfo);
        }
        if (pVar.G == 1) {
            bundle2.putInt(AppConstants.Key.GUILD_DIRECT_MESSAGE_TYPE, 2);
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        GuildMainFrameUtils.r(this.K.getActivity(), 6, new LaunchGuildChatPieParam().l(pVar.f226296e).b(pVar.f226297f).r(false).o(1).g(3).k(bundle2).q("").a());
    }

    private void Yh(int i3, @NonNull String str, Map<String, String> map) {
        this.M.b2(i3, str);
        if (i3 == 0) {
            DirectMessageNodeRepository.a0(getActivity(), str, map);
        } else {
            this.M.u2(str);
        }
        if (TextUtils.equals(str, com.tencent.mobileqq.guild.mainframe.helper.c.k(this.K).j().f227422b)) {
            this.K.Z0().r();
        }
        GuildProfileBannerLayout guildProfileBannerLayout = this.P;
        if (guildProfileBannerLayout != null) {
            guildProfileBannerLayout.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.inbox.startpanel.o
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMyProfileWithInboxFragment.this.hi();
                }
            }, 200L);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Guild.C2C.GuildMyProfileWithInboxFragment", 2, "onInboxNodeRemove inboxType:", Integer.valueOf(i3), " inboxKey:", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zh(p pVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("extra_channel_id", pVar.f226297f);
        hashMap.put("extra_target_tiny_id", pVar.f226298h);
        Yh(pVar.f226295d, pVar.f226296e, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(p pVar, Intent intent) {
        int i3;
        if (QLog.isColorLevel()) {
            QLog.d("Guild.C2C.GuildMyProfileWithInboxFragment", 2, "handleGuildNoticeClick, uiData:", pVar);
        }
        if (TextUtils.equals(pVar.f226296e, String.valueOf(6))) {
            i3 = 4;
        } else if (TextUtils.equals(pVar.f226296e, String.valueOf(7))) {
            i3 = 7;
        } else if (TextUtils.equals(pVar.f226296e, String.valueOf(5))) {
            i3 = 10;
        } else {
            QLog.e("Guild.C2C.GuildMyProfileWithInboxFragment", 1, "handleOfficialNodeClick, the uiData is error, uiData:", pVar);
            return;
        }
        com.tencent.mobileqq.guild.mainframe.helper.c.k(this.K).o(pVar.f226295d, pVar.f226296e);
        this.M.v2(com.tencent.mobileqq.guild.mainframe.helper.c.k(this.K).j().f227422b);
        int t16 = this.K.Z0().t();
        if (t16 != i3 || intent != null) {
            QLog.w("Guild.C2C.GuildMyProfileWithInboxFragment", 1, "onclick but left frame type=" + t16);
            this.K.Z0().F(i3, intent);
        }
        this.K.Z0().z(1);
    }

    private void ci() {
        DragFrameLayout e16 = this.K.e();
        this.D = e16;
        e16.addOnDragModeChangeListener(this, true);
        this.D.addDragViewProviderByGroup(fs1.b.x(4, ""), this, false);
        ((DragFrameLayout) this.K.getActivity().findViewById(tp1.a.a())).addDragViewProviderByGroup(com.tencent.mobileqq.activity.home.impl.b.f183056s, this, false);
    }

    private void di() {
        if (this.P == null) {
            this.P = new GuildProfileBannerLayout(requireContext());
        }
        this.P.V0(getViewLifecycleOwner(), this.K, this.C);
    }

    private void ei() {
        GuildMeViewModel guildMeViewModel = (GuildMeViewModel) com.tencent.mobileqq.mvvm.h.b(this.K.y(), BaseChannelViewModel.sViewModelFactory).get(GuildMeViewModel.class);
        this.N = guildMeViewModel;
        guildMeViewModel.init();
        this.P.setViewModel(this.N);
        this.P.setupLiveDataInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fi(String str) {
        int c16 = az.c(str, 0);
        if (c16 != 6 && c16 != 7 && c16 != 5) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hi() {
        this.P.Z0(this.E);
        this.P.Y0(this.E, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ii(Boolean bool) {
        if (bool.booleanValue()) {
            this.L.j0();
        }
    }

    private void initData() {
        com.tencent.mobileqq.guild.inbox.startpanel.b bVar = new com.tencent.mobileqq.guild.inbox.startpanel.b(this.K, Uh(), this.D);
        this.L = bVar;
        bVar.o0(this.E);
        this.L.registerAdapterDataObserver(this.Y);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.F = linearLayoutManager;
        this.E.setLayoutManager(linearLayoutManager);
        this.E.setAdapter(this.L);
        this.E.setDrawListener(new b());
        GuildInboxC2CViewModel guildInboxC2CViewModel = (GuildInboxC2CViewModel) com.tencent.mobileqq.mvvm.h.b(this.K.y(), GuildInboxC2CViewModel.S).get(GuildInboxC2CViewModel.class);
        this.M = guildInboxC2CViewModel;
        guildInboxC2CViewModel.init();
        this.M.v2(com.tencent.mobileqq.guild.mainframe.helper.c.k(this.K).j().f227422b);
        this.M.g2().observe(getViewLifecycleOwner(), new c());
        this.M.i2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.inbox.startpanel.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMyProfileWithInboxFragment.this.ii((Boolean) obj);
            }
        });
        ei();
        this.R = new com.tencent.mobileqq.guild.inbox.startpanel.dialog.k(new com.tencent.mobileqq.guild.inbox.startpanel.dialog.d() { // from class: com.tencent.mobileqq.guild.inbox.startpanel.l
            @Override // com.tencent.mobileqq.guild.inbox.startpanel.dialog.d
            public final void a(p pVar) {
                GuildMyProfileWithInboxFragment.this.Zh(pVar);
            }
        });
    }

    private void initView() {
        ci();
        di();
        GuildInboxTitleHeaderView guildInboxTitleHeaderView = new GuildInboxTitleHeaderView(requireContext());
        this.G = guildInboxTitleHeaderView;
        guildInboxTitleHeaderView.e(this.D);
        this.E = (OverScrollRecyclerViewWithHeaderFooter) this.C.findViewById(R.id.xlt);
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.eup, (ViewGroup) null);
        this.I = inflate;
        this.J = (ImageView) inflate.findViewById(R.id.xls);
        this.I.setVisibility(8);
        this.C.findViewById(R.id.wzz).setOnClickListener(this.P);
        GuildInboxTitleHeaderView guildInboxTitleHeaderView2 = (GuildInboxTitleHeaderView) this.C.findViewById(R.id.wja);
        this.H = guildInboxTitleHeaderView2;
        guildInboxTitleHeaderView2.e(this.D);
        this.E.addOnScrollListener(this.Z);
        this.E.H();
        this.E.setHasFixedSize(true);
        this.E.D(this.P);
        this.E.D(this.G);
        this.E.C(this.I);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ji(GuildInboxC2CViewModel.c cVar) {
        if (this.M.g2().getValue().f226223a.isEmpty()) {
            v.k("https://downv6.qq.com/innovate/guild/empty_view/guild_inbox_empty_view_new.png", this.J, new ColorDrawable(0));
            this.I.setVisibility(0);
            this.J.setVisibility(0);
            QLog.e("Guild.C2C.GuildMyProfileWithInboxFragment", 1, "getC2CMassageNodeLiveData onChanged, noticeNodeUIData isEmpty:", Boolean.valueOf(cVar.f226223a.isEmpty()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ki(GuildInboxC2CViewModel.c cVar) {
        QLog.i("Guild.C2C.GuildMyProfileWithInboxFragment", 2, "open center panel " + cVar.f226224b);
        com.tencent.mobileqq.guild.mainframe.helper.c.k(this.K).m(cVar.f226223a);
    }

    private void li() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        GuildAppReportSourceInfo guildAppReportSourceInfo = (GuildAppReportSourceInfo) arguments.getParcelable("GuildAppReportSourceInfo");
        if (guildAppReportSourceInfo == null) {
            guildAppReportSourceInfo = this.K.f0();
        }
        arguments.putParcelable("GuildAppReportSourceInfo", guildAppReportSourceInfo);
    }

    public static GuildMyProfileWithInboxFragment mi(Intent intent) {
        GuildMyProfileWithInboxFragment guildMyProfileWithInboxFragment = new GuildMyProfileWithInboxFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("data", intent);
        guildMyProfileWithInboxFragment.setArguments(bundle);
        return guildMyProfileWithInboxFragment;
    }

    private void pi() {
        GuildThemeManager.j(this);
        this.K.N().removeGestureListener(this.X);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qi(String str) {
        if (str == "pgin" && !((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isInGuildTab(getActivity())) {
            QLog.w("Guild.C2C.GuildMyProfileWithInboxFragment", 1, "reportDtPageEvent not inGuildTab");
            return;
        }
        if (TextUtils.equals(this.T, str)) {
            return;
        }
        this.T = str;
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        hashMap.put("pgid", "pg_sgrp_mine");
        if (TextUtils.equals(str, "pgin")) {
            this.V = System.currentTimeMillis();
            Rh(hashMap);
        } else if (this.V > 0) {
            hashMap.put(DTParamKey.REPORT_KEY_LVTM, Long.valueOf(System.currentTimeMillis() - this.V));
            this.V = 0L;
        }
        w.b(hashMap);
        VideoReport.reportEvent(str, this.C, hashMap);
        if (QLog.isColorLevel()) {
            QLog.d("Guild.C2C.GuildMyProfileWithInboxFragment", 2, "reportDtPageEvent ", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ri(String str) {
        int i3;
        if (TextUtils.equals(this.U, str)) {
            return;
        }
        this.U = str;
        UnreadInfo.a mine = ((IGuildTotalUnreadService) ch.R0(IGuildTotalUnreadService.class)).getTotalCount().getMine();
        HashMap hashMap = new HashMap();
        if (mine.getCount() <= 0) {
            i3 = 1;
        } else if (mine.getIsStrongUnread()) {
            i3 = 3;
        } else {
            i3 = 2;
        }
        hashMap.put("sgrp_private_aio_alert", Integer.valueOf(i3));
        VideoReport.reportEvent(str, this.E, hashMap);
    }

    private void si() {
        if (((IGuildTotalUnreadService) ch.R0(IGuildTotalUnreadService.class)).getTotalCount().getMine().getCount() > 0) {
            QLog.d("Guild.C2C.GuildMyProfileWithInboxFragment", 2, "scrollToTopIfHasUnreadNode() scroll to 0");
            GuildProfileBannerLayout guildProfileBannerLayout = this.P;
            if (guildProfileBannerLayout != null) {
                guildProfileBannerLayout.U0();
            }
            this.F.scrollToPositionWithOffset(0, 0);
        }
    }

    private void ti() {
        VideoReport.addToDetectionWhitelist(getQBaseActivity());
        VideoReport.setPageId(this.C, "pg_sgrp_mine");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        w.b(hashMap);
        VideoReport.setPageParams(this.C, new PageParams(hashMap));
        VideoReport.ignorePageInOutEvent(this.C, true);
        ch.Y0(this.E, "em_sgrp_private_letters", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xi(final GuildInboxC2CViewModel.c cVar) {
        if (cVar.f226223a.isEmpty()) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.inbox.startpanel.m
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMyProfileWithInboxFragment.this.ji(cVar);
                }
            }, 500L);
        } else {
            this.I.setVisibility(8);
            this.J.setVisibility(8);
        }
        boolean z16 = true;
        if (cVar.f226224b) {
            com.tencent.mobileqq.guild.performance.report.f.d(true);
        }
        this.W.f();
        this.L.p0(cVar.f226223a, this.W);
        com.tencent.mobileqq.guild.mainframe.util.j.d("inbox load finish", "KEY_RIGHT_PART_LOAD");
        com.tencent.mobileqq.guild.mainframe.util.j.d("inbox load finish after guild init. data size=" + cVar.f226223a.size(), "KEY_MAIN_FRAGMENT_CREATE");
        if (this.K.Z0().C()) {
            if (this.K.b() != 3) {
                z16 = false;
            }
            if (z16 && cVar.f226224b) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.inbox.startpanel.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildMyProfileWithInboxFragment.this.ki(cVar);
                    }
                });
                QLog.i("Guild.C2C.GuildMyProfileWithInboxFragment", 2, "open center panel mInit=" + cVar.f226224b + " delayed");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Guild.C2C.GuildMyProfileWithInboxFragment", 2, "aio is not on right do nothing. new datalist.size=" + cVar.f226223a.size());
        }
    }

    public void bi() {
        ViewGroup viewGroup = this.C;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
            qi("pgout");
            ri("imp_end");
            f12.f.f397616a.g("inbox_frame", false);
        }
    }

    public void gi(GuildCenterPanelController.b bVar) {
        GuildInboxC2CViewModel guildInboxC2CViewModel = this.M;
        if (guildInboxC2CViewModel == null) {
            QLog.e("Guild.C2C.GuildMyProfileWithInboxFragment", 1, "jump2TargetItem() error! mInboxViewModel is null!", new NullPointerException());
            return;
        }
        GuildInboxC2CViewModel.c value = guildInboxC2CViewModel.g2().getValue();
        if (value != null && !value.f226223a.isEmpty()) {
            QLog.i("Guild.C2C.GuildMyProfileWithInboxFragment", 1, "jump2TargetItem " + bVar);
            com.tencent.mobileqq.guild.mainframe.helper.c.k(this.K).p(value.f226223a, true, true);
            this.M.v2(com.tencent.mobileqq.guild.mainframe.helper.c.k(this.K).j().f227422b);
            Vh(bVar.f227300b, "jump2TargetItem");
            return;
        }
        this.K.Z0().r();
        QLog.w("Guild.C2C.GuildMyProfileWithInboxFragment", 1, "jump2TargetItem close. want=" + bVar.toString());
    }

    public void ni(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.C2C.GuildMyProfileWithInboxFragment", 2, "onAfterAccountChanged");
        }
        GuildInboxC2CViewModel guildInboxC2CViewModel = this.M;
        if (guildInboxC2CViewModel != null) {
            guildInboxC2CViewModel.init();
        }
        GuildMeViewModel guildMeViewModel = this.N;
        if (guildMeViewModel != null) {
            guildMeViewModel.onAfterAccountChanged(z16);
        }
    }

    public void oi() {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.C2C.GuildMyProfileWithInboxFragment", 2, "onBeforeAccountChanged");
        }
        GuildInboxC2CViewModel guildInboxC2CViewModel = this.M;
        if (guildInboxC2CViewModel != null) {
            guildInboxC2CViewModel.removeListener();
        }
        GuildMeViewModel guildMeViewModel = this.N;
        if (guildMeViewModel != null) {
            guildMeViewModel.onBeforeAccountChanged();
        }
    }

    @Override // com.tencent.mobileqq.quibadge.QUIBadgeDragLayout.OnDragModeChangedListener
    public void onChange(boolean z16, int i3, QUIBadgeDragLayout qUIBadgeDragLayout) {
        DragFrameLayout dragFrameLayout;
        if (qUIBadgeDragLayout.getDragView() != null && (dragFrameLayout = this.D) != null && dragFrameLayout.getMode() == -1 && qUIBadgeDragLayout.getDragView() != null && qUIBadgeDragLayout.getDragView().getId() == R.id.xm8) {
            QLog.i("Guild.C2C.GuildMyProfileWithInboxFragment", 4, "drag onchange tag " + qUIBadgeDragLayout.getDragView().getTag());
            if (qUIBadgeDragLayout.getDragView().getTag() instanceof p) {
                p pVar = (p) qUIBadgeDragLayout.getDragView().getTag();
                if (pVar != null && !TextUtils.isEmpty(pVar.f226296e)) {
                    this.M.b2(pVar.f226295d, pVar.f226296e);
                } else {
                    QLog.e("Guild.C2C.GuildMyProfileWithInboxFragment", 1, "clearUnreadMsg error, the data is null");
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.P.X0();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        com.tencent.mobileqq.guild.performance.report.f.e();
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.C = (ViewGroup) layoutInflater.inflate(R.layout.f0t, viewGroup, false);
        initView();
        initData();
        Qh();
        ti();
        ViewGroup viewGroup2 = this.C;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, viewGroup2);
        return viewGroup2;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.C2C.GuildMyProfileWithInboxFragment", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        Th();
        GuildInboxC2CViewModel guildInboxC2CViewModel = this.M;
        if (guildInboxC2CViewModel != null) {
            guildInboxC2CViewModel.removeListener();
        }
        this.Q = null;
        pi();
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.quibadge.QUIBadgeDragLayout.IDragViewProvider
    public List<View> onGetVisibleDragView() {
        if (!isVisible()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int itemCount = this.L.getItemCount();
        for (int i3 = 0; i3 < itemCount; i3++) {
            View childAt = this.E.getChildAt(i3);
            if (childAt != null) {
                View findViewById = childAt.findViewById(R.id.xm8);
                if (findViewById instanceof DragTextView) {
                    DragTextView dragTextView = (DragTextView) findViewById;
                    if (dragTextView.isShown() && dragTextView.c() != -1) {
                        arrayList.add(dragTextView);
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (isVisible()) {
            qi("pgout");
            ri("imp_end");
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (isVisible()) {
            li();
            qi("pgin");
            ri("imp");
            Sh(false);
        }
    }

    @Override // com.tencent.mobileqq.guild.theme.d
    @SuppressLint({"NotifyDataSetChanged"})
    public void onThemeChanged() {
        com.tencent.mobileqq.guild.inbox.startpanel.b bVar = this.L;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
        com.tencent.mobileqq.guild.theme.c.a(this.C);
        com.tencent.mobileqq.guild.theme.c.a(this.G);
        com.tencent.mobileqq.guild.theme.c.a(this.P);
        this.P.onThemeChanged();
    }

    public void ui(com.tencent.mobileqq.guild.mainframe.i iVar) {
        this.K = iVar;
    }

    public boolean vi(GuildMainFrameJumpParam.GuildCenterPanelJumpExtra guildCenterPanelJumpExtra, @Nullable GuildAppReportSourceInfo guildAppReportSourceInfo) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("show  guildId=");
        if (guildCenterPanelJumpExtra == null) {
            str = "NULL";
        } else {
            str = guildCenterPanelJumpExtra.f227443d.f227447e;
        }
        sb5.append(str);
        QLog.d("Guild.C2C.GuildMyProfileWithInboxFragment", 1, sb5.toString());
        if (isVisible()) {
            qi("pgin");
            ri("imp");
        }
        if (guildCenterPanelJumpExtra != null) {
            boolean wi5 = wi(guildCenterPanelJumpExtra, guildAppReportSourceInfo);
            if (this.C.getVisibility() != 0) {
                this.C.setVisibility(0);
            }
            si();
            Vh(guildCenterPanelJumpExtra.f227443d.f227447e, "show");
            return wi5;
        }
        if (this.C.getVisibility() != 0) {
            this.C.setVisibility(0);
        }
        GuildInboxC2CViewModel guildInboxC2CViewModel = this.M;
        if (guildInboxC2CViewModel == null) {
            QLog.d("Guild.C2C.GuildMyProfileWithInboxFragment", 1, "show view model not init maybe is the first time");
            return false;
        }
        GuildInboxC2CViewModel.c value = guildInboxC2CViewModel.g2().getValue();
        if (value != null) {
            if (value.f226224b) {
                QLog.d("Guild.C2C.GuildMyProfileWithInboxFragment", 1, "show updateSelectItem");
                com.tencent.mobileqq.guild.mainframe.helper.c.k(this.K).p(value.f226223a, true, true);
            }
            si();
            f12.f.f397616a.g("inbox_frame", true);
            return true;
        }
        QLog.d("Guild.C2C.GuildMyProfileWithInboxFragment", 1, "data not init data");
        return false;
    }

    public boolean wi(GuildMainFrameJumpParam.GuildCenterPanelJumpExtra guildCenterPanelJumpExtra, @Nullable GuildAppReportSourceInfo guildAppReportSourceInfo) {
        GuildInboxC2CViewModel guildInboxC2CViewModel = this.M;
        if (guildInboxC2CViewModel == null) {
            QLog.e("Guild.C2C.GuildMyProfileWithInboxFragment", 1, "showTargetCenterPanel() error! mInboxViewModel is null!", new NullPointerException());
            return false;
        }
        GuildMainFrameJumpParam.GuildInboxJumpExtra guildInboxJumpExtra = guildCenterPanelJumpExtra.f227443d;
        p f26 = guildInboxC2CViewModel.f2(guildInboxJumpExtra.f227446d, guildInboxJumpExtra.f227447e);
        if (f26 == null) {
            QLog.w("Guild.C2C.GuildMyProfileWithInboxFragment", 1, "showTargetCenterPanel() error! didn't find item " + guildCenterPanelJumpExtra);
            return false;
        }
        Intent intent = null;
        Bundle bundle = null;
        intent = null;
        if (guildCenterPanelJumpExtra.f227443d.f227446d == 0) {
            LaunchGuildChatPieParam launchGuildChatPieParam = guildCenterPanelJumpExtra.f227444e;
            if (launchGuildChatPieParam != null) {
                bundle = launchGuildChatPieParam.G;
            }
            Xh(f26, guildAppReportSourceInfo, bundle);
            return true;
        }
        LaunchGuildChatPieParam launchGuildChatPieParam2 = guildCenterPanelJumpExtra.f227444e;
        if (launchGuildChatPieParam2 != null && launchGuildChatPieParam2.G != null) {
            intent = new Intent();
            intent.putExtra("param_ext_bundle", guildCenterPanelJumpExtra.f227444e.G);
        }
        ai(f26, intent);
        return true;
    }
}
