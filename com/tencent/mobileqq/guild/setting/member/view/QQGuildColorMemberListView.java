package com.tencent.mobileqq.guild.setting.member.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.nt.perf.api.IPerfApi;
import com.tencent.mobileqq.guild.setting.member.view.j;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class QQGuildColorMemberListView extends LinearLayout {
    private String C;
    private com.tencent.mobileqq.guild.avatar.a D;
    private final AbsListView.OnScrollListener E;

    /* renamed from: d, reason: collision with root package name */
    private final Context f234703d;

    /* renamed from: e, reason: collision with root package name */
    private DispatchDrawSwipListView f234704e;

    /* renamed from: f, reason: collision with root package name */
    private j f234705f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f234706h;

    /* renamed from: i, reason: collision with root package name */
    private j.b f234707i;

    /* renamed from: m, reason: collision with root package name */
    private String f234708m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements kv1.a {
        a() {
        }

        @Override // kv1.a
        public void a() {
            if (QQGuildColorMemberListView.this.f234705f != null && QQGuildColorMemberListView.this.f234705f.getCount() > 0) {
                QQGuildColorMemberListView qQGuildColorMemberListView = QQGuildColorMemberListView.this;
                qQGuildColorMemberListView.q(qQGuildColorMemberListView.f234705f.getCount());
                QQGuildColorMemberListView.this.f234704e.b0();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class b implements AbsListView.OnScrollListener {
        b() {
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            if (QQGuildColorMemberListView.this.D != null) {
                com.tencent.mobileqq.guild.avatar.a aVar = QQGuildColorMemberListView.this.D;
                String str = QQGuildColorMemberListView.this.f234708m;
                QQGuildColorMemberListView qQGuildColorMemberListView = QQGuildColorMemberListView.this;
                aVar.g(str, qQGuildColorMemberListView.j(i3 + i16, qQGuildColorMemberListView.f234705f.getCount()));
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            if (i3 == 1) {
                QQGuildColorMemberListView.this.f234707i.a();
            }
            if (QQGuildColorMemberListView.this.f234704e.getCount() - QQGuildColorMemberListView.this.f234704e.getLastVisiblePosition() < 20) {
                QQGuildColorMemberListView.this.f234707i.c();
            }
            if (i3 == 0) {
                ((IPerfApi) QRoute.api(IPerfApi.class)).stopMonitorDropFrame("qqguild_member_list");
                VideoReport.traversePage(QQGuildColorMemberListView.this.f234704e);
            } else {
                ((IPerfApi) QRoute.api(IPerfApi.class)).startMonitorDropFrame("qqguild_member_list");
            }
        }
    }

    public QQGuildColorMemberListView(Context context) {
        super(context);
        this.f234708m = "0";
        this.C = "0";
        this.E = new b();
        this.f234703d = context;
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> j(int i3, int i16) {
        ArrayList arrayList = new ArrayList();
        int i17 = i16 - 1;
        int min = Math.min(i3 + 6, i17);
        for (int min2 = Math.min(i3 + 1, i17); min2 < min; min2++) {
            arrayList.add(this.f234705f.getItem(min2));
        }
        return j.c.b(arrayList);
    }

    private void m() {
        DispatchDrawSwipListView dispatchDrawSwipListView = (DispatchDrawSwipListView) LayoutInflater.from(this.f234703d).inflate(R.layout.ejs, this).findViewById(R.id.u0x);
        this.f234704e = dispatchDrawSwipListView;
        dispatchDrawSwipListView.setDrawListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        VideoReport.traversePage(this.f234704e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i3) {
        com.tencent.mobileqq.guild.performance.report.o.b(i3);
    }

    public void i(View view) {
        if (this.f234704e.findHeaderViewPosition(view) == -1) {
            this.f234704e.addHeaderView(view);
        }
    }

    public List<IGProUserInfo> k() {
        return this.f234705f.g();
    }

    public void l(String str, String str2, boolean z16, boolean z17, j.b bVar) {
        this.f234708m = str;
        this.C = str2;
        j jVar = new j(z17, z16, bVar);
        this.f234705f = jVar;
        this.f234704e.setAdapter((ListAdapter) jVar);
        this.f234704e.setRightIconMenuListener(this.f234705f);
        this.f234704e.setOnScrollListener(this.E);
        this.f234706h = z17;
        this.f234704e.setDragEnable(z17);
        this.f234707i = bVar;
    }

    public void o() {
        com.tencent.mobileqq.guild.avatar.a aVar = this.D;
        if (aVar != null) {
            aVar.c();
        }
        j jVar = this.f234705f;
        if (jVar != null) {
            jVar.k();
        }
    }

    public void p(View view) {
        if (this.f234704e.findHeaderViewPosition(view) != -1) {
            this.f234704e.removeHeaderView(view);
        }
    }

    public void setDragEnable(boolean z16) {
        if (!this.f234706h) {
            return;
        }
        this.f234704e.setDragEnable(z16);
    }

    public void setEditMode(boolean z16) {
        if (!this.f234706h) {
            return;
        }
        this.f234704e.setDragEnable(!z16);
        this.f234705f.e(z16);
    }

    public void setPreLoadHelper(com.tencent.mobileqq.guild.avatar.a aVar) {
        this.D = aVar;
    }

    public void setUIDataList(List<j.c> list) {
        this.f234705f.l(this.f234708m, this.C, list);
        if (list.size() < 20) {
            this.f234707i.c();
        }
        postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.member.view.k
            @Override // java.lang.Runnable
            public final void run() {
                QQGuildColorMemberListView.this.n();
            }
        }, 200L);
    }

    public QQGuildColorMemberListView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f234708m = "0";
        this.C = "0";
        this.E = new b();
        this.f234703d = context;
        m();
    }

    public QQGuildColorMemberListView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f234708m = "0";
        this.C = "0";
        this.E = new b();
        this.f234703d = context;
        m();
    }
}
