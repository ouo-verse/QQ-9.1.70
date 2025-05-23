package com.tencent.mobileqq.guild.inbox.startpanel;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.guild.inbox.startpanel.d;
import com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes13.dex */
public class b extends ListAdapter<p, d> {
    private static final DiffUtil.ItemCallback<p> G = new a();
    private final com.tencent.mobileqq.guild.mainframe.i C;
    private d.b D;
    private DragFrameLayout E;
    private OverScrollRecyclerViewWithHeaderFooter F;

    /* renamed from: m, reason: collision with root package name */
    private List<p> f226247m;

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class a extends DiffUtil.ItemCallback<p> {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NonNull p pVar, @NonNull p pVar2) {
            boolean equals = Objects.equals(pVar, pVar2);
            if (QLog.isDevelopLevel() && !equals) {
                QLog.d("Guild.C2C.GuildInboxC2CAdapter", 2, "isNotSame!! old: ", pVar, " new: ", pVar2);
            }
            return equals;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NonNull p pVar, @NonNull p pVar2) {
            if (pVar != pVar2 && !TextUtils.equals(pVar.f226296e, pVar2.f226296e)) {
                return false;
            }
            return true;
        }
    }

    public b(@NonNull com.tencent.mobileqq.guild.mainframe.i iVar, @NonNull d.b bVar, @NonNull DragFrameLayout dragFrameLayout) {
        super(G);
        this.f226247m = new ArrayList();
        this.C = iVar;
        this.E = dragFrameLayout;
        this.D = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k0(LinearLayoutManager linearLayoutManager, int i3) {
        linearLayoutManager.scrollToPosition(i3);
        if (QLog.isColorLevel()) {
            QLog.i("Guild.C2C.GuildInboxC2CAdapter", 2, "scrollToTargetPos pos:" + i3);
        }
    }

    private void n0(final int i3) {
        if (i3 >= 0 && i3 < getNUM_BACKGOURND_ICON()) {
            final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.F.getLayoutManager();
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            if (i3 > findFirstVisibleItemPosition && i3 < findLastVisibleItemPosition) {
                return;
            }
            this.F.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.inbox.startpanel.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.k0(LinearLayoutManager.this, i3);
                }
            }, 200L);
            return;
        }
        QLog.e("Guild.C2C.GuildInboxC2CAdapter", 4, "scrollToTargetPos err pos: " + i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return getItem(i3).f226295d;
    }

    public void j0() {
        String str = com.tencent.mobileqq.guild.mainframe.helper.c.k(this.C).j().f227422b;
        int i3 = 0;
        while (true) {
            if (i3 >= this.f226247m.size()) {
                break;
            }
            if (TextUtils.equals(this.f226247m.get(i3).f226296e, str)) {
                n0(i3);
                break;
            }
            i3++;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Guild.C2C.GuildInboxC2CAdapter", 2, "jumpToCurSelInboxItem but no targetPos");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull d dVar, int i3) {
        p item = getItem(i3);
        QLog.d("Guild.C2C.GuildInboxC2CAdapter", 4, "onBindViewHolder pos: ", Integer.valueOf(i3), " data: ", item);
        long uptimeMillis = SystemClock.uptimeMillis();
        dVar.t(item);
        QLog.d("Guild.C2C.GuildInboxC2CAdapter", 4, "onBindViewHolder pos: ", Integer.valueOf(i3), " cost: ", Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis), "ms");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public d onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.euo, viewGroup, false), this.D, this.E);
    }

    public void o0(OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter) {
        this.F = overScrollRecyclerViewWithHeaderFooter;
    }

    public void p0(List<p> list, @Nullable Runnable runnable) {
        this.f226247m = list;
        submitList(list, runnable);
        VideoReport.traversePage(this.F);
    }
}
